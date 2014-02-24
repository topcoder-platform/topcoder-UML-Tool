/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.statemachines.failuretests;

import java.util.ArrayList;
import java.util.Collection;

import  com.topcoder.uml.model.statemachines.StateMachineImpl;
import com.topcoder.uml.model.statemachines.Transition;

import junit.framework.TestCase;

/**
 * Failure test for class <code>StateMachineImpl </code>.
 *
 * @author Chenhong
 * @version 1.0
 *
 */
public class FailureTestStateMachineImpl extends TestCase {

  /**
   * Represents the StateMachine instance for testing.
   */
  private StateMachineImpl s  = new StateMachineImpl();

  /**
   * Test constructor.
   *
   */
  public void testConstructor_1() {
    try {
      new StateMachineImpl(null, null, null);
      fail("IllegalArgumentException is expected.");
    } catch (IllegalArgumentException e) {
      // Ok.
    }
  }

  /**
   * Test constructor.
   *
   */
  public void testConstructor_2() {
    Collection<Transition> transitions  = new ArrayList<Transition>();
    transitions.add(null);

    try {
      new StateMachineImpl(null, null, transitions);
      fail("IllegalArgumentException is expected.");
    } catch (IllegalArgumentException e) {
      // Ok.
    }
  }

  /**
   * Test method <code>void addTransition(Transition transition) </code>.
   *
   */
  public void testAddTransition() {
    try {
      s.addTransition(null);
      fail("IllegalArgumentException is expected.");
    } catch (IllegalArgumentException e) {
      // Ok.
    }
  }

  /**
   * Test method <code>void removeTransition(Transition transition) </code>.
   *
   */
  public void testRemoveTransition() {
    try {
      s.removeTransition(null);
      fail("IllegalArgumentException is expected.");
    } catch (IllegalArgumentException e) {
      // Ok.
    }
  }

  /**
   * Test method <code>void containsTransition(Transition transition) </code>.
   *
   */
  public void testContainsTransition() {
    try {
      s.containsTransition(null);
      fail("IllegalArgumentException is expected.");
    } catch (IllegalArgumentException e) {
      // Ok.
    }
  }
}
