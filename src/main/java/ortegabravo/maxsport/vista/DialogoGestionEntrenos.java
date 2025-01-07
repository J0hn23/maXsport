
package ortegabravo.maxsport.vista;

import java.util.ArrayList;
import ortegabravo.maxsport.accesoDatos.DataAccess;
import ortegabravo.maxsport.accesoDatos.EntrenosTableModel;
import ortegabravo.maxsport.accesoDatos.UsuariosTableModel;
import ortegabravo.maxsport.modelo.Usuari;
import ortegabravo.maxsport.modelo.Workout;


public class DialogoGestionEntrenos extends javax.swing.JDialog {
    
     int id;

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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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
        getContentPane().add(txtNombre);
        txtNombre.setBounds(80, 170, 64, 24);
        getContentPane().add(txtCorreo);
        txtCorreo.setBounds(220, 170, 160, 24);

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
        jScrollPane2.setViewportView(tblEntrenosPorUsuario);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(30, 210, 380, 160);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(20, 150, 400, 10);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblTablaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTablaUsuariosMouseClicked
       
         int fila = tblTablaUsuarios.rowAtPoint(evt.getPoint());

        id=Integer.parseInt(tblTablaUsuarios.getValueAt(fila, 0).toString());
        
        String nombre = (String) tblTablaUsuarios.getValueAt(fila, 1);
        String correoAlumno = tblTablaUsuarios.getValueAt(fila, 2).toString();
        
        cargarTablaEntrenamientos(nombre,correoAlumno);
        
        
    }//GEN-LAST:event_tblTablaUsuariosMouseClicked

  
    private void cargarTablaEntrenamientos(String nombre,String correoAlumno){
        txtCorreo.setText(correoAlumno);
        txtNombre.setText(nombre);
        
        Usuari usuario = null;
        ArrayList<Workout> workouts;
        usuario = DataAccess.getUser(correoAlumno);

        workouts = DataAccess.getWorkoutsPerUser(usuario);

        // ejercicios = new ArrayList<>();
        //ejercicios = DataAccess.getExercicisPerWorkout(workouts);
        EntrenosTableModel eptm = new EntrenosTableModel(workouts);
        tblEntrenosPorUsuario.setModel(eptm);
        tblEntrenosPorUsuario.setAutoCreateRowSorter(true);

        
    }
    
    
    private int borrarEntreno(){
    int filasAfectadas = 0;
        
        
    return filasAfectadas;
    }
    
    
    
    private void cargarUsuariosEnTabla(int idEntrenador) {

        ArrayList<Usuari> usuaris=new ArrayList<>();
        usuaris = DataAccess.getAllUsersByInstructor(idEntrenador);
        UsuariosTableModel utm = new UsuariosTableModel(usuaris);
        tblTablaUsuarios.setModel(utm);
        tblTablaUsuarios.setAutoCreateRowSorter(true);
    }

 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblEntrenosPorUsuario;
    private javax.swing.JTable tblTablaUsuarios;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
