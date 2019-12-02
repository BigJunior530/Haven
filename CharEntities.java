package Haven;
// This is a test
public abstract class CharEntities{
      int health;
      int attack;

      public <E> int getAttack(){
            return this.attack;
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
