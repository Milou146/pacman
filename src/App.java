/**
 * This is where we implement all the classes process the view
 * @author Emilien André
 */
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.*;
import javax.swing.*;

public class App {
    public static final JFrame frame = new JFrame("Pacman");
    public static Graphics graphics;
    public static Ghost[] ghosts;
    public static int[][] pacgommes;
    public static void main(String[] args) throws Exception {
        // Frame Init
        frame.setSize(new Dimension(1000,1000));
        frame.setVisible(true);
        frame.setLocation(80, 30);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        graphics = frame.getGraphics();//the frame's graphic

        // Getting game data
        SerializerDonnees.creerFichier(1);
        DeSerializerDonnees.getFichier("1");

        // Loading game data
        Pacman pacman = DeSerializerDonnees.getPacman();
        ghosts = DeSerializerDonnees.getGhosts();
        int[][] walls = DeSerializerDonnees.getLevel().getTabLayout()[0];
        pacgommes = DeSerializerDonnees.getLevel().getTabLayout()[2];

        // Setting entities images
        pacman.setImage("pacman_1_0.png");
        for(int i=0;i<=3;i++){
            ghosts[i].setImage("ghost" + i + ".png");
        }

        // Drawing the game board and entities
        for(int i=0; i<22; i++){
            for(int j=0; j<19; j++){
                if(walls[i][j] == 1){
                    graphics.drawRect(j*40, i*40, 40, 40);
                }
                if(pacgommes[i][j] == 1){
                    graphics.drawOval(j*40+10, i*40+10, 20,20);
                }
            }
        }
        for(int i=0;i<=3;i++){
            ghosts[i].draw();
        }

        // Setting the refresh frame
        int refreshRate = 200;
        class RefreshFrame extends Thread {
            long refreshRate;
            RefreshFrame(long refreshRate) {
                this.refreshRate = refreshRate;
            }
        
            public void run() {
                while(true){
                    pacman.openCloseMouth();//change the mouth's state closed to open or open to closed
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

        // KeyListener
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
        frame.addKeyListener(new GameKeyListener());

        // Moving the entities
        while(true){
            pacman.move();
            for(int i=0; i<=3; i++){
                ghosts[i].move();
            }
            Thread.sleep(refreshRate); // we don't want the move to be triggered more than the screen refresh
        }
    }
}