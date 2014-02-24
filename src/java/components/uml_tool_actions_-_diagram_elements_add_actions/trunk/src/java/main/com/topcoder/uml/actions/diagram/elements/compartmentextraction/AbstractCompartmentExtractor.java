/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.compartmentextraction;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.uml.actions.diagram.elements.Util;

/**
 * <p>
 * An abstract implementation for CompartmentExtractor interface.
 * </p>
 *
 * <p>
 * All methods in this class simply throw CompartmentNotSupportedException.
 * This class is provided for convenience when creating implementation of CompartmentExtractor
 * as usually only some operations are supported.
 * </p>
 *
 * <p>
 * Developers might want to subclass this class in order to provide implementation of
 * CompartmentExtractor interface instead of directly implements all methods available.
 * </p>
 *
 * <p>
 * Thread Safety : This class is not thread safe as element is mutable, in addition it depends
 * on the thread safety of implementation of diagram interchange component.
 * </p>
 *
 * @author bramandia, TCSDEVELOPER
 * @version 1.0
 */
public abstract class AbstractCompartmentExtractor implements CompartmentExtractor {
    /**
     * <p>
     * Represents the element which is handled by this compartment extractor.
     * </p>
     *
     * <p>
     * This variable will not be null and can be changed.
     * Has setter method.
     * </p>
     */
    private DiagramElement element;

    /**
     * <p>
     * Create AbstractCompartmentExtractor with the diagram element specified.
     * </p>
     *
     * @param element graph element in which the compartment graph element is to be extracted
     *
     * @throws IllegalArgumentException if element is null
     */
    protected AbstractCompartmentExtractor(DiagramElement element) {
        Util.checkNull(element, "element");

        this.element = element;
    }

    /**
     * <p>
     * Extract the name compartment from the element.
     * </p>
     *
     * @return graph element representing name compartment
     *
     * @throws CompartmentNotSupportedException all the time unless it is overridden
     * @throws CompartmentNotFoundException never unless it is overridden
     * @throws CompartmentMalformedException never unless it is overridden
     */
    public GraphElement extractName() throws CompartmentNotSupportedException, CompartmentMalformedException,
        CompartmentNotFoundException {
        throw new CompartmentNotSupportedException("The extractName() method is not supported");
    }

    /**
     * <p>
     * Update the name compartment of the element to the new value.
     * </p>
     *
     * @param newElement graph element representing name compartment
     *
     * @throws CompartmentNotSupportedException all the time unless it is overridden
     * @throws CompartmentNotFoundException never unless it is overridden
     * @throws CompartmentMalformedException never unless it is overridden
     */
    public void updateName(GraphElement newElement) throws CompartmentNotSupportedException,
        CompartmentMalformedException, CompartmentNotFoundException {
        throw new CompartmentNotSupportedException("The updateName(GraphElement) method is not supported");
    }

    /**
     * <p>
     * Extract the namespace compartment from the element.
     * </p>
     *
     * @return graph element representing namespace compartment
     *
     * @throws CompartmentNotSupportedException all the time unless it is overridden
     * @throws CompartmentNotFoundException never unless it is overridden
     * @throws CompartmentMalformedException never unless it is overridden
     */
    public GraphElement extractNamespace() throws CompartmentNotSupportedException, CompartmentMalformedException,
        CompartmentNotFoundException {
        throw new CompartmentNotSupportedException("The extractNamespace() method is not supported");
    }

    /**
     * <p>
     * Update the namespace compartment to the new value.
     * </p>
     *
     * @param newElement graph element representing namespace compartment
     *
     * @throws CompartmentNotSupportedException all the time unless it is overridden
     * @throws CompartmentNotFoundException never unless it is overridden
     * @throws CompartmentMalformedException never unless it is overridden
     */
    public void updateNamespace(GraphElement newElement) throws CompartmentNotSupportedException,
        CompartmentMalformedException, CompartmentNotFoundException {
        throw new CompartmentNotSupportedException("The updateNamespace(GraphElement) method is not supported");
    }

    /**
     * <p>
     * Extract the stereotype compartment from the element.
     * </p>
     *
     * @return graph element representing stereo type compartment
     *
     * @throws CompartmentNotSupportedException all the time unless it is overridden
     * @throws CompartmentNotFoundException never unless it is overridden
     * @throws CompartmentMalformedException never unless it is overridden
     */
    public GraphElement extractStereotype() throws CompartmentNotSupportedException, CompartmentMalformedException,
        CompartmentNotFoundException {
        throw new CompartmentNotSupportedException("The extractStereotype() method is not supported");
    }

    /**
     * <p>
     * Update the stereotype compartment of the element to the new value.
     * </p>
     *
     * @param newElement graph element representing stereo type compartment
     *
     * @throws CompartmentNotSupportedException all the time unless it is overridden
     * @throws CompartmentNotFoundException never unless it is overridden
     * @throws CompartmentMalformedException unless it is overridden
     */
    public void updateStereotype(GraphElement newElement) throws CompartmentNotSupportedException,
        CompartmentMalformedException, CompartmentNotFoundException {
        throw new CompartmentNotSupportedException("The updateStereotype(GraphElement) method is not supported");
    }

    /**
     * <p>
     * Extract the first association end compartment from the element.
     * </p>
     *
     * @return graph element representing first association end
     *
     * @throws CompartmentNotSupportedException all the time unless it is overridden
     * @throws CompartmentNotFoundException never unless it is overridden
     * @throws CompartmentMalformedException never unless it is overridden
     */
    public GraphElement extractFirstAssociationEnd() throws CompartmentNotSupportedException,
        CompartmentMalformedException, CompartmentNotFoundException {
        throw new CompartmentNotSupportedException("The extractFirstAssociationEnd() method is not supported");
    }

    /**
     * <p>
     * Update the first association end compartment from the element.
     * </p>
     *
     * @param newElement graph element representing first association end
     *
     * @throws CompartmentNotSupportedException all the time unless it is overridden
     * @throws CompartmentNotFoundException never unless it is overridden
     * @throws CompartmentMalformedException never unless it is overridden
     */
    public void updateFirstAssociationEnd(GraphElement newElement) throws CompartmentNotSupportedException,
        CompartmentMalformedException, CompartmentNotFoundException {
        throw new CompartmentNotSupportedException(
            "The updateFirstAssociationEnd(GraphElement) method is not supported");
    }

    /**
     * <p>
     * Extract the second association end compartment from the element.
     * </p>
     *
     * @return graph element representing second association end
     *
     * @throws CompartmentNotSupportedException all the time unless it is overridden
     * @throws CompartmentNotFoundException never unless it is overridden
     * @throws CompartmentMalformedException never unless it is overridden
     */
    public GraphElement extractSecondAssociationEnd() throws CompartmentNotSupportedException,
        CompartmentMalformedException, CompartmentNotFoundException {
        throw new CompartmentNotSupportedException("The extractSecondAssociationEnd() method is not supported");
    }

    /**
     * <p>
     * Update the second association end compartment from the element.
     * </p>
     *
     * @param newElement graph element representing second association end
     *
     * @throws CompartmentNotSupportedException all the time unless it is overridden
     * @throws CompartmentNotFoundException never unless it is overridden
     * @throws CompartmentMalformedException never unless it is overridden
     */
    public void updateSecondAssociationEnd(GraphElement newElement) throws CompartmentNotSupportedException,
        CompartmentMalformedException, CompartmentNotFoundException {
        throw new CompartmentNotSupportedException(
            "The updateSecondAssociationEnd(GraphElement) method is not supported");
    }

    /**
     * <p>
     * Extract the attribute compartment from the element.
     * This corresponds to the compartment containing the set of attributes, not the attribute itself.
     * </p>
     *
     * @return graph element representing the overall attribute compartment
     *
     * @throws CompartmentNotSupportedException all the time unless it is overridden
     * @throws CompartmentNotFoundException never unless it is overridden
     * @throws CompartmentMalformedException never unless it is overridden
     */
    public GraphElement extractAttribute() throws CompartmentNotSupportedException, CompartmentMalformedException,
        CompartmentNotFoundException {
        throw new CompartmentNotSupportedException("The extractAttribute() method is not supported");
    }

    /**
     * <p>
     * Update the attribute compartment from the element.
     * This corresponds to the compartment containing the set of attributes, not the attribute itself.
     * </p>
     *
     * @param newElement graph element representing the overall attribute compartment
     *
     * @throws CompartmentNotSupportedException all the time unless it is overridden
     * @throws CompartmentNotFoundException never unless it is overridden
     * @throws CompartmentMalformedException never unless it is overridden
     */
    public void updateAttribute(GraphElement newElement) throws CompartmentNotSupportedException,
        CompartmentMalformedException, CompartmentNotFoundException {
        throw new CompartmentNotSupportedException("The updateAttribute(GraphElement) method is not supported");
    }

    /**
     * <p>
     * Extract the operation compartment from the element.
     * This corresponds to the compartment containing the set of operations, not the operation itself.
     * </p>
     *
     * @return graph element representing the overall operation compartment
     *
     * @throws CompartmentNotSupportedException all the time unless it is overridden
     * @throws CompartmentNotFoundException never unless it is overridden
     * @throws CompartmentMalformedException never unless it is overridden
     */
    public GraphElement extractOperation() throws CompartmentNotSupportedException, CompartmentMalformedException,
        CompartmentNotFoundException {
        throw new CompartmentNotSupportedException("The extractOperation() method is not supported");
    }

    /**
     * <p>
     * Update the operation compartment from the element.
     * This corresponds to the compartment containing the set of operations, not the operation itself.
     * </p>
     *
     * @param newElement graph element representing the overall operation compartment
     *
     * @throws CompartmentNotSupportedException all the time unless it is overridden
     * @throws CompartmentNotFoundException never unless it is overridden
     * @throws CompartmentMalformedException never unless it is overridden
     */
    public void updateOperation(GraphElement newElement) throws CompartmentNotSupportedException,
        CompartmentMalformedException, CompartmentNotFoundException {
        throw new CompartmentNotSupportedException("The updateOperation(GraphElement) method is not supported");
    }

    /**
     * <p>
     * Update the diagram element to be extracted to a new element.
     * </p>
     *
     * @param element set the graph element to be extracted, can not be null
     *
     * @throws IllegalArgumentException if element is null
     */
    public void setElement(DiagramElement element) {
        Util.checkNull(element, "element");

        this.element = element;
    }

    /**
     * <p>
     * Get the diagram element to be extracted.
     * </p>
     *
     * @return the graph element to be extracted
     */
    public DiagramElement getElement() {
        return this.element;
    }
}
