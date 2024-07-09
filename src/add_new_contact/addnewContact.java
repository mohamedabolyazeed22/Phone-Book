package add_new_contact;

import DBConnection.databaseConnection;
import Forms_manager.FormsManager;
import com.formdev.flatlaf.FlatClientProperties;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import raven.toast.Notifications;
import sign_in.sign_in;
import view_my_contact.viewContact;

public class addnewContact extends javax.swing.JPanel {

    databaseConnection addContact = new databaseConnection();

    ArrayList<Integer> countryId = new ArrayList<>();
    ArrayList<String> countryKey = new ArrayList<>();
    ArrayList<Integer> relactionId = new ArrayList<>();
    sign_in UserID = new sign_in();
    viewContact Faveorite = new viewContact();
    
    public addnewContact() {
        initComponents();
        fillText();
        fillComboBox();
        setcountry();
    }

    // methode to set text in TextField
    private void fillText() {
        txt_FName.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "First Name");
        txt_LName.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Last Name");
        txt_PhoneNumber.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "e.g. 010,011,012");
        txt_Email.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "e.g. example@gmail.com");

        txt_City.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter Your City");
        txt_address.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "street name. home number");

        txt_JobTitle.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter The Job Title");
        txt_JobLocation.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter The Job Location");
        txt_Company.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter The Company");

        //txtA_details.setText("Enter Some Details About The Contact");
        txt_ChatApp.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "e.g. whatsApp,Instagram,Messenger");
        txt_LinkedIn.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter The LinkedIn");
        txt_GitHub.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter The GitHub");
        txt_FaceBook.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Enter The FaceBook");
    }

    // to make code easy and with high filexiblity make an object from sign_up calss
    // and use the funcion fillComboBoxCountry() here 
    private void fillComboBox() {

        try {

            PreparedStatement countryName = addContact.con.prepareStatement("select country_id, country_name , country_Phone_Number_Key from phonebookDB.country");
            PreparedStatement relaction = addContact.con.prepareStatement("select * from phonebookDB.contact_relationship");

            ResultSet countryData = countryName.executeQuery();
            ResultSet relactionData = relaction.executeQuery();

            while (countryData.next()) {
                countryId.add(countryData.getInt(1));
                ComboBoxCountry.addItem(countryData.getString(2));
                countryKey.add(countryData.getString(3));

            }

            while (relactionData.next()) {
                relactionId.add(relactionData.getInt(1));
                ComboBoxRelathionship.addItem(relactionData.getString(2));
            }
        } catch (SQLException ex) {
            Notifications.getInstance().show(Notifications.Type.ERROR, "Error");
        }
    }

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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        panelRound1 = new Components.PanelRound();
        txt_data = new javax.swing.JLabel();
        txt_LName = new javax.swing.JTextField();
        txt_PhoneNumber = new javax.swing.JTextField();
        txt_Email = new javax.swing.JTextField();
        txt_ChatApp = new javax.swing.JTextField();
        btn_cancel = new javax.swing.JButton();
        txt_JobTitle = new javax.swing.JTextField();
        txt_JobLocation = new javax.swing.JTextField();
        txt_Company = new javax.swing.JTextField();
        txt_LinkedIn = new javax.swing.JTextField();
        lab_city = new javax.swing.JLabel();
        ComboBoxRelathionship = new javax.swing.JComboBox<>();
        rbn_male = new javax.swing.JRadioButton();
        lab_gender = new javax.swing.JLabel();
        rbn_female = new javax.swing.JRadioButton();
        txt_FaceBook = new javax.swing.JTextField();
        btn_save = new javax.swing.JButton();
        txt_City = new javax.swing.JTextField();
        txt_FName = new javax.swing.JTextField();
        lab_address = new javax.swing.JLabel();
        lab_company = new javax.swing.JLabel();
        lab_phoneNumber = new javax.swing.JLabel();
        lab_country = new javax.swing.JLabel();
        txt_address = new javax.swing.JTextField();
        lab_fullName = new javax.swing.JLabel();
        lab_jobTitle = new javax.swing.JLabel();
        lab_ChatApp = new javax.swing.JLabel();
        lab_linkedIn = new javax.swing.JLabel();
        lab_github = new javax.swing.JLabel();
        lab_facebook = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        lab_fullName1 = new javax.swing.JLabel();
        lab_email1 = new javax.swing.JLabel();
        ComboBoxCountry = new javax.swing.JComboBox<>();
        lab_phoneNumber1 = new javax.swing.JLabel();
        lab_jobLocation1 = new javax.swing.JLabel();
        lab_countryKey = new javax.swing.JLabel();
        svgIconCountry = new SVGIcon.svgIcon();
        txt_GitHub = new javax.swing.JTextField();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound1.setBackground(new java.awt.Color(226, 226, 226));
        panelRound1.setRoundBottomLeft(35);
        panelRound1.setRoundBottomRight(35);
        panelRound1.setRoundTopLeft(35);
        panelRound1.setRoundTopRight(35);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_data.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        txt_data.setForeground(new java.awt.Color(0, 0, 0));
        txt_data.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        txt_data.setText("Insert The data to add new contact");
        panelRound1.add(txt_data, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 30, -1, -1));

        txt_LName.setBackground(new java.awt.Color(206, 211, 214));
        txt_LName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panelRound1.add(txt_LName, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, 140, 35));

        txt_PhoneNumber.setBackground(new java.awt.Color(206, 211, 214));
        txt_PhoneNumber.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panelRound1.add(txt_PhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 280, 240, 35));

        txt_Email.setBackground(new java.awt.Color(206, 211, 214));
        txt_Email.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panelRound1.add(txt_Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, 300, 35));

        txt_ChatApp.setBackground(new java.awt.Color(206, 211, 214));
        txt_ChatApp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panelRound1.add(txt_ChatApp, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 350, 300, 35));

        btn_cancel.setBackground(new java.awt.Color(21, 101, 192));
        btn_cancel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_cancel.setForeground(new java.awt.Color(255, 255, 255));
        btn_cancel.setText("Cancel");
        btn_cancel.setBorderPainted(false);
        btn_cancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cancelActionPerformed(evt);
            }
        });
        panelRound1.add(btn_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 630, 250, -1));

        txt_JobTitle.setBackground(new java.awt.Color(206, 211, 214));
        txt_JobTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panelRound1.add(txt_JobTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 160, 300, 35));

        txt_JobLocation.setBackground(new java.awt.Color(206, 211, 214));
        txt_JobLocation.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panelRound1.add(txt_JobLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 220, 300, 35));

        txt_Company.setBackground(new java.awt.Color(206, 211, 214));
        txt_Company.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panelRound1.add(txt_Company, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 280, 300, 35));

        txt_LinkedIn.setBackground(new java.awt.Color(206, 211, 214));
        txt_LinkedIn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panelRound1.add(txt_LinkedIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 410, 300, 35));

        lab_city.setBackground(new java.awt.Color(206, 211, 214));
        lab_city.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lab_city.setForeground(new java.awt.Color(0, 0, 0));
        lab_city.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lab_city.setText("City");
        panelRound1.add(lab_city, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 460, 40, 35));

        ComboBoxRelathionship.setBackground(new java.awt.Color(206, 211, 214));
        ComboBoxRelathionship.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ComboBoxRelathionship.setForeground(new java.awt.Color(0, 0, 0));
        ComboBoxRelathionship.setToolTipText("\n");
        panelRound1.add(ComboBoxRelathionship, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 570, 200, 35));

        buttonGroup.add(rbn_male);
        rbn_male.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbn_male.setForeground(new java.awt.Color(0, 0, 0));
        rbn_male.setSelected(true);
        rbn_male.setText("Male");
        panelRound1.add(rbn_male, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 330, -1, -1));

        lab_gender.setBackground(new java.awt.Color(206, 211, 214));
        lab_gender.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lab_gender.setForeground(new java.awt.Color(0, 0, 0));
        lab_gender.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lab_gender.setText("Gender");
        panelRound1.add(lab_gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 330, 60, -1));

        buttonGroup.add(rbn_female);
        rbn_female.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbn_female.setForeground(new java.awt.Color(0, 0, 0));
        rbn_female.setText("Female");
        panelRound1.add(rbn_female, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 330, -1, -1));

        txt_FaceBook.setBackground(new java.awt.Color(206, 211, 214));
        txt_FaceBook.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panelRound1.add(txt_FaceBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 550, 300, 35));

        btn_save.setBackground(new java.awt.Color(21, 101, 192));
        btn_save.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_save.setForeground(new java.awt.Color(255, 255, 255));
        btn_save.setText("Save");
        btn_save.setBorderPainted(false);
        btn_save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_saveActionPerformed(evt);
            }
        });
        panelRound1.add(btn_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 630, 250, -1));

        txt_City.setBackground(new java.awt.Color(206, 211, 214));
        txt_City.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panelRound1.add(txt_City, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 460, 310, 35));

        txt_FName.setBackground(new java.awt.Color(206, 211, 214));
        txt_FName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panelRound1.add(txt_FName, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 140, 35));

        lab_address.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lab_address.setForeground(new java.awt.Color(0, 0, 0));
        lab_address.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lab_address.setText("Address");
        panelRound1.add(lab_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 520, 70, 35));

        lab_company.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lab_company.setForeground(new java.awt.Color(0, 0, 0));
        lab_company.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lab_company.setText("Company");
        panelRound1.add(lab_company, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 280, 100, 35));

        lab_phoneNumber.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lab_phoneNumber.setForeground(new java.awt.Color(0, 0, 0));
        lab_phoneNumber.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lab_phoneNumber.setText("Relathionship");
        panelRound1.add(lab_phoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 570, 100, 35));

        lab_country.setBackground(new java.awt.Color(206, 211, 214));
        lab_country.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lab_country.setForeground(new java.awt.Color(0, 0, 0));
        lab_country.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lab_country.setText("Country");
        panelRound1.add(lab_country, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, 60, 35));

        txt_address.setBackground(new java.awt.Color(206, 211, 214));
        txt_address.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panelRound1.add(txt_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 520, 310, 35));

        lab_fullName.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lab_fullName.setForeground(new java.awt.Color(0, 0, 0));
        lab_fullName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_fullName.setText("Contact info");
        panelRound1.add(lab_fullName, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, 35));

        lab_jobTitle.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lab_jobTitle.setForeground(new java.awt.Color(0, 0, 0));
        lab_jobTitle.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lab_jobTitle.setText("Job Title");
        panelRound1.add(lab_jobTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 160, 100, 35));

        lab_ChatApp.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lab_ChatApp.setForeground(new java.awt.Color(0, 0, 0));
        lab_ChatApp.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lab_ChatApp.setText("Chat App");
        panelRound1.add(lab_ChatApp, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 350, 100, 35));

        lab_linkedIn.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lab_linkedIn.setForeground(new java.awt.Color(0, 0, 0));
        lab_linkedIn.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lab_linkedIn.setText("LinkedIn");
        panelRound1.add(lab_linkedIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 410, 100, 35));

        lab_github.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lab_github.setForeground(new java.awt.Color(0, 0, 0));
        lab_github.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lab_github.setText("GitHub");
        panelRound1.add(lab_github, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 480, 100, 35));

        lab_facebook.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lab_facebook.setForeground(new java.awt.Color(0, 0, 0));
        lab_facebook.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lab_facebook.setText("FaceBook");
        panelRound1.add(lab_facebook, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 550, 100, 35));

        jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
        panelRound1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 450, 10));

        lab_fullName1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lab_fullName1.setForeground(new java.awt.Color(0, 0, 0));
        lab_fullName1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lab_fullName1.setText("Full Name");
        panelRound1.add(lab_fullName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 80, 35));

        lab_email1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lab_email1.setForeground(new java.awt.Color(0, 0, 0));
        lab_email1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lab_email1.setText("Email Address");
        panelRound1.add(lab_email1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 220, 100, 35));

        ComboBoxCountry.setBackground(new java.awt.Color(206, 211, 214));
        ComboBoxCountry.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ComboBoxCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxCountryActionPerformed(evt);
            }
        });
        panelRound1.add(ComboBoxCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 400, 200, 35));

        lab_phoneNumber1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lab_phoneNumber1.setForeground(new java.awt.Color(0, 0, 0));
        lab_phoneNumber1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lab_phoneNumber1.setText("Phone Number");
        panelRound1.add(lab_phoneNumber1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 280, 110, 35));

        lab_jobLocation1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lab_jobLocation1.setForeground(new java.awt.Color(0, 0, 0));
        lab_jobLocation1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lab_jobLocation1.setText("Job Location");
        panelRound1.add(lab_jobLocation1, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 220, 100, 35));

        lab_countryKey.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lab_countryKey.setForeground(new java.awt.Color(0, 0, 0));
        lab_countryKey.setToolTipText("");
        panelRound1.add(lab_countryKey, new org.netbeans.lib.awtextra.AbsoluteConstraints(426, 280, 52, 33));
        panelRound1.add(svgIconCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 400, 25, 25));

        txt_GitHub.setBackground(new java.awt.Color(206, 211, 214));
        txt_GitHub.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panelRound1.add(txt_GitHub, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 480, 300, 35));

        add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 1140, 680));
    }// </editor-fold>//GEN-END:initComponents

    // action methode to set the data into database and go to test11 frame
    // note that if the data is right give he message that is succseful

    /*
       Here your code mohamed baker
     */
    public boolean IsValidEmail(String email) {
        return email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9+_.-]+$");
    }

    private void btn_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_saveActionPerformed

        int userID = UserID.user_id;
        boolean contact_faveorite = Faveorite.flag;
        String Fname = txt_FName.getText();
        String Lname = txt_LName.getText();
        String email = txt_Email.getText();
        String phoneNumber = txt_PhoneNumber.getText();
        String city = txt_City.getText();
        String address = txt_address.getText();
        String jobTitle = txt_JobTitle.getText();
        String jobLocation = txt_JobLocation.getText();
        String company = txt_Company.getText();
        String chatApp = txt_ChatApp.getText();
        String linkedIn = txt_LinkedIn.getText();
        String github = txt_GitHub.getText();
        String facebook = txt_FaceBook.getText();
        String gender;

        if (rbn_male.isSelected()) {
            gender = "Male";
        } else {
            gender = "Female";
        }

        if (!Fname.isEmpty() && !Lname.isEmpty()
                && !email.isEmpty() && !phoneNumber.isEmpty()
                && !city.isEmpty() && !address.isEmpty()
                && !jobTitle.isEmpty() && !jobLocation.isEmpty()
                && !company.isEmpty() && !chatApp.isEmpty()
                && !linkedIn.isEmpty() && !github.isEmpty()
                && !facebook.isEmpty() && IsValidEmail(email)) {

            try {

                PreparedStatement data = addContact.con.prepareStatement("insert into contactsDB (user_id,contact_Fname,contact_Lname,contact_phoneNumber,contact_email,country_id,contact_city,contact_address,relationship_id,contact_gender,job_title,job_location,job_company,chatApp,contact_GitHub,contact_LinkedIn,contact_Facebook,Faveorite_contact) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);");

                data.setInt(1, userID);
                data.setString(2, Fname);
                data.setString(3, Lname);
                data.setString(4, phoneNumber);
                data.setString(5, email);
                data.setInt(6, countryId.get(ComboBoxCountry.getSelectedIndex()));
                data.setString(7, city);
                data.setString(8, address);
                data.setInt(9, relactionId.get(ComboBoxRelathionship.getSelectedIndex()));
                data.setString(10, gender);
                data.setString(11, jobTitle);
                data.setString(12, jobLocation);
                data.setString(13, company);
                data.setString(14, chatApp);
                data.setString(15, github);
                data.setString(16, linkedIn);
                data.setString(17, facebook);
                data.setBoolean(18, contact_faveorite);

                data.executeUpdate();
                Notifications.getInstance().show(Notifications.Type.SUCCESS, "Added The Contact Successfully");
            } catch (SQLException ex) {
                Notifications.getInstance().show(Notifications.Type.ERROR, "Error Conection");
            }
            FormsManager.getInstance().showForm(new viewContact());
        } else {
            Notifications.getInstance().show(Notifications.Type.ERROR, "Please Insert All The Data");
        }

    }//GEN-LAST:event_btn_saveActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        FormsManager.getInstance().showForm(new viewContact());
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void ComboBoxCountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxCountryActionPerformed
        setcountry();
    }//GEN-LAST:event_ComboBoxCountryActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> ComboBoxCountry;
    private javax.swing.JComboBox<String> ComboBoxRelathionship;
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_save;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lab_ChatApp;
    private javax.swing.JLabel lab_address;
    private javax.swing.JLabel lab_city;
    private javax.swing.JLabel lab_company;
    private javax.swing.JLabel lab_country;
    private javax.swing.JLabel lab_countryKey;
    private javax.swing.JLabel lab_email1;
    private javax.swing.JLabel lab_facebook;
    private javax.swing.JLabel lab_fullName;
    private javax.swing.JLabel lab_fullName1;
    private javax.swing.JLabel lab_gender;
    private javax.swing.JLabel lab_github;
    private javax.swing.JLabel lab_jobLocation1;
    private javax.swing.JLabel lab_jobTitle;
    private javax.swing.JLabel lab_linkedIn;
    private javax.swing.JLabel lab_phoneNumber;
    private javax.swing.JLabel lab_phoneNumber1;
    private Components.PanelRound panelRound1;
    private javax.swing.JRadioButton rbn_female;
    private javax.swing.JRadioButton rbn_male;
    private SVGIcon.svgIcon svgIconCountry;
    private javax.swing.JTextField txt_ChatApp;
    private javax.swing.JTextField txt_City;
    private javax.swing.JTextField txt_Company;
    private javax.swing.JTextField txt_Email;
    private javax.swing.JTextField txt_FName;
    private javax.swing.JTextField txt_FaceBook;
    private javax.swing.JTextField txt_GitHub;
    private javax.swing.JTextField txt_JobLocation;
    private javax.swing.JTextField txt_JobTitle;
    private javax.swing.JTextField txt_LName;
    private javax.swing.JTextField txt_LinkedIn;
    private javax.swing.JTextField txt_PhoneNumber;
    private javax.swing.JTextField txt_address;
    private javax.swing.JLabel txt_data;
    // End of variables declaration//GEN-END:variables
}
