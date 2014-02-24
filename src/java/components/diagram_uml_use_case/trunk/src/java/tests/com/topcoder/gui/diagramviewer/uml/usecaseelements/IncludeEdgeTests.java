/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements;

import java.awt.Dimension;

import javax.swing.JFrame;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.uml.model.usecases.IncludeImpl;

/**
 * <p>
 * Unit test cases for IncludeEdge.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class IncludeEdgeTests extends TestCase {

    /**
     * <p>
     * IncludeEdge instance for testing.
     * </p>
     */
    private IncludeEdge includeEdge;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     */
    protected void setUp() {
        GraphEdge edge = TestHelper.createGraphEdgeForEdge(new IncludeImpl());
        try {
            includeEdge = new IncludeEdge(edge);
        } catch (IllegalGraphElementException e) {
            fail("no exception will be thrown");
        }
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     */
    protected void tearDown() {
        includeEdge = null;
    }

    /**
     * <p>
     * Tests {@link IncludeEdge#IncludeEdge(GraphEdge)} for accuracy.
     * </p>
     * <p>
     * It verifies the new created IncludeEdge instance is not null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create an include edge.", includeEdge);
    }

    /**
     * <p>
     * Tests {@link IncludeEdge#IncludeEdge(GraphEdge)} for failure.
     * </p>
     * <p>
     * It verifies the new created IncludeEdge instance is not null.
     * </p>
     */
    public void testCtor_BadGraphEdge() {
        assertNotNull("Failed to create an include edge.", includeEdge);
        try {
            GraphEdge graphEdge = new GraphEdge();
            graphEdge.addWaypoint(TestHelper.createDiagramInterchangePoint(100, 100));
            graphEdge.addWaypoint(TestHelper.createDiagramInterchangePoint(250, 200));
            new IncludeEdge(graphEdge);

            fail("IllegalGraphElementException expected");
        } catch (IllegalGraphElementException e) {
            // the expected case
        }
    }

    /**
     * <p>
     * Unit Test of the <code>notifyGraphEdgeChange()</code> method.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNotifyGraphNodeChange_Name() throws Exception {
        includeEdge.notifyGraphEdgeChange();
        assertEquals("no name", includeEdge.getNameCompartment().getText());
    }

    /**
     * <p>
     * Unit Test of the <code>notifyGraphEdgeChange()</code> method.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNotifyGraphNodeChange_Stereotype() throws Exception {
        includeEdge.notifyGraphEdgeChange();
        assertEquals("<<include, implicit>>", includeEdge.getStereotypeCompartment().getText());
    }

    /**
     * <p>
     * The entry of the demo program.
     * </p>
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        GraphEdge edge = TestHelper.createGraphEdgeForEdge(new IncludeImpl());
        IncludeEdge includeEdge;
        try {
            includeEdge = new IncludeEdge(edge);

            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(includeEdge);
            frame.setSize(new Dimension(500, 500));
            frame.setVisible(true);
        } catch (IllegalGraphElementException e) {
            fail("no exception will be thrown.");
        }
    }
}
