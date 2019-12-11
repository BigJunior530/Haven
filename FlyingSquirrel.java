import java.util.Random;

public class FlyingSquirrel extends CharEntities{
      private int health;
      private int attack;
      private int level;
      public static Random rand = new Random();

      public FlyingSquirrel(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack();
          setHealth();
      }
      public void enemy(){
    	  System.out.println("              (\\__/)  .~    ~. ))");
          System.out.println("              /O O `./      .'");
          System.out.println("             {O__,   \\    {");
          System.out.println("              / .  . )    \\");
          System.out.println("              |-| '-' \\    } ))");
          System.out.println("             .(   _(   )_.'");
          System.out.println("            '---.~_ _ _&");
       }
      public void setLevel(int enemy) {
    	  
    	  level = (rand.nextInt(4) + 1) * enemy;
      }
      public void setAttack() {
    	  
    	  attack = 2*level;
      }
      public void setHealth() {
    	  
    	  health = 4*level;
      }
      
      public int getLevel() {
    	  return level;
      }
      public int getMove(Protag pc){
          int move = rand.nextInt(4);
          int dam = 0;
          if(move == 0) {
        	  System.out.println("Squirell uses Fluffy Tail");
        	  dam = 0;
        	  System.out.println("You kind of don't want to hurt it now.");
        	  System.out.println("You lost some attack");
        	  System.out.println("Attack " + pc.getAttack() + "-->");
        	  pc.downgradeAttack(1);
        	  System.out.print(pc.getAttack()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Squirrel uses Pierce");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Squirrel uses Tackle");
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
          System.out.println("\n\nA Flying Squirrel appeared!");
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