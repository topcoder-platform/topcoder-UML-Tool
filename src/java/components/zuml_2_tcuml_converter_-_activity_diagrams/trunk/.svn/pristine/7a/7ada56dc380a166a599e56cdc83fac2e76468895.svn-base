/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.activity;

import java.util.List;


/**
 * <p>
 * This interface defines an uml 2.0 ActivityDiagram from a conceptual point of view with the
 * least demanding interface contract. In this context, a ZUMLActivityDiagram is a collection
 * of nodes and edges defined in an activity diagram. This interface defines only methods to
 * retrieve the edges and nodes, this being the minimal contract required by a layered conversion
 * framework for this element. It extends ZUML2TCUMLConvertible interface to allow implementations
 * to be converted in the same way.
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
public interface ZUMLActivityDiagram extends ZUML2TCUMLConvertible {
    /**
     * <p>Gets the list of diagram nodes in this diagram.</p>
     *
     * @return a list of the contained activity diagram nodes
     */
    public List<ZUMLActivityNode> getNodes();

    /**
     * <p>Gets the list of diagram edges in this diagram.</p>
     *
     * @return a list of the contained activity diagram edges
     */
    public List<ZUMLActivityEdge> getEdges();
}
