/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.failuretests;

import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.uml.actions.diagram.elements.RemoveDiagramElementAction;
import com.topcoder.util.actionmanager.ActionExecutionException;

import junit.framework.TestCase;

/**
 * Failure tests for RemoveDiagramElementAction.
 * 
 * @author superZZ
 * @version 1.0
 */
public class RemoveDiagramElementActionTest extends TestCase {
	/**
	 * RemoveDiagramElementAction instance for test.
	 */
	private final RemoveDiagramElementAction action = new RemoveDiagramElementAction(
			new GraphEdge(), new Diagram());

	/**
	 * Test method for
	 * {@link RemoveDiagramElementAction#RemoveDiagramElementAction(DiagramElement, Diagram)}.
	 * 
	 * Passing null ClipboardContent.
	 */
	public void testRemoveDiagramElementAction_NullDiagramElement() {
		try {
			new RemoveDiagramElementAction(new GraphEdge(), null);
			fail("IAE is expected");
		} catch (IllegalArgumentException e) {
			// pass
		}
	}

	/**
	 * Test method for
	 * {@link RemoveDiagramElementAction#RemoveDiagramElementAction(DiagramElement, Diagram)}.
	 * 
	 * Passing null diagram.
	 */
	public void testRemoveDiagramElementAction_NullDiagram() {
		try {
			new RemoveDiagramElementAction(null, new Diagram());
			fail("IAE is expected.");
		} catch (IllegalArgumentException e) {
			// pass
		}
	}

	/**
	 * Test method for {@link RemoveDiagramElementAction#execute()}.
	 * 
	 * Consecutive execute.
	 */
	public void testExecute() {
		try {
			action.execute();
			action.execute();
			fail("ActionExecutionException is expected");
		} catch (ActionExecutionException e) {
			// pass
		}
	}

	/**
	 * Test method for {@link RemoveDiagramElementAction#undo()}.
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
	 * Test method for {@link RemoveDiagramElementAction#redo()}.
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
	 * Test method for {@link RemoveDiagramElementAction#canUndo()}.
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
	 * Test method for {@link RemoveDiagramElementAction#canRedo()}.
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
	 * Test method for {@link RemoveDiagramElementAction#die()}.
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
