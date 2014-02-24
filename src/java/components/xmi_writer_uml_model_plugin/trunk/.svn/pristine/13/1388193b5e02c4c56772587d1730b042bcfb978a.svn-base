/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.xmi.writer.transformers.model.failuretests;

import java.lang.reflect.Method;

import com.topcoder.xmi.writer.transformers.model.AttributeDescription;
import com.topcoder.xmi.writer.transformers.model.ChildDescription;
import com.topcoder.xmi.writer.transformers.model.XMIElementDescription;

import junit.framework.TestCase;

/**
 * Failure test for {@link XMIElementDescription};
 *
 * @author maone
 * @version 1.0
 */
public class XMIElementDescriptionFailureTest extends TestCase {

  /**
   * An <code>XMIElementDescription</code> instance to test against.
   * It is intialized in <code>setUp</code>,
   * and contains two attributes and two children initially.
   */
  private XMIElementDescription description = null;

  /**
   * A dummy <code>Method</code> instance for the convenience of test.
   */
  private Method dummy = null;

  /**
   * Set up.
   * Initialize <code>description</code>.
   *
   * @throws Exception to JUnit.
   */
  protected void setUp() throws Exception {
    super.setUp();

    description = new XMIElementDescription("UML:String", String.class);

    dummy = String.class.getDeclaredMethod("hashCode", new Class[0]);
    description.addAttribute(new AttributeDescription("attr1", dummy));
    description.addAttribute(new AttributeDescription("attr2", dummy));
    description.addChild(new ChildDescription("child1", dummy, true));
    description.addChild(new ChildDescription("child2", dummy, false));
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
  public void testXMIElementDescription_NullName() {
    try {
      new XMIElementDescription(null, String.class);
      fail("IllegalArgumentException should be thrown for null name.");
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
  public void testXMIElementDescription_EmptyName() {
    try {
      new XMIElementDescription("\n\t", String.class);
      fail("IllegalArgumentException should be thrown for empty name.");
    } catch (IllegalArgumentException e) {
      // pass
    }
  }

  /**
   * Test constructor with null element type param.
   * <p>
   * IllegalArgumentException should be thrown.
   * </p>
   */
  public void testXMIElementDescription_NullType() {
    try {
      new XMIElementDescription("UML0:String", null);
      fail("IllegalArgumentException should be thrown for null type.");
    } catch (IllegalArgumentException e) {
      // pass
    }
  }

  /**
   * Test <code>addAttribute(AttributeDescription)</code> with null attribute.
   * <p>
   * IllegalArgumentException should be thrown.
   * </p>
   */
  public void testAddAttribute1_NullAttribute() {
    try {
      description.addAttribute(null);
      fail("Should throw IllegalArgumentException for null attribute.");
    } catch (IllegalArgumentException e) {
      // pass
    }
  }

  /**
   * Test <code>addAttribute(int, AttributeDescription)</code> with null attribute.
   * <p>
   * IllegalArgumentException should be thrown.
   * </p>
   */
  public void testAddAttribute2_NullAttribute() {
    try {
      description.addAttribute(1, null);
      fail("Should throw IllegalArgumentException for null attribute.");
    } catch (IllegalArgumentException e) {
      // pass
    }
  }

  /**
   * Test <code>addAttribute(int, AttributeDescription)</code> with too small index value.
   * <p>
   * IndexOutOfBoundsException should be thrown.
   * </p>
   */
  public void testAddAttribute2_SmallIndex() {
    try {
      description.addAttribute(-1, new AttributeDescription("attr", dummy));
      fail("Should throw IndexOutOfBoundsException for too small index.");
    } catch (IndexOutOfBoundsException e) {
      // pass
    }
  }

  /**
   * Test <code>addAttribute(int, AttributeDescription)</code> with too big index value.
   * <p>
   * IndexOutOfBoundsException should be thrown.
   * </p>
   */
  public void testAddAttribute2_BigIndex() {
    try {
      description.addAttribute(3, new AttributeDescription("attr", dummy));
      fail("Should throw IndexOutOfBoundsException for too big index.");
    } catch (IndexOutOfBoundsException e) {
      // pass
    }
  }


  /**
   * Test <code>removeAttribute(AttributeDescription)</code> with null attribute.
   * <p>
   * IllegalArgumentException should be thrown.
   * </p>
   */
  public void testRemoveAttribute_NullAttribute() {
    try {
      description.removeAttribute(null);
      fail("Should throw IllegalArgumentException for null attribute.");
    } catch (IllegalArgumentException e) {
      // pass
    }
  }

  /**
   * Test <code>removeAttribute(int)</code> with too small index value.
   * <p>
   * IndexOutOfBoundsException should be thrown.
   * </p>
   */
  public void testRemoveAttribute2_SmallIndex() {
    try {
      description.removeAttribute(-1);
      fail("Should throw IndexOutOfBoundsException for too small index.");
    } catch (IndexOutOfBoundsException e) {
      // pass
    }
  }

  /**
   * Test <code>removeAttribute(int)</code> with too big index value.
   * <p>
   * IndexOutOfBoundsException should be thrown.
   * </p>
   */
  public void testRemoveAttribute2_BigIndex() {
    try {
      description.removeAttribute(2);
      fail("Should throw IndexOutOfBoundsException for too big index.");
    } catch (IndexOutOfBoundsException e) {
      // pass
    }
  }


  /**
   * Test <code>addChild(ChildDescription)</code> with null attribute.
   * <p>
   * IllegalArgumentException should be thrown.
   * </p>
   */
  public void testAddChild1_NullChild() {
    try {
      description.addChild(null);
      fail("Should throw IllegalArgumentException for null attribute.");
    } catch (IllegalArgumentException e) {
      // pass
    }
  }

  /**
   * Test <code>addChild(int, ChildDescription)</code> with null attribute.
   * <p>
   * IllegalArgumentException should be thrown.
   * </p>
   */
  public void testAddChild2_NullChild() {
    try {
      description.addChild(1, null);
      fail("Should throw IllegalArgumentException for null attribute.");
    } catch (IllegalArgumentException e) {
      // pass
    }
  }

  /**
   * Test <code>addChild(int, ChildDescription)</code> with too small index value.
   * <p>
   * IndexOutOfBoundsException should be thrown.
   * </p>
   */
  public void testAddChild2_SmallIndex() {
    try {
      description.addChild(-1, new ChildDescription("child", dummy, true));
      fail("Should throw IndexOutOfBoundsException for too small index.");
    } catch (IndexOutOfBoundsException e) {
      // pass
    }
  }

  /**
   * Test <code>addChild(int, ChildDescription)</code> with too big index value.
   * <p>
   * IndexOutOfBoundsException should be thrown.
   * </p>
   */
  public void testAddChild2_BigIndex() {
    try {
      description.addChild(3, new ChildDescription("child", dummy, false));
      fail("Should throw IndexOutOfBoundsException for too big index.");
    } catch (IndexOutOfBoundsException e) {
      // pass
    }
  }


  /**
   * Test <code>removeChild(ChildDescription)</code> with null attribute.
   * <p>
   * IllegalArgumentException should be thrown.
   * </p>
   */
  public void testRemoveChild_NullChild() {
    try {
      description.removeChild(null);
      fail("Should throw IllegalArgumentException for null attribute.");
    } catch (IllegalArgumentException e) {
      // pass
    }
  }

  /**
   * Test <code>removeChild(int)</code> with too small index value.
   * <p>
   * IndexOutOfBoundsException should be thrown.
   * </p>
   */
  public void testRemoveChild2_SmallIndex() {
    try {
      description.removeChild(-1);
      fail("Should throw IndexOutOfBoundsException for too small index.");
    } catch (IndexOutOfBoundsException e) {
      // pass
    }
  }

  /**
   * Test <code>removeChild(int)</code> with too big index value.
   * <p>
   * IndexOutOfBoundsException should be thrown.
   * </p>
   */
  public void testRemoveChild2_BigIndex() {
    try {
      description.removeChild(2);
      fail("Should throw IndexOutOfBoundsException for too big index.");
    } catch (IndexOutOfBoundsException e) {
      // pass
    }
  }
}
