/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * EdgeAddEventFailureTest.java
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.failuretests;

import junit.framework.TestCase;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.SubsystemNodeContainer;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.TestHelper;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.event.EdgeAddEvent;
import com.topcoder.diagraminterchange.GraphNode;

import javax.swing.TransferHandler;
import java.awt.Point;
import java.util.HashMap;

/**
 * <p>
 * This is a failure tests for <code>EdgeAddEvent</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class EdgeAddEventFailureTest extends TestCase {

    /**SubsystemNodeContainer instance that is used for testing.*/
    private SubsystemNodeContainer source;

    /**Point instance that is used for testing.*/
    private Point location;

    /**
     * <p>
     * Set up environment.
     * </p>
     *
     * @throws Exception exception
     */
    public void setUp() throws Exception {
        location = new Point();
        GraphNode graphNode = TestHelper.createGraphNodeForSubsystem();
        source = new SubsystemNodeContainer(graphNode, new HashMap<String, String>(),
                new TransferHandler("property_name"));
    }

    /**
     * <p>
     * Tests constructor EdgeAddEvent(source, location, isStart) if source is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfSourceNull() {
        try {
            new EdgeAddEvent(null, location, true);
            fail("IllegalArgumentException is excpected because source cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor EdgeAddEvent(source, location, isStart) if location is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfLocationNull() {
        try {
            new EdgeAddEvent(source, null, true);
            fail("IllegalArgumentException is excpected because location cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }
}