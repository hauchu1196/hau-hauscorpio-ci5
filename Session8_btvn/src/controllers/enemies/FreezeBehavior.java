package controllers.enemies;

/**
 * Created by Hau on 20/08/2016.
 */
public class FreezeBehavior {
    private int count;
    private int freezePeriod;

    public FreezeBehavior(int freezePeriod) {
        this.freezePeriod = freezePeriod;
        this.count = 0;
    }

    public void run(EnemyController enemyController) {
        switch (enemyController.getEnemyState()) {
            case NORMAL:
                break;
            case FREEZED:
                count++;
                if (count > freezePeriod) {
                    count = 0;
                    enemyController.setEnemyState(EnemyState.NORMAL);
                }
                break;
        }
    }
}
