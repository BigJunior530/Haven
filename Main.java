import java.util.*;

public class Main {

   public static Scanner console = new Scanner(System.in);
   public static Random rand = new Random();
   public static int helmet = 0;
   public static int chest = 0;
   public static int leg = 0;
   public static int ran = 0;
   public static boolean run = false;
   public static boolean adventure = true;

   public static void main(String[] args) throws InterruptedException {
      enterGame();
      if(run == true) {
    	  Protag pc = new Protag();
    	  Story.intro();
    	  start(pc);
      }
            
   }
      
     private static void enterGame() throws InterruptedException{
    	 System.out.println("Haven");
    	 System.out.println("Press 1 to start Game");
    	 System.out.println("Press 2 to exit");
    	 int start = console.nextInt();
    	 if(start == 1) {
    		 run = true;
    	 }
    	 Story.clearScreen();
     }
      
   private static void choice() throws InterruptedException {
      sleep500();
      Thread.sleep(500);
      System.out.println("\nWhat do you want to do for your turn?");
      System.out.println("Enter in your choice using the numbers 1-3");
      System.out.println("1: Attack");
      System.out.println("2: Inventory");
      System.out.println("3: Run");
   }
   private static <E> void battle(Protag pc, E ek) throws InterruptedException {
      System.out.println("_________________________________________________________________");
      ((CharEntities) ek).enemy();
      pc.sprite();
      System.out.println("_________________________________________________________________");
   }
      
   private static void rest(Protag pc) throws InterruptedException {
      Story.Check();
      console.nextLine();
      int choice = console.nextInt();
            
            // Main character choice
      switch (choice){
         case 1:
            Inventory(pc);
            break;
         case 2: 
        	 checkStats(pc);
             rest(pc);
            return;
         case 3:
        	 if(pc.getPoints() < 1) {
        		 System.out.println("No points available");
        	 }else {
        		 System.out.println("Points: " + pc.getPoints());
        		 System.out.println("What do you want to upgrade?");
        		 System.out.println("1. Attack");
        		 System.out.println("2. Defense");
        		 System.out.println("3. Health");
        		 console.nextLine();
        		 int answer = console.nextInt();
        		 switch(answer) {
        		 	case 1:
        		 		System.out.print("Attack: " + pc.getAttack() + "-->");
        		    	pc.upgradeAttack(1);
        		    	System.out.print(pc.getAttack()+ "\n");
        		    	break;
        		 	case 2:
        		 		System.out.print("Shield: " + pc.getShield() + "-->");
        		    	pc.upgradeShield(1);
        		    	System.out.print(pc.getShield()+ "\n");
        		    	break;
        		 	case 3:
        		 		System.out.print("Total Health: " + pc.getTotal() + "-->");
        		    	pc.upgradeHealth(1);
        		    	System.out.print(pc.getTotal()+ "\n");
        		    	break;
        		 	default:
                        // DEFAULT
        		 		break;
        		 }
        		 
        	 }
         case 4:
        	 return;
         default:
                        // DEFAULT
            break;
      }
   }
   private static <E> void Inventory(Protag pc) throws InterruptedException {
      sleep500();
      Thread.sleep(500);
      System.out.println("\nWhat do you want to do?");
      System.out.println("Enter in your choice using the numbers 1-3");
      System.out.println("1: Items");
      System.out.println("2: Equipment");
      System.out.println("3: Return");
      console.nextLine();
      int choice = console.nextInt();
          
          // Main character choice
      switch (choice){
         case 1:
            boolean has = pc.getItems();
            if(has) {
               console.nextLine();
               System.out.println("Which one do you want to use?");
               int reply = console.nextInt();
               String c = pc.getItem(reply - 1);
               if(c.equalsIgnoreCase("Health Potion")) {
                  Items.healthPotion();
                  pc.heal(25);
               } else if(c.equalsIgnoreCase("Duct tape")) {
                  Items.ductTape();
                  pc.upgradeShield(2);
               }else if(c.equalsIgnoreCase("Stregnth Potion")) {
                  Items.strengthPotion();
                  pc.upgradeAttack(3);
               } 
               pc.removeItem(c);
            }
            rest(pc);
            return;
         case 2:
            boolean has1 = pc.getEquipment();
            if(has1) {
               console.nextLine();
               System.out.println("Which one do you want to use?");
               int reply = console.nextInt();
               String c = pc.getEquipment(reply - 1);
               if(c.equalsIgnoreCase("Helmet")) {
                  Equipment.helmet();
                  pc.upgradeShield(1);
               }else if(c.equalsIgnoreCase("Chest Plate")) {
                  Equipment.chestPlate();
                  pc.upgradeShield(3);
               }else if(c.equalsIgnoreCase("Leggings")) {
                  Equipment.leggings();
                  pc.upgradeShield(2);
               }
               pc.removeEquipment(c);
            }
            rest(pc);
            return;
         case 3:
            rest(pc);
            return;
         default:
                      // DEFAULT
            break;
      }
   }
   private static <E> void checkStats(Protag pc) throws InterruptedException {
        System.out.println("Total Health: " + pc.getTotal());
    	  System.out.println("Attack: " + pc.getAttack());
    	  System.out.println("Shield: " + pc.getShield());
    	  System.out.println("Points: " + pc.getPoints());
    	  System.out.println("Level: " + pc.getLevel());
        System.out.println("Health: " + pc.getHealth());
        
   }
   private static <E> void attacksStarter(Protag pc, E ek, String name) throws InterruptedException {
      System.out.println("\nWhat Attack do you want to use?");
      System.out.println("Enter in your choice using the numbers 1-3");
      System.out.println("1: Basic Attack");
      System.out.println("2: Toughen");
      System.out.println("3: Return");
      console.nextLine();
      int choice = console.nextInt();
          
          // Main character choice
      switch (choice){
         case 1:
            Basic(pc, ek, name);
            break;
         case 2:
        	 pc.increaseShieldTemp();
        	 break;
         case 3:
            fightSequence(pc, ek, name);
            return;
         default:
                      // DEFAULT
            break;
      }
   }
   private static <E> void attacksMid(Protag pc, E ek, String name) throws InterruptedException {
      System.out.println("\nWhat Attack do you want to use?");
      System.out.println("Enter in your choice using the numbers 1-4");
      System.out.println("1: Basic Attack");
      System.out.println("2: Toughen");
      System.out.println("3: Strong Attack");
      System.out.println("4: Return");
      console.nextLine();
      int choice = console.nextInt();
          
          // Main character choice
      switch (choice){
         case 1:
            Basic(pc, ek, name);
            break;
         case 2:
        	 pc.increaseShieldTemp();
        	 break;
         case 3:
            Strong(pc, ek, name);
            break;
         case 4:
            fightSequence(pc, ek, name);
            return;
         default:
                      // DEFAULT
            break;
      }
   }
   private static <E> void attacksMaster(Protag pc, E ek, String name) throws InterruptedException {
      System.out.println("\nWhat Attack do you want to use?");
      System.out.println("Enter in your choice using the numbers 1-5");
      System.out.println("1: Basic Attack");
      System.out.println("2: Toughen");
      System.out.println("3: Strong Attack");
      System.out.println("4: Triple Attack");
      System.out.println("5: Return");
      console.nextLine();
      int choice = console.nextInt();
          
          // Main character choice
      switch (choice){
         case 1:
            Basic(pc, ek, name);
            break;
         case 2:
        	 pc.increaseShieldTemp();
        	 break;
         case 3:
            Strong(pc, ek, name);
            break;
         case 4:
            Triple(pc, ek, name);
            break;
         case 5:
            fightSequence(pc, ek, name);
            return;
         default:
                      // DEFAULT
            break;
      }
   }
   private static <E> void attacksGod(Protag pc, E ek, String name) throws InterruptedException {
	      System.out.println("\nWhat Attack do you want to use?");
	      System.out.println("Enter in your choice using the numbers 1-6");
	      System.out.println("1: Basic Attack");
	      System.out.println("2: Toughen");
	      System.out.println("3: Strong Attack");
	      System.out.println("4: Triple Attack");
	      System.out.println("5: Sharpen");
	      System.out.println("6: Return");
	      console.nextLine();
	      int choice = console.nextInt();
	          
	          // Main character choice
	      switch (choice){
	         case 1:
	            Basic(pc, ek, name);
	            break;
	         case 2:
	        	 pc.increaseShieldTemp();
	        	 break;
	         case 3:
	            Strong(pc, ek, name);
	            break;
	         case 4:
	            Triple(pc, ek, name);
	            break;
	         case 5:
	        	 pc.increaseAttackTemp();
	        	 break;
	         case 6:
	            fightSequence(pc, ek, name);
	            return;
	         default:
	                      // DEFAULT
	            break;
	      }
	   }
   private static <E> void Inventory(Protag pc, E ek, String name) throws InterruptedException {
      sleep500();
      Thread.sleep(500);
      System.out.println("\nWhat do you want to do?");
      System.out.println("Enter in your choice using the numbers 1-3");
      System.out.println("1: Items");
      System.out.println("2: Equipment");
      System.out.println("3: Return");
      console.nextLine();
      int choice = console.nextInt();
          
          // Main character choice
      switch (choice){
         case 1:
            boolean has = pc.getItems();
            if(has) {
               console.nextLine();
               System.out.println("Which one do you want to use?");
               int reply = console.nextInt();
               String c = pc.getItem(reply - 1);
               if(c.equalsIgnoreCase("Health Potion")) {
                  Items.healthPotion();
                  pc.heal(25);
               } else if(c.equalsIgnoreCase("Duct tape")) {
                  Items.ductTape();
                  pc.upgradeShield(2);
               }else if(c.equalsIgnoreCase("Stregnth Potion")) {
                  Items.strengthPotion();
                  pc.upgradeAttack(3);
               } 
               pc.removeItem(c);
            }
            return;
         case 2:
            boolean has1 = pc.getEquipment();
            if(has1) {
               console.nextLine();
               System.out.println("Which one do you want to use?");
               int reply = console.nextInt();
               String c = pc.getEquipment(reply - 1);
               if(c.equalsIgnoreCase("Helmet")) {
                  Equipment.helmet();
                  pc.upgradeShield(1);
               }else if(c.equalsIgnoreCase("Chest Plate")) {
                  Equipment.chestPlate();
                  pc.upgradeShield(3);
               }else if(c.equalsIgnoreCase("Leggings")) {
                  Equipment.leggings();
                  pc.upgradeShield(2);
               }
               pc.removeEquipment(c);
            }
            return;
         case 3:
            fightSequence(pc, ek, name);
            return;
         default:
                      // DEFAULT
            break;
      }
   }
   private static <E> void Basic(Protag pc, E ek, String name) throws InterruptedException {
      int p1Attack;
      p1Attack = pc.getAttack();
      System.out.println("You dealt " + p1Attack + " damage");
      ((CharEntities) ek).damage(p1Attack);
      if(((CharEntities) ek).getHealth() > 0) {
         System.out.println("The " + name + " has only " + ((CharEntities) ek).getHealth() + " health left!");
      }else {
         ((CharEntities) ek).endMessage();
         int b = ((CharEntities) ek).getAttack();
         pc.setExp(b);
         int chance = rand.nextInt(6);
        	  
         if(chance > 2) {
            System.out.println("You got nothing...");
         }else if(chance > 4) {
            int item = rand.nextInt(3);
            if(item == 0) {
               System.out.println("You got a Health potion!");
               pc.putItems("Health Potion");
            }else if(item == 1) {
               System.out.println("You got Duck tape!");
               pc.putItems("Duct tape");
            }else if(item == 2) {
               System.out.println("You got a Stregnth potion!");
               pc.putItems("Stregnth Potion");
            }
         }else {
         	  
            if(helmet == 0) {
               System.out.println("You got a Helmet!");
               pc.putEquipment("Helmet");
               helmet++;
            }else if(chest == 0) {
               System.out.println("You got a Chest Plate!");
               pc.putEquipment("Chest Plate");
               chest++;
            }else if(leg == 0) {
               System.out.println("You got Leggings!");
               pc.putEquipment("Leggings");
               leg++;
            }else {
               System.out.println("You got nothing...");
            }
         	  
         }
         return;
      }
   }
      
   private static <E> void Strong(Protag pc, E ek, String name) throws InterruptedException {
      int p1Attack; 
      p1Attack = pc.getAttack() + (pc.getAttack()/2);
      pc.damage(4*pc.getLevel());
      System.out.println("You dealt " + p1Attack + " damage");
      System.out.println("Recoil " + (4*pc.getLevel()) + " damage");
      ((CharEntities) ek).damage(p1Attack);
      if(((CharEntities) ek).getHealth() > 0) {
         System.out.println("The " + name + " has only " + ((CharEntities) ek).getHealth() + " health left!");
      }else {
    	  ((CharEntities) ek).endMessage();
         int b = ((CharEntities) ek).getAttack();
         pc.setExp(b);
         int chance = rand.nextInt(6);
        	  
         if(chance > 2) {
            System.out.println("You got nothing...");
         }else if(chance > 4) {
            int item = rand.nextInt(3);
            if(item == 0) {
               System.out.println("You got a Health potion!");
               pc.putItems("Health Potion");
            }else if(item == 1) {
               System.out.println("You got Duck tape!");
               pc.putItems("Duct tape");
            }else if(item == 2) {
               System.out.println("You got a Stregnth potion!");
               pc.putItems("Stregnth Potion");
            }
         }else {
         	  
            if(helmet == 0) {
               System.out.println("You got a Helmet!");
               pc.putEquipment("Helmet");
               helmet++;
            }else if(chest == 0) {
               System.out.println("You got a Chest Plate!");
               pc.putEquipment("Chest Plate");
               chest++;
            }else if(leg == 0) {
               System.out.println("You got Leggings!");
               pc.putEquipment("Leggings");
               leg++;
            }else {
               System.out.println("You got nothing...");
            }
         	  
         }
         return;
      }
   }
   private static <E> void Triple(Protag pc, E ek, String name) throws InterruptedException {
      int p1Attack;
      int count;
      count = 0;
      p1Attack = rand.nextInt(pc.getAttack());
      while(count < 4 && ((CharEntities) ek).getHealth() > 0) {
         System.out.println("You dealt " + p1Attack + " damage");
         ((CharEntities) ek).damage(p1Attack);
      }
      if(((CharEntities) ek).getHealth() > 0) {
         System.out.println("The " + name + " has only " + ((CharEntities) ek).getHealth() + " health left!");
      }else {
    	  ((CharEntities) ek).endMessage();
         int b = ((CharEntities) ek).getAttack();
         pc.setExp(b);
         int chance = rand.nextInt(6);
        	  
         if(chance > 2) {
            System.out.println("You got nothing...");
         }else if(chance > 4) {
            int item = rand.nextInt(3);
            if(item == 0) {
               System.out.println("You got a Health potion!");
               pc.putItems("Health Potion");
            }else if(item == 1) {
               System.out.println("You got Duck tape!");
               pc.putItems("Duct tape");
            }else if(item == 2) {
               System.out.println("You got a Stregnth potion!");
               pc.putItems("Stregnth Potion");
            }
         }else {
         	  
            if(helmet == 0) {
               System.out.println("You got a Helmet!");
               pc.putEquipment("Helmet");
               helmet++;
            }else if(chest == 0) {
               System.out.println("You got a Chest Plate!");
               pc.putEquipment("Chest Plate");
               chest++;
            }else if(leg == 0) {
               System.out.println("You got Leggings!");
               pc.putEquipment("Leggings");
               leg++;
            }else {
               System.out.println("You got nothing...");
            }
         	  
         }
         return;
      }
   }
   private static void start(Protag pc) throws InterruptedException {
      int answer = console.nextInt();
      if(answer == 1) {
         Story.East();
         WildBoar ek = new WildBoar(pc);
         System.out.println("Your health is " + pc.getHealth()); 
      
              
         fightSequence(pc, ek, "Boar");
         Story.Encounter(pc);
         Story.Mid();
         int response = console.nextInt();
         if(response == 1) {
            rest(pc);
            Story.Tired();
            FlyingSquirrel fs = new FlyingSquirrel(pc);
            System.out.println("Your health is " + pc.getHealth()); 
         
                  
            fightSequence(pc, fs, "Flying Squirrel");
            Story.Encounter(pc);
         }else {
            rest(pc);
            Story.Relax();
            KoiFish kf = new KoiFish(pc);
            System.out.println("Your health is " + pc.getHealth()); 
         
                  
            fightSequence(pc, kf, "Koi Fish");
            Story.Encounter(pc);
         }
         rest(pc);
         Story.Close();
         System.out.println("Your health is " + pc.getHealth()); 
         Wolf ke = new Wolf(pc);
         ke.intro();
         fightSequence(pc, ke, "Wolf");
         Story.Encounter(pc);
      }else {
         Story.West();
         System.out.println("Your health is " + pc.getHealth()); 
         Wolf ke = new Wolf(pc);
          	
         fightSequence(pc, ke, "Wolf");
         Story.Encounter(pc);
         Story.Mid();
         int response = console.nextInt();
         if(response == 1) {
            rest(pc);
            Story.Tired();
            FlyingSquirrel fs = new FlyingSquirrel(pc);
            System.out.println("Your health is " + pc.getHealth()); 
         
                  
            fightSequence(pc, fs, "Flying Squirrel");
            Story.Encounter(pc);
         }else {
            rest(pc);
            Story.Relax();
            KoiFish kf = new KoiFish(pc);
            System.out.println("Your health is " + pc.getHealth()); 
         
                  
            fightSequence(pc, kf, "Koi Fish");
            Story.Encounter(pc);
         }
         rest(pc);
         Story.Close();
         WildBoar ek = new WildBoar(pc);
         System.out.println("Your health is " + pc.getHealth()); 
      
              
         fightSequence(pc, ek, "Boar");
         Story.Encounter(pc);
          	
      }
      Story.choice();
      answer = console.nextInt();
      if(answer == 1) {
         adventure = false;
    	 Story.homeLand();
         end(pc);
      }else {
         Story.adventure();
         end(pc);
      }
   }

   private static void end(Protag pc) throws InterruptedException {
      int ans = console.nextInt();
      switch (ans){
         case 1:
            North(pc);
            break;
         case 2:
            South(pc);
            break;
         case 3:
            Ocean(pc);
            break;
         default:
                // DEFAULT
            break;
      }
          
   }
   private static void North(Protag pc) throws InterruptedException {
      Story.North();
      int ans = console.nextInt();
      if(ans == 1) {
         rest(pc);
         Story.Snowy();
         Ram r = new Ram(pc);
         System.out.println("Your health is " + pc.getHealth()); 
      
                
         fightSequence(pc, r, "Ram");
         Story.Encounter(pc);
         rest(pc);
         if(adventure) {
        	 Story.adMoutain();
        	 Eagle e = new Eagle(pc);
             System.out.println("Your health is " + pc.getHealth()); 
          
                    
             fightSequence(pc, e, "Eagle");
             Story.Encounter(pc);
             rest(pc);
         }else {
        	 Story.civMoutain();
        	 Yak y = new Yak(pc);
             System.out.println("Your health is " + pc.getHealth()); 
          
                    
             fightSequence(pc, y, "Yak");
             Story.Encounter(pc);
             rest(pc);
         }
         Story.Moutain();
         MountainLion ml = new MountainLion(pc);
         System.out.println("Your health is " + pc.getHealth()); 
      
                
         fightSequence(pc, ml, "Mountain Lion");
         Story.Encounter(pc);
      	  
      }else {
         rest(pc);
         Story.Frozen();
         Owl o = new Owl(pc);
         System.out.println("Your health is " + pc.getHealth()); 
      
                
         fightSequence(pc, o, "Owl");
         Story.Encounter(pc);
         rest(pc);
         if(adventure) {
        	 Story.adTundra();
        	 Fox f = new Fox(pc);
             System.out.println("Your health is " + pc.getHealth()); 
          
                    
             fightSequence(pc, f, "Fox");
             Story.Encounter(pc);
             rest(pc);
         }else {
        	 Story.civTundra();
        	 Penguin p = new Penguin(pc);
             System.out.println("Your health is " + pc.getHealth()); 
          
                    
             fightSequence(pc, p, "Penguin");
             Story.Encounter(pc);
             rest(pc);
         }
         Story.Tundra();
         PolarBear pb = new PolarBear(pc);
         System.out.println("Your health is " + pc.getHealth()); 
      
                
         fightSequence(pc, pb, "Polar Bear");
         Story.Encounter(pc);
      }
      Story.next();
      end(pc);
          
   }
   private static void South(Protag pc) throws InterruptedException {
      Story.South();
      int ans = console.nextInt();
      if(ans == 1) {
         rest(pc);
         Story.Scorching();
         Vulture v = new Vulture(pc);
         System.out.println("Your health is " + pc.getHealth()); 
      
                
         fightSequence(pc, v, "Vulture");
         Story.Encounter(pc);
         rest(pc);
         if(adventure) {
        	 Story.adDesert();
        	 RattleSnake rs = new RattleSnake(pc);
             System.out.println("Your health is " + pc.getHealth()); 
          
                    
             fightSequence(pc, rs, "Rattle Snake");
             Story.Encounter(pc);
             rest(pc);
         }else {
        	 Story.civDesert();
        	 Scorpion s = new Scorpion(pc);
             System.out.println("Your health is " + pc.getHealth()); 
          
                    
             fightSequence(pc, s, "Scorpion");
             Story.Encounter(pc);
             rest(pc);
         }
         Story.Desert();
         Komodo k = new Komodo(pc);
         System.out.println("Your health is " + pc.getHealth()); 
      
                
         fightSequence(pc, k, "Komodo Dragon");
         Story.Encounter(pc);
      	  
      }else {
         rest(pc);
         Story.Green();
         Frog f = new Frog(pc);
         System.out.println("Your health is " + pc.getHealth()); 
      
                
         fightSequence(pc, f, "Frog");
         Story.Encounter(pc);
         rest(pc);
         if(adventure) {
        	 Story.adJungle();
        	 Piranha p = new Piranha(pc);
             System.out.println("Your health is " + pc.getHealth()); 
          
                    
             fightSequence(pc, p, "Piranha");
             Story.Encounter(pc);
             rest(pc);
         }else {
        	 Story.civJungle();
        	 Chimpanzee c = new Chimpanzee(pc);
             System.out.println("Your health is " + pc.getHealth()); 
          
                    
             fightSequence(pc, c, "Chimpanzee");
             Story.Encounter(pc);
             rest(pc);
         }
         Story.Jungle();
         Panther bp = new Panther(pc);
         System.out.println("Your health is " + pc.getHealth()); 
      
                
         fightSequence(pc, bp, "Panther");
         Story.Encounter(pc);
      }
      Story.next();
      end(pc);
   }
   private static void Ocean(Protag pc) throws InterruptedException {
      Story.Ocean();
      int ans = console.nextInt();
      if(ans == 1) {
         rest(pc);
         Story.Bermuda();
         Alien a = new Alien(pc);
         System.out.println("Your health is " + pc.getHealth()); 
      
                
         fightSequence(pc, a, "Alien");
         Story.Encounter(pc);
         rest(pc);
         if(adventure) {
        	 Story.adTriangle();
        	 Kraken k = new Kraken(pc);
             System.out.println("Your health is " + pc.getHealth()); 
          
                    
             fightSequence(pc, k, "Kraken");
             Story.Encounter(pc);
             rest(pc);
         }else {
        	 Story.civTriangle();
        	 JellyFish jf = new JellyFish(pc);
             System.out.println("Your health is " + pc.getHealth()); 
          
                    
             fightSequence(pc, jf, "JellyFish");
             Story.Encounter(pc);
             rest(pc);
         }
         Story.Triangle();
         Hydra h = new Hydra(pc);
         System.out.println("Your health is " + pc.getHealth()); 
      
                
         fightSequence(pc, h, "Hydra");
         Story.Encounter(pc);
      	  
      }else {
         rest(pc);
         Story.City();
         Mermaid m = new Mermaid(pc);
         System.out.println("Your health is " + pc.getHealth()); 
      
                
         fightSequence(pc, m, "Mermaid");
         Story.Encounter(pc);
         rest(pc);
         if(adventure) {
        	 Story.adAlantis();
        	 Poseidon p = new Poseidon(pc);
             System.out.println("Your health is " + pc.getHealth()); 
          
                    
             fightSequence(pc, p, "Poseidon");
             Story.Encounter(pc);
             rest(pc);
         }else {
        	 Story.civAlantis();
        	 Shark s = new Shark(pc);
             System.out.println("Your health is " + pc.getHealth()); 
          
                    
             fightSequence(pc, s, "Shark");
             Story.Encounter(pc);
             rest(pc);
         }
         Story.Alantis();
         Leviathan l = new Leviathan(pc);
         System.out.println("Your health is " + pc.getHealth()); 
      
                
         fightSequence(pc, l, "Leviathan");
         Story.Encounter(pc);
      }
      Story.next();
      end(pc);
   }
   //Possible method to use for choosing mood of monster
//   public static String mood() {
//	   String type = " ";
//       
//       int mood = rand.nextInt(3) + 1;
//       	if(mood == 0) {
//       		type = "Angry";
//       		
//       	}else if(mood == 1) {
//       		type = "Calm";
//       	}
//       	return type;
//   }
   private static <E> void fightSequence(Protag pc, E ek, String name) throws InterruptedException {
      Story.clearScreen(); 
      ((CharEntities) ek).intro();
      int run = ran;
      while (!(pc.getHealth() <= 0) || !(((CharEntities) ek).getHealth() <= 0) || run == ran) {
         battle(pc, ek);     
         int CPUAttack;
         int p1Defence = pc.getShield();
         choice();
         console.nextLine();
         int choice = console.nextInt();
                  
                  // Main character choice
         switch (choice){
            case 1:
               int level = pc.getLevel();
               if(level < 3) {
                  attacksStarter(pc, ek, name);
               }else if(level >= 3 && level < 7) {
                  attacksMid(pc, ek, name);
               }else if(level >= 7 && level < 10){
                  attacksMaster(pc, ek, name);
               }else {
            	   attacksGod(pc, ek, name);
               }
               if(pc.getHealth()<0){
                   System.out.println("You fainted...");
                   System.out.println("You wake up again hours later");
                   pc.setHealth(pc.getTotal());
                   System.out.println("Your health is " + pc.getHealth());
                   return;
                }
                              // something regarding ATTACK
               break;
            case 2:
               Inventory(pc, ek, name);
                              
                              // something regarding ITEMS
               break;
            case 3:
            	//possibly broken where even if you do run away, it'll still keep the battle going
            	//add something to make sure the run away worked
            	int chance = rand.nextInt(5);
            	if(chance >= 3) {
            		System.out.println("You ran away!!");
                    ran++;
            		return;
            	}
            	System.out.println("You couldn't run away...");
               break;
            default:
                              // DEFAULT
               break;
         }
         if((pc.getHealth() <= 0) || (((CharEntities) ek).getHealth() <= 0) || run != ran){
            return;
         }
         
                  // CPU choice
                  //Switch back to four when you want to add leaving again
         int num = rand.nextInt(2) + 1;
         sleep500();
         switch (num){
             //Too common and makes the game uninteresting
             // case 1:
//                System.out.println(name + " does NOTHING.");
                               //something regarding DEFENCE
//                break;
            case 1:
            	CPUAttack = ((CharEntities) ek).getMove(pc);
                if(CPUAttack - p1Defence > 0) {
                         		
                   CPUAttack = CPUAttack - p1Defence;
                }else {
                   CPUAttack = 0;
                   System.out.println("No damage taken.");
                }
                System.out.println("Damage taken " + CPUAttack);
                pc.damage(CPUAttack);
                if(pc.getHealth()>0) {
                   System.out.println("Your health is " + pc.getHealth()); 
                }else {
                   System.out.println("You fainted...");
                   System.out.println("You wake up again hours later");
                   pc.setHealth(pc.getTotal());
                   System.out.println("Your health is " + pc.getHealth());
                   return;
                }
                              // something regarding ATTACK
               break;
            case 2:
               CPUAttack = ((CharEntities) ek).getMove(pc);
               if(CPUAttack - p1Defence > 0) {
                        		
                  CPUAttack = CPUAttack - p1Defence;
               }else {
                  CPUAttack = 0;
                  System.out.println("No damage taken.");
               }
               System.out.println("Damage taken " + CPUAttack);
               pc.damage(CPUAttack);
               if(pc.getHealth()>0) {
                  System.out.println("Your health is " + pc.getHealth()); 
               }else {
                  System.out.println("You fainted...");
                  System.out.println("You wake up again hours later");
                  pc.setHealth(50);
                  System.out.println("Your health is " + pc.getHealth());
                  return;
               }
                              // something ITEMS
               break;
                        //case 4:
                        	//System.out.println(name + " LEAVES");	
                        	//return;
            default:
                              // DEFAULT
               break;
         }
      }
   }
      
   public static void sleep500() throws InterruptedException {
      for(int i = 0; i <= 4; i++){
         Thread.sleep(500);
         System.out.print(".");
      }
   }
}
