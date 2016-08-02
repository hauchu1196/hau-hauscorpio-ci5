package models;

import java.awt.*;

/**
 * Created by Hau on 31/07/2016.
 */
public class GameObject {
    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected int hp;

    protected boolean isAlive;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public GameObject(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.isAlive = true;
    }

    public int middleX() {
        return this.x + this.width/2;
    }

    public void destroy() {
        isAlive = false;
    }

    public void move(GameVector gameVector) {
        this.x += gameVector.dx;
        this.y += gameVector.dy;
    }

    public Rectangle getRect() {
        return new Rectangle(x, y, width, height);
    }

    public boolean overlap(GameObject gameObject) {
        Rectangle rect1 = this.getRect();
        Rectangle rect2 = gameObject.getRect();
        return rect1.intersects(rect2);
    }

    public int getHp() {
        return hp;
    }

    public void dealHP() {

        this.hp--;
    }
}
