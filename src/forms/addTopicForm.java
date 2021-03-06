/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author lance_tan
 */
public class addTopicForm extends javax.swing.JFrame {

        /**
         * Creates new form addTopicForm
         */
        
        MainMenu myMainMenu;
        
        public addTopicForm(MainMenu someMain) {
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
                txtTopicName = new javax.swing.JTextField();
                btnAdd = new javax.swing.JButton();
                btnBack = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setMaximumSize(new java.awt.Dimension(400, 300));
                setMinimumSize(new java.awt.Dimension(400, 300));
                getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                lblTitle.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
                lblTitle.setText("Adding Topic");
                getContentPane().add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, -1, -1));
                getContentPane().add(txtTopicName, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 180, -1));

                btnAdd.setText("Add");
                btnAdd.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnAddActionPerformed(evt);
                        }
                });
                getContentPane().add(btnAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, -1, -1));

                btnBack.setText("Back");
                btnBack.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnBackActionPerformed(evt);
                        }
                });
                getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
                // TODO add your handling code here:
                if(txtTopicName.getText().equals("")) {
                        JOptionPane.showMessageDialog(new JFrame(), "Please do not leave Topic Name field blank", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                        myMainMenu.mySQLMain.addItem("tblTopic", "TopicName", "SubjectID", this.txtTopicName.getText(), myMainMenu.currentSubjectID); //Adds the item onto the database
                        myMainMenu.navigate(this, "topicForm");
                        myMainMenu.myTopicForm.refresh();
                        this.txtTopicName.setText("");
                }        
        }//GEN-LAST:event_btnAddActionPerformed

        private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
                // TODO add your handling code here:
                myMainMenu.navigate(this, "topicForm"); //Switches back to the topic form
                myMainMenu.myTopicForm.refresh(); //Refrehes the topic form
                this.txtTopicName.setText("");
        }//GEN-LAST:event_btnBackActionPerformed

        /**
         * @param args the command line arguments
         */


        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnAdd;
        private javax.swing.JButton btnBack;
        private javax.swing.JLabel lblTitle;
        private javax.swing.JTextField txtTopicName;
        // End of variables declaration//GEN-END:variables
}
