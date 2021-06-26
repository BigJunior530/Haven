import java.util.*;
/**
 * This is the main for the game
 * 
 * @author Carlos
 *
 */
public class Main {

   public static Scanner console = new Scanner(System.in);
   public static Random rand = new Random();
   public static int ran = 0;
   public static boolean run = false;
   public static boolean adventure = true;
   public static int type = 1;
   public static boolean fullCounter = true;
   public static boolean miss = true;
   public static String direction = "";
   public static boolean won = true;
   public static int copper = 0;
   public static int silver = 0;
   public static int gold = 0;
   public static int platinum = 0;
   public static boolean boat = false;
   public static Protag pc;
   public static headArmor ha = new headArmor();
   public static torsoArmor ta = new torsoArmor();
   public static armArmor aa = new armArmor();
   public static legArmor la = new legArmor();
   public static feetArmor fa = new feetArmor();
   public static weapons w = new weapons();
   public static characterSheet cs;
   
   /**
    * This is where the game starts
    * 
    * @param args
    * @throws InterruptedException
    */
   public static void main(String[] args) throws InterruptedException {
      enterGame();
      if(run == true) {
         pc = new Protag(type);
         cs = new characterSheet(ha, ta, aa, la, fa, w, pc);
         pc.upgradeAttack(w.getAttack());
         int item = rand.nextInt(4);
         if(item == 0) {
            pc.putItems("Health Potion");
         }else if(item == 1) {
            pc.putItems("Scotch tape");
         }else if(item == 2) {
            pc.putItems("Attack Potion");
         }else {
            pc.putItems("Luck Potion");
         }
         Story.intro(pc);
         start();
      }
            
   }
     /**
      * This is the starting menu
      *  
      * @throws InterruptedException
      */
   private static void enterGame() throws InterruptedException{
      System.out.println(" _    _     __      ________ _   _ ");
      System.out.println("| |  | |   /\\ \\    / /  ____| \\ | |");
      System.out.println("| |__| |  /  \\ \\  / /| |__  |  \\| |");
      System.out.println("|  __  | / /\\ \\ \\/ / |  __| | . ` |");
      System.out.println("| |  | |/ ____ \\  /  | |____| |\\  |");
      System.out.println("|_|  |_/_/    \\_\\/   |______|_| \\_|");
      System.out.println();
      System.out.println("Start a game by picking a class.");
      System.out.println("Press 0 to  be a Barbarian(High-Health/Mid-Attack/Low-Shield/Low-Luck)");
      System.out.println("Press 1 to  be a Warrior(Low-Health/High-Attack/Mid-Shield/Mid-Luck)");
      System.out.println("Press 2 to  be a Knight(Mid-Health/Low-Attack/High-Shield/High-Luck)");
      System.out.println("Press 3 to exit");
      int start = inputVerification(0, 3);
      if(start == 0 || start == 1 || start == 2) {
         run = true;
         type = start;
         Story.clearScreen();
      }else {
         Story.clearScreen();
         System.out.println("Goodbye...");
      }
    	 
   }
   /**
    * This is prints out your options during a battle
    *    
    * @throws InterruptedException
    */
   private static void choice() throws InterruptedException {
      sleep500();
      Thread.sleep(250);
      System.out.println("\nWhat do you want to do for your turn?");
      System.out.println("Enter in your choice using the numbers 1-3");
      System.out.println("1: Attack");
      System.out.println("2: Inventory");
      System.out.println("3: Run");
   }
   /**
    * This method prints out the sprites for the user and enemy
    * 
    * @param <E>
    * @param ek is enemy class
    * @throws InterruptedException
    */
   private static <E> void battle(E ek) throws InterruptedException {
      System.out.println("_________________________________________________________________");
      System.out.println("                                          Health: "+ ((CharEntities) ek).getHealth());
      ((CharEntities) ek).enemy();
      pc.sprite();
      System.out.println("Health: "+ pc.getHealth() + "/" + pc.getTotal());
      System.out.println("_________________________________________________________________");
   }
   /**
    * This method is a switch case method to get what you choose during the resting period
    * 
    */
   private static void rest() throws InterruptedException {
      Story.Check();
      int choice = inputVerification(1,5);
            
            // Main character choice
      switch (choice){
         case 1:
            Inventory();
            break;
         case 2:
        	 cs.printSheet();
        	 rest();
        	 break;
         case 3: 
            checkStats();
            rest();
            return;
         case 4:
            if(pc.getPoints() < 1) {
               System.out.println("No points available");
            }else {
               System.out.println("Points: " + pc.getPoints());
               System.out.println("What do you want to upgrade?");
               System.out.println("1. Attack");
               System.out.println("2. Defense");
               System.out.println("3. Health");
               System.out.println("4. Luck");
               int answer = inputVerification(1,4);
               switch(answer) {
                  case 1:
                     System.out.print("Attack: " + pc.getAttack() + "-->");
                     pc.upgradeAttack(1);
                     pc.usePoint(1);
                     System.out.print(pc.getAttack()+ "\n");
                     break;
                  case 2:
                     System.out.print("Shield: " + pc.getShield() + "-->");
                     pc.upgradeShield(1);
                     pc.usePoint(1);
                     System.out.print(pc.getShield()+ "\n");
                     break;
                  case 3:
                     System.out.print("Total Health: " + pc.getTotal() + "-->");
                     pc.upgradeHealth(3);
                     pc.usePoint(1);
                     System.out.print(pc.getTotal()+ "\n");
                     break;
                  case 4:
                     System.out.print("Luck: " + pc.getLuck() + "-->");
                     pc.upgradeLuck(1);
                     pc.usePoint(1);
                     System.out.print(pc.getLuck()+ "\n");
                     break;
                  default:
                        // DEFAULT
                     break;
               }
             
            }
            rest();
            break;
         case 5:
        	 store();
        	 rest();
        	 break;
         case 6:
            return;
         default:
        	 System.out.println("Bad input...");
             rest();
            break;
      }
   }
   /**
    * This method allows the player to access what's inside while in rest
    * 
    * @param <E>
    * @throws InterruptedException
    */
   private static <E> void Inventory() throws InterruptedException {
	   itemEquip();
      int choice = inputVerification(1,3);
        if(choice == 3) {
        	rest();
        }else {
           boolean a = itemsEquipment(choice);
        	if(a) {
        		rest();
        	}else {
        		Inventory();
        	}
        }
   }
  
/**
    * This method allows the player to check their stats during resting periods
    * 
    * @param <E>
    * @throws InterruptedException
    */
   private static <E> void checkStats() throws InterruptedException {
      if(type == 0) {
         System.out.println("Class: Barbarian");
      }else if(type == 1) {
         System.out.println("Class: Warrior");
      }else {
         System.out.println("Class: Knight");
      }
      System.out.println("Total Health: " + pc.getTotal());
      System.out.println("Attack: " + pc.getAttack());
      System.out.println("Shield: " + pc.getShield());
      System.out.println("Points: " + pc.getPoints());
      System.out.println("Level: " + pc.getLevel());
      System.out.println("Health: " + pc.getHealth());
      System.out.println("Luck: " + pc.getLuck());
        
   }
   /**
    * This method is the attacks that the player has at the start of the game
    * 
    * @param <E>
    * @param ek is enemy class
    * @param name is the name of the enemy
    * @throws InterruptedException
    */
   private static <E> void attacksStarter( E ek, String name) throws InterruptedException {
      System.out.println("\nWhat Attack do you want to use?");
      System.out.println("Enter in your choice using the numbers 1-3");
      System.out.println("1: Basic Attack");
      System.out.println("2: Toughen");
      System.out.println("3: Return");
      int choice = inputVerification(1,3);
          
          // Main character choice
      switch (choice){
         case 1:
            Basic(ek, name);
            break;
         case 2:
            pc.increaseShieldTemp(5);
            break;
         case 3:
            playerAttack(ek, name);
            return;
         case 20160806:
        	 cheatDefeat(ek,name);
        	 break;
         default:
        	 System.out.println("Bad input...");
             attacksStarter(ek,name);
            break;
      }
   }
   /**
    * This method is the attacks that the player has at level 3
    * 
    * @param <E>
    * @param ek is enemy class
    * @param name is the name of the enemy
    * @throws InterruptedException
    */
   private static <E> void attacksNovice(E ek, String name) throws InterruptedException {
      System.out.println("\nWhat Attack do you want to use?");
      System.out.println("Enter in your choice using the numbers 1-4");
      System.out.println("1: Basic Attack");
      System.out.println("2: Toughen");
      System.out.println("3: Strong Attack");
      System.out.println("4: Return");
      int choice = inputVerification(1,4);
          
          // Main character choice
      switch (choice){
         case 1:
            Basic(ek, name);
            break;
         case 2:
            pc.increaseShieldTemp(5);
            break;
         case 3:
            Strong(ek, name);
            break;
         case 4:
            playerAttack(ek, name);
            return;
         case 20160806:
        	 cheatDefeat(ek,name);
        	 break;
         default:
            System.out.println("Bad input...");
            attacksNovice(ek,name);
                      // DEFAULT
            break;
      }
   }
   /**
    * This method is the attacks that the player has at level 7
    * 
    * @param <E>
    * @param ek is enemy class
    * @param name is the name of the enemy
    * @throws InterruptedException
    */
   private static <E> void attacksMid(E ek, String name) throws InterruptedException {
      System.out.println("\nWhat Attack do you want to use?");
      System.out.println("Enter in your choice using the numbers 1-5");
      System.out.println("1: Basic Attack");
      System.out.println("2: Toughen");
      System.out.println("3: Strong Attack");
      System.out.println("4: Triple Attack");
      System.out.println("5: Return");
      int choice = inputVerification(1,5);
          
          // Main character choice
      switch (choice){
         case 1:
            Basic(ek, name);
            break;
         case 2:
            pc.increaseShieldTemp(5);
            break;
         case 3:
            Strong(ek, name);
            break;
         case 4:
            Triple(ek, name);
            break;
         case 5:
            playerAttack(ek, name);
            return;
         case 20160806:
        	 cheatDefeat(ek,name);
        	 break;
         default:
            System.out.println("Bad input...");
            attacksMid(ek,name);
                      // DEFAULT
            break;
      }
   }
   /**
    * This method is the attacks that the player has at level 10
    * 
    * @param <E>
    * @param ek is enemy class
    * @param name is the name of the enemy
    * @throws InterruptedException
    */
   private static <E> void attacksMaster(E ek, String name) throws InterruptedException {
      System.out.println("\nWhat Attack do you want to use?");
      System.out.println("Enter in your choice using the numbers 1-6");
      System.out.println("1: Basic Attack");
      System.out.println("2: Toughen");
      System.out.println("3: Strong Attack");
      System.out.println("4: Triple Attack");
      System.out.println("5: Sharpen");
      System.out.println("6: Return");
      int choice = inputVerification(1,6);
             
             // Main character choice
      switch (choice){
         case 1:
            Basic(ek, name);
            break;
         case 2:
            pc.increaseShieldTemp(5);
            break;
         case 3:
            Strong(ek, name);
            break;
         case 4:
            Triple(ek, name);
            break;
         case 5:
            pc.increaseAttackTemp(8);
            break;
         case 6:
            playerAttack(ek, name);
            return;
         case 20160806:
        	 cheatDefeat(ek,name);
        	 break;
         default:
            System.out.println("Bad input...");
            attacksMaster(ek,name);
                         // DEFAULT
            break;
      }
   }
   /**
    * This method is the attacks that the player has at level 15
    * 
    * @param <E>
    * @param ek is enemy class
    * @param name is the name of the enemy
    * @throws InterruptedException
    */
   private static <E> void attacksGod(E ek, String name) throws InterruptedException {
      System.out.println("\nWhat Attack do you want to use?");
      System.out.println("Enter in your choice using the numbers 1-6");
      System.out.println("1: Basic Attack");
      System.out.println("2: Toughen");
      System.out.println("3: Strong Attack");
      System.out.println("4: Triple Attack");
      System.out.println("5: Sharpen");
      if(type == 0 ) {
         System.out.println("6: Wild Swing");
      }else if (type == 1) {
         System.out.println("6: Full Counter");
      }else {
         System.out.println("6: Holy Heal");
      }
      System.out.println("7: Return");
      int choice = inputVerification(1,7);
             
             // Main character choice
      switch (choice){
         case 1:
            Basic(ek, name);
            break;
         case 2:
            pc.increaseShieldTemp(5);
            break;
         case 3:
            Strong(ek, name);
            break;
         case 4:
            Triple(ek, name);
            break;
         case 5:
            pc.increaseAttackTemp(8);
            break;
         case 6:
            if(type == 0 ) {
               wildSwing(ek,name);
            }else if (type == 1) {
               fullCounter = false;
            }else {
               System.out.println("You healed " + pc.getAttack() + " health.");
               pc.heal(pc.getAttack());
            }
            break;
         case 7:
            playerAttack(ek, name);
            return;
         case 20160806:
        	 cheatDefeat(ek,name);
        	 break;
         default:
           	 //input validation
            System.out.println("Bad input....");
            attacksGod(ek,name);
                         // DEFAULT
            break;
      }
   }
   /**
    * This method allows the user to access their inventory during battle
    * 
    * @param <E>
    * @param ek is enemy class
    * @param name is the name of the enemy
    * @throws InterruptedException
    */
   private static <E> void Inventory(E ek, String name) throws InterruptedException {
      itemEquip();
	   int choice = inputVerification(1,3);
      if(choice ==3) {
    	  playerAttack(ek,name);
      }else {
    	  boolean a = itemsEquipment(choice);
    	  if(a == false) {
    		  Inventory(ek,name);
    	  }
      }
   }
   /**
    * This method is the first move the user knows that allows the user to cause damage based solely on attack
    * 
    * @param <E>
    * @param ek is enemy class
    * @param name is name of the enemy
    * @throws InterruptedException
    */
   private static <E> void Basic(E ek, String name) throws InterruptedException {
      int p1Attack;
      p1Attack = pc.getAttack();
      p1Attack = damageCrit(ek,p1Attack);
      System.out.println("You dealt " + p1Attack + " damage");
      Looting(ek, name);
   }
   /**
    * This method is the second offensive attack from the user which allows the user to cause 1.5 times attack as damage
    * but costs 1/4 recoil damage to themselves
    *   
    * @param <E>
    * @param ek is the enemy class
    * @param name is the name of the enemy
    * @throws InterruptedException
    */
   private static <E> void Strong(E ek, String name) throws InterruptedException {
      int p1Attack; 
      p1Attack = pc.getAttack() + (pc.getAttack()/2);
      pc.damage(4*pc.getLevel());
      p1Attack = damageCrit(ek,p1Attack);
      System.out.println("You dealt " + p1Attack + " damage");
      System.out.println("Recoil " + (4*pc.getLevel()) + " damage");
      Looting(ek, name);
   }
   /**
    * This method is the third offensive attack by the user and allows the user a random attack value from zero to attack stat
    * hitting the enemy three times
    * 
    * @param <E>
    * @param ek is the enemy class
    * @param name is the name of the enemy
    * @throws InterruptedException
    */
   private static <E> void Triple(E ek, String name) throws InterruptedException {
      int p1Attack;
      int count;
      count = 0;
      p1Attack = rand.nextInt(pc.getAttack());
      int temp = p1Attack;
      while(count < 3 && ((CharEntities) ek).getHealth() > 0) {
    	  p1Attack = damageCrit(ek,p1Attack);
         System.out.println("You dealt " + p1Attack + " damage");
         p1Attack = temp;
         count++;
      }
      Looting(ek, name);
   }
   /**
    * This is a move specifically for the barbarian to use and allows the user to deal double attack damage
    * at the cost of some shield 
    * 
    * @param <E>
    * @param ek
    * @param name
    * @throws InterruptedException
    */
   private static <E> void wildSwing(E ek, String name) throws InterruptedException {
      int p1Attack;
      p1Attack = pc.getAttack() * 2;
      p1Attack = damageCrit(ek,p1Attack);
      System.out.println("You dealt " + p1Attack + " damage");
      pc.decreaseShieldTemp(5);
      System.out.println("Shield dropped by 5.");
      Looting(ek, name);
   }
   /**
    * This is a move specifically for the Warrior to use that allows them to return the enemies attack 1.5 times as strong
    * 
    * @param <E>
    * @param ek is enemy class
    * @param name is the name of the enemy
    * @param CPUAttack is the strength of the enemies attack
    * @throws InterruptedException
    */
   private static <E> void Full(E ek, String name, int CPUAttack) throws InterruptedException {
      int p1Attack;
      p1Attack = CPUAttack + CPUAttack/2;
      p1Attack = damageCrit(ek,p1Attack);
      System.out.println("You dealt " + p1Attack + " damage");
      Looting(ek, name);
   }
   /**
    * This is the structure of how the beginning of the game goes
    * 
    * @throws InterruptedException
    */
   private static void start() throws InterruptedException {
      eastWest();
      Story.choice();
      int answer = inputVerification(1,2);
      if(answer == 1) {
         adventure = false;
         Story.homeLand();
         end();
      }else {
         Story.adventure();
         end();
      }
   }
   /**
    * This method is just to allow the user to choose between east or west
    * 
    * @throws InterruptedException
    */
   public static void eastWest() throws InterruptedException{
	   int response = inputVerification(1,2);
	   switch(response) {
	   case 1:
		   direction = "East";
		   Story.East();
	         WildBoar ek = new WildBoar(pc);
      
	              
	         fightSequence(ek, "Boar");
	         Story.Encounter(pc);
	         Story.Mid();
	         treePond();
	         rest();
	         Story.Close();
	         // 
	         Wolf ke = new Wolf(pc);
	         ke.intro();
	         fightSequence(ke, "Wolf");
	         Story.Encounter(pc);
		   break;
	   case 2:
		   direction = "West";
		   Story.West();
	         Wolf w = new Wolf(pc);
	         w.intro();
	         fightSequence(w, "Wolf");
	         Story.Encounter(pc);
	         Story.Mid();
	         treePond();
	         rest();
	         Story.Close();
	         WildBoar wb = new WildBoar(pc); 
	         wb.intro();
	         fightSequence(wb, "Boar");
	         Story.Encounter(pc);
		   break;
	   default:
		   System.out.println("Bad input...");
		   eastWest();
	   }
   }
   /**
    * This method is just to allow the user to choose between tree or pond
    * 
    * @throws InterruptedException
    */
   public static void treePond() throws InterruptedException{
	   int response = inputVerification(1,2);
	   switch(response) {
	   case 1:
		   rest();
	          Story.Tired();
	          FlyingSquirrel fs = new FlyingSquirrel(pc);
	       
	                
	          fightSequence(fs, "Flying Squirrel");
	          Story.Encounter(pc);
		   break;
	   case 2:
		   rest();
	          Story.Relax();
	          KoiFish kf = new KoiFish(pc);
	       
	                
	          fightSequence(kf, "Koi Fish");
	          Story.Encounter(pc);
		   break;
	   default:
		   System.out.println("Bad input...");
		   treePond();
	   }
   }
   /**
    * This allows the user to go to the land regions regions
    * 
    * @throws InterruptedException
    */
   private static void end() throws InterruptedException {
	   //Save option will probably be placed here
	  if(CheckPoint.checkAll()!= true) {
		  won = true;
	      int ans = inputVerification(1,5);
	      switch (ans){
	         case 1:
	            North();
	            break;
	         case 2:
	            South();
	            break;
	         case 3:
	             West();
	             break;
	         case 4:
	             East();
	             break;
	         case 5:
	        	if(CheckPoint.checkAllLand() && boat) {
	        		Ocean();
	        	}else if(!CheckPoint.checkAllLand()) {
	        		System.out.println("You're not yet ready...");
	        		end();
	        	}else {
	        		System.out.println("You need a boat...");
	        		end();
	        	}
	            break;
	         default:
	            System.out.println("Bad input...");
	            end();
	            break;
	      }
	  }else {
		  if(adventure) {
			  System.out.println("You adventured everywhere you could.");
		  }else {
			  System.out.println("You couldn't find a suitable home anywhere.");
		  }
		  System.out.println("What now?");
	  }
          
   }
   /**
    * This is the game structure for the two areas in the North
    * 
    * @throws InterruptedException
    */
   private static void North() throws InterruptedException {
      Story.North();
      int ans = inputVerification(1,2);
      switch(ans) {
      case 1:
    	  if(CheckPoint.SM() == 0) {
	    	  rest();
	          Story.Snowy();
	          Ram r = new Ram(pc);
	       
	                 
	          fightSequence(r, "Ram");
	          if(!won) {
	        	  break;
	          }
	          Story.Encounter(pc);
	          rest();
	          CheckPoint.increaseSMV();
    	  }
    	  if(CheckPoint.SM() == 1) {
	          if(adventure) {
	             Story.adMoutain();
	             Eagle e = new Eagle(pc);
	           
	                     
	             fightSequence(e, "Eagle");
	             if(!won) {
		        	  break;
		          }
	             Story.Encounter(pc);
	             rest();
	             CheckPoint.increaseSMV();
	          }else {
	             Story.civMoutain();
	             Yak y = new Yak(pc);
	           
	                     
	             fightSequence(y, "Yak");
	             if(!won) {
		        	  break;
		          }
	             Story.Encounter(pc);
	             rest();
	             CheckPoint.increaseSMV();
	          }
    	  }
    	  if(CheckPoint.SM() == 2) {
	          Story.Moutain();
	          MountainLion ml = new MountainLion(pc);
	       
	                 
	          fightSequence(ml, "Mountain Lion");
	          if(!won) {
	        	  break;
	          }
	          Story.Encounter(pc);
	          CheckPoint.increaseSMV();
    	  }
    	  if(CheckPoint.SM() >= 3) {
    		  System.out.println("You've already done this path, no need to do it again");
    	  }
    	  break;
      case 2:
    	  if(CheckPoint.FT() == 0) {
	    	  rest();
	          Story.Frozen();
	          Owl o = new Owl(pc);
	       
	                 
	          fightSequence(o, "Owl");
	          if(!won) {
	        	  break;
	          }
	          Story.Encounter(pc);
	          rest();
	          CheckPoint.increaseFTV();
    	  }
    	  if(CheckPoint.FT() == 1) {
	          if(adventure) {
	             Story.adTundra();
	             Fox f = new Fox(pc);
	           
	                     
	             fightSequence(f, "Fox");
	             if(!won) {
		        	  break;
		          }
	             Story.Encounter(pc);
	             rest();
	             CheckPoint.increaseFTV();
	          }else {
	             Story.civTundra();
	             Penguin p = new Penguin(pc);
	           
	                     
	             fightSequence(p, "Penguin");
	             if(!won) {
		        	  break;
		          }
	             Story.Encounter(pc);
	             rest();
	             CheckPoint.increaseFTV();
	          }
    	  }
    	  if(CheckPoint.FT() == 2) {
	          Story.Tundra();
	          PolarBear pb = new PolarBear(pc);
	       
	                 
	          fightSequence(pb, "Polar Bear");
	          if(!won) {
	        	  break;
	          }
	          Story.Encounter(pc);
	          CheckPoint.increaseFTV();
    	  }
    	  if(CheckPoint.FT() >= 3) {
    		  System.out.println("You've already done this path, no need to do it again");
    	  }
    	  break;
      default:
    	  System.out.println("Bad input...");
    	  North();
    	  return;
      }
      //this will possibly repeat
      //Story.next();
      end();
          
   }
   /**
    * This is the game structure for the two areas in the South
    * 
    * @throws InterruptedException
    */
   private static void South() throws InterruptedException {
      Story.South();
      int ans = inputVerification(1,2);
      switch(ans) {
      case 1:
    	  if(CheckPoint.SD() == 0) {
	    	  rest();
	          Story.Scorching();
	          Vulture v = new Vulture(pc);
	       
	                 
	          fightSequence(v, "Vulture");
	          if(!won) {
	        	  break;
	          }
	          Story.Encounter(pc);
	          rest();
	          CheckPoint.increaseSDV();
    	  }
    	  if(CheckPoint.SD() == 1) {
	          if(adventure) {
	             Story.adDesert();
	             RattleSnake rs = new RattleSnake(pc);
	           
	                     
	             fightSequence(rs, "Rattle Snake");
	             if(!won) {
		        	  break;
		          }
	             Story.Encounter(pc);
	             rest();
	             CheckPoint.increaseSDV();
	          }else {
	             Story.civDesert();
	             Scorpion s = new Scorpion(pc);
	           
	                     
	             fightSequence(s, "Scorpion");
	             if(!won) {
		        	  break;
		          }
	             Story.Encounter(pc);
	             rest();
	             CheckPoint.increaseSDV();
	          }
    	  }
    	  if(CheckPoint.SD() == 2) {
	          Story.Desert();
	          Komodo k = new Komodo(pc);
	       
	                 
	          fightSequence(k, "Komodo Dragon");
	          if(!won) {
	        	  break;
	          }
	          Story.Encounter(pc);
	          CheckPoint.increaseSDV();
    	  }
    	  if(CheckPoint.SD() >= 3) {
    		  System.out.println("You've already done this path, no need to do it again");
    	  }
    	  break;
      case 2:
    	  if(CheckPoint.GJ() == 0) {
	    	  rest();
	          Story.Green();
	          Frog f = new Frog(pc);
	       
	                 
	          fightSequence(f, "Frog");
	          if(!won) {
	        	  break;
	          }
	          Story.Encounter(pc);
	          rest();
	          CheckPoint.increaseGJV();
    	  }
          if(CheckPoint.GJ() == 1) {
	          if(adventure) {
	             Story.adJungle();
	             Piranha p = new Piranha(pc);
	           
	                     
	             fightSequence(p, "Piranha");
	             if(!won) {
		        	  break;
		          }
	             Story.Encounter(pc);
	             rest();
	             CheckPoint.increaseGJV();
	          }else {
	             Story.civJungle();
	             Chimpanzee c = new Chimpanzee(pc);
	           
	                     
	             fightSequence(c, "Chimpanzee");
	             if(!won) {
		        	  break;
		          }
	             Story.Encounter(pc);
	             rest();
	             CheckPoint.increaseGJV();
	          }
          }
          if(CheckPoint.GJ() == 2) {
	          Story.Jungle();
	          Panther bp = new Panther(pc);
	       
	                 
	          fightSequence(bp, "Panther");
	          if(!won) {
	        	  break;
	          }
	          Story.Encounter(pc);
	          CheckPoint.increaseGJV();
          }
          if(CheckPoint.GJ() >= 3) {
    		  System.out.println("You've already done this path, no need to do it again");
    	  }
    	  break;
      default:
    	  System.out.println("Bad input...");
    	  South();
    	  return;
      }
      //possibly of repeating
      //Story.next();
      end();
   }
   /**
    * This is the game structure for the two areas in the West
    * 
    * @throws InterruptedException
    */
   private static void West() throws InterruptedException {
      Story.WestRegion();
      if(direction == "East") {
    	  System.out.println("2. Dark Forest");
      }else {
    	  System.out.println("2. Crystal Lake");
      }
      Thread.sleep(500);
      int ans = inputVerification(1,2);
      switch(ans) {
      case 1:
    	  if(CheckPoint.AR() == 0) {
	    	  rest();
	          Story.Ancient();
	          Mummy m = new Mummy(pc);
	       
	                 
	          fightSequence(m, m.getName());
	          if(!won) {
	        	  break;
	          }
	          Story.Encounter(pc);
	          rest();
	          CheckPoint.increaseARV();
    	  }
          if(CheckPoint.AR() == 1) {
	          if(adventure) {
	             Story.adRuins();
	             Golem g = new Golem(pc);
	           
	                     
	             fightSequence(g, g.getName());
	             if(!won) {
		        	  break;
		          }
	             Story.Encounter(pc);
	             rest();
	             CheckPoint.increaseARV();
	          }else {
	             Story.civRuins();
	             Spider s = new Spider(pc);
	           
	                     
	             fightSequence(s, s.getName());
	             if(!won) {
		        	  break;
		          }
	             Story.Encounter(pc);
	             rest();
	             CheckPoint.increaseARV();
	          }
          }
          if(CheckPoint.AR() == 2) {
	          Story.Ruins();
	          Dragon d = new Dragon(pc);
	       
	                 
	          fightSequence(d, d.getName());
	          if(!won) {
	        	  break;
	          }
	          Story.Encounter(pc);
	          CheckPoint.increaseARV();
          }
          if(CheckPoint.AR() >= 3) {
    		  System.out.println("You've already done this path, no need to do it again");
    	  }
    	  break;
      case 2:
    	  if(direction == "East"){
    		  DarkForest();
    	  }else {
    		  CrystalLake();
    	  }
    	  break;
      default:
    	  System.out.println("Bad input...");
    	  North();
    	  return;
      }
      //this will possibly repeat
      //Story.next();
      end();
          
   }
   private static void DarkForest() throws InterruptedException {
	   if(CheckPoint.DF() == 0) {
		   rest();
	       Story.Dark();
	       FlyingSquirrel fs = new FlyingSquirrel(pc);
	    
	              
	       fightSequence(fs, fs.getName());
	       if(!won) {
	        	  return;
	          }
	       Story.Encounter(pc);
	       rest();
	       CheckPoint.increaseDFV();
	   }
       if(CheckPoint.DF() == 1) {
	       if(adventure) {
	          Story.adForest();
	          WildBoar wb = new WildBoar(pc);
	        
	                  
	          fightSequence(wb, wb.getName());
	          if(!won) {
	        	  return;
	          }
	          Story.Encounter(pc);
	          rest();
	          CheckPoint.increaseDFV();
	       }else {
	          Story.civForest();
	          KoiFish kf = new KoiFish(pc);
	        
	                  
	          fightSequence(kf, kf.getName());
	          if(!won) {
	        	  return;
	          }
	          Story.Encounter(pc);
	          rest();
	          CheckPoint.increaseDFV();
	       }
       }
       if(CheckPoint.DF() == 2) {
	       Story.Forest();
	       Wolf w = new Wolf(pc);
	    
	              
	       fightSequence(w, w.getName());
	       if(!won) {
	        	  return;
	          }
	       Story.Encounter(pc);
	       CheckPoint.increaseDFV();
       }
       if(CheckPoint.DF() >= 3) {
 		  System.out.println("You've already done this path, no need to do it again");
 	  }
   }
   private static void CrystalLake() throws InterruptedException {
	   if(CheckPoint.CL() == 0) {
		   rest();
	       Story.Crystal();
	       Duck d = new Duck(pc);
	    
	              
	       fightSequence(d, d.getName());
	       if(!won) {
	        	  return;
	          }
	       Story.Encounter(pc);
	       rest();
	       CheckPoint.increaseCLV();
	   }
       if(CheckPoint.CL() == 1) {
	       if(adventure) {
	          Story.adLake();
	          Turtle t = new Turtle(pc);
	        
	                  
	          fightSequence(t, t.getName());
	          if(!won) {
	        	  return;
	          }
	          Story.Encounter(pc);
	          rest();
	          CheckPoint.increaseCLV();
	       }else {
	          Story.civLake();
	          Salmon s = new Salmon(pc);
	        
	                  
	          fightSequence(s, s.getName());
	          if(!won) {
	        	  return;
	          }
	          Story.Encounter(pc);
	          rest();
	          CheckPoint.increaseCLV();
	       }
       }
       if(CheckPoint.CL() == 2) {
	       Story.Lake();
	       LochNess ln = new LochNess(pc);
	    
	              
	       fightSequence(ln, ln.getName());
	       if(!won) {
	        	  return;
	          }
	       Story.Encounter(pc);
	       CheckPoint.increaseCLV();
       }
       if(CheckPoint.CL() >= 3) {
  		  System.out.println("You've already done this path, no need to do it again");
  	  }
   }
   /**
    * This method tests the user luck to get a better chance of receiving an item during looting
    * 
    * @param <E>
    * @param luck is the amount of luck the user has
    * @return plus true if a bonus false if none
    */
   public static <E> boolean testLuck(int luck) {
      boolean plus = false;
      int lotto = rand.nextInt(101);
      if(luck > lotto) {
         plus = true;
      }
      return plus;
   }
/**
    * This is the game structure for the two areas in the East
    * 
    * @throws InterruptedException
    */
   private static void East() throws InterruptedException {
      Story.EastRegion();
      if(direction == "West") {
    	  System.out.println("2. Dark Forest");
      }else {
    	  System.out.println("2. Crystal Lake");
      }
      Thread.sleep(500);
      int ans = inputVerification(1,2);
      switch(ans) {
      case 1:
    	  if(CheckPoint.AV() == 0) {
	    	  rest();
	          Story.Abandoned();
	          Chicken c = new Chicken(pc);
	       
	                 
	          fightSequence(c, c.getName());
	          if(!won) {
	        	  break;
	          }
	          Story.Encounter(pc);
	          rest();
	          CheckPoint.increaseAVV();
    	  }
          if(CheckPoint.AV() == 1) {
	          if(adventure) {
	             Story.adVillage();
	             Zombie z = new Zombie(pc);
	           
	                     
	             fightSequence(z, z.getName());
	             if(!won) {
		        	  break;
		          }
	             Story.Encounter(pc);
	             rest();
	             CheckPoint.increaseAVV();
	          }else {
	             Story.civVillage();
	             Skeleton s = new Skeleton(pc);
	           
	                     
	             fightSequence(s, s.getName());
	             if(!won) {
		        	  break;
		          }
	             Story.Encounter(pc);
	             rest();
	             CheckPoint.increaseAVV();
	          }
          }
          if(CheckPoint.AV() == 2) {
	          Story.Village();
	          Ogre o = new Ogre(pc);
	       
	                 
	          fightSequence(o, o.getName());
	          if(!won) {
	        	  break;
	          }
	          Story.Encounter(pc);
	          CheckPoint.increaseAVV();
          }
          if(CheckPoint.AV() >= 3) {
      		  System.out.println("You've already done this path, no need to do it again");
      	  }
    	  break;
      case 2:
    	  if(direction == "West"){
    		  DarkForest();
    	  }else {
    		  CrystalLake();
    	  }
    	  break;
      default:
    	  System.out.println("Bad input...");
    	  North();
    	  return;
      }
      //this will possibly repeat
      //Story.next();
      end();
          
   }
   /**
    * This is the game structure for the two areas in the Oceean
    * 
    * @throws InterruptedException
    */
   private static void Ocean() throws InterruptedException {
      Story.Ocean();
      int ans = inputVerification(1,2);
      switch(ans) {
      case 1:
    	  if(CheckPoint.BT() == 0) {
	    	  rest();
	          Story.Bermuda();
	          Alien a = new Alien(pc);
	       
	                 
	          fightSequence(a, "Alien");
	          if(!won) {
	        	  break;
	          }
	          Story.Encounter(pc);
	          rest();
	          CheckPoint.increaseBTV();
    	  }
          if(CheckPoint.BT() == 1) {
	          if(adventure) {
	             Story.adTriangle();
	             Kraken k = new Kraken(pc);
	           
	                     
	             fightSequence(k, "Kraken");
	             if(!won) {
		        	  break;
		          }
	             Story.Encounter(pc);
	             rest();
	             CheckPoint.increaseBTV();
	          }else {
	             Story.civTriangle();
	             JellyFish jf = new JellyFish(pc);
	           
	                     
	             fightSequence(jf, "JellyFish");
	             if(!won) {
		        	  break;
		          }
	             Story.Encounter(pc);
	             rest();
	             CheckPoint.increaseBTV();
	          }
          }
	      if(CheckPoint.BT() == 2) {
	          Story.Triangle();
	          Hydra h = new Hydra(pc);
	       
	                 
	          fightSequence(h, "Hydra");
	          if(!won) {
	        	  break;
	          }
	          Story.Encounter(pc);
	          CheckPoint.increaseBTV();
          }
	      if(CheckPoint.BT() >= 3) {
	      	System.out.println("You've already done this path, no need to do it again");
	      }
    	  break;
      case 2:
    	  if(CheckPoint.CA() == 0) {
	    	  rest();
	          Story.City();
	          Mermaid m = new Mermaid(pc);
	       
	                 
	          fightSequence(m, "Mermaid");
	          if(!won) {
	        	  break;
	          }
	          Story.Encounter(pc);
	          rest();
	          CheckPoint.increaseCAV();
    	  }
          if(CheckPoint.CA() == 1) {
	          if(adventure) {
	             Story.adAlantis();
	             Poseidon p = new Poseidon(pc);
	           
	                     
	             fightSequence(p, "Poseidon");
	             if(!won) {
		        	  break;
		          }
	             Story.Encounter(pc);
	             rest();
	             CheckPoint.increaseCAV();
	          }else {
	             Story.civAlantis();
	             Shark s = new Shark(pc);
	           
	                     
	             fightSequence(s, "Shark");
	             if(!won) {
		        	  break;
		          }
	             Story.Encounter(pc);
	             rest();
	             CheckPoint.increaseCAV();
	          }
          }
          if(CheckPoint.CA() == 2) {
	          Story.Alantis();
	          Leviathan l = new Leviathan(pc);
	       
	                 
	          fightSequence(l, "Leviathan");
	          if(!won) {
	        	  break;
	          }
	          Story.Encounter(pc);
	          CheckPoint.increaseCAV();
          }
          if(CheckPoint.CA() >= 3) {
  	      	System.out.println("You've already done this path, no need to do it again");
  	      }
    	  break;
      default:
    	  System.out.println("Bad input...");
    	  Ocean();
    	  return;
      }
      //Story.next();
      end();
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
   /**
    * This method is the structure for how the user attacks and how the enemy attacks  during a battle
    * 
    * @param <E>
    * @param ek is the enemy class
    * @param name is the name of the enemy
    * @throws InterruptedException
    */
   private static <E> void fightSequence(E ek, String name) throws InterruptedException {
      testPassive();
      Story.clearScreen(); 
      ((CharEntities) ek).intro();
      int run = ran;
      int useFull = 1;
      int useMiss = 0;
      while (!(pc.getHealth() <= 0) && !(((CharEntities) ek).getHealth() <= 0) && run == ran) {
         battle(ek);     
         int CPUAttack;
         int p1Defence = pc.getShield();
         int passive = 0;
         if(type == 1) {
            int protect = rand.nextInt(8);
            if(protect == 4) {
               passive = 1;
               System.out.println("You used your shield to completely block any attacks");
            }
         }
         if(useMiss > 1){
            useMiss = 0;
         }
         if(passive == 0 && (fullCounter == true || miss == true)) {
            fullCounter = true;
            playerAttack(ek, name);
            if((pc.getHealth() <= 0) || (((CharEntities) ek).getHealth() <= 0) || run != ran){
               return;
            }
            
            p1Defence = pc.getShield();
         }else if(passive == 1){
            p1Defence = pc.getShield() * 100;
         }
         
         if(fullCounter == false && useFull >= useMiss) {
            miss = true;
            useMiss++;
         }
         int fear;
         if((((CharEntities)ek).getTotalHealth()/4)> ((CharEntities)ek).getHealth()) { //health below 25% of total
        	 fear = 4;
         }else if((((CharEntities)ek).getTotalHealth()/2)> ((CharEntities)ek).getHealth()){//health below 50% of total
        	 fear = 10;
         }else {
        	 fear = 20;
         }
         int num = rand.nextInt(fear);

         sleep500();
         if(num == 2) {
        	 ((CharEntities)ek).leaveMessage();
        	 pc.setExp(((CharEntities) ek).getEXP()/2);
        	 System.out.println("You got nothing...");
        	 return;
         }else {
        	 CPUAttack = ((CharEntities) ek).getMove(pc);
             if(CPUAttack - p1Defence > 0) {    		
                CPUAttack = CPUAttack - p1Defence;
                if(fullCounter == false && useMiss < 2) {
                   Full(ek, name, CPUAttack);
                   fullCounter = true;
                }
                System.out.println("Damage taken " + CPUAttack);
                pc.damage(CPUAttack);
             }else {
                if(CPUAttack > 0){
                   System.out.println("It's attack was too weak to penetrate your shield.");
                }
                CPUAttack = 0;
                System.out.println("No damage taken.");
                if(fullCounter == false && useMiss == useFull) {
                   System.out.println("Full Counter failed...");
                   miss = false;
                   
                }
             }
             if(pc.getHealth()>0) {
            	 System.out.println("Your health is " + pc.getHealth());
             }else {
            	 System.out.println("You fainted...");
                 System.out.println("You wake up again hours later");
                 System.out.println("You'll come back when you're stronger");
                 pc.setHealth(pc.getTotal());
                 System.out.println("Your health is " + pc.getHealth());
                 won = false;
                return;
             }
         }
      }
   }
   /**
    * This method is used to test if the user has their passive ability on or not 
    * 
    * @param <E>
    */
   public static <E> void testPassive() {
      boolean passive = pc.getPassive();
      if(type == 0) {
         if(pc.getHealth() < (pc.getTotal()/ 4) && passive == false) {
            pc.setPassive(true); 
            pc.increaseAttackTemp(20);
            pc.decreaseShieldTemp(10);
         }
      }else if(type == 2) {
         if(pc.getHealth() > (pc.getTotal()/4 + pc.getTotal()/2) && passive == false) {
            pc.setPassive(true); 
            pc.increaseShieldTemp(10);
         }
         if(pc.getHealth() < (pc.getTotal()/4 + pc.getTotal()/2) && passive == true) {
            pc.setPassive(false);
            pc.decreaseShieldTemp(10);
         }
      }
   }
   /**
    * This method is used to simulate loading
    * 
    * @throws InterruptedException
    */
   public static void sleep500() throws InterruptedException {
      for(int i = 0; i <= 4; i++){
         Thread.sleep(250);
         System.out.print(".");
      }
   }
   /**
    * This method test if the enemy is still alive or not
    * if alive will print how much health is left
    * if dead will choose what kind of loot the user will receive if any
    * 
    * @param <E>
    * @param ek is enemy class
    * @param name is name of the enemy
    * @throws InterruptedException
    */
   private static <E> void Looting(E ek, String name) throws InterruptedException {
      if(((CharEntities) ek).getHealth() > 0) {
         System.out.println("The " + name + " has only " + ((CharEntities) ek).getHealth() + " health left!");
      }else {
         ((CharEntities) ek).endMessage();
         pc.setExp(((CharEntities) ek).getEXP());
         int chance = rand.nextInt(6);
         int luck = pc.getLuck();
         boolean help = testLuck(luck);
         if(help) {
            chance++;
         }
         if(pc.getLevel() > 9) {
            help = testLuck(luck/2);
            if(help) {
               chance++;
            }
         }
         if(chance < 1) {
            System.out.println("You got nothing...");
         }else if(chance > 2) {
            int item = rand.nextInt(4);
            int strength = rand.nextInt(2);
            if(item == 0) {
               if(pc.getLevel() >= 10 && strength == 1) {
            	   System.out.println("You got Adrenaline!");
            	   System.out.println("You can heal yourself with this.");
           			pc.putItems("Adrenaline");
               }else if(pc.getLevel()< 10 && pc.getLevel() >= 5 && strength >= 0) {
            	   System.out.println("You got a Booster potion!");
            	   System.out.println("You can heal yourself with this.");
           			pc.putItems("Booster Potion");
               }else {
            	   System.out.println("You got a Health potion!");
            	   System.out.println("You can heal yourself with this.");
            		pc.putItems("Health Potion");
               }
            }else if(item == 1) {
            	if(pc.getLevel() >= 10 && strength == 1) {
            		System.out.println("You got Flex tape!");
            		System.out.println("You can increase your shield with this.");
                    pc.putItems("Flex tape");
                }else if(pc.getLevel()< 10 && pc.getLevel() >= 5 && strength >= 0) {
                	System.out.println("You got Duct tape!");
                	System.out.println("You can increase your shield with this.");
                    pc.putItems("Duct tape");
                }else {
                	System.out.println("You got Scotch tape!");
                	System.out.println("You can increase your shield with this.");
                    pc.putItems("Scotch tape");
                }
            }else if(item == 2) {
            	if(pc.getLevel() >= 10 && strength == 1) {
            		System.out.println("You got Steroids!");
            		System.out.println("You can increase your attack with this.");
                    pc.putItems("Steroids");
                }else if(pc.getLevel()< 10 && pc.getLevel() >= 5 && strength >= 0) {
                	System.out.println("You got a Strength potion!");
                	System.out.println("You can increase your attack with this.");
                    pc.putItems("Strength Potion");
                }else {
                	System.out.println("You got an Attack potion!");
                	System.out.println("You can increase your attack with this.");
                    pc.putItems("Attack Potion");
                }
            }else {
            	if(pc.getLevel() >= 10 && strength == 1) {
            		System.out.println("You got a Four Leaf Clover!");
            		System.out.println("You can increase your luck with this.");
                    pc.putItems("Four Leaf Clover");
                }else if(pc.getLevel()< 10 && pc.getLevel() >= 5 && strength >= 0) {
                	System.out.println("You got a Fortune potion!");
                	System.out.println("You can increase your luck with this.");
                    pc.putItems("Fortune Potion");
                }else {
                	System.out.println("You got a Luck potion!");
                	System.out.println("You can increase your luck with this.");
                    pc.putItems("Luck Potion");
                }
            }
         }else {
            int item = rand.nextInt(5);
            String winner = "";
            if(item == 0) {
               winner = aa.lootItem(pc);
            }else if(item == 1) {
            	winner = fa.lootItem(pc);
            }else if(item == 2) {
            	winner = ta.lootItem(pc);
            }else if(item == 3) {
            	winner = la.lootItem(pc);
             }else if(item == 4) {
            	 winner = ha.lootItem(pc);
             }
            if(winner == "nothing")	{
            	System.out.println("You got nothing...");
            }else {
            	System.out.println("You got a " + winner);
            	pc.putEquipment(winner);
            }
         }
         moneyReward(ek);
         return;
      }
   }
   private static <E> void playerAttack(E ek, String name) throws InterruptedException{
      if (!(pc.getHealth() <= 0) && !(((CharEntities) ek).getHealth() <= 0)) {
         choice();
         int choice = inputVerification(1,3);
       
       // Main character choice
         switch (choice){
            case 1:
               int level = pc.getLevel();
               if(level < 3) {
                  attacksStarter(ek, name);
               }else if(level >= 3 && level < 7) {
                  attacksNovice(ek, name);
               }else if(level >= 7 && level < 10){
                  attacksMid(ek, name);
               }else if(level >= 10 && level < 15){
                  attacksMaster(ek, name);
               }else {
                  attacksGod(ek,name);
               }
                   // something regarding ATTACK
               break;
            case 2:
               Inventory(ek, name);
                   
                   // something regarding ITEMS
               break;
            case 3:
            //possibly broken where even if you do run away, it'll still keep the battle going
            //add something to make sure the run away worked
               int chance = rand.nextInt(5);
               if(chance >= 3) {
                  System.out.println("You ran away!!");
                  ran++;
                  won = false;
                  return;
               }
               System.out.println("You couldn't run away...");
               break;
            default:
                   System.out.println("Bad input...");
                   playerAttack(ek, name);
               break;
         }
      }
   }
   public static int inputVerification(int MIN, int MAX) {
	   int answer = 0;
	      boolean valid = false;
	      while(!valid){
	         while(!console.hasNextInt()){
	            System.out.println("Input must be an integer, please try again");
	            console.nextLine();
	         }
	         answer = console.nextInt();
	         console.nextLine();
	         valid = answer >= MIN && answer <= MAX; 
	         if(answer == 20160806) {
	        	 valid = true;
	         }
	         if(!valid){
	            System.out.printf("Must enter a value from %d to %d\n", MIN, MAX);
	         }
	      }
	      return answer;
   }
   /**
    * This method is meant to be used to access the items and equipments inside the player inventory.
    * 
    * @param choice is the userInput either 1 or 2
    * @throws InterruptedException
    * @return boolean response is if the user wanted to use item or not
    */
   public static boolean itemsEquipment(int choice) throws InterruptedException {
	   boolean response = false;
	   if(choice==1) {
		   boolean has = pc.getItems();
           if(has) {
              System.out.println("Which one do you want to use?");
              int reply = inputVerification(1, pc.getItemsSize());
              String c = pc.getItem(reply - 1);
              if(c.equalsIgnoreCase("Health Potion")) {
                 Items.healthPotion();
                 response = confirm();
                 if(response) {
                 pc.heal(25);
                 }
              } else if(c.equalsIgnoreCase("Scotch tape")) {
                 Items.scotchTape();
                 response = confirm();
                 if(response) {
                 pc.upgradeShield(2);
                 }
              }else if(c.equalsIgnoreCase("Attack Potion")) {
                 Items.attackPotion();
                 response = confirm();
                 if(response) {
                 pc.upgradeAttack(3);
                 }
              } else if(c.equalsIgnoreCase("Luck Potion")){
                 Items.LuckPotion();
                 response = confirm();
                 if(response) {
                 pc.upgradeLuck(1);
                 }
              }else if(c.equalsIgnoreCase("Booster Potion")) {
                  Items.boosterPotion();
                  response = confirm();
                  if(response) {
                  pc.heal(50);
                  }
               } else if(c.equalsIgnoreCase("Duct tape")) {
                  Items.ductTape();
                  response = confirm();
                  if(response) {
                  pc.upgradeShield(4);
                  }
               }else if(c.equalsIgnoreCase("Strength Potion")) {
                  Items.strengthPotion();
                  response = confirm();
                  if(response) {
                  pc.upgradeAttack(6);
                  }
               } else if(c.equalsIgnoreCase("Fortune Potion")) {
                  Items.fortunePotion();
                  response = confirm();
                  if(response) {
                  pc.upgradeLuck(2);
                  }
               }else if(c.equalsIgnoreCase("Adrenaline")) {
                   Items.adrenaline();
                   response = confirm();
                   if(response) {
                   pc.heal(100);
                   }
                } else if(c.equalsIgnoreCase("Flex tape")) {
                   Items.flexTape();
                   response = confirm();
                   if(response) {
                   pc.upgradeShield(6);
                   }
                }else if(c.equalsIgnoreCase("Steroids")) {
                   Items.steroids();
                   response = confirm();
                   if(response) {
                   pc.upgradeAttack(10);
                   }
                } else if(c.equalsIgnoreCase("Four Leaf Clover")) {
                   Items.clover();
                   response = confirm();
                   if(response) {
                   pc.upgradeLuck(4);
                   }
                }
              if(response == true) {
            	  pc.removeItem(reply - 1);
              }
           }
	   }else {
		   boolean has1 = pc.getEquipment();
           if(has1) {
              System.out.println("Which one do you want to use?");
              int reply1 = inputVerification(1, pc.getEquipCounter());
              String c1 = pc.getEquipment(reply1 - 1);
                 if(fa.itemHere(c1)) {
                	 fa.printItem(c1);
                	 response = confirm();
                     if(response) {
                    	 fa.setItem(c1, pc);
                    	 pc.upgradeShield(fa.equippedDefense);
                     }
                 }
                 if(aa.itemHere(c1)) {
                	 aa.printItem(c1);
                	 response = confirm();
                     if(response) {
                    	 aa.setItem(c1, pc);
                    	 pc.upgradeShield(aa.equippedDefense);
                     }
                 }
                 if(la.itemHere(c1)) {
                	 la.printItem(c1);
                	 response = confirm();
                     if(response) {
                    	 la.setItem(c1, pc);
                    	 pc.upgradeShield(la.equippedDefense);
                     }
                 }
                 if(ta.itemHere(c1)) {
                	 ta.printItem(c1);
                	 response = confirm();
                     if(response) {
                    	 ta.setItem(c1, pc);
                    	 pc.upgradeShield(ta.equippedDefense);
                     }
                 }
                 if(ha.itemHere(c1)) {
                	 ha.printItem(c1);
                	 response = confirm();
                     if(response) {
                    	 ha.setItem(c1, pc);
                    	 pc.upgradeShield(ha.equippedDefense);
                     }
                 }
              if(response == true) {
            	  pc.removeEquipment(c1);
              }
           }
	   }
	   return response;
   }
   /**
    * This  method prints what the options the player has inside their inventory
    * 
    * @throws InterruptedException
    */
   public static void itemEquip() throws InterruptedException {
	      sleep500();
	      Thread.sleep(250);
	      System.out.println("\nWhat do you want to do?");
	      System.out.println("Enter in your choice using the numbers 1-3");
	      System.out.println("1: Items");
	      System.out.println("2: Equipment");
	      System.out.println("3: Return");
   }
   /**
    * Allows the user to back out of an action
    * 
    * @return
    * @throws InterruptedException
    */
   public static boolean confirm() throws InterruptedException{
	   System.out.println("\nAre you sure?");
	   System.out.println("1: Yes");
	   System.out.println("2: No");
	   int response = inputVerification(1,2);
	   if(response ==1 ) {
		   return true;
	   }else {
		   return false;   
	   }
   }
   /**
    * This makes sure that the players money is in correct amounts
    * 
    * @throws InterruptedException
    */
   public static void moneyConversion() throws InterruptedException{
	   int temp = 0;
	   while(copper >100) {
		   copper -= 100;
		   temp++;
	   }
	   silver += temp;
	   temp = 0;
	   while(silver >100) {
		   silver -= 100;
		   temp++;  
	   }
	   gold += temp;
	   temp = 0;
	   while(gold >100) {
		   gold -= 100;
		   temp++;
	   }
	   platinum += temp;
	   temp = 0;
   }
   /**
    * This method prints all of the players money.
    * 
    * @throws InterruptedException
    */
   public static void printMoney() throws InterruptedException{
	   System.out.println("Copper pieces: " + copper + "c");
	   System.out.println("Silver pieces: " + silver + "s");
	   System.out.println("Gold pieces: " + gold + "g");
	   System.out.println("Platinum pieces: " + platinum + "p");
   }
   
   public static <E> void moneyReward(E ek) throws InterruptedException {
	   String n = ((CharEntities) ek).difficulty;
	   int temp;
	   switch(n) {
	   case "Easy": 
		   temp = rand.nextInt(50) + ((CharEntities) ek).level;
		   copper += temp;
		   System.out.println("You got " + temp + "c" );
		   break;
	   case "Normal": 
		   temp = rand.nextInt(100) + ((CharEntities) ek).level;
		   copper += temp;
		   System.out.println("You got " + temp + "c" );
		   break;
	   case "Hard": 
		   temp = rand.nextInt(26) + ((CharEntities) ek).level;
		   silver += temp;
		   System.out.println("You got " + temp + "s" );
		   break;
	   default: 
		   System.out.println("The moneyReward method is broken.");
		   break;
	   }
	   
   }
   /**
    * This method is to create the store filled with itmes
    * 
    * @throws InterruptedException
    */
   public static void store() throws InterruptedException {
	   Story.clearScreen();
	   boolean leave = false;
	   while(!leave) {
		   System.out.println("Welcome to the Store");
		   System.out.println();
		   moneyConversion();
		   printMoney();
		   System.out.println("What would you like to browse?");
		   System.out.println();
		   System.out.println("1: Stats Boosters");
		   System.out.println("2: Misc");
		   //This is for a future update when I add different armor types and weapons
		   System.out.println("3: Weapons");
		   //System.out.println("4: Armor");
		   System.out.println("4: Leave");
		   System.out.println();
		   int category = inputVerification(1, 3);
		   int choice;
		   switch(category) {
		   case 1:
			   System.out.println("What would you like to buy?");
			   System.out.println();
			   System.out.println("1: Attack Potion - 10s");
			   System.out.println("2: Health Potion - 80c");
			   System.out.println("3: Scotch Tape - 5s");
			   System.out.println("4: Luck Potion - 70s");
			   System.out.println("5: Return");
			   System.out.println();
			   choice = inputVerification(1, 5);
			   switch(choice) {
			   case 1:
				   if(spend(1000)) {
					   System.out.println("You got an Attack potion!");
	               	   System.out.println("You can increase your attack with this.");
	                   pc.putItems("Attack Potion");
				   }else {
					   System.out.println("You can't afford this.");
					   System.out.println();
					   Thread.sleep(250);
				   }
				   break;
			   case 2:
				   if(spend(80)) {
					   System.out.println("You got a Health potion!");
	            	   System.out.println("You can heal yourself with this.");
	            	   pc.putItems("Health Potion");
				   }else {
					   System.out.println("You can't afford this.");
					   System.out.println();
					   Thread.sleep(250);
				   }
				   break;
			   case 3:
				   if(spend(500)) {
					   System.out.println("You got Scotch tape!");
	               	   System.out.println("You can increase your shield with this.");
	                   pc.putItems("Scotch tape");
				   }else {
					   System.out.println("You can't afford this.");
					   System.out.println();
					   Thread.sleep(250);
				   }
				   break;
			   case 4:
				   if(spend(7000)) {
					   System.out.println("You got a Luck potion!");
	               	   System.out.println("You can increase your luck with this.");
	                   pc.putItems("Luck Potion");
				   }else {
					   System.out.println("You can't afford this.");
					   System.out.println();
					   Thread.sleep(250);
				   }
				   break;
			   case 5:
				   break;
			   default:
					break;
			   }
			   break;
		   case 2:
			   System.out.println("What would you like to buy?");
			   System.out.println();
			   System.out.println("1: Boat - 5g");
			   System.out.println("2: Return");
			   System.out.println();
			   choice = inputVerification(1, 2);
			   switch(choice) {
			   case 1:
				   if(spend(50000)) {
					   if(!boat) {
						   System.out.println("You've obtained a boat.");
						   Items.boat();
						   boat = true;
						   System.out.println();
						   Thread.sleep(250);
					   }else {
						   System.out.println("You already have a boat.");
						   System.out.println();
						   Thread.sleep(250);
					   }
				   }else {
					   System.out.println("You can't afford this.");
					   System.out.println();
					   Thread.sleep(250);
				   }
				   break;
			   case 2:
				   break;
				default:
					break;
			   }
			   break;
		   case 3:
			   int returnNumber = 2;
			   System.out.println("What would you like to buy?");
			   System.out.println("Note** Weapons are automatically equipped. Old weapon auto sold.");
			   System.out.println();
			   System.out.println("1. Iron Sword - 2s");
			   if(pc.getLevel() >= 3) {
				   returnNumber++;
				   System.out.println("2. Silver Sword - 24s");
			   }else if(pc.getLevel() >= 5) {
				   returnNumber++;
				   System.out.println("3. Steel Sword- 78s");
			   }else if(pc.getLevel() >= 10) {
				   returnNumber+= 2;
				   System.out.println("4. Damascus Sword- 4g");
				   System.out.println("5. Tamahagane Sword- 4g");
			   }else if(pc.getLevel() >= 15) {
				   returnNumber++;
				   System.out.println("6. Demon Claw Sword- 60g");
			   }else if(pc.getLevel() >= 20) {
				   returnNumber++;
				   System.out.println("7. Dragon Tooth Sword- 1p");
			   }
			   
			   System.out.println("" + returnNumber +": Return");
			   choice = inputVerification(1, returnNumber);
			   if(choice == 1) {
				   w.printItem("Iron Sword");
				   if(confirm()) {
					   if(spend(200)) {
						   System.out.println("You've gained the Iron Sword");
						   System.out.println(w.getName()+" has been sold for " + earnAmount(w.sellItem(w.getName())) + earnType(w.sellItem(w.getName())));
						   pc.downgradeAttack(w.getAttack());
						   w.setItem("Iron Sword");
						   pc.upgradeAttack(w.getAttack());
					   }else {
						   System.out.println("You can't afford this.");
						   System.out.println();
						   Thread.sleep(250);
					   }
				   }
			   }else if(choice == returnNumber) {
				   //didn't know what to put for this since its just returning.
				   System.out.print("");
			   }else if(choice == 2 && pc.getLevel() >= 3) {
				   w.printItem("Silver Sword");
				   if(confirm()) {
					   if(spend(2400)) {
						   System.out.println("You've gained the Silver Sword");
						   System.out.println(w.getName()+" has been sold for " + earnAmount(w.sellItem(w.getName())) + earnType(w.sellItem(w.getName())));
						   pc.downgradeAttack(w.getAttack());
						   w.setItem("Silver Sword");
						   pc.upgradeAttack(w.getAttack());
					   }else {
						   System.out.println("You can't afford this.");
						   System.out.println();
						   Thread.sleep(250);
					   }
				   }
			   }else if(choice == 3 && pc.getLevel() >= 5) {
				   w.printItem("Steel Sword");
				   if(confirm()) {
					   if(spend(7800)) {
						   System.out.println("You've gained the Steel Sword");
						   System.out.println(w.getName()+" has been sold for " + earnAmount(w.sellItem(w.getName())) + earnType(w.sellItem(w.getName())));
						   pc.downgradeAttack(w.getAttack());
						   w.setItem("Steel Sword");
						   pc.upgradeAttack(w.getAttack());
					   }else {
						   System.out.println("You can't afford this.");
						   System.out.println();
						   Thread.sleep(250);
					   }
				   }
			   }else if(choice == 4 && pc.getLevel() >= 10) {
				   w.printItem("Damascus Sword");
				   if(confirm()) {
					   if(spend(40000)) {
						   System.out.println("You've gained the Damascus Sword");
						   System.out.println(w.getName()+" has been sold for " + earnAmount(w.sellItem(w.getName())) + earnType(w.sellItem(w.getName())));
						   pc.downgradeAttack(w.getAttack());
						   w.setItem("Damascus Sword");
						   pc.upgradeAttack(w.getAttack());
					   }else {
						   System.out.println("You can't afford this.");
						   System.out.println();
						   Thread.sleep(250);
					   }
				   }
			   }else if(choice == 5 && pc.getLevel() >= 10) {
				   w.printItem("Tamahagane Sword");
				   if(confirm()) {
					   if(spend(40000)) {
						   System.out.println("You've gained the Tamahagane Sword");
						   System.out.println(w.getName()+" has been sold for " + earnAmount(w.sellItem(w.getName())) + earnType(w.sellItem(w.getName())));
						   pc.downgradeAttack(w.getAttack());
						   w.setItem("Tamahagane Sword");
						   pc.upgradeAttack(w.getAttack());
					   }else {
						   System.out.println("You can't afford this.");
						   System.out.println();
						   Thread.sleep(250);
					   }
				   }
			   }else if(choice == 6 && pc.getLevel() >= 15) {
				   w.printItem("Demon Claw Sword");
				   if(confirm()) {
					   if(spend(600000)) {
						   System.out.println("You've gained the Demon Claw Sword");
						   System.out.println(w.getName()+" has been sold for " + earnAmount(w.sellItem(w.getName())) + earnType(w.sellItem(w.getName())));
						   pc.downgradeAttack(w.getAttack());
						   w.setItem("Demon Claw Sword");
						   pc.upgradeAttack(w.getAttack());
					   }else {
						   System.out.println("You can't afford this.");
						   System.out.println();
						   Thread.sleep(250);
					   }
				   }
			   }else if(choice == 7 && pc.getLevel() >= 20) {
				   w.printItem("Dragon Tooth Sword");
				   if(confirm()) {
					   if(spend(1000000)) {
						   System.out.println("You've gained the Dragon Tooth Sword");
						   System.out.println(w.getName()+" has been sold for " + earnAmount(w.sellItem(w.getName())) + earnType(w.sellItem(w.getName())));
						   pc.downgradeAttack(w.getAttack());
						   w.setItem("Dragon Tooth Sword");
						   pc.upgradeAttack(w.getAttack());
					   }else {
						   System.out.println("You can't afford this.");
						   System.out.println();
						   Thread.sleep(250);
					   }
				   }
			   }
			   break;
		   case 4:
			   leave = true;
			   break;
			default:
				System.out.println("Bad Input... try again");
		   }
	   }
	   
   }
   /**
    * This method is used calculate if the player can buy an item, and if they can is spend
    * 
    * @param cost
    * @return spent if true than item was bought, if false than not bought
    */
   public static boolean spend(int cost) {
	   boolean spent = false;
	   if(cost < 100) {
		   if(cost > copper) {
			   if(silver > 1) {
				   silver--;
				   copper += 100;
				   copper -= cost;
				   spent = true;
			   }else if(gold > 1){
				   gold--;
				   silver += 99;
				   copper += 100;
				   copper -= cost;
				   spent = true;
			   }else if(platinum > 1) {
				   platinum--;
				   gold += 99;
				   silver += 99;
				   copper += 100;
				   copper -= cost;
				   spent = true;
			   }
		   }else {
			   copper -= cost;
			   spent = true;
		   }
	   }else if(cost < 10000) {
		   cost = cost/100;
		   if(cost > silver) {
			   if(gold > 1){
				   gold--;
				   silver += 100;
				   silver -= cost;
				   spent = true;
			   }else if(platinum > 1) {
				   platinum--;
				   gold += 99;
				   silver += 100;
				   silver -= cost;
				   spent = true;
			   }
		   }else {
			   silver -= cost;
			   spent = true;
		   }
	   }else if(cost < 1000000) {
		   cost = cost/10000;
		   if(cost > gold) {
			   if(platinum > 1) {
				   platinum--;
				   gold += 100;
				   gold -= cost;
				   spent = true;
			   }
		   }else {
			   gold -= cost;
			   spent = true;
		   }
	   }else {
		   cost = cost/1000000;
		   if(cost < platinum) {
			   platinum -= cost;
			   spent = true;
		   }
	   }
	   return spent;
   }
   /**
    * This method is to get the amount of currency earned
    * 
    * @param cost
    * @return
    */
   public static int earnAmount(int cost) {
	   if(cost < 100) {
		   copper += cost;
	   }else if(cost < 10000) {
		   cost = cost/100;
		   silver += cost;
	   }else if(cost < 1000000) {
		   cost = cost/10000;
		   gold += cost;
	   }else {
		   cost = cost/1000000;
		   platinum += cost;
	   }
	   return cost;
   }
   /**
    * This method is to get the type of currency earned
    * 
    * @param cost
    * @return
    */
   public static String earnType(int cost) {
	   String currency = "o";
	   if(cost < 100) {
		   currency = "c";
	   }else if(cost < 10000) {
		   currency = "s";
	   }else if(cost < 1000000) {
		   currency = "g";
	   }else {
		   currency = "p";
	   }
	   return currency;
   }
   /**
    * This method is to see if the move dealt would be a critical, base is 1% critical rate, raises 1% per luck
    *   
    * @param <E>
    * @param ek
    * @param attack
    * @return attack in case it changed
    * @throws InterruptedException
    */
   public static <E> int damageCrit(E ek, int attack) throws InterruptedException{
	   int chance = rand.nextInt(100 - pc.getLuck());
	   if(chance < 0) {
		   chance = 0;
	   }
	   if(chance == 0) {
		   attack = attack + (attack/2);
		   System.out.println("That was a critical.");
	   }
	   ((CharEntities) ek).damage(attack);
	   return attack;
   }
   public static <E> void cheatDefeat(E ek, String name) throws InterruptedException{
	      int p1Attack;
	      p1Attack = ((CharEntities) ek).getHealth();
	      p1Attack = damageCrit(ek,p1Attack);
	      System.out.println("You dealt " + p1Attack + " damage");
	      Looting(ek, name);
   }
}
