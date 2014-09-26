/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS UML Model - Collaborations Version 1.0
 *
 * @ Collaboration.java
 */
package com.topcoder.uml.model.collaborations.collaborationinteractions;

import java.util.Collection;

import com.topcoder.uml.model.collaborations.collaborationinstances.CollaborationInstanceSet;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.GeneralizableElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.Operation;

/**
 * <p>This interface extends Namespace and GeneralizableElement interfaces. The Namespace and
 * GeneralizableElement interfaces come from the Core Requirements component. A collaboration
 * describes how an operation or a classifier, like a use case, is realized by a set of classifiers
 * and associations used in a specific way. The collaboration defines a set of roles to be played
 * by instances and links, as well as a set of interactions that define the communication between
 * the instances when they play the roles. In the metamodel, a Collaboration contains a set of
 * ClassifierRoles and AssociationRoles, which represent the Classifiers and Associations that take
 * part in the realization of the associated Classifier or Operation. The Collaboration may also
 * contain a set of Interactions that are used for describing the behavior performed by Instances
 * conforming to the participating ClassifierRoles.</p>
 *
 * <p><strong>Thread Safety</strong></p>
 * <p>Implementations do not have to be thread-safe. In fact, method synchronization is discouraged.
 * Thread safety will be provided by the application using these implementations.</p>
 *
 * @author argolite, yinzi
 * @version 1.0
 */
public interface Collaboration extends GeneralizableElement, Namespace {
    /**
     * Adds the CollaborationInstanceSet into the collaborationInstanceSets collection. It allows
     * duplicates. Null values are not allowed.
     *
     * @param collaborationInstanceSet The CollaborationInstanceSet to add to this collection
     * @throws IllegalArgumentException if collaborationInstanceSet is null
     */
    public void addCollaborationInstanceSet(CollaborationInstanceSet collaborationInstanceSet);

    /**
     * Adds the CollaborationInstanceSet instances into the collaborationInstanceSets collection.
     * It allows duplicates. The collection must not be null or contain null elements.
     *
     * @param collaborationInstanceSets Collection of CollaborationInstanceSet instances to add to the
     *  contained collection
     * @throws IllegalArgumentException if collaborationInstanceSets is null or it contains null elements
     */
    public void addCollaborationInstanceSets(Collection<CollaborationInstanceSet> collaborationInstanceSets);

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
    public boolean removeCollaborationInstanceSet(CollaborationInstanceSet collaborationInstanceSet);

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
    public boolean removeCollaborationInstanceSets(Collection<CollaborationInstanceSet> collaborationInstanceSets);

    /**
     * Removes all elements from the collaborationInstanceSets collection.
     */
    public void clearCollaborationInstanceSets();

    /**
     * Returns a shallow copy of the collaborationInstanceSets collection.
     *
     * @return shallow copy of the collaborationInstanceSets collection
     */
    public Collection<CollaborationInstanceSet> getCollaborationInstanceSets();

    /**
     * Checks if the CollaborationInstanceSet is contained in the collaborationInstanceSets collection.
     * The check is done by reference.
     *
     * @return true if the CollaborationInstanceSet is in the collection, false otherwise
     * @param collaborationInstanceSet The CollaborationInstanceSet to check for its presence in this
     *  collection
     * @throws IllegalArgumentException if collaborationInstanceSet is null
     */
    public boolean containsCollaborationInstanceSet(CollaborationInstanceSet collaborationInstanceSet);

    /**
     * Returns the size of the collaborationInstanceSets collection.
     *
     * @return the number of elements in the collection
     */
    public int countCollaborationInstanceSets();

    /**
     * Gets the Classifier representedClassifier field value. Could be null.
     *
     * @return representedClassifier field value
     */
    public Classifier getRepresentedClassifier();

    /**
     * Sets the Classifier representedClassifier field value. Null is allowed.
     *
     * @param representedClassifier representedClassifier field value
     */
    public void setRepresentedClassifier(Classifier representedClassifier);

    /**
     * Gets the Operation representedOperation field value. Could be null.
     *
     * @return representedOperation field value
     */
    public Operation getRepresentedOperation();

    /**
     * Sets the Operation representedOperation field value. Null is allowed.
     *
     * @param representedOperation representedOperation field value
     */
    public void setRepresentedOperation(Operation representedOperation);
}


