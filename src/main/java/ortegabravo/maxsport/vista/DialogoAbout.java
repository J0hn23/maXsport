
package ortegabravo.maxsport.vista;


public class DialogoAbout extends javax.swing.JDialog {

    
    
    public DialogoAbout(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
         setLocationRelativeTo(null);
         setSize(600,600);
        jScrollPane2.setAutoscrolls(true);
        
       
       //jTextArea2.setSize(550,1200);
        jTextArea2.setText("""
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
                           
                           -La arquitectura del programa es un JFrame principal con dos paneles o JPanel 
                           y el resto son Jdialog que hacen las llamadas a la bbdd.
                           Esta modularizado en diferentes paquetes accesoDatos, Vista y modelo, ademas 
                           solo hay una clase main en vista.
                           
                           -He creado un archivo properties para los datos de la conexion a la bbdd.
                           
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
                           -Tambien encontré un problema en el metodo getUsers que n el ps de instructor
                           devolvia siempre true y lo cambie a getInstructor no isInstructor como estaba.
                           Los demas problemas son los problemas normales que surgen al programar.
                                       
                           Los recursos que he usado son los videos del profesor, la IA de Brave,el típico 
                           foro de stack overflow y los videos de un youtuber pildoras informaticas.
                           """);
        
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("About");
        setBackground(new java.awt.Color(102, 102, 102));
        setPreferredSize(new java.awt.Dimension(400, 400));
        setResizable(false);
        getContentPane().setLayout(null);

        jTextArea2.setColumns(20);
        jTextArea2.setRows(100);
        jScrollPane2.setViewportView(jTextArea2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(20, 20, 570, 640);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea2;
    // End of variables declaration//GEN-END:variables
}
