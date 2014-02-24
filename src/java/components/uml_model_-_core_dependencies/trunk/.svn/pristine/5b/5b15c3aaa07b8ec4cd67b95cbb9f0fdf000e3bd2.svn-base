/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS UML Model - Core Dependencies Version 1.0
 *
 * @ DependencyImpl.java
 */
package com.topcoder.uml.model.core.dependencies;

import java.util.ArrayList;
import java.util.Collection;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.relationships.RelationshipAbstractImpl;

/**
 * <p>This is a simple concrete implementation of Dependency interface and extends RelationshipAbstractImpl
 * from the Core Relationships component. As such, all methods in Dependency are supported.</p>
 *
 * <p><strong>Thread Safety</strong></p>
 * <p>This class is mutable and not thread-safe.</p>
 *
 * @author argolite, yinzi
 * @version 1.0
 */
public class DependencyImpl extends RelationshipAbstractImpl implements Dependency {
    /**
     * <p>Represents the Inverse of client. Designates the list that is unaffected by a change. In a
     * two-way relationship (such as some Refinement Abstractions) this would be the more general element.
     * In an undirected situation, such as a Trace Abstraction, the choice of client and supplier may
     * be irrelevant. It will support ModelElement elements.</p>
     *
     * <p>This collection will be initialized upon construction, and will have many accessor methods,
     * including adding and removing an element or elements, checking if the element is in the collection
     * (by reference), counting the number of the elements, and finally clearing and getting the collection.
     * Note that the whole collection getter will only return a copy of the collection. Null values will
     * not be allowed.</p>
     */
    private final Collection<ModelElement> suppliers = new ArrayList<ModelElement>();

    /**
     * <p>Represents The list that is affected by the supplier element. In some cases (such as a Trace
     * Abstraction) the direction is unimportant and serves only to distinguish the two elements. It
     * will support ModelElement elements.</p>
     *
     * <p>This collection will be initialized upon construction, and will have many accessor methods,
     * including adding and removing an element or elements, checking if the element is in the collection
     * (by reference), counting the number of the elements, and finally clearing and getting the collection.
     * Note that the whole collection getter will only return a copy of the collection. Null values will
     * not be allowed.</p>
     */
    private final Collection<ModelElement> clients = new ArrayList<ModelElement>();

    /**
     * <p>Empty constructor.</p>
     */
    public  DependencyImpl() {
    }

    /**
     * Adds the ModelElement into the suppliers collection. It allows duplicates. Null values are not
     * allowed.
     *
     * @param supplier The ModelElement to add to this collection
     * @throws IllegalArgumentException if supplier is null
     */
    public void addSupplier(ModelElement supplier) {
        // Check if supplier is null
        CoreDependenciesHelper.checkNotNull(supplier, "supplier");

        suppliers.add(supplier);
    }

    /**
     * Adds the ModelElement instances into the suppliers collection. It allows duplicates. The
     * collection must not be null or contain null elements.
     *
     * @param suppliers Collection of ModelElement instances to add to the contained collection
     * @throws IllegalArgumentException if suppliers is null or it contains null elements
     */
    public void addSuppliers(Collection<ModelElement> suppliers) {
        // Check if suppliers is null or contains null supplier
        CoreDependenciesHelper.checkCollection(suppliers, "suppliers");

        this.suppliers.addAll(suppliers);
    }

    /**
     * Removes the first instance, by reference, of the passed ModelElement, from the suppliers collection.
     * Since this is a collection, this operation does not guarantee which instance of the referenced
     * ModelElement will be removed if there are multiple references to the same instance in the collection.
     *
     * @return true if the instance was in the collection and was successfully removed, false if it was
     *  not removed, or did not exist in the collection
     * @param supplier The ModelElement to remove from this collection
     * @throws IllegalArgumentException if supplier is null
     */
    public boolean removeSupplier(ModelElement supplier) {
        // Check if supplier is null
        CoreDependenciesHelper.checkNotNull(supplier, "supplier");

        return suppliers.remove(supplier);
    }

    /**
     * Removes the first instance, by reference, of each passed ModelElement from the contained suppliers
     * collection. Since this is a collection, this operation does not guarantee which instance of the
     * referenced ModelElement will be removed if there are multiple references to the same instance in
     * the collection. This equally applies to the case if there are multiple duplicates in the passed
     * collection.
     *
     * @return boolean True if the state of the contained suppliers collection has changed, false otherwise.
     * @param suppliers Collection of ModelElement instances to remove from the contained collection
     * @throws IllegalArgumentException if suppliers is null or it contains null elements
     */
    public boolean removeSuppliers(Collection<ModelElement> suppliers) {
        // Check if suppliers is null or contains null supplier
        CoreDependenciesHelper.checkCollection(suppliers, "suppliers");

        boolean ret = false;
        // Remove each supplier
        for (Object obj : suppliers) {
            if (this.suppliers.remove(obj)) {
                ret = true;
            }
        }
        return ret;
    }

    /**
     * Removes all elements from the suppliers collection.
     */
    public void clearSuppliers() {
        suppliers.clear();
    }

    /**
     * Returns a shallow copy of the suppliers collection.
     *
     * @return shallow copy of the suppliers collection
     */
    public Collection<ModelElement> getSuppliers() {
        return new ArrayList<ModelElement>(suppliers);
    }

    /**
     * Checks if the ModelElement is contained in the suppliers collection. The check is done
     * by reference.
     *
     * @return true if the ModelElement is in the collection, false otherwise
     * @param supplier The ModelElement to check for its presence in this collection
     * @throws IllegalArgumentException if supplier is null
     */
    public boolean containsSupplier(ModelElement supplier) {
        // Check if supplier is null
        CoreDependenciesHelper.checkNotNull(supplier, "supplier");

        return suppliers.contains(supplier);
    }

    /**
     * Returns the size of the suppliers collection.
     *
     * @return the number of elements in the collection
     */
    public int countSuppliers() {
        return suppliers.size();
    }

    /**
     * Adds the ModelElement into the clients collection. It allows duplicates. Null values are not
     * allowed.
     *
     * @param client The ModelElement to add to this collection
     * @throws IllegalArgumentException if client is null
     */
    public void addClient(ModelElement client) {
        // Check if client is null
        CoreDependenciesHelper.checkNotNull(client, "client");

        clients.add(client);
    }

    /**
     * Adds the ModelElement instances into the clients collection. It allows duplicates. The collection
     * must not be null or contain null elements.
     *
     * @param clients Collection of ModelElement instances to add to the contained collection
     * @throws IllegalArgumentException if clients is null or it contains null elements
     */
    public void addClients(Collection<ModelElement> clients) {
        // Check if clients is null or contains null client
        CoreDependenciesHelper.checkCollection(clients, "clients");

        this.clients.addAll(clients);
    }

    /**
     * Removes the first instance, by reference, of the passed ModelElement, from the clients collection.
     * Since this is a collection, this operation does not guarantee which instance of the referenced
     * ModelElement will be removed if there are multiple references to the same instance in the collection.
     *
     * @return true if the instance was in the collection and was successfully removed, false if it
     *  was not removed, or did not exist in the collection
     * @param client The ModelElement to remove from this collection
     * @throws IllegalArgumentException if client is null
     */
    public boolean removeClient(ModelElement client) {
        // Check if client is null
        CoreDependenciesHelper.checkNotNull(client, "client");

        return clients.remove(client);
    }

    /**
     * Removes the first instance, by reference, of each passed ModelElement from the contained clients
     * collection. Since this is a collection, this operation does not guarantee which instance of the
     * referenced ModelElement will be removed if there are multiple references to the same instance in
     * the collection. This equally applies to the case if there are multiple duplicates in the passed
     * collection.
     *
     * @return boolean True if the state of the contained clients collection has changed, false otherwise.
     * @param clients Collection of ModelElement instances to remove from the contained collection
     * @throws IllegalArgumentException if clients is null or it contains null elements
     */
    public boolean removeClients(Collection<ModelElement> clients) {
        // Check if clients is null or contains null client
        CoreDependenciesHelper.checkCollection(clients, "clients");

        boolean ret = false;
        // Remove each client
        for (Object obj : clients) {
            if (this.clients.remove(obj)) {
                ret = true;
            }
        }
        return ret;
    }

    /**
     * Removes all elements from the clients collection.
     */
    public void clearClients() {
        clients.clear();
    }

    /**
     * Returns a shallow copy of the clients collection.
     *
     * @return shallow copy of the clients collection
     */
    public Collection<ModelElement> getClients() {
        return new ArrayList<ModelElement>(clients);
    }

    /**
     * Checks if the ModelElement is contained in the clients collection. The check is done
     * by reference.
     *
     * @return true if the ModelElement is in the collection, false otherwise
     * @param client The ModelElement to check for its presence in this collection
     * @throws IllegalArgumentException if client is null
     */
    public boolean containsClient(ModelElement client) {
        // Check if client is null
        CoreDependenciesHelper.checkNotNull(client, "client");

        return clients.contains(client);
    }

    /**
     * Returns the size of the clients collection.
     *
     * @return the number of elements in the collection
     */
    public int countClients() {
        return clients.size();
    }
}
