
package ortegabravo.maxsport.vista;

import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import ortegabravo.maxsport.accesoDatos.DataAccess;
import ortegabravo.maxsport.accesoDatos.UsuariosTableModel;
import ortegabravo.maxsport.modelo.Usuari;


public class DialogoListaUsuarios extends javax.swing.JDialog {

   
    
    public DialogoListaUsuarios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
//        cargaListaConObjetos();
        setSize(450,500);
//        lstUsuarios.setSize(400,300);
        
//        cargaListaConObjetos();

        cargaComboUsuarios();
        
    }
   
//    private void cargaListaConObjetos() {
//
//        ArrayList<Usuari> usuarios = DataAccess.getAllUsers();
//
//        DefaultListModel<String> dlm = new DefaultListModel();
//      
//        for (Usuari e: usuarios) {
//            dlm.addElement(e.getNom()+"  "+e.getEmail()+"  "+e.getAssignedInstructor());
//        }
//        
//        lstUsuarios.setModel(dlm);
//
//    }
    
    
    private void cargaComboUsuarios(){
    
        ArrayList<Usuari> misUsuarios = DataAccess.getAllUsers();
        UsuariosTableModel utm = new UsuariosTableModel(misUsuarios);
        tblTablaUsuarios.setModel(utm);
        tblTablaUsuarios.setAutoCreateRowSorter(true);
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnSalir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTablaUsuarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(450, 500));
        setResizable(false);
        getContentPane().setLayout(null);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir);
        btnSalir.setBounds(170, 370, 100, 40);

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
        jScrollPane1.setViewportView(tblTablaUsuarios);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 20, 420, 270);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTablaUsuarios;
    // End of variables declaration//GEN-END:variables
}
