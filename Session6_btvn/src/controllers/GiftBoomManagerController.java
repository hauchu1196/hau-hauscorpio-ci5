package controllers;

import models.GiftBoom;
import views.ImageDrawer;

import java.awt.*;
import java.util.Random;

/**
 * Created by Hau on 08/08/2016.
 */
public class GiftBoomManagerController extends ControllerManager {
    public static final int TIME_CREATE_GIFT = 100;
    private int count;
    public GiftBoomManagerController() {
        super();
    }

    @Override
    public void run() {
        super.run();
        count++;
        int enX;
        int enY = 0;
        if(count % TIME_CREATE_GIFT == 0 && count / TIME_CREATE_GIFT == 5 ) {
            count = 0;
            Random random = new Random();
            enX = random.nextInt(550);
            GiftBoomController2 giftBoomController = new GiftBoomController2(
                    new GiftBoom(enX, enY),
                    new ImageDrawer("resources/boom2.png")
            );
            this.add(giftBoomController);
        } else if (count % TIME_CREATE_GIFT == 0){
            Random random = new Random();
            enX = random.nextInt(550);
            GiftBoomController1 giftBoomController = new GiftBoomController1(
                    new GiftBoom(enX, enY),
                    new ImageDrawer("resources/boom1.png")
            );
            this.add(giftBoomController);
        }
    }

    @Override
    public void draw(Graphics g) {
        super.draw(g);
    }

    public static final GiftBoomManagerController instance = new GiftBoomManagerController();

}
