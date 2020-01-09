import java.util.Random;

public class Panther extends CharEntities{
      private int health;
      private int attack;
      private int level;
      public static Random rand = new Random();

      public Panther(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack();
          setHealth();
      }
      public void enemy(){
    	  System.out.println("                 (\"`-''-/\").___..--''\"`-._");
          System.out.println("                  `6_ 6  )   `-.  (     ).`-.__.`)");
          System.out.println("                  (_Y_.)'  ._   )  `._ `. ``-..-'");
          System.out.println("                _..`--'_..-_/  /--'_.' ,'");
          System.out.println("               (il),-''  (li),'  ((!.-' ");
       }
      public void setLevel(int enemy) {
    	  
    	  level = rand.nextInt(4) +enemy;
      }
      public void setAttack() {
    	  
    	  attack = 7*level;
      }
      public void upAttack(int boost) {
    	  
    	  attack = attack + boost;
      }
      public void setHealth() {
    	  
    	  health = 9*level;
      }
      
      public int getLevel() {
    	  return level;
      }
      public int getMove(Protag pc){
          int move = rand.nextInt(4);
          int dam = 0;
          if(move == 0) {
        	  System.out.println("Panther prepares to pounce");
        	  dam = 0;
        	  System.out.println("It's attack doubled.");
        	  System.out.println("Attack " + getAttack() + "-->");
        	  upAttack(getAttack());
        	  System.out.print(getAttack()+ "\n");
          }else if(move == 1) {
          }else if(move == 1) {
        	  System.out.println("Panther uses Maul");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Panther uses Pounce");
        	  dam = attack;
          }
          return dam;
    	  
      }
      public int getAttack(){
            return this.attack;
      }

      public void intro() throws InterruptedException {
            Main.sleep500();
            Thread.sleep(1000);
            System.out.println("\n\nA Panther appeared!");
            System.out.println("Level: " + getLevel());
            System.out.println("Health: " + getHealth());
      }

      public int getHealth(){
            return this.health;
      }
      public void damage(int hurt) {
    	  health = health - hurt;
      }
      public void endMessage() throws InterruptedException{
    	  System.out.println("You slash the final blow against the Panther straight into its skull");
          Thread.sleep(2000);
          System.out.println("You realize this wasn't the best place.");
          Thread.sleep(2000);
          System.out.println("You leave the Jungle and wonder where to next");
          Thread.sleep(2000);
      }
}
