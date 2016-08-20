package controllers.enemies;

import controllers.PlaneController;
import models.*;
import views.ImageDrawer;

/**
 * Created by Hau on 20/08/2016.
 */
public class ShowFollowBehavior implements ShotBehavior {
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
            GameVector gameVector = enemyBulletController.getGameVector();
            int dx = PlaneController.getInstance().getGameObject().getX() - gameObject.getX();
            int dy = PlaneController.getInstance().getGameObject().getY() - gameObject.getY();
            if (dy > 0) {
                double ratio = Math.sqrt(dx * dx + dy * dy) / BULLET_SPEED;

                gameVector.dx = (int) (dx / ratio);
                gameVector.dy = (int) (dy / ratio);

                EnemyBulletControllerManager.getInstance().add(enemyBulletController);
            }
        }
    }
}
