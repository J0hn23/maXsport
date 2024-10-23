
package ortegabravo.maxsport.vista;



import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import javax.swing.ImageIcon;
import javax.swing.JDialog;



public class FramePrincipal extends javax.swing.JFrame {

    JDialog dlgDialogoLogin;
   
    
    
    public FramePrincipal() {
    
        initComponents();
 
        setTitle("MaXsport");
        setLocationRelativeTo(null);
        
        
      
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panPanelEnPrincipal = new javax.swing.JPanel();
        btnBotonLogin = new javax.swing.JButton();
        lblEtiquetaLogo = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));
        setPreferredSize(new java.awt.Dimension(900, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        panPanelEnPrincipal.setBackground(new java.awt.Color(102, 102, 102));
        panPanelEnPrincipal.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 0, 0)));
        panPanelEnPrincipal.setMinimumSize(new java.awt.Dimension(900, 600));
        panPanelEnPrincipal.setPreferredSize(getPreferredSize());
        panPanelEnPrincipal.setLayout(null);

        btnBotonLogin.setBackground(new java.awt.Color(153, 153, 153));
        btnBotonLogin.setFont(new java.awt.Font("Mukti Narrow", 1, 24)); // NOI18N
        btnBotonLogin.setIcon(new javax.swing.ImageIcon("/home/john/NetBeansProjects/maXsport/src/main/java/ortegabravo/iconos/down.png")); // NOI18N
        btnBotonLogin.setText("Entrar");
        btnBotonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBotonLoginActionPerformed(evt);
            }
        });
        panPanelEnPrincipal.add(btnBotonLogin);
        btnBotonLogin.setBounds(600, 380, 210, 100);

        lblEtiquetaLogo.setIcon(new javax.swing.ImageIcon("/home/john/NetBeansProjects/maXsport/src/main/java/ortegabravo/iconos/nutricion.png")); // NOI18N
        panPanelEnPrincipal.add(lblEtiquetaLogo);
        lblEtiquetaLogo.setBounds(10, 10, 530, 500);

        getContentPane().add(panPanelEnPrincipal);
        panPanelEnPrincipal.setBounds(0, 0, 900, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    private void btnBotonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBotonLoginActionPerformed
        
        dlgDialogoLogin=new DialogoLogin(this, false);
        dlgDialogoLogin.setSize(300,400);
        dlgDialogoLogin.setVisible(true);
        
        
        
    }//GEN-LAST:event_btnBotonLoginActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBotonLogin;
    private javax.swing.JLabel lblEtiquetaLogo;
    private javax.swing.JPanel panPanelEnPrincipal;
    // End of variables declaration//GEN-END:variables



}

    
