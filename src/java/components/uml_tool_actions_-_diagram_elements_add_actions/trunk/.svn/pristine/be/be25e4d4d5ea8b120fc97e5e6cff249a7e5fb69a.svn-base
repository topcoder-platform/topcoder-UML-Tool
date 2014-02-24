package com.topcoder.uml.actions.diagram.elements;


import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;

import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.uml.actions.diagram.elements.compartmentextraction.CompartmentExtractor;

/**
 * <p>
 * Represent the super class of all update actions in this component.
 * </p>
 *
 * <p>
 * This class employs a CompartmentExtractor class to extract particular
 * GraphElement from the element to be updated.
 * </p>
 *
 * <p>
 * Client of this class needs to instantiate a concrete subclass and call
 * execute action to execute Update action.
 * </p>
 *
 * <p>
 * Thread Safety : This class is not thread safe and undo, redo and execute
 * might interfere each other.
 * </p>
 *
 * @author bramandia, TCSDEVELOPER
 * @version 1.0
 */
public abstract class UpdateDiagramElementAction extends DiagramElementUndoableAction {
    /**
     * <p>
     * Represents the Compartment Extractor implementation to be used by this class.
     * </p>
     *
     * <p>
     * It might be null (eg: some update only use element not extractor), set in constructor.
     * </p>
     *
     * <p>
     * This variable will not be changed.
     * </p>
     */
    private final CompartmentExtractor extractor;

    /**
     * <p>
     * Create Diagram Element Update Action with given extractor.
     * </p>
     *
     * @param extractor compartment extractor to be used
     *
     * @throws IllegalArgumentException if extractor is null
     */
    protected UpdateDiagramElementAction(CompartmentExtractor extractor) {
        this(null, extractor);
    }

    /**
     * <p>
     * Create Diagram Element Update Action with given graph element.
     * </p>
     *
     * @param element graph element to be updated
     *
     * @throws IllegalArgumentException if element is null
     */
    protected UpdateDiagramElementAction(GraphElement element) {
        this(element, null);
    }

    /**
     * <p>
     * Create Diagram Element Update Action with given parent element and
     * compartment extractor.
     * </p>
     *
     * @param element graph element to be updated
     * @param extractor extractor to be used
     *
     * @throws IllegalArgumentException if both element and extractor are null
     */
    protected UpdateDiagramElementAction(GraphElement element, CompartmentExtractor extractor) {
        super(element);

        // Any one of them can be null and both of them can not be null
        if (element == null && extractor == null) {
            throw new IllegalArgumentException("Both the GraphElement and CompartmentExtractor instances are null.");
        }

        this.extractor = extractor;
    }

    /**
     * <p>
     * Redo the action represented by this class.
     * </p>
     *
     * <p>
     * Note, for the subclass of this class, in the case of exception occurs,
     * Implementation of this method should set the lastException instance variable
     * and return silently.
     * It is the responsibility of the client to call getLastException to ensure
     * there was no exception.
     * </p>
     *
     * @throws CannotRedoException if redo operation cannot be performed
     */
    public void redo() {
        super.redo();
    }

    /**
     * <p>
     * Undo the action represented by this class.
     * </p>
     *
     * <p>
     * Note, for the subclass of this class, in the case of exception occurs,
     * Implementation of this method should set the lastException instance variable
     * and return silently.
     * It is the responsibility of the client to call getLastException to ensure
     * there was no exception.
     * </p>
     *
     * @throws CannotUndoException if undo operation cannot be performed
     */
    public void undo() {
        super.undo();
    }

    /**
     * <p>
     * Return the CompartmentExtractor used.
     * </p>
     *
     * @return the compartment extractor to be used
     */
    public CompartmentExtractor getExtractor() {
        return extractor;
    }
}
