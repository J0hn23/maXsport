package ortegabravo.maxsport.vista;

import java.util.ArrayList;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
import ortegabravo.maxsport.accesoDatos.DataAccess;
import ortegabravo.maxsport.modelo.Usuari;
import ortegabravo.maxsport.modelo.Workout;

public class FramePrincipal extends javax.swing.JFrame {

    JDialog dlgDialogoLogin;
    boolean confirmacion;
    ArrayList<Usuari> usuaris;

    public FramePrincipal() {

        initComponents();

        setTitle("MaXsport");
        setLocationRelativeTo(null);
        setSize(900, 600);
        pnlPanelSecundario.setSize(900, 600);
        pnlPanelSecundario.setVisible(false);
    }

    public void ConfirmacionLogin(boolean confirmacion, int idEntrenador) {
        this.confirmacion = confirmacion;
        System.out.println(confirmacion);//esto es para ver lo que devuelve
        
        //si devuelve confirmacion como true entonces cierra el jpanel principal
        //y abre el secundario con la jtable cargada
        if (confirmacion) {
            pnlPanelPrincipal.setVisible(false);

            usuaris = new ArrayList<>();

            usuaris = DataAccess.getAllUsersByInstructor(idEntrenador);

            UsuariosTableModel utm = new UsuariosTableModel(usuaris);
            tblTablaUsuarios.setModel(utm);
            tblTablaUsuarios.setAutoCreateRowSorter(true);

            pnlPanelSecundario.setVisible(true);

        }
        System.out.println("****Datos login recibidos desde el login");//chekeo
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
        btnSalirPanelSecundario = new javax.swing.JButton();
        btnCrearEntreno = new javax.swing.JButton();
        btnAsignarEntreno = new javax.swing.JButton();
        lblBoligrafo = new javax.swing.JLabel();
        lblLogoPanelSecundario = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));
        setResizable(false);
        getContentPane().setLayout(null);

        pnlPanelPrincipal.setBackground(new java.awt.Color(102, 102, 102));
        pnlPanelPrincipal.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlPanelPrincipal.setMinimumSize(new java.awt.Dimension(900, 600));
        pnlPanelPrincipal.setLayout(null);

        btnBotonLogin.setBackground(new java.awt.Color(153, 153, 153));
        btnBotonLogin.setFont(new java.awt.Font("Mukti Narrow", 1, 24)); // NOI18N
        btnBotonLogin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/down.png"))); // NOI18N
        btnBotonLogin.setText("Entrar");
        btnBotonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBotonLoginActionPerformed(evt);
            }
        });
        pnlPanelPrincipal.add(btnBotonLogin);
        btnBotonLogin.setBounds(600, 380, 210, 100);

        lblEtiquetaLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/nutricion.png"))); // NOI18N
        pnlPanelPrincipal.add(lblEtiquetaLogo);
        lblEtiquetaLogo.setBounds(10, 10, 550, 530);

        jLabel1.setText("                     www.maXsport.com");
        pnlPanelPrincipal.add(jLabel1);
        jLabel1.setBounds(300, 560, 340, 18);

        getContentPane().add(pnlPanelPrincipal);
        pnlPanelPrincipal.setBounds(0, 0, 900, 600);

        pnlPanelSecundario.setMinimumSize(new java.awt.Dimension(900, 600));
        pnlPanelSecundario.setName(""); // NOI18N
        pnlPanelSecundario.setPreferredSize(new java.awt.Dimension(900, 600));
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
        tblTablaUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblTablaUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblTablaUsuarios);

        pnlPanelSecundario.add(jScrollPane1);
        jScrollPane1.setBounds(30, 80, 452, 402);

        btnSalirPanelSecundario.setBackground(new java.awt.Color(255, 51, 0));
        btnSalirPanelSecundario.setFont(new java.awt.Font("Norasi", 0, 24)); // NOI18N
        btnSalirPanelSecundario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/exercise_salir.png"))); // NOI18N
        btnSalirPanelSecundario.setText("Salir");
        btnSalirPanelSecundario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirPanelSecundarioActionPerformed(evt);
            }
        });
        pnlPanelSecundario.add(btnSalirPanelSecundario);
        btnSalirPanelSecundario.setBounds(670, 410, 180, 70);

        btnCrearEntreno.setBackground(new java.awt.Color(153, 255, 0));
        btnCrearEntreno.setFont(new java.awt.Font("Manjari", 0, 15)); // NOI18N
        btnCrearEntreno.setText("Crear nuevo entreno");
        btnCrearEntreno.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCrearEntreno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearEntrenoActionPerformed(evt);
            }
        });
        pnlPanelSecundario.add(btnCrearEntreno);
        btnCrearEntreno.setBounds(520, 290, 190, 40);

        btnAsignarEntreno.setBackground(new java.awt.Color(51, 255, 204));
        btnAsignarEntreno.setFont(new java.awt.Font("Manjari", 0, 15)); // NOI18N
        btnAsignarEntreno.setText("Asignar entrenamiento");
        btnAsignarEntreno.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlPanelSecundario.add(btnAsignarEntreno);
        btnAsignarEntreno.setBounds(520, 350, 190, 40);

        lblBoligrafo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/boligrafo-cuadrado (1).png"))); // NOI18N
        pnlPanelSecundario.add(lblBoligrafo);
        lblBoligrafo.setBounds(540, 10, 300, 260);

        lblLogoPanelSecundario.setFont(new java.awt.Font("Noto Serif CJK JP", 2, 36)); // NOI18N
        lblLogoPanelSecundario.setForeground(new java.awt.Color(0, 255, 204));
        lblLogoPanelSecundario.setText("maXsport");
        pnlPanelSecundario.add(lblLogoPanelSecundario);
        lblLogoPanelSecundario.setBounds(150, 10, 180, 50);

        getContentPane().add(pnlPanelSecundario);
        pnlPanelSecundario.setBounds(0, 0, 900, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents


    private void btnBotonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBotonLoginActionPerformed
        //es el actionperformed del boton de login que abre el jdialog login
        dlgDialogoLogin = new DialogoLogin(this, false);
        dlgDialogoLogin.setSize(300, 400);
        dlgDialogoLogin.setVisible(true);


    }//GEN-LAST:event_btnBotonLoginActionPerformed

    private void btnSalirPanelSecundarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirPanelSecundarioActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnSalirPanelSecundarioActionPerformed

    private void tblTablaUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTablaUsuariosMouseClicked
       
       //creo un evento mouseclicked en la tabla
       //el evento evt con el metodo getpoint me da el punto de la fila donde 
       //clikeo y el numero de la fila
        int fila=tblTablaUsuarios.rowAtPoint(evt.getPoint());
        
        //int id=Integer.parseInt(tblTablaUsuarios.getValueAt(fila, 0).toString());
        //con el in de la fila obtengo los datos que quiera de la tabla
        String nombre=(String) tblTablaUsuarios.getValueAt(fila, 1);
        String correoAlumno=tblTablaUsuarios.getValueAt(fila, 2).toString();
        
      
        //le paso al dialog el id y alli hago el resultset, y le mando como parametros
        //correo y nombre para usarlos alli, en el nuevo jdialog
        DialogoEntrenamientos de=new  DialogoEntrenamientos(this,false,correoAlumno,nombre);
        de.setSize(500, 400);
        de.setVisible(true);
        de.setLocationRelativeTo(null);
        
        
    }//GEN-LAST:event_tblTablaUsuariosMouseClicked

    private void btnCrearEntrenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearEntrenoActionPerformed
       //proximamente
       JOptionPane.showMessageDialog(rootPane, "En construccion");
    }//GEN-LAST:event_btnCrearEntrenoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsignarEntreno;
    private javax.swing.JButton btnBotonLogin;
    private javax.swing.JButton btnCrearEntreno;
    private javax.swing.JButton btnSalirPanelSecundario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblBoligrafo;
    private javax.swing.JLabel lblEtiquetaLogo;
    private javax.swing.JLabel lblLogoPanelSecundario;
    private javax.swing.JPanel pnlPanelPrincipal;
    private javax.swing.JPanel pnlPanelSecundario;
    private javax.swing.JTable tblTablaUsuarios;
    // End of variables declaration//GEN-END:variables

}
 //uso la interface abstracttablemodel para crear una tabla como yo quiera
class UsuariosTableModel extends AbstractTableModel {

    private final String[] columns = {"Id Usuario", "Nombre", "Correo", "Foto"};
    public ArrayList<Usuari> usuaris = null;

    public UsuariosTableModel(ArrayList<Usuari> usuaris) {
        this.usuaris = usuaris;
    }

    @Override
    public int getRowCount() {

        return usuaris.size();
    }

    @Override
    public int getColumnCount() {

        return columns.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        return switch (columnIndex) {
            case 0 ->
                usuaris.get(rowIndex).getId();
            case 1 ->
                usuaris.get(rowIndex).getNom();
            case 2 ->
                usuaris.get(rowIndex).getEmail();
            // case 3-> usuaris.get(rowIndex).setFoto(foto);
            case 3 ->
                "prueba";
            default ->
                "-";
        };
    }

    @Override
    public String getColumnName(int column) {
        return columns[column];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return super.getColumnClass(columnIndex);
    }

}
