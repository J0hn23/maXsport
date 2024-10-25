
package ortegabravo.maxsport.vista;



import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import javax.swing.ImageIcon;
import javax.swing.JDialog;



public class FramePrincipal extends javax.swing.JFrame {

    JDialog dlgDialogoLogin;
    boolean confirmacion;
   
 
    public FramePrincipal() {
    
        initComponents();
 
        setTitle("MaXsport");
        setLocationRelativeTo(null);
        setSize(900,600);
   
    }
    
    
    public void enviarConfirmacionLogin(boolean confirmacion){
        this.confirmacion=confirmacion;
        System.out.println(confirmacion);
        if (confirmacion=true){
            pnlPanelPrincipal.setVisible(false);
        }
        System.out.println("****Datos login recibidos desde el login");
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPanelPrincipal = new javax.swing.JPanel();
        btnBotonLogin = new javax.swing.JButton();
        lblEtiquetaLogo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    
    private void btnBotonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBotonLoginActionPerformed
        
        dlgDialogoLogin=new DialogoLogin(this, false);
        dlgDialogoLogin.setSize(300,400);
        dlgDialogoLogin.setVisible(true);
        
        
        
    }//GEN-LAST:event_btnBotonLoginActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBotonLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblEtiquetaLogo;
    private javax.swing.JPanel pnlPanelPrincipal;
    // End of variables declaration//GEN-END:variables



}

    
