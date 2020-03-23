import java.util.Random;
/**
 * This class is used to make the Piranha enemy
 * @author Carlos
 *
 */
public class Piranha extends CharEntities{
      public static Random rand = new Random();
      /**
    	 * This is a constructor to make the Piranha class
    	 * 
    	 * @param pc is the user class
    	 */
      public Piranha(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack(5);
          setHealth(4);
          setDifficulty("Normal");
          setName("Piranha");
      }
      /**
       * This method prints out the ascii art for the Piranha
       * 
       */
      public void enemy(){
    	  System.out.println("                              ,---");
          System.out.println("                      _    _,-'    `--,");
          System.out.println("                     ( `-,'            `\\");
          System.out.println("                      \\           ,    o \\");
          System.out.println("                      /   ,       ;       \\");
          System.out.println("                     (_,-' \\       `, _  \"\"/");
          System.out.println("                            `-,___ =='__,-'");
          System.out.println("                                  ````");
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
        	  System.out.println("Piranha uses BloodLust");
        	  dam = 0;
        	  System.out.println("It's attack increased.");
        	  System.out.println("Attack " + getAttack() + "-->");
        	  upAttack(getAttack()/2);
        	  System.out.print(getAttack()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Piranha uses Frenzy");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Piranha uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the kill message for the Piranha
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You make the Piranha into the most disappointing sushi.");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The piranha has gotten sick of your blood and leaves.");
          Thread.sleep(2000);
      }
}
