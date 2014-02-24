/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import com.topcoder.uml.model.commonbehavior.instances.Stimulus;

/**
 * <p>
 * This class is the mock extension of RemoveMessageAction used for testing.
 * </p>
 *
 * @author evilisneo
 * @version 1.0
 */
public class MockRemoveMessageAction extends RemoveMessageAction {

    /**
     * <p>
     * Mock Stub. Just calls the super.
     * </p>
     *
     * @param stimulus
     *            Stimulus instance, Cannot be <code>null</code>
     * @throws IllegalArgumentException
     *             if the <code>stimulus</code> is <code>null</code>.
     */
    public MockRemoveMessageAction(Stimulus stimulus) {
        super(stimulus);
    }

}
