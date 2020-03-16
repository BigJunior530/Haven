import java.util.Random;
/**
 * This class is used to make the Salmon enemy
 * @author Carlos
 *
 */
public class Salmon extends CharEntities{
	public static Random rand = new Random();
	/**
	 * This is a constructor to make the Salmon class
	 * 
	 * @param pc is the user class
	 */
      public Salmon(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack(3);
          setHealth(5);
          setDifficulty("Normal");
          setName("Salmon");
      }
      /**
       * This method prints out the ascii art for the Salmon
       * 
       */
      public void enemy(){
    	  System.out.println("                   /\"*._         _");
          System.out.println("               .-*'`    `*-.._.-'/");
          System.out.println("             < * ))     ,       ( ");
          System.out.println("              `*-._`._(__.--*\"`.\\");
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
        	  System.out.println("Salmon uses Current");
        	  dam = 0;
        	  System.out.println("Its attack increased");
        	  System.out.println("Attack " + getAttack() + "-->");
        	  upAttack(getAttack()/2);
        	  System.out.print(getAttack()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Salmon uses Razor Scale");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Salmon uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the kill message for the Salmon
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You can't wait to eat salmon sushi.");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The Salmon swims back into the water.");
          Thread.sleep(2000);
      }
}
