public class Protag {
      private int health;
      private int attack;
      private int shield;
      private int exp;
      private int level;
      private int needed;


      public Protag(){
            this.health = 100;
            this.attack = 5;
            this.shield = 2;
            level = 1;
            exp = 0;
            needed = 100;

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
    	  needed = 10*getLevel();
      }
      
      public void levelUp() {
    	  health = health + 5;
    	  attack = attack + 5;
    	  shield = shield + 3;
    	  exp = exp - getNeeded();
    	  level++;
    	  setNeeded();
    	  
      }

      public void damage(int hurt) {
    	  health = health - hurt;
      }

      public void getItems(){
            System.out.println("No Items");
      }

      
}
