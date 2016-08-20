package controllers.bombs;

import models.GameObject;

/**
 * Created by Hau on 20/08/2016.
 */
public interface ShieldSubscriber {
    GameObject getGameObject();
    void onShield(int x, int y);
}
