
package ortegabravo.maxsport.vista;

import at.favre.lib.crypto.bcrypt.BCrypt;
import ortegabravo.maxsport.accesoDatos.DataAccess;
import ortegabravo.maxsport.modelo.Usuari;


public class DialogoNuevoUsuario extends javax.swing.JDialog {

    
    Usuari nuevoUsuario;
   
    public DialogoNuevoUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        //setVisible(true);
        setSize(400,350);
        setTitle("Nuevo usuario");
        setLocationRelativeTo(parent);
    }
    
    private void cargarUsuario(){
    
        nuevoUsuario=new Usuari();
        
        char[] pass = jpsPassword.getPassword();
        Byte[]fotoVacia=new Byte[10];
             
        String hash=BCrypt.withDefaults().hashToString(12, pass);
         
        nuevoUsuario.setNom(txtNombre.getText());
        nuevoUsuario.setEmail(txtCorreo.getText());
        nuevoUsuario.setPasswordHash(hash);
            
        nuevoUsuario.setInstructor(chkIsInstructor.isSelected());
        System.out.println(chkIsInstructor.isSelected()+"        -------------");
        nuevoUsuario.setAssignedInstructor(Integer.parseInt(txtInstructorasignado.getText()));
        
        nuevoUsuario.setFoto(fotoVacia);
       // nuevoUsuario.setId(000);
        
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
        setBackground(new java.awt.Color(102, 102, 102));
        setSize(new java.awt.Dimension(400, 300));
        getContentPane().setLayout(null);

        lblNombre.setText("Nombre:");
        getContentPane().add(lblNombre);
        lblNombre.setBounds(26, 32, 70, 18);
        getContentPane().add(txtNombre);
        txtNombre.setBounds(110, 30, 200, 24);

        jLabel1.setText("Correo:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 80, 60, 18);
        getContentPane().add(txtCorreo);
        txtCorreo.setBounds(110, 80, 200, 24);

        jLabel2.setText("Pass:");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 130, 70, 18);

        lblInstructorAsignado.setText("Asg.Intructor");
        getContentPane().add(lblInstructorAsignado);
        lblInstructorAsignado.setBounds(30, 180, 60, 18);
        getContentPane().add(txtInstructorasignado);
        txtInstructorasignado.setBounds(110, 180, 64, 24);

        btnAnyadir.setBackground(new java.awt.Color(0, 153, 153));
        btnAnyadir.setText("Añadir");
        btnAnyadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAnyadirActionPerformed(evt);
            }
        });
        getContentPane().add(btnAnyadir);
        btnAnyadir.setBounds(140, 230, 120, 30);

        btnSalir.setBackground(new java.awt.Color(102, 0, 0));
        btnSalir.setForeground(new java.awt.Color(255, 102, 102));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir);
        btnSalir.setBounds(300, 260, 83, 24);

        chkIsInstructor.setText("Instructor");
        getContentPane().add(chkIsInstructor);
        chkIsInstructor.setBounds(240, 180, 84, 22);
        getContentPane().add(jpsPassword);
        jpsPassword.setBounds(110, 130, 200, 24);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAnyadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAnyadirActionPerformed
        cargarUsuario();
        setVisible(false);
    }//GEN-LAST:event_btnAnyadirActionPerformed
    
    
    

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
