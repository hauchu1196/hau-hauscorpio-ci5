package controllers;

import com.sun.org.apache.xpath.internal.SourceTree;
import models.Enemy;
import views.ImageDrawer;

import java.util.Random;

/**
 * Created by Hau on 31/07/2016.
 */
public class EnemyManager extends ControllerManager {

    public EnemyManager() {
        super();

    }

    @Override
    public void run() {
        super.run();
        Random random = new Random();
        int color = random.nextInt(2);
        System.out.println(color);
        if (getSingleControllerVector().size() < 10) {
            if (color != 1) {
                int enX = random.nextInt(500);
                int enY = random.nextInt(200);
                EnemyController enemyController = new EnemyController(
                        new Enemy(enX, enY),
                        new ImageDrawer("resources/enemy_plane_white_3.png")
                );
                enemyController.gameVector.dy = 0;
                enemyController.gameVector.dx = EnemyController.SPEED;
                this.add(enemyController);
            } else {
                int enX = random.nextInt(500);
                int enY = random.nextInt(200);
                EnemyController enemyController = new EnemyController(
                        new Enemy(enX, enY),
                        new ImageDrawer("resources/enemy_plane_yellow_3.png")
                );
                this.add(enemyController);
            }
        }
    }

    public static final EnemyManager instance = new EnemyManager();
}
