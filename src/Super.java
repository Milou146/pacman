public class Super extends PacGomme{

    /**
     * La durée de la super Pac-gomme
     */
    public int duree = 4;

    /**
     * Une super pac-gomme
     * 
     * @param ref
     * @param type
     * @param nbPoints
     */
    public Super(int ref, String type, int nbPoints) {
        super(ref, type, nbPoints);
    }

    /**
     * Permet d'implémenter l'invincibilité de Pacman.
     * inclus:
     * -changement de l'état des phantomes à 1:en fuite
     * -changement de l'état de Pacman à invincible(clignote)
     * -changement de la vitesse des phantomes 
     */
    public void invincibilite(){
        Ghost.etatG = 1;
        Pacman.etatP = 1;
        Ghost.changeV();
    }

}
