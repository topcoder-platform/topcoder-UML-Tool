/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges.failuretests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.gui.diagramviewer.uml.classedges.event.PopupMenuTrigger;


/**
 * Failure test case of <code>PopupMenuTrigger</code> class.
 * This class tests <code>PopupMenuTrigger</code> for proper behavior. It covers
 * PopupMenuTrigger(), mouseClicked(MouseEvent).
 *
 * @author still
 * @version 1.0
 */
public class PopupMenuTriggerFailureTest extends TestCase {

    /**
     * Test suite of PopupMenuTrigger.
     *
     * @return Test suite of PopupMenuTrigger.
     */
    public static Test suite() {
        return new TestSuite(PopupMenuTriggerFailureTest.class);
    }

    /**
     * <p>
     * Test of mouseClicked(MouseEvent) for ignoring null event.
     * </p>
     *
     * No exception should be thrown when encountering null event.
     */
    public void testMouseClickedForIngoreNullMouseEvent() {
        new PopupMenuTrigger().mouseClicked(null);
    }

}
