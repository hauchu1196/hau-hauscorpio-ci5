package controllers;

import models.Explosion;
import models.GameObject;
import views.GameDrawer;

/**
 * Created by Hau on 20/08/2016.
 */
public class ExplosionController extends SingleController {
    public ExplosionController(Explosion gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
    }
}
