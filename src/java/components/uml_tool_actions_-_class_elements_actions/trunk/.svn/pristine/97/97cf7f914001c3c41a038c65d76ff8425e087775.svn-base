/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers.failuretests;

import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.actions.model.classifiers.CopyExceptionAction;
import com.topcoder.uml.actions.model.classifiers.InvalidDataContentException;
import com.topcoder.uml.model.core.classifiers.ClassImpl;

/**
 * <p>
 * Failure test for <code>{@link CopyExceptionAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class CopyExceptionActionFailureTests extends BaseTestCase {
    /**
     * <p>
     * Failure test for <code>{@link CopyExceptionAction#CopyExceptionAction(Class)}</code> constructor. method.
     * </p>
     */
    public void testCtor_1_NullException() {
        assertConstructorException(CopyExceptionAction.class,
            new Class[] {com.topcoder.uml.model.core.classifiers.Class.class}, new Object[] {null},
            IllegalArgumentException.class, "If the class is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for
     * <code>{@link CopyExceptionAction#CopyExceptionAction(com.topcoder.uml.model.core.classifiers.Class)}</code>
     * method.
     * </p>
     */
    public void testCtor_1_NotException() {
        assertConstructorException(CopyExceptionAction.class,
            new Class[] {com.topcoder.uml.model.core.classifiers.Class.class}, new Object[] {new ClassImpl()},
            InvalidDataContentException.class,
            "If the class is not exception, should throw InvalidDataContentException.");
    }

    /**
     * <p>
     * Fail test for <code>{@link CopyExceptionAction#CopyExceptionAction(Class, Clipboard)}</code> constructor.
     * </p>
     */
    public void testCtor_2_NullException() {
        assertConstructorException(CopyExceptionAction.class, new Class[] {
            com.topcoder.uml.model.core.classifiers.Class.class, Clipboard.class}, new Object[] {null,
            new Clipboard("test")}, IllegalArgumentException.class,
            "If the class is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Fail test for <code>{@link CopyExceptionAction#CopyExceptionAction(Class, Clipboard)}</code> constructor.
     * </p>
     */
    public void testCtor_2_NotException() {
        assertConstructorException(CopyExceptionAction.class, new Class[] {
            com.topcoder.uml.model.core.classifiers.Class.class, Clipboard.class}, new Object[] {new ClassImpl(),
            new Clipboard("test")}, InvalidDataContentException.class,
            "If the class is not exception, should throw InvalidDataContentException.");
    }
}
