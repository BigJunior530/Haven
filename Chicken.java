import java.util.Random;
/**
 * This class is used to make the Chicken enemy
 * @author Carlos
 *
 */
public class Chicken extends CharEntities{
	public static Random rand = new Random();
	/**
	 * This is a constructor to make the Chicken class
	 * 
	 * @param pc is the user class
	 */
      public Chicken(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack(2);
          setHealth(2);
          setDifficulty("Easy");
          setName("Chicken");
      }
      /**
       * This method prints out the ascii art for the Chicken
       * 
       */
      public void enemy(){
          System.out.println("             \\\\");
          System.out.println("             (o>");
          System.out.println("          \\\\_//)");
          System.out.println("           \\_/_)");
          System.out.println("            _|_ "); 
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
        	  System.out.println("Chicken uses Pluck");
        	  dam = 0;
        	  System.out.println("You lost some shield.");
        	  System.out.println("Shield " + pc.getShield() + "-->");
        	  pc.decreaseShieldTemp(4);
        	  System.out.print(pc.getShield()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Chicken uses Peck");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Chicken uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the kill message for the Chicken
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You absolutely love chicken for any meal.");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The Chicken scurries away, unable to catch it, you let it go.");
          Thread.sleep(2000);
      }
}
