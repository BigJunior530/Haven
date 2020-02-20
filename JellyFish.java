import java.util.Random;
/**
 * This class is used to make the JellyFish enemy
 * @author Carlos
 *
 */
public class JellyFish extends CharEntities{

      public static Random rand = new Random();
      /**
  	 * This is a constructor to make the JellyFish class
  	 * 
  	 * @param pc is the user class
  	 */
      public JellyFish(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack();
          setHealth();
      }
      /**
       * This method prints out the ascii art for the JellyFish
       * 
       */
      public void enemy(){
    	  System.out.println("                     .-;':':'-.");
          System.out.println("                    {'.'.'.'.'.}");
          System.out.println("                     )        '`.");
          System.out.println("                    '-. ._ ,_.-='");
          System.out.println("                      `). ( `);(");
          System.out.println("                      ('. .)(,'.)");
          System.out.println("                       ) ( ,').(");
          System.out.println("                      ( .').'(').");
          System.out.println("                      .) (' ).('");
          System.out.println("                       '  ) (  ).");
          System.out.println("                        .'( .)'");
          System.out.println("                          .).'");
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
        	  System.out.println("JellyFish uses Paralyze");
        	  dam = 0;
        	  System.out.println("You lost some shield");
        	  System.out.println("Shield " + pc.getShield() + "-->");
        	  pc.downgradeShield(2);
        	  System.out.print(pc.getShield()+ "\n");
          }else if(move == 1) {
        	  System.out.println("JellyFish uses Poison Sting");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("JellyFish uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the introduction for the JellyFish
       */
      public void intro() throws InterruptedException {
            Main.sleep500();
            Thread.sleep(1000);
            System.out.println("\nA JellyFish appeared!");
            System.out.println("Level: " + getLevel());
            System.out.println("Health: " + getHealth());
      }
      /**
       * This method prints out the kill message for the JellyFish
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You slice the JellyFish up into bits and make your own 'Jelly'");
          Thread.sleep(2000);
      }
}
