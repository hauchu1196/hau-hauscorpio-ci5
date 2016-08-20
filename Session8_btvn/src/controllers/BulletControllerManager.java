package controllers;

/**
 * Created by Hau on 19/08/2016.
 */
public class BulletControllerManager extends ControllerManager {
    private BulletControllerManager() {
    }

    private static BulletControllerManager instance = null;
    public static BulletControllerManager getInstance() {
        if (instance == null) {
            instance = new BulletControllerManager();
        }
        return instance;
    }
}
