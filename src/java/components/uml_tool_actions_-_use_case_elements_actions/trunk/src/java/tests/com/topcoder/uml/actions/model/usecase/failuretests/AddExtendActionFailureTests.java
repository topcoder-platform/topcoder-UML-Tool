/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.usecase.failuretests;

import com.topcoder.uml.actions.model.usecase.AddExtendAction;
import com.topcoder.uml.model.usecases.Extend;
import com.topcoder.uml.model.usecases.ExtendImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Failure test for <code>{@link AddExtendAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class AddExtendActionFailureTests extends BaseTestCase {
    /**
     * <p>
     * Failure test for <code>{@link AddExtendAction#AddExtendAction(Extend, UMLModelManager)}</code>
     * </p>
     * <p>
     * If extend is null, should throw IllegalArgumentException.
     * </p>
     */
    public void testCtor_1_nullActor() {
        assertConstructorException(AddExtendAction.class, new Class[] {Extend.class, UMLModelManager.class},
            new Object[] {null, new UMLModelManager()}, IllegalArgumentException.class,
            "If actor is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link AddExtendAction#AddExtendAction(Extend, UMLModelManager)}</code>
     * </p>
     * <p>
     * If umlModelManager is null, should throw IllegalArgumentException.
     * </p>
     */
    public void testCtor_1_nullUMLModelManager() {
        assertConstructorException(AddExtendAction.class, new Class[] {Extend.class, UMLModelManager.class},
            new Object[] {new ExtendImpl(), null}, IllegalArgumentException.class,
            "If umlModelManager is null, should throw IllegalArgumentException.");
    }
}
