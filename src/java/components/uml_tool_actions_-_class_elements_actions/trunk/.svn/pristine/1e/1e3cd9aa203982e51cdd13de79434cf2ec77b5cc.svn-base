/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers.failuretests;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.actions.model.classifiers.CutClassAction;

/**
 * <p>
 * Failure test for <code>{@link CutClassAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class CutClassActionFailureTests extends BaseTestCase {
    /**
     * <p>
     * Failure test for <code>{@link CutClassAction#CutClassAction(Class)}</code> constructor. method.
     * </p>
     */
    public void testCtor_1_NullClass() {
        assertConstructorException(CutClassAction.class,
            new Class[] {com.topcoder.uml.model.core.classifiers.Class.class}, new Object[] {null},
            IllegalArgumentException.class, "If the class is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Fail test for <code>{@link CutClassAction#CutClassAction(Class, Clipboard)}</code> constructor.
     * </p>
     */
    public void testCtor_2_NullClass() {
        assertConstructorException(CutClassAction.class, new Class[] {
            com.topcoder.uml.model.core.classifiers.Class.class, Clipboard.class}, new Object[] {null,
            new Clipboard("test")}, IllegalArgumentException.class,
            "If the class is null, should throw IllegalArgumentException.");
    }

}
