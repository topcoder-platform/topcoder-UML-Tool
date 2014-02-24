/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.failuretests;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

import com.topcoder.uml.actions.diagram.elements.DiagramElementDataFlavorManager;

import junit.framework.TestCase;

/**
 * Failure tests for DiagramElementDataFlavorManager.
 * 
 * @author superZZ
 * @version 1.0
 */
public class DiagramElementDataFlavorManagerTest extends TestCase {
	/**
	 * DiagramElementDataFlavorManager instance for test.
	 */
	private final DiagramElementDataFlavorManager manager = new DiagramElementDataFlavorManager();

	/**
	 * Test method for
	 * {@link DiagramElementDataFlavorManager#isSuitableForDiagramElement(DataFlavor)}.
	 */
	public void testIsSuitableForDiagramElementDataFlavor_NullFlavor() {
		try {
			manager.isSuitableForDiagramElement((DataFlavor) null);
			fail("IAE is expected");
		} catch (IllegalArgumentException e) {
			// pass
		}
	}

	/**
	 * Test method for
	 * {@link DiagramElementDataFlavorManager#isSuitableForDiagramElement(Transferable)}.
	 */
	public void testIsSuitableForDiagramElementTransferable_NullTransferable() {
		try {
			manager.isSuitableForDiagramElement((Transferable) null);
			fail("IAE is expected");
		} catch (IllegalArgumentException e) {
			// pass
		}
	}

	/**
	 * Test method for
	 * {@link DiagramElementDataFlavorManager#getDataFlavor(DiagramElement)}.
	 */
	public void testGetDataFlavor() {
		try {
			manager.getDataFlavor(null);
			fail("IAE is expected");
		} catch (IllegalArgumentException e) {
			// pass
		}
	}

	/**
	 * Test method for
	 * {@link DiagramElementDataFlavorManager#addDataFlavor(DataFlavor)}.
	 */
	public void testAddDataFlavor() {
		try {
			manager.addDataFlavor(null);
			fail("IAE is expected");
		} catch (IllegalArgumentException e) {
			// pass
		}
	}

}
