import java.util.Random;
/**
 * This class is used to make the Eagle enemy
 * @author Carlos
 *
 */
public class Eagle extends CharEntities{
      public static Random rand = new Random();
      /**
    	 * This is a constructor to make the Eagle class
    	 * 
    	 * @param pc is the user class
    	 */
      public Eagle(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack(6);
          setHealth(4);
          setDifficulty("Normal");
          setName("Eagle");
      }
      /**
       * This method prints out the ascii art for the Eagle
       * 
       */
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
        	  System.out.println("Eagle uses Feather Dance");
        	  dam = 0;
        	  System.out.println("It's attack doubled.");
        	  System.out.println("Attack " + getAttack() + "-->");
        	  upAttack(getAttack()/2);
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
      /**
       * This method prints out the kill message for the Eagle
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You rip the Eagle's heart out and are finally able to taste Freedom");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The Eagle believes in freedom, so it leaves to find some.");
          Thread.sleep(2000);
      }
}
