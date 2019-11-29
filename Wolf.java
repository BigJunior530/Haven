public class Wolf {
      private int health;
      private int attack;
      private int shield;

      public Wolf(int health, int attack, int shield){
            this.health = health;
            this.attack = attack;
            this.shield = shield;
      }

      public int useAttack(){
            return this.attack;
      }
      public int useShield(){
            return this.shield;
      }
}
