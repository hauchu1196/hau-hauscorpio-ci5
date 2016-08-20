package models;

/**
 * Created by Hau on 19/08/2016.
 */
public class Bullet extends GameObject {
    public static final int WIDTH = 10;
    public static final int HEIGHT = 30;
    private int damage;

    public int getDamage() {
        return damage;
    }

    public Bullet(int x, int y) {
        super(x, y, WIDTH, HEIGHT);
        damage = 1;
    }
}
