/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.relationships;

import java.util.ArrayList;
import java.util.List;

/**
 * Mock class.
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public class AssociationImpl extends com.topcoder.uml.model.core.GeneralizableElementAbstractImpl implements
        com.topcoder.uml.model.core.relationships.Association {

    /**
     * Represents the list of connections that this association consists of. An
     * Association consists of at least two AssociationEnds, each of which
     * represents a connection of the association to a Classifier. For this
     * field a powerful api has been provided to made the interaction easy
     * (methods like add,set,remove,clear, get,contains,indexOf, count have been
     * provided). Initial value is an empty ArrayList<Attribute>. Nulls are not
     * allowed. The instance cannot be modified after initialization but the
     * contents of the list can be modified.
     */
    private final List<AssociationEnd> connections = new ArrayList<AssociationEnd>();

    /**
     * Empty constructor.
     */
    public AssociationImpl() {
    }

    /**
     * Adds a connection at the end of the connections list. Simply use the
     * corresponding add method from the connections list.
     *
     * @param connection
     *            the connection to be added
     * @throws IllegalArgumentException -
     *             if the parameter is null
     */
    public void addConnection(com.topcoder.uml.model.core.relationships.AssociationEnd connection) {
        this.connections.add(connection);
    }

    /**
     * Adds a connection at the specified index in the connection list. Simply
     * use the corresponding add method from the connections list.
     *
     * @param index
     *            the index
     * @param connection
     *            the connection to be added
     * @throws IllegalArgumentException -
     *             if the parameter is null
     * @throws IndexOutOfBoundsException -
     *             if index out of range (index < 0 || index >= the size of the
     *             connections list
     */
    public void addConnection(int index, com.topcoder.uml.model.core.relationships.AssociationEnd connection) {
    }

    /**
     * Replaces the connection at the specified position in the connections list
     * with the specified element. Simply use the set method from the
     * connections list.
     *
     * @param index
     *            the index
     * @param connection
     *            the connection
     * @throws IndexOutOfBoundsException -
     *             if index out of range (index < 0 || index >= size of the
     *             connections list
     * @throws IllegalArgumentException -
     *             if the parameter is null
     */
    public void setConnection(int index, com.topcoder.uml.model.core.relationships.AssociationEnd connection) {
    }

    /**
     * Removes the connection at the specified index from the connection list.
     * Simply use the corresponding remove method from the connections list.
     *
     * @return the removed connection
     * @param index
     *            the index
     * @throws IndexOutOfBoundsException -
     *             if index out of range (index < 0 || index >= size of the
     *             connections list
     */
    public com.topcoder.uml.model.core.relationships.AssociationEnd removeConnection(int index) {
        return null;
    }

    /**
     * Removes the specified connection from the connections list. Simply use
     * the corresponding remove method from the connections list.
     *
     * @return true if the connection was removed, false otherwise
     * @param connection
     *            the connection to be removed
     * @throws IllegalArgumentException -
     *             if the connection is null
     */
    public boolean removeConnection(com.topcoder.uml.model.core.relationships.AssociationEnd connection) {
        return this.connections.remove(connection);
    }

    /**
     * Clears the connections list. Simply use the clear method from the
     * connections list.
     */
    public void clearConnections() {
    }

    /**
     * Retrieves the connections list. A copy of the connections list should be
     * returned.
     *
     * @return a copy of the connections list
     */
    public List<AssociationEnd> getConnections() {
        return this.connections;
    }

    /**
     * Checks wether the specified connection is contained in the connections
     * list. Simply use the contains method from the connections list.
     *
     * @return true if the connection is contained, false otherwise
     * @param connection
     *            the connection
     * @throws IllegalArgumentException -
     *             if the connection is null
     */
    public boolean containsConnection(com.topcoder.uml.model.core.relationships.AssociationEnd connection) {
        return this.connections.contains(connection);
    }

    /**
     * Gets the index of the specified connection in the connections list.
     * Simply use the indexOf method from the connections list.
     *
     * @return the index of the connection in the connections list or -1 if not
     *         found
     * @param connection
     *            the connection
     * @throws IllegalArgumentException -
     *             if the connection is null
     */
    public int indexOfConnection(com.topcoder.uml.model.core.relationships.AssociationEnd connection) {
        return 0;
    }

    /**
     * Retrieves the number of connections hold in the connections list. Simply
     * use the size method from the connections list.
     *
     * @return the number of the connections
     */
    public int countConnections() {
        return 0;
    }

    /**
     * Mock method.
     *
     * @return
     */
    public int countBehaviors() {
        return 0;
    }
}