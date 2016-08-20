package controllers.enemies;

import models.GameObject;
import models.GameSetting;
import models.GameVector;

/**
 * Created by Hau on 20/08/2016.
 */
public class FlyZigZacBehavior implements FlyBehavior {
    public static final int SPEED = 2;
    private boolean startup = true;

    @Override
    public void doFly(EnemyController enemyController) {
        GameObject gameObject = enemyController.getGameObject();
        GameVector gameVector = enemyController.getGameVector();

        if (startup) {
            gameVector.down(SPEED);
            gameVector.right(SPEED);
            startup = false;
        } else {
            if (gameObject.getX() > GameSetting.getInstance().getScreenWidth()) {
                gameVector.left(SPEED);
            } else if (gameObject.getX() < 0) {
                gameVector.right(SPEED);
            }
        }
    }
}
