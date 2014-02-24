/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.statemachines.StateVertex;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * This is a mock extends of AddStateNodeAbstractAction class.
 * It is only used for testing.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockAddStateNodeAbstractAction extends AddStateNodeAbstractAction {

    /**
     * <p>
     * Call the super construct.
     * </P>
     *
     * @param name the presentation name.
     * @param state the StateVertex object to add to ActivityGraph
     * @param activityGraph the ActivityGraph object to add the state node
     * @param manager the UMLModelManager object to apply initial formatting
     *
     * @throws IllegalArgumentException if any argument is null, or name is empty string
     */
    public MockAddStateNodeAbstractAction(String name, StateVertex state, ActivityGraph activityGraph,
        UMLModelManager manager) {
        super(name, state, activityGraph, manager);
    }

}
