/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.activity;


/**
 * <p>
 * This interface defines the edges in the Activity Diagram. An ActivityEdge is composed of
 * a source, a target and a guard that describes the edge. This interface defines only methods
 * to retrieve the three constituent elements, this being the minimal contract required by
 * a layered conversion framework for this element. It extends ZUML2TCUMLConvertible interface
 * to allow implementations to be converted in the same way.
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
public interface ZUMLActivityEdge extends ZUML2TCUMLConvertible {
    /**
     * <p>
     * Gets the ZUMLActivityNode object that represents the source of this Activity Edge.
     * </p>
     *
     * @return the ZUMLActivityNode object that represents the source of this Activity Edge
     */
    public ZUMLActivityNode getSource();

    /**
     * <p>
     * Gets the ZUMLActivityNode object that represents the target of this Activity Edge.
     * </p>
     *
     * @return the ZUMLActivityNode object that represents the target of this Activity Edge.
     */
    public ZUMLActivityNode getTarget();

    /**
     * <p>
     * Gets the guard of this Activity Edge. A guard is an OpaqueExpression instance.
     * </p>
     *
     * @return the guard of this Activity Edge
     */
    public ZUMLOpaqueExpression getGuard();
}
