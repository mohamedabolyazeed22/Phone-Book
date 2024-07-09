
package CurrencyService;


public class currencyService extends javax.swing.JPanel {


    public currencyService() {
        initComponents();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panAll = new javax.swing.JPanel();
        panelRound2 = new Components.PanelRound();
        lab_delete = new javax.swing.JLabel();

        panAll.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelRound2.setBackground(new java.awt.Color(226, 226, 226));
        panelRound2.setRoundBottomLeft(35);
        panelRound2.setRoundBottomRight(35);
        panelRound2.setRoundTopLeft(35);
        panelRound2.setRoundTopRight(35);
        panelRound2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lab_delete.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        lab_delete.setForeground(new java.awt.Color(0, 0, 0));
        lab_delete.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lab_delete.setText("Choose The Contact to Delete");
        panelRound2.add(lab_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 10, 410, -1));

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lab_delete;
    private javax.swing.JPanel panAll;
    private Components.PanelRound panelRound2;
    // End of variables declaration//GEN-END:variables
}
