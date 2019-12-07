import java.util.*;


public class Main {

      public static Scanner console = new Scanner(System.in);
      public static Random rand = new Random();

      public static void main(String[] args) throws InterruptedException {
            Protag pc = new Protag();
            Story.intro();
            start(pc);

      }
      
      /**
       * Method prints out the character selection choices for battle 
       * @throws InterruptedException Most likely is thrown when an outside command from the users
       * computer ends the Thread.sleep(millis) method
       */
      private static void choice() throws InterruptedException {
            sleep500();
            Thread.sleep(500);
            System.out.println("\nWhat do you want to do for your turn?");
            System.out.println("Enter in your choice using the numbers 1-4");
            System.out.println("1: Basic Attack");
            System.out.println("2: Strong Attack");
            System.out.println("3: Items");
            System.out.println("4: Run");
      }

      /**
       * Method starts the story with getting input from the player and
       * having a battle. Depending on what path the user chooses, the method 
       * will invoke other methods to advance the story.
       * @param pc Primary Character is added into the argument to shorten the
       * main(String[] args) method
       * @throws InterruptedException Most likely is thrown when an outside command from the users
       * computer ends the Thread.sleep(millis) method
       */
      private static void start(Protag pc) throws InterruptedException {
    	  int answer = console.nextInt();
          if(answer == 1) {
          	Story.East();
          	WildBoar ek = new WildBoar(pc);
          	System.out.println("Your health is " + pc.getHealth()); 

              ek.intro();
              fightSequence(pc, ek, "Boar");
              Story.Encounter(pc);
              Story.Mid();
              int response = console.nextInt();
              if(response == 1) {
              	Story.Tired();
              	FlyingSquirrel fs = new FlyingSquirrel(pc);
              	System.out.println("Your health is " + pc.getHealth()); 

                  fs.intro();
                  fightSequence(pc, fs, "Flying Squirrel");
                  Story.Encounter(pc);
              }else {
              	Story.Relax();
              	KoiFish kf = new KoiFish(pc);
              	System.out.println("Your health is " + pc.getHealth()); 

                  kf.intro();
                  fightSequence(pc, kf, "Koi Fish");
                  Story.Encounter(pc);
              }
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
          	ke.intro();
          	fightSequence(pc, ke, "Wolf");
          	Story.Encounter(pc);
          	Story.Mid();
              int response = console.nextInt();
              if(response == 1) {
              	Story.Tired();
              	FlyingSquirrel fs = new FlyingSquirrel(pc);
              	System.out.println("Your health is " + pc.getHealth()); 

                  fs.intro();
                  fightSequence(pc, fs, "Flying Squirrel");
                  Story.Encounter(pc);
              }else {
              	Story.Relax();
              	KoiFish kf = new KoiFish(pc);
              	System.out.println("Your health is " + pc.getHealth()); 

                  kf.intro();
                  fightSequence(pc, kf, "Koi Fish");
                  Story.Encounter(pc);
              }
          	Story.Close();
          	WildBoar ek = new WildBoar(pc);
          	System.out.println("Your health is " + pc.getHealth()); 

              ek.intro();
              fightSequence(pc, ek, "Boar");
              Story.Encounter(pc);
          	
          }
          Story.choice();
          answer = console.nextInt();
          if(answer == 1) {
          	Story.homeLand();
          	end(pc);
          }else {
          	Story.adventure();
          	end(pc);
          }
       }

      /**
       * 
       * @param pc Primary Character is added into the argument to shorten the
       * main(String[] args) method
       * @throws InterruptedException
       */
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

      /**
       * North defines the terrain and environment for the North region.
       * @param pc Primary Character is added into the argument to shorten the
       * main(String[] args) method
       * @throws InterruptedException Most likely is thrown when an outside command from the users
       * computer ends the Thread.sleep(millis) method
       */
      private static void North(Protag pc) throws InterruptedException {
    	  Story.North();
    	  int ans = console.nextInt();
    	  if(ans == 1) {
    		  Story.Snowy();
    		  Ram r = new Ram(pc);
            	System.out.println("Your health is " + pc.getHealth()); 

                r.intro();
                fightSequence(pc, r, "Ram");
                Story.Encounter(pc);
    		  Story.Moutain();
    		  MountainLion ml = new MountainLion(pc);
            	System.out.println("Your health is " + pc.getHealth()); 

                ml.intro();
                fightSequence(pc, ml, "Mountain Lion");
                Story.Encounter(pc);
    		  
    	  }else {
    		  Story.Frozen();
    		  Penguin p = new Penguin(pc);
            	System.out.println("Your health is " + pc.getHealth()); 

                p.intro();
                fightSequence(pc, p, "Penguin");
                Story.Encounter(pc);
    		  Story.Tundra();
    		  PolarBear pb = new PolarBear(pc);
            	System.out.println("Your health is " + pc.getHealth()); 

                pb.intro();
                fightSequence(pc, pb, "Polar Bear");
                Story.Encounter(pc);
    	  }
    	  Story.next();
    	  end(pc);
          
    }

      /**
       * 
       * @param pc Primary Character is added into the argument to shorten the
       * main(String[] args) method
       * @throws InterruptedException Most likely is thrown when an outside command from the users
       * computer ends the Thread.sleep(millis) method
       */
      private static void South(Protag pc) throws InterruptedException {
    	  Story.South();
    	  int ans = console.nextInt();
    	  if(ans == 1) {
    		  Story.Scorching();
    		  Vulture v = new Vulture(pc);
            	System.out.println("Your health is " + pc.getHealth()); 

                v.intro();
                fightSequence(pc, v, "Vulture");
                Story.Encounter(pc);
    		  Story.Desert();
    		  RattleSnake rs = new RattleSnake(pc);
            	System.out.println("Your health is " + pc.getHealth()); 

                rs.intro();
                fightSequence(pc, rs, "Rattle Snake");
                Story.Encounter(pc);
    		  
    	  }else {
    		  Story.Green();
    		  Chimpanzee c = new Chimpanzee(pc);
            	System.out.println("Your health is " + pc.getHealth()); 

                c.intro();
                fightSequence(pc, c, "Chimpanzee");
                Story.Encounter(pc);
    		  Story.Jungle();
    		  Panther p = new Panther(pc);
            	System.out.println("Your health is " + pc.getHealth()); 

                p.intro();
                fightSequence(pc, p, "Panther");
                Story.Encounter(pc);
    	  }
    	  Story.next();
    	  end(pc);
      }

      /**
       * 
       * @param pc Primary Character is added into the argument to shorten the
       * main(String[] args) method
       * @throws InterruptedException Most likely is thrown when an outside command from the users
       * computer ends the Thread.sleep(millis) method
       */
      private static void Ocean(Protag pc) throws InterruptedException {
    	  Story.Ocean();
    	  int ans = console.nextInt();
    	  if(ans == 1) {
    		  Story.Bermuda();
    		  Alien a = new Alien(pc);
            	System.out.println("Your health is " + pc.getHealth()); 

                a.intro();
                fightSequence(pc, a, "Alien");
                Story.Encounter(pc);
    		  Story.Triangle();
    		  Kraken k = new Kraken(pc);
            	System.out.println("Your health is " + pc.getHealth()); 

                k.intro();
                fightSequence(pc, k, "Kraken");
                Story.Encounter(pc);
    		  
    	  }else {
    		  Story.City();
    		  Mermaid m = new Mermaid(pc);
            	System.out.println("Your health is " + pc.getHealth()); 

                m.intro();
                fightSequence(pc, m, "Mermaid");
                Story.Encounter(pc);
    		  Story.Alantis();
    		  Shark s = new Shark(pc);
            	System.out.println("Your health is " + pc.getHealth()); 

                s.intro();
                fightSequence(pc, s, "Shark");
                Story.Encounter(pc);
    	  }
    	  Story.next();
    	  end(pc);
      }

      /**
       * 
       * @param <E>
       * @param pc Primary Character is added into the argument to shorten the
       * main(String[] args) method
       * @param ek
       * @param name
       * @throws InterruptedException Most likely is thrown when an outside command from the users
       * computer ends the Thread.sleep(millis) method
       */
      private static <E> void fightSequence(Protag pc, E ek, String name) throws InterruptedException {
            while (!(pc.getHealth() <= 0) || !(((CharEntities) ek).getHealth() <= 0)) {
                  int p1Attack;
                  int CPUAttack;
                  int p1Defence = pc.getShield();

                  choice();
                  console.nextLine();
                  int choice = console.nextInt();
                  
                  // Main character choice
                  switch (choice){
                        case 1:
                        	p1Attack = pc.getAttack();
                        	System.out.println("You dealt " + p1Attack + " damage");
                            ((CharEntities) ek).damage(p1Attack);
                            if(((CharEntities) ek).getHealth() > 0) {
                            	System.out.println("The " + name + " has only " + ((CharEntities) ek).getHealth() + " health left!");
                            }else {
                          	  System.out.println("You beat the " + name);
                          	  int b = ((CharEntities) ek).getAttack();
                          	  pc.setExp(b);
                          	  int item = rand.nextInt(4);
                          	  if(item == 0) {
                          		  System.out.println("You got a Health potion!");
                          		  pc.putItems("Health Potion");
                          	  }else if(item == 1) {
                          		  System.out.println("You got Duck tape!");
                          		  pc.putItems("Duct tape");
                          	  }else if(item == 2) {
                          		  System.out.println("You got a Stregnth potion!");
                          		  pc.putItems("Stregnth Potion");
                          	  }else {
                          		  System.out.println("You got nothing...");
                          	  }
                          	  return;
                            }
                              break;
                        case 2:
                              p1Attack = pc.getAttack() + (pc.getAttack()/2);
                              pc.damage(4*pc.getLevel());
                              System.out.println("You dealt " + p1Attack + " damage");
                              System.out.println("Recoil " + (4*pc.getLevel()) + " damage");
                              ((CharEntities) ek).damage(p1Attack);
                              if(((CharEntities) ek).getHealth() > 0) {
                              	System.out.println("The " + name + " has only " + ((CharEntities) ek).getHealth() + " health left!");
                              }else {
                            	  System.out.println("You beat the " + name);
                            	  int b = ((CharEntities) ek).getAttack();
                            	  pc.setExp(b);
                            	  int item = rand.nextInt(4);
                            	  if(item == 0) {
                            		  System.out.println("You got a Health potion!");
                            		  pc.putItems("Health Potion");
                            	  }else if(item == 1) {
                            		  System.out.println("You got Duck tape!");
                            		  pc.putItems("Duct tape");
                            	  }else if(item == 2) {
                            		  System.out.println("You got a Stregnth potion!");
                            		  pc.putItems("Stregnth Potion");
                            	  }else {
                            		  System.out.println("You got nothing...");
                            	  }
                            	  return;
                              }
                              // something regarding ATTACK
                              break;
                        case 3:
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
                              
                              // something regarding ITEMS
                              break;
                        case 4:
                        	  System.out.println("You ran away!!");
                              // run
                              return;
                        default:
                              // DEFAULT
                              break;
                  }

                  // CPU choice
                  //Switch back to four when you want to add leaving again
                  int num = rand.nextInt(3) + 1;
                  sleep500();
                  switch (num){
                        case 1:
                              System.out.println(name + " does NOTHING.");
                              // something regarding DEFENCE
                              break;
                        case 2:
                        	CPUAttack = ((CharEntities) ek).getAttack();
                        	if(CPUAttack - p1Defence > 0) {
                        		
                        		CPUAttack = CPUAttack - p1Defence;
                        	}else {
                        		CPUAttack = 0;
                        		System.out.println("No damage taken.");
                        	}
                        	System.out.println(name + " ATTACKED");
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
                              // something regarding ATTACK
                              break;
                        case 3:
                              System.out.println(name + " is Bored");
                              // something ITEMS
                              break;
                        default:
                              // DEFAULT
                              break;
                  }
            }
      }
      
      /**
       * Method would allow a "...." sequence to appear with a Thread.sleep(millis) inbetween each "."
       * @throws InterruptedException Most likely is thrown when an outside command from the users
       * computer ends the Thread.sleep(millis) method
       */
      public static void sleep500() throws InterruptedException {
            for(int i = 0; i <= 4; i++){
                  Thread.sleep(500);
                  System.out.print(".");
            }
      }
}
