
package homePage;


public class homepage extends javax.swing.JPanel {

  
    public homepage() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelRound1 = new Components.PanelRound();
        lab_PhoneBook = new javax.swing.JLabel();
        panelRound2 = new Components.PanelRound();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound1.setBackground(new java.awt.Color(176, 190, 197));
        panelRound1.setRoundBottomLeft(30);
        panelRound1.setRoundBottomRight(30);
        panelRound1.setRoundTopLeft(30);
        panelRound1.setRoundTopRight(30);
        panelRound1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lab_PhoneBook.setFont(new java.awt.Font("Segoe UI", 1, 22)); // NOI18N
        lab_PhoneBook.setForeground(new java.awt.Color(38, 50, 56));
        lab_PhoneBook.setText("Phone Book");
        panelRound1.add(lab_PhoneBook, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, 30));

        add(panelRound1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 150, 630));

        panelRound2.setBackground(new java.awt.Color(176, 190, 197));
        panelRound2.setRoundBottomLeft(30);
        panelRound2.setRoundBottomRight(30);
        panelRound2.setRoundTopLeft(30);
        panelRound2.setRoundTopRight(30);
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        add(panelRound2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 970, 630));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lab_PhoneBook;
    private Components.PanelRound panelRound1;
    private Components.PanelRound panelRound2;
    // End of variables declaration//GEN-END:variables
}
