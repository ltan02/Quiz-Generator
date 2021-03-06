/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

/**
 *
 * @author lance_tan
 */
public class importKTorD extends javax.swing.JFrame {

        /**
         * Creates new form importKTorD
         */
        
        MainMenu myMainMenu;
        
        public importKTorD(MainMenu someMain) {
                initComponents();
                
                myMainMenu = someMain;
        }

        /**
         * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code.
         * The content of this method is always regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                lblTitle = new javax.swing.JLabel();
                lblStep4 = new javax.swing.JLabel();
                btnKT = new javax.swing.JButton();
                btnKTandD = new javax.swing.JButton();
                btnBack = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setLocation(new java.awt.Point(0, 0));
                setMinimumSize(new java.awt.Dimension(400, 300));
                getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                lblTitle.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
                lblTitle.setText("Creating New Quiz");
                getContentPane().add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 20, -1, -1));

                lblStep4.setText("Step 4: Importing Key Terms and/or Definitions");
                getContentPane().add(lblStep4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, -1, -1));

                btnKT.setText("Key Terms Only");
                btnKT.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnKTActionPerformed(evt);
                        }
                });
                getContentPane().add(btnKT, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, -1));

                btnKTandD.setText("Key Terms and Definitions");
                btnKTandD.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnKTandDActionPerformed(evt);
                        }
                });
                getContentPane().add(btnKTandD, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, -1, -1));

                btnBack.setText("Back");
                btnBack.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnBackActionPerformed(evt);
                        }
                });
                getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, -1));

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
                // TODO add your handling code here:
                myMainMenu.navigate(this, "quizForm"); //Switching between frames
        }//GEN-LAST:event_btnBackActionPerformed

        private void btnKTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKTActionPerformed
                // TODO add your handling code here:
                myMainMenu.myImportFormat.importType = "KT";
                myMainMenu.navigate(this, "importFormat");
                
        }//GEN-LAST:event_btnKTActionPerformed

        private void btnKTandDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKTandDActionPerformed
                // TODO add your handling code here:
                myMainMenu.myImportFormat.importType = "KTandD";
                myMainMenu.navigate(this, "importFormat");
        }//GEN-LAST:event_btnKTandDActionPerformed

        /**
         * @param args the command line arguments
         */
        



        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnBack;
        private javax.swing.JButton btnKT;
        private javax.swing.JButton btnKTandD;
        private javax.swing.JLabel lblStep4;
        private javax.swing.JLabel lblTitle;
        // End of variables declaration//GEN-END:variables
}
