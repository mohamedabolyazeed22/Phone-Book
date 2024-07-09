
package IntroPage;

import com.formdev.flatlaf.themes.FlatMacLightLaf;
import java.awt.Desktop;
import java.awt.Toolkit;
import java.net.URL;
import javax.swing.JOptionPane;
import mainApplication.Main_Application;


public class introPage extends javax.swing.JFrame {

    public introPage() {
        initComponents();
        this.setLocationRelativeTo(null);
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/Icons/Back.png")));
        setIcon();
    }
    
    private void setIcon(){
        svgIconLinkedin.setSVGIcon("Icons/linkedin1.svg", 40, 40);
        svgIconLinkedin.setCursorHand();
        svgIconGitHub.setSVGIcon("Icons/Github1.svg", 40, 40);
        svgIconGitHub.setCursorHand();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        kGradientPanel = new keeptoo.KGradientPanel();
        lab_PhoneBook = new javax.swing.JLabel();
        lodingValue = new javax.swing.JLabel();
        lodingtxt = new javax.swing.JLabel();
        lodingBar = new javax.swing.JProgressBar();
        lodingChange = new javax.swing.JLabel();
        svgIconLinkedin = new SVGIcon.svgIcon();
        svgIconGitHub = new SVGIcon.svgIcon();
        jLabel1 = new javax.swing.JLabel();
        lab_teamName = new javax.swing.JLabel();
        lab_ver = new javax.swing.JLabel();
        imageAvatar1 = new Components.ImageAvatar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kGradientPanel.setkEndColor(new java.awt.Color(142, 183, 225));
        kGradientPanel.setkGradientFocus(450);
        kGradientPanel.setkStartColor(new java.awt.Color(4, 125, 198));
        kGradientPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lab_PhoneBook.setFont(new java.awt.Font("Tahoma", 1, 34)); // NOI18N
        lab_PhoneBook.setForeground(new java.awt.Color(255, 255, 255));
        lab_PhoneBook.setText("Phone Book Application ");
        lab_PhoneBook.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        kGradientPanel.add(lab_PhoneBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 34, 440, -1));

        lodingValue.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lodingValue.setForeground(new java.awt.Color(255, 255, 255));
        lodingValue.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lodingValue.setText("0%");
        kGradientPanel.add(lodingValue, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 340, -1, -1));

        lodingtxt.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lodingtxt.setForeground(new java.awt.Color(255, 255, 255));
        lodingtxt.setText("Loding...");
        kGradientPanel.add(lodingtxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 304, 73, -1));
        kGradientPanel.add(lodingBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 330, 440, 8));

        lodingChange.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lodingChange.setForeground(new java.awt.Color(255, 255, 255));
        kGradientPanel.add(lodingChange, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 344, 302, 20));

        svgIconLinkedin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                svgIconLinkedinMouseClicked(evt);
            }
        });
        kGradientPanel.add(svgIconLinkedin, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 40, 40));

        svgIconGitHub.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                svgIconGitHubMouseClicked(evt);
            }
        });
        kGradientPanel.add(svgIconGitHub, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 40, 40));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(235, 235, 235));
        jLabel1.setText("Some Detalis");
        kGradientPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 310, 40));

        lab_teamName.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lab_teamName.setForeground(new java.awt.Color(255, 255, 255));
        lab_teamName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_teamName.setText("Peaky Blinders");
        lab_teamName.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        kGradientPanel.add(lab_teamName, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 260, 150, 20));

        lab_ver.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lab_ver.setForeground(new java.awt.Color(255, 255, 255));
        lab_ver.setText("Version1 2023");
        kGradientPanel.add(lab_ver, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 130, 24));

        imageAvatar1.setBorderSize(4);
        imageAvatar1.setBorderSpace(1);
        imageAvatar1.setGradientColor1(new java.awt.Color(142, 183, 225));
        imageAvatar1.setGradientColor2(new java.awt.Color(4, 125, 198));
        imageAvatar1.setImage(new javax.swing.ImageIcon(getClass().getResource("/Icons/Peaky Blinders.jpg"))); // NOI18N
        kGradientPanel.add(imageAvatar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 100, 150, 140));

        getContentPane().add(kGradientPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 730, 380));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void svgIconLinkedinMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_svgIconLinkedinMouseClicked
        try{
        Desktop.getDesktop().browse(new URL("https://www.linkedin.com/in/mohamed-abolyazeed-246a78255/").toURI());
        } catch(Exception e){
        
        }       
    }//GEN-LAST:event_svgIconLinkedinMouseClicked
 
    private void svgIconGitHubMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_svgIconGitHubMouseClicked
        try{
        Desktop.getDesktop().browse(new URL("https://github.com/MohamedAboElYazeed").toURI());
        } catch(Exception e){
        
        }         
    }//GEN-LAST:event_svgIconGitHubMouseClicked

    public static void main(String args[]) {
        FlatMacLightLaf.setup();
        introPage loding = new introPage();
        loding.setVisible(true);

        try {            
            for (int i = 0; i <= 100; i++) {
                Thread.sleep(100);
                loding.lodingValue.setText(i + "%"); 

                if (i == 8) {
                    loding.lodingChange.setText("Turning On Modules...");
                    loding.lodingtxt.setText("Loding.");
                }

                if (i == 20) {
                    loding.lodingChange.setText("Loding Modules...");
                    loding.lodingtxt.setText("Loding..");
                }

                if (i == 40) {
                    loding.lodingtxt.setText("Loding...");
                }

                if (i == 50) {
                    loding.lodingChange.setText("Connecting To Database...");
                    loding.lodingtxt.setText("Loding....");
                }

                if (i == 65) {
                    loding.lodingtxt.setText("Loding...");
                }

                if (i == 70) {
                    loding.lodingChange.setText("Connection Successful !");
                    loding.lodingtxt.setText("Loding..");
                }

                if (i == 80) {
                    loding.lodingChange.setText("Launching Application");
                    loding.lodingtxt.setText("Loding.");
                }

                if (i == 95) {
                    loding.lodingtxt.setText("Loding...");
                }

                loding.lodingBar.setValue(i);  

            }

            loding.setVisible(false);
            new Main_Application().setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private Components.ImageAvatar imageAvatar1;
    private javax.swing.JLabel jLabel1;
    private keeptoo.KGradientPanel kGradientPanel;
    private javax.swing.JLabel lab_PhoneBook;
    private javax.swing.JLabel lab_teamName;
    private javax.swing.JLabel lab_ver;
    private javax.swing.JProgressBar lodingBar;
    private javax.swing.JLabel lodingChange;
    private javax.swing.JLabel lodingValue;
    private javax.swing.JLabel lodingtxt;
    private SVGIcon.svgIcon svgIconGitHub;
    private SVGIcon.svgIcon svgIconLinkedin;
    // End of variables declaration//GEN-END:variables
}
