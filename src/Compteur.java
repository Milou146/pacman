public class Compteur {
	/**
	 * Nombre de points gagnés au total.
	 */
	private int nbPointTot = 0;
	
	/**
	 * Nombre de PacGommes mangees sur le niveau.
	 */
	private int nbPG = 0;
	
	/**
	 * Donne le nombre total de points gagnés pendant la partie.
	 * @return un entier correspondant au nombre total de points gagnés.
	 */
	public int getNbPointTot()
	{
		return this.nbPointTot;
	}
	
	/**
	 * Donne le nombre total de pacgommes mangées dans le niveau.
	 * @return
	 */
	public int getNbPG()
	{
		return this.nbPG;
	}
}
