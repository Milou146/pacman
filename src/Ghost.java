public class Ghost extends Entite{

    /**
     * Permet de caractériser l'état du phantome:
     * 0 -> normal;
     * 1 -> en fuite;
     * 2 -> mort
     */
    public int etatG;

    /**
     * Permet de caractériser la vitesse du phantome:
     * 0 -> normal;
     * 1 -> fuite (lent)
     */
    public int vitesseG;

    /**
     * Un phantome
     * 
     * @param ref la référence d'un phantome (=2)
     * @param etatG l'état d'un phantome
     * @param vitesseG la vitesse d'un phantome
     */
    public Ghost(int ref, int etatG, int vitesseG, int[] pos){
        super(ref, pos);
        this.etatG = etatG;
        this.vitesseG = vitesseG;
    }

    /**
     * Permet de bouger le phantome
     */
    public void moveG(){
        
    }

    /**
     * Permet de changer la vitesse d'un phantome
     */
    public void changeV(){
        if (this.vitesseG == 0){
            this.vitesseG = 1;
        }
        if (this.vitesseG == 1){
            this.vitesseG = 0;
        }
    }

    public int getEtatG(){
        return this.etatG;
    }

    public String getMoveG(){
        return this.;
    }
}
