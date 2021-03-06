import java.util.Random;
/**
 * This class is used to make the Koi Fish enemy
 * @author Carlos
 *
 */
public class KoiFish extends CharEntities{
      public static Random rand = new Random();
      /**
  	 * This is a constructor to make the Koi Fish class
  	 * 
  	 * @param pc is the user class
  	 */
      public KoiFish(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack(2);
          setHealth(6);
          setDifficulty("Normal");
          setName("Koi Fish");
      }
      /**
       * This method prints out the ascii art for the Koi Fish
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
        	  System.out.println("Koi uses Glistening Scales");
        	  dam = 0;
        	  System.out.println("It's attack increased.");
        	  System.out.println("Attack " + getAttack() + "-->");
        	  upAttack(getAttack()/2);
        	  System.out.print(getAttack()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Koi uses Razor Scales");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Koi uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
    /**
     * This method prints out the kill message for the Koi Fish
     */
    public void endMessage() throws InterruptedException{
  	  System.out.println("You make yourself some sushi from the Koi.");
        Thread.sleep(2000); 
    }
    /**
     * The enemy's message when it decides to leave
     * 
     * @throws InterruptedException
     */
    public void leaveMessage() throws InterruptedException{
  	  System.out.println("The koi fish, tired of winning, swims away proudly.");
        Thread.sleep(2000);
    }
}
