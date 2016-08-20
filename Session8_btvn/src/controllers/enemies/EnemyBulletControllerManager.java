package controllers.enemies;

import controllers.ControllerManager;

/**
 * Created by Hau on 20/08/2016.
 */
public class EnemyBulletControllerManager extends ControllerManager {
    private EnemyBulletControllerManager() {
    }
    private static EnemyBulletControllerManager instance = null;
    public static EnemyBulletControllerManager getInstance() {
        if (instance == null) {
            instance = new EnemyBulletControllerManager();
        }
        return instance;
    }
}
