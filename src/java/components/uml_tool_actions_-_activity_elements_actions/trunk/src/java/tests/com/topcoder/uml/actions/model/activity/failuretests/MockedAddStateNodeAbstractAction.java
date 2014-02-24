/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity.failuretests;

import com.topcoder.uml.actions.model.activity.AddStateNodeAbstractAction;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.statemachines.StateVertex;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * This is a mocked implementation of <code>AddStateNodeAbstractAction</code>.
 * </p>
 *
 * @author restarter
 * @version 1.0
 */
public class MockedAddStateNodeAbstractAction extends AddStateNodeAbstractAction {
    /**
     * <p>
     * Constructor.
     * </p>
     *
     * @param name the presentation name.
     * @param state the <code>StateVertex</code> object to add to
     *            ActivityGraph
     * @param activityGraph the <code>ActivityGraph</code> object to add the
     *            state node
     * @param manager the <code>UMLModelManager</code> object to apply initial
     *            formatting
     * @throws IllegalArgumentException if the
     *             <code>name, state, activityGraph, manager</code> is
     *             <code>null</code> or if name is empty. Any exception while
     *             formatting the state using the project configuration is also
     *             wrapped.
     */
    protected MockedAddStateNodeAbstractAction(String name, StateVertex state, ActivityGraph activityGraph,
            UMLModelManager manager) {
        super(name, state, activityGraph, manager);
    }

}
