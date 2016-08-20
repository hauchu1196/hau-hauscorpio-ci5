package controllers.enemies;

/**
 * Created by Hau on 20/08/2016.
 */
public class FlyVerticalBehavior implements FlyBehavior {
    public static final int SPEED = 2;
    @Override
    public void doFly(EnemyController enemyController) {
        enemyController.getGameVector().down(SPEED);
    }
}
