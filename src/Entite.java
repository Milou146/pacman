public class Entite {
    
    /**
     * La référence de l'entité:
     * 1-> Pacman
     * 2-> Ghost
     * 3-> Point
     * 4x-> Pac-gomme
     * p-> mur
     */
    public int ref;

    /**
     * Une entité, caractérisée par sa référence
     * 
     * @param ref la référence de l'entité
     */
    public Entite(int ref) {
        this.ref = ref;
    }

    /**
     * La référence assoviée à une entité
     * 
     * @return la référence
     */
    public int getRef(){
        return this.ref;
    }
}
