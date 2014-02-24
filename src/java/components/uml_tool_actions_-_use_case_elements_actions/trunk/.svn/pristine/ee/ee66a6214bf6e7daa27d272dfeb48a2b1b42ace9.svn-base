/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.failuretests;

import com.topcoder.uml.actions.model.usecase.RemoveIncludeAction;
import com.topcoder.uml.model.usecases.Include;

/**
 * <p>
 * Failure test for <code>{@link RemoveIncludeAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class RemoveIncludeActionFailureTests extends BaseTestCase {

    /**
     * <p>
     * Failure test for <code>{@link CopyIncludeAction#CopyIncludeAction(Include)}</code> constructor.
     * </p>
     */
    public void testCtor_1_nullInclude() {
        assertConstructorException(RemoveIncludeAction.class, new Class[] {Include.class}, new Object[] {null},
            IllegalArgumentException.class, "If actor is null, should throw IllegalArgumentException.");
    }
}
