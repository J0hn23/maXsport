
package ortegabravo.maxsport.vista;

import java.util.ArrayList;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import ortegabravo.maxsport.accesoDatos.DataAccess;
import ortegabravo.maxsport.modelo.Exercici;


public class DialogoAsignarEjerciciosAEntreno extends javax.swing.JDialog {

    public DialogoAsignarEjerciciosAEntreno(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setSize(500, 350);
        
        cargarComboEjercicios();
        
        
        
        
    }
    
    
    private void cargarComboEjercicios(){
    
        //creo un arrrayList y lo cargo con los ejercicios de la bbdd
        ArrayList<Exercici> listaEjercicios = new ArrayList<>();
        listaEjercicios=DataAccess.getAllExercicis();
        
         ArrayList<String> nombresEjercicios = new ArrayList<>();
       
        
          for(Exercici e:listaEjercicios){
       
             nombresEjercicios.add(0,e.getDescripcio());
          
          }
            DefaultComboBoxModel<String> modelo=new DefaultComboBoxModel<>();
          
          for(String e:nombresEjercicios){
          
               System.out.println(e); 
               modelo.addElement(e);
          
          }

        jcbDesplegableEjercicios.setModel(modelo);
    
    
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblEjercicios = new javax.swing.JLabel();
        jcbDesplegableEjercicios = new javax.swing.JComboBox<>();
        btnAniadir = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txaEjerciciosSeleccionados = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));
        setSize(new java.awt.Dimension(500, 350));
        getContentPane().setLayout(null);

        lblEjercicios.setText("Ejercicios");
        getContentPane().add(lblEjercicios);
        lblEjercicios.setBounds(50, 50, 290, 18);

        jcbDesplegableEjercicios.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jcbDesplegableEjercicios);
        jcbDesplegableEjercicios.setBounds(130, 50, 310, 24);

        btnAniadir.setText("Añadir");
        getContentPane().add(btnAniadir);
        btnAniadir.setBounds(150, 230, 220, 50);

        btnSalir.setText("Salir");
        getContentPane().add(btnSalir);
        btnSalir.setBounds(400, 250, 80, 30);

        txaEjerciciosSeleccionados.setColumns(20);
        txaEjerciciosSeleccionados.setRows(5);
        jScrollPane1.setViewportView(txaEjerciciosSeleccionados);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(130, 90, 310, 96);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAniadir;
    private javax.swing.JButton btnSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbDesplegableEjercicios;
    private javax.swing.JLabel lblEjercicios;
    private javax.swing.JTextArea txaEjerciciosSeleccionados;
    // End of variables declaration//GEN-END:variables
}
