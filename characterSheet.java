public class characterSheet{

   private int defenseBonus;
   private int totalArmor;
   headArmor ha;
   torsoArmor ta;
   armArmor aa;
   legArmor la;
   feetArmor fa;
   weapons w;
   
   public characterSheet(headArmor h, torsoArmor t, armArmor a, legArmor l, feetArmor f, weapons ww, Protag pc){
      ha = h;
      ta = t;
      aa = a;
      la = l;
      fa = f;
      w = ww;
      w.setItem("Rusty Sword");
      w.setDurability(w.getDurabilityMax());
      ha.setItem("Headgear", pc);
      ta.setItem("Shirt", pc);
      aa.setItem("Cotton Sleeves", pc);
      la.setItem("Plain Pants", pc);
      fa.setItem("Leather Boots", pc);
      totalArmor = 0;
   }
   
   public void printSheet(){
      System.out.println("Head - " + ha.getName() + " " + ha.getDefense() + " armor");
      System.out.println("Torso - " + ta.getName() + " " + ta.getDefense() + " armor");
      System.out.println("Arms - " + aa.getName() + " " + aa.getDefense() + " armor");
      System.out.println("Legs - " + la.getName() + " " + la.getDefense() + " armor");
      System.out.println("Feet - " + fa.getName() + " " + fa.getDefense() + " armor");
      testBonus();
      System.out.println("Bonus Armor: "+ defenseBonus + " armor");
      System.out.println();
      System.out.println("Weapon - " + w.getName() + " " +w.getAttack() + " attack" + " Durability: " + w.getDurability() +"/"+ w.getDurabilityMax());
   }
   
   public int getTotal(){
      setTotal();
      return totalArmor;
   }
   public void setTotal(){
      testBonus();
      totalArmor = ha.getDefense() + ta.getDefense() + aa.getDefense() + la.getDefense() + fa.getDefense() + defenseBonus;;
   }
   public int getBonus(){
      testBonus();
      return defenseBonus;
   }
   public void testBonus(){
      int which = 0;
      int typeBonus = 0;
      int typeTemp = 0;
      int totalDefense = 0;
      int tempDefense = 0;
      while(which < 4){
         if(which == 0){
            tempDefense = ha.getDefense();
            if(ha.getType() == ta.getType()){
               typeTemp++;
               tempDefense += ta.getDefense();
            }
            if(ha.getType() == aa.getType()){
               typeTemp++;
               tempDefense += aa.getDefense();
            }
            if(ha.getType() == la.getType()){
               typeTemp++;
               tempDefense += la.getDefense();
            }
            if(ha.getType() == fa.getType()){
               typeTemp++;
               tempDefense += fa.getDefense();
            }
            if(typeTemp > typeBonus){
               typeBonus= typeTemp;
               totalDefense = tempDefense;
            }
         }else if(which == 1){
            tempDefense = ta.getDefense();
            if(ta.getType() == aa.getType()){
               typeTemp++;
               tempDefense += aa.getDefense();
            }
            if(ta.getType() == la.getType()){
               typeTemp++;
               tempDefense += la.getDefense();
            }
            if(ta.getType() == fa.getType()){
               typeTemp++;
               tempDefense += fa.getDefense();
            }
            if(typeTemp > typeBonus){
               typeBonus= typeTemp;
               totalDefense = tempDefense;
            }
         }else if(which == 2){
            tempDefense = aa.getDefense();
            if(aa.getType() == la.getType()){
               typeTemp++;
               tempDefense += la.getDefense();
            }
            if(aa.getType() == fa.getType()){
               typeTemp++;
               tempDefense += fa.getDefense();
            }
            if(typeTemp > typeBonus){
               typeBonus= typeTemp;
               totalDefense = tempDefense;
            }
         }else{
            tempDefense = la.getDefense();
            if(la.getType() == fa.getType()){
               typeTemp++;
               tempDefense += fa.getDefense();
            }
            if(typeTemp > typeBonus){
               typeBonus= typeTemp;
               totalDefense = tempDefense;
            }
         }
         which++;
      }
      if(typeBonus == 0){
         defenseBonus = 0;
      }
      if(typeBonus == 1){
         defenseBonus = (int) Math.ceil(totalDefense * 0.05);
      }
      if(typeBonus == 2){
         defenseBonus = (int) Math.ceil(totalDefense * 0.1);
      }
      if(typeBonus == 3){
         defenseBonus = (int) Math.ceil(totalDefense * 0.15);
      }
      if(typeBonus == 4){
         defenseBonus = (int) Math.ceil(totalDefense * 0.2);
      }
   }

}