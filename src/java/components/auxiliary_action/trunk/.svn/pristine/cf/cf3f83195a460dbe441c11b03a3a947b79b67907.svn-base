/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.auxiliary.diagram;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.uml.actions.auxiliary.AuxiliaryElementDataFlavor;
import com.topcoder.uml.actions.auxiliary.UnitTestHelper;

/**
 * <p>
 * Unit tests on class <code>CopyPolylineAction</code>.
 * </p>
 * @version 1.0
 * @author TCSDEVELOPER
 */
public class CopyPolylineActionTest extends TestCase {
    /**
     * <p>
     * Instance of <code>CopyPolylineAction</code> used in this test.
     * </p>
     */
    private CopyPolylineAction action;

    /**
     * <p>
     * Polyline graph edge.
     * </p>
     */
    private GraphEdge polylineGraphEdge;

    /**
     * <p>
     * Clipboard.
     * </p>
     */
    private Clipboard clipboard;
    /**
     * <p>
     * Set up environment.
     * </p>
     * @throws Exception to JUnit
     */
    public void setUp() throws Exception {
        UnitTestHelper.loadConfig(UnitTestHelper.CONFIG_FILE);
        this.polylineGraphEdge = new GraphEdge();
        this.polylineGraphEdge.addContained(new Polyline());
        this.clipboard = new Clipboard("CopyPolylineActionTest");
        this.action = new CopyPolylineAction(this.polylineGraphEdge,
                this.clipboard);
    }
    /**
     * <p>
     * Clear the environment.
     * </p>
     */
    public void tearDown() {
        UnitTestHelper.clearConfig();
    }

    /**
     * <p>
     * Test method <code>CopyPolylineAction(GraphEdge polylineGraphEdge, Clipboard clipboard)</code>
     * for failure with null polylineGraphEdge, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_NullPolylineGraphEdge() {
        try {
            new CopyPolylineAction(null, Toolkit.getDefaultToolkit().getSystemClipboard());
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }
    /**
     * <p>
     * Test method <code>CopyPolylineAction(GraphEdge polylineGraphEdge, Clipboard clipboard)</code>
     * for failure with polylineGraphEdge has no Polyline, <code>IllegalArgumentException</code> is expected.
     * </p>
     */
    public void testCtor_IllegalPolylineGraphEdge() {
        try {
            new CopyPolylineAction(new GraphEdge(), Toolkit.getDefaultToolkit().getSystemClipboard());
            fail("IllegalArgumentException is expected!");
        } catch (IllegalArgumentException e) {
            // expected
        }
    }

    /**
     * <p>
     * Test method <code>CopyPolylineAction(GraphEdge polylineGraphEdge, Clipboard clipboard)</code>
     * for accuracy.
     * </p>
     */
    public void testCtor_Accuracy1() {
        assertNotNull("Failed to create the action!",
                new CopyPolylineAction(this.polylineGraphEdge, null));
    }
    /**
     * <p>
     * Test method <code>CopyPolylineAction(GraphEdge polylineGraphEdge, Clipboard clipboard)</code>
     * for accuracy.
     * </p>
     */
    public void testCtor_Accuracy2() {
        assertNotNull("Failed to create the action!",
                new CopyPolylineAction(this.polylineGraphEdge, Toolkit.getDefaultToolkit().getSystemClipboard()));
    }

    /**
     * <p>
     * Test method <code>execute()</code> for accuracy.
     * </p>
     * @throws Exception to JUnit
     */
    public void testExecute() throws Exception {
        // execute the action
        this.action.execute();
        Object obj = clipboard.getData(AuxiliaryElementDataFlavor.POLYLINE);
        assertNotNull("Failed to execute the action!", obj);
        assertTrue("Failed to execute the action!", obj instanceof GraphEdge);
        UnitTestHelper.assertEquals(this.polylineGraphEdge, (GraphEdge) obj, "Failed to copy!");
    }
}
