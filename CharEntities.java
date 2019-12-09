public abstract class CharEntities{
      int health;
      int attack;

      public int getAttack(){
            return this.attack;
      }
      public int getMove(Protag pc) {
    	  return this.attack;
      }
      public static void enemy(){
          System.out.println("          \\/");
          System.out.println("          /\\");
       }
      public void intro() throws InterruptedException{
          
       }

      
      public String showHealth(){
            String output = "HP is " + this.health;
            return output;
      }

      public <E> int getHealth(){
            return health;
      }
      public void damage(int hurt) {
    	  health = health -1;
      }
}
