

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
	public static void Close() throws InterruptedException{
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
	public static void Mid() throws InterruptedException{
		System.out.println("The day is going by fast.");
        Thread.sleep(2000);
        System.out.println("You see the sun get ever and ever closer to the other side of the sky.");
        Thread.sleep(3500);
        System.out.println("You feel great after that last battle.");
        Thread.sleep(3000);
        System.out.println("You start to think about home and feel sad.");
        Thread.sleep(3000);
        System.out.println("You need a distraction.");
        Thread.sleep(5000);
        System.out.println("Where do you wanna go?\n");
        Thread.sleep(2000);
        System.out.println("1: Tree");
        System.out.println("2: Pond");
        Thread.sleep(1500);
	}
	public static void Relax() throws InterruptedException{
		System.out.println("You stumble upon a pond.");
        Thread.sleep(2000);
        System.out.println("You look into the clear water and you see a Koi Fish.");
        Thread.sleep(3500);
        System.out.println("You see the entrancing colors of its scales as it swims.");
        Thread.sleep(3000);
        System.out.println("You start to feel calm and relaxed.");
        Thread.sleep(3000);
        System.out.println("You start leaning closer and closer to the fish.");
        Thread.sleep(5000);
        System.out.println("Then it JUMPS onto your face.\n");
        Thread.sleep(1500);
	}
	public static void Tired() throws InterruptedException{
		System.out.println("You feel like you've been walking for ages.");
        Thread.sleep(2000);
        System.out.println("You sit down next to the big oak tree.");
        Thread.sleep(3500);
        System.out.println("You slowly start to drift off to sleep.");
        Thread.sleep(3000);
        System.out.println("You suddenly see a small animal.");
        Thread.sleep(3000);
        System.out.println("It's a squirrel... with wings?");
        Thread.sleep(5000);
        System.out.println("It flys off its branch and heads towards you.\n");
        Thread.sleep(1500);
	}
	public static void East() throws InterruptedException{
		System.out.println("You start heading East.");
        Thread.sleep(2000);
        System.out.println("You start to wonder why you're in the forest.");
        Thread.sleep(2000);
        System.out.println("You love the forest.");
        Thread.sleep(3500);
        System.out.println("You hear a noise up ahead.");
        Thread.sleep(3000);
	}
	public static void West() throws InterruptedException{
		System.out.println("You start heading West.");
        Thread.sleep(2000);
        System.out.println("You start to wonder why you're in the forest.");
        Thread.sleep(2000);
        System.out.println("You really miss home.");
        Thread.sleep(3500);
        System.out.println("You hear a howl up ahead.");
        Thread.sleep(3000);
	}
	public static void Encounter(Protag pc) throws InterruptedException {
		System.out.println("Total Exp is now " + pc.getExp());
        Thread.sleep(2000);
        pc.setNeeded();
        System.out.println(pc.getNeeded() + " left to get to the next level");
        Thread.sleep(2000);
        System.out.println("That fight was too close.");
        Thread.sleep(2000);
        System.out.println("You continue on your path to the homeland.");
        Thread.sleep(1500);
  }
	public static void homeLand() throws InterruptedException {
        System.out.println("You made it");
        Thread.sleep(3000);
        System.out.println("Objective: Completed.");
        Thread.sleep(5000);
        System.out.println("You're home...");
        
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
		Thread.sleep(3000);
        System.out.println("Objective: None.");
        Thread.sleep(5000);
        System.out.println("Adventure awaits...");
	}
}
