/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.xmi.writer.transformers.model.failuretests;

import java.lang.reflect.Method;

import com.topcoder.xmi.writer.transformers.model.ChildDescription;

import junit.framework.TestCase;

/**
 * Failure test for {@link ChildDescription}.
 *
 * @author maone
 * @version 1.0
 */
public class ChildDescriptionFailureTest extends TestCase {
  /**
   * Represents the name of <code>description</code>.
   */
  private static final String NAME = "foo";

  /**
   * Represents a method which takes no parameter.
   * It is initialized in <code>setUp()</code>.
   */
  private Method method = null;

  /**
   * Set up.
   * Create the <code>method</code> instances.
   *
   * @throws Exception to JUnit.
   */
  protected void setUp() throws Exception {
    super.setUp();

    method = String.class.getDeclaredMethod("hashCode", new Class[0]);
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
  public void testChildDescription_NullName() {
    try {
      new ChildDescription(null, method, false);
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
  public void testChildDescription_EmptyName() {
    try {
      new ChildDescription("\t\n", method, true);
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
  public void testChildDescription_NullMethod() {
    try {
      new ChildDescription(NAME, null, false);
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
  public void testChildDescription_InvalidMethod() throws Exception {
    method = String.class.getDeclaredMethod("endsWith", new Class[]{String.class});

    try {
      new ChildDescription(NAME, method, true);
      fail("Should throw IllegalArgumentException for invalid method.");
    } catch (IllegalArgumentException e) {
      // pass
    }
  }
}
