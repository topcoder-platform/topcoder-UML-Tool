/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * AbstractAuxiliaryUndoableActionFailureTest.java
 */
package com.topcoder.uml.actions.auxiliary.failuretests;

import com.topcoder.uml.actions.auxiliary.failuretests.impls.AbstractAuxiliaryUndoableActionImpl;
import junit.framework.TestCase;

import javax.swing.undo.CannotRedoException;

/**
 * <p>
 * This is a failure tests for <code>AbstractAuxiliaryUndoableAction</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class AbstractAuxiliaryUndoableActionFailureTest extends TestCase {

    /**Name.*/
    private static final String NAME = "name";

    /**AbstractAuxiliaryUndoableAction instance that will be tested.*/
    private AbstractAuxiliaryUndoableActionImpl action;

    /**
     * <p>
     * Set up environment.
     * </p>
     *
     * @throws Exception exception
     */
    public void setUp() throws Exception {
        Helper.clearNamespace();
        Helper.initNamespace();

        action = new AbstractAuxiliaryUndoableActionImpl(NAME);
    }

    /**
     * <p>
     * Tear down.
     * </p>
     *
     * @throws Exception exception
     */
    public void tearDown() throws Exception {
        Helper.clearNamespace();
    }

    /**
     * <p>
     * Tests constructor AbstractAuxiliaryUndoableAction(name) if name is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfNameNull() {
        try {
            new AbstractAuxiliaryUndoableActionImpl(null);
            fail("IllegalArgumentException is expected because name cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor AbstractAuxiliaryUndoableAction(name) if name is empty.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfNameEmpty() {
        try {
            new AbstractAuxiliaryUndoableActionImpl("   ");
            fail("IllegalArgumentException is expected because name cannot be empty.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests method logException(message, exception) if exception is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void tetsLogExceptionIfExceptionNull() {
        try {
            action.logException("message", null);
            fail("IllegalArgumentException is expected because exception cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests method redo() if action is already dead.
     * CannotRedoException is expected.
     * </p>
     */
    public void testRedoIfDead() {
        action.die();
        try {
            action.redo();
            fail("CannotRedoException is expected.");
        } catch (CannotRedoException e) {
            //success
        }
    }
}