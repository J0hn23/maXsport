package ortegabravo.maxsport.vista;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import ortegabravo.maxsport.accesoDatos.DataAccess;
import ortegabravo.maxsport.modelo.Exercici;

public class DialogoListaEjercicios extends javax.swing.JDialog {

   private ArrayList<Exercici> exercicis;
   
    

    public DialogoListaEjercicios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setSize(300, 400);
        
       

        cargaListaConObjetos();
 
    }

    private void cargaListaConObjetos() {

        exercicis = DataAccess.getAllExercicis();
        DefaultListModel<String> dlm = new DefaultListModel();
   
        for (Exercici e: exercicis) {
            dlm.addElement(e.getDescripcio());
        }
        
        jltListaEjercicios.setModel(dlm);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSalir = new javax.swing.JButton();
        lblTextoEjercicios = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jltListaEjercicios = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));
        setForeground(new java.awt.Color(51, 51, 255));
        setResizable(false);
        getContentPane().setLayout(null);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir);
        btnSalir.setBounds(110, 310, 100, 30);

        lblTextoEjercicios.setBackground(new java.awt.Color(102, 255, 204));
        lblTextoEjercicios.setFont(new java.awt.Font("Liberation Serif", 1, 15)); // NOI18N
        lblTextoEjercicios.setText("   Ejercicios elegibles en el sistema");
        getContentPane().add(lblTextoEjercicios);
        lblTextoEjercicios.setBounds(30, 10, 240, 18);

        jScrollPane2.setViewportView(jltListaEjercicios);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(20, 40, 260, 240);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> jltListaEjercicios;
    private javax.swing.JLabel lblTextoEjercicios;
    // End of variables declaration//GEN-END:variables
    
}


