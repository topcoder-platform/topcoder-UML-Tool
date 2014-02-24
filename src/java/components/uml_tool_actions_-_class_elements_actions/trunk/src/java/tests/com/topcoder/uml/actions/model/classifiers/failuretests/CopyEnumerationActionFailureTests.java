/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers.failuretests;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.actions.model.classifiers.CopyEnumerationAction;
import com.topcoder.uml.model.core.classifiers.Enumeration;

/**
 * <p>
 * Failure test for <code>{@link CopyEnumerationAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class CopyEnumerationActionFailureTests extends BaseTestCase {
    /**
     * <p>
     * Failure test for <code>{@link CopyEnumerationAction#CopyEnumerationAction(Enumeration)}</code> constructor.
     * method.
     * </p>
     */
    public void testCtor_1_NullEnumeration() {
        assertConstructorException(CopyEnumerationAction.class, new Class[] {Enumeration.class}, new Object[] {null},
            IllegalArgumentException.class, "If the abstraction is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Fail test for <code>{@link CopyEnumerationAction#CopyEnumerationAction(Enumeration, Clipboard)}</code>
     * constructor.
     * </p>
     */
    public void testCtor_2_NullEnumeration() {
        assertConstructorException(CopyEnumerationAction.class, new Class[] {Enumeration.class, Clipboard.class},
            new Object[] {null, new Clipboard("test")}, IllegalArgumentException.class,
            "If the abstraction is null, should throw IllegalArgumentException.");
    }

}
