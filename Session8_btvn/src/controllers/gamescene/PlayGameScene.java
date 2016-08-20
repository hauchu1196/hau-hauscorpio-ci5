package controllers.gamescene;

import controllers.CollisionPool;
import controllers.PlaneController;
import controllers.ShieldControllerManager;
import controllers.bombs.BombControllerManager;
import controllers.bombs.FreezeControllerManager;
import controllers.bombs.GiftShieldControllerManager;
import controllers.enemies.EnemyBulletControllerManager;
import controllers.enemies.EnemyControllerManager;
import utils.Utils;

import java.awt.*;
import java.awt.event.KeyListener;

/**
 * Created by Hau on 19/08/2016.
 */
public class PlayGameScene implements GameScene {
    Image image;
    GameSceneListener gameSceneListener;

    public PlayGameScene() {
        this.image = Utils.loadImage("resources/background.png");
    }


    @Override
    public KeyListener getKeyListener() {
        return PlaneController.getInstance();
    }

    @Override
    public void setGameSceneListener(GameSceneListener gameSceneListener) {
        this.gameSceneListener = gameSceneListener;
        PlaneController.getInstance().setGameSceneListener(gameSceneListener);
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(image, 0, 0, null);
        PlaneController.getInstance().draw(g);
        EnemyControllerManager.getInstance().draw(g);
        EnemyBulletControllerManager.getInstance().draw(g);
        BombControllerManager.getInstance().draw(g);
        FreezeControllerManager.getInstance().draw(g);
        GiftShieldControllerManager.getInstance().draw(g);
        ShieldControllerManager.getInstance().draw(g);
//        BulletControllerManager.getInstance().draw(g);
    }

    @Override
    public void run() {
        PlaneController.getInstance().run();
        EnemyControllerManager.getInstance().run();
        EnemyBulletControllerManager.getInstance().run();
        CollisionPool.getInstance().run();
        BombControllerManager.getInstance().run();
        FreezeControllerManager.getInstance().run();
        GiftShieldControllerManager.getInstance().run();
        ShieldControllerManager.getInstance().run();
//        BulletControllerManager.getInstance().run();
    }
}
