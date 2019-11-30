package Haven;

public class WildBoar extends CharEntities{
      private int health;
      private int attack;

      public WildBoar(){
            this(6,3);
      }
      public WildBoar(int health, int attack){
            this.health = health;
            this.attack = attack;
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
