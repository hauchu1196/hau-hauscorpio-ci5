package controllers;

import models.GameObject;

import java.awt.*;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by Hau on 31/07/2016.
 */
public class CollisionPool implements BaseController {

    private Vector<Colliable> colliableVector;

    public CollisionPool() {
        this.colliableVector = new Vector<Colliable>();
    }

    public void add(Colliable colliable) {
        this.colliableVector.add(colliable);
    }

    @Override
    public void draw(Graphics g) {

    }

    @Override
    public void run() {
        for (int i = 0; i < colliableVector.size() - 1; i++) {
            Colliable ci = colliableVector.get(i);
            for (int j = i + 1; j < colliableVector.size(); j++) {
                Colliable cj = colliableVector.get(j);

                GameObject gi = ci.getGameObject();
                GameObject gj = cj.getGameObject();

                if(gi.overlap(gj)) {
                    ci.onCollide(cj);
                    cj.onCollide(ci);
                }
            }
        }

        Iterator<Colliable> colliableIterator = this.colliableVector.iterator();
        while(colliableIterator.hasNext()) {
            Colliable colliable = colliableIterator.next();
            if(!colliable.getGameObject().isAlive()) {
                colliableIterator.remove();
            }
        }
    }
    public static final CollisionPool instance = new CollisionPool();
}
