package controllers;

import models.Bullet;
import models.Plane;
import views.GameDrawer;
import views.ImageDrawer;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Hau on 31/07/2016.
 */
public class PlaneController extends SingleController implements KeyListener, Colliable {

    public static final int SPEED = 5;
    private ControllerManager bulletManager;
    private GameInput gameInput;

    public PlaneController(Plane gameObject, GameDrawer gameDrawer) {
        super(gameObject, gameDrawer);
        CollisionPool.instance.add(this);
        this.bulletManager = new ControllerManager();
        this.gameInput = new GameInput();

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                this.gameInput.keyUp = true;
                break;
            case KeyEvent.VK_DOWN:
                this.gameInput.keyDown = true;
                break;
            case KeyEvent.VK_LEFT:
                this.gameInput.keyLeft = true;
                break;
            case KeyEvent.VK_RIGHT:
                this.gameInput.keyRight = true;
                break;
            case KeyEvent.VK_SPACE:
                this.gameInput.keySpace = true;
                break;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                this.gameInput.keyUp = false;
                break;
            case KeyEvent.VK_DOWN:
                this.gameInput.keyDown = false;
                break;
            case KeyEvent.VK_LEFT:
                this.gameInput.keyLeft = false;
                break;
            case KeyEvent.VK_RIGHT:
                this.gameInput.keyRight = false;
                break;
            case KeyEvent.VK_SPACE:
                this.gameInput.keySpace = false;
                break;
        }

    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
        bulletManager.draw(g);
    }

    @Override
    public void run() {
        this.gameVector.dx = 0;
        this.gameVector.dy = 0;

        if (!this.gameInput.keyUp && this.gameInput.keyDown) {
            this.gameVector.dy = SPEED;
        } else if (this.gameInput.keyUp && !this.gameInput.keyDown) {
            this.gameVector.dy = -SPEED;
        }
        if(gameInput.keyLeft && !gameInput.keyRight) {
            this.gameVector.dx = -SPEED;
        } else if(!gameInput.keyLeft && gameInput.keyRight) {
            this.gameVector.dx = SPEED;
        }
        if (gameInput.keySpace) {
            BulletController bulletController = new BulletController(
                    new Bullet(this.gameObject.middleX() - Bullet.WIDTH / 2, this.gameObject.getY()),
                    new ImageDrawer("resources/bullet.png")
            );
            bulletManager.add(bulletController);
        }

        super.run();
        bulletManager.run();
    }

    public final static PlaneController instance = new PlaneController(
            new Plane(250, 600),
            new ImageDrawer("resources/plane3.png")
    );

    @Override
    public void onCollide(Colliable colliable) {

    }
}
