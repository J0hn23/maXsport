package ortegabravo.maxsport.vista;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import ortegabravo.maxsport.accesoDatos.DataAccess;
import ortegabravo.maxsport.modelo.Exercici;

public class DialogoAsignarEjerciciosAEntreno extends javax.swing.JDialog {

    String ejercicioSeleccionado="";
    String valor="";
    String respuesta="";
    ArrayList<Exercici> listaEjerciciosSeleccionados = new ArrayList<>();
    Exercici ejercicio=new Exercici();
    ArrayList<Exercici> listaEjercicios = new ArrayList<>();
    ArrayList<String> nombresEjercicios = new ArrayList<>();
    ArrayList<Exercici> listaACargar = new ArrayList<>();

    public DialogoAsignarEjerciciosAEntreno(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setSize(500, 350);
        
        
        cargarComboEjercicios();
        

    }

    private void cargarComboEjercicios() {
   
     
       
        
        listaEjercicios = DataAccess.getAllExercicis();

        for (Exercici e : listaEjercicios) {

            nombresEjercicios.add(0, e.getDescripcio()); 
           
            
        }
         DefaultComboBoxModel<String> modelo = new DefaultComboBoxModel<>();
        
        for (String e : nombresEjercicios) {

           
            modelo.addElement(e);

        }
        
        
  
        cmbComboEjercicios.setModel(modelo);
        cmbComboEjercicios.setSelectedItem(nombresEjercicios);
        
       
        
 
    }
    
   private ArrayList<Exercici> cargaListaEjercicios(String respuesta,ArrayList<Exercici>listaEjercicios ){
     
    
     for(Exercici e:listaEjercicios){
     if(e.getDescripcio().equals(respuesta)){
                   listaACargar.add(e);
                   System.out.println("+++cargado dato en for e"+e.toString());
                   
               }
          
     
     
     }
  
    return listaACargar;
    }
   
    
    
        
   

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblEjercicios = new javax.swing.JLabel();
        btnAniadir = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaEjerciciosSeleccionados = new javax.swing.JTextArea();
        lblEntrenamiento = new javax.swing.JLabel();
        txtAñadirAEntreno = new javax.swing.JTextField();
        cmbComboEjercicios = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));
        setSize(new java.awt.Dimension(500, 350));
        getContentPane().setLayout(null);

        lblEjercicios.setText("Ejercicios");
        lblEjercicios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lblEjerciciosMousePressed(evt);
            }
        });
        getContentPane().add(lblEjercicios);
        lblEjercicios.setBounds(50, 50, 290, 18);

        btnAniadir.setText("Añadir");
        btnAniadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAniadirActionPerformed(evt);
            }
        });
        getContentPane().add(btnAniadir);
        btnAniadir.setBounds(150, 250, 220, 50);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir);
        btnSalir.setBounds(400, 250, 80, 30);

        txaEjerciciosSeleccionados.setColumns(20);
        txaEjerciciosSeleccionados.setRows(5);
        jScrollPane1.setViewportView(txaEjerciciosSeleccionados);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(130, 90, 310, 96);

        lblEntrenamiento.setText("Añadir al entrenamiento nº:");
        getContentPane().add(lblEntrenamiento);
        lblEntrenamiento.setBounds(50, 20, 180, 18);
        getContentPane().add(txtAñadirAEntreno);
        txtAñadirAEntreno.setBounds(240, 20, 64, 24);

        cmbComboEjercicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbComboEjerciciosActionPerformed(evt);
            }
        });
        getContentPane().add(cmbComboEjercicios);
        cmbComboEjercicios.setBounds(130, 50, 310, 24);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblEjerciciosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEjerciciosMousePressed
    
    }//GEN-LAST:event_lblEjerciciosMousePressed
 
    
    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    
    
    
    private void btnAniadirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAniadirActionPerformed
        
        
        
        int numeroEntreno= Integer.parseInt(txtAñadirAEntreno.getText());
        int prueba=DataAccess.insertExercisesPerWorkout(numeroEntreno, listaEjerciciosSeleccionados);
        System.out.println("      Filas modificadas:" +prueba);
       
        setVisible(false);
          
    }//GEN-LAST:event_btnAniadirActionPerformed

    private void cmbComboEjerciciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbComboEjerciciosActionPerformed
        
       

        respuesta=cmbComboEjercicios.getSelectedItem().toString();
        //valor=cmbComboEjercicios.getSelectedItem().toString();
        //System.out.println(valor);
        valor+=cmbComboEjercicios.getSelectedItem().toString()+" \n";
        txaEjerciciosSeleccionados.setText(valor);
        
        
        // ArrayList<Exercici>prueba = new ArrayList<>();
         
         listaEjerciciosSeleccionados=cargaListaEjercicios(respuesta,listaEjercicios);
         /*
        for(Exercici e:prueba){
            System.out.println(e.getDescripcio());
            System.out.println("----------------dentro del array arrayprueba");
        
        }
        */
        
    }//GEN-LAST:event_cmbComboEjerciciosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAniadir;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox<String> cmbComboEjercicios;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEjercicios;
    private javax.swing.JLabel lblEntrenamiento;
    private javax.swing.JTextArea txaEjerciciosSeleccionados;
    private javax.swing.JTextField txtAñadirAEntreno;
    // End of variables declaration//GEN-END:variables

   
}
