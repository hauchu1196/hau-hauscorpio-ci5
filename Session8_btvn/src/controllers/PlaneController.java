package controllers;

import controllers.bombs.NotificationCenter;
import controllers.bombs.ShieldSubscriber;
import controllers.gamescene.GameOverGameScene;
import controllers.gamescene.GameSceneListener;
import models.*;
import views.GameDrawer;
import views.ImageDrawer;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Hau on 19/08/2016.
 */
public class PlaneController extends SingleController implements KeyListener, Colliable, ShieldSubscriber {
    public static final int SPEED = 5;
    public static final int ATK_SPEED = 300;
    private int count;
    GameInput gameInput;
    GameSceneListener gameSceneListener;
    ControllerManager bulletManager;



    public PlaneController(Plane gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.gameInput = new GameInput();
        bulletManager = new ControllerManager();
        NotificationCenter.getInstance().subscribeShield(this);
        CollisionPool.getInstance().add(this);
    }

    public void setGameSceneListener(GameSceneListener gameSceneListener) {
        this.gameSceneListener = gameSceneListener;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                gameInput.keyUp = true;
                break;
            case KeyEvent.VK_LEFT:
                gameInput.keyLeft = true;
                break;
            case KeyEvent.VK_RIGHT:
                gameInput.keyRight = true;
                break;
            case KeyEvent.VK_DOWN:
                gameInput.keyDown = true;
                break;
            case KeyEvent.VK_SPACE:
                gameInput.keySpace = true;
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                gameInput.keyUp = false;
                break;
            case KeyEvent.VK_LEFT:
                gameInput.keyLeft = false;
                break;
            case KeyEvent.VK_RIGHT:
                gameInput.keyRight = false;
                break;
            case KeyEvent.VK_DOWN:
                gameInput.keyDown = false;
                break;
            case KeyEvent.VK_SPACE:
                gameInput.keySpace = false;
                break;
            case KeyEvent.VK_S:
                gameSceneListener.changeGameScene(new GameOverGameScene(), false);
                break;
        }
    }

    @Override
    public void run() {
        super.run();
        BulletControllerManager.getInstance().run();
        count++;
        gameVector.reset();
        if (gameInput.keyUp && !gameInput.keyDown) {
            gameVector.up(SPEED);
        } else if (!gameInput.keyUp && gameInput.keyDown) {
            gameVector.down(SPEED);
        }
        if (gameInput.keyLeft && !gameInput.keyRight) {
            gameVector.left(SPEED);
        } else if (!gameInput.keyLeft && gameInput.keyRight) {
            gameVector.right(SPEED);
        }
        if (gameInput.keySpace) {
            if (GameSetting.getInstance().toMiliseconds(count) > ATK_SPEED) {
                count = 0;
                BulletController bulletController = new BulletController(
                        new Bullet(gameObject.getMiddleX() - Bullet.WIDTH / 2, gameObject.getY() - Bullet.HEIGHT),
                        new ImageDrawer("resources/bullet.png")
                );
//                bulletManager.add(bulletController);
                BulletControllerManager.getInstance().add(bulletController);
            }
        }
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        BulletControllerManager.getInstance().draw(g);
    }

    private static PlaneController instance = null;

    public static PlaneController getInstance() {
        if (instance == null) {
            instance = new PlaneController(
                    new Plane(250, 600),
                    new ImageDrawer("resources/plane2.png")
            );
        }
        return instance;
    }

    @Override
    public void onCollide(Colliable colliable) {

    }

    @Override
    public void onShield(int x, int y) {
        ShieldController shieldController = new ShieldController(
                new Shield(gameObject.getX() - 100, gameObject.getY()),
                new ImageDrawer("resources/sharingan.png")
        );
        ShieldControllerManager.getInstance().add(shieldController);

    }
}
