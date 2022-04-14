import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
public class Pacman{
    BufferedImage image;
    Graphics graphics;
    int x;
    int y;
    int xDir;
    int yDir;
    String mouthState;
    String dir;
    Pacman(Graphics graphics) throws IOException{
        this.image = ImageIO.read(new File(System.getProperty("user.dir") + "\\lib\\pacman_open_left.png"));
        this.graphics = graphics;
        this.x = 60;
        this.y = 60;
        this.mouthState = "open";
        this.xDir = -1;// move left by default
        this.yDir = 0;
        this.dir = "left";
    }
    BufferedImage getImage(){
        return this.image;
    }
    int getX(){
        return this.x;
    }
    int getY(){
        return this.y;
    }
    void setX(int newX){
        this.x = newX;
    }
    void setY(int newY){
        this.y = newY;
    }
    void setPos(int newX,int newY){
        this.x = newX;
        this.y = newY;
    }
    void setImage(String pathname) throws IOException{
        this.image = ImageIO.read(new File(System.getProperty("user.dir") + "\\lib\\" + pathname));
    }
    boolean isMouthOpen(){
        return this.mouthState.equals("open");
    }
    void closeMouth() throws IOException{
        this.image = ImageIO.read(new File(System.getProperty("user.dir") + "\\lib\\pacman_closed.png"));
        this.mouthState = "closed";
    }
    void openMouth() throws IOException{
        this.image = ImageIO.read(new File(System.getProperty("user.dir") + "\\lib\\pacman_open_" + dir + ".png"));
        this.mouthState = "open";
    }
    void draw(){
        graphics.drawImage(image,x,y,null);
    }
    void setDir(String newDir){
        dir = newDir;
        if(newDir.equals("left")){
            xDir = -1;
            yDir = 0;
        }
        else if(newDir.equals("right")){
            xDir = 1;
            yDir = 0;
        }
        else if(newDir.equals("front")){
            xDir = 0;
            yDir = -1;
        }
        else if(newDir.equals("back")){
            xDir = 0;
            yDir = 1;
        }
    }
    int getXDir(){
        return this.xDir;
    }
    int getYDir(){
        return this.yDir;
    }
    void setXDir(int newXDir){
        xDir = newXDir;
    }
    void setYDir(int newYDir){
        yDir = newYDir;
    }
    void move(){
        setPos(getX() + 10 * getXDir(),getY() + 10 * getYDir());
    }
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
    boolean canMove(){
        return getX() + 10 * getXDir() > 0 && getX() + 10 * getXDir() + 40 < 1920 && getY() + 10 * getYDir() > 0 && getY() + 10 * getYDir() + 40 < 1080;
    }
}
