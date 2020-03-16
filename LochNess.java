import java.util.Random;
/**
 * This class is used to make the Loch Ness Monster enemy
 * @author Carlos
 *
 */
public class LochNess extends CharEntities{
	public static Random rand = new Random();
	/**
	 * This is a constructor to make the Loch Ness Monster class
	 * 
	 * @param pc is the user class
	 */
      public LochNess(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack(8);
          setHealth(10);
          setDifficulty("Hard");
          setName("Loch Ness Monster");
      }
      /**
       * This method prints out the ascii art for the Loch Ness Monster
       * 
       */
      public void enemy(){
          System.out.println("                                    _   _       _a_a");
          System.out.println("                        _   _     _{.`=`.}_    {/ ''\\_");
          System.out.println("                  _    {.`'`.}   {.'  _  '.}  {|  ._oo)");
          System.out.println("                 { \\  {/ .-. \\} {/  .' '.  \\} {/  |  ");
          System.out.println("          ~^~~^~`~^~`~^~`~^~`~^~^~`^~^~`^~^~^~^~^~^~`^~~`");
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
        	  System.out.println("Loch Ness Monster uses Enigma");
        	  dam = pc.getAttack()/2;
        	  System.out.println("You hurt yourself in confusion");
          }else if(move == 1) {
        	  System.out.println("Loch Ness Monster uses Tsunami");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Loch Ness Monster uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the kill message for the Loch Ness Monster
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You think this monster wasn't worth being a legend, leaving its corpse on a log.");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The Loch Ness Monster heads back deep into the lake, never to be seen again.");
          Thread.sleep(2000);
      }
}
