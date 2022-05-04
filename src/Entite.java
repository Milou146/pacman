
public class Entite implements java.io.Serializable{
	/**
	 * La r�f�rence de l'entit�.
	 */
	public int ref = 0;
	
	/**
	 * La position selon l'axe des abscisses de l'entit�.
	 */
	public int x = 0;
	
	/**
	 * La position selon l'axe des ordonn�es de l'entit�.
	 */
	public int y = 0;
	
	/**
	 * La position selon les axes x et y de l'entit�.
	 */
	public int[] pos = {this.x,this.y};
	
	/**
	 * Une entit�, caract�ris�e par sa r�f�rence.
	 *
	 * @param ref la r�f�rence de l'entit�
	 */
	public Entite(int ref)
	{
		this.ref = ref;
	}
	
	/**
	 * La r�f�rence associ�e � l'entit�.
	 * 
	 * @return la r�f�rence de l'entit�.
	 */
	public int getRef()
	{
		return this.ref;
	}
	
	/**
	 * La coordonn�e x de l'entit�.
	 * 
	 * @return la coordonn�e x de l'entit�.
	 */
	public int getX()
	{
		return this.x;
	}
	
	/**
	 * La coordonn�e y de l'entit�.
	 * 
	 * @return la coordonn�e y de l'entit�.
	 */
	public int getY()
	{
		return this.y;
	}
	
	/**
	 * Le couple de coordonn�es de l'entit�.
	 * 
	 * @return
	 */
	public int[] getPos()
	{
		return this.pos;
	}
}
