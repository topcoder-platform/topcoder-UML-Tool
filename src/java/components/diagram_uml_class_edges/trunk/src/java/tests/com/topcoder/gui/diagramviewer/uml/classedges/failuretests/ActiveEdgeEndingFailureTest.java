/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges.failuretests;

import java.awt.Graphics;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.classedges.ActiveEdgeEnding;
import com.topcoder.gui.diagramviewer.uml.classedges.TextField;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Failure test case of <code>ActiveEdgeEnding</code> class.
 *
 *
 * @author still
 * @version 1.0
 */
public class ActiveEdgeEndingFailureTest extends TestCase {
    /** ActiveEdgeEnding instance used in this failure test. */
    private ActiveEdgeEnding ending;
    /**
     * Test suite of ActiveEdgeEnding.
     *
     * @return Test suite of ActiveEdgeEnding.
     */
    public static Test suite() {
        return new TestSuite(ActiveEdgeEndingFailureTest.class);
    }

    /**
     * Initialization for all tests here.
     */
    protected void setUp() {
        // set up for test
        TextField textField1 = new TextField(new GraphNode());
        TextField textField2 = new TextField(new GraphNode());
        ending = new MockActiveEdgeEnding(textField1, textField2);
    }


    /**
     * <p>
     * Test of ActiveEdgeEnding(TextField, TextField) for IllegalArgumentException.
     * </p>
     * IllegalArgumentException must be thrown when encountering null name textField.
     */
    public void testActiveEdgeEndingForException1() {
        try {
            new MockActiveEdgeEnding(null, new TextField(new GraphNode()));
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }
    /**
     * <p>
     * Test of ActiveEdgeEnding(TextField, TextField) for IllegalArgumentException.
     * </p>
     * IllegalArgumentException must be thrown when encountering null multiplicity textField.
     */
    public void testActiveEdgeEndingForException2() {
        try {
            new MockActiveEdgeEnding(new TextField(new GraphNode()), null);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * <p>
     * Test of setHideNameText(String) for IllegalArgumentException.
     * </p>
     * IllegalArgumentException must be thrown when encountering null hideNameText.
     */
    public void testSetHideNameTextForException() {
        try {
            ending.setHideNameText(null);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }

    /**
     * <p>
     * Test of setHideMultiplicityText(String) for IllegalArgumentException.
     * </p>
     * IllegalArgumentException must be thrown when encountering null hideMultiplicityText.
     */
    public void testSetHideMultiplicityTextForException() {
        try {
            ending.setHideMultiplicityText(null);
            // should not be here
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException e) {
            // should be here
        }
    }
    /**
     * Mock ActiveEdgeEnding class implements an empty paintComponent.
     *
     * @author still
     * @version 1.0
     */
    private final class MockActiveEdgeEnding extends ActiveEdgeEnding {
        /**
         * Constructor of MockActiveEdgeEnding, with name and multiplicity for base class.
         *
         * @param name the name compartment
         * @param multiplicity the multiplicity compartment
         */
        protected MockActiveEdgeEnding(TextField name, TextField multiplicity) {
            super(name, multiplicity);
        }

        /**
         * Mock empty paintComponent(it is not used in this test).
         *
         * @param g never used
         */
        protected void paintComponent(Graphics g) {
        }

    }
}
