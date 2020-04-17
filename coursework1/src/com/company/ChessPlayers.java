package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;
import java.lang.Class;
import java.util.ArrayList;
import java.util.List;

public class ChessPlayers extends JFrame {
    static List<Chesser> array = new ArrayList<>();
    private JPanel newPanel;
    private JButton addNewButton;
    private JButton deleteButton;
    private JButton editButton;
    private JTable table1;
    private JPanel buttonsPanel;
    static int size = 0;

    public static void connect() {
        Connection dbConnection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            dbConnection = DriverManager.getConnection("jdbc:sqlite:players.db");
            System.out.println("Connected");
            Statement dbStatement = dbConnection.createStatement();
            //for (int i = 0; i < 50; i++) {
             //   dbStatement.executeUpdate("INSERT INTO ChessPlayers(citi, dateOfBirth, name, rating) VALUES ('Mariupol', '2229.87.20056', 'Andrey', 56)");
            //}
            //dbStatement.executeUpdate("DELETE FROM ChessPlayers WHERE 1=1");

            ResultSet result = dbStatement.executeQuery("SELECT * FROM ChessPlayers");


            while (result.next()) {
                array.add(new Chesser(result.getInt(1), result.getString(2), result.getString(3), result.getString(4), result.getInt(5)));

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

    public ChessPlayers() {
        connect();
        String[] columnNames = {
                "№",
                "Name",
                "DOB",
                "City",
                "Rating"
        };
        String data[][] = new String[array.size()][5];
        System.out.println("hello" + array.size());
        for (int i = 0; i < array.size(); i++) {
            data[i][0] = Integer.toString(i+1);
            data[i][1] = array.get(i).getName();
            data[i][2] = array.get(i).getDateOfBirth();
            data[i][3] = array.get(i).getCity();
            data[i][4] =Integer.toString(array.get(i).getRating());
        }

        table1 = new JTable(data, columnNames);
        JScrollPane scrollPane = new JScrollPane(table1);
        //buttonsPanel.setBackground(Color.YELLOW);
        getContentPane().add(scrollPane);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        setTitle("General list of chess players");
        setSize(new Dimension(467, 500));
        add(newPanel);

    }
}
