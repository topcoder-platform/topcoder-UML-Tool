/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges.accuracytests;

import com.topcoder.gui.diagramviewer.uml.classedges.Composition;
import com.topcoder.gui.diagramviewer.uml.classedges.TextField;

import junit.framework.TestCase;

import java.awt.Point;


/**
 * <p>Test the accuracy of Composition class.</p>
 *
 * @author KLW
 * @version 1.0
 */
public class CompositionAccuracyTests extends TestCase {
    /** <code>Composition</code> instance used for testing. */
    private Composition edgeEnding;

    /** <code>TextField</code> instance representing name compartment. */
    private TextField name;

    /** <code>TextField</code> instance representing multiplicity compartment. */
    private TextField multiplicity;

    /**
     * <p>Sets up test environment.</p>
     */
    protected void setUp() {
        name = AccuracyTestHelper.createTextFiled("name");
        multiplicity = AccuracyTestHelper.createTextFiled("1..n");
        edgeEnding = new Composition(name, multiplicity);
        edgeEnding.setAngle(0);
        edgeEnding.setEndingPoint(new Point(20, 20));
    }

    /**
     * <p>Tears down test environment.</p>
     */
    protected void tearDown() {
        name = null;
        multiplicity = null;
        edgeEnding = null;
    }

    /**
     * <p>Accuracy test of constructor . Should create the instance successfully.</p>
     */
    public void testCtor() {
        assertNotNull("Should create the instance successfully.", edgeEnding);
    }
}
