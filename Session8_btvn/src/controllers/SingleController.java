package controllers;

import models.GameObject;
import models.GameVector;
import views.GameDrawer;

import java.awt.*;

/**
 * Created by Hau on 19/08/2016.
 */
public class SingleController implements BaseController {
    protected GameObject gameObject;
    protected GameDrawer gameDrawer;
    protected GameVector gameVector;

    public GameObject getGameObject() {
        return gameObject;
    }

    public GameVector getGameVector() {
        return gameVector;
    }

    public SingleController(GameObject gameObject, GameDrawer gameDrawer) {
        this.gameObject = gameObject;
        this.gameDrawer = gameDrawer;
        gameVector = new GameVector();
    }

    @Override
    public void draw(Graphics g) {
        gameDrawer.draw(g, gameObject);
    }

    @Override
    public void run() {
        gameObject.move(gameVector);
    }
}
