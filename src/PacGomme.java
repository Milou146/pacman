import java.util.Random;

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
    public static int nbPoints;

    /**
     * Le nombre de Pac-gommes mangées par Pacman dans le niveau
     */
    public int nbManger;

    /**
     * Le nombre de Pac-gommes dans le niveau
     */
    public static int nbNPG;

    /**
     * Une Pac-gomme
     * 
     * @param ref la référence de la Pac-gomme
     * @param nbPoints le nombre de points de la Pac-gomme
     */
    public PacGomme(short ref, short x, short y, int nbPoints){
        super(ref,x,y);
        PacGomme.nbPoints = nbPoints;
    }

    /**
     * Permet de commaitre le nombre de points d'une Pac-gomme
     * 
     * @return le nombre de points de la Pac-gomme
     */
    public static int getPointPG(){
        return PacGomme.nbPoints;
    }

    /**
     * Permet de réduire le nombre de Pac-gomme quand Pacman en mange une
     * 
     * @return le nombre de Pac-gomme moins une
     */
    public static int decPG(){
        return nbNPG-1;
    }

    /**
     * Un random permettant de faire spawner un fruit dans le niveau
     */
    public static final Random R = new Random();

    public static void spawnPG(){
        int r1 = PacGomme.R.nextInt(20);
        int r2 = PacGomme.R.nextInt(20);
<<<<<<< Updated upstream
        Layout[] lay = DeSerializerDonnees.getLevel().getTabLayout();
        while (lay[2][r1][r2] != 0){
=======
        int[][] lay = DeSerializerDonnees.getLevel().getTabLayout();
        while (lay[r1][r2] != 0){
>>>>>>> Stashed changes
            r1 = PacGomme.R.nextInt(20);
            r2 = PacGomme.R.nextInt(20);
        }
        int pg = 0;
        int n = Level.getNumLevel();
        if (n<10){
            pg = PacGomme.R.nextInt(1) + 2;
        }
        else if (n>10 && n<20){
            pg = PacGomme.R.nextInt(2) + 2;
        }
        else if (n>20 && n<30){
            pg = PacGomme.R.nextInt(3) + 2;
        }
        else if (n>30 && n<40){
            pg = PacGomme.R.nextInt(4) + 2;
        }
        else if (n>40 && n<50){
            pg = PacGomme.R.nextInt(5) + 2;
        }
        else if (n>50 && n<60){
            pg = PacGomme.R.nextInt(6) + 2;
        }
        else if (n>60 && n<70){
            pg = PacGomme.R.nextInt(7) + 2;
        }
        else if (n>70){
            pg = PacGomme.R.nextInt(8) + 2;
        }
        lay[r1][r2] = pg;
    }
}
