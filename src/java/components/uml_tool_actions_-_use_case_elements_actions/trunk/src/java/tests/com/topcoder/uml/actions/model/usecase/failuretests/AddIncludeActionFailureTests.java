/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.failuretests;

import com.topcoder.uml.actions.model.usecase.AddIncludeAction;
import com.topcoder.uml.model.usecases.Include;
import com.topcoder.uml.model.usecases.IncludeImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Failure test for <code>{@link AddIncludeAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class AddIncludeActionFailureTests extends BaseTestCase {
    /**
     * <p>
     * Failure test for <code>{@link AddIncludeAction#AddIncludeAction(Include, UMLModelManager)}</code>
     * </p>
     * <p>
     * If extend is null, should throw IllegalArgumentException.
     * </p>
     */
    public void testCtor_1_nullActor() {
        assertConstructorException(AddIncludeAction.class, new Class[] {Include.class, UMLModelManager.class},
            new Object[] {null, new UMLModelManager()}, IllegalArgumentException.class,
            "If include is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link AddIncludeAction#AddIncludeAction(Include, UMLModelManager)}</code>
     * </p>
     * <p>
     * If umlModelManager is null, should throw IllegalArgumentException.
     * </p>
     */
    public void testCtor_1_nullUMLModelManager() {
        assertConstructorException(AddIncludeAction.class, new Class[] {Include.class, UMLModelManager.class},
            new Object[] {new IncludeImpl(), null}, IllegalArgumentException.class,
            "If umlModelManager is null, should throw IllegalArgumentException.");
    }
}
