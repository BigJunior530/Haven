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
   public static int helmet = 0;
   public static int chest = 0;
   public static int leg = 0;
   public static int ran = 0;
   public static boolean run = false;
   public static boolean adventure = true;
   public static int type = 1;
   public static boolean fullCounter = true;
   public static boolean miss = true;
   /**
    * This is where the game starts
    * 
    * @param args
    * @throws InterruptedException
    */
   public static void main(String[] args) throws InterruptedException {
      enterGame();
      if(run == true) {
         Protag pc = new Protag(type);
         Story.intro();
         start(pc);
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
      int start = console.nextInt();
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
    * @param pc is user class
    * @param ek is enemy class
    * @throws InterruptedException
    */
   private static <E> void battle(Protag pc, E ek) throws InterruptedException {
      System.out.println("_________________________________________________________________");
      ((CharEntities) ek).enemy();
      pc.sprite();
      System.out.println("_________________________________________________________________");
   }
   /**
    * This method is a switch case method to get what you choose during the resting period
    * 
    * @param pc is user class
    */
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
               System.out.println("4. Luck");
               console.nextLine();
               int answer = console.nextInt();
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
            rest(pc);
            break;
         case 4:
            return;
         default:
        	 System.out.println("Bad input...");
             rest(pc);
            break;
      }
   }
   /**
    * This method prints out option for inventory and allows the player to access what's inside while in rest
    * 
    * @param <E>
    * @param pc is user class
    * @throws InterruptedException
    */
   private static <E> void Inventory(Protag pc) throws InterruptedException {
      sleep500();
      Thread.sleep(250);
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
               } else {
                  Items.LuckPotion();
                  pc.upgradeLuck(1);
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
                  pc.upgradeShield(3);
               }else if(c.equalsIgnoreCase("Chest Plate")) {
                  Equipment.chestPlate();
                  pc.upgradeShield(5);
               }else if(c.equalsIgnoreCase("Leggings")) {
                  Equipment.leggings();
                  pc.upgradeShield(4);
               }
               pc.removeEquipment(c);
            }
            rest(pc);
            return;
         case 3:
            rest(pc);
            return;
         default:
        	 System.out.println("Bad input...");
             Inventory(pc);
            break;
      }
   }
  
/**
    * This method allows the player to check their stats during resting periods
    * 
    * @param <E>
    * @param pc is user class
    * @throws InterruptedException
    */
   private static <E> void checkStats(Protag pc) throws InterruptedException {
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
    * @param pc is user class
    * @param ek is enemy class
    * @param name is the name of the enemy
    * @throws InterruptedException
    */
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
            pc.increaseShieldTemp(5);
            break;
         case 3:
            playerAttack(pc, ek, name);
            return;
         default:
        	 System.out.println("Bad input...");
             attacksStarter(pc,ek,name);
            break;
      }
   }
   /**
    * This method is the attacks that the player has at level 3
    * 
    * @param <E>
    * @param pc is user class
    * @param ek is enemy class
    * @param name is the name of the enemy
    * @throws InterruptedException
    */
   private static <E> void attacksNovice(Protag pc, E ek, String name) throws InterruptedException {
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
            pc.increaseShieldTemp(5);
            break;
         case 3:
            Strong(pc, ek, name);
            break;
         case 4:
            playerAttack(pc, ek, name);
            return;
         default:
            System.out.println("Bad input...");
            attacksNovice(pc,ek,name);
                      // DEFAULT
            break;
      }
   }
   /**
    * This method is the attacks that the player has at level 7
    * 
    * @param <E>
    * @param pc is user class
    * @param ek is enemy class
    * @param name is the name of the enemy
    * @throws InterruptedException
    */
   private static <E> void attacksMid(Protag pc, E ek, String name) throws InterruptedException {
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
            pc.increaseShieldTemp(5);
            break;
         case 3:
            Strong(pc, ek, name);
            break;
         case 4:
            Triple(pc, ek, name);
            break;
         case 5:
            playerAttack(pc, ek, name);
            return;
         default:
            System.out.println("Bad input...");
            attacksMid(pc,ek,name);
                      // DEFAULT
            break;
      }
   }
   /**
    * This method is the attacks that the player has at level 10
    * 
    * @param <E>
    * @param pc is user class
    * @param ek is enemy class
    * @param name is the name of the enemy
    * @throws InterruptedException
    */
   private static <E> void attacksMaster(Protag pc, E ek, String name) throws InterruptedException {
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
            pc.increaseShieldTemp(5);
            break;
         case 3:
            Strong(pc, ek, name);
            break;
         case 4:
            Triple(pc, ek, name);
            break;
         case 5:
            pc.increaseAttackTemp(8);
            break;
         case 6:
            playerAttack(pc, ek, name);
            return;
         default:
            System.out.println("Bad input...");
            attacksMaster(pc,ek,name);
                         // DEFAULT
            break;
      }
   }
   /**
    * This method is the attacks that the player has at level 15
    * 
    * @param <E>
    * @param pc is user class
    * @param ek is enemy class
    * @param name is the name of the enemy
    * @throws InterruptedException
    */
   private static <E> void attacksGod(Protag pc, E ek, String name) throws InterruptedException {
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
      console.nextLine();
      int choice = console.nextInt();
             
             // Main character choice
      switch (choice){
         case 1:
            Basic(pc, ek, name);
            break;
         case 2:
            pc.increaseShieldTemp(5);
            break;
         case 3:
            Strong(pc, ek, name);
            break;
         case 4:
            Triple(pc, ek, name);
            break;
         case 5:
            pc.increaseAttackTemp(8);
            break;
         case 6:
            if(type == 0 ) {
               wildSwing(pc,ek,name);
            }else if (type == 1) {
               fullCounter = false;
            }else {
               System.out.println("You healed " + pc.getAttack() + " health.");
               pc.heal(pc.getAttack());
            }
            break;
         case 7:
            playerAttack(pc, ek, name);
            return;
         default:
           	 //input validation
            System.out.println("Bad input....");
            attacksGod(pc,ek,name);
                         // DEFAULT
            break;
      }
   }
   /**
    * This method allows the user to access their inventory during battle
    * 
    * @param <E>
    * @param pc is user class
    * @param ek is enemy class
    * @param name is the name of the enemy
    * @throws InterruptedException
    */
   private static <E> void Inventory(Protag pc, E ek, String name) throws InterruptedException {
      sleep500();
      Thread.sleep(250);
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
               } else {
                  Items.LuckPotion();
                  pc.upgradeLuck(1);
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
                  pc.upgradeShield(3);
               }else if(c.equalsIgnoreCase("Chest Plate")) {
                  Equipment.chestPlate();
                  pc.upgradeShield(5);
               }else if(c.equalsIgnoreCase("Leggings")) {
                  Equipment.leggings();
                  pc.upgradeShield(4);
               }
               pc.removeEquipment(c);
            }
            return;
         case 3:
            playerAttack(pc, ek, name);
            return;
         default:
            System.out.println("Bad input...");
            Inventory(pc, ek, name);
            break;
      }
   }
   /**
    * This method is the first move the user knows that allows the user to cause damage based solely on attack
    * 
    * @param <E>
    * @param pc is user class
    * @param ek is enemy class
    * @param name is name of the enemy
    * @throws InterruptedException
    */
   private static <E> void Basic(Protag pc, E ek, String name) throws InterruptedException {
      int p1Attack;
      p1Attack = pc.getAttack();
      System.out.println("You dealt " + p1Attack + " damage");
      ((CharEntities) ek).damage(p1Attack);
      Looting(pc, ek, name);
   }
   /**
    * This method is the second offensive attack from the user which allows the user to cause 1.5 times attack as damage
    * but costs 1/4 recoil damage to themselves
    *   
    * @param <E>
    * @param pc is the user class
    * @param ek is the enemy class
    * @param name is the name of the enemy
    * @throws InterruptedException
    */
   private static <E> void Strong(Protag pc, E ek, String name) throws InterruptedException {
      int p1Attack; 
      p1Attack = pc.getAttack() + (pc.getAttack()/2);
      pc.damage(4*pc.getLevel());
      System.out.println("You dealt " + p1Attack + " damage");
      System.out.println("Recoil " + (4*pc.getLevel()) + " damage");
      ((CharEntities) ek).damage(p1Attack);
      Looting(pc, ek, name);
   }
   /**
    * This method is the third offensive attack by the user and allows the user a random attack value from zero to attack stat
    * hitting the enemy three times
    * 
    * @param <E>
    * @param pc is the user class
    * @param ek is the enemy class
    * @param name is the name of the enemy
    * @throws InterruptedException
    */
   private static <E> void Triple(Protag pc, E ek, String name) throws InterruptedException {
      int p1Attack;
      int count;
      count = 0;
      p1Attack = rand.nextInt(pc.getAttack());
      while(count < 3 && ((CharEntities) ek).getHealth() > 0) {
         System.out.println("You dealt " + p1Attack + " damage");
         ((CharEntities) ek).damage(p1Attack);
         count++;
      }
      Looting(pc, ek, name);
   }
   /**
    * This is a move specifically for the barbarian to use and allows the user to deal double attack damage
    * at the cost of some shield 
    * 
    * @param <E>
    * @param pc
    * @param ek
    * @param name
    * @throws InterruptedException
    */
   private static <E> void wildSwing(Protag pc, E ek, String name) throws InterruptedException {
      int p1Attack;
      p1Attack = pc.getAttack() * 2;
      System.out.println("You dealt " + p1Attack + " damage");
      ((CharEntities) ek).damage(p1Attack);
      pc.decreaseShieldTemp(5);
      System.out.println("Shield dropped by 5.");
      Looting(pc, ek, name);
   }
   /**
    * This is a move specifically for the Warrior to use that allows them to return the enemies attack 1.5 times as strong
    * 
    * @param <E>
    * @param pc is user class
    * @param ek is enemy class
    * @param name is the name of the enemy
    * @param CPUAttack is the strength of the enemies attack
    * @throws InterruptedException
    */
   private static <E> void Full(Protag pc, E ek, String name, int CPUAttack) throws InterruptedException {
      int p1Attack;
      p1Attack = CPUAttack + CPUAttack/2;
      System.out.println("You dealt " + p1Attack + " damage");
      ((CharEntities) ek).damage(p1Attack);
      Looting(pc, ek, name);
   }
   /**
    * This is the structure of how the beginning of the game goes
    * 
    * @param pc is user class
    * @throws InterruptedException
    */
   private static void start(Protag pc) throws InterruptedException {
      int item = rand.nextInt(4);
      if(item == 0) {
         pc.putItems("Health Potion");
      }else if(item == 1) {
         pc.putItems("Duct tape");
      }else if(item == 2) {
         pc.putItems("Stregnth Potion");
      }else {
         pc.putItems("Luck Potion");
      }
      eastWest(pc);
      Story.choice();
      int answer = console.nextInt();
      if(answer == 1) {
         adventure = false;
         Story.homeLand();
         end(pc);
      }else {
         Story.adventure();
         end(pc);
      }
   }
   /**
    * This method is just to allow the user to choose between east or west
    * 
    * @param pc is user class
    * @throws InterruptedException
    */
   public static void eastWest(Protag pc) throws InterruptedException{
	   int response = console.nextInt();
	   switch(response) {
	   case 1:
		   Story.East();
	         WildBoar ek = new WildBoar(pc);
	         System.out.println("Your health is " + pc.getHealth()); 
	      
	              
	         fightSequence(pc, ek, "Boar");
	         Story.Encounter(pc);
	         Story.Mid();
	         treePond(pc);
	         rest(pc);
	         Story.Close();
	         System.out.println("Your health is " + pc.getHealth()); 
	         Wolf ke = new Wolf(pc);
	         ke.intro();
	         fightSequence(pc, ke, "Wolf");
	         Story.Encounter(pc);
		   break;
	   case 2:
		   Story.West();
	         System.out.println("Your health is " + pc.getHealth()); 
	         Wolf w = new Wolf(pc);
	          	
	         fightSequence(pc, w, "Wolf");
	         Story.Encounter(pc);
	         Story.Mid();
	         treePond(pc);
	         rest(pc);
	         Story.Close();
	         WildBoar wb = new WildBoar(pc);
	         System.out.println("Your health is " + pc.getHealth()); 
	      
	              
	         fightSequence(pc, wb, "Boar");
	         Story.Encounter(pc);
		   break;
	   default:
		   System.out.println("Bad input...");
		   eastWest(pc);
	   }
   }
   /**
    * This method is just to allow the user to choose between tree or pond
    * 
    * @param pc is user class
    * @throws InterruptedException
    */
   public static void treePond(Protag pc) throws InterruptedException{
	   int response = console.nextInt();
	   switch(response) {
	   case 1:
		   rest(pc);
	          Story.Tired();
	          FlyingSquirrel fs = new FlyingSquirrel(pc);
	          System.out.println("Your health is " + pc.getHealth()); 
	       
	                
	          fightSequence(pc, fs, "Flying Squirrel");
	          Story.Encounter(pc);
		   break;
	   case 2:
		   rest(pc);
	          Story.Relax();
	          KoiFish kf = new KoiFish(pc);
	          System.out.println("Your health is " + pc.getHealth()); 
	       
	                
	          fightSequence(pc, kf, "Koi Fish");
	          Story.Encounter(pc);
		   break;
	   default:
		   System.out.println("Bad input...");
		   treePond(pc);
	   }
   }
   /**
    * This allows the user to go to the three regions
    * 
    * @param pc is user class
    * @throws InterruptedException
    */
   private static void end(Protag pc) throws InterruptedException {
      //Save option will probably be placed here
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
            System.out.println("Bad input...");
            end(pc);
            break;
      }
          
   }
   /**
    * This is the game structure for the two areas in the North
    * 
    * @param pc is the user class
    * @throws InterruptedException
    */
   private static void North(Protag pc) throws InterruptedException {
      Story.North();
      int ans = console.nextInt();
      switch(ans) {
      case 1:
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
    	  break;
      case 2:
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
    	  break;
      default:
    	  System.out.println("Bad input...");
    	  North(pc);
    	  return;
      }
      //this will possibly repeat
      Story.next();
      end(pc);
          
   }
   /**
    * This is the game structure for the two areas in the South
    * 
    * @param pc is the user class
    * @throws InterruptedException
    */
   private static void South(Protag pc) throws InterruptedException {
      Story.South();
      int ans = console.nextInt();
      switch(ans) {
      case 1:
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
    	  break;
      case 2:
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
    	  break;
      default:
    	  System.out.println("Bad input...");
    	  South(pc);
    	  return;
      }
      //possibly of repeating
      Story.next();
      end(pc);
   }
   /**
    * This is the game structure for the two areas in the Oceean
    * 
    * @param pc is the user class
    * @throws InterruptedException
    */
   private static void Ocean(Protag pc) throws InterruptedException {
      Story.Ocean();
      int ans = console.nextInt();
      switch(ans) {
      case 1:
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
    	  break;
      case 2:
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
    	  break;
      default:
    	  System.out.println("Bad input...");
    	  Ocean(pc);
    	  return;
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
   /**
    * This method is the structure for how the user attacks and how the enemy attacks  during a battle
    * 
    * @param <E>
    * @param pc is the user class
    * @param ek is the enemy class
    * @param name is the name of the enemy
    * @throws InterruptedException
    */
   private static <E> void fightSequence(Protag pc, E ek, String name) throws InterruptedException {
      testPassive(pc);
      Story.clearScreen(); 
      ((CharEntities) ek).intro();
      int run = ran;
      int useFull = 1;
      int useMiss = 0;
      while (!(pc.getHealth() <= 0) && !(((CharEntities) ek).getHealth() <= 0) && run == ran) {
         battle(pc, ek);     
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
            playerAttack(pc, ek, name);
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
                  // CPU choice
                  //Switch back to four when you want to add leaving again
         int num = rand.nextInt(2) + 1;
         sleep500();
         switch (num){
             //Too common and makes the game uninteresting
         	//almost no chance of returning
             // case 1:
         //                System.out.println(name + " does NOTHING.");
                               //something regarding DEFENCE
         //                break;
            case 1:
               CPUAttack = ((CharEntities) ek).getMove(pc);
               if(CPUAttack - p1Defence > 0) {    		
                  CPUAttack = CPUAttack - p1Defence;
                  if(fullCounter == false && useMiss < 2) {
                     Full(pc, ek, name, CPUAttack);
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
                  if(fullCounter == false && useMiss < 2) {
                     Full(pc, ek, name, CPUAttack);
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
                  pc.setHealth(50);
                  System.out.println("Your health is " + pc.getHealth());
                  return;
               }
                              // something ITEMS
               break;
               			//If added back, change to still gives exp but only half. and different end message
                        //case 4:
                        	//System.out.println(name + " LEAVES");	
                        	//return;
            default:
                              // Doesn't need one
               break;
         }
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
    * This method is used to test if the user has their passive ability on or not 
    * 
    * @param <E>
    * @param pc is the user class
    */
   public static <E> void testPassive(Protag pc) {
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
    * @param pc is user class
    * @param ek is enemy class
    * @param name is name of the enemy
    * @throws InterruptedException
    */
   private static <E> void Looting(Protag pc, E ek, String name) throws InterruptedException {
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
            if(item == 0) {
               System.out.println("You got a Health potion!");
               pc.putItems("Health Potion");
            }else if(item == 1) {
               System.out.println("You got Duct tape!");
               pc.putItems("Duct tape");
            }else if(item == 2) {
               System.out.println("You got a Stregnth potion!");
               pc.putItems("Stregnth Potion");
            }else {
               System.out.println("You got a luck potion");
               pc.putItems("Luck Potion");
            }
         }else {
            int item = rand.nextInt(3);
            if(helmet == 0 && item == 0) {
               System.out.println("You got a Helmet!");
               pc.putEquipment("Helmet");
               helmet++;
            }else if(chest == 0 && item == 1) {
               System.out.println("You got a Chest Plate!");
               pc.putEquipment("Chest Plate");
               chest++;
            }else if(leg == 0 && item == 2) {
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
   private static <E> void playerAttack(Protag pc, E ek, String name) throws InterruptedException{
      if (!(pc.getHealth() <= 0) && !(((CharEntities) ek).getHealth() <= 0)) {
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
                  attacksNovice(pc, ek, name);
               }else if(level >= 7 && level < 10){
                  attacksMid(pc, ek, name);
               }else if(level >= 10 && level < 15){
                  attacksMaster(pc, ek, name);
               }else {
                  attacksGod(pc,ek,name);
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
                   System.out.println("Bad input...");
                   playerAttack(pc, ek, name);
               break;
         }
      }
   }
}
