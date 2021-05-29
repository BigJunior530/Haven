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
      String name;
      public static Random rand = new Random();
      /**
       * This method sets the name of the animal to whatever the constructor passes
       *
       * @param stat is the name passed by the constructor
       */
      public void setName(String stat) {
    	  name = stat;
      }
      /**
       * This method is how every animal's level is set
       * 
       * @param enemy is the level of the User
       */
      public void setLevel(int enemy) {
    	  int bonus = 0;
    	  if(difficulty == "Hard") {
    		  bonus = 3;
    	  }else if(difficulty == "Normal") {
    		  bonus = 1;
    	  }
    	  level = (rand.nextInt(4)) + enemy + bonus;
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
       * @param stat is the difficulty passed by the constructor
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
       * This method is just used to get the name of the enemy
       * 
       * @return global variable difficulty
       */
      public String getName(){
            return name;
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
    	  Main.sleep500();
          Thread.sleep(1000);
    	  System.out.printf("\nA(n) %s appeared!\n", name);
    	  System.out.println("Level: " + getLevel());
          System.out.println("Health: " + getHealth());
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
    	  		return getLevel();
    	  	case "Normal":
    	  		return 3 + getLevel();
    	  	case "Hard":
    	  		return 9 + getLevel();
    	  	default:
    	  		return getLevel();
    	
    	  }
      }
}
/**
 * This class is used to make the Wild Boar enemy
 * @author Carlos
 *
 */
class WildBoar extends CharEntities{
      public static Random rand = new Random();
      /**
    	 * This is a constructor to make the Wild Boar class
    	 * 
    	 * @param pc is the user class
    	 */
      public WildBoar(Protag pc){
    	  int enemy = pc.getLevel();
          setDifficulty("Normal");
          setName("Wild Board");
          setLevel(enemy);
          setAttack(3);
          setHealth(6);
      }
      /**
       * This method prints out the ascii art for the Wild Boar
       * 
       */
      public void enemy(){
    	  System.out.println("                     __   __");
          System.out.println("                     \\/---\\/");
          System.out.println("                      ). .(");
          System.out.println("                     ( (\") )");
          System.out.println("                      )   (");
          System.out.println("                     /     \\ ");
          System.out.println("                    (       )`9");
          System.out.println("                   ( \\ /-\\ / )");
          System.out.println("                    w'W   W'w");
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
        	  System.out.println("Boar rolls in mud");
        	  dam = 0;
        	  System.out.println("It's healed some health.");
        	  System.out.println("Health " + getHealth() + "-->");
        	  upHealth(level);
        	  System.out.print(getHealth()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Boar uses Body Slam");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Boar uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the kill message for the Wild Boar
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You slice up the Boar and eat some good pork.");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The boar decides to look for its meerkat friend.");
          Thread.sleep(2000);
      }
}
/**
 * This class is used to make the Alien enemy
 * @author Carlos
 *
 */
class Alien extends CharEntities{
	public static Random rand = new Random();
	/**
	 * This is a constructor to make the Alien class
	 * 
	 * @param pc is the user class
	 */
      public Alien(Protag pc){
    	  int enemy = pc.getLevel();
          setDifficulty("Easy");
          setName("Alien");
          setLevel(enemy);
          setAttack(4);
          setHealth(4);
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
/**
 * This class is used to make the Chicken enemy
 * @author Carlos
 *
 */
class Chicken extends CharEntities{
	public static Random rand = new Random();
	/**
	 * This is a constructor to make the Chicken class
	 * 
	 * @param pc is the user class
	 */
      public Chicken(Protag pc){
    	  int enemy = pc.getLevel();
          setDifficulty("Easy");
          setName("Chicken");
          setLevel(enemy);
          setAttack(2);
          setHealth(2);
      }
      /**
       * This method prints out the ascii art for the Chicken
       * 
       */
      public void enemy(){
          System.out.println("             \\\\");
          System.out.println("             (o>");
          System.out.println("          \\\\_//)");
          System.out.println("           \\_/_)");
          System.out.println("            _|_ "); 
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
        	  System.out.println("Chicken uses Pluck");
        	  dam = 0;
        	  System.out.println("You lost some shield.");
        	  System.out.println("Shield " + pc.getShield() + "-->");
        	  pc.decreaseShieldTemp(4);
        	  System.out.print(pc.getShield()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Chicken uses Peck");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Chicken uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the kill message for the Chicken
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You absolutely love chicken for any meal.");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The Chicken scurries away, unable to catch it, you let it go.");
          Thread.sleep(2000);
      }
}
/**
 * This class is used to make the Chimpanzee enemy
 * @author Carlos
 *
 */
class Chimpanzee extends CharEntities{
      public static Random rand = new Random();
      /**
  	 * This is a constructor to make the Chimpanzee class
  	 * 
  	 * @param pc is the user class
  	 */
      public Chimpanzee(Protag pc){
    	  int enemy = pc.getLevel();
          setDifficulty("Normal");
          setName("Chimpanzee");
          setLevel(enemy);
          setAttack(4);
          setHealth(5);
      }
      /**
       * This method prints out the ascii art for the Chimpanzee
       * 
       */
      public void enemy(){
    	  System.out.println("            __");
          System.out.println("          (/00\\)");
          System.out.println("           \\--/");
          System.out.println("         \\/ [] \\/");
          System.out.println("            []/");
          System.out.println("          _|  |_");
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
        	  System.out.println("Chimpanzee uses Poop Throw");
        	  dam = 0;
        	  System.out.println("You lost some shield");
        	  System.out.println("Shield " + pc.getShield() + "-->");
        	  pc.downgradeShield(1);
        	  System.out.print(pc.getShield()+ "\n");
        	  
          }else if(move == 1) {
        	  System.out.println("Chimpanzee uses both arms to smash against your body");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Chimpanzee uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the kill message for the Chimpanzee
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You stab the Chimp against the tree and head back into the Jungle");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The Chimpanzee decided this isn't worth a banana.");
          Thread.sleep(2000);
      }
}
/**
 * This class is used to make the Dragon enemy
 * @author Carlos
 *
 */
class Dragon extends CharEntities{
	public static Random rand = new Random();
	/**
	 * This is a constructor to make the Dragon class
	 * 
	 * @param pc is the user class
	 */
      public Dragon(Protag pc){
    	  int enemy = pc.getLevel();
          setDifficulty("Hard");
          setName("Dragon");
          setLevel(enemy);
          setAttack(10);
          setHealth(10);
      }
      /**
       * This method prints out the ascii art for the Dragon
       * 
       */
      public void enemy(){
          System.out.println("                               _ _");
          System.out.println("                        _     //` `\\");
          System.out.println("                    _,-\"\\%   // /``\\`\\");
          System.out.println("               ~^~ >__^  |% // /  } `\\`\\");
          System.out.println("                      )  )%// / }  } }`\\`\\");
          System.out.println("                     /  (%/'/.\\_/\\_/\\_/\\`/");
          System.out.println("                    (    '         `-._`");
          System.out.println("                     \\   ,     (  \\   _`-.__.-;%>");
          System.out.println("                    /_`\\ \\      `\\ \\.\" `-..-'`");
          System.out.println("                   ``` /_/`\"-=-'`/_/");
          System.out.println("                       ```       ```");
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
        	  System.out.println("Dragon uses HeatWave");
        	  dam = 0;
        	  System.out.println("Its attack increased");
        	  System.out.println("Attack " + getAttack() + "-->");
        	  upAttack(getAttack()/2);
        	  System.out.print(getAttack()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Dragon uses Volcanic Ash");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Dragon uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the kill message for the Dragon
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You chop off the Dragon's head and use it as a trophy.");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The Dragon flies away uninterested by your presence.");
          Thread.sleep(2000);
      }
}
/**
 * This class is used to make the Duck enemy
 * @author Carlos
 *
 */
class Duck extends CharEntities{
	public static Random rand = new Random();
	/**
	 * This is a constructor to make the Duck class
	 * 
	 * @param pc is the user class
	 */
      public Duck(Protag pc){
    	  int enemy = pc.getLevel();
          setDifficulty("Easy");
          setName("Duck");
          setLevel(enemy);
          setAttack(3);
          setHealth(3);
      }
      /**
       * This method prints out the ascii art for the Duck
       * 
       */
      public void enemy(){
          System.out.println("                 ,~~.");
          System.out.println("                (  6 )-_,");
          System.out.println("           (\\___ )=='-'");
          System.out.println("            \\ .   ) )");
          System.out.println("             \\ `-' /");    
          System.out.println("          ~'`~'`~'`~'`~");
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
        	  System.out.println("Duck uses Pluck");
        	  dam = 0;
        	  System.out.println("You lost some shield.");
        	  System.out.println("Shield " + pc.getShield() + "-->");
        	  pc.decreaseShieldTemp(4);
        	  System.out.print(pc.getShield()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Duck uses Water Gun");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Duck uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the kill message for the Duck
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You've never had  duck for dinner before.");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The Duck dives flies away, too bad you're not range.");
          Thread.sleep(2000);
      }
}
/**
 * This class is used to make the Eagle enemy
 * @author Carlos
 *
 */
class Eagle extends CharEntities{
      public static Random rand = new Random();
      /**
    	 * This is a constructor to make the Eagle class
    	 * 
    	 * @param pc is the user class
    	 */
      public Eagle(Protag pc){
    	  int enemy = pc.getLevel();
          setDifficulty("Normal");
          setName("Eagle");
          setLevel(enemy);
          setAttack(6);
          setHealth(4);
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
/**
 * This class is used to make the Flying Squirrel enemy
 * @author Carlos
 *
 */
class FlyingSquirrel extends CharEntities{
      public static Random rand = new Random();
      /**
  	 * This is a constructor to make the Flying Squirrel class
  	 * 
  	 * @param pc is the user class
  	 */
      public FlyingSquirrel(Protag pc){
    	  int enemy = pc.getLevel();
          setDifficulty("Easy");
          setName("Flying Squirrel");
          setLevel(enemy);
          setAttack(2);
          setHealth(4);
      }
      /**
       * This method prints out the ascii art for the Flying Squirrel
       * 
       */
      public void enemy(){
    	  System.out.println("              (\\__/)  .~    ~. ))");
          System.out.println("              /O O `./      .'");
          System.out.println("             {O__,   \\    {");
          System.out.println("              / .  . )    \\");
          System.out.println("              |-| '-' \\    } ))");
          System.out.println("             .(   _(   )_.'");
          System.out.println("            '---.~_ _ _&");
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
        	  System.out.println("Squirell uses Fluffy Tail");
        	  dam = 0;
        	  System.out.println("You kind of don't want to hurt it now.");
        	  System.out.println("You lost some attack");
        	  System.out.println("Attack " + pc.getAttack() + "-->");
        	  pc.decreaseAttackTemp(2);
        	  System.out.print(pc.getAttack()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Squirrel uses Pierce");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Squirrel uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
    /**
     * This method prints out the kill message for the Flying Squirrel
     */
    public void endMessage() throws InterruptedException{
  	  System.out.println("You rip off the extra skin making it into just a normal squirrel.");
        Thread.sleep(2000);
    }
    /**
     * The enemy's message when it decides to leave
     * 
     * @throws InterruptedException
     */
    public void leaveMessage() throws InterruptedException{
  	  System.out.println("The flying Squirrel does what it does best, glides away.");
        Thread.sleep(2000);
    }
}
/**
 * This class is used to make the Fox enemy
 * @author Carlos
 *
 */
class Fox extends CharEntities{
      public static Random rand = new Random();
      /**
  	 * This is a constructor to make the Fox class
  	 * 
  	 * @param pc is the user class
  	 */
      public Fox(Protag pc){
    	  int enemy = pc.getLevel();
          setDifficulty("Normal");
          setName("Fox");
          setLevel(enemy);
          setAttack(6);
          setHealth(4);
      }
      /**
       * This method prints out the ascii art for the Fox
       * 
       */
      public void enemy(){
    	  System.out.println("                          /^._");
          System.out.println("            ,___,--~~~~--' /'~");
          System.out.println("            `~--~\\ )___,)/'");
          System.out.println("                (/\\\\_  (/\\\\_");
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
        	  System.out.println("Fox uses Fluffy Tail");
        	  dam = 0;
        	  System.out.println("You kind of don't want to hurt it now.");
        	  System.out.println("You lost some attack");
        	  System.out.println("Attack " + pc.getAttack() + "-->");
        	  pc.decreaseAttackTemp(2);
        	  System.out.print(pc.getAttack()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Fox uses Bite");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Fox uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the kill message for the Fox
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You kill the fox and cut off its tail as a trophy.");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The fox jumps into one of its holes and doesn't come back out.");
          Thread.sleep(2000);
      }
}

/**
 * This class is used to make the Frog enemy
 * @author Carlos
 *
 */
class Frog extends CharEntities{
      public static Random rand = new Random();
      /**
  	 * This is a constructor to make the Frog class
  	 * 
  	 * @param pc is the user class
  	 */
      public Frog(Protag pc){
    	  int enemy = pc.getLevel();
          setDifficulty("Easy");
          setName("Frog");
          setLevel(enemy);
          setAttack(6);
          setHealth(4);
      }
      /**
       * This method prints out the ascii art for the Frog
       * 
       */
      public void enemy(){
    	  System.out.println("                      _   _");
          System.out.println("                     (.)_(.)");
          System.out.println("                  _ (   _   ) _");
          System.out.println("                 / \\/`-----'\\/ \\");
          System.out.println("               __\\ ( (     ) ) /__");
          System.out.println("               )   /\\ \\._./ /\\   (");
          System.out.println("                )_/ /|\\   /|\\ \\_(");
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
        	  System.out.println("Frog uses slime");
        	  dam = 0;
        	  System.out.println("It's healed some health.");
        	  System.out.println("Health " + getHealth() + "-->");
        	  upHealth(level);
        	  System.out.print(getHealth()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Frog uses its Tongue");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Frog uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the kill message for the Frog
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You cut the Frogs legs off and tongue making it useless.");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The frog jumps, hits your face one last time, and escapes into the nearby body of water.");
          Thread.sleep(2000);
      }
}
/**
 * This class is used to make the Golem enemy
 * @author Carlos
 *
 */
class Golem extends CharEntities{
	public static Random rand = new Random();
	/**
	 * This is a constructor to make the Golem class
	 * 
	 * @param pc is the user class
	 */
      public Golem(Protag pc){
    	  int enemy = pc.getLevel();
          setDifficulty("Normal");
          setName("Golem");
          setLevel(enemy);
          setAttack(4);
          setHealth(7);
      }
      /**
       * This method prints out the ascii art for the Golem
       * 
       */
      public void enemy(){
          System.out.println("              (o)(o)");
          System.out.println("            w\"      \"w");
          System.out.println("           W  -====-  W");
          System.out.println("            \"w      w\"");
          System.out.println("           w\"\"\"\"\"\"\"\"\"\"w");
          System.out.println("          W            W");
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
        	  System.out.println("Golem uses Clay Hardening");
        	  dam = 0;
        	  System.out.println("It healed itself.");
        	  System.out.println("Health " + getHealth() + "-->");
        	  upHealth(level);
        	  System.out.print(getHealth()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Golem uses Crush");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Golem uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the kill message for the Golem
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You destroy the golem back into bits of clay.");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The golem decides you aren't really a threat and turns back into clay.");
          Thread.sleep(2000);
      }
}
/**
 * This class is used to make the Hydra enemy
 * @author Carlos
 *
 */
class Hydra extends CharEntities{
      public static Random rand = new Random();
      /**
  	 * This is a constructor to make the Hydra class
  	 * 
  	 * @param pc is the user class
  	 */
      public Hydra(Protag pc){
    	  int enemy = pc.getLevel();
          setDifficulty("Hard");
          setName("Hydra");
          setLevel(enemy);
          setAttack(7);
          setHealth(9);
      }
      /**
       * This method prints out the ascii art for the Hydra
       * 
       */
      public void enemy(){
    	  System.out.println("                      __   __  __");
          System.out.println("                     |\"|  |\"| |\"|");
          System.out.println("                       \\   |   /");
          System.out.println("                        \\  |  /");
          System.out.println("                         \\ | /");
          System.out.println("                         (   )");
          System.out.println("                        (     )");
          System.out.println("                       (       )");
          System.out.println("                         W   W");
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
        	  System.out.println("Hydra grows another head");
        	  dam = 0;
        	  System.out.println("It's attack increased.");
        	  System.out.println("Attack " + getAttack() + "-->");
        	  upAttack(getAttack()/2);
        	  System.out.print(getAttack()+ "\n");
          }else if(move == 1) {
        	  System.out.println("All of Hydras heads attacked");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Hydra uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the kill message for the Hydra
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("Finally realizing slashing its head off weren't a good idea.");
          Thread.sleep(2000);
          System.out.println("You finally kill the beast");
          Thread.sleep(2000);
          System.out.println("You realize this wasn't the best place.");
          Thread.sleep(2000);
          System.out.println("You hope you never have to come back and sail back to land");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("Realizing you're insignificance, the hydra delves back into the ocean.");
          Thread.sleep(2000);
      }
}
/**
 * This class is used to make the JellyFish enemy
 * @author Carlos
 *
 */
class JellyFish extends CharEntities{

      public static Random rand = new Random();
      /**
  	 * This is a constructor to make the JellyFish class
  	 * 
  	 * @param pc is the user class
  	 */
      public JellyFish(Protag pc){
    	  int enemy = pc.getLevel();
          setDifficulty("Normal");
          setName("JellyFish");
          setLevel(enemy);
          setAttack(5);
          setHealth(3);
      }
      /**
       * This method prints out the ascii art for the JellyFish
       * 
       */
      public void enemy(){
    	  System.out.println("                     .-;':':'-.");
          System.out.println("                    {'.'.'.'.'.}");
          System.out.println("                     )        '`.");
          System.out.println("                    '-. ._ ,_.-='");
          System.out.println("                      `). ( `);(");
          System.out.println("                      ('. .)(,'.)");
          System.out.println("                       ) ( ,').(");
          System.out.println("                      ( .').'(').");
          System.out.println("                      .) (' ).('");
          System.out.println("                       '  ) (  ).");
          System.out.println("                        .'( .)'");
          System.out.println("                          .).'");
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
        	  System.out.println("JellyFish uses Paralyze");
        	  dam = 0;
        	  System.out.println("You lost some shield");
        	  System.out.println("Shield " + pc.getShield() + "-->");
        	  pc.decreaseShieldTemp(4);
        	  System.out.print(pc.getShield()+ "\n");
          }else if(move == 1) {
        	  System.out.println("JellyFish uses Poison Sting");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("JellyFish uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the kill message for the JellyFish
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You slice the JellyFish up into bits and make your own 'Jelly'");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The Jellyfish, unamused by your actions, floats back down as you see its glow slowly dissapate.");
          Thread.sleep(2000);
      }
}
/**
 * This class is used to make the Koi Fish enemy
 * @author Carlos
 *
 */
class KoiFish extends CharEntities{
      public static Random rand = new Random();
      /**
  	 * This is a constructor to make the Koi Fish class
  	 * 
  	 * @param pc is the user class
  	 */
      public KoiFish(Protag pc){
    	  int enemy = pc.getLevel();
          setDifficulty("Normal");
          setName("Koi Fish");
          setLevel(enemy);
          setAttack(2);
          setHealth(6);
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
/**
 * This class is used to make the Komodo Dragon enemy
 * @author Carlos
 *
 */
class Komodo extends CharEntities{
      public static Random rand = new Random();
      /**
  	 * This is a constructor to make the Komodo Dragon class
  	 * 
  	 * @param pc is the user class
  	 */
      public Komodo(Protag pc){
    	  int enemy = pc.getLevel();
          setDifficulty("Hard");
          setName("Komodo Dragon");
          setLevel(enemy);
          setAttack(8);
          setHealth(7);
      }
      /**
       * This method prints out the ascii art for the Komodo Dragon
       * 
       */
      public void enemy(){
    	  System.out.println("                                  )/_");
          System.out.println("                         _.--..---\"-,--c_");
          System.out.println("                    \\L..'           ._O__)_");
          System.out.println("            ,-.     _.+  _  \\..--( /");
          System.out.println("              `\\.-''__.-' \\ (     \\_");
          System.out.println("                `'''       `\\__   /\\");
          System.out.println("                            ')");
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
        	  System.out.println("Komodo Dragon uses Sand attack");
        	  dam = 0;
        	  System.out.println("You lost some shield");
        	  System.out.println("Shield " + pc.getShield() + "-->");
        	  pc.decreaseShieldTemp(4);
        	  System.out.print(pc.getShield()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Komodo Dragon uses Acid Spit");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Komodo Dragan uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the kill message for the Komodo Dragon
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You stab the Komodo Dragon until you can't tell what's the head and whats the tail is anymore.");
          Thread.sleep(2000);
          System.out.println("You realize this wasn't the best place.");
          Thread.sleep(2000);
          System.out.println("You leave the desert and wonder where to next");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The komodo dragon hoping you die of its poison, leaves to finish your corpse later.");
          Thread.sleep(2000);
      }
}
/**
 * This class is used to make the Kraken enemy
 * @author Carlos
 *
 */
class Kraken extends CharEntities{
      public static Random rand = new Random();
      /**
  	 * This is a constructor to make the Kraken class
  	 * 
  	 * @param pc is the user class
  	 */
      public Kraken(Protag pc){
    	  int enemy = pc.getLevel();
          setDifficulty("Normal");
          setName("Kraken");
          setLevel(enemy);
          setAttack(5);
          setHealth(7);
      }
      /**
       * This method prints out the ascii art for the Kraken
       * 
       */
      public void enemy(){
    	  System.out.println("                       .'-'.");
          System.out.println("                   .  (  o O)");
          System.out.println("                    \\_ `  _,   _");
          System.out.println("                 -.___'.) ( ,-'");
          System.out.println("                      '-.O.'-..-..");
          System.out.println("                  ./\\/\\/ | \\_.-._");
          System.out.println("                         ;");
          System.out.println("                      ._/");
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
        	  System.out.println("Kraken Submerges itself");
        	  dam = 0;
        	  System.out.println("It's healed some health.");
        	  System.out.println("Health " + getHealth() + "-->");
        	  upHealth(level);
        	  System.out.print(getHealth()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Kraken uses Tsunami");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Kraken uses Smack");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the kill message for the Kraken
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You cut the last tentacle of the kraken and let it sink back into the ocean");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("Kraken lets go of your boat, inks away from you.");
          Thread.sleep(2000);
      }
}
/**
 * This class is used to make the Leviathan enemy
 * @author Carlos
 *
 */
class Leviathan extends CharEntities{
      public static Random rand = new Random();
      /**
    	 * This is a constructor to make the Leviathan class
    	 * 
    	 * @param pc is the user class
    	 */
      public Leviathan(Protag pc){
    	  int enemy = pc.getLevel();
          setDifficulty("Hard");
          setName("Leviathan");
          setLevel(enemy);
          setAttack(10);
          setHealth(12);
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
/**
 * This class is used to make the Loch Ness Monster enemy
 * @author Carlos
 *
 */
class LochNess extends CharEntities{
	public static Random rand = new Random();
	/**
	 * This is a constructor to make the Loch Ness Monster class
	 * 
	 * @param pc is the user class
	 */
      public LochNess(Protag pc){
    	  int enemy = pc.getLevel();
          setDifficulty("Hard");
          setName("Loch Ness Monster");
          setLevel(enemy);
          setAttack(8);
          setHealth(10);
      }
      /**
       * This method prints out the ascii art for the Loch Ness Monster
       * 
       */
      public void enemy(){
          System.out.println("                                    _   _       _a_a");
          System.out.println("                        _   _     _{.`=`.}_    {/ ''\\_");
          System.out.println("                  _    {.`'`.}   {.'  _  '.}  {|  ._oo)");
          System.out.println("                 { \\  {/ .-. \\} {/  .' '.  \\} {/  |  ");
          System.out.println("          ~^~~^~`~^~`~^~`~^~`~^~^~`^~^~`^~^~^~^~^~^~`^~~`");
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
        	  System.out.println("Loch Ness Monster uses Enigma");
        	  dam = pc.getAttack()/2;
        	  System.out.println("You hurt yourself in confusion");
          }else if(move == 1) {
        	  System.out.println("Loch Ness Monster uses Tsunami");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Loch Ness Monster uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the kill message for the Loch Ness Monster
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You think this monster wasn't worth being a legend, leaving its corpse on a log.");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The Loch Ness Monster heads back deep into the lake, never to be seen again.");
          Thread.sleep(2000);
      }
}
/**
 * This class is used to make the Mermaid enemy
 * @author Carlos
 *
 */
class Mermaid extends CharEntities{
      public static Random rand = new Random();
      /**
    	 * This is a constructor to make the Mermaid class
    	 * 
    	 * @param pc is the user class
    	 */
      public Mermaid(Protag pc){
    	  int enemy = pc.getLevel();
          setDifficulty("Easy");
          setName("Mermaid");
          setLevel(enemy);
          setAttack(3);
          setHealth(5);
      }
      /**
       * This method prints out the ascii art for the Mermaid
       * 
       */
      public void enemy(){
    	  System.out.println("                                               .-\"\"-.");
          System.out.println("                                              (___/\\ \\");
          System.out.println("                           ,                 (|^ ^ ) )");
          System.out.println("                          /(                _)_\\=_/  (");
          System.out.println("                    ,..__/ `\\          ____(_/_ ` \\   )");
          System.out.println("                     `\\    _/        _/---._/(_)_  `\\ (");
          System.out.println("                       '--\\ `-.__..-'    /.    (_), |  )");
          System.out.println("                           `._        ___\\_____.'_| |__/");
          System.out.println("                              `~----\"`   `-.........'");
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
        	  System.out.println("Mermaid uses Song");
        	  dam = pc.getAttack()/2;
        	  System.out.println("You're body slowing started walking by itself towads the Mermaid. You stabbed youself to Stop.");
          }else if(move == 1) {
        	  System.out.println("Mermaid uses drown");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Mermaid uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the kill message for the Mermaid
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You split the mermaid cleanly in half, seperating the human from fish");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The Mermaid, now looking at you more closely, realizes it wants nothing to do with you and swims away.");
          Thread.sleep(2000);
      }
}
/**
 * This class is used to make the Mountain Lion enemy
 * @author Carlos
 *
 */
class MountainLion extends CharEntities{
      public static Random rand = new Random();
      /**
    	 * This is a constructor to make the Mountain Lion class
    	 * 
    	 * @param pc is the user class
    	 */
      public MountainLion(Protag pc){
    	  int enemy = pc.getLevel();
          setDifficulty("Hard");
          setName("Mountain Lion");
          setLevel(enemy);
          setAttack(8);
          setHealth(8);
      }
      /**
       * This method prints out the ascii art for the Mountain Lion
       * 
       */
      public void enemy(){
    	  System.out.println("                 (\"`-''-/\").___..--''\"`-._");
          System.out.println("                  `6_ 6  )   `-.  (     ).`-.__.`)");
          System.out.println("                  (_Y_.)'  ._   )  `._ `. ``-..-'");
          System.out.println("                _..`--'_..-_/  /--'_.' ,'");
          System.out.println("               (il),-''  (li),'  ((!.-' ");
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
        	  System.out.println("Mountain Lion used Sharpen claw");
        	  dam = 0;
        	  System.out.println("It's attack increased.");
        	  System.out.println("Attack " + getAttack() + "-->");
        	  upAttack(getAttack()/2);
        	  System.out.print(getAttack()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Moutain Lion uses Mangle");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Mountain Lion uses Pounce");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the kill message for the Mountain Lion
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You slash off the bottom jaw, watching the blood drain from its mouth");
          Thread.sleep(2000);
          System.out.println("You realize this wasn't the best place.");
          Thread.sleep(2000);
          System.out.println("You leave the Moutain and wonder where to next");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The Mountain Lion seeing something far more interesting in the distance, leaves.");
          Thread.sleep(2000);
      }
}
/**
 * This class is used to make the Mummy enemy
 * @author Carlos
 *
 */
class Mummy extends CharEntities{
	public static Random rand = new Random();
	/**
	 * This is a constructor to make the Mummy class
	 * 
	 * @param pc is the user class
	 */
      public Mummy(Protag pc){
    	  int enemy = pc.getLevel();
          setDifficulty("Easy");
          setName("Mummy");
          setLevel(enemy);
          setAttack(4);
          setHealth(3);
      }
      /**
       * This method prints out the ascii art for the Mummy
       * 
       */
      public void enemy(){
          System.out.println("                    .--.");
          System.out.println("                   | = o\\");
          System.out.println("                   \\= =_/");
          System.out.println("                    )= \\____");
          System.out.println("                   ; = _|__-\\");
          System.out.println("                   |= ----.\\");
          System.out.println("                   ('.==|");
          System.out.println("                   / \\=\\=\\");
          System.out.println("                _.'  /=/\\=\\_");
          System.out.println("          __..-'    /__) \\__)");
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
        	  System.out.println("Mummy uses Rebandage");
        	  dam = 0;
        	  System.out.println("It healed itself");
        	  System.out.println("Health " + getHealth() + "-->");
        	  upHealth(level);
        	  System.out.print(getHealth()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Mummy uses Pharoah's Demise");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Mummy uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the kill message for the Mummy
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You finally finish killing it off, leaving only blood soaked paper.");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The Mummy decides to lay back down and doesn't wake back up.");
          Thread.sleep(2000);
      }
}
/**
 * This class is used to make the Ogre enemy
 * @author Carlos
 *
 */
class Ogre extends CharEntities{
	public static Random rand = new Random();
	/**
	 * This is a constructor to make the Ogre class
	 * 
	 * @param pc is the user class
	 */
      public Ogre(Protag pc){
    	  int enemy = pc.getLevel();
          setDifficulty("Hard");
          setName("Ogre");
          setLevel(enemy);
          setAttack(9);
          setHealth(9);
      }
      /**
       * This method prints out the ascii art for the Ogre
       * 
       */
      public void enemy(){
          System.out.println("              (o)(o)");
          System.out.println("            w\"      \"w");
          System.out.println("           W  -====-  W");
          System.out.println("            \"w      w\"");
          System.out.println("           w\"\"\"\"\"\"\"\"\"\"w");
          System.out.println("          W            W");
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
        	  System.out.println("Ogre uses Mud");
        	  dam = 0; 
        	  System.out.println("It healed itself.");
        	  System.out.println("Health " + getHealth() + "-->");
        	  upHealth(level);
        	  System.out.print(getHealth()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Ogre uses Crush");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Ogre uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the kill message for the Ogre
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You kill the beast and yell \"This is my Swamp.\"");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The Ogre unafflicted by your weak attacks, walks away.");
          Thread.sleep(2000);
      }
}
/**
 * This class is used to make the Owl enemy
 * @author Carlos
 *
 */
class Owl extends CharEntities{
      public static Random rand = new Random();
      /**
    	 * This is a constructor to make the Owl class
    	 * 
    	 * @param pc is the user class
    	 */
      public Owl(Protag pc){
    	  int enemy = pc.getLevel();
          setDifficulty("Easy");
          setName("Owl");
          setLevel(enemy);
          setAttack(5);
          setHealth(4);
      }
      /**
       * This method prints out the ascii art for the Owl
       * 
       */
      public void enemy(){
    	  System.out.println("            , _ ,");
          System.out.println("           ( o o )");
          System.out.println("          /'` ' `'\\");
          System.out.println("          |'''''''|");
          System.out.println("          |\\\\'''//|");
          System.out.println("             \"\"\"");
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
        	  System.out.println("Owl spun its head");
        	  dam = pc.getAttack()/2;
        	  System.out.println("You got confused and tried to twist your own head.");
          }else if(move == 1) {
        	  System.out.println("Owl used its Talons");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Owl uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the kill message for the Owl
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You decapitated the Owl after it turned its head again");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The Owl flies high in the air, minutes later you realize its not returning.");
          Thread.sleep(2000);
      }
}
/**
 * This class is used to make the Panther enemy
 * @author Carlos
 *
 */
class Panther extends CharEntities{
      public static Random rand = new Random();
      /**
    	 * This is a constructor to make the Panther class
    	 * 
    	 * @param pc is the user class
    	 */
      public Panther(Protag pc){
    	  int enemy = pc.getLevel();
          setDifficulty("Hard");
          setName("Panther");
          setLevel(enemy);
          setAttack(7);
          setHealth(9);
      }
      /**
       * This method prints out the ascii art for the Panther
       * 
       */
      public void enemy(){
    	  System.out.println("                 (\"`-''-/\").___..--''\"`-._");
          System.out.println("                  `6_ 6  )   `-.  (     ).`-.__.`)");
          System.out.println("                  (_Y_.)'  ._   )  `._ `. ``-..-'");
          System.out.println("                _..`--'_..-_/  /--'_.' ,'");
          System.out.println("               (il),-''  (li),'  ((!.-' ");
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
        	  System.out.println("Panther prepares to pounce");
        	  dam = 0;
        	  System.out.println("It's attack increased.");
        	  System.out.println("Attack " + getAttack() + "-->");
        	  upAttack(getAttack()/2);
        	  System.out.print(getAttack()+ "\n");
          }else if(move == 1) {
          }else if(move == 1) {
        	  System.out.println("Panther uses Maul");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Panther uses Pounce");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the kill message for the Panther
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You slash the final blow against the Panther straight into its skull");
          Thread.sleep(2000);
          System.out.println("You realize this wasn't the best place.");
          Thread.sleep(2000);
          System.out.println("You leave the Jungle and wonder where to next");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The Panther decides there are better places to hide from the storm.");
          Thread.sleep(2000);
      }
}
/**
 * This class is used to make the Penguin enemy
 * @author Carlos
 *
 */
class Penguin extends CharEntities{
      public static Random rand = new Random();
      /**
    	 * This is a constructor to make the Penguin class
    	 * 
    	 * @param pc is the user class
    	 */
      public Penguin(Protag pc){
    	  int enemy = pc.getLevel();
          setDifficulty("Normal");
          setName("Penguin");
          setLevel(enemy);
          setAttack(2);
          setHealth(6);
      }
      /**
       * This method prints out the ascii art for the Penguin
       * 
       */
      public void enemy(){
    	  System.out.println("                  .___.");
          System.out.println("                 /     \\");
          System.out.println("                | O _ O |");
          System.out.println("                /  \\_/  \\ ");
          System.out.println("              .' /     \\ `.");
          System.out.println("             / _|       |_ \\");
          System.out.println("            (_/ |       | \\_)");
          System.out.println("                \\       /");
          System.out.println("               __\\_>-<_/__");
          System.out.println("               ~;/     \\;~");
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
        	  System.out.println("Penguin uses Happy Feet");
        	  dam = 0;
        	  System.out.println("You kind of don't want to hurt it now.");
        	  System.out.println("You lost some attack");
        	  System.out.println("Attack " + pc.getAttack() + "-->");
        	  pc.decreaseAttackTemp(2);
        	  System.out.print(pc.getAttack()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Penguin uses Drill  Peck");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Penguin uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the kill message for the Penguin
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You slit open the Penguin and let it get covered by the now heavy snow");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The penguin slides towards you but misses and falls back into its hole.");
          Thread.sleep(2000);
      }
}
/**
 * This class is used to make the Piranha enemy
 * @author Carlos
 *
 */
class Piranha extends CharEntities{
      public static Random rand = new Random();
      /**
    	 * This is a constructor to make the Piranha class
    	 * 
    	 * @param pc is the user class
    	 */
      public Piranha(Protag pc){
    	  int enemy = pc.getLevel();
          setDifficulty("Normal");
          setName("Piranha");
          setLevel(enemy);
          setAttack(5);
          setHealth(4);
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
/**
 * This class is used to make the Polar Bear enemy
 * @author Carlos
 *
 */
class PolarBear extends CharEntities{
      public static Random rand = new Random();
      /**
  	 * This is a constructor to make the Polar Bear class
  	 * 
  	 * @param pc is the user class
  	 */
      public PolarBear(Protag pc){
    	  int enemy = pc.getLevel();
          setDifficulty("Hard");
          setName("Polar Bear");
          setLevel(enemy);
          setAttack(8);
          setHealth(11);
      }
      /**
       * This method prints out the ascii art for the Polar Bear
       * 
       */
      public void enemy(){
    	  System.out.println("                     ..------~~~--.__");
          System.out.println("                   /               c~\\");
          System.out.println("                   /             \\__ `\\");
          System.out.println("                   |  /~~--__/  /'\\ ~~'");
          System.out.println("                  /'/'\\ |    | |`\\ \\_");
          System.out.println("                 `-))  `-))  `-)) `-))");
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
        	  System.out.println("Polar Bear uses its thick fur to warm itself up.");
        	  dam = 0;
        	  System.out.println("It's healed some health.");
        	  System.out.println("Health " + getHealth() + "-->");
        	  upHealth(level);
        	  System.out.print(getHealth()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Polar Bear smashes its paws against the Ice to completely shatter the Ice under you");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Polar Bear uses Strike");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the kill message for the Polar Bear
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You stab the Bear through its chest and watch it fall to the ground.");
          Thread.sleep(2000);
          System.out.println("The only see white with a large red puddle");
          Thread.sleep(2000);
          System.out.println("You realize this wasn't the best place.");
          Thread.sleep(2000);
          System.out.println("You leave the Tundra and wonder where to next");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The polar bear gets bored and wanders away.");
          Thread.sleep(2000);
      }
}
/**
 * This class is used to make the Poseidon enemy
 * @author Carlos
 *
 */
class Poseidon extends CharEntities{
      public static Random rand = new Random();
      /**
  	 * This is a constructor to make the Poseidon class
  	 * 
  	 * @param pc is the user class
  	 */
      public Poseidon(Protag pc){
    	  int enemy = pc.getLevel();
          setDifficulty("Normal");
          setName("Poseidon");
          setLevel(enemy);
          setAttack(5);
          setHealth(7);
      }
      /**
       * This method prints out the ascii art for the Poseidon
       * 
       */
      public void enemy(){
    	  System.out.println("                     |      ,sss.");
          System.out.println("                   | | |    $^,^$");
          System.out.println("                   |_|_|   _/$$$\\_");
          System.out.println("                     |   /'  ?$?  `.");
          System.out.println("                     ;,-' /\\ ,, /. |");
          System.out.println("                     '-./' ;    ;: |");
          System.out.println("                     |     |`  '|`,;");
          System.out.println("                   ~~~~~~~~~~~~~~~~~~~~");
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
        	  System.out.println("Poseidon used Wrath");
        	  dam = 0;
        	  System.out.println("It's attack increased.");
        	  System.out.println("Attack " + getAttack() + "-->");
        	  upAttack(getAttack()/2);
        	  System.out.print(getAttack()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Poseidon used Tsunami");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Poseidon used surf");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the kill message for the Poseidon
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You use Poseidon's Trident to turn him into a Fish(Shish) Kebab");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("Poseidon doesn't understand why it bothered with such a weak mortal and dives back into the Ocean.");
          Thread.sleep(2000);
      }
}
/**
 * This class is used to make the Ram enemy
 * @author Carlos
 *
 */
class Ram extends CharEntities{
      public static Random rand = new Random();
      /**
  	 * This is a constructor to make the Ram class
  	 * 
  	 * @param pc is the user class
  	 */
      public Ram(Protag pc){
    	  int enemy = pc.getLevel();
          setDifficulty("Easy");
          setName("Ram");
          setLevel(enemy);
          setAttack(5);
          setHealth(4);
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
/**
 * This class is used to make the Rattle Snake enemy
 * @author Carlos
 *
 */
class RattleSnake extends CharEntities{
      public static Random rand = new Random();
      /**
  	 * This is a constructor to make the Rattle Snake class
  	 * 
  	 * @param pc is the user class
  	 */
      public RattleSnake(Protag pc){
    	  int enemy = pc.getLevel();
          setDifficulty("Normal");
          setName("Rattle Snake");
          setLevel(enemy);
          setAttack(8);
          setHealth(5);
      }
      /**
       * This method prints out the ascii art for the Rattle Snake
       * 
       */
      public void enemy(){
    	  System.out.println("                                   ____");
          System.out.println("          ________________________/ O  \\___/");
          System.out.println("         <_/_\\_/_\\_/_\\_/_\\_/_\\_/_______/   \\");
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
        	  System.out.println("Snake uses its poison");
        	  dam = 0;
        	  System.out.println("You lost some shield");
        	  System.out.println("Shield " + pc.getShield() + "-->");
        	  pc.decreaseShieldTemp(4);
        	  System.out.print(pc.getShield()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Snake uses Constriction");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Snake uses Strike");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the kill message for the Rattle Snake
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You cut the snakes head off and watch its body squirm.");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The snake slithers away in dissapointment, realizing you're far too easy of prey.");
          Thread.sleep(2000);
      }
}
/**
 * This class is used to make the Salmon enemy
 * @author Carlos
 *
 */
class Salmon extends CharEntities{
	public static Random rand = new Random();
	/**
	 * This is a constructor to make the Salmon class
	 * 
	 * @param pc is the user class
	 */
      public Salmon(Protag pc){
    	  int enemy = pc.getLevel();
          setDifficulty("Normal");
          setName("Salmon");
          setLevel(enemy);
          setAttack(3);
          setHealth(5);
      }
      /**
       * This method prints out the ascii art for the Salmon
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
        	  System.out.println("Salmon uses Current");
        	  dam = 0;
        	  System.out.println("Its attack increased");
        	  System.out.println("Attack " + getAttack() + "-->");
        	  upAttack(getAttack()/2);
        	  System.out.print(getAttack()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Salmon uses Razor Scale");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Salmon uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the kill message for the Salmon
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You can't wait to eat salmon sushi.");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The Salmon swims back into the water.");
          Thread.sleep(2000);
      }
}
/**
 * This class is used to make the Scorpion enemy
 * @author Carlos
 *
 */
class Scorpion extends CharEntities{
      public static Random rand = new Random();
      /**
  	 * This is a constructor to make the Scorpion class
  	 * 
  	 * @param pc is the user class
  	 */
      public Scorpion(Protag pc){
    	  int enemy = pc.getLevel();
          setDifficulty("Normal");
          setName("Scorpion");
          setLevel(enemy);
          setAttack(6);
          setHealth(3);
      }
      /**
       * This method prints out the ascii art for the Scorpion
       * 
       */
      public void enemy(){
    	  System.out.println("            _    _");
          System.out.println("           /_]  [_\\");
          System.out.println("          //      \\\\");
          System.out.println("          \\\\      //");
          System.out.println("           \\`-..-'/");
          System.out.println("            `\\  /`");
          System.out.println("              ||    _");
          System.out.println("              ||   ( )");
          System.out.println("              \\\\___/");
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
        	  System.out.println("Scorpion uses Posion Sting");
        	  dam = pc.getAttack()/2;
        	  System.out.println("You cut off the area to stop the Poison from spreading");
          }else if(move == 1) {
        	  System.out.println("Scorpion uses Pinch");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Scorpion uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the kill message for the Scorpion
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You cut off the stringer and the claws leaving the Scorpion to a pathetic existence.");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The Scorpion crawls away, victoriously, haven survived an enemy more than 10x its size.");
          Thread.sleep(2000);
      }
}
/**
 * This class is used to make the Shark enemy
 * @author Carlos
 *
 */
class Shark extends CharEntities{
      public static Random rand = new Random();
      /**
  	 * This is a constructor to make the Shark class
  	 * 
  	 * @param pc is the user class
  	 */
      public Shark(Protag pc){
    	  int enemy = pc.getLevel();
          setDifficulty("Normal");
          setName("Shark");
          setLevel(enemy);
          setAttack(7);
          setHealth(9);
      }
      /**
       * This method prints out the ascii art for the Shark
       * 
       */
      public void enemy(){
    	  System.out.println("                       _________         .    .");
          System.out.println("                      (..       \\_    ,  |\\  /|");
          System.out.println("                       \\       O  \\  /|  \\ \\/ /");
          System.out.println("                        \\______    \\/ |   \\  / ");
          System.out.println("                           vvvv\\    \\ |   /  |");
          System.out.println("                           \\^^^^  ==   \\_/   |");
          System.out.println("                            `\\_   ===    \\.  |");
          System.out.println("                            / /\\_   \\ /      |");
          System.out.println("                            |/   \\_  \\|      /");
          System.out.println("                                   \\________/");
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
        	  System.out.println("Shark smells Blood");
        	  dam = 0;
        	  System.out.println("It's attack increased.");
        	  System.out.println("Attack " + getAttack() + "-->");
        	  upAttack(getAttack()/2);
        	  System.out.print(getAttack()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Shark uses its rows of Razer Sharp teeth to shred you");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Shark uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the kill message for the Shark
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You stab your sword straight through the Shark's eye to the other.");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The shark having realized you tasted horrible decides to leave.");
          Thread.sleep(2000);
      }
}
/**
 * This class is used to make the Skeleton enemy
 * @author Carlos
 *
 */
class Skeleton extends CharEntities{
	public static Random rand = new Random();
	/**
	 * This is a constructor to make the Skeleton class
	 * 
	 * @param pc is the user class
	 */
      public Skeleton(Protag pc){
    	  int enemy = pc.getLevel();
          setDifficulty("Normal");
          setName("Skeleton");
          setLevel(enemy);
          setAttack(5);
          setHealth(4);
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
/**
 * This class is used to make the Spider enemy
 * @author Carlos
 *
 */
class Spider extends CharEntities{
	public static Random rand = new Random();
	/**
	 * This is a constructor to make the Spider class
	 * 
	 * @param pc is the user class
	 */
      public Spider(Protag pc){
    	  int enemy = pc.getLevel();
          setDifficulty("Normal");
          setName("Spider");
          setLevel(enemy);
          setAttack(7);
          setHealth(3);
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
/**
 * This class is used to make the Turtle enemy
 * @author Carlos
 *
 */
class Turtle extends CharEntities{
	public static Random rand = new Random();
	/**
	 * This is a constructor to make the Turtle class
	 * 
	 * @param pc is the user class
	 */
      public Turtle(Protag pc){
    	  int enemy = pc.getLevel();
          setDifficulty("Normal");
          setName("Turtle");
          setLevel(enemy);
          setAttack(4);
          setHealth(4);
      }
      /**
       * This method prints out the ascii art for the Turtle
       * 
       */
      public void enemy(){
          System.out.println("            _____     ____");
          System.out.println("           /      \\  |  o |"); 
          System.out.println("          |        |/ ___\\|"); 
          System.out.println("          |_________/     ");
          System.out.println("          |_|_| |_|_|");
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
        	  System.out.println("Turtle uses Harden");
        	  dam = 0;
        	  System.out.println("Its health increases");
        	  System.out.println("Health " + getHealth() + "-->");
        	  upHealth(level);
        	  System.out.print(getHealth()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Turtle uses Crunch");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Turtle uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the kill message for the Turtle
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You crack open the turtle like a coconut, its blood just doesn't taste as good.");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The Turtle decides you were too boring of a subject and dump you out of the UFO");
          Thread.sleep(2000);
      }
}
/**
 * This class is used to make the Vulture enemy
 * @author Carlos
 *
 */
class Vulture extends CharEntities{
      public static Random rand = new Random();
      /**
  	 * This is a constructor to make the Vulture class
  	 * 
  	 * @param pc is the user class
  	 */
      public Vulture(Protag pc){
    	  int enemy = pc.getLevel();
          setDifficulty("Easy");
          setName("Vulture");
          setLevel(enemy);
          setAttack(3);
          setHealth(6);
      }
      /**
       * This method prints out the ascii art for the Vulture
       * 
       */
      public void enemy(){
    	  System.out.println("                   .-..-.__");
          System.out.println("                 /`  |\\_( \"\\__");
          System.out.println("                 |   / __/`'--)");
          System.out.println("                 |  /  | |");
          System.out.println("                 /_/ _/_/");
          System.out.println("                 `|/))))");
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
        	  System.out.println("Vulture uses Fly");
        	  dam = 0;
        	  System.out.println("You cant't really reach it.");
        	  System.out.println("You lost some attack");
        	  System.out.println("Attack " + pc.getAttack() + "-->");
        	  pc.decreaseAttackTemp(2);
        	  System.out.print(pc.getAttack()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Vulture uses Scavenger");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Vulture uses tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the kill message for the Vulture
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You're able to slash the vulture's wings, never able to fly again.");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The vulture realizing you weren't dead, decided to stick to its natural prey.");
          Thread.sleep(2000);
      }
}
/**
 * This class is used to make the Wolf enemy
 * @author Carlos
 *
 */
class Wolf extends CharEntities{
      public static Random rand = new Random();
      /**
    	 * This is a constructor to make the Wolf class
    	 * 
    	 * @param pc is the user class
    	 */
      public Wolf(Protag pc){
    	  int enemy = pc.getLevel();
          setDifficulty("Hard");
          setName("Wolf");
          setLevel(enemy);
          setAttack(7);
          setHealth(7);
      }
      /**
       * This method prints out the ascii art for the Wolf
       * 
       */
      public void enemy() {
    	  System.out.println("                              .");
          System.out.println("                             / V\\");
          System.out.println("                            / ` /");
          System.out.println("                          <<   |");
          System.out.println("                          /    |");
          System.out.println("                        /      |");
          System.out.println("                      /        |");
          System.out.println("                    /    \\  \\ /");
          System.out.println("                   (      ) | |");
          System.out.println("           ________|   _/_  | |");
          System.out.println("         <__________\\______)\\__)");
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
        	  System.out.println("Wolf uses Howl");
        	  dam = 0;
        	  System.out.println("It's attack increased.");
        	  System.out.println("Attack " + getAttack() + "-->");
        	  upAttack(getAttack()/2);
        	  System.out.print(getAttack()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Wolf uses Mutilate");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Wolf uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
    /**
     * This method prints out the kill message for the Wolf
     */
    public void endMessage() throws InterruptedException{
  	  System.out.println("You slash the wolf until the whimpers finally stop.");
        Thread.sleep(2000);
    }
    /**
     * The enemy's message when it decides to leave
     * 
     * @throws InterruptedException
     */
    public void leaveMessage() throws InterruptedException{
  	  System.out.println("The wolf hears a howl and decides to join back up with its pack.");
        Thread.sleep(2000);
    }
}
/**
 * This class is used to make the Yak enemy
 * @author Carlos
 *
 */
class Yak extends CharEntities{
      public static Random rand = new Random();
      /**
    	 * This is a constructor to make the Yak class
    	 * 
    	 * @param pc is the user class
    	 */
      public Yak(Protag pc){
    	  int enemy = pc.getLevel();
          setDifficulty("Normal");
          setName("Yak");
          setLevel(enemy);
          setAttack(5);
          setHealth(8);
      }
      /**
       * This method prints out the ascii art for the Yak
       * 
       */
      public void enemy(){
    	  System.out.println("            ,__ ., __, ,,,,");
          System.out.println("            '--/,,\\--'\\*\\%\\*\\");
          System.out.println("              //  \\\\\\'\\'%.\\'%\\");
          System.out.println("               '..'//'%\\.\\%/\\\\'.^");
          System.out.println("                  \\\\'/'/%''/\\'");
          System.out.println("                    ||     ||");
          System.out.println("                    \"      \"");
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
        	  System.out.println("Yak uses its thick fur to warm itself up");
        	  dam = 0;
        	  System.out.println("It's healed some health.");
        	  System.out.println("Health " + getHealth() + "-->");
        	  upHealth(level);
        	  System.out.print(getHealth()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Yak uses Charge");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Yak uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the kill message for the Yak
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You cut off the horns of the Yak and use them to stab them through each eye.");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The Yak, decides it wasn't worth its time to fight a weak being.");
          Thread.sleep(2000);
      }
}
/**
 * This class is used to make the Zombie enemy
 * @author Carlos
 *
 */
class Zombie extends CharEntities{
	public static Random rand = new Random();
	/**
	 * This is a constructor to make the Zombie class
	 * 
	 * @param pc is the user class
	 */
      public Zombie(Protag pc){
    	  int enemy = pc.getLevel();
          setDifficulty("Normal");
          setName("Zombie");
          setLevel(enemy);
          setAttack(6);
          setHealth(3);
      }
      /**
       * This method prints out the ascii art for the Zombie
       * 
       */
      public void enemy(){
          System.out.println("               0");
          System.out.println("            ===|");
          System.out.println("               |");
          System.out.println("              / \\");
          System.out.println("            _/  _\\");
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
        	  System.out.println("Zombie uses Virus");
        	  dam = 0;
        	  System.out.println("You become more vulnerable to attacks.");
        	  System.out.println("Shield " + pc.getShield() + "-->");
        	  pc.decreaseShieldTemp(4);
        	  System.out.print(pc.getShield()+ "\n");
          }else if(move == 1) {
        	  System.out.println("Zombie uses Decay");
        	  dam = attack*2;
        	  System.out.println("It's a critical");
          }else if(move == 2 || move == 3) {
        	  System.out.println("Zombie uses Tackle");
        	  dam = attack;
          }
          return dam;
    	  
      }
      /**
       * This method prints out the kill message for the Zombie
       */
      public void endMessage() throws InterruptedException{
    	  System.out.println("You slash the rotting corpse until there's just black blood left.");
          Thread.sleep(2000);
      }
      /**
       * The enemy's message when it decides to leave
       * 
       * @throws InterruptedException
       */
      public void leaveMessage() throws InterruptedException{
    	  System.out.println("The Zombie realizes you don't have any brains to eat and leaves.");
          Thread.sleep(2000);
      }
}
