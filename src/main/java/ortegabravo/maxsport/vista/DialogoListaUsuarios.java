package ortegabravo.maxsport.vista;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import ortegabravo.maxsport.accesoDatos.DataAccess;
import ortegabravo.maxsport.accesoDatos.UsuariosTableModel;
import ortegabravo.maxsport.modelo.Usuari;
import static ortegabravo.maxsport.vista.MODO.CLARO;
import static ortegabravo.maxsport.vista.MODO.OSCURO;

/**
 * Clase que representa el diálogo para listar usuarios en el sistema.
 */
public class DialogoListaUsuarios extends javax.swing.JDialog {

    /**
     * Constructor del diálogo de lista de usuarios.
     *
     * @param parent el marco padre del diálogo
     * @param modal indica si el diálogo debe ser modal
     * @param modo el modo de visualización (claro u oscuro)
     */
    public DialogoListaUsuarios(java.awt.Frame parent, boolean modal, MODO modo) {
        super(parent, modal);
        modoVentana(modo);
        initComponents();
//        cargaListaConObjetos();
        setSize(440, 350);
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
    /**
     * Establece el modo de visualización de la ventana (claro u oscuro).
     *
     * @param modo el modo de visualización
     */
    private void modoVentana(MODO modo) {

        switch (modo) {
            case CLARO -> {
                try {
                    UIManager.setLookAndFeel(new FlatLightLaf());
                    SwingUtilities.updateComponentTreeUI(this);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

            case OSCURO -> {
                try {
                    UIManager.setLookAndFeel(new FlatMacDarkLaf());
                    SwingUtilities.updateComponentTreeUI(this);
                } catch (UnsupportedLookAndFeelException ex) {
                    Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }

    /**
     * Carga la tabla de usuarios en la interfaz.
     */
    private void cargaComboUsuarios() {

        ArrayList<Usuari> misUsuarios = DataAccess.getAllUsers();
        UsuariosTableModel utm = new UsuariosTableModel(misUsuarios);
        tblTablaUsuarios.setModel(utm);
        tblTablaUsuarios.setAutoCreateRowSorter(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblTablaUsuarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(453, 350));
        setResizable(false);
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
        jScrollPane1.setViewportView(tblTablaUsuarios);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 20, 420, 270);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblTablaUsuarios;
    // End of variables declaration//GEN-END:variables
}
