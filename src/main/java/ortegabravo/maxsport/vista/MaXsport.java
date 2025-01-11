

package ortegabravo.maxsport.vista;

import com.bulenkov.darcula.DarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.YES_OPTION;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import ortegabravo.maxsport.accesoDatos.DataAccess;

/**
 *
 * author
 */


public class MaXsport {

    public static void main(String[] args) {
       
//         try {
//                UIManager.setLookAndFeel(new FlatMacDarkLaf());
//                //SwingUtilities.updateComponentTreeUI();
//            } catch (UnsupportedLookAndFeelException ex) {
//                Logger.getLogger(MaXsport.class.getName()).log(Level.SEVERE, null, ex);
//            }
//           
        

        FramePrincipal frmPrincipal=new FramePrincipal(); 
        frmPrincipal.setVisible(true);
     
        
    }
      
    
}
