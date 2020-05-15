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
    private JLabel mainLabel;
    private String DigitRegex = "\\d+";
    private String NotDigitRegex = "\\w+";
    private String DOBRegex = "^[0-3][0-9]-[0-1][0-9]-\\d{4}$";
        //System.out.println(data.matches(regex));

    public Editor(ChessPlayers chessPlayers, Database db, String num){
        mainLabel.setText("Edit chess player under number: "+num);
        add(MainPanel);
        pack();
        setLocationRelativeTo(null);
        setTitle("Edit");
        setMinimumSize(new Dimension(500, 70));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!textFieldName.getText().matches(NotDigitRegex)||!textFieldDOB.getText().matches(DOBRegex)
                        ||!textFieldCity.getText().matches(NotDigitRegex)||!textFieldRating.getText().matches(DigitRegex)){
                    JOptionPane.showMessageDialog(null,"Wrong data");
                    System.out.println(!textFieldName.getText().matches(NotDigitRegex));
                    System.out.println(!textFieldDOB.getText().matches(DOBRegex));
                    System.out.println(!textFieldCity.getText().matches(NotDigitRegex));
                    System.out.println(!textFieldRating.getText().matches(DigitRegex));
                } else{
                    db.editElement( textFieldCity.getText(),
                            textFieldDOB.getText(),textFieldName.getText(), textFieldRating.getText(), chessPlayers.getNumber(Integer.parseInt(num)-1));
                    chessPlayers.update();
                    dispose();
                }
            }
        });
    }
}
