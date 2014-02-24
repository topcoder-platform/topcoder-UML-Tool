/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.commonbehavior.links;

import com.topcoder.uml.model.commonbehavior.Helper;
import com.topcoder.uml.model.commonbehavior.instances.Instance;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


/**
 * <p>This is a simple concrete implementation of Link interface and extends ModelElementAbstractImpl
 * from the Core Requirements component. The link construct is a connection between instances. In the metamodel,
 * Link is an instance of an Association. It has a set of LinkEnds that matches the set of
 * AssociationEnds of the Association. A Link defines a connection between Instances.
 * As such, all methods in Link are supported.</p>
 *
 * <p><strong>Thread Safety</strong></p>
 * <p>This class is mutable and not thread-safe.</p>
 * @author argolite, TCSDEVELOPER
 * @version 1.0
 */
public class LinkImpl extends ModelElementAbstractImpl implements Link {
    /**
     * <p>Represents Specifies the Instance that owns the Link.</p>
     * <p>This value is set in the setter, and accessed with the getter. Null values are acceptable.
     * There is no validation performed on the setter.</p>
     *
     */
    private Instance owner = null;

    /**
     * <p>Represents The list of LinkEnds that constitute the Link. It will support LinkEnd elements.</p>
     * <p>This list will be initialized upon construction, and will have many accessor methods, including
     * adding and removing an element or elements by reference or position, checking if the element is in
     * the list (by reference), counting the number of the elements, getting an element at a position, and
     * finally clearing and getting the list. Note that the whole list getter will only return a copy of
     * the list. Null values will not be allowed.</p>
     *
     */
    private final List<LinkEnd> connections = new ArrayList<LinkEnd>();

    /**
     * <p>Represents collection of stimuli related to this link. It will support Stimulus elements.</p>
     * <p>This collection will be initialized upon construction, and will have many accessor methods,
     * including adding and removing an element or elements, checking if the element is in the collection
     * (by reference), counting the number of the elements, and finally clearing and getting the
     * collection. Note that the whole collection getter will only return a copy of the collection.
     * Null values will not be allowed.</p>
     *
     */
    private final Collection<Stimulus> stimuli = new ArrayList<Stimulus>();

    /**
     * <p>Empty constructor.</p>
     *
     */
    public LinkImpl() {
    }

    /**
     * Gets the owner field value. Could be null.
     *
     *
     * @return owner field value
     */
    public Instance getOwner() {
        return owner;
    }

    /**
     * Sets the owner field value. Null is allowed.
     *
     *
     * @param owner owner field value
     */
    public void setOwner(Instance owner) {
        this.owner = owner;
    }

    /**
     * Appends the LinkEnd to the connections list. It allows duplicates. Null values are not allowed.
     * This is equivalent to using addConnection(countConnections(), connection).
     *
     *
     * @param connection The LinkEnd to add to this list
     * @throws IllegalArgumentException if connection is null
     */
    public void addConnection(LinkEnd connection) {
        Helper.validateNotNull(connection, "connection");
        connections.add(connection);
    }

    /**
     * Adds the LinkEnd at the index position in the connections list. It allows duplicates.
     * Null values are not allowed. Note that adding at index = countConnections() is equivalent
     * to calling addConnection(connection).
     *
     *
     * @param index the position to insert this LinkEnd in this list
     * @param connection The LinkEnd to add to this list
     * @throws IllegalArgumentException if connection is null
     * @throws IndexOutOfBoundsException if index < 0 or index > connections.size()
     */
    public void addConnection(int index, LinkEnd connection) {
        Helper.validateNotNull(connection, "connection");
        Helper.validateIndexRange(index, connections.size(), "[0, connections.size()]");
        connections.add(index, connection);
    }

    /**
     * Appends the LinkEnd instance to the connections list. It allows duplicates. Null values
     * are not allowed. This is equivalent to using addConnections(countConnections(), connections).
     *
     *
     * @param connections The LinkEnd collection to add to this list
     * @throws IllegalArgumentException if connections is null or contains null elements.
     */
    public void addConnections(Collection<LinkEnd> connections) {
        Helper.validateCollectionNotNullNotContainNull(connections, "connections");
        this.connections.addAll(connections);
    }

    /**
     * Adds the LinkEnd instances at the index position in the contained connections list.
     * It allows duplicates. Null values are not allowed. Note that adding at
     * index = countConnections() is equivalent to calling addConnections(connections).
     *
     *
     * @param index the position to insert this LinkEnd collection in this list
     * @param connections The LinkEnd collection to add to this list
     * @throws IllegalArgumentException if connections is null or contains null elements
     * @throws IndexOutOfBoundsException if index < 0 or index > countConnections()
     */
    public void addConnections(int index, Collection<LinkEnd> connections) {
        Helper.validateCollectionNotNullNotContainNull(connections, "connections");
        Helper.validateIndexRange(index, this.connections.size(), "[0, connections.size()]");
        this.connections.addAll(index, connections);
    }

    /**
     * Sets the LinkEnd at the index position in the connections list. Null values are not allowed.
     *
     *
     * @param index the position to set this LinkEnd in this list
     * @param connection The LinkEnd to set in this list
     * @throws IllegalArgumentException if connection is null
     * @throws IndexOutOfBoundsException if index < 0 or index >= connections.size()
     */
    public void setConnection(int index, LinkEnd connection) {
        Helper.validateNotNull(connection, "connection");
        Helper.validateIndexRange(index, connections.size() - 1, "[0, connections.size())");
        connections.set(index, connection);
    }

    /**
     * Removes the LinkEnd instance at the index position from the connections list.
     *
     *
     * @return LinkEnd The removed LinkEnd
     * @param index the position of the LinkEnd in this list to remove
     * @throws IndexOutOfBoundsException if index < 0 or index >= connections.size()
     */
    public LinkEnd removeConnection(int index) {
        Helper.validateIndexRange(index, connections.size() - 1, "[0, connections.size())");

        return connections.remove(index);
    }

    /**
     * Removes the first instance, by reference, of the passed LinkEnd, from the connections list.
     *
     *
     * @return true if the instance was in the list and was successfully removed, false if it was not
     * removed, or did not exist in the list
     * @param connection The LinkEnd to remove from this list
     * @throws IllegalArgumentException if connection is null
     */
    public boolean removeConnection(LinkEnd connection) {
        Helper.validateNotNull(connection, "connection");

        return connections.remove(connection);
    }

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
    public boolean removeConnections(Collection<LinkEnd> connections) {
        Helper.validateCollectionNotNullNotContainNull(connections, "connections");

        return Helper.removeAllFromCollection(this.connections, connections);
    }

    /**
     * Removes all elements from the connections list.
     *
     */
    public void clearConnections() {
        connections.clear();
    }

    /**
     * Returns a shallow copy of the connections list.
     *
     *
     * @return shallow copy of the connections list
     */
    public List<LinkEnd> getConnections() {
        return new ArrayList<LinkEnd>(connections);
    }

    /**
     * Checks if the LinkEnd is contained in the connections list. The check is done by reference.
     *
     *
     * @return true if the LinkEnd is in the list, false otherwise
     * @param connection The LinkEnd to check for its presence in this list
     * @throws IllegalArgumentException if connection is null
     */
    public boolean containsConnection(LinkEnd connection) {
        Helper.validateNotNull(connection, "connection");

        return connections.contains(connection);
    }

    /**
     * Gets the index of the appearance of the LinkEnd, by reference, in the connections list.
     * It will always return the index of the first instance of the LinkEnd if there are duplicates
     * in the list. It will return -1 if the LinkEnd instance is not in the list.
     *
     *
     * @return the index of the LinkEnd instance in the list, or -1 if not found
     * @param connection LinkEnd instance to look for
     * @throws IllegalArgumentException if argument is null.
     */
    public int indexOfConnection(LinkEnd connection) {
        Helper.validateNotNull(connection, "connection");

        return connections.indexOf(connection);
    }

    /**
     * Returns the size of the connections list.
     *
     *
     * @return the number of elements in the list
     */
    public int countConnections() {
        return connections.size();
    }

    /**
     * Adds the Stimulus into the stimuli collection. It allows duplicates. Null values are not allowed.
     *
     *
     * @param stimulus The Stimulus to add to this collection
     * @throws IllegalArgumentException if stimulus is null
     */
    public void addStimulus(Stimulus stimulus) {
        Helper.validateNotNull(stimulus, "stimulus");
        stimuli.add(stimulus);
    }

    /**
     * Adds the Stimulus instances into the stimuli collection. It allows duplicates. The collection
     * must not be null or contain null elements.
     *
     *
     * @param stimuli Collection of Stimulus instances to add to the contained collection
     * @throws IllegalArgumentException if stimuli is null or it contains null elements
     */
    public void addStimuli(Collection<Stimulus> stimuli) {
        Helper.validateCollectionNotNullNotContainNull(stimuli, "stimuli");
        this.stimuli.addAll(stimuli);
    }

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
    public boolean removeStimulus(Stimulus stimulus) {
        Helper.validateNotNull(stimulus, "stimulus");

        return stimuli.remove(stimulus);
    }

    /**
     * Removes the instances, by reference, of each passed Stimulus from the contained stimuli
     * collection. Since this is a collection, this operation does not guarantee which instance of
     * the referenced Stimulus will be removed if there are multiple references to the same instance
     * in the collection. This equally applies to the case if there are multiple duplicates in the
     * passed collection.
     *
     *
     * @return boolean True if the state of the contained stimuli collection has changed, false otherwise.
     * @param stimuli Collection of Stimulus instances to remove from the contained collection
     * @throws IllegalArgumentException if stimuli is null or it contains null elements
     */
    public boolean removeStimuli(Collection<Stimulus> stimuli) {
        Helper.validateCollectionNotNullNotContainNull(stimuli, "stimuli");

        return Helper.removeAllFromCollection(this.stimuli, stimuli);
    }

    /**
     * Removes all elements from the stimuli collection.
     *
     */
    public void clearStimuli() {
        stimuli.clear();
    }

    /**
     * Returns a shallow copy of the stimuli collection.
     *
     *
     * @return shallow copy of the stimuli collection
     */
    public Collection<Stimulus> getStimuli() {
        return new ArrayList<Stimulus>(stimuli);
    }

    /**
     * Checks if the Stimulus is contained in the stimuli collection. The check is done by reference.
     *
     *
     * @return true if the Stimulus is in the collection, false otherwise
     * @param stimulus The Stimulus to check for its presence in this collection
     * @throws IllegalArgumentException if stimulus is null
     */
    public boolean containsStimulus(Stimulus stimulus) {
        Helper.validateNotNull(stimulus, "stimulus");

        return stimuli.contains(stimulus);
    }

    /**
     * Returns the size of the stimuli collection.
     *
     *
     * @return the number of elements in the collection
     */
    public int countStimuli() {
        return stimuli.size();
    }
}
