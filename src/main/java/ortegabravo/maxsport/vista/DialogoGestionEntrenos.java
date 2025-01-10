
package ortegabravo.maxsport.vista;

import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import ortegabravo.maxsport.accesoDatos.DataAccess;
import ortegabravo.maxsport.accesoDatos.EntrenosTableModel;
import ortegabravo.maxsport.accesoDatos.UsuariosTableModel;
import ortegabravo.maxsport.modelo.Usuari;
import ortegabravo.maxsport.modelo.Workout;


public class DialogoGestionEntrenos extends javax.swing.JDialog {
    
    private int id;
    private byte[] imagenByte;
    private int idEntreno;
    private int idUsuario;
    private String nombre="";
    private String correoAlumno="";

    public DialogoGestionEntrenos(java.awt.Frame parent, boolean modal, int idEntrenador) {
        super(parent, modal);
        initComponents();
        setSize(400, 350);       
        setLocationRelativeTo(parent);
        
        cargarUsuariosEnTabla(idEntrenador);
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblTablaUsuarios = new javax.swing.JTable();
        txtNombre = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblEntrenosPorUsuario = new javax.swing.JTable();
        jSeparator1 = new javax.swing.JSeparator();
        btnEliminar = new javax.swing.JButton();
        lblFotoUsuario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(584, 400));
        getContentPane().setLayout(null);

        tblTablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblTablaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTablaUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTablaUsuarios);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 20, 375, 116);

        txtNombre.setEnabled(false);
        getContentPane().add(txtNombre);
        txtNombre.setBounds(430, 170, 110, 22);

        txtCorreo.setEnabled(false);
        getContentPane().add(txtCorreo);
        txtCorreo.setBounds(240, 170, 160, 22);

        tblEntrenosPorUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblEntrenosPorUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEntrenosPorUsuarioMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblEntrenosPorUsuario);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(30, 210, 380, 140);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(20, 150, 400, 10);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(btnEliminar);
        btnEliminar.setBounds(440, 250, 100, 50);

        lblFotoUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        getContentPane().add(lblFotoUsuario);
        lblFotoUsuario.setBounds(430, 20, 110, 110);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    //Aqui he aprovechado el codigo que usé en la calse FramePrincipal
    private void cargarFoto() {

        ImageIcon icon = byteArrayAImagen(imagenByte);
        if (icon != null) {
            Image imagenIcon = icon.getImage();
            Image nuevaImagenEscalada = imagenIcon.getScaledInstance(190, 160, java.awt.Image.SCALE_FAST);
            ImageIcon iconoNuevo = new ImageIcon(nuevaImagenEscalada);
            lblFotoUsuario.setIcon(iconoNuevo);
            System.out.println("    finalizada cargarfoto()");
        } else {
            System.out.println("La imagen no pudo ser cargada");
        }
    }

    private void obtenerUsuario(String mail) {
        System.out.println("estoy en obtenerusuario()");
        Usuari usuario = DataAccess.getUser(mail);
        imagenByte = usuario.getFoto();
        System.out.println(usuario.getNom());
        System.out.println(usuario.getFoto());

    }

    private static ImageIcon byteArrayAImagen(byte[] imagen) {
        try {
            ImageIcon icon = new ImageIcon(imagen);
            return icon;
        } catch (Exception e) {
            System.out.println("No se pudo crear el icono de la foto");
        }
        return null;
    }

    
    
    //Cuando pulso la tabla genero un evento que carga nombre y correoalumno con los datos de la fila seleccionada
    private void tblTablaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTablaUsuariosMouseClicked
       
        int fila = tblTablaUsuarios.rowAtPoint(evt.getPoint());

        id=Integer.parseInt(tblTablaUsuarios.getValueAt(fila, 0).toString());
        
        nombre = (String) tblTablaUsuarios.getValueAt(fila, 1);
        correoAlumno = tblTablaUsuarios.getValueAt(fila, 2).toString();
        
        cargarTablaEntrenamientos(nombre,correoAlumno);
        obtenerUsuario(correoAlumno);
        byteArrayAImagen(imagenByte);
        cargarFoto();
        
        
    }//GEN-LAST:event_tblTablaUsuariosMouseClicked

    //ejecuto los dos metodos elimninar entrno
    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        
        eliminarEntrenoEnBD(idEntreno, idUsuario);
        cargarTablaEntrenamientos(nombre,correoAlumno);
        
        
        
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void tblEntrenosPorUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEntrenosPorUsuarioMouseClicked
       
        int fila = tblEntrenosPorUsuario.rowAtPoint(evt.getPoint());

        idEntreno=Integer.parseInt(tblEntrenosPorUsuario.getValueAt(fila, 0).toString());
        System.out.println(idEntreno);
        
       
        idUsuario = Integer.parseInt(tblEntrenosPorUsuario.getValueAt(fila, 2).toString());
//        String correoAlumno = tblEntrenosPorUsuario.getValueAt(fila, 2).toString();
        
        
    }//GEN-LAST:event_tblEntrenosPorUsuarioMouseClicked

    //creo este metodo para eliminar el entreno , vaya tela con la consulta , era dificil ya que afectaba a 4 tablas
    private void eliminarEntrenoEnBD(int idEntreno, int idUsuario){
     
        DataAccess.eliminarEntreno(idEntreno, idUsuario);
    
    }
  
    
    // Aprovecho el mismo codigo que para cargar la tabl de mis usuarios en FFramePrincipal
    private void cargarTablaEntrenamientos(String nombre,String correoAlumno){
        txtCorreo.setText(correoAlumno);
        txtNombre.setText(nombre);
        
        System.out.println("estoy en cargartablaentrenos y correoalumno es:"+correoAlumno );
        
        Usuari usuario;
        ArrayList<Workout> workouts;
        usuario = DataAccess.getUser(correoAlumno);

        System.out.println("usuario.getEmail() es:"+usuario.getEmail());
        workouts = DataAccess.getWorkoutsPerUser(usuario);

        // ejercicios = new ArrayList<>();
        //ejercicios = DataAccess.getExercicisPerWorkout(workouts);
        EntrenosTableModel eptm = new EntrenosTableModel(workouts);
        tblEntrenosPorUsuario.setModel(eptm);
        tblEntrenosPorUsuario.setAutoCreateRowSorter(true);

        
    }
    
    
    
    
    //Lo mismo, aprovecho codigo
    private void cargarUsuariosEnTabla(int idEntrenador) {

        ArrayList<Usuari> usuaris=new ArrayList<>();
        usuaris = DataAccess.getAllUsersByInstructor(idEntrenador);
        UsuariosTableModel utm = new UsuariosTableModel(usuaris);
        tblTablaUsuarios.setModel(utm);
        tblTablaUsuarios.setAutoCreateRowSorter(true);
    }

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblFotoUsuario;
    private javax.swing.JTable tblEntrenosPorUsuario;
    private javax.swing.JTable tblTablaUsuarios;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
