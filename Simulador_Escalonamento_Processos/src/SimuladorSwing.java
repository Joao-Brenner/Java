
import javax.swing.*; // Importa a biblioteca Swing para construção da interface gráfica
import javax.swing.table.*; // Importa classes para uso de tabelas
import javax.swing.border.EmptyBorder; // Permite criar bordas vazias para componentes
import java.awt.*; // Importa classes para elementos gráficos como layout e cores
import java.util.*; // Importa utilitários como ArrayList, Queue, etc.
import java.util.List;
import java.util.Queue;

// Classe principal que estende JFrame para criar uma janela
public class SimuladorSwing extends JFrame {

    // Componentes da interface gráfica
    private JTextArea logEscalonamento = new JTextArea(10, 50); // Área de texto para log de escalonamento
    private JTextArea logDeadlock = new JTextArea(15, 50); // Área de texto para log de deadlock
    private JTable tabelaGerenciador; // Tabela para mostrar processos no gerenciador de tarefas
    private JTable tabelaProcessos; // Tabela para mostrar os processos escalonados
    private DefaultTableModel modeloGerenciador; // Modelo de dados da tabela do gerenciador
    private DefaultTableModel tabelaModelo; // Modelo de dados da tabela de escalonamento
    private JScrollPane scrollTabela; // Scroll para a tabela de processos
    private JScrollPane scrollGerenciador; // Scroll para a tabela do gerenciador
    private JSplitPane painelTabelaELog; // Painel dividido entre tabela e log de escalonamento
    private JPanel painelDeadlock; // Painel da aba de deadlock
    private java.util.List<Processo> processos = new ArrayList<>(); // Lista de processos para escalonamento
    private java.util.List<Processo> processosDeadlock = new ArrayList<>(); // Lista de processos com deadlock

    // Construtor da classe
    public SimuladorSwing() {
        super("Simulador de Escalonamento e Deadlock");
        JTabbedPane abas = new JTabbedPane(); // Abas da interface
        abas.addTab("Escalonamento", criarPainelEscalonamento());
        abas.addTab("Deadlock", criarPainelDeadlock());
        add(abas);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack(); // Ajusta tamanho dos componentes
        setLocationRelativeTo(null); // Centraliza janela
        setVisible(true); // Torna a janela visível
    }

    // Cria o painel da aba de escalonamento
    private JPanel criarPainelEscalonamento() {
        JPanel painel = new JPanel(new BorderLayout());

        // Campos de entrada
        JPanel entrada = new JPanel(new GridLayout(2, 4, 10, 10));
        JTextField nome = new JTextField();
        JTextField tempo = new JTextField();
        JTextField prioridade = new JTextField();
        JComboBox<String> algoritmo = new JComboBox<>(new String[]{"FIFO", "SJF", "Round Robin", "Prioridade"});

        // Adiciona labels e campos ao painel de entrada
        entrada.add(new JLabel("Nome"));
        entrada.add(nome);
        entrada.add(new JLabel("Tempo"));
        entrada.add(tempo);
        entrada.add(new JLabel("Prioridade"));
        entrada.add(prioridade);
        entrada.add(new JLabel("Algoritmo"));
        entrada.add(algoritmo);

        // Botões de ação
        JPanel botoes = new JPanel();
        JButton adicionar = new JButton("Adicionar Processo");
        JButton executar = new JButton("Executar");
        JButton limpar = new JButton("Limpar");
        botoes.add(adicionar);
        botoes.add(executar);
        botoes.add(limpar);

        // Configura a tabela de processos
        String[] colunas = {"Nome", "Tempo", "Prioridade", "Algoritmo"};
        tabelaModelo = new DefaultTableModel(colunas, 0);
        tabelaProcessos = new JTable(tabelaModelo);
        scrollTabela = new JScrollPane(tabelaProcessos);
        scrollTabela.setPreferredSize(new Dimension(500, 150));
        scrollTabela.setBorder(new EmptyBorder(10, 10, 10, 10));
        scrollTabela.setVisible(false);

        // Estilização da tabela
        tabelaProcessos.setBackground(Color.BLACK);
        tabelaProcessos.setForeground(Color.WHITE);
        tabelaProcessos.setGridColor(Color.WHITE);
        tabelaProcessos.setSelectionBackground(Color.DARK_GRAY);
        tabelaProcessos.setSelectionForeground(Color.WHITE);
        tabelaProcessos.setRowHeight(30);
        tabelaProcessos.getTableHeader().setBackground(Color.BLACK);
        tabelaProcessos.getTableHeader().setForeground(Color.WHITE);
        tabelaProcessos.getTableHeader().setFont(new Font("SansSerif", Font.BOLD, 15));

        // Painel dividido com tabela e log
        painelTabelaELog = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
        painelTabelaELog.setTopComponent(scrollTabela);
        painelTabelaELog.setBottomComponent(new JScrollPane(logEscalonamento));
        painelTabelaELog.setResizeWeight(1.0);
        painelTabelaELog.setDividerSize(10);
        painelTabelaELog.setBorder(null);

        JPanel centro = new JPanel(new BorderLayout());
        centro.add(botoes, BorderLayout.NORTH);
        centro.add(painelTabelaELog, BorderLayout.CENTER);

        painel.add(entrada, BorderLayout.NORTH);
        painel.add(centro, BorderLayout.CENTER);

        // Ação do botão limpar
        limpar.addActionListener(e -> {
            nome.setText("");
            tempo.setText("");
            prioridade.setText("");
            processos.clear();
            logEscalonamento.setText("");
            scrollTabela.setVisible(false);
        });

        // Ação do botão adicionar processo
        adicionar.addActionListener(e -> {
            try {
                processos.add(new Processo(nome.getText(),
                        Integer.parseInt(tempo.getText()),
                        Integer.parseInt(prioridade.getText())));
                logEscalonamento.append("Adicionado: " + nome.getText() + "\n");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Erro ao adicionar processo.");
            }
        });

        // Ação do botão executar
        executar.addActionListener(e -> {
            preencherTabelaComProcessos(algoritmo.getSelectedItem().toString());
            scrollTabela.setVisible(true);
            SwingUtilities.getWindowAncestor(painel).pack();
            new Thread(() -> executarEscalonamento(algoritmo.getSelectedItem().toString())).start();
        });

        return painel;
    }

    // Preenche a tabela com os processos cadastrados
    private void preencherTabelaComProcessos(String algoritmoSelecionado) {
        tabelaModelo.setRowCount(0);
        for (Processo p : processos) {
            tabelaModelo.addRow(new Object[]{
                p.nome,
                p.tempoExecucao,
                p.prioridade,
                algoritmoSelecionado
            });
        }
    }

    private void executarEscalonamento(String algoritmo) {
        logEscalonamento.append("Executando escalonamento com algoritmo: " + algoritmo + "\n");

        List<Processo> filaExecucao = new ArrayList<>(processos); // Cópia para não modificar a original

        switch (algoritmo) {
            case "SJF":
                filaExecucao.sort(Comparator.comparingInt(p -> p.tempoExecucao));
                break;
            case "Prioridade":
                filaExecucao.sort(Comparator.comparingInt(p -> p.prioridade));
                break;
            case "Round Robin":
                executarRoundRobin(processos, logEscalonamento);
                return; // Evita execução duplicada

            case "FIFO":
            default:
                // Não altera a ordem
                break;
        }

        for (Processo p : filaExecucao) {
            logEscalonamento.append("Executando: " + p.nome + " (Tempo: " + p.tempoExecucao + ")\n");
            try {
                Thread.sleep(p.tempoExecucao * 100);
            } catch (InterruptedException ignored) {
            }
            logEscalonamento.append("Finalizado: " + p.nome + "\n");
        }
    }

    // Cria o painel da aba de deadlock
    private JPanel criarPainelDeadlock() {
        painelDeadlock = new JPanel(new BorderLayout());

        JButton simular = new JButton("Simular Deadlock");
        JButton gerenciador = new JButton("Gerenciador de Tarefas");

        JPanel botoes = new JPanel();
        botoes.add(simular);
        botoes.add(gerenciador);

        painelDeadlock.add(new JScrollPane(logDeadlock), BorderLayout.CENTER);
        painelDeadlock.add(botoes, BorderLayout.SOUTH);

        simular.addActionListener(e -> simularDeadlock());
        gerenciador.addActionListener(e -> abrirGerenciador());

        return painelDeadlock;
    }

    // Simula um cenário de deadlock fictício
    private void simularDeadlock() {
    logDeadlock.setText("");
    logDeadlock.append("Simulando deadlock em componentes do sistema...\n\n");

    processosDeadlock.clear();

    // Adiciona processos reais e populares
    processosDeadlock.add(new Processo("Navegador", 4, 2));              // Ex: Chrome
    processosDeadlock.add(new Processo("Genshin Impact", 3, 1));         // Jogo pesado
    processosDeadlock.add(new Processo("Adobe Acrobat", 5, 3));          // Leitor de PDF
    processosDeadlock.add(new Processo("Spotify", 4, 2));                // Música
    processosDeadlock.add(new Processo("Netflix", 3, 2));                // Streaming
    processosDeadlock.add(new Processo("Visual Studio Code", 6, 3));     // IDE
    processosDeadlock.add(new Processo("Google Drive", 2, 2));           // Backup na nuvem
    processosDeadlock.add(new Processo("Steam", 4, 1));                  // Plataforma de jogos
    processosDeadlock.add(new Processo("Photoshop", 7, 3));              // Editor de imagem
    processosDeadlock.add(new Processo("Discord", 3, 2));                // Comunicação
    processosDeadlock.add(new Processo("Zoom", 3, 2));                   // Vídeo conferência
    processosDeadlock.add(new Processo("Slack", 2, 2));                  // Comunicação corporativa
    processosDeadlock.add(new Processo("Dropbox", 2, 2));                // Backup na nuvem
    processosDeadlock.add(new Processo("Minecraft", 5, 1));              // Jogo
    processosDeadlock.add(new Processo("After Effects", 6, 3));          // Edição vídeo
    processosDeadlock.add(new Processo("Chrome Extension", 1, 1));       // Plugin navegador
    processosDeadlock.add(new Processo("Microsoft Word", 3, 2));         // Editor de texto
    processosDeadlock.add(new Processo("OneDrive", 2, 2));               // Backup na nuvem
    processosDeadlock.add(new Processo("Slack Bot", 1, 1));              // Automação Slack
    processosDeadlock.add(new Processo("File Explorer", 2, 2));          // Gerenciador de arquivos

    // Simulação de recursos que podem ser disputados
    // Recursos comuns: Placa de Vídeo, Impressora, Memória, Disco Rígido, Rede, Som, USB, Webcam
    logDeadlock.append("Genshin Impact bloqueou o recurso 'Placa de Vídeo' e aguarda 'Impressora'.\n");
    logDeadlock.append("Adobe Acrobat bloqueou o recurso 'Impressora' e aguarda 'Memória'.\n");
    logDeadlock.append("Navegador bloqueou o recurso 'Memória' e aguarda 'Placa de Vídeo'.\n\n");

    logDeadlock.append("Spotify bloqueou o recurso 'Som' e aguarda 'Rede'.\n");
    logDeadlock.append("Netflix bloqueou o recurso 'Rede' e aguarda 'Disco Rígido'.\n");
    logDeadlock.append("Visual Studio Code bloqueou o recurso 'Disco Rígido' e aguarda 'USB'.\n");
    logDeadlock.append("Google Drive bloqueou o recurso 'USB' e aguarda 'Som'.\n\n");

    logDeadlock.append("Steam bloqueou o recurso 'Memória' e aguarda 'Placa de Vídeo'.\n");
    logDeadlock.append("Photoshop bloqueou o recurso 'Placa de Vídeo' e aguarda 'Webcam'.\n");
    logDeadlock.append("Discord bloqueou o recurso 'Webcam' e aguarda 'Impressora'.\n\n");

    logDeadlock.append("Zoom bloqueou o recurso 'Impressora' e aguarda 'Rede'.\n");
    logDeadlock.append("Slack bloqueou o recurso 'Rede' e aguarda 'Disco Rígido'.\n");
    logDeadlock.append("Dropbox bloqueou o recurso 'Disco Rígido' e aguarda 'Som'.\n\n");

    logDeadlock.append("Minecraft bloqueou o recurso 'Som' e aguarda 'Memória'.\n");
    logDeadlock.append("After Effects bloqueou o recurso 'Memória' e aguarda 'USB'.\n");
    logDeadlock.append("Chrome Extension bloqueou o recurso 'USB' e aguarda 'Placa de Vídeo'.\n\n");

    logDeadlock.append("Microsoft Word bloqueou o recurso 'Placa de Vídeo' e aguarda 'Webcam'.\n");
    logDeadlock.append("OneDrive bloqueou o recurso 'Webcam' e aguarda 'Impressora'.\n");
    logDeadlock.append("Slack Bot bloqueou o recurso 'Impressora' e aguarda 'Rede'.\n");
    logDeadlock.append("File Explorer bloqueou o recurso 'Rede' e aguarda 'Disco Rígido'.\n\n");

    logDeadlock.append("⚠ Deadlock detectado! Há um ciclo no grafo de espera envolvendo múltiplos processos e recursos.\n\n");
    logDeadlock.append("Sugestões para resolver o deadlock:\n");
    logDeadlock.append("- Abrir o Gerenciador de Tarefas e encerrar um dos processos.\n");
    logDeadlock.append("- Desligar o computador da tomada (não recomendado).\n");
}

    // Exibe o gerenciador com botão para encerrar processos
    private void abrirGerenciador() {
        painelDeadlock.removeAll();

        modeloGerenciador = new DefaultTableModel(new String[]{"Nome", "Tempo", "Prioridade", "Algoritmo", "Ação"}, 0);
        tabelaGerenciador = new JTable(modeloGerenciador) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 4;
            }
        };

        for (Processo p : processosDeadlock) {
            modeloGerenciador.addRow(new Object[]{p.nome, p.tempoExecucao, p.prioridade, "Round Robin", "X"});
        }

        tabelaGerenciador.getColumn("Ação").setCellRenderer(new ButtonRenderer());
        tabelaGerenciador.getColumn("Ação").setCellEditor(new ButtonEditor(new JCheckBox()));

        scrollGerenciador = new JScrollPane(tabelaGerenciador);
        painelDeadlock.add(scrollGerenciador, BorderLayout.CENTER);
        painelDeadlock.revalidate();
        painelDeadlock.repaint();
    }

    // Restaura o log e simula execução em Round Robin após matar processo
    private void restaurarLogComSimulacaoRoundRobin() {
        painelDeadlock.removeAll();
        painelDeadlock.add(new JScrollPane(logDeadlock), BorderLayout.CENTER);
        painelDeadlock.revalidate();
        painelDeadlock.repaint();

        logDeadlock.setText("");
        logDeadlock.append("Processo encerrado pelo usuário. Recursos liberados.\n");
        logDeadlock.append("Sistema voltou ao estado estável.\n\n");
        logDeadlock.append("Executando Round Robin com processos restantes...\n");
        executarRoundRobin(processosDeadlock, logDeadlock);
    }

    // Modifique o método para receber o JTextArea do log como parâmetro
    private void executarRoundRobin(java.util.List<Processo> lista, JTextArea log) {
        Queue<Processo> fila = new LinkedList<>();
        for (Processo p : lista) {
            fila.add(new Processo(p.nome, p.tempoExecucao, p.prioridade));
        }

        int quantum = 2;
        while (!fila.isEmpty()) {
            Processo p = fila.poll();
            int exec = Math.min(p.tempoExecucao, quantum);
            log.append("Executando: " + p.nome + " por " + exec + " unidades de tempo.\n");
            try {
                Thread.sleep(exec * 100);
            } catch (InterruptedException ignored) {
            }
            p.tempoExecucao -= exec;
            if (p.tempoExecucao > 0) {
                fila.add(p);
            } else {
                log.append("Finalizado: " + p.nome + "\n");
            }
        }
    }

    // Método principal para iniciar o programa
    public static void main(String[] args) {
        SwingUtilities.invokeLater(SimuladorSwing::new);
    }

    // Classe para renderizar botão na tabela
    class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {
            setOpaque(true);
            setForeground(Color.WHITE);
            setBackground(Color.RED);
            setText("X");
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            return this;
        }
    }

    // Classe para editar botão e lidar com ação de matar processo
    class ButtonEditor extends DefaultCellEditor {

        private JButton button;
        private int selectedRow;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton("X");
            button.setForeground(Color.WHITE);
            button.setBackground(Color.RED);
            button.addActionListener(e -> {
                if (selectedRow >= 0 && selectedRow < processosDeadlock.size()) {
                    processosDeadlock.remove(selectedRow);
                    modeloGerenciador.removeRow(selectedRow);
                    restaurarLogComSimulacaoRoundRobin();
                }
            });
        }

        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            selectedRow = row;
            return button;
        }
    }
}
