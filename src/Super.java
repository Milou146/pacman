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
    public Super(short ref, short x, short y, int nbPoints) {
        super(ref,x,y, nbPoints);
    }

    /**
     * Permet d'implémenter l'invincibilité de Pacman.
     * inclus:
     * -changement de l'état des phantomes à 1: en fuite;
     * -changement de l'état de Pacman à 1: invincible(clignote);
     * -changement de la vitesse des phantomes (lent)
     */
    public void invincibilite(){
        Ghost.etatG = 1;
        Pacman.etatP = 1;
        Ghost.changeV();
    }

}
