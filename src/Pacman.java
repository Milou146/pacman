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
    Pacman(Graphics graphics) throws IOException{
        this.image = ImageIO.read(new File(System.getProperty("user.dir") + "\\lib\\pacman_open.png"));
        this.graphics = graphics;
        this.x = 60;
        this.y = 60;
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
    void draw(){
        graphics.drawImage(image,x,y,null);
    }
}
