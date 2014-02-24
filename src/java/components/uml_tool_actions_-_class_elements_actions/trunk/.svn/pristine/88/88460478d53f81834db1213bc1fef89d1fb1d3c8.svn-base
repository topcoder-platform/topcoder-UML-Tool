/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers.failuretests;

import com.topcoder.uml.actions.model.classifiers.AddGeneralizationAction;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.core.relationships.GeneralizationImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Failure test for <code>{@link AddGeneralizationAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class AddGeneralizationActionFailureTests extends BaseTestCase {

    /**
     * <p>
     * Failure test for
     * <code>{@link AddGeneralizationAction#AddGeneralizationAction(Generalization, UMLModelManager)}</code>
     * constructor.
     * </p>
     */
    public void testCtor_NullGeneralization() {
        assertConstructorException(AddGeneralizationAction.class, new Class[] {Generalization.class,
            UMLModelManager.class}, new Object[] {null, new UMLModelManager()}, IllegalArgumentException.class,
            "If the generalizaion is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for
     * <code>{@link AddGeneralizationAction#AddGeneralizationAction(Generalization, UMLModelManager)}</code>
     * constructor.
     * </p>
     */
    public void testCtor_NullUMLModelManager() {
        assertConstructorException(AddGeneralizationAction.class, new Class[] {Generalization.class,
            UMLModelManager.class}, new Object[] {new GeneralizationImpl(), null}, IllegalArgumentException.class,
            "If the umlModelManager is null, should throw IllegalArgumentException.");
    }

}
