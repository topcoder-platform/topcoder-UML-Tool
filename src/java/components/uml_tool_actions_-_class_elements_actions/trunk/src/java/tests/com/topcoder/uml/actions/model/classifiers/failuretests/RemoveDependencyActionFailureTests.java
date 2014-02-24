/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers.failuretests;

import com.topcoder.uml.actions.model.classifiers.RemoveAbstractionAction;
import com.topcoder.uml.actions.model.classifiers.RemoveDependencyAction;
import com.topcoder.uml.model.core.dependencies.Dependency;

/**
 * <p>
 * Failure test for <code>{@link RemoveAbstractionAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class RemoveDependencyActionFailureTests extends BaseTestCase {

    /**
     * <p>
     * Failure test for <code>{@link RemoveDependencyAction#RemoveDependencyAction(Dependency)}</code> constructor.
     * </p>
     */
    public void testCtor_NullDependency() {
        assertConstructorException(RemoveDependencyAction.class, new Class[] {Dependency.class}, new Object[] {null},
            IllegalArgumentException.class, "If the dependency is null, should throw IllegalArgumentException.");
    }
}
