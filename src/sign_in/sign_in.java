package sign_in;

import java.util.prefs.Preferences;
import DBConnection.databaseConnection;
import Forms_manager.FormsManager;
import com.formdev.flatlaf.FlatClientProperties;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import raven.toast.Notifications;
import sign_up.sign_up;
import view_my_contact.viewContact;

public class sign_in extends javax.swing.JPanel {

    databaseConnection signindata = new databaseConnection();

    public sign_in() {
        initComponents();
        filltext();
        loadSavedCredentials();
    }

    // Method to fill JText
    private void filltext() {
        txt_email.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter your Email");
        PasswordField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter your Password");
        PasswordField.putClientProperty(FlatClientProperties.STYLE, "showRevealButton:true");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pan_all = new Components.PanelRound();
        lb_Title = new javax.swing.JLabel();
        lb_Description = new javax.swing.JLabel();
        lab_email = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        lab_password = new javax.swing.JLabel();
        PasswordField = new javax.swing.JPasswordField();
        cbx_rememberMe = new javax.swing.JCheckBox();
        btn_login = new javax.swing.JButton();
        lab_haveaccount = new javax.swing.JLabel();
        btn_signup = new javax.swing.JButton();
        lab_errorEmail = new javax.swing.JLabel();
        lab_errorPassword = new javax.swing.JLabel();

        pan_all.setBackground(new java.awt.Color(226, 226, 226));
        pan_all.setRoundBottomLeft(30);
        pan_all.setRoundBottomRight(30);
        pan_all.setRoundTopLeft(30);
        pan_all.setRoundTopRight(30);
        pan_all.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_Title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lb_Title.setForeground(new java.awt.Color(0, 0, 0));
        lb_Title.setText("Welcome back!");
        pan_all.add(lb_Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, -1));

        lb_Description.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lb_Description.setForeground(new java.awt.Color(0, 0, 0));
        lb_Description.setText("Please sign in to access your account");
        pan_all.add(lb_Description, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, -1));

        lab_email.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lab_email.setForeground(new java.awt.Color(0, 0, 0));
        lab_email.setText("Email");
        pan_all.add(lab_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, -1));

        txt_email.setBackground(new java.awt.Color(206, 211, 214));
        txt_email.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_email.setForeground(new java.awt.Color(0, 0, 0));
        txt_email.setMinimumSize(new java.awt.Dimension(64, 20));
        txt_email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_emailActionPerformed(evt);
            }
        });
        pan_all.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, 290, 36));

        lab_password.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lab_password.setForeground(new java.awt.Color(0, 0, 0));
        lab_password.setText("Password");
        pan_all.add(lab_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, -1, -1));

        PasswordField.setBackground(new java.awt.Color(206, 211, 214));
        PasswordField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        PasswordField.setForeground(new java.awt.Color(0, 0, 0));
        PasswordField.setMinimumSize(new java.awt.Dimension(64, 20));
        PasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordFieldActionPerformed(evt);
            }
        });
        pan_all.add(PasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 250, 290, 36));

        cbx_rememberMe.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        cbx_rememberMe.setForeground(new java.awt.Color(0, 0, 0));
        cbx_rememberMe.setText("Remember me");
        cbx_rememberMe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbx_rememberMeActionPerformed(evt);
            }
        });
        pan_all.add(cbx_rememberMe, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, -1, -1));

        btn_login.setBackground(new java.awt.Color(21, 101, 192));
        btn_login.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_login.setForeground(new java.awt.Color(255, 255, 255));
        btn_login.setText("Login");
        btn_login.setBorderPainted(false);
        btn_login.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_loginActionPerformed(evt);
            }
        });
        pan_all.add(btn_login, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 340, 290, -1));

        lab_haveaccount.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lab_haveaccount.setForeground(new java.awt.Color(0, 0, 0));
        lab_haveaccount.setText("Don't have an account ? ");
        pan_all.add(lab_haveaccount, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, 150, -1));

        btn_signup.setBackground(new java.awt.Color(226, 226, 226));
        btn_signup.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_signup.setForeground(new java.awt.Color(19, 91, 174));
        btn_signup.setText("Sign up now");
        btn_signup.setBorder(null);
        btn_signup.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_signup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_signupActionPerformed(evt);
            }
        });
        pan_all.add(btn_signup, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 390, -1, -1));

        lab_errorEmail.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lab_errorEmail.setForeground(new java.awt.Color(255, 0, 0));
        lab_errorEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pan_all.add(lab_errorEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 290, 15));

        lab_errorPassword.setFont(new java.awt.Font("Segoe UI", 0, 11)); // NOI18N
        lab_errorPassword.setForeground(new java.awt.Color(255, 0, 0));
        lab_errorPassword.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pan_all.add(lab_errorPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, 290, 15));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(pan_all, javax.swing.GroupLayout.PREFERRED_SIZE, 434, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pan_all, javax.swing.GroupLayout.PREFERRED_SIZE, 422, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Methode to go to the sign up Page

    private void btn_signupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_signupActionPerformed
        FormsManager.getInstance().showForm(new sign_up());
    }//GEN-LAST:event_btn_signupActionPerformed

    public static int user_id;

    // Methode To Check If the user is in the database or not

    private void btn_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_loginActionPerformed

        String email = txt_email.getText();
        String password = new String(PasswordField.getPassword());

        String query = "SELECT user_id, user_email, user_password FROM userDB ;";

        try {
            PreparedStatement userData = signindata.con.prepareStatement(query);

            ResultSet data = userData.executeQuery();

            if (data.next()) {
                String dbPassword = data.getString("user_password");
                String dpEmail = data.getString("user_email");
                user_id = data.getInt("user_id");

                if (email.equals(dpEmail) && password.equals(dbPassword)) {
                    // Successful login
                    Notifications.getInstance().show(Notifications.Type.SUCCESS, "Welcome Back");
                    FormsManager.getInstance().showForm(new viewContact());
                } else {
                    // Incorrect password
                    lab_errorEmail.setText("");
                    lab_errorEmail.setBorder((javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(226, 226, 226))));
                    lab_errorPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
                    lab_errorPassword.setText("Incorrect Password. Please enter the correct password.");
                }
            } else {
                // User not found
                lab_errorPassword.setText("");
                lab_errorPassword.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(226, 226, 226)));
                lab_errorEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
                lab_errorEmail.setText("User not found. Please enter a valid email address.");

                Notifications.getInstance().show(Notifications.Type.ERROR, "Invalid Email. Please enter a valid email address.");
            }

        } catch (SQLException ex) {
            Notifications.getInstance().show(Notifications.Type.ERROR, "There is No Connection To Database");
        }
    }//GEN-LAST:event_btn_loginActionPerformed

    // The next Methodes is For Remember Me Check box
    
    private void saveCredentials(String email, String password) {
        Preferences prefs = Preferences.userNodeForPackage(getClass());

        prefs.put("email", email);
        prefs.put("password", password);

        prefs.putBoolean("rememberMe", true);
    }

    private void loadSavedCredentials() {
        Preferences prefs = Preferences.userNodeForPackage(getClass());

        String savedEmail = prefs.get("email", "");
        String savedPassword = prefs.get("password", "");

        txt_email.setText(savedEmail);
        PasswordField.setText(savedPassword);

        cbx_rememberMe.setSelected(true);
    }

    private void clearSavedCredentials() {
        Preferences prefs = Preferences.userNodeForPackage(getClass());

        prefs.remove("email");
        prefs.remove("password");
        prefs.remove("rememberMe");
    }


    private void cbx_rememberMeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbx_rememberMeActionPerformed
        if (cbx_rememberMe.isSelected()) {
            saveCredentials(txt_email.getText(), new String(PasswordField.getPassword()));
        } else {
            clearSavedCredentials();
        }
    }//GEN-LAST:event_cbx_rememberMeActionPerformed

    private void txt_emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_emailActionPerformed

    private void PasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JButton btn_login;
    private javax.swing.JButton btn_signup;
    private javax.swing.JCheckBox cbx_rememberMe;
    private javax.swing.JLabel lab_email;
    private javax.swing.JLabel lab_errorEmail;
    private javax.swing.JLabel lab_errorPassword;
    private javax.swing.JLabel lab_haveaccount;
    private javax.swing.JLabel lab_password;
    private javax.swing.JLabel lb_Description;
    private javax.swing.JLabel lb_Title;
    private Components.PanelRound pan_all;
    private javax.swing.JTextField txt_email;
    // End of variables declaration//GEN-END:variables
}
