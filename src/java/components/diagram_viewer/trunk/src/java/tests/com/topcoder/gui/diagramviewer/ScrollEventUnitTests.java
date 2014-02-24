/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer;

import javax.swing.JViewport;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.gui.diagramviewer.event.ScrollEvent;

/**
 * <p>
 * Unit test cases for ScrollEvent.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ScrollEventUnitTests extends TestCase {

    /**
     * <p>
     * Diagram instance for testing.
     * </p>
     */
    private Diagram diagram;

    /**
     * <p>
     * JViewport instance for testing.
     * </p>
     */
    private JViewport source;

    /**
     * ScrollEvent instance for testing.
     */
    private ScrollEvent se;

    /**
     * Sets up the testing environment.
     *
     * @throws Exception when error occurs
     */
    protected void setUp() throws Exception {
        // loads the valid configuration
        this.source = new JViewport();
        this.diagram = new Diagram();
        se = new ScrollEvent(source, diagram);
    }

    /**
     * <p>
     * This is the accuracy test for constructor:ScrollEvent(JViewport source,
     * Diagram diagram). <br>
     * Target: test the creation. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtor() throws Exception {
        assertNotNull("Failed to create ScrollEvent instance.", se);
        // assertEquals("Failed to create ScrollEvent instance.",
        // (JViewport)se.getSource(),this.source);
    }

    /**
     * <p>
     * This is the failure test for constructor: ScrollEvent(JViewport source,
     * Diagram diagram).<br>
     * Failure condition: at least one of the are is null. <br>
     * Expected: IllegalArgumentException. <br>
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testCtorWithNullValue() throws Exception {
        try {
            new ScrollEvent(null, diagram);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }
        try {
            new ScrollEvent(source, null);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }
        try {
            new ScrollEvent(null, null);
            fail("IllegalArgumentException is excepted.");
        } catch (IllegalArgumentException e) {
            // pass.
        }
    }

    /**
     * <p>
     * This is the Accuracy test for Method: getDiagram().
     * </p>
     *
     * @throws Exception when error occurs
     */
    public void testGetDiagramAccuracy() throws Exception {
        assertEquals("Failed to call Method: getDiagram().", this.diagram, se.getDiagram());

    }

}
