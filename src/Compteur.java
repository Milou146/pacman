public class Compteur {
	/**
	 * Nombre de points gagn�s au total.
	 */
	private int nbPointTot = 0;
	
	/**
	 * Nombre de PacGommes mangees sur le niveau.
	 */
	private int nbPG = 0;
	
	/**
	 * Donne le nombre total de points gagn�s pendant la partie.
	 * @return un entier correspondant au nombre total de points gagn�s.
	 */
	public int getNbPointTot()
	{
		return this.nbPointTot;
	}
	
	/**
	 * Donne le nombre total de pacgommes mang�es dans le niveau.
	 * @return
	 */
	public int getNbPG()
	{
		return this.nbPG;
	}
}
