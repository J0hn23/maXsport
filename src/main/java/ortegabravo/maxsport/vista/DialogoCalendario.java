package ortegabravo.maxsport.vista;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import net.ortegabravo.calendarioentrenosbeans.MiEventoDiaSeleccionado;
import net.ortegabravo.calendarioentrenosbeans.MiEventoInterfaceRecogerArrayEntrenosListener;
import static ortegabravo.maxsport.vista.MODO.CLARO;
import static ortegabravo.maxsport.vista.MODO.OSCURO;

/**
 *
 * Clase que representa un diálogo en la aplicación con un calendario de
 * entrenos por entrenadsor.
 * @author Jonathan M.Ortega Bravo
 * @since 2024-10-24
 */
public class DialogoCalendario extends javax.swing.JDialog implements MiEventoInterfaceRecogerArrayEntrenosListener {

    JList<String> lstEjercicios;

    /**
     * Constructor del diálogo de calendario.
     *
     * @param parent el marco padre del diálogo
     * @param modal indica si el diálogo debe ser modal
     * @param idInstructor el ID del instructor
     * @param modo el modo de visualización (claro u oscuro)
     */
    public DialogoCalendario(java.awt.Frame parent, boolean modal, int idInstructor, MODO modo) {
        super(parent, modal);
        modoVentana(modo);
        initComponents();

        calendarioEntrenosBeans1.addRecogerArrayEntrenosListener(this);

        colocaLista();

    }

    /**
     * Establece el modo de visualización de la ventana (claro u oscuro). metodo
     * que cambia de un modo claro a oscuro segun una clase enumerada creada en
     * framePrincipal
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
     * Coloca la lista de ejercicios en la interfaz.
     */
    public void colocaLista() {

        JScrollPane jScrollPane3 = new javax.swing.JScrollPane();
        lstEjercicios = new javax.swing.JList<>();
        jScrollPane3.setViewportView(lstEjercicios);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(10, 290, 556, 200);

    }

    /**
     * Carga la lista con los objetos proporcionados.
     *
     * @param a la lista de objetos a mostrar
     */
    private void cargaListaConObjetos(ArrayList<String> a) {

        System.out.println("esta en cargarlistaobjetos tiene de size=" + a.size());

        DefaultListModel<String> dlm = new DefaultListModel();

        if (a != null) {

            if (!a.isEmpty()) {

                for (String e : a) {
                    dlm.addElement(e);
                }
            } else {
                dlm.addElement("Sin entrenos");
            }
        }
        lstEjercicios.setModel(dlm);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        calendarioEntrenosBeans1 = new net.ortegabravo.calendarioentrenosbeans.CalendarioEntrenosBeans();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(590, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(590, 600));
        getContentPane().setLayout(null);
        getContentPane().add(calendarioEntrenosBeans1);
        calendarioEntrenosBeans1.setBounds(10, 10, 564, 280);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private net.ortegabravo.calendarioentrenosbeans.CalendarioEntrenosBeans calendarioEntrenosBeans1;
    // End of variables declaration//GEN-END:variables

    /**
     * Método que se llama al recibir un evento con un array de entrenamientos.
     *
     * @param e el evento que contiene el array de entrenamientos
     */
    @Override
    public void recogerArrayEntrenos(MiEventoDiaSeleccionado e) {

        cargaListaConObjetos(e.getEfu());

    }
}
