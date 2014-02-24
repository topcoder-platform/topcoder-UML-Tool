/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.commonbehavior.instances;

import com.topcoder.uml.model.commonbehavior.links.Link;
import com.topcoder.uml.model.commonbehavior.links.LinkEnd;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.ModelElement;

import java.util.Collection;


/**
 * <p>This interface extends ModelElement interface. The ModelElement interface comes form the Core
 * Requirements component. The instance construct defines an entity to which a set of operations
 * can be applied and which has a state that stores the effects of the operations. In the metamodel,
 * Instance is connected to at least one Classifier that declares its structure and behavior. It
 * has a set of attribute values and is connected to a set of Links, both sets matching the
 * definitions of its Classifiers. The two sets implement the current state of the Instance. An
 * Instance may also own other Instances or Links.</p>
 *
 * <p><strong>Thread Safety</strong></p>
 * <p>Implementations do not have to be thread-safe. In fact, method synchronization is discouraged.
 * Thread safety will be provided by the application using these implementations.</p>
 * @author argolite, TCSDEVELOPER
 * @version 1.0
 */
public interface Instance extends ModelElement {
    /**
     * Gets the classifier field value. Could be null.
     *
     *
     * @return classifier field value
     */
    Classifier getClassifier();

    /**
     * Sets the classifier field value. Null is allowed.
     *
     *
     * @param classifier classifier field value
     */
    void setClassifier(Classifier classifier);

    /**
     * Adds the Link into the ownedLinks collection. It allows duplicates. Null values are not allowed.
     *
     *
     * @param ownedLink The Link to add to this collection
     * @throws IllegalArgumentException if ownedLink is null
     */
    void addOwnedLink(Link ownedLink);

    /**
     * Adds the Link instances into the ownedLinks collection. It allows duplicates. The collection
     * must not be null or contain null elements.
     *
     *
     * @param ownedLinks Collection of Link instances to add to the contained collection
     * @throws IllegalArgumentException if ownedLinks is null or it contains null elements
     */
    void addOwnedLinks(Collection<Link> ownedLinks);

    /**
     * Removes the first instance, by reference, of the passed Link, from the ownedLinks collection.
     * Since this is a collection, this operation does not guarantee which instance of the referenced
     * Link will be removed if there are multiple references to the same instance in the collection.
     *
     *
     * @return true if the instance was in the collection and was successfully removed, false if it
     * was not removed, or did not exist in the collection
     * @param ownedLink The Link to remove from this collection
     * @throws IllegalArgumentException if ownedLink is null
     */
    boolean removeOwnedLink(Link ownedLink);

    /**
     * Removes the first instance, by reference, of each passed Link from the contained ownedLinks
     * collection. Since this is a collection, this operation does not guarantee which instance of
     * the referenced Link will be removed if there are multiple references to the same instance
     * in the collection. This equally applies to the case if there are multiple duplicates in the
     * passed collection.
     *
     *
     * @return boolean True if the state of the contained ownedLinks collection has changed, false otherwise.
     * @param ownedLinks Collection of Link instances to remove from the contained collection
     * @throws IllegalArgumentException if ownedLinks is null or it contains null elements
     */
    boolean removeOwnedLinks(Collection<Link> ownedLinks);

    /**
     * Removes all elements from the ownedLinks collection.
     *
     */
    void clearOwnedLinks();

    /**
     * Returns a shallow copy of the ownedLinks collection.
     *
     *
     * @return shallow copy of the ownedLinks collection
     */
    Collection<Link> getOwnedLinks();

    /**
     * Checks if the Link is contained in the ownedLinks collection. The check is done by reference.
     *
     *
     * @return true if the Link is in the collection, false otherwise
     * @param ownedLink The Link to check for its presence in this collection
     * @throws IllegalArgumentException if ownedLink is null
     */
    boolean containsOwnedLink(Link ownedLink);

    /**
     * Returns the size of the ownedLinks collection.
     *
     *
     * @return the number of elements in the collection
     */
    int countOwnedLinks();

    /**
     * Adds the LinkEnd into the linkEnds collection. It allows duplicates. Null values are not allowed.
     *
     *
     * @param linkEnd The LinkEnd to add to this collection
     * @throws IllegalArgumentException if linkEnd is null
     */
    void addLinkEnd(LinkEnd linkEnd);

    /**
     * Adds the LinkEnd instances into the linkEnds collection. It allows duplicates. The collection
     * must not be null or contain null elements.
     *
     *
     * @param linkEnds Collection of LinkEnd instances to add to the contained collection
     * @throws IllegalArgumentException if linkEnds is null or it contains null elements
     */
    void addLinkEnds(Collection<LinkEnd> linkEnds);

    /**
     * Removes the first instance, by reference, of the passed LinkEnd, from the linkEnds collection.
     * Since this is a collection, this operation does not guarantee which instance of the referenced
     * LinkEnd will be removed if there are multiple references to the same instance in the collection.
     *
     *
     * @return true if the instance was in the collection and was successfully removed, false if it
     * was not removed, or did not exist in the collection
     * @param linkEnd The LinkEnd to remove from this collection
     * @throws IllegalArgumentException if linkEnd is null
     */
    boolean removeLinkEnd(LinkEnd linkEnd);

    /**
     * Removes the first instance, by reference, of each passed LinkEnd from the contained linkEnds
     * collection. Since this is a collection, this operation does not guarantee which instance of
     * the referenced LinkEnd will be removed if there are multiple references to the same instance
     * in the collection. This equally applies to the case if there are multiple duplicates in the
     * passed collection.
     *
     *
     * @return boolean True if the state of the contained linkEnds collection has changed, false otherwise.
     * @param linkEnds Collection of LinkEnd instances to remove from the contained collection
     * @throws IllegalArgumentException if linkEnds is null or it contains null elements
     */
    boolean removeLinkEnds(Collection<LinkEnd> linkEnds);

    /**
     * Removes all elements from the linkEnds collection.
     *
     */
    void clearLinkEnds();

    /**
     * Returns a shallow copy of the linkEnds collection.
     *
     *
     * @return shallow copy of the linkEnds collection
     */
    Collection<LinkEnd> getLinkEnds();

    /**
     * Checks if the LinkEnd is contained in the linkEnds collection. The check is done by reference.
     *
     *
     * @return true if the LinkEnd is in the collection, false otherwise
     * @param linkEnd The LinkEnd to check for its presence in this collection
     * @throws IllegalArgumentException if linkEnd is null
     */
    boolean containsLinkEnd(LinkEnd linkEnd);

    /**
     * Returns the size of the linkEnds collection.
     *
     *
     * @return the number of elements in the collection
     */
    int countLinkEnds();

    /**
     * Adds the Stimulus into the sendStimuli collection. It allows duplicates. Null values are not allowed.
     *
     *
     * @param sendStimulus The Stimulus to add to this collection
     * @throws IllegalArgumentException if sendStimulus is null
     */
    void addSendStimulus(Stimulus sendStimulus);

    /**
     * Adds the Stimulus instances into the sendStimuli collection. It allows duplicates. The collection
     * must not be null or contain null elements.
     *
     *
     * @param sendStimuli Collection of Stimulus instances to add to the contained collection
     * @throws IllegalArgumentException if sendStimuli is null or it contains null elements
     */
    void addSendStimuli(Collection<Stimulus> sendStimuli);

    /**
     * Removes the first instance, by reference, of the passed Stimulus, from the sendStimuli collection.
     * Since this is a collection, this operation does not guarantee which instance of the referenced
     * Stimulus will be removed if there are multiple references to the same instance in the collection.
     *
     *
     * @return true if the instance was in the collection and was successfully removed, false if it was
     * not removed, or did not exist in the collection
     * @param sendStimulus The Stimulus to remove from this collection
     * @throws IllegalArgumentException if sendStimulus is null
     */
    boolean removeSendStimulus(Stimulus sendStimulus);

    /**
     * Removes the first instance, by reference, of each passed Stimulus from the contained sendStimuli
     * collection. Since this is a collection, this operation does not guarantee which instance of the
     * referenced Stimulus will be removed if there are multiple references to the same instance in the
     * collection. This equally applies to the case if there are multiple duplicates in the passed collection.
     *
     *
     * @return boolean True if the state of the contained sendStimuli collection has changed, false otherwise.
     * @param sendStimuli Collection of Stimulus instances to remove from the contained collection
     * @throws IllegalArgumentException if sendStimuli is null or it contains null elements
     */
    boolean removeSendStimuli(Collection<Stimulus> sendStimuli);

    /**
     * Removes all elements from the sendStimuli collection.
     *
     */
    void clearSendStimuli();

    /**
     * Returns a shallow copy of the sendStimuli collection.
     *
     *
     * @return shallow copy of the sendStimuli collection
     */
    Collection<Stimulus> getSendStimuli();

    /**
     * Checks if the Stimulus is contained in the sendStimuli collection. The check is done by reference.
     *
     *
     * @return true if the Stimulus is in the collection, false otherwise
     * @param sendStimulus The Stimulus to check for its presence in this collection
     * @throws IllegalArgumentException if sendStimulus is null
     */
    boolean containsSendStimulus(Stimulus sendStimulus);

    /**
     * Returns the size of the sendStimuli collection.
     *
     *
     * @return the number of elements in the collection
     */
    int countSendStimuli();

    /**
     * Adds the Stimulus into the receiveStimuli collection. It allows duplicates. Null values are not allowed.
     *
     *
     * @param receiveStimulus The Stimulus to add to this collection
     * @throws IllegalArgumentException if receiveStimulus is null
     */
    void addReceiveStimulus(Stimulus receiveStimulus);

    /**
     * Adds the Stimulus instances into the receiveStimuli collection. It allows duplicates. The
     * collection must not be null or contain null elements.
     *
     *
     * @param receiveStimuli Collection of Stimulus instances to add to the contained collection
     * @throws IllegalArgumentException if receiveStimuli is null or it contains null elements
     */
    void addReceiveStimuli(Collection<Stimulus> receiveStimuli);

    /**
     * Removes the first instance, by reference, of the passed Stimulus, from the receiveStimuli
     * collection. Since this is a collection, this operation does not guarantee which instance of
     * the referenced Stimulus will be removed if there are multiple references to the same instance
     * in the collection.
     *
     *
     * @return true if the instance was in the collection and was successfully removed, false if it
     * was not removed, or did not exist in the collection
     * @param receiveStimulus The Stimulus to remove from this collection
     * @throws IllegalArgumentException if receiveStimulus is null
     */
    boolean removeReceiveStimulus(Stimulus receiveStimulus);

    /**
     * Removes the first instance, by reference, of each passed Stimulus from the contained
     * receiveStimuli collection. Since this is a collection, this operation does not guarantee
     * which instance of the referenced Stimulus will be removed if there are multiple references
     * to the same instance in the collection. This equally applies to the case if there are multiple
     * duplicates in the passed collection.
     *
     *
     * @return boolean True if the state of the contained receiveStimuli collection has changed, false otherwise.
     * @param receiveStimuli Collection of Stimulus instances to remove from the contained collection
     * @throws IllegalArgumentException if receiveStimuli is null or it contains null elements
     */
    boolean removeReceiveStimuli(Collection<Stimulus> receiveStimuli);

    /**
     * Removes all elements from the receiveStimuli collection.
     *
     */
    void clearReceiveStimuli();

    /**
     * Returns a shallow copy of the receiveStimuli collection.
     *
     *
     * @return shallow copy of the receiveStimuli collection
     */
    Collection<Stimulus> getReceiveStimuli();

    /**
     * Checks if the Stimulus is contained in the receiveStimuli collection. The check is done by reference.
     *
     *
     * @return true if the Stimulus is in the collection, false otherwise
     * @param receiveStimulus The Stimulus to check for its presence in this collection
     * @throws IllegalArgumentException if receiveStimulus is null
     */
    boolean containsReceiveStimulus(Stimulus receiveStimulus);

    /**
     * Returns the size of the receiveStimuli collection.
     *
     *
     * @return the number of elements in the collection
     */
    int countReceiveStimuli();
}
