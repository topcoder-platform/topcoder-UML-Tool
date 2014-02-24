/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */

package com.topcoder.uml.model.activitygraphs;

import junit.framework.TestCase;

import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.uml.model.statemachines.TransitionImpl;

/**
 * <p>
 * This class demonstrates the usage of this component. Generally, it shows the
 * following four scenarios:
 *
 * <ul>
 * <li> Scenario#1: Manage an ActivityGraph </li>
 * <li> Scenario#2: Manage an ObjectFlowState </li>
 * <li> Scenario#3: Manage an ActionState </li>
 * <li> Scenario#4: Manage a CallState </li>
 * </ul>
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class Demo extends TestCase {
    /**
     * <p>
     * This method demonstrates the management of an ActivityGraph.
     * </p>
     */
    public void testDemo1() {
        // create an activity graph
        ActivityGraph graph = new ActivityGraphImpl();

        // set top
        ActionState top = new ActionStateImpl();
        graph.setTop(top);

        // get top
        top = (ActionState) graph.getTop();
    }

    /**
     * <p>
     * This method demonstrates the management of an ObjectFlowState.
     * </p>
     */
    public void testDemo2() {
        // create an object flow state
        ObjectFlowState state1 = new ObjectFlowStateImpl();

        // create object flow state with given type
        Classifier type = new ClassImpl();
        ObjectFlowState state2 = new ObjectFlowStateImpl(type);

        // get attributes of an object flow state
        type = state1.getType();
        if (state1.isSynch()) {
            // perform some operations here
        } else {
            // perform some other operations here
        }

        // set attributes of an object flow state
        state2.setSynch(true);
        state2.setType(new ClassImpl());
    }

    /**
     * <p>
     * This method demonstrates the management of an ActionState.
     * </p>
     */
    public void testDemo3() {
        // create two action states
        ActionState state1 = new ActionStateImpl();
        ActionState state2 = new ActionStateImpl();

        // the states can be added to a graph as the two parts of a Transition
        Transition trans = new TransitionImpl();
        trans.setSource(state1);
        trans.setTarget(state2);
    }

    /**
     * <p>
     * This method demonstrates the management of an CallState.
     * </p>
     */
    public void testDemo4() {
        // create two call states
        CallState state1 = new CallStateImpl();
        CallState state2 = new CallStateImpl();

        // the states can be added to a graph as the two parts of a Transition
        Transition trans = new TransitionImpl();
        trans.setSource(state1);
        trans.setTarget(state2);
    }
}
