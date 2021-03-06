public class Layout implements java.io.Serializable{
	
	private static int[][] layout;
	
	/**
	 * Les layouts ont une r�f�rence similaire aux entit�s :
	 * 0 - Layout Pacman & Murs
	 * 1 - Layout Ghosts
	 * 2 - Layout Pacgommes
	 */
	private int reflay;
	
	/**
	 * Constructeur de la classe Layout.
	 * @param layout
	 * @param reflay
	 */
	public Layout(int[][] layout, int reflay)
	{
		Layout.layout = layout;
		this.reflay = reflay;
	}

	public static int[][] getLayout(int reflay)
	{
		return layout;
	}
	
	/**
	 * Donne un layer. Il s'agit d'un etage d'un layout.
	 * Les etages sont définis comme suit :
	 * 0 - Layer Pacman & Murs
	 * 1 - Layer Ghosts
	 * 2 - Layer Pacgommes
	 * Leur numero est leur reference. Il correspond au dernier parametre d'un layout.
	 *
	 * @param ref
	 * @return
	 */
	
	public int getreflay()
	{
		return this.reflay;
	}
}
