/*
 * Copyright (C) 2005 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.print;

import java.awt.Component;


/**
 * Mock implement of {@link ComponentVisibleMaker} for test purpose.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockComponentVisibleMaker implements ComponentVisibleMaker {
    /**
     * Does nothing.
     */
    public void clear() {
    }

    /**
     * Does nothing.
     *
     * @param component component
     */
    public void makeInvisible(Component component) {
    }

    /**
     * Does nothing.
     *
     * @param component component
     */
    public void makeVisible(Component component) {
    }
}
