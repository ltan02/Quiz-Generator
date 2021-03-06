/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lance_tan
 */
public class formatForm extends javax.swing.JFrame {

        /**
         * Creates new form formatForm
         */
        
        MainMenu myMainMenu;
        
        
        public formatForm(MainMenu someMain) {
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

                lblStep = new javax.swing.JLabel();
                btnKahoot = new javax.swing.JButton();
                btnSocrative = new javax.swing.JButton();
                btnBack = new javax.swing.JButton();
                jLabel1 = new javax.swing.JLabel();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setMinimumSize(new java.awt.Dimension(400, 300));
                getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                lblStep.setText("Step 5: Choose Quiz Format and then select the file of the ");
                getContentPane().add(lblStep, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, 20));

                btnKahoot.setText("Kahoot!");
                btnKahoot.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnKahootActionPerformed(evt);
                        }
                });
                getContentPane().add(btnKahoot, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 150, -1, -1));

                btnSocrative.setText("Socrative");
                btnSocrative.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnSocrativeActionPerformed(evt);
                        }
                });
                getContentPane().add(btnSocrative, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 150, -1, -1));

                btnBack.setText("Back");
                btnBack.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnBackActionPerformed(evt);
                        }
                });
                getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

                jLabel1.setText("template you will use from your computer");
                getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, -1));

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void btnKahootActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKahootActionPerformed
                // TODO add your handling code here:
                String filePath = myMainMenu.myExcelMain.getFilePath(); //Gets the file path of the kahoot template
                try {
                        String kahootFilePath = myMainMenu.myExcelMain.createNewSheet(filePath); //Generates a new google sheet
                        
                        ArrayList<Integer> quizIDs = new ArrayList<>();
                        quizIDs = myMainMenu.mySQLMain.retrieveID("QuestionID", "tblQuizQuestion", "QuizID", myMainMenu.currentQuizID); //Gets the quiz ID of the chosen quiz
                        
                        for(int i = 1; i < quizIDs.size() + 1; i++) { //Loops until all of the key terms are added
                                
                                String definition = myMainMenu.mySQLMain.retrieveData("Definition", "tblQuestion", "QuestionID", quizIDs.get(i-1)); //Gets all the necessary information to create the quiz
                                String answer = myMainMenu.mySQLMain.retrieveData("Answer", "tblQuestion", "QuestionID", quizIDs.get(i-1));
                                String wrongAnswer1 = myMainMenu.mySQLMain.retrieveData("WrongAnswer1", "tblQuestion", "QuestionID", quizIDs.get(i-1));
                                String wrongAnswer2 = myMainMenu.mySQLMain.retrieveData("WrongAnswer2", "tblQuestion", "QuestionID", quizIDs.get(i-1));
                                String wrongAnswer3 = myMainMenu.mySQLMain.retrieveData("WrongAnswer3", "tblQuestion", "QuestionID", quizIDs.get(i-1));
                               
                                myMainMenu.myExcelMain.addKahootQuestion(i, kahootFilePath, definition, answer, wrongAnswer1, wrongAnswer2, wrongAnswer3); //Adds the question into the kahoot excel
                        }

                } catch (IOException ex) {
                        Logger.getLogger(formatForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                myMainMenu.navigate(this, "finalForm");
        }//GEN-LAST:event_btnKahootActionPerformed

        private void btnSocrativeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSocrativeActionPerformed
                // TODO add your handling code here:
                String filePath = myMainMenu.myExcelMain.getFilePath(); //Same as the kahoot function
                try {
                        String socrativeFilePath = myMainMenu.myExcelMain.createNewSheet(filePath);
                        
                        ArrayList<Integer> quizIDs = new ArrayList<>();
                        quizIDs = myMainMenu.mySQLMain.retrieveID("QuestionID", "tblQuizQuestion", "QuizID", myMainMenu.currentQuizID);
                        
                        for(int i = 1; i < quizIDs.size() + 1; i++) {
                                
                                String definition = myMainMenu.mySQLMain.retrieveData("Definition", "tblQuestion", "QuestionID", quizIDs.get(i-1));
                                String answer = myMainMenu.mySQLMain.retrieveData("Answer", "tblQuestion", "QuestionID", quizIDs.get(i-1));
                                String wrongAnswer1 = myMainMenu.mySQLMain.retrieveData("WrongAnswer1", "tblQuestion", "QuestionID", quizIDs.get(i-1));
                                String wrongAnswer2 = myMainMenu.mySQLMain.retrieveData("WrongAnswer2", "tblQuestion", "QuestionID", quizIDs.get(i-1));
                                String wrongAnswer3 = myMainMenu.mySQLMain.retrieveData("WrongAnswer3", "tblQuestion", "QuestionID", quizIDs.get(i-1));
                               
                                myMainMenu.myExcelMain.addSocrativeQuestion(i, socrativeFilePath, definition, answer, wrongAnswer1, wrongAnswer2, wrongAnswer3);
                        }

                } catch (IOException ex) {
                        Logger.getLogger(formatForm.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                myMainMenu.navigate(this, "finalForm");
        }//GEN-LAST:event_btnSocrativeActionPerformed

        private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
                // TODO add your handling code here:
                myMainMenu.navigate(this, myMainMenu.previousFrame);
        }//GEN-LAST:event_btnBackActionPerformed

        

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnBack;
        private javax.swing.JButton btnKahoot;
        private javax.swing.JButton btnSocrative;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel lblStep;
        // End of variables declaration//GEN-END:variables
}
