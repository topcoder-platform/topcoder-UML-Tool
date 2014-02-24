/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.xmi.writer.transformers.model.failuretests;

import java.util.HashMap;
import java.util.Map;

import com.topcoder.xmi.writer.transformers.model.XMIDescription;
import com.topcoder.xmi.writer.transformers.model.XMIElementDescription;

/**
 * A mock implementation of {@link XMIDescription} interface.
 * This class is provided for convenience of failure tests.
 * <p>
 * Initially, it contains no XMI element descriptions.
 * And it provides method to add/remove/get element description.
 * </p>
 *
 * @author maone
 * @version 1.0
 */
public class MockXMIDescription implements XMIDescription {
  /**
   * A map containing [type, description] mappings.
   * It is initialized in constructor, and can be changed later.
   */
  private final Map<Class, XMIElementDescription> elements;

  /**
   * Constructor.
   */
  public MockXMIDescription() {
    elements = new HashMap<Class, XMIElementDescription>();
  }

  /**
   * Get description for specific type.
   *
   * @param type the element type
   * @return description of the type
   */
  public XMIElementDescription getXMIElementDescription(Class type) {
    return elements.get(type);
  }

  /**
   * Add a [type, description] pair.
   *
   * @param type the element type
   * @param elementDesc the XMI description for given type
   */
  public void addElementDescription(Class type, XMIElementDescription elementDesc) {
    elements.put(type, elementDesc);
  }

  /**
   * Remove description for the specific type.
   *
   * @param type the element type.
   */
  public void removeElementDescrption(Class type) {
    elements.remove(type);
  }
}
