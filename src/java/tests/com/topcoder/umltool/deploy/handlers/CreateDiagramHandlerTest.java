/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import junit.framework.TestCase;

import com.topcoder.uml.actions.diagram.CreateClassDiagramAction;
import com.topcoder.uml.actions.diagram.CreateDiagramAction;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.TestHelper;
import com.topcoder.util.eventmanager.ActionEvent;
import com.topcoder.util.eventmanager.EventValidation;
import com.topcoder.util.eventmanager.RedoChangesEvent;
import com.topcoder.util.eventmanager.UndoChangesEvent;

/**
 * <p>
 * Test the functionality of <code>CreateDiagramHandler</code> class.
 * </p>
 *
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class CreateDiagramHandlerTest extends TestCase {
	/** Reference to main frame for testing */
	private MainFrame mainFrame;

	/** An instance of <code>CreateDiagramHandler</code> for testing. */
	private CreateDiagramHandler handler;

	/** Create diagram action that triggers this handler */
	private CreateDiagramAction createDiagramAction;

	/** Action event to perform execute */
	private ActionEvent actionEvent;

	/** Action event to perform undo */
	private UndoChangesEvent undoEvent;

	/** Action event to perform redo */
	private RedoChangesEvent redoEvent;

	/**
	 * <p>
	 * Sets up the test environment. The test instance is created.
	 * </p>
	 *
	 * @throws Exception
	 *             to junit
	 */
	protected void setUp() throws Exception {
		super.setUp();
		mainFrame = TestHelper.getMainFrame();
		createDiagramAction = new CreateClassDiagramAction(null, "Test");
		actionEvent = new ActionEvent(createDiagramAction, mainFrame);
		undoEvent = new UndoChangesEvent(createDiagramAction, mainFrame);
		redoEvent = new RedoChangesEvent(createDiagramAction, mainFrame);
		handler = new CreateDiagramHandler();
	}

	/**
	 * Test method for 'CreateDiagramHandler.actionPerformed(EventObject,
	 * EventValidation)'. Diagram should be created and showed.
	 */
	public void testActionPerformed_Accuracy() {
		handler.actionPerformed(actionEvent, EventValidation.SUCCESSFUL);

		assertEquals("Current diagram is not the created one", TestHelper
				.getCurrentDiagram(), createDiagramAction.getDiagram());

		handler.undoActionPerformed(undoEvent, createDiagramAction);
	}

	/**
	 * Test method for 'CreateDiagramHandler.actionPerformed(EventObject,
	 * EventValidation)'.The argument is null, IllegalArgumentException should
	 * be thrown.
	 */
	public void testActionPerformed_Null_1() {
		try {
			handler.actionPerformed(null, EventValidation.SUCCESSFUL);
			fail("IllegalArgumentException should be thrown.");
		} catch (IllegalArgumentException iae) {
			// Success
		}
	}

	/**
	 * Test method for 'CreateDiagramHandler.actionPerformed(EventObject,
	 * EventValidation)'.The argument is null, IllegalArgumentException should
	 * be thrown.
	 */
	public void testActionPerformed_Null_2() {
		try {
			handler.actionPerformed(actionEvent, null);
			fail("IllegalArgumentException should be thrown.");
		} catch (IllegalArgumentException iae) {
			// Success
		}
	}

	/**
	 * Test method for
	 * 'CreateDiagramHandler.undoActionPerformed(UndoChangesEvent,
	 * UndoableAction)'. Created diagram should be closed.
	 */
	public void testUndoActionPerformed_Accuracy() {
		handler.actionPerformed(actionEvent, EventValidation.SUCCESSFUL);
		handler.undoActionPerformed(undoEvent, createDiagramAction);

		assertTrue("Created diagram is still opened", TestHelper
				.getCurrentDiagram() != createDiagramAction.getDiagram());
	}

	/**
	 * Test method for
	 * 'CreateDiagramHandler.undoActionPerformed(UndoChangesEvent,
	 * UndoableAction)'. The argument is null, IllegalArgumentException should
	 * be thrown.
	 */
	public void testUndoActionPerformed_Null_1() {
		try {
			handler.undoActionPerformed(null, createDiagramAction);
			fail("IllegalArgumentException should be thrown.");
		} catch (IllegalArgumentException iae) {
			// Success
		}
	}

	/**
	 * Test method for
	 * 'CreateDiagramHandler.undoActionPerformed(UndoChangesEvent,
	 * UndoableAction)'. The argument is null, IllegalArgumentException should
	 * be thrown.
	 */
	public void testUndoActionPerformed_Null_2() {
		try {
			handler.undoActionPerformed(undoEvent, null);
			fail("IllegalArgumentException should be thrown.");
		} catch (IllegalArgumentException iae) {
			// Success
		}
	}

	/**
	 * Test method for
	 * 'CreateDiagramHandler.redoActionPerformed(RedoChangesEvent,
	 * UndoableAction)'
	 */
	public void testRedoActionPerformed() {
		handler.actionPerformed(actionEvent, EventValidation.SUCCESSFUL);
		handler.undoActionPerformed(undoEvent, createDiagramAction);
		handler.redoActionPerformed(redoEvent, createDiagramAction);

		assertEquals("Current diagram is not the created one", TestHelper
				.getCurrentDiagram(), createDiagramAction.getDiagram());

		handler.undoActionPerformed(undoEvent, createDiagramAction);
	}

	/**
	 * Test method for
	 * 'CreateDiagramHandler.redoActionPerformed(RedoChangesEvent,
	 * UndoableAction)'. The argument is null, IllegalArgumentException should
	 * be thrown.
	 */
	public void testRedoActionPerformed_Null_1() {
		try {
			handler.redoActionPerformed(null, createDiagramAction);
			fail("IllegalArgumentException should be thrown.");
		} catch (IllegalArgumentException iae) {
			// Success
		}
	}

	/**
	 * Test method for
	 * 'CreateDiagramHandler.redoActionPerformed(RedoChangesEvent,
	 * UndoableAction)'. The argument is null, IllegalArgumentException should
	 * be thrown.
	 */
	public void testRedoActionPerformed_Null_2() {
		try {
			handler.redoActionPerformed(redoEvent, null);
			fail("IllegalArgumentException should be thrown.");
		} catch (IllegalArgumentException iae) {
			// Success
		}
	}

	/**
	 * <p>
	 * Tears down the test environment.
	 * </p>
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		mainFrame = null;
		createDiagramAction = null;
		actionEvent = null;
		undoEvent = null;
		redoEvent = null;
	}
}
