/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers.failuretests;

import com.topcoder.uml.actions.model.classifiers.AddDependencyAction;
import com.topcoder.uml.model.core.dependencies.Dependency;
import com.topcoder.uml.model.core.dependencies.DependencyImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Failure test for <code>{@link AddDependencyAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class AddDependencyActionFailureTests extends BaseTestCase {

    /**
     * <p>
     * Failure test for <code>{@link AddDependencyAction#AddDependencyAction(Dependency, UMLModelManager)}</code>
     * constructor.
     * </p>
     */
    public void testCtor_NullDependency() {
        assertConstructorException(AddDependencyAction.class, new Class[] {Dependency.class, UMLModelManager.class},
            new Object[] {null, new UMLModelManager()}, IllegalArgumentException.class,
            "If the abstraction is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link AddDependencyAction#AddDependencyAction(Dependency, UMLModelManager)}</code>
     * constructor.
     * </p>
     */
    public void testCtor_NullUMLModelManager() {
        assertConstructorException(AddDependencyAction.class, new Class[] {Dependency.class, UMLModelManager.class},
            new Object[] {new DependencyImpl(), null}, IllegalArgumentException.class,
            "If the umlModelManager is null, should throw IllegalArgumentException.");
    }

}
