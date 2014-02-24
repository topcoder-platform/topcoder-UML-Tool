/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.imageexporter;

import javax.swing.JComponent;


/**
 * Mock implementation for JComponentVisibleMaker used in test.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockVisibleMaker implements JComponentVisibleMaker {
    /**
     * irnores this.
     *
     * @param component irnores this.
     *
     * @throws JComponentVisibleMakerException irnores this.
     */
    public void makeVisible(JComponent component) throws JComponentVisibleMakerException {
    }

    /**
     * irnores this.
     *
     * @param component irnores this.
     *
     * @throws JComponentVisibleMakerException irnores this.
     */
    public void restoreVisibility(JComponent component)
        throws JComponentVisibleMakerException {
    }
}
