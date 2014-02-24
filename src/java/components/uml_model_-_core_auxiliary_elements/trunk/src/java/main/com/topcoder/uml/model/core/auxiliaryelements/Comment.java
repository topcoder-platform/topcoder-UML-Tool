/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.auxiliaryelements;

import com.topcoder.uml.model.core.ModelElement;

import java.util.Collection;


/**
 * <p>This interface extends ModelElement interface. The ModelElement interface comes form the Core
 * Requirements component. A comment is an annotation attached to a model element or a set of model
 * elements. It has no semantic force but may contain information useful to the modeler.</p>
 *
 * <p><strong>Thread Safety</strong></p>
 * <p>Implementations do not have to be thread-safe. In fact, method synchronization is discouraged.
 * Thread safety will be provided by the application using these implementations.</p>
 * @author argolite, TCSDEVELOPER
 * @version 1.0
 */
public interface Comment extends ModelElement {
    /**
     * Gets the body field value. Could be null/empty.
     *
     *
     * @return body field value
     */
    String getBody();

    /**
     * Sets the body field value. Null/empty is allowed.
     *
     *
     * @param body body field value
     */
    void setBody(String body);

    /**
     * Adds the ModelElement into the annotatedElements collection. It allows duplicates. Null
     * values are not allowed.
     *
     *
     * @param annotatedElement The ModelElement to add to this collection
     * @throws IllegalArgumentException if annotatedElement is null
     */
    void addAnnotatedElement(ModelElement annotatedElement);

    /**
     * Adds the ModelElement instances into the annotatedElements collection. It allows duplicates.
     * The collection must not be null or contain null elements.
     *
     *
     * @param annotatedElements Collection of ModelElement instances to add to the contained collection
     * @throws IllegalArgumentException if annotatedElements is null or it contains null elements
     */
    void addAnnotatedElements(Collection<ModelElement> annotatedElements);

    /**
     * Removes the first instance, by reference, of the passed ModelElement, from the annotatedElements
     * collection. Since this is a collection, this operation does not guarantee which instance of the
     * referenced ModelElement will be removed if there are multiple references to the same instance in
     * the collection.
     *
     *
     * @return true if the instance was in the collection and was successfully removed, false if it was
     * not removed, or did not exist in the collection
     * @param annotatedElement The ModelElement to remove from this collection
     * @throws IllegalArgumentException if annotatedElement is null
     */
    boolean removeAnnotatedElement(ModelElement annotatedElement);

    /**
     * Removes the instances, by reference, of each passed ModelElement from the contained
     * annotatedElements collection. Since this is a collection, this operation does not guarantee
     * which instance of the referenced ModelElement will be removed if there are multiple references
     * to the same instance in the collection. This equally applies to the case if there are multiple
     * duplicates in the passed collection.
     *
     *
     * @return boolean True if the state of the contained annotatedElements collection has changed,
     * false otherwise.
     * @param annotatedElements Collection of ModelElement instances to remove from the contained collection
     * @throws IllegalArgumentException if annotatedElements is null or it contains null elements
     */
    boolean removeAnnotatedElements(Collection<ModelElement> annotatedElements);

    /**
     * Removes all elements from the annotatedElements collection.
     *
     */
    void clearAnnotatedElements();

    /**
     * Returns a shallow copy of the annotatedElements collection.
     *
     *
     * @return shallow copy of the annotatedElements collection
     */
    Collection<ModelElement> getAnnotatedElements();

    /**
     * Checks if the ModelElement is contained in the annotatedElements collection. The check is done
     * by reference.
     *
     *
     * @return true if the ModelElement is in the collection, false otherwise
     * @param annotatedElement The ModelElement to check for its presence in this collection
     * @throws IllegalArgumentException if annotatedElement is null
     */
    boolean containsAnnotatedElement(ModelElement annotatedElement);

    /**
     * Returns the size of the annotated elements collection.
     *
     *
     * @return the number of elements in the annotated elements collection
     */
    int countAnnotatedElements();
}
