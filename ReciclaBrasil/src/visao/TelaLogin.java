package visao;

/**
 *
 * @author thain
 */

public class TelaLogin extends javax.swing.JFrame {

    public TelaLogin() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        senha = new javax.swing.JLabel();
        usuario = new javax.swing.JLabel();
        botaoAcessar = new javax.swing.JButton();
        campoUsuario = new javax.swing.JTextField();
        campoSenha = new javax.swing.JPasswordField();
        logoImg = new javax.swing.JLabel();
        reciclaBrasil = new javax.swing.JLabel();
        botaoEsqueciSenha = new javax.swing.JButton();
        lembrarMe = new java.awt.Checkbox();
        planoFundo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        senha.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        senha.setText("Senha:");
        getContentPane().add(senha);
        senha.setBounds(290, 180, 50, 20);

        usuario.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        usuario.setText("Usuário:");
        getContentPane().add(usuario);
        usuario.setBounds(280, 140, 90, 30);

        botaoAcessar.setBackground(new java.awt.Color(0, 153, 255));
        botaoAcessar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        botaoAcessar.setText("Acessar");
        botaoAcessar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAcessarActionPerformed(evt);
            }
        });
        getContentPane().add(botaoAcessar);
        botaoAcessar.setBounds(490, 250, 90, 30);

        campoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoUsuarioActionPerformed(evt);
            }
        });
        getContentPane().add(campoUsuario);
        campoUsuario.setBounds(340, 140, 240, 30);

        campoSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoSenhaActionPerformed(evt);
            }
        });
        getContentPane().add(campoSenha);
        campoSenha.setBounds(340, 180, 240, 30);

        logoImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/ReciclaImagem.png"))); // NOI18N
        getContentPane().add(logoImg);
        logoImg.setBounds(520, 60, 59, 80);

        reciclaBrasil.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        reciclaBrasil.setText("Recicla Brasil");
        getContentPane().add(reciclaBrasil);
        reciclaBrasil.setBounds(370, 80, 250, 50);

        botaoEsqueciSenha.setBackground(new java.awt.Color(255, 255, 255));
        botaoEsqueciSenha.setText("Esqueci a senha");
        botaoEsqueciSenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEsqueciSenhaActionPerformed(evt);
            }
        });
        getContentPane().add(botaoEsqueciSenha);
        botaoEsqueciSenha.setBounds(340, 220, 150, 20);

        lembrarMe.setBackground(new java.awt.Color(255, 255, 255));
        lembrarMe.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lembrarMe.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        lembrarMe.setState(true);

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, campoUsuario, org.jdesktop.beansbinding.ELProperty.create("Lembrar-me"), lembrarMe, org.jdesktop.beansbinding.BeanProperty.create("label"));
        bindingGroup.addBinding(binding);

        getContentPane().add(lembrarMe);
        lembrarMe.setBounds(590, 140, 110, 30);

        planoFundo.setBackground(new java.awt.Color(0, 0, 0));
        planoFundo.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        planoFundo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/green-nature-vector-backgrounds-powerpoint.jpg"))); // NOI18N
        getContentPane().add(planoFundo);
        planoFundo.setBounds(0, 0, 860, 410);

        bindingGroup.bind();

        setSize(new java.awt.Dimension(877, 447));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void campoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoUsuarioActionPerformed

    private void campoSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoSenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoSenhaActionPerformed

    private void botaoAcessarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAcessarActionPerformed
       TelaHome tela = new TelaHome();
       tela.setVisible(true);
       dispose(); //fecha a tela anterior//
    }//GEN-LAST:event_botaoAcessarActionPerformed

    private void botaoEsqueciSenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEsqueciSenhaActionPerformed
        EsqueciSenha telaEsqueci = new EsqueciSenha();
        telaEsqueci.setVisible(true);
        dispose();
    }//GEN-LAST:event_botaoEsqueciSenhaActionPerformed

    public static void main(String args[]) {
      
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaLogin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAcessar;
    private javax.swing.JButton botaoEsqueciSenha;
    private javax.swing.JPasswordField campoSenha;
    private javax.swing.JTextField campoUsuario;
    private java.awt.Checkbox lembrarMe;
    private javax.swing.JLabel logoImg;
    private javax.swing.JLabel planoFundo;
    private javax.swing.JLabel reciclaBrasil;
    private javax.swing.JLabel senha;
    private javax.swing.JLabel usuario;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables
}
