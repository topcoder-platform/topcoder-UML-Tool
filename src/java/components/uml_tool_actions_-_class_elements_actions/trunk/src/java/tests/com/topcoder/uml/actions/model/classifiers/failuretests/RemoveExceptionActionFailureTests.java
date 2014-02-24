/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers.failuretests;

import com.topcoder.uml.actions.model.classifiers.InvalidDataContentException;
import com.topcoder.uml.actions.model.classifiers.RemoveExceptionAction;
import com.topcoder.uml.model.core.classifiers.ClassImpl;

/**
 * <p>
 * Failure test for <code>{@link RemoveExceptionAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class RemoveExceptionActionFailureTests extends BaseTestCase {

    /**
     * <p>
     * Failure test for <code>{@link RemoveExceptionAction#RemoveExceptionAction(Exception)}</code> constructor.
     * </p>
     */
    public void testCtor_NullException() {
        assertConstructorException(RemoveExceptionAction.class,
            new Class[] {com.topcoder.uml.model.core.classifiers.Class.class}, new Object[] {null},
            IllegalArgumentException.class, "If the class is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link RemoveExceptionAction#RemoveExceptionAction(Exception)}</code> constructor.
     * </p>
     */
    public void testCtor_NotException() {
        assertConstructorException(RemoveExceptionAction.class,
            new Class[] {com.topcoder.uml.model.core.classifiers.Class.class}, new Object[] {new ClassImpl()},
            InvalidDataContentException.class,
            "If the class is not exception, should throw InvalidDataContentException.");
    }
}
