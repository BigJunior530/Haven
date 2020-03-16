import java.util.Random;
/**
 * This class is used to make the Mummy enemy
 * @author Carlos
 *
 */
public class Mummy extends CharEntities{
	public static Random rand = new Random();
	/**
	 * This is a constructor to make the Mummy class
	 * 
	 * @param pc is the user class
	 */
      public Mummy(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack(4);
          setHealth(3);
          setDifficulty("Easy");
          setName("Mummy");
      }
      /**
       * This method prints out the ascii art for the Mummy
       * 
       */
      public void enemy(){
          System.out.println("                    .--.");
          System.out.println("                   | = o\\");
          System.out.println("                   \\= =_/");
          System.out.println("                    )= \\____");
          System.out.println("                   ; = _|__-\\");
          System.out.println("                   |= ----.\\");
          System.out.println("                   ('.==|");
          System.out.println("                   / \\=\\=\\");
          System.out.println("                _.'  /=/\\=\\_");
          System.out.println("          __..-'    /__) \\__)");
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
        	  System.out.println("Mummy uses Rebandage");
        	  dam = 0;
        	  System.out.println("It healed itself");
        	  System.out.println("Health " + getHealth() + "-->");
        	  upHealth(level);
        	  System.out.print(getHealth()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Mummy uses Pharoah's Demise");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Mummy uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the kill message for the Mummy
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You finally finish killing it off, leaving only blood soaked paper.");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The Mummy decides to lay back down and doesn't wake back up.");
          Thread.sleep(2000);
      }
}
