import java.util.Random;
/**
 * This class is used to make the Yak enemy
 * @author Carlos
 *
 */
public class Yak extends CharEntities{
      public static Random rand = new Random();
      /**
    	 * This is a constructor to make the Yak class
    	 * 
    	 * @param pc is the user class
    	 */
      public Yak(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack(5);
          setHealth(8);
          setDifficulty("Normal");
      }
      /**
       * This method prints out the ascii art for the Yak
       * 
       */
      public void enemy(){
    	  System.out.println("            ,__ ., __, ,,,,");
          System.out.println("            '--/,,\\--'\\*\\%\\*\\");
          System.out.println("              //  \\\\\\'\\'%.\\'%\\");
          System.out.println("               '..'//'%\\.\\%/\\\\'.^");
          System.out.println("                  \\\\'/'/%''/\\'");
          System.out.println("                    ||     ||");
          System.out.println("                    \"      \"");
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
        	  System.out.println("Yak uses its thick fur to warm itself up");
        	  dam = 0;
        	  System.out.println("It's healed some health.");
        	  System.out.println("Health " + getHealth() + "-->");
        	  upHealth(1*level);
        	  System.out.print(getHealth()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Yak uses Charge");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Yak uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the introduction for the Yak
       */
      public void intro() throws InterruptedException {
            Main.sleep500();
            Thread.sleep(1000);
            System.out.println("\nA Yak appeared!");
            System.out.println("Level: " + getLevel());
            System.out.println("Health: " + getHealth());
      }
      /**
       * This method prints out the kill message for the Yak
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You cut off the horns of the Yak and use them to stab them through each eye.");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The Yak, decides it wasn't worth its time to fight a weak being.");
          Thread.sleep(2000);
      }
}
