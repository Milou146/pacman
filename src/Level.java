public class Level implements java.io.Serializable{
	
	/**
	 * Numero du niveau actuel.
	 */
	private int numLevel = 0;
	
	/**
	 * Caract�rise la vitesse du jeu.
	 * Le facteur est augment� de 0,03.
	 */
	private double vitesse = 1;
	
	/**
	 * Nombre de PacGommes pr�sentent au d�but du niveau.
	 */
	private int nbPGLevel = -1;
	
	private Layout[] tabLayout;
	
	/**
	 * Constructeur de la classe Level.
	 * @param numLevel : le num�ro du niveau.
	 * @param vitesse : la vitesse du jeu.
	 * @param nbPGLevel : le nombre de PacGommes au d�but du niveau.
	 * @param tabLayout : l'ensemble des layouts du niveau.
	 */
	public Level(int numeroLevel, double vitesse, int nbPGLevel, Layout[] tabLayout)
	{
		this.numLevel = numeroLevel;
		this.vitesse = vitesse;
		this.nbPGLevel = nbPGLevel;
		this.tabLayout = tabLayout;
	}
	
	/**
	 * Donne le numero du niveau auquel on se trouve.
	 *
	 * @return le numero du niveau.
	 */
	public int getNumLevel()
	{
		return this.numLevel;
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
	public Layout[] getTabLayout()
	{
		return this.tabLayout;
	}
}
