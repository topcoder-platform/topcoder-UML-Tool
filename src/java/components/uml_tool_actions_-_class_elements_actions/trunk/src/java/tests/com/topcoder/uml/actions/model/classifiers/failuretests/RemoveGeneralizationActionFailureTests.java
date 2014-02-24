/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers.failuretests;

import com.topcoder.uml.actions.model.classifiers.RemoveGeneralizationAction;
import com.topcoder.uml.model.core.relationships.Generalization;

/**
 * <p>
 * Failure test for <code>{@link RemoveGeneralizationAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class RemoveGeneralizationActionFailureTests extends BaseTestCase {

    /**
     * <p>
     * Failure test for <code>{@link RemoveGeneralizationAction#RemoveGeneralizationAction(Generalization)}</code>
     * constructor.
     * </p>
     */
    public void testCtor_NullGeneralization() {
        assertConstructorException(RemoveGeneralizationAction.class, new Class[] {Generalization.class},
            new Object[] {null}, IllegalArgumentException.class,
            "If the generalization is null, should throw IllegalArgumentException.");
    }
}
