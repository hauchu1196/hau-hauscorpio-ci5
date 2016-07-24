import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Hau on 24/07/2016.
 */
public class GameWindow extends Frame implements Runnable {
    private static final int SPEED = 10;
    Image background;
    Image plane1;
    Image plane2;
    int plane1X = 400;
    int plane1Y = 670;
    int plane2X = 200;
    int plane2Y = 670;
    Thread thread;
    BufferedImage bufferedImage;
    Graphics graphicsBufferedImage;

    public GameWindow() {
        this.setSize(600, 800);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);

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
        try {
            background = ImageIO.read(new File("resources/background.png"));
            plane1 = ImageIO.read(new File("resources/plane4.png"));
            plane2 = ImageIO.read(new File("resources/plane2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        plane1X -= SPEED;
                        break;
                    case KeyEvent.VK_RIGHT:
                        plane1X += SPEED;
                        break;
                    case KeyEvent.VK_UP:
                        plane1Y -= SPEED;
                        break;
                    case KeyEvent.VK_DOWN:
                        plane1Y += SPEED;
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                System.out.println("mouseDragged");
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                plane2X = e.getX() - 33;
                plane2Y = e.getY();
                System.out.println("mouseMoved");
            }
        });
        bufferedImage = new BufferedImage(600, 800, BufferedImage.TYPE_INT_ARGB);
        graphicsBufferedImage = bufferedImage.getGraphics();
        thread = new Thread(this);
        thread.start();

    }

    @Override
    public void update(Graphics g) {
        graphicsBufferedImage.drawImage(background, 0, 0, null);
        graphicsBufferedImage.drawImage(plane1, plane1X, plane1Y, null);
        graphicsBufferedImage.drawImage(plane2, plane2X, plane2Y, null);
        g.drawImage(bufferedImage, 0, 0, null);

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(27);
                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
