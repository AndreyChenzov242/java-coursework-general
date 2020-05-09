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

    public AddDialog(Frame owner, Database db, boolean modal){
        super(owner, "Add chesser", modal);
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
                if(textFieldName.getText().equals("")||textFieldDOB.getText().equals("")
                        ||textFieldCity.getText().equals("")||textFieldRating.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Enter all data");
                } else{
                    db.addElement(textFieldCity.getText(), textFieldDOB.getText(),
                            textFieldName.getText(), textFieldRating.getText());
                    dispose();
                }
            }
        });
    }


}
