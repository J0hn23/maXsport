package ortegabravo.maxsport.vista;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.awt.HeadlessException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import ortegabravo.maxsport.accesoDatos.DataAccess;
import ortegabravo.maxsport.modelo.Usuari;
import static ortegabravo.maxsport.vista.MODO.CLARO;
import static ortegabravo.maxsport.vista.MODO.OSCURO;

public class DialogoNuevoUsuario extends javax.swing.JDialog {

    Usuari nuevoUsuario;
    int instructorAsignado;
    FramePrincipal fp;

    public DialogoNuevoUsuario(java.awt.Frame parent, boolean modal, int idInstructorAsigna, FramePrincipal fp, MODO modo) {
        super(parent, modal);
        modoVentana(modo);
        initComponents();
        //setVisible(true);
        setSize(400, 350);
        setTitle("Nuevo usuario");
        setLocationRelativeTo(parent);
        instructorAsignado = idInstructorAsigna;
        this.fp = fp;
    }

    private void modoVentana(MODO modo) {

        switch (modo) {
            case CLARO -> {
                try {
                    UIManager.setLookAndFeel(new FlatLightLaf());
                    SwingUtilities.updateComponentTreeUI(this);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            case OSCURO -> {
                try {
                    UIManager.setLookAndFeel(new FlatMacDarkLaf());
                    SwingUtilities.updateComponentTreeUI(this);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }

    private void cargarUsuario() {

        nuevoUsuario = new Usuari();

        char[] pass = jpsPassword.getPassword();
        byte[] fotoVacia = new byte[10];

        String hash = BCrypt.withDefaults().hashToString(12, pass);

        nuevoUsuario.setNom(txtNombre.getText());
        nuevoUsuario.setEmail(txtCorreo.getText());
        nuevoUsuario.setPasswordHash(hash);
        nuevoUsuario.setInstructor(chkIsInstructor.isSelected());
        nuevoUsuario.setFoto(fotoVacia);
 
        //cuandos se da de alta un nuevo usuario y es entrenador se le asigna como id AssignedInstructor el del que lo ha dado de alta
        try {
            if (!txtInstructorasignado.getText().isEmpty()) {
                int instructorId = Integer.parseInt(txtInstructorasignado.getText());
                nuevoUsuario.setAssignedInstructor(instructorId);
            } else {
                nuevoUsuario.setAssignedInstructor(instructorAsignado);
            }
        } catch (NumberFormatException e) {
            // Error en caso de entrada erronea 
            System.err.println("Error: El campo de instructor asignado debe ser un número.");
            return;
        }

        DataAccess.registerUser(nuevoUsuario);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblNombre = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        lblInstructorAsignado = new javax.swing.JLabel();
        txtInstructorasignado = new javax.swing.JTextField();
        btnAnyadir = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        chkIsInstructor = new javax.swing.JCheckBox();
        jpsPassword = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setSize(new java.awt.Dimension(360, 300));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(null);

        lblNombre.setText("Nombre:");
        getContentPane().add(lblNombre);
        lblNombre.setBounds(26, 32, 70, 16);

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        getContentPane().add(txtNombre);
        txtNombre.setBounds(110, 30, 200, 22);

        jLabel1.setText("Correo:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 80, 60, 16);

        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorreoKeyTyped(evt);
            }
        });
        getContentPane().add(txtCorreo);
        txtCorreo.setBounds(110, 80, 200, 22);

        jLabel2.setText("Pass:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 130, 70, 16);

        lblInstructorAsignado.setText("Asg.Intructor");
        getContentPane().add(lblInstructorAsignado);
        lblInstructorAsignado.setBounds(30, 180, 60, 16);

        txtInstructorasignado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtInstructorasignadoKeyTyped(evt);
            }
        });
        getContentPane().add(txtInstructorasignado);
        txtInstructorasignado.setBounds(110, 180, 64, 22);

        btnAnyadir.setText("Añadir");
        btnAnyadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnyadirActionPerformed(evt);
            }
        });
        getContentPane().add(btnAnyadir);
        btnAnyadir.setBounds(80, 230, 120, 30);

        btnSalir.setForeground(new java.awt.Color(204, 0, 0));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir);
        btnSalir.setBounds(200, 230, 110, 30);

        chkIsInstructor.setText("Instructor");
        getContentPane().add(chkIsInstructor);
        chkIsInstructor.setBounds(240, 180, 74, 20);
        getContentPane().add(jpsPassword);
        jpsPassword.setBounds(110, 130, 200, 22);

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAnyadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnyadirActionPerformed

        boolean comprobarMailRepetido = true;
        String nombre = txtNombre.getText();
        String correo = txtCorreo.getText();
        ArrayList<String> mailUsuarios;

        mailUsuarios = DataAccess.getMailUsuarios();

        for (String s : mailUsuarios) {
            if (s.equals(nombre)) {
                comprobarMailRepetido = false;
            }
        }

        if (nombre.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "En campo nombre no puede estrar vacio");
        }else if (correo.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "En campo correo no puede estrar vacio");
        }else if (esEmailValido(correo) != true) {
            JOptionPane.showMessageDialog(rootPane, "Ese formato de mail no es valido");
        }else if (!comprobarMailRepetido) {
            JOptionPane.showMessageDialog(rootPane, "El mail ya esta en el sistema");
        }else {
            try {
                cargarUsuario();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Error al añadir");
            }
        }
        setVisible(false);

        fp.cargarUsuariosEnTabla(instructorAsignado);


    }//GEN-LAST:event_btnAnyadirActionPerformed

    public boolean esEmailValido(String email) {
        String pattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{1,3}$";
        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(email);
        return matcher.matches();
    }


    private void txtInstructorasignadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtInstructorasignadoKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9'))
            evt.consume();
    }//GEN-LAST:event_txtInstructorasignadoKeyTyped

    private void txtCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && (c < '@' || c > 'z') && (c < 'A' || c > 'Z')
                && (c < '-' || c > '.')) {
            evt.consume();
        }

    }//GEN-LAST:event_txtCorreoKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9') && (c < 'a' || c > 'z') && (c < 'A' || c > 'Z')
                && (c < '-' || c > '.')) {
            evt.consume();
        }

    }//GEN-LAST:event_txtNombreKeyTyped

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        fp.cargarUsuariosEnTabla(instructorAsignado);
    }//GEN-LAST:event_formWindowClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAnyadir;
    private javax.swing.JButton btnSalir;
    private javax.swing.JCheckBox chkIsInstructor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField jpsPassword;
    private javax.swing.JLabel lblInstructorAsignado;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtInstructorasignado;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
