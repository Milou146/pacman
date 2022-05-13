import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class Entite implements java.io.Serializable{
	/**
	 * La r�f�rence de l'entit�.
	 */
	public short ref ;
	
	/**
	 * La position selon l'axe des abscisses de l'entit�.
	 */
	public byte x = 0;
	
	/**
	 * La position selon l'axe des ordonn�es de l'entit�.
	 */
	public byte y = 0;
    /**
     * The buffered image of the entity which will be drawn in the graphics
     */
    BufferedImage image;
	/**
	 * La position selon les axes x et y de l'entit�.
	 */
	public byte[] pos = {this.x,this.y};
	
	/**
	 * Une entit�, caract�ris�e par sa r�f�rence.
	 *
	 * @param ref la r�f�rence de l'entit�
	 * @throws IOException
	 */
	public Entite(short ref, byte x, byte y) throws IOException
	{
		this.ref = ref;
        this.x = x;
        this.y = y;
	}
	
	/**
	 * La r�f�rence associ�e � l'entit�.
	 * 
	 * @return la r�f�rence de l'entit�.
	 */
	public short getRef()
	{
		return this.ref;
	}
	
	/**
	 * La coordonn�e x de l'entit�.
	 * 
	 * @return la coordonn�e x de l'entit�.
	 */
	byte getX()
	{
		return this.x;
	}
	
	/**
	 * La coordonn�e y de l'entit�.
	 * s
	 * @return la coordonn�e y de l'entit�.
	 */
	byte getY()
	{
		return this.y;
	}
    /**
     * Change the image of the entity to be drawn the next frame
     * @param pathname
     * @throws IOException
     */
    void setImage(String pathname) throws IOException{
        this.image = ImageIO.read(new File(System.getProperty("user.dir") + "/lib/" + pathname));
    }
    /**
     * Get the image to be drawn the next frame
     * @return
     */
    BufferedImage getImage(){
        return this.image;
    }
	/**
	 * Le couple de coordonn�es de l'entit�.
	 * 
	 * @return
	 */
	public byte[] getPos()
	{
		return this.pos;
	}

	void setPos(byte newX, byte newY){
		this.x = newX;
		this.y = newY;
	}
	void draw(){
		App.graphics.drawImage(image,x*40+1,y*40+1,null);
	}
	void addX(byte amount){
		x += amount;
	}
	void addY(byte amount){
		y += amount;
	}
}
