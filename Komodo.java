import java.util.Random;
/**
 * This class is used to make the Komodo Dragon enemy
 * @author Carlos
 *
 */
public class Komodo extends CharEntities{
      public static Random rand = new Random();
      /**
  	 * This is a constructor to make the Komodo Dragon class
  	 * 
  	 * @param pc is the user class
  	 */
      public Komodo(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack(8);
          setHealth(7);
          setDifficulty("Hard");
      }
      /**
       * This method prints out the ascii art for the Komodo Dragon
       * 
       */
      public void enemy(){
    	  System.out.println("                                  )/_");
          System.out.println("                         _.--..---\"-,--c_");
          System.out.println("                    \\L..'           ._O__)_");
          System.out.println("            ,-.     _.+  _  \\..--( /");
          System.out.println("              `\\.-''__.-' \\ (     \\_");
          System.out.println("                `'''       `\\__   /\\");
          System.out.println("                            ')");
       }
      /**
       * This method randomly chooses a move to determine the damage to the User
       * 
       * @param pc is the user class
       * @return dam is the damage it will deal to the user
       */
      public int getMove(Protag pc){
          int move = rand.nextInt(4);
          int dam = 0;
          if(move == 0) {
        	  System.out.println("Komodo Dragon uses Sand attack");
        	  dam = 0;
        	  System.out.println("You lost some shield");
        	  System.out.println("Shield " + pc.getShield() + "-->");
        	  pc.downgradeShield(2);
        	  System.out.print(pc.getShield()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Komodo Dragon uses Acid Spit");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Komodo Dragan uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the introduction for the Komodo Dragon
       */
      public void intro() throws InterruptedException {
            Main.sleep500();
            Thread.sleep(1000);
            System.out.println("\nA Komodo Dragon appeared!");
            System.out.println("Level: " + getLevel());
            System.out.println("Health: " + getHealth());
      }
      /**
       * This method prints out the kill message for the Komodo Dragon
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You stab the Komodo Dragon until you can't tell what's the head and whats the tail is anymore.");
          Thread.sleep(2000);
          System.out.println("You realize this wasn't the best place.");
          Thread.sleep(2000);
          System.out.println("You leave the desert and wonder where to next");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The komodo dragon hoping you die of its poison, leaves to finish your corpse later.");
          Thread.sleep(2000);
      }
}
