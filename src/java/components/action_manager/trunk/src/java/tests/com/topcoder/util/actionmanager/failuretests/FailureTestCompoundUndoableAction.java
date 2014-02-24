/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.actionmanager.failuretests;

import javax.swing.undo.CompoundEdit;

import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.actionmanager.CompoundUndoableAction;
import com.topcoder.util.actionmanager.TransientUndoableAction;
import com.topcoder.util.log.Log;
import com.topcoder.util.log.LogFactory;

import junit.framework.TestCase;

/**
 * Failure test cases for class <code>CompoundUndoableAction</code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class FailureTestCompoundUndoableAction extends TestCase {

    /**
     * Represents the Log instance.
     */
    private static Log log = LogFactory.getLog();

    /**
     * Test constructor <code>CompoundUndoableAction(String presentationName) </code>.
     *
     * <p>
     * IllegalArguemntException should be thrown if presenttationName is null or empty.
     * </p>
     *
     */
    public void testConstructor1_1() {
        try {
            new CompoundUndoableAction(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // Ok.
        }
    }

    /**
     * Test constructor <code>CompoundUndoableAction(String presentationName) </code>.
     *
     * <p>
     * IllegalArguemntException should be thrown if presenttationName is null or empty.
     * </p>
     *
     */
    public void testConstructor1_2() {
        try {
            new CompoundUndoableAction("");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // Ok.
        }
    }


    /**
     * Test constructor <code>CompoundUndoableAction(String presentationName) </code>.
     *
     * <p>
     * IllegalArguemntException should be thrown if presenttationName is null or empty.
     * </p>
     *
     */
    public void testConstructor1_3() {
        try {
            new CompoundUndoableAction("                     ");
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // Ok.
        }
    }


    /**
     * Test constructor <code>CompoundUndoableAction(String presentationName, Log logger) </code>.
     *
     * <p>
     * IllegalArguemntException should be thrown if presenttationName is null or empty.
     * </p>
     *
     */
    public void testConstructor2_1() {
        try {
            new CompoundUndoableAction(null, log);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // Ok.
        }
    }


    /**
     * Test constructor <code>CompoundUndoableAction(String presentationName, Log logger) </code>.
     *
     * <p>
     * IllegalArguemntException should be thrown if presenttationName is null or empty.
     * </p>
     *
     */
    public void testConstructor2_2() {
        try {
            new CompoundUndoableAction("", log);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // Ok.
        }
    }

    /**
     * Test constructor <code>CompoundUndoableAction(String presentationName, Log logger) </code>.
     *
     * <p>
     * IllegalArguemntException should be thrown if presenttationName is null or empty.
     * </p>
     *
     */
    public void testConstructor2_3() {
        try {
            new CompoundUndoableAction("            ", log);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // Ok.
        }
    }

    /**
     * Test method <code>void execute() </code>.
     * @throws Exception to junit.
     */
    public void testExecute_1() throws Exception {
        CompoundUndoableAction action = new CompoundUndoableAction("action");

        action.die();

        try {
            action.execute();
            fail("ActionExecutionException is expected.");
        } catch (ActionExecutionException e) {
            // Ok.
        }
    }


    /**
     * Test method <code>void execute() </code>.
     * <p>
     * In this test case, there is no UndoableAction, no exception should be thrown.
     * </p>
     * @throws Exception to junit.
     */
    public void testExecute_2() throws Exception {
        CompoundUndoableAction action = new CompoundUndoableAction("action");

        try {
            action.execute();
        } catch (ActionExecutionException e) {
            fail("ActionExecutionException is expected.");
        }
    }

    /**
     * Test method <code>void execute() </code>.
     * @throws Exception to junit.
     */
    public void testExecute_3() throws Exception {
        CompoundUndoableAction action = new CompoundUndoableAction("action");
        action.addEdit(new TransientUndoableAction(new MyTransientAction(), "reviewer"));
        try {
            action.execute();
            fail("ActionExecutionException is expected.");
        } catch (ActionExecutionException e) {
            // oK.
        }
    }

    /**
     * Test method <code> boolean addEdit(UndoableEdit edit) </code>.
     *
     * <p>
     * IllegalArgumentException  if the passed parameter is not an instance of UndoableAction or is null
     * </p>
     *
     */
    public void testAddEdit_1() {
        CompoundUndoableAction action = new CompoundUndoableAction("action");

        try {
            action.addEdit(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // Ok.
        }
    }

    /**
     * Test method <code> boolean addEdit(UndoableEdit edit) </code>.
     *
     * <p>
     * IllegalArgumentException  if the passed parameter is not an instance of UndoableAction or is null
     * </p>
     *
     */
    public void testAddEdit_2() {
        CompoundUndoableAction action = new CompoundUndoableAction("action");

        try {
            action.addEdit(new CompoundEdit());
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // Ok.
        }
    }

    /**
     * Test method <code>boolean replaceEdit(UndoableEdit edit) </code>.
     *
     * <p>
     * IllegalArgumentException if the passed parameter is not an instance of UndoableAction or is null
     * </p>
     */
    public void testReplaceEdit_1() {
        CompoundUndoableAction action = new CompoundUndoableAction("action");

        try {
            action.replaceEdit(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // Ok.
        }
    }


    /**
     * Test method <code>boolean replaceEdit(UndoableEdit edit) </code>.
     *
     * <p>
     * IllegalArgumentException if the passed parameter is not an instance of UndoableAction or is null
     * </p>
     */
    public void testReplaceEdit_2() {
        CompoundUndoableAction action = new CompoundUndoableAction("action");

        try {
            action.replaceEdit(new CompoundEdit());
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // Ok.
        }
    }
}
