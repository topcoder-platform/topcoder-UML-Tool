/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.uml.model.core;

import java.util.Collection;

/**
 * <p>
 * A namespace is a part of a model that contains a set of ModelElements each of whose names designates a unique element
 * within the namespace.
 * </p>
 * <p>
 * In the meta model, a Namespace is a ModelElement that can own other ModelElements, like Associations and Classifiers.
 * The name of each owned ModelElement must be unique within the Namespace. Moreover, each contained ModelElement is
 * owned by at most one Namespace. The concrete subclasses of Namespace have additional constraints on which kind of
 * elements may be contained. Namespace is an abstract meta class.
 * </p>
 * <p>
 * Note that explicit parts of a model element, such as the features of a Classifier, are not modeled as owned elements
 * in a namespace. A namespace is used for unstructured contents such as the contents of a package or a class declared
 * inside the scope of another class.
 * </p>
 * <p>
 * A Namespace has the following properties:
 * <ul>
 * <li>ownedElement: (association class ElementOwnership) A set of ModelElements owned by the Namespace. Its visibility
 * attribute states whether the element is visible outside the namespace. </li>
 * </ul>
 * </p>
 * <p>
 * <b>Thread Safety</b>: Implementations of this interface are not required to be thread-safe, since thread safety
 * should be handled by the application itself.
 * </p>
 *
 * @author Pisky, vividmxx
 * @version 1.0
 */
public interface Namespace extends ModelElement {
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
    void addOwnedElement(ModelElement ownedElement);

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
    boolean removeOwnedElement(ModelElement ownedElement);

    /**
     * <p>
     * Removes all the objects of type "owned element" from the collection of the current object.
     * </p>
     */
    void clearOwnedElements();

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
    Collection<ModelElement> getOwnedElements();

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
    boolean containsOwnedElement(ModelElement ownedElement);

    /**
     * <p>
     * Returns the number of objects of type "owned element" previously added to the collection of the current object.
     * </p>
     *
     * @return the quantity of objects of type <code>ModelElement</code> inserted in the collection of the current
     *         object.
     */
    int countOwnedElements();
}
