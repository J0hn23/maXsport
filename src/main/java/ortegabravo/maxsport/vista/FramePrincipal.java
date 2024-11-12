package ortegabravo.maxsport.vista;

import java.awt.Color;
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
import javax.swing.table.AbstractTableModel;
import ortegabravo.maxsport.accesoDatos.DataAccess;
import ortegabravo.maxsport.accesoDatos.UsuariosTableModel;
import ortegabravo.maxsport.modelo.Usuari;

public class FramePrincipal extends javax.swing.JFrame {

    JDialog dlgDialogoLogin;
    ArrayList<Usuari> usuaris;
    private Connection conexion;
    byte[] imagenByte;
    DialogoAbout da;
    DialogoNuevoUsuario dnu;
    DialogoListaUsuarios dlu;
    DialogoListaEjercicios dle;  
    DialogoCrearEntrenoConEjercicios dcece;

    public FramePrincipal() {

        initComponents();

        setTitle("MaXsport");
        setLocationRelativeTo(null);
        setSize(900, 600);
        pnlPanelSecundario.setSize(900, 600);
        pnlPanelSecundario.setVisible(false);

    }

    private void cargarFoto() {

        ImageIcon icon = byteArrayAImagen(imagenByte);
        Image imagenIcon = icon.getImage();
        Image nuevaImagenEscalada = imagenIcon.getScaledInstance(190, 160, java.awt.Image.SCALE_FAST);
        ImageIcon iconoNuevo = new ImageIcon(nuevaImagenEscalada);
        lblBoligrafo.setIcon(iconoNuevo);

    }

    private void obtenerUsuario(String mail) {

        Usuari usuario = DataAccess.getUser(mail);
        imagenByte = usuario.getFoto();
        System.out.println(usuario.getNom());
        System.out.println(usuario.getFoto());

    }

    public static ImageIcon byteArrayAImagen(byte[] imagen) {
        ImageIcon icon = new ImageIcon(imagen);
        return icon;
    }

    public void ConfirmacionLogin(boolean confirmacion, int idEntrenador, String mail) {
   
        //si devuelve confirmacion como true entonces cierra el jpanel principal
        //y abre el secundario con la jtable cargada
        if (confirmacion) {
            pnlPanelPrincipal.setVisible(false);

            usuaris = new ArrayList<>();
            usuaris = DataAccess.getAllUsersByInstructor(idEntrenador);
            //carga la tabla
            UsuariosTableModel utm = new UsuariosTableModel(usuaris);
            tblTablaUsuarios.setModel(utm);
            tblTablaUsuarios.setAutoCreateRowSorter(true);

            pnlPanelSecundario.setVisible(true);
            obtenerUsuario(mail);
            cargarFoto();

        }
        txtNumeroEntrenador.setText(String.valueOf(idEntrenador));

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
        jLabel1 = new javax.swing.JLabel();
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
        jLabel2 = new javax.swing.JLabel();
        menMenu = new javax.swing.JMenuBar();
        mnbFile = new javax.swing.JMenu();
        mnbExit = new javax.swing.JMenu();
        mnbAbout = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));
        setResizable(false);
        getContentPane().setLayout(null);

        pnlPanelPrincipal.setBackground(new java.awt.Color(102, 102, 102));
        pnlPanelPrincipal.setMinimumSize(new java.awt.Dimension(900, 600));
        pnlPanelPrincipal.setLayout(null);

        btnBotonLogin.setBackground(new java.awt.Color(153, 153, 153));
        btnBotonLogin.setFont(new java.awt.Font("Mukti Narrow", 1, 24)); // NOI18N
        btnBotonLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/down.png"))); // NOI18N
        btnBotonLogin.setText("Entrar");
        btnBotonLogin.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(0, 0, 0), null, new java.awt.Color(0, 51, 51)));
        btnBotonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBotonLoginActionPerformed(evt);
            }
        });
        pnlPanelPrincipal.add(btnBotonLogin);
        btnBotonLogin.setBounds(590, 250, 210, 100);

        lblEtiquetaLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nutricion.png"))); // NOI18N
        pnlPanelPrincipal.add(lblEtiquetaLogo);
        lblEtiquetaLogo.setBounds(10, 0, 550, 520);

        jLabel1.setText("                     www.maXsport.com");
        pnlPanelPrincipal.add(jLabel1);
        jLabel1.setBounds(260, 510, 340, 40);

        getContentPane().add(pnlPanelPrincipal);
        pnlPanelPrincipal.setBounds(0, 0, 900, 600);

        pnlPanelSecundario.setBackground(new java.awt.Color(102, 102, 102));
        pnlPanelSecundario.setMinimumSize(new java.awt.Dimension(900, 600));
        pnlPanelSecundario.setName(""); // NOI18N
        pnlPanelSecundario.setPreferredSize(new java.awt.Dimension(900, 600));
        pnlPanelSecundario.setLayout(null);

        tblTablaUsuarios.setBackground(new java.awt.Color(153, 153, 153));
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
        jScrollPane1.setBounds(30, 80, 452, 370);

        btnAsignarEntreno.setBackground(new java.awt.Color(0, 102, 102));
        btnAsignarEntreno.setFont(new java.awt.Font("Manjari", 0, 15)); // NOI18N
        btnAsignarEntreno.setText("Crear entreno con ejercicios");
        btnAsignarEntreno.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnAsignarEntreno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsignarEntrenoActionPerformed(evt);
            }
        });
        pnlPanelSecundario.add(btnAsignarEntreno);
        btnAsignarEntreno.setBounds(510, 350, 380, 40);

        lblBoligrafo.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51)));
        pnlPanelSecundario.add(lblBoligrafo);
        lblBoligrafo.setBounds(560, 20, 190, 160);

        lblLogoPanelSecundario.setFont(new java.awt.Font("Noto Serif CJK JP", 2, 36)); // NOI18N
        lblLogoPanelSecundario.setForeground(new java.awt.Color(0, 51, 51));
        lblLogoPanelSecundario.setText("maXsport");
        pnlPanelSecundario.add(lblLogoPanelSecundario);
        lblLogoPanelSecundario.setBounds(150, 10, 180, 50);

        btnSignOut.setBackground(new java.awt.Color(102, 0, 0));
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
        btnSignOut.setBounds(770, 20, 120, 70);

        btnNuevoUsuario.setBackground(new java.awt.Color(0, 51, 51));
        btnNuevoUsuario.setForeground(new java.awt.Color(0, 153, 153));
        btnNuevoUsuario.setText("Nuevo usuario");
        btnNuevoUsuario.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnNuevoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoUsuarioActionPerformed(evt);
            }
        });
        pnlPanelSecundario.add(btnNuevoUsuario);
        btnNuevoUsuario.setBounds(510, 410, 190, 40);

        lblEtiquetaWeb.setText("www.maXsport.com");
        pnlPanelSecundario.add(lblEtiquetaWeb);
        lblEtiquetaWeb.setBounds(400, 490, 180, 18);

        txtNumeroEntrenador.setBackground(new java.awt.Color(153, 153, 153));
        txtNumeroEntrenador.setFont(new java.awt.Font("Noto Sans CJK SC", 1, 18)); // NOI18N
        txtNumeroEntrenador.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        txtNumeroEntrenador.setEnabled(false);
        txtNumeroEntrenador.setSelectionColor(new java.awt.Color(0, 0, 0));
        pnlPanelSecundario.add(txtNumeroEntrenador);
        txtNumeroEntrenador.setBounds(770, 150, 80, 33);

        btnListarEjercicios.setBackground(new java.awt.Color(0, 204, 204));
        btnListarEjercicios.setText("Mostrar ejercicios ");
        btnListarEjercicios.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnListarEjercicios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListarEjerciciosActionPerformed(evt);
            }
        });
        pnlPanelSecundario.add(btnListarEjercicios);
        btnListarEjercicios.setBounds(510, 290, 190, 40);

        btnGestionEntrenos.setBackground(new java.awt.Color(204, 255, 204));
        btnGestionEntrenos.setText("Gestion entrenos");
        btnGestionEntrenos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGestionEntrenosActionPerformed(evt);
            }
        });
        pnlPanelSecundario.add(btnGestionEntrenos);
        btnGestionEntrenos.setBounds(710, 410, 180, 40);

        btnMostrarUsuarios.setBackground(new java.awt.Color(51, 255, 102));
        btnMostrarUsuarios.setText("Mostrar usuarios");
        btnMostrarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMostrarUsuariosActionPerformed(evt);
            }
        });
        pnlPanelSecundario.add(btnMostrarUsuarios);
        btnMostrarUsuarios.setBounds(710, 290, 180, 40);

        jLabel2.setText("Instructor");
        pnlPanelSecundario.add(jLabel2);
        jLabel2.setBounds(770, 120, 80, 30);

        getContentPane().add(pnlPanelSecundario);
        pnlPanelSecundario.setBounds(0, 0, 900, 600);

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
        de. setBackground(new Color(150,150,150));
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
        JComponent contenedor=(JComponent) da.getContentPane();
        contenedor.setBackground(new Color(150,150,150));
        da.setVisible(true);
    }//GEN-LAST:event_mnbAboutMousePressed

    private void btnNuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoUsuarioActionPerformed

        dnu = new DialogoNuevoUsuario(this, true);
        JComponent contenedor=(JComponent) dnu.getContentPane();
        contenedor.setBackground(new Color(150,150,150));
        dnu.setVisible(true);

    }//GEN-LAST:event_btnNuevoUsuarioActionPerformed

    private void btnAsignarEntrenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsignarEntrenoActionPerformed
        //daeae=new DialogoAsignarEjerciciosAEntreno(this,false);
        //daeae.setVisible(true);
        dcece = new DialogoCrearEntrenoConEjercicios(this, true);
        JComponent contenedor=(JComponent) dcece.getContentPane();
        contenedor.setBackground(new Color(150,150,150));
        dcece.setVisible(true);

    }//GEN-LAST:event_btnAsignarEntrenoActionPerformed

    private void btnListarEjerciciosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListarEjerciciosActionPerformed
        dle = new DialogoListaEjercicios(this, true);
        dle.setVisible(true);
    }//GEN-LAST:event_btnListarEjerciciosActionPerformed

    private void btnGestionEntrenosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGestionEntrenosActionPerformed
        JOptionPane.showMessageDialog(rootPane, "En contrucción");
    }//GEN-LAST:event_btnGestionEntrenosActionPerformed

    private void btnMostrarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMostrarUsuariosActionPerformed
        dlu = new DialogoListaUsuarios(this, true);
        dlu.setVisible(true);
        
    }//GEN-LAST:event_btnMostrarUsuariosActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsignarEntreno;
    private javax.swing.JButton btnBotonLogin;
    private javax.swing.JButton btnGestionEntrenos;
    private javax.swing.JButton btnListarEjercicios;
    private javax.swing.JButton btnMostrarUsuarios;
    private javax.swing.JButton btnNuevoUsuario;
    private javax.swing.JButton btnSignOut;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
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
