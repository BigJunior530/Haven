import java.util.Random;
/**
 * This class is used to make the Panther enemy
 * @author Carlos
 *
 */
public class Panther extends CharEntities{
      public static Random rand = new Random();
      /**
    	 * This is a constructor to make the Panther class
    	 * 
    	 * @param pc is the user class
    	 */
      public Panther(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack(7);
          setHealth(9);
          setDifficulty("Hard");
          setName("Panther");
      }
      /**
       * This method prints out the ascii art for the Panther
       * 
       */
      public void enemy(){
    	  System.out.println("                 (\"`-''-/\").___..--''\"`-._");
          System.out.println("                  `6_ 6  )   `-.  (     ).`-.__.`)");
          System.out.println("                  (_Y_.)'  ._   )  `._ `. ``-..-'");
          System.out.println("                _..`--'_..-_/  /--'_.' ,'");
          System.out.println("               (il),-''  (li),'  ((!.-' ");
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
        	  System.out.println("Panther prepares to pounce");
        	  dam = 0;
        	  System.out.println("It's attack increased.");
        	  System.out.println("Attack " + getAttack() + "-->");
        	  upAttack(getAttack()/2);
        	  System.out.print(getAttack()+ "\n");
          }else if(move == 1) {
          }else if(move == 1) {
        	  System.out.println("Panther uses Maul");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Panther uses Pounce");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the kill message for the Panther
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You slash the final blow against the Panther straight into its skull");
          Thread.sleep(2000);
          System.out.println("You realize this wasn't the best place.");
          Thread.sleep(2000);
          System.out.println("You leave the Jungle and wonder where to next");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The Panther decides there are better places to hide from the storm.");
          Thread.sleep(2000);
      }
}
