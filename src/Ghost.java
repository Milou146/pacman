import java.util.Random;

public class Ghost extends Entite{

    /**
     * Un random permettant de rendre le chemin du fantome random
     */
    public static final Random R = new Random();

    /**
     * La prochaine position d'un fantome
     */
    public int[] nextPos;

    /**
     * Permet de caractériser l'état du fantome:
     * 0 -> normal;
     * 1 -> en fuite;
     * 2 -> mort
     */
    public int etatG;

    /**
     * Permet de caractériser la vitesse du fantome:
     * 0 -> normal;
     * 1 -> fuite (lent)
     */
    public int vitesseG;

    /**
     * Un fantome
     * 
     * @param ref la référence d'un fantome (=2)
     * @param etatG l'état d'un fantome
     * @param vitesseG la vitesse d'un fantome
     */
    public Ghost(int ref, int etatG, int vitesseG, int[] pos){
        super(ref, pos);
        this.etatG = etatG;
        this.vitesseG = vitesseG;
    }

    /**
     * Permet de bouger le fantome selon un chiffre choisit au hasard:
     * 0 -> haut;
     * 1 -> droite;
     * 2 -> bas;
     * 3 -> gauche
     */
    public void moveG(){
        int[] p = this.getPos();
        int x = p[0];
        int y = p[1];
        int r = Ghost.R.nextInt(4);
        int[][][] lay = Layout.getLayout();
        if (r == 0 && lay[2][x-1][y] != 9){
            p[0] -= 1;
            lay[2][x][y] = 0;
        }
        if (r == 1 && lay[2][x][y+1] != 9){
            p[1] += 1;
            lay[2][x][y] = 0;
        }
        if (r == 2 && lay[2][x+1][y] != 9){
            p[0] += 1;
            lay[2][x][y] = 0;
        }
        if (r == 3 && lay[2][x][y-1] != 9){
            p[1] -= 1;
            lay[0][x][y] = 0;
        this.nextPos = p;
        }
    }

    /**
     * Permet de changer la vitesse d'un fantome
     */
    public void changeV(){
        if (this.vitesseG == 0){
            this.vitesseG = 1;
        }
        if (this.vitesseG == 1){
            this.vitesseG = 0;
        }
    }

    /**
     * Permet de connaitre l'état du fantome:
     * 0 -> normal;
     * 1 -> en fuite;
     * 2 -> mort
     * 
     * @return l'état du fantome
     */
    public int getEtatG(){
        return this.etatG;
    }

    /**
     * Permet de connaitre la prochaine position du fantome
     * 
     * @return la prochaine position du fantome
     */
    public int[] getMoveG(){
        return this.nextPos;
    }
}
