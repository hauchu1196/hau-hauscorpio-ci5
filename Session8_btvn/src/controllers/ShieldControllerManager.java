package controllers;

/**
 * Created by Hau on 20/08/2016.
 */
public class ShieldControllerManager extends ControllerManager {
    private static ShieldControllerManager instance = null;
    public static ShieldControllerManager getInstance() {
        if (instance == null) {
            instance = new ShieldControllerManager();
        }
        return instance;
    }
}
