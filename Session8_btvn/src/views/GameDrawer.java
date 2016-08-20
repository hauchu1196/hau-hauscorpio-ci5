package views;

import models.GameObject;

import java.awt.*;

/**
 * Created by Hau on 19/08/2016.
 */
public interface GameDrawer {
    void draw(Graphics g, GameObject gameObject);
}
