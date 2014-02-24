/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.activity.impl;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;

import com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLActivityEdge;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLActivityNode;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLOpaqueExpression;


/**
 * <p>
 * This abstract class implements the ZUMLActivityEdge interface and extends the ModelElementAbstractImpl class.
 * It defines the common methods of any type of ActivityEdge to lessen the implementation contract. It also
 * defines methods to set and get the source, target and guard of an ActivityEdge.
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
public abstract class AbstractZUMLActivityEdge extends ModelElementAbstractImpl
    implements ZUMLActivityEdge {
    /**
     * <p>
     * This field represents the activity node object that is the source of this activity edge.
     * Initialized with null in the constructor. It can be null immediately after initialization
     * but cannot be reset to null. It can be changed after initialization and accessed in
     * getSource(), changed in setSource().
     * </p>
     */
    private ZUMLActivityNode source;

    /**
     * <p>
     * This field represents the activity node object that is the target of this activity edge.
     * Initialized with null in the constructor. It can be null immediately after initialization
     * but cannot be reset to null. It can be changed after initialization and accessed in
     * getTarget(), changed in setTarget().
     * </p>
     */
    private ZUMLActivityNode target;

    /**
     * <p>
     * This field represents the OpaqueExpression object that is the guard element of this
     * activity edge. Initialized with null in the constructor. It can be null immediately
     * after initialization but cannot be reset to null. It can be changed after initialization
     * and accessed in getGuard(), changed in setGuard().
     * </p>
     */
    private ZUMLOpaqueExpression guard;

    /**
     * <p>Intializes the source, target and guard variables with default null values.</p>
     */
    protected AbstractZUMLActivityEdge() {
    }

    /**
     * <p>
     * Gets the ZUMLActivityNode object that represents the target of this Activity Edge.
     * </p>
     *
     * @return the ZUMLActivityNode object that represents the target of this Activity Edge.
     */
    public ZUMLActivityNode getTarget() {
        return target;
    }

    /**
     * <p>
     * Sets the target ZUMLActivityNode to the specified value.
     * </p>
     *
     * @param target the new ZUMLActivityNode target
     * @throws IllegalArgumentException if the argument is null
     */
    public void setTarget(ZUMLActivityNode target) {
        Helper.checkNull(target, "target");

        this.target = target;
    }

    /**
     * <p>
     * Gets the ZUMLActivityNode object that represents the source of this Activity Edge.
     * </p>
     *
     * @return the ZUMLActivityNode object that represents the source of this Activity Edge
     */
    public ZUMLActivityNode getSource() {
        return source;
    }

    /**
     * <p>
     * Sets the source ZUMLActivityNode to the specified value.
     * </p>
     *
     * @param source the new ZUMLActivityNode source
     * @throws IllegalArgumentException if the argument is null
     */
    public void setSource(ZUMLActivityNode source) {
        Helper.checkNull(source, "source");

        this.source = source;
    }

    /**
     * <p>
     * Gets the guard of this Activity Edge. A guard is an OpaqueExpression instance.
     * </p>
     *
     * @return the guard of this Activity Edge
     */
    public ZUMLOpaqueExpression getGuard() {
        return guard;
    }

    /**
     * <p>
     * Sets the guard of this edge to the specified value.
     * </p>
     *
     * @param guard the new ZUMLActivityNode Guard
     * @throws IllegalArgumentException if the argument is null
     */
    public void setGuard(ZUMLOpaqueExpression guard) {
        Helper.checkNull(guard, "guard");

        this.guard = guard;
    }

    /**
     * <p>
     * Abstract methods for converting the current activity diagram element to its tcuml
     * equivalent model representation. The returned object is a ModelElement instance which
     * means it can be used to construct a tcuml model.
     * </p>
     *
     * @return the equivalent tcuml ModelElement
     */
    public abstract ModelElement convertToTCUML();
}
