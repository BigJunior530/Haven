import java.util.Random;
/**
 * This class is used to make the Owl enemy
 * @author Carlos
 *
 */
public class Owl extends CharEntities{
      public static Random rand = new Random();
      /**
    	 * This is a constructor to make the Owl class
    	 * 
    	 * @param pc is the user class
    	 */
      public Owl(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack();
          setHealth();
          setDifficulty();
      }
      /**
       * This method prints out the ascii art for the Owl
       * 
       */
      public void enemy(){
    	  System.out.println("            , _ ,");
          System.out.println("           ( o o )");
          System.out.println("          /'` ' `'\\");
          System.out.println("          |'''''''|");
          System.out.println("          |\\\\'''//|");
          System.out.println("             \"\"\"");
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
    	  
    	  health = 4*level;
      }
      /**
       * This method sets the difficulty of the animal to easy
       */
      public void setDifficulty() {
    	  difficulty = "Easy";
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
        	  System.out.println("Owl spun its head");
        	  dam = pc.getAttack()/2;
        	  System.out.println("You got confused and tried to twist your own head.");
          }else if(move == 1) {
        	  System.out.println("Owl used its Talons");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Owl uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the introduction for the Owl
       */
      public void intro() throws InterruptedException {
            Main.sleep500();
            Thread.sleep(1000);
            System.out.println("\nAn Artic Owl appeared!");
            System.out.println("Level: " + getLevel());
            System.out.println("Health: " + getHealth());
      }
      /**
       * This method prints out the kill message for the Owl
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You decapitated the Owl after it turned its head again");
          Thread.sleep(2000);
      }
}
