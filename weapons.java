
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
      case "Steel Sword": 
         equippedAttack = 6;
         durabilityMax = 100;
         break;
      case "Damascus Sword": 
         equippedAttack = 10;
         durabilityMax = 150;
         break;
      case "Tamahagane Sword": 
         equippedAttack = 12;
         durabilityMax = 130;
         break;
      default:
         equippedAttack = 1;
         durabilityMax = 1;
      }
      
         

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