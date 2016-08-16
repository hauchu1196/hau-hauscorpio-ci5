package controllers.gamescenes;

import utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Hau on 16/08/2016.
 */
public class MenuGameScene implements KeyListener, GameScene {
    private static final String TAG = MenuGameScene.class.toString();
    private Image background;
    private GameSceneListener gameSceneListener;

    public MenuGameScene() {
        this.background = Utils.loadImage("resources/background_menu.jpg");
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(background, 0, 0, null);
    }

    @Override
    public KeyListener getKeyListener() {
        return this;
    }

    @Override
    public void setGameSceneListener(GameSceneListener gameSceneListener) {
        this.gameSceneListener = gameSceneListener;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (gameSceneListener != null) {
                gameSceneListener.changeGameScene(new PlayGameScene());
            } else {
                System.out.println(String.format("%s: gameSceneListener is not set", TAG));
            }
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {

    }
}
