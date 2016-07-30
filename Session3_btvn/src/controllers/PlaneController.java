package controllers;

import models.Bullet;
import models.GameObject;
import models.GameVector;
import models.Plane;
import views.GameDrawer;
import views.ImageDrawer;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static javafx.scene.CacheHint.SPEED;

/**
 * Created by Hau on 31/07/2016.
 */
public class PlaneController extends SingleController implements KeyListener {

    public static final int SPEED = 10;
    private ControllerManager bulletManager;

    private PlaneController(Plane gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        this.bulletManager = new ControllerManager();
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        bulletManager.draw(g);
    }

    @Override
    public void run() {
        super.run();
        bulletManager.run();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                gameVector.dy = -SPEED;
                break;
            case KeyEvent.VK_DOWN:
                gameVector.dy = SPEED;
                break;
            case KeyEvent.VK_LEFT:
                gameVector.dx = -SPEED;
                break;
            case KeyEvent.VK_RIGHT:
                gameVector.dx = SPEED;
                break;
            case KeyEvent.VK_SPACE:
                BulletController bulletController = new BulletController(
                        new Bullet(this.gameObject.middleX() - Bullet.WIDTH / 2,
                                this.gameObject.getY()), new ImageDrawer("resources/bullet.png"));
                bulletManager.add(bulletController);
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
            case KeyEvent.VK_DOWN:
                gameVector.dy = 0;
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_RIGHT:
                gameVector.dx = 0;
                break;
        }
    }

    private static PlaneController planeController1;

    public static PlaneController getPlaneController1() {
        if(planeController1 == null) {
            planeController1 = new PlaneController(
                    new Plane(250, 600),
                    new ImageDrawer("resources/plane3.png")
                    );
        }
        return planeController1;
    }
}
