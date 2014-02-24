package com.topcoder.uml.model.statemachines.failuretests;

import java.util.ArrayList;
import java.util.Collection;

import com.topcoder.uml.model.statemachines.AbstractStateImpl;
import com.topcoder.uml.model.statemachines.CompositeState;
import com.topcoder.uml.model.statemachines.CompositeStateImpl;
import com.topcoder.uml.model.statemachines.StateMachine;
import com.topcoder.uml.model.statemachines.StateMachineImpl;
import com.topcoder.uml.model.statemachines.Transition;

import junit.framework.TestCase;

/**
 * Failure test cases for class <code>AbstractStateImpl</code>.
 *
 * @author Chenhong
 * @version 1.0
 *
 */
public class FailureTestAbstractStateImpl extends TestCase {

  /**
   * Represents the StateMachine instance for testing.
   */
  private static StateMachine stateMachine = new StateMachineImpl();

  /**
   * Represents the CompositeState instance for testing.
   */
  private static CompositeState compositeState = new CompositeStateImpl();

  /**
   * Failure test cases for constructor.
   *
   * <p>
   * IllegalArgumentException should be raised if the collection arguments are null or contains null.
   * </p>
   *
   */
  public void testAbstractStateImplCompositeStateCollectionOfTransitionCollectionOfTransitionStateMachine_1() {
    Collection<Transition> outGoing = new ArrayList<Transition>();

    try {
      new MyAbstractStateImpl(compositeState, outGoing, null, stateMachine);
      fail("IllegalArgumentException is expected.");
    } catch (IllegalArgumentException e) {
      // Ok.
    }
  }


  /**
   * Failure test cases for constructor.
   *
   * <p>
   * IllegalArgumentException should be raised if the collection arguments are null or contains null.
   * </p>
   *
   */
  public void testAbstractStateImplCompositeStateCollectionOfTransitionCollectionOfTransitionStateMachine_2() {
    Collection<Transition> outGoing = new ArrayList<Transition>();

    Collection<Transition> inComing = new ArrayList<Transition>();

    inComing.add(null);

    try {
      new MyAbstractStateImpl(compositeState, outGoing, inComing, stateMachine);
      fail("IllegalArgumentException is expected.");
    } catch (IllegalArgumentException e) {
      // Ok.
    }
  }

  /**
   * Failure test cases for constructor.
   *
   * <p>
   * IllegalArgumentException should be raised if the collection arguments are null or contains null.
   * </p>
   *
   */
  public void testAbstractStateImplCompositeStateCollectionOfTransitionCollectionOfTransitionStateMachine_3() {
    Collection<Transition> inComing = new ArrayList<Transition>();

    inComing.add(null);

    try {
      new MyAbstractStateImpl(compositeState, null, inComing, stateMachine);
      fail("IllegalArgumentException is expected.");
    } catch (IllegalArgumentException e) {
      // Ok.
    }
  }


  /**
   * Failure test cases for constructor.
   *
   * <p>
   * IllegalArgumentException should be raised if the collection arguments are null or contains null.
   * </p>
   *
   */
  public void testAbstractStateImplCompositeStateCollectionOfTransitionCollectionOfTransitionStateMachine_4() {
    Collection<Transition> outGoing = new ArrayList<Transition>();
    outGoing.add(null);

    Collection<Transition> inComing = new ArrayList<Transition>();

    inComing.add(null);

    try {
      new MyAbstractStateImpl(compositeState, outGoing, inComing, stateMachine);
      fail("IllegalArgumentException is expected.");
    } catch (IllegalArgumentException e) {
      // Ok.
    }
  }

  /**
   * Test method <code>void setStateMachine(StateMachine stateMachine) </code>.
   *
   * <p>
   * Null can be allowed.
   * </p>
   *
   */
  public void testSetStateMachine() {
    Collection<Transition> outGoing = new ArrayList<Transition>();

    Collection<Transition> inComing = new ArrayList<Transition>();

    new MyAbstractStateImpl(compositeState, outGoing, inComing, stateMachine).setStateMachine(null);
  }

  /**
   * Create a concrete class for testing.
   *
   */
  class MyAbstractStateImpl extends AbstractStateImpl {

      /**
       * <p>
       * Creates an instance of this class by initializing the fields using the given arguments.
       * </p>
       *
       * @param container the composite state that contains this state
       * @param outgoingTransitions a collection of outgoing transitions
       * @param incomingTransitions a collection of incoming transitions
       * @param stateMachine state machine which contains this state
       * @throws IllegalArgumentException if any of the collection arguments are null or contains null
       */
    public MyAbstractStateImpl(CompositeState container,
        Collection<Transition> outgoingTransitions,
        Collection<Transition> incomingTransitions,
        StateMachine stateMachine) {
      super(container, outgoingTransitions, incomingTransitions,
          stateMachine);
    }

  }
}
