package controllers;

import java.awt.*;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by Hau on 19/08/2016.
 */
public class ControllerManager implements BaseController {
    private Vector<SingleController> singleControllerVector;

    public ControllerManager() {
        this.singleControllerVector = new Vector<>();
    }

    public void add(SingleController singleController) {
        singleControllerVector.add(singleController);
    }

    @Override
    public void draw(Graphics g) {
        synchronized (this.singleControllerVector) {
            Iterator<SingleController> singleControllerIterator = singleControllerVector.iterator();
            while (singleControllerIterator.hasNext()) {
                SingleController singleController = singleControllerIterator.next();
                if (singleController.gameObject.isAlive()) {
                    singleController.draw(g);
                }
            }
        }
    }

    @Override
    public void run() {
        synchronized (this.singleControllerVector) {
            Iterator<SingleController> singleControllerIterator = singleControllerVector.iterator();
            while (singleControllerIterator.hasNext()) {
                SingleController singleController = singleControllerIterator.next();
                if (!singleController.gameObject.isAlive()) {
                    singleControllerIterator.remove();
                } else {
                    singleController.run();
                }
            }
        }
    }
}
