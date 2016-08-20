package controllers.bombs;

import models.GameObject;

/**
 * Created by Hau on 20/08/2016.
 */
public interface BombSubscriber {
    void onBombExplode(int x, int y);
    GameObject getGameObject();
}
