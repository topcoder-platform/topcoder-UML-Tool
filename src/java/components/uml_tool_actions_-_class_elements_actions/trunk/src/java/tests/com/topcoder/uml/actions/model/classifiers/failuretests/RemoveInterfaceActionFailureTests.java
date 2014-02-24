/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers.failuretests;

import com.topcoder.uml.actions.model.classifiers.RemoveInterfaceAction;
import com.topcoder.uml.model.core.classifiers.Interface;

/**
 * <p>
 * Failure test for <code>{@link RemoveInterfaceAction}</code> class.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class RemoveInterfaceActionFailureTests extends BaseTestCase {

    /**
     * <p>
     * Failure test for <code>{@link RemoveInterfaceAction#RemoveInterfaceAction(Interface)}</code> constructor.
     * </p>
     */
    public void testCtor_NullInterface() {
        assertConstructorException(RemoveInterfaceAction.class, new Class[] {Interface.class}, new Object[] {null},
            IllegalArgumentException.class, "If the interface is null, should throw IllegalArgumentException.");
    }
}
