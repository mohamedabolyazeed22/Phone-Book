package view_my_contact;

import CurrencyService.currencyService;
import DBConnection.databaseConnection;
import FavoriteContacts.favoriteContacts;
import Forms_manager.FormsManager;
import add_new_contact.addnewContact;
import com.formdev.flatlaf.FlatClientProperties;
import edit_contact.editContact;
import java.awt.Color;
import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// For Serach 
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

import raven.toast.Notifications;
import sign_in.sign_in;

public class viewContact extends javax.swing.JPanel {

    private int count = 1;

    DefaultTableModel contactview;
    databaseConnection viewForm = new databaseConnection();
    databaseConnection table = new databaseConnection();
    databaseConnection deletetable = new databaseConnection();

    ArrayList<Integer> contactData = new ArrayList<>();
    ArrayList<Integer> contactId = new ArrayList<>();

    databaseConnection contactDB = new databaseConnection();
    ArrayList<Integer> countryId = new ArrayList<>();
    ArrayList<Integer> relactionId = new ArrayList<>();

    sign_in UserID = new sign_in();

    public viewContact() {
        initComponents();
        init();
        setUserData();
        fillText();
        setUserIcons();
        contactview = new DefaultTableModel();

        contactview.addColumn("Name");
        contactview.addColumn("Job Title");
        contactview.addColumn("Phone Number");
        contactview.addColumn("Email");
        setTableData();

        pan_contact.setVisible(false);
    }

    /*
        Give The wattsab link to make the user to open the account
        for the contact like linkedin and github and facebook and the chat app and the gmail
    
        try{
        Desktop.getDesktop().browse(new URL("https://www.google.com").toURI());
        } catch(Exception e){
        
        }    
     */
    private void init() {

    }

    private void fillText() {
        txt_search.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Search Contact");
    }

    private void setUserIcons() {
        svgIconregDate.setSVGIcon("Icons/Icalendar.svg", 35, 35);
        svgIconphoneNum.setSVGIcon("Icons/Phone.svg", 35, 35);
        svgIconuserCountry.setSVGIcon("Icons/GitHub.svg", 35, 35);
        svgIconSearch.setSVGIcon("Icons/Search.svg", 30, 30);
    }

    private void setUserData() {

        String query = "select userDB.user_id, CONCAT(userDB.Fname, ' ' ,userDB.Lname) AS userName, userDB.user_email, userDB.user_phoneNumber, userDB.user_gender, country.country_name, userDB.reg_date from userDB,country  where userDB.country_id = country.country_id;";
        String checkGender = "";

        try {
            PreparedStatement userviewData = viewForm.con.prepareStatement(query);

            ResultSet data = userviewData.executeQuery();

            while (data.next()) {

                int checkId = data.getInt(1);

                if (UserID.user_id == checkId) {

                    checkGender = data.getString(5);

                    if (checkGender != "Male") {
                        svgIconUser.setSVGIcon("Icons/User Male.svg", 100, 100);
                    } else {
                        svgIconUser.setSVGIcon("Icons/Female User.svg", 100, 100);
                    }

                    lab_userName.setText(data.getString(2));
                    lab_userEmail.setText(data.getString(3));
                    lab_userRegistrationDate.setText(data.getString(7));
                    lab_userPhoneNumber.setText(data.getString(4));
                    lab_userCountry.setText(data.getString(6));

                }
            }

        } catch (Exception e) {
            Notifications.getInstance().show(Notifications.Type.ERROR, "There is No Connection To Databas");
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pan_userInfo = new Components.PanelRound();
        svgIconUser = new SVGIcon.svgIcon();
        lab_userName = new javax.swing.JLabel();
        lab_userEmail = new javax.swing.JLabel();
        lab_userRegistrationDate = new javax.swing.JLabel();
        svgIconregDate = new SVGIcon.svgIcon();
        svgIconphoneNum = new SVGIcon.svgIcon();
        lab_userPhoneNumber = new javax.swing.JLabel();
        svgIconuserCountry = new SVGIcon.svgIcon();
        lab_userCountry = new javax.swing.JLabel();
        lab_PhoneBook = new javax.swing.JLabel();
        btn_Logout = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        pan_search = new Components.PanelRound();
        txt_search = new javax.swing.JTextField();
        svgIconSearch = new SVGIcon.svgIcon();
        btn_addContact = new javax.swing.JButton();
        pan_contact = new Components.PanelRound();
        svgIconContact = new SVGIcon.svgIcon();
        lab_contactName = new javax.swing.JLabel();
        lab_contactRelationship = new javax.swing.JLabel();
        pan_buttom = new Components.PanelRound();
        panContact = new Components.PanelRound();
        lab_contact = new javax.swing.JLabel();
        panWork = new Components.PanelRound();
        lab_work = new javax.swing.JLabel();
        panAbout = new Components.PanelRound();
        lab_about = new javax.swing.JLabel();
        pan_details = new Components.PanelRound();
        lab1 = new javax.swing.JLabel();
        lab11 = new javax.swing.JLabel();
        lab2 = new javax.swing.JLabel();
        lab22 = new javax.swing.JLabel();
        lab3 = new javax.swing.JLabel();
        lab33 = new javax.swing.JLabel();
        lab4 = new javax.swing.JLabel();
        lab44 = new javax.swing.JLabel();
        svgIconLab1 = new SVGIcon.svgIcon();
        svgIconLab2 = new SVGIcon.svgIcon();
        svgIconLab3 = new SVGIcon.svgIcon();
        svgIconLab4 = new SVGIcon.svgIcon();
        buttonDelete = new Components.Button();
        buttonEdit = new Components.Button();
        buttonFavorite = new Components.Button();
        scrollPane = new Components.ScrollPaneWin11();
        contactTable = new contactData.Table();
        btn_favoriteContacts = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pan_userInfo.setBackground(new java.awt.Color(226, 226, 226));
        pan_userInfo.setPreferredSize(new java.awt.Dimension(243, 503));
        pan_userInfo.setRoundBottomLeft(15);
        pan_userInfo.setRoundBottomRight(15);
        pan_userInfo.setRoundTopLeft(15);
        pan_userInfo.setRoundTopRight(15);
        pan_userInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pan_userInfo.add(svgIconUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 100, 100));

        lab_userName.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        lab_userName.setForeground(new java.awt.Color(38, 50, 56));
        lab_userName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pan_userInfo.add(lab_userName, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 200, 30));

        lab_userEmail.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lab_userEmail.setForeground(new java.awt.Color(33, 33, 33));
        lab_userEmail.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pan_userInfo.add(lab_userEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 200, 25));

        lab_userRegistrationDate.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lab_userRegistrationDate.setForeground(new java.awt.Color(33, 33, 33));
        pan_userInfo.add(lab_userRegistrationDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 380, 140, 20));
        pan_userInfo.add(svgIconregDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 35, 35));
        pan_userInfo.add(svgIconphoneNum, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, 35, 35));

        lab_userPhoneNumber.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lab_userPhoneNumber.setForeground(new java.awt.Color(33, 33, 33));
        pan_userInfo.add(lab_userPhoneNumber, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 430, 140, 20));
        pan_userInfo.add(svgIconuserCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, 35, 35));

        lab_userCountry.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lab_userCountry.setForeground(new java.awt.Color(33, 33, 33));
        pan_userInfo.add(lab_userCountry, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 480, 140, 20));

        lab_PhoneBook.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lab_PhoneBook.setForeground(new java.awt.Color(38, 50, 56));
        lab_PhoneBook.setText("Peaky Blinders");
        lab_PhoneBook.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lab_PhoneBook.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lab_PhoneBookMouseClicked(evt);
            }
        });
        pan_userInfo.add(lab_PhoneBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 170, 30));

        btn_Logout.setBackground(new java.awt.Color(21, 101, 192));
        btn_Logout.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Logout.setForeground(new java.awt.Color(255, 255, 255));
        btn_Logout.setText("Log out");
        btn_Logout.setBorderPainted(false);
        btn_Logout.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_LogoutActionPerformed(evt);
            }
        });
        pan_userInfo.add(btn_Logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 610, 150, 30));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(19, 91, 174));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Currency Service");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        pan_userInfo.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 650, 170, -1));

        add(pan_userInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 240, 680));

        pan_search.setBackground(new java.awt.Color(226, 226, 226));
        pan_search.setRoundBottomLeft(15);
        pan_search.setRoundBottomRight(15);
        pan_search.setRoundTopLeft(15);
        pan_search.setRoundTopRight(15);
        pan_search.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txt_search.setBackground(new java.awt.Color(206, 211, 214));
        txt_search.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        txt_search.setVerifyInputWhenFocusTarget(false);
        txt_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_searchActionPerformed(evt);
            }
        });
        txt_search.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_searchKeyReleased(evt);
            }
        });
        pan_search.add(txt_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 500, 30));
        pan_search.add(svgIconSearch, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 30, 30));

        btn_addContact.setBackground(new java.awt.Color(21, 101, 192));
        btn_addContact.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        btn_addContact.setForeground(new java.awt.Color(255, 255, 255));
        btn_addContact.setText("Add New Contact");
        btn_addContact.setBorderPainted(false);
        btn_addContact.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_addContact.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addContactActionPerformed(evt);
            }
        });
        pan_search.add(btn_addContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 20, 150, 30));

        add(pan_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, 910, 80));

        pan_contact.setBackground(new java.awt.Color(226, 226, 226));
        pan_contact.setRoundBottomLeft(30);
        pan_contact.setRoundBottomRight(30);
        pan_contact.setRoundTopLeft(30);
        pan_contact.setRoundTopRight(30);
        pan_contact.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pan_contact.add(svgIconContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 90, 90));

        lab_contactName.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        lab_contactName.setForeground(new java.awt.Color(38, 50, 56));
        lab_contactName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pan_contact.add(lab_contactName, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, 160, 27));

        lab_contactRelationship.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lab_contactRelationship.setForeground(new java.awt.Color(38, 50, 56));
        lab_contactRelationship.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pan_contact.add(lab_contactRelationship, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 190, 20));

        pan_buttom.setBackground(new java.awt.Color(234, 234, 234));
        pan_buttom.setRoundBottomLeft(20);
        pan_buttom.setRoundBottomRight(20);
        pan_buttom.setRoundTopLeft(20);
        pan_buttom.setRoundTopRight(20);
        pan_buttom.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panContact.setBackground(new java.awt.Color(51, 102, 255));
        panContact.setRoundBottomLeft(20);
        panContact.setRoundTopLeft(20);

        lab_contact.setBackground(new java.awt.Color(255, 255, 255));
        lab_contact.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lab_contact.setForeground(new java.awt.Color(255, 255, 255));
        lab_contact.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_contact.setText("Contact");
        lab_contact.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lab_contact.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lab_contactMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panContactLayout = new javax.swing.GroupLayout(panContact);
        panContact.setLayout(panContactLayout);
        panContactLayout.setHorizontalGroup(
            panContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panContactLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lab_contact, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        panContactLayout.setVerticalGroup(
            panContactLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panContactLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lab_contact, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pan_buttom.add(panContact, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 90, 40));

        panWork.setBackground(new java.awt.Color(234, 234, 234));

        lab_work.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lab_work.setForeground(new java.awt.Color(38, 50, 56));
        lab_work.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_work.setText("Work");
        lab_work.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lab_work.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lab_workMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panWorkLayout = new javax.swing.GroupLayout(panWork);
        panWork.setLayout(panWorkLayout);
        panWorkLayout.setHorizontalGroup(
            panWorkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panWorkLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lab_work, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        panWorkLayout.setVerticalGroup(
            panWorkLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panWorkLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lab_work, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pan_buttom.add(panWork, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 90, 40));

        panAbout.setBackground(new java.awt.Color(234, 234, 234));
        panAbout.setRoundBottomRight(20);
        panAbout.setRoundTopRight(20);

        lab_about.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lab_about.setForeground(new java.awt.Color(38, 50, 56));
        lab_about.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_about.setText("About");
        lab_about.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        lab_about.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lab_aboutMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panAboutLayout = new javax.swing.GroupLayout(panAbout);
        panAbout.setLayout(panAboutLayout);
        panAboutLayout.setHorizontalGroup(
            panAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAboutLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lab_about, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        panAboutLayout.setVerticalGroup(
            panAboutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panAboutLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(lab_about, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pan_buttom.add(panAbout, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 80, 40));

        pan_contact.add(pan_buttom, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 260, 40));

        pan_details.setRoundBottomLeft(20);
        pan_details.setRoundBottomRight(20);
        pan_details.setRoundTopLeft(20);
        pan_details.setRoundTopRight(20);
        pan_details.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lab1.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lab1.setForeground(new java.awt.Color(0, 0, 0));
        pan_details.add(lab1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 30, 200, 20));

        lab11.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lab11.setForeground(new java.awt.Color(25, 25, 25));
        pan_details.add(lab11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 60, 200, 30));

        lab2.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lab2.setForeground(new java.awt.Color(0, 0, 0));
        pan_details.add(lab2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 200, 20));

        lab22.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lab22.setForeground(new java.awt.Color(19, 91, 174));
        lab22.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pan_details.add(lab22, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 200, 30));

        lab3.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lab3.setForeground(new java.awt.Color(0, 0, 0));
        pan_details.add(lab3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 170, 200, 20));

        lab33.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lab33.setForeground(new java.awt.Color(25, 25, 25));
        pan_details.add(lab33, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 200, 200, 30));

        lab4.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        lab4.setForeground(new java.awt.Color(0, 0, 0));
        pan_details.add(lab4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 230, 200, 20));

        lab44.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        lab44.setForeground(new java.awt.Color(25, 25, 25));
        pan_details.add(lab44, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 260, 200, 30));
        pan_details.add(svgIconLab1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 30, 30));
        pan_details.add(svgIconLab2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, 30, 30));
        pan_details.add(svgIconLab3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 170, 30, 30));
        pan_details.add(svgIconLab4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 30, 30));

        pan_contact.add(pan_details, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 260, 300));

        buttonDelete.setForeground(new java.awt.Color(0, 0, 0));
        buttonDelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/delete.png"))); // NOI18N
        buttonDelete.setText("Delete");
        buttonDelete.setEffectColor(new java.awt.Color(229, 71, 71));
        buttonDelete.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });
        pan_contact.add(buttonDelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 550, 80, -1));

        buttonEdit.setForeground(new java.awt.Color(0, 0, 0));
        buttonEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/edit.png"))); // NOI18N
        buttonEdit.setText("Edit");
        buttonEdit.setEffectColor(new java.awt.Color(21, 101, 192));
        buttonEdit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonEditActionPerformed(evt);
            }
        });
        pan_contact.add(buttonEdit, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 550, 70, -1));

        buttonFavorite.setForeground(new java.awt.Color(0, 0, 0));
        buttonFavorite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/star.png"))); // NOI18N
        buttonFavorite.setText("Faveorite");
        buttonFavorite.setEffectColor(new java.awt.Color(208, 208, 34));
        buttonFavorite.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        buttonFavorite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFavoriteActionPerformed(evt);
            }
        });
        pan_contact.add(buttonFavorite, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 550, 90, -1));

        add(pan_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 100, 300, 590));

        scrollPane.setBorder(null);

        contactTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Job Title", "Phone Number", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        contactTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                contactTableMouseClicked(evt);
            }
        });
        scrollPane.setViewportView(contactTable);
        if (contactTable.getColumnModel().getColumnCount() > 0) {
            contactTable.getColumnModel().getColumn(0).setResizable(false);
            contactTable.getColumnModel().getColumn(1).setResizable(false);
            contactTable.getColumnModel().getColumn(2).setResizable(false);
            contactTable.getColumnModel().getColumn(3).setResizable(false);
        }

        add(scrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 100, 600, 550));

        btn_favoriteContacts.setBackground(new java.awt.Color(21, 101, 192));
        btn_favoriteContacts.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_favoriteContacts.setForeground(new java.awt.Color(255, 255, 255));
        btn_favoriteContacts.setText("Favorite Contacts");
        btn_favoriteContacts.setBorderPainted(false);
        btn_favoriteContacts.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_favoriteContacts.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_favoriteContactsActionPerformed(evt);
            }
        });
        add(btn_favoriteContacts, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 660, 160, 30));
    }// </editor-fold>//GEN-END:initComponents

    public static String checkEmail;
    
    private void setTableData() {
        contactview.setRowCount(0);

        try {
            PreparedStatement contact = table.con.prepareStatement("select userDB.user_id, contactsDB.contact_id , contactsDB.contact_Fname, contactsDB.job_title, contactsDB.contact_phoneNumber , contactsDB.contact_email from contactsDB ,userDB where contactsDB.user_id = userDB.user_id;");
            ResultSet data = contact.executeQuery();

            //data.setInt(test.user_id);
            while (data.next()) {
               
                int check = data.getInt("userDB.user_id");
                //checkEmail = data.getInt("contactsDB.contact_id");
                if (UserID.user_id == check) {

                    contactId.add(data.getInt("contactsDB.contact_id"));
                    contactview.addRow(new Object[]{data.getString("contactsDB.contact_Fname"), data.getString("contactsDB.job_title"), data.getString("contactsDB.contact_phoneNumber"), data.getString("contactsDB.contact_email")});
                }
            
            }

            // new ImageIcon(getClass().getResource("/Icons/User Male2.png"))
            contactTable.setModel(contactview);
            checkEmail = contactTable.getValueAt(contactTable.getSelectedRow(), 3).toString();
                    
        } catch (Exception e) {
            Notifications.getInstance().show(Notifications.Type.ERROR, "There is No Connection To Databas");
        }

    }

    private void setContact() {
        String checkGender = "";
        String query = "select user_id, contactsDB.contact_gender, CONCAT(contactsDB.contact_Fname, ' ' ,contactsDB.contact_Lname) AS ContactName , contactsDB.contact_email , contact_relationship.relationship from contactsDB,contact_relationship where contact_email = ? && contactsDB.relationship_id = contact_relationship.relationship_id;";
        try {
            PreparedStatement contactviewData = viewForm.con.prepareStatement(query);
            contactviewData.setString(1, contactTable.getValueAt(contactTable.getSelectedRow(), 3).toString());
            
            ResultSet data = contactviewData.executeQuery(); 
            
            while (data.next()) {
                //int checkId = data.getInt(1);
                if (contactTable.getValueAt(contactTable.getSelectedRow(), 3).toString().equals(data.getString("contactsDB.contact_email"))) {
                    checkGender = data.getString("contactsDB.contact_gender");

                    if (checkGender.equals("Male")) {
                        svgIconContact.setSVGIcon("Icons/User Male.svg", 90, 90);
                    } else {
                        svgIconContact.setSVGIcon("Icons/Female User.svg", 90, 90);
                    }

                    lab_contactName.setText(data.getString("ContactName"));
                    lab_contactRelationship.setText(data.getString("contactsDB.contact_email"));
                } else {
                Notifications.getInstance().show(Notifications.Type.ERROR, "Error");
                }
             }
            
            Contact();

        } catch (Exception e) {
            Notifications.getInstance().show(Notifications.Type.ERROR, "Error There is No More Contacts");
        }
    }

    
    private void Contact() {
        String query = "select contactsDB.contact_phoneNumber , contactsDB.contact_email, contactsDB.chatApp , country.country_name from contactsDB , country Where contact_email = ? && contactsDB.country_id = country.country_id;";
        try {
            PreparedStatement contactData = viewForm.con.prepareStatement(query);
            contactData.setString(1, contactTable.getValueAt(contactTable.getSelectedRow(), 3).toString());
            
            ResultSet data = contactData.executeQuery();
            lab22.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            lab22.setForeground(new java.awt.Color(19, 91, 174));

            while (data.next()) {

               if (contactTable.getValueAt(contactTable.getSelectedRow(), 3).toString().equals(data.getString("contactsDB.contact_email"))) {
                lab1.setText("Phone Number");
                lab2.setText("Email Address");
                lab3.setText("Chat");
                lab4.setText("Country");

                lab11.setText(data.getString("contactsDB.contact_phoneNumber"));
                lab22.setText(data.getString("contactsDB.contact_email"));
                lab33.setText(data.getString("contactsDB.chatApp"));
                lab44.setText(data.getString("country.country_name"));

                svgIconLab1.setVisible(true);
                svgIconLab2.setVisible(true);
                svgIconLab3.setVisible(true);
                svgIconLab4.setVisible(true);

                svgIconLab1.setSVGIcon("Icons/GitHub.svg", 30, 30);
                svgIconLab2.setSVGIcon("Icons/GitHub.svg", 30, 30);
                svgIconLab3.setSVGIcon("Icons/GitHub.svg", 30, 30);
                svgIconLab4.setSVGIcon("Icons/GitHub.svg", 30, 30);

                }
            }

        } catch (Exception e) {

        }
    }

    private void work() {

        String query = "select contact_email , job_title , job_location , job_company from contactsDB where contact_email = ?";
        try {
            PreparedStatement contactWorkData = viewForm.con.prepareStatement(query);
            contactWorkData.setString(1, contactTable.getValueAt(contactTable.getSelectedRow(), 3).toString());
            
            ResultSet data = contactWorkData.executeQuery();

            lab22.setForeground(new java.awt.Color(25, 25, 25));

            while (data.next()) {
                if (contactTable.getValueAt(contactTable.getSelectedRow(), 3).toString().equals(data.getString("contactsDB.contact_email"))) {
                lab1.setText("Job Title");
                lab2.setText("Job Location");
                lab3.setText("Country");
                lab4.setText("");

                lab11.setText(data.getString("job_title"));
                lab22.setText(data.getString("job_location"));
                lab33.setText(data.getString("job_company"));
                lab44.setText("");

                svgIconLab1.setVisible(false);
                svgIconLab2.setVisible(false);
                svgIconLab3.setVisible(false);
                svgIconLab4.setVisible(false);

                }
            }
        } catch (Exception e) {

        }
    }

    private void about() {

        String query = "select contact_email , contact_LinkedIn , contact_GitHub , contact_Facebook from contactsDB where contact_email = ?";
        try {
            PreparedStatement contactAboutData = viewForm.con.prepareStatement(query);
            contactAboutData.setString(1, contactTable.getValueAt(contactTable.getSelectedRow(), 3).toString());
            
            ResultSet data = contactAboutData.executeQuery();

            lab22.setForeground(new java.awt.Color(25, 25, 25));
            
            while (data.next()) {
                
                if (contactTable.getValueAt(contactTable.getSelectedRow(), 3).toString().equals(data.getString("contactsDB.contact_email"))) {
                lab1.setText("LinkedIn");
                lab2.setText("GitHub");
                lab3.setText("Facebook");
                lab4.setText("");

                lab11.setText(data.getString("contact_LinkedIn"));
                lab22.setText(data.getString("contact_GitHub"));
                lab33.setText(data.getString("contact_Facebook"));
                lab44.setText("");

                svgIconLab1.setVisible(true);
                svgIconLab2.setVisible(true);
                svgIconLab3.setVisible(true);

                svgIconLab1.setSVGIcon("Icons/LinkedIn.svg", 30, 30);
                svgIconLab2.setSVGIcon("Icons/GitHub.svg", 30, 30);
                svgIconLab3.setSVGIcon("Icons/Facebook.svg", 30, 30);
                svgIconLab4.setVisible(false);
                  }
                }

        } catch (Exception e) {

        }
    }

    public boolean flag;

    private void setFaveoriteIcon() {

        if (count % 2 == 0) {
            flag = true;
            buttonFavorite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/star All.png")));
            Notifications.getInstance().show(Notifications.Type.SUCCESS, "Added The contact To Favorite");
        } else {
            flag = false;
            buttonFavorite.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icons/star.png")));
            Notifications.getInstance().show(Notifications.Type.SUCCESS, "Removed The contact From Favorite");
        }
    }

    private void btn_LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_LogoutActionPerformed
        FormsManager.getInstance().showForm(new sign_in());
    }//GEN-LAST:event_btn_LogoutActionPerformed

    // 3366FF
    // 0F6B6B
    private void panContact() {
        panContact.setBackground(Color.decode("#3366FF"));
        panWork.setBackground(Color.decode("#EAEAEA"));
        panAbout.setBackground(Color.decode("#EAEAEA"));

        lab_contact.setForeground(Color.decode("#FFFFFF"));
        lab_work.setForeground(Color.decode("#263238"));
        lab_about.setForeground(Color.decode("#263238"));

    }

    private void lab_contactMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lab_contactMouseClicked
        panContact();
        Contact();
    }//GEN-LAST:event_lab_contactMouseClicked

    private void lab_workMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lab_workMouseClicked
        panContact.setBackground(Color.decode("#EAEAEA"));
        panWork.setBackground(Color.decode("#3366FF"));
        panAbout.setBackground(Color.decode("#EAEAEA"));

        lab_contact.setForeground(Color.decode("#263238"));
        lab_work.setForeground(Color.decode("#FFFFFF"));
        lab_about.setForeground(Color.decode("#263238"));

        work();
    }//GEN-LAST:event_lab_workMouseClicked

    private void lab_aboutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lab_aboutMouseClicked
        panContact.setBackground(Color.decode("#EAEAEA"));
        panWork.setBackground(Color.decode("#EAEAEA"));
        panAbout.setBackground(Color.decode("#3366FF"));

        lab_contact.setForeground(Color.decode("#263238"));
        lab_work.setForeground(Color.decode("#263238"));
        lab_about.setForeground(Color.decode("#FFFFFF"));

        about();
    }//GEN-LAST:event_lab_aboutMouseClicked


    private void btn_favoriteContactsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_favoriteContactsActionPerformed
        FormsManager.getInstance().showForm(new favoriteContacts());
    }//GEN-LAST:event_btn_favoriteContactsActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDeleteActionPerformed
        // Delete the selected contact from the table and database

        try {
            PreparedStatement delete = deletetable.con.prepareStatement("delete from contactsDB where contact_id = ?;");

            delete.setInt(1, contactId.get(contactTable.getSelectedRow()));

            delete.executeUpdate();
            Notifications.getInstance().show(Notifications.Type.SUCCESS, "Removed The contact From The Table IS Succesfully");
        } catch (Exception ex) {
            Notifications.getInstance().show(Notifications.Type.ERROR, "Error There is No More Contacts");
        }
        setTableData();
    }//GEN-LAST:event_buttonDeleteActionPerformed


    private void buttonEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonEditActionPerformed
        setTableData();
        FormsManager.getInstance().showForm(new editContact());
    }//GEN-LAST:event_buttonEditActionPerformed

    private void buttonFavoriteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonFavoriteActionPerformed
        // Make The selected contact with the favorite contacts 
        // and insert this action into the database

        count++;
        setFaveoriteIcon();
    }//GEN-LAST:event_buttonFavoriteActionPerformed

    private void btn_addContactActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addContactActionPerformed
        FormsManager.getInstance().showForm(new addnewContact());
    }//GEN-LAST:event_btn_addContactActionPerformed

    private void lab_PhoneBookMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lab_PhoneBookMouseClicked
        //FormsManager.getInstance().showForm(new teamMember());
    }//GEN-LAST:event_lab_PhoneBookMouseClicked

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        FormsManager.getInstance().showForm(new currencyService());
    }//GEN-LAST:event_jLabel1MouseClicked

    private void contactTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_contactTableMouseClicked
        setContact();
        pan_contact.setVisible(true);
    }//GEN-LAST:event_contactTableMouseClicked

    private void txt_searchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_searchKeyReleased
        DefaultTableModel search = (DefaultTableModel) contactTable.getModel();
        TableRowSorter<DefaultTableModel> obj = new TableRowSorter<>(search);
        contactTable.setRowSorter(obj);
        obj.setRowFilter(RowFilter.regexFilter(txt_search.getText()));
    }//GEN-LAST:event_txt_searchKeyReleased

    private void txt_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_searchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_searchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_Logout;
    private javax.swing.JButton btn_addContact;
    private javax.swing.JButton btn_favoriteContacts;
    private Components.Button buttonDelete;
    private Components.Button buttonEdit;
    private Components.Button buttonFavorite;
    private contactData.Table contactTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lab1;
    private javax.swing.JLabel lab11;
    private javax.swing.JLabel lab2;
    private javax.swing.JLabel lab22;
    private javax.swing.JLabel lab3;
    private javax.swing.JLabel lab33;
    private javax.swing.JLabel lab4;
    private javax.swing.JLabel lab44;
    private javax.swing.JLabel lab_PhoneBook;
    private javax.swing.JLabel lab_about;
    private javax.swing.JLabel lab_contact;
    private javax.swing.JLabel lab_contactName;
    private javax.swing.JLabel lab_contactRelationship;
    private javax.swing.JLabel lab_userCountry;
    private javax.swing.JLabel lab_userEmail;
    private javax.swing.JLabel lab_userName;
    private javax.swing.JLabel lab_userPhoneNumber;
    private javax.swing.JLabel lab_userRegistrationDate;
    private javax.swing.JLabel lab_work;
    private Components.PanelRound panAbout;
    private Components.PanelRound panContact;
    private Components.PanelRound panWork;
    private Components.PanelRound pan_buttom;
    private Components.PanelRound pan_contact;
    private Components.PanelRound pan_details;
    private Components.PanelRound pan_search;
    private Components.PanelRound pan_userInfo;
    private Components.ScrollPaneWin11 scrollPane;
    private SVGIcon.svgIcon svgIconContact;
    private SVGIcon.svgIcon svgIconLab1;
    private SVGIcon.svgIcon svgIconLab2;
    private SVGIcon.svgIcon svgIconLab3;
    private SVGIcon.svgIcon svgIconLab4;
    private SVGIcon.svgIcon svgIconSearch;
    private SVGIcon.svgIcon svgIconUser;
    private SVGIcon.svgIcon svgIconphoneNum;
    private SVGIcon.svgIcon svgIconregDate;
    private SVGIcon.svgIcon svgIconuserCountry;
    private javax.swing.JTextField txt_search;
    // End of variables declaration//GEN-END:variables
}
