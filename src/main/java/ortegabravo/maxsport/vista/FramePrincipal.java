package ortegabravo.maxsport.vista;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import ortegabravo.maxsport.accesoDatos.DataAccess;
import ortegabravo.maxsport.accesoDatos.UsuariosTableModel;
import ortegabravo.maxsport.modelo.Usuari;
import static ortegabravo.maxsport.vista.MODO.CLARO;
import static ortegabravo.maxsport.vista.MODO.OSCURO;

/**
 * Clase que representa la ventana principal de la aplicación.
 */
public class FramePrincipal extends javax.swing.JFrame {

    private JDialog dlgDialogoLogin;
    private ArrayList<Usuari> usuaris;
    private Connection conexion;
    private byte[] imagenByte;
    private DialogoAbout da;
    private DialogoNuevoUsuario dnu;
    private DialogoListaUsuarios dlu;
    private DialogoListaEjercicios dle;
    private DialogoCrearEntrenoConEjercicios dcece;
    private DialogoCalendario dc;
    private DialogoGestionEntrenos dge;
    int idInstructorAsigna;
    MODO modo = MODO.OSCURO;

    /**
     * Constructor de la clase FramePrincipal. Inicializa la interfaz gráfica,
     * configura el modo de visualización y establece las propiedades iniciales.
     */
    public FramePrincipal() {

        modoVentana(modo);
        initComponents();
        configuracionInicio();
        tipTextBotones();
    }

    /**
     * Establece el texto de ayuda para los botones.
     */
    private void tipTextBotones() {

        mnbExit.setToolTipText("Sale de la aplicación");
        lblEtiquetaWeb.setToolTipText("Ir a WWW");
        mnbAbout.setToolTipText("Sobre la aplicación");
        mnbFile.setToolTipText("Menu Archivo");
        btnAsignarEntreno.setToolTipText("Asigna entreno a usuario");
        btnBotonLogin.setToolTipText("Logear");
        btnCalendario.setToolTipText("Calendario de entrenos");
        btnGestionEntrenos.setToolTipText("Gestion de entrenos");
        btnListarEjercicios.setToolTipText("Ejercicios del sistema");
        btnMostrarUsuarios.setToolTipText("Muestra usuarios totales");
        btnNuevoUsuario.setToolTipText("Nuevo usuario");
        btnSignOut.setToolTipText("Desconectar usuario");

    }

    /**
     * Configura las propiedades iniciales de la ventana principal.
     */
    private void configuracionInicio() {

        setTitle("MaXsport");
        setLocationRelativeTo(null);
        setSize(700, 500);
        pnlPanelSecundario.setSize(700, 500);
        pnlPanelSecundario.setVisible(false);

    }

    /**
     * Carga la foto del usuario en la interfaz.
     */
    private void cargarFoto() {

        ImageIcon icon = byteArrayAImagen(imagenByte);
        if (icon != null) {
            Image imagenIcon = icon.getImage();
            Image nuevaImagenEscalada = imagenIcon.getScaledInstance(190, 160, java.awt.Image.SCALE_FAST);
            ImageIcon iconoNuevo = new ImageIcon(nuevaImagenEscalada);
            lblBoligrafo.setIcon(iconoNuevo);
        } else {
            System.out.println("La imagen no pudo ser cargada");
        }
    }

    /**
     * Obtiene la información del usuario a partir de su correo electrónico.
     *
     * @param mail el correo electrónico del usuario
     */
    private void obtenerUsuario(String mail) {

        Usuari usuario = DataAccess.getUser(mail);
        imagenByte = usuario.getFoto();
        System.out.println(usuario.getNom());
        System.out.println(usuario.getFoto());

    }

    /**
     * Convierte un array de bytes en un objeto ImageIcon.
     *
     * @param imagen el array de bytes que representa la imagen
     * @return el objeto ImageIcon creado a partir del array de bytes
     */
    private static ImageIcon byteArrayAImagen(byte[] imagen) {
        try {
            ImageIcon icon = new ImageIcon(imagen);
            return icon;
        } catch (Exception e) {
            System.out.println("No se pudo crear el icono de la foto");
        }
        return null;
    }

    /**
     * Realiza las acciones necesarias después de que un usuario se ha logueado
     * correctamente.
     *
     * @param confirmacion indica si la confirmación fue exitosa
     * @param idEntrenador el ID del entrenador
     * @param mail el correo electrónico del usuario
     */
    public void confirmacionLogin(boolean confirmacion, int idEntrenador, String mail) {
        if (confirmacion) {

            pnlPanelPrincipal.setVisible(false);
            pnlPanelSecundario.setVisible(true);
            cargarUsuariosEnTabla(idEntrenador);
            obtenerUsuario(mail);
            cargarFoto();
            idInstructorAsigna = idEntrenador;

        }

        txtNumeroEntrenador.setText(mail);
    }

    /**
     * Carga la lista de usuarios en la tabla.
     *
     * @param idEntrenador el ID del entrenador
     */
    void cargarUsuariosEnTabla(int idEntrenador) {

        usuaris = DataAccess.getAllUsersByInstructor(idEntrenador);
        UsuariosTableModel utm = new UsuariosTableModel(usuaris);
        tblTablaUsuarios.setModel(utm);
        tblTablaUsuarios.setAutoCreateRowSorter(true);
    }

    /**
     * Establece la conexión a la base de datos.
     *
     * @param conexion el objeto Connection que representa la conexión a la base
     * de datos
     */
    public void enviarConexion(Connection conexion) {
        this.conexion = conexion;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPanelPrincipal = new javax.swing.JPanel();
        btnBotonLogin = new javax.swing.JButton();
        lblEtiquetaLogo = new javax.swing.JLabel();
        lblAccesoWeb = new javax.swing.JLabel();
        pnlPanelSecundario = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblTablaUsuarios = new javax.swing.JTable();
        btnAsignarEntreno = new javax.swing.JButton();
        lblBoligrafo = new javax.swing.JLabel();
        lblLogoPanelSecundario = new javax.swing.JLabel();
        btnSignOut = new javax.swing.JButton();
        btnNuevoUsuario = new javax.swing.JButton();
        lblEtiquetaWeb = new javax.swing.JLabel();
        txtNumeroEntrenador = new javax.swing.JTextField();
        btnListarEjercicios = new javax.swing.JButton();
        btnGestionEntrenos = new javax.swing.JButton();
        btnMostrarUsuarios = new javax.swing.JButton();
        btnCalendario = new javax.swing.JButton();
        jTxtBuscar = new javax.swing.JTextField();
        btnBuscar = new javax.swing.JButton();
        btnCambiaSkin = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        menMenu = new javax.swing.JMenuBar();
        mnbFile = new javax.swing.JMenu();
        mnbExit = new javax.swing.JMenu();
        mnbAbout = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));
        setResizable(false);
        getContentPane().setLayout(null);

        pnlPanelPrincipal.setMinimumSize(new java.awt.Dimension(700, 500));
        pnlPanelPrincipal.setLayout(null);

        btnBotonLogin.setFont(new java.awt.Font("Mukti Narrow", 1, 24)); // NOI18N
        btnBotonLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/down.png"))); // NOI18N
        btnBotonLogin.setText("Entrar");
        btnBotonLogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnBotonLoginMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnBotonLoginMouseExited(evt);
            }
        });
        btnBotonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBotonLoginActionPerformed(evt);
            }
        });
        pnlPanelPrincipal.add(btnBotonLogin);
        btnBotonLogin.setBounds(490, 70, 160, 50);

        lblEtiquetaLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nutricion.png"))); // NOI18N
        pnlPanelPrincipal.add(lblEtiquetaLogo);
        lblEtiquetaLogo.setBounds(10, 0, 550, 520);

        lblAccesoWeb.setText("                     www.maXsport.com");
        lblAccesoWeb.setEnabled(false);
        lblAccesoWeb.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblAccesoWebMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblAccesoWebMouseExited(evt);
            }
        });
        pnlPanelPrincipal.add(lblAccesoWeb);
        lblAccesoWeb.setBounds(260, 510, 340, 40);

        getContentPane().add(pnlPanelPrincipal);
        pnlPanelPrincipal.setBounds(0, 0, 700, 500);

        pnlPanelSecundario.setMinimumSize(new java.awt.Dimension(700, 500));
        pnlPanelSecundario.setName(""); // NOI18N
        pnlPanelSecundario.setPreferredSize(new java.awt.Dimension(700, 430));
        pnlPanelSecundario.setLayout(null);

        tblTablaUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Nombre", "Correo", "Foto"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTablaUsuarios.setGridColor(new java.awt.Color(204, 204, 204));
        tblTablaUsuarios.setSelectionBackground(new java.awt.Color(102, 255, 255));
        tblTablaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblTablaUsuariosMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblTablaUsuarios);

        pnlPanelSecundario.add(jScrollPane1);
        jScrollPane1.setBounds(20, 180, 452, 240);

        btnAsignarEntreno.setFont(new java.awt.Font("Manjari", 0, 12)); // NOI18N
        btnAsignarEntreno.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/crear entreno.png"))); // NOI18N
        btnAsignarEntreno.setText("Crear entreno ");
        btnAsignarEntreno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarEntrenoActionPerformed(evt);
            }
        });
        pnlPanelSecundario.add(btnAsignarEntreno);
        btnAsignarEntreno.setBounds(490, 300, 190, 40);

        lblBoligrafo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        pnlPanelSecundario.add(lblBoligrafo);
        lblBoligrafo.setBounds(20, 10, 190, 160);

        lblLogoPanelSecundario.setFont(new java.awt.Font("Noto Serif CJK JP", 2, 36)); // NOI18N
        lblLogoPanelSecundario.setForeground(new java.awt.Color(0, 51, 51));
        lblLogoPanelSecundario.setText("maXsport");
        pnlPanelSecundario.add(lblLogoPanelSecundario);
        lblLogoPanelSecundario.setBounds(220, 10, 180, 50);

        btnSignOut.setForeground(new java.awt.Color(153, 0, 0));
        btnSignOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exercise_salir.png"))); // NOI18N
        btnSignOut.setText("Sign out");
        btnSignOut.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnSignOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSignOutActionPerformed(evt);
            }
        });
        pnlPanelSecundario.add(btnSignOut);
        btnSignOut.setBounds(490, 30, 190, 40);

        btnNuevoUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nuevo usuario.png"))); // NOI18N
        btnNuevoUsuario.setText("Nuevo usuario");
        btnNuevoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoUsuarioActionPerformed(evt);
            }
        });
        pnlPanelSecundario.add(btnNuevoUsuario);
        btnNuevoUsuario.setBounds(490, 340, 190, 40);

        lblEtiquetaWeb.setText("www.maXsport.com");
        lblEtiquetaWeb.setDisplayedMnemonicIndex(0);
        lblEtiquetaWeb.setEnabled(false);
        lblEtiquetaWeb.setFocusable(false);
        pnlPanelSecundario.add(lblEtiquetaWeb);
        lblEtiquetaWeb.setBounds(220, 60, 180, 20);

        txtNumeroEntrenador.setFont(new java.awt.Font("Noto Sans CJK SC", 1, 18)); // NOI18N
        txtNumeroEntrenador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumeroEntrenador.setEnabled(false);
        txtNumeroEntrenador.setSelectionColor(new java.awt.Color(0, 0, 0));
        pnlPanelSecundario.add(txtNumeroEntrenador);
        txtNumeroEntrenador.setBounds(490, 80, 190, 30);

        btnListarEjercicios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/persona-pilates.png"))); // NOI18N
        btnListarEjercicios.setText("Mostrar ejercicios ");
        btnListarEjercicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarEjerciciosActionPerformed(evt);
            }
        });
        pnlPanelSecundario.add(btnListarEjercicios);
        btnListarEjercicios.setBounds(490, 220, 190, 40);

        btnGestionEntrenos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/gestion entrenos.png"))); // NOI18N
        btnGestionEntrenos.setText("Gestion entrenos");
        btnGestionEntrenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionEntrenosActionPerformed(evt);
            }
        });
        pnlPanelSecundario.add(btnGestionEntrenos);
        btnGestionEntrenos.setBounds(490, 380, 190, 40);

        btnMostrarUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/usuario.png"))); // NOI18N
        btnMostrarUsuarios.setText("Mostrar usuarios");
        btnMostrarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarUsuariosActionPerformed(evt);
            }
        });
        pnlPanelSecundario.add(btnMostrarUsuarios);
        btnMostrarUsuarios.setBounds(490, 260, 190, 40);

        btnCalendario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/calendario.png"))); // NOI18N
        btnCalendario.setText("Calendario");
        btnCalendario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCalendarioActionPerformed(evt);
            }
        });
        pnlPanelSecundario.add(btnCalendario);
        btnCalendario.setBounds(490, 180, 190, 40);
        pnlPanelSecundario.add(jTxtBuscar);
        jTxtBuscar.setBounds(20, 420, 140, 30);

        btnBuscar.setText("Buscar");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });
        pnlPanelSecundario.add(btnBuscar);
        btnBuscar.setBounds(160, 420, 72, 30);

        btnCambiaSkin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiaSkinActionPerformed(evt);
            }
        });
        pnlPanelSecundario.add(btnCambiaSkin);
        btnCambiaSkin.setBounds(650, 420, 30, 23);

        jLabel1.setText("Cambia Skin");
        pnlPanelSecundario.add(jLabel1);
        jLabel1.setBounds(570, 420, 70, 20);

        getContentPane().add(pnlPanelSecundario);
        pnlPanelSecundario.setBounds(0, 0, 700, 500);

        menMenu.setBackground(new java.awt.Color(153, 153, 153));
        menMenu.setEnabled(false);

        mnbFile.setText("File");
        menMenu.add(mnbFile);

        mnbExit.setText("Exit");
        mnbExit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mnbExitMouseClicked(evt);
            }
        });
        menMenu.add(mnbExit);

        mnbAbout.setText("About");
        mnbAbout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mnbAboutMousePressed(evt);
            }
        });
        menMenu.add(mnbAbout);

        setJMenuBar(menMenu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Acción realizada al presionar el botón de login. Abre el diálogo de
     * login.
     *
     * @param evt el evento de acción que desencadena este método
     */
    private void btnBotonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBotonLoginActionPerformed
        //es el actionperformed del boton de login que abre el jdialog login
        dlgDialogoLogin = new DialogoLogin(this, true);
        dlgDialogoLogin.setSize(300, 400);
        dlgDialogoLogin.setVisible(true);


    }//GEN-LAST:event_btnBotonLoginActionPerformed
    /**
     * Acción realizada al presionar el botón de cerrar sesión. Cierra la
     * conexión del usuario y vuelve al panel principal.
     *
     * @param evt el evento de acción que desencadena este método
     */
    private void btnSignOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSignOutActionPerformed

        //este boton cierra la getconection del usuario y la jpanel
        try {
            conexion.close();
            JOptionPane.showMessageDialog(rootPane, "Usuario desconectado");
        } catch (SQLException ex) {
            Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        pnlPanelSecundario.setVisible(false);
        pnlPanelPrincipal.setVisible(true);

    }//GEN-LAST:event_btnSignOutActionPerformed
    /**
     * Acción realizada al hacer clic en el menú de salida. Cierra la
     * aplicación.
     *
     * @param evt el evento de acción que desencadena este método
     */
    private void mnbExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnbExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_mnbExitMouseClicked
    /**
     * Acción realizada al presionar el menú "Acerca de". Abre el diálogo
     * "Acerca de".
     *
     * @param evt el evento de acción que desencadena este método
     */
    private void mnbAboutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnbAboutMousePressed
        da = new DialogoAbout(this, true, modo);
        JComponent contenedor = (JComponent) da.getContentPane();
        //contenedor.setBackground(new Color(150, 150, 150));
        da.setVisible(true);
    }//GEN-LAST:event_mnbAboutMousePressed
    /**
     * Acción realizada al presionar el botón de "Nuevo Usuario". Abre el
     * diálogo para crear un nuevo usuario.
     *
     * @param evt el evento de acción que desencadena este método
     */
    private void btnNuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoUsuarioActionPerformed

        dnu = new DialogoNuevoUsuario(this, true, idInstructorAsigna, this, modo);
        JComponent contenedor = (JComponent) dnu.getContentPane();
        //contenedor.setBackground(new Color(150, 150, 150));
        dnu.setVisible(true);

    }//GEN-LAST:event_btnNuevoUsuarioActionPerformed
    /**
     * Acción realizada al presionar el botón "Asignar Entreno". Abre el diálogo
     * para crear un nuevo entreno con ejercicios.
     *
     * @param evt el evento de acción que desencadena este método
     */
    private void btnAsignarEntrenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarEntrenoActionPerformed
        //daeae=new DialogoAsignarEjerciciosAEntreno(this,false);
        //daeae.setVisible(true);
        dcece = new DialogoCrearEntrenoConEjercicios(this, true, modo);
        JComponent contenedor = (JComponent) dcece.getContentPane();
        //contenedor.setBackground(new Color(150, 150, 150));
        dcece.setVisible(true);

    }//GEN-LAST:event_btnAsignarEntrenoActionPerformed
    /**
     * Acción realizada al presionar el botón "Mostrar Ejercicios". Abre el
     * diálogo para listar los ejercicios.
     *
     * @param evt el evento de acción que desencadena este método
     */
    private void btnListarEjerciciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarEjerciciosActionPerformed
        dle = new DialogoListaEjercicios(this, true, modo);
        dle.setVisible(true);
    }//GEN-LAST:event_btnListarEjerciciosActionPerformed
    /**
     * Acción realizada al presionar el botón "Gestión Entrenos". Abre el
     * diálogo para gestionar los entrenamientos.
     *
     * @param evt el evento de acción que desencadena este método
     */
    private void btnGestionEntrenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionEntrenosActionPerformed
//        JOptionPane.showMessageDialog(rootPane, "En construcción");

        dge = new DialogoGestionEntrenos(this, true, idInstructorAsigna, modo);
        dge.setVisible(true);


    }//GEN-LAST:event_btnGestionEntrenosActionPerformed
    /**
     * Acción realizada al presionar el botón "Mostrar Usuarios". Abre el
     * diálogo para listar los usuarios.
     *
     * @param evt el evento de acción que desencadena este método
     */
    private void btnMostrarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarUsuariosActionPerformed
        dlu = new DialogoListaUsuarios(this, true, modo);
        dlu.setVisible(true);

    }//GEN-LAST:event_btnMostrarUsuariosActionPerformed
    /**
     * Acción realizada al presionar el botón "Calendario". Abre el diálogo del
     * calendario.
     *
     * @param evt el evento de acción que desencadena este método
     */
    private void btnCalendarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalendarioActionPerformed

        dc = new DialogoCalendario(this, true, idInstructorAsigna, modo);
        dc.setVisible(true);


    }//GEN-LAST:event_btnCalendarioActionPerformed
    /**
     * Cambia el cursor al pasar el ratón por encima del botón de login.
     *
     * @param evt el evento de ratón que desencadena este método
     */
    private void btnBotonLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBotonLoginMouseEntered

        btnBotonLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnBotonLoginMouseEntered
    /**
     * Restablece el cursor al salir el ratón del botón de login.
     *
     * @param evt el evento de ratón que desencadena este método
     */
    private void btnBotonLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBotonLoginMouseExited

        btnBotonLogin.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnBotonLoginMouseExited

    /**
     * Cambia el cursor al pasar el ratón por encima de la etiqueta web.
     *
     * @param evt el evento de ratón que desencadena este método
     */
    private void lblAccesoWebMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAccesoWebMouseEntered

        lblEtiquetaWeb.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_lblAccesoWebMouseEntered
    /**
     * Restablece el cursor al salir el ratón de la etiqueta web.
     *
     * @param evt el evento de ratón que desencadena este método
     */
    private void lblAccesoWebMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAccesoWebMouseExited

        lblEtiquetaWeb.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_lblAccesoWebMouseExited

    /**
     * Acción realizada al presionar el botón "Buscar". Busca un usuario por
     * nombre.
     *
     * @param evt el evento de acción que desencadena este método
     */
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        String nombre = jTxtBuscar.getText();
        buscarNombre(nombre);


    }//GEN-LAST:event_btnBuscarActionPerformed
    /**
     * Acción realizada al presionar el botón para cambiar el tema visual.
     * Cambia entre el tema claro y oscuro.
     *
     * @param evt el evento de acción que desencadena este método
     */
    private void btnCambiaSkinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiaSkinActionPerformed
        if (modo == modo.OSCURO) {
            modo = modo.CLARO;
        } else if (modo == modo.CLARO) {
            modo = modo.OSCURO;
        }
        modoVentana(modo);
        System.out.println("en action performes de skinf:" + modo);
    }//GEN-LAST:event_btnCambiaSkinActionPerformed
    /**
     * Acción realizada al presionar el ratón sobre una fila de la tabla de
     * usuarios. Abre un diálogo con los entrenamientos del usuario
     * seleccionado.
     *
     * @param evt el evento de ratón que desencadena este método
     */
    private void tblTablaUsuariosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTablaUsuariosMousePressed
        //creo un evento mouseclicked en la tabla
        //el evento evt con el metodo getpoint me da el punto de la fila donde 
        //clikeo y el numero de la fila
        int fila = tblTablaUsuarios.rowAtPoint(evt.getPoint());

        //int id=Integer.parseInt(tblTablaUsuarios.getValueAt(fila, 0).toString());
        //con el in de la fila obtengo los datos que quiera de la tabla
        String nombre = (String) tblTablaUsuarios.getValueAt(fila, 1);
        String correoAlumno = tblTablaUsuarios.getValueAt(fila, 2).toString();

        //le paso al dialog el id y alli hago el resultset, y le mando como parametros
        //correo y nombre para usarlos alli, en el nuevo jdialog
        DialogoEntrenamientos de = new DialogoEntrenamientos(this, true, correoAlumno, nombre, modo);
        de.setSize(500, 400);
        de.setBackground(new Color(150, 150, 150));
        de.setLocationRelativeTo(null);
        de.setVisible(true);
    }//GEN-LAST:event_tblTablaUsuariosMousePressed
    /**
     * Busca un usuario por nombre y muestra su información.
     *
     * @param nombre el nombre del usuario a buscar
     */
    private void buscarNombre(String nombre) {

        Usuari usuario = null;

        usuario = DataAccess.getUserNom(nombre);

        if (usuario != null) {

            String nom = usuario.getNom();
            String correo = usuario.getEmail();
            int numId = usuario.getId();
            JOptionPane.showMessageDialog(rootPane, "El usuaio " + nom + " con correo " + correo + " está entre tus usuarios con el id " + numId);

        } else {
            JOptionPane.showMessageDialog(rootPane, "El usuario no esta entre tus usuarios");
        }

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsignarEntreno;
    private javax.swing.JButton btnBotonLogin;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCalendario;
    private javax.swing.JButton btnCambiaSkin;
    private javax.swing.JButton btnGestionEntrenos;
    private javax.swing.JButton btnListarEjercicios;
    private javax.swing.JButton btnMostrarUsuarios;
    private javax.swing.JButton btnNuevoUsuario;
    private javax.swing.JButton btnSignOut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTxtBuscar;
    private javax.swing.JLabel lblAccesoWeb;
    private javax.swing.JLabel lblBoligrafo;
    private javax.swing.JLabel lblEtiquetaLogo;
    private javax.swing.JLabel lblEtiquetaWeb;
    private javax.swing.JLabel lblLogoPanelSecundario;
    private javax.swing.JMenuBar menMenu;
    private javax.swing.JMenu mnbAbout;
    private javax.swing.JMenu mnbExit;
    private javax.swing.JMenu mnbFile;
    private javax.swing.JPanel pnlPanelPrincipal;
    private javax.swing.JPanel pnlPanelSecundario;
    private javax.swing.JTable tblTablaUsuarios;
    private javax.swing.JTextField txtNumeroEntrenador;
    // End of variables declaration//GEN-END:variables

}

enum MODO {
    CLARO,
    OSCURO,
}
