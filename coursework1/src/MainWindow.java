import com.company.ChessPlayers;
import com.company.AddDialog;
import com.company.Database;
import com.company.DelDialog;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MainWindow {

    public ChessPlayers chessPlayers;
    private Dimension dimension = new Dimension(800,900);
    private JFrame mainWindow;
    private Database db;
    private ImageIcon listImg = new ImageIcon("list.png");
    private ImageIcon plusImg = new ImageIcon("plus.png");
    private ImageIcon deleteImg = new ImageIcon("kill.png");
    private ImageIcon exitImg = new ImageIcon("exit.png");
    private ImageIcon aboutImg = new ImageIcon("about.png");
    private Color btnColor = new Color(45, 200, 185);
    private Color backgroundColor = new Color(23, 24, 50);
    private JDialog jDialog = new JDialog();;

    public MainWindow() {
        db = new Database();
        //db.randomFill(100);

        mainWindow = new JFrame();



        mainWindow.setMinimumSize(dimension);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainWindow.setTitle("Chess catalog");
        mainWindow.setLocationRelativeTo(null);
        mainWindow.setResizable(false);
        mainWindow.pack();


        mainWindow.setVisible(true);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(null);
        buttonPanel.setBackground(backgroundColor);

        JButton gButton = new Button("List of chess players",150, 390,listImg );
        buttonPanel.add(gButton);
        JButton addButton = new Button("Add a chess player",150, 300,plusImg);
        buttonPanel.add(addButton);
        JButton killButton = new Button("Kill my lovely database", 150, 210,deleteImg);
        buttonPanel.add(killButton);
        JButton aboutButton = new Button("About", 150, 120,aboutImg);
        buttonPanel.add(aboutButton);
        JButton exitButton = new Button("Exit",150,30,exitImg);
        buttonPanel.add(exitButton);
        mainWindow.add(buttonPanel);


        gButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {     //нажатие на кнопку
                mainWindow.setVisible(false);
                if (chessPlayers != null) {
                    chessPlayers.setVisible(false);
                    chessPlayers.dispose();
                }
                chessPlayers = new ChessPlayers(db);
                chessPlayers.addWindowListener(new WindowListener() {
                    @Override
                    public void windowOpened(WindowEvent windowEvent) {

                    }

                    @Override
                    public void windowClosing(WindowEvent windowEvent) {

                    }

                    @Override
                    public void windowClosed(WindowEvent windowEvent) {
                        mainWindow.setVisible(true);
                    }

                    @Override
                    public void windowIconified(WindowEvent windowEvent) {

                    }

                    @Override
                    public void windowDeiconified(WindowEvent windowEvent) {

                    }

                    @Override
                    public void windowActivated(WindowEvent windowEvent) {

                    }

                    @Override
                    public void windowDeactivated(WindowEvent windowEvent) {

                    }
                });
                mainWindow.setVisible(false);
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

        aboutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {     //нажатие на кнопку
                if(!jDialog.isVisible()) {
                    JPanel jPanel = new JPanel();
                    jDialog.setTitle("About");
                    JLabel jLabel = new JLabel();
                    jLabel.setText("<html> This is a program that shows a list <br> of chess players. " +
                            "You can remove and <br> add them yourself. <br> <br> <br> <br> <br> " +
                            "© Created by Andrey Chenzov © </html>");
                    jLabel.setForeground(Color.LIGHT_GRAY);
                    jLabel.setVisible(true);
                    jPanel.add(jLabel);
                    jPanel.setBackground(backgroundColor);
                    jDialog.add(jPanel);
                    jDialog.setLocation(dimension.width-200,dimension.height/6);
                    jDialog.setVisible(true);
                    jDialog.setMinimumSize(new Dimension(300, 160));
                    jDialog.setResizable(false);
                } else {
                    jDialog.dispose();
                }
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {     //нажатие на кнопку
                System.exit(0);
            }
        });
    }


    public static void main(String[] args) {
        MainWindow mw = new MainWindow();
    }
}
