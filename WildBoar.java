import java.util.Random;

public class WildBoar extends CharEntities{
      private int health;
      private int attack;
      private int level;
      public static Random rand = new Random();

      public WildBoar(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack();
          setHealth();
      }
      public void setLevel(int enemy) {
    	  
    	  level = (rand.nextInt(3) + 1) * enemy;
      }
      public void setAttack() {
    	  
    	  attack = 3*level;
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
            System.out.println("\n\nA wild boar appeared!");
      }

      public int getHealth(){
            return this.health;
      }
      public void damage(int hurt) {
    	  health = health - hurt;
      }
}
