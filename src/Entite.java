public class Entite {
    
    /**
     * La référence de l'entité:
     * 1-> Pacman
     * 2-> Ghost
     * 3-> Point
     * 4x-> Pac-gomme
     * 5-> Super Pac-gomme
     * 9-> mur
     */
    public int ref;

    /**
     * La position de l'entité dans un tableau à 2 dimensions
     */
    protected int[] pos;

    /**
     * Une entité, caractérisée par sa référence
     * 
     * @param ref la référence de l'entité
     */
    public Entite(int ref) {
        this.ref = ref;
    }

    /**
     * La référence associée à une entité
     * 
     * @return la référence
     */
    public int getRef(){
        return this.ref;
    }

    /**
     * Permet de récupérer la position de l'entité
     * 
     * @return la position de l'entité
     */
    public int[] getPos(){
        return this.pos;
    }
}
