package controllers.enemies;

import controllers.ControllerManager;

/**
 * Created by Hau on 20/08/2016.
 */
public class EnemyControllerManager extends ControllerManager {
    private int count;
    private static final int RESPAWN_TYPE1 = 100;
    private static final int RESPAWN_TYPE2 = 200;

    @Override
    public void run() {
        super.run();
        count++;
        int enX = 10;
        int enY = 10;
        if (count == RESPAWN_TYPE2) {
            count = 0;
            for (int i = 0; i < 5; i++) {
                EnemyController enemyController = EnemyController.create(enX, enY, EnemyPlaneType.WHITE);
                this.add(enemyController);
                enX += 100;
            }
        } else if (count == RESPAWN_TYPE1) {
            for (int i = 0; i < 5; i++) {
                EnemyController enemyController = EnemyController.create(enX, enY, EnemyPlaneType.YELLOW);
                enX += 100;
                this.add(enemyController);
            }
        }
    }
    private static EnemyControllerManager instance = null;
    public static EnemyControllerManager getInstance() {
        if (instance == null) {
            instance = new EnemyControllerManager();
        }
        return instance;
    }
}
