import java.util.TreeSet;

public class Protag {
      private int health;
      private int totalHealth;
      private int attack;
      private int shield;
      private int exp;
      private int level;
      private int needed;
      private static TreeSet<String> items = new TreeSet<String>();
      private static TreeSet<String> equip = new TreeSet<String>();
      private int itemCounter;
      private int equipCounter;

      public Protag(){
            this.health = 100;
            totalHealth = 100;
            this.attack = 5;
            this.shield = 2;
            level = 1;
            exp = 0;
            needed = 10;
            itemCounter = 0;
            equipCounter = 0;

      }
      public void sprite(){
          System.out.println("  /\\");
    	  System.out.println(" /00\\");
          System.out.println(" \\  /");
          System.out.println("  []");
          System.out.println("||  ||");
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
    	  upgradeHealth(5);
    	  System.out.print(getTotal()+ "\n");
    	  System.out.print("Attack: " + getAttack() + "-->");
    	  upgradeAttack(5);
    	  System.out.print(getAttack()+ "\n");
    	  System.out.print("Shield: " + getShield() + "-->");
    	  upgradeShield(3);
    	  System.out.print(getShield()+ "\n");
    	  exp = exp - getNeeded();
    	  System.out.println("Level up " + getLevel() + "-->");
    	  level++;
    	  System.out.print(getLevel()+ "\n");
    	  if(level == 3 || level == 7) {
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

      
}
