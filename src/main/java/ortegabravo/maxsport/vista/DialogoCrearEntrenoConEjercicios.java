package ortegabravo.maxsport.vista;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import ortegabravo.maxsport.accesoDatos.DataAccess;
import ortegabravo.maxsport.modelo.Exercici;
import ortegabravo.maxsport.modelo.Usuari;
import ortegabravo.maxsport.modelo.Workout;

public class DialogoCrearEntrenoConEjercicios extends javax.swing.JDialog {

    private javax.swing.JComboBox<Exercici> cmbComboObject;
    String valor = "";
    ArrayList<Exercici> listaEjerciciosSeleccionados = new ArrayList<>();

    public DialogoCrearEntrenoConEjercicios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);

        //setSize(450, 600);
       cargarComboEjercicios();
         
    }
    
    private void cargarComboEjercicios(){
        cmbComboObject = new javax.swing.JComboBox<>();
        getContentPane().add(cmbComboObject);
        cmbComboObject.setBounds(30, 260, 400, 30);
    
    }
    
    
    private int buscarIdUltimoUsuario(){
          
        ArrayList<Usuari>usuarios=DataAccess.getAllUsers();
    
        int idUltimoUsuario=usuarios.getLast().getId();

    return idUltimoUsuario;
    }

    public int aniadirEntreno(ArrayList<Exercici> exercicis) {
        
        Workout w = new Workout();
       
        
        String s=txtId.getText();
        
        
        
        if(s.equals("")){
            JOptionPane.showMessageDialog(rootPane, "Debe introducir un número de usuario");
        }else if(Integer.parseInt(s)>buscarIdUltimoUsuario() ||  Integer.parseInt(s)<=buscarIdUltimoUsuario()){
            w.setIdUsuari(Integer.parseInt(txtId.getText()));
            w.setComments(txtComentaio.getText());
            w.setForDate((Date) spnFechaEntreno.getValue());
            DataAccess.insertWorkout(w, exercicis);
            JOptionPane.showMessageDialog(rootPane, "Entreno añadido");
            return 1;
        }else{
            JOptionPane.showMessageDialog(rootPane, "Usuario no existe");
        }
        
        
    return 0;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblFechaEntreno = new javax.swing.JLabel();
        spnFechaEntreno = new javax.swing.JSpinner();
        jLabel2 = new javax.swing.JLabel();
        txtId = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtComentaio = new javax.swing.JTextField();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaEjerciciosSeleccionados = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        btnAniadirejercicio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));
        setMinimumSize(new java.awt.Dimension(450, 600));
        setPreferredSize(new java.awt.Dimension(450, 600));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setText("          Crear nuevo entreno");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(78, 20, 200, 30);

        lblFechaEntreno.setText("Fecha");
        getContentPane().add(lblFechaEntreno);
        lblFechaEntreno.setBounds(30, 60, 41, 18);

        spnFechaEntreno.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), new java.util.Date(), null, java.util.Calendar.DAY_OF_MONTH));
        getContentPane().add(spnFechaEntreno);
        spnFechaEntreno.setBounds(130, 60, 140, 24);

        jLabel2.setText("Id Usuario");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 110, 80, 18);

        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdKeyTyped(evt);
            }
        });
        getContentPane().add(txtId);
        txtId.setBounds(130, 100, 64, 30);

        jLabel3.setText("Comentario");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 160, 80, 18);
        getContentPane().add(txtComentaio);
        txtComentaio.setBounds(130, 154, 220, 30);

        btnSalir.setBackground(new java.awt.Color(255, 153, 153));
        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir);
        btnSalir.setBounds(290, 510, 83, 24);

        txaEjerciciosSeleccionados.setColumns(20);
        txaEjerciciosSeleccionados.setRows(5);
        jScrollPane1.setViewportView(txaEjerciciosSeleccionados);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 370, 330, 96);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(20, 210, 360, 30);

        btnAniadirejercicio.setBackground(new java.awt.Color(102, 204, 255));
        btnAniadirejercicio.setText("Añadir Ejercicio");
        btnAniadirejercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAniadirejercicioActionPerformed(evt);
            }
        });
        getContentPane().add(btnAniadirejercicio);
        btnAniadirejercicio.setBounds(30, 490, 160, 50);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        var ejercicios = DataAccess.getAllExercicis();

        DefaultComboBoxModel dcbm = new DefaultComboBoxModel();

        cmbComboObject.setModel(dcbm);

        for (Exercici e : ejercicios) {

            cmbComboObject.addItem(e);

        }

        cmbComboObject.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbComboObjectActionPerformed(evt);
            }
        });


    }//GEN-LAST:event_formWindowOpened


    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnAniadirejercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAniadirejercicioActionPerformed
 
        int realizado=aniadirEntreno(listaEjerciciosSeleccionados);

        
        if(realizado==1)setVisible(false);

    }//GEN-LAST:event_btnAniadirejercicioActionPerformed

    private void txtIdKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIdKeyTyped
        char c = evt.getKeyChar();
        if ((c < '0' || c > '9'))
            evt.consume();
    }//GEN-LAST:event_txtIdKeyTyped

    private void cmbComboObjectActionPerformed(ActionEvent evt) {

        valor += cmbComboObject.getSelectedItem().toString() + " \n";
        txaEjerciciosSeleccionados.setText(valor);

        listaEjerciciosSeleccionados.add((Exercici) cmbComboObject.getSelectedItem());

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAniadirejercicio;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblFechaEntreno;
    private javax.swing.JSpinner spnFechaEntreno;
    private javax.swing.JTextArea txaEjerciciosSeleccionados;
    private javax.swing.JTextField txtComentaio;
    private javax.swing.JTextField txtId;
    // End of variables declaration//GEN-END:variables
}
