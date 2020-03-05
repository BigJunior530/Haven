import java.util.Random;
/**
 * This class is used to make the Polar Bear enemy
 * @author Carlos
 *
 */
public class PolarBear extends CharEntities{
      public static Random rand = new Random();
      /**
  	 * This is a constructor to make the Polar Bear class
  	 * 
  	 * @param pc is the user class
  	 */
      public PolarBear(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack(8);
          setHealth(11);
          setDifficulty("Hard");
      }
      /**
       * This method prints out the ascii art for the Polar Bear
       * 
       */
      public void enemy(){
    	  System.out.println("                     ..------~~~--.__");
          System.out.println("                   /               c~\\");
          System.out.println("                   /             \\__ `\\");
          System.out.println("                   |  /~~--__/  /'\\ ~~'");
          System.out.println("                  /'/'\\ |    | |`\\ \\_");
          System.out.println("                 `-))  `-))  `-)) `-))");
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
        	  System.out.println("Polar Bear uses its thick fur to warm itself up.");
        	  dam = 0;
        	  System.out.println("It's healed some health.");
        	  System.out.println("Health " + getHealth() + "-->");
        	  upHealth(1*level);
        	  System.out.print(getHealth()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Polar Bear smashes its paws against the Ice to completely shatter the Ice under you");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Polar Bear uses Strike");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the introduction for the Polar Bear
       */
      public void intro() throws InterruptedException {
            Main.sleep500();
            Thread.sleep(1000);
            System.out.println("\n\nA Polar Bear appeared!");
            System.out.println("Level: " + getLevel());
            System.out.println("Health: " + getHealth());
      }
      /**
       * This method prints out the kill message for the Polar Bear
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You stab the Bear through its chest and watch it fall to the ground.");
          Thread.sleep(2000);
          System.out.println("The only see white with a large red puddle");
          Thread.sleep(2000);
          System.out.println("You realize this wasn't the best place.");
          Thread.sleep(2000);
          System.out.println("You leave the Tundra and wonder where to next");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The polar bear gets bored and wanders away.");
          Thread.sleep(2000);
      }
}
