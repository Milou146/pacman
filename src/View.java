import java.awt.*;
import javax.swing.*;

public class View {
    public static JFrame frame;

    public static Graphics graphics;

    View(){
        View.frame = new JFrame("Pacman");
        frame.setSize(new Dimension(1920,1080));
        frame.setVisible(true);
        frame.setLocation(80, 30);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        View.graphics = frame.getGraphics();//the frame's graphic
    }
}
