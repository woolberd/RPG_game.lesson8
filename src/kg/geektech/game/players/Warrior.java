package kg.geektech.game.players;

import java.util.Random;

public class Warrior extends Hero implements HavingSuperAbility{


    public Warrior(int health, int damage) {
        super(health, damage, SuperAbility.CRITICAL_DAMAGE);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (boss.getHealth() > 0) {
            Random random = new Random();
            int coeff = random.nextInt(5) + 2;
            boss.setHealth(boss.getHealth() - this.getDamage() * coeff);
            System.out.println("Warrior critical damage" + this.getDamage() * coeff);

        }
    }
}
