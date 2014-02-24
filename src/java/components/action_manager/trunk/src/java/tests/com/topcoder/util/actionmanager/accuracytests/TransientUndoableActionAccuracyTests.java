/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.actionmanager.accuracytests;

import junit.framework.TestCase;

import com.topcoder.util.actionmanager.TransientUndoableAction;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.log.Log;
import com.topcoder.util.log.Level;
import com.topcoder.util.log.LogFactory;

/**
 * Accuracy tests for <code>TransientUndoableAction</code>.
 *
 * @author hackerzhut
 * @version 1.0
 */
public class TransientUndoableActionAccuracyTests extends TestCase {
    /** Represents the TransientUndoableAction instance for testing. */
    private TransientUndoableAction instance = null;

    /** Represents the Log instance for testing. */
    private Log logger = null;

    /**
     * Initialization for all tests here.
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        Helper.unloadConfig();
        Helper.loadConfigFromFile("Logger_Wrapper.xml");
        this.logger = LogFactory.getLog("com.topcoder.util.log");
        this.instance = new TransientUndoableAction(new MockTransientAction(), "Name", null);
    }

    /**
     * Clean up the entironment.
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        Helper.unloadConfig();
    }

    /**
     * Test Method: TransientUndoableAction(TransientAction originalAction, String presentationName)
     * Condition: Create new ActionManager instance using 2-arg constructor.
     * Expected: Created object should not be null.
     *
     * @throws Exception to jUnit.
     */
    public void test_TransientUndoableAction_2arg() throws Exception {
        assertNotNull("Should not be null.", new TransientUndoableAction(new MockTransientAction(), "Name"));
    }

    /**
     * Test Method: TransientUndoableAction(TransientAction originalAction, String presentationName, Log logger)
     * Condition: Create new ActionManager instance using 3-arg constructor.
     * Expected: non null object.
     *
     * @throws Exception to jUnit.
     */
    public void test_TransientUndoableAction_3arg() throws Exception {
        assertNotNull("Should not be null.", new TransientUndoableAction(new MockTransientAction(), "Name", null));
        assertNotNull("Should not be null.", new TransientUndoableAction(new MockTransientAction(), "Name", this.logger));
    }

    /**
     * Test Method: execute()
     * Condition: execute.
     * Expected: verifies the execute method.
     *
     * @throws Exception to jUnit.
     */
    public void test_execute() throws Exception {
        this.instance.execute();
        this.instance.die();

        try {
            this.instance.execute();
            fail("Should throw ActionExecutionException");
        } catch (ActionExecutionException e) {
            // expected.
        }
    }

    /**
     * Test Method: canUndo()
     * Condition: n/a
     * Expected: should return true intially, false after die.
     *
     * @throws Exception to jUnit.
     */
    public void test_canUndo() throws Exception {
        assertEquals(true, this.instance.canUndo());
        this.instance.die();
        assertEquals(false, this.instance.canUndo());
    }

    /**
     * Test Method: canRedo()
     * Condition: n/a
     * Expected: should return true intially, false after die.
     *
     * @throws Exception to jUnit.
     */
    public void test_canRedo() throws Exception {
        assertEquals(true, this.instance.canRedo());
        this.instance.die();
        assertEquals(false, this.instance.canRedo());
    }

    /**
     * Test Method: addEdit(UndoableEdit edit)
     * Condition: n/a
     * Expected: should always return false.
     *
     * @throws Exception to jUnit.
     */
    public void test_addEdit() throws Exception {
        assertEquals(false, this.instance.addEdit(null));
        this.instance.die();
        assertEquals(false, this.instance.addEdit(null));
    }

    /**
     * Test Method: replaceEdit(UndoableEdit edit)
     * Condition: n/a
     * Expected: should always return false.
     *
     * @throws Exception to jUnit.
     */
    public void test_replaceEdit() throws Exception {
        assertEquals(false, this.instance.replaceEdit(null));
        this.instance.die();
        assertEquals(false, this.instance.replaceEdit(null));
    }

    /**
     * Test Method: isSignificant()
     * Condition: n/a
     * Expected: should always return false.
     *
     * @throws Exception to jUnit.
     */
    public void test_isSignificant() throws Exception {
        assertEquals(false, this.instance.isSignificant());
        this.instance.die();
        assertEquals(false, this.instance.isSignificant());
    }

    /**
     * Test Method: getPresentationName()
     * Condition: n/a
     * Expected: should return "Name"
     *
     * @throws Exception to jUnit.
     */
    public void test_getPresentationName() throws Exception {
        assertEquals("Name", this.instance.getPresentationName());
    }

    /**
     * Test Method: getUndoPresentationName()
     * Condition: n/a
     * Expected: should return "Undo: Name"
     *
     * @throws Exception to jUnit.
     */
    public void test_getUndoPresentationName() throws Exception {
        assertEquals("Undo: Name", this.instance.getUndoPresentationName());
    }

    /**
     * Test Method: getRedoPresentationName()
     * Condition: n/a
     * Expected: should return "Redo: Name"
     *
     * @throws Exception to jUnit.
     */
    public void test_getRedoPresentationName() throws Exception {
        assertEquals("Redo: Name", this.instance.getRedoPresentationName());
    }

    /**
     * Test Method: getLastException()
     * Condition: execute & check for last exception.
     * Expected: should return the last exception.
     *
     * @throws Exception to jUnit.
     */
    public void test_getLastException() throws Exception {
        this.instance.execute();
        this.instance.die();
        Exception exception = null;

        try {
            this.instance.execute();
            fail("Should throw ActionExecutionException");
        } catch (ActionExecutionException e) {
            exception = e;
            // expected.
        }

        assertEquals(exception, this.instance.getLastException());
    }
}