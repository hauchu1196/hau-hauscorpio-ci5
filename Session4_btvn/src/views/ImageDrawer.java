package views;

import models.GameObject;
import utils.Ultils;

import java.awt.*;

/**
 * Created by Hau on 31/07/2016.
 */
public class ImageDrawer implements GameDrawer{

    private Image image;

    public ImageDrawer(Image image) {
        this.image = image;
    }

    public ImageDrawer(String url) {
        this.image = Ultils.loadImage(url);
    }

    @Override
    public void draw(Graphics g, GameObject gameObject) {
        g.drawImage(image, gameObject.getX(),
                gameObject.getY(), gameObject.getWidth(),
                gameObject.getHeight(), null);
    }
}
