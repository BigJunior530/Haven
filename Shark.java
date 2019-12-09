import java.util.Random;

public class Shark extends CharEntities{
      private int health;
      private int attack;
      private int level;
      public static Random rand = new Random();

      public Shark(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack();
          setHealth();
      }
      public void setLevel(int enemy) {
    	  
    	  level = (rand.nextInt(3) + 1) * enemy;
      }
      public void setAttack() {
    	  
    	  attack = 10*level;
      }

      public void upAttack(int boost) {
    	  
    	  attack = attack + boost;
      }

      public void setHealth() {
    	  
    	  health = 12*level;
      }
      
      public int getLevel() {
    	  return level;
      }

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

      public int getAttack(){
            return this.attack;
      }

      public void intro() throws InterruptedException {
            Main.sleep500();
            Thread.sleep(1000);
            System.out.println("\n\nA Great White Shark appeared!");
            System.out.println("Level: " + getLevel());
            System.out.println("Health: " + getHealth());
      }

      public int getHealth(){
            return this.health;
      }
      public void damage(int hurt) {
    	  health = health - hurt;
      }
}
