import java.util.Random;
/**
 * This class is used to make the Dragon enemy
 * @author Carlos
 *
 */
public class Dragon extends CharEntities{
	public static Random rand = new Random();
	/**
	 * This is a constructor to make the Dragon class
	 * 
	 * @param pc is the user class
	 */
      public Dragon(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack(10);
          setHealth(10);
          setDifficulty("Hard");
          setName("Dragon");
      }
      /**
       * This method prints out the ascii art for the Dragon
       * 
       */
      public void enemy(){
          System.out.println("                               _ _");
          System.out.println("                        _     //` `\\");
          System.out.println("                    _,-\"\\%   // /``\\`\\");
          System.out.println("               ~^~ >__^  |% // /  } `\\`\\");
          System.out.println("                      )  )%// / }  } }`\\`\\");
          System.out.println("                     /  (%/'/.\\_/\\_/\\_/\\`/");
          System.out.println("                    (    '         `-._`");
          System.out.println("                     \\   ,     (  \\   _`-.__.-;%>");
          System.out.println("                    /_`\\ \\      `\\ \\.\" `-..-'`");
          System.out.println("                   ``` /_/`\"-=-'`/_/");
          System.out.println("                       ```       ```");
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
        	  System.out.println("Dragon uses HeatWave");
        	  dam = 0;
        	  System.out.println("Its attack increased");
        	  System.out.println("Attack " + getAttack() + "-->");
        	  upAttack(getAttack()/2);
        	  System.out.print(getAttack()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Dragon uses Volcanic Ash");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Dragon uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the kill message for the Dragon
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You chop off the Dragon's head and use it as a trophy.");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The Dragon flies away uninterested by your presence.");
          Thread.sleep(2000);
      }
}
