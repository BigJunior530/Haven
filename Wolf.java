import java.util.Random;
/**
 * This class is used to make the Wolf enemy
 * @author Carlos
 *
 */
public class Wolf extends CharEntities{
      public static Random rand = new Random();
      /**
    	 * This is a constructor to make the Wolf class
    	 * 
    	 * @param pc is the user class
    	 */
      public Wolf(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack(5);
          setHealth(7);
          setDifficulty("Normal");
      }
      /**
       * This method prints out the ascii art for the Wolf
       * 
       */
      public void enemy(){
    	  System.out.println("                              .");
          System.out.println("                             / V\\");
          System.out.println("                            / ` /");
          System.out.println("                          <<   |");
          System.out.println("                          /    |");
          System.out.println("                        /      |");
          System.out.println("                      /        |");
          System.out.println("                    /    \\  \\ /");
          System.out.println("                   (      ) | |");
          System.out.println("           ________|   _/_  | |");
          System.out.println("         <__________\\______)\\__)");
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
        	  System.out.println("Wolf uses Howl");
        	  dam = 0;
        	  System.out.println("It's attack increased.");
        	  System.out.println("Attack " + getAttack() + "-->");
        	  upAttack(getAttack()/2);
        	  System.out.print(getAttack()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Wolf uses Mutilate");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Wolf uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the introduction for the Wolf
       */
    public void intro() throws InterruptedException {
          Main.sleep500();
          Thread.sleep(1000);
          System.out.println("\nA rabid Wolf appeared!");
          System.out.println("Level: " + getLevel());
          System.out.println("Health: " + getHealth());
    }
    /**
     * This method prints out the kill message for the Wolf
     */
    public void endMessage() throws InterruptedException{
  	  System.out.println("You slash the wolf until the whimpers finally stop.");
        Thread.sleep(2000);
    }
    /**
     * The enemy's message when it decides to leave
     * 
     * @throws InterruptedException
     */
    public void leaveMessage() throws InterruptedException{
  	  System.out.println("The wolf hears a howl and decides to join back up with its pack.");
        Thread.sleep(2000);
    }
}
