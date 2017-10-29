package visao;

/**
 *
 * @author thain
 */
public class EsqueciSenha extends javax.swing.JFrame {

    public EsqueciSenha() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        reciclaBrasil = new javax.swing.JLabel();
        logoImg = new javax.swing.JLabel();
        senhaEmail = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        textoRefSenha = new javax.swing.JLabel();
        redefinirSenha = new javax.swing.JButton();
        voltarLogin = new javax.swing.JButton();
        planoFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        reciclaBrasil.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        reciclaBrasil.setText("Recicla Brasil");
        getContentPane().add(reciclaBrasil);
        reciclaBrasil.setBounds(340, 90, 280, 50);

        logoImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/ReciclaImagem.png"))); // NOI18N
        getContentPane().add(logoImg);
        logoImg.setBounds(510, 80, 70, 60);

        senhaEmail.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        senhaEmail.setText("Email:");
        getContentPane().add(senhaEmail);
        senhaEmail.setBounds(220, 180, 110, 50);

        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        getContentPane().add(email);
        email.setBounds(270, 190, 310, 30);

        textoRefSenha.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        textoRefSenha.setText("Um email será mandando para redefinição de senha");
        getContentPane().add(textoRefSenha);
        textoRefSenha.setBounds(280, 150, 320, 20);

        redefinirSenha.setBackground(new java.awt.Color(0, 153, 255));
        redefinirSenha.setText("Enviar");
        redefinirSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redefinirSenhaActionPerformed(evt);
            }
        });
        getContentPane().add(redefinirSenha);
        redefinirSenha.setBounds(460, 240, 120, 30);

        voltarLogin.setBackground(new java.awt.Color(255, 255, 255));
        voltarLogin.setText("Voltar para Login");
        voltarLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                voltarLoginActionPerformed(evt);
            }
        });
        getContentPane().add(voltarLogin);
        voltarLogin.setBounds(270, 240, 160, 30);

        planoFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/green-nature-vector-backgrounds-powerpoint.jpg"))); // NOI18N
        getContentPane().add(planoFundo);
        planoFundo.setBounds(0, 0, 820, 410);

        setSize(new java.awt.Dimension(838, 450));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void redefinirSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redefinirSenhaActionPerformed
        EmailEnviado telaEnvio = new EmailEnviado();
        telaEnvio.setVisible(true);
        dispose();
    }//GEN-LAST:event_redefinirSenhaActionPerformed

    private void voltarLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_voltarLoginActionPerformed
        TelaLogin login = new TelaLogin();
        login.setVisible(true);
    }//GEN-LAST:event_voltarLoginActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EsqueciSenha().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField email;
    private javax.swing.JLabel logoImg;
    private javax.swing.JLabel planoFundo;
    private javax.swing.JLabel reciclaBrasil;
    private javax.swing.JButton redefinirSenha;
    private javax.swing.JLabel senhaEmail;
    private javax.swing.JLabel textoRefSenha;
    private javax.swing.JButton voltarLogin;
    // End of variables declaration//GEN-END:variables
}
