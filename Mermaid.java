import java.util.Random;

public class Mermaid extends CharEntities{
      private int health;
      private int attack;
      private int level;
      public static Random rand = new Random();

      public Mermaid(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack();
          setHealth();
      }
      public void enemy(){
    	  System.out.println("                                               .-\"\"-.");
          System.out.println("                                              (___/\\ \\");
          System.out.println("                           ,                 (|^ ^ ) )");
          System.out.println("                          /(                _)_\\=_/  (");
          System.out.println("                    ,..__/ `\\          ____(_/_ ` \\   )");
          System.out.println("                     `\\    _/        _/---._/(_)_  `\\ (");
          System.out.println("                       '--\\ `-.__..-'    /.    (_), |  )");
          System.out.println("                           `._        ___\\_____.'_| |__/");
          System.out.println("                              `~----\"`   `-.........'");
       }
      public void setLevel(int enemy) {
    	  
    	  level = rand.nextInt(4) + enemy;
      }
      public void setAttack() {
    	  
    	  attack = 3*level;
      }
      public void setHealth() {
    	  
    	  health = 5*level;
      }
      
      public int getLevel() {
    	  return level;
      }
      public int getMove(Protag pc){
          int move = rand.nextInt(4);
          int dam = 0;
          if(move == 0) {
        	  System.out.println("Mermaid uses Song");
        	  dam = pc.getAttack()/2;
        	  System.out.println("You're body slowing started walking by itself towads the Mermaid. You stabbed youself to Stop.");
          }else if(move == 1) {
        	  System.out.println("Mermaid uses drown");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Mermaid uses Tackle");
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
            System.out.println("\n\nA Mermaid appeared!");
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
    	  System.out.println("You split the mermaid cleanly in half, seperating the human from fish");
          Thread.sleep(2000);
      }
}
