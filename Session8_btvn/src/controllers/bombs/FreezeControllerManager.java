package controllers.bombs;

import controllers.ControllerManager;
import models.GameSetting;

import java.util.Random;

/**
 * Created by Hau on 20/08/2016.
 */
public class FreezeControllerManager extends ControllerManager {
    private int count;
    private static final int FREEZED_PERIOD = 200;

    @Override
    public void run() {
        super.run();
        count++;
        Random random = new Random();
        int x = random.nextInt(GameSetting.getInstance().getScreenWidth());
        if (count == FREEZED_PERIOD) {
            count = 0;
            FreezeController freezeController = FreezeController.create(x, 0);
            FreezeControllerManager.getInstance().add(freezeController);
        }

    }

    private static FreezeControllerManager instance = null;
    public static FreezeControllerManager getInstance() {
        if (instance == null) {
            instance = new FreezeControllerManager();
        }
        return instance;
    }
}
