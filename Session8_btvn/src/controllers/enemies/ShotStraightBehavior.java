package controllers.enemies;

import models.EnemyBullet;
import models.EnemyPlane;
import models.GameObject;
import models.GameSetting;
import views.ImageDrawer;

/**
 * Created by Hau on 20/08/2016.
 */
public class ShotStraightBehavior implements ShotBehavior {
    public static final int BULLET_SPEED = 5;
    public static final int ATK_SPEED = 1000;
    private int count;
    @Override
    public void doShot(EnemyController enemyController) {
        count++;
        if (GameSetting.getInstance().toMiliseconds(count) > ATK_SPEED) {
            count = 0;
            GameObject gameObject = enemyController.getGameObject();
            EnemyBulletController enemyBulletController = new EnemyBulletController(
                    new EnemyBullet(gameObject.getMiddleX() - EnemyBullet.WIDTH / 2, gameObject.getY() + EnemyPlane.HEIGHT - EnemyBullet.HEIGHT / 2),
                    new ImageDrawer("resources/enemy_bullet.png")
            );
            enemyBulletController.getGameVector().down(BULLET_SPEED);
            EnemyBulletControllerManager.getInstance().add(enemyBulletController);
        }
    }
}
