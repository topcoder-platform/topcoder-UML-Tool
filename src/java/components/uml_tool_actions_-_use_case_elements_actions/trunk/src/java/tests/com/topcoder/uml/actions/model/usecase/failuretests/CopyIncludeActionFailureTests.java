/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.failuretests;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.actions.model.usecase.CopyIncludeAction;
import com.topcoder.uml.model.usecases.Include;
import com.topcoder.uml.model.usecases.IncludeImpl;

/**
 * <p>
 * Failure test for <code>{@link CopyIncludeAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class CopyIncludeActionFailureTests extends BaseTestCase {
    /**
     * <p>
     * Failure test for <code>{@link CopyIncludeAction#CopyIncludeAction(Include)}</code> constructor.
     * </p>
     */
    public void testCtor_1_nullInclude() {
        assertConstructorException(CopyIncludeAction.class, new Class[] {Include.class}, new Object[] {null},
            IllegalArgumentException.class, "If include is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link CopyIncludeAction#CopyIncludeAction(Include, Clipboard)}</code> constructor.
     * </p>
     */
    public void testCtor_2_nullInclude() {
        assertConstructorException(CopyIncludeAction.class, new Class[] {Include.class, Clipboard.class}, new Object[] {
            null, new Clipboard("Hello")}, IllegalArgumentException.class,
            "If include is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link CopyIncludeAction#CopyIncludeAction(Include, Clipboard)}</code> constructor.
     * </p>
     */
    public void testCtor_2_nullClipboard() {
        assertConstructorException(CopyIncludeAction.class, new Class[] {Include.class, Clipboard.class}, new Object[] {
            new IncludeImpl(), null}, IllegalArgumentException.class,
            "If clipboard is null, should throw IllegalArgumentException.");
    }
}
