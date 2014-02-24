/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.commonbehavior.instances;

import com.topcoder.uml.model.commonbehavior.Helper;
import com.topcoder.uml.model.commonbehavior.links.Link;
import com.topcoder.uml.model.commonbehavior.links.LinkEnd;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;
import com.topcoder.uml.model.core.StructuralFeature;

import java.util.ArrayList;
import java.util.Collection;

/**
 * <p>
 * This is a simple implementation of Instance interface and extends ModelElementAbstractImpl from the Core
 * Requirements component. The instance construct defines an entity to which a set of operations can be applied and
 * which has a state that stores the effects of the operations. In the metamodel, Instance is connected to at least
 * one Classifier that declares its structure and behavior. It has a set of attribute values and is connected to a
 * set of Links, both sets matching the definitions of its Classifiers. The two sets implement the current state of
 * the Instance. An Instance may also own other Instances or Links. As such, all methods in Instance are supported.
 * This class is declared as being abstract.
 * </p>
 *
 * <p>
 * <strong>Thread Safety</strong>
 * </p>
 * <p>
 * This class is mutable and not thread-safe.
 * </p>
 *
 * @author argolite, TCSDEVELOPER
 * @version 1.0
 */
public abstract class InstanceAbstractImpl extends ModelElementAbstractImpl implements Instance {
    /**
     * <p>
     * Represents The collection of Links that are owned by the Instance. It will support Link elements.
     * </p>
     *
     * <p>
     * This collection will be initialized upon construction, and will have many accessor methods, including adding
     * and removing an element or elements, checking if the element is in the collection (by reference), counting
     * the number of the elements, and finally clearing and getting the collection. Note that the whole collection
     * getter will only return a copy of the collection. Null values will not be allowed.
     * </p>
     *
     */
    private final Collection<Link> ownedLinks = new ArrayList<Link>();

    /**
     * <p>
     * Represents The collection of LinkEnds of the connected Links that are attached to the Instance. It will
     * support LinkEnd elements.
     * </p>
     *
     * <p>
     * This collection will be initialized upon construction, and will have many accessor methods, including adding
     * and removing an element or elements, checking if the element is in the collection (by reference), counting
     * the number of the elements, and finally clearing and getting the collection. Note that the whole collection
     * getter will only return a copy of the collection. Null values will not be allowed.
     * </p>
     *
     */
    private final Collection<LinkEnd> linkEnds = new ArrayList<LinkEnd>();

    /**
     * <p>
     * Represents The collection of Stimuli that send to this instance. It will support Stimulus elements.
     * </p>
     *
     * <p>
     * This collection will be initialized upon construction, and will have many accessor methods, including adding
     * and removing an element or elements, checking if the element is in the collection (by reference), counting
     * the number of the elements, and finally clearing and getting the collection. Note that the whole collection
     * getter will only return a copy of the collection. Null values will not be allowed.
     * </p>
     *
     */
    private final Collection<Stimulus> sendStimuli = new ArrayList<Stimulus>();

    /**
     * <p>
     * Represents The collection of Stimuli that receive from this instance. It will support Stimulus elements.
     * </p>
     *
     * <p>
     * This collection will be initialized upon construction, and will have many accessor methods, including adding
     * and removing an element or elements, checking if the element is in the collection (by reference), counting
     * the number of the elements, and finally clearing and getting the collection. Note that the whole collection
     * getter will only return a copy of the collection. Null values will not be allowed.
     * </p>
     *
     */
    private final Collection<Stimulus> receiveStimuli = new ArrayList<Stimulus>();

    /**
     * <p>
     * Represents the Classifier that declares the structure of the Instance.
     * </p>
     *
     * <p>
     * This value is set in the setter, and accessed with the getter. Null values are acceptable. There is no
     * validation performed on the setter.
     * </p>
     *
     */
    private Classifier classifier = null;

    /**
     * <p>
     * Empty constructor.
     * </p>
     *
     */
    protected InstanceAbstractImpl() {
        // empty
    }

    /**
     * Gets the classifier field value. Could be null.
     *
     *
     * @return classifier field value
     */
    public Classifier getClassifier() {
        return classifier;
    }

    /**
     * Sets the classifier field value. Null is allowed.
     *
     *
     * @param classifier
     *            classifier field value
     */
    public void setClassifier(Classifier classifier) {
        this.classifier = classifier;
    }

    /**
     * Adds the Link into the ownedLinks collection. It allows duplicates. Null values are not allowed.
     *
     *
     * @param ownedLink
     *            The Link to add to this collection
     * @throws IllegalArgumentException
     *             if ownedLink is null
     */
    public void addOwnedLink(Link ownedLink) {
        Helper.validateNotNull(ownedLink, "ownedLink");
        ownedLinks.add(ownedLink);
    }

    /**
     * Adds the Link instances into the ownedLinks collection. It allows duplicates. The collection must not be
     * null or contain null elements.
     *
     *
     * @param ownedLinks
     *            Collection of Link instances to add to the contained collection
     * @throws IllegalArgumentException
     *             if ownedLinks is null or it contains null elements
     */
    public void addOwnedLinks(Collection<Link> ownedLinks) {
        Helper.validateCollectionNotNullNotContainNull(ownedLinks, "ownedLinks");
        this.ownedLinks.addAll(ownedLinks);
    }

    /**
     * Removes the first instance, by reference, of the passed Link, from the ownedLinks collection. Since this is
     * a collection, this operation does not guarantee which instance of the referenced Link will be removed if
     * there are multiple references to the same instance in the collection.
     *
     *
     * @return true if the instance was in the collection and was successfully removed, false if it was not
     *         removed, or did not exist in the collection
     * @param ownedLink
     *            The Link to remove from this collection
     * @throws IllegalArgumentException
     *             if ownedLink is null
     */
    public boolean removeOwnedLink(Link ownedLink) {
        Helper.validateNotNull(ownedLink, "ownedLink");

        return ownedLinks.remove(ownedLink);
    }

    /**
     * Removes the instances, by reference, of each passed Link from the contained ownedLinks collection. Since
     * this is a collection, this operation does not guarantee which instance of the referenced Link will be
     * removed if there are multiple references to the same instance in the collection. This equally applies to the
     * case if there are multiple duplicates in the passed collection.
     *
     *
     * @return boolean True if the state of the contained ownedLinks collection has changed, false otherwise.
     * @param ownedLinks
     *            Collection of Link instances to remove from the contained collection
     * @throws IllegalArgumentException
     *             if ownedLinks is null or it contains null elements
     */
    public boolean removeOwnedLinks(Collection<Link> ownedLinks) {
        Helper.validateCollectionNotNullNotContainNull(ownedLinks, "ownedLinks");

        return Helper.removeAllFromCollection(this.ownedLinks, ownedLinks);
    }

    /**
     * Removes all elements from the ownedLinks collection.
     *
     */
    public void clearOwnedLinks() {
        ownedLinks.clear();
    }

    /**
     * Returns a shallow copy of the ownedLinks collection.
     *
     *
     * @return shallow copy of the ownedLinks collection
     */
    public Collection<Link> getOwnedLinks() {
        return new ArrayList<Link>(ownedLinks);
    }

    /**
     * Checks if the Link is contained in the ownedLinks collection. The check is done by reference.
     *
     *
     * @return true if the Link is in the collection, false otherwise
     * @param ownedLink
     *            The Link to check for its presence in this collection
     * @throws IllegalArgumentException
     *             if ownedLink is null
     */
    public boolean containsOwnedLink(Link ownedLink) {
        Helper.validateNotNull(ownedLink, "ownedLink");

        return ownedLinks.contains(ownedLink);
    }

    /**
     * Returns the size of the ownedLinks collection.
     *
     *
     * @return the number of elements in the collection
     */
    public int countOwnedLinks() {
        return ownedLinks.size();
    }

    /**
     * Adds the LinkEnd into the linkEnds collection. It allows duplicates. Null values are not allowed.
     *
     *
     * @param linkEnd
     *            The LinkEnd to add to this collection
     * @throws IllegalArgumentException
     *             if linkEnd is null
     */
    public void addLinkEnd(LinkEnd linkEnd) {
        Helper.validateNotNull(linkEnd, "linkEnd");
        linkEnds.add(linkEnd);
    }

    /**
     * Adds the LinkEnd instances into the linkEnds collection. It allows duplicates. The collection must not be
     * null or contain null elements.
     *
     *
     * @param linkEnds
     *            Collection of LinkEnd instances to add to the contained collection
     * @throws IllegalArgumentException
     *             if linkEnds is null or it contains null elements
     */
    public void addLinkEnds(Collection<LinkEnd> linkEnds) {
        Helper.validateCollectionNotNullNotContainNull(linkEnds, "linkEnds");
        this.linkEnds.addAll(linkEnds);
    }

    /**
     * Removes the first instance, by reference, of the passed LinkEnd, from the linkEnds collection. Since this is
     * a collection, this operation does not guarantee which instance of the referenced LinkEnd will be removed if
     * there are multiple references to the same instance in the collection.
     *
     *
     * @return true if the instance was in the collection and was successfully removed, false if it was not
     *         removed, or did not exist in the collection
     * @param linkEnd
     *            The LinkEnd to remove from this collection
     * @throws IllegalArgumentException
     *             if linkEnd is null
     */
    public boolean removeLinkEnd(LinkEnd linkEnd) {
        Helper.validateNotNull(linkEnd, "linkEnd");

        return linkEnds.remove(linkEnd);
    }

    /**
     * Removes the instances, by reference, of each passed LinkEnd from the contained linkEnds collection. Since
     * this is a collection, this operation does not guarantee which instance of the referenced LinkEnd will be
     * removed if there are multiple references to the same instance in the collection. This equally applies to the
     * case if there are multiple duplicates in the passed collection.
     *
     *
     * @return boolean True if the state of the contained linkEnds collection has changed, false otherwise.
     * @param linkEnds
     *            Collection of LinkEnd instances to remove from the contained collection
     * @throws IllegalArgumentException
     *             if linkEnds is null or it contains null elements
     */
    public boolean removeLinkEnds(Collection<LinkEnd> linkEnds) {
        Helper.validateCollectionNotNullNotContainNull(linkEnds, "linkEnds");

        return Helper.removeAllFromCollection(this.linkEnds, linkEnds);
    }

    /**
     * Removes all elements from the linkEnds collection.
     *
     */
    public void clearLinkEnds() {
        linkEnds.clear();
    }

    /**
     * Returns a shallow copy of the linkEnds collection.
     *
     *
     * @return shallow copy of the linkEnds collection
     */
    public Collection<LinkEnd> getLinkEnds() {
        return new ArrayList<LinkEnd>(linkEnds);
    }

    /**
     * Checks if the LinkEnd is contained in the linkEnds collection. The check is done by reference.
     *
     *
     * @return true if the LinkEnd is in the collection, false otherwise
     * @param linkEnd
     *            The LinkEnd to check for its presence in this collection
     * @throws IllegalArgumentException
     *             if linkEnd is null
     */
    public boolean containsLinkEnd(LinkEnd linkEnd) {
        Helper.validateNotNull(linkEnd, "linkEnd");

        return linkEnds.contains(linkEnd);
    }

    /**
     * Returns the size of the linkEnds collection.
     *
     *
     * @return the number of elements in the collection
     */
    public int countLinkEnds() {
        return linkEnds.size();
    }

    /**
     * Adds the Stimulus into the sendStimuli collection. It allows duplicates. Null values are not allowed.
     *
     *
     * @param sendStimulus
     *            The Stimulus to add to this collection
     * @throws IllegalArgumentException
     *             if sendStimulus is null
     */
    public void addSendStimulus(Stimulus sendStimulus) {
        Helper.validateNotNull(sendStimulus, "sendStimulus");
        sendStimuli.add(sendStimulus);
    }

    /**
     * Adds the Stimulus instances into the sendStimuli collection. It allows duplicates. The collection must not
     * be null or contain null elements.
     *
     *
     * @param sendStimuli
     *            Collection of Stimulus instances to add to the contained collection
     * @throws IllegalArgumentException
     *             if sendStimuli is null or it contains null elements
     */
    public void addSendStimuli(Collection<Stimulus> sendStimuli) {
        Helper.validateCollectionNotNullNotContainNull(sendStimuli, "sendStimuli");
        this.sendStimuli.addAll(sendStimuli);
    }

    /**
     * Removes the first instance, by reference, of the passed Stimulus, from the sendStimuli collection. Since
     * this is a collection, this operation does not guarantee which instance of the referenced Stimulus will be
     * removed if there are multiple references to the same instance in the collection.
     *
     *
     * @return true if the instance was in the collection and was successfully removed, false if it was not
     *         removed, or did not exist in the collection
     * @param sendStimulus
     *            The Stimulus to remove from this collection
     * @throws IllegalArgumentException
     *             if sendStimulus is null
     */
    public boolean removeSendStimulus(Stimulus sendStimulus) {
        Helper.validateNotNull(sendStimulus, "sendStimulus");

        return sendStimuli.remove(sendStimulus);
    }

    /**
     * Removes the instances, by reference, of each passed Stimulus from the contained sendStimuli collection.
     * Since this is a collection, this operation does not guarantee which instance of the referenced Stimulus will
     * be removed if there are multiple references to the same instance in the collection. This equally applies to
     * the case if there are multiple duplicates in the passed collection.
     *
     *
     * @return boolean True if the state of the contained sendStimuli collection has changed, false otherwise.
     * @param sendStimuli
     *            Collection of Stimulus instances to remove from the contained collection
     * @throws IllegalArgumentException
     *             if sendStimuli is null or it contains null elements
     */
    public boolean removeSendStimuli(Collection<Stimulus> sendStimuli) {
        Helper.validateCollectionNotNullNotContainNull(sendStimuli, "sendStimuli");

        return Helper.removeAllFromCollection(this.sendStimuli, sendStimuli);
    }

    /**
     * Removes all elements from the sendStimuli collection.
     *
     */
    public void clearSendStimuli() {
        sendStimuli.clear();
    }

    /**
     * Returns a shallow copy of the sendStimuli collection.
     *
     *
     * @return shallow copy of the sendStimuli collection
     */
    public Collection<Stimulus> getSendStimuli() {
        return new ArrayList<Stimulus>(sendStimuli);
    }

    /**
     * Checks if the Stimulus is contained in the sendStimuli collection. The check is done by reference.
     *
     *
     * @return true if the Stimulus is in the collection, false otherwise
     * @param sendStimulus
     *            The Stimulus to check for its presence in this collection
     * @throws IllegalArgumentException
     *             if sendStimulus is null
     */
    public boolean containsSendStimulus(Stimulus sendStimulus) {
        Helper.validateNotNull(sendStimulus, "sendStimulus");

        return sendStimuli.contains(sendStimulus);
    }

    /**
     * Returns the size of the sendStimuli collection.
     *
     *
     * @return the number of elements in the collection
     */
    public int countSendStimuli() {
        return sendStimuli.size();
    }

    /**
     * Adds the Stimulus into the receiveStimuli collection. It allows duplicates. Null values are not allowed.
     *
     *
     * @param receiveStimulus
     *            The Stimulus to add to this collection
     * @throws IllegalArgumentException
     *             if receiveStimulus is null
     */
    public void addReceiveStimulus(Stimulus receiveStimulus) {
        Helper.validateNotNull(receiveStimulus, "receiveStimulus");
        receiveStimuli.add(receiveStimulus);
    }

    /**
     * Adds the Stimulus instances into the receiveStimuli collection. It allows duplicates. The collection must
     * not be null or contain null elements.
     *
     *
     * @param receiveStimuli
     *            Collection of Stimulus instances to add to the contained collection
     * @throws IllegalArgumentException
     *             if receiveStimuli is null or it contains null elements
     */
    public void addReceiveStimuli(Collection<Stimulus> receiveStimuli) {
        Helper.validateCollectionNotNullNotContainNull(receiveStimuli, "receiveStimuli");
        this.receiveStimuli.addAll(receiveStimuli);
    }

    /**
     * Removes the first instance, by reference, of the passed Stimulus, from the receiveStimuli collection. Since
     * this is a collection, this operation does not guarantee which instance of the referenced Stimulus will be
     * removed if there are multiple references to the same instance in the collection.
     *
     *
     * @return true if the instance was in the collection and was successfully removed, false if it was not
     *         removed, or did not exist in the collection
     * @param receiveStimulus
     *            The Stimulus to remove from this collection
     * @throws IllegalArgumentException
     *             if receiveStimulus is null
     */
    public boolean removeReceiveStimulus(Stimulus receiveStimulus) {
        Helper.validateNotNull(receiveStimulus, "receiveStimulus");

        return receiveStimuli.remove(receiveStimulus);
    }

    /**
     * Removes the instances, by reference, of each passed Stimulus from the contained receiveStimuli collection.
     * Since this is a collection, this operation does not guarantee which instance of the referenced Stimulus will
     * be removed if there are multiple references to the same instance in the collection. This equally applies to
     * the case if there are multiple duplicates in the passed collection.
     *
     *
     * @return boolean True if the state of the contained receiveStimuli collection has changed, false otherwise.
     * @param receiveStimuli
     *            Collection of Stimulus instances to remove from the contained collection
     * @throws IllegalArgumentException
     *             if receiveStimuli is null or it contains null elements
     */
    public boolean removeReceiveStimuli(Collection<Stimulus> receiveStimuli) {
        Helper.validateCollectionNotNullNotContainNull(receiveStimuli, "receiveStimuli");

        return Helper.removeAllFromCollection(this.receiveStimuli, receiveStimuli);
    }

    /**
     * Removes all elements from the receiveStimuli collection.
     *
     */
    public void clearReceiveStimuli() {
        receiveStimuli.clear();
    }

    /**
     * Returns a shallow copy of the receiveStimuli collection.
     *
     *
     * @return shallow copy of the receiveStimuli collection
     */
    public Collection<Stimulus> getReceiveStimuli() {
        return new ArrayList<Stimulus>(receiveStimuli);
    }

    /**
     * Checks if the Stimulus is contained in the receiveStimuli collection. The check is done by reference.
     *
     *
     * @return true if the Stimulus is in the collection, false otherwise
     * @param receiveStimulus
     *            The Stimulus to check for its presence in this collection
     * @throws IllegalArgumentException
     *             if receiveStimulus is null
     */
    public boolean containsReceiveStimulus(Stimulus receiveStimulus) {
        Helper.validateNotNull(receiveStimulus, "receiveStimulus");

        return receiveStimuli.contains(receiveStimulus);
    }

    /**
     * Returns the size of the receiveStimuli collection.
     *
     *
     * @return the number of elements in the collection
     */
    public int countReceiveStimuli() {
        return receiveStimuli.size();
    }

    /**
     * Forcing two way association.
     *
     * @param structuralFeature
     * @param type
     */
    public static void setClassifier(Instance instance, Classifier type) {
        // forcing two way associations
        if (instance.getClassifier() != null) {
            instance.getClassifier().removeInstance(instance);
        }
        instance.setClassifier(type);
        if (type != null) {
            if (!type.containsInstance(instance)) {
                type.addInstance(instance);
            }
        }
    }
}
