/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.activity.impl;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;

import com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLActivityEdge;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLActivityNode;

import java.util.ArrayList;
import java.util.List;


/**
 * <p>
 * This abstract class implements the ZUMLActivityNode interface and extends the ModelElementAbstractImpl class.
 * It defines the common methods of any type of ZUMLActivityNode to lessen the imlementation contract. It also
 * defines methods to manage the incoming and outgoing edges.
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
public abstract class AbstractZUMLActivityNode extends ModelElementAbstractImpl
    implements ZUMLActivityNode {
    /**
     * <p>
     * The list of incoming edges of the current ZUMLActivityNode instance. Initialized in
     * the constructor with an empty ArrayList and never changed after that. It cannot be null
     * and cannot contain null elements. It can be empty after creation or if the model has
     * no such elements. It's used in getIncomingEdges(), addIncomingEdge(), addIncomingEdges(),
     * removeIncomingEdge() and clearIncomingEdges().
     * </p>
     */
    private final List<ZUMLActivityEdge> incomingEdges;

    /**
     * <p>
     * The list of outgoing edges of the current ZUMLActivityNode instance. Initialized in
     * the constructor with an empty ArrayList and never changed after that. It cannot be null
     * and cannot contain null elements. It can be empty after creation or if the model has
     * no such elements. It's used in getOutgoingEdges(), addOutgoingEdge(), addtOutgoingEdges(),
     * removetOutgoingEdge() and clearOutgoingEdges().
     * </p>
     */
    private final List<ZUMLActivityEdge> outgoingEdges;

    /**
     * <p>Intializes the incoming and outgoing edges variables with empty ArrayList.</p>
     */
    protected AbstractZUMLActivityNode() {
        incomingEdges = new ArrayList<ZUMLActivityEdge>();
        outgoingEdges = new ArrayList<ZUMLActivityEdge>();
    }

    /**
     * <p>
     * Gets the list of the contained incoming edges for this node. A shadow copy of the list is returned.
     * </p>
     *
     * @return a shadow copy of the list of the contained incoming edges
     */
    public List<ZUMLActivityEdge> getIncomingEdges() {
        return new ArrayList<ZUMLActivityEdge>(incomingEdges);
    }

    /**
     * <p>
     * Adds a ZUMLActivityEdge to the incoming edges list. Duplicates are not checked.
     * </p>
     *
     * @param edge the ZUMLActivityEdge to be added
     * @throws IllegalArgumentException if the edge argument is null
     */
    public void addIncomingEdge(ZUMLActivityEdge edge) {
        Helper.checkNull(edge, "edge");

        incomingEdges.add(edge);
    }

    /**
     * <p>
     * Adds an array of ZUMLActivityEdge objects to the incoming edges list. Duplicates are not checked.
     * </p>
     *
     * @param edges an array of ZUMLActivityEdge elements to be added
     * @throws IllegalArgumentException if the edges array is null or if it contains null elements
     */
    public void addIncomingEdges(ZUMLActivityEdge[] edges) {
        Helper.checkObjectArray(edges, "edges");

        for (ZUMLActivityEdge edge : edges) {
            addIncomingEdge(edge);
        }
    }

    /**
     * <p>
     * Removes an edge from the incoming edges list. If the outgoing edge is not found, do nothing,
     * if two or more incoming edges are identical, remove the first find and return.
     * </p>
     *
     * @param edge the incoming edge to be removed
     * @throws IllegalArgumentException if the argument is null
     */
    public void removeIncomingEdge(ZUMLActivityEdge edge) {
        Helper.checkNull(edge, "edge");

        incomingEdges.remove(edge);
    }

    /**
     * <p>
     * Removes all the incoming edges for this node.
     * </p>
     */
    public void clearIncomingEdges() {
        incomingEdges.clear();
    }

    /**
     * <p>
     * Gets the list of the contained outgoing edges for this node. A shadow copy of the list is returned.
     * </p>
     *
     * @return a list of the contained outgoing edges
     */
    public List<ZUMLActivityEdge> getOutgoingEdges() {
        return new ArrayList<ZUMLActivityEdge>(outgoingEdges);
    }

    /**
     * <p>
     * Adds a ZUMLActivityEdge to the outgoing edges list. Duplicates are not checked.
     * </p>
     *
     * @param edge the ZUMLActivityEdge to be added
     * @throws IllegalArgumentException if the edge argument is null
     */
    public void addOutgoingEdge(ZUMLActivityEdge edge) {
        Helper.checkNull(edge, "edge");

        outgoingEdges.add(edge);
    }

    /**
     * <p>
     * Adds an array of ZUMLActivityEdge objects to the outgoing edges list. Duplicates are not checked.
     * </p>
     *
     * @param edges an array of ZUMLActivityEdge elements to be added
     * @throws IllegalArgumentException if the edges array is null or if it contains null elements
     */
    public void addOutgoingEdges(ZUMLActivityEdge[] edges) {
        Helper.checkObjectArray(edges, "edges");

        for (ZUMLActivityEdge edge : edges) {
            addOutgoingEdge(edge);
        }
    }

    /**
     * <p>
     * Removes an edge from the outgoing edges list. If the outgoing edge is not found, do nothing,
     * if two or more outgoing edges are identical, remove the first find and return.
     * </p>
     *
     * @param edge the outgoing edge to be removed
     * @throws IllegalArgumentException if the argument is null
     */
    public void removeOutgoingEdge(ZUMLActivityEdge edge) {
        Helper.checkNull(edge, "edge");

        outgoingEdges.remove(edge);
    }

    /**
     * <p>
     * Removes all the outgoing Edges for this node.
     * </p>
     */
    public void clearOutgoingEdges() {
        outgoingEdges.clear();
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
