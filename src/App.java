import java.awt.*;
import javax.swing.*;
public class App {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("Pacman");
        frame.setSize(new Dimension(300,300));
        frame.setVisible(true);
        frame.setLocation(80, 30);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Graphics graphics = frame.getGraphics();
        Pacman pacman = new Pacman(graphics);
        while(true){
            graphics.clearRect(0,0,300,300); //clear the graphics
            pacman.setPos(pacman.getX() + 10,pacman.getY() + 10);
            pacman.draw();
            Thread.sleep(1000);
        }
    }
}