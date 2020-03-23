import java.util.Random;
/**
 * This class is used to make the Leviathan enemy
 * @author Carlos
 *
 */
public class Leviathan extends CharEntities{
      public static Random rand = new Random();
      /**
    	 * This is a constructor to make the Leviathan class
    	 * 
    	 * @param pc is the user class
    	 */
      public Leviathan(Protag pc){
    	  int enemy = pc.getLevel();
    	  setLevel(enemy);
          setAttack(10);
          setHealth(12);
          setDifficulty("Hard");
          setName("Leviathan");
      }
      /**
       * This method prints out the ascii art for the Leviathan
       * 
       */
      public void enemy(){
          System.out.println("                                   (,,(,");                   
          System.out.println("                                (,'     `(");                            
          System.out.println("                            ,  ,'  ,--.  `,");                                     
          System.out.println("                             `{D, {    \\  :");                                        
          System.out.println("                               V,,'    /  /");                                        
          System.out.println("                               j;;    /  ,' ,---.    ,---.      ,");                    
          System.out.println("                               \\;'   /  ,' /  _  \\  /  _  \\   ,'/");                    
          System.out.println("                                     \\   `'  / \\  `'  / \\  `.' / ");                    
          System.out.println("                                      `.___,'   `.__,'   `.__,'  ");
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
        	  System.out.println("Leviathan uses glare");
        	  dam = 0;
        	  System.out.println("You lost some shield");
        	  System.out.println("Shield " + pc.getShield() + "-->");
        	  pc.decreaseShieldTemp(4);
        	  System.out.print(pc.getShield()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Leviathan uses crunch");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Leviathan uses tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the kill message for the Leviathan
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You split the Leviathan straight down the middle.");
          Thread.sleep(2000);
          System.out.println("You realize this wasn't the best place.");
          Thread.sleep(2000);
          System.out.println("You leave the Lost City and wonder where to next");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The Leviathan ashamed of wasting its time, leaves in embarassment.");
          Thread.sleep(2000);
      }
}
