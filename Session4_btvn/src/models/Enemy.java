package models;

/**
 * Created by Hau on 31/07/2016.
 */
public class Enemy extends GameObject {
    public static final int WIDTH = 45;
    public static final int HEIGHT = 30;

    public Enemy(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    public Enemy(int x, int y) {
        super(x, y, WIDTH, HEIGHT);
    }
}
