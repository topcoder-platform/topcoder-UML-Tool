/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.failuretests;

import com.topcoder.uml.actions.model.usecase.RemoveUseCaseAction;
import com.topcoder.uml.model.usecases.UseCase;

/**
 * <p>
 * Failure test for <code>{@link RemoveUseCaseAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class RemoveUseCaseActionFailureTests extends BaseTestCase {

    /**
     * <p>
     * Failure test for <code>{@link CopyUseCaseAction#CopyUseCaseAction(UseCase)}</code> constructor.
     * </p>
     */
    public void testCtor_1_nullUseCase() {
        assertConstructorException(RemoveUseCaseAction.class, new Class[] {UseCase.class}, new Object[] {null},
            IllegalArgumentException.class, "If actor is null, should throw IllegalArgumentException.");
    }
}
