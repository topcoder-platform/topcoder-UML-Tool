/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.relationships;

import com.topcoder.uml.model.core.GeneralizableElementAbstractImpl;

import java.util.ArrayList;
import java.util.List;


/**
 * This is the default implementation of the Association interface. An association defines a semantic relationship
 * between classifiers. An Association has at least two AssociationEnds. Each end is connected to a Classifier - the
 * same Classifier may be connected to more than one AssociationEnd in the same Association. The Association represents
 * a set of connections among instances of the Classifiers. This class also extends GeneralizableElementAbstractImpl to
 * reuse the code that exists in the abstract class. This class has a connection list for which a powerful api is
 * provided. This class is mutable and not thread safe. Since it is a data class it doesn't really makes sense to make
 * it thread safe.
 *
 * @author DanLazar, fanse
 * @version 1.0
 */
public class AssociationImpl extends GeneralizableElementAbstractImpl
    implements Association {
    /**
     * Represents the list of connections that this association consists of. An Association consists of at least two
     * AssociationEnds, each of which represents a connection of the association to a Classifier. For this field a
     * powerful api has been provided to made the interaction easy (methods like add,set,remove,clear,
     * get,contains,indexOf, count have been provided). Nulls are not allowed. The instance cannot be modified after
     * initialization but the contents of the list can be modified.
     */
    private final List<AssociationEnd> connections = new ArrayList<AssociationEnd>();

    /**
     * Empty constructor.
     */
    public AssociationImpl() {
    }

    /**
     * Adds a connection at the end of the connections list.
     *
     * @param connection the connection to be added.
     * @throws IllegalArgumentException if the parameter is null.
     */
    public void addConnection(AssociationEnd connection) {
        checkNull(connection);
        this.connections.add(connection);
    }

    /**
     * Adds a connection at the specified index in the connection list.
     *
     * @param index the index of connection to be added.
     * @param connection the connection to be added.
     * @throws IllegalArgumentException if the parameter is null.
     * @throws IndexOutOfBoundsException if index out of range(index < 0 || index > the size of the connections list).
     */
    public void addConnection(int index, AssociationEnd connection) {
        checkNull(connection);
        checkOutOfBounds(index, false);
        this.connections.add(index, connection);
    }

    /**
     * Replaces the connection at the specified position in the connections list with the specified element.
     *
     * @param index the index of connection to be set.
     * @param connection the connection to be set.
     * @throws IndexOutOfBoundsException if index out of range(index < 0 || index >= the size of the connections list).
     * @throws IllegalArgumentException if the parameter is null.
     */
    public void setConnection(int index, AssociationEnd connection) {
        checkNull(connection);
        checkOutOfBounds(index, true);
        this.connections.set(index, connection);
    }

    /**
     * Removes the connection at the specified index from the connection list.
     *
     * @return the removed connection.
     * @param index the index of connection to be removed.
     * @throws IndexOutOfBoundsException if index out of range(index < 0 || index >= the size of the connections list).
     */
    public AssociationEnd removeConnection(int index) {
        checkOutOfBounds(index, true);

        return this.connections.remove(index);
    }

    /**
     * Removes the specified connection from the connections list.
     *
     * @return true if the connection was removed, otherwise false.
     * @param connection the connection to be removed.
     * @throws IllegalArgumentException if the connection is null.
     */
    public boolean removeConnection(AssociationEnd connection) {
        checkNull(connection);

        return this.connections.remove(connection);
    }

    /**
     * Clears the connections list.
     */
    public void clearConnections() {
        this.connections.clear();
    }

    /**
     * Retrieves the connections list. A shallow copy of the connections list should be returned.
     *
     * @return a copy of the connections list.
     */
    public List<AssociationEnd> getConnections() {
        // Return a copy of connections list.
        return new ArrayList<AssociationEnd>(this.connections);
    }

    /**
     * Checks whether the specified connection is contained in the connections list.
     *
     * @return true if the connection is contained, otherwise false.
     * @param connection the connection to be checked.
     * @throws IllegalArgumentException if the connection is null.
     */
    public boolean containsConnection(AssociationEnd connection) {
        checkNull(connection);

        return this.connections.contains(connection);
    }

    /**
     * Gets the index of the specified connection in the connections list.
     *
     * @return the index of the connection in the connections list or -1 if not found.
     * @param connection the connection to be found.
     * @throws IllegalArgumentException if the connection is null.
     */
    public int indexOfConnection(AssociationEnd connection) {
        checkNull(connection);

        return this.connections.indexOf(connection);
    }

    /**
     * Retrieves the number of connections hold in the connections list.
     *
     * @return the number of the connections contains.
     */
    public int countConnections() {
        return this.connections.size();
    }

    /**
     * Checks whether the given AssociationEnd is null.
     *
     * @param connection the connection to be checked.
     * @throws IllegalArgumentException if the connection is null.
     */
    private void checkNull(AssociationEnd connection) {
        if (connection == null) {
            throw new IllegalArgumentException("connection is null.");
        }
    }

    /**
     * Checks whether the given index is out of bounds.
     *
     * @param index the index to be checked.
     * @param containBound check index whether contain upper bound.
     * @throws IndexOutOfBoundsException if index out of range; the lower bound is 0, the upper bound can be two case:
     * if containBound is true, it should be the size of the connections list, otherwise the size - 1.
     */
    private void checkOutOfBounds(int index, boolean containBound) {
        if (containBound) {
            if (index < 0 || index >= this.connections.size()) {
                throw new IndexOutOfBoundsException("index should not be out of bounds "
                        + "between 0 and the size of connections(both inclusive)");
            }
        } else if (index < 0 || index > this.connections.size()) {
            throw new IndexOutOfBoundsException("index should not be out of bounds "
                + "between 0 and the size of connections(0 inclusive)");
        }
    }
}
