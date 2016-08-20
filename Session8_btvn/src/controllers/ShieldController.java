package controllers;

import controllers.enemies.EnemyController;
import models.GameObject;
import models.Shield;
import views.GameDrawer;

/**
 * Created by Hau on 20/08/2016.
 */
public class ShieldController extends SingleController implements Colliable {
    private static final double RADIUS = 100;
    private static final int SPEED = 4;
    private static final int COOL_DOWN = 300;
    private double angle = 0;
    private int count;
    private int countCd;

    public ShieldController(Shield gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollisionPool.getInstance().add(this);
    }

    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof EnemyController) {
            ((EnemyController) colliable).destroy();
        }
    }

    @Override
    public void run() {
        super.run();
        count++;
        countCd++;
        if (count == SPEED) {
            count = 0;
            gameVector.dx = (int) (PlaneController.getInstance().getGameObject().getX() + RADIUS * Math.cos(angle));
            gameVector.dy = (int) (PlaneController.getInstance().getGameObject().getY() + RADIUS * Math.sin(angle));
            angle++;
            if (angle == 360) {
                angle = 0;
            }
        }
        if (countCd == COOL_DOWN) {
//            this.gameObject.destroy();
        }
    }
}
