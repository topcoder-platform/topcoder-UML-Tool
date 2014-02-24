/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.activity.impl;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.statemachines.SimpleState;
import com.topcoder.uml.model.statemachines.SimpleStateImpl;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLOpaqueExpression;


/**
 * <p>
 * This class represents an UML2:PinNode element. It will be used by the XMI Reader and
 * its plugins to create an object representation of the read zuml data. It implements
 * the convertToTCUML() method returning the converted tcuml object that can be used in
 * the internal uml tool model.
 * </p>
 *
 * <p>
 * In order to prevent there are many converted instances of one element, the convertTCUML()
 * will always return the same instance.
 * </p>
 *
 * <p>
 * <strong>Thread safety:</strong>
 * This class is mutable and not thread safe.
 * </p>
 *
 * @author Rica, zhengjuyu
 * @version 1.0
 */
public class ZUMLPinNodeImpl extends AbstractZUMLActivityNode {
    /**
     * <p>The data value of PinNode's taggedValue.</p>
     */
    private static final String DATAVALUE = "ObjectFlowStateNode";

    /**
     * <p>The tagType of PinNode.</p>
     */
    private static final String PINNODE = "ObjectFlowStateType";

    /**
     * <p>Serial version uid for the Serializable class.</p>
     */
    private static final long serialVersionUID = -883549495144024472L;

    /**
     * <p>
     * This field represents the converted instance of this element. If it
     * is not null, it will be returned directly in the convertToTCUML(). This
     * will prevents one element being converted many times.
     * </p>
     */
    private SimpleState transformed;

    /**
     * <p>
     * This field represents the OpaqueExpression object that is the upperBound element
     * of this PinNdoe implementation. It can be null immediately after initialization
     * but cannot be reset to null. It can be changed after initialization and accessed
     * in getGuard(), changed in setGuard().
     * </p>
     */
    private ZUMLOpaqueExpression upperBound;

    /**
     * <p>Empty constructor. Call super() default constructor.</p>
     */
    public ZUMLPinNodeImpl() {
        super();
    }

    /**
     * <p>
     * Sets a new ZUMLOpaqueExpression upperBound.
     * </p>
     *
     * @param bound the ZUMLOpaqueExpression representing the new upperBound
     * @throws IllegalArgumentException if the argument is null
     */
    public void setUpperBound(ZUMLOpaqueExpression bound) {
        Helper.checkNull(bound, "bound");

        this.upperBound = bound;
    }

    /**
     * <p>
     * Gets the upperBound opaque expression of this joinNode implementation.
     * </p>
     *
     * @return the upperBound OpaqueExpression
     */
    public ZUMLOpaqueExpression getUpperBound() {
        return upperBound;
    }

    /**
     * <p>
     * This method converts the current ZUMLPinNodeImpl representation of an UML2:Pin
     * zuml element into the equivalent tcuml instance.
     * </p>
     *
     * <p>
     * This method will always return the same instance of converted element. This will
     * prevent there are many converted elements in the diagram of one original element.
     * </p>
     *
     * @return the equivalent tcuml ModelElement
     */
    public ModelElement convertToTCUML() {
        if (transformed == null) {
            transformed = new SimpleStateImpl();
            Helper.initializeState(this, transformed, DATAVALUE, PINNODE);
        }

        return transformed;
    }
}
