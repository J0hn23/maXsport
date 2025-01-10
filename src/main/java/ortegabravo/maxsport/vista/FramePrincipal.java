package ortegabravo.maxsport.vista;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.awt.BorderLayout;
import com.bulenkov.darcula.DarculaLaf;
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
import static javax.swing.JOptionPane.YES_OPTION;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import net.miginfocom.swing.MigLayout;
import ortegabravo.maxsport.accesoDatos.DataAccess;
import ortegabravo.maxsport.accesoDatos.UsuariosTableModel;
import ortegabravo.maxsport.modelo.Usuari;

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
    MODO modo=MODO.OSCURO ;
    
    public FramePrincipal() {

//         UIManager.setLookAndFeel(new FlatDarkLaf());
//            //UIManager.setLookAndFeel(new FlatLightLaf());


          

//        try {
//
//            UIManager.setLookAndFeel(new FlatMacDarkLaf());
//            // SwingUtilities.updateComponentTreeUI(this);
//        } catch (UnsupportedLookAndFeelException ex) {
//            Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
//        }


//        EleccionModo();
        modoVentana(modo);
        
        
        initComponents();
        configuracionInicio();
        tipTextBotones();
          
          
    }

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

    private void configuracionInicio() {

       
        setTitle("MaXsport");
        setLocationRelativeTo(null);
        setSize(700, 500);
        pnlPanelSecundario.setSize(700, 500);
        pnlPanelSecundario.setVisible(false);

    }

//     private void EleccionModo(){
//        if(modo==MODO.OSCURO){
//            try {
//                UIManager.setLookAndFeel(new FlatDarkLaf());
//            } catch (UnsupportedLookAndFeelException ex) {
//                Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }else{
//            try {
//                UIManager.setLookAndFeel(new FlatLightLaf());
//            } catch (UnsupportedLookAndFeelException ex) {
//                Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            }
//        }
    
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

    private void obtenerUsuario(String mail) {

        Usuari usuario = DataAccess.getUser(mail);
        imagenByte = usuario.getFoto();
        System.out.println(usuario.getNom());
        System.out.println(usuario.getFoto());

    }

    private static ImageIcon byteArrayAImagen(byte[] imagen) {
        try {
            ImageIcon icon = new ImageIcon(imagen);
            return icon;
        } catch (Exception e) {
            System.out.println("No se pudo crear el icono de la foto");
        }
        return null;
    }

//
//    public void confirmacionLogin(boolean confirmacion, int idEntrenador, String mail) {
//   
//        //si devuelve confirmacion como true entonces cierra el jpanel principal
//        //y abre el secundario con la jtable cargada
//        if (confirmacion) {
//            pnlPanelPrincipal.setVisible(false);
//
//            usuaris = new ArrayList<>();
//            usuaris = DataAccess.getAllUsersByInstructor(idEntrenador);
//            //carga la tabla
//            UsuariosTableModel utm = new UsuariosTableModel(usuaris);
//            tblTablaUsuarios.setModel(utm);
//            tblTablaUsuarios.setAutoCreateRowSorter(true);
//
//            pnlPanelSecundario.setVisible(true);
//            obtenerUsuario(mail);
//            cargarFoto();
//
//        }
//        txtNumeroEntrenador.setText(String.valueOf(idEntrenador));
//    }
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

    void cargarUsuariosEnTabla(int idEntrenador) {

        usuaris = DataAccess.getAllUsersByInstructor(idEntrenador);
        UsuariosTableModel utm = new UsuariosTableModel(usuaris);
        tblTablaUsuarios.setModel(utm);
        tblTablaUsuarios.setAutoCreateRowSorter(true);
    }

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
        menMenu = new javax.swing.JMenuBar();
        mnbFile = new javax.swing.JMenu();
        mnbExit = new javax.swing.JMenu();
        mnbAbout = new javax.swing.JMenu();
        jmnPinkSkin = new javax.swing.JMenu();

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
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTablaUsuariosMouseClicked(evt);
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

        jmnPinkSkin.setText("Pink skin");
        jmnPinkSkin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmnPinkSkinActionPerformed(evt);
            }
        });
        menMenu.add(jmnPinkSkin);

        setJMenuBar(menMenu);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnBotonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBotonLoginActionPerformed
        //es el actionperformed del boton de login que abre el jdialog login
        dlgDialogoLogin = new DialogoLogin(this, true);
        dlgDialogoLogin.setSize(300, 400);
        dlgDialogoLogin.setVisible(true);


    }//GEN-LAST:event_btnBotonLoginActionPerformed

    private void tblTablaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTablaUsuariosMouseClicked

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
        DialogoEntrenamientos de = new DialogoEntrenamientos(this, true, correoAlumno, nombre);
        de.setSize(500, 400);
        de.setBackground(new Color(150, 150, 150));
        de.setLocationRelativeTo(null);
        de.setVisible(true);

    }//GEN-LAST:event_tblTablaUsuariosMouseClicked

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

    private void mnbExitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnbExitMouseClicked
        System.exit(0);
    }//GEN-LAST:event_mnbExitMouseClicked

    private void mnbAboutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mnbAboutMousePressed
        da = new DialogoAbout(this, true);
        JComponent contenedor = (JComponent) da.getContentPane();
        //contenedor.setBackground(new Color(150, 150, 150));
        da.setVisible(true);
    }//GEN-LAST:event_mnbAboutMousePressed

    private void btnNuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoUsuarioActionPerformed

        dnu = new DialogoNuevoUsuario(this, true, idInstructorAsigna, this);
        JComponent contenedor = (JComponent) dnu.getContentPane();
        //contenedor.setBackground(new Color(150, 150, 150));
        dnu.setVisible(true);

    }//GEN-LAST:event_btnNuevoUsuarioActionPerformed

    private void btnAsignarEntrenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarEntrenoActionPerformed
        //daeae=new DialogoAsignarEjerciciosAEntreno(this,false);
        //daeae.setVisible(true);
        dcece = new DialogoCrearEntrenoConEjercicios(this, true);
        JComponent contenedor = (JComponent) dcece.getContentPane();
        //contenedor.setBackground(new Color(150, 150, 150));
        dcece.setVisible(true);

    }//GEN-LAST:event_btnAsignarEntrenoActionPerformed

    private void btnListarEjerciciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarEjerciciosActionPerformed
        dle = new DialogoListaEjercicios(this, true);
        dle.setVisible(true);
    }//GEN-LAST:event_btnListarEjerciciosActionPerformed

    private void btnGestionEntrenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionEntrenosActionPerformed
//        JOptionPane.showMessageDialog(rootPane, "En construcción");

        dge = new DialogoGestionEntrenos(this, true, idInstructorAsigna);
        dge.setVisible(true);


    }//GEN-LAST:event_btnGestionEntrenosActionPerformed

    private void btnMostrarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarUsuariosActionPerformed
        dlu = new DialogoListaUsuarios(this, true);
        dlu.setVisible(true);

    }//GEN-LAST:event_btnMostrarUsuariosActionPerformed

    private void btnCalendarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCalendarioActionPerformed

        dc = new DialogoCalendario(this, true, idInstructorAsigna);
        dc.setVisible(true);


    }//GEN-LAST:event_btnCalendarioActionPerformed

    private void btnBotonLoginMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBotonLoginMouseEntered

        btnBotonLogin.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_btnBotonLoginMouseEntered

    private void btnBotonLoginMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBotonLoginMouseExited

        btnBotonLogin.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_btnBotonLoginMouseExited

    private void lblAccesoWebMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAccesoWebMouseEntered

        lblEtiquetaWeb.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }//GEN-LAST:event_lblAccesoWebMouseEntered

    private void lblAccesoWebMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblAccesoWebMouseExited

        lblEtiquetaWeb.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }//GEN-LAST:event_lblAccesoWebMouseExited

    private void jmnPinkSkinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmnPinkSkinActionPerformed
       

    }//GEN-LAST:event_jmnPinkSkinActionPerformed

   
    
    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed

        String nombre = jTxtBuscar.getText();
        buscarNombre(nombre);


    }//GEN-LAST:event_btnBuscarActionPerformed

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

   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsignarEntreno;
    private javax.swing.JButton btnBotonLogin;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCalendario;
    private javax.swing.JButton btnGestionEntrenos;
    private javax.swing.JButton btnListarEjercicios;
    private javax.swing.JButton btnMostrarUsuarios;
    private javax.swing.JButton btnNuevoUsuario;
    private javax.swing.JButton btnSignOut;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTxtBuscar;
    private javax.swing.JMenu jmnPinkSkin;
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

    
    private void modoVentana(MODO modo){
    
        switch (modo) {
            case    CLARO ->    {
                            try {
                                UIManager.setLookAndFeel(new FlatLightLaf())  ;
                            } catch (UnsupportedLookAndFeelException ex) {
                                Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

            case OSCURO ->  {
                            try {
                                UIManager.setLookAndFeel(new FlatMacDarkLaf())  ;
                            } catch (UnsupportedLookAndFeelException ex) {
                                Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
 
        }
    }   
}

enum MODO {
    CLARO,
    OSCURO,
}
