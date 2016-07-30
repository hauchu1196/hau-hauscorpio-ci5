package controllers;

import java.awt.*;
import java.util.Iterator;
import java.util.Vector;

/**
 * Created by Hau on 31/07/2016.
 */
public class ControllerManager implements BaseController {
    private Vector<SingleController> singleControllerVector;

    public ControllerManager() {
        singleControllerVector = new Vector<SingleController>();
    }

    @Override
    public void draw(Graphics g) {
        for (BaseController baseController : singleControllerVector) {
            baseController.draw(g);
        }

    }

    public void add(SingleController singleController) {
        this.singleControllerVector.add(singleController);
    }
    @Override
    public void run() {
        Iterator<SingleController> singleControllerIterator = this.singleControllerVector.iterator();
        while (singleControllerIterator.hasNext()) {
            SingleController singleController = singleControllerIterator.next();
            if(!singleController.gameObject.isAlive()) {
                singleControllerIterator.remove();
            } else {
                singleController.run();
            }
        }

    }
}
