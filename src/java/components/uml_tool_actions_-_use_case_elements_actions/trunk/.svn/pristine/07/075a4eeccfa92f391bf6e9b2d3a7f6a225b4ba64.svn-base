/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.failuretests;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.actions.model.usecase.CutExtendAction;
import com.topcoder.uml.model.usecases.Extend;
import com.topcoder.uml.model.usecases.ExtendImpl;

/**
 * <p>
 * Failure test for <code>{@link CutExtendAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class CutExtendActionFailureTests extends BaseTestCase {
    /**
     * <p>
     * Failure test for <code>{@link CutExtendAction#CutExtendAction(Extend)}</code> constructor.
     * </p>
     */
    public void testCtor_1_nullExtend() {
        assertConstructorException(CutExtendAction.class, new Class[] {Extend.class}, new Object[] {null},
            IllegalArgumentException.class, "If actor is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link CutExtendAction#CutExtendAction(Extend, Clipboard)}</code> constructor.
     * </p>
     */
    public void testCtor_2_nullExtend() {
        assertConstructorException(CutExtendAction.class, new Class[] {Extend.class, Clipboard.class}, new Object[] {
            null, new Clipboard("Hello")}, IllegalArgumentException.class,
            "If actor is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link CutExtendAction#CutExtendAction(Extend, Clipboard)}</code> constructor.
     * </p>
     */
    public void testCtor_2_nullClipboard() {
        assertConstructorException(CutExtendAction.class, new Class[] {Extend.class, Clipboard.class}, new Object[] {
            new ExtendImpl(), null}, IllegalArgumentException.class,
            "If clipboard is null, should throw IllegalArgumentException.");
    }
}
