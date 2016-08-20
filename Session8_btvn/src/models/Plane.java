package models;

/**
 * Created by Hau on 19/08/2016.
 */
public class Plane extends GameObjectWithHp {
    public static final int WIDTH = 70;
    public static final int HEIGHT = 50;
    public static final int MAX_HP = 10;

    public Plane(int x, int y) {
        super(x, y, WIDTH, HEIGHT, MAX_HP);
    }

}
