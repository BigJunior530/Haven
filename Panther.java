import java.util.Random;
/**
 * This class is used to make the Panther enemy
 * @author Carlos
 *
 */
public class Panther extends CharEntities{
      public static Random rand = new Random();
      /**
    	 * This is a constructor to make the Panther class
    	 * 
    	 * @param pc is the user class
    	 */
      public Panther(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack();
          setHealth();
          setDifficulty();
      }
      /**
       * This method prints out the ascii art for the Panther
       * 
       */
      public void enemy(){
    	  System.out.println("                 (\"`-''-/\").___..--''\"`-._");
          System.out.println("                  `6_ 6  )   `-.  (     ).`-.__.`)");
          System.out.println("                  (_Y_.)'  ._   )  `._ `. ``-..-'");
          System.out.println("                _..`--'_..-_/  /--'_.' ,'");
          System.out.println("               (il),-''  (li),'  ((!.-' ");
       }
      /**
       * This method sets the level for the enemy based off the User's level
       * 
       *  @param enemy is the level of the User
       */
      public void setLevel(int enemy) {
    	  
    	  level = rand.nextInt(4) +enemy;
      }
      /**
       * This method sets the attack using level
       */
      public void setAttack() {
    	  
    	  attack = 7*level;
      }
      /**
       * This method sets the health using level
       */
      public void setHealth() {
    	  
    	  health = 9*level;
      }
      /**
       * This method sets the difficulty of the animal to Hard
       */
      public void setDifficulty() {
    	  difficulty = "Hard";
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
        	  System.out.println("Panther prepares to pounce");
        	  dam = 0;
        	  System.out.println("It's attack doubled.");
        	  System.out.println("Attack " + getAttack() + "-->");
        	  upAttack(getAttack());
        	  System.out.print(getAttack()+ "\n");
          }else if(move == 1) {
          }else if(move == 1) {
        	  System.out.println("Panther uses Maul");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Panther uses Pounce");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the introduction for the Panther
       */
      public void intro() throws InterruptedException {
            Main.sleep500();
            Thread.sleep(1000);
            System.out.println("\n\nA Panther appeared!");
            System.out.println("Level: " + getLevel());
            System.out.println("Health: " + getHealth());
      }
      /**
       * This method prints out the kill message for the Panther
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You slash the final blow against the Panther straight into its skull");
          Thread.sleep(2000);
          System.out.println("You realize this wasn't the best place.");
          Thread.sleep(2000);
          System.out.println("You leave the Jungle and wonder where to next");
          Thread.sleep(2000);
      }
}
