/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS UML Model - Collaborations Version 1.0
 *
 * @ CollaborationInstanceSet.java
 */
package com.topcoder.uml.model.collaborations.collaborationinstances;

import java.util.Collection;

import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.commonbehavior.instances.Instance;
import com.topcoder.uml.model.commonbehavior.links.Link;
import com.topcoder.uml.model.core.ModelElement;

/**
 * <p>This interface extends ModelElement interface. The ModelElement interface comes from the Core
 * Requirements component. A collaboration instance set references a set of instances that jointly
 * collaborate in performing the particular task specified by the collaboration of the collaboration
 * instance. The instances in the collaboration instance set play the roles defined in the collaboration.</p>
 *
 * <p><strong>Thread Safety</strong></p>
 * <p>Implementations do not have to be thread-safe. In fact, method synchronization is discouraged.
 * Thread safety will be provided by the application using these implementations.</p>
 *
 * @author argolite, yinzi
 * @version 1.0
 */
public interface CollaborationInstanceSet extends ModelElement {
    /**
     * Gets the Collaboration collaboration field value. Could be null.
     *
     * @return collaboration field value
     */
    public Collaboration getCollaboration();

    /**
     * Sets the Collaboration collaboration field value. Null is allowed.
     *
     * @param collaboration collaboration field value
     */
    public void setCollaboration(Collaboration collaboration);

    /**
     * Adds the Instance into the participatingInstances collection. It allows duplicates. Null values
     * are not allowed.
     *
     * @param participatingInstance The Instance to add to this collection
     * @throws IllegalArgumentException if participatingInstance is null
     */
    public void addParticipatingInstance(Instance participatingInstance);

    /**
     * Adds the Instance instances into the participatingInstances collection. It allows duplicates.
     * The collection must not be null or contain null elements.
     *
     * @param participatingInstances Collection of Instance instances to add to the contained collection
     * @throws IllegalArgumentException if participatingInstances is null or it contains null elements
     */
    public void addParticipatingInstances(Collection<Instance> participatingInstances);

    /**
     * Removes the first instance, by reference, of the passed Instance, from the participatingInstances
     * collection. Since this is a collection, this operation does not guarantee which instance of the
     * referenced Instance will be removed if there are multiple references to the same instance in the
     * collection.
     *
     * @return true if the instance was in the collection and was successfully removed, false if it was
     * not removed, or did not exist in the collection
     * @param participatingInstance The Instance to remove from this collection
     * @throws IllegalArgumentException if participatingInstance is null
     */
    public boolean removeParticipatingInstance(Instance participatingInstance);

    /**
     * Removes the first instance, by reference, of each passed Instance from the contained participatingInstances
     * collection. Since this is a collection, this operation does not guarantee which instance of the referenced
     * Instance will be removed if there are multiple references to the same instance in the collection. This
     * equally applies to the case if there are multiple duplicates in the passed collection.
     *
     * @return boolean True if the state of the contained participatingInstances collection has changed,
     *  false otherwise.
     * @param participatingInstances Collection of Instance instances to remove from the contained collection
     * @throws IllegalArgumentException if participatingInstances is null or it contains null elements
     */
    public boolean removeParticipatingInstances(Collection<Instance> participatingInstances);

    /**
     * Removes all elements from the participatingInstances collection.
     */
    public void clearParticipatingInstances();

    /**
     * Returns a shallow copy of the participatingInstances collection.
     *
     * @return shallow copy of the participatingInstances collection
     */
    public Collection<Instance> getParticipatingInstances();

    /**
     * Checks if the Instance is contained in the participatingInstances collection. The check is
     * done by reference.
     *
     * @return true if the Instance is in the collection, false otherwise
     * @param participatingInstance The Instance to check for its presence in this collection
     * @throws IllegalArgumentException if participatingInstance is null
     */
    public boolean containsParticipatingInstance(Instance participatingInstance);

    /**
     * Returns the size of the participatingInstances collection.
     *
     * @return the number of elements in the collection
     */
    public int countParticipatingInstances();

    /**
     * Adds the Link into the participatingLinks collection. It allows duplicates. Null values are
     * not allowed.
     *
     * @param participatingLink The Link to add to this collection
     * @throws IllegalArgumentException if participatingLink is null
     */
    public void addParticipatingLink(Link participatingLink);

    /**
     * Adds the Link instances into the participatingLinks collection. It allows duplicates. The
     * collection must not be null or contain null elements.
     *
     * @param participatingLinks Collection of Link instances to add to the contained collection
     * @throws IllegalArgumentException if participatingLinks is null or it contains null elements
     */
    public void addParticipatingLinks(Collection<Link> participatingLinks);

    /**
     * Removes the first instance, by reference, of the passed Link, from the participatingLinks
     * collection. Since this is a collection, this operation does not guarantee which instance
     * of the referenced Link will be removed if there are multiple references to the same instance
     * in the collection.
     *
     * @return true if the instance was in the collection and was successfully removed, false if it
     *  was not removed, or did not exist in the collection
     * @param participatingLink The Link to remove from this collection
     * @throws IllegalArgumentException if participatingLink is null
     */
    public boolean removeParticipatingLink(Link participatingLink);

    /**
     * Removes the first instance, by reference, of each passed Link from the contained participatingLinks
     * collection. Since this is a collection, this operation does not guarantee which instance of the
     * referenced Link will be removed if there are multiple references to the same instance in the
     * collection. This equally applies to the case if there are multiple duplicates in the passed
     * collection.
     *
     * @return boolean True if the state of the contained participatingLinks collection has changed,
     *  false otherwise.
     * @param participatingLinks Collection of Link instances to remove from the contained collection
     * @throws IllegalArgumentException if participatingLinks is null or it contains null elements
     */
    public boolean removeParticipatingLinks(Collection<Link> participatingLinks);

    /**
     * Removes all elements from the participatingLinks collection.
     */
    public void clearParticipatingLinks();

    /**
     * Returns a shallow copy of the participatingLinks collection.
     *
     * @return shallow copy of the participatingLinks collection
     */
    public Collection<Link> getParticipatingLinks();

    /**
     * Checks if the Link is contained in the participatingLinks collection. The check is done
     * by reference.
     *
     * @return true if the Link is in the collection, false otherwise
     * @param participatingLink The Link to check for its presence in this collection
     * @throws IllegalArgumentException if participatingLink is null
     */
    public boolean containsParticipatingLink(Link participatingLink);

    /**
     * Returns the size of the participatingLinks collection.
     *
     * @return the number of elements in the collection
     */
    public int countParticipatingLinks();
}


