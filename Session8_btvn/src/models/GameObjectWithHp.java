package models;

/**
 * Created by Hau on 19/08/2016.
 */
public class GameObjectWithHp extends GameObject {
    private int maxHP;
    private int hp;


    public GameObjectWithHp(int x, int y, int width, int height, int maxHP) {
        super(x, y, width, height);
        this.hp = maxHP;
        this.maxHP = maxHP;

    }

    public int getMaxHP() {
        return maxHP;
    }

    public int getHp() {
        return hp;
    }

    public void increaseHP (int amount) {
        this.hp += amount;
        if (this.hp > this.maxHP) {
            this.hp = this.maxHP;
        }
    }

    public void decreaseHP (int amount) {
        this.hp -= amount;
        if (this.hp <= 0) {
            destroy();
        }
    }
}
