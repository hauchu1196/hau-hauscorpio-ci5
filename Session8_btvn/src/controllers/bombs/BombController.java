package controllers.bombs;

import com.sun.corba.se.spi.legacy.connection.GetEndPointInfoAgainException;
import controllers.Colliable;
import controllers.CollisionPool;
import controllers.PlaneController;
import controllers.SingleController;
import models.Bomb;
import models.GameSetting;
import views.GameDrawer;
import views.ImageDrawer;

/**
 * Created by Hau on 20/08/2016.
 */
public class BombController extends SingleController implements Colliable {
    public static final int SPEED = 10;
    public BombController(Bomb gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameVector.down(SPEED);
        CollisionPool.getInstance().add(this);
    }
    public static BombController create(int x, int y) {
        return new BombController(
                new Bomb(x, y),
                new ImageDrawer("resources/bomb.png")
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
            NotificationCenter.getInstance().onBombExplode(gameObject.getX(), gameObject.getY());
            gameObject.destroy();
        }
    }
}
