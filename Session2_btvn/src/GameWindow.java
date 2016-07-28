import models.Bullet;
import models.EnemyPlane;
import models.Plane;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Random;
import java.util.Vector;

/**
 * Created by Hau on 24/07/2016.
 */
public class GameWindow extends Frame implements Runnable {
    private static final int SPEED = 10;
    Image background;
    Image plane1Image;
    Image plane2Image;
    Image enemyPlaneImage;
    Image bulletImage;

    Plane plane1;
    Plane plane2;

    Vector<Bullet> bulletVector;
    Vector<EnemyPlane> enemyPlaneVector;

    int plane2ImageWitdh;
    int plane2ImageHeight;
    int plane1ImageWitdh;
    int plane1ImageHeight;
    int enemyPlaneImageWidth;
    int enemyPlaneImageHeight;
    long timeCreateEnemyPlane = 0;

    Thread thread;
    BufferedImage bufferedImage;
    Graphics graphicsBufferedImage;

    public GameWindow() {
        this.setSize(600, 800);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        plane1 = new Plane(400, 670);
        plane2 = new Plane(200, 670);
        bulletVector = new Vector<>();
        enemyPlaneVector = new Vector<>();


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
            plane1Image = ImageIO.read(new File("resources/plane4.png"));
            plane2Image = ImageIO.read(new File("resources/plane2.png"));
            bulletImage = ImageIO.read(new File("resources/bullet.png"));
            enemyPlaneImage = ImageIO.read(new File("resources/enemy_plane_white_3.png"));
            plane2ImageWitdh = plane2Image.getWidth(null);
            plane2ImageHeight = plane2Image.getHeight(null);
            plane1ImageWitdh = plane1Image.getWidth(null);
            enemyPlaneImageWidth = enemyPlaneImage.getWidth(null);
            enemyPlaneImageHeight = enemyPlaneImage.getHeight(null);
            plane1ImageHeight = plane1Image.getHeight(null);
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
                        plane1.moveTo(plane1.x - SPEED, plane1.y);
                        break;
                    case KeyEvent.VK_RIGHT:
                        plane1.moveTo(plane1.x + SPEED, plane1.y);
                        break;
                    case KeyEvent.VK_UP:
                        plane1.moveTo(plane1.x, plane1.y - SPEED);
                        break;
                    case KeyEvent.VK_DOWN:
                        plane1.moveTo(plane1.x, plane1.y + SPEED);
                        break;
                    case KeyEvent.VK_SPACE:
                        Bullet bullet = new Bullet();
                        bullet.moveTo(plane1.x + plane1ImageWitdh / 2 - 5, plane1.y);
                        bulletVector.add(bullet);
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        this.addMouseMotionListener(new MouseAdapter() {

            @Override
            public void mouseMoved(MouseEvent e) {
                plane2.moveTo(e.getX() - plane2ImageWitdh / 2, e.getY() - plane2ImageHeight / 2);
            }
        });
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {
                Bullet bullet = new Bullet();
                bullet.moveTo(plane2.x + plane2ImageWitdh / 2 - 5, plane2.y);
                bulletVector.add(bullet);

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

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
        graphicsBufferedImage.drawImage(plane1Image, plane1.x, plane1.y, null);
        graphicsBufferedImage.drawImage(plane2Image, plane2.x, plane2.y, null);
        for (Bullet bullet : bulletVector) {
            graphicsBufferedImage.drawImage(bulletImage, bullet.x, bullet.y, null);
        }
        for (EnemyPlane enemyPlane : enemyPlaneVector) {
            graphicsBufferedImage.drawImage(enemyPlaneImage, enemyPlane.x, enemyPlane.y, null);
        }
        g.drawImage(bufferedImage, 0, 0, null);

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(27);
//                for(Bullet bullet : bulletVector) {
//                    bullet.y -= 10;
//                    if(bullet.y <= 0){
//                        bulletVector.remove(bullet);
//                    }
//                }


                if (System.currentTimeMillis() - timeCreateEnemyPlane >= 500 && enemyPlaneVector.size() < 10) {
                    timeCreateEnemyPlane = System.currentTimeMillis();

                    Random random = new Random();
                    EnemyPlane enemyPlane = new EnemyPlane(random.nextInt(550), 100);
                    enemyPlaneVector.add(enemyPlane);
                }
                Iterator<EnemyPlane> enemyPlaneIterator = enemyPlaneVector.iterator();
                while (enemyPlaneIterator.hasNext()) {
                    EnemyPlane plane = enemyPlaneIterator.next();
                    plane.y += 5;
                    if (plane.y >= 800) {
                        enemyPlaneIterator.remove();
                    }
                }


                Iterator<Bullet> bulletIterator = bulletVector.iterator();
                Iterator<EnemyPlane> enemyPlaneIterator1 = enemyPlaneVector.iterator();
                while (bulletIterator.hasNext()) {
                    Bullet bullet = bulletIterator.next();
                    bullet.y -= 10;
                    while (enemyPlaneIterator1.hasNext()) {
                        EnemyPlane enemyPlane = enemyPlaneIterator1.next();
                        System.out.println("EnemyPlane :" + enemyPlane.x + " " + enemyPlane.y);
                        System.out.println("Bullet :" + bullet.x + " " + bullet.y);
                        if (bullet.y <= enemyPlane.y + enemyPlaneImageHeight
                                && bullet.y >= enemyPlane.y - enemyPlaneImageHeight
                                && bullet.x >= enemyPlane.x - enemyPlaneImageWidth
                                && bullet.x <= enemyPlane.x + enemyPlaneImageWidth) {
                            bulletIterator.remove();
                            enemyPlaneIterator1.remove();
                        }
                    }
                    if (bullet.y <= 100) {
                        bulletIterator.remove();
                    }
                }

                repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
