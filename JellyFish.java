import java.util.Random;

public class JellyFish extends CharEntities{
      private int health;
      private int attack;
      private int level;
      public static Random rand = new Random();

      public JellyFish(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack();
          setHealth();
      }
      public void enemy(){
    	  System.out.println("                     .-;':':'-.");
          System.out.println("                    {'.'.'.'.'.}");
          System.out.println("                     )        '`.");
          System.out.println("                    '-. ._ ,_.-='");
          System.out.println("                      `). ( `);(");
          System.out.println("                      ('. .)(,'.)");
          System.out.println("                       ) ( ,').(");
          System.out.println("                      ( .').'(').");
          System.out.println("                      .) (' ).('");
          System.out.println("                       '  ) (  ).");
          System.out.println("                        .'( .)'");
          System.out.println("                          .).'");
       }
      public void setLevel(int enemy) {
    	  
    	  level = (rand.nextInt(4)) + enemy;
      }
      public void setAttack() {
    	  
    	  attack = 5*level;
      }
      public void setHealth() {
    	  
    	  health = 3*level;
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
        	  System.out.println("JellyFish uses Paralyze");
        	  dam = 0;
        	  System.out.println("You lost some shield");
        	  System.out.println("Shield " + pc.getShield() + "-->");
        	  pc.downgradeShield(2);
        	  System.out.print(pc.getShield()+ "\n");
          }else if(move == 1) {
        	  System.out.println("JellyFish uses Poison Sting");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("JellyFish uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }

      public void intro() throws InterruptedException {
            Main.sleep500();
            Thread.sleep(1000);
            System.out.println("\nA JellyFish appeared!");
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
    	  System.out.println("You slice the JellyFish up into bits and make your own 'Jelly'");
          Thread.sleep(2000);
      }
}
