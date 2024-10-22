
package ortegabravo.maxsport.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class FramePrincipal extends javax.swing.JFrame {

    
    
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(102, 102, 102));
        setPreferredSize(new java.awt.Dimension(900, 600));
        setResizable(false);
        getContentPane().setLayout(null);

        panPanelEnPrincipal.setBackground(new java.awt.Color(102, 102, 102));
        panPanelEnPrincipal.setMinimumSize(new java.awt.Dimension(900, 600));
        panPanelEnPrincipal.setPreferredSize(getPreferredSize());
        panPanelEnPrincipal.setLayout(null);

        btnBotonLogin.setBackground(new java.awt.Color(153, 153, 153));
        btnBotonLogin.setText("Login");
        btnBotonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBotonLoginActionPerformed(evt);
            }
        });
        panPanelEnPrincipal.add(btnBotonLogin);
        btnBotonLogin.setBounds(674, 243, 161, 62);

        getContentPane().add(panPanelEnPrincipal);
        panPanelEnPrincipal.setBounds(0, 0, 900, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBotonLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBotonLoginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnBotonLoginActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBotonLogin;
    private javax.swing.JPanel panPanelEnPrincipal;
    // End of variables declaration//GEN-END:variables
}
