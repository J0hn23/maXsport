package ortegabravo.maxsport.vista;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_OPTION;
import javax.swing.table.AbstractTableModel;
import ortegabravo.maxsport.accesoDatos.DataAccess;
import ortegabravo.maxsport.modelo.Exercici;
import ortegabravo.maxsport.modelo.Usuari;
import ortegabravo.maxsport.modelo.Workout;

public class DialogoEntrenamientos extends javax.swing.JDialog {

    private javax.swing.JComboBox<Exercici> cmbComboEjercicios;
    private ArrayList<Exercici>listaEjerciciosAniadir;
    private int wId;
    private boolean variableControlItemSeleccionadoEjercicio=false;
    private boolean variableControlItemSeleccionadoEntreno=false;
    
    public DialogoEntrenamientos(java.awt.Frame parent, boolean modal, String correo, String nombre) {
        super(parent, false);
        initComponents();

        setLocationRelativeTo(parent);

        txtNombreAlumno.setText(nombre);
        //txtInfoEntreno.setText(cargarEntrenamientos(correo));

        //ArrayList<Exercici> getExercicisPerWorkout(Workout workout)
        cargarTablaEntrenamientos(correo);
        cargaComboEjercicios();
        
        

    }
    
    private void cmbComboEjerciciosActionPerformed(ActionEvent evt) {

        listaEjerciciosAniadir=new ArrayList<>();
        listaEjerciciosAniadir.add((Exercici) cmbComboEjercicios.getSelectedItem());
        variableControlItemSeleccionadoEjercicio=true;
    }

    private void cargarTablaEntrenamientos(String correo) {
        //cargo la tabla con los entrenamientos por correo de usuario
        Usuari usuario = null;
        ArrayList<Workout> workouts;
        usuario = DataAccess.getUser(correo);
        
        
        workouts = DataAccess.getWorkoutsPerUser(usuario);
       
        // ejercicios = new ArrayList<>();
        //ejercicios = DataAccess.getExercicisPerWorkout(workouts);
        EntrenosTableModel eptm = new EntrenosTableModel(workouts);
        tblEntrenosPorUsuario.setModel(eptm);
        tblEntrenosPorUsuario.setAutoCreateRowSorter(true);
        
    }

    private void cargaComboEjercicios() {
        //cargo el combobox con los objetos de Exercici
        cmbComboEjercicios = new javax.swing.JComboBox<>();
        getContentPane().add(cmbComboEjercicios);
        cmbComboEjercicios.setBounds(380, 80, 350, 30);
        DefaultComboBoxModel<Exercici> dcbmw = new DefaultComboBoxModel();
        cmbComboEjercicios.setModel(dcbmw);

        var ejercicios = DataAccess.getAllExercicis();
        for (Exercici e : ejercicios) {
            cmbComboEjercicios.addItem(e);
        }
        
        cmbComboEjercicios.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbComboEjerciciosActionPerformed(evt);
            }
        });
  
    }
    
    
    private void cargaBBDDNuevosEjercicios() {
        
        int opcion=JOptionPane.showConfirmDialog(this, "Se va a añadir ejercicio","Confirme", JOptionPane.YES_NO_OPTION);
        if(opcion==YES_OPTION){
            DataAccess.insertExercisesPerWorkout(wId, listaEjerciciosAniadir);
             JOptionPane.showMessageDialog(this, "Ejercicio añadido con exito");
        }else{
                JOptionPane.showMessageDialog(this, "No añadido ejercicio");
        }
        
        
       
    }

    private void cargarEjerciciosPorEntreno(Workout entrenamiento) {

        //aqui cargo la tabla con los ejercicios y el resultado lo paso
        //a un string que carga el txtArea para ver los ejercicios por entreno
        String cadenaEjercicios = "";
        ArrayList<Exercici> exercicis;
        exercicis = DataAccess.getExercicisPerWorkout((entrenamiento));
        variableControlItemSeleccionadoEntreno=true;
        for (Exercici e : exercicis) {
            //cadenaEjercicios=e.getId();
            cadenaEjercicios += e.getNomExercici() + " ";
            cadenaEjercicios += e.getDescripcio() + "  \n";
            cadenaEjercicios += "--------------------\n";
            
        }
       
        txaResultadoEjercicios.setText(cadenaEjercicios);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSalir = new javax.swing.JButton();
        txtNombreAlumno = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEntrenosPorUsuario = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        txaResultadoEjercicios = new javax.swing.JTextArea();
        btnAniadir = new javax.swing.JButton();
        lblFlechaIzq = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));
        setBounds(new java.awt.Rectangle(0, 0, 400, 400));
        setMinimumSize(new java.awt.Dimension(750, 400));
        setModal(true);
        setResizable(false);
        setSize(new java.awt.Dimension(750, 400));
        getContentPane().setLayout(null);

        btnSalir.setBackground(new java.awt.Color(255, 102, 102));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir);
        btnSalir.setBounds(300, 320, 100, 30);

        txtNombreAlumno.setEditable(false);
        getContentPane().add(txtNombreAlumno);
        txtNombreAlumno.setBounds(150, 20, 180, 24);

        jLabel1.setText("Nombre:");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(80, 20, 70, 20);

        tblEntrenosPorUsuario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Id", "Fecha", "Nombre"
            }
        ));
        tblEntrenosPorUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEntrenosPorUsuarioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEntrenosPorUsuario);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(20, 50, 350, 90);

        txaResultadoEjercicios.setColumns(20);
        txaResultadoEjercicios.setRows(5);
        jScrollPane2.setViewportView(txaResultadoEjercicios);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(20, 150, 350, 150);

        btnAniadir.setBackground(new java.awt.Color(153, 255, 153));
        btnAniadir.setForeground(new java.awt.Color(51, 51, 0));
        btnAniadir.setText("Añadir ejercicio");
        btnAniadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAniadirActionPerformed(evt);
            }
        });
        getContentPane().add(btnAniadir);
        btnAniadir.setBounds(450, 240, 240, 40);

        lblFlechaIzq.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/flecha-girar-hacia-abajo-a-la-izquierda (1).png"))); // NOI18N
        getContentPane().add(lblFlechaIzq);
        lblFlechaIzq.setBounds(400, 240, 40, 60);

        jLabel2.setText("Ejercicios disponibles a añadir");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(440, 40, 220, 18);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void tblEntrenosPorUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEntrenosPorUsuarioMouseClicked

        //con este evento obtengo el la fila donde hago click
        int fila = tblEntrenosPorUsuario.rowAtPoint(evt.getPoint());
        //con la fila cargo un objeto tipo workout con los datos de la fila de la tabla
        Workout entrenamiento = new Workout();
        //aqui cojo con la variablwe el valoer del entreno id seleccionado con el click
        wId=(int) tblEntrenosPorUsuario.getValueAt(fila, 0);
        
        entrenamiento.setId((int) tblEntrenosPorUsuario.getValueAt(fila, 0));
        entrenamiento.setForDate((Date) tblEntrenosPorUsuario.getValueAt(fila, 1));
        entrenamiento.setIdUsuari((int) tblEntrenosPorUsuario.getValueAt(fila, 2));
        entrenamiento.setComments((String) tblEntrenosPorUsuario.getValueAt(fila, 3));

        //paso el objeto workout al metod creado por mi ue creara la tabla con los ejercicios
        cargarEjerciciosPorEntreno(entrenamiento);


    }//GEN-LAST:event_tblEntrenosPorUsuarioMouseClicked

    private void btnAniadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAniadirActionPerformed
       
        if(variableControlItemSeleccionadoEjercicio && variableControlItemSeleccionadoEntreno){
               cargaBBDDNuevosEjercicios();
        }else{
            JOptionPane.showMessageDialog(this, "Debe indicar entreno y ejercicio");
            }
        
    }//GEN-LAST:event_btnAniadirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAniadir;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblFlechaIzq;
    private javax.swing.JTable tblEntrenosPorUsuario;
    private javax.swing.JTextArea txaResultadoEjercicios;
    private javax.swing.JTextField txtNombreAlumno;
    // End of variables declaration//GEN-END:variables

    
}

//de nuevo con la interface Abstracttablemodel creo una tabla a mi gusto
class EntrenosTableModel extends AbstractTableModel {

    private final String[] columns = {"Id Entreno", "Fecha", "Usuario", "Comentario"};
    public ArrayList<Workout> entrenos = null;

    public EntrenosTableModel(ArrayList<Workout> entrenos) {
        this.entrenos = entrenos;
    }

    @Override
    public int getRowCount() {

        return entrenos.size();
    }

    @Override
    public int getColumnCount() {

        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        return switch (columnIndex) {
            case 0 ->
                entrenos.get(rowIndex).getId();
            case 1 ->
                entrenos.get(rowIndex).getForDate();
            case 2 ->
                entrenos.get(rowIndex).getIdUsuari();
            // case 3-> usuaris.get(rowIndex).setFoto(foto);
            case 3 ->
                entrenos.get(rowIndex).getComments();

            default ->
                "-";
        };
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return super.getColumnClass(columnIndex);
    }

}
