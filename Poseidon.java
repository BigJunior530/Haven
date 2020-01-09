import java.util.Random;

public class Poseidon extends CharEntities{
      private int health;
      private int attack;
      private int level;
      public static Random rand = new Random();

      public Poseidon(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack();
          setHealth();
      }
      public void enemy(){
    	  System.out.println("                     |      ,sss.");
          System.out.println("                   | | |    $^,^$");
          System.out.println("                   |_|_|   _/$$$\\_");
          System.out.println("                     |   /'  ?$?  `.");
          System.out.println("                     ;,-' /\\ ,, /. |");
          System.out.println("                     '-./' ;    ;: |");
          System.out.println("                     |     |`  '|`,;");
          System.out.println("                   ~~~~~~~~~~~~~~~~~~~~");
       }
      public void setLevel(int enemy) {
    	  
    	  level = (rand.nextInt(4)) + enemy;
      }
      public void setAttack() {
    	  
    	  attack = 5*level;
      }
      public void upAttack(int boost) {
    	  
    	  attack = attack + boost;
      }
      public void setHealth() {
    	  
    	  health = 7*level;
      }
      
      public int getLevel() {
    	  return level;
      }
      public int getAttack() {
    	  return attack;
      }
      public int getMove(Protag pc){
          int move = rand.nextInt(4);
          int dam = 0;
          if(move == 0) {
        	  System.out.println("Poseidon used Wrath");
        	  dam = 0;
        	  System.out.println("It's attack doubled.");
        	  System.out.println("Attack " + getAttack() + "-->");
        	  upAttack(getAttack());
        	  System.out.print(getAttack()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Poseidon used Tsunami");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Poseidon used surf");
        	  dam = attack;
          }
          return dam;
    	  
      }

      public void intro() throws InterruptedException {
            Main.sleep500();
            Thread.sleep(1000);
            System.out.println("\nPoseidon appeared!");
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
    	  System.out.println("You use Poseidon's Trident to turn him into a Fish(Shish) Kebab");
          Thread.sleep(2000);
      }
}
