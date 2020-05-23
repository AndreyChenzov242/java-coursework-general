import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Button extends JButton {
    private Toolkit toolkit = Toolkit.getDefaultToolkit();
    private Dimension dimension = new Dimension(800,1200);
    private Color btnColor = new Color(45, 200, 185);
    private Color changedBtnColor = new Color(225,0 ,119);

    Button(String text, int x, int y, Icon icon){
        setHorizontalAlignment(SwingConstants.LEFT);
        setIcon(icon);
        setBackground(btnColor);
        setText(text);
        setFont(new Font("Droid Serif", Font.BOLD, 16));
        setLocation(dimension.width / 2 - x , dimension.height / 2 - y);
        setSize(300, 50);
        setBorderPainted(false);
        setFocusPainted(false);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                setBackground(changedBtnColor);
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                setBackground(btnColor);
            }
        });
    }
}
