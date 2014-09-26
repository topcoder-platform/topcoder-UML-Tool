/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.relationships;

import com.topcoder.uml.model.core.GeneralizableElement;

import java.util.List;

/**
 * This interface defines the contract for a association. An association defines a semantic relationship between
 * classifiers. An Association has at least two AssociationEnds. Each end is connected to a Classifier - the same
 * Classifier may be connected to more than one AssociationEnd in the same Association. The Association represents a set
 * of connections among instances of the Classifiers. This interface extends the GeneralizableElement and Relationship
 * interfaces and adds more specific methods that apply to a association Implementations are not required to be thread
 * safe.
 *
 * @author DanLazar, fanse
 * @version 1.0
 */
public interface Association extends Relationship, GeneralizableElement {
    /**
     * Adds a connection to the current object.
     *
     * @param connection the connection.
     * @throws IllegalArgumentException if the specified connection is null.
     */
    public void addConnection(AssociationEnd connection);

    /**
     * Adds a connection at the specified index.
     *
     * @param index the index of connection to be added.
     * @param connection the connection to be added.
     * @throws IndexOutOfBoundsException if index out of range(index < 0 || index > the size of the connections list).
     * @throws IllegalArgumentException if the specified connection is null.
     */
    public void addConnection(int index, AssociationEnd connection);

    /**
     * Replaces the connection at the specified position with the specified element.
     *
     * @param index the index of connection to be set.
     * @param connection the connection to be set.
     * @throws IndexOutOfBoundsException if index out of range(index < 0 || index >= the size of the connections list).
     * @throws IllegalArgumentException if the parameter is null.
     */
    public void setConnection(int index, AssociationEnd connection);

    /**
     * Removes the connection at the specified index.
     *
     * @return the connection at the specified index.
     * @param index the index of connection to be removed.
     * @throws IndexOutOfBoundsException - if index out of range(index < 0 || index >= the size of the connections
     *             list).
     */
    public AssociationEnd removeConnection(int index);

    /**
     * Removes the specified connection.
     *
     * @return true if the connection has been removed, false otherwise.
     * @param connection the connection to be removed.
     * @throws IllegalArgumentException - if the parameter is null.
     */
    public boolean removeConnection(AssociationEnd connection);

    /**
     * Clears the connections list.
     */
    public void clearConnections();

    /**
     * Retrieves a shallow copy of connections.
     *
     * @return A shallow copy of the connections.
     */
    public List<AssociationEnd> getConnections();

    /**
     * Checks whether the specified connection is contained.
     *
     * @return true if the connection is contained, false otherwise.
     * @param connection the connection to be checked.
     * @throws IllegalArgumentException if the parameter is null.
     */
    public boolean containsConnection(AssociationEnd connection);

    /**
     * Gets the index of the specified connection.
     *
     * @return the index of the connection or -1 if not found.
     * @param connection the connection to be found.
     * @throws IllegalArgumentException if the parameter is null.
     */
    public int indexOfConnection(AssociationEnd connection);

    /**
     * Retrieves the quantity of connections.
     *
     * @return the quantity of connections.
     */
    public int countConnections();
}
