/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.accuracytests.event;

import javax.swing.JViewport;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.gui.diagramviewer.event.ScrollEvent;

import junit.framework.TestCase;

/**
 * <p>
 * Accuracy test case for <c>ScrollEvent</c>.
 * </p>
 *
 * @author tianniu
 * @version 1.0
 */
public class ScrollEventAccuracyTests extends TestCase {

    /**
     * Represent the instance of <c>ScrollEvent</c> used for test.
     */
    private ScrollEvent event;

    /**
     * Represent the instance of <c>Diagram</c> used for test.
     */
    private Diagram diagram;

    /**
     * <p>
     * Set up test environment.
     * </p>
     *
     * @throws Exception
     *         if any error occurs when set up
     */
    protected void setUp() throws Exception {
        this.diagram = new Diagram();
        event = new ScrollEvent(new JViewport(), diagram);
    }

    /**
     * <p>
     * Accuracy test for the constructor <code>ScrollEvent</code>. The instance of <code>ScrollEvent</code> should be
     * created successfully.
     * </p>
     */
    public void testConstructorAccuracy() {
        assertNotNull("instance of ScrollEvent should be created", new ScrollEvent(new JViewport(), diagram));
    }

    /**
     * <p>
     * Accuracy test for the method <code>GetDiagram</code> The diagram should be returned.
     * </p>
     */
    public void testGetDiagramAccuracy() {
        try {
            assertEquals("the diagram should be returned", diagram, event.getDiagram());
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}
