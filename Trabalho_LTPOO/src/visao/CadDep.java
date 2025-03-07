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

public class CadDep extends javax.swing.JFrame {

    /**
     * Creates new form CadDep
     */
    public CadDep(String parametro) {
        if (!"acessoPermitido".equals(parametro)) {
            JOptionPane.showMessageDialog(null, "Acesso negado. Navegue através da Home.", "Erro de Acesso", JOptionPane.ERROR_MESSAGE);
            System.exit(0); 
        }
        initComponents();
        iniciando();
    }

    private CadDep() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    private void iniciando() {
        jTandar.setDocument(new PlainDocument() {
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTnome = new javax.swing.JTextField();
        jTandar = new javax.swing.JTextField();
        jBcadastrarD = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        jBhome1 = new javax.swing.JButton();
        jBlimpar1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Nome:");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Andar:");

        jBcadastrarD.setBackground(new java.awt.Color(153, 153, 153));
        jBcadastrarD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBcadastrarD.setText("Cadastrar");
        jBcadastrarD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBcadastrarDActionPerformed(evt);
            }
        });

        jTextField2.setEditable(false);
        jTextField2.setBackground(new java.awt.Color(0, 0, 0));
        jTextField2.setFont(new java.awt.Font("Segoe UI Black", 3, 24)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField2.setText("        JDEVS.setDepartamento() ");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jBhome1.setBackground(new java.awt.Color(153, 153, 153));
        jBhome1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBhome1.setText("Home");
        jBhome1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBhome1ActionPerformed(evt);
            }
        });

        jBlimpar1.setBackground(new java.awt.Color(153, 153, 153));
        jBlimpar1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jBlimpar1.setText("Limpar");
        jBlimpar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBlimpar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 110, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jTandar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jBcadastrarD)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jTnome, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(3, 3, 3)
                                .addComponent(jBlimpar1)
                                .addContainerGap())))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jBhome1)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTnome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTandar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 94, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBcadastrarD)
                    .addComponent(jBhome1)
                    .addComponent(jBlimpar1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jBcadastrarDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcadastrarDActionPerformed
        // TODO add your handling code here:         

        ArrayList<String> erros = new ArrayList<>();

        try {
            boolean temErro = false;
            if (jTnome.getText().isEmpty()) {
                erros.add("O campo Nome não pode estar vazio!");
                jTnome.requestFocus();
                temErro = true;
            } else if (!Pattern.matches("^[\\p{L} ]+$", jTnome.getText())) {
                erros.add("O campo Nome deve conter apenas letras!");
                jTnome.requestFocus();
                temErro = true;
            }
            if (jTandar.getText().isEmpty()) {
                erros.add("O campo Andar não pode estar vazio!");
                if (!temErro) {
                    jTandar.requestFocus();
                    temErro = true;
                }
            } else {
                try {
                    Integer.parseInt(jTandar.getText());
                } catch (NumberFormatException e) {
                    erros.add("O campo Andar deve ser um número inteiro!");
                    if (!temErro) {
                        jTandar.requestFocus();
                        temErro = true;
                    }
                }
            }
            if (!erros.isEmpty()) {
                StringBuilder mensagem = new StringBuilder("Erros encontrados:\n");
                for (String erro : erros) {
                    mensagem.append(erro).append("\n");
                }
                JOptionPane.showMessageDialog(this, mensagem.toString(), "Erro de Validação", JOptionPane.ERROR_MESSAGE);
                return;
            }
            ControleDep cd = new ControleDep();
            cd.setNome(jTnome.getText());
            cd.setAndar(Integer.valueOf(jTandar.getText()));
            ManterDep depdao = new ManterDep();
            depdao.inserirD(cd);
            jTnome.setText("");
            jTandar.setText("");
            jTnome.requestFocus();
        } catch (Exception ex) {
            Logger.getLogger(CadDep.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_jBcadastrarDActionPerformed

    private void jBlimpar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBlimpar1ActionPerformed
        // TODO add your handling code here:
        jTnome.setText("");
        jTandar.setText("");
        jTnome.requestFocus();
    }//GEN-LAST:event_jBlimpar1ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jBhome1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBhome1ActionPerformed
        // TODO add your handling code here:
        Home home = new Home();
        home.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jBhome1ActionPerformed

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
            java.util.logging.Logger.getLogger(CadDep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadDep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadDep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadDep.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadDep().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBcadastrarD;
    private javax.swing.JButton jBhome1;
    private javax.swing.JButton jBlimpar1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField jTandar;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTnome;
    // End of variables declaration//GEN-END:variables
}
