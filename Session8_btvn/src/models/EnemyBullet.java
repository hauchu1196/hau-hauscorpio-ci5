package models;

import models.GameObject;

/**
 * Created by Hau on 20/08/2016.
 */
public class EnemyBullet extends GameObject {
    public static final int WIDTH = 30;
    public static final int HEIGHT = 30;

    public EnemyBullet(int x, int y) {
        super(x, y, WIDTH, HEIGHT);
    }
}
