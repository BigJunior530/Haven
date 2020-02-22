import java.util.Random;
/**
 * This class is used to make the Rattle Snake enemy
 * @author Carlos
 *
 */
public class RattleSnake extends CharEntities{
      public static Random rand = new Random();
      /**
  	 * This is a constructor to make the Rattle Snake class
  	 * 
  	 * @param pc is the user class
  	 */
      public RattleSnake(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack();
          setHealth();
      }
      /**
       * This method prints out the ascii art for the Rattle Snake
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
    	  
    	  attack = 8*level;
      }
      /**
       * This method sets the health using level
       */
      public void setHealth() {
    	  
    	  health = 5*level;
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
        	  System.out.println("Snake uses its poison");
        	  dam = 0;
        	  System.out.println("You lost some shield");
        	  System.out.println("Shield " + pc.getShield() + "-->");
        	  pc.downgradeShield(2);
        	  System.out.print(pc.getShield()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Snake uses Constriction");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Snake uses Strike");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the introduction for the Rattle Snake
       */
      public void intro() throws InterruptedException {
            Main.sleep500();
            Thread.sleep(1000);
            System.out.println("\n\nA Rattle Snake appeared!");
            System.out.println("Level: " + getLevel());
            System.out.println("Health: " + getHealth());
      }
      /**
       * This method prints out the kill message for the Rattle Snake
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You cut the snakes head off and watch its body squirm.");
          Thread.sleep(2000);

      }
}
