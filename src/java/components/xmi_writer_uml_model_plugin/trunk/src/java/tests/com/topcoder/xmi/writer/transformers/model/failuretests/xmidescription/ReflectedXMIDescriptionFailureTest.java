/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.xmi.writer.transformers.model.failuretests.xmidescription;

import com.topcoder.xmi.writer.transformers.model.ConfigurationException;
import com.topcoder.xmi.writer.transformers.model.failuretests.FailureTestUtil;
import com.topcoder.xmi.writer.transformers.model.xmidescription.ReflectedXMIDescription;

import junit.framework.TestCase;

/**
 * Failure test for {@link ReflectedXMIDescription}.
 *
 * @author maone
 * @version 1.0
 */
public class ReflectedXMIDescriptionFailureTest extends TestCase {
  /**
   * A <code>ReflectedXMIDescription</code> instance to test against.
   * It is initilized in constructor.
   */
  private ReflectedXMIDescription description = null;

  /**
   * Set up.
   * Load configuration and create the <code>description</code> instance to test.
   *
   * @throws Exception to JUnit.
   */
  protected void setUp() throws Exception {
    super.setUp();

    FailureTestUtil.loadConfig(FailureTestUtil.VALID_CONFIG);
    description = new ReflectedXMIDescription(ReflectedXMIDescription.class.getName());
  }

  /**
   * Tear down.
   * Clear the configuration.
   *
   * @throws Exception to JUnit.
   */
  protected void tearDown() throws Exception {
    FailureTestUtil.clearAllConfigurations();

    super.tearDown();
  }

  /**
   * Test constructor with null namespace param.
   * <p>
   * IllegalArgumentException should be thrown.
   * </p>
   *
   * @throws Exception to JUnit.
   */
  public void testReflectedXMIDescription_Null() throws Exception {
    try {
      new ReflectedXMIDescription(null);
      fail("Should throw IllegalArgumentException for null namespace.");
    } catch (IllegalArgumentException e) {
      // pass
    }
  }

  /**
   * Test constructor with an empty namespace param.
   * <p>
   * IllegalArgumentException should be thrown.
   * </p>
   *
   * @throws Exception to JUnit.
   */
  public void testReflectedXMIDescription_Empty() throws Exception {
    try {
      new ReflectedXMIDescription("\t\n");
      fail("Should throw IllegalArgumentException for empty namespace.");
    } catch (IllegalArgumentException e) {
      // pass
    }
  }

  /**
   * Test constructor with unknown namespace param.
   * <p>
   * ConfigurationException should be thrown.
   * </p>
   */
  public void testReflectedXMIDescription_UnknownNamespace() {
    try {
      new ReflectedXMIDescription("NoSuchNamespace");
      fail("Should throw ConfigurationException for namespace.");
    } catch (ConfigurationException e) {
      // pass
    }
  }

  /**
   * Test <code>getXMIElementDescription(Class)</code> with a null param.s
   * <p>
   * IllegalArgumentException should be thrown.
   * </p>
   *
   * @throws Exception to JUnit.
   */
  public void testGetXMIElementDescription() throws Exception {
    try {
      description.getXMIElementDescription((Class) null);
      fail("Should throw IllegalArgumentException for null type.");
    } catch (IllegalArgumentException e) {
      // pass
    }
  }

}
