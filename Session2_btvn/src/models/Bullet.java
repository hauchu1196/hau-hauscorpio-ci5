package models;

import java.awt.*;

/**
 * Created by Hau on 27/07/2016.
 */
public class Bullet {
    public int x;
    public int y;
    public int dx = 2;
    public int dy = 0;

    public Bullet() {

    }

    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public void moveTo(int x, int y){
        this.x = x;
        this.y = y;
    }
    public boolean conllision(int x, int y){
        return (this.x == x && this.y == y);

    }
}
