import java.util.Random;
/**
 * This class is used to make the Kraken enemy
 * @author Carlos
 *
 */
public class Kraken extends CharEntities{
      public static Random rand = new Random();
      /**
  	 * This is a constructor to make the Kraken class
  	 * 
  	 * @param pc is the user class
  	 */
      public Kraken(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack(5);
          setHealth(7);
          setDifficulty("Normal");
      }
      /**
       * This method prints out the ascii art for the Kraken
       * 
       */
      public void enemy(){
    	  System.out.println("                       .'-'.");
          System.out.println("                   .  (  o O)");
          System.out.println("                    \\_ `  _,   _");
          System.out.println("                 -.___'.) ( ,-'");
          System.out.println("                      '-.O.'-..-..");
          System.out.println("                  ./\\/\\/ | \\_.-._");
          System.out.println("                         ;");
          System.out.println("                      ._/");
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
        	  System.out.println("Kraken Submerges itself");
        	  dam = 0;
        	  System.out.println("It's healed some health.");
        	  System.out.println("Health " + getHealth() + "-->");
        	  upHealth(1*level);
        	  System.out.print(getHealth()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Kraken uses Tsunami");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Kraken uses Smack");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the introduction for the Kraken
       */
      public void intro() throws InterruptedException {
            Main.sleep500();
            Thread.sleep(1000);
            System.out.println("\nA Kraken appeared!");
            System.out.println("Level: " + getLevel());
            System.out.println("Health: " + getHealth());
      }
      /**
       * This method prints out the kill message for the Kraken
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You cut the last tentacle of the kraken and let it sink back into the ocean");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("Kraken lets go of your boat, inks away from you.");
          Thread.sleep(2000);
      }
}
