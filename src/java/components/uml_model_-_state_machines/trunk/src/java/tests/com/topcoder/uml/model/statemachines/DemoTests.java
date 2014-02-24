/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.statemachines;

import com.topcoder.uml.model.datatypes.expressions.BooleanExpressionImpl;
import com.topcoder.uml.model.datatypes.PseudostateKind;
import junit.framework.TestCase;

/**
 * <p>
 * The TIN Scrubber application will be used to help synchronize taxpayer data on a remote system with data in a master
 * system. This particular component will provide overall control of the scrubbing logic.
 * </p>
 * <p>
 * This class provides the demo usage of this component.
 * </p>
 *
 * @author catcher
 * @version 1.0
 */
public class DemoTests extends TestCase {

    /**
     * <p>
     * This test shows how to create <code>StateMachine</code> instance. and how to use it.
     * </p>
     *
     * @throws Exception
     *             throws exception to JUnit
     */
    public void testStateMachine() throws Exception {

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
        Pseudostate abortState = new PseudostateImpl();
        abortState.setName("Abort State");
        abortState.setKind(PseudostateKind.JUNCTION);

        // Create all the transitions (some with guards)

        // abort transition#1
        Transition abortTransition = new TransitionImpl();
        abortTransition.setName("abort");
        abortTransition.setSource(top);
        abortTransition.setTarget(abortState);

        // abort transition#2
        Transition abortTransition2 = new TransitionImpl();
        abortTransition2.setName("abort");
        abortTransition2.setSource(otherAmount);
        abortTransition2.setTarget(abortState);

        // Ok transition
        Transition okTransition = new TransitionImpl();
        okTransition.setName("Ok");
        okTransition.setSource(otherAmount);
        okTransition.setTarget(finalState);

        // amount transition
        Transition amountTransition = new TransitionImpl();
        amountTransition.setName("Amount");
        amountTransition.setSource(top);
        amountTransition.setTarget(finalState);
        // create a new guard and add it to the transition
        Guard amountTransitionGuard = new GuardImpl(new BooleanExpressionImpl(), amountTransition);
        amountTransition.setGuard(amountTransitionGuard);

        // Other Amount transition
        Transition otherAmountTransition = new TransitionImpl();
        otherAmountTransition.setName("Other Amount");
        otherAmountTransition.setSource(top);
        otherAmountTransition.setTarget(otherAmount);
        // create a new guard and add it to the transition
        Guard otherAmountTransitionGuard = new GuardImpl(new BooleanExpressionImpl(), otherAmountTransition);
        otherAmountTransition.setGuard(otherAmountTransitionGuard);

        // Add transitions to states

        // top state
        top.addOutgoingTransition(abortTransition);
        top.addOutgoingTransition(amountTransition);
        top.addOutgoingTransition(otherAmountTransition);

        // Other Amount State
        otherAmount.addOutgoingTransition(abortTransition2);
        otherAmount.addOutgoingTransition(okTransition);
        otherAmount.addIncomingTransition(otherAmountTransition);

        // Final State
        finalState.addIncomingTransition(amountTransition);
        finalState.addIncomingTransition(okTransition);

        // Abort State
        abortState.addIncomingTransition(abortTransition);
        abortState.addIncomingTransition(abortTransition2);

        // Add all transitions to the state machine

        // add top state to the state machine
        myStateMachine.setTop(top);
        // add transitions to the state machine
        myStateMachine.addTransition(abortTransition);
        myStateMachine.addTransition(abortTransition2);
        myStateMachine.addTransition(okTransition);
        myStateMachine.addTransition(amountTransition);
        myStateMachine.addTransition(otherAmountTransition);
    }
}
