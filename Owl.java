import java.util.Random;

public class Owl extends CharEntities{
      private int health;
      private int attack;
      private int level;
      public static Random rand = new Random();

      public Owl(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack();
          setHealth();
      }
      public void enemy(){
    	  System.out.println("            , _ ,");
          System.out.println("           ( o o )");
          System.out.println("          /'` ' `'\\");
          System.out.println("          |'''''''|");
          System.out.println("          |\\\\'''//|");
          System.out.println("             \"\"\"");
       }
      public void setLevel(int enemy) {
    	  
    	  level = (rand.nextInt(4)) + enemy;
      }
      public void setAttack() {
    	  
    	  attack = 5*level;
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
        	  System.out.println("Owl spun its head");
        	  dam = pc.getAttack()/2;
        	  System.out.println("You got confused and tried to twist your own head.");
          }else if(move == 1) {
        	  System.out.println("Owl used its Talons");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Owl uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }

      public void intro() throws InterruptedException {
            Main.sleep500();
            Thread.sleep(1000);
            System.out.println("\nAn Artic Owl appeared!");
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
    	  System.out.println("You decapitated the Owl after it turned its head again");
          Thread.sleep(2000);
      }
}
