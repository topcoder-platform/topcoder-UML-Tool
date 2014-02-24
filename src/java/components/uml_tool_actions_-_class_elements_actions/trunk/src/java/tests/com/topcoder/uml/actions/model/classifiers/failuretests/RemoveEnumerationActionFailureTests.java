/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers.failuretests;

import com.topcoder.uml.actions.model.classifiers.RemoveEnumerationAction;
import com.topcoder.uml.model.core.classifiers.Enumeration;

/**
 * <p>
 * Failure test for <code>{@link RemoveEnumerationAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class RemoveEnumerationActionFailureTests extends BaseTestCase {

    /**
     * <p>
     * Failure test for <code>{@link RemoveEnumerationAction#RemoveEnumerationAction(Enumeration)}</code> constructor.
     * </p>
     */
    public void testCtor_NullEnumeration() {
        assertConstructorException(RemoveEnumerationAction.class, new Class[] {Enumeration.class}, new Object[] {null},
            IllegalArgumentException.class, "If the enumeration is null, should throw IllegalArgumentException.");
    }
}
