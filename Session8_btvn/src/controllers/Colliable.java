package controllers;

import models.GameObject;

/**
 * Created by Hau on 20/08/2016.
 */
public interface Colliable {
    void onCollide(Colliable colliable);
    GameObject getGameObject();
}
