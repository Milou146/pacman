/**
 * This is where we implement all the classes process the view
 * @author Emilien André
 */
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class App {
    public static void main(String[] args) throws Exception {
        new View();
        Pacman pacman = new Pacman((short) 1, (short) 100, (short) 100);
        int refreshRate = 200;
        class RefreshFrame extends Thread {
            long refreshRate;
            RefreshFrame(long refreshRate) {
                this.refreshRate = refreshRate;
            }
        
            public void run() {
                while(true){
                    View.graphics.clearRect(0,0,1920,1080); //clear the graphics
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
            public void keyTyped(KeyEvent e) {// there is nothing to do aside override the default method
            }
        
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if(key == 90){ // Z
                    pacman.setDir("front");
                }
                else if(key == 81){ // Q
                    pacman.setDir("left");
                }
                else if(key == 83){ // S
                    pacman.setDir("back");
                }
                else if(key == 68){ // D
                    pacman.setDir("right");
                }
            }
        
            @Override
            public void keyReleased(KeyEvent e) {// there is nothing to do aside override the default method
            }
        
        }
        View.frame.addKeyListener(new GameKeyListener());

        while(true){
            if(pacman.canMove()){
                pacman.move();
            }
            Thread.sleep(refreshRate); // we don't want the move to be triggered more than the screen refresh
        }
    }
}