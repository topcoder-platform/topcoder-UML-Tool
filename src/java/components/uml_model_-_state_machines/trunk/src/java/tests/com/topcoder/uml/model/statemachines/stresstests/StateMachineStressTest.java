/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.statemachines.stresstests;

import com.topcoder.uml.model.datatypes.expressions.BooleanExpression;
import com.topcoder.uml.model.datatypes.expressions.BooleanExpressionImpl;
import com.topcoder.uml.model.statemachines.CompositeState;
import com.topcoder.uml.model.statemachines.CompositeStateImpl;
import com.topcoder.uml.model.statemachines.FinalState;
import com.topcoder.uml.model.statemachines.FinalStateImpl;
import com.topcoder.uml.model.statemachines.GuardImpl;
import com.topcoder.uml.model.statemachines.SimpleStateImpl;
import com.topcoder.uml.model.statemachines.State;
import com.topcoder.uml.model.statemachines.StateMachine;
import com.topcoder.uml.model.statemachines.StateMachineImpl;
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.uml.model.statemachines.TransitionImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Stress test for <b>UML Model: State Machines</b> component.
 * </p>
 * @author FireIce
 * @version 1.0
 */
public class StateMachineStressTest extends TestCase {

    /**
     * <p>
     * Represents the small iteration number for stress testing.
     * </p>
     */
    private static final int SMALL = 10;

    /**
     * <p>
     * Represents the medium iteration number for stress testing.
     * </p>
     */
    private static final int MEDIUM = 1000;

    /**
     * <p>
     * Represents the large iteration number for stress testing.
     * </p>
     */
    private static final int LARGE = 1000000;

    /**
     * <p>
     * common usage of State Machine component.
     * </p>
     */
    /**
     * Demonstrates the use of the <i>UML State Machines</i> component.
     */
    private void componnetUsage() {
        // create an empty state machine
        StateMachine myStateMachine = new StateMachineImpl();

        // Create all the states

        // create the top state
        CompositeState top = new CompositeStateImpl();
        top.setName("Select Amount");
        // create another state
        State otherAmount = new SimpleStateImpl();
        otherAmount.setName("Other Amount");
        // create a final state
        FinalState finalState = new FinalStateImpl();
        finalState.setName("Final State");
        // create a abort state
        State abortState = new FinalStateImpl();
        abortState.setName("Terminate");

        // Create all the transitions (some with guards)

        // abort transition#1
        Transition abortTransition = createTransition("abort", myStateMachine, top, abortState);

        // abort transition#2
        Transition abortTransition2 = createTransition("abort", myStateMachine, otherAmount, abortState);

        // Ok transition
        Transition okTransition = createTransition("Ok", myStateMachine, otherAmount, finalState);

        // amount transition
        Transition amountTransition = createTransition("Amount", myStateMachine, top, finalState);

        // create a new guard and add it to the transition
        BooleanExpression expression = new BooleanExpressionImpl();
        expression.setBody("amount<=500");
        amountTransition.setGuard(new GuardImpl(expression, amountTransition));

        // Other Amount transition
        Transition otherAmountTransition = createTransition("Other Amount", myStateMachine, top, otherAmount);

        // create a new guard and add it to the transition
        otherAmountTransition.setGuard(new GuardImpl(expression, otherAmountTransition));

        // add top state to the state machine
        myStateMachine.setTop(top);

        // Add transitions to states
        linkTransition(myStateMachine, abortTransition);
        linkTransition(myStateMachine, abortTransition2);
        linkTransition(myStateMachine, okTransition);
        linkTransition(myStateMachine, amountTransition);
        linkTransition(myStateMachine, otherAmountTransition);
    }

    /**
     * Helper method to create a new transition and set its name.
     * @param name
     *            the transition name
     * @param machine
     *            the state machine
     * @param source
     *            the source state
     * @param target
     *            the target state
     * @return a new transition with the specified attributes
     */
    private static Transition createTransition(String name, StateMachine machine, State source, State target) {
        Transition transition = new TransitionImpl(machine, source, target, null);
        transition.setName(name);
        return transition;
    }

    /**
     * Adds a transition to a state machine and links it to the source and target states.
     * @param machine
     *            the state machine
     * @param transition
     *            the transition
     */
    private static void linkTransition(StateMachine machine, Transition transition) {
        machine.addTransition(transition);
        transition.getSource().addOutgoingTransition(transition);
        transition.getTarget().addIncomingTransition(transition);
    }

    /**
     * <p>
     * Stress test for common component usage.
     * </p>
     */
    public void testComponentUsageSMALL() {
        long start = System.currentTimeMillis();

        for (int i = 0; i < SMALL; i++) {
            componnetUsage();
        }

        long end = System.currentTimeMillis();

        System.out.println("run common usage of state machine component for " + SMALL + " times takes " + (end - start)
            + " millisecond.");
    }

    /**
     * <p>
     * Stress test for common component usage.
     * </p>
     */
    public void testComponentUsageMEDIUM() {
        long start = System.currentTimeMillis();

        for (int i = 0; i < MEDIUM; i++) {
            componnetUsage();
        }

        long end = System.currentTimeMillis();

        System.out.println("run common usage of state machine component for " + MEDIUM + " times takes "
            + (end - start) + " millisecond.");
    }

    /**
     * <p>
     * Stress test for common component usage.
     * </p>
     */
    public void testComponentUsageLARGE() {
        long start = System.currentTimeMillis();

        for (int i = 0; i < LARGE; i++) {
            componnetUsage();
        }

        long end = System.currentTimeMillis();

        System.out.println("run common usage of state machine component for " + LARGE + " times takes " + (end - start)
            + " millisecond.");
    }
}
