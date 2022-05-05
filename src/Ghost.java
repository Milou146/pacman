import java.util.Random;

public class Ghost extends Entite{

    /**
     * Un random permettant de rendre le chemin du fantome random
     */
    public static final Random R = new Random();

    /**
     * La prochaine position d'un fantome
     */
    public static int[] nextPos;

    /**
     * Permet de caractériser l'état du fantome:
     * 0 -> normal;
     * 1 -> en fuite;
     * 2 -> mort
     */
    public static int etatG = 0;

    /**
     * Permet de caractériser la vitesse du fantome:
     * 0 -> normal;
     * 1 -> fuite (lent)
     */
    public static int vitesseG = 0;

    /**
     * Un fantome
     * 
     * @param ref la r�f�rence d'un fantome (=2)
     * @param etatG l'�tat d'un fantome
     * @param vitesseG la vitesse d'un fantome
     */
    public Ghost(int ref, int x, int y)
    {
        super(ref);
        this.x = x;
        this.y = y;
        this.pos[0] = x;
        this.pos[1] = y;
    }

    /**
     * Permet de bouger le fantome selon un chiffre choisit au hasard:
     * 0 -> haut;
     * 1 -> droite;
     * 2 -> bas;
     * 3 -> gauche
     * !!!!! Le mouvement des ghost n'est censé être random qu'aux intersections
     * Sinon, il continue sur son chemin comme si de rien n'était
     * checker les 4 dir
     */
    public void moveG(){
        int[] p = this.getPos();
        int x = p[0];
        int y = p[1];
        int r = Ghost.R.nextInt(4);
        int[][] lay0 = Layout.getLayout(0);
        int[][] lay1 = Layout.getLayout(1);
        if (r == 0 && lay0[y-1][x] != 1){
            p[0] -= 1;
            lay1[y][x] = 0;
        }
        else if (r == 1 && lay0[y][x+1] != 1){
            p[1] += 1;
            lay1[y][x] = 0;
        }
        else if (r == 2 && lay0[y+1][x] != 1){
            p[0] += 1;
            lay1[y][x] = 0;
        }
        else if (r == 3 && lay0[y][x-1] != 1){
            p[1] -= 1;
            lay1[y][x] = 0;
        }
        Ghost.nextPos = p;
    }

    /**
     * Permet de changer la vitesse d'un fantome
     */
    public static void changeV(){
        if (Ghost.vitesseG == 0){
            Ghost.vitesseG = 1;
        }
        else if (Ghost.vitesseG == 1){
            Ghost.vitesseG = 0;
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
        return Ghost.etatG;
    }

    /**
     * Permet de connaitre la prochaine position du fantome
     * 
     * @return la prochaine position du fantome
     */
    public static int[] getMoveG(){
        return Ghost.nextPos;
    }
    
    /**
     * Permet de connaitre la vitesse du fantome.
     * 
     * @return la vitesse du fantome.
     */
    public int getVitesseG()
    {
    	return Ghost.vitesseG;
    }
}
