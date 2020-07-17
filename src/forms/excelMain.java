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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Random;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.commons.collections4.ListValuedMap;
import org.apache.xmlbeans.XmlObject;

public class excelMain {
        
        MainMenu myMainMenu;

        public excelMain(MainMenu someMain) {
                myMainMenu = someMain;

        }
        
        public String getFilePath() { //Gets the file path of the template
                JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
                //Opens a dialog for the user to look for the file
		int returnValue = jfc.showOpenDialog(null);
                //Checks if the file is the one that was chosen
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getSelectedFile();
                        //Gets the path of the selected file
			String path = selectedFile.getAbsolutePath();
                        return path;
                }
               return ""; 
        }
        
        public String createNewSheet(String filePath) throws IOException { //Creates a new excel file using the file path
                //Creates a new file using the filePath
                File originalFile = new File(filePath);
                //Calls the newFilePath() function to get the new file path of the new excel file
                String newFilePath = this.newFilePath(filePath);
                //Creates a new file using the newFilePath
                File duplicateFile = new File(newFilePath);
                FileChannel sourceChannel = null;
                FileChannel destChannel = null;
                try {
                        //Gets the data from the original file
                        sourceChannel = new FileInputStream(originalFile).getChannel();
                        //Gets the data from the duplicated file
                        destChannel = new FileOutputStream(duplicateFile).getChannel();
                        //Transfers all the data from the sourceChannel to the destChannel
                        destChannel.transferFrom(sourceChannel, 0, sourceChannel.size());
                } finally {
                        sourceChannel.close();
                        destChannel.close();
                }
                return newFilePath;
        }
        
        public String newFilePath(String filePath) throws IOException {
                //Gets the index of where "Desktop" is located in the filePath
                int location = filePath.indexOf("Desktop");
                //Gets the string from the start until "Desktop"
                String newFilePath = filePath.substring(0, location+8);
                //Concatinates the newFilePath and the quizName, which is formated to remove all spaces
                newFilePath = newFilePath + myMainMenu.quizName.replaceAll("\\s", "_") + ".xlsx";
                return newFilePath;
        }
        
        //Adds a question into the Kahoot excel file
        public void addKahootQuestion(int questionNumber, String filePath, String definition, String answer, 
                                                String wrongAnswer1, String wrongAnswer2, String wrongAnswer3) {
                try {
                        FileInputStream file = new FileInputStream(new File(filePath));
                        //Creates a new xlsx excel file
                        XSSFWorkbook workbook = new XSSFWorkbook(file);
                        //Creates a new sheet
                        XSSFSheet sheet = workbook.getSheetAt(0);
                        XSSFCell cell = null;
                        //Update the value of cell
                        cell = sheet.getRow(questionNumber + 7).getCell(1); //Question Cell
                        cell.setCellValue(definition);
                        cell = sheet.getRow(questionNumber + 7).getCell(6); //Time Limit Cell
                        cell.setCellValue(60);
                        //Getting a random number, which will be the location of the correct answer
                        Random rand = new Random();
                        int randomNumber = rand.nextInt(4) + 1;
                        int counter = 0;
                        for(int i = 1; i < 5; i++) {
                                if(i == randomNumber) { //Fills in the correct answer cells
                                        cell = sheet.getRow(questionNumber + 7).getCell(i+1); //Answer Cell
                                        cell.setCellValue(answer);
                                        cell = sheet.getRow(questionNumber + 7).getCell(7); //Correct Answer Number Cell
                                        cell.setCellValue(i);
                                } else {
                                        switch (counter) { //Filling in the Wrong Answer Cells
                                                case 1:
                                                        cell = sheet.getRow(questionNumber + 7).getCell(i+1);
                                                        cell.setCellValue(wrongAnswer1);
                                                        break;
                                                case 2:
                                                        cell = sheet.getRow(questionNumber + 7).getCell(i+1);
                                                        cell.setCellValue(wrongAnswer2);
                                                        break;
                                                default:
                                                        cell = sheet.getRow(questionNumber + 7).getCell(i+1);
                                                        cell.setCellValue(wrongAnswer3);
                                                        break;
                                        }
                                        counter++;
                                }
                        }
                        file.close();
                        FileOutputStream outFile = new FileOutputStream(new File(filePath));
                        workbook.write(outFile);
                        outFile.close();
                } catch (FileNotFoundException e) {
                         e.printStackTrace();
                } catch (IOException e) {
                         e.printStackTrace();
                }
        }
        
        //Adds a question into the Socrative excel file
        public void addSocrativeQuestion(int questionNumber, String filePath, String definition, String answer, 
                                                String wrongAnswer1, String wrongAnswer2, String wrongAnswer3) {
                try {
                        FileInputStream file = new FileInputStream(new File(filePath));
                        //Creates new excel workbook
                        XSSFWorkbook workbook = new XSSFWorkbook(file);
                        //Creates new sheet
                        XSSFSheet sheet = workbook.getSheetAt(0);
                        XSSFCell cell = null;
                        //Update the value of cell
                        cell = sheet.getRow(2).getCell(1); //Quiz Name
                        cell.setCellValue(myMainMenu.quizName);
                        cell = sheet.getRow(questionNumber + 5).getCell(0); //Quiz Type
                        cell.setCellValue("Multiple choice");
                        cell = sheet.getRow(questionNumber + 5).getCell(1); //Question Cell
                        cell.setCellValue(definition);
                        //Gets a random number, which will be the location of the correct answer
                        Random rand = new Random();
                        int randomNumber = rand.nextInt(4) + 1;
                        int counter = 1;
                        for(int i = 1; i < 5; i++) {
                                if(i == randomNumber) { //Filling in the correct answer cell
                                        cell = sheet.getRow(questionNumber + 5).getCell(i+1); //Answer Cell
                                        cell.setCellValue(answer);
                                        cell = sheet.getRow(questionNumber + 5).getCell(7); //Correct Answer Number Cell
                                        String value = "";
                                        switch(counter) { //Answers need to be letters rather than numbers
                                                case 1:
                                                        value = "A"; 
                                                        break;
                                                case 2:
                                                        value = "B";
                                                        break;
                                                case 3:
                                                        value = "C";
                                                        break;
                                                default:
                                                        value = "D";
                                                        break;
                                        }
                                        cell.setCellValue(value);
                                } else {
                                        switch (counter) { //Filling in the Wrong Answer Cells
                                                case 1:
                                                        cell = sheet.getRow(questionNumber + 5).getCell(i+1);
                                                        cell.setCellValue(wrongAnswer1);
                                                        break;
                                                case 2:
                                                        cell = sheet.getRow(questionNumber + 5).getCell(i+1);
                                                        cell.setCellValue(wrongAnswer2);
                                                        break;
                                                default:
                                                        cell = sheet.getRow(questionNumber + 5).getCell(i+1);
                                                        cell.setCellValue(wrongAnswer3);
                                                        break;
                                        }
                                        counter++;
                                }
                        }
                        file.close();
                        FileOutputStream outFile = new FileOutputStream(new File(filePath));
                        workbook.write(outFile);
                        outFile.close();
                } catch (FileNotFoundException e) {
                         e.printStackTrace();
                } catch (IOException e) {
                         e.printStackTrace();
                }
        }
        
}
