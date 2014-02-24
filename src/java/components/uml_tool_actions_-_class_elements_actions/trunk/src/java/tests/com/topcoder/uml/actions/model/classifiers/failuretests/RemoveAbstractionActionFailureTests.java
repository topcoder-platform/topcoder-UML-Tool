/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers.failuretests;

import com.topcoder.uml.actions.model.classifiers.RemoveAbstractionAction;
import com.topcoder.uml.model.core.dependencies.Abstraction;

/**
 * <p>
 * Failure test for <code>{@link RemoveAbstractionAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class RemoveAbstractionActionFailureTests extends BaseTestCase {

    /**
     * <p>
     * Failure test for <code>{@link RemoveAbstractionAction#RemoveAbstractionAction(Abstraction)}</code> constructor.
     * </p>
     */
    public void testCtor_NullAbstraction() {
        assertConstructorException(RemoveAbstractionAction.class, new Class[] {Abstraction.class}, new Object[] {null},
            IllegalArgumentException.class, "If the abstraction is null, should throw IllegalArgumentException.");
    }
}
