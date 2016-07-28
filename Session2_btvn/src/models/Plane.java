package models;

import java.awt.*;

/**
 * Created by Hau on 27/07/2016.
 */
public class Plane {
    public int x;
    public int y;
    public int dx;
    public int dy;

    public Plane(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveTo(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void move() {
        x += dx;
        y += dy;
    }
}
