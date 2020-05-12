import com.company.ChessPlayers;
import com.company.AddDialog;
import com.company.Database;
import com.company.DelDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {


    public ChessPlayers chessPlayers;
    private Dimension dimension = new Dimension(800,900);
    private JFrame mainWindow;
    private Database db;
    private ImageIcon listImg = new ImageIcon("list.png");
    private ImageIcon plusImg = new ImageIcon("plus.png");
    private ImageIcon deleteImg = new ImageIcon("delete5.png");
    private ImageIcon exitImg = new ImageIcon("exit.png");
    private Color btnColor = new Color(45, 200, 185);
    private Color backgroundColor = new Color(23, 24, 50);


    public MainWindow() {
        db = new Database();
        //db.randomFill(100);

        mainWindow = new JFrame();

        mainWindow.setVisible(true);
        mainWindow.setPreferredSize(dimension);
        mainWindow.setMaximumSize(dimension);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setTitle("Chess catalog");
        mainWindow.setLocationRelativeTo(null);
        mainWindow.pack();

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        buttonPanel.setBackground(backgroundColor);

        JButton gButton = new Button("List of chess players", btnColor,150, 350,listImg );
        buttonPanel.add(gButton);
        JButton addButton = new Button("Add a chess player", btnColor,150, 260,plusImg);
        buttonPanel.add(addButton);
        JButton killButton = new Button("Kill my lovely database", btnColor, 150, 170,deleteImg);
        buttonPanel.add(killButton);
        JButton exitButton = new Button("Exit",btnColor,150,80,exitImg);
        //exitButton.setHorizontalAlignment(SwingConstants.CENTER);
        buttonPanel.add(exitButton);
        mainWindow.add(buttonPanel);

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

        killButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {     //нажатие на кнопку
                db.killDB();
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
