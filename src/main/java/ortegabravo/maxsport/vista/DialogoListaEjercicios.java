package ortegabravo.maxsport.vista;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import ortegabravo.maxsport.accesoDatos.DataAccess;
import ortegabravo.maxsport.modelo.Exercici;
import static ortegabravo.maxsport.vista.MODO.CLARO;
import static ortegabravo.maxsport.vista.MODO.OSCURO;

/**
 * Clase que representa el diálogo para listar ejercicios en el sistema.
 */
public class DialogoListaEjercicios extends javax.swing.JDialog {

    private ArrayList<Exercici> exercicis;

    /**
     * Constructor del diálogo de lista de ejercicios.
     *
     * @param parent el marco padre del diálogo
     * @param modal indica si el diálogo debe ser modal
     * @param modo el modo de visualización (claro u oscuro)
     */
    public DialogoListaEjercicios(java.awt.Frame parent, boolean modal, MODO modo) {
        super(parent, modal);
        modoVentana(modo);
        initComponents();
        setLocationRelativeTo(parent);
        setSize(300, 400);
        System.out.println(modo);

        cargaListaConObjetos();

    }

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
     * Carga la lista de ejercicios en la interfaz.
     */
    private void cargaListaConObjetos() {

        exercicis = DataAccess.getAllExercicis();
        DefaultListModel<String> dlm = new DefaultListModel();

        for (Exercici e : exercicis) {
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

    /**
     * Sale de la ventana
     */
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
