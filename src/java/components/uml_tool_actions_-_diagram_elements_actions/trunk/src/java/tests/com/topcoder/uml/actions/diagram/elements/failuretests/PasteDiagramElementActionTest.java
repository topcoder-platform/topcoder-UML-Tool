/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.failuretests;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.uml.actions.diagram.elements.CopiedElement;
import com.topcoder.uml.actions.diagram.elements.PasteDiagramElementAction;

import junit.framework.TestCase;

/**
 * Failure tests for PasteDiagramElementAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class PasteDiagramElementActionTest extends TestCase {
	/**
	 * PasteDiagramElementAction instance for test.
	 */
	private final PasteDiagramElementAction action = new PasteDiagramElementAction(
			new CopiedElement(new GraphEdge(),
					new DataFlavor[] { new DataFlavor(GraphEdge.class,
							GraphEdge.class.getName()) }), new Diagram());

	/**
	 * Test method for
	 * {@link PasteDiagramElementAction#PasteDiagramElementAction(Transferable, Diagram)}.
	 * 
	 * Passing null ClipboardContent.
	 */
	public void testPasteDiagramElementAction_NullClipboardContent() {
		try {
			new PasteDiagramElementAction(new CopiedElement(new GraphEdge(),
					new DataFlavor[] { new DataFlavor(GraphEdge.class,
							GraphEdge.class.getName()) }), null);
			fail("IAE is expected");
		} catch (IllegalArgumentException e) {
			// pass
		}
	}

	/**
	 * Test method for
	 * {@link PasteDiagramElementAction#PasteDiagramElementAction(Transferable, Diagram)}.
	 * 
	 * Passing non-CopiedElement typed ClipboardContent.
	 */
	public void testPasteDiagramElementAction_NullDiagram() {
		try {
			new PasteDiagramElementAction(new MockTransferable(), new Diagram());
			fail("IAE is expected.");
		} catch (IllegalArgumentException e) {
			// pass
		}
	}

	/**
	 * Test method for {@link PasteDiagramElementAction#undo()}.
	 * 
	 * Undo before execute.
	 */
	public void testUndo() {
		try {
			action.undo();
			fail("CannotUndoException is expected");
		} catch (CannotUndoException e) {
			// pass
		}
	}

	/**
	 * Test method for {@link PasteDiagramElementAction#redo()}.
	 * 
	 * Redo before execute.
	 */
	public void testRedo() {
		try {
			action.redo();
			fail("CannotRedoException is expected");
		} catch (CannotRedoException e) {
			// pass
		}
	}

	/**
	 * Test method for {@link PasteDiagramElementAction#canUndo()}.
	 * 
	 * canUndo should be unsupported.
	 */
	public void testCanUndo() {
		try {
			action.canUndo();
			fail("UnsupportedOperationException is expected");
		} catch (UnsupportedOperationException e) {
			// pass
		}
	}

	/**
	 * Test method for {@link PasteDiagramElementAction#canRedo()}.
	 * 
	 * canRedo should be unsupported.
	 */
	public void testCanRedo() {
		try {
			action.canRedo();
			fail("UnsupportedOperationException is expected");
		} catch (UnsupportedOperationException e) {
			// pass
		}
	}

	/**
	 * Test method for {@link PasteDiagramElementAction#die()}.
	 * 
	 * die should be unsupported.
	 */
	public void testDie() {
		try {
			action.die();
			fail("UnsupportedOperationException is expected");
		} catch (UnsupportedOperationException e) {
			// pass
		}
	}
}
