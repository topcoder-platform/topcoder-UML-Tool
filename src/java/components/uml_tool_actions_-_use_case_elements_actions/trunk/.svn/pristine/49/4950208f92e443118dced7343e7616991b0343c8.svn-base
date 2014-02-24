/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.failuretests;

import com.topcoder.uml.actions.model.usecase.RemoveActorAction;
import com.topcoder.uml.model.usecases.Actor;

/**
 * <p>
 * Failure test for <code>{@link RemoveActorAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class RemoveActorActionFailureTests extends BaseTestCase {

    /**
     * <p>
     * Failure test for <code>{@link CopyActorAction#CopyActorAction(Actor)}</code> constructor.
     * </p>
     */
    public void testCtor_1_nullActor() {
        assertConstructorException(RemoveActorAction.class, new Class[] {Actor.class}, new Object[] {null},
            IllegalArgumentException.class, "If actor is null, should throw IllegalArgumentException.");
    }
}
