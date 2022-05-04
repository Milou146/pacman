
public class Entite implements java.io.Serializable{
	/**
	 * La référence de l'entité.
	 */
	public int ref = 0;
	
	/**
	 * La position selon l'axe des abscisses de l'entité.
	 */
	public int x = 0;
	
	/**
	 * La position selon l'axe des ordonnées de l'entité.
	 */
	public int y = 0;
	
	/**
	 * La position selon les axes x et y de l'entité.
	 */
	public int[] pos = {this.x,this.y};
	
	/**
	 * Une entité, caractérisée par sa référence.
	 *
	 * @param ref la référence de l'entité
	 */
	public Entite(int ref)
	{
		this.ref = ref;
	}
	
	/**
	 * La référence associée à l'entité.
	 * 
	 * @return la référence de l'entité.
	 */
	public int getRef()
	{
		return this.ref;
	}
	
	/**
	 * La coordonnée x de l'entité.
	 * 
	 * @return la coordonnée x de l'entité.
	 */
	public int getX()
	{
		return this.x;
	}
	
	/**
	 * La coordonnée y de l'entité.
	 * 
	 * @return la coordonnée y de l'entité.
	 */
	public int getY()
	{
		return this.y;
	}
	
	/**
	 * Le couple de coordonnées de l'entité.
	 * 
	 * @return
	 */
	public int[] getPos()
	{
		return this.pos;
	}
}
