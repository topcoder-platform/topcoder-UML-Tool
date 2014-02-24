/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * TCS UML_Tool_Actions_-_Diagram_Actions Version 1.0 Accuracytests.
 *
 * @ AdjustDiagramZoomLevelActionAccuracyTests.java
 */
package com.topcoder.uml.actions.diagram.accuracytests;

import com.topcoder.diagraminterchange.Diagram;

import com.topcoder.uml.actions.diagram.AdjustDiagramZoomLevelAction;

import com.topcoder.util.actionmanager.TransientAction;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * The <code>AdjustDiagramZoomLevelAction</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>AdjustDiagramZoomLevelAction</code> class.
 * </p>
 *
 * @author icyriver
 * @version 1.0
 */
public class AdjustDiagramZoomLevelActionAccuracyTests extends TestCase {
    /**
    * <p>
    * Represents an instance of <code>AdjustDiagramZoomLevelAction</code> uses for accuracy tests.
    * </p>
    */
    private AdjustDiagramZoomLevelAction test = null;

    /**
     * <p>
     * Represents an instance of <code>Diagram</code> uses for accuracy tests.
     * </p>
     */
    private Diagram diagram = null;

    /**
     * <p>
     * Represents an array of <code>Double</code> uses for accuracy tests.
     * </p>
     */
    private Double[] newZoomLevels = null;

    /**
     * <p>
     * Test suite of <code>AdjustDiagramZoomLevelActionAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>AdjustDiagramZoomLevelActionAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(AdjustDiagramZoomLevelActionAccuracyTests.class);
    }

    /**
     * <p>
     * Initialization for all tests here.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    protected void setUp() throws Exception {
        // clean the ConfigManager.
        TestHelper.clearConfig();
        TestHelper.loadLogFile();
        diagram = new Diagram();
        newZoomLevels = new Double[] {
            new Double(2.2), new Double(4.6), new Double(3.6)
        };
        test = new AdjustDiagramZoomLevelAction(diagram, new Double(5.7));
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit.
     */
    protected void tearDown() throws Exception {
        // clean the ConfigManager.
        TestHelper.clearConfig();
    }

    /**
     * <p>
     * Accuracy Test of the <code>AdjustDiagramZoomLevelAction(Diagram, Double)</code>
     * constructor and execute() method.
     * </p>
     */
    public void testAdjustDiagramZoomLevelActionCtor_Basic() {
        // check for creating successful.
        assertNotNull("Create failed.", test);
        // adjust the diagram's zoom level.
        test.execute();
        // check new zoom level here.
        assertEquals("Equal zoom level expected.", 5.7, diagram.getZoom());
    }

    /**
     * <p>
     * Accuracy Test of the <code>AdjustDiagramZoomLevelAction(Diagram, Double)</code>
     * constructor and execute() method.
     * It tests this methods with different values.
     * </p>
     */
    public void testAdjustDiagramZoomLevelActionCtor_Times() {
        for (Double level : newZoomLevels) {
            test = new AdjustDiagramZoomLevelAction(diagram, level);
            // check for creating successful.
            assertNotNull("Create failed.", test);
            // adjust the diagram's zoom level.
            test.execute();
            // check new zoom level here.
            assertEquals("Equal zoom level expected.", level.doubleValue(),
                diagram.getZoom());
        }
    }

    /**
     * <p>
     * Accuracy Test of the <code>AdjustDiagramZoomLevelAction</code> calss.
     * It tests class inheritance.
     * </p>
     */
    public void testInheritance() {
        // test class inheritance.
        assertTrue("This class should extend from TransientAction",
            test instanceof TransientAction);
    }
}
