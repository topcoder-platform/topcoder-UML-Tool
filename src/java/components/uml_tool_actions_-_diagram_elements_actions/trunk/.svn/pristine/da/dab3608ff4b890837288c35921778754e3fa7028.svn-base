/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.failuretests;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.uml.actions.diagram.elements.CutDiagramElementAction;

import junit.framework.TestCase;

/**
 * Failure tests for CutDiagramElementAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class CutDiagramElementActionTest extends TestCase {
	/**
	 * Test method for
	 * {@link CutDiagramElementAction#CutDiagramElementAction(DiagramElement, Diagram, Clipboard)}.
	 */
	public void testCutDiagramElementAction_NullDiagramElement() {
		try {
			new CutDiagramElementAction(null, new Diagram(), null);
			fail("IllegalArgumentException is expected.");
		} catch (IllegalArgumentException e) {
			// expected.
		}
	}

	/**
	 * Test method for
	 * {@link CutDiagramElementAction#CutDiagramElementAction(DiagramElement, Diagram, Clipboard)}.
	 */
	public void testCutDiagramElementAction_NullDiagram() {
		try {
			new CutDiagramElementAction(new GraphEdge(), null, null);
			fail("IllegalArgumentException is expected.");
		} catch (IllegalArgumentException e) {
			// expected.
		}
	}
}
