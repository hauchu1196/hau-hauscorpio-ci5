package models;

/**
 * Created by Hau on 20/08/2016.
 */
public class Bomb extends GameObject{
    public static final int WITDH = 30;
    public static final int HEIGHT = 30;

    public Bomb(int x, int y) {
        super(x, y, WITDH, HEIGHT);
    }
}
