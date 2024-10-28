package ortegabravo.maxsport.vista;

import java.util.Date;
import javax.swing.JOptionPane;
import ortegabravo.maxsport.accesoDatos.DataAccess;
import ortegabravo.maxsport.modelo.Workout;

public class DialogoCrearEntreno extends javax.swing.JDialog {

    Workout w;

    public DialogoCrearEntreno(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
        setSize(400, 300);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblId = new javax.swing.JLabel();
        lblComentario = new javax.swing.JLabel();
        txttComentario = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        spnFecha = new javax.swing.JSpinner();
        btnAniadirEntreno = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));
        setSize(new java.awt.Dimension(400, 300));
        getContentPane().setLayout(null);

        jLabel1.setText("Fecha");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(34, 43, 60, 18);

        lblId.setText("Id usuario");
        getContentPane().add(lblId);
        lblId.setBounds(30, 90, 63, 18);

        lblComentario.setText("Comentario");
        getContentPane().add(lblComentario);
        lblComentario.setBounds(30, 140, 90, 18);
        getContentPane().add(txttComentario);
        txttComentario.setBounds(140, 140, 250, 24);
        getContentPane().add(txtId);
        txtId.setBounds(140, 90, 64, 24);

        spnFecha.setModel(new javax.swing.SpinnerDateModel(new java.util.Date(), null, null, java.util.Calendar.WEEK_OF_YEAR));
        getContentPane().add(spnFecha);
        spnFecha.setBounds(140, 40, 137, 24);

        btnAniadirEntreno.setText("Añadir Entreno");
        btnAniadirEntreno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAniadirEntrenoActionPerformed(evt);
            }
        });
        getContentPane().add(btnAniadirEntreno);
        btnAniadirEntreno.setBounds(120, 210, 170, 40);

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        getContentPane().add(btnCancelar);
        btnCancelar.setBounds(300, 210, 89, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAniadirEntrenoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAniadirEntrenoActionPerformed

        aniadirEntreno();
        JOptionPane.showMessageDialog(rootPane, "Entreno añadido");
        setVisible(false);
    }//GEN-LAST:event_btnAniadirEntrenoActionPerformed

    public void aniadirEntreno() {

        w = new Workout();

        w.setComments(txttComentario.getText());
        w.setIdUsuari(Integer.parseInt(txtId.getText().trim()));
        w.setForDate((Date) spnFecha.getValue());

        DataAccess.insertToWorkoutTable(w);

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAniadirEntreno;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblComentario;
    private javax.swing.JLabel lblId;
    private javax.swing.JSpinner spnFecha;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txttComentario;
    // End of variables declaration//GEN-END:variables
}
