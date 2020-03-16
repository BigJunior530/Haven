import java.util.Random;
/**
 * This class is used to make the Zombie enemy
 * @author Carlos
 *
 */
public class Zombie extends CharEntities{
	public static Random rand = new Random();
	/**
	 * This is a constructor to make the Zombie class
	 * 
	 * @param pc is the user class
	 */
      public Zombie(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack(6);
          setHealth(3);
          setDifficulty("Normal");
          setName("Zombie");
      }
      /**
       * This method prints out the ascii art for the Zombie
       * 
       */
      public void enemy(){
          System.out.println("               0");
          System.out.println("            ===|");
          System.out.println("               |");
          System.out.println("              / \\");
          System.out.println("            _/  _\\");
       }
      /**
       * This method randomly chooses a move to determine the damage to the User
       * 
       * @param pc is the user class
       * @return dam is the damage it will deal to the user
       */
      public int getMove(Protag pc){
          int move = rand.nextInt(4);
          int dam = 0;
          if(move == 0) {
        	  System.out.println("Zombie uses Virus");
        	  dam = 0;
        	  System.out.println("You become more vulnerable to attacks.");
        	  System.out.println("Shield " + pc.getShield() + "-->");
        	  pc.decreaseShieldTemp(4);
        	  System.out.print(pc.getShield()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Zombie uses Decay");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Zombie uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the kill message for the Zombie
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You slash the rotting corpse until there's just black blood left.");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The Zombie realizes you don't have any brains to eat and leaves.");
          Thread.sleep(2000);
      }
}
