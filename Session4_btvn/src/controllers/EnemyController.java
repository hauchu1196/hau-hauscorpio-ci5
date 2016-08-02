package controllers;

import models.Bullet;
import models.Enemy;
import models.EnemyBullet;
import models.GameObject;
import sun.awt.image.ShortInterleavedRaster;
import views.GameDrawer;
import views.ImageDrawer;

import java.awt.*;
import java.util.Vector;

/**
 * Created by Hau on 31/07/2016.
 */
public class EnemyController extends SingleController implements Colliable {

    public static final int SPEED = 3;
    public static final int TIME_SHOOT = 800;
    public boolean isShoot;
    public long timeLastShoot;

    private ControllerManager bulletManager;

    public EnemyController(Enemy gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.dy = SPEED;
        CollisionPool.instance.add(this);
        bulletManager = new ControllerManager();
        isShoot = true;
    }

    public void Shoot() {
        if (System.currentTimeMillis() - timeLastShoot > TIME_SHOOT) {
            timeLastShoot = System.currentTimeMillis();
            isShoot = true;
        } else {
            isShoot = false;
        }
    }

    @Override
    public void run() {
        super.run();
        bulletManager.run();
        if (this.gameObject.getY() > 800 || this.gameObject.getX() > 600) {
            gameObject.destroy();
        }
        Shoot();

        if (isShoot && this.getGameObject().getY() < PlaneController.instance.getGameObject().getY()) {
            BulletEnemyController bulletController = new BulletEnemyController(
                    new EnemyBullet((int) (gameObject.getX() + gameObject.getWidth() / 2 - EnemyBullet.WIDTH/2), this.gameObject.getY() + Bullet.HEIGHT),
                    new ImageDrawer("resources/enemy_bullet.png")
            );
            bulletManager.add(bulletController);
        }
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        bulletManager.draw(g);
    }

    @Override
    public void onCollide(Colliable colliable) {

    }
}
