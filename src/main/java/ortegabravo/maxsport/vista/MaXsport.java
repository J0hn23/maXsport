

package ortegabravo.maxsport.vista;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * author
 */


public class MaXsport {

    public static void main(String[] args) {
       
        
        try {
           
//            UIManager.setLookAndFeel(new FlatDarkLaf());
            //UIManager.setLookAndFeel(new FlatLightLaf());
             UIManager.setLookAndFeel(new FlatMacDarkLaf());
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        JFrame frmPrincipal=new FramePrincipal(); 
        frmPrincipal.setVisible(true);
        
        
    }
}
