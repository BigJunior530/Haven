import java.util.Random;
/**
 * This class is used to make the Hydra enemy
 * @author Carlos
 *
 */
public class Hydra extends CharEntities{
      public static Random rand = new Random();
      /**
  	 * This is a constructor to make the Hydra class
  	 * 
  	 * @param pc is the user class
  	 */
      public Hydra(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack(7);
          setHealth(9);
          setDifficulty("Hard");
      }
      /**
       * This method prints out the ascii art for the Hydra
       * 
       */
      public void enemy(){
    	  System.out.println("                      __   __  __");
          System.out.println("                     |\"|  |\"| |\"|");
          System.out.println("                       \\   |   /");
          System.out.println("                        \\  |  /");
          System.out.println("                         \\ | /");
          System.out.println("                         (   )");
          System.out.println("                        (     )");
          System.out.println("                       (       )");
          System.out.println("                         W   W");
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
        	  System.out.println("Hydra grows another head");
        	  dam = 0;
        	  System.out.println("It's attack increased.");
        	  System.out.println("Attack " + getAttack() + "-->");
        	  upAttack(getAttack()/2);
        	  System.out.print(getAttack()+ "\n");
          }else if(move == 1) {
        	  System.out.println("All of Hydras heads attacked");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Hydra uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the introduction for the Hydra
       */
      public void intro() throws InterruptedException {
            Main.sleep500();
            Thread.sleep(1000);
            System.out.println("\nA Hydra appeared!");
            System.out.println("Level: " + getLevel());
            System.out.println("Health: " + getHealth());
      }
      /**
       * This method prints out the kill message for the Hydra
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("Finally realizing slashing its head off weren't a good idea.");
          Thread.sleep(2000);
          System.out.println("You finally kill the beast");
          Thread.sleep(2000);
          System.out.println("You realize this wasn't the best place.");
          Thread.sleep(2000);
          System.out.println("You hope you never have to come back and sail back to land");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("Realizing you're insignificance, the hydra delves back into the ocean.");
          Thread.sleep(2000);
      }
}
