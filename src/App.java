import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;
public class App {
    public static void main(String[] args) throws Exception {
        JFrame frame = new JFrame("Pacman");
        frame.setSize(new Dimension(1080,720));
        frame.setVisible(true);
        frame.setLocation(80, 30);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Graphics graphics = frame.getGraphics();
        Pacman pacman = new Pacman(graphics);
        int refreshRate = 200;
        class RefreshFrame extends Thread {
            long refreshRate;
            RefreshFrame(long refreshRate) {
                this.refreshRate = refreshRate;
            }
        
            public void run() {
                while(true){
                    graphics.clearRect(0,0,1080,720); //clear the graphics
                    pacman.openCloseMouth();//change the mouth's state closed to open or open to closed
                    pacman.draw();
                    try {
                        Thread.sleep(refreshRate);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        RefreshFrame autoRefresh = new RefreshFrame(refreshRate);
        autoRefresh.start();
        class GameKeyListener implements KeyListener{
        
            @Override
            public void keyTyped(KeyEvent e) {
                
            }
        
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if(key == 90){
                    pacman.setDir("front");
                }
                else if(key == 81){
                    pacman.setDir("left");
                }
                else if(key == 83){
                    pacman.setDir("back");
                }
                else if(key == 68){
                    pacman.setDir("right");
                }
            }
        
            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
        
        }
        frame.addKeyListener(new GameKeyListener());
        while(true){
            if(pacman.canMove()){
                pacman.move();
            }
            Thread.sleep(refreshRate);
        }
    }
}