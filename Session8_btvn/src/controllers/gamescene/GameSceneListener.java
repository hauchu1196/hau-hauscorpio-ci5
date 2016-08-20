package controllers.gamescene;

/**
 * Created by Hau on 19/08/2016.
 */
public interface GameSceneListener {
    void changeGameScene(GameScene gameScene, boolean addToStack);
    void back();
}
