/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.statemachines.failuretests;

import java.util.ArrayList;
import java.util.Collection;

import com.topcoder.uml.model.statemachines.CompositeState;
import com.topcoder.uml.model.statemachines.CompositeStateImpl;
import com.topcoder.uml.model.statemachines.StateMachine;
import com.topcoder.uml.model.statemachines.StateMachineImpl;
import com.topcoder.uml.model.statemachines.StateVertex;
import com.topcoder.uml.model.statemachines.Transition;

import junit.framework.TestCase;

/**
 * Failure test cases for class <code>CompositeStateImpl </code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class FailureTestCompositeStateImpl extends TestCase {

  /**
   * Represents the CompositeStateImpl instance for testing.
   */
  private CompositeStateImpl s = new CompositeStateImpl();


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
  public void testCompositeStateImplConstructor_1() {
    Collection<Transition> outgoing = new ArrayList<Transition>();

    Collection<Transition> incoming = new ArrayList<Transition>();
    try {
      new CompositeStateImpl(compositeState, outgoing, incoming, stateMachine, false, null);
      fail("IllegalArgumentException is expected.");
    } catch (IllegalArgumentException e) {
      // Ok.
    }

  }

  /**
   * Test the constructor.
   *
   */
  public void testCompositeStateImplConstructor_2() {
    Collection<Transition> outgoing = new ArrayList<Transition>();

    Collection<Transition> incoming = new ArrayList<Transition>();

    Collection<StateVertex> subVertexes = new ArrayList<StateVertex>();
    subVertexes.add(null);

    try {
      new CompositeStateImpl(compositeState, outgoing, incoming, stateMachine, false, subVertexes);
      fail("IllegalArgumentException is expected.");
    } catch (IllegalArgumentException e) {
      // Ok.
    }

  }

  /**
   * Test the constructor.
   *
   */
  public void testCompositeStateImplConstructor_3() {
    Collection<Transition> outgoing = new ArrayList<Transition>();
    Collection<StateVertex> subVertexes = new ArrayList<StateVertex>();

    try {
      new CompositeStateImpl(compositeState, outgoing, null, stateMachine, false, subVertexes);
      fail("IllegalArgumentException is expected.");
    } catch (IllegalArgumentException e) {
      // Ok.
    }

  }

  /**
   * Test the constructor.
   *
   */
  public void testCompositeStateImplConstructor_4() {
    Collection<Transition> outgoing = new ArrayList<Transition>();

    Collection<Transition> incoming = new ArrayList<Transition>();
    incoming.add(null);

    Collection<StateVertex> subVertexes = new ArrayList<StateVertex>();
    subVertexes.add(null);

    try {
      new CompositeStateImpl(compositeState, outgoing, incoming, stateMachine, false, subVertexes);
      fail("IllegalArgumentException is expected.");
    } catch (IllegalArgumentException e) {
      // Ok.
    }

  }

  /**
   * Test the constructor.
   *
   */
  public void testCompositeStateImplConstructor_5() {
    Collection<Transition> incoming = new ArrayList<Transition>();

    Collection<StateVertex> subVertexes = new ArrayList<StateVertex>();

    try {
      new CompositeStateImpl(compositeState, null, incoming, stateMachine, false, subVertexes);
      fail("IllegalArgumentException is expected.");
    } catch (IllegalArgumentException e) {
      // Ok.
    }

  }


  /**
   * Test the constructor.
   *
   */
  public void testCompositeStateImplConstructor_6() {
    Collection<Transition> outgoing = new ArrayList<Transition>();
    outgoing.add(null);

    Collection<Transition> incoming = new ArrayList<Transition>();

    Collection<StateVertex> subVertexes = new ArrayList<StateVertex>();

    try {
      new CompositeStateImpl(compositeState, outgoing, incoming, stateMachine, false, subVertexes);
      fail("IllegalArgumentException is expected.");
    } catch (IllegalArgumentException e) {
      // Ok.
    }

  }

  /**
   * Test method <code>void addSubVertex(StateVertex subVertex) </code>.
   *
   */
  public void testAddSubVertex() {
    try {
      s.addSubVertex(null);
      fail("IllegalArgumentException is expected.");
    } catch (IllegalArgumentException e) {
      // Ok.
    }
  }

  /**
   * Test method <code> boolean removeSubVertex(StateVertex subVertex) </code>.
   *
   */
  public void testRemoveSubVertex() {
    try {
      s.removeSubVertex(null);
      fail("IllegalArgumentException is expected.");
    } catch (IllegalArgumentException e) {
      // Ok.
    }
  }

  /**
   * Test method <code> boolean containsSubVertex(StateVertex subVertex) </code>.
   *
   */
  public void testContainsSubVertex() {
    try {
      s.containsSubVertex(null);
      fail("IllegalArgumentException is expected.");
    } catch (IllegalArgumentException e) {
      // Ok.
    }
  }

}
