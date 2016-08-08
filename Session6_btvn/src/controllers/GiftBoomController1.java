package controllers;

import models.GiftBoom;
import views.GameDrawer;

/**
 * Created by Hau on 08/08/2016.
 */
public class GiftBoomController1 extends SingleController implements Colliable{
    public static final int GIFT_SPEED = 5;
    protected int radius;
    public GiftBoomController1(GiftBoom gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollsionPool.instance.add(this);
        this.gameVector.dy = GIFT_SPEED;
        this.radius = 200;
    }

    @Override
    public void run() {
        super.run();
        if(this.getGameObject().getY() > 800) {
            this.getGameObject().destroy();
        }
    }

    @Override
    public void onCollide(Colliable colliable) {
         if (colliable instanceof PlaneController) {
            this.getGameObject().destroy();
            EnemyControllerManager.instance.destroyForRadius(radius, this.getGameObject().getX(), this.gameObject.getY());
        }
    }
}
