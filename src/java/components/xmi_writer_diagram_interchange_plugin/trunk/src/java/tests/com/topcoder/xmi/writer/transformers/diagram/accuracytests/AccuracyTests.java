/**
 *
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.xmi.writer.transformers.diagram.accuracytests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This test case aggregates all Accuracy test cases.
 * </p>
 *
 * @author TopCoder
 * @version 1.0
 */
public class AccuracyTests extends TestCase {

	/**
     * Aggregates all the Accuracy test cases.
     *
     * @return Test
     */
	public static Test suite() {
		final TestSuite suite = new TestSuite();
		suite.addTestSuite(TestBezierPointTransformerAccuracy.class);
		suite.addTestSuite(TestCoreSemanticModelBridgeTransformerAccuracy.class);
		suite.addTestSuite(TestDiagramElementTransformerAccuracy.class);
		suite.addTestSuite(TestDiagramLinkTransformerAccuracy.class);
		suite.addTestSuite(TestDiagramTransformerAccuracy.class);
		suite.addTestSuite(TestDimensionTransformerAccuracy.class);
		suite.addTestSuite(TestEllipseTransformerAccuracy.class);
		suite.addTestSuite(TestGraphConnectorTransformerAccuracy.class);
		suite.addTestSuite(TestGraphEdgeTransformerAccuracy.class);
		suite.addTestSuite(TestGraphElementTransformerAccuracy.class);
		suite.addTestSuite(TestGraphicPrimitiveTransformerAccuracy.class);
		suite.addTestSuite(TestGraphNodeTransformerAccuracy.class);
		suite.addTestSuite(TestImageTransformerAccuracy.class);
		suite.addTestSuite(TestLeafElementTransformerAccuracy.class);
		suite.addTestSuite(TestPointTransformerAccuracy.class);
		suite.addTestSuite(TestPolylineTransformerAccuracy.class);
		suite.addTestSuite(TestPropertyTransformerAccuracy.class);
		suite.addTestSuite(TestReferenceTransformerAccuracy.class);
		suite.addTestSuite(TestSemanticModelBridgeTransformerAccuracy.class);
		suite.addTestSuite(TestSimpleSemanticModelElementTransformerAccuracy.class);
		suite.addTestSuite(TestTextElementTransformerAccuracy.class);
		suite.addTestSuite(TestUml1SemanticModelBridgeTransformerAccuracy.class);

		suite.addTestSuite(TestDiagram2XMITransformerAccuracy.class);
		return suite;
	}
}
