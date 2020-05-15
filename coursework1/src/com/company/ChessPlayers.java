package com.company;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        table1 = new JTable()/*{
            @Override
            public boolean isCellEditable(int i, int i1) {
                return false;
            }
        }*/;
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
                PreEditor preEditor = new PreEditor(thisObj,db);
                preEditor.setVisible(true);
                update();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DelDialog del = new DelDialog(thisObj, db);
                del.setVisible(true);
                update();

                // снизу
            }
        });
    }
    public int getNumber(int index){
        return array.get(index).getId();
    }
    public int getArraySize(){
        return array.size();
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
