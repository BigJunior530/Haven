import java.util.*;
//import java.lang.*;
//import java.io.*;
//import java.math.*;

public class Main {

      public static Scanner console = new Scanner(System.in);
      public static Random rand = new Random();

      public static void main(String[] args) throws InterruptedException {
            Protag pc = new Protag();
            Story.intro();
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
            }else {
            	Story.adventure();
            }
            
            
           

      }
      
      
      

      private static void choice() throws InterruptedException {
            sleep500();
            Thread.sleep(500);
            System.out.println("\nWhat do you want to do for your turn?");
            System.out.println("Enter in your choice using the numbers 1-3");
            System.out.println("1: Defend");
            System.out.println("2: Attack");
            System.out.println("3: Items");
            System.out.println("4: Run");
      }

      private static <E> void fightSequence(Protag pc, E ek, String name) throws InterruptedException {
            while (!(pc.getHealth() <= 0) || !(((CharEntities) ek).getHealth() <= 0)) {
                  int p1Attack;
                  int CPUAttack;
                  int p1Defence = 0;
                  //int CPUDefence;
                  //String p1Items;
                  //String CPUItems;
                  choice();
                  int choice = console.nextInt();
                  
                  // Main character choice
                  switch (choice){
                        case 1:
                              // something regarding DEFENCE
                              p1Defence = pc.getShield();
                              break;
                        case 2:
                              p1Attack = pc.getAttack();
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
                            	  System.out.println("Which one do you want to use?");
                            	  int reply = console.nextInt();
                            	  String c = pc.getItem(reply - 1);
                            	  if(c.equalsIgnoreCase("Health Potion")) {
                            		  Items.healthPotion();
                            		  pc.heal(10);
                            	  } else if(c.equalsIgnoreCase("Duct tape")) {
                            		  Items.ductTape();
                            		  pc.upgradeShield(2);
                            	  }else if(c.equalsIgnoreCase("Stregnth Potion")) {
                            		  Items.strengthPotion();
                            		  pc.upgradeAttack(4);
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
                        	if(p1Defence != 0) {
                        		
                        		CPUAttack = CPUAttack - p1Defence;
                        	}
                        	System.out.println(name + " ATTACKED");
                        	pc.damage(CPUAttack);
                        	if(pc.getHealth()>0) {
                        		System.out.println("Your health is " + pc.getHealth()); 
                        	}else {
                        		System.out.println("You fainted...");
                        		System.out.println("You wake up again hours later");
                        		pc.heal(50);
                        		System.out.println("Your health is " + pc.getHealth()); 
                        	}
                              // something regarding ATTACK
                              break;
                        case 3:
                              System.out.println(name + " is Bored");
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
