
package PokemonFighting;

/**
 * Created by Алена on 09.11.2016.
 */
public class Pokemon implements Attack {
    String type;
    public int health;
    public int power;
    public boolean shield;
    final static int DEFAULT_HEALTH = 50;
    final static int DEFAULT_POWER = 25;

    Pokemon() {
        this.health = DEFAULT_HEALTH;
        this.power = DEFAULT_POWER;
    }

    Pokemon (int h, int p) {
        this.health = h;
        this.power = p;
    }

    public boolean ShieldUp() {
       return shield = true;
    }

    void Pass() {
        this.health+=5;
        this.power+=10;
        ShieldUp();
    }

    public void BasicAttack(Pokemon target) {
        int damage=0;
        if (target.shield==false) {
            damage=-5;
        }
        target.health+=damage;
        target.shield=false;
        System.out.println("Basic Attack damage: " + damage);

    }

    public void SpecialAttack(Pokemon target) {
        int damage=0;
        if (this.power>=35) {
            this.power-=35;
            damage = -(DEFAULT_HEALTH+target.health)/2;
            target.health+=damage;
            target.shield=false;
        }
        else {
            System.out.println("Not enough power points!");
        }
        System.out.println("Special Attack damage: " + damage);

    }

    public void PowerfulAttack(Pokemon target, int countpower) {
        int damage = 0;
        if (this.power >= countpower) {
            if (target.shield == false) damage = -countpower;
            else damage = -countpower/2;
            this.power -=countpower;
            target.health+=damage;
            target.shield=false;
            System.out.println("Powerful Attack damage: " + damage);
        }
        else BasicAttack(target);


    }




}
