import java.util.Random;
/**
 * This class is used to make the Scorpion enemy
 * @author Carlos
 *
 */
public class Scorpion extends CharEntities{
      public static Random rand = new Random();
      /**
  	 * This is a constructor to make the Scorpion class
  	 * 
  	 * @param pc is the user class
  	 */
      public Scorpion(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack();
          setHealth();
      }
      /**
       * This method prints out the ascii art for the Scorpion
       * 
       */
      public void enemy(){
    	  System.out.println("            _    _");
          System.out.println("           /_]  [_\\");
          System.out.println("          //      \\\\");
          System.out.println("          \\\\      //");
          System.out.println("           \\`-..-'/");
          System.out.println("            `\\  /`");
          System.out.println("              ||    _");
          System.out.println("              ||   ( )");
          System.out.println("              \\\\___/");
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
    	  
    	  attack = 6*level;
      }
      /**
       * This method sets the health using level
       */
      public void setHealth() {
    	  
    	  health = 3*level;
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
        	  System.out.println("Scorpion uses Posion Sting");
        	  dam = pc.getAttack()/2;
        	  System.out.println("You cut off the area to stop the Poison from spreading");
          }else if(move == 1) {
        	  System.out.println("Scorpion uses Pinch");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Scorpion uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the introduction for the Scorpion
       */
      public void intro() throws InterruptedException {
            Main.sleep500();
            Thread.sleep(1000);
            System.out.println("\nA Scorpion appeared!");
            System.out.println("Level: " + getLevel());
            System.out.println("Health: " + getHealth());
      }
      /**
       * This method prints out the kill message for the Scorpion
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You cut off the stringer and the claws leaving the Scorpion to a pathetic existence.");
          Thread.sleep(2000);
      }
}