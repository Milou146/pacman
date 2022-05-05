import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
/**
 * @author Emilien ANDRE
 */
public class Pacman extends Entite{
    /**
     * Le nombre de points de vies de Pacman
     */
    static int LP = 3;
    /**
     * The buffered image of Pacman which will be drawn in the graphics
     */
    BufferedImage image;
    /**
     * The graphics in which Pacman will be drawn each frame
     */
    Graphics graphics;
    /**
     * The x position of Pacman
     */
    short x; // I dont think anyone have a monitor with a resolution higher than 32768 px
    /**
     * The y position of Pacman
     */
    short y;
    /**
     * The x direction of Pacman
     */
    byte xDir;
    /**
     * The y direction of Pacman
     */
    byte yDir;
    /**
     * The mouth state of Pacman
     * 0 for closed
     * 1 for open
     */
    byte mouthState;
    /**
     * The direction of Pacman
     * 0 is -X
     * 1 is +X
     * 2 is -Y
     * 3 is +Y
     */
    byte dir;
    Pacman(Graphics graphics) throws IOException{
        this.image = ImageIO.read(new File(System.getProperty("user.dir") + "\\lib\\pacman_1_0.png"));
        this.graphics = graphics;
        this.x = 60;
        this.y = 60;
        this.mouthState = 1;
        this.xDir = -1;// move left by default
        this.yDir = 0;
        this.dir = 0;
    }
    /**
     * Get the image of pacman to be drawn the next frame
     * @return
     */
    BufferedImage getImage(){
        return this.image;
    }
    /**
     * Get the x position of pacman
     * @return the x position
     */
    short getX(){
        return this.x;
    }
    /**
     * Get the current y position of pacman
     * @return the y position
     */
    short getY(){
        return this.y;
    }
    /**
     * Set Pacman's x position
     * @param newX the new x position
     */
    void setX(short newX){
        this.x = newX;
    }
    /**
     * Set Pacman's y position
     * @param newY the new y position
     */
    void setY(short newY){
        this.y = newY;
    }
    /**
     * Set Pacman's position
     * @param newX the new x position
     * @param newY the nex y position
     */
    void setPos(short newX,short newY){
        this.x = newX;
        this.y = newY;
    }
    /**
     * Change the image of pacman to be drawn the next frame
     * @param pathname
     * @throws IOException
     */
    void setImage(String pathname) throws IOException{
        this.image = ImageIO.read(new File(System.getProperty("user.dir") + "\\lib\\" + pathname));
    }
    /**
     * 
     * @return true if pacman's mouth is open
     */
    boolean isMouthOpen(){
        return this.mouthState == 1;
    }
    /**
     * Close Pacman's mouth by drawing another picture
     * @throws IOException
     */
    void closeMouth() throws IOException{
        this.image = ImageIO.read(new File(System.getProperty("user.dir") + "\\lib\\pacman_0.png"));
        this.mouthState = 0;
    }
    /**
     * Open Pacman's mouth by drawing another picture
     * @throws IOException
     */
    void openMouth() throws IOException{
        this.image = ImageIO.read(new File(System.getProperty("user.dir") + "\\lib\\pacman_1_" + dir + ".png"));
        this.mouthState = 1;
    }
    /**
     * Draw Pacman onto the graphics at his specified position with his speficied BufferedImage
     */
    void draw(){
        graphics.drawImage(image,x,y,null);
    }
    /**
     * Set in which direction Pacman will move
     * @param newDir "left" "right" "front" "back"
     */
    void setDir(String newDir){
        if(newDir.equals("left")){
            xDir = -1;
            yDir = 0;
            dir = 0;
        }
        else if(newDir.equals("right")){
            xDir = 1;
            yDir = 0;
            dir = 1;
        }
        else if(newDir.equals("front")){
            xDir = 0;
            yDir = -1;
            dir = 2;
        }
        else if(newDir.equals("back")){
            xDir = 0;
            yDir = 1;
            dir = 3;
        }
    }
    /**
     * -1 means -X
     * +1 means +X
     * @return the X moving direction of Pacman
     */
    byte getXDir(){
        return this.xDir;
    }
    /**
     * -1 means -Y
     * 1 means +Y
     * @return the Y moving direction of Pacman
     */
    byte getYDir(){
        return this.yDir;
    }
    /**
     * Set the X moving direction of Pacman
     * @param newXDir the new direction, -1 or 1
     */
    void setXDir(byte newXDir){
        xDir = newXDir;
    }
    /**
     * Set the Y moving direction of Pacman
     * @param newYDir
     */
    void setYDir(byte newYDir){
        yDir = newYDir;
    }
    /**
     * Move Pacman 10 pixels in his direction
     */
    void move(){
        setPos((short)(getX() + 10 * getXDir()),(short)(getY() + 10 * getYDir()));
    }
    /**
     * If Pacman is stuck in a wall his mouth remains open
     * otherwise his mouth closed if its open or open if its closed
     */
    void openCloseMouth(){
        if(isMouthOpen() && getXDir() + getYDir() != 0){//if pacman is stuck his mouth remains open
            try {
                closeMouth();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else{
            try {
                openMouth();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * Tell us whether Pacman can move or not
     * @return whether Pacman can move or not.
     */
    boolean canMove(){
        return getX() + 10 * getXDir() > 0 && getX() + 10 * getXDir() + 40 < 1920 && getY() + 10 * getYDir() > 0 && getY() + 10 * getYDir() + 40 < 1080;
    }

    /**
     * Pacman
     * 
     * @param ref la référence de pacman (=1)
     * @param etatG l'état de Pacman
     */
    public Pacman(int ref, short x, short y){
        super(ref);
        this.x = x;
        this.y = y;
    }

    public static int etatP;

    void moveP(){
        int[] p = getPos();
        int x = p[0];
        int y = p[1];
        int xMov = getXDir();
        int yMov = getYDir();
        int[][] lay0 = Layout.getLayout(0);
        int[][] lay2 = Layout.getLayout(2);
        int[] posG = Ghost.getMoveG();
        if (yMov == -1 && lay0[y-1][x] != 9){
            p[0] -= 1;
            lay0[y][x] = 0;
        }
        else if (xMov == -1 && lay0[y][x-1] != 9){
            p[1] += 1;
            lay0[y][x] = 0;
        }
        else if (yMov == 1 && lay0[y+1][x] != 9){
            p[0] += 1;
            lay0[y][x] = 0;
        }
        else if (xMov == 1 && lay0[y][x+1] != 9){
            p[1] -= 1;
            lay0[y][x] = 0;
        }
        LPcomp.death(p, posG);
        int pacG = lay2[p[0]][p[1]];
        int posP = lay0[p[0]][p[1]];
        Compteur.incComp(posP, pacG);
    }
}