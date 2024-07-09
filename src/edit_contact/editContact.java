package edit_contact;

import DBConnection.databaseConnection;
import Forms_manager.FormsManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import raven.toast.Notifications;
import sign_in.sign_in;
import view_my_contact.viewContact;

public class editContact extends javax.swing.JPanel {

    databaseConnection showContact = new databaseConnection();
    databaseConnection editContact = new databaseConnection();

    ArrayList<Integer> countryId = new ArrayList<>();
    ArrayList<String> countryKey = new ArrayList<>();
    ArrayList<Integer> relactionId = new ArrayList<>();
    sign_in UserID = new sign_in();
    viewContact contactEmail = new viewContact();
    viewContact Faveorite = new viewContact();

    public editContact() {
        initComponents();
        fillComboBox();
        setData();
        setcountry();
    }

    private void fillComboBox() {

        try {

            PreparedStatement countryName = editContact.con.prepareStatement("select country_id, country_name , country_Phone_Number_Key from phonebookDB.country");
            PreparedStatement relaction = editContact.con.prepareStatement("select * from phonebookDB.contact_relationship");

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
        
    private void setData() {

        String query = "select contactsDB.contact_id , contactsDB.contact_Fname , contactsDB.contact_Lname , contactsDB.contact_phoneNumber , contactsDB.contact_email , contactsDB.contact_city , contactsDB.contact_address , contactsDB.contact_gender , contactsDB.job_title , contactsDB.job_location , contactsDB.job_company , contactsDB.chatApp , contactsDB.contact_GitHub , contactsDB.contact_LinkedIn , contactsDB.contact_Facebook , country.country_name , contact_relationship.relationship from contactsDB , country Where contactsDB.contact_email = ? && contactsDB.country_id = country.country_id && contact_relationship.relationship_id = contactsDB.relationship_id";
        //int email = contactEmail.checkEmail;
                //contactEmail.checkEmail;
        try {
            PreparedStatement ShowContactData = showContact.con.prepareStatement(query);
            ShowContactData.setString(1, contactEmail.checkEmail);
            
            ResultSet data = ShowContactData.executeQuery();

            while (data.next()) {
                if (contactEmail.checkEmail == data.getString("contactsDB.contact_email")){
                    
                txt_FName.setText(data.getString("contactsDB.contact_Fname"));
                txt_LName.setText(data.getString("contactsDB.contact_Lname"));
                txt_Email.setText(data.getString("contactsDB.contact_email"));
                txt_PhoneNumber.setText(data.getString("contactsDB.contact_phoneNumber"));

                txt_City.setText(data.getString("contactsDB.contact_city"));
                txt_address.setText(data.getString("contactsDB.contact_address"));

                if (data.getString("contactsDB.contact_gender") != "Male"){
                    rbn_male.setSelected(true);
                } else {
                    rbn_female.setSelected(true);
                }
                
                txt_JobTitle.setText(data.getString("contactsDB.job_title"));
                txt_JobLocation.setText(data.getString("contactsDB.job_location"));
                txt_Company.setText(data.getString("contactsDB.job_company"));
                txt_ChatApp.setText(data.getString("contactsDB.chatApp"));
                
                txt_GitHub.setText(data.getString("contactsDB.contact_GitHub"));
                txt_LinkedIn.setText(data.getString("contactsDB.contact_LinkedIn"));
                txt_FaceBook.setText(data.getString("contactsDB.contact_Facebook"));
                
                ComboBoxCountry.setSelectedItem(data.getString("country.country_name"));
                ComboBoxRelathionship.setSelectedItem(data.getString("contact_relationship.relationship"));
            }
            }

        } catch (SQLException ex) {
            Notifications.getInstance().show(Notifications.Type.ERROR, "There is No Connection To Database");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        panAll = new Components.PanelRound();
        lab_edit = new javax.swing.JLabel();
        btn_cancel = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        lab_fullName1 = new javax.swing.JLabel();
        txt_FName = new javax.swing.JTextField();
        txt_LName = new javax.swing.JTextField();
        txt_Email = new javax.swing.JTextField();
        lab_email1 = new javax.swing.JLabel();
        lab_phoneNumber1 = new javax.swing.JLabel();
        txt_PhoneNumber = new javax.swing.JTextField();
        ComboBoxCountry = new javax.swing.JComboBox<>();
        txt_City = new javax.swing.JTextField();
        txt_address = new javax.swing.JTextField();
        ComboBoxRelathionship = new javax.swing.JComboBox<>();
        lab_country = new javax.swing.JLabel();
        lab_city = new javax.swing.JLabel();
        lab_address = new javax.swing.JLabel();
        lab_phoneNumber = new javax.swing.JLabel();
        lab_jobTitle = new javax.swing.JLabel();
        txt_JobTitle = new javax.swing.JTextField();
        lab_jobLocation1 = new javax.swing.JLabel();
        txt_JobLocation = new javax.swing.JTextField();
        lab_company = new javax.swing.JLabel();
        txt_Company = new javax.swing.JTextField();
        lab_ChatApp = new javax.swing.JLabel();
        txt_ChatApp = new javax.swing.JTextField();
        lab_linkedIn = new javax.swing.JLabel();
        txt_LinkedIn = new javax.swing.JTextField();
        lab_github = new javax.swing.JLabel();
        txt_GitHub = new javax.swing.JTextField();
        lab_facebook = new javax.swing.JLabel();
        txt_FaceBook = new javax.swing.JTextField();
        lab_gender = new javax.swing.JLabel();
        rbn_male = new javax.swing.JRadioButton();
        rbn_female = new javax.swing.JRadioButton();
        lab_countryKey = new javax.swing.JLabel();
        svgIconCountry = new SVGIcon.svgIcon();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panAll.setBackground(new java.awt.Color(226, 226, 226));
        panAll.setRoundBottomLeft(35);
        panAll.setRoundBottomRight(35);
        panAll.setRoundTopLeft(35);
        panAll.setRoundTopRight(35);
        panAll.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lab_edit.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lab_edit.setForeground(new java.awt.Color(0, 0, 0));
        lab_edit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_edit.setText("Choose The Contact to Edit");
        panAll.add(lab_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, 410, -1));

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
        panAll.add(btn_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 610, 200, 30));

        btn_edit.setBackground(new java.awt.Color(21, 101, 192));
        btn_edit.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_edit.setForeground(new java.awt.Color(255, 255, 255));
        btn_edit.setText("Edit");
        btn_edit.setBorderPainted(false);
        btn_edit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });
        panAll.add(btn_edit, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 610, 200, 30));

        lab_fullName1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lab_fullName1.setForeground(new java.awt.Color(0, 0, 0));
        lab_fullName1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lab_fullName1.setText("Full Name");
        panAll.add(lab_fullName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, 80, 35));

        txt_FName.setBackground(new java.awt.Color(206, 211, 214));
        txt_FName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panAll.add(txt_FName, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 140, 35));

        txt_LName.setBackground(new java.awt.Color(206, 211, 214));
        txt_LName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panAll.add(txt_LName, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 140, 35));

        txt_Email.setBackground(new java.awt.Color(206, 211, 214));
        txt_Email.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panAll.add(txt_Email, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 190, 300, 35));

        lab_email1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lab_email1.setForeground(new java.awt.Color(0, 0, 0));
        lab_email1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lab_email1.setText("Email Address");
        panAll.add(lab_email1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 190, 100, 35));

        lab_phoneNumber1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lab_phoneNumber1.setForeground(new java.awt.Color(0, 0, 0));
        lab_phoneNumber1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lab_phoneNumber1.setText("Phone Number");
        panAll.add(lab_phoneNumber1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 110, 35));

        txt_PhoneNumber.setBackground(new java.awt.Color(206, 211, 214));
        txt_PhoneNumber.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panAll.add(txt_PhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 250, 35));

        ComboBoxCountry.setBackground(new java.awt.Color(206, 211, 214));
        ComboBoxCountry.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ComboBoxCountry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxCountryActionPerformed(evt);
            }
        });
        panAll.add(ComboBoxCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 200, 35));

        txt_City.setBackground(new java.awt.Color(206, 211, 214));
        txt_City.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panAll.add(txt_City, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, 310, 35));

        txt_address.setBackground(new java.awt.Color(206, 211, 214));
        txt_address.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panAll.add(txt_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 430, 310, 35));

        ComboBoxRelathionship.setBackground(new java.awt.Color(206, 211, 214));
        ComboBoxRelathionship.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ComboBoxRelathionship.setForeground(new java.awt.Color(0, 0, 0));
        ComboBoxRelathionship.setToolTipText("\n");
        panAll.add(ComboBoxRelathionship, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 480, 200, 35));

        lab_country.setBackground(new java.awt.Color(206, 211, 214));
        lab_country.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lab_country.setForeground(new java.awt.Color(0, 0, 0));
        lab_country.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lab_country.setText("Country");
        panAll.add(lab_country, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 290, 60, 35));

        lab_city.setBackground(new java.awt.Color(206, 211, 214));
        lab_city.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lab_city.setForeground(new java.awt.Color(0, 0, 0));
        lab_city.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lab_city.setText("City");
        panAll.add(lab_city, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 380, 40, 35));

        lab_address.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lab_address.setForeground(new java.awt.Color(0, 0, 0));
        lab_address.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lab_address.setText("Address");
        panAll.add(lab_address, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 430, 70, 35));

        lab_phoneNumber.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lab_phoneNumber.setForeground(new java.awt.Color(0, 0, 0));
        lab_phoneNumber.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lab_phoneNumber.setText("Relathionship");
        panAll.add(lab_phoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 480, 100, 35));

        lab_jobTitle.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lab_jobTitle.setForeground(new java.awt.Color(0, 0, 0));
        lab_jobTitle.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lab_jobTitle.setText("Job Title");
        panAll.add(lab_jobTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 190, 100, 35));

        txt_JobTitle.setBackground(new java.awt.Color(206, 211, 214));
        txt_JobTitle.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panAll.add(txt_JobTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 190, 250, 35));

        lab_jobLocation1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lab_jobLocation1.setForeground(new java.awt.Color(0, 0, 0));
        lab_jobLocation1.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lab_jobLocation1.setText("Job Location");
        panAll.add(lab_jobLocation1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 240, 100, 35));

        txt_JobLocation.setBackground(new java.awt.Color(206, 211, 214));
        txt_JobLocation.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panAll.add(txt_JobLocation, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 240, 250, 35));

        lab_company.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lab_company.setForeground(new java.awt.Color(0, 0, 0));
        lab_company.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lab_company.setText("Company");
        panAll.add(lab_company, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 290, 100, 35));

        txt_Company.setBackground(new java.awt.Color(206, 211, 214));
        txt_Company.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panAll.add(txt_Company, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 290, 250, 35));

        lab_ChatApp.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lab_ChatApp.setForeground(new java.awt.Color(0, 0, 0));
        lab_ChatApp.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lab_ChatApp.setText("Chat App");
        panAll.add(lab_ChatApp, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 140, 100, 35));

        txt_ChatApp.setBackground(new java.awt.Color(206, 211, 214));
        txt_ChatApp.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panAll.add(txt_ChatApp, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 140, 250, 35));

        lab_linkedIn.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lab_linkedIn.setForeground(new java.awt.Color(0, 0, 0));
        lab_linkedIn.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lab_linkedIn.setText("LinkedIn");
        panAll.add(lab_linkedIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 380, 100, 35));

        txt_LinkedIn.setBackground(new java.awt.Color(206, 211, 214));
        txt_LinkedIn.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panAll.add(txt_LinkedIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 380, 250, 35));

        lab_github.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lab_github.setForeground(new java.awt.Color(0, 0, 0));
        lab_github.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lab_github.setText("GitHub");
        panAll.add(lab_github, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 440, 100, 35));

        txt_GitHub.setBackground(new java.awt.Color(206, 211, 214));
        txt_GitHub.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panAll.add(txt_GitHub, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 440, 250, 35));

        lab_facebook.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lab_facebook.setForeground(new java.awt.Color(0, 0, 0));
        lab_facebook.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lab_facebook.setText("FaceBook");
        panAll.add(lab_facebook, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 500, 100, 35));

        txt_FaceBook.setBackground(new java.awt.Color(206, 211, 214));
        txt_FaceBook.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panAll.add(txt_FaceBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(800, 500, 250, 35));

        lab_gender.setBackground(new java.awt.Color(206, 211, 214));
        lab_gender.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lab_gender.setForeground(new java.awt.Color(0, 0, 0));
        lab_gender.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lab_gender.setText("Gender");
        panAll.add(lab_gender, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 530, 60, -1));

        buttonGroup.add(rbn_male);
        rbn_male.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbn_male.setForeground(new java.awt.Color(0, 0, 0));
        rbn_male.setSelected(true);
        rbn_male.setText("Male");
        panAll.add(rbn_male, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 530, -1, -1));

        buttonGroup.add(rbn_female);
        rbn_female.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        rbn_female.setForeground(new java.awt.Color(0, 0, 0));
        rbn_female.setText("Female");
        panAll.add(rbn_female, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 530, -1, -1));

        lab_countryKey.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lab_countryKey.setForeground(new java.awt.Color(0, 0, 0));
        lab_countryKey.setToolTipText("");
        panAll.add(lab_countryKey, new org.netbeans.lib.awtextra.AbsoluteConstraints(426, 240, 52, 33));
        panAll.add(svgIconCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 290, 25, 25));

        add(panAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 1140, 680));
    }// </editor-fold>//GEN-END:initComponents


    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed

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

        if (!txt_LName.getText().isEmpty() && !txt_FName.getText().isEmpty()
                && !txt_Email.getText().isEmpty() && !txt_PhoneNumber.getText().isEmpty()
                && !txt_City.getText().isEmpty() && !txt_address.getText().isEmpty()
                && !txt_JobTitle.getText().isEmpty() && !txt_JobLocation.getText().isEmpty()
                && !txt_Company.getText().isEmpty() && !txt_ChatApp.getText().isEmpty()
                && !txt_LinkedIn.getText().isEmpty() && !txt_GitHub.getText().isEmpty()
                && !txt_FaceBook.getText().isEmpty()) {

            try {
                PreparedStatement data = editContact.con.prepareStatement("update contactsDB set user_id = ? , contact_Fname = ? , contact_Lname = ? , contact_phoneNumber = ? , contact_email = ? , country_id = ? , contact_city = ? , contact_address = ? , relationship_id = ? , contact_gender = ? , job_title = ? , job_location = ? , job_company = ? , chatApp = ? , contact_Github = ? , contact_LinkedIn = ? , contact_Facebook = ? , Faveorite_contact = ?;");

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
                Notifications.getInstance().show(Notifications.Type.SUCCESS, "Edit The Contact Successfully");
                FormsManager.getInstance().showForm(new viewContact());
            } catch (Exception e) {
                Notifications.getInstance().show(Notifications.Type.ERROR, "There is No Connection To Database!");
            }
        }

    }//GEN-LAST:event_btn_editActionPerformed

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
    private javax.swing.JButton btn_edit;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JLabel lab_ChatApp;
    private javax.swing.JLabel lab_address;
    private javax.swing.JLabel lab_city;
    private javax.swing.JLabel lab_company;
    private javax.swing.JLabel lab_country;
    private javax.swing.JLabel lab_countryKey;
    private javax.swing.JLabel lab_edit;
    private javax.swing.JLabel lab_email1;
    private javax.swing.JLabel lab_facebook;
    private javax.swing.JLabel lab_fullName1;
    private javax.swing.JLabel lab_gender;
    private javax.swing.JLabel lab_github;
    private javax.swing.JLabel lab_jobLocation1;
    private javax.swing.JLabel lab_jobTitle;
    private javax.swing.JLabel lab_linkedIn;
    private javax.swing.JLabel lab_phoneNumber;
    private javax.swing.JLabel lab_phoneNumber1;
    private Components.PanelRound panAll;
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
    // End of variables declaration//GEN-END:variables
}
