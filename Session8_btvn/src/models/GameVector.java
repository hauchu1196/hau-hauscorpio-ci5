package models;

/**
 * Created by Hau on 19/08/2016.
 */
public class GameVector {
    public int dx;
    public int dy;

    public GameVector() {
        this(0, 0);
    }

    public GameVector(int dx, int dy) {
        this.dx = dx;
        this.dy = dy;
    }

    public void up(int speed) {
        this.dy = -speed;
    }
    public void down(int speed) {
        this.dy = speed;
    }
    public void left(int speed) {
        this.dx = -speed;
    }
    public void right(int speed) {
        this.dx = speed;
    }

    public void reset() {
        this.dx = 0;
        this.dy = 0;
    }
}
