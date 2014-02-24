/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers.failuretests;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.actions.model.classifiers.CopyClassAction;

/**
 * <p>
 * Failure test for <code>{@link CopyClassAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class CopyClassActionFailureTests extends BaseTestCase {
    /**
     * <p>
     * Failure test for <code>{@link CopyClassAction#CopyClassAction(Class)}</code> constructor. method.
     * </p>
     */
    public void testCtor_1_NullClass() {
        assertConstructorException(CopyClassAction.class,
            new Class[] {com.topcoder.uml.model.core.classifiers.Class.class}, new Object[] {null},
            IllegalArgumentException.class, "If the class is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Fail test for <code>{@link CopyClassAction#CopyClassAction(Class, Clipboard)}</code> constructor.
     * </p>
     */
    public void testCtor_2_NullClass() {
        assertConstructorException(CopyClassAction.class, new Class[] {
            com.topcoder.uml.model.core.classifiers.Class.class, Clipboard.class}, new Object[] {null,
            new Clipboard("test")}, IllegalArgumentException.class,
            "If the class is null, should throw IllegalArgumentException.");
    }
}
