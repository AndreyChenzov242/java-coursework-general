import javax.swing.*;
import java.awt.*;

public class Button extends JButton {
    private Toolkit toolkit = Toolkit.getDefaultToolkit();
    private Dimension dimension = new Dimension(800,1200);

    Button(String text, Color color, int x, int y, Icon icon){
        setHorizontalAlignment(SwingConstants.LEFT);
        setIcon(icon);
        setBackground(color);
        setText(text);
        setFont(new Font("Droid Serif", Font.BOLD, 16));
        setLocation(dimension.width / 2 - x , dimension.height / 2 - y);
        setSize(300, 50);
        setBorderPainted(false);
        setFocusPainted(false);
    }
}
