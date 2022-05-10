import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
/**
 * @author Emilien ANDRE
 */
public class Pacman extends Entite{
    /**
     * Le nombre de points de vies de Pacman
     */
    static int LP = 3;
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
        this.image = ImageIO.read(new File(System.getProperty("user.dir") + "/lib/pacman_0.png"));
        this.mouthState = 0;
    }
    /**
     * Open Pacman's mouth by drawing another picture
     * @throws IOException
     */
    void openMouth() throws IOException{
        this.image = ImageIO.read(new File(System.getProperty("user.dir") + "/lib/pacman_1_" + dir + ".png"));
        this.mouthState = 1;
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
     * @throws IOException
     */
    public Pacman(short ref, short x, short y) throws IOException{
        super(ref, x, y);
        System.out.println(System.getProperty("user.dir") + "/lib/pacman_1_0.png");
        this.image = ImageIO.read(new File(System.getProperty("user.dir") + "/lib/pacman_1_0.png"));
        this.mouthState = 1;
        this.xDir = -1;// move left by default
        this.yDir = 0;
        this.dir = 0;
    }

    public static int etatP;

     void moveP(){
        short[] p = getPos();
        short x = p[0];
        short y = p[1];
        byte xMov = getXDir();
        byte yMov = getYDir();
        Layout[] lay = DeSerializerDonnees.getLevel().getTabLayout();
        short[] posG = Ghost.getMoveG();
        if (yMov == -1 && lay[0][y-1][x] != 1){
            p[0] -= 1;
            lay[0][y][x] = 0;
        }
        else if (xMov == -1 && lay[0][y][x-1] != 1){
            p[1] += 1;
            lay[0][y][x] = 0;
        }
        else if (yMov == 1 && lay[0][y+1][x] != 1){
            p[0] += 1;
            lay[0][y][x] = 0;
        }
        else if (xMov == 1 && lay[0][y][x+1] != 9){
            p[1] -= 1;
            lay[0][y][x] = 0;
        }
        LPcomp.decLP(p, posG);
        int pacG = lay[2][p[0]][p[1]];
        int posP = lay[0][p[0]][p[1]];
        Compteur.incComp(posP, pacG, lay);
    }
}