import java.util.Random;

public class WildBoar extends CharEntities{
      private int health;
      private int attack;
      private int level;
      public static Random rand = new Random();

      public WildBoar(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack();
          setHealth();
      }
      public void enemy(){
    	  System.out.println("                     __   __");
          System.out.println("                     \\/---\\/");
          System.out.println("                      ). .(");
          System.out.println("                     ( (\") )");
          System.out.println("                      )   (");
          System.out.println("                     /     \\ ");
          System.out.println("                    (       )`9");
          System.out.println("                   ( \\ /-\\ / )");
          System.out.println("                    w'W   W'w");
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
      public void upHealth(int boost) {
    	  if(boost + health > 10*level) {
    		  setHealth();
    	  }else {
    		  health = health + boost;
    	  }
      }
      public int getLevel() {
    	  return level;
      }
      public int getMove(Protag pc){
          int move = rand.nextInt(4);
          int dam = 0;
          if(move == 0) {
        	  System.out.println("Boar rolls in mud");
        	  dam = 0;
        	  System.out.println("It's healed some health.");
        	  System.out.println("Health " + getHealth() + "-->");
        	  upHealth(1*level);
        	  System.out.print(getHealth()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Boar uses Body Slam");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Boar uses Tackle");
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
            System.out.println("\nA wild boar appeared!");
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
    	  System.out.println("You slice up the Boar and eat some good pork.");
          Thread.sleep(2000);
          
      }
}
