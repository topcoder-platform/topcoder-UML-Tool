/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.auxiliaryelements;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;

import java.util.ArrayList;
import java.util.Collection;


/**
 * <p>This is a simple concrete implementation of Comment interface and extends ModelElementAbstractImpl
 * from the Core Requirements component. As such, all methods in Comment are supported.</p>
 *
 * <p><strong>Thread Safety</strong></p>
 * <p>This class is mutable and not thread-safe.</p>
 * @author argolite, TCSDEVELOPER
 * @version 1.0
 */
public class CommentImpl extends ModelElementAbstractImpl implements Comment {
    /**
     * <p>Represents A string that is the comment.</p>
     *
     * <p>This value is set in the setter, and accessed with the getter. Null and empty values are
     * acceptable. There is no validation performed on the setter.</p>
     *
     */
    private String body = null;

    /**
     * <p>Represents a collection of ModelElements described by the Comment. It will support
     * ModelElement elements.</p>
     *
     * <p>This collection will be initialized upon construction, and will have many accessor methods,
     * including adding and removing an element or elements, checking if the element is in the
     * collection (by reference), counting the number of the elements, and finally clearing and
     * getting the collection. Note that the whole collection getter will only return a copy of
     * the collection. Null values will not be allowed.</p>
     *
     */
    private final Collection<ModelElement> annotatedElements = new ArrayList<ModelElement>();

    /**
     * <p>Default constructor.</p>
     *
     */
    public CommentImpl() {
        // empty
    }

    /**
     * Gets the body field value. Could be null/empty.
     *
     *
     * @return body field value
     */
    public String getBody() {
        return body;
    }

    /**
     * Sets the body field value. Null/empty is allowed.
     *
     *
     * @param body body field value
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * Adds the ModelElement into the annotatedElements collection. It allows duplicates. Null values
     * are not allowed.
     *
     *
     * @param annotatedElement The ModelElement to add to this collection
     * @throws IllegalArgumentException if annotatedElement is null
     */
    public void addAnnotatedElement(ModelElement annotatedElement) {
        Helper.validateNotNull(annotatedElement, "annotatedElement");
        annotatedElements.add(annotatedElement);
    }

    /**
     * Adds the ModelElement instances into the annotatedElements collection. It allows duplicates.
     * The collection must not be null or contain null elements.
     *
     *
     * @param annotatedElements Collection of ModelElement instances to add to the contained collection
     * @throws IllegalArgumentException if annotatedElements is null or it contains null elements
     */
    public void addAnnotatedElements(Collection<ModelElement> annotatedElements) {
        Helper.validateCollectionNotNullNotContainNull(annotatedElements, "annotatedElements");
        this.annotatedElements.addAll(annotatedElements);
    }

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
    public boolean removeAnnotatedElement(ModelElement annotatedElement) {
        Helper.validateNotNull(annotatedElement, "annotatedElement");

        return annotatedElements.remove(annotatedElement);
    }

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
    public boolean removeAnnotatedElements(Collection<ModelElement> annotatedElements) {
        Helper.validateCollectionNotNullNotContainNull(annotatedElements, "annotatedElements");

        return Helper.removeAllFromCollection(this.annotatedElements, annotatedElements);
    }

    /**
     * Removes all elements from the annotatedElements collection.
     *
     */
    public void clearAnnotatedElements() {
        annotatedElements.clear();
    }

    /**
     * Returns a shallow copy of the annotatedElements collection.
     *
     *
     * @return shallow copy of the annotatedElements collection
     */
    public Collection<ModelElement> getAnnotatedElements() {
        return new ArrayList<ModelElement>(annotatedElements);
    }

    /**
     * Checks if the ModelElement is contained in the annotatedElements collection. The check is done
     * by reference.
     *
     *
     * @return true if the ModelElement is in the collection, false otherwise
     * @param annotatedElement The ModelElement to check for its presence in this collection
     * @throws IllegalArgumentException if annotatedElement is null
     */
    public boolean containsAnnotatedElement(ModelElement annotatedElement) {
        Helper.validateNotNull(annotatedElement, "annotatedElement");

        return annotatedElements.contains(annotatedElement);
    }

    /**
     * Returns the size of the annotatedElements collection.
     *
     *
     * @return the number of elements in the collection
     */
    public int countAnnotatedElements() {
        return annotatedElements.size();
    }
}
