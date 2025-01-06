


package ortegabravo.maxsport.vista;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import net.ortegabravo.calendarioentrenosbeans.MiEventoDiaSeleccionado;
import net.ortegabravo.calendarioentrenosbeans.MiEventoInterfaceRecogerArrayEntrenosListener;

public class DialogoCalendario extends javax.swing.JDialog implements MiEventoInterfaceRecogerArrayEntrenosListener {

    JList<String> lstEjercicios;
   
    public DialogoCalendario(java.awt.Frame parent, boolean modal, int idInstructor) {
        super(parent, modal);
        initComponents();
        
        
        calendarioEntrenosBeans1.addRecogerArrayEntrenosListener(this);
        
        colocaLista();
        
        
    }
    
    public void colocaLista() {

        
        JScrollPane jScrollPane3 = new javax.swing.JScrollPane();
        lstEjercicios = new javax.swing.JList<>();
        jScrollPane3.setViewportView(lstEjercicios);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(10, 290, 556, 200);

    }
    
    private void cargaListaConObjetos(ArrayList<String> a) {
         
        System.out.println("esta en cargarlistaobjetos tiene de size=" + a.size());
 
        DefaultListModel<String> dlm = new DefaultListModel();
        
        if (a != null) {
            
            if(!a.isEmpty()){

                for (String e : a) {
                    dlm.addElement(e);
                }
            }else {dlm.addElement("Sin entrenos");}
        }
        lstEjercicios.setModel(dlm);

    }
    
    
    

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        calendarioEntrenosBeans1 = new net.ortegabravo.calendarioentrenosbeans.CalendarioEntrenosBeans();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(153, 153, 153));
        setPreferredSize(new java.awt.Dimension(574, 550));
        setResizable(false);
        setSize(new java.awt.Dimension(575, 550));
        getContentPane().setLayout(null);
        getContentPane().add(calendarioEntrenosBeans1);
        calendarioEntrenosBeans1.setBounds(10, 10, 556, 279);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private net.ortegabravo.calendarioentrenosbeans.CalendarioEntrenosBeans calendarioEntrenosBeans1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void recogerArrayEntrenos(MiEventoDiaSeleccionado e) {
      
        cargaListaConObjetos(e.getEfu());
        
    }
}
