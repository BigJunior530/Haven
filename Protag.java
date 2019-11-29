public class Protag extends CharEntities{
      private int health;
      private int attack;
      private int shield;
      private int damageTaken;

      public Protag(){
            this (25, 8, 5, 0);
      }

      public Protag(int health, int attack, int shield, int damageTaken){
            this.health = health;
            this.attack = attack;
            this.shield = shield;

            if(damageTaken != 0){
                  
            }
      }
      
      
      public int getShield(){
            return 0;
      }

      public static void getItems(){
            System.out.println();
      }

      
}
