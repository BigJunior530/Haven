import java.util.Random;
/**
 * This class is used to make the Leviathan enemy
 * @author Carlos
 *
 */
public class Leviathan extends CharEntities{
      public static Random rand = new Random();
      /**
    	 * This is a constructor to make the Leviathan class
    	 * 
    	 * @param pc is the user class
    	 */
      public Leviathan(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack();
          setHealth();
          setDifficulty();
      }
      /**
       * This method prints out the ascii art for the Leviathan
       * 
       */
      public void enemy(){
    	  System.out.println("                                   ____");
          System.out.println("          ________________________/ O  \\___/");
          System.out.println("         <_/_\\_/_\\_/_\\_/_\\_/_\\_/_______/   \\");
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
    	  
    	  attack = 10*level;
      }
      /**
       * This method sets the health using level
       */
      public void setHealth() {
    	  
    	  health = 12*level;
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
        	  System.out.println("Leviathan uses glare");
        	  dam = 0;
        	  System.out.println("You lost some shield");
        	  System.out.println("Shield " + pc.getShield() + "-->");
        	  pc.downgradeShield(3);
        	  System.out.print(pc.getShield()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Leviathan uses crunch");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Leviathan uses tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the introduction for the Leviathan
       */
      public void intro() throws InterruptedException {
            Main.sleep500();
            Thread.sleep(1000);
            System.out.println("\n\nA Leviathan appeared!");
            System.out.println("Level: " + getLevel());
            System.out.println("Health: " + getHealth());
      }
      /**
       * This method prints out the kill message for the Leviathan
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You split the Leviathan straight down the middle.");
          Thread.sleep(2000);
          System.out.println("You realize this wasn't the best place.");
          Thread.sleep(2000);
          System.out.println("You leave the Lost City and wonder where to next");
          Thread.sleep(2000);
      }
}
