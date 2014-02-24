/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.actionmanager.failuretests;

import com.topcoder.util.actionmanager.TransientAction;
import com.topcoder.util.actionmanager.TransientUndoableAction;
import com.topcoder.util.actionmanager.ActionExecutionException;

import junit.framework.TestCase;

/**
 * Failure test cases for class <code>TransientUndoableAction </code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class FailureTestTransientUndoableAction extends TestCase {

	/**
	 * Represents the TransientUndoableAction instance for testing.
	 */
	private TransientUndoableAction action = null;

	/**
	 * Represents the TransientAction instance for testing.
	 */
	private TransientAction transientAction = null;

	/**
	 * Set up the environment.
	 *
	 * @throws Exception to junit.
	 */
	public void setUp() throws Exception  {
		transientAction = new MyTransientAction();

		action = new TransientUndoableAction(transientAction, "TransientAction");
	}

	/**
	 * Test the first constructor
	 *  <code> TransientUndoableAction(TransientAction originalAction, String presentationName) </code>.
	 *
	 * <p>
	 * IllegalArgumentException if the parameter "originalAction" is null or the parameter "presentationName"
     *             is null or an empty String on trimming.
	 * </p>
	 */
	public void testTransientUndoableActionTransientActionString_1() {
		try {
			new TransientUndoableAction(null, "name");
			fail("IllegalArgumentException is expected.");
		} catch (IllegalArgumentException e) {
			// ok.
		}
	}


	/**
	 * Test the first constructor
	 *  <code> TransientUndoableAction(TransientAction originalAction, String presentationName) </code>.
	 *
	 * <p>
	 * IllegalArgumentException if the parameter "originalAction" is null or the parameter "presentationName"
     *             is null or an empty String on trimming.
	 * </p>
	 */
	public void testTransientUndoableActionTransientActionString_2() {
		try {
			new TransientUndoableAction(transientAction, null);
			fail("IllegalArgumentException is expected.");
		} catch (IllegalArgumentException e) {
			// ok.
		}
	}

	/**
	 * Test the first constructor
	 *  <code> TransientUndoableAction(TransientAction originalAction, String presentationName) </code>.
	 *
	 * <p>
	 * IllegalArgumentException if the parameter "originalAction" is null or the parameter "presentationName"
     *             is null or an empty String on trimming.
	 * </p>
	 */
	public void testTransientUndoableActionTransientActionString_3() {
		try {
			new TransientUndoableAction(transientAction, "");
			fail("IllegalArgumentException is expected.");
		} catch (IllegalArgumentException e) {
			// ok.
		}
	}

	/**
	 * Test the first constructor
	 *  <code> TransientUndoableAction(TransientAction originalAction, String presentationName) </code>.
	 *
	 * <p>
	 * IllegalArgumentException if the parameter "originalAction" is null or the parameter "presentationName"
     *             is null or an empty String on trimming.
	 * </p>
	 */
	public void testTransientUndoableActionTransientActionString_4() {
		try {
			new TransientUndoableAction(transientAction, "       ");
			fail("IllegalArgumentException is expected.");
		} catch (IllegalArgumentException e) {
			// ok.
		}
	}

	/**
	 * Test the second constructor
	 * <code>TransientUndoableAction(TransientAction originalAction, String presentationName, Log logger) </code>.
	 *
	 * <p>
	 * IllegalArgumentException if the parameter "originalAction" is null or the parameter "presentationName"
     *             is null or an empty String on trimming.
	 * </p>
	 *
	 */
	public void testTransientUndoableActionTransientActionStringLog_1() {
		try {
			new TransientUndoableAction(null, "name", null);
			fail("IllegalArgumentException is expected.");
		} catch (IllegalArgumentException e) {
			// ok.
		}
	}


	/**
	 * Test the second constructor
	 * <code>TransientUndoableAction(TransientAction originalAction, String presentationName, Log logger) </code>.
	 *
	 * <p>
	 * IllegalArgumentException if the parameter "originalAction" is null or the parameter "presentationName"
     *             is null or an empty String on trimming.
	 * </p>
	 *
	 */
	public void testTransientUndoableActionTransientActionStringLog_2() {
		try {
			new TransientUndoableAction(transientAction, null, null);
			fail("IllegalArgumentException is expected.");
		} catch (IllegalArgumentException e) {
			// ok.
		}
	}

	/**
	 * Test the second constructor
	 * <code>TransientUndoableAction(TransientAction originalAction, String presentationName, Log logger) </code>.
	 *
	 * <p>
	 * IllegalArgumentException if the parameter "originalAction" is null or the parameter "presentationName"
     *             is null or an empty String on trimming.
	 * </p>
	 *
	 */
	public void testTransientUndoableActionTransientActionStringLog_3() {
		try {
			new TransientUndoableAction(transientAction, "", null);
			fail("IllegalArgumentException is expected.");
		} catch (IllegalArgumentException e) {
			// ok.
		}
	}

	/**
	 * Test the second constructor
	 * <code>TransientUndoableAction(TransientAction originalAction, String presentationName, Log logger) </code>.
	 *
	 * <p>
	 * IllegalArgumentException if the parameter "originalAction" is null or the parameter "presentationName"
     *             is null or an empty String on trimming.
	 * </p>
	 *
	 */
	public void testTransientUndoableActionTransientActionStringLog_4() {
		try {
			new TransientUndoableAction(transientAction, "          ", null);
			fail("IllegalArgumentException is expected.");
		} catch (IllegalArgumentException e) {
			// ok.
		}
	}

	/**
	 * Test method <code>void execute()  </code>.
	 *
	 * <p>
	 * If isActive is false, ActionExecutionException should be thrown.
	 * </p>
	 *
	 */
	public void testExecute_1() {
		action.die();

		try {
			action.execute();
			fail("ActionExecutionException is expected.");
		} catch (ActionExecutionException e) {
			// OK.
		}
	}

	/**
	 * Test method <code>void execute()  </code>.
	 *
	 * <p>
	 * If isActive is true, execute method of TransientAction instance will be invoked.
	 * Thus ActionExecutionException should be caught and stored.
	 * </p>
	 *
	 */
	public void testExecute_2() {
		try {
			action.execute();
			fail("ActionExecutionException is expected.");
		} catch (ActionExecutionException e) {
			// OK.
		}

		assertNotNull("Exception should be stored.", action.getLastException().getMessage().indexOf("Failure") >= 0);
	}

	/**
	 * Test method <code>void redo() </code>.
	 *
	 * <p>
	 * If isActive is false, ActionExecutionException should be thrown.
	 * </p>
	 *
	 *
	 */
	public void testRedo_1() {
		action.die();
		action.redo();
		assertNotNull("The exception should be caught.", action.getLastException());
	}


	/**
	 * Test method <code>void redo() </code>.
	 *
	 * <p>
	 * If isActive is true, execute method of TransientAction instance will be invoked.
	 * Thus ActionExecutionException should be caught and stored.
	 * </p>
	 *
	 */
	public void testRedo_2() {
		action.redo();
		assertNotNull("The exception should be caught.", action.getLastException());
	}
}
