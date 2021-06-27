import java.util.ArrayList;
import java.util.TreeSet;
/**
 * This creates the User class
 * 
 * @author Carlos
 *
 */
public class Protag {
      private int health;
      private int totalHealth;
      private int attack;
      private int speed;
      private int shield;
      private int exp;
      private int level;
      private int needed;
      private int lvlPoint;
      private static ArrayList<String> items = new ArrayList<>(100);
      private static TreeSet<String> equip = new TreeSet<String>();
      private int equipCounter;
      public int attackTemp;
      public int shieldTemp;
      public int attackDump;
      public int shieldDump;
      public int type;
      public int luck;
      public boolean passive;
      /**
       * This is the constructor for the user class
       * 
       * @param type is the class the user chose
       */
      public Protag(int type){
    	  this.type = type; 
    	  if(type == 0) {
    		  //13 points not including health 13 points
    		  this.health = 130;
              totalHealth = 130;
              this.attack = 5;
              this.shield = 3; 
              luck = 1;
              speed = 4;
    	  }else if(type == 1) {
    		  //21 points not including health 7 points
    		  this.health = 70;
              totalHealth = 70;
              this.attack = 7;
              this.shield = 5; 
              luck = 3;
              speed = 6;
    	  }else {
    		  //17 points not including health 10 points
    		  this.health = 100;
              totalHealth = 100;
              this.attack = 3;
              this.shield = 7; 
              luck = 5;
              speed = 2;
    	  }
    	  	
            level = 1;
            lvlPoint = 0;
            exp = 0;
            needed = 10;
            equipCounter = 0;
            attackTemp = 0;
            shieldTemp = 0;
            attackDump = 0;
            shieldDump = 0;
            passive = false;
      }
      /**
       * This method prints out the sprite for the player
       */
      public void sprite(){
    	  System.out.println("      _,.");
          System.out.println("    ,` -.)");
          System.out.println("   ( _/-\\\\-._");
          System.out.println("  /,|`--._,-^|            ,");
          System.out.println("  \\_| |`-._/||          ,'|");
          System.out.println("    |  `-, / |         /  /");
          System.out.println("    |     || |        /  /");
          System.out.println("     `r-._||/   __   /  /");
          System.out.println(" __,-<_     )`-/  `./  /");
          System.out.println("'  \\   `---'   \\   /  /");
          System.out.println("    |           |./  /");
          System.out.println("    /           //  /");
          System.out.println("\\_/' \\         |/  /");
          System.out.println(" |    |   _,^-'/  /");
          System.out.println(" |    , ``  (\\/  /_");
          System.out.println("  \\,.->._    \\X-=/^");
          System.out.println("  (  /   `-._//^`");
          System.out.println("   `Y-.____(__}");
          System.out.println("    |     {__)");
          System.out.println("          ()");
       }
      /**
       * This method increasingly adds exp to the total exp
       * 
       * @param strength is the attack of the Enemy
       */
      public void setExp(int strength) {
    	  exp = exp + (strength*2);
      }
      /**
       * This method is used to get the luck of the User
       * 
       * @return luck 
       */
      public int getLuck(){
          return luck;
    }
      /**
       * This method is used to get the shield of the User
       * 
       * @return shield
       */
      public int getShield(){
            return shield;
      }
      /**
       * This method is used to get the attack of the User
       * 
       * @return attack
       */
      public int getAttack(){
          return attack;
      }
      /**
       * This method is used to get the current health of the User
       * 
       * @return health
       */
      public int getHealth(){
          return health;
      }
      /**
       * This method is used to get the speed of the User
       * 
       * @return health
       */
      public int getSpeed(){
          return speed;
      }
      /** 
       * This method is used to set the health depending on idx
       * 
       * @param idx is what the health changes in to
       */
      public void setHealth(int idx){
          health = idx ;
      }
      /**
       * This method is used to get total health of the user
       * 
       * @return totalHealth
       */
      public int getTotal() {
    	  return totalHealth;
      }
      /**
       * This method is used to increase the shield of the User
       * 
       * @param boost is how much to increase the shield
       */
      public void upgradeShield(int boost){
          shield = shield + boost;
      }
      /**
       * THis method is used to decrease the shield of the User
       * 
       * @param boost is how much to decrease the shield
       */
      public void downgradeShield(int boost){
          shield = shield - boost;
      }
      /**
       * This method is used to decrease the attack of the User
       * 
       * @param boost is how much to decrease the attack
       */
      public void downgradeAttack(int boost){
          attack = attack - boost;
      }
      /**
       * This method is used to decrease the amount of lvlpoints the user has
       * 
       * @param boost is how many lvlpoints the User used
       */
      public void usePoint(int boost){
          lvlPoint =  lvlPoint- boost;
      }
      /**
       * This method is used to increase the amount of luck the User has with the limit of 100
       * 
       * @param boost is how much to increase the luck
       */
      public void upgradeLuck(int boost){
    	  if(luck < 100) {
    		  luck = luck + boost;
    	  }else {
    		  System.out.println("Luck can't go higher");
    	  }
      }
      /**
       * This method is used to increase the attack of the User
       * 
       * @param boost is how much to increase the attack
       */
      public void upgradeAttack(int boost){
    	  attack = attack + boost;
      }
      /**
       * This method is used to increase the speed of the User
       * 
       * @param boost is how much to increase the attack
       */
      public void upgradeSpeed(int boost){
    	  speed = speed + boost;
      }
      /**
       * This method is used to increase the total health of the User
       * 
       * @param boost is how much to increase the total health
       */
      public void upgradeHealth(int boost){
        totalHealth = totalHealth + boost;
      }
      /**
       * This method is to increase User's current health with the limit being the User's total health
       * 
       * @param boost is how much to increase the health
       */
      public void heal(int boost){
          if(health < totalHealth) {
        	  if((boost + health) > totalHealth) {
        		  health = totalHealth;
        	  }else {
        		  health = health + boost;
        	  }
          }
        }
      /**
       * This method is used to get the exp
       * 
       * @return exp
       */
      public int getExp() {
    	  return exp;
      }
      /**
       * This method is used to get the level
       * 
       * @return level
       */
      public int getLevel() {
    	  return level;
      }
      /**
       * This methos is used to get amount of lvlpoints
       * 
       * @return lvlPoint
       */
      public int getPoints() {
    	  return lvlPoint;
      }
      /**
       * This method is used to get needed
       * 
       * @return needed
       */
      public int getNeeded() {
    	  return needed;
      }
      /**
       * This method is used to set needed on how much you need until the next level
       * 
       */
      public void setNeeded() {
    	  needed = 10*getLevel() - exp;
    	  if(needed <= 0) {
    		  needed = 10*getLevel();
    		  levelUp();
    	  }
      }
      /**
       * This method shows the user what increases when they level up and if they unlock a new move
       */
      public void levelUp() {
    	  System.out.println("\nCongrats you just Leveled Up!\n");
    	  System.out.print("Total Health: " + getTotal() + "-->");
    	  if(type == 0) {
    		  upgradeHealth(7); 
    	  }else if(type == 1) {
    		  upgradeHealth(5);
    	  }else {
    		  upgradeHealth(6);
    	  }
    	  System.out.print(getTotal()+ "\n");
    	  System.out.print("Health: " + getHealth() + "-->");
    	  if(type == 0) {
    		  heal(7); 
    	  }else if(type == 1) {
    		  heal(5);
    	  }else {
    		  heal(6);
    	  }
    	  System.out.print(getHealth()+ "\n");
    	  System.out.print("Attack: " + getAttack() + "-->");
    	  if(type == 0) {
    		  upgradeAttack(4);
    	  }else if(type == 1) {
    		  upgradeAttack(5);
    	  }else {
    		  upgradeAttack(3);
    	  }
    	  System.out.print(getAttack()+ "\n");
    	  System.out.print("Speed: " + getSpeed() + "-->");
    	  if(type == 0) {
    		  upgradeSpeed(3);
    	  }else if(type == 1) {
    		  upgradeSpeed(4);
    	  }else {
    		  upgradeSpeed(2);
    	  }
    	  System.out.print(getSpeed()+ "\n");
    	  System.out.print("Shield: " + getShield() + "-->");
    	  if(type == 0) {
    		  upgradeShield(2);
    	  }else if(type == 1) {
    		  upgradeShield(3);
    	  }else {
    		  upgradeShield(4);
    	  }
    	  System.out.print(getShield()+ "\n");
    	  exp = exp - getNeeded();
    	  System.out.print("Points: " + getPoints() + "-->");
    	  lvlPoint++;
    	  System.out.print(getPoints()+ "\n");
    	  System.out.print("Level up " + getLevel() + "-->");
    	  level++;
    	  System.out.print(getLevel()+ "\n");
    	  if(level == 3 || level == 7 || level == 10 || level == 15) {
    		  System.out.print("You learned a new move\n");
    	  }
    	  setNeeded();
    	  
      }
      /**
       * This method is used to decrease health
       * 
       * @param hurt is the damage done by the enemy
       */
      public void damage(int hurt) {
    	  health = health - hurt;
      }
      /**
       * This method is made to return the number of items
       * 
       * @return itemCounter is global variable of how many items there are
       */
      public int getItemsSize() {
    	  return items.size();
      }
      /**
       * This method is used to print out the items the User has or not
       * 
       * @return true if there are items and false if no items
       */
      public boolean getItems(){
    	  if(items.isEmpty()){
    	      System.out.println("No items");
        	  return false;
          }else {
        	  for(int i = 0; i < items.size(); i++){
                  System.out.println((i + 1) + ": " + items.get(i));
               }
        	  return true;
          }
      }
      /**
       * This method is used to get a specfic item
       * 
       * @param idx the index of the item
       * @return string version of chosen item
       */
      public String getItem(int idx) {
    	  try {
    		  return (String) items.get(idx);
    	  }catch(ArrayIndexOutOfBoundsException e) {
    		  return " ";
    	  }
      }
      /**
       * This method is used to remove an item from treeset and decrease the itemCounter
       * 
       * @param word is the item we need to remove
       */
      public void removeItem(int idx) {
    	  items.remove(idx);
      }
      /**
       * This method is used to put an item to treeset and increase the itemCounter
       * 
       * @param thing is the item we are adding
       */
      public void putItems(String thing) {
    	  items.add(thing); 
      }
      /**
       * This method is made to return the number of equipments
       * 
       * @return equipCounter is global variable of how many equipments there are
       */
      public int getEquipCounter() {
    	  return equipCounter;
      }
      /**
       * This method is used to print out all of the equipment the user has 
       * 
       * @return false if no equipment or true if there is
       */
      public boolean getEquipment(){
          if(equipCounter == 0) {  
        	  System.out.println("No Equipment");
        	  return false;
          }else {
        	  if(equipCounter > 1) {
        		  for(int i = 0; i< equipCounter; i++) {
        			  if(getEquipment(i) != " ") {
        				  System.out.println((i + 1) + ": " + getEquipment(i));
        			  }
        		  }
        	  }else if(equipCounter == 1) {
        		  System.out.println("1: " + getEquipment(0));
        	  }
        	  return true;
          }
      }
      /**
       * This method is used to get a specific equipment
       * 
       * @return string type of equipment
       */
      public String getEquipment(int idx) {
    	try {
    	  return (String) equip.toArray()[idx];
      	}catch(ArrayIndexOutOfBoundsException e) {
      		equipCounter--;
      		return " ";
      	}
      }
      public boolean checkEquipment(String word) {
    	  return equip.contains(word);
      }
      /**
       * This method is used to remove an equipment in treeset and decrease equipCounter
       * 
       * @param word is the equipment
       */
      public void removeEquipment(String word) {
    	  equip.remove(word);
    	  equipCounter--;
      }
      /**
       * THis method is used to put an equipment in treeset and increase equipCounter
       * 
       * @param word is the equipment
       */
      public void putEquipment(String word) {
    	  equip.add(word);
    	  equipCounter++;
    	  
      }
      /**
       * This method is used to increase attack temp with a limit of 33
       * and increase attack
       * 
       * @param boost is how much to increase attack temp and attack
       */
      public void increaseAttackTemp(int boost) {
    	  if(attackTemp < 33) {
    		  attackTemp = attackTemp + boost;
    		  System.out.println("Attack has been increased");
    		  upgradeAttack(boost);
    	  }else {
    		  System.out.println("Attack can't go higher");
    	  }
      }
      /**
       * This method is used the increase shield temp with a limit of 26
       * and increase shield
       * 
       * @param boost is how much to increase shield temp and shield
       */
      public void increaseShieldTemp(int boost) {
    	  if(shieldTemp < 26) {
    		  shieldTemp = shieldTemp + boost;
    		  System.out.println("Shield has been increased");
    		  upgradeShield(boost);
    	  }else {
    		  System.out.println("Shield can't go higher");
    	  }
      }
      /**
       * This method is used to increase attack dump with a limit of attack not going down to zero
       * and decrease attack
       * 
       * @param boost is how much to increase attack dump and decrease attack
       */
      public void decreaseAttackTemp(int boost) {
    		if((attack - boost) > 0) {  
    			attackDump = attackDump + boost;
    			downgradeAttack(boost);
    		}
      }
      /**
       * This method is used to increase shield dump with a limit of shield not going down to zero
       * and decrease shield
       * 
       * @param boost is how much to increase shield dump and decrease shield
       */
      public void decreaseShieldTemp(int boost) {
    		if((shield-boost) > 0) {  
    			shieldDump = shieldDump + boost;
    			downgradeShield(boost);
    		}
      }
      /**
       * sets all the temps and dumps to zero and reset attack and shield
       * sets passive to false
       */
      public void reset() {
    	  if(attackTemp > 0 || shieldTemp > 0 || attackDump > 0 || shieldDump > 0) {
    		  downgradeAttack(attackTemp);
    		  downgradeShield(shieldTemp);
    		  upgradeAttack(attackDump);
    		  upgradeShield(shieldDump);
    		  attackTemp = 0;
    		  shieldTemp = 0;
    		  attackDump = 0;
    		  shieldDump = 0;
    		  setPassive(false);
    	  }
      }
      /**
       * This method is used to get passive
       * 
       * @return passive
       */
      public boolean getPassive() {
    	  return passive;
      }
      /**
       * This method is used to set passive into whatever was passed
       * 
       * @param set is either true of false
       */
      public void setPassive(boolean set) {
    	  passive = set;
      }
      
}
