package com.company;

import javax.swing.*;
import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private Connection dbConnection;
    private String path;
    private final String createTableSql = "CREATE TABLE IF NOT EXISTS ChessPlayers(\n" +
            "\tid INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "\tname VARCHAR(50),\n" +
            "\tdateOfBirth VARCHAR(50),\n" +
            "\tciti VARCHAR(50),\n" +
            "\trating INTEGER);";

    public Database(){
        File file = new File(getClass().getProtectionDomain().getCodeSource().getLocation().getPath());
        path = file.getParentFile().getAbsolutePath();
        try {
            Class.forName("org.sqlite.JDBC");
            dbConnection = DriverManager.getConnection("jdbc:sqlite:" + path + "/players.db");
            Statement dbStatement = dbConnection.createStatement();
            dbStatement.execute(createTableSql);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (dbConnection != null) {
                    dbConnection.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public List<Chesser> fetchData() {
        List<Chesser> data = new ArrayList<>();
        try {
            dbConnection = DriverManager.getConnection("jdbc:sqlite:" + path + "/players.db");
            Statement dbStatement = dbConnection.createStatement();
            //for (int i = 0; i < 1; i++) {
            //dbStatement.executeUpdate("INSERT INTO ChessPlayers(citi, dateOfBirth, name, rating) VALUES ('Mariupol', '15.02.2001', 'Sonechka', 2200)");
            //}
            //dbStatement.executeUpdate("DELETE FROM ChessPlayers WHERE 1=1");

            ResultSet result = dbStatement.executeQuery("SELECT * FROM ChessPlayers");
            while (result.next()) {
                data.add(new Chesser(result.getInt(1), result.getString(2),
                        result.getString(3), result.getString(4), result.getInt(5)));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                if (dbConnection != null) {
                    dbConnection.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return data;
    }

    public void addElement(String city, String dateOfBirth, String name, String rating) {
        try {
            dbConnection = DriverManager.getConnection("jdbc:sqlite:" + path + "/players.db");
            System.out.println("Connected");
            Statement dbStatement = dbConnection.createStatement();
            for (int i = 0; i < 1; i++) {
                dbStatement.executeUpdate("INSERT INTO ChessPlayers(citi, dateOfBirth, name, rating) VALUES (" +
                        "'" + city + "'" + ", '"+dateOfBirth+"', '"+name+"', "+rating+")");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (dbConnection != null) {
                    dbConnection.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
