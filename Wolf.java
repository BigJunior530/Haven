package Haven;
public class Wolf extends CharEntities{
      private int health;
      private int attack;

      public Wolf(){
          this(7,5);
    }
      public Wolf(int health, int attack){
            this.health = health;
            this.attack = attack;
      }

      public int getAttack(){
          return this.attack;
    }

    public void intro() throws InterruptedException {
          Main.sleep500();
          Thread.sleep(1000);
          System.out.println("\n\nA rabid Wolf appeared!");
    }

    public int getHealth(){
          return this.health;
    }
    public void damage(int hurt) {
  	  health = health - hurt;
    }
}
