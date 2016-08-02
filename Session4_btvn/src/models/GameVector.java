package models;

/**
 * Created by Hau on 31/07/2016.
 */
public class GameVector {
    public float dx;
    public float dy;

    public GameVector() {
        this(0, 0);
    }

    public GameVector(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }
}
