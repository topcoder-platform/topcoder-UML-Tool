/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.xmi.writer.transformers.model.failuretests;

import java.lang.reflect.Method;

import com.topcoder.xmi.writer.transformers.model.AttributeDescription;

import junit.framework.TestCase;

/**
 * Failure test for {@link AttributeDescription}.
 *
 * @author maone
 * @version 1.0
 */
public class AttributeDescriptionFailureTest extends TestCase {
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
  public void testAttributeDescription_NullName() {
    try {
      new AttributeDescription(null, method);
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
  public void testAttributeDescription_EmptyName() {
    try {
      new AttributeDescription("\t\n", method);
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
  public void testAttributeDescription_NullMethod() {
    try {
      new AttributeDescription(NAME, null);
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
  public void testAttributeDescription_InvalidMethod() throws Exception {
    method = String.class.getMethod("endsWith", new Class[]{String.class});

    try {
      new AttributeDescription(NAME, method);
      fail("Should throw IllegalArgumentException for invalid method.");
    } catch (IllegalArgumentException e) {
      // pass
    }
  }
}
