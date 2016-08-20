package controllers.enemies;

import controllers.Colliable;
import controllers.CollisionPool;
import controllers.SingleController;
import models.EnemyBullet;
import models.GameSetting;
import views.GameDrawer;

/**
 * Created by Hau on 20/08/2016.
 */
public class EnemyBulletController extends SingleController implements Colliable {
    public EnemyBulletController(EnemyBullet enemyBullet, GameDrawer gameDrawer) {
        super(enemyBullet, gameDrawer);
        CollisionPool.getInstance().add(this);
    }

    @Override
    public void run() {
        super.run();
        if (gameObject.getY() > GameSetting.getInstance().getScreenHeight()) {
            gameObject.destroy();
        }
    }

    @Override
    public void onCollide(Colliable colliable) {

    }
}
