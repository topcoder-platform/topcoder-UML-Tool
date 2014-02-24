/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.util.actionmanager.accuracytests;

import com.topcoder.util.actionmanager.UndoableAction;
import javax.swing.undo.UndoableEdit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Mock for UndoableAction (used in test cases).
 *
 * @author hackerzhut
 * @version 1.0
 */
public class MockUndoableAction implements UndoableAction {
    /** The AtomicInteger instance.*/
    private AtomicInteger integer = null;

    /**
     * Constructor.
     *
     * @param instance the counter
     */
    public MockUndoableAction(AtomicInteger integer) {
        this.integer = integer;
    }

    /**
     * Execute the action.
     */
    public void execute() {
        integer.incrementAndGet();
    }

    /**
     * Can redo.
     *
     * @return true, can redo
     */
    public boolean canRedo() {
        return true;
    }

    /**
     * Can undo.
     *
     * @return true, can undo
     */
    public boolean canUndo() {
        return true;
    }

    /**
     * Significant action.
     *
     * @return true, significant
     */
    public boolean isSignificant() {
        return true;
    }

    /**
     * Redo the action.
     */
    public void redo() {
        integer.incrementAndGet();
    }

    /**
     * Undo the action.
     */
    public void undo() {
        integer.decrementAndGet();
    }

    /**
     * Mock implementation.
     *
     * @param anEdit the edit
     *
     * @return false
     */
    public boolean addEdit(UndoableEdit anEdit) {
        return false;
    }

    /**
     * Mock implementation.
     */
    public void die() {
    }

    /**
     * Mock implementation.
     *
     * @return null
     */
    public String getPresentationName() {
        return null;
    }

    /**
     * Mock implementation.
     *
     * @return null
     */
    public String getRedoPresentationName() {
        return null;
    }

    /**
     * Mock implementation.
     *
     * @return null
     */
    public String getUndoPresentationName() {
        return null;
    }

    /**
     * Mock implementation.
     *
     * @param anEdit the edit
     *
     * @return false
     */
    public boolean replaceEdit(UndoableEdit anEdit) {
        return false;
    }
}
