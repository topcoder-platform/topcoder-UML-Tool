/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.activity;

import com.topcoder.uml.model.core.ModelElement;


/**
 * <p>
 * An interface that defines the generic convertToTCUML() method. Every concrete class that
 * represents an uml 2.0 model element and implements this interface defines its custom
 * conversion algorithm. It extends the ModelElement which permits the use of the elements
 * defined in this design in tcuml internal model.
 * </p>
 *
 * <p>
 * <strong>Thread safety:</strong>
 * Implementations of this interface are not required to be thread safe.
 * </p>
 *
 * @author Rica, zhengjuyu
 * @version 1.0
 */
public interface ZUML2TCUMLConvertible extends ModelElement {
    /**
     * <p>
     * Converts the given element to its tcuml equivalent model representation. The returned
     * object is a ModelElement instance which means it can be used to construct a tcuml model.
     * </p>
     *
     * <p>
     * This method will always return the same instance of converted element. This will
     * prevent there are many converted elements in the diagram of one original element.
     * </p>
     *
     * @return the equivalent tcuml ModelElement
     */
    public ModelElement convertToTCUML();
}
