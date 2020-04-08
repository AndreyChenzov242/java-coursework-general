import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {

    public MainWindow(){
        setTitle("CheessCatalog");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension dimension= toolkit.getScreenSize();
        setSize(dimension.width,dimension.height);
        setLocationRelativeTo(null);
        setVisible(true);

    }


    public static void main(String[] args){
        MainWindow mw = new MainWindow();

    }
}
