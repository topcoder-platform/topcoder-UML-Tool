/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.dependencies;

import com.topcoder.uml.model.core.*;
import com.topcoder.uml.model.core.relationships.*;
import java.util.*;

/**
 * Mock class.
 *
 * @author tushak, TCSDEVELOPER
 * @version 1.0
 */
public class DependencyImpl extends RelationshipAbstractImpl implements Dependency {

    /**
     * <p>
     * Empty constructor.
     * </p>
     */
    public DependencyImpl() {
    }

    /**
     * <p>
     * Represents the Inverse of client. Designates the list that is unaffected
     * by a change. In a two-way relationship (such as some Refinement
     * Abstractions) this would be the more general element. In an undirected
     * situation, such as a Trace Abstraction, the choice of client and supplier
     * may be irrelevant. It will support ModelElement elements.
     * </p>
     */
    private final Collection<ModelElement> suppliers = new ArrayList<ModelElement>();

    /**
     * <p>
     * Represents The list that is affected by the supplier element. In some
     * cases (such as a Trace Abstraction) the direction is unimportant and
     * serves only to distinguish the two elements. It will support ModelElement
     * elements.
     * </p>
     */
    private final Collection<ModelElement> clients = new ArrayList<ModelElement>();

    /**
     * Adds the ModelElement into the suppliers collection. It allows
     * duplicates. Null values are not allowed.
     *
     * @param supplier
     *            The ModelElement to add to this collection
     * @throws IllegalArgumentException
     *             if supplier is null
     */
    public void addSupplier(ModelElement supplier) {
        this.suppliers.add(supplier);
    }

    /**
     * Adds the ModelElement instances into the suppliers collection. It allows
     * duplicates. The collection must not be null or contain null elements.
     *
     * @param suppliers
     *            Collection of ModelElement instances to add to the contained
     *            collection
     * @throws IllegalArgumentException
     *             if suppliers is null or it contains null elements
     */
    public void addSuppliers(Collection<ModelElement> suppliers) {
    }

    /**
     * Removes the first instance, by reference, of the passed ModelElement,
     * from the suppliers collection. Since this is a collection, this operation
     * does not guarantee which instance of the referenced ModelElement will be
     * removed if there are multiple references to the same instance in the
     * collection.
     *
     * @return true if the instance was in the collection and was successfully
     *         removed, false if it was not removed, or did not exist in the
     *         collection
     * @param supplier
     *            The ModelElement to remove from this collection
     * @throws IllegalArgumentException
     *             if supplier is null
     */
    public boolean removeSupplier(ModelElement supplier) {
        return false;
    }

    /**
     * Removes the first instance, by reference, of each passed ModelElement
     * from the contained suppliers collection. Since this is a collection, this
     * operation does not guarantee which instance of the referenced
     * ModelElement will be removed if there are multiple references to the same
     * instance in the collection. This equally applies to the case if there are
     * multiple duplicates in the passed collection.
     *
     * @return boolean True if the state of the contained suppliers collection
     *         has changed, false otherwise.
     * @param suppliers
     *            Collection of ModelElement instances to remove from the
     *            contained collection
     * @throws IllegalArgumentException
     *             if suppliers is null or it contains null elements
     */
    public boolean removeSuppliers(Collection<ModelElement> suppliers) {
        return false;
    }

    /**
     * Removes all elements from the suppliers collection.
     */
    public void clearSuppliers() {
    }

    /**
     * Returns a shallow copy of the suppliers collection.
     *
     * @return shallow copy of the suppliers collection
     */
    public Collection<ModelElement> getSuppliers() {
        return this.suppliers;
    }

    /**
     * Checks if the ModelElement is contained in the suppliers collection. The
     * check is done by reference.
     *
     * @return true if the ModelElement is in the collection, false otherwise
     * @param supplier
     *            The ModelElement to check for its presence in this collection
     * @throws IllegalArgumentException
     *             if supplier is null
     */
    public boolean containsSupplier(ModelElement supplier) {
        return false;
    }

    /**
     * Returns the size of the suppliers collection.
     *
     * @return the number of elements in the collection
     */
    public int countSuppliers() {
        return 0;
    }

    /**
     * Adds the ModelElement into the clients collection. It allows duplicates.
     * Null values are not allowed.
     *
     * @param client
     *            The ModelElement to add to this collection
     * @throws IllegalArgumentException
     *             if client is null
     */
    public void addClient(ModelElement client) {
        this.clients.add(client);
    }

    /**
     * Adds the ModelElement instances into the clients collection. It allows
     * duplicates. The collection must not be null or contain null elements.
     *
     * @param clients
     *            Collection of ModelElement instances to add to the contained
     *            collection
     * @throws IllegalArgumentException
     *             if clients is null or it contains null elements
     */
    public void addClients(Collection<ModelElement> clients) {
    }

    /**
     * Removes the first instance, by reference, of the passed ModelElement,
     * from the clients collection. Since this is a collection, this operation
     * does not guarantee which instance of the referenced ModelElement will be
     * removed if there are multiple references to the same instance in the
     * collection.
     *
     * @return true if the instance was in the collection and was successfully
     *         removed, false if it was not removed, or did not exist in the
     *         collection
     * @param client
     *            The ModelElement to remove from this collection
     * @throws IllegalArgumentException
     *             if client is null
     */
    public boolean removeClient(ModelElement client) {
        return false;
    }

    /**
     * Removes the first instance, by reference, of each passed ModelElement
     * from the contained clients collection. Since this is a collection, this
     * operation does not guarantee which instance of the referenced
     * ModelElement will be removed if there are multiple references to the same
     * instance in the collection. This equally applies to the case if there are
     * multiple duplicates in the passed collection.
     *
     * @return boolean True if the state of the contained clients collection has
     *         changed, false otherwise.
     * @param clients
     *            Collection of ModelElement instances to remove from the
     *            contained collection
     * @throws IllegalArgumentException
     *             if clients is null or it contains null elements
     */
    public boolean removeClients(Collection<ModelElement> clients) {
        return false;
    }

    /**
     * Removes all elements from the clients collection.
     */
    public void clearClients() {
        // your code here
    }

    /**
     * Returns a shallow copy of the clients collection.
     *
     * @return shallow copy of the clients collection
     */
    public Collection<ModelElement> getClients() {
        return this.clients;
    }

    /**
     * Checks if the ModelElement is contained in the clients collection. The
     * check is done by reference.
     *
     * @return true if the ModelElement is in the collection, false otherwise
     * @param client
     *            The ModelElement to check for its presence in this collection
     * @throws IllegalArgumentException
     *             if client is null
     */
    public boolean containsClient(ModelElement client) {
        return false;
    }

    /**
     * Returns the size of the clients collection.
     *
     * @return the number of elements in the collection
     */
    public int countClients() {
        return 0;
    }

    public int countBehaviors() {
        return 0;
    }
}