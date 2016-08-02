package controllers;

import models.GameObject;

/**
 * Created by Hau on 31/07/2016.
 */
public interface Colliable {
    GameObject getGameObject();
    void onCollide(Colliable colliable);
}
