import java.util.Random;
/**
 * This class is used to make the Duck enemy
 * @author Carlos
 *
 */
public class Duck extends CharEntities{
	public static Random rand = new Random();
	/**
	 * This is a constructor to make the Duck class
	 * 
	 * @param pc is the user class
	 */
      public Duck(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack(3);
          setHealth(3);
          setDifficulty("Easy");
          setName("Duck");
      }
      /**
       * This method prints out the ascii art for the Duck
       * 
       */
      public void enemy(){
          System.out.println("                 ,~~.");
          System.out.println("                (  6 )-_,");
          System.out.println("           (\\___ )=='-'");
          System.out.println("            \\ .   ) )");
          System.out.println("             \\ `-' /");    
          System.out.println("          ~'`~'`~'`~'`~");
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
        	  System.out.println("Duck uses Pluck");
        	  dam = 0;
        	  System.out.println("You lost some shield.");
        	  System.out.println("Shield " + pc.getShield() + "-->");
        	  pc.decreaseShieldTemp(4);
        	  System.out.print(pc.getShield()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Duck uses Water Gun");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Duck uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the kill message for the Duck
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You've never had  duck for dinner before.");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The Duck dives flies away, too bad you're not range.");
          Thread.sleep(2000);
      }
}
