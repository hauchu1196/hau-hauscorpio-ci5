package controllers.bombs;

import controllers.Colliable;
import controllers.CollisionPool;
import controllers.PlaneController;
import controllers.SingleController;
import javafx.print.PageLayout;
import models.GameObject;
import models.GameSetting;
import models.Lock;
import views.GameDrawer;
import views.ImageDrawer;

/**
 * Created by Hau on 20/08/2016.
 */
public class FreezeController extends SingleController implements Colliable {

    private static final int SPEED = 5;

    public FreezeController(GameObject gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollisionPool.getInstance().add(this);
        gameVector.down(SPEED);
    }

    public static FreezeController create(int x, int y) {
        return new FreezeController(
                new Lock(x, y),
                new ImageDrawer("resources/lock.png")
        );
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
        if (colliable instanceof PlaneController) {
            NotificationCenter.getInstance().onFreeze(gameObject.getX(), gameObject.getY());
            gameObject.destroy();

        }
    }
}
