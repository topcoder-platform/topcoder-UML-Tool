/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements;

import java.awt.Dimension;

import javax.swing.JFrame;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.uml.model.usecases.ExtendImpl;

/**
 * <p>
 * Unit test cases for ExtendEdge.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ExtendEdgeTests extends TestCase {

    /**
     * <p>
     * ExtendEdge instance for testing.
     * </p>
     */
    private ExtendEdge extendEdge;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     */
    protected void setUp() {
        GraphEdge edge = TestHelper.createGraphEdgeForEdge(new ExtendImpl());
        try {
            extendEdge = new ExtendEdge(edge);
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
        extendEdge = null;
    }

    /**
     * <p>
     * Tests {@link ExtendEdge#ExtendEdge(GraphEdge)} for accuracy.
     * </p>
     * <p>
     * It verifies the new created ExtendEdge instance is not null.
     * </p>
     */
    public void testCtor() {
        assertNotNull("Failed to create an extend edge.", extendEdge);
    }

    /**
     * <p>
     * Tests {@link ExtendEdge#ExtendEdge(GraphEdge)} for failure.
     * </p>
     * <p>
     * It verifies the new created ExtendEdge instance is not null.
     * </p>
     */
    public void testCtor_BadGraphEdge() {
        assertNotNull("Failed to create an extend edge.", extendEdge);
        try {
            GraphEdge graphEdge = new GraphEdge();
            graphEdge.addWaypoint(TestHelper.createDiagramInterchangePoint(100, 100));
            graphEdge.addWaypoint(TestHelper.createDiagramInterchangePoint(250, 200));
            new ExtendEdge(graphEdge);

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
        extendEdge.notifyGraphEdgeChange();
        assertEquals("no name", extendEdge.getNameCompartment().getText());
    }

    /**
     * <p>
     * Unit Test of the <code>notifyGraphEdgeChange()</code> method.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    public void testNotifyGraphNodeChange_Stereotype() throws Exception {
        extendEdge.notifyGraphEdgeChange();
        assertEquals("<<extend, implicit>>", extendEdge.getStereotypeCompartment().getText());
    }

    /**
     * <p>
     * The entry of the demo program.
     * </p>
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        GraphEdge edge = TestHelper.createGraphEdgeForEdge(new ExtendImpl());
        ExtendEdge extendEdge;
        try {
            extendEdge = new ExtendEdge(edge);

            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(extendEdge);
            frame.setSize(new Dimension(500, 500));
            frame.setVisible(true);
        } catch (IllegalGraphElementException e) {
            fail("no exception will be thrown.");
        }
    }
}
