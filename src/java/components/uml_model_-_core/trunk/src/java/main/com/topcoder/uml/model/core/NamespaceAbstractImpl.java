/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.core;

import java.util.Collection;
import java.util.ArrayList;

/**
 * <p>
 * This abstract class is a default implementation of the <code>Namespace</code> interface.
 * </p>
 * <p>
 * The non-collection attributes described by the interface are implemented by simple references to objects, that are
 * set to <code>null</code> by default; the unordered collection attributes are implemented with instances of
 * <code>ArrayList</code>, while the ordered collection attributes are implemented with instances of
 * <code>LinkedList</code>.
 * </p>
 * <p>
 * The non-collection attributes can be set to every reference of the correct type, either <code>null</code> or
 * non-null (and the String attributes can be set to the empty string); the collection attributes can't obviously be
 * <code>null</code>, since they are set during instantiation and can't be changed. Anyway, they can't contain
 * <code>null</code> references while they can contain duplicate entries.
 * </p>
 * <p>
 * <b>Thread Safety</b>: This class is not thread-safe, since thread safety should be handled by the application
 * itself.
 * </p>
 *
 * @author Pisky, vividmxx
 * @version 1.0
 */
public abstract class NamespaceAbstractImpl extends ModelElementAbstractImpl implements Namespace {

    /**
     * <p>
     * A set of ModelElements owned by the Namespace.
     * </p>
     * <p>
     * This unordered collection is instantiated as an empty <code>ArrayList</code> during construction. The value of
     * this attribute cannot be changed after construction; the content of the collection itself can be modified through
     * the appropriate methods (add, remove...). Every object of the appropriate type can be inserted into it; null
     * values are not allowed; duplicate entries are allowed.
     * </p>
     */
    private final Collection<ModelElement> ownedElements;

    /**
     * <p>
     * Constructs a basic instance of this class.
     * </p>
     */
    protected NamespaceAbstractImpl() {
        ownedElements = new ArrayList<ModelElement>();
    }

    /**
     * <p>
     * Adds a owned element to the collection of the current object.
     * </p>
     *
     * @param ownedElement
     *            the owned element to be added.
     * @throws IllegalArgumentException
     *             if <code>ownedElement</code> is null.
     */
    public void addOwnedElement(ModelElement ownedElement) {
        if (ownedElement == null) {
            throw new IllegalArgumentException("The ownedElement to be added can't be null.");
        }
        ownedElements.add(ownedElement);
    }

    /**
     * <p>
     * Removes a owned element from the collection of the current object.
     * </p>
     *
     * @param ownedElement
     *            the owned element to be removed.
     * @throws IllegalArgumentException
     *             if <code>ownedElement</code> is null.
     * @return <code>true</code> if the current object state changed because of the removal.
     */
    public boolean removeOwnedElement(ModelElement ownedElement) {
        if (ownedElement == null) {
            throw new IllegalArgumentException("The ownedElement to be removed can't be null.");
        }
        return ownedElements.remove(ownedElement);
    }

    /**
     * <p>
     * Removes all the objects of type "owned element" from the collection of the current object.
     * </p>
     */
    public void clearOwnedElements() {
        ownedElements.clear();
    }

    /**
     * <p>
     * Gets all the objects of type "owned element" previously added to the collection of the current object.
     * </p>
     * <p>
     * Additions and removals of elements to and from the returned collection do not change the state of current object
     * (i.e. the returned collection is a copy of the internal one of the current object). However, if an element
     * contained in it is modified, the state of the current object is modified accordingly (i.e. the internal and the
     * returned collections share references to the same objects).
     * </p>
     *
     * @return a <code>java.util.Collection</code> instance, containing all the objects of type
     *         <code>ModelElement</code> added to the collection of current object.
     */
    public Collection<ModelElement> getOwnedElements() {
        return new ArrayList<ModelElement>(ownedElements);
    }

    /**
     * <p>
     * Checks if a owned element is contained in the collection of the current object.
     * </p>
     *
     * @param ownedElement
     *            the ownedElement to be tested.
     * @throws IllegalArgumentException
     *             if <code>ownedElement</code> is null.
     * @return <code>true</code> if <code>ownedElement</code> is contained in the collection of the current object.
     */
    public boolean containsOwnedElement(ModelElement ownedElement) {
        if (ownedElement == null) {
            throw new IllegalArgumentException("The ownedElement to be tested can't be null.");
        }
        return ownedElements.contains(ownedElement);
    }

    /**
     * <p>
     * Returns the number of objects of type "owned element" previously added to the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>ModelElement</code> inserted in the collection of the current
     *         object.
     */
    public int countOwnedElements() {
        return ownedElements.size();
    }
}
