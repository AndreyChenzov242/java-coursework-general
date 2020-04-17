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
                JFrame generalList = getFrame();
                generalList.setTitle("General list of chess players");
                generalList.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                connect();
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

    public static void connect(){
        Connection dbConnection = null;
        try {
            Class.forName("org.sqlite.JDBC");
            dbConnection = DriverManager.getConnection("jdbc:sqlite:players.db");
            System.out.println("Connected");
            Statement dbStatement = dbConnection.createStatement();
            dbStatement.executeUpdate("INSERT INTO ChessPlayers(citi, dateOfBirth, name, rating) VALUES ('Mariupol', '2229.87.20056', 'Andrey', 56)");
            //dbStatement.executeUpdate("DELETE FROM ChessPlayers WHERE 1=1");
            int counter = 0;
            ResultSet result = dbStatement.executeQuery("SELECT * FROM ChessPlayers");
            while (result.next()) {
                System.out.println(++counter + ": " + result.getString(2) + " "
                        + result.getString(3) + " " + result.getString(4) + " " + result.getString(5));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (dbConnection != null) {
                    dbConnection.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }


    public static void main(String[] args) {
        MainWindow mw = new MainWindow();

    }
}
