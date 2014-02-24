/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.failuretests;

import com.topcoder.uml.actions.model.usecase.RemoveExtendAction;
import com.topcoder.uml.model.usecases.Extend;

/**
 * <p>
 * Failure test for <code>{@link RemoveExtendAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class RemoveExtendActionFailureTests extends BaseTestCase {

    /**
     * <p>
     * Failure test for <code>{@link CopyExtendAction#CopyExtendAction(Extend)}</code> constructor.
     * </p>
     */
    public void testCtor_1_nullExtend() {
        assertConstructorException(RemoveExtendAction.class, new Class[] {Extend.class}, new Object[] {null},
            IllegalArgumentException.class, "If actor is null, should throw IllegalArgumentException.");
    }
}
