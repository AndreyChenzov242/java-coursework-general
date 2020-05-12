package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Editor extends JDialog{
    private JPanel MainPanel;
    private JButton acceptButton;
    private JTextField textFieldName;
    private JTextField textFieldDOB;
    private JTextField textFieldCity;
    private JTextField textFieldRating;

    public Editor(ChessPlayers chessPlayers, Database db, int index){
        add(MainPanel);
        pack();
        setLocationRelativeTo(null);
        setTitle("Edit info");
        setMinimumSize(new Dimension(500, 70));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(textFieldName.getText().equals("")||textFieldDOB.getText().equals("")
                        ||textFieldCity.getText().equals("")||textFieldRating.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Enter all data");
                } else{
                    db.editElement( textFieldCity.getText(),
                            textFieldDOB.getText(),textFieldName.getText(), textFieldRating.getText(), index);
                    chessPlayers.update();
                    dispose();
                }
            }
        });
    }
}
