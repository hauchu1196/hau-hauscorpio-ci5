package models;

/**
 * Created by Hau on 20/08/2016.
 */
public class EnemyPlane extends GameObjectWithHp {
    public static final int WIDTH = 30;
    public static final int HEIGHT = 30;


    public EnemyPlane(int x, int y, int maxHP) {
        super(x, y, WIDTH, HEIGHT, maxHP);
    }
}
