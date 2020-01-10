import java.util.TreeSet;

public class Protag {
      private int health;
      private int totalHealth;
      private int attack;
      private int shield;
      private int exp;
      private int level;
      private int needed;
      private int lvlPoint;
      private static TreeSet<String> items = new TreeSet<String>();
      private static TreeSet<String> equip = new TreeSet<String>();
      private int itemCounter;
      private int equipCounter;
      public int attackTemp;
      public int shieldTemp;
      public int type;

      public Protag(int type){
    	  this.type = type; 
    	  if(type == 0) {
    		  this.health = 125;
              totalHealth = 125;
              this.attack = 5;
              this.shield = 3; 
    	  }else if(type == 1) {
    		  this.health = 75;
              totalHealth = 75;
              this.attack = 8;
              this.shield = 5; 
    	  }else {
    		  this.health = 100;
              totalHealth = 100;
              this.attack = 3;
              this.shield = 8; 
    	  }
            level = 1;
            lvlPoint = 0;
            exp = 0;
            needed = 10;
            itemCounter = 0;
            equipCounter = 0;
            attackTemp = 0;
            shieldTemp = 0;
      }
      public void sprite(){
    	  System.out.println("  O  /");
          System.out.println(" /|\\/");
          System.out.println("  |");
          System.out.println(" _^_");
       }
      
      public void setExp(int strength) {
    	  exp = exp + (strength*2);
      }
      public int getShield(){
            return shield;
      }
      public int getAttack(){
          return attack;
      }
      public int getHealth(){
          return health;
      }
      public void setHealth(int idx){
          health = idx ;
      }
      public int getTotal() {
    	  return totalHealth;
      }
      public void upgradeShield(int boost){
          shield = shield + boost;
      }
      public void downgradeShield(int boost){
          shield = shield - boost;
      }
      public void downgradeAttack(int boost){
          attack = attack - boost;
      }
      public void usePoint(int boost){
          lvlPoint =  lvlPoint- boost;
      }
      public void upgradeAttack(int boost){
    	  attack = attack + boost;
      }
      public void upgradeHealth(int boost){
        totalHealth = totalHealth + boost;
      }
      public void heal(int boost){
          if(health < totalHealth) {
        	  if((boost + health) > totalHealth) {
        		  health = totalHealth;
        	  }else {
        		  health = health + boost;
        	  }
          }
        }
      public int getExp() {
    	  return exp;
      }
      public int getLevel() {
    	  return level;
      }
      public int getPoints() {
    	  return lvlPoint;
      }
      public int getNeeded() {
    	  return needed;
      }
      public void setNeeded() {
    	  needed = 10*getLevel() - exp;
    	  if(needed <= 0) {
    		  needed = 10*getLevel();
    		  levelUp();
    	  }
      }
      
      public void levelUp() {
    	  
    	  System.out.print("Total Health: " + getTotal() + "-->");
    	  if(type == 0) {
    		  upgradeHealth(7); 
    	  }else if(type == 1) {
    		  upgradeHealth(5);
    	  }else {
    		  upgradeHealth(6);
    	  }
    	  System.out.print(getTotal()+ "\n");
    	  System.out.print("Attack: " + getAttack() + "-->");
    	  if(type == 0) {
    		  upgradeAttack(4);
    	  }else if(type == 1) {
    		  upgradeAttack(5);
    	  }else {
    		  upgradeAttack(3);
    	  }
    	  System.out.print(getAttack()+ "\n");
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
    	  if(level == 3 || level == 7 || level == 10) {
    		  System.out.print("You learned a new move\n");
    	  }
    	  setNeeded();
    	  
      }

      public void damage(int hurt) {
    	  health = health - hurt;
      }

      public boolean getItems(){
          if(itemCounter == 0) {  
        	  System.out.println("No Items");
        	  return false;
          }else {
        	  if(itemCounter > 1) {
        		  for(int i = 0; i< itemCounter; i++) {
        			  System.out.println((i + 1) + ": " + items.toArray()[i]);
        		  }
        	  }else if(itemCounter == 1) {
        		  System.out.println("1: " + items.toArray()[0]);
        	  }
        	  return true;
          }
      }
      public String getItem(int idx) {
    	  return (String) items.toArray()[idx];
      }
      public void removeItem(String word) {
    	  items.remove(word);
    	  itemCounter--;
      }
      public void putItems(String thing) {
    	  items.add(thing);
    	  itemCounter++;
    	  
      }
      public boolean getEquipment(){
          if(equipCounter == 0) {  
        	  System.out.println("No Equipment");
        	  return false;
          }else {
        	  if(equipCounter > 1) {
        		  for(int i = 0; i< equipCounter; i++) {
        			  System.out.println((i + 1) + ": " + equip.toArray()[i]);
        		  }
        	  }else if(equipCounter == 1) {
        		  System.out.println("1: " + equip.toArray()[0]);
        	  }
        	  return true;
          }
      }
      public String getEquipment(int idx) {
    	  return (String) equip.toArray()[idx];
      }
      public void removeEquipment(String word) {
    	  equip.remove(word);
    	  equipCounter--;
      }
      public void putEquipment(String word) {
    	  equip.add(word);
    	  equipCounter++;
    	  
      }
      
      public void increaseAttackTemp() {
    	  if(attackTemp < 20) {
    		  attackTemp = attackTemp + 6;
    		  System.out.println("Attack has been increased");
    		  upgradeAttack(attackTemp);
    	  }else {
    		  System.out.println("Attack can't go higher");
    	  }
      }
      public void increaseShieldTemp() {
    	  if(shieldTemp < 17) {
    		  shieldTemp = shieldTemp + 4;
    		  System.out.println("Shield has been increased");
    		  upgradeShield(shieldTemp);
    	  }else {
    		  System.out.println("Shield can't go higher");
    	  }
      }
      
      public void reset() {
    	  if(attackTemp > 0 || shieldTemp > 0) {
    		  downgradeAttack(attackTemp);
    		  downgradeShield(shieldTemp);
    		  attackTemp = 0;
    		  shieldTemp = 0;
    	  }
      }

      
}
