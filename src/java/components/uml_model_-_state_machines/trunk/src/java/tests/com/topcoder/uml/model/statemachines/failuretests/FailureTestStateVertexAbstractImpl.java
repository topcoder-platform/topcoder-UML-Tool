package com.topcoder.uml.model.statemachines.failuretests;

import java.util.ArrayList;
import java.util.Collection;

import com.topcoder.uml.model.statemachines.CompositeState;
import com.topcoder.uml.model.statemachines.CompositeStateImpl;
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.uml.model.statemachines.StateVertexAbstractImpl;

import junit.framework.TestCase;

/**
 * Failure test cases for class <code>StateVertexAbstractImpl </code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class FailureTestStateVertexAbstractImpl extends TestCase {

  /**
   * Represents the CompositeState instance for testing.
   */
  private static CompositeState compositeState = new CompositeStateImpl();

  /**
   * Test the constructor.
   *
   */
  public void testConstructor_1() {
    Collection<Transition> outgoing = new ArrayList<Transition>();

    try {
      new  MyStateVertexAbstractImpl(compositeState, outgoing, null);
      fail("IllegalArgumentException is expected.");
    } catch (IllegalArgumentException e) {
      // Ok.
    }
  }

  /**
   * Test the constructor.
   *
   */
  public void testConstructor_2() {
    Collection<Transition> outgoing = new ArrayList<Transition>();

    Collection<Transition> inComing = new ArrayList<Transition>();
    inComing.add(null);

    try {
      new  MyStateVertexAbstractImpl(compositeState, outgoing, inComing);
      fail("IllegalArgumentException is expected.");
    } catch (IllegalArgumentException e) {
      // Ok.
    }
  }


  /**
   * Test the constructor.
   *
   */
  public void testConstructor_3() {
    Collection<Transition> inComing = new ArrayList<Transition>();

    try {
      new  MyStateVertexAbstractImpl(compositeState, null, inComing);
      fail("IllegalArgumentException is expected.");
    } catch (IllegalArgumentException e) {
      // Ok.
    }
  }


  /**
   * Test the constructor.
   *
   */
  public void testConstructor_4() {
    Collection<Transition> outgoing = new ArrayList<Transition>();
    outgoing.add(null);

    Collection<Transition> inComing = new ArrayList<Transition>();


    try {
      new  MyStateVertexAbstractImpl(compositeState, outgoing, inComing);
      fail("IllegalArgumentException is expected.");
    } catch (IllegalArgumentException e) {
      // Ok.
    }
  }

  /**
   * Test method <code>void addOutgoingTransition(Transition outgoingTransition) </code>.
   *
   */
  public void testAddOutgoingTransition() {
    Collection<Transition> outgoing = new ArrayList<Transition>();

    Collection<Transition> inComing = new ArrayList<Transition>();

    MyStateVertexAbstractImpl t = new MyStateVertexAbstractImpl(compositeState, outgoing, inComing);

    try {
      t.addOutgoingTransition(null);
      fail("IllegalArgumentException is expected.");
    } catch (IllegalArgumentException e) {
      // Ok.
    }
  }

  /**
   * Test method <code>void removeOutgoingTransition(Transition outgoingTransition) </code>.
   *
   */
  public void testRemoveOutgoingTransition() {
    Collection<Transition> outgoing = new ArrayList<Transition>();

    Collection<Transition> inComing = new ArrayList<Transition>();

    MyStateVertexAbstractImpl t = new MyStateVertexAbstractImpl(compositeState, outgoing, inComing);

    try {
      t.removeOutgoingTransition(null);
      fail("IllegalArgumentException is expected.");
    } catch (IllegalArgumentException e) {
      // Ok.
    }
  }


  /**
   * Test method <code>void containsOutgoingTransition(Transition outgoingTransition) </code>.
   *
   */
  public void testContainsOutgoingTransition() {
    Collection<Transition> outgoing = new ArrayList<Transition>();

    Collection<Transition> inComing = new ArrayList<Transition>();

    MyStateVertexAbstractImpl t = new MyStateVertexAbstractImpl(compositeState, outgoing, inComing);

    try {
      t.containsOutgoingTransition(null);
      fail("IllegalArgumentException is expected.");
    } catch (IllegalArgumentException e) {
      // Ok.
    }
  }


  /**
   * Test method <code>void addIncomingTransition(Transition outgoingTransition) </code>.
   *
   */
  public void testAddIncomingTransition() {
    Collection<Transition> outgoing = new ArrayList<Transition>();

    Collection<Transition> inComing = new ArrayList<Transition>();

    MyStateVertexAbstractImpl t = new MyStateVertexAbstractImpl(compositeState, outgoing, inComing);

    try {
      t.addIncomingTransition(null);
      fail("IllegalArgumentException is expected.");
    } catch (IllegalArgumentException e) {
      // Ok.
    }
  }


  /**
   * Test method <code>void removeIncomingTransition(Transition outgoingTransition) </code>.
   *
   */
  public void testRemoveIncomingTransition() {
    Collection<Transition> outgoing = new ArrayList<Transition>();

    Collection<Transition> inComing = new ArrayList<Transition>();

    MyStateVertexAbstractImpl t = new MyStateVertexAbstractImpl(compositeState, outgoing, inComing);

    try {
      t.removeIncomingTransition(null);
      fail("IllegalArgumentException is expected.");
    } catch (IllegalArgumentException e) {
      // Ok.
    }
  }


  /**
   * Test method <code>void containsIncomingTransition(Transition outgoingTransition) </code>.
   *
   */
  public void testContainsIncomingTransition() {
    Collection<Transition> outgoing = new ArrayList<Transition>();

    Collection<Transition> inComing = new ArrayList<Transition>();

    MyStateVertexAbstractImpl t = new MyStateVertexAbstractImpl(compositeState, outgoing, inComing);

    try {
      t.containsIncomingTransition(null);
      fail("IllegalArgumentException is expected.");
    } catch (IllegalArgumentException e) {
      // Ok.
    }
  }

  /**
   * Create a concrete class for testing.
   *
   */
  class MyStateVertexAbstractImpl extends StateVertexAbstractImpl {

      /**
       * <p>
       * Creates an instance of this class by initializing the fields using the given arguments.
       * </p>
       *
       * @param container the composite state that contains this state
       * @param outgoingTransitions a collection of outgoing transitions
       * @param incomingTransitions a collection of incoming transitions
       * @throws IllegalArgumentException if any of the collection arguments are null or contains null
       */
    public MyStateVertexAbstractImpl(CompositeState container,
        Collection<Transition> outgoingTransitions,
        Collection<Transition> incomingTransitions) {
      super(container, outgoingTransitions, incomingTransitions);
    }
  }
}
