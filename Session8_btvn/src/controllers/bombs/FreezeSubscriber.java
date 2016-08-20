package controllers.bombs;

import models.GameObject;

/**
 * Created by Hau on 20/08/2016.
 */
public interface FreezeSubscriber {
    GameObject getGameObject();
    void onFreeze(int x, int y);
}
