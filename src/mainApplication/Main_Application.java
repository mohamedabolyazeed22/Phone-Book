
package mainApplication;

import Forms_manager.FormsManager;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import javax.swing.JFrame;
import raven.toast.Notifications;
import sign_in.sign_in;

public class Main_Application extends JFrame{
    public Main_Application(){
        init();    
    }
    
    private void init(){
        setTitle("Contacts");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(1200, 750));
        setLocationRelativeTo(null);
        setResizable(false);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Icons/phone-book icon app.png")));
        FormsManager.getInstance().initApplication(this);
        Notifications.getInstance().setJFrame(this);        
        setContentPane(new sign_in());

    }
    
    public static void main(String[] args) {
        FlatMacLightLaf.setup();
        EventQueue.invokeLater(() -> new Main_Application().setVisible(true));
    }
}
