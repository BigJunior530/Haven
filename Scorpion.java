import java.util.Random;

public class Scorpion extends CharEntities{
      private int health;
      private int attack;
      private int level;
      public static Random rand = new Random();

      public Scorpion(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack();
          setHealth();
      }
      public void enemy(){
    	  System.out.println("            _    _");
          System.out.println("           /_]  [_\\");
          System.out.println("          //      \\\\");
          System.out.println("          \\\\      //");
          System.out.println("           \\`-..-'/");
          System.out.println("            `\\  /`");
          System.out.println("              ||    _");
          System.out.println("              ||   ( )");
          System.out.println("              \\\\___/");
       }
      public void setLevel(int enemy) {
    	  
    	  level = (rand.nextInt(4)) + enemy;
      }
      public void setAttack() {
    	  
    	  attack = 6*level;
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
        	  System.out.println("Scorpion uses Posion Sting");
        	  dam = pc.getAttack()/2;
        	  System.out.println("You cut off the area to stop the Poison from spreading");
          }else if(move == 1) {
        	  System.out.println("Scorpion uses Pinch");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Scorpion uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }

      public void intro() throws InterruptedException {
            Main.sleep500();
            Thread.sleep(1000);
            System.out.println("\nA Scorpion appeared!");
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
    	  System.out.println("You cut off the stringer and the claws leaving the Scorpion to a pathetic existence.");
          Thread.sleep(2000);
      }
}
