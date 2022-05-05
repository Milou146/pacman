public class Compteur {
	/**
	 * Nombre de points gagn�s au total.
	 */
	private static int nbPointTot = 0;
	
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
		return Compteur.nbPointTot;
	}
	
	/**
	 * Donne le nombre total de pacgommes mang�es dans le niveau.
	 * @return
	 */
	public int getNbPG()
	{
		return this.nbPG;
	}

	/**
	 * Augmente le nombre de points du compteur
	 * @return 
	 */
	public static void incComp(int posP, int posPacG){
		if (posPacG == 1){
			nbPointTot += 10;
			PacGomme.decPG();
		}
		else if (posPacG != 1 && posPacG != 0){
			nbPointTot += PacGomme.getPointPG();
		}
	}
}
