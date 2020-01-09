import java.util.Random;

public class Frog extends CharEntities{
      private int health;
      private int attack;
      private int level;
      public static Random rand = new Random();

      public Frog(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack();
          setHealth();
      }
      public void enemy(){
    	  System.out.println("                      _   _");
          System.out.println("                     (.)_(.)");
          System.out.println("                  _ (   _   ) _");
          System.out.println("                 / \\/`-----'\\/ \\");
          System.out.println("               __\\ ( (     ) ) /__");
          System.out.println("               )   /\\ \\._./ /\\   (");
          System.out.println("                )_/ /|\\   /|\\ \\_(");
       }
      public void setLevel(int enemy) {
    	  
    	  level = (rand.nextInt(4)) + enemy;
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
      
      public void endMessage() throws InterruptedException{
    	  System.out.println("You slash the aliens into bits and jump out of the UFO back to the ocean");
          Thread.sleep(2000);
      }
}
