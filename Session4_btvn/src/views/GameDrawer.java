package views;

import models.GameObject;

import java.awt.*;

/**
 * Created by Hau on 31/07/2016.
 */
public interface GameDrawer {
    void draw(Graphics g, GameObject gameObject);
}
