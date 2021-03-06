import java.util.Random;
/**
 * This class is used to make the Alien enemy
 * @author Carlos
 *
 */
public class Alien extends CharEntities{
	public static Random rand = new Random();
	/**
	 * This is a constructor to make the Alien class
	 * 
	 * @param pc is the user class
	 */
      public Alien(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack(4);
          setHealth(4);
          setDifficulty("Easy");
          setName("Alien");
      }
      /**
       * This method prints out the ascii art for the Alien
       * 
       */
      public void enemy(){
    	  System.out.println("                                  .-.");
          System.out.println("                   .-\"\"`\"\"-.    |(@ @)");
          System.out.println("                _/`oOoOoOoOo`\\_ \\ \\-/");
          System.out.println("               '.-=-=-=-=-=-=-.' \\/ \\");
          System.out.println("                 `-=.=-.-=.=-'    \\ /\\");
          System.out.println("                    ^  ^  ^       _H_ \\");
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
        	  System.out.println("Alien uses Hypnosis");
        	  dam = pc.getAttack()/2;
        	  System.out.println("You got confused. Then punched yourself to get out of confusion");
          }else if(move == 1) {
        	  System.out.println("Alien uses Probe");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Alien uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the kill message for the Alien
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You slash the aliens into bits and jump out of the UFO back to the ocean");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The alien decides you were too boring of a subject and dump you out of the UFO");
          Thread.sleep(2000);
      }
}
