import java.util.Random;

public class Vulture extends CharEntities{
      private int health;
      private int attack;
      private int level;
      public static Random rand = new Random();

      public Vulture(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack();
          setHealth();
      }
      public void enemy(){
    	  System.out.println("                   .-..-.__");
          System.out.println("                 /`  |\\_( \"\\__");
          System.out.println("                 |   / __/`'--)");
          System.out.println("                 |  /  | |");
          System.out.println("                 /_/ _/_/");
          System.out.println("                 `|/))))");
       }
      public void setLevel(int enemy) {
    	  
    	  level = rand.nextInt(4) + enemy;
      }
      public void setAttack() {
    	  
    	  attack = 3*level;
      }
      public void setHealth() {
    	  
    	  health = 6*level;
      }
      
      public int getLevel() {
    	  return level;
      }
      public int getMove(Protag pc){
          int move = rand.nextInt(4);
          int dam = 0;
          if(move == 0) {
        	  System.out.println("Vulture uses Fly");
        	  dam = 0;
        	  System.out.println("You cant't really reach it.");
        	  System.out.println("You lost some attack");
        	  System.out.println("Attack " + pc.getAttack() + "-->");
        	  pc.downgradeAttack(1);
        	  System.out.print(pc.getAttack()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Vulture uses Scavenger");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Vulture uses tackle");
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
            System.out.println("\n\nA Vulture appeared!");
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
    	  System.out.println("You're able to slash the vulture's wings, never able to fly again.");
          Thread.sleep(2000);
      }
}
