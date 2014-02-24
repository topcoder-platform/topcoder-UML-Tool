/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers.failuretests;

import com.topcoder.uml.actions.model.classifiers.RemoveAssociationAction;
import com.topcoder.uml.model.core.relationships.Association;

/**
 * <p>
 * Failure test for <code>{@link RemoveAbstractionAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class RemoveAssociationActionFailureTests extends BaseTestCase {

    /**
     * <p>
     * Failure test for <code>{@link RemoveAssociationAction#RemoveAssociationAction(Association)}</code> constructor.
     * </p>
     */
    public void testCtor_NullAssociation() {
        assertConstructorException(RemoveAssociationAction.class, new Class[] {Association.class}, new Object[] {null},
            IllegalArgumentException.class, "If the association is null, should throw IllegalArgumentException.");
    }
}
