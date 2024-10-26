package ortegabravo.maxsport.vista;

import at.favre.lib.crypto.bcrypt.BCrypt;
import java.sql.Connection;
import javax.swing.JOptionPane;
import ortegabravo.maxsport.accesoDatos.DataAccess;
import ortegabravo.maxsport.modelo.Usuari;

public class DialogoLogin extends javax.swing.JDialog {

    FramePrincipal fp;
    Connection cx;
    Usuari u = new Usuari();

    public DialogoLogin(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        fp = (FramePrincipal) parent;
    }

    private void comprobarConexion() {

        cx = DataAccess.getConnection();
        if (cx != null) {
            JOptionPane.showMessageDialog(rootPane, "Conectando");
        } else {
            JOptionPane.showMessageDialog(rootPane, "Error en conexion");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnBotonLogin = new javax.swing.JButton();
        txtCampoTextoCorreo = new javax.swing.JTextField();
        lblEtiquetaCorreo = new javax.swing.JLabel();
        lblEtiquetaPass = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        lblLogo = new javax.swing.JLabel();
        jpsPass = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Login usuario");
        setBackground(new java.awt.Color(153, 153, 153));
        setLocation(new java.awt.Point(200, 300));
        setPreferredSize(new java.awt.Dimension(300, 400));
        setSize(new java.awt.Dimension(300, 400));
        getContentPane().setLayout(null);

        btnBotonLogin.setBackground(new java.awt.Color(255, 153, 0));
        btnBotonLogin.setText("Loguear");
        btnBotonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBotonLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnBotonLogin);
        btnBotonLogin.setBounds(90, 250, 140, 40);

        txtCampoTextoCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCampoTextoCorreoKeyTyped(evt);
            }
        });
        getContentPane().add(txtCampoTextoCorreo);
        txtCampoTextoCorreo.setBounds(50, 100, 230, 40);

        lblEtiquetaCorreo.setText("Correo electronico");
        getContentPane().add(lblEtiquetaCorreo);
        lblEtiquetaCorreo.setBounds(100, 80, 140, 20);

        lblEtiquetaPass.setText("Contraseña");
        getContentPane().add(lblEtiquetaPass);
        lblEtiquetaPass.setBounds(120, 160, 140, 18);

        btnCancelar.setBackground(new java.awt.Color(204, 204, 255));
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar);
        btnCancelar.setBounds(110, 310, 100, 30);

        lblLogo.setFont(new java.awt.Font("Liberation Serif", 2, 24)); // NOI18N
        lblLogo.setText("     maXsport");
        getContentPane().add(lblLogo);
        lblLogo.setBounds(80, 10, 160, 40);
        getContentPane().add(jpsPass);
        jpsPass.setBounds(50, 190, 230, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBotonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBotonLoginActionPerformed

        comprobarConexion();
        
        u = DataAccess.getUser(txtCampoTextoCorreo.getText());

        if (u != null) {

            char[] pass = jpsPass.getPassword();
            var resultado = BCrypt.verifyer().verify(pass, u.getPasswordHash());

            if (resultado.verified) {

                System.out.println(u.getNom() + " " + u.isInstructor());
                fp.ConfirmacionLogin(resultado.verified,u.getId());
                setVisible(false);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Usuario no encontrado");
        }

    }//GEN-LAST:event_btnBotonLoginActionPerformed


    private void txtCampoTextoCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCampoTextoCorreoKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && (c < '@' || c > 'z') && (c < 'A' || c > 'Z')
                && (c < '-' || c > '.'))
            evt.consume();
    }//GEN-LAST:event_txtCampoTextoCorreoKeyTyped

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBotonLogin;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JPasswordField jpsPass;
    private javax.swing.JLabel lblEtiquetaCorreo;
    private javax.swing.JLabel lblEtiquetaPass;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JTextField txtCampoTextoCorreo;
    // End of variables declaration//GEN-END:variables
}
