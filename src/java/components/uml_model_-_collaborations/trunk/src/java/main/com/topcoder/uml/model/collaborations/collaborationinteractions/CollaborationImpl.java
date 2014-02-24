/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS UML Model - Collaborations Version 1.0
 *
 * @ CollaborationImpl.java
 */
package com.topcoder.uml.model.collaborations.collaborationinteractions;

import java.util.ArrayList;
import java.util.Collection;

import com.topcoder.uml.model.collaborations.collaborationinstances.CollaborationInstanceSet;
import com.topcoder.uml.model.collaborations.collaborationinstances.CollaborationsHelper;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.GeneralizableElementAbstractImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.NamespaceAbstractImpl;
import com.topcoder.uml.model.core.Operation;

/**
 * <p> <code>CollaborationImpl</code> provides a default implementation of <code>Collaboration</code>
 * interface and extends <code>GeneralizableElementAbstractImpl</code> from the Core Requirements
 * component. To facilitate complete implementation of methods in the interface, the methods in
 * Namespace interface are implemented but all they do is defer to in internal concrete implementation
 * of that Namespace. As such, all methods in Collaboration are supported.</p>
 *
 * <p><strong>Thread Safety</strong></p>
 * <p>This class is mutable and not thread-safe.</p>
 *
 * @author argolite, yinzi
 * @version 1.0
 */
public class CollaborationImpl extends GeneralizableElementAbstractImpl implements Collaboration {
    /**
     * Inner class that represents a concrete extension of Namespace. It simply provides a concrete
     * wrapper of the NamespaceAbstractImpl for this class so it can make use of the logic in the
     * Namespace branch of implementation.
     *
     * <p><strong>Thread Safety</strong></p>
     * <p>This class is mutable and not thread-safe.</p>
     */
    private class NamespaceImpl extends NamespaceAbstractImpl {
        /**
         * <p>Empty constructor.</p>
         */
        public NamespaceImpl() {
        }
    }

    /**
     * Represents the Namespace branch of the inheritance. Due to inheritance limitations to just one
     * branch, we need to use the other branch via delegation. All Namespace method calls implemented in
     * this class will be routed to this instance. Note that this class uses its own concrete extension
     * of NamespaceAbstractImpl so it can be instantiated.
     */
    private final NamespaceImpl innerNamespace = new NamespaceImpl();

    /**
     * <p>Represents the CollaborationInstanceSets associated with this collaboration. It will support
     * CollaborationInstanceSet elements.</p>
     *
     * <p>This collection will be initialized upon construction, and will have many accessor methods,
     * including adding and removing an element or elements, checking if the element is in the collection
     * (by reference), counting the number of the elements, and finally clearing and getting the collection.
     * Note that the whole collection getter will only return a copy of the collection. Null values will
     * not be allowed.</p>
     */
    private final Collection<CollaborationInstanceSet> collaborationInstanceSets =
        new ArrayList<CollaborationInstanceSet>();

    /**
     * <p>Represents the Classifier the Collaboration is a realization of. (Used if the Collaboration
     * represents a Classifier.).</p>
     *
     * <p>This value is set in the setter, and accessed with the getter. Null values are acceptable.
     * There is no validation performed on the setter.</p>
     */
    private Classifier representedClassifier = null;

    /**
     * <p>Represents the Operation the Collaboration is a realization of. (Used if the Collaboration
     * represents an Operation.).</p>
     *
     * <p>This value is set in the setter, and accessed with the getter. Null values are acceptable.
     * There is no validation performed on the setter.</p>
     */
    private Operation representedOperation = null;

    /**
     * <p>Empty constructor.</p>
     */
    public  CollaborationImpl() {
    }

    /**
     * Adds the CollaborationInstanceSet into the collaborationInstanceSets collection. It allows
     * duplicates. Null values are not allowed.
     *
     * @param collaborationInstanceSet The CollaborationInstanceSet to add to this collection
     * @throws IllegalArgumentException if collaborationInstanceSet is null
     */
    public void addCollaborationInstanceSet(CollaborationInstanceSet collaborationInstanceSet) {
        // Check if collaborationInstanceSet is null
        CollaborationsHelper.checkNotNull(collaborationInstanceSet, "collaborationInstanceSet");

        collaborationInstanceSets.add(collaborationInstanceSet);
    }

    /**
     * Adds the CollaborationInstanceSet instances into the collaborationInstanceSets collection. It
     * allows duplicates. The collection must not be null or contain null elements.
     *
     * @param collaborationInstanceSets Collection of CollaborationInstanceSet instances to add to the
     *  contained collection
     * @throws IllegalArgumentException if collaborationInstanceSets is null or it contains null elements
     */
    public void addCollaborationInstanceSets(Collection<CollaborationInstanceSet> collaborationInstanceSets) {
        // Check if collaborationInstanceSets is null or contains null objects
        CollaborationsHelper.checkCollection(collaborationInstanceSets, "collaborationInstanceSets");

        this.collaborationInstanceSets.addAll(collaborationInstanceSets);
    }

    /**
     * Removes the first instance, by reference, of the passed CollaborationInstanceSet, from the
     * collaborationInstanceSets collection. Since this is a collection, this operation does not
     * guarantee which instance of the referenced CollaborationInstanceSet will be removed if there
     * are multiple references to the same instance in the collection.
     *
     * @return true if the instance was in the collection and was successfully removed, false if it
     *  was not removed, or did not exist in the collection
     * @param collaborationInstanceSet The CollaborationInstanceSet to remove from this collection
     * @throws IllegalArgumentException if collaborationInstanceSet is null
     */
    public boolean removeCollaborationInstanceSet(CollaborationInstanceSet collaborationInstanceSet) {
        // Check if collaborationInstanceSet is null
        CollaborationsHelper.checkNotNull(collaborationInstanceSet, "collaborationInstanceSet");

        return collaborationInstanceSets.remove(collaborationInstanceSet);
    }

    /**
     * Removes the first instance, by reference, of each passed CollaborationInstanceSet from the
     * contained collaborationInstanceSets collection. Since this is a collection, this operation
     * does not guarantee which instance of the referenced CollaborationInstanceSet will be removed
     * if there are multiple references to the same instance in the collection. This equally applies
     * to the case if there are multiple duplicates in the passed collection.
     *
     * @return boolean True if the state of the contained collaborationInstanceSets collection has
     *  changed, false otherwise.
     * @param collaborationInstanceSets Collection of CollaborationInstanceSet instances to remove
     *  from the contained collection
     * @throws IllegalArgumentException if collaborationInstanceSets is null or it contains null elements
     */
    public boolean removeCollaborationInstanceSets(Collection<CollaborationInstanceSet> collaborationInstanceSets) {
        // Check if collaborationInstanceSets is null or contains null objects
        CollaborationsHelper.checkCollection(collaborationInstanceSets, "collaborationInstanceSets");

        boolean ret = false;
        // Remove each CollaborationInstanceSet
        for (Object obj : collaborationInstanceSets) {
            if (this.collaborationInstanceSets.remove(obj)) {
                ret = true;
            }
        }
        return ret;
    }

    /**
     * Removes all elements from the collaborationInstanceSets collection.
     */
    public void clearCollaborationInstanceSets() {
        collaborationInstanceSets.clear();
    }

    /**
     * Returns a shallow copy of the collaborationInstanceSets collection.
     *
     * @return shallow copy of the collaborationInstanceSets collection
     */
    public Collection<CollaborationInstanceSet> getCollaborationInstanceSets() {
        return new ArrayList<CollaborationInstanceSet>(collaborationInstanceSets);
    }

    /**
     * Checks if the CollaborationInstanceSet is contained in the collaborationInstanceSets collection.
     * The check is done by reference.
     *
     * @return true if the CollaborationInstanceSet is in the collection, false otherwise
     * @param collaborationInstanceSet The CollaborationInstanceSet to check for its presence in this
     *  collection
     * @throws IllegalArgumentException if collaborationInstanceSet is null
     */
    public boolean containsCollaborationInstanceSet(CollaborationInstanceSet collaborationInstanceSet) {
        // Check if collaborationInstanceSet is null
        CollaborationsHelper.checkNotNull(collaborationInstanceSet, "collaborationInstanceSet");

        return collaborationInstanceSets.contains(collaborationInstanceSet);
    }

    /**
     * Returns the size of the collaborationInstanceSets collection.
     *
     * @return the number of elements in the collection
     */
    public int countCollaborationInstanceSets() {
        return collaborationInstanceSets.size();
    }

    /**
     * Gets the Classifier representedClassifier field value. Could be null.
     *
     * @return representedClassifier field value
     */
    public Classifier getRepresentedClassifier() {
        return representedClassifier;
    }

    /**
     * Sets the Classifier representedClassifier field value. Null is allowed.
     *
     * @param representedClassifier representedClassifier field value
     */
    public void setRepresentedClassifier(Classifier representedClassifier) {
        this.representedClassifier = representedClassifier;
    }

    /**
     * Gets the Operation representedOperation field value. Could be null.
     *
     * @return representedOperation field value
     */
    public Operation getRepresentedOperation() {
        return representedOperation;
    }

    /**
     * Sets the Operation representedOperation field value. Null is allowed.
     *
     * @param representedOperation representedOperation field value
     */
    public void setRepresentedOperation(Operation representedOperation) {
        this.representedOperation = representedOperation;
    }

    /**
     * Adds the ModelElement into the ownedElements collection. It allows duplicates. Null values are
     * not allowed.
     *
     * @param ownedElement The ModelElement to add to this collection
     * @throws IllegalArgumentException if ownedElement is null
     */
    public void addOwnedElement(ModelElement ownedElement) {
        CollaborationsHelper.checkNotNull(ownedElement, "ownedElement");
        innerNamespace.addOwnedElement(ownedElement);
    }

    /**
     * Removes the first instance, by reference, of the passed ModelElement, from the ownedElements collection.
     * Since this is a collection, this operation does not guarantee which instance of the referenced
     * ModelElement will be removed if there are multiple references to the same instance in the collection.
     *
     * @return true if the instance was in the collection and was successfully removed, false if it
     *  was not removed,
     * or did not exist in the collection
     * @param ownedElement The ModelElement to remove from this collection
     * @throws IllegalArgumentException if ownedElement is null
     */
    public boolean removeOwnedElement(ModelElement ownedElement) {
        CollaborationsHelper.checkNotNull(ownedElement, "ownedElement");
        return innerNamespace.removeOwnedElement(ownedElement);
    }

    /**
     * Removes all elements from the ownedElements collection.
     */
    public void clearOwnedElements() {
        innerNamespace.clearOwnedElements();
    }

    /**
     * Returns a shallow copy of the ownedElements collection.
     *
     * @return shallow copy of the ownedElements collection
     */
    public Collection<ModelElement> getOwnedElements() {
        return innerNamespace.getOwnedElements();
    }

    /**
     * Checks if the ModelElement is contained in the ownedElements collection. The check is done
     * by reference.
     *
     * @return true if the ModelElement is in the collection, false otherwise
     * @param ownedElement The ModelElement to check for its presence in this collection
     * @throws IllegalArgumentException if ownedElement is null
     */
    public boolean containsOwnedElement(ModelElement ownedElement) {
        CollaborationsHelper.checkNotNull(ownedElement, "ownedElement");
        return innerNamespace.containsOwnedElement(ownedElement);
    }

    /**
     * Returns the size of the ownedElements collection.
     *
     * @return the number of elements in the collection
     */
    public int countOwnedElements() {
        return innerNamespace.countOwnedElements();
    }
}
