package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PreEditor extends JDialog {
    private JButton button1;
    private JTextField textField1;
    private JPanel MainPanel;

    public PreEditor(ChessPlayers chessPlayers, Database db){
        add(MainPanel);
        pack();
        setLocationRelativeTo(null);
        setTitle("Edit info");
        setMinimumSize(new Dimension(200, 70));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if(textField1.getText().equals("")){
                    JOptionPane.showMessageDialog(null,"Error");
                } else{
                    if(chessPlayers.getArraySize()<Integer.parseInt(textField1.getText())){
                        JOptionPane.showMessageDialog(null,"Out of bounds");
                    } else {
                        Editor editor = new Editor(chessPlayers,db,chessPlayers.getNumber(Integer.parseInt(textField1.getText())-1));
                        editor.setVisible(true);
                        dispose();
                    }
                }
            }
        });
    }
}
