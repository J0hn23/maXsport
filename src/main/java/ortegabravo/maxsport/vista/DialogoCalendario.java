


package ortegabravo.maxsport.vista;

public class DialogoCalendario extends javax.swing.JDialog {

   
    public DialogoCalendario(java.awt.Frame parent, boolean modal, int idInstructor) {
        super(parent, modal);
        initComponents();
        
    }
    
    
    
    
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        calendarioEntrenosBeans1 = new net.ortegabravo.calendarioentrenosbeans.CalendarioEntrenosBeans();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));
        setPreferredSize(new java.awt.Dimension(700, 600));
        setResizable(false);
        setSize(new java.awt.Dimension(700, 600));
        getContentPane().setLayout(null);
        getContentPane().add(calendarioEntrenosBeans1);
        calendarioEntrenosBeans1.setBounds(10, 10, 556, 279);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private net.ortegabravo.calendarioentrenosbeans.CalendarioEntrenosBeans calendarioEntrenosBeans1;
    // End of variables declaration//GEN-END:variables
}
