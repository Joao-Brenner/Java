/* O projeto só funciona se inicializado pela Home*/
package visao;

import controle.ControleDep;
import modelo.ManterDep;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;


public class AltDep extends javax.swing.JFrame {

    private int id;
    private String nome;
    private int andar;

    /**
     * Creates new form AltDep
     */
    public AltDep(int id, String nome, int andar) {
        initComponents();
        iniciando();
        this.id = id;
        this.nome = nome;
        this.andar = andar;
        jTnovonome.setText(nome);
        jTnovoandar.setText(String.valueOf(andar));
    }

    private AltDep() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    private void iniciando() {
        jTnovoandar.setDocument(new PlainDocument() {
            @Override
            public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
                if (str == null) {
                    return;
                }
                String textoAtual = getText(0, getLength());
                String textoFuturo = textoAtual.substring(0, offset) + str + textoAtual.substring(offset);
                if (textoFuturo.matches("-?\\d{0,3}")) {
                    super.insertString(offset, str, attr);
                }
            }
        });
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField4 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTnovonome = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTnovoandar = new javax.swing.JTextField();
        jBatualizardep2 = new javax.swing.JButton();
        jBlimpar2 = new javax.swing.JButton();
        jBhome3 = new javax.swing.JButton();
        jBvoltar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField4.setEditable(false);
        jTextField4.setBackground(new java.awt.Color(0, 0, 0));
        jTextField4.setFont(new java.awt.Font("Segoe UI Black", 3, 24)); // NOI18N
        jTextField4.setForeground(new java.awt.Color(255, 255, 255));
        jTextField4.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField4.setText("        JDEVS.UPDATEDepartamento() ");
        jTextField4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField4ActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setText("Nome:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Andar:");

        jBatualizardep2.setBackground(new java.awt.Color(153, 153, 153));
        jBatualizardep2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBatualizardep2.setText("Atualizar");
        jBatualizardep2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBatualizardep2ActionPerformed(evt);
            }
        });

        jBlimpar2.setBackground(new java.awt.Color(153, 153, 153));
        jBlimpar2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBlimpar2.setText("Limpar");
        jBlimpar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBlimpar2ActionPerformed(evt);
            }
        });

        jBhome3.setBackground(new java.awt.Color(153, 153, 153));
        jBhome3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBhome3.setText("Home");
        jBhome3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBhome3ActionPerformed(evt);
            }
        });

        jBvoltar1.setBackground(new java.awt.Color(153, 153, 153));
        jBvoltar1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBvoltar1.setText("Voltar");
        jBvoltar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBvoltar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTextField4)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTnovoandar, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jTnovonome, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jBvoltar1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBhome3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jBatualizardep2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBlimpar2)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTnovonome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTnovoandar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBatualizardep2)
                    .addComponent(jBlimpar2)
                    .addComponent(jBhome3)
                    .addComponent(jBvoltar1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField4ActionPerformed

    private void jBatualizardep2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBatualizardep2ActionPerformed
        // TODO add your handling code here:
        ArrayList<String> erros2 = new ArrayList<>();

        try {
            String novoNome = jTnovonome.getText();
            String novoAndarStr = jTnovoandar.getText();
            boolean temErro2 = false;

            if (novoNome.isEmpty()) {
                erros2.add("O campo Nome não pode estar vazio!");
                jTnovonome.requestFocus();
                temErro2 = true;
            } else if (!Pattern.matches("^[\\p{L} ]+$", novoNome)) {
                erros2.add("O campo Nome deve conter apenas letras!");
                jTnovonome.requestFocus();
                temErro2 = true;
            }

            int novoAndar = 0;
            if (novoAndarStr.isEmpty()) {
                erros2.add("O campo Andar não pode estar vazio!");
                if (!temErro2) {
                    jTnovoandar.requestFocus();
                    temErro2 = true;
                }
            } else {
                try {
                    novoAndar = Integer.parseInt(novoAndarStr);
                } catch (NumberFormatException e) {
                    erros2.add("O campo Andar deve ser um número inteiro!");
                    if (!temErro2) {
                        jTnovoandar.requestFocus();
                        temErro2 = true;
                    }
                }
            }

            if (!erros2.isEmpty()) {
                StringBuilder mensagem = new StringBuilder("Erros encontrados:\n");
                for (String erro : erros2) {
                    mensagem.append(erro).append("\n");
                }
                JOptionPane.showMessageDialog(this, mensagem.toString(), "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                return;
            }

            ControleDep cd = new ControleDep();
            cd.setId(this.id);
            cd.setNome(novoNome);
            cd.setAndar(novoAndar);

            try {
                ManterDep md = new ManterDep();
                boolean atualizacao = md.atualizarDep(cd);

                if (atualizacao) {
                    new ListarDep("acessoPermitido").setVisible(true);
                    this.dispose();
                }
            } catch (Exception ex) {
                Logger.getLogger(AltDep.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception e) {
            Logger.getLogger(AltDep.class.getName()).log(Level.SEVERE, null, e);

        }
    }//GEN-LAST:event_jBatualizardep2ActionPerformed

    private void jBlimpar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBlimpar2ActionPerformed
        // TODO add your handling code here:
        jTnovonome.setText(nome);
        jTnovoandar.setText(String.valueOf(andar));
        jTnovonome.requestFocus();
    }//GEN-LAST:event_jBlimpar2ActionPerformed

    private void jBhome3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBhome3ActionPerformed
        // TODO add your handling code here:
        Home home = new Home();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBhome3ActionPerformed

    private void jBvoltar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBvoltar1ActionPerformed
        // TODO add your handling code here:
        ListarDep ld = new ListarDep("acessoPermitido");
        ld.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBvoltar1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AltDep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AltDep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AltDep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AltDep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AltDep().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBatualizardep2;
    private javax.swing.JButton jBhome3;
    private javax.swing.JButton jBlimpar2;
    private javax.swing.JButton jBvoltar1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTnovoandar;
    private javax.swing.JTextField jTnovonome;
    // End of variables declaration//GEN-END:variables
}
