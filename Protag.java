import java.util.TreeSet;

/**
 * Constructor class for the main character. Contains the statistics 
 * for what the Protag entity has.
 */
public class Protag {
    private int health;
    private int totalHealth;
    private int attack;
    private int shield;
    private int exp;
    private int level;
    private int needed;
    private static TreeSet<String> items = new TreeSet<String>();
    private int counter;

        /**
         * Default construtor for the Protag class and sets default values.
         * <pre>{@code TODO}</pre> Make a construtor with parameters for when a save game is present
         */
        public Protag(){
            this.health = 100;
            totalHealth = 100;
            this.attack = 5;
            this.shield = 2;
            level = 1;
            exp = 0;
            needed = 10;
            counter = 0;
        }
    /**
     * Sets the value for experience.
     * @param strength Is the getAttack value from the entity that was fought.
     */
    public void setExp(int strength) {
        exp = exp + (strength*2);
    }

    /**
     * Is used to get the value of the instance field shield.
     * @return Returns the value of shield.
     */
    public int getShield(){
        return shield;
    }

    /**
     * Is used to get the value of the instance field attack.
     * @return Returns the value of attack.
     */
    public int getAttack(){
        return attack;
    }

    /**
     * Is used to get the value of the instance field health.
     * @return Returns the value of health.
     */
    public int getHealth(){
        return health;
    }

    /**
     * Sets the value for health.
     * @param idx Is passed inside Main.java.
     */
    public void setHealth(int idx){
        health = idx ;
    }

    /**
     * Is used to get the value of the instance field totalHealth.
     * @return Returns the value of totalHealth.
     */
    public int getTotal() {
        return totalHealth;
    }

    /**
     * Modifies the existing shield value based on the change in boost.
     * @param boost Is the change in what armor has been equipped.
     */
    public void upgradeShield(int boost){
        shield = shield + boost;
    }

    /**
     * Modifies the existing attack value based on the change in boost.
     * @param boost Is the change in what weapon has been equipped.
     */
    public void upgradeAttack(int boost){
        attack = attack + boost;
    }

    /**
     * Modifies the existing totalHealth value based on the change in boost.
     * @param boost Is the change in what healing object was used.
     */
    public void upgradeHealth(int boost){
    totalHealth = totalHealth + boost;
    }

    /**
     * Modifies the current health the player has in-game
     * @param boost Is the health increase the player uses.
     */
    public void heal(int boost){
        if(health < totalHealth) {
            if((boost + health) > totalHealth) {
                health = totalHealth;
            }else {
                health = health + boost;
            }
        }
    }

    /**
     * Is used to get the value of the instance field exp.
     * @return Returns the experience of the player.
     */
    public int getExp() {
        return exp;
    }

    /**
     * Is used to get the value of the instance field level.
     * @return Returns the level of the player.
     */
    public int getLevel() {
        return level;
    }

    /**
     * 
     * @return
     */
    public int getNeeded() {
        return needed;
    }
    public void setNeeded() {
        needed = 10*getLevel() - exp;
        if(needed <= 0) {
            needed = 10*getLevel();
            levelUp();
        }
    }
      
    public void levelUp() {
        System.out.println("You leveled up!\n");
        System.out.print("Total Health: " + getTotal() + "-->");
        upgradeHealth(5);
        System.out.print(getTotal()+ "\n");
        System.out.print("Attack: " + getAttack() + "-->");
        upgradeAttack(5);
        System.out.print(getAttack()+ "\n");
        System.out.print("Shield: " + getShield() + "-->");
        upgradeShield(3);
        System.out.print(getShield()+ "\n");
        exp = exp - getNeeded();
        level++;
        setNeeded();
        
    }

    public void damage(int hurt) {
        health = health - hurt;
    }

    public boolean getItems(){
        if(counter == 0) {  
            System.out.println("No Items");
            return false;
        }else {
            if(counter > 1) {
                for(int i = 0; i< counter; i++) {
                    System.out.println((i + 1) + ": " + items.toArray()[i]);
                }
            }else if(counter == 1) {
                System.out.println("1: " + items.toArray()[0]);
            }
            return true;
        }
    }
    public String getItem(int idx) {
        return (String) items.toArray()[idx];
    }
    public void removeItem(String word) {
        items.remove(word);
    counter--;
    }
    public void putItems(String thing) {
        items.add(thing);
        counter++;
    } 
}
