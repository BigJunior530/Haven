import java.util.Random;

public class RattleSnake extends CharEntities{
      private int health;
      private int attack;
      private int level;
      public static Random rand = new Random();

      public RattleSnake(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack();
          setHealth();
      }
      public void setLevel(int enemy) {
    	  
    	  level = (rand.nextInt(3) + 1) * enemy;
      }
      public void setAttack() {
    	  
    	  attack = 8*level;
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
        	  System.out.println("Snake uses its poison");
        	  dam = 0;
        	  System.out.println("You lost some shield");
        	  System.out.println("Shield " + pc.getShield() + "-->");
        	  pc.downgradeShield(2);
        	  System.out.print(pc.getShield()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Snake uses Constriction");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Snake uses Strike");
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
            System.out.println("\n\nA Rattle Snake appeared!");
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
