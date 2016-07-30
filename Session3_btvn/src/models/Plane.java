package models;

/**
 * Created by Hau on 31/07/2016.
 */
public class Plane extends GameObject {
    public static final int WIDTH = 70;
    public static final int HEIGHT = 50;


    public Plane(int x, int y) {
        super(x, y, WIDTH, HEIGHT);
    }
}
