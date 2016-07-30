package models;

/**
 * Created by Hau on 31/07/2016.
 */
public class Bullet extends GameObject {
    public static final int WIDTH = 13;
    public static final int HEIGHT = 30;
    public Bullet(int x, int y) {
        super(x, y, WIDTH, HEIGHT);
    }
}
