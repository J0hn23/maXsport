
package ortegabravo.maxsport.vista;


public class DialogoLogin extends javax.swing.JDialog {

    
    
    
   
    public DialogoLogin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBotonLogin = new javax.swing.JButton();
        txtCampoTextoCorreo = new javax.swing.JTextField();
        lblEtiquetaCorreo = new javax.swing.JLabel();
        lblEtiquetaPass = new javax.swing.JLabel();
        txtCampoTextoPass = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login usuario");
        setBackground(new java.awt.Color(153, 153, 153));
        setLocation(new java.awt.Point(200, 300));
        setPreferredSize(new java.awt.Dimension(300, 400));
        setSize(new java.awt.Dimension(300, 400));
        getContentPane().setLayout(null);

        btnBotonLogin.setBackground(new java.awt.Color(255, 153, 0));
        btnBotonLogin.setText("Loguear");
        getContentPane().add(btnBotonLogin);
        btnBotonLogin.setBounds(110, 290, 99, 45);
        getContentPane().add(txtCampoTextoCorreo);
        txtCampoTextoCorreo.setBounds(60, 100, 220, 40);

        lblEtiquetaCorreo.setText("Correo electronico");
        getContentPane().add(lblEtiquetaCorreo);
        lblEtiquetaCorreo.setBounds(100, 80, 140, 20);

        lblEtiquetaPass.setText("Contraseña");
        getContentPane().add(lblEtiquetaPass);
        lblEtiquetaPass.setBounds(120, 160, 140, 18);
        getContentPane().add(txtCampoTextoPass);
        txtCampoTextoPass.setBounds(60, 180, 220, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBotonLogin;
    private javax.swing.JLabel lblEtiquetaCorreo;
    private javax.swing.JLabel lblEtiquetaPass;
    private javax.swing.JTextField txtCampoTextoCorreo;
    private javax.swing.JTextField txtCampoTextoPass;
    // End of variables declaration//GEN-END:variables
}
