package sign_up;

import DBConnection.databaseConnection;
import Forms_manager.FormsManager;
import Components.methodUtil;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Color;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JPasswordField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import raven.toast.Notifications;
import sign_in.sign_in;

public class sign_up extends javax.swing.JPanel {

    // For Check The Password
    private JPasswordField passwordField1;
    private DocumentListener documentListener;
    private int type;
    
    // Array List for Database
    databaseConnection signupdata = new databaseConnection();
    ArrayList<Integer> countryId = new ArrayList<>();
    ArrayList<String> countryKey = new ArrayList<>();
    ArrayList<Integer> userDB = new ArrayList<>();

    public sign_up() {
        initComponents();
        fillText();
        initPasswordField(PasswordField);
        fillComboBoxCountry();
        setcountry();
    }

    // method to fill the text
    private void fillText() {
        txt_Fname.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter your First Name");
        txt_Lname.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter your Last Name");
        txt_email.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "e.g. example@gmail.com");
        PasswordField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter your password");
        txt_phoneNum.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter your Phone Number");
        PasswordField.putClientProperty(FlatClientProperties.STYLE, "" + "showRevealButton:true");
    }

    // methode to fill the country Phone number Key and the country flag
    private void setcountry() {

        switch (ComboBoxCountry.getSelectedIndex()) {
            case 0:
                lab_countryKey.setText("+20");
                svgIconCountry.setSVGIcon("ArabicCountriesFlag/Flag_of_Egypt.svg", 25, 25);
                break;
            case 1:
                lab_countryKey.setText("+213");
                svgIconCountry.setSVGIcon("ArabicCountriesFlag/Flag_of_Algeria.svg", 25, 25);
                break;
            case 2:
                lab_countryKey.setText("+962");
                svgIconCountry.setSVGIcon("ArabicCountriesFlag/Flag_of_Jordan.svg", 25, 25);
                break;
            case 3:
                lab_countryKey.setText("+968");
                svgIconCountry.setSVGIcon("ArabicCountriesFlag/Flag_of_Oman.svg", 25, 25);
                break;
            case 4:
                lab_countryKey.setText("+249");
                svgIconCountry.setSVGIcon("ArabicCountriesFlag/Flag_of_Sudan.svg", 25, 25);
                break;
            case 5:
                lab_countryKey.setText("+973");
                svgIconCountry.setSVGIcon("ArabicCountriesFlag/Flag_of_Bahrain.svg", 25, 25);
                break;
            case 6:
                lab_countryKey.setText("+965");
                svgIconCountry.setSVGIcon("ArabicCountriesFlag/Flag_of_Kuwait.svg", 25, 25);
                break;
            case 7:
                lab_countryKey.setText("+970");
                svgIconCountry.setSVGIcon("ArabicCountriesFlag/Flag_of_Palestine.svg", 25, 25);
                break;
            case 8:
                lab_countryKey.setText("+963");
                svgIconCountry.setSVGIcon("ArabicCountriesFlag/Flag_of_Syria.svg", 25, 25);
                break;
            case 9:
                lab_countryKey.setText("+269");
                svgIconCountry.setSVGIcon("ArabicCountriesFlag/Flag_of_the_Comoros.svg", 25, 25);
                break;
            case 10:
                lab_countryKey.setText("+961");
                svgIconCountry.setSVGIcon("ArabicCountriesFlag/Flag_of_Lebanon.svg", 25, 25);
                break;
            case 11:
                lab_countryKey.setText("+974");
                svgIconCountry.setSVGIcon("ArabicCountriesFlag/Flag_of_Qatar.svg", 25, 25);
                break;
            case 12:
                lab_countryKey.setText("+216");
                svgIconCountry.setSVGIcon("ArabicCountriesFlag/Flag_of_Tunisia.svg", 25, 25);
                break;
            case 13:
                lab_countryKey.setText("+253");
                svgIconCountry.setSVGIcon("ArabicCountriesFlag/Flag_of_Djibouti.svg", 25, 25);
                break;
            case 14:
                lab_countryKey.setText("+218");
                svgIconCountry.setSVGIcon("ArabicCountriesFlag/Flag_of_Libya.svg", 25, 25);
                break;
            case 15:
                lab_countryKey.setText("+966");
                svgIconCountry.setSVGIcon("ArabicCountriesFlag/Flag_of_Saudi_Arabia.svg", 25, 25);
                break;
            case 16:
                lab_countryKey.setText("+971");
                svgIconCountry.setSVGIcon("ArabicCountriesFlag/Flag_of_the_United_Arab_Emirates.svg", 25, 25);
                break;
            case 17:
                lab_countryKey.setText("+222");
                svgIconCountry.setSVGIcon("ArabicCountriesFlag/Flag_of_Mauritania.svg", 25, 25);
                break;
            case 18:
                lab_countryKey.setText("+252");
                svgIconCountry.setSVGIcon("ArabicCountriesFlag/Flag_of_Somalia.svg", 25, 25);
                break;
            case 19:
                lab_countryKey.setText("+967");
                svgIconCountry.setSVGIcon("ArabicCountriesFlag/Flag_of_Yemen.svg", 25, 25);
                break;
            case 20:
                lab_countryKey.setText("+964");
                svgIconCountry.setSVGIcon("ArabicCountriesFlag/Flag_of_Iraq.svg", 25, 25);
                break;
            case 21:
                lab_countryKey.setText("+212");
                svgIconCountry.setSVGIcon("ArabicCountriesFlag/Flag_of_Morocco.svg", 25, 25);
                break;
            default:
                Notifications.getInstance().show(Notifications.Type.ERROR, "Error");
        }
    }

    private void fillComboBoxCountry() {

        try {
            PreparedStatement countryName = signupdata.con.prepareStatement("select country_id, country_name , country_Phone_Number_Key from phonebookDB.country");
            ResultSet data = countryName.executeQuery();

            while (data.next()) {
                countryId.add(data.getInt(1));
                ComboBoxCountry.addItem(data.getString(2));
                countryKey.add(data.getString(3));
            }
        } catch (SQLException ex) {
            Notifications.getInstance().show(Notifications.Type.WARNING, "Error Conection");
        }
    }

    // Methods of check Password Status 
    // Method To set color
    private Color getStrengthColor(int type) {
        if (type == 1) {
            return Color.decode("#FF4D4D");
        } else if (type == 2) {
            return Color.decode("#FFB04D");
        } else {
            return Color.decode("#58C359");
        }
    }

    // Method To set txt password status
    private void set_txtStatus(String password) {
        this.type = password.isEmpty() ? 0 : methodUtil.checkPasswordStrength(password);

        if (type == 0) {
            lab_passwordStatus.setText("none");
            lab_passwordStatus.setVisible(false);
        } else {
            lab_passwordStatus.setVisible(true);
            if (type == 1) {
                lab_passwordStatus.setText("Too weak");
            } else if (type == 2) {
                lab_passwordStatus.setText("Medium");
            } else {
                lab_passwordStatus.setText("Strong");
            }
            lab_passwordStatus.setForeground(getStrengthColor(type));
        }
        repaint();
    }

    // Method to set progress bar password status
    private void set_progreesBarStatus(String password) {
        Color disableColor = Color.decode("#4E5052");
        if (type >= 1) {
            bar_week.setBackground(getStrengthColor(1));
        } else {
            bar_week.setBackground(disableColor);
        }

        if (type >= 2) {
            bar_medium.setBackground(getStrengthColor(2));
        } else {
            bar_medium.setBackground(disableColor);
        }

        if (type >= 3) {
            bar_strong.setBackground(getStrengthColor(3));
        } else {
            bar_strong.setBackground(disableColor);
        }
    }

    // Method to init The password
    public void initPasswordField(JPasswordField txt) {
        if (documentListener == null) {
            documentListener = new DocumentListener() {
                @Override
                public void insertUpdate(DocumentEvent e) {
                    set_txtStatus(String.valueOf(txt.getPassword()));
                    set_progreesBarStatus(String.valueOf(txt.getPassword()));
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    set_txtStatus(String.valueOf(txt.getPassword()));
                    set_progreesBarStatus(String.valueOf(txt.getPassword()));
                }

                @Override
                public void changedUpdate(DocumentEvent e) {
                    set_txtStatus(String.valueOf(txt.getPassword()));
                    set_progreesBarStatus(String.valueOf(txt.getPassword()));
                }
            };
        }
        if (passwordField1 != null) {
            passwordField1.getDocument().removeDocumentListener(documentListener);
        }
        txt.getDocument().addDocumentListener(documentListener);
        passwordField1 = txt;
    }

    // here the code was generated from netbeanse 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        panelRound1 = new Components.PanelRound();
        lb_Title = new javax.swing.JLabel();
        lb_Description = new javax.swing.JLabel();
        lab_Lname = new javax.swing.JLabel();
        txt_Fname = new javax.swing.JTextField();
        txt_Lname = new javax.swing.JTextField();
        lab_email = new javax.swing.JLabel();
        txt_email = new javax.swing.JTextField();
        lab_id = new javax.swing.JLabel();
        txt_phoneNum = new javax.swing.JTextField();
        lab_password = new javax.swing.JLabel();
        PasswordField = new javax.swing.JPasswordField();
        bar_week = new javax.swing.JProgressBar();
        bar_medium = new javax.swing.JProgressBar();
        bar_strong = new javax.swing.JProgressBar();
        lab_gender = new javax.swing.JLabel();
        rbn_male = new javax.swing.JRadioButton();
        rbn_female = new javax.swing.JRadioButton();
        lab_year = new javax.swing.JLabel();
        ComboBoxCountry = new javax.swing.JComboBox<>();
        btn_signUp = new javax.swing.JButton();
        lab_haveAccout = new javax.swing.JLabel();
        btn_signin = new javax.swing.JButton();
        lab_passwordStatus = new javax.swing.JLabel();
        lab_Fname = new javax.swing.JLabel();
        lab_countryKey = new javax.swing.JLabel();
        svgIconCountry = new SVGIcon.svgIcon();
        lab_errorEmail = new javax.swing.JLabel();

        panelRound1.setBackground(new java.awt.Color(226, 226, 226));
        panelRound1.setRoundBottomLeft(30);
        panelRound1.setRoundBottomRight(30);
        panelRound1.setRoundTopLeft(30);
        panelRound1.setRoundTopRight(30);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lb_Title.setBackground(new java.awt.Color(206, 211, 214));
        lb_Title.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lb_Title.setForeground(new java.awt.Color(0, 0, 0));
        lb_Title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_Title.setText("Welcome To Phone Book Application");
        panelRound1.add(lb_Title, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 20, -1, -1));

        lb_Description.setBackground(new java.awt.Color(206, 211, 214));
        lb_Description.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lb_Description.setForeground(new java.awt.Color(38, 38, 38));
        lb_Description.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lb_Description.setText("Join us to our program . Sign up now! ");
        panelRound1.add(lb_Description, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 350, -1));

        lab_Lname.setBackground(new java.awt.Color(206, 211, 214));
        lab_Lname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lab_Lname.setForeground(new java.awt.Color(38, 38, 38));
        lab_Lname.setText("Last Name");
        panelRound1.add(lab_Lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, -1, -1));

        txt_Fname.setBackground(new java.awt.Color(206, 211, 214));
        txt_Fname.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_Fname.setPreferredSize(new java.awt.Dimension(68, 28));
        txt_Fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_FnameActionPerformed(evt);
            }
        });
        panelRound1.add(txt_Fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 160, 33));

        txt_Lname.setBackground(new java.awt.Color(206, 211, 214));
        txt_Lname.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_Lname.setPreferredSize(new java.awt.Dimension(68, 28));
        txt_Lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_LnameActionPerformed(evt);
            }
        });
        panelRound1.add(txt_Lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 110, 170, 33));

        lab_email.setBackground(new java.awt.Color(206, 211, 214));
        lab_email.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lab_email.setForeground(new java.awt.Color(38, 38, 38));
        lab_email.setText("Email");
        panelRound1.add(lab_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, -1, -1));

        txt_email.setBackground(new java.awt.Color(206, 211, 214));
        txt_email.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_email.setPreferredSize(new java.awt.Dimension(68, 28));
        panelRound1.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 340, 33));

        lab_id.setBackground(new java.awt.Color(206, 211, 214));
        lab_id.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lab_id.setForeground(new java.awt.Color(38, 38, 38));
        lab_id.setText("Phone Number");
        panelRound1.add(lab_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 290, -1, -1));

        txt_phoneNum.setBackground(new java.awt.Color(206, 211, 214));
        txt_phoneNum.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        txt_phoneNum.setPreferredSize(new java.awt.Dimension(68, 28));
        txt_phoneNum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_phoneNumActionPerformed(evt);
            }
        });
        panelRound1.add(txt_phoneNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 280, 33));

        lab_password.setBackground(new java.awt.Color(206, 211, 214));
        lab_password.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lab_password.setForeground(new java.awt.Color(38, 38, 38));
        lab_password.setText("Password");
        panelRound1.add(lab_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 360, -1, -1));

        PasswordField.setBackground(new java.awt.Color(206, 211, 214));
        PasswordField.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        PasswordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PasswordFieldActionPerformed(evt);
            }
        });
        panelRound1.add(PasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 390, 340, 33));

        bar_week.setMinimumSize(new java.awt.Dimension(8, 4));
        panelRound1.add(bar_week, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 440, 45, -1));

        bar_medium.setMinimumSize(new java.awt.Dimension(8, 4));
        panelRound1.add(bar_medium, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 440, 45, -1));

        bar_strong.setMinimumSize(new java.awt.Dimension(8, 4));
        panelRound1.add(bar_strong, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 440, 45, -1));

        lab_gender.setBackground(new java.awt.Color(206, 211, 214));
        lab_gender.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lab_gender.setForeground(new java.awt.Color(38, 38, 38));
        lab_gender.setText("Gender");
        panelRound1.add(lab_gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 470, -1, -1));

        buttonGroup.add(rbn_male);
        rbn_male.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rbn_male.setForeground(new java.awt.Color(0, 0, 0));
        rbn_male.setSelected(true);
        rbn_male.setText("Male");
        rbn_male.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbn_maleActionPerformed(evt);
            }
        });
        panelRound1.add(rbn_male, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 470, -1, -1));

        buttonGroup.add(rbn_female);
        rbn_female.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        rbn_female.setForeground(new java.awt.Color(0, 0, 0));
        rbn_female.setText("Female");
        panelRound1.add(rbn_female, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 470, -1, -1));

        lab_year.setBackground(new java.awt.Color(206, 211, 214));
        lab_year.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lab_year.setForeground(new java.awt.Color(38, 38, 38));
        lab_year.setText("Country");
        panelRound1.add(lab_year, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, 60, -1));

        ComboBoxCountry.setBackground(new java.awt.Color(206, 211, 214));
        ComboBoxCountry.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ComboBoxCountry.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ComboBoxCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxCountryActionPerformed(evt);
            }
        });
        panelRound1.add(ComboBoxCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 260, 220, 30));

        btn_signUp.setBackground(new java.awt.Color(21, 101, 192));
        btn_signUp.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btn_signUp.setForeground(new java.awt.Color(255, 255, 255));
        btn_signUp.setText("Sign Up");
        btn_signUp.setBorderPainted(false);
        btn_signUp.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_signUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_signUpActionPerformed(evt);
            }
        });
        panelRound1.add(btn_signUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 500, 310, -1));

        lab_haveAccout.setBackground(new java.awt.Color(206, 211, 214));
        lab_haveAccout.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lab_haveAccout.setForeground(new java.awt.Color(38, 38, 38));
        lab_haveAccout.setText("Already have an account? ");
        panelRound1.add(lab_haveAccout, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 540, -1, -1));

        btn_signin.setBackground(new java.awt.Color(226, 226, 226));
        btn_signin.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_signin.setForeground(new java.awt.Color(19, 91, 174));
        btn_signin.setText("Sign in here");
        btn_signin.setBorder(null);
        btn_signin.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_signin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_signinActionPerformed(evt);
            }
        });
        panelRound1.add(btn_signin, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 540, -1, -1));

        lab_passwordStatus.setForeground(new java.awt.Color(0, 0, 0));
        lab_passwordStatus.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelRound1.add(lab_passwordStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 430, 60, 20));

        lab_Fname.setBackground(new java.awt.Color(206, 211, 214));
        lab_Fname.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lab_Fname.setForeground(new java.awt.Color(38, 38, 38));
        lab_Fname.setText("First Name");
        panelRound1.add(lab_Fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 80, -1, -1));

        lab_countryKey.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lab_countryKey.setForeground(new java.awt.Color(0, 0, 0));
        lab_countryKey.setToolTipText("");
        panelRound1.add(lab_countryKey, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 320, 52, 33));
        panelRound1.add(svgIconCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 25, 25));

        lab_errorEmail.setForeground(new java.awt.Color(255, 0, 0));
        panelRound1.add(lab_errorEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 230, 340, 15));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(panelRound1, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private boolean isEnglishLetters(String text) {
        for (char c : text.toCharArray()) {
            if (!Character.isLetter(c) || !Character.isAlphabetic(c)) {
                return false;
            }
        }
        return true;
    }

    public boolean IsValidEmail(String email) {
        return email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9+_.-]+$");
    }

    private boolean check(String Email, String PhoneNumber) {
        String query = "select user_email, user_phoneNumber from userDB";

        try {
            PreparedStatement userDB = signupdata.con.prepareStatement(query);
            ResultSet data = userDB.executeQuery();

            while (data.next()) {
                if (Email != data.getString(1)) {
                    Notifications.getInstance().show(Notifications.Type.ERROR, "Email Is Already In The Database");
                    return false;
                } else if (PhoneNumber != data.getString(2)) {
                    Notifications.getInstance().show(Notifications.Type.ERROR, "Phone Number Is Already In The Database");
                    return false;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }


    private void btn_signUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_signUpActionPerformed
        String Fname = txt_Fname.getText();
        String Lname = txt_Lname.getText();
        String email = txt_email.getText();
        String PhoneNumber = txt_phoneNum.getText();
        String password = new String(PasswordField.getPassword());
        String gender;
        String query = "insert into userDB (Fname,Lname,user_email,user_phoneNumber,user_password,user_gender,country_id) values (?,?,?,?,?,?,?);";

        if (!Fname.isEmpty() && !Lname.isEmpty()
                && !email.isEmpty() && !PhoneNumber.isEmpty()
                && !password.isEmpty()
                && (Fname.length() > 0 && Fname.length() <= 15)
                && (Lname.length() > 0 && Lname.length() <= 15)
                && IsValidEmail(email)) {

            try {

                if (rbn_male.isSelected()) {
                    gender = "Male";
                } else {
                    gender = "Female";
                }

                PreparedStatement userDB = signupdata.con.prepareStatement(query);

                userDB.setString(1, Fname);
                userDB.setString(2, Lname);
                userDB.setString(3, email);
                userDB.setString(4, PhoneNumber);
                userDB.setString(5, password);
                userDB.setString(6, gender);
                userDB.setInt(7, countryId.get(ComboBoxCountry.getSelectedIndex()));

                userDB.executeUpdate();
                
                Notifications.getInstance().show(Notifications.Type.SUCCESS, "Sign Up Successfully, Now Please Sign In");
            } catch (Exception e) {
                Notifications.getInstance().show(Notifications.Type.WARNING, "Error Conection");
            }
            FormsManager.getInstance().showForm(new sign_in());
        } else if (!IsValidEmail(email)){
            lab_errorEmail.setText("Incorrect Email, Please enter a valid email address.");
            lab_errorEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(255, 0, 0)));
            Notifications.getInstance().show(Notifications.Type.ERROR, "Invalid Email. Please enter a valid email address.");
        } else {
            Notifications.getInstance().show(Notifications.Type.ERROR, "Please Inter All Data!");
        }

    }//GEN-LAST:event_btn_signUpActionPerformed

    private void btn_signinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_signinActionPerformed
        FormsManager.getInstance().showForm(new sign_in());
    }//GEN-LAST:event_btn_signinActionPerformed


    private void ComboBoxCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxCountryActionPerformed
        setcountry();
    }//GEN-LAST:event_ComboBoxCountryActionPerformed

    private void txt_FnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_FnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_FnameActionPerformed

    private void txt_LnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_LnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_LnameActionPerformed

    private void PasswordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PasswordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PasswordFieldActionPerformed

    private void txt_phoneNumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_phoneNumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_phoneNumActionPerformed

    private void rbn_maleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbn_maleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbn_maleActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxCountry;
    private javax.swing.JPasswordField PasswordField;
    private javax.swing.JProgressBar bar_medium;
    private javax.swing.JProgressBar bar_strong;
    private javax.swing.JProgressBar bar_week;
    private javax.swing.JButton btn_signUp;
    private javax.swing.JButton btn_signin;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JLabel lab_Fname;
    private javax.swing.JLabel lab_Lname;
    private javax.swing.JLabel lab_countryKey;
    private javax.swing.JLabel lab_email;
    private javax.swing.JLabel lab_errorEmail;
    private javax.swing.JLabel lab_gender;
    private javax.swing.JLabel lab_haveAccout;
    private javax.swing.JLabel lab_id;
    private javax.swing.JLabel lab_password;
    private javax.swing.JLabel lab_passwordStatus;
    private javax.swing.JLabel lab_year;
    private javax.swing.JLabel lb_Description;
    private javax.swing.JLabel lb_Title;
    private Components.PanelRound panelRound1;
    private javax.swing.JRadioButton rbn_female;
    private javax.swing.JRadioButton rbn_male;
    private SVGIcon.svgIcon svgIconCountry;
    private javax.swing.JTextField txt_Fname;
    private javax.swing.JTextField txt_Lname;
    private javax.swing.JTextField txt_email;
    private javax.swing.JTextField txt_phoneNum;
    // End of variables declaration//GEN-END:variables

}
