/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.failuretests;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.actions.model.usecase.CutIncludeAction;
import com.topcoder.uml.model.usecases.Include;
import com.topcoder.uml.model.usecases.IncludeImpl;

/**
 * <p>
 * Failure test for <code>{@link CutIncludeAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class CutIncludeActionFailureTests extends BaseTestCase {
    /**
     * <p>
     * Failure test for <code>{@link CutIncludeAction#CutIncludeAction(Include)}</code> constructor.
     * </p>
     */
    public void testCtor_1_nullInclude() {
        assertConstructorException(CutIncludeAction.class, new Class[] {Include.class}, new Object[] {null},
            IllegalArgumentException.class, "If actor is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link CutIncludeAction#CutIncludeAction(Include, Clipboard)}</code> constructor.
     * </p>
     */
    public void testCtor_2_nullInclude() {
        assertConstructorException(CutIncludeAction.class, new Class[] {Include.class, Clipboard.class}, new Object[] {
            null, new Clipboard("Hello")}, IllegalArgumentException.class,
            "If actor is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link CutIncludeAction#CutIncludeAction(Include, Clipboard)}</code> constructor.
     * </p>
     */
    public void testCtor_2_nullClipboard() {
        assertConstructorException(CutIncludeAction.class, new Class[] {Include.class, Clipboard.class}, new Object[] {
            new IncludeImpl(), null}, IllegalArgumentException.class,
            "If clipboard is null, should throw IllegalArgumentException.");
    }
}
