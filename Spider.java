import java.util.Random;
/**
 * This class is used to make the Spider enemy
 * @author Carlos
 *
 */
public class Spider extends CharEntities{
	public static Random rand = new Random();
	/**
	 * This is a constructor to make the Spider class
	 * 
	 * @param pc is the user class
	 */
      public Spider(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack(7);
          setHealth(3);
          setDifficulty("Normal");
          setName("Spider");
      }
      /**
       * This method prints out the ascii art for the Spider
       * 
       */
      public void enemy(){
          System.out.println("                     /      \\");
          System.out.println("                  \\  \\  ,,  /  /");
          System.out.println("                   '-.`\\()/`.-'");
          System.out.println("                  .--_'(  )'_--.");
          System.out.println("                 / /` /`\"\"`\\ `\\ \\");
          System.out.println("                  |  |  ><  |  |");
          System.out.println("                  \\  \\      /  /");
          System.out.println("                      '.__.'");
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
        	  System.out.println("Spider uses Fear");
        	  dam = 0;
        	  System.out.println("You become more fearlful... lose some attack");
        	  System.out.println("Attack " + pc.getAttack() + "-->");
        	  pc.decreaseAttackTemp(2);
        	  System.out.print(pc.getAttack()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Spider uses Venom");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Spider uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the kill message for the Spider
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You squish the spider like the bug that it isn't.");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The Spider crawls away, leaving you frightened as to where it might appear next.");
          Thread.sleep(2000);
      }
}
