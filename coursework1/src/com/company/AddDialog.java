package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddDialog extends JDialog {
    private JTextField textFieldName;
    private JTextField textFieldDOB;
    private JTextField textFieldCity;
    private JTextField textFieldRating;
    private JButton buttonAccept;
    private JPanel MainPanel;
    private JLabel Label1;
    private JLabel Label2;
    private JLabel label3;
    private JLabel Label4;
    private String DigitRegex = "\\d+";
    private String NotDigitRegex = "\\w+";
    private String DOBRegex = "^[0-3][0-9]-[0-1][0-9]-\\d{4}$";

    public AddDialog(Frame owner, Database db, boolean modal){
        super(owner, "Add chesser", modal);
        MainPanel.setBackground(new Color(23, 24, 50));
        buttonAccept.setBackground(new Color(45, 200, 185));
        add(MainPanel);
        pack();
        setLocationRelativeTo(null);
        setTitle("Add chess player");
        setMinimumSize(new Dimension(450, 500));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        buttonAccept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(!textFieldName.getText().matches(NotDigitRegex)||!textFieldDOB.getText().matches(DOBRegex)
                        ||!textFieldCity.getText().matches(NotDigitRegex)||!textFieldRating.getText().matches(DigitRegex)){
                    JOptionPane.showMessageDialog(null,"Wrong data");
                } else{
                    db.addElement(textFieldCity.getText(), textFieldDOB.getText(),
                            textFieldName.getText(), textFieldRating.getText());
                    dispose();
                }
            }
        });
    }


}
