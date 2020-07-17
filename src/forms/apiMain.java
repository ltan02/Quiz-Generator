/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import javax.net.ssl.HttpsURLConnection;

/**
 *
 * @author lance_tan
 */
public class apiMain {
        
        MainMenu myMainMenu;
        
        final String app_id = "fff0958f";
        final String app_key = "afc60aa5c71e0df43b46512fa0d7c4d1";
        
        public apiMain(MainMenu someMain) {
                myMainMenu = someMain;
        }
        
        public String dictionaryEntries(String keyTerm) { //Creates a string with the url and the correct key term to be searched up
                final String language = "en-gb"; //Presets the languae to UK English
                final String word = keyTerm.replaceAll(" ", "_"); //Changes any spaces to underscores
                final String fields = "definitions"; //Set the field to definitions, which is what we are trying to get
                final String strictMatch = "true"; //Will only get the specific key term rather than near-homographs
                final String word_id = word.toLowerCase(); //Makes it so that the key term is all lower cased
                return "https://od-api.oxforddictionaries.com:443/api/v2/entries/" + language + "/" + word_id + "?" 
                                                                + "fields=" + fields + "&strictMatch=" + strictMatch;
        }

        public String doInBackground(String urlToGet) { //gets the html of the page
                try {
                        //Create a URL variable of the url we are searching up
                        URL url = new URL(urlToGet); 
                        //Connecting to the Oxford Dictionary
                        HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection(); 
                        //Requests for the data to be in JSON code
                        urlConnection.setRequestProperty("Accept", "application/json"); 
                        //Gives the id of the API
                        urlConnection.setRequestProperty("app_id", app_id); 
                        //Gives the key of the API
                        urlConnection.setRequestProperty("app_key", app_key); 

                        // read the output from the server
                        //Open a BufferedReader to integrate the data into the algorithm
                        BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream())); 
                        //Creates a string builder for creating a mutable string object
                        StringBuilder stringBuilder = new StringBuilder(); 
                        //Used to start the loop
                        String line = null; 
                        //If there are no more new lines, the reader.readLine() will return null      
                        while ((line = reader.readLine()) != null) {      
                                //Adds the line and a metacharacter to the string builder
                                StringBuilder append = stringBuilder.append(line).append("\n"); 
                        }
                        //Returns the string
                        return stringBuilder.toString(); 
                } catch (IOException e) {
                        return e.toString();
                }
        }//end doInBackground


        public ArrayList<String> getAllDefinitions(String response) { //Finds all the definitions and puts it in an array
                String[] text = response.split("\n"); //Split each line of the JSON code into an array
                ArrayList<String> definitions = new ArrayList<>(); //Initialise a new array list
                String temp = ""; //Temporary string
                boolean flag = false; //Flag used for looking for the specific word "definition"
                for(String text1 : text) { //Loop through each item in the text array
                        temp = text1.replaceAll("\\s", ""); //Removes all the whitespaces from the text
                        if (temp.equals("\"definitions\":[")) { //Looks for the word definition then gets the string after that
                                flag = true;
                        } else if (flag) { //If the current text is the definition do this
                                definitions.add(text1.trim().replaceAll("\"", "")); //Removes all back slashes and adds to array
                                flag = false; 
                        }
                }
                return definitions;
        }
}
