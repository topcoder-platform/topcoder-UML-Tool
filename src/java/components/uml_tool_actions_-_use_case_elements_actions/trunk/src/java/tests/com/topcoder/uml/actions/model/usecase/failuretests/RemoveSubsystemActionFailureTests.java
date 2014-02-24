/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.failuretests;

import com.topcoder.uml.actions.model.usecase.RemoveSubsystemAction;
import com.topcoder.uml.model.modelmanagement.Subsystem;

/**
 * <p>
 * Failure test for <code>{@link RemoveSubsystemAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class RemoveSubsystemActionFailureTests extends BaseTestCase {

    /**
     * <p>
     * Failure test for <code>{@link CopySubsystemAction#CopySubsystemAction(Subsystem)}</code> constructor.
     * </p>
     */
    public void testCtor_1_nullSubsystem() {
        assertConstructorException(RemoveSubsystemAction.class, new Class[] {Subsystem.class}, new Object[] {null},
            IllegalArgumentException.class, "If actor is null, should throw IllegalArgumentException.");
    }
}
