import java.util.Random;
/**
 * This is an abstract class or super class meant to be used by all enemies
 * 
 * @author Carlos
 *
 */
public abstract class CharEntities{
      int health;
      int totalHealth;
      int attack;
      int level;
      String difficulty;
      public static Random rand = new Random();
      /**
       * This method is how every animal's level is set
       * 
       * @param enemy is the level of the User
       */
      public void setLevel(int enemy) {
    	  level = (rand.nextInt(4)) + enemy;
      }
      /**
       * This method uses whatever stat is passed by the animals constructor and multiplies it by the level to get attack
       *
       * @param stat is the number passed by constructor
       */
      public void setAttack(int stat) {
    	  attack = stat*level;
      }
      /**
       * This method uses whatever stat is passed by the animals constructor and multiplies it by the level to get health
       *
       * @param stat is the number passed by constructor
       */
      public void setHealth(int stat) {
    	 health = stat*level;
      }
      /**
       * This method sets the difficulty of the animal to either easy, normal, hard depending on what is sent by the constructor
       *
       * @param stat is the diffculty passsed by the constructor
       */
      public void setDifficulty(String stat) {
    	  difficulty = stat;
      }
      /**
       * This method will be unchanged and increases the health of the enemy when called
       * 
       * @param boost
       */
      public void upHealth(int boost) {
    	  if(boost + health > 10*level) {
    		  health=totalHealth;
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
       * This method is just used to get the difficulty of the enemy
       * 
       * @return global variable difficulty
       */
      public String getDifficulty(){
            return difficulty;
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
       * This method is just meant to return the total Health
       * 
       * @param <E> 
       * @return totalHealth of the enemy
       */
      public <E> int getTotalHealth(){
            return totalHealth;
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
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("F*** this sh*t I'm out ");
          Thread.sleep(2000);
      }
      /**
       * This method uses level of difficulty and the level of the animal to determine the exp
       */
      public int getEXP() {
    	  switch(getDifficulty()) {
    	  	case "Easy":
    	  		return 3 + getLevel();
    	  	case "Normal":
    	  		return 6 + getLevel();
    	  	case "Hard":
    	  		return 9 + getLevel();
    	  	default:
    	  		return getLevel();
    	
    	  }
      }
}
