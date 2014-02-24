/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.failuretests;

import java.awt.Toolkit;
import java.awt.datatransfer.DataFlavor;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.uml.actions.diagram.elements.CopiedElement;
import com.topcoder.uml.actions.diagram.elements.CopyDiagramElementAction;

import junit.framework.TestCase;

/**
 * Failure tests for CopyDiagramElementAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class CopyDiagramElementActionTests extends TestCase {

	/**
	 * Test method for
	 * {@link CopyDiagramElementAction#CopyDiagramElementAction(DiagramElement, Clipboard)}.
	 */
	public void testCopyDiagramElementAction_NullDiagramElement1() {
		try {
			new CopyDiagramElementAction(null, Toolkit.getDefaultToolkit()
					.getSystemClipboard());
			fail("IllegalArgumentException is expected.");
		} catch (IllegalArgumentException e) {
			// expected.
		}
	}

	/**
	 * Test method for
	 * {@link CopyDiagramElementAction#CopyDiagramElementAction(DiagramElement)}.
	 */
	public void testCopyDiagramElementAction_NullDiagramElement2() {
		try {
			new CopyDiagramElementAction(null);
			fail("IllegalArgumentException is expected.");
		} catch (IllegalArgumentException e) {
			// expected.
		}
	}

	/**
	 * Test method for
	 * {@link CopyDiagramElementAction#lostOwnership(Clipboard, Transferable)}.
	 */
	public void testLostOwnership_NullContents() {
		CopyDiagramElementAction action = new CopyDiagramElementAction(
				new GraphEdge(), Toolkit.getDefaultToolkit()
						.getSystemClipboard());

		try {
			action.lostOwnership(Toolkit.getDefaultToolkit()
					.getSystemClipboard(), null);
			fail("IllegalArgumentException is expected.");
		} catch (IllegalArgumentException e) {
			// expected.
		}
	}

	/**
	 * Test method for
	 * {@link CopyDiagramElementAction#lostOwnership(Clipboard, Transferable)}.
	 */
	public void testLostOwnership_NullClipborad() {
		CopyDiagramElementAction action = new CopyDiagramElementAction(
				new GraphEdge(), Toolkit.getDefaultToolkit()
						.getSystemClipboard());

		DataFlavor[] dataFlavors = new DataFlavor[] { new DataFlavor(
				GraphEdge.class, GraphEdge.class.getName()) };

		try {
			action.lostOwnership(null, new CopiedElement(new GraphEdge(),
					dataFlavors));
			fail("IllegalArgumentException is expected.");
		} catch (IllegalArgumentException e) {
			// expected.
		}
	}
}
