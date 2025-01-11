package ortegabravo.maxsport.vista;

import at.favre.lib.crypto.bcrypt.BCrypt;
import java.sql.Connection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
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
        setLocationRelativeTo(parent);
        txtCampoTextoCorreo.requestFocusInWindow();
        logicaBotonLogin();
    }
    
    
    private void logicaBotonLogin(){
    //Esto lleva el focus al boton login y permite que al tipear el login con el intro acceda
        btnBotonLogin.requestFocusInWindow();
        btnBotonLogin.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("ENTER"), "pressed");
        btnBotonLogin.getInputMap(JComponent.WHEN_FOCUSED).put(KeyStroke.getKeyStroke("released ENTER"), "released");
        btnBotonLogin.setToolTipText("Entrar");
    }

    private void comprobarConexion() {

        cx = DataAccess.getConnection();
        if (cx != null) {
            fp.enviarConexion(cx);
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
        setResizable(false);
        setSize(new java.awt.Dimension(300, 400));
        getContentPane().setLayout(null);

        btnBotonLogin.setForeground(new java.awt.Color(255, 0, 51));
        btnBotonLogin.setText("Loguear");
        btnBotonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBotonLoginActionPerformed(evt);
            }
        });
        getContentPane().add(btnBotonLogin);
        btnBotonLogin.setBounds(70, 270, 140, 40);

        txtCampoTextoCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCampoTextoCorreoKeyTyped(evt);
            }
        });
        getContentPane().add(txtCampoTextoCorreo);
        txtCampoTextoCorreo.setBounds(30, 100, 230, 40);

        lblEtiquetaCorreo.setText("Correo electronico");
        getContentPane().add(lblEtiquetaCorreo);
        lblEtiquetaCorreo.setBounds(100, 80, 140, 20);

        lblEtiquetaPass.setText("Contraseña");
        getContentPane().add(lblEtiquetaPass);
        lblEtiquetaPass.setBounds(120, 160, 140, 16);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar);
        btnCancelar.setBounds(70, 310, 140, 30);

        lblLogo.setFont(new java.awt.Font("Liberation Serif", 2, 24)); // NOI18N
        lblLogo.setText("     maXsport");
        getContentPane().add(lblLogo);
        lblLogo.setBounds(80, 10, 160, 40);
        getContentPane().add(jpsPass);
        jpsPass.setBounds(30, 190, 230, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents
    //uso una funcion mediante patrones para comprobar que el correo es valido
    public boolean esEmailValido(String email) {
        String pattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{1,3}$";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(email);
        return matcher.matches();
    }


    private void btnBotonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBotonLoginActionPerformed

        comprobarConexion();

        esEmailValido(txtCampoTextoCorreo.getText());

        u = DataAccess.getUser(txtCampoTextoCorreo.getText());

        if (esEmailValido(txtCampoTextoCorreo.getText())) {

            if (u != null && u.getInstructor() == true) {

                char[] pass = jpsPass.getPassword();
                var resultado = BCrypt.verifyer().verify(pass, u.getPasswordHash());

                if (resultado.verified) {

                    System.out.println(u.getNom() + " " + u.isInstructor());
                    fp.confirmacionLogin(resultado.verified, u.getId(),u.getEmail());
                    setVisible(false);
                } else {
                JOptionPane.showMessageDialog(rootPane, "Usuario no encontrado o no es instructor");
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Email no valido");
        }

    }//GEN-LAST:event_btnBotonLoginActionPerformed


    private void txtCampoTextoCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCampoTextoCorreoKeyTyped
        //limito la entrada por teclado a estos caracteres
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && (c < '@' || c > 'z') && (c < 'A' || c > 'Z')
                && (c < '-' || c > '.')) {
            evt.consume();
        }


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
