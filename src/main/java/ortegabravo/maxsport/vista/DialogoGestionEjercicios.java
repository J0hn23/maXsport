
package ortegabravo.maxsport.vista;

import javax.swing.DefaultComboBoxModel;
import ortegabravo.maxsport.accesoDatos.DataAccess;
import ortegabravo.maxsport.modelo.Exercici;
import ortegabravo.maxsport.modelo.Usuari;
import ortegabravo.maxsport.modelo.Workout;


public class DialogoGestionEjercicios extends javax.swing.JDialog {
    
    
    private javax.swing.JComboBox<Workout> cmbComboObject;

   
    public DialogoGestionEjercicios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        setSize(600,450);
        cmbComboObject=new javax.swing.JComboBox<>();
         getContentPane().add(cmbComboObject);
        cmbComboObject.setBounds(40, 70, 390, 30);
         DefaultComboBoxModel <Workout>dcbmw=new DefaultComboBoxModel();
         cmbComboObject.setModel(dcbmw);
         /*
           var entrenos=DataAccess.getWorkoutsPerUser(7);
          for(Workout w: entrenos){
            cmbComboEntrenos.addItem(w.toString());
        
        }
*/
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        txtEntrenoSeleccionado = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnAniadirEjercicio = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jlstEjerciciosSeleccionados = new javax.swing.JList<>();
        cmbComboEntrenos = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 255));
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(600, 450));
        setResizable(false);
        setSize(new java.awt.Dimension(600, 450));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jButton1.setBackground(new java.awt.Color(255, 153, 153));
        jButton1.setText("Salir");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(jButton1);
        jButton1.setBounds(460, 50, 100, 40);
        getContentPane().add(txtEntrenoSeleccionado);
        txtEntrenoSeleccionado.setBounds(200, 170, 360, 24);

        jLabel1.setText("Entreno seleccionado");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(40, 170, 150, 18);

        btnAniadirEjercicio.setBackground(new java.awt.Color(102, 255, 204));
        btnAniadirEjercicio.setText("Añadir");
        btnAniadirEjercicio.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        getContentPane().add(btnAniadirEjercicio);
        btnAniadirEjercicio.setBounds(260, 230, 80, 60);

        jScrollPane1.setViewportView(jlstEjerciciosSeleccionados);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(370, 230, 190, 170);

        cmbComboEntrenos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbComboEntrenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbComboEntrenosActionPerformed(evt);
            }
        });
        getContentPane().add(cmbComboEntrenos);
        cmbComboEntrenos.setBounds(40, 50, 390, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
       
        var ejercicios=DataAccess.getAllExercicis();
        
        DefaultComboBoxModel dcbm=new DefaultComboBoxModel();
        
        cmbComboEntrenos.setModel(dcbm);
        
        for(Exercici e:ejercicios){
            cmbComboEntrenos.addItem(e.toString());
        
        }
              
    }//GEN-LAST:event_formWindowOpened

    private void cmbComboEntrenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbComboEntrenosActionPerformed
        
         String seleccion=cmbComboEntrenos.getSelectedItem().toString();
        txtEntrenoSeleccionado.setText(seleccion);
         
        
    }//GEN-LAST:event_cmbComboEntrenosActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAniadirEjercicio;
    private javax.swing.JComboBox<String> cmbComboEntrenos;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> jlstEjerciciosSeleccionados;
    private javax.swing.JTextField txtEntrenoSeleccionado;
    // End of variables declaration//GEN-END:variables
}
