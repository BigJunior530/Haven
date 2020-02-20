/**
 * This class contains all the items
 * @author Carlos
 *
 */
public class Items {
	/**
	 * This method prints out the information for the Health Potion
	 * 
	 * @throws InterruptedException
	 */
	public static void healthPotion() throws InterruptedException{
		System.out.println("Health Potion.");
        Thread.sleep(2000);
		System.out.println("Adds 25 health.");
        Thread.sleep(2000);
	}
	/**
	 * This method prints out the information for the Strength Potion
	 * 
	 * @throws InterruptedException
	 */
	public static void strengthPotion() throws InterruptedException{
		System.out.println("Strength Potion.");
        Thread.sleep(2000);
		System.out.println("Adds 3 attack.");
        Thread.sleep(2000);
	}
	/**
	 * This method prints out the information for the Luck Potion
	 * 
	 * @throws InterruptedException
	 */
	public static void LuckPotion() throws InterruptedException{
		System.out.println("Luck Potion.");
        Thread.sleep(2000);
		System.out.println("Adds 1 Luck.");
        Thread.sleep(2000);
	}
	/**
	 * This method prints out the information for duct tape
	 * 
	 * @throws InterruptedException
	 */
	public static void ductTape() throws InterruptedException{
		System.out.println("Duct Tape.");
        Thread.sleep(2000);
		System.out.println("Adds 2 shield.");
        Thread.sleep(2000);
	}
}
