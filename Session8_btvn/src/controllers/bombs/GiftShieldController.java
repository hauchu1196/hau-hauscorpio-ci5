package controllers.bombs;

import controllers.Colliable;
import controllers.CollisionPool;
import controllers.PlaneController;
import controllers.SingleController;
import models.Shield;
import views.GameDrawer;
import views.ImageDrawer;

/**
 * Created by Hau on 20/08/2016.
 */
public class GiftShieldController extends SingleController implements Colliable {
    public static final int SPEED = 5;
    public GiftShieldController(Shield gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.down(SPEED);
        CollisionPool.getInstance().add(this);
    }

    public static GiftShieldController create(int x, int y) {
        return new GiftShieldController(
                new Shield(x, y),
                new ImageDrawer("resources/sharingan.png")
        );
    }

    @Override
    public void run() {
        super.run();
    }

    @Override
    public void onCollide(Colliable colliable) {
        if (colliable instanceof PlaneController) {
            NotificationCenter.getInstance().onShield(gameObject.getX(), gameObject.getY());
            gameObject.destroy();
        }
    }
}
