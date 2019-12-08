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
      private int counter;


      public Protag(){
            this.health = 100;
            totalHealth = 100;
            this.attack = 5;
            this.shield = 2;
            level = 1;
            exp = 0;
            needed = 10;
            counter = 0;

      }
      /**
       * 
       * @param strength
       */
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
    	  System.out.println("You leveled up!\n");
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
    	  level++;
    	  setNeeded();
    	  
      }

      public void damage(int hurt) {
    	  health = health - hurt;
      }

      public boolean getItems(){
          if(counter == 0) {  
        	  System.out.println("No Items");
        	  return false;
          }else {
        	  if(counter > 1) {
        		  for(int i = 0; i< counter; i++) {
        			  System.out.println((i + 1) + ": " + items.toArray()[i]);
        		  }
        	  }else if(counter == 1) {
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
        counter--;
      }
      public void putItems(String thing) {
    	  items.add(thing);
    	  counter++;
    	  
      }

      
}
