/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.relationships;

import java.util.List;

/**
 * Mock class.
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public interface Association extends com.topcoder.uml.model.core.relationships.Relationship,
        com.topcoder.uml.model.core.GeneralizableElement {
    /**
     * Adds a connection.
     *
     * @param connection
     *            the connection
     * @throws IllegalArgumentException -
     *             if the parameter is null
     */
    public void addConnection(com.topcoder.uml.model.core.relationships.AssociationEnd connection);

    /**
     * Adds a connection at the specified index.
     *
     * @param index
     *            the index
     * @param connection
     *            the connection
     * @throws IndexOutOfBoundsException -
     *             if index out of range (index < 0 || index >= size of the
     *             connections holder
     * @throws IllegalArgumentException -
     *             if the parameter is null
     */
    public void addConnection(int index, com.topcoder.uml.model.core.relationships.AssociationEnd connection);

    /**
     * Replaces the connection at the specified position with the specified
     * element.
     *
     * @param index
     *            the index
     * @param connection
     *            the connection
     * @throws IndexOutOfBoundsException -
     *             if index out of range (index < 0 || index >= size of the
     *             connections holder
     * @throws IllegalArgumentException -
     *             if the parameter is null
     */
    public void setConnection(int index, com.topcoder.uml.model.core.relationships.AssociationEnd connection);

    /**
     * Removes the connection at the specified index .
     *
     * @return the connection at the specified index
     * @param index
     *            the index
     * @throws IndexOutOfBoundsException -
     *             if index out of range (index < 0 || index >= size of the
     *             connections holder
     */
    public com.topcoder.uml.model.core.relationships.AssociationEnd removeConnection(int index);

    /**
     * Removes the specified connection.
     *
     * @return true if the connection has been removed, false otherwise
     * @param connection
     *            the connection
     * @throws IllegalArgumentException -
     *             if the parameter is null
     */
    public boolean removeConnection(com.topcoder.uml.model.core.relationships.AssociationEnd connection);

    /**
     * Clears the connections list.
     */
    public void clearConnections();

    /**
     * Retrieves the connections..
     *
     * @return the connections
     */
    public List<AssociationEnd> getConnections();

    /**
     * Checks wether the specified connection is contained.
     *
     * @return true if the connection is contained, false otherwise
     * @param connection
     *            the connection
     * @throws IllegalArgumentException -
     *             if the parameter is null
     */
    public boolean containsConnection(com.topcoder.uml.model.core.relationships.AssociationEnd connection);

    /**
     * Gets the index of the specified connection .
     *
     * @return the index of the connection or -1 if not found
     * @param connection
     *            the connection
     * @throws IllegalArgumentException -
     *             if the parameter is null
     */
    public int indexOfConnection(com.topcoder.uml.model.core.relationships.AssociationEnd connection);

    /**
     * Retrieves the number of connections.
     *
     * @return the number of connections
     */
    public int countConnections();
}