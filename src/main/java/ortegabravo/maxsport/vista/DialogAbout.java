
package ortegabravo.maxsport.vista;

import java.time.LocalDate;
import java.time.ZoneId;


public class DialogAbout extends javax.swing.JDialog {

    
    
    public DialogAbout(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
         setLocationRelativeTo(parent);
         setSize(600,600);
        
        jTextArea1.setText("""
                           Creado por Jonathan M.Ortega Bravo
                           Curso distancia Desarrollo Aplicaciones Multiplataforma 
                           Asignatura Desarrollo de Interfaces.
                           
                           Al inicio tuve que refrescar todos los conocimientos de java ya que hacia
                           2 años que no lo tocaba.
                           Para ello use la web pildoras informaticas y sus videos y algun video de
                           youtube para la base de datos.
                           
                           
                            Problemas encontrados:
                           -Cambié las funciones a public para poder acceder a ellas.
                           -El nombre de la bbdd estaba no coincidia con el de la getconection
                           -Tuve problemas con la clase DataAccess uno fue que al bbdd habia un tipo
                           date y en DataAccess era un string en el PreparedStatement.
                           lo arreglae asi consultando diferentes ia de brave.
                                       LocalDate date = w.getForDate().toInstant().atZone
                                       (ZoneId.systemDefault()).toLocalDate();
                                       java.sql.Date sqlDate = java.sql.Date.valueOf(date);
                                       insertStatement.setDate(1, sqlDate);
                            -Tambien tuve problemas con la instalacion de azure ms sql ya que
                           trabajo con ubuntu 24.04 y no habia soporte, tuve que degradarlo a                        
                           y tengo que usar azure data studio, y aprender a usarlo ya que yo
                           conocia mYsql y su workbrench.
                           Los demas problemas son los probelamas normales que surgen al programar.
                                       
                           """);
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("About");
        setBackground(new java.awt.Color(102, 102, 102));
        setPreferredSize(new java.awt.Dimension(400, 400));
        getContentPane().setLayout(null);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(6, 43, 388, 240);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
