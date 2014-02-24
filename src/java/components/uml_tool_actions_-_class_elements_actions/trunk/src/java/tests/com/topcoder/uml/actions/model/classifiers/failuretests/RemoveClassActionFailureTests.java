/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers.failuretests;

import com.topcoder.uml.actions.model.classifiers.RemoveClassAction;

/**
 * <p>
 * Failure test for <code>{@link RemoveClassAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class RemoveClassActionFailureTests extends BaseTestCase {

    /**
     * <p>
     * Failure test for <code>{@link RemoveClassAction#RemoveClassAction(Class)}</code> constructor.
     * </p>
     */
    public void testCtor_NullClass() {
        assertConstructorException(RemoveClassAction.class,
            new Class[] {com.topcoder.uml.model.core.classifiers.Class.class}, new Object[] {null},
            IllegalArgumentException.class, "If the class is null, should throw IllegalArgumentException.");
    }
}
