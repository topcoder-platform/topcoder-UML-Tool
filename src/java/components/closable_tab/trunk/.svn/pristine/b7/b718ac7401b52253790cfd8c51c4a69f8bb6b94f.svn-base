/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.closabletabbedpane.accuracytests;

import java.awt.TextArea;

import junit.framework.TestCase;

import com.topcoder.gui.closabletabbedpane.ClosableTabbedPane;
import com.topcoder.gui.closabletabbedpane.ClosableTabbedPaneEvent;

/**
 * This is a accuracy test for class ClosableTabbedPaneEvent.
 *
 * @author knuthocean
 * @version 1.0
 */
public class ClosableTabbedPaneEventAccuracyTests extends TestCase {

    /** The ClosableTabbedPane instance for acc testing. */
    private ClosableTabbedPane pane = new ClosableTabbedPane();

    /** The tab index for acc testing, it is initialized to 0. */
    private static final int TAB_INDEX = 0;

    /**
     * Accuracy test for the ctor: ClosableTabbedPaneEvent, THIS acc test not only do the test of ctor,
     * also it will test the two getXXX() methods.
     */
    public void testAccuracyClosableTabbedPaneEvent() {
        pane.add("acc test", new TextArea());
        ClosableTabbedPaneEvent event = new ClosableTabbedPaneEvent(TAB_INDEX, pane);
        assertNotNull("fail to create ClosableTabbedPaneEvent instance.", event);
        assertEquals("fail to create ClosableTabbedPaneEvent instance.", event.getSource(), pane);
        assertEquals("fail to create ClosableTabbedPaneEvent instance.", event.getTabIndex(), TAB_INDEX);

    }

}
