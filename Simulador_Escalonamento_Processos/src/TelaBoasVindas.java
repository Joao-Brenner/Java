import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class TelaBoasVindas extends JFrame {

    public TelaBoasVindas() {
        // Configurações básicas da janela JFrame
        setTitle("Boas-Vindas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 500);
        setLocationRelativeTo(null);  // Centraliza a janela na tela

        // Painel principal com layout BorderLayout e margem ao redor
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setBackground(Color.WHITE);
        painelPrincipal.setLayout(new BorderLayout(10, 10));
        painelPrincipal.setBorder(new EmptyBorder(20, 40, 20, 40));  // Espaçamento interno
        add(painelPrincipal);

        // Painel do topo para título e subtítulo, usando BoxLayout vertical
        JPanel painelTopo = new JPanel();
        painelTopo.setBackground(Color.WHITE);
        painelTopo.setLayout(new BoxLayout(painelTopo, BoxLayout.Y_AXIS));
        painelPrincipal.add(painelTopo, BorderLayout.NORTH);

        // Título principal
        JLabel titulo = new JLabel("BEM-VINDO");
        titulo.setFont(new Font("Arial", Font.BOLD, 36));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);  // Centraliza horizontalmente
        painelTopo.add(titulo);

        // Subtítulo
        JLabel subtitulo = new JLabel("Este é o nosso Simulador de um Processador e de um Deadlock");
        subtitulo.setFont(new Font("Arial", Font.PLAIN, 18));
        subtitulo.setAlignmentX(Component.CENTER_ALIGNMENT);
        painelTopo.add(Box.createRigidArea(new Dimension(0, 10)));  // Espaço vertical
        painelTopo.add(subtitulo);

        painelTopo.add(Box.createRigidArea(new Dimension(0, 30)));  // Espaço extra entre seções

        // Título para membros do grupo
        JLabel membros = new JLabel("Membros do Grupo");
        membros.setFont(new Font("Arial", Font.PLAIN, 20));
        membros.setAlignmentX(Component.CENTER_ALIGNMENT);
        painelTopo.add(membros);

        // Definição das colunas da tabela
        String[] colunas = {"Nome"};

        // Dados dos membros do grupo
        Object[][] dados = {
            {"André Rodrigues"},
            {"Daniel Rocha"},
            {"João Brenner"},
            {"Raissa da Anunciação"},
            {"Sarah Marques"}
        };

        // Ordena os dados pelo nome (coluna 0) em ordem alfabética
        java.util.Arrays.sort(dados, (a, b) -> a[0].toString().compareToIgnoreCase(b[0].toString()));

        // Cria a tabela com modelo não editável
        JTable tabela = new JTable(new DefaultTableModel(dados, colunas)) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;  // Impede edição das células
            }
        };

        // Configurações visuais da tabela
        tabela.setFont(new Font("Arial", Font.PLAIN, 14));
        tabela.setRowHeight(28);  // Altura fixa para cada linha
        tabela.setBackground(Color.WHITE);
        tabela.setForeground(Color.BLACK);
        tabela.setGridColor(Color.BLACK);
        tabela.setShowGrid(true);

        // Configurações do cabeçalho da tabela
        JTableHeader header = tabela.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 14));
        header.setBackground(Color.BLACK);
        header.setForeground(Color.WHITE);
        header.setReorderingAllowed(false);  // Impede reordenar colunas pelo usuário
        header.setResizingAllowed(false);    // Impede redimensionar colunas

        // Força altura fixa no cabeçalho (24 px é adequado para fonte 14)
        Dimension headerDim = new Dimension(header.getPreferredSize().width, 24);
        header.setPreferredSize(headerDim);
        header.setMinimumSize(headerDim);
        header.setMaximumSize(headerDim);

        // Centraliza o texto das colunas da tabela
        DefaultTableCellRenderer centralizado = new DefaultTableCellRenderer();
        centralizado.setHorizontalAlignment(JLabel.CENTER);
        tabela.getColumnModel().getColumn(0).setCellRenderer(centralizado);

        // Coloca a tabela dentro de um JScrollPane para permitir rolagem se necessário
        JScrollPane scrollPane = new JScrollPane(tabela);
        scrollPane.setBorder(new LineBorder(Color.BLACK, 2));
        scrollPane.setBackground(Color.WHITE);

        // Calcula o número de linhas visíveis (máximo 5)
        int linhasVisiveis = Math.min(tabela.getRowCount(), 5);
        int alturaLinhas = tabela.getRowHeight() * linhasVisiveis;  // Altura total das linhas visíveis
        int alturaCabecalho = header.getPreferredSize().height;    // Altura do cabeçalho

        // Define o tamanho preferido do scrollPane para caber o número certo de linhas + cabeçalho
        scrollPane.setPreferredSize(new Dimension(700, alturaLinhas + alturaCabecalho));
        scrollPane.getViewport().setPreferredSize(new Dimension(700, alturaLinhas));

        // Painel que vai conter a tabela + botão iniciar
        JPanel painelTabela = new JPanel();
        painelTabela.setLayout(new BoxLayout(painelTabela, BoxLayout.Y_AXIS));
        painelTabela.setBackground(Color.WHITE);
        painelTabela.setAlignmentX(Component.CENTER_ALIGNMENT);
        painelTabela.add(scrollPane);  // adiciona tabela com scroll

        // Espaço entre tabela e botão
        painelTabela.add(Box.createRigidArea(new Dimension(0, 20)));

        // Botão para iniciar o simulador
        JButton iniciarSimulador = new JButton("Iniciar Simulador");
        iniciarSimulador.setFont(new Font("Arial", Font.BOLD, 16));
        iniciarSimulador.setBackground(new Color(0, 123, 255));
        iniciarSimulador.setForeground(Color.WHITE);
        iniciarSimulador.setFocusPainted(false);
        iniciarSimulador.setMaximumSize(new Dimension(200, 40));
        iniciarSimulador.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Ação do botão: fecha esta tela e abre a tela do simulador
        iniciarSimulador.addActionListener(e -> {
            dispose();
            new SimuladorSwing().setVisible(true);
        });

        painelTabela.add(iniciarSimulador);

        // Adiciona o painelTabela no centro do painel principal
        painelPrincipal.add(painelTabela, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        // Garante que a interface gráfica será criada na thread correta
        SwingUtilities.invokeLater(() -> {
            TelaBoasVindas tela = new TelaBoasVindas();
            tela.setVisible(true);  // Exibe a janela
        });
    }
}
