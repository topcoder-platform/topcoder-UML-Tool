/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.activity;

import java.util.List;


/**
 * <p>
 * This interface defines the nodes in the Activity Diagram. An ActivityNode is composed of
 * a list of incomming edges and a list of outgoing ones. This interface defines only the
 * methods to retrieve the incoming and outgoing edges, this being the minimal contract required
 * by a layered conversion framework for this element. It extends ZUML2TCUMLConvertible interface
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
public interface ZUMLActivityNode extends ZUML2TCUMLConvertible {
    /**
     * <p>Gets the list of the contained incoming edges for this node.</p>
     *
     * @return a list of the contained incoming edges
     */
    public List<ZUMLActivityEdge> getIncomingEdges();

    /**
     * <p>Gets the list of the contained outgoing edges for this node.</p>
     *
     * @return a list of the contained outgoing edges
     */
    public List<ZUMLActivityEdge> getOutgoingEdges();
}
