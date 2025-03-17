package ortegabravo.maxsport.vista;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import ortegabravo.maxsport.accesoDatos.DataAccess;
import ortegabravo.maxsport.modelo.Exercici;
import ortegabravo.maxsport.modelo.Usuari;
import ortegabravo.maxsport.modelo.Workout;
import static ortegabravo.maxsport.vista.MODO.CLARO;
import static ortegabravo.maxsport.vista.MODO.OSCURO;

/**
 *
 * Clase que representa un diálogo en la aplicación para crear entrenos con
 * ejercicios.
 */
public class DialogoCrearEntrenoConEjercicios extends javax.swing.JDialog {

    private javax.swing.JComboBox<Exercici> cmbComboObject;
    String valor = "";
    ArrayList<Exercici> listaEjerciciosSeleccionados = new ArrayList<>();

    /**
     * Constructor del diálogo para crear entrenamientos con ejercicios.
     *
     * @param parent el marco padre del diálogo
     * @param modal indica si el diálogo debe ser modal
     * @param modo el modo de visualización (claro u oscuro)
     */
    public DialogoCrearEntrenoConEjercicios(java.awt.Frame parent, boolean modal, MODO modo) {
        super(parent, modal);
        modoVentana(modo);
        initComponents();
        setLocationRelativeTo(parent);

        //setSize(450, 600);
        cargarComboEjercicios();

    }

    /**
     * Carga el combo box con los ejercicios.
     */
    private void cargarComboEjercicios() {
        cmbComboObject = new javax.swing.JComboBox<>();
        getContentPane().add(cmbComboObject);
        cmbComboObject.setBounds(20, 230, 370, 30);

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
     * Busca el ID del último usuario registrado.
     *
     * @return el ID del último usuario
     */
    private int buscarIdUltimoUsuario() {

        ArrayList<Usuari> usuarios = DataAccess.getAllUsers();

        int idUltimoUsuario = usuarios.getLast().getId();

        return idUltimoUsuario;
    }

    /**
     * Añade un entrenamiento con los ejercicios seleccionados.
     *
     * @param exercicis la lista de ejercicios a añadir
     * @return 1 si el entrenamiento se añadió correctamente, 0 en caso
     * contrario
     */
    public int aniadirEntreno(ArrayList<Exercici> exercicis) {

        Workout w = new Workout();

        String s = txtId.getText();

        if (s.equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Debe introducir un número de usuario");
        } else if (Integer.parseInt(s) > buscarIdUltimoUsuario() || Integer.parseInt(s) <= buscarIdUltimoUsuario()) {
            w.setIdUsuari(Integer.parseInt(txtId.getText()));
            w.setComments(txtComentaio.getText());
            w.setForDate((Date) spnFechaEntreno.getValue());
            try {
                DataAccess.insertWorkout(w, exercicis);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Error al añadir entreno.No existe el usuario");
            }

            JOptionPane.showMessageDialog(rootPane, "Entreno añadido");
            return 1;
        } else {
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
        jScrollPane1 = new javax.swing.JScrollPane();
        txaEjerciciosSeleccionados = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        btnAniadirejercicio = new javax.swing.JButton();
        cmbNombreUsuario = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(51, 51, 51));
        setMinimumSize(new java.awt.Dimension(415, 560));
        setPreferredSize(new java.awt.Dimension(415, 560));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Likhan", 2, 24)); // NOI18N
        jLabel1.setText("  Crear nuevo entreno");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(78, 20, 240, 30);

        lblFechaEntreno.setText("Fecha");
        getContentPane().add(lblFechaEntreno);
        lblFechaEntreno.setBounds(30, 60, 31, 16);

        spnFechaEntreno.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), new java.util.Date(), null, java.util.Calendar.DAY_OF_MONTH));
        getContentPane().add(spnFechaEntreno);
        spnFechaEntreno.setBounds(130, 60, 260, 22);

        jLabel2.setText("Id Usuario");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 110, 80, 16);

        txtId.setEditable(false);
        txtId.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIdKeyTyped(evt);
            }
        });
        getContentPane().add(txtId);
        txtId.setBounds(130, 100, 64, 30);

        jLabel3.setText("Comentario");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 160, 80, 16);
        getContentPane().add(txtComentaio);
        txtComentaio.setBounds(130, 154, 260, 30);

        txaEjerciciosSeleccionados.setColumns(20);
        txaEjerciciosSeleccionados.setRows(5);
        jScrollPane1.setViewportView(txaEjerciciosSeleccionados);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(10, 346, 380, 110);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(20, 210, 360, 30);

        btnAniadirejercicio.setText("Añadir Ejercicio");
        btnAniadirejercicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAniadirejercicioActionPerformed(evt);
            }
        });
        getContentPane().add(btnAniadirejercicio);
        btnAniadirejercicio.setBounds(130, 470, 140, 30);

        getContentPane().add(cmbNombreUsuario);
        cmbNombreUsuario.setBounds(210, 100, 180, 30);

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

        cargaComboNombreUsuario();


    }//GEN-LAST:event_formWindowOpened

    private void cargaComboNombreUsuario() {

        var usuarios = DataAccess.getAllUsers();
        DefaultComboBoxModel dcbmUsuarios = new DefaultComboBoxModel();
        cmbNombreUsuario.setModel(dcbmUsuarios);

        for (Usuari u : usuarios) {

            cmbNombreUsuario.addItem(u.getNom());

        }

        cmbNombreUsuario.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbNombreUsuarioActionPerformed(evt);
            }

            private void cmbNombreUsuarioActionPerformed(ActionEvent evt) {

                String nombre = (String) cmbNombreUsuario.getSelectedItem();
                int id = 0;

                for (Usuari u : usuarios) {
                    if (u.getNom().equals(nombre)) {
                        id = u.getId();
                    }

                }

                txtId.setText(String.valueOf(id));
            }

        });

    }


    private void btnAniadirejercicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAniadirejercicioActionPerformed

        int realizado = aniadirEntreno(listaEjerciciosSeleccionados);

        if (realizado == 1) {
            setVisible(false);
        }

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
    private javax.swing.JComboBox<String> cmbNombreUsuario;
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
