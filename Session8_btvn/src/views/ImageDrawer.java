package views;

import models.GameObject;
import utils.Utils;

import java.awt.*;

/**
 * Created by Hau on 19/08/2016.
 */
public class ImageDrawer implements GameDrawer {
    Image image;

    public ImageDrawer(Image image) {
        this.image = image;
    }

    public ImageDrawer(String url) {
        this.image = Utils.loadImage(url);
    }

    @Override
    public void draw(Graphics g, GameObject gameObject) {
        g.drawImage(image, gameObject.getX(),
                gameObject.getY(), gameObject.getWidth(),
                gameObject.getHeight(), null);
    }
}
