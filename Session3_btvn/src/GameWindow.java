import controllers.PlaneController;
import utils.Utils;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;

/**
 * Created by Hau on 30/07/2016.
 */
public class GameWindow extends Frame implements Runnable{
    Image background;
    BufferedImage bufferedImage;
    Graphics bufferGraphicsImage;
    Thread thread;
    PlaneController planeController;

    public GameWindow() {
        setSize(600, 800);
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);

        this.addWindowListener(new WindowListener() {
            @Override
            public void windowOpened(WindowEvent e) {

            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }

            @Override
            public void windowClosed(WindowEvent e) {

            }

            @Override
            public void windowIconified(WindowEvent e) {

            }

            @Override
            public void windowDeiconified(WindowEvent e) {

            }

            @Override
            public void windowActivated(WindowEvent e) {

            }

            @Override
            public void windowDeactivated(WindowEvent e) {

            }
        });

        background = Utils.loadImage("resources/background.png");

        planeController = PlaneController.getPlaneController1();

        this.addKeyListener(planeController);

        bufferedImage = new BufferedImage(600, 800, BufferedImage.TYPE_INT_ARGB);
        bufferGraphicsImage = bufferedImage.getGraphics();
        thread = new Thread(this);
        thread.start();


    }

    @Override
    public void update(Graphics g) {
        bufferGraphicsImage.drawImage(background, 0, 0, null);
        planeController.draw(bufferGraphicsImage);
        g.drawImage(bufferedImage, 0, 0, null);
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(17);
                planeController.run();
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
