import java.util.Random;

public class Hydra extends CharEntities{
      private int health;
      private int attack;
      private int level;
      public static Random rand = new Random();

      public Hydra(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack();
          setHealth();
      }
      public void enemy(){
    	  System.out.println("                      __   __  __");
          System.out.println("                     |\"|  |\"| |\"|");
          System.out.println("                       \\   |   /");
          System.out.println("                        \\  |  /");
          System.out.println("                         \\ | /");
          System.out.println("                         (   )");
          System.out.println("                        (     )");
          System.out.println("                       (       )");
          System.out.println("                         W   W");
       }
      public void setLevel(int enemy) {
    	  
    	  level = rand.nextInt(4) + enemy;
      }
      public void setAttack() {
    	  
    	  attack = 7*level;
      }
      public void setHealth() {
    	  
    	  health = 9*level;
      }
      public void upAttack(int boost) {
    	  
    	  attack = attack + boost;
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
        	  System.out.println("Hydra grows another head");
        	  dam = 0;
        	  System.out.println("It's attack increased.");
        	  System.out.println("Attack " + getAttack() + "-->");
        	  upAttack(getAttack()/2);
        	  System.out.print(getAttack()+ "\n");
          }else if(move == 1) {
        	  System.out.println("All of Hydras heads attacked");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Hydra uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }

      public void intro() throws InterruptedException {
            Main.sleep500();
            Thread.sleep(1000);
            System.out.println("\nA Hydra appeared!");
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
    	  System.out.println("Finally realizing slashing its head off weren't a good idea.");
          Thread.sleep(2000);
          System.out.println("You finally kill the beast");
          Thread.sleep(2000);
          System.out.println("You realize this wasn't the best place.");
          Thread.sleep(2000);
          System.out.println("You hope you never have to come back and sail back to land");
          Thread.sleep(2000);
      }
}
