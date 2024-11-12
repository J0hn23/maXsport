
package ortegabravo.maxsport.vista;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import ortegabravo.maxsport.accesoDatos.DataAccess;
import ortegabravo.maxsport.modelo.Usuari;


public class DialogoListaUsuarios extends javax.swing.JDialog {

    
    public DialogoListaUsuarios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargaListaConObjetos();
        setSize(450,500);
        lstUsuarios.setSize(400,300);
        
        cargaListaConObjetos();
        
    }
   
    private void cargaListaConObjetos() {

        ArrayList<Usuari> usuarios = DataAccess.getAllUsers();

        DefaultListModel<String> dlm = new DefaultListModel();
      
        for (Usuari e: usuarios) {
            dlm.addElement(e.getNom()+"  "+e.getEmail()+"  "+e.getAssignedInstructor());
        }
        
        lstUsuarios.setModel(dlm);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstUsuarios = new javax.swing.JList<>();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(450, 500));
        setResizable(false);
        getContentPane().setLayout(null);

        lstUsuarios.setVisibleRowCount(50);
        jScrollPane1.setViewportView(lstUsuarios);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 44, 359, 251);

        btnSalir.setText("Salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(btnSalir);
        btnSalir.setBounds(170, 370, 100, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnSalirActionPerformed

    
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lstUsuarios;
    // End of variables declaration//GEN-END:variables
}
