import java.util.Random;
/**
 * This class is used to make the Shark enemy
 * @author Carlos
 *
 */
public class Shark extends CharEntities{
      public static Random rand = new Random();
      /**
  	 * This is a constructor to make the Shark class
  	 * 
  	 * @param pc is the user class
  	 */
      public Shark(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack();
          setHealth();
          setDifficulty();
      }
      /**
       * This method prints out the ascii art for the Shark
       * 
       */
      public void enemy(){
    	  System.out.println("                       _________         .    .");
          System.out.println("                      (..       \\_    ,  |\\  /|");
          System.out.println("                       \\       O  \\  /|  \\ \\/ /");
          System.out.println("                        \\______    \\/ |   \\  / ");
          System.out.println("                           vvvv\\    \\ |   /  |");
          System.out.println("                           \\^^^^  ==   \\_/   |");
          System.out.println("                            `\\_   ===    \\.  |");
          System.out.println("                            / /\\_   \\ /      |");
          System.out.println("                            |/   \\_  \\|      /");
          System.out.println("                                   \\________/");
       }
      /**
       * This method sets the level for the enemy based off the User's level
       * 
       *  @param enemy is the level of the User
       */
      public void setLevel(int enemy) {
    	  
    	  level = rand.nextInt(4) + enemy;
      }
      /**
       * This method sets the attack using level
       */
      public void setAttack() {
    	  
    	  attack = 7*level;
      }
      /**
       * This method sets the health using level
       */
      public void setHealth() {
    	  
    	  health = 9*level;
      }
      /**
       * This method sets the difficulty of the animal to Normal
       */
      public void setDifficulty() {
    	  difficulty = "Normal";
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
        	  System.out.println("Shark smells Blood");
        	  dam = 0;
        	  System.out.println("It's attack Doubled.");
        	  System.out.println("Attack " + getAttack() + "-->");
        	  upAttack(getAttack());
        	  System.out.print(getAttack()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Shark uses its rows of Razer Sharp teeth to shred you");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Shark uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the introduction for the Shark
       */
      public void intro() throws InterruptedException {
            Main.sleep500();
            Thread.sleep(1000);
            System.out.println("\n\nA Great White Shark appeared!");
            System.out.println("Level: " + getLevel());
            System.out.println("Health: " + getHealth());
      }
      /**
       * This method prints out the kill message for the Shark
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You stab your sword straight through the Shark's eye to the other.");
          Thread.sleep(2000);
      }
}
