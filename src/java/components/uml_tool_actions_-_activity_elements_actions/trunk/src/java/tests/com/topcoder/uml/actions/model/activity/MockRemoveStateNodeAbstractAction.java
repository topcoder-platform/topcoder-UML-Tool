/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import com.topcoder.uml.model.statemachines.StateVertex;

/**
 * <p>
 * This is a mock extends of RemoveStateNodeAbstractAction class.
 * It is only used for testing.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockRemoveStateNodeAbstractAction extends RemoveStateNodeAbstractAction {

    /**
     * <p>
     * Call the super construct.
     * </p>
     *
     * @param name the presentation name.
     * @param state the StateVertex object to remove
     *
     * @throws IllegalArgumentException if the argument is null.
     */
    public MockRemoveStateNodeAbstractAction(String name, StateVertex state) {
        super(name, state);
    }

}
