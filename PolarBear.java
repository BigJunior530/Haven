import java.util.Random;

public class PolarBear extends CharEntities{
      private int health;
      private int attack;
      private int level;
      public static Random rand = new Random();

      public PolarBear(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack();
          setHealth();
      }
      public void enemy(){
    	  System.out.println("                     ..------~~~--.__");
          System.out.println("                   /               c~\\");
          System.out.println("                   /             \\__ `\\");
          System.out.println("                   |  /~~--__/  /'\\ ~~'");
          System.out.println("                  /'/'\\ |    | |`\\ \\_");
          System.out.println("                 `-))  `-))  `-)) `-))");
       }
      public void setLevel(int enemy) {
    	  
    	  level = rand.nextInt(4) + enemy;
      }
      public void setAttack() {
    	  
    	  attack = 8*level;
      }
      public void setHealth() {
    	  
    	  health = 11*level;
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
      public int getAttack(){
            return this.attack;
      }

      public void intro() throws InterruptedException {
            Main.sleep500();
            Thread.sleep(1000);
            System.out.println("\n\nA Polar Bear appeared!");
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
    	  System.out.println("You stab the Bear through its chest and watch it fall to the ground.");
          Thread.sleep(2000);
          System.out.println("The only see white with a large red puddle");
          Thread.sleep(2000);
          System.out.println("You realize this wasn't the best place.");
          Thread.sleep(2000);
          System.out.println("You leave the Tundra and wonder where to next");
          Thread.sleep(2000);
      }
}
