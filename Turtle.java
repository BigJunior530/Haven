import java.util.Random;
/**
 * This class is used to make the Turtle enemy
 * @author Carlos
 *
 */
public class Turtle extends CharEntities{
	public static Random rand = new Random();
	/**
	 * This is a constructor to make the Turtle class
	 * 
	 * @param pc is the user class
	 */
      public Turtle(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack(4);
          setHealth(4);
          setDifficulty("Normal");
          setName("Turtle");
      }
      /**
       * This method prints out the ascii art for the Turtle
       * 
       */
      public void enemy(){
          System.out.println("            _____     ____");
          System.out.println("           /      \\  |  o |"); 
          System.out.println("          |        |/ ___\\|"); 
          System.out.println("          |_________/     ");
          System.out.println("          |_|_| |_|_|");
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
        	  System.out.println("Turtle uses Harden");
        	  dam = 0;
        	  System.out.println("Its health increases");
        	  System.out.println("Health " + getHealth() + "-->");
        	  upHealth(level);
        	  System.out.print(getHealth()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Turtle uses Crunch");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Turtle uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the kill message for the Turtle
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You crack open the turtle like a coconut, its blood just doesn't taste as good.");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The Turtle decides you were too boring of a subject and dump you out of the UFO");
          Thread.sleep(2000);
      }
}
