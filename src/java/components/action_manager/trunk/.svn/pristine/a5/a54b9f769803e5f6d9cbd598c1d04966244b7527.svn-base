/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.actionmanager.accuracytests;

import junit.framework.TestCase;

import com.topcoder.util.actionmanager.CompoundUndoableAction;
import com.topcoder.util.actionmanager.TransientUndoableAction;
import com.topcoder.util.log.Log;
import com.topcoder.util.log.Level;
import com.topcoder.util.log.LogFactory;
import java.util.concurrent.atomic.AtomicInteger;
import com.topcoder.util.actionmanager.ActionExecutionException;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;

/**
 * Accuracy tests for <code>CompoundUndoableAction</code>.
 *
 * @author hackerzhut
 * @version 1.0
 */
public class CompoundUndoableActionAccuracyTests extends TestCase {
    /** Represents the CompoundUndoableAction instance for testing. */
    private CompoundUndoableAction instance = null;

    /** Represents the Log instance for testing. */
    private Log logger = null;

    /** Represents the instance of AtomicInteger for testing. */
    private AtomicInteger integer = null;

    /**
     * Initialization for all tests here.
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        Helper.unloadConfig();
        Helper.loadConfigFromFile("Logger_Wrapper.xml");
        this.logger = LogFactory.getLog("com.topcoder.util.log");
        integer = new AtomicInteger();
        instance = new CompoundUndoableAction("Name");
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
     * Test Method: CompoundUndoableAction(String presentationName)
     * Condition: Create new ActionManager instance using 1-arg constructor.
     * Expected: Created object should not be null.
     *
     * @throws Exception to jUnit.
     */
    public void test_TransientUndoableAction_1arg() throws Exception {
        assertNotNull("Should not be null.", new CompoundUndoableAction("Name"));
    }

    /**
     * Test Method: CompoundUndoableAction(String presentationName, Log logger)
     * Condition: Create new ActionManager instance using 2-arg constructor.
     * Expected: non null object.
     *
     * @throws Exception to jUnit.
     */
    public void test_CompoundUndoableAction_2arg() throws Exception {
        assertNotNull("Should not be null.", new CompoundUndoableAction("Name", null));
        assertNotNull("Should not be null.", new CompoundUndoableAction("Name", this.logger));
    }

    /**
     * Test Method: execute()
     * Condition: execute
     * Expected: check whether all the sub elements are executed.
     *
     * @throws Exception to jUnit.
     */
    public void test_execute() throws Exception {
        instance.addEdit(new MockUndoableAction(integer));
        instance.addEdit(new TransientUndoableAction(new MockTransientAction(integer), "TransientUndoableAction"));

        instance.execute();

        assertEquals(2, integer.get());
    }

    /**
     * Test Method: undo()
     * Condition: n/a
     * Expected: check whether all the sub actions are undone except transient action.
     *
     * @throws Exception to jUnit.
     */
    public void test_undo() throws Exception {
        instance.addEdit(new MockUndoableAction(integer));
        instance.addEdit(new TransientUndoableAction(new MockTransientAction(integer), "TransientUndoableAction"));

        instance.execute();

        assertEquals(2, integer.get());

        instance.undo();

        assertEquals(1, integer.get());
    }

    /**
     * Test Method: canUndo()
     * Condition: n/a
     * Expected: undo cannot be done before execute.
     *
     * @throws Exception to jUnit.
     */
    public void test_canUndo1() throws Exception {
        assertFalse("undo cannot be done before execution", instance.canUndo());
    }

    /**
     * Test Method: canUndo()
     * Condition: n/a
     * Expected: undo can be done after execute.
     *
     * @throws Exception to jUnit.
     */
    public void test_canUndo2() throws Exception {
        instance.addEdit(new MockUndoableAction(integer));
        instance.execute();
        assertTrue(instance.canUndo());
    }

    /**
     * Test Method: redo()
     * Condition: n/a
     * Expected: redo all the actions.
     *
     * @throws Exception to jUnit.
     */
    public void test_redo() throws Exception {
        instance.addEdit(new MockUndoableAction(integer));
        instance.addEdit(new TransientUndoableAction(new MockTransientAction(integer), "TransientUndoableAction"));
        instance.execute();
        instance.undo();
        instance.redo();
        assertEquals(3, integer.get());
    }

    /**
     * Test Method: canRedo()
     * Condition: n/a
     * Expected: return true if any redo available.
     *
     * @throws Exception to jUnit.
     */
    public void test_canRedo1() throws Exception {
        instance.addEdit(new MockUndoableAction(integer));
        instance.addEdit(new TransientUndoableAction(new MockTransientAction(integer), "TransientUndoableAction"));
        instance.execute();

        // undo the action done.
        instance.undo();

        // the action can be redone.
        assertTrue(instance.canRedo());
    }

    /**
     * Test Method: canRedo()
     * Condition: n/a
     * Expected: return true if any redo available.
     *
     * @throws Exception to jUnit.
     */
    public void test_canRedo2() throws Exception {
        instance.addEdit(new MockUndoableAction(integer));
        instance.execute();

        // no undo action done.
        // the action can not be redone.
        assertFalse(instance.canRedo());
    }

    /**
     * Test Method: die()
     * Condition: n/a
     * Expected: on execute after die throw ActionExecutionException
     *
     * @throws Exception to jUnit.
     */
    public void test_die1() {
        instance.die();

        try {
            instance.execute();
            fail("Should throw ActionExecutionException");
        } catch (ActionExecutionException e) {
            // Ignore.
        }
    }

    /**
     * Test Method: die()
     * Condition: n/a
     * Expected: on canUndo & unRedo after die returns false.
     *
     * @throws Exception to jUnit.
     */
    public void test_die2() {
        instance.die();
        assertFalse(instance.canUndo());
        assertFalse(instance.canRedo());
    }

    /**
     * Test Method: addEdit()
     * Condition: n/a
     * Expected: actions added before execute will be executed.
     *
     * @throws Exception to jUnit.
     */
    public void test_addEdit1() throws Exception {
        assertTrue(instance.addEdit(new MockUndoableAction(integer)));
    }

    /**
     * Test Method: addEdit()
     * Condition: n/a
     * Expected: actions added after execute is not added.
     *
     * @throws Exception to jUnit.
     */
    public void test_addEdit2() throws Exception {
        assertTrue(instance.addEdit(new MockUndoableAction(integer)));
        instance.execute();
        assertFalse(instance.addEdit(new MockUndoableAction(integer)));
    }

    /**
     * Test Method: replaceEdit()
     * Condition: n/a
     * Expected: actions that are able to replace the edit will return true.
     *
     * @throws Exception to jUnit.
     */
    public void test_replaceEdit1() throws Exception {
        assertEquals(false, instance.replaceEdit(new MockUndoableAction(integer)));
    }

    /**
     * Test Method: replaceEdit()
     * Condition: n/a
     * Expected: actions that are able to replace the edit will return false.
     *
     * @throws Exception to jUnit.
     */
    public void test_replaceEdit2() throws Exception {
        MockUndoableAction action = new MockUndoableAction(integer);
        assertEquals(false, instance.replaceEdit(action));
    }

    /**
     * Test Method: isSignificant()
     * Condition: n/a
     * Expected: return false before any action added.
     *
     * @throws Exception to jUnit.
     */
    public void test_isSignificant1() throws Exception {
        assertFalse(instance.isSignificant());
    }

    /**
     * Test Method: isSignificant()
     * Condition: n/a
     * Expected: returns true if any actions are added.
     *
     * @throws Exception to jUnit.
     */
    public void test_isSignificant2() throws Exception {
        instance.addEdit(new MockUndoableAction(integer));
        assertTrue(instance.isSignificant());
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
     * Condition: n/a
     * Expected: return the last exception thrown.
     *
     * @throws Exception to jUnit.
     */
    public void test_getLastException1() {
        Exception exception = null;

        assertNull(instance.getLastException());
        instance.die();

        try {
            instance.execute();
            fail("Should throw ActionExecutionException");
        } catch (ActionExecutionException e) {
            exception = e;
            // expected.
        }

        assertEquals(exception, instance.getLastException());
    }

    /**
     * Test Method: getLastException()
     * Condition: n/a
     * Expected: return the last exception thrown.
     *
     * @throws Exception to jUnit.
     */
    public void test_getLastException2() {
        assertNull(instance.getLastException());
        instance.die();

        instance.undo();

        assertTrue(instance.getLastException() instanceof CannotUndoException);
    }

    /**
     * Test Method: getLastException()
     * Condition: n/a
     * Expected: return the last exception thrown.
     *
     * @throws Exception to jUnit.
     */
    public void test_getLastException3() {
        assertNull(instance.getLastException());
        instance.die();

        instance.redo();

        assertTrue(instance.getLastException() instanceof CannotRedoException);
    }
}
