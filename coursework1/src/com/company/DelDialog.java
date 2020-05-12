package com.company;

import com.company.ChessPlayers;
import com.company.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DelDialog extends JDialog{
    private JButton button1;
    private JTextField textField1;
    private JPanel MainPanel;

    public DelDialog(ChessPlayers chessPlayers, Database db){
        super(chessPlayers, true);
        add(MainPanel);
        pack();
        setLocationRelativeTo(null);
        setTitle("Delete chess player");
        setMinimumSize(new Dimension(300, 70));
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
                        db.delElement(chessPlayers.getNumber(Integer.parseInt(textField1.getText())-1));
                        dispose();
                    }
                }
            }
        });
    }
}
