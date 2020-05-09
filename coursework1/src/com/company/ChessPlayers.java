package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.xml.crypto.Data;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.lang.Class;
import java.util.ArrayList;
import java.util.List;

public class ChessPlayers extends JFrame {
    private List<Chesser> array;
    private JPanel newPanel;
    private JButton addNewButton;
    private JButton deleteButton;
    private JButton editButton;
    private JTable table1;
    private JPanel buttonsPanel;
    private Database db;

    private final String[] columnNames = {
            "№",
            "Name",
            "DOB",
            "City",
            "Rating"
    };

    public ChessPlayers(Database db) {
        this.db = db;
        table1 = new JTable();
        JScrollPane scrollPane = new JScrollPane(table1);
        getContentPane().add(scrollPane);

        update();

        pack();
        add(newPanel);
        setLocationRelativeTo(null);
        setTitle("General list of chess players");
        setMinimumSize(new Dimension(467, 500));
        setResizable(false);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        ChessPlayers thisObj = this;

        addNewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                AddDialog add = new AddDialog(thisObj, db, true);
                add.setVisible(true);
                update();
            }
        });

        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                update();
            }
        });
    }

    public void update() {
        array = db.fetchData();
        String data[][] = new String[array.size()][5];
        System.out.println("hello" + array.size());
        for (int i = 0; i < array.size(); i++) {
            data[i][0] = Integer.toString(i + 1);
            data[i][1] = array.get(i).getName();
            data[i][2] = array.get(i).getDateOfBirth();
            data[i][3] = array.get(i).getCity();
            data[i][4] = Integer.toString(array.get(i).getRating());
        }
        TableModel model = new DefaultTableModel(data, columnNames);
        table1.setModel(model);
    }
}
