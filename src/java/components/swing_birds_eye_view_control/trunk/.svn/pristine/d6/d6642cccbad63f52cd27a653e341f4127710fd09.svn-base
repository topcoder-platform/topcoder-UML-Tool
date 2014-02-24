/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.birdseyeview;

import com.topcoder.swing.birdseyeview.event.ViewPortEvent;
import com.topcoder.swing.birdseyeview.event.ViewPortListener;
/**
 * <p>
 * Mock ViewPortListener used for the unit test.
 * </p>
 *
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockViewPortListener implements ViewPortListener {

    /**
     * <p>
     * ViewPortEvent instance, used for test.
     * </p>
     */
    private ViewPortEvent event = null;

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
        this.event = event;
    }

    /**
     * <p>
     * Getter of event attribute.
     * </p>
     *
     * @return
     *          the instance of event.
     */
    public ViewPortEvent getViewPortEvent() {
        return this.event;
    }

}
