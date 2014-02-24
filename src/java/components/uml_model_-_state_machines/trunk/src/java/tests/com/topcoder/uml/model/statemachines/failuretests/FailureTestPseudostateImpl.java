/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.statemachines.failuretests;

import java.util.ArrayList;
import java.util.Collection;

import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.statemachines.CompositeState;
import com.topcoder.uml.model.statemachines.CompositeStateImpl;
import com.topcoder.uml.model.statemachines.PseudostateImpl;
import com.topcoder.uml.model.statemachines.Transition;

import junit.framework.TestCase;

/**
 * Failure test cases for class <code>PseudostateImpl</code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class FailureTestPseudostateImpl extends TestCase {

  /**
   * Represents the CompositeState instance for testing.
   */
  private static CompositeState compositeState = new CompositeStateImpl();


  /**
   * Test the constructor.
   *
   */
  public void testPseudostateImpl_1() {
    Collection<Transition> outgoing = new ArrayList<Transition>();
    try {
      new PseudostateImpl(compositeState, outgoing, null,  PseudostateKind.CHOICE);
      fail("IllegalArgumentException is expected.");
    } catch (IllegalArgumentException e) {
      // Ok.
    }
  }


  /**
   * Test the constructor.
   *
   */
  public void testPseudostateImpl_2() {
    Collection<Transition> incoming = new ArrayList<Transition>();

    try {
      new PseudostateImpl(compositeState, null, incoming, PseudostateKind.CHOICE);
      fail("IllegalArgumentException is expected.");
    } catch (IllegalArgumentException e) {
      // Ok.
    }
  }


  /**
   * Test the constructor.
   *
   */
  public void testPseudostateImpl_3() {
    Collection<Transition> outgoing = new ArrayList<Transition>();

    Collection<Transition> incoming = new ArrayList<Transition>();
    incoming.add(null);

    try {
      new PseudostateImpl(compositeState, outgoing, incoming, PseudostateKind.CHOICE);
      fail("IllegalArgumentException is expected.");
    } catch (IllegalArgumentException e) {
      // Ok.
    }
  }


  /**
   * Test the constructor.
   *
   */
  public void testPseudostateImpl_4() {
    Collection<Transition> outgoing = new ArrayList<Transition>();
    outgoing.add(null);

    Collection<Transition> incoming = new ArrayList<Transition>();

    try {
      new PseudostateImpl(compositeState, outgoing, incoming, PseudostateKind.CHOICE);
      fail("IllegalArgumentException is expected.");
    } catch (IllegalArgumentException e) {
      // Ok.
    }
  }
}
