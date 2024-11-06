
package ortegabravo.maxsport.vista;


public class DialogoAbout extends javax.swing.JDialog {

    
    
    public DialogoAbout(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
         setLocationRelativeTo(null);
         setSize(600,600);
        jTextArea1.setSize(550,550);
        jTextArea1.setText("""
                           Creado por Jonathan M.Ortega Bravo
                           Curso distancia Desarrollo Aplicaciones Multiplataforma 
                           Asignatura Desarrollo de Interfaces.
                           
                           He debido hacerlo con netbeans 21, ademas de jdk21 ya que uso ubuntu y para poder 
                           usar la bbdd azure
                           tuve que degradar el SO al 20.04 y con esa version no hay soporte para netbeans 23,
                           y mi ordenador no soporta una virtualbox con windows.
                           
                           Al inicio tuve que refrescar todos los conocimientos de java ya que hacia
                           2 años que no lo tocaba.
                           Para ello use la web pildoras informaticas y sus videos y algun video de
                           youtube para la base de datos.
                           
                           -Para la arquitectura del programa he usado el modelo MVC de la siguiente forma:
                           Una clase para el DataAccess aportado por el profesor que tiene los metodos para 
                           la consulta y la comunicacion con la interface.
                           Otra clase modelo con las clases para el acceso a los datos
                           Otra clase Vista con la interface , la parte que se comunica con el usuario,
                           compuesta por un jFrame principal y en el dos JPanel y de estas deriban varios 
                           JDialog que se usan para introducir los datos por el usuario.
                           
                           -Comencé a realizarlo antes de ver el video de las jList y los jComboBox y 
                           lo hice a mi manera, luego vi que era mas eficiente la manera explicada en el
                           video, dejé comentada mi manera.
                                                      
                            Problemas encontrados:
                           -Cambié las funciones a public para poder acceder a ellas.
                           -El nombre de la bbdd estaba no coincidia con el de la getconection
                           --Tambien en la funcion registerUser cambié esto porque siempre daba true:
                                insertStatement.setBoolean(4, u.getInstructor());//aqui cambie a getIntructor
                           ya que habia un isInstructor que siempre devolvia un true
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
        setResizable(false);
        getContentPane().setLayout(null);

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(1);
        jTextArea1.setFont(new java.awt.Font("Lohit Devanagari", 0, 15)); // NOI18N
        jTextArea1.setRows(1);
        jTextArea1.setTabSize(1);
        jTextArea1.setDisabledTextColor(new java.awt.Color(51, 51, 51));
        jTextArea1.setEnabled(false);
        jTextArea1.setMaximumSize(new java.awt.Dimension(550, 550));
        jTextArea1.setMinimumSize(new java.awt.Dimension(550, 500));
        jTextArea1.setName(""); // NOI18N
        jTextArea1.setOpaque(false);
        jTextArea1.setPreferredSize(new java.awt.Dimension(550, 550));
        jScrollPane1.setViewportView(jTextArea1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(6, 43, 600, 480);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    // End of variables declaration//GEN-END:variables
}
