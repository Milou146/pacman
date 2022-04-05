public class PacGomme extends Entite{
    
    /**
     * Le type de Pac-gomme, soit son nom
     */
    public String type;

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
     */
    public int nbPoints;

    /**
     * Le nombre de Pac-gommes mangées par Pacman dans le niveau
     */
    public int nbManger;

    /**
     * Le nombre de Pac-gommes dans le niveau
     */
    public int nbNPG;

    /**
     * Permet de commaitre le nombre de points d'une Pac-gomme
     * 
     * @return le nombre de points de la Pac-gomme
     */
    public int getPointPG(){
        return this.nbPoints;
    }

    /**
     * Permet de réduire le nombre de Pac-gomme quand Pacman en mange une
     * 
     * @return le nombre de Pac-gomme moins une
     */
    public int decPG(){
        return nbNPG-1;
    }
}
