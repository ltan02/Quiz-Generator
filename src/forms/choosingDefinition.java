/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import java.util.ArrayList;

/**
 *
 * @author lance_tan
 */
public class choosingDefinition extends javax.swing.JFrame {

        /**
         * Creates new form choosingDefinition
         */
        
        MainMenu myMainMenu;
        
        int currentKeyTerm;
       
        String[][] data;
        
        int pointer;
        
        public choosingDefinition(MainMenu someMain) {
                initComponents();
                
                myMainMenu = someMain;
                currentKeyTerm = 0;
                
                pointer = 0;
        }

        /**
         * This method is called from within the constructor to initialize the form. WARNING: Do NOT modify this code.
         * The content of this method is always regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                lblTitle = new javax.swing.JLabel();
                lblStep = new javax.swing.JLabel();
                lblKeyTerm = new javax.swing.JLabel();
                rbtnDefinition1 = new javax.swing.JRadioButton();
                rbtnDefinition2 = new javax.swing.JRadioButton();
                rbtnDefinition3 = new javax.swing.JRadioButton();
                btnBack = new javax.swing.JButton();
                btnChoose = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setLocation(new java.awt.Point(0, 0));
                setMinimumSize(new java.awt.Dimension(400, 300));
                setResizable(false);
                getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

                lblTitle.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
                lblTitle.setText("Creating New Quiz");
                getContentPane().add(lblTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, -1, -1));

                lblStep.setText("Step 4: Importing Key Terms and/or Definitions");
                getContentPane().add(lblStep, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 40, -1, -1));

                lblKeyTerm.setFont(new java.awt.Font("Lucida Grande", 1, 14)); // NOI18N
                lblKeyTerm.setText("Key Term");
                getContentPane().add(lblKeyTerm, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 70, -1, -1));

                rbtnDefinition1.setText("Definition 1");
                rbtnDefinition1.setMaximumSize(new java.awt.Dimension(107, 100));
                rbtnDefinition1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                rbtnDefinition1ActionPerformed(evt);
                        }
                });
                getContentPane().add(rbtnDefinition1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, 20));

                rbtnDefinition2.setText("Definition 2");
                rbtnDefinition2.setMaximumSize(new java.awt.Dimension(107, 100));
                rbtnDefinition2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                rbtnDefinition2ActionPerformed(evt);
                        }
                });
                getContentPane().add(rbtnDefinition2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, -1, -1));

                rbtnDefinition3.setText("Definition 3");
                rbtnDefinition3.setMaximumSize(new java.awt.Dimension(107, 100));
                rbtnDefinition3.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                rbtnDefinition3ActionPerformed(evt);
                        }
                });
                getContentPane().add(rbtnDefinition3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

                btnBack.setText("Back");
                btnBack.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnBackActionPerformed(evt);
                        }
                });
                getContentPane().add(btnBack, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));

                btnChoose.setText("Choose");
                btnChoose.setMaximumSize(new java.awt.Dimension(10, 29));
                btnChoose.setMinimumSize(new java.awt.Dimension(10, 29));
                btnChoose.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                btnChooseActionPerformed(evt);
                        }
                });
                getContentPane().add(btnChoose, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 240, -1, -1));

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
                myMainMenu.navigate(this, myMainMenu.previousFrame); //Goes back to whatever the previous frame is
        }//GEN-LAST:event_btnBackActionPerformed

        private void btnChooseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChooseActionPerformed
                // TODO add your handling code here:
                data[currentKeyTerm][0] = myMainMenu.keyTerms.get(currentKeyTerm); //Gets the current key term that the user is choosing the definition for
                for(int i = 0; i < 3; i++) {
                        if(rbtnDefinition1.isSelected()) {
                                data[currentKeyTerm][1] = rbtnDefinition1.getText(); //Sets the definition for that key term to whichever one is pressed
                                rbtnDefinition1.setSelected(false);
                        } else if(rbtnDefinition2.isSelected()) {
                                data[currentKeyTerm][1] = rbtnDefinition2.getText();
                                rbtnDefinition2.setSelected(false);
                        } else {
                                data[currentKeyTerm][1] = rbtnDefinition3.getText();
                                rbtnDefinition3.setSelected(false);
                        }
                }
                currentKeyTerm++;
                if(currentKeyTerm == myMainMenu.keyTerms.size()) { //Checks to see if the definitions for all the key terms are chosen already
                        myMainMenu.navigate(this, "formatForm");
                        addData();
                } else {
                        change();  
                }
                
        }//GEN-LAST:event_btnChooseActionPerformed

        private void rbtnDefinition1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnDefinition1ActionPerformed
                // TODO add your handling code here:
                rbtnDefinition3.setSelected(false); //Makes it so that only one radio button is pressed at a time
                rbtnDefinition2.setSelected(false);
        }//GEN-LAST:event_rbtnDefinition1ActionPerformed

        private void rbtnDefinition2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnDefinition2ActionPerformed
                // TODO add your handling code here:
                rbtnDefinition3.setSelected(false);
                rbtnDefinition1.setSelected(false);
        }//GEN-LAST:event_rbtnDefinition2ActionPerformed

        private void rbtnDefinition3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtnDefinition3ActionPerformed
                // TODO add your handling code here:
                rbtnDefinition1.setSelected(false);
                rbtnDefinition2.setSelected(false);
        }//GEN-LAST:event_rbtnDefinition3ActionPerformed

        public void change() { //Change between the definition for each key term
                lblKeyTerm.setText(myMainMenu.keyTerms.get(currentKeyTerm));
                String[] definitions = getDefinitions(); //Gets the definition for the key term that is getting looked at
                
                for(int i = 0; i < definitions.length; i++) {
                        switch (i) {
                                case 0:
                                        if(definitions[i] == null) { //If it can't find a definition, then it will be preset to that
                                                rbtnDefinition1.setText("No Definition Found");
                                        } else {
                                                pointer = 0;
                                                rbtnDefinition1.setText("<html>" + fixText(definitions[i]) + "</html>"); //To make it so that the text wraps
                                        }
                                        break;
                                case 1:
                                        if(definitions[i] == null) {
                                                rbtnDefinition2.setText("No Definition Found");
                                        } else {
                                                pointer = 0;
                                                rbtnDefinition2.setText("<html>" + fixText(definitions[i]) + "</html>");
                                        }
                                        break;
                                default:
                                        if(definitions[i] == null) {
                                                rbtnDefinition3.setText("No Definition Found");
                                        } else {
                                                pointer = 0;
                                                rbtnDefinition3.setText("<html>" + fixText(definitions[i]) + "</html>");
                                        }
                                        break;
                        }
                }        
        }
        
        public final void setUp() { //For the initial key term when the frame is looked at
                String firstKeyTerm = myMainMenu.keyTerms.get(currentKeyTerm);
                
                lblKeyTerm.setText(firstKeyTerm);
                String[] definitions = getDefinitions();
                
                for(int i = 0; i < definitions.length; i++) {
                        switch (i) {
                                case 0:
                                        if(definitions[i] == null) {
                                                rbtnDefinition1.setText("No Definition Found");
                                        } else {
                                                pointer = 0;
                                                rbtnDefinition1.setText("<html>" + fixText(definitions[i]) + "</html>");
                                        }
                                        break;
                                case 1:
                                        if(definitions[i] == null) {
                                                rbtnDefinition2.setText("No Definition Found");
                                        } else {
                                                pointer = 0;
                                                rbtnDefinition2.setText("<html>" + fixText(definitions[i]) + "</html>");
                                        }
                                        break;
                                default:
                                        if(definitions[i] == null) {
                                                rbtnDefinition3.setText("No Definition Found");
                                        } else {
                                                pointer = 0;
                                                rbtnDefinition3.setText("<html>" + fixText(definitions[i]) + "</html>");
                                        }
                                        break;
                        }
                }
                data = new String[myMainMenu.keyTerms.size()][2]; 
        }
     
        public String fixText(String text) { //Recrusive method to format the text
                //Checks if the length of the string is okay or if we already formatted the whole string
                if(text.length() < 57 || pointer+57 >= text.length()) { //Recursive case
                        return text; //Returns the text
                } else {
                        //Creates a substring from the current point to the next 57 letters
                        String text1 = text.substring(pointer, pointer+57); 
                        //Creates a substring from the next 57 letters till the end
                        String text2 = text.substring(pointer+57);
                        //Moves pointer by 57
                        pointer += 57;
                        //Calls fixText with text1 and text2 with a line-break in between as the parameter
                        return fixText(text1 + "<br>" + text2); 
                }
        }
        
        public String[] getDefinitions() { //Gets the three definitions from all of the definitions in the API Main
                String url = myMainMenu.myAPIMain.dictionaryEntries(myMainMenu.keyTerms.get(currentKeyTerm));
                String response = myMainMenu.myAPIMain.doInBackground(url);
                ArrayList<String> definitions = myMainMenu.myAPIMain.getAllDefinitions(response);
                String[] definitionsCondensed = new String[3];
                int size = definitions.size();
                
                if(size > 3) {
                        size = 3;
                }
                
                for(int i = 0; i < size; i++) {
                        definitionsCondensed[i] = definitions.get(i);
                }
                
                return definitionsCondensed;
        }
        
        public void addData() { //Adds the data into the database
                for(int k = 0; k < data.length; k++) {
                        String definition = data[k][1];
                        String answer = data[k][0];
                        
                        int[] randomInts = new int[3];
                        randomInts = randomIntGenerator(randomInts, data.length - 1, 0, k);
                        
                        String wrongAnswer1 = data[randomInts[0]][0];
                        String wrongAnswer2 = data[randomInts[1]][0];
                        String wrongAnswer3 = data[randomInts[2]][0];
                        int primaryKey = myMainMenu.mySQLMain.addItem("tblQuestion", "Definition", "Answer", "WrongAnswer1", "WrongAnswer2", "WrongAnswer3", "TopicID", definition, answer, wrongAnswer1, wrongAnswer2, wrongAnswer3, myMainMenu.currentTopicID);
                        
                        myMainMenu.mySQLMain.addItem("tblQuizQuestion", "QuizID", "QuestionID", myMainMenu.currentQuizID, primaryKey);
                }     
        }
        
        public int[] randomIntGenerator(int[] array, int max, int min, int currentCorrect) { //Generates a random number between the range
                for(int i = 0; i < array.length; i++) { 
                        int random = (int) (Math.random() * ((max - min) + 1)) + min;
                        while(random == currentCorrect || inArray(array, random)) {
                                random = (int) (Math.random() * ((max - min) + 1)) + min;
                        }
                        array[i] = random;
                }
                return array;
        }
        
        public boolean inArray(int[] array, int random) { //Checks if it is inside the array
                boolean flag = false;
                for(int i = 0; i < array.length; i++) {
                        if(array[i] == random) {
                                flag = true;
                        }
                }
                return flag;
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton btnBack;
        private javax.swing.JButton btnChoose;
        private javax.swing.JLabel lblKeyTerm;
        private javax.swing.JLabel lblStep;
        private javax.swing.JLabel lblTitle;
        private javax.swing.JRadioButton rbtnDefinition1;
        private javax.swing.JRadioButton rbtnDefinition2;
        private javax.swing.JRadioButton rbtnDefinition3;
        // End of variables declaration//GEN-END:variables
}