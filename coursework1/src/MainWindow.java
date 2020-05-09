import com.company.ChessPlayers;
import com.company.AddDialog;
import com.company.Database;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {

    public ChessPlayers chessPlayers;
    private Toolkit toolkit = Toolkit.getDefaultToolkit();
    private Dimension dimension = toolkit.getScreenSize();
    private JFrame mainWindow;
    private Database db;

    public MainWindow() {
        db = new Database();

        mainWindow = new JFrame();
        mainWindow.setVisible(true);
        mainWindow.setMinimumSize(dimension);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setTitle("Chess catalog");

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(null);

        mainWindow.add(buttonPanel);

        JButton gButton = new JButton("General list of chess players");
        gButton.setFont(new Font("Arial", Font.BOLD, 16));
        gButton.setLocation(dimension.width / 2 - 150, dimension.height / 2 - 350);
        gButton.setSize(300, 50);
        gButton.setBorderPainted(false);
        gButton.setFocusPainted(false);
        buttonPanel.add(gButton);

        JButton addButton = new JButton("Add a chess player");
        addButton.setFont(new Font("Arial", Font.BOLD, 16));
        addButton.setLocation(dimension.width / 2 - 150, dimension.height / 2 - 260);
        addButton.setSize(300, 50);
        addButton.setBorderPainted(false);
        addButton.setFocusPainted(false);
        buttonPanel.add(addButton);

        JButton delButton = new JButton("Delete a chess player");
        delButton.setFont(new Font("Arial", Font.BOLD, 16));
        delButton.setLocation(dimension.width / 2 - 150, dimension.height / 2 - 170);
        delButton.setSize(300, 50);
        delButton.setBorderPainted(false);
        delButton.setFocusPainted(false);
        buttonPanel.add(delButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Arial", Font.BOLD, 16));
        exitButton.setLocation(dimension.width / 2 - 150, dimension.height / 2 - 80);
        exitButton.setSize(300, 50);
        exitButton.setBorderPainted(false);
        exitButton.setFocusPainted(false);
        buttonPanel.add(exitButton);

        gButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {     //нажатие на кнопку
                if (chessPlayers != null) {
                    chessPlayers.setVisible(false);
                    chessPlayers.dispose();
                }
                chessPlayers = new ChessPlayers(db);
                chessPlayers.setVisible(true);
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {     //нажатие на кнопку
                AddDialog add = new AddDialog(mainWindow, db, false);
                add.setVisible(true);
            }
        });

        delButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {     //нажатие на кнопку

            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {     //нажатие на кнопку
                mainWindow.dispose();
                chessPlayers.dispose();
            }
        });
    }

    public static void main(String[] args) {
        MainWindow mw = new MainWindow();
    }
}
