/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers.failuretests;

import com.topcoder.uml.actions.model.classifiers.AddAbstractionAction;
import com.topcoder.uml.model.core.dependencies.Abstraction;
import com.topcoder.uml.model.core.dependencies.AbstractionImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Failure test for <code>{@link AddAbstractionAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class AddAbstractionActionFailureTests extends BaseTestCase {

    /**
     * <p>
     * Failure test for <code>{@link AddAbstractionAction#AddAbstractionAction(Abstraction, UMLModelManager)}</code>
     * constructor.
     * </p>
     */
    public void testCtor_NullAbstraction() {
        assertConstructorException(AddAbstractionAction.class, new Class[] {Abstraction.class, UMLModelManager.class},
            new Object[] {null, new UMLModelManager()}, IllegalArgumentException.class,
            "If the abstraction is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link AddAbstractionAction#AddAbstractionAction(Abstraction, UMLModelManager)}</code>
     * constructor.
     * </p>
     */
    public void testCtor_NullUMLModelManager() {
        assertConstructorException(AddAbstractionAction.class, new Class[] {Abstraction.class, UMLModelManager.class},
            new Object[] {new AbstractionImpl(), null}, IllegalArgumentException.class,
            "If the umlModelManager is null, should throw IllegalArgumentException.");
    }

}
