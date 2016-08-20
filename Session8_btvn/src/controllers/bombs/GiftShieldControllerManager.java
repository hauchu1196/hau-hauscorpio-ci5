package controllers.bombs;

import controllers.ControllerManager;
import models.GameSetting;

import java.util.Random;

/**
 * Created by Hau on 20/08/2016.
 */
public class GiftShieldControllerManager extends ControllerManager {
    private int count;
    public static final int SHIELD_PERIOD = 200;
    private GiftShieldControllerManager() {
    }

    @Override
    public void run() {
        super.run();

        count++;
        Random random = new Random();
        int x = random.nextInt(GameSetting.getInstance().getScreenWidth());
        if (count == SHIELD_PERIOD) {
            count = 0;
            GiftShieldController shieldController = GiftShieldController.create(x, 0);
            GiftShieldControllerManager.getInstance().add(shieldController);
        }

    }


    private static GiftShieldControllerManager instance = null;

    public static GiftShieldControllerManager getInstance() {
        if (instance == null) {
            instance = new GiftShieldControllerManager();
        }
        return instance;
    }
}
