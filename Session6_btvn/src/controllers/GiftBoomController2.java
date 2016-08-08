package controllers;

import models.GameObject;
import models.GiftBoom;
import views.GameDrawer;

/**
 * Created by Hau on 08/08/2016.
 */
public class GiftBoomController2 extends GiftBoomController1 implements Colliable  {

    public GiftBoomController2(GiftBoom gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.radius = 800;
    }

}
