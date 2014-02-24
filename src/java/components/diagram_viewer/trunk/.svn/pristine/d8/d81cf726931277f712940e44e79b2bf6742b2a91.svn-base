/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.elements;

import com.topcoder.diagraminterchange.GraphNode;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * This class represents a node container, which can contain <code>Node</code> instances. It is an extension of class
 * <code>Node</code>. It can contain node directly, or contain node under certain compartments.
 * </p>
 * <p>
 * Besides the functionality provided in <code>Node</code> class, this class only defines the methods to manipulate
 * the contained nodes.
 * </p>
 * <p>
 * <b>Thread Safety:</b> This class is mutable, and not thread safe.
 * </p>
 *
 * @author maone, TCSDEVELOPER
 * @version 1.0
 */
public abstract class NodeContainer extends Node {

    /**
     * <p>
     * Represents all the compartments. The key is compartment name, and value is all the nodes in the compartment.
     * </p>
     * <p>
     * It is initialized in constructor, can not be null, the reference can not be changed, but the entries can be
     * changed later. The key can not be null (but can be empty string), the value can not be null or contain null.
     * </p>
     */
    private final Map<String, Set<Node>> compartments;

    /**
     * <p>
     * Represents all the directly contained nodes.
     * </p>
     * <p>
     * It is initialized in constructor, can not be null, the reference can not be changed, but element can be changed
     * later. The element can not be null.
     * </p>
     */
    private final Set<Node> nodes;

    /**
     * <p>
     * Constructs a <code>NodeContainer</code> instance.
     * </p>
     *
     * @param graphNode
     *            the <code>GraphNode</code> instance associated to this node
     * @param position
     *            the relative position of visual node
     * @param bound
     *            the selection bound of corners
     * @param corners
     *            all the supported selection corners
     * @throws IllegalArgumentException
     *             if <code>graphNode</code>, <code>position</code>, <code>bound</code> or <code>corners</code>
     *             is null, or <code>corners</code> contains null element or duplicated elements
     */
    protected NodeContainer(GraphNode graphNode, Point position, Rectangle bound,
            Collection<SelectionCornerType> corners) {
        super(graphNode, position, bound, corners);
        // initialize compartments map and nodes list
        compartments = new HashMap<String, Set<Node>>();
        nodes = new HashSet<Node>();
    }

    /**
     * <p>
     * Adds the node to given compartment.
     * </p>
     *
     * @return true if the node is added, otherwise false
     * @param compartment
     *            the compartment name
     * @param node
     *            the node instance to add
     * @throws IllegalArgumentException
     *             if <code>compartment</code> or <code>node</code> is null
     */
    public boolean addNode(String compartment, Node node) {
        if (compartment == null) {
            throw new IllegalArgumentException("compartment should not be null.");
        }
        if (node == null) {
            throw new IllegalArgumentException("node should not be null.");
        }
        Set<Node> nodesValue = compartments.get(compartment);
        if (nodesValue == null) {
            nodesValue = new HashSet<Node>();
            compartments.put(compartment, nodesValue);
        }
        return nodesValue.add(node);
    }

    /**
     * <p>
     * Removes a node from given compartment.
     * </p>
     *
     * @return true if the node is removed, otherwise false
     * @param compartment
     *            the compartment name
     * @param node
     *            the node instance to remove
     * @throws IllegalArgumentException
     *             if <code>compartment</code> or <code>node</code> is null
     */
    public boolean removeNode(String compartment, Node node) {
        if (compartment == null) {
            throw new IllegalArgumentException("compartment should not be null.");
        }
        if (node == null) {
            throw new IllegalArgumentException("node should not be null.");
        }
        Set<Node> nodesValue = compartments.get(compartment);
        return nodesValue == null ? false : nodesValue.remove(node);
    }

    /**
     * <p>
     * Clears all the nodes belonging to the compartment.
     * </p>
     *
     * @param compartment
     *            the compartment name
     * @throws IllegalArgumentException
     *             if <code>compartment</code> is null
     */
    public void clearNodes(String compartment) {
        if (compartment == null) {
            throw new IllegalArgumentException("compartment should not be null.");
        }
        Set<Node> nodesValue = compartments.get(compartment);
        if (nodesValue != null) {
            nodesValue.clear();
        }
    }

    /**
     * <p>
     * Gets all the nodes belonging to the compartment.
     * </p>
     * <p>
     * An unmodifiable set should be returned.
     * </p>
     *
     * @return the nodes set belonging to the compartment, or null if no such compartment
     * @param compartment
     *            the compartment name
     * @throws IllegalArgumentException
     *             if <code>compartment</code> is null
     */
    public Set<Node> getNodes(String compartment) {
        if (compartment == null) {
            throw new IllegalArgumentException("compartment should not be null.");
        }
        Set<Node> nodesValue = compartments.get(compartment);
        return nodesValue == null ? null : Collections.unmodifiableSet(nodesValue);
    }

    /**
     * <p>
     * Adds directly contained node.
     * </p>
     *
     * @return true if the node is added, otherwise false
     * @param node
     *            the node instance to add
     * @throws IllegalArgumentException
     *             if <code>node</code> is null
     */
    public boolean addNode(Node node) {
        if (node == null) {
            throw new IllegalArgumentException("node should not be null.");
        }
        return nodes.add(node);
    }

    /**
     * <p>
     * Removes a directly contained node.
     * </p>
     *
     * @return true if the node is removed, otherwise false
     * @param node
     *            the node instance to remove
     * @throws IllegalArgumentException
     *             if <code>node</code> is null
     */
    public boolean removeNode(Node node) {
        if (node == null) {
            throw new IllegalArgumentException("node should not be null.");
        }
        return nodes.remove(node);
    }

    /**
     * <p>
     * Clears all the directly contained nodes.
     * </p>
     */
    public void clearNodes() {
        nodes.clear();
    }

    /**
     * <p>
     * Get all the directly contained nodes.
     * </p>
     * <p>
     * An unmodifiable set should be returned.
     * </p>
     *
     * @return all the directly contained nodes
     */
    public Set<Node> getNodes() {
        return Collections.unmodifiableSet(nodes);
    }

    /**
     * <p>
     * Gets all the compartment names.
     * </p>
     * <p>
     * An unmodifiable set should be returned.
     * </p>
     *
     * @return the unmodifiable set of compartment names
     */
    public Set<String> getCompartments() {
        return Collections.unmodifiableSet(compartments.keySet());
    }

    /**
     * <p>
     * Clears all the compartments.
     * </p>
     */
    public void clearCompartments() {
        compartments.clear();
    }

    /**
     * <p>
     * Removes the specified compartment.
     * </p>
     *
     * @return the nodes belonging to the compartment, or null if no such compartment
     * @param compartment
     *            the compartment name
     * @throws IllegalArgumentException
     *             if <code>compartment</code> is null
     */
    public Set<Node> removeCompartment(String compartment) {
        if (compartment == null) {
            throw new IllegalArgumentException("compartment should not be null.");
        }
        return compartments.remove(compartment);
    }

    /**
     * <p>
     * Get all the nodes, including directly contained, and the one contained in compartments.
     * </p>
     *
     * @return all the nodes contained
     */
    public Set<Node> getAllNodes() {
        Set<Node> allNodes = new HashSet<Node>(nodes);
        for (Set<Node> nodesForcompartment : compartments.values()) {
            allNodes.addAll(nodesForcompartment);
        }
        return allNodes;
    }
}
