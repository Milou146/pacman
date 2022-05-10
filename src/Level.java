public class Level implements java.io.Serializable{
	
	/**
	 * Numero du niveau actuel.
	 */
	private static int numLevel = 0;
	
	/**
	 * Caract�rise la vitesse du jeu.
	 * Le facteur est augment� de 0,03.
	 */
	private double vitesse = 1;
	
	/**
	 * Nombre de PacGommes pr�sentent au d�but du niveau.
	 */
	private int nbPGLevel = -1;
	
<<<<<<< Updated upstream
	private int[][][] tabLayout;
=======
	private int[][] tabLayout;
>>>>>>> Stashed changes
	
	/**
	 * Constructeur de la classe Level.
	 * @param numLevel : le num�ro du niveau.
	 * @param vitesse : la vitesse du jeu.
	 * @param nbPGLevel : le nombre de PacGommes au d�but du niveau.
	 * @param tabLayout : l'ensemble des layouts du niveau.
	 */
<<<<<<< Updated upstream
	public Level(int numeroLevel, double vitesse, int nbPGLevel, int[][][] tabLayout)
=======
	public Level(int numeroLevel, double vitesse, int nbPGLevel, int[][] tabLayout)
>>>>>>> Stashed changes
	{
		Level.numLevel = numeroLevel;
		this.vitesse = vitesse;
		this.nbPGLevel = nbPGLevel;
		this.tabLayout = tabLayout;
	}
	
	/**
	 * Donne le numero du niveau auquel on se trouve.
	 *
	 * @return le numero du niveau.
	 */
	public static int getNumLevel()
	{
		return Level.numLevel;
	}
	
	/**
	 * Donne la vitesse actuelle du jeu.
	 * 
	 * @return la vitesse du jeu.
	 */
	public double getVitesse()
	{
		return this.vitesse;
	}
	
	/**
	 * Donne le nombre de PacGommes pr�sentent au d�but du niveau.
	 * 
	 * @return le nombre de PacGommes pr�sentent au d�but du niveau.
	 */
	public int getNbPGLevel()
	{
		return this.nbPGLevel;
	}
	
	/**
	 * Donne sous forme de tableau l'ensemble des layouts du niveau.
	 * 
	 * @return sous forme de tableau l'ensemble des layouts du niveau.
	 */
<<<<<<< Updated upstream
	public int[][][] getTabLayout()
=======
	public int[][] getTabLayout()
>>>>>>> Stashed changes
	{
		return this.tabLayout;
	}
}
