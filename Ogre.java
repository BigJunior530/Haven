import java.util.Random;
/**
 * This class is used to make the Ogre enemy
 * @author Carlos
 *
 */
public class Ogre extends CharEntities{
	public static Random rand = new Random();
	/**
	 * This is a constructor to make the Ogre class
	 * 
	 * @param pc is the user class
	 */
      public Ogre(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack(9);
          setHealth(9);
          setDifficulty("Hard");
          setName("Ogre");
      }
      /**
       * This method prints out the ascii art for the Ogre
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
        	  System.out.println("Ogre uses Mud");
        	  dam = 0; 
        	  System.out.println("It healed itself.");
        	  System.out.println("Health " + getHealth() + "-->");
        	  upHealth(level);
        	  System.out.print(getHealth()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Ogre uses Crush");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Ogre uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the kill message for the Ogre
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You kill the beast and yell \"This is my Swamp.\"");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The Ogre unafflicted by your weak attacks, walks away.");
          Thread.sleep(2000);
      }
}
