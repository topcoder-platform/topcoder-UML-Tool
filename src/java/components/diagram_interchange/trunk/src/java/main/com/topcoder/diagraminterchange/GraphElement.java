/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * <p>
 * GraphElements are linked via GraphConnector. A GraphElement can own any number of GraphConnectors, called
 * anchorages. GraphElement extends DiagramElement. A GraphElement can contain any number of DiagramElements.
 * A GraphElement can contain any number of sub-Diagrams through the DiagramLink class.
 * </p>
 * <p>
 * <b>Thread Safety:</b> This class is abstract but has no abstract methods. This class is mutable and is not
 * thread-safe, since thread safety is not required. Instead, the calling application is required to ensure
 * thread safety.
 * </p>
 *
 * @author caru, TCSDEVELOPER
 * @version 1.0
 */
public abstract class GraphElement extends DiagramElement {

    /**
     * <p>
     * Represents the position Point. It is relative to container position. Can be null. Default to null.
     * </p>
     */
    private Point position;

    /**
     * <p>
     * Represents the SemanticModelBridge associated to this GraphElement. Can be null. Default to null.
     * </p>
     */
    private SemanticModelBridge semanticModel;

    /**
     * <p>
     * Represents the DiagramElements contained in this GraphElement. Can never be null. Can be empty.
     * Elements cannot be null. There can be duplicated elements. Default to empty.
     * </p>
     */
    private final List<DiagramElement> containeds = new ArrayList<DiagramElement>();

    /**
     * <p>
     * Represents the anchorages of this GraphElement. They permit any number of GraphEdge to connect them.
     * Can never be null. Can be empty. Elements cannot be null. There can be duplicated elements. Default to
     * empty.
     * </p>
     */
    private final List<GraphConnector> anchorages = new ArrayList<GraphConnector>();

    /**
     * <p>
     * Represents the Diagrams linked to this GraphElement via DiagramLink. Can never be null. Can be empty.
     * Elements cannot be null. There can be duplicated elements. Default to empty.
     * </p>
     */
    private final Collection<DiagramLink> links = new ArrayList<DiagramLink>();

    /**
     * <p>
     * This method is called by subtypes of GraphElement.
     * </p>
     */
    protected GraphElement() {
        super();
    }

    /**
     * <p>
     * Gets the position Point.
     * </p>
     *
     * @return the position Point
     */
    public Point getPosition() {
        return position;
    }

    /**
     * <p>
     * Sets the position Point. Can be null.
     * </p>
     *
     * @param position the new position Point
     */
    public void setPosition(Point position) {
        this.position = position;
    }

    /**
     * <p>
     * Gets the SemanticModelBridge associated to this GraphElement.
     * </p>
     *
     * @return the SemanticModelBridge associated to this GraphElement
     */
    public SemanticModelBridge getSemanticModel() {
        return semanticModel;
    }

    /**
     * <p>
     * Sets the SemanticModelBridge associated to this GraphElement. Can be null.
     * </p>
     *
     * @param semanticModel the new SemanticModelBridge associated to this GraphElement
     */
    public void setSemanticModel(SemanticModelBridge semanticModel) {
        this.semanticModel = semanticModel;
    }

    /**
     * <p>
     * Appends a DiagramElement to this GraphElement at the end.
     * </p>
     *
     * @param contained the DiagramElement to be appended
     * @throws IllegalArgumentException if contained is null
     */
    public void addContained(DiagramElement contained) {
        if (contained == null) {
            throw new IllegalArgumentException("the DiagramElement can not be null");
        }
        containeds.add(contained);
    }

    /**
     * <p>
     * Inserts a DiagramElement to this GraphElement at the given position. Shifts the element currently at
     * that position (if any) and any subsequent elements to the right (adds one to their indices).
     * </p>
     *
     * @param index the index at which the DiagramElement is to be inserted
     * @param contained the DiagramElement to be inserted
     * @throws IllegalArgumentException if contained is null, or index is out of range (index < 0 || index >
     *         countContaineds())
     */
    public void addContained(int index, DiagramElement contained) {
        if (contained == null) {
            throw new IllegalArgumentException("the DiagramElement can not be null");
        }
        if (index < 0) {
            throw new IllegalArgumentException("index can not be less than 0");
        }
        if (index > containeds.size()) {
            throw new IllegalArgumentException("index can not be larger than size");
        }
        containeds.add(index, contained);
    }

    /**
     * <p>
     * Replaces the DiagramElement contained in this GraphElement at the given position with the specified
     * one.
     * </p>
     *
     * @param index the index of the DiagramElement to replace
     * @param contained the DiagramElement to be stored
     * @throws IllegalArgumentException if contained is null, or index is out of range (index < 0 || index >=
     *         countContaineds())
     */
    public void setContained(int index, DiagramElement contained) {
        if (contained == null) {
            throw new IllegalArgumentException("the DiagramElement can not be null");
        }
        if (index < 0) {
            throw new IllegalArgumentException("index can not be less than 0");
        }
        if (index >= containeds.size()) {
            throw new IllegalArgumentException("index can not be larger than or equal to size");
        }
        containeds.set(index, contained);
    }

    /**
     * <p>
     * Removes the DiagramElement from this GraphElement at the specified position. All subsequent elements
     * are shifted to the left. Returns the removed DiagramElement.
     * </p>
     *
     * @param index the index of the DiagramElement to be removed
     * @return the removed DiagramElement
     * @throws IllegalArgumentException if index is out of range (index < 0 || index >= countContaineds())
     */
    public DiagramElement removeContained(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("index can not be less than 0");
        }
        if (index >= containeds.size()) {
            throw new IllegalArgumentException("index can not be larger than or equal to size");
        }
        return containeds.remove(index);
    }

    /**
     * <p>
     * Removes the DiagramElement from this GraphElement. If the DiagramElement is a duplicated element, only
     * the first one is removed. Returns true if the DiagramElement is removed, false otherwise.
     * </p>
     *
     * @param contained the DiagramElement to be removed
     * @return true if the element is removed, false otherwise
     * @throws IllegalArgumentException if contained is null
     */
    public boolean removeContained(DiagramElement contained) {
        if (contained == null) {
            throw new IllegalArgumentException("the DiagramElement can not be null");
        }
        return containeds.remove(contained);
    }

    /**
     * <p>
     * Removes all the DiagramElements contained in this GraphElement.
     * </p>
     */
    public void clearContaineds() {
        containeds.clear();
    }

    /**
     * <p>
     * Returns a copy of the DiagramElements contained in this GraphElement.
     * </p>
     *
     * @return a copy of the DiagramElements contained in this GraphElement
     */
    public List<DiagramElement> getContaineds() {
        return new ArrayList<DiagramElement>(containeds);
    }

    /**
     * <p>
     * Returns true if the DiagramElement is contained in this GraphElement, false otherwise.
     * </p>
     *
     * @param contained the DiagramElement to be checked for inclusion
     * @return true if the DiagramElement is contained in this GraphElement, false otherwise
     * @throws IllegalArgumentException if contained is null
     */
    public boolean containsContained(DiagramElement contained) {
        if (contained == null) {
            throw new IllegalArgumentException("the DiagramElement can not be null");
        }
        return containeds.contains(contained);
    }

    /**
     * <p>
     * Returns the index of the first occurrence of the given DiagramElement in this GraphElement.
     * </p>
     *
     * @param contained the DiagramElement to search for
     * @return the position of the DiagramElement, -1 if not found
     * @throws IllegalArgumentException if contained is null
     */
    public int indexOfContained(DiagramElement contained) {
        if (contained == null) {
            throw new IllegalArgumentException("the DiagramElement can not be null");
        }
        return containeds.indexOf(contained);
    }

    /**
     * <p>
     * Returns the number of the DiagramElements contained in this GraphElement.
     * </p>
     *
     * @return the number of the DiagramElements contained in this GraphElement
     */
    public int countContaineds() {
        return containeds.size();
    }

    /**
     * <p>
     * Appends an anchorage to this GraphElement at the end.
     * </p>
     *
     * @param anchorage the anchorage to be appended
     * @throws IllegalArgumentException if anchorage is null
     */
    public void addAnchorage(GraphConnector anchorage) {
        if (anchorage == null) {
            throw new IllegalArgumentException("the anchorage can not be null");
        }
        anchorages.add(anchorage);
    }

    /**
     * <p>
     * Inserts an anchorage to this GraphElement at the given position. Shifts the element currently at that
     * position (if any) and any subsequent elements to the right (adds one to their indices).
     * </p>
     *
     * @param index the index at which the anchorage is to be inserted
     * @param anchorage the anchorage to be inserted
     * @throws IllegalArgumentException if anchorage is null, or index is out of range (index < 0 || index >
     *         countAnchorages())
     */
    public void addAnchorage(int index, GraphConnector anchorage) {
        if (anchorage == null) {
            throw new IllegalArgumentException("the anchorage can not be null");
        }
        if (index < 0) {
            throw new IllegalArgumentException("index can not be less than 0");
        }
        if (index > anchorages.size()) {
            throw new IllegalArgumentException("index can not be larger than size");
        }
        anchorages.add(index, anchorage);
    }

    /**
     * <p>
     * Replaces the anchorage in this GraphElement at the given position with the specified one.
     * </p>
     *
     * @param index the index of the anchorage to replace
     * @param anchorage the anchorage to be stored
     * @throws IllegalArgumentException if anchorage is null, or index is out of range (index < 0 || index >=
     *         countAnchorages())
     */
    public void setAnchorage(int index, GraphConnector anchorage) {
        if (anchorage == null) {
            throw new IllegalArgumentException("the anchorage can not be null");
        }
        if (index < 0) {
            throw new IllegalArgumentException("index can not be less than 0");
        }
        if (index >= anchorages.size()) {
            throw new IllegalArgumentException("index can not be larger than or equal to size");
        }
        anchorages.set(index, anchorage);
    }

    /**
     * <p>
     * Removes the anchorage from this GraphElement at the specified position. All subsequent elements are
     * shifted to the left. Returns the removed anchorage.
     * </p>
     *
     * @param index the index of the anchorage to be removed
     * @return the removed anchorage
     * @throws IllegalArgumentException if index is out of range (index < 0 || index >= countAnchorages())
     */
    public GraphConnector removeAnchorage(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("index can not be less than 0");
        }
        if (index >= anchorages.size()) {
            throw new IllegalArgumentException("index can not be larger than or equal to size");
        }
        return anchorages.remove(index);
    }

    /**
     * <p>
     * Removes the anchorage from this GraphElement. If anchorage is a duplicated element, only the first one
     * is removed. Returns true if the anchorage is removed, false otherwise.
     * </p>
     *
     * @param anchorage the anchorage to be removed
     * @return true if the anchorage is removed, false otherwise
     * @throws IllegalArgumentException if anchorage is null
     */
    public boolean removeAnchorage(GraphConnector anchorage) {
        if (anchorage == null) {
            throw new IllegalArgumentException("the anchorage can not be null");
        }
        return anchorages.remove(anchorage);
    }

    /**
     * <p>
     * Removes all the anchorages from this GraphElement.
     * </p>
     */
    public void clearAnchorages() {
        anchorages.clear();
    }

    /**
     * <p>
     * Returns a copy of the anchorages of this GraphElement.
     * </p>
     *
     * @return a copy of the anchorages of this GraphElement
     */
    public List<GraphConnector> getAnchorages() {
        return new ArrayList<GraphConnector>(anchorages);
    }

    /**
     * <p>
     * Returns true if the anchorage is in this GraphElement, false otherwise.
     * </p>
     *
     * @param anchorage the anchorage to be checked for inclusion
     * @return true if the anchorage is in this GraphElement, false otherwise
     * @throws IllegalArgumentException if anchorage is null
     */
    public boolean containsAnchorage(GraphConnector anchorage) {
        if (anchorage == null) {
            throw new IllegalArgumentException("the anchorage can not be null");
        }
        return anchorages.contains(anchorage);
    }

    /**
     * <p>
     * Returns the index of the first occurrence of the given anchorage in this GraphElement.
     * </p>
     *
     * @param anchorage the anchorage to search for
     * @return the position of the anchorage, -1 if not found
     * @throws IllegalArgumentException if anchorage is null
     */
    public int indexOfAnchorage(GraphConnector anchorage) {
        if (anchorage == null) {
            throw new IllegalArgumentException("the anchorage can not be null");
        }
        return anchorages.indexOf(anchorage);
    }

    /**
     * <p>
     * Returns the number of the anchorages of this GraphElement.
     * </p>
     *
     * @return the number of the anchorages of this GraphElement
     */
    public int countAnchorages() {
        return anchorages.size();
    }

    /**
     * <p>
     * Appends a DiagramLink to this GraphElement at the end.
     * </p>
     *
     * @param link the DiagramLink to be appended
     * @throws IllegalArgumentException if link is null
     */
    public void addLink(DiagramLink link) {
        if (link == null) {
            throw new IllegalArgumentException("the link can not be null");
        }
        links.add(link);
    }

    /**
     * <p>
     * Removes the DiagramLink from this GraphElement. If the DiagramLink is a duplicated element, only the
     * first one is removed. Returns true if the DiagramLink is removed, false otherwise.
     * </p>
     *
     * @param link the DiagramLink to be removed
     * @return true if the DiagramLink is removed, false otherwise
     * @throws IllegalArgumentException if link is null
     */
    public boolean removeLink(DiagramLink link) {
        if (link == null) {
            throw new IllegalArgumentException("the link can not be null");
        }
        return links.remove(link);
    }

    /**
     * <p>
     * Removes all the DiagramLinks from this GraphElement.
     * </p>
     */
    public void clearLinks() {
        links.clear();
    }

    /**
     * <p>
     * Returns a copy of the DiagramLinks of this GraphElement.
     * </p>
     *
     * @return a copy of the DiagramLinks of this GraphElement
     */
    public Collection<DiagramLink> getLinks() {
        return new ArrayList<DiagramLink>(links);
    }

    /**
     * <p>
     * Returns true if the DiagramLink is in this GraphElement, false otherwise.
     * </p>
     *
     * @param link the DiagramLink to be checked for inclusion
     * @return true if the DiagramLink is in this GraphElement, false otherwise
     * @throws IllegalArgumentException if link is null
     */
    public boolean containsLink(DiagramLink link) {
        if (link == null) {
            throw new IllegalArgumentException("the link can not be null");
        }
        return links.contains(link);
    }

    /**
     * <p>
     * Returns the number of the DiagramLinks of this GraphElement.
     * </p>
     *
     * @return the number of the DiagramLinks of this GraphElement
     */
    public int countLinks() {
        return links.size();
    }
}