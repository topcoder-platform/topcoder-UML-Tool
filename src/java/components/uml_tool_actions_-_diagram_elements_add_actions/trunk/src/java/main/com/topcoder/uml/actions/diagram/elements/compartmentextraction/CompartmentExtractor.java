/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.compartmentextraction;

import com.topcoder.diagraminterchange.GraphElement;

/**
 * <p>
 * An interface to represent methods need to be supported by a CompartmentExtractor.
 * </p>
 *
 * <p>
 * CompartmentExtractor is responsible to extract and update several types of compartments
 * from the given DiagramElement object.
 * </p>
 *
 * <p>
 * Thread Safety : The implement is not be thread safe since the update operation changes the state of
 * the diagram element.
 * </p>
 *
 * @author bramandia, TCSDEVELOPER
 * @version 1.0
 */
public interface CompartmentExtractor {
    /**
     * <p>
     * Extract the name compartment from the element and return the GraphElement representing name compartment.
     * </p>
     *
     * @return graph element represents name compartment
     *
     * @throws CompartmentNotSupportedException if the element does not support the compartment
     * @throws CompartmentNotFoundException if the compartment is supported but it does not exist in the element
     * @throws CompartmentMalformedException if the element contains malformed compartment
     */
    public GraphElement extractName() throws CompartmentNotSupportedException, CompartmentNotFoundException,
        CompartmentMalformedException;

    /**
     * <p>
     * Update the name compartment of the element to the new value.
     * </p>
     *
     * @param newElement graph element represents name compartment
     *
     * @throws CompartmentNotSupportedException if the element does not support the compartment
     * @throws CompartmentNotFoundException if the compartment is supported but it does not exist in the element
     * @throws CompartmentMalformedException if the element contains malformed compartment
     */
    public void updateName(GraphElement newElement) throws CompartmentNotSupportedException,
        CompartmentNotFoundException, CompartmentMalformedException;

    /**
     * <p>
     * Extract the namespace compartment from the element and return the GraphElement representing
     * namespace compartment.
     * </p>
     *
     * @return graph element represents name space compartment
     *
     * @throws CompartmentNotSupportedException if the element does not support the compartment
     * @throws CompartmentNotFoundException if the compartment is supported but it does not exist in the element
     * @throws CompartmentMalformedException if the element contains malformed compartment
     */
    public GraphElement extractNamespace() throws CompartmentNotSupportedException, CompartmentNotFoundException,
        CompartmentMalformedException;

    /**
     * <p>
     * Update the namespace compartment of the element to the new value.
     * </p>
     *
     * @param newElement the new graph element represents namespace
     *
     * @throws CompartmentNotSupportedException if the element does not support the compartment
     * @throws CompartmentNotFoundException if the compartment is supported but it does not exist in the element
     * @throws CompartmentMalformedException if the element contains malformed compartment
     */
    public void updateNamespace(GraphElement newElement) throws CompartmentNotSupportedException,
        CompartmentNotFoundException, CompartmentMalformedException;

    /**
     * <p>
     * Extract the stereotype compartment from the element and return the GraphElement
     * representing stereotype compartment.
     * </p>
     *
     * @return graph element representing the stereo type
     *
     * @throws CompartmentNotSupportedException if the element does not support the compartment
     * @throws CompartmentNotFoundException if the compartment is supported but it does not exist in the element
     * @throws CompartmentMalformedException if the element contains malformed compartment
     */
    public GraphElement extractStereotype() throws CompartmentNotSupportedException, CompartmentNotFoundException,
        CompartmentMalformedException;

    /**
     * <p>
     * Update the stereotype compartment of the element to the new value.
     * </p>
     *
     * @param newElement graph element representing the stereo type
     *
     * @throws CompartmentNotSupportedException if the element does not support the compartment
     * @throws CompartmentNotFoundException if the compartment is supported but it does not exist in the element
     * @throws CompartmentMalformedException if the element contains malformed compartment
     */
    public void updateStereotype(GraphElement newElement) throws CompartmentNotSupportedException,
        CompartmentNotFoundException, CompartmentMalformedException;

    /**
     * <p>
     * Extract the first association end compartment from the element and return the
     * GraphElement representing the first association end compartment.
     * </p>
     *
     * @return graph element representing first association end
     *
     * @throws CompartmentNotSupportedException if the element does not support the compartment
     * @throws CompartmentNotFoundException if the compartment is supported but it does not exist in the element
     * @throws CompartmentMalformedException if the element contains malformed compartment
     */
    public GraphElement extractFirstAssociationEnd() throws CompartmentNotSupportedException,
        CompartmentNotFoundException, CompartmentMalformedException;

    /**
     * <p>
     * Update the first association end compartment from the element.
     * </p>
     *
     * @param newElement graph element representing first association end
     *
     * @throws CompartmentNotSupportedException if the element does not support the compartment
     * @throws CompartmentNotFoundException if the compartment is supported but it does not exist in the element
     * @throws CompartmentMalformedException if the element contains malformed compartment
     */
    public void updateFirstAssociationEnd(GraphElement newElement) throws CompartmentNotSupportedException,
        CompartmentNotFoundException, CompartmentMalformedException;

    /**
     * <p>
     * Extract the second association end compartment from the element and return the GraphElement representing
     * the first association end compartment.
     * </p>
     *
     * @return graph element representing second association end
     *
     * @throws CompartmentNotSupportedException if the element does not support the compartment
     * @throws CompartmentNotFoundException if the compartment is supported but it does not exist in the element
     * @throws CompartmentMalformedException if the element contains malformed compartment
     */
    public GraphElement extractSecondAssociationEnd() throws CompartmentNotSupportedException,
        CompartmentNotFoundException, CompartmentMalformedException;

    /**
     * <p>
     * Update the second association end compartment from the element.
     * </p>
     *
     * @param newElement graph element representing second association end
     *
     * @throws CompartmentNotSupportedException if the element does not support the compartment
     * @throws CompartmentNotFoundException if the compartment is supported but it does not exist in the element
     * @throws CompartmentMalformedException if the element contains malformed compartment
     */
    public void updateSecondAssociationEnd(GraphElement newElement) throws CompartmentNotSupportedException,
        CompartmentNotFoundException, CompartmentMalformedException;

    /**
     * <p>
     * Extract the attribute compartment from the element and return the graph element representing
     * compartment containing the set of attributes.
     * </p>
     *
     * <p>
     * Note, this corresponds to the compartment containing the set of attributes, not the individual
     * attribute itself.</p>
     *
     * @return graph element representing the overall attribute compartment
     *
     * @throws CompartmentNotSupportedException if the element does not support the compartment
     * @throws CompartmentNotFoundException if the compartment is supported but it does not exist in the element
     * @throws CompartmentMalformedException if the element contains malformed compartment
     */
    public GraphElement extractAttribute() throws CompartmentNotSupportedException, CompartmentNotFoundException,
        CompartmentMalformedException;

    /**
     * <p>
     * Update the attribute compartment from the element.
     * </p>
     *
     * <p>
     * Note, this corresponds to the compartment containing the set of attributes, not the individual attribute itself.
     * </p>
     *
     * @param newElement graph element representing the overall attribute compartment
     *
     * @throws CompartmentNotSupportedException if the element does not support the compartment
     * @throws CompartmentNotFoundException if the compartment is supported but it does not exist in the element
     * @throws CompartmentMalformedException if the element contains malformed compartment
     */
    public void updateAttribute(GraphElement newElement) throws CompartmentNotSupportedException,
        CompartmentNotFoundException, CompartmentMalformedException;

    /**
     * <p>
     * Extract the operation compartment from the element and return the graph element representing
     * compartment containing the set of operations.
     * </p>
     *
     * <p>
     * Note, this corresponds to the compartment containing the set of operations, not the individual operation itself.
     * </p>
     *
     * @return graph element representing the overall operation compartment
     *
     * @throws CompartmentNotSupportedException if the element does not support the compartment
     * @throws CompartmentNotFoundException if the compartment is supported but it does not exist in the element
     * @throws CompartmentMalformedException if the element contains malformed compartment
     */
    public GraphElement extractOperation() throws CompartmentNotSupportedException, CompartmentNotFoundException,
        CompartmentMalformedException;

    /**
     * <p>
     * Update the operation compartment from the element.
     * </p>
     *
     * <p>
     * Note, this corresponds to the compartment containing the set of operations,
     * not the individual operation itself.
     * </p>
     *
     * @param newElement graph element representing the overall operation compartment
     *
     * @throws CompartmentNotSupportedException if the element does not support the compartment
     * @throws CompartmentNotFoundException if the compartment is supported but it does not exist in the element
     * @throws CompartmentMalformedException if the element contains malformed compartment
     */
    public void updateOperation(GraphElement newElement) throws CompartmentNotSupportedException,
        CompartmentNotFoundException, CompartmentMalformedException;
}
