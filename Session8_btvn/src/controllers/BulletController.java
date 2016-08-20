package controllers;

import controllers.enemies.EnemyController;
import models.Bullet;
import models.GameObject;
import models.GameObjectWithHp;
import models.GameSetting;
import views.GameDrawer;

import java.awt.*;

/**
 * Created by Hau on 19/08/2016.
 */
public class BulletController extends SingleController implements Colliable{
    public static final int SPEED = 10;

    public BulletController(Bullet gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.up(SPEED);
        CollisionPool.getInstance().add(this);
    }

    @Override
    public void run() {
        super.run();
        if (gameObject.getY() < 0) {
            gameObject.destroy();
        }
    }

    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof EnemyController) {
            Bullet bullet = (Bullet) gameObject;
            this.getGameObject().destroy();
            GameObjectWithHp target = (GameObjectWithHp) colliable.getGameObject();
            target.decreaseHP(bullet.getDamage());
            if (target.getHp() <= 0) {
                ((EnemyController) colliable).destroy();
            }
        }
    }
}
