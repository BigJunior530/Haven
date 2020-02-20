/**
 * This is an abstract class or super class meant to be used by all enemies
 * 
 * @author Carlos
 *
 */
public abstract class CharEntities{
      int health;
      int attack;
      int level;
      /**
       * This method is a basic form of how to set the enemy's level
       * 
       * @param enemy is the level of the User
       */
      public void setLevel(int enemy) {
    	  
    	  level = 1;
      }
      /**
       * This method is a basic form of how to set the enemies attack
       */
      public void setAttack() {
    	  attack = 1;
      }
      /**
       * This method is a basic form of how to set the enemies health
       */
      public void setHealth() {
    	 health = 1;
      }
      /**
       * This method will be unchanged and increases the health of the enemy when called
       * 
       * @param boost
       */
      public void upHealth(int boost) {
    	  if(boost + health > 10*level) {
    		  setHealth();
    	  }else {
    		  health = health + boost;
    	  }
      }
      /**
       * This method is just used to get the attack of the enemy
       * 
       * @return global variable attack
       */
      public int getAttack(){
            return this.attack;
      }
      /**
       * This method will be unchanged and increases the attack of the enemy when called
       * 
       * @param boost
       */
      public void upAttack(int boost) {
    	  
    	  attack = attack + boost;
      }
      /**
       * This is a basic form of the getMove method which just uses attack as the damage done
       * 
       */
      public int getMove(Protag pc) {
    	  return this.attack;
      }
      /**
       * This is a basic form of the design of the enemy
       */
      public void enemy(){
          System.out.println("          \\/");
          System.out.println("          /\\");
       }
      /**
       * This is a basic method to print out the introduction of the enemy
       * 
       * @throws InterruptedException
       */
      public void intro() throws InterruptedException{ 
    	  System.out.println("An Enemy aproaches");
      }
      /**
       * This method is made just to return the level
       * 
       * @return the level of the enemy
       */
      public int getLevel() {
    	  return level;
      }
      /**
       * This method is just meant to return the Health
       * 
       * @param <E> 
       * @return health of the enemy
       */
      public <E> int getHealth(){
            return health;
      }
      /**
       * This method is meant to decrease the health of the enemy when attacked
       * 
       * @param hurt is how much damage was received
       */
      public void damage(int hurt) {
    	  health = health - hurt;
      }
      /**
       * The enemy's death message when it diess
       * 
       * @throws InterruptedException
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("Yeet");
          Thread.sleep(2000);
      }
}
