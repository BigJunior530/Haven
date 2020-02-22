import java.util.Random;
/**
 * This class is used to make the Poseidon enemy
 * @author Carlos
 *
 */
public class Poseidon extends CharEntities{
      public static Random rand = new Random();
      /**
  	 * This is a constructor to make the Poseidon class
  	 * 
  	 * @param pc is the user class
  	 */
      public Poseidon(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack();
          setHealth();
      }
      /**
       * This method prints out the ascii art for the Poseidon
       * 
       */
      public void enemy(){
    	  System.out.println("                     |      ,sss.");
          System.out.println("                   | | |    $^,^$");
          System.out.println("                   |_|_|   _/$$$\\_");
          System.out.println("                     |   /'  ?$?  `.");
          System.out.println("                     ;,-' /\\ ,, /. |");
          System.out.println("                     '-./' ;    ;: |");
          System.out.println("                     |     |`  '|`,;");
          System.out.println("                   ~~~~~~~~~~~~~~~~~~~~");
       }
      /**
       * This method sets the level for the enemy based off the User's level
       * 
       *  @param enemy is the level of the User
       */
      public void setLevel(int enemy) {
    	  
    	  level = (rand.nextInt(4)) + enemy;
      }
      /**
       * This method sets the attack using level
       */
      public void setAttack() {
    	  
    	  attack = 5*level;
      }
      /**
       * This method sets the health using level
       */
      public void setHealth() {
    	  
    	  health = 7*level;
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
        	  System.out.println("Poseidon used Wrath");
        	  dam = 0;
        	  System.out.println("It's attack doubled.");
        	  System.out.println("Attack " + getAttack() + "-->");
        	  upAttack(getAttack());
        	  System.out.print(getAttack()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Poseidon used Tsunami");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Poseidon used surf");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the introduction for the Poseidon
       */
      public void intro() throws InterruptedException {
            Main.sleep500();
            Thread.sleep(1000);
            System.out.println("\nPoseidon appeared!");
            System.out.println("Level: " + getLevel());
            System.out.println("Health: " + getHealth());
      }
      /**
       * This method prints out the kill message for the Poseidon
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You use Poseidon's Trident to turn him into a Fish(Shish) Kebab");
          Thread.sleep(2000);
      }
}