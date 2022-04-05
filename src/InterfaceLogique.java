/**
 * Interface logique pour la partie view
 * @author Ianis Zemali2
 */
public interface InterfaceLogique {
    /**
     * le nombre de vies
     * 
     * @return le nombre de vie
     */
    public int getLP();

    /**
     * le nombre de points total
     * 
     * @return le nombre de points total
     */
    public int getPoint();

    /**
     * le numéro du niveau, permettant donc de savoir
     * quels fruits on peut mettre dans le niveau
     * 
     * @return le numéro du niveau
     */
    public int getLvl();

    /**
     * le nombre de points d'une Pac-gomme, dépendant de son type:
     * normal:10 pt,
     * cerise:100 pt,
     * fraise:300 pt,
     * orange:500 pt,
     * pomme:700 pt,
     * melon:1000 pt,
     * galbosse:2000 pt,
     * cloche:3000 pt,
     * cle:5000 pt,
     * super:50 pt
     * 
     * @return le nombre de points d'une Pac-gomme
     */
    public int getPointPG();

    /**
     * le déplacement suivant de Pacman (up, down, left, right)
     * 
     * @return le déplacement suivant de Pacman
     */
    public String getMoveP();

    /**
     * le déplacement suivant d'un phantome (up, down, left, right)
     * 
     * @return le déplacement suivant d'un phantome
     */
    public String getMoveG();

    /**
     * la référence d'une entité (phantome, Pac-Man, Pac-gomme, mur)
     * 
     * @return la référence de l'entité concernée
     */
    public int getRef();

    /**
     * Permet de connaitre l'état du phantome:
     * 0:normal,
     * 1:en fuite,
     * 2:mort
     * 
     * @return l'état du phantome
     */ 
    public int getEtatGhost();

    /**
     * Permet de connaitre l'état de Pacman:
     * 0:normal,
     * 1:respawning(invincibilité sans pouvoir manger les phantomes),
     * 2:terminator
     * 
     * @return l'état de Pacman
     */
    public int getEtatPacman();
}