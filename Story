

public class Story {
	public static void intro() throws InterruptedException {
        System.out.println("You wake up in forest.");
        Thread.sleep(2000);
        System.out.println("You only have a sword and a shield.");
        Thread.sleep(3500);
        System.out.println("You don't feel any pain at all.");
        Thread.sleep(3000);
        System.out.println("Objective: Find your way back to your homeland.");
        Thread.sleep(5000);
        System.out.println("Where do you wanna go?\n");
        Thread.sleep(2000);
        System.out.println("1: East");
        System.out.println("2: West");
        Thread.sleep(1500);
  }
	public static void Mid() throws InterruptedException{
		System.out.println("Hours have passed by.");
        Thread.sleep(2000);
        System.out.println("You have grown stronger since the last battle.");
        Thread.sleep(3500);
        System.out.println("You start to wonder what it would be like to keep fighting.");
        Thread.sleep(3000);
        System.out.println("You think about what you really want to do.");
        Thread.sleep(3000);
        System.out.println("There's a clearing ahead, possibly home.");
        Thread.sleep(5000);
        System.out.println("Something jumps in front of you.\n");
        Thread.sleep(1500);
	}
	public static void East() throws InterruptedException{
		System.out.println("You start heading East.");
        Thread.sleep(2000);
        System.out.println("You start to wonder why you're in the forest.");
        Thread.sleep(3500);
        System.out.println("You see hear a noise up ahead.");
        Thread.sleep(3000);
	}
	public static void West() throws InterruptedException{
		System.out.println("You start heading West.");
        Thread.sleep(2000);
        System.out.println("You start to wonder why you're in the forest.");
        Thread.sleep(3500);
        System.out.println("You see hear a howl up ahead.");
        Thread.sleep(3000);
	}
	public static void Encounter() throws InterruptedException {
        System.out.println("That fight was too close.");
        Thread.sleep(2000);
        System.out.println("You continue on your path to the homeland.");
        Thread.sleep(1500);
  }
	public static void homeLand() throws InterruptedException {
        System.out.println("You made it");
        Thread.sleep(5000);
        System.out.println("You're home");
        
  }
	public static void choice() throws InterruptedException { 
		System.out.println("You see home clearly now.");
        Thread.sleep(2000);
		System.out.println("It's time to decide");
        Thread.sleep(2000);
        System.out.println("What do you want to do?");
        Thread.sleep(3000);
        System.out.println("1: Home");
        System.out.println("2: Adventure");
	}
	public static void adventure() throws InterruptedException { 
		System.out.println("You say bye to home and any for sure safety");
        Thread.sleep(5000);
        System.out.println("Adventure awaits...");
	}
}
