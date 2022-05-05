import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeSerializerDonnees {
	  /**
	   * Le niveau actuel.
	   */
	  private static Level currentLevel;
	
	  /**
	   * L'ensemble des ghosts du niveau.
	   */
	  private static Ghost[] ghosts;
	
	  /**
	   * Le Pacman.
	   */
	  private static Pacman lePacman;
	
	  /**
	   * La table des point gagnï¿½s en fonction du type de chaque Pac-Gomme.
	   * Le nombre de points d'une Pac-gomme, dï¿½pendant de son type:
	   * 1)  normal:10 pts
	   * 2)  cerise:100 pts
	   * 3)  fraise:300 pts
	   * 4)  orange:500 pts
	   * 5)  pomme:700 pts
	   * 6)  melon:1000 pts
	   * 7)  galbosse:2000 pts
	   * 8)  cloche:3000 pts
	   * 9)  cle:5000 pts
	   * 10) super:50 pts
	   */
	  public static int[] tabPointsPG;
	
	  public static void main(final String argv[]) {
	    ObjectInputStream ois = null;
	    try {
	      final FileInputStream fichier = new FileInputStream("level20.ser");
	      ois = new ObjectInputStream(fichier);
	      
	      final Level level = (Level) ois.readObject();
	      final Ghost[] tabGhosts = (Ghost[]) ois.readObject();
	      final Pacman pacman = (Pacman) ois.readObject();
	      final int[] tableauNbPoints = (int[]) ois.readObject();
	      
	      //Quelques informations sur le niveau qui a ï¿½tï¿½ chargï¿½.
	      System.out.println("Numï¿½ro du level : " + Level.getNumLevel());
	      System.out.println("Nombre de PacGommes dans le niveau : " + level.getNbPGLevel());
	      System.out.println("Vitesse du niveau : " + level.getVitesse());
	      System.out.println("PacmanPos : (" + pacman.getX() + "," + pacman.getY() + ")");
	      
	      currentLevel = level;
	      ghosts = tabGhosts;
	      lePacman = pacman;
	      tabPointsPG = tableauNbPoints;
	  
<<<<<<< Updated upstream
	  public static void getFichier(String numero)
	  {
		    ObjectInputStream ois = null;
		    try {
		      final FileInputStream fichier = new FileInputStream("level"+ numero +".ser"); //On récupère le fichier du quel on va extraire les données.
		      ois = new ObjectInputStream(fichier); 
		      //On récupère les données de chaque classe présente dans le fichier.
		      final Level level = (Level) ois.readObject(); 
		      final Ghost[] tabGhosts = (Ghost[]) ois.readObject();
		      final Pacman pacman = (Pacman) ois.readObject();
		      final int[] tableauNbPoints = (int[]) ois.readObject();
		      
		      //Quelques informations sur le niveau qui a été chargé.
		      System.out.println("Numï¿½ro du level : " + level.getNumLevel());
		      System.out.println("Nombre de PacGommes dans le niveau : " + level.getNbPGLevel());
		      System.out.println("Vitesse du niveau : " + level.getVitesse());
		      System.out.println("PacmanPos : (" + pacman.getX() + "," + pacman.getY() + ")");
		      //On modifie les valeurs du DeSerializerDonnees pour qu'elles puissent ensuite être exploitables. 
		      currentLevel = level;
		      ghosts = tabGhosts;
		      lePacman = pacman;
		      tabPointsPG = tableauNbPoints;
		  
		    } catch (final java.io.IOException e) {
		      e.printStackTrace();
		    } catch (final ClassNotFoundException e) {
		      e.printStackTrace();
		    } finally {
		      try {
		        if (ois != null) {
		          ois.close();
		        }
		      } catch (final IOException ex) {
		        ex.printStackTrace();
		      }
		    }
=======
	    } catch (final java.io.IOException e) {
	      e.printStackTrace();
	    } catch (final ClassNotFoundException e) {
	      e.printStackTrace();
	    } finally {
	      try {
	        if (ois != null) {
	          ois.close();
	        }
	      } catch (final IOException ex) {
	        ex.printStackTrace();
	      }
	    }

>>>>>>> Stashed changes
	  }
	  
	  /**
	   * Donne le niveau actuel.
	   * 
	   * @return le Level actuel, comportant la vitesse et le plateau.
	   */
	  public static Level getLevel()
	  {
		  return currentLevel;
	  }
	  
	  /**
	   * Donne l'ensemble des ghosts prï¿½sents dans le niveau avec leur placement initial.
	   * 
	   * @return le tableau des ghosts du niveau.
	   */
	  public static Ghost[] getGhosts()
	  {
		  return ghosts;
	  }
	  
	  /**
	   * Donne le Pacman avec son placement initial.
	   * 
	   * @return le Pacman.
	   */
	  public static Pacman getPacman()
	  {
		  return lePacman;
	  }
	  
	  /**
	   * Donne le tableau des points de chaque type de Pac-Gommes.
	   * 
	   * @return le tableau des points de chaque type de Pac-Gommes.
	   * 
	   */
	  public static int[] getPointsPG()
	  {
		  return tabPointsPG;
	  }

	}

