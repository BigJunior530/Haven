import java.util.Random;
/**
 * This class is used to make the Mermaid enemy
 * @author Carlos
 *
 */
public class Mermaid extends CharEntities{
      public static Random rand = new Random();
      /**
    	 * This is a constructor to make the Mermaid class
    	 * 
    	 * @param pc is the user class
    	 */
      public Mermaid(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack(3);
          setHealth(5);
          setDifficulty("Easy");
          setName("Mermaid");
      }
      /**
       * This method prints out the ascii art for the Mermaid
       * 
       */
      public void enemy(){
    	  System.out.println("                                               .-\"\"-.");
          System.out.println("                                              (___/\\ \\");
          System.out.println("                           ,                 (|^ ^ ) )");
          System.out.println("                          /(                _)_\\=_/  (");
          System.out.println("                    ,..__/ `\\          ____(_/_ ` \\   )");
          System.out.println("                     `\\    _/        _/---._/(_)_  `\\ (");
          System.out.println("                       '--\\ `-.__..-'    /.    (_), |  )");
          System.out.println("                           `._        ___\\_____.'_| |__/");
          System.out.println("                              `~----\"`   `-.........'");
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
        	  System.out.println("Mermaid uses Song");
        	  dam = pc.getAttack()/2;
        	  System.out.println("You're body slowing started walking by itself towads the Mermaid. You stabbed youself to Stop.");
          }else if(move == 1) {
        	  System.out.println("Mermaid uses drown");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Mermaid uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the kill message for the Mermaid
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You split the mermaid cleanly in half, seperating the human from fish");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The Mermaid, now looking at you more closely, realizes it wants nothing to do with you and swims away.");
          Thread.sleep(2000);
      }
}
