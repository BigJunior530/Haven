import java.util.Random;
/**
 * This class is used to make the Golem enemy
 * @author Carlos
 *
 */
public class Golem extends CharEntities{
	public static Random rand = new Random();
	/**
	 * This is a constructor to make the Golem class
	 * 
	 * @param pc is the user class
	 */
      public Golem(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack(4);
          setHealth(7);
          setDifficulty("Normal");
          setName("Golem");
      }
      /**
       * This method prints out the ascii art for the Golem
       * 
       */
      public void enemy(){
          System.out.println("              (o)(o)");
          System.out.println("            w\"      \"w");
          System.out.println("           W  -====-  W");
          System.out.println("            \"w      w\"");
          System.out.println("           w\"\"\"\"\"\"\"\"\"\"w");
          System.out.println("          W            W");
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
        	  System.out.println("Golem uses Clay Hardening");
        	  dam = 0;
        	  System.out.println("It healed itself.");
        	  System.out.println("Health " + getHealth() + "-->");
        	  upHealth(level);
        	  System.out.print(getHealth()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Golem uses Crush");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Golem uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the kill message for the Golem
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You destroy the golem back into bits of clay.");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The golem decides you aren't really a threat and turns back into clay.");
          Thread.sleep(2000);
      }
}
