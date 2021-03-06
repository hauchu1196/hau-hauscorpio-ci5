package utils;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by Hau on 19/08/2016.
 */
public class Utils {
    public static BufferedImage loadImage(String url) {
        try {
            return ImageIO.read(new File(url));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Vector<Image> loadImages(String... urls) {
        Vector<Image> imageVector = new Vector<>();
        for (String url : urls) {
            imageVector.add(loadImage(url));
        }
        return imageVector;
    }

    public static Vector<Image> loadFromSprite(String url, boolean horizontal, int width, int height, int padding) {
        BufferedImage sprite = loadImage(url);
        Vector<Image> imageVector = new Vector<>();
        if (horizontal) {
            int y = padding;
            for (int x = padding; x < sprite.getWidth(); x += (width + padding)) {
                Image subImage = sprite.getSubimage(x, y, width, height);
                imageVector.add(subImage);
            }
        } else {
            int x = padding;
            for (int y = padding; y < sprite.getWidth(); y += (height + padding)) {
                Image subImage = sprite.getSubimage(x, y, width, height);
                imageVector.add(subImage);
            }
        }
        return imageVector;
    }

    public static void playSound(String audioUrl, boolean repeat) {
        File soundFile = new File(audioUrl);
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
            if (repeat) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                clip.loop(0);
            }
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
