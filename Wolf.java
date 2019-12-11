import java.util.Random;

public class Wolf extends CharEntities{
      private int health;
      private int attack;
      private int level;
      public static Random rand = new Random();

      public Wolf(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack();
          setHealth();
      }
      public void enemy(){
    	  System.out.println("                              .");
          System.out.println("                             / V\\");
          System.out.println("                            / ` /");
          System.out.println("                          <<   |");
          System.out.println("                          /    |");
          System.out.println("                        /      |");
          System.out.println("                      /        |");
          System.out.println("                    /    \\  \\ /");
          System.out.println("                   (      ) | |");
          System.out.println("           ________|   _/_  | |");
          System.out.println("         <__________\\______)\\__)");
       }
      public void setLevel(int enemy) {
    	  
    	  level = (rand.nextInt(4) + 1) * enemy;
      }
      public void setAttack() {
    	  
    	  attack = 5*level;
      }
      public void setHealth() {
    	  
    	  health = 7*level;
      }
      public void upAttack(int boost) {
    	  
    	  attack = attack + boost;
      }
      public int getLevel() {
    	  return level;
      }
      public int getMove(Protag pc){
          int move = rand.nextInt(4);
          int dam = 0;
          if(move == 0) {
        	  System.out.println("Wolf uses Howl");
        	  dam = 0;
        	  System.out.println("It's attack increased.");
        	  System.out.println("Attack " + getAttack() + "-->");
        	  upAttack(getAttack()/2);
        	  System.out.print(getAttack()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Wolf uses Mutilate");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Wolf uses Tackle");
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
          System.out.println("\n\nA rabid Wolf appeared!");
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
