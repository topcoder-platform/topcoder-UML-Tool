/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.xmi.writer.transformers.model.failuretests;

import java.lang.reflect.Method;

import com.topcoder.xmi.writer.transformers.model.NodeDescription;
import com.topcoder.xmi.writer.transformers.model.NodeValueRetrievalException;

import junit.framework.TestCase;

/**
 * Failure test for {@link NodeDescription}.
 *
 * @author maone
 * @version 1.0
 */
public class NodeDescriptionFailureTest extends TestCase {
  /**
   * Represents the name of <code>description</code>.
   */
  private static final String NAME = "foo";

  /**
   * Represents the method of <code>description</code>.
   * It is initialized in <code>setUp()</code>.
   */
  private Method method = null;

  /**
   * Represents a <code>NodeDescription</code> instance to test against.
   * It is initialized in <code>setUp()</code>.
   */
  private NodeDescription description = null;

  /**
   * Set up.
   * Create the <code>method</code> and <code>description</code> instances.
   *
   * @throws Exception to JUnit.
   */
  protected void setUp() throws Exception {
    super.setUp();

    method = String.class.getDeclaredMethod("hashCode", new Class[0]);

    description = new NodeDescription(NAME, method) {};
  }

  /**
   * Tear down.
   *
   * @throws Exception to JUnit.
   */
  protected void tearDown() throws Exception {
    super.tearDown();
  }

  /**
   * Test constructor with null name param.
   * <p>
   * IllegalArgumentException should be thrown.
   * </p>
   */
  public void testNodeDescription_NullName() {
    try {
      new NodeDescription(null, method) {};
      fail("Should throw IllegalArgumentException for null name.");
    } catch (IllegalArgumentException e) {
      // pass
    }
  }


  /**
   * Test constructor with empty name param.
   * <p>
   * IllegalArgumentException should be thrown.
   * </p>
   */
  public void testNodeDescription_EmptyName() {
    try {
      new NodeDescription("\t\n", method) {};
      fail("Should throw IllegalArgumentException for empty name.");
    } catch (IllegalArgumentException e) {
      // pass
    }
  }

  /**
   * Test constructor with null method param.
   * <p>
   * IllegalArgumentException should be thrown.
   * </p>
   */
  public void testNodeDescription_NullMethod() {
    try {
      new NodeDescription(NAME, null) {};
      fail("Should throw IllegalArgumentException for null method.");
    } catch (IllegalArgumentException e) {
      // pass
    }
  }

  /**
   * Test constructor with an invalid method param, which takes some parameters.
   * <p>
   * IllegalArgumentException should be thrown.
   * </p>
   *
   * @throws Exception to JUnit
   */
  public void testNodeDescription_InvalidMethod() throws Exception {
    method = String.class.getDeclaredMethod("endsWith", new Class[]{String.class});

    try {
      new NodeDescription(NAME, method) {};
      fail("Should throw IllegalArgumentException for invalid method.");
    } catch (IllegalArgumentException e) {
      // pass
    }
  }

  /**
   * Test <code>getValue(Object)</code> with a null param.
   * <p>
   * IllegalArgumentException should be thrown.
   * </p>
   *
   * @throws Exception to JUnit
   */
  public void testGetValue_Null() throws Exception {
    try {
      description.getValue(null);
      fail("Should throw IllegalArgumentException for null param.");
    } catch (IllegalArgumentException e) {
      // pass
    }
  }

  /**
   * Test <code>getValue(Object)</code> with an invalid param,
   * which is not an instance of expected type.
   * <p>
   * NodeValueRetrievalException should be thrown.
   * </p>
   */
  public void testGetValue_Invalid() {
    try {
      description.getValue(new Integer(100));
      fail("Should throw NodeValueRetrievalException for invalid param.");
    } catch (NodeValueRetrievalException e) {
      // pass
    }
  }


}
