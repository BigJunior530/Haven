import java.util.Random;

public class Penguin extends CharEntities{
      private int health;
      private int attack;
      private int level;
      public static Random rand = new Random();

      public Penguin(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack();
          setHealth();
      }
      public void setLevel(int enemy) {
    	  
    	  level = (rand.nextInt(4) + 1) * enemy;
      }
      public void setAttack() {
    	  
    	  attack = 2*level;
      }
      public void setHealth() {
    	  
    	  health = 6*level;
      }
      
      public int getLevel() {
    	  return level;
      }

      public int getAttack(){
            return this.attack;
      }

      public void intro() throws InterruptedException {
            Main.sleep500();
            Thread.sleep(1000);
            System.out.println("\n\nA Penguin appeared!");
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
