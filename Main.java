import java.util.*;
//import java.lang.*;
//import java.io.*;
//import java.math.*;

public class Main {

      public static Scanner console = new Scanner(System.in);
      public static Random rand = new Random();

      public static void main(String[] args) throws InterruptedException {
            Protag primaryCharacter = new Protag();
            intro();
            WildBoar ek = new WildBoar();
            primaryCharacter.showHealth(); 

            ek.intro();
            fightSequence(primaryCharacter, ek);
           

      }
      private static void intro() throws InterruptedException {
            System.out.println("You wake up in forest.");
            Thread.sleep(2000);
            System.out.println("You only have a sword and a shield.");
            Thread.sleep(3500);
            System.out.println("You don't feel any pain at all.");
            Thread.sleep(3000);
            System.out.println("Objective: Find your way back to your homeland.");
            Thread.sleep(5000);
            System.out.println("There's a sound very near\n");
            Thread.sleep(1500);
      }

      private static void choice() throws InterruptedException {
            sleep500();
            Thread.sleep(500);
            System.out.println("\nWhat do you want to do for your turn?");
            System.out.println("Enter in your choice using the numbers 1-3");
            System.out.println("1: Defend");
            System.out.println("2: Attack");
            System.out.println("3: Items");
      }

      private static <E> void fightSequence(Protag primaryCharacter, E ek) throws InterruptedException {
            while (primaryCharacter.getHealth() <= 0 || ((CharEntities) ek).getHealth() <= 0) {
                  int p1Attack;
                  int CPUAttack;
                  int p1Defence;
                  int CPUDefence;
                  String p1Items;
                  String CPUItems;
                  choice();
                  int choice = console.nextInt();
                  
                  // Main character choice
                  switch (choice){
                        case 1:
                              // something regarding DEFENCE
                              p1Defence = primaryCharacter.getShield();
                              break;
                        case 2:
                              p1Attack = primaryCharacter.getAttack();
                              // something regarding ATTACK
                              break;
                        case 3:
                              
                              // something regarding ITEMS
                              break;
                        case 4:
                              // something
                              break;
                        default:
                              // DEFAULT
                              break;
                  }

                  // CPU choice
                  int num = rand.nextInt(4) + 1;
                  sleep500();
                  switch (num){
                        case 1:
                              System.out.println("Boar does NOTHING.");
                              // something regarding DEFENCE
                              break;
                        case 2:
                        CPUAttack = ((CharEntities) ek).getAttack();
                              // something regarding ATTACK
                              break;
                        case 3:
                              System.out.println("Boar does NOTHING. ");
                              // something ITEMS
                              break;
                        case 4:
                              // something regarding LEAVING
                              break;
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
