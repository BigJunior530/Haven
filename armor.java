import java.util.Random;

public class armor{

   public int equippedDefense;
   public String type;
   public String equippedName;
   public Random rand = new Random();
   //can pass protag or before calling this method needs to have already removed the equipped defense.
   public void setItem(String item, Protag pc){
   }
   public void printItem(String item){
   }
   public String getType(){
      return type;
   }
   public String getName(){
      return equippedName;
   }
   public int getDefense(){
      return equippedDefense;
   }
   
   public String lootItem(Protag pc) {
      return "bug";
   }
   public boolean itemHere(String item) {
	   return false;
   }
}

class feetArmor extends armor{
   public void setItem(String item, Protag pc){
      pc.downgradeShield(equippedDefense);
	   equippedName = item;
      switch (item){
         case "Leather Boots":
            equippedDefense = 0;
            type = "starter"; 
            break;   
         case "Reinforced Boots":
            equippedDefense = 2;
            type = "reinforced";
            break;
         case "Warrior's Boots":
            equippedDefense = 5;
            type = "warrior";
            break;
         case "Hero's Boots":
            equippedDefense = 9;
            type = "hero";
            break;
         case "King's Boots":
            equippedDefense = 14;
            type = "king";
            break;
         case "Demon Armor Boots":
            equippedDefense = 21;
            type = "demon";
            break;
         case "Dragon Armor Boots":
            equippedDefense = 26;
            type = "dragon";
            break;
      }
      
   }
   public boolean itemHere(String item) {
	   switch (item){
       case "Leather Boots":
          return true;  
       case "Reinforced Boots":
    	   return true; 
       case "Warrior's Boots":
    	   return true; 
       case "Hero's Boots":
    	   return true; 
       case "King's Boots":
    	   return true; 
       case "Demon Armor Boots":
    	   return true; 
       case "Dragon Armor Boots":
    	   return true; 
	   }
	   return false;
   }
   public void printItem(String item){
      switch (item){
         case "Leather Boots":
            leatherBoots();
            break;   
         case "Reinforced Boots":
            reinforcedBoots();
            break;
         case "Warrior's Boots":
            warriorBoots();
            break;
         case "Hero's Boots":
            heroBoots();
            break;
         case "King's Boots":
            kingBoots();
            break;
         case "Demon Armor Boots":
            demonBoots();
            break;
         case "Dragon Armor Boots":
            dragonBoots();
            break;
      }
         
   }
   public void leatherBoots() {
      System.out.println("Name - Leather Boots");
      System.out.println("Defense - 0");
      System.out.println("Type - Starter");
   }
   public void reinforcedBoots() {
      System.out.println("Name - Reinforced Boots");
      System.out.println("Defense - 2");
      System.out.println("Type - Reinforced");
   }
   public void warriorBoots() {
      System.out.println("Name - Warrior's Boots");
      System.out.println("Defense - 5");
      System.out.println("Type - Warrior");
   }
   public void heroBoots() {
      System.out.println("Name - Hero's Boots");
      System.out.println("Defense - 9");
      System.out.println("Type - Hero");
   }
   public void kingBoots() {
      System.out.println("Name - King's Boots");
      System.out.println("Defense - 14");
      System.out.println("Type - King");
   }
   public void demonBoots() {
      System.out.println("Name - Demon Armor Boots");
      System.out.println("Defense - 21");
      System.out.println("Type - Demon");
   }
   public void dragonBoots() {
      System.out.println("Name - Dragon Armor Boots");
      System.out.println("Defense - 26");
      System.out.println("Type - Dragon");
   }
   
   public String lootItem(Protag pc) {
      int luck = rand.nextInt(100);
      luck += pc.getLuck();
      if(pc.getLevel() > 20) {
         if(luck > 70 && !pc.checkEquipment("Dragon Armor Boots")){
            return "Dragon Armor Boots";
         }
         if(luck < 70 && !pc.checkEquipment("Demon Armor Boots")){
            return "Demon Armor Boots";
         }
      }
      if(pc.getLevel() > 10) {
         if(luck > 70 && !pc.checkEquipment("King's Boots")){
            return "King's Boots";
         }
         if(luck < 70 && !pc.checkEquipment("Hero's Boots")){
            return "Hero's Boots";
         }
      }
      if(luck > 70 && !pc.checkEquipment("Warrior's Boots")){
         return "Warrior's Boots";
      }
      if(luck < 70 && !pc.checkEquipment("Reinforced Boots")){
         return "Reinforced Boots";
      }
      return "nothing";
   }


}
class torsoArmor extends armor{
   public void setItem(String item, Protag pc){
	   pc.downgradeShield(equippedDefense);
      equippedName = item;
      switch (item){
         case "Shirt":
            equippedDefense = 0;
            type = "starter"; 
            break;   
         case "Reinforced Shirt":
            equippedDefense = 5;
            type = "reinforced";
            break;
         case "Warrior's Shirt":
            equippedDefense = 12;
            type = "warrior";
            break;
         case "Hero's Shirt":
            equippedDefense = 19;
            type = "hero";
            break;
         case "King's Chestplate":
            equippedDefense = 26;
            type = "king";
            break;
         case "Demon Armor Chestplate":
            equippedDefense = 34;
            type = "demon";
            break;
         case "Dragon Armor Chestplate":
            equippedDefense = 40;
            type = "dragon";
            break;
      }
   }
   public boolean itemHere(String item) {
	   switch (item){
     	case "Shirt":
           return true;  
     	case "Reinforced Shirt":
     		return true;  
     	case "Warrior's Shirt":
     		return true;  
     	case "Hero's Shirt":
     		return true;  
     	case "King's Chestplate":
     		return true;  
     	case "Demon Armor Chestplate":
     		return true;  
     	case "Dragon Armor Chestplate":
     		return true;  
	   }
	   return false;
   }
   public void printItem(String item){
      switch (item){
      	case "Shirt":
            shirt();
            break;   
      	case "Reinforced Shirt":
            reinforcedShirt();
            break;
      	case "Warrior's Shirt":
            warriorShirt();
            break;
      	case "Hero's Shirt":
            heroShirt();
            break;
      	case "King's Chestplate":
            kingChestplate();
            break;
      	case "Demon Armor Chestplate":
            demonChestplate();
            break;
      	case "Dragon Armor Chestplate":
            dragonChestplate();
            break;
      }
         
   }
   public void shirt() {
      System.out.println("Name - Shirt");
      System.out.println("Defense - 0");
      System.out.println("Type - Starter");
   }
   public void reinforcedShirt() {
      System.out.println("Name - Reinforced Shirt");
      System.out.println("Defense - 5");
      System.out.println("Type - Reinforced");
   }
   public void warriorShirt() {
      System.out.println("Name - Warrior's Shirt");
      System.out.println("Defense - 12");
      System.out.println("Type - Warrior");
   }
   public void heroShirt() {
      System.out.println("Name - Hero's Shirt");
      System.out.println("Defense - 19");
      System.out.println("Type - Hero");
   }
   public void kingChestplate() {
      System.out.println("Name - King's Chestplate");
      System.out.println("Defense - 26");
      System.out.println("Type - King");
   }
   public void demonChestplate() {
      System.out.println("Name - Demon Armor Chestplate");
      System.out.println("Defense - 34");
      System.out.println("Type - Demon");
   }
   public void dragonChestplate() {
      System.out.println("Name - Dragon Armor Chestplate");
      System.out.println("Defense - 40");
      System.out.println("Type - Dragon");
   }
   public String lootItem(Protag pc) {
      int luck = rand.nextInt(100);
      luck += pc.getLuck();
      if(pc.getLevel() > 20) {
         if(luck > 70 && !pc.checkEquipment("Dragon Armor Chestplate")){
            return "Dragon Armor Chestplate";
         }
         if(luck < 70 && !pc.checkEquipment("Demon Armor Chestplate")){
            return "Demon Armor Chestplate";
         }
      }
      if(pc.getLevel() > 10) {
         if(luck > 70 && !pc.checkEquipment("King's Chestplate")){
            return "King's Chestplate";
         }
         if(luck < 70 && !pc.checkEquipment("Hero's Shirt")){
            return "Hero's Shirt";
         }
      }
      if(luck > 70 && !pc.checkEquipment("Warrior's Shirt")){
         return "Warrior's Shirt";
      }
      if(luck < 70 && !pc.checkEquipment("Reinforced Shirt")){
         return "Reinforced Shirt";
      }
      return "nothing";
   }


}
class legArmor extends armor{
   public void setItem(String item, Protag pc){
	   pc.downgradeShield(equippedDefense);
      equippedName = item;
      switch (item){
         case "Plain Pants":
            equippedDefense = 0;
            type = "starter"; 
            break;   
         case "Reinforced Pants":
            equippedDefense = 4;
            type = "reinforced";
            break;
         case "Warrior's Pants":
            equippedDefense = 9;
            type = "warrior";
            break;
         case "Hero's Pants":
            equippedDefense = 15;
            type = "hero";
            break;
         case "King's Leggings":
            equippedDefense = 21;
            type = "king";
            break;
         case "Demon Armor Leggings":
            equippedDefense = 29;
            type = "demon";
            break;
         case "Dragon Armor Leggings":
            equippedDefense = 35;
            type = "dragon";
            break;
      }
   }
   public boolean itemHere(String item) {
	   switch (item){
       case "Plain Pants":
    	   return true; 
       case "Reinforced Pants":
    	   return true; 
       case "Warrior's Pants":
    	   return true; 
       case "Hero's Pants":
    	   return true; 
       case "King's Leggings":
    	   return true; 
       case "Demon Armor Leggings":
    	   return true; 
       case "Dragon Armor Leggings":
    	   return true; 
	   }
	   return false;
   }
   public void printItem(String item){
	   switch (item){
	       case "Plain Pants":
	    	   plainPants();
	          break;   
	       case "Reinforced Pants":
	    	   reinforcedPants();
	          break;
	       case "Warrior's Pants":
	          warriorPants();
	          break;
	       case "Hero's Pants":
	          heroPants();
	          break;
	       case "King's Leggings":
	    	  kingLeggings();
	          break;
	       case "Demon Armor Leggings":
	          demonLeggings();
	          break;
	       case "Dragon Armor Leggings":
	          dragonLeggings();
	          break;
	   }
         
   }
   public void plainPants() {
      System.out.println("Name - Plain Pants");
      System.out.println("Defense - 0");
      System.out.println("Type - Starter");
   }
   public void reinforcedPants() {
      System.out.println("Name - Reinforced Pants");
      System.out.println("Defense - 4");
      System.out.println("Type - Reinforced");
   }
   public void warriorPants() {
      System.out.println("Name - Warrior's Pants");
      System.out.println("Defense - 9");
      System.out.println("Type - Warrior");
   }
   public void heroPants() {
      System.out.println("Name - Hero's Pants");
      System.out.println("Defense - 15");
      System.out.println("Type - Hero");
   }
   public void kingLeggings() {
      System.out.println("Name - King's Leggings");
      System.out.println("Defense - 21");
      System.out.println("Type - King");
   }
   public void demonLeggings() {
      System.out.println("Name - Demon Armor Leggings");
      System.out.println("Defense - 29");
      System.out.println("Type - Demon");
   }
   public void dragonLeggings() {
      System.out.println("Name - Dragon Armor Leggings");
      System.out.println("Defense - 35");
      System.out.println("Type - Dragon");
   }
   public String lootItem(Protag pc) {
      int luck = rand.nextInt(100);
      luck += pc.getLuck();
      if(pc.getLevel() > 20) {
         if(luck > 70 && !pc.checkEquipment("Dragon Armor Leggings")){
            return "Dragon Armor Leggings";
         }
         if(luck < 70 && !pc.checkEquipment("Demon Armor Leggings")){
            return "Demon Armor Leggings";
         }
      }
      if(pc.getLevel() > 10) {
         if(luck > 70 && !pc.checkEquipment("King's Leggings")){
            return "King's Leggings";
         }
         if(luck < 70 && !pc.checkEquipment("Hero's Pants")){
            return "Hero's Pants";
         }
      }
      if(luck > 70 && !pc.checkEquipment("Warrior's Pants")){
         return "Warrior's Pants";
      }
      if(luck < 70 && !pc.checkEquipment("Reinforced Pants")){
         return "Reinforced Pants";
      }
      return "nothing";
   }


}
class headArmor extends armor{
   public void setItem(String item, Protag pc){
	   pc.downgradeShield(equippedDefense);
      equippedName = item;
      switch (item){
         case "Headgear":
            equippedDefense = 0;
            type = "starter"; 
            break;   
         case "Reinforced Headgear":
            equippedDefense = 3;
            type = "reinforced";
            break;
         case "Warrior's Headgear":
            equippedDefense = 6;
            type = "warrior";
            break;
         case "Hero's HeadGear":
            equippedDefense = 10;
            type = "hero";
            break;
         case "King's Helmet":
            equippedDefense = 16;
            type = "king";
            break;
         case "Demon Armor Helmet":
            equippedDefense = 24;
            type = "demon";
            break;
         case "Dragon Armor Helmet":
            equippedDefense = 29;
            type = "dragon";
            break;
      }
   }
   public boolean itemHere(String item) {
	   switch (item){
       case "Headgear":
          return true;  
       case "Reinforced Headgear":
    	   return true;  
       case "Warrior's Headgear":
    	   return true;  
       case "Hero's HeadGear":
    	   return true;  
       case "King's Helmet":
    	   return true;  
       case "Demon Armor Helmet":
    	   return true;  
       case "Dragon Armor Helmet":
    	   return true;  
	   }
	   return false;
   }
   public void printItem(String item){
	   switch (item){
	       case "Headgear":
	          leatherHeadgear();
	          break;   
	       case "Reinforced Headgear":
	          reinforcedHeadgear();
	          break;
	       case "Warrior's Headgear":
	          warriorHeadgear();
	          break;
	       case "Hero's HeadGear":
	          heroHeadgear();
	          break;
	       case "King's Helmet":
	          kingHelmet();
	          break;
	       case "Demon Armor Helmet":
	          demonHelmet();
	          break;
	       case "Dragon Armor Helmet":
	          dragonHelmet();
	          break;
	    }
         
   }
   public void leatherHeadgear() {
      System.out.println("Name - Headgear");
      System.out.println("Defense - 0");
      System.out.println("Type - Starter");
   }
   public void reinforcedHeadgear() {
      System.out.println("Name - Reinforced Headgear");
      System.out.println("Defense - 3");
      System.out.println("Type - Reinforced");
   }
   public void warriorHeadgear() {
      System.out.println("Name - Warrior's Headgear");
      System.out.println("Defense - 6");
      System.out.println("Type - Warrior");
   }
   public void heroHeadgear() {
      System.out.println("Name - Hero's Headgear");
      System.out.println("Defense - 10");
      System.out.println("Type - Hero");
   }
   public void kingHelmet() {
      System.out.println("Name - King's Helmet");
      System.out.println("Defense - 16");
      System.out.println("Type - King");
   }
   public void demonHelmet() {
      System.out.println("Name - Demon Armor Helmet");
      System.out.println("Defense - 24");
      System.out.println("Type - Demon");
   }
   public void dragonHelmet() {
      System.out.println("Name - Dragon Armor Helmet");
      System.out.println("Defense - 29");
      System.out.println("Type - Dragon");
   }
   public String lootItem(Protag pc) {
      int luck = rand.nextInt(100);
      luck += pc.getLuck();
      if(pc.getLevel() > 20) {
         if(luck > 70 && !pc.checkEquipment("Dragon Armor Helmet")){
            return "Dragon Armor Helmet";
         }
         if(luck < 70 && !pc.checkEquipment("Demon Armor Helmet")){
            return "Demon Armor Helmet";
         }
      }
      if(pc.getLevel() > 10) {
         if(luck > 70 && !pc.checkEquipment("King's Helmet")){
            return "King's Helmet";
         }
         if(luck < 70 && !pc.checkEquipment("Hero's HeadGear")){
            return "Hero's HeadGear";
         }
      }
      if(luck > 70 && !pc.checkEquipment("Warrior's Headgear")){
         return "Warrior's Headgear";
      }
      if(luck < 70 && !pc.checkEquipment("Reinforced Headgear")){
         return "Reinforced Headgear";
      }
      return "nothing";
   }

}
class armArmor extends armor{
   public void setItem(String item, Protag pc){
	   pc.downgradeShield(equippedDefense);
      equippedName = item;
      switch (item){
         case "Cotton Sleeves":
            equippedDefense = 0;
            type = "starter"; 
            break;   
         case "Reinforced Sleeves":
            equippedDefense = 3;
            type = "reinforced";
            break;
         case "Warrior's Sleeves":
            equippedDefense = 7;
            type = "warrior";
            break;
         case "Hero's Sleeves":
            equippedDefense = 10;
            type = "hero";
            break;
         case "King's Sleeves":
            equippedDefense = 17;
            type = "king";
            break;
         case "Demon Armor Sleeves":
            equippedDefense = 26;
            type = "demon";
            break;
         case "Dragon Armor Sleeves":
            equippedDefense = 32;
            type = "dragon";
            break;
      }
   }
   public boolean itemHere(String item) {
	   switch (item){
	      case "Cotton Sleeves":
	          return true;  
	      case "Reinforced Sleeves":
	    	  return true; 
	      case "Warrior's Sleeves":
	    	  return true; 
	      case "Hero's Sleeves":
	    	  return true; 
	      case "King's Sleeves":
	    	  return true; 
	      case "Demon Armor Sleeves":
	    	  return true; 
	      case "Dragon Armor Sleeves":
	    	  return true; 
	   }
	   return false;
   }
   public void printItem(String item){
      switch (item){
	      case "Cotton Sleeves":
	          cottonSleeves();
	         break;   
	      case "Reinforced Sleeves":
	         reinforcedSleeves();
	         break;
	      case "Warrior's Sleeves":
	         warriorSleeves();
	         break;
	      case "Hero's Sleeves":
	         heroSleeves();
	         break;
	      case "King's Sleeves":
	         kingSleeves();
	         break;
	      case "Demon Armor Sleeves":
	         demonSleeves();
	         break;
	      case "Dragon Armor Sleeves":
	         dragonSleeves();
	         break;
	   }
         
   }
   public void cottonSleeves() {
      System.out.println("Name - Cotton Sleeves");
      System.out.println("Defense - 0");
      System.out.println("Type - Starter");
   }
   public void reinforcedSleeves() {
      System.out.println("Name - Reinforced Sleeves");
      System.out.println("Defense - 3");
      System.out.println("Type - Reinforced");
   }
   public void warriorSleeves() {
      System.out.println("Name - Warrior's Sleeves");
      System.out.println("Defense - 7");
      System.out.println("Type - Warrior");
   }
   public void heroSleeves() {
      System.out.println("Name - Hero's Sleeves");
      System.out.println("Defense - 10");
      System.out.println("Type - Hero");
   }
   public void kingSleeves() {
      System.out.println("Name - King's Sleeves");
      System.out.println("Defense - 17");
      System.out.println("Type - King");
   }
   public void demonSleeves() {
      System.out.println("Name - Demon Armor Sleeves");
      System.out.println("Defense - 26");
      System.out.println("Type - Demon");
   }
   public void dragonSleeves() {
      System.out.println("Name - Dragon Armor Sleeves");
      System.out.println("Defense - 32");
      System.out.println("Type - Dragon");
   }
   public String lootItem(Protag pc) {
      int luck = rand.nextInt(100);
      luck += pc.getLuck();
      if(pc.getLevel() > 20) {
         if(luck > 70 && !pc.checkEquipment("Dragon Armor Sleeves")){
            return "Dragon Armor Sleeves";
         }
         if(luck < 70 && !pc.checkEquipment("Demon Armor Sleeves")){
            return "Demon Armor Sleeves";
         }
      }
      if(pc.getLevel() > 10) {
         if(luck > 70 && !pc.checkEquipment("King's Sleeves")){
            return "King's Sleeves";
         }
         if(luck < 70 && !pc.checkEquipment("Hero's Sleeves")){
            return "Hero's Sleeves";
         }
      }
      if(luck > 70 && !pc.checkEquipment("Warrior's Sleeves")){
         return "Warrior's Sleeves";
      }
      if(luck < 70 && !pc.checkEquipment("Reinforced Sleeves")){
         return "Reinforced Sleeves";
      }
      return "nothing";
   }


}