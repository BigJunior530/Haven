import java.util.Random;
/**
 * This class is used to make the Ram enemy
 * @author Carlos
 *
 */
public class Ram extends CharEntities{
      public static Random rand = new Random();
      /**
  	 * This is a constructor to make the Ram class
  	 * 
  	 * @param pc is the user class
  	 */
      public Ram(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack(5);
          setHealth(4);
          setDifficulty("Easy");
      }
      /**
       * This method prints out the ascii art for the Ram
       * 
       */
      public void enemy(){
    	  System.out.println("                   _.-..");
          System.out.println("                 ,'9 )\\)`-.,.--.");
          System.out.println("                 `-.|           `.");
          System.out.println("                     \\,      ,    \\)");
          System.out.println("                      `.  )._\\   (\\");
          System.out.println("                       |//   `-,//");
          System.out.println("                       ]||    //\"");
          System.out.println("                       \"\"    \"\"");
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
        	  System.out.println("Ram smashes his Horns into the wall");
        	  dam = 0;
        	  System.out.println("It's attack increased.");
        	  System.out.println("Attack " + getAttack() + "-->");
        	  upAttack(getAttack()/2);
        	  System.out.print(getAttack()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Ram uses Head Smash");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Ram uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the introduction for the Ram
       */
      public void intro() throws InterruptedException {
            Main.sleep500();
            Thread.sleep(1000);
            System.out.println("\n\nA Ram appeared!");
            System.out.println("Level: " + getLevel());
            System.out.println("Health: " + getHealth());
      }
      /**
       * This method prints out the kill message for the Ram
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You kill the Goat and watch its lifeless body fall down the side of the Moutain");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The ram starts to jump rock to rock, unable to keep up, it gets away.");
          Thread.sleep(2000);
      }
}
