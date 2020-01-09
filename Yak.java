import java.util.Random;

public class Yak extends CharEntities{
      private int health;
      private int attack;
      private int level;
      public static Random rand = new Random();

      public Yak(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack();
          setHealth();
      }
      public void enemy(){
    	  System.out.println("            ,__ ., __, ,,,,");
          System.out.println("            '--/,,\\--'\\*\\%\\*\\");
          System.out.println("              //  \\\\\\'\\'%.\\'%\\");
          System.out.println("               '..'//'%\\.\\%/\\\\'.^");
          System.out.println("                  \\\\'/'/%''/\\'");
          System.out.println("                    ||     ||");
          System.out.println("                    \"      \"");
       }
      public void setLevel(int enemy) {
    	  
    	  level = (rand.nextInt(4)) + enemy;
      }
      public void setAttack() {
    	  
    	  attack = 5*level;
      }
      public void setHealth() {
    	  
    	  health = 8*level;
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
      public int getAttack() {
    	  return attack;
      }
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

      public void intro() throws InterruptedException {
            Main.sleep500();
            Thread.sleep(1000);
            System.out.println("\nA Yak appeared!");
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
    	  System.out.println("You cut off the horns of the Yak and use them to stab them through each eye.");
          Thread.sleep(2000);
      }
}
