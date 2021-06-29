
public class weapons{
   public int equippedAttack;
   public String equippedName;
   public int durabilityMax;
   public int durability;
   public void setItem(String item){
      equippedName = item;
      switch (item){
      case "Rusty Sword":
         equippedAttack = 1;
         durabilityMax = 30;
         break;
      case "Iron Sword":
         equippedAttack = 3;
         durabilityMax = 50;
         break;
      case "Silver Sword": 
          equippedAttack = 6;
          durabilityMax = 100;
          break;
      case "Steel Sword": 
         equippedAttack = 10;
         durabilityMax = 140;
         break;
      case "Damascus Sword": 
         equippedAttack = 18;
         durabilityMax = 200;
         break;
      case "Tamahagane Sword": 
         equippedAttack = 20;
         durabilityMax = 180;
         break;
      case "Demon Claw Sword": 
          equippedAttack = 28;
          durabilityMax = 280;
          break;
       case "Dragon Tooth Sword": 
          equippedAttack = 40;
          durabilityMax = 360;
          break;
      default:
         equippedAttack = 1;
         durabilityMax = 1;
      }
      durability = durabilityMax;
   }
   public void printItem(String item){
	   switch (item){
	      case "Rusty Sword":
	    	  rustySword();
	         break;
	      case "Iron Sword":
	    	  ironSword();
	         break;
	      case "Silver Sword": 
	    	  silverSword();
	          break;
	      case "Steel Sword": 
	    	  steelSword();
	         break;
	      case "Damascus Sword": 
	    	  damascusSword();
	         break;
	      case "Tamahagane Sword": 
	    	  tamahaganeSword();
	         break;
	      case "Demon Claw Sword": 
	    	  demonClawSword();
	          break;
	       case "Dragon Tooth Sword": 
	    	   dragonToothSword();
	          break;
	      default:
	         System.out.println("printItem failed in weapons");
	      }
   }
   public int sellItem(String item){
	   switch (item){
	      case "Rusty Sword":
	         return 5;
	      case "Iron Sword":
	         return 100;
	      case "Silver Sword": 
	          return 1200;
	      case "Steel Sword": 
	         return 3900;
	      case "Damascus Sword": 
	         return 20000;
	      case "Tamahagane Sword": 
	         return 20000;
	      case "Demon Claw Sword": 
	          return 300000;
	       case "Dragon Tooth Sword": 
	          return 500000;
	      default:
	         break;
	   }
	      
	   return 0;
   }
   public void rustySword() {
	   System.out.println("Name- Rusty Sword");
	   System.out.println("Damage- 1");
	   System.out.println("Durability - 30");
   }
   public void ironSword() {
	   System.out.println("Name- Iron Sword");
	   System.out.println("Damage- 3");
	   System.out.println("Durability - 50");
   }
   public void silverSword() {
	   System.out.println("Name- Silver Sword");
	   System.out.println("Damage- 6");
	   System.out.println("Durability - 100");
   }
   public void steelSword() {
	   System.out.println("Name- Steel Sword");
	   System.out.println("Damage- 10");
	   System.out.println("Durability - 140");
   }
   public void damascusSword() {
	   System.out.println("Name- Damascus Sword");
	   System.out.println("Damage- 18");
	   System.out.println("Durability - 200");
   }
   public void tamahaganeSword() {
	   System.out.println("Name- Tamahagane Sword");
	   System.out.println("Damage- 20");
	   System.out.println("Durability - 180");
   }
   public void demonClawSword() {
	   System.out.println("Name- Demon Claw Sword");
	   System.out.println("Damage- 28");
	   System.out.println("Durability - 280");
   }
   public void dragonToothSword() {
	   System.out.println("Name- Dragon Tooth Sword");
	   System.out.println("Damage- 40");
	   System.out.println("Durability - 360");
   }
   public String getName(){
      return equippedName;
   }
   public int getAttack(){
      return equippedAttack;
   }
   public int getDurabilityMax(){
      return durabilityMax;
   }
   public int getDurability(){
      return durability;
   }
   public void setDurability(int temp){
      durability = temp;
   }

}