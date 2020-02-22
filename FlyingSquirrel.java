import java.util.Random;
/**
 * This class is used to make the Flying Squirrel enemy
 * @author Carlos
 *
 */
public class FlyingSquirrel extends CharEntities{
      public static Random rand = new Random();
      /**
  	 * This is a constructor to make the Flying Squirrel class
  	 * 
  	 * @param pc is the user class
  	 */
      public FlyingSquirrel(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack();
          setHealth();
      }
      /**
       * This method prints out the ascii art for the Flying Squirrel
       * 
       */
      public void enemy(){
    	  System.out.println("              (\\__/)  .~    ~. ))");
          System.out.println("              /O O `./      .'");
          System.out.println("             {O__,   \\    {");
          System.out.println("              / .  . )    \\");
          System.out.println("              |-| '-' \\    } ))");
          System.out.println("             .(   _(   )_.'");
          System.out.println("            '---.~_ _ _&");
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
    	  
    	  attack = 2*level;
      }
      /**
       * This method sets the health using level
       */
      public void setHealth() {
    	  
    	  health = 4*level;
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
        	  System.out.println("Squirell uses Fluffy Tail");
        	  dam = 0;
        	  System.out.println("You kind of don't want to hurt it now.");
        	  System.out.println("You lost some attack");
        	  System.out.println("Attack " + pc.getAttack() + "-->");
        	  pc.downgradeAttack(1);
        	  System.out.print(pc.getAttack()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Squirrel uses Pierce");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Squirrel uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the introduction for the Flying Squirrel
       */
    public void intro() throws InterruptedException {
          Main.sleep500();
          Thread.sleep(1000);
          System.out.println("\nA Flying Squirrel appeared!");
          System.out.println("Level: " + getLevel());
          System.out.println("Health: " + getHealth());
    }
    /**
     * This method prints out the kill message for the Flying Squirrel
     */
    public void endMessage() throws InterruptedException{
  	  System.out.println("You rip off the extra skin making it into just a normal squirrel.");
        Thread.sleep(2000);
        
    }
}