package controllers.bombs;

import controllers.ControllerManager;
import models.GameSetting;

import java.awt.*;
import java.util.Random;

/**
 * Created by Hau on 20/08/2016.
 */
public class BombControllerManager extends ControllerManager {
    private int count;
    private static final int BOMB_PERIOD = 300;

    @Override
    public void run() {
        super.run();
        count++;
        Random random = new Random();
        int x = random.nextInt(GameSetting.getInstance().getScreenWidth());
        if (count == BOMB_PERIOD) {
            count = 0;
            BombController bombController = BombController.create(x, 0);
            BombControllerManager.getInstance().add(bombController);
        }
    }

    private static BombControllerManager instance = null;
    public static BombControllerManager getInstance() {
        if (instance == null) {
            instance = new BombControllerManager();
        }
        return instance;
    }
}
