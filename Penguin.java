import java.util.Random;
/**
 * This class is used to make the Penguin enemy
 * @author Carlos
 *
 */
public class Penguin extends CharEntities{
      public static Random rand = new Random();
      /**
    	 * This is a constructor to make the Penguin class
    	 * 
    	 * @param pc is the user class
    	 */
      public Penguin(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack(2);
          setHealth(6);
          setDifficulty("Normal");
      }
      /**
       * This method prints out the ascii art for the Penguin
       * 
       */
      public void enemy(){
    	  System.out.println("                  .___.");
          System.out.println("                 /     \\");
          System.out.println("                | O _ O |");
          System.out.println("                /  \\_/  \\ ");
          System.out.println("              .' /     \\ `.");
          System.out.println("             / _|       |_ \\");
          System.out.println("            (_/ |       | \\_)");
          System.out.println("                \\       /");
          System.out.println("               __\\_>-<_/__");
          System.out.println("               ~;/     \\;~");
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
        	  System.out.println("Penguin uses Happy Feet");
        	  dam = 0;
        	  System.out.println("You kind of don't want to hurt it now.");
        	  System.out.println("You lost some attack");
        	  System.out.println("Attack " + pc.getAttack() + "-->");
        	  pc.downgradeAttack(1);
        	  System.out.print(pc.getAttack()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Penguin uses Drill  Peck");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Penguin uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the introduction for the Penguin
       */
      public void intro() throws InterruptedException {
            Main.sleep500();
            Thread.sleep(1000);
            System.out.println("\n\nA Penguin appeared!");
            System.out.println("Level: " + getLevel());
            System.out.println("Health: " + getHealth());
      }
      /**
       * This method prints out the kill message for the Penguin
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You slit open the Penguin and let it get covered by the now heavy snow");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The penguin slides towards you but misses and falls back into its hole.");
          Thread.sleep(2000);
      }
}
