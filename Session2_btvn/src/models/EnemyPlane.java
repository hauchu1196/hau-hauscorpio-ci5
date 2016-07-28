package models;

/**
 * Created by Hau on 28/07/2016.
 */
public class EnemyPlane {
    public int x;
    public int y;
    public int dx;
    public int dy;

    public EnemyPlane(){

    }
    public EnemyPlane(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveTo(int x, int y){
        this.x = x;
        this.y = y;
    }
}
