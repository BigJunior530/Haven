import java.util.Random;
/**
 * This class is used to make the Vulture enemy
 * @author Carlos
 *
 */
public class Vulture extends CharEntities{
      public static Random rand = new Random();
      /**
  	 * This is a constructor to make the Vulture class
  	 * 
  	 * @param pc is the user class
  	 */
      public Vulture(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack(3);
          setHealth(6);
          setDifficulty("Easy");
      }
      /**
       * This method prints out the ascii art for the Vulture
       * 
       */
      public void enemy(){
    	  System.out.println("                   .-..-.__");
          System.out.println("                 /`  |\\_( \"\\__");
          System.out.println("                 |   / __/`'--)");
          System.out.println("                 |  /  | |");
          System.out.println("                 /_/ _/_/");
          System.out.println("                 `|/))))");
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
        	  System.out.println("Vulture uses Fly");
        	  dam = 0;
        	  System.out.println("You cant't really reach it.");
        	  System.out.println("You lost some attack");
        	  System.out.println("Attack " + pc.getAttack() + "-->");
        	  pc.downgradeAttack(1);
        	  System.out.print(pc.getAttack()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Vulture uses Scavenger");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Vulture uses tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the introduction for the Vulture
       */
      public void intro() throws InterruptedException {
            Main.sleep500();
            Thread.sleep(1000);
            System.out.println("\n\nA Vulture appeared!");
            System.out.println("Level: " + getLevel());
            System.out.println("Health: " + getHealth());
      }
      /**
       * This method prints out the kill message for the Vulture
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You're able to slash the vulture's wings, never able to fly again.");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The vulture realizing you weren't dead, decided to stick to its natural prey.");
          Thread.sleep(2000);
      }
}
