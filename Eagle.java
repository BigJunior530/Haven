import java.util.Random;

public class Eagle extends CharEntities{
      private int health;
      private int attack;
      private int level;
      public static Random rand = new Random();

      public Eagle(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack();
          setHealth();
      }
      public void enemy(){
    	  System.out.println("             ____     _____");
          System.out.println("            /  \\  _.-'_.-'");
          System.out.println("            \\  _\\/   _/");
          System.out.println("          ___)/   __<");
          System.out.println("         <'-;:\\_  _\\");
          System.out.println("             '; \\_\\");
          System.out.println("              >/-,\\");
          System.out.println("            \"\"`  |_\\  ");
       }
      public void setLevel(int enemy) {
    	  
    	  level = (rand.nextInt(4)) + enemy;
      }
      public void setAttack() {
    	  
    	  attack = 6*level;
      }
      public void upAttack(int boost) {
    	  
    	  attack = attack + boost;
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
        	  System.out.println("Eagle uses Feather Dance");
        	  dam = 0;
        	  System.out.println("It's attack doubled.");
        	  System.out.println("Attack " + getAttack() + "-->");
        	  upAttack(getAttack());
        	  System.out.print(getAttack()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Eagle uses its Talons");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Eagle uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }

      public void intro() throws InterruptedException {
            Main.sleep500();
            Thread.sleep(1000);
            System.out.println("\nAn Eagle appeared!");
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
    	  System.out.println("You rip the Eagle's heart out and are finally able to taste Freedom");
          Thread.sleep(2000);
      }
}
