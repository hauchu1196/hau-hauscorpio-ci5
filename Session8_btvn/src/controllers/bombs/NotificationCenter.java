package controllers.bombs;

import models.Bomb;

import java.util.Iterator;
import java.util.Vector;

/**
 * Created by Hau on 20/08/2016.
 */
public class NotificationCenter {
    private Vector<BombSubscriber> bombSubscriberVector;

    private Vector<FreezeSubscriber> freezeSubscriberVector;

    private Vector<ShieldSubscriber> shieldSubscriberVector;

    public NotificationCenter() {
        this.bombSubscriberVector = new Vector<>();
        this.freezeSubscriberVector = new Vector<>();
        this.shieldSubscriberVector = new Vector<>();
    }

    public void subscribe(BombSubscriber bombSubscriber) {
        bombSubscriberVector.add(bombSubscriber);
    }

    public void subscribeFreeze(FreezeSubscriber freezeSubscriber) {
        freezeSubscriberVector.add(freezeSubscriber);
    }

    public void subscribeShield(ShieldSubscriber shieldSubscriber) {
        shieldSubscriberVector.add(shieldSubscriber);
    }

    public void onBombExplode(int x, int y) {
        Iterator<BombSubscriber> bombSubscriberIterator = bombSubscriberVector.iterator();
        while (bombSubscriberIterator.hasNext()) {
            BombSubscriber bombSubscriber = bombSubscriberIterator.next();
            if (!bombSubscriber.getGameObject().isAlive()) {
                bombSubscriberIterator.remove();
            } else {
                bombSubscriber.onBombExplode(x, y);
            }
        }
    }

    public void onFreeze(int x, int y) {
        Iterator<FreezeSubscriber> freezeSubscriberIterator = freezeSubscriberVector.iterator();
        while (freezeSubscriberIterator.hasNext()) {
            FreezeSubscriber freezeSubscriber = freezeSubscriberIterator.next();
            if (!freezeSubscriber.getGameObject().isAlive()) {
                freezeSubscriberIterator.remove();
            } else {
                freezeSubscriber.onFreeze(x, y);
            }
        }
    }

    private static NotificationCenter instance = null;
    public static NotificationCenter getInstance() {
        if (instance == null) {
            instance = new NotificationCenter();
        }
        return instance;
    }

    public void onShield(int x, int y) {
        Iterator<ShieldSubscriber> shieldSubscriberIterator = shieldSubscriberVector.iterator();
        while (shieldSubscriberIterator.hasNext()) {
            ShieldSubscriber shieldSubscriber = shieldSubscriberIterator.next();
            if (!shieldSubscriber.getGameObject().isAlive()) {
                shieldSubscriberIterator.remove();
            } else {
                shieldSubscriber.onShield(x, y);
            }
        }
    }
}
