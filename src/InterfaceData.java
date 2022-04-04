/**
 * Interface  Data pour la partie Logique.
 * @author Grégoire TISSOT
 *
 */
public interface InterfaceData {
    /**
     * Donne le niveau dans lequel on se trouve.
     * 
     * @return le niveau.
     */
    public int getNiveau();
    
    /**
     * Donne le layout de tout le niveau.
     * 
     * @return le layout du niveau.
     */
    public int[][] getLayout();
    
    /**
     * Donne la vitesse du jeu.
     *
     *@return la vitesse (1,2 ou 3).
     */
    public int getVitesse();
    
    /**
     * Donne la référence de l'entité.
     * 
     * @return la référence de l'entité.
     */
    public int getRef();
    
    /**
     * Donne l'état du Pacman.
     * 
     * @return l'état du Pacman.
     */
    public int getEtatPacman();
    
    /**
     * Donne l'état du ghost (3 états différents : normal, fuite ou mort).
     * 
     * @return l'état du ghost.
     */
    public int getEtatGhost();
    
    /**
     * Donne les LP (Life Points) du Pacman.
     * 
     * @return les LP du Pacman.
     */
    public int getLP();
    
    /**
     * Donne le nombre de points associés au fruit.
     * 
     * @return le nombre de points associés au fruit.
     */
    public int getPointFruit();
}