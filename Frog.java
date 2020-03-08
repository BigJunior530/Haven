import java.util.Random;
/**
 * This class is used to make the Frog enemy
 * @author Carlos
 *
 */
public class Frog extends CharEntities{
      public static Random rand = new Random();
      /**
  	 * This is a constructor to make the Frog class
  	 * 
  	 * @param pc is the user class
  	 */
      public Frog(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack(4);
          setHealth(4);
          setDifficulty("Easy");
      }
      /**
       * This method prints out the ascii art for the Frog
       * 
       */
      public void enemy(){
    	  System.out.println("                      _   _");
          System.out.println("                     (.)_(.)");
          System.out.println("                  _ (   _   ) _");
          System.out.println("                 / \\/`-----'\\/ \\");
          System.out.println("               __\\ ( (     ) ) /__");
          System.out.println("               )   /\\ \\._./ /\\   (");
          System.out.println("                )_/ /|\\   /|\\ \\_(");
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
        	  System.out.println("Frog uses slime");
        	  dam = 0;
        	  System.out.println("It's healed some health.");
        	  System.out.println("Health " + getHealth() + "-->");
        	  upHealth(1*level);
        	  System.out.print(getHealth()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Frog uses its Tongue");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Frog uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the introduction for the Frog
       */
      public void intro() throws InterruptedException {
            Main.sleep500();
            Thread.sleep(1000);
            System.out.println("\nA Frog appeared!");
            System.out.println("Level: " + getLevel());
            System.out.println("Health: " + getHealth());
      }
      /**
       * This method prints out the kill message for the Frog
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You cut the Frogs legs off and tongue making it useless.");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The frog jumps, hits your face one last time, and escapes into the nearby body of water.");
          Thread.sleep(2000);
      }
}
