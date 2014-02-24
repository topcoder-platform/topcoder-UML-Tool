/**
 *
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.diagram.elements.failuretests;

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

	public static Test suite() {
		final TestSuite suite = new TestSuite();

		suite.addTestSuite(CopiedElementTest.class);
		suite.addTestSuite(CopyDiagramElementActionTests.class);
		suite.addTestSuite(CutDiagramElementActionTest.class);
		suite.addTestSuite(DiagramElementDataFlavorManagerTest.class);
		suite.addTestSuite(PasteDiagramElementActionTest.class);
		suite.addTestSuite(RemoveDiagramElementActionTest.class);

		return suite;
	}

}
