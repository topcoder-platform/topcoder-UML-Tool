/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS UML Model - Collaborations Version 1.0
 *
 * @ CollaborationInstanceSetImpl.java
 */
package com.topcoder.uml.model.collaborations.collaborationinstances;

import java.util.ArrayList;
import java.util.Collection;

import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.commonbehavior.instances.Instance;
import com.topcoder.uml.model.commonbehavior.links.Link;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;

/**
 * <p> <code>CollaborationInstanceSetImpl</code> provides a default implementation of
 * <code>CollaborationInstanceSet</code> interface and extends <code>ModelElementAbstractImpl</code>
 * from the Core Requirements component. As such, all methods in <code>CollaborationInstanceSet</code>
 * are supported.</p>
 *
 * <p><strong>Thread Safety</strong></p>
 * <p>This class is mutable and not thread-safe.</p>
 *
 * @author argolite, yinzi
 * @version 1.0
 */
public class CollaborationInstanceSetImpl extends ModelElementAbstractImpl implements CollaborationInstanceSet {
    /**
     * <p>Represents the Collaboration, which declares the roles that the Instances that participate
     * in the CollaborationInstanceSet play.</p>
     *
     * <p>This value is set in the setter, and accessed with the getter. Null values are acceptable.
     * There is no validation performed on the setter.</p>
     */
    private Collaboration collaboration = null;

    /**
     * <p>Represents the set of Instances that participate in the CollaborationInstanceSet. It will
     * support Instance elements.</p>
     *
     * <p>This collection will be initialized upon construction, and will have many accessor methods,
     * including adding and removing an element or elements, checking if the element is in the collection
     * (by reference), counting the number of the elements, and finally clearing and getting the collection.
     * Note that the whole collection getter will only return a copy of the collection. Null values will
     * not be allowed.</p>
     */
    private final Collection<Instance> participatingInstances = new ArrayList<Instance>();

    /**
     * <p>Represents the set of Links that participate in the CollaborationInstanceSet.. It will support
     * Link elements.</p>
     *
     * <p>This collection will be initialized upon construction, and will have many accessor methods,
     * including adding and removing an element or elements, checking if the element is in the collection
     * (by reference), counting the number of the elements, and finally clearing and getting the collection.
     * Note that the whole collection getter will only return a copy of the collection. Null values will
     * not be allowed.</p>
     */
    private final Collection<Link> participatingLinks = new ArrayList<Link>();

    /**
     * <p>Empty constructor.</p>
     */
    public  CollaborationInstanceSetImpl() {
    }

    /**
     * Gets the Collaboration collaboration field value. Could be null.
     *
     * @return collaboration field value
     */
    public Collaboration getCollaboration() {
        return collaboration;
    }

    /**
     * Sets the Collaboration collaboration field value. Null is allowed.
     *
     * @param collaboration collaboration field value
     */
    public void setCollaboration(Collaboration collaboration) {
        this.collaboration = collaboration;
    }

    /**
     * Adds the Instance into the participatingInstances collection. It allows duplicates. Null values
     * are not allowed.
     *
     * @param participatingInstance The Instance to add to this collection
     * @throws IllegalArgumentException if participatingInstance is null
     */
    public void addParticipatingInstance(Instance participatingInstance) {
        // Check if the parameter is null
        CollaborationsHelper.checkNotNull(participatingInstance, "participatingInstance");

        participatingInstances.add(participatingInstance);
    }

    /**
     * Adds the Instance instances into the participatingInstances collection. It allows duplicates.
     * The collection must not be null or contain null elements.
     *
     * @param participatingInstances Collection of Instance instances to add to the contained collection
     * @throws IllegalArgumentException if participatingInstances is null or it contains null elements
     */
    public void addParticipatingInstances(Collection<Instance> participatingInstances) {
        // Check if participatingInstances is null or contains null objects
        CollaborationsHelper.checkCollection(participatingInstances, "participatingInstances");

        this.participatingInstances.addAll(participatingInstances);
    }

/**
 * Removes the first instance, by reference, of the passed Instance, from the participatingInstances
 * collection. Since this is a collection, this operation does not guarantee which instance of the
 * referenced Instance will be removed if there are multiple references to the same instance in the
 * collection.
 *
 * @return true if the instance was in the collection and was successfully removed, false if it was
 *  not removed, or did not exist in the collection
 * @param participatingInstance The Instance to remove from this collection
 * @throws IllegalArgumentException if participatingInstance is null
 */
    public boolean removeParticipatingInstance(Instance participatingInstance) {
        // Check if parameter is null
        CollaborationsHelper.checkNotNull(participatingInstance, "participatingInstance");

        return participatingInstances.remove(participatingInstance);
    }

    /**
     * Removes the first instance, by reference, of each passed Instance from the contained
     * participatingInstances collection. Since this is a collection, this operation does not guarantee
     * which instance of the referenced Instance will be removed if there are multiple references to
     * the same instance in the collection. This equally applies to the case if there are multiple
     * duplicates in the passed collection.
     *
     * @return boolean True if the state of the contained participatingInstances collection has changed,
     *  false otherwise.
     * @param participatingInstances Collection of Instance instances to remove from the contained collection
     * @throws IllegalArgumentException if participatingInstances is null or it contains null elements
     */
    public boolean removeParticipatingInstances(Collection<Instance> participatingInstances) {
        // Check if participatingInstances is null or contains null objects
        CollaborationsHelper.checkCollection(participatingInstances, "participatingInstances");

        boolean ret = false;
        // Remove each CollaborationInstanceSet
        for (Object obj : participatingInstances) {
            if (this.participatingInstances.remove(obj)) {
                ret = true;
            }
        }
        return ret;
    }

    /**
     * Removes all elements from the participatingInstances collection.
     */
    public void clearParticipatingInstances() {
        participatingInstances.clear();
    }

    /**
     * Returns a shallow copy of the participatingInstances collection.
     *
     * @return shallow copy of the participatingInstances collection
     */
    public Collection<Instance> getParticipatingInstances() {
        return new ArrayList<Instance>(participatingInstances);
    }

    /**
     * Checks if the Instance is contained in the participatingInstances collection. The check is done
     * by reference.
     *
     * @return true if the Instance is in the collection, false otherwise
     * @param participatingInstance The Instance to check for its presence in this collection
     * @throws IllegalArgumentException if participatingInstance is null
     */
    public boolean containsParticipatingInstance(Instance participatingInstance) {
        // Check if parameter is null
        CollaborationsHelper.checkNotNull(participatingInstance, "participatingInstance");

        return participatingInstances.contains(participatingInstance);
    }

    /**
     * Returns the size of the participatingInstances collection.
     *
     * @return the number of elements in the collection
     */
    public int countParticipatingInstances() {
        return participatingInstances.size();
    }

    /**
     * Adds the Link into the participatingLinks collection. It allows duplicates. Null values are
     * not allowed.
     *
     * @param participatingLink The Link to add to this collection
     * @throws IllegalArgumentException if participatingLink is null
     */
    public void addParticipatingLink(Link participatingLink) {
        // Check if parameter is null
        CollaborationsHelper.checkNotNull(participatingLink, "participatingLink");

        participatingLinks.add(participatingLink);
    }

    /**
     * Adds the Link instances into the participatingLinks collection. It allows duplicates. The
     * collection must not be null or contain null elements.
     *
     * @param participatingLinks Collection of Link instances to add to the contained collection
     * @throws IllegalArgumentException if participatingLinks is null or it contains null elements
     */
    public void addParticipatingLinks(Collection<Link> participatingLinks) {
        // Check if participatingLinks is null or contais null objects
        CollaborationsHelper.checkCollection(participatingLinks, "participatingLinks");

        this.participatingLinks.addAll(participatingLinks);
    }

    /**
     * Removes the first instance, by reference, of the passed Link, from the participatingLinks collection.
     * Since this is a collection, this operation does not guarantee which instance of the referenced
     * Link will be removed if there are multiple references to the same instance in the collection.
     *
     * @return true if the instance was in the collection and was successfully removed, false if it was
     *  not removed, or did not exist in the collection
     * @param participatingLink The Link to remove from this collection
     * @throws IllegalArgumentException if participatingLink is null
     */
    public boolean removeParticipatingLink(Link participatingLink) {
        // Check if parameter is null
        CollaborationsHelper.checkNotNull(participatingLink, "participatingLink");

        return participatingLinks.remove(participatingLink);
    }

    /**
     * Removes the first instance, by reference, of each passed Link from the contained participatingLinks
     * collection. Since this is a collection, this operation does not guarantee which instance of the
     * referenced Link will be removed if there are multiple references to the same instance in the
     * collection. This equally applies to the case if there are multiple duplicates in the passed
     * collection.
     *
     * @return boolean True if the state of the contained participatingLinks collection has changed, false otherwise.
     * @param participatingLinks Collection of Link instances to remove from the contained collection
     * @throws IllegalArgumentException if participatingLinks is null or it contains null elements
     */
    public boolean removeParticipatingLinks(Collection<Link> participatingLinks) {
        // Check if participatingLinks is null or contains null objects
        CollaborationsHelper.checkCollection(participatingLinks, "participatingLinks");

        boolean ret = false;
        // Remove each CollaborationInstanceSet
        for (Object obj : participatingLinks) {
            if (this.participatingLinks.remove(obj)) {
                ret = true;
            }
        }
        return ret;
    }

    /**
     * Removes all elements from the participatingLinks collection.
     */
    public void clearParticipatingLinks() {
        participatingLinks.clear();
    }

    /**
     * Returns a shallow copy of the participatingLinks collection.
     *
     * @return shallow copy of the participatingLinks collection
     */
    public Collection<Link> getParticipatingLinks() {
        return new ArrayList<Link>(participatingLinks);
    }

    /**
     * Checks if the Link is contained in the participatingLinks collection. The check is done
     * by reference.
     *
     * @return true if the Link is in the collection, false otherwise
     * @param participatingLink The Link to check for its presence in this collection
     * @throws IllegalArgumentException if participatingLink is null
     */
    public boolean containsParticipatingLink(Link participatingLink) {
        // Check if parameter is null
        CollaborationsHelper.checkNotNull(participatingLink, "participatingLink");

        return participatingLinks.contains(participatingLink);
    }

    /**
     * Returns the size of the participatingLinks collection.
     *
     * @return the number of elements in the collection
     */
    public int countParticipatingLinks() {
        return participatingLinks.size();
    }
}
