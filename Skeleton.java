import java.util.Random;
/**
 * This class is used to make the Skeleton enemy
 * @author Carlos
 *
 */
public class Skeleton extends CharEntities{
	public static Random rand = new Random();
	/**
	 * This is a constructor to make the Skeleton class
	 * 
	 * @param pc is the user class
	 */
      public Skeleton(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack(5);
          setHealth(4);
          setDifficulty("Normal");
          setName("Skeleton");
      }
      /**
       * This method prints out the ascii art for the Skeleton
       * 
       */
      public void enemy(){
          System.out.println("                  .-.");
          System.out.println("                 (e.e)");
          System.out.println("                  (m)");
          System.out.println("                .-=\"=-.  W");
          System.out.println("               // =T= \\\\,/");
          System.out.println("              () ==|== ()");
          System.out.println("               \\  =V=");
          System.out.println("                M(oVo)");
          System.out.println("                 // \\\\");
          System.out.println("                //   \\\\");
          System.out.println("               ()     ()");
          System.out.println("                \\\\    ||");
          System.out.println("                 \'   '|");
          System.out.println("               ==\"     \"=="); 
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
        	  System.out.println("Skeleton uses Hone");
        	  dam = 0;
        	  System.out.println("It's attack increased.");
        	  System.out.println("Attack " + getAttack() + "-->");
        	  upAttack(getAttack()/2);
        	  System.out.print(getAttack()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Skeleton uses Bone Rattler");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Skeleton uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the kill message for the Skeleton
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You break every single bone like a twig until there wasn't another bone left.");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("You close your eyes for a second, when they open, only a couple bones on the floor, are you going crazy?");
          Thread.sleep(2000);
      }
}
