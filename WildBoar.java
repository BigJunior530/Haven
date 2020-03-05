import java.util.Random;
/**
 * This class is used to make the Wild Boar enemy
 * @author Carlos
 *
 */
public class WildBoar extends CharEntities{
      public static Random rand = new Random();
      /**
    	 * This is a constructor to make the Wild Boar class
    	 * 
    	 * @param pc is the user class
    	 */
      public WildBoar(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack(3);
          setHealth(6);
          setDifficulty("Normal");
      }
      /**
       * This method prints out the ascii art for the Wild Boar
       * 
       */
      public void enemy(){
    	  System.out.println("                     __   __");
          System.out.println("                     \\/---\\/");
          System.out.println("                      ). .(");
          System.out.println("                     ( (\") )");
          System.out.println("                      )   (");
          System.out.println("                     /     \\ ");
          System.out.println("                    (       )`9");
          System.out.println("                   ( \\ /-\\ / )");
          System.out.println("                    w'W   W'w");
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
        	  System.out.println("Boar rolls in mud");
        	  dam = 0;
        	  System.out.println("It's healed some health.");
        	  System.out.println("Health " + getHealth() + "-->");
        	  upHealth(1*level);
        	  System.out.print(getHealth()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Boar uses Body Slam");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Boar uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the introduction for the Wild Boar
       */
      public void intro() throws InterruptedException {
            Main.sleep500();
            Thread.sleep(1000);
            System.out.println("\nA wild boar appeared!");
            System.out.println("Level: " + getLevel());
            System.out.println("Health: " + getHealth());
      }
      /**
       * This method prints out the kill message for the Wild Boar
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You slice up the Boar and eat some good pork.");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The boar decides to look for its meerkat friend.");
          Thread.sleep(2000);
      }
}
