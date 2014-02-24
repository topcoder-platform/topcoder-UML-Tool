/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.diagram.failuretests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * This test case aggregates all Failure test cases.
 * </p>
 *
 * @author TopCoder
 * @version 1.0
 */
public class FailureTests extends TestCase {
    /**
     * <p>
     * This test case aggregates Failure Unit test cases.
     * </p>
     *
     * @return the Failure test suite
     */
    public static Test suite() {
        final TestSuite suite = new TestSuite();
        suite.addTestSuite(Diagram2XMITransformerFailureTests.class);

        suite.addTestSuite(PropertyTransformerFailureTests.class);
        suite.addTestSuite(DiagramElementTransformerFailureTests.class);
        suite.addTestSuite(DiagramLinkTransformerFailureTests.class);
        suite.addTestSuite(GraphConnectorTransformerFailureTests.class);

        suite.addTestSuite(GraphElementTransformerFailureTests.class);
        suite.addTestSuite(ReferenceTransformerFailureTests.class);
        suite.addTestSuite(GraphEdgeTransformerFailureTests.class);
        suite.addTestSuite(GraphNodeTransformerFailureTests.class);

        suite.addTestSuite(SemanticModelBridgeTransformerFailureTests.class);
        suite.addTestSuite(DiagramTransformerFailureTests.class);
        suite.addTestSuite(SimpleSemanticModelElementTransformerFailureTests.class);
        suite.addTestSuite(Uml1SemanticModelBridgeTransformerFailureTests.class);

        suite.addTestSuite(CoreSemanticModelBridgeTransformerFailureTests.class);
        suite.addTestSuite(ImageTransformerFailureTests.class);
        suite.addTestSuite(TextElementTransformerFailureTests.class);
        suite.addTestSuite(LeafElementTransformerFailureTests.class);

        suite.addTestSuite(DiagramTransformerFailureTests.class);
        suite.addTestSuite(PointTransformerFailureTests.class);
        suite.addTestSuite(GraphicPrimitiveTransformerFailureTests.class);
        suite.addTestSuite(BezierPointTransformerFailureTests.class);

        suite.addTestSuite(PolylineTransformerFailureTests.class);
        suite.addTestSuite(EllipseTransformerFailureTests.class);

        return suite;
    }
}
