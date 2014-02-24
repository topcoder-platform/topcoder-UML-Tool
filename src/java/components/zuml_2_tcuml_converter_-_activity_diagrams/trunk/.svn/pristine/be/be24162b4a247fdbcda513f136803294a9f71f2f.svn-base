/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.activity.impl;

import com.topcoder.uml.model.activitygraphs.ActivityGraphImpl;
import com.topcoder.uml.model.core.ModelElement;

import com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLActivityDiagram;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLActivityEdge;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLActivityNode;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>
 * This abstract class implements the ZUMLActivityDiagram interface and extends the ActivityGraphImpl class.
 * It defines the common methods of any type of ZUMLActivityDiagram to lessen the implementation contract.
 * It also defines methods to manage the nodes and the edges of an Activity Diagram instance.
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
public abstract class AbstractZUMLActivityDiagram extends ActivityGraphImpl
    implements ZUMLActivityDiagram {
    /**
     * <p>
     * The list of nodes contained by this ActivityDiagram instance. Initialized in the
     * constructor with an empty ArrayList and never changed after that. It cannot be null and
     * cannot contain null elements. It can be empty after creation or if the model has
     * no such elements. It's used in getNodes(), addNode(), addNodes(), removeNode() and
     * clearNodes().
     * </p>
     */
    private final List<ZUMLActivityNode> nodes;

    /**
     * <p>
     * The list of edges contained by this ActivityDiagram instance. Initialized in the
     * constructor with an empty ArrayList and never changed after that. It cannot be null and
     * cannot contain null elements. It can be empty after creation or if the model has
     * no such elements. It's used in getEdges(), addEdge(), addEdges(), removeEdge() and
     * clearEdges().
     * </p>
     */
    private final List<ZUMLActivityEdge> edges;

    /**
     * <p>
     * Intializes the nodes and edges variables with emtpy ArrayLists.
     * </p>
     */
    protected AbstractZUMLActivityDiagram() {
        nodes = new ArrayList<ZUMLActivityNode>();
        edges = new ArrayList<ZUMLActivityEdge>();
    }

    /**
     * <p>
     * Gets the list of the contained nodes in this Diagram. A shadow copy of the list is returned.
     * </p>
     *
     * @return a shadow copy of the list of the contained nodes in this Diagram
     */
    public List<ZUMLActivityNode> getNodes() {
        return new ArrayList<ZUMLActivityNode>(nodes);
    }

    /**
     * <p>
     * Adds a ZUMLActivityNode to the nodes list. Duplicates are not checked.
     * </p>
     *
     * @param node the node to be added
     * @throws IllegalArgumentException if the node argument is null
     */
    public void addNode(ZUMLActivityNode node) {
        Helper.checkNull(node, "node");

        nodes.add(node);
    }

    /**
     * <p>
     * Adds an array of ZUMLActivityNode objects to the nodes list. Duplicates are not checked.
     * </p>
     *
     * @param nodes the array of nodes to be added
     * @throws IllegalArgumentException if the nodes array is null or if it contains null elements
     */
    public void addNodes(ZUMLActivityNode[] nodes) {
        Helper.checkObjectArray(nodes, "nodes");

        for (ZUMLActivityNode node : nodes) {
            addNode(node);
        }
    }

    /**
     * <p>
     * Removes a node from the nodes list. If the node is not found, do nothing, if two or more
     * nodes are identical remove the first find and return.
     * </p>
     *
     * @param node the node to be removed
     * @throws IllegalArgumentException if the argument is null
     */
    public void removeNode(ZUMLActivityNode node) {
        Helper.checkNull(node, "node");

        nodes.remove(node);
    }

    /**
     * <p>
     * Removes all the nodes from the list.
     * </p>
     */
    public void clearNodes() {
        nodes.clear();
    }

    /**
     * <p>
     * Get the list of the contained edges in this Diagram. A shadow copy of this list is returned.
     * </p>
     *
     * @return a shadow copy of the list of the contained edges in thid Diagram
     */
    public List<ZUMLActivityEdge> getEdges() {
        return new ArrayList<ZUMLActivityEdge>(edges);
    }

    /**
     * <p>
     * Adds a ZUMLActivityEdge to the edges list. Duplicates are not checked.
     * </p>
     *
     * @param edge the ZUMLActivityEdge to be added
     * @throws IllegalArgumentException if the edge argument is null
     */
    public void addEdge(ZUMLActivityEdge edge) {
        Helper.checkNull(edge, "edge");

        edges.add(edge);
    }

    /**
     * <p>
     * Adds an array of ZUMLActivityEdge objects to the edges list. Duplicates are not checked.
     * </p>
     *
     * @param edges an array of ZUMLActivityEdge elements to be added
     * @throws IllegalArgumentException if the edges array is null or if it contains null elements
     */
    public void addEdges(ZUMLActivityEdge[] edges) {
        Helper.checkObjectArray(edges, "edges");

        for (ZUMLActivityEdge edge : edges) {
            addEdge(edge);
        }
    }

    /**
     * <p>
     * Removes a edge from the edges list. If the edge is not found, do nothing, if two or more edges
     * are identical remove the first find and return.
     * </p>
     *
     * @param edge the edge to be removed
     * @throws IllegalArgumentException if the argument is null
     */
    public void removeEdge(ZUMLActivityEdge edge) {
        Helper.checkNull(edge, "edge");

        edges.remove(edge);
    }

    /**
     * <p>
     * Removes all the edges from the list.
     * </p>
     */
    public void clearEdges() {
        edges.clear();
    }

    /**
     * <p>
     * Abstract methods for converting the current activity diagram element to its tcuml equivalent
     * model representation. The returned object is a ModelElement instance which means it can be
     * used to construct a tcuml model.
     * </p>
     *
     * @return the equivalent tcuml ModelElement
     */
    public abstract ModelElement convertToTCUML();
}
