import java.util.Random;

public class Leviathan extends CharEntities{
      private int health;
      private int attack;
      private int level;
      public static Random rand = new Random();

      public Leviathan(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack();
          setHealth();
      }
      public void enemy(){
    	  System.out.println("                                   ____");
          System.out.println("          ________________________/ O  \\___/");
          System.out.println("         <_/_\\_/_\\_/_\\_/_\\_/_\\_/_______/   \\");
       }
      public void setLevel(int enemy) {
    	  
    	  level = rand.nextInt(4) + enemy;
      }
      public void setAttack() {
    	  
    	  attack = 10*level;
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
        	  System.out.println("Leviathan uses glare");
        	  dam = 0;
        	  System.out.println("You lost some shield");
        	  System.out.println("Shield " + pc.getShield() + "-->");
        	  pc.downgradeShield(3);
        	  System.out.print(pc.getShield()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Leviathan uses crunch");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Leviathan uses tackle");
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
            System.out.println("\n\nA Leviathan appeared!");
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
    	  System.out.println("You split the Leviathan straight down the middle.");
          Thread.sleep(2000);
          System.out.println("You realize this wasn't the best place.");
          Thread.sleep(2000);
          System.out.println("You leave the Lost City and wonder where to next");
          Thread.sleep(2000);
      }
}
