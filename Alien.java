
import java.util.Random;

public class Alien extends CharEntities{
      private int health;
      private int attack;
      private int level;
      public static Random rand = new Random();

      public Alien(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack();
          setHealth();
      }
      public void enemy(){
    	  System.out.println("                                  .-.");
          System.out.println("                   .-\"\"`\"\"-.    |(@ @)");
          System.out.println("                _/`oOoOoOoOo`\\_ \\ \\-/");
          System.out.println("               '.-=-=-=-=-=-=-.' \\/ \\");
          System.out.println("                 `-=.=-.-=.=-'    \\ /\\");
          System.out.println("                    ^  ^  ^       _H_ \\");
       }
      public void setLevel(int enemy) {
    	  
    	  level = (rand.nextInt(4) + 1) * enemy;
      }
      public void setAttack() {
    	  
    	  attack = 4*level;
      }
      public void setHealth() {
    	  
    	  health = 4*level;
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
        	  System.out.println("Alien uses Hypnosis");
        	  dam = pc.getAttack()/2;
        	  System.out.println("You got confused. Then punched yourself to get out of confusion");
          }else if(move == 1) {
        	  System.out.println("Alien uses Probe");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Alien uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }

      public void intro() throws InterruptedException {
            Main.sleep500();
            Thread.sleep(1000);
            System.out.println("\n\nAn Alien appeared!");
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
