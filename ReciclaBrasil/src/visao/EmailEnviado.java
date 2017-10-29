package visao;

/**
 *
 * @author thain
 */
public class EmailEnviado extends javax.swing.JFrame {
    public EmailEnviado() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        sucesso = new javax.swing.JLabel();
        botaoOk = new javax.swing.JButton();
        reciclaBrasil = new javax.swing.JLabel();
        logoImg = new javax.swing.JLabel();
        planoFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        sucesso.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        sucesso.setText("Email enviado com sucesso!!");
        getContentPane().add(sucesso);
        sucesso.setBounds(270, 160, 310, 50);

        botaoOk.setBackground(new java.awt.Color(0, 153, 255));
        botaoOk.setText("Ok");
        botaoOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoOkActionPerformed(evt);
            }
        });
        getContentPane().add(botaoOk);
        botaoOk.setBounds(320, 270, 170, 30);

        reciclaBrasil.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        reciclaBrasil.setText("Recicla Brasil");
        getContentPane().add(reciclaBrasil);
        reciclaBrasil.setBounds(40, 10, 230, 40);

        logoImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/ReciclaImagem.png"))); // NOI18N
        logoImg.setText("jLabel1");
        getContentPane().add(logoImg);
        logoImg.setBounds(710, 10, 60, 60);

        planoFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/green-nature-vector-backgrounds-powerpoint.jpg"))); // NOI18N
        getContentPane().add(planoFundo);
        planoFundo.setBounds(0, 0, 780, 430);

        setSize(new java.awt.Dimension(799, 463));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoOkActionPerformed
        TelaLogin telaLogin = new TelaLogin();
        telaLogin.setVisible(true);
        dispose();
    }//GEN-LAST:event_botaoOkActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EmailEnviado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoOk;
    private javax.swing.JLabel logoImg;
    private javax.swing.JLabel planoFundo;
    private javax.swing.JLabel reciclaBrasil;
    private javax.swing.JLabel sucesso;
    // End of variables declaration//GEN-END:variables
}
