package controllers;

import java.awt.*;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by Hau on 31/07/2016.
 */
public class ControllerManager implements BaseController {

    private Vector<SingleController> singleControllerVector;

    public Vector<SingleController> getSingleControllerVector() {
        return singleControllerVector;
    }

    public ControllerManager() {
        this.singleControllerVector = new Vector<SingleController>();
    }

    public void add(SingleController singleController) {
        this.singleControllerVector.add(singleController);
    }

    @Override
    public void draw(Graphics g) {
        synchronized (this.singleControllerVector) {
            Iterator<SingleController> singleControllerIterator = this.singleControllerVector.iterator();
            while (singleControllerIterator.hasNext()) {
                SingleController singleController = singleControllerIterator.next();
                if (singleController.getGameObject().isAlive()) {
                    singleController.draw(g);
                }
            }
        }

    }

    @Override
    public void run() {
        synchronized (this.singleControllerVector) {
            Iterator<SingleController> singleControllerIterator = this.singleControllerVector.iterator();
            while (singleControllerIterator.hasNext()) {
                SingleController singleController = singleControllerIterator.next();
                if (!singleController.getGameObject().isAlive()) {
                    singleControllerIterator.remove();
                } else {
                    singleController.run();
                }
            }
        }

    }
}
