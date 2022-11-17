package kg.geektech.game.players;

public abstract class Hero extends GameEntity implements HavingSuperAbility{

    public SuperAbility superAbility;
    public Hero(int health, int damage, SuperAbility superAbility) {
        super(health, damage);
        this.superAbility = superAbility;
    }


}
