/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.xmi.writer.transformers.model.failuretests;

import java.util.HashMap;
import java.util.Map;

import com.topcoder.uml.model.modelmanagement.PackageImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.xmi.writer.TransformerType;
import com.topcoder.xmi.writer.XMITransformer;
import com.topcoder.xmi.writer.XMIWriter;
import com.topcoder.xmi.writer.transformers.model.ChildDescription;
import com.topcoder.xmi.writer.transformers.model.ConfigurationException;
import com.topcoder.xmi.writer.transformers.model.DuplicateElementException;
import com.topcoder.xmi.writer.transformers.model.Model2XMITransformer;
import com.topcoder.xmi.writer.transformers.model.UnknownElementTypeException;
import com.topcoder.xmi.writer.transformers.model.XMIDescription;
import com.topcoder.xmi.writer.transformers.model.XMIElementDescription;

import junit.framework.TestCase;

/**
 * Failure tests for {@link Model2XMITransformer};
 *
 * @author maone
 * @version 1.0
 */
public class Model2XMITransformerFailureTest extends TestCase {
  /**
   * A <code>Model2XMITransformer</code> instance to test against.
   */
  private Model2XMITransformer transformer;

  /**
   * A <code>MockXMIDescription</code> to be used in the <code>transformer</code>.
   * We can manipulate the element descriptions contained in it very easily.
   */
  private MockXMIDescription xmiDescription;

  /**
   * Set up.
   * Create the <code>xmiDescription</code> and <code>transformer</code> instance to test.
   *
   * @throws Exception to JUnit.
   */
  protected void setUp() throws Exception {
    super.setUp();

    xmiDescription = new MockXMIDescription();

    transformer = new Model2XMITransformer(xmiDescription, true);

    // create an XMIWriter, and set it to transformer
        Map <TransformerType, XMITransformer> map = new HashMap<TransformerType, XMITransformer>();
        map.put(TransformerType.Model, transformer);
        map.put(TransformerType.ActivityGraph, transformer);
        map.put(TransformerType.Diagram, transformer);

        XMIWriter writer = new XMIWriter(new UMLModelManager(), map);
        transformer.setXMIWriter(writer);
  }

  /**
   * Tear down.
   * Clear all the ConfigManager configurations.
   *
   * @throws Exception to JUnit.
   */
  protected void tearDown() throws Exception {
    super.tearDown();

    FailureTestUtil.clearAllConfigurations();
  }

  /**
   * Test constructor <code>Model2XMITransformer(XMIDescription, boolean)</code>
   * with a null XMIDescription param.
   * <p>
   * IllegalArgumentException should be thrown.
   * </p>
   */
  public void testConstructor_NullXMIDescription() {
    try {
      new Model2XMITransformer((XMIDescription) null, false);
      fail("Should throw IllegalArgumentException for null XMIDescription.");
    } catch (IllegalArgumentException e) {
      // pass
    }
  }

  /**
   * Test constructor <code>Model2XMITransformer(String)</code> with a null param.
   * <p>
   * IllegalArgumentException should be thrown.
   * </p>
   *
   * @throws Exception to JUnit.
   */
  public void testConstructor_NullNamespace() throws Exception {
    try {
      new Model2XMITransformer((String) null);
      fail("Should throw IllegalArgumentException for null namespace.");
    } catch (IllegalArgumentException e) {
      // pass
    }
  }

  /**
   * Test constructor <code>Model2XMITransformer(String)</code> with an empty param.
   * <p>
   * IllegalArgumentException should be thrown.
   * </p>
   *
   * @throws Exception to JUnit.
   */
  public void testConstructor_EmptyNamespace() throws Exception {
    try {
      new Model2XMITransformer("\t\n ");
      fail("Should throw IllegalArgumentException for empty namespace.");
    } catch (IllegalArgumentException e) {
      // pass
    }
  }

  /**
   * Test constructor <code>Model2XMITransformer(String)</code>
   * with an unknown namespace param.
   * <p>
   * ConfigurationException should be thrown.
   * </p>
   */
  public void testConstructor_UnknownNamespace() {
    try {
      new Model2XMITransformer("Top.Coder");
      fail("Should throw ConfigurationException for unknown namespace.");
    } catch (ConfigurationException e) {
      // pass
    }
  }

  /**
   * Test constructor <code>Model2XMITransformer(String)</code>
   * with a namespace, which misses a description name.
   * <p>
   * ConfigurationException should be thrown.
   * </p>
   *
   * @throws Exception to JUnit.
   */
  public void testConstructor_MissDescription() throws Exception {
    FailureTestUtil.loadConfig(FailureTestUtil.MISS_DESCRIPTION_CONFIG);

    try {
      new Model2XMITransformer(Model2XMITransformer.class.getName());
      fail("Should throw ConfigurationException" +
          " for a namespace missing description name.");
    } catch (ConfigurationException e) {
      // pass
    }
  }

  /**
   * Test constructor <code>Model2XMITransformer(String)</code>
   * with a namespace, which misses a ignoreUnknownElementType flag.
   * <p>
   * ConfigurationException should be thrown.
   * </p>
   *
   * @throws Exception to JUnit.
   */
  public void testConstructor_MissIgnoreFlag() throws Exception {
    FailureTestUtil.loadConfig(FailureTestUtil.MISS_IGNOREUNKNOWNELEMENTTYPE_CONFIG);

    try {
      new Model2XMITransformer(Model2XMITransformer.class.getName());
      fail("Should throw ConfigurationException" +
          " for a namespace missing ignoreUnknownElementType flag.");
    } catch (ConfigurationException e) {
      // pass
    }
  }

  /**
   * Test constructor <code>Model2XMITransformer(String)</code>
   * with a namespace, which misses an object factory namespace.
   * <p>
   * ConfigurationException should be thrown.
   * </p>
   *
   * @throws Exception to JUnit.
   */
  public void testConstructor_MissObjectFactory() throws Exception {
    FailureTestUtil.loadConfig(FailureTestUtil.MISS_OBJECTFACTORY_CONFIG);

    try {
      new Model2XMITransformer(Model2XMITransformer.class.getName());
      fail("Should throw ConfigurationException" +
          " for a namespace missing objectfactory namespace.");
    } catch (ConfigurationException e) {
      // pass
    }
  }

  /**
   * Test constructor <code>Model2XMITransformer(String)</code>
   * with a namespace, which contains a invalid description name.
   * <p>
   * ConfigurationException should be thrown.
   * </p>
   *
   * @throws Exception to JUnit.
   */
  public void testConstructor_InvalidDescription() throws Exception {
    FailureTestUtil.loadConfig(FailureTestUtil.INVALID_DESCRIPTION_CONFIG);

    try {
      new Model2XMITransformer(Model2XMITransformer.class.getName());
      fail("Should throw ConfigurationException" +
          " for a namespace containing invalid description name.");
    } catch (ConfigurationException e) {
      // pass
    }
  }


  /**
   * Test constructor <code>Model2XMITransformer(String)</code>
   * with a namespace, which contains an invalid objectfactory namespace.
   * <p>
   * ConfigurationException should be thrown.
   * </p>
   *
   * @throws Exception to JUnit.
   */
  public void testConstructor_InvalidObjectfactory() throws Exception {
    FailureTestUtil.loadConfig(FailureTestUtil.INVALID_OBJECTFACTORY_CONFIG);

    try {
      new Model2XMITransformer(Model2XMITransformer.class.getName());
      fail("Should throw ConfigurationException" +
          " for a namespace containing invalid objectfactory namespace.");
    } catch (ConfigurationException e) {
      // pass
    }
  }

  /**
   * Test <code>transform(Object, PrintStream)</code> with null Object param.
   * <p>
   * IllegalArgumentException should be thrown.
   * </p>
   *
   * @throws Exception to JUnit.
   */
  public void testTransform_NullObject() throws Exception {
    try {
      transformer.transform(null, System.out);
      fail("Should throw IllegalArgumentException for null element.");
    } catch (IllegalArgumentException e) {
      // pass
    }
  }

  /**
   * Test <code>transform(Object, PrintStream)</code> with null PrintStream param.
   * <p>
   * IllegalArgumentException should be thrown.
   * </p>
   *
   * @throws Exception to JUnit.
   */
  public void testTransform_NullPrintStream() throws Exception {
    try {
      transformer.transform(null, System.out);
      fail("Should throw IllegalArgumentException for null element.");
    } catch (IllegalArgumentException e) {
      // pass
    }
  }

  /**
   * Test <code>transform(Object, PrintStream)</code>
   * with an element whose type is unknown when the flag is false.
   * <p>
   * UnknownElementTypeException should be thrown.
   * </p>
   *
   * @throws Exception to JUnit.
   */
  public void testTransform_UnknownElementType() throws Exception {
    transformer.setIgnoreUnknownElementType(false);
    try {
      transformer.transform(xmiDescription, System.out);
      fail("Should throw UnknownElementTypeException for unknown elemen.");
    } catch (UnknownElementTypeException e) {
      // pass
    }
  }

  /**
   * Test <code>transform(Object, PrintStream)</code>
   * with duplicated element.
   * <p>
   * DuplicateElementException should be thrown.
   * </p>
   *
   * @throws Exception to JUnit.
   */
  public void testTransform_DuplicateElement() throws Exception {
    // build the desription of PackageImpl class
    XMIElementDescription packageDesc = new XMIElementDescription("UML:Package", PackageImpl.class);
    packageDesc.addChild(
        new ChildDescription("ownedElement",
            PackageImpl.class.getDeclaredMethod("getOwnedElements", new Class[0]),
            false));
    xmiDescription.addElementDescription(PackageImpl.class, packageDesc);

    // create a PackageImpl instance, and add itself as children.
    PackageImpl packageImpl = new PackageImpl();
    packageImpl.addOwnedElement(packageImpl);

    try {
      transformer.transform(packageImpl, System.out);
      fail("Should throw DuplicateElementException.");
    } catch (DuplicateElementException e) {
      // pass
    }
  }


}
