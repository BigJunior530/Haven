import java.util.Random;
/**
 * This class is used to make the Shark enemy
 * @author Carlos
 *
 */
public class Shark extends CharEntities{
      public static Random rand = new Random();
      /**
  	 * This is a constructor to make the Shark class
  	 * 
  	 * @param pc is the user class
  	 */
      public Shark(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack(7);
          setHealth(9);
          setDifficulty("Normal");
          setName("Shark");
      }
      /**
       * This method prints out the ascii art for the Shark
       * 
       */
      public void enemy(){
    	  System.out.println("                       _________         .    .");
          System.out.println("                      (..       \\_    ,  |\\  /|");
          System.out.println("                       \\       O  \\  /|  \\ \\/ /");
          System.out.println("                        \\______    \\/ |   \\  / ");
          System.out.println("                           vvvv\\    \\ |   /  |");
          System.out.println("                           \\^^^^  ==   \\_/   |");
          System.out.println("                            `\\_   ===    \\.  |");
          System.out.println("                            / /\\_   \\ /      |");
          System.out.println("                            |/   \\_  \\|      /");
          System.out.println("                                   \\________/");
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
        	  System.out.println("Shark smells Blood");
        	  dam = 0;
        	  System.out.println("It's attack increased.");
        	  System.out.println("Attack " + getAttack() + "-->");
        	  upAttack(getAttack()/2);
        	  System.out.print(getAttack()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Shark uses its rows of Razer Sharp teeth to shred you");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Shark uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the kill message for the Shark
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You stab your sword straight through the Shark's eye to the other.");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The shark having realized you tasted horrible decides to leave.");
          Thread.sleep(2000);
      }
}
