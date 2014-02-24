/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.relationships;

import com.topcoder.uml.model.core.classifiers.ClassImpl;

import java.util.List;


/**
 * This is the concrete implementation of the AssociationClass interface. An association class is an association that
 * is also a class. It not only connects a set of classifiers but also defines a set of features that belong to the
 * relationship itself and not any of the classifiers. This class also extends ClassImpl to reuse the code that exists
 * in the class. It has an association field of Association type in order to reuse the code because ,in Java, a
 * concrete class cannot extend two classes. This class has several simple attributes(discriminator,child, parent,
 * powertype) that describe a generalization. For these simple attributes setters and getters are provided. This class
 * is mutable and not thread safe. Since it is a data class it doesn't really makes sense to make it thread safe.
 *
 * @author DanLazar, fanse
 * @version 1.0
 */
public class AssociationClassImpl extends ClassImpl implements AssociationClass {
    /**
     * This field is added so that we can reuse the code from an Association concrete implementation.
     * AssociationClassImpl extends ClassImpl so AssociationClassImpl can no longer extend another concrete class(or
     * abstract). Null is not allowed.
     */
    private final Association association;

    /**
     * Constructs a new instance.
     */
    public AssociationClassImpl() {
        this(new AssociationImpl());
    }

    /**
     * Constructs a new instance.
     *
     * @param association a param used to be initialize a filed.
     * @throws IllegalArgumentException if the parameter is null.
     */
    public AssociationClassImpl(Association association) {
        super();

        // Check association is null.
        if (association == null) {
            throw new IllegalArgumentException("association is null.");
        }

        this.association = association;
    }

    /**
     * Adds a new connection.
     *
     * @param connection the connection
     * @throws IllegalArgumentException - if the parameter is null
     */
    public void addConnection(AssociationEnd connection) {
        this.association.addConnection(connection);
    }

    /**
     * Adds a new connection at the specified index.
     *
     * @param index the index of connection to be added.
     * @param connection the connection to be added.
     * @throws IndexOutOfBoundsException if index out of range(index < 0 || index > the size of the connections list).
     * @throws IllegalArgumentException if the connection is null.
     */
    public void addConnection(int index, AssociationEnd connection) {
        this.association.addConnection(index, connection);
    }

    /**
     * Sets a new connection at the specified index.
     *
     * @param index the index of connection to be set.
     * @param connection the connection to be set.
     * @throws IndexOutOfBoundsException if index out of range(index < 0 || index >= the size of the connections list).
     * @throws IllegalArgumentException if the connection is null.
     */
    public void setConnection(int index, AssociationEnd connection) {
        this.association.setConnection(index, connection);
    }

    /**
     * Removes the connection from the specified index..
     *
     * @return the connection at the specified index.
     * @param index the index of connection to be removed.
     * @throws IndexOutOfBoundsException if index out of range(index < 0 || index > the size of the connections list).
     */
    public AssociationEnd removeConnection(int index) {
        return this.association.removeConnection(index);
    }

    /**
     * Removes the parameter connection.
     *
     * @return true if the connection was removed.
     * @param connection the connection to be removed.
     * @throws IllegalArgumentException if the parameter is null.
     */
    public boolean removeConnection(AssociationEnd connection) {
        return this.association.removeConnection(connection);
    }

    /**
     * Clears the connections.
     */
    public void clearConnections() {
        this.association.clearConnections();
    }

    /**
     * Gets a copy of the connections.
     *
     * @return a shallow copy of the connections list.
     */
    public List<AssociationEnd> getConnections() {
        return this.association.getConnections();
    }

    /**
     * Checks if the specified connection is contained.
     *
     * @return true if the connection is contained.
     * @param connection the connection to be checked.
     * @throws IllegalArgumentException if the parameter is null.
     */
    public boolean containsConnection(AssociationEnd connection) {
        return this.association.containsConnection(connection);
    }

    /**
     * Retrieves the index of the connection.
     *
     * @return the index of the connection or -1 if not found.
     * @param connection the connection to be found.
     * @throws IllegalArgumentException if the parameter is null.
     */
    public int indexOfConnection(AssociationEnd connection) {
        return this.association.indexOfConnection(connection);
    }

    /**
     * Retrieves the quantity of connections.
     *
     * @return the quantity of connections.
     */
    public int countConnections() {
        return this.association.countConnections();
    }
}
