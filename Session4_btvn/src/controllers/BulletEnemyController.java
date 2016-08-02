package controllers;

import models.Bullet;
import models.EnemyBullet;
import models.GameObject;
import models.Plane;
import views.GameDrawer;

/**
 * Created by Hau on 01/08/2016.
 */
public class BulletEnemyController extends SingleController implements Colliable {
    public static final int SPEED = 5;

    public BulletEnemyController(EnemyBullet gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollisionPool.instance.add(this);
        this.gameVector.dy = SPEED;
    }

    @Override

    public void run() {
        super.run();

        if (gameObject.getY() > 800) {
            gameObject.destroy();
        }

    }

    @Override
    public void onCollide(Colliable colliable) {
        if(colliable instanceof PlaneController) {
            colliable.getGameObject().dealHP();
            this.getGameObject().destroy();
        }
    }
}
