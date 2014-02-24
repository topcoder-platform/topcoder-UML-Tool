/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>This test case aggregates all Unit test cases.</p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class UnitTests extends TestCase {

    /**
     * Returns a test suite containing all the unit tests.
     *
     * @return a test suite containing all the unit tests
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();

        suite.addTestSuite(BezierPointTest.class);
        suite.addTestSuite(CoreSemanticModelBridgeTest.class);
        suite.addTestSuite(DiagramTest.class);
        suite.addTestSuite(DiagramElementTest.class);
        suite.addTestSuite(DiagramLinkTest.class);
        suite.addTestSuite(DimensionTest.class);
        suite.addTestSuite(EllipseTest.class);
        suite.addTestSuite(GraphConnectorTest.class);
        suite.addTestSuite(GraphEdgeTest.class);
        suite.addTestSuite(GraphElementTest.class);
        suite.addTestSuite(GraphicPrimitiveTest.class);
        suite.addTestSuite(GraphNodeTest.class);
        suite.addTestSuite(ImageTest.class);
        suite.addTestSuite(LeafElementTest.class);
        suite.addTestSuite(PointTest.class);
        suite.addTestSuite(PolylineTest.class);
        suite.addTestSuite(PropertyTest.class);
        suite.addTestSuite(ReferenceTest.class);
        suite.addTestSuite(SemanticModelBridgeTest.class);
        suite.addTestSuite(SimpleSemanticModelElementTest.class);
        suite.addTestSuite(TextElementTest.class);
        suite.addTestSuite(Uml1SemanticModelBridgeTest.class);

        suite.addTestSuite(DemoTest.class);

        return suite;
    }
}