package contactData;

import DBConnection.databaseConnection;
import java.awt.Color;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Table extends JTable {
    
    DefaultTableModel conatctData;
    databaseConnection contactDB = new databaseConnection(); 
    ArrayList<Integer> countryId = new ArrayList<>();
    ArrayList<Integer> relactionId = new ArrayList<>();
    
    public Table() {
        setShowHorizontalLines(true);
        setGridColor(new Color(230, 230, 230));
        setRowHeight(40); 
        getTableHeader().setReorderingAllowed(false);
        getTableHeader().setDefaultRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                TableHeader header = new TableHeader(o + "");
                if (i1 == 4) {
                    header.setHorizontalAlignment(JLabel.CENTER);
                }
                return header;
            }
        });
        
        setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean selected, boolean focus, int i, int i1) {
                if (o instanceof ModelProfile) {
                    ModelProfile data = (ModelProfile) o;
                    Profile cell = new Profile(data);
                    if (selected) {
                        cell.setBackground(new Color(239, 244, 255));
                    } else {
                        cell.setBackground(Color.WHITE);
                    }
                    return cell;
                } else {
                    Component com = super.getTableCellRendererComponent(jtable, o, selected, focus, i, i1);
                    setBorder(noFocusBorder);
                    com.setForeground(new Color(102, 102, 102));
                    if (selected) {
                        com.setBackground(new Color(239, 244, 255));
                    } else {
                        com.setBackground(Color.WHITE);
                    }
                    return com;
                }
            }
        });    
        
        //fillTable();  
    }
    
    /*
    
        Table.setRowCount(0);
        try {
            PreparedStatement contact = contactDB.con.prepareStatement("select contactsDB.contact_Fname, contactsDB.job_title, contactsDB.contact_phoneNumber, contactsDB.contact_email from contactsDB where contactsDB.user_id = ?");
            ResultSet data = contact.executeQuery();

            while (data.next()) {
                countryId.add(data.getInt(1));
                relactionId.add(data.getInt());
                conatctData.addRow(new ImageIcon(getClass().getResource("/Icons/User Male2.png")),new Object[]{data.getString(2), data.getString(3), data.getString(4), data.getString(5)});
            }
            Table.setModel(conatctData);

        } catch (SQLException ex) {
            Logger.getLogger(RegisterForm.class.getName()).log(Level.SEVERE, null, ex);
        }    
    */
    
    public void fillTable(){
        addRow(new ModelContact(new ImageIcon(getClass().getResource("/Icons/User Male2.png")), "Ahmed Badawi Hosny", "C++ Developer", "01018562905", "ahmedbad063@gmail.com").toRowTable());
        addRow(new ModelContact(new ImageIcon(getClass().getResource("/Icons/profile2.jpg")), "Ahmed Badawi Hosny", "jobTitle", "PhoneNumber", "email").toRowTable());
        addRow(new ModelContact(new ImageIcon(getClass().getResource("/Icons/profile2.jpg")), "Ahmed Badawi Hosny", "jobTitle", "PhoneNumber", "email").toRowTable());
        addRow(new ModelContact(new ImageIcon(getClass().getResource("/Icons/profile2.jpg")), "Bora", "jobTitle", "PhoneNumber", "email").toRowTable());
        addRow(new ModelContact(new ImageIcon(getClass().getResource("/Icons/profile2.jpg")), "Bora", "jobTitle", "PhoneNumber", "email").toRowTable());
    }
    
public void addRow(Object[] row) {
        DefaultTableModel mod = (DefaultTableModel) getModel();
        mod.addRow(row);
    }    
}
