import java.io.IOException;
import java.util.Random;

public class Ghost extends Entite{

    /**
     * Un random permettant de rendre le chemin du fantome random
     */
    public static final Random R = new Random();

    /**
     * La prochaine position d'un fantome
     */
    public byte[] nextPos;

    /**
     * La dernière position d'un fantome
     */
    public byte[] lastPos;

    /**
     * Permet de caractériser l'état du fantome:
     * 0 -> normal;
     * 1 -> en fuite;
     * 2 -> mort
     */
    public static byte etatG = 0;

    /**
     * Permet de caractériser la vitesse du fantome:
     * 0 -> normal;
     * 1 -> fuite (lent)
     */
    public static byte vitesseG = 0;

    /**
     * Un fantome
     * 
     * @param ref la r�f�rence d'un fantome (=2)
     * @param etatG l'�tat d'un fantome
     * @param vitesseG la vitesse d'un fantome
     * @throws IOException
     */
    public Ghost(short ref, byte x, byte y) throws IOException
    {
        super(ref,x,y);
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
    public void move(){
        // clear the case
        App.graphics.clearRect(x*40+1, y*40+1, 39,39);
        if(App.pacgommes[y][x] == 1){
            App.graphics.drawOval(x*40+10, y*40+10, 20,20);
        }

        int[][] lay0 = (DeSerializerDonnees.getLevel().getTabLayout())[0];
        int[][] lay1 = (DeSerializerDonnees.getLevel().getTabLayout())[1];
        int s = nbChemins(lay0, x, y)-1;
        int dx;
        int dy;
        dx = (int)(Math.random()* (double)2) - 1;
        dy = (int)(Math.random()* (double)2) - 1;
        lastPos = getPos();
        int a = 0;// Est utilisé pour checker si le fantome a bien bougé
        if (s == 1){//Permet au fantome de continuer sur sa route si il est sur une ligne droite ou brisée
            if (dx != 0){
                if (lay0[y][x+dx] != 1){
                    x += dx;
                }
                else if (lay0[y+dy][x] != 1){
                    y += dy;
                }
                else if (lay0[y-dy][x] != 1){
                    y -= dy;
                }
            }
            else {
                if (lay0[y+dy][x] != 1){
                    y += dy;
                }
                else if (lay0[y][x+dx] != 1){
                    x += dx;
                }
                else if (lay0[y][x+dx] != 1){
                    x -= dx;
                }
            }
        }
        else if (s == 3){//Permet au fantome de continuer son mouvement si il arrive à une intersection de 3 ou 4 chemins
            int r = Ghost.R.nextInt(s);
            while (a == 0){
                if (dx != 0){
                    if (r == 0 && lay0[y][x+dx] != 1){
                        x += dx;
                        a = 1;
                    }
                    else if (r == 1 && lay0[y+dy][x] != 1){
                        y += dy;
                        a = 1;
                    }
                    else if (r == 2 && lay0[y-dy][x] != 1){
                        y -= dy;
                        a = 1;
                    }
                }
                else {
                    if (r == 0 && lay0[y+dy][x] != 1){
                        y += dy;
                        a = 1;
                    }
                    else if (r == 1 && lay0[y][x+dx] != 1){
                        x += dx;
                        a = 1;
                    }
                    else if (r == 2 && lay0[y][x+dx] != 1){
                        x -= dx;
                        a = 1;
                    }
                }  
            }
        }
        lay1[y][x] = 0;
        draw();
    }

    public int nbChemins(int[][] lay, byte x, byte y){
        int s = 0;
        if (lay[y-1][x] == 0){
            s += 1;
        }
        if (lay[y+1][x] == 0){
            s += 1;
        }
        if (lay[y][x-1] == 0){
            s += 1;
        }
        if (lay[y][x+1] == 0){
            s += 1;
        }
        return s;
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
        return etatG;
    }

    /**
     * Permet de connaitre la prochaine position du fantome
     * 
     * @return la prochaine position du fantome
     */
    public byte[] getMoveG(){
        return nextPos;
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
