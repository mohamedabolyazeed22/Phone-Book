
package FavoriteContacts;

import DBConnection.databaseConnection;
import Forms_manager.FormsManager;
import contactData.ModelContact;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.table.DefaultTableModel;
import raven.toast.Notifications;
import view_my_contact.viewContact;



public class favoriteContacts extends javax.swing.JPanel {

    DefaultTableModel favoriteContact;
    databaseConnection table = new databaseConnection();
    viewContact favorite = new viewContact();
    
    public favoriteContacts() {
        initComponents();
        setTableData();
        
        favoriteContact = new DefaultTableModel();

        favoriteContact.addColumn("Name");
        favoriteContact.addColumn("Job Title");
        favoriteContact.addColumn("Phone Number");
        favoriteContact.addColumn("Email");        
    }

    private void setTableData() {
        favoriteContact.setRowCount(0);

        try {
            PreparedStatement contact = table.con.prepareStatement("select userDB.user_id, contactsDB.contact_id , contactsDB.contact_Fname, contactsDB.job_title, contactsDB.contact_phoneNumber, contactsDB.contact_email from contactsDB ,userDB where  Faveorite_contact = ?;");
            contact.setBoolean(1, favorite.flag);
            
            ResultSet data = contact.executeQuery();

            while (data.next()) {

                if (favorite.flag == true) {

                    //contactId.add(data.getInt(2));
                    favoriteContactTable.addRow(new Object[]{data.getString(3), data.getString(4), data.getString(5), data.getString(6)});
                }
            }

            favoriteContactTable.setModel(favoriteContact);
                    
        } catch (Exception e) {
            Notifications.getInstance().show(Notifications.Type.ERROR, "There is No Connection To Databas");
        }

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panAll = new javax.swing.JPanel();
        panelRound2 = new Components.PanelRound();
        scrollPane = new Components.ScrollPaneWin11();
        favoriteContactTable = new contactData.Table();
        lab_delete = new javax.swing.JLabel();
        btn_cancel = new javax.swing.JButton();
        btn_deleteFromFavorite = new javax.swing.JButton();

        panAll.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound2.setBackground(new java.awt.Color(226, 226, 226));
        panelRound2.setRoundBottomLeft(35);
        panelRound2.setRoundBottomRight(35);
        panelRound2.setRoundTopLeft(35);
        panelRound2.setRoundTopRight(35);
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scrollPane.setBorder(null);
        scrollPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        favoriteContactTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Name", "Job Title", "Phone Number", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        scrollPane.setViewportView(favoriteContactTable);

        panelRound2.add(scrollPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 570, 480));

        lab_delete.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lab_delete.setForeground(new java.awt.Color(0, 0, 0));
        lab_delete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_delete.setText("Choose The Contact to Delete");
        panelRound2.add(lab_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 410, -1));

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
        panelRound2.add(btn_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 550, 180, 40));

        btn_deleteFromFavorite.setBackground(new java.awt.Color(21, 101, 192));
        btn_deleteFromFavorite.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        btn_deleteFromFavorite.setForeground(new java.awt.Color(255, 255, 255));
        btn_deleteFromFavorite.setText("Delete From Favorite");
        btn_deleteFromFavorite.setBorderPainted(false);
        btn_deleteFromFavorite.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_deleteFromFavorite.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteFromFavoriteActionPerformed(evt);
            }
        });
        panelRound2.add(btn_deleteFromFavorite, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 550, 230, 40));

        panAll.add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 610));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(10, Short.MAX_VALUE)
                .addComponent(panAll, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(panAll, javax.swing.GroupLayout.PREFERRED_SIZE, 612, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        FormsManager.getInstance().showForm(new viewContact());
    }//GEN-LAST:event_btn_cancelActionPerformed

    private void btn_deleteFromFavoriteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteFromFavoriteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_deleteFromFavoriteActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_deleteFromFavorite;
    private contactData.Table favoriteContactTable;
    private javax.swing.JLabel lab_delete;
    private javax.swing.JPanel panAll;
    private Components.PanelRound panelRound2;
    private Components.ScrollPaneWin11 scrollPane;
    // End of variables declaration//GEN-END:variables
}
