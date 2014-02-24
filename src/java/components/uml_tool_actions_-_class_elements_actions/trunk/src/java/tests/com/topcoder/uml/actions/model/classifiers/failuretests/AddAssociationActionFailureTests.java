/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers.failuretests;

import com.topcoder.uml.actions.model.classifiers.AddAssociationAction;
import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.uml.model.core.relationships.AssociationImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * Failure test for <code>{@link AddAssociationAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class AddAssociationActionFailureTests extends BaseTestCase {

    /**
     * <p>
     * Failure test for <code>{@link AddAssociationAction#AddAssociationAction(Association, UMLModelManager)}</code>
     * constructor.
     * </p>
     */
    public void testCtor_NullAssociation() {
        assertConstructorException(AddAssociationAction.class, new Class[] {Association.class, UMLModelManager.class},
            new Object[] {null, new UMLModelManager()}, IllegalArgumentException.class,
            "If the association is null, should throw IllegalArgumentException.");
    }

    /**
     * <p>
     * Failure test for <code>{@link AddAssociationAction#AddAssociationAction(Association, UMLModelManager)}</code>
     * constructor.
     * </p>
     */
    public void testCtor_NullUMLModelManager() {
        assertConstructorException(AddAssociationAction.class, new Class[] {Association.class, UMLModelManager.class},
            new Object[] {new AssociationImpl(), null}, IllegalArgumentException.class,
            "If the umlModelManager is null, should throw IllegalArgumentException.");
    }

}
