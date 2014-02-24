/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.commonbehavior.links;

import com.topcoder.uml.model.commonbehavior.instances.Instance;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.core.ModelElement;

import java.util.Collection;
import java.util.List;


/**
 * <p>This interface extends ModelElement interface. The ModelElement interface comes form the Core
 * Requirements component. The link construct is a connection between instances. In the metamodel,
 * Link is an instance of an Association. It has a set of LinkEnds that matches the set of
 * AssociationEnds of the Association. A Link defines a connection between Instances.</p>
 *
 * <p><strong>Thread Safety</strong></p>
 * <p>Implementations do not have to be thread-safe. In fact, method synchronization is discouraged.
 * Thread safety will be provided by the application using these implementations.</p>
 * @author argolite, TCSDEVELOPER
 * @version 1.0
 */
public interface Link extends ModelElement {
    /**
     * Gets the owner field value. Could be null.
     *
     *
     * @return owner field value
     */
    Instance getOwner();

    /**
     * Sets the owner field value. Null is allowed.
     *
     *
     * @param owner owner field value
     */
    void setOwner(Instance owner);

    /**
     * Appends the LinkEnd to the connections list. It allows duplicates. Null values are not allowed.
     * This is equivalent to using addConnection(countConnections(), connection).
     *
     *
     * @param connection The LinkEnd to add to this list
     * @throws IllegalArgumentException if connection is null
     */
    void addConnection(LinkEnd connection);

    /**
     * Adds the LinkEnd at the index position in the connections list. It allows duplicates. Null values
     * are not allowed. Note that adding at index = countConnections() is equivalent to calling
     * addConnection(connection).
     *
     *
     * @param index the position to insert this LinkEnd in this list
     * @param connection The LinkEnd to add to this list
     * @throws IllegalArgumentException if connection is null
     * @throws IndexOutOfBoundsException if index < 0 or index > connections.size()
     */
    void addConnection(int index, LinkEnd connection);

    /**
     * Appends the LinkEnd instance to the connections list. It allows duplicates. Null values are not
     * allowed. This is equivalent to using addConnections(countConnections(), connections).
     *
     *
     * @param connections The LinkEnd collection to add to this list
     * @throws IllegalArgumentException if connections is null or contains null elements.
     */
    void addConnections(Collection<LinkEnd> connections);

    /**
     * Adds the LinkEnd instances at the index position in the contained connections list. It allows
     * duplicates. Null values are not allowed. Note that adding at index = countConnections() is
     * equivalent to calling addConnections(connections).
     *
     *
     * @param index the position to insert this LinkEnd collection in this list
     * @param connections The LinkEnd collection to add to this list
     * @throws IllegalArgumentException if connections is null or contains null elements
     * @throws IndexOutOfBoundsException if index < 0 or index > countQualifiers()
     */
    void addConnections(int index, Collection<LinkEnd> connections);

    /**
     * Sets the LinkEnd at the index position in the connections list. Null values are not allowed.
     *
     *
     * @param index the position to set this LinkEnd in this list
     * @param connection The LinkEnd to set in this list
     * @throws IllegalArgumentException if connection is null
     * @throws IndexOutOfBoundsException if index < 0 or index >= connections.size()
     */
    void setConnection(int index, LinkEnd connection);

    /**
     * Removes the LinkEnd instance at the index position from the connections list.
     *
     *
     * @return LinkEnd The removed LinkEnd
     * @param index the position of the LinkEnd in this list to remove
     * @throws IndexOutOfBoundsException if index < 0 or index >= connections.size()
     */
    LinkEnd removeConnection(int index);

    /**
     * Removes the first instance, by reference, of the passed LinkEnd, from the connections list.
     *
     *
     * @return true if the instance was in the list and was successfully removed, false if it was not
     * removed, or did not exist in the list
     * @param connection The LinkEnd to remove from this list
     * @throws IllegalArgumentException if connection is null
     */
    boolean removeConnection(LinkEnd connection);

    /**
     * Removes the instances, by reference, of each passed LinkEnd from the contained connections
     * list. It will iterate via the passed collection using its iterator and remove the first instance,
     * by reference, of each passed LinkEnd, from the contained connections list.
     *
     *
     * @return boolean True if the state of the contained connections list has changed, false otherwise.
     * @param connections Collection of LinkEnd instances to remove from the contained list
     * @throws IllegalArgumentException if connections is null or it contains null elements
     */
    boolean removeConnections(Collection<LinkEnd> connections);

    /**
     * Removes all elements from the connections list.
     *
     */
    void clearConnections();

    /**
     * Returns a shallow copy of the connections list.
     *
     *
     * @return shallow copy of the connections list
     */
    List<LinkEnd> getConnections();

    /**
     * Checks if the LinkEnd is contained in the connections list. The check is done by reference.
     *
     *
     * @return true if the LinkEnd is in the list, false otherwise
     * @param connection The LinkEnd to check for its presence in this list
     * @throws IllegalArgumentException if connection is null
     */
    boolean containsConnection(LinkEnd connection);

    /**
     * Gets the index of the appearance of the LinkEnd, by reference, in the connections list. It will
     * always return the index of the first instance of the LinkEnd if there are duplicates in the list.
     * It will return -1 if the LinkEnd instance is not in the list.
     *
     *
     * @return the index of the LinkEnd instance in the list, or -1 if not found
     * @param connection LinkEnd instance to look for
     * @throws IllegalArgumentException if argument is null.
     */
    int indexOfConnection(LinkEnd connection);

    /**
     * Returns the size of the connections list.
     *
     *
     * @return the number of elements in the list
     */
    int countConnections();

    /**
     * Adds the Stimulus into the stimuli collection. It allows duplicates. Null values are not allowed.
     *
     *
     * @param stimulus The Stimulus to add to this collection
     * @throws IllegalArgumentException if stimulus is null
     */
    void addStimulus(Stimulus stimulus);

    /**
     * Adds the Stimulus instances into the stimuli collection. It allows duplicates. The collection must
     * not be null or contain null elements.
     *
     *
     * @param stimuli Collection of Stimulus instances to add to the contained collection
     * @throws IllegalArgumentException if stimuli is null or it contains null elements
     */
    void addStimuli(Collection<Stimulus> stimuli);

    /**
     * Removes the first instance, by reference, of the passed Stimulus, from the stimuli collection.
     * Since this is a collection, this operation does not guarantee which instance of the referenced
     * Stimulus will be removed if there are multiple references to the same instance in the collection.
     *
     *
     * @return true if the instance was in the collection and was successfully removed, false if it was
     * not removed, or did not exist in the collection
     * @param stimulus The Stimulus to remove from this collection
     * @throws IllegalArgumentException if stimulus is null
     */
    boolean removeStimulus(Stimulus stimulus);

    /**
     * Removes the instances, by reference, of each passed Stimulus from the contained stimuli
     * collection. Since this is a collection, this operation does not guarantee which instance of the
     * referenced Stimulus will be removed if there are multiple references to the same instance in the
     * collection. This equally applies to the case if there are multiple duplicates in the passed collection.
     *
     *
     * @return boolean True if the state of the contained stimuli collection has changed, false otherwise.
     * @param stimuli Collection of Stimulus instances to remove from the contained collection
     * @throws IllegalArgumentException if stimuli is null or it contains null elements
     */
    boolean removeStimuli(Collection<Stimulus> stimuli);

    /**
     * Removes all elements from the stimuli collection.
     *
     */
    void clearStimuli();

    /**
     * Returns a shallow copy of the stimuli collection.
     *
     *
     * @return shallow copy of the stimuli collection
     */
    Collection<Stimulus> getStimuli();

    /**
     * Checks if the Stimulus is contained in the stimuli collection. The check is done by reference.
     *
     *
     * @return true if the Stimulus is in the collection, false otherwise
     * @param stimulus The Stimulus to check for its presence in this collection
     * @throws IllegalArgumentException if stimulus is null
     */
    boolean containsStimulus(Stimulus stimulus);

    /**
     * Returns the size of the stimuli collection.
     *
     *
     * @return the number of elements in the collection
     */
    int countStimuli();
}
