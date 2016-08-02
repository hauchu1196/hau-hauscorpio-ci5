package controllers;

import models.Bullet;
import models.GameObject;
import views.GameDrawer;

/**
 * Created by Hau on 31/07/2016.
 */
public class BulletController extends SingleController implements Colliable {

    public static final int SPEED = 11;

    public BulletController(Bullet gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dy = -SPEED;
        CollisionPool.instance.add(this);
    }

    @Override
    public void run() {
        super.run();
        if(gameObject.getY() < 0) {
            gameObject.destroy();
        }
    }

    @Override
    public void onCollide(Colliable colliable) {
        if(colliable instanceof EnemyController) {
            this.getGameObject().destroy();
            colliable.getGameObject().destroy();
        }

    }
}
