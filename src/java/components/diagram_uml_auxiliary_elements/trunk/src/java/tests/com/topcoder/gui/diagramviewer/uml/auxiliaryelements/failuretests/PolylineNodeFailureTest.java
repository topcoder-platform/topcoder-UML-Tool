/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements.failuretests;

import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.*;

import junit.framework.TestCase;

/**
 * <p>
 * Failure test for <code>PolylineNode</code>.
 * </p>
 *
 * @author Hacker_QC
 * @version 1.0
 */
public class PolylineNodeFailureTest extends TestCase {

    /**
     * <p>
     * Static final String for valid namespace.
     * </p>
     */
    private static final String VALID_NAMESPACE =
        "com.topcoder.gui.diagramviewer.uml.auxiliaryelements".intern();

    /**
     * <p>
     * The Polyline instance for helping testing.
     * </p>
     */
    private Polyline polyline;

    /**
     * <p>
     * The PropertyMapping instance for helping testing.
     * </p>
     */
    private PropertyMapping mapping;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        TestHelper.loadXMLConfig(TestHelper.CONFIG_FILE);
        mapping = new PropertyMapping(VALID_NAMESPACE);
        polyline = new Polyline();
        polyline.addWaypoint(TestHelper.createDiagramInterchangePoint(100, 100));
        polyline.addWaypoint(TestHelper.createDiagramInterchangePoint(200, 200));
        polyline.addWaypoint(TestHelper.createDiagramInterchangePoint(300, 400));
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        TestHelper.clearConfig();
        mapping = null;
        polyline = null;
    }

    /**
     * <p>
     * Tests constructor PolylineNode(Polyline polyline, PropertyMapping properties) for failure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testPolylineNodeCtor1() throws Exception {
        try {
            new PolylineNode(null, mapping);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // everything is good
        }
    }

    /**
     * <p>
     * Tests constructor PolylineNode(Polyline polyline, PropertyMapping properties) for failure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testPolylineNodeCtor2() throws Exception {
        try {
            new PolylineNode(polyline, null);
            fail("IllegalArgumentException expected.");
        } catch (IllegalArgumentException iae) {
            // everything is good
        }
    }
}
