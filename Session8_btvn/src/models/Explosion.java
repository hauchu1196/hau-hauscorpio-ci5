package models;

/**
 * Created by Hau on 20/08/2016.
 */
public class Explosion extends GameObject {

    private static final int WITDH = 30;
    private static final int HEIGHT = 30;

    public Explosion(int x, int y) {
        super(x, y, WITDH, HEIGHT);
    }
}
