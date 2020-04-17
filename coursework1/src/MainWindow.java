import com.company.ChessPlayers;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class MainWindow extends JFrame {

    Toolkit toolkit = Toolkit.getDefaultToolkit();
    Dimension dimension = toolkit.getScreenSize();

    public MainWindow() {

        JFrame jFrame = getFrame();
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setTitle("Chess catalog");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(null);

        jFrame.add(buttonPanel);


        JButton gButton = new JButton("General list of chess players");
        gButton.setFont(new Font("Arial", Font.BOLD, 16));
        gButton.setLocation(dimension.width / 2 - 150, dimension.height / 2 - 350);
        gButton.setSize(300, 50);
        gButton.setBorderPainted(false);
        gButton.setFocusPainted(false);
        buttonPanel.add(gButton);

        gButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {     //нажатие на кнопку


                //connect();
                ChessPlayers cp = new ChessPlayers();
                cp.setVisible(true);
            }
        });

        JButton addButton = new JButton("Add a chess player");
        addButton.setFont(new Font("Arial", Font.BOLD, 16));
        addButton.setLocation(dimension.width / 2 - 150, dimension.height / 2 - 260);
        addButton.setSize(300, 50);
        addButton.setBorderPainted(false);
        addButton.setFocusPainted(false);
        buttonPanel.add(addButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {     //нажатие на кнопку

            }
        });

        JButton delButton = new JButton("Delete a chess player");
        delButton.setFont(new Font("Arial", Font.BOLD, 16));
        delButton.setLocation(dimension.width / 2 - 150, dimension.height / 2 - 170);
        delButton.setSize(300, 50);
        delButton.setBorderPainted(false);
        delButton.setFocusPainted(false);
        buttonPanel.add(delButton);

        delButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {     //нажатие на кнопку

            }
        });

        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 16));
        exitButton.setLocation(dimension.width / 2 - 150, dimension.height / 2 - 80);
        exitButton.setSize(300, 50);
        exitButton.setBorderPainted(false);
        exitButton.setFocusPainted(false);
        buttonPanel.add(exitButton);

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {     //нажатие на кнопку
                jFrame.dispose();
            }
        });

    }


    static JFrame getFrame() {
        JFrame jFrame = new JFrame();
        jFrame.setVisible(true);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension = toolkit.getScreenSize();
        jFrame.setMinimumSize(dimension);
        return jFrame;
    }




    public static void main(String[] args) {
        MainWindow mw = new MainWindow();

    }
}
