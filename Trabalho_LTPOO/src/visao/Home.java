/* O projeto só funciona se inicializado pela Home*/
package visao;

public class Home extends javax.swing.JFrame {

    /**
     * Creates new form Home
     */
    public Home() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        ListadeDepartamentos = new javax.swing.JButton();
        CadastrarFuncionario = new javax.swing.JButton();
        ListadeFuncionarios = new javax.swing.JButton();
        CadastrarDepartamento = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField1.setEditable(false);
        jTextField1.setBackground(new java.awt.Color(0, 0, 0));
        jTextField1.setFont(new java.awt.Font("Segoe UI Black", 3, 36)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("        JDEVS.getHome() ");
        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        ListadeDepartamentos.setBackground(new java.awt.Color(153, 153, 153));
        ListadeDepartamentos.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ListadeDepartamentos.setText("Lista de Departamentos");
        ListadeDepartamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListadeDepartamentosActionPerformed(evt);
            }
        });

        CadastrarFuncionario.setBackground(new java.awt.Color(153, 153, 153));
        CadastrarFuncionario.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CadastrarFuncionario.setText("Cadastrar Funcionário");
        CadastrarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarFuncionarioActionPerformed(evt);
            }
        });

        ListadeFuncionarios.setBackground(new java.awt.Color(153, 153, 153));
        ListadeFuncionarios.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ListadeFuncionarios.setText("Lista de Funcionários");
        ListadeFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListadeFuncionariosActionPerformed(evt);
            }
        });

        CadastrarDepartamento.setBackground(new java.awt.Color(153, 153, 153));
        CadastrarDepartamento.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        CadastrarDepartamento.setText("Cadastrar Departamento");
        CadastrarDepartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarDepartamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 491, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ListadeFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CadastrarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ListadeDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CadastrarDepartamento))
                .addGap(121, 121, 121))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(CadastrarDepartamento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(ListadeDepartamentos)
                .addGap(29, 29, 29)
                .addComponent(CadastrarFuncionario)
                .addGap(32, 32, 32)
                .addComponent(ListadeFuncionarios)
                .addGap(28, 28, 28))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void CadastrarDepartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarDepartamentoActionPerformed
        // TODO add your handling code here:      
        CadDep cadDep = new CadDep("acessoPermitido");
        cadDep.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_CadastrarDepartamentoActionPerformed

    private void ListadeDepartamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListadeDepartamentosActionPerformed
        // TODO add your handling code here:
        ListarDep listarDep = new ListarDep("acessoPermitido");
        listarDep.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ListadeDepartamentosActionPerformed

    private void CadastrarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarFuncionarioActionPerformed
        // TODO add your handling code here:
        CadFunc cadFunc = new CadFunc("acessoPermitido");
        cadFunc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_CadastrarFuncionarioActionPerformed

    private void ListadeFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListadeFuncionariosActionPerformed
        // TODO add your handling code here:
        ListarFunc listarFunc = new ListarFunc("acessoPermitido");
        listarFunc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_ListadeFuncionariosActionPerformed

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CadastrarDepartamento;
    private javax.swing.JButton CadastrarFuncionario;
    private javax.swing.JButton ListadeDepartamentos;
    private javax.swing.JButton ListadeFuncionarios;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
