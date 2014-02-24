/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.birdseyeview;

import java.awt.Point;

import javax.swing.JScrollPane;

import com.topcoder.swing.birdseyeview.event.ViewPortEvent;
import com.topcoder.swing.birdseyeview.event.ViewPortListener;

/**
 * <p>
 * ViewPortListener used in the demo.
 * It is used to control the view port of the JScrollPane.
 * It move the view port of the JScrollPane the viewPortMoved method is
 * invoked and the position is of the view port is determined by the event.
 * </p>
 *
 * @author MiG-29, TCSDEVELOPER
 * @version 1.0
 */
class ChangeViewPortListener implements ViewPortListener {
    /**
     * <p>
     * The JScrollPane whose view port will be moved if the viewPortMoved is invoked.
     * </p>
     */
    private JScrollPane sp;

    /**
     * <p>
     * Constructor of ChangeViewPortListener.
     * </p>
     *
     * @param sp
     *          the JScrollPane whose view port will be moved if the
     *          viewPortMoved is invoked
     */
    public ChangeViewPortListener(JScrollPane sp) {
        this.sp = sp;
    }

    /**
     * <p>
     * The method to be invoked, then the view port has been moved. The new
     * position of the input object view port will be provided to the consumer
     * of this method in the external code.
     * </p>
     *
     * @param event
     *            an instance of the ViewPortEvent class with the data about the
     *            view port moving. It can not be null.
     */
    public void viewPortMoved(ViewPortEvent event) {
        Point p = new Point(event.getInputObjectViewX(), event.getInputObjectViewY());
        sp.getViewport().setViewPosition(p);
    }
}