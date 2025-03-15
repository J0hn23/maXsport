
package ortegabravo.maxsport.vista;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import static ortegabravo.maxsport.vista.MODO.CLARO;
import static ortegabravo.maxsport.vista.MODO.OSCURO;


public class DialogoAbout extends javax.swing.JDialog {

    
    
    public DialogoAbout(java.awt.Frame parent, boolean modal, MODO modo) {
        super(parent, modal);
        modoVentana(modo);
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
                           
                           TAREA 04
                           Se incicia el tema 4 con las siguientes mejores:
                           -Se ha ñadido una skin que cambia en tiempo de ejecución.
                           -Se añaden ToolTipText en los botones.
                           -Se añade un buscador de usuarios.
                           -Se añade el cambio del puntero al pasar por enciuma de ciertos botones.
                           -Se han añadido funcinalidades que no habia antes como la eliminacion de un entreno y ejercicios.
                           Sobre este último las sentencias sql eran complicadas afectando a 4 tablas.
                           -He cambiado varios textfield como el del login para que solo acepte ciertos caracteres, 
                           o el correo que sea valido y no este en la base de datos.
                           -He añadido gestion de entrenos para eliminar entrenos de usuarios, en este dialog se muestra 
                           la foto del usuario al que entrenamos.
                           -He ido eliminando errores que ha testeado mi hijo, como jtextfield que estaban enable y
                           no deberian.
                           -En medio del proyecto he cambiado de equipo, trabajando en windows y he comenzado a usar el management sql
                           y el ms server 2022.
                           -He cambiado los jlist para que se actualicen inmediatamente al borrar o añadir ejercicios y entrenos.
                           -He hecho lo mismo con los jcombobox.
                           -He aprovechado codigo para los nuevos cambios como los metodos para poner la foto de los usuarios.
                           -En el dialogoLogin , muevo el focus para poder usarlo con tabulaciones o pulsar directamente intro
                           para loguear.
                           -He sacado codigo a clases para una mejor modularidad como la DefaultTableModel de entrenos.
                           -He creado nuevos metodos en DataAccess par alas consultas que necesitaba.
                           
                           
                           """);
        
    }

    
    private void modoVentana(MODO modo){
    
        switch (modo) {
            case    CLARO ->    {
                            try {
                                UIManager.setLookAndFeel(new FlatLightLaf())  ;
                                SwingUtilities.updateComponentTreeUI(this);
                            } catch (UnsupportedLookAndFeelException ex) {
                                Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }

            case OSCURO ->  {
                            try {
                                UIManager.setLookAndFeel(new FlatMacDarkLaf())  ;
                                SwingUtilities.updateComponentTreeUI(this);
                            } catch (UnsupportedLookAndFeelException ex) {
                                Logger.getLogger(FramePrincipal.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
 
        }
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

        jTextArea2.setEditable(false);
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
