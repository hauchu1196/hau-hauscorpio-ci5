import controllers.CollisionPool;
import controllers.EnemyManager;
import controllers.PlaneController;
import utils.Ultils;

import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferedImage;

/**
 * Created by Hau on 31/07/2016.
 */
public class GameWindow extends Frame implements Runnable{
    public static final int WIDTH_DEFAULT = 600;
    public static final int HEIGHT_DEFAULT = 800;

    Image background;
    BufferedImage bufferedImage;
    Graphics bufferImageGraphic;
    Thread thread;

    public GameWindow() {
        setSize(WIDTH_DEFAULT, HEIGHT_DEFAULT);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

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
        this.addKeyListener(PlaneController.instance);

        background = Ultils.loadImage("resources/background.png");

        bufferedImage = new BufferedImage(WIDTH_DEFAULT, HEIGHT_DEFAULT, BufferedImage.TYPE_INT_ARGB);
        bufferImageGraphic = bufferedImage.getGraphics();
        thread = new Thread(this);
        thread.start();

    }

    @Override
    public void update(Graphics g) {
        bufferImageGraphic.drawImage(background, 0, 0, null);
        PlaneController.instance.draw(bufferImageGraphic);
        EnemyManager.instance.draw(bufferImageGraphic);
        bufferImageGraphic.drawString("HP:" + PlaneController.instance.getGameObject().getHp() ,50 ,50);
        g.drawImage(bufferedImage, 0, 0, null);

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(17);
                PlaneController.instance.run();
                EnemyManager.instance.run();
                CollisionPool.instance.run();
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
