
package delete_contact;

import Forms_manager.FormsManager;
import contactData.ModelContact;
import javax.swing.ImageIcon;
import view_my_contact.viewContact;

public class deleteContact extends javax.swing.JPanel {


    public deleteContact() {
        initComponents();
        setTableData();
    }

    private void setTableData() {
        contactTable.addRow(new ModelContact(new ImageIcon(getClass().getResource("/Icons/User Male2.png")), "Ahmed Badawi Hosny", "C++ Developer", "01018562905", "ahmedbad063@gmail.com").toRowTable());
        contactTable.addRow(new ModelContact(new ImageIcon(getClass().getResource("/Icons/profile2.jpg")), "Ahmed Badawi Hosny", "jobTitle", "PhoneNumber", "email").toRowTable());
        contactTable.addRow(new ModelContact(new ImageIcon(getClass().getResource("/Icons/profile2.jpg")), "Ahmed Badawi Hosny", "jobTitle", "PhoneNumber", "email").toRowTable());
        contactTable.addRow(new ModelContact(new ImageIcon(getClass().getResource("/Icons/profile2.jpg")), "Bora", "jobTitle", "PhoneNumber", "email").toRowTable());
        contactTable.addRow(new ModelContact(new ImageIcon(getClass().getResource("/Icons/profile2.jpg")), "Bora", "jobTitle", "PhoneNumber", "email").toRowTable());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panAll = new javax.swing.JPanel();
        panelRound2 = new Components.PanelRound();
        scrollPane = new Components.ScrollPaneWin11();
        contactTable = new contactData.Table();
        lab_delete = new javax.swing.JLabel();
        btn_cancel = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();

        panAll.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound2.setBackground(new java.awt.Color(226, 226, 226));
        panelRound2.setRoundBottomLeft(35);
        panelRound2.setRoundBottomRight(35);
        panelRound2.setRoundTopLeft(35);
        panelRound2.setRoundTopRight(35);
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scrollPane.setBorder(null);
        scrollPane.setToolTipText("");

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
        scrollPane.setViewportView(contactTable);

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
        panelRound2.add(btn_cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 550, 180, 40));

        btn_delete.setBackground(new java.awt.Color(21, 101, 192));
        btn_delete.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btn_delete.setForeground(new java.awt.Color(255, 255, 255));
        btn_delete.setText("Delete");
        btn_delete.setBorderPainted(false);
        btn_delete.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });
        panelRound2.add(btn_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 550, 180, 40));

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


    
    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        // Delete the contact from the database
        
        /*
        try {
            PreparedStatement stmt = con.prepareStatement("delete from employee where emp_id = ?");

            stmt.setInt(1, empIds.get(tbl_show.getSelectedRow()));

            stmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
        }
        fillTableModel();        
        
                // Delete the contact from the database
        
        preparedStatement stmt = con.preparedStatement("delete from employee where emp_id =?");
        stmt.setInt(1,empIds.get(tbl_show.getSelectedRow));
        stmt.executeUpdata();
        JoptionPane.showMessageDialog(this, "Deleted successfully");
        fillTableModel();
    }catch(SQLExceptiln ex){
    
    Logger.getLogger(RegisterForm.class.getName().log(Level.SEVERE,null,ex));
        
        */
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cancelActionPerformed
        FormsManager.getInstance().showForm(new viewContact());
    }//GEN-LAST:event_btn_cancelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cancel;
    private javax.swing.JButton btn_delete;
    private contactData.Table contactTable;
    private javax.swing.JLabel lab_delete;
    private javax.swing.JPanel panAll;
    private Components.PanelRound panelRound2;
    private Components.ScrollPaneWin11 scrollPane;
    // End of variables declaration//GEN-END:variables
}
