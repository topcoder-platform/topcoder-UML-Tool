package com.topcoder.gui.diagramviewer.uml.classedges.accuracytests;

import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JFrame;

import com.topcoder.gui.diagramviewer.uml.classedges.AggregationBiDirectional;
import com.topcoder.gui.diagramviewer.uml.classedges.TextField;
import com.topcoder.gui.diagramviewer.uml.classedges.UnitTestsHelper;

import junit.framework.TestCase;
/**
 * <p>Test the accuracy of AggregationBiDirectional class.</p>
 *
 * @author KLW
 * @version 1.0
 */
public class AggregationBiDirectionalAccuracyTests extends TestCase {

    /** <code>AggregationBiDirectional</code> instance used for testing. */
    private AggregationBiDirectional edgeEnding;

    /** <code>TextField</code> instance representing name compartment. */
    private TextField name;

    /** <code>TextField</code> instance representing multiplicity compartment. */
    private TextField multiplicity;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     */
    protected void setUp() {
        name = AccuracyTestHelper.createTextFiled("name");
        multiplicity = AccuracyTestHelper.createTextFiled("1..n");
        edgeEnding = new AggregationBiDirectional(name, multiplicity);
        edgeEnding.setAngle(0);
        edgeEnding.setEndingPoint(new Point(20, 20));
    }
    /**
     * <p>
     * Accuracy test of constructor .
     * Should create the instance successfully.
     * </p>
     */
    public void testCtor() {
        assertNotNull("It should not be null.", edgeEnding);
    }
}
