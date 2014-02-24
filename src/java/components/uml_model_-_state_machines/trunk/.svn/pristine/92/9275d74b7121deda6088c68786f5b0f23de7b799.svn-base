/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.statemachines.failuretests;

import java.util.ArrayList;
import java.util.Collection;

import com.topcoder.uml.model.statemachines.CompositeState;
import com.topcoder.uml.model.statemachines.CompositeStateImpl;
import com.topcoder.uml.model.statemachines.FinalStateImpl;
import com.topcoder.uml.model.statemachines.StateMachine;
import com.topcoder.uml.model.statemachines.StateMachineImpl;
import com.topcoder.uml.model.statemachines.Transition;

import junit.framework.TestCase;

/**
 * Failure test cases for class <code>FinalStateImpl</code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class FailureTestFinalStateImpl extends TestCase {


  /**
   * Represents the StateMachine instance for testing.
   */
  private static StateMachine stateMachine = new StateMachineImpl();

  /**
   * Represents the CompositeState instance for testing.
   */
  private static CompositeState compositeState = new CompositeStateImpl();


  /**
   * Test the constructor.
   *
   */
  public void testFinalStateImpl_1() {
    Collection<Transition> outgoing = new ArrayList<Transition>();
    try {
      new FinalStateImpl(compositeState, outgoing, null, stateMachine);
      fail("IllegalArgumentException is expected.");
    } catch (IllegalArgumentException e) {
      // Ok.
    }
  }


  /**
   * Test the constructor.
   *
   */
  public void testFinalStateImpl_2() {
    Collection<Transition> incoming = new ArrayList<Transition>();

    try {
      new FinalStateImpl(compositeState, null, incoming, stateMachine);
      fail("IllegalArgumentException is expected.");
    } catch (IllegalArgumentException e) {
      // Ok.
    }
  }


  /**
   * Test the constructor.
   *
   */
  public void testFinalStateImpl_3() {
    Collection<Transition> outgoing = new ArrayList<Transition>();

    Collection<Transition> incoming = new ArrayList<Transition>();
    incoming.add(null);

    try {
      new FinalStateImpl(compositeState, outgoing, incoming, stateMachine);
      fail("IllegalArgumentException is expected.");
    } catch (IllegalArgumentException e) {
      // Ok.
    }
  }


  /**
   * Test the constructor.
   *
   */
  public void testFinalStateImpl_4() {
    Collection<Transition> outgoing = new ArrayList<Transition>();
    outgoing.add(null);

    Collection<Transition> incoming = new ArrayList<Transition>();

    try {
      new FinalStateImpl(compositeState, outgoing, incoming, stateMachine);
      fail("IllegalArgumentException is expected.");
    } catch (IllegalArgumentException e) {
      // Ok.
    }
  }
}
