/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author lance_tan
 */
public class sqlMain {
        
        Connection con; //Create connection object
        Statement stmt; //Create statement object
        ResultSet rs; //Creates result set object
        String driverName = "org.apache.derby.jdbc.EmbeddedDriver"; //Creates a variable for the name of the driver
        String connectString = "jdbc:derby://localhost:1527/quizGenerator"; //The string needed to connect to the server
        String uname = "ia"; //The username of the server
        String pwd = "ia"; //The password of the server
        
        public sqlMain() { //Makes a connection with the jdbc 
                try {
                        Class.forName(driverName);
                        //Creates a connection with the driver
                        con = DriverManager.getConnection(connectString, uname, pwd);
                        //Creates a statement object
                        stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
                        
                } catch(ClassNotFoundException | SQLException e) {
                        System.out.println("Error 1: " + e.toString());
                }
                
        }
        
        public String resultSet(String query, String columnTitle) {
                try {
                        rs = stmt.executeQuery(query);
                        rs.next();
                        return rs.getString(columnTitle);
                } catch(SQLException e) {
                        System.out.println("Error 1: " + e.toString());
                        return "";
                }
        }
        
        public String nextItem(String columnTitle) {
                try {
                        rs.next();
                        return rs.getString(columnTitle);
                } catch(SQLException e) {
                        System.out.println("Error 1: " + e.toString());
                        try {
                                rs.first();
                                return rs.getString(columnTitle);
                        } catch(SQLException er) {
                                System.out.println("Error 2: " + er.toString());
                                return "";
                        }
                }
        }
        
        public String previousItem(String columnTitle) {
                try {
                        rs.previous();
                        return rs.getString(columnTitle);
                } catch(SQLException e) {
                        System.out.println("Error 1: " + e.toString());
                        try {
                                rs.last();
                                return rs.getString(columnTitle);
                        } catch(SQLException er) {
                                System.out.println("Error 2: " + er.toString());
                                return "";
                        }
                }
        }
        
        public void addItem(String tableName, String columnTitle, String value1) {
                try {
                        stmt.executeUpdate(String.format("INSERT INTO %s (%s) VALUES ('%s')", tableName, columnTitle, value1));
                } catch(SQLException e) {
                        System.out.println("Error 1: " + e.toString());
                }
        }
        
        public void addItem(String tableName, String columnTitle1, String columnTitle2, int value1, int value2) {
                try {
                        stmt.executeUpdate(String.format("INSERT INTO %s (%s, %s) VALUES (%d, %d)", tableName, columnTitle1, columnTitle2, value1, value2));
                } catch(SQLException e) {
                        System.out.println("Error 1: " + e.toString());
                }
        }
        
        public void addItem(String tableName, String columnTitle1, String columnTitle2, String value1, int value2) {
                try {
                        stmt.executeUpdate(String.format("INSERT INTO %s (%s, %s) VALUES ('%s', %d)", tableName, columnTitle1, columnTitle2, value1, value2));
                } catch(SQLException e) {
                        System.out.println("Error 1: " + e.toString());
                }
        }
        
        public void addItem(String tableName, String columnTitle1, String columnTitle2, String columnTitle3, String value1, int value2) {
                try {
                        stmt.executeUpdate(String.format("INSERT INTO %s (%s, %s, %s) VALUES ('%s', CURRENT_TIMESTAMP, %d)", tableName, columnTitle1, columnTitle2, columnTitle3, value1, value2));
                } catch(SQLException e) {
                        System.out.println("Error 1: " + e.toString());
                }
        }

        public void addItem(String tableName, String columnTitle1, String columnTitle2, String columnTitle3, String columnTitle4, String value1, String value2, int value3) {
                try {
                        stmt.executeUpdate(String.format("INSERT INTO %s (%s, %s, %s, %s) VALUES ('%s', '%s', CURRENT_TIMESTAMP, %d)", tableName, columnTitle1, columnTitle2, columnTitle3, columnTitle4, value1, value2, value3));
                } catch(SQLException e) {
                        System.out.println("Error 1: " + e.toString());
                }
        }
        
        public int addItem(String tableName, String columnTitle1, String columnTitle2, String columnTitle3, String columnTitle4, String columnTitle5, String columnTitle6, String value1, String value2, String value3, String value4, String value5, int value6) {
                try {
                        PreparedStatement ps = con.prepareStatement(String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s) VALUES ('%s', '%s', '%s', '%s', '%s', %d)", tableName, columnTitle1, columnTitle2, columnTitle3, columnTitle4, columnTitle5, columnTitle6, value1, value2, value3, value4, value5, value6), Statement.RETURN_GENERATED_KEYS);
                        ps.execute();
                        rs = ps.getGeneratedKeys();
                        int generatedKey = 0;
                        if(rs.next()) {
                                generatedKey = rs.getInt(1);
                        }
                        return generatedKey;
                } catch(SQLException e) {
                        System.out.println("Error 1: " + e.toString());
                        return -1;
                }
        }
                
        public void removeItem(String tableName, String columnTitle, String text) {
                try {
                        stmt.executeUpdate(String.format("DELETE FROM %s WHERE %s='%s'", tableName, columnTitle, text));
                } catch(SQLException e) {
                        System.out.println("Error 1: " + e.toString());
                }
        }
        
        public int retrieveID(String columnTitle, String tableName, String condition, String condition1) {
                try {
                        rs = stmt.executeQuery(String.format("SELECT %s FROM %s WHERE %s='%s'", columnTitle, tableName, condition, condition1));
                        while(rs.next()) {
                                int ID = rs.getInt(columnTitle);
                                return ID;
                        }
                        return -1;
                } catch(SQLException e) {
                        System.out.println("Error 1: " + e.toString());
                        return -1;
                }
        }
        
        public ArrayList<Integer> retrieveID(String columnTitle, String tableName, String condition, int condition1) {
                try {
                        ArrayList<Integer> IDs = new ArrayList<Integer>();
                        
                        rs = stmt.executeQuery(String.format("SELECT %s FROM %s WHERE %s=%d", columnTitle, tableName, condition, condition1));
                        while(rs.next()) {
                                int ID = rs.getInt(columnTitle);
                                IDs.add(ID);
                        }
                        return IDs;
                } catch(SQLException e) {
                        System.out.println("Error 1: " + e.toString());
                        return null;
                }
        }
        
        public String retrieveData(String columnTitle, String tableName, String condition, int condition1) {
                try {
                        rs = stmt.executeQuery(String.format("SELECT %s FROM %s WHERE %s=%d", columnTitle, tableName, condition, condition1));
                        while(rs.next()) {
                                String data = rs.getString(columnTitle);
                                return data;
                        }
                        return "";
                } catch(SQLException e) {
                        System.out.println("Error 1: " + e.toString());
                        return "";
                }
        }
}
