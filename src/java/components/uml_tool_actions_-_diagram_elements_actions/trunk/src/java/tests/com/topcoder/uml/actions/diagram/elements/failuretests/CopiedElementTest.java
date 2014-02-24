/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.failuretests;

import java.awt.datatransfer.DataFlavor;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.uml.actions.diagram.elements.CopiedElement;

import junit.framework.TestCase;

/**
 * Failure tests for CopiedElement.
 * 
 * @author superZZ
 * @version 1.0
 */
public class CopiedElementTest extends TestCase {
	/**
	 * Test method for
	 * {@link CopiedElement#CopiedElement(DiagramElement, DataFlavor[])}.
	 */
	public void testCopiedElement_NullDiagramElement() {
		try {
			new CopiedElement(null, new DataFlavor[] { new DataFlavor(
					GraphEdge.class, GraphEdge.class.getName()) });
			fail("IllegalArgumentException is expected.");
		} catch (IllegalArgumentException e) {
			// expected.
		}
	}

	/**
	 * Test method for
	 * {@link CopiedElement#CopiedElement(DiagramElement, DataFlavor[])}.
	 */
	public void testCopiedElement_NullDataFlavors() {
		try {
			new CopiedElement(new GraphEdge(), null);
			fail("IllegalArgumentException is expected.");
		} catch (IllegalArgumentException e) {
			// expected.
		}
	}

	/**
	 * Test method for
	 * {@link CopiedElement#CopiedElement(DiagramElement, DataFlavor[])}.
	 */
	public void testCopiedElement_DataFlavorsWithNullElement() {
		try {
			new CopiedElement(new GraphEdge(), new DataFlavor[] {
					new DataFlavor(GraphEdge.class, GraphEdge.class.getName()),
					null });
			fail("IllegalArgumentException is expected.");
		} catch (IllegalArgumentException e) {
			// expected.
		}
	}

	/**
	 * Test method for
	 * {@link CopiedElement#CopiedElement(DiagramElement, DataFlavor[])}.
	 */
	public void testCopiedElement_EmptyDataFlavors() {
		try {
			new CopiedElement(new GraphEdge(), new DataFlavor[] {});
			fail("IllegalArgumentException is expected.");
		} catch (IllegalArgumentException e) {
			// expected.
		}
	}
}
