import java.util.Random;
/**
 * This class is used to make the Mountain Lion enemy
 * @author Carlos
 *
 */
public class MountainLion extends CharEntities{
      public static Random rand = new Random();
      /**
    	 * This is a constructor to make the Mountain Lion class
    	 * 
    	 * @param pc is the user class
    	 */
      public MountainLion(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack();
          setHealth();
          setDifficulty();
      }
      /**
       * This method prints out the ascii art for the Mountain Lion
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
    	  
    	  level = rand.nextInt(4) + enemy;
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
    	  
    	  health = 8*level;
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
        	  System.out.println("Mountain Lion used Sharpen claw");
        	  dam = 0;
        	  System.out.println("It's attack doubled.");
        	  System.out.println("Attack " + getAttack() + "-->");
        	  upAttack(getAttack());
        	  System.out.print(getAttack()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Moutain Lion uses Mangle");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Mountain Lion uses Pounce");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the introduction for the Mountain Lion
       */
      public void intro() throws InterruptedException {
            Main.sleep500();
            Thread.sleep(1000);
            System.out.println("\n\nA Mountain Lion appeared!");
            System.out.println("Level: " + getLevel());
            System.out.println("Health: " + getHealth());
      }

      /**
       * This method prints out the kill message for the Mountain Lion
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You slash off the bottom jaw, watching the blood drain from its mouth");
          Thread.sleep(2000);
          System.out.println("You realize this wasn't the best place.");
          Thread.sleep(2000);
          System.out.println("You leave the Moutain and wonder where to next");
          Thread.sleep(2000);
      }
}
