package controllers;

import controllers.enemies.EnemyController;
import models.GameObject;
import models.Shield;
import views.GameDrawer;

/**
 * Created by Hau on 20/08/2016.
 */
public class ShieldController extends SingleController implements Colliable {
    private double radian = 0;
    private double RADIUS = 100;
    private int SPEED = 8;
    private int COOLDOWN = 1000;
    private int count;
    private int countcd;

    public ShieldController(GameObject gameObject, GameDrawer gameDrawer) {
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
        countcd++;
        if (count == SPEED) {
            count = 0;
            this.getGameObject().moveTo(
                    (int) (PlaneController.getInstance().getGameObject().getMiddleX() - RADIUS * Math.cos(radian)),
                    (int) (PlaneController.getInstance().getGameObject().getMiddleY() - RADIUS * Math.sin(radian))
            );
            radian += 0.3;
            if (radian == 360) {
                radian = 0;
            }
        }
        if (countcd == COOLDOWN) {
            this.getGameObject().destroy();
        }
    }
}
