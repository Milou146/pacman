public class LPcomp {
	
	/**
	 * Nombre de Points de Vie (Life Points) du Pacman.
	 */
	private static int LP = 3;
	
	/**
	 * Donne le nombre de Points de Vie du Pacman
	 * 
	 * @return le nombre de Points de Vie du Pacman.
	 */
	public int getLP()
	{
		return LPcomp.LP;
	}

	/**
	 * Permer de diminuer le nb de LP Pacman si il ya a collision avec un fantôme
	 * @param pos
	 */
	public static void death(int[] posP, int[] posG){
		if (Pacman.etatP == 0 && Ghost.etatG == 0 && posP == posG){
			LP -= 1;
			Pacman.etatP = 1;
		}
	}
	
}
