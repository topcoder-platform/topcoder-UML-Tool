/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.compartmentextraction;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.uml.model.core.relationships.AssociationEnd;

/**
 * <p>
 * This class extends AbstractCompartmentExtractor class and so implements CompartmentExtractor interface.
 * </p>
 *
 * <p>
 * This class is responsible to extract and update from the given GraphEdge the following compartments:
 * <ul type="disc">
 * <li>name</li>
 * <li>stereotype</li>
 * <li>association ends</li>
 * </ul>
 * </p>
 *
 * <p>
 * This class can be used for GraphEdge that follows the structure:
 * </p>
 *
 * <p>
 * <pre>
 * Uml1SemanticModelBridge.element = &lt;UML:Association&gt;
 *     Uml1SemanticModelBridge.element = &lt;UML:AssociationEnd&gt;
 *     Uml1SemanticModelBridge.element = &lt;UML:AssociationEnd&gt;
 *     SimpleSemanticModelElement.typeInfo = &quot;DirectedName&quot;
 *         SimpleSemanticModelElement.typeInfo = &quot;Name&quot;
 *     SimpleSemanticModelElement.typeInfo = &quot;StereotypeCompartment&quot;
 * </pre>
 * Such structure corresponds to the following type:
 * <ul type="disc">
 * <li>Association</li>
 * </ul>
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
public class AssociationCompartmentExtractor extends AbstractCompartmentExtractor {
    /**
     * <p>
     * StructureCompartmentExtractor instance for extracting and updating name compartment.
     * </p>
     *
     * <p>
     * It is set in the constructor and setElement() method.
     * </p>
     */
    private StructureCompartmentExtractor nameExtractor;

    /**
     * <p>
     * StructureCompartmentExtractor instance for extracting and updating stereotype compartment.
     * </p>
     *
     * <p>
     * It is set in the constructor and setElement() method.
     * </p>
     */
    private StructureCompartmentExtractor stereotypeExtractor;

    /**
     * <p>
     * StructureCompartmentExtractor instance for extracting and updating first association end compartment.
     * </p>
     *
     * <p>
     * It is set in the constructor and setElement() method.
     * </p>
     */
    private StructureCompartmentExtractor firstAssociationEndExtractor;


    /**
     * <p>
     * StructureCompartmentExtractor instance for extracting and updating second association end compartment.
     * </p>
     *
     * <p>
     * It is set in the constructor and setElement() method.
     * </p>
     */
    private StructureCompartmentExtractor secondAssociationEndExtractor;

    /**
     * <p>
     * Create AssociationCompartmentExtractor with the element set to the given GraphEdge.
     * </p>
     *
     * @param edge the graph edge in which the compartment is to be extracted
     */
    public AssociationCompartmentExtractor(GraphEdge edge) {
        super(edge);

        nameExtractor = this.getExtractorForName();
        stereotypeExtractor = this.getExtractorForStereotype();
        firstAssociationEndExtractor = this.getExtractorForFirstAssociationEnd();
        secondAssociationEndExtractor = this.getExtractorForSecondAssociationEnd();
    }

    /**
     * <p>
     * Extract the name compartment from the element and return the
     * GraphElement representing name compartment.
     * </p>
     *
     * @return the graph element representing name compartment
     *
     * @throws CompartmentNotFoundException if the compartment is supported but it does not exist in the element
     * @throws CompartmentMalformedException if the element contains malformed compartment
     */
    public GraphElement extractName() throws CompartmentMalformedException, CompartmentNotFoundException {
        return nameExtractor.extract();
    }

    /**
     * <p>
     * Update the name compartment of the element to the new value.
     * </p>
     *
     * @param newElement the graph element representing name compartment
     *
     * @throws IllegalArgumentException if newElement is null
     * @throws CompartmentNotFoundException if the compartment is supported but it does not exist in the element
     * @throws CompartmentMalformedException if the element contains malformed compartment
     */
    public void updateName(GraphElement newElement) throws CompartmentMalformedException, CompartmentNotFoundException {
        nameExtractor.update(newElement);
    }

    /**
     * <p>
     * Extract the stereotype compartment from the element and return the
     * GraphElement representing stereotype compartment.
     * </p>
     *
     * @return the graph element representing stereo type compartment
     *
     * @throws CompartmentNotFoundException if the compartment is supported but it does not exist in the element
     * @throws CompartmentMalformedException if the element contains malformed compartment
     */
    public GraphElement extractStereotype() throws CompartmentMalformedException, CompartmentNotFoundException {
        return stereotypeExtractor.extract();
    }

    /**
     * <p>
     * Update the stereotype compartment of the element to the new value.
     * </p>
     *
     * @param newElement the graph element representing stereo type compartment
     *
     * @throws IllegalArgumentException if newElement is null
     * @throws CompartmentNotFoundException if the compartment is supported but it does not exist in the element
     * @throws CompartmentMalformedException if the element contains malformed compartment
     */
    public void updateStereotype(GraphElement newElement) throws CompartmentMalformedException,
        CompartmentNotFoundException {
        stereotypeExtractor.update(newElement);
    }

    /**
     * <p>
     * Update the first association end compartment from the element.
     * </p>
     *
     * @param newElement the graph element representing first association end compartment
     *
     * @throws IllegalArgumentException if newElement is null
     * @throws CompartmentNotFoundException if the compartment is supported but it does not exist in the element
     * @throws CompartmentMalformedException if the element contains malformed compartment
     */
    public void updateFirstAssociationEnd(GraphElement newElement) throws CompartmentMalformedException,
        CompartmentNotFoundException {
        firstAssociationEndExtractor.update(newElement);
    }

    /**
     * <p>
     * Extract the first association end compartment from the element and return the
     * GraphElement representing the first association end compartment.
     * </p>
     *
     * @return the graph element representing first association end compartment
     *
     * @throws CompartmentNotFoundException if the compartment is supported but it does not exist in the element
     * @throws CompartmentMalformedException if the element contains malformed compartment
     */
    public GraphElement extractFirstAssociationEnd()
        throws CompartmentMalformedException, CompartmentNotFoundException {
        return firstAssociationEndExtractor.extract();
    }

    /**
     * <p>
     * Update the second association end compartment from the element.
     * </p>
     *
     * @param newElement the graph element representing second association end compartment
     *
     * @throws IllegalArgumentException if newElement is null
     * @throws CompartmentNotFoundException if the compartment is supported but it does not exist in the element
     * @throws CompartmentMalformedException if the element contains malformed compartment
     */
    public void updateSecondAssociationEnd(GraphElement newElement) throws CompartmentMalformedException,
        CompartmentNotFoundException {
        secondAssociationEndExtractor.update(newElement);
    }

    /**
     * <p>
     * Extract the second association end compartment from the element and return the
     * GraphElement representing the second association end compartment.
     * </p>
     *
     * @return the graph element representing second association end compartment
     *
     * @throws CompartmentNotFoundException if the compartment is supported but it does not exist in the element
     * @throws CompartmentMalformedException if the element contains malformed compartment
     */
    public GraphElement extractSecondAssociationEnd() throws CompartmentMalformedException,
        CompartmentNotFoundException {
        return secondAssociationEndExtractor.extract();
    }

    /**
     * <p>
     * Update the diagram element to be extracted to a new element.
     * </p>
     *
     * <p>
     * The nameExtractor, stereoExtractor, firstAssociationEndExtractor and secondAssociationEndExtractor
     * are created in this method too.
     * </p>
     *
     * @param element set the graph element to be extracted, can not be null
     *
     * @throws IllegalArgumentException if element is null
     */
    public void setElement(DiagramElement element) {
        super.setElement(element);

        nameExtractor = this.getExtractorForName();
        stereotypeExtractor = this.getExtractorForStereotype();
        firstAssociationEndExtractor = this.getExtractorForFirstAssociationEnd();
        secondAssociationEndExtractor = this.getExtractorForSecondAssociationEnd();
    }

    /**
     * <p>
     * This method creates a structure compartment extractor for extracting the name compartment for
     * the diagram element in this class and returns it.
     * </p>
     *
     * <p>
     * Note, the layout for extracting name compartment is set up.
     * </p>
     *
     * @return a structure compartment extractor for extracting the name compartment
     */
    private StructureCompartmentExtractor getExtractorForName() {
        StructureCompartmentExtractor extractor = new StructureCompartmentExtractor((GraphElement) this.getElement(),
            Association.class);
        extractor.addNextLevelSemanticModel("DirectedName", 2);
        extractor.addNextLevelSemanticModel("Name", 0);

        return extractor;
    }

    /**
     * <p>
     * This method creates a structure compartment extractor for extracting the stereotype compartment for
     * the diagram element in this class and returns it.
     * </p>
     *
     * <p>
     * Note, the layout for extracting stereotype compartment is set up.
     * </p>
     *
     * @return a structure compartment extractor for extracting the stereotype compartment
     */
    private StructureCompartmentExtractor getExtractorForStereotype() {
        StructureCompartmentExtractor extractor = new StructureCompartmentExtractor((GraphElement) this.getElement(),
            Association.class);
        extractor.addNextLevelSemanticModel("StereotypeCompartment", 3);

        return extractor;
    }

    /**
     * <p>
     * This method creates a structure compartment extractor for extracting the first association end compartment for
     * the diagram element in this class and returns it.
     * </p>
     *
     * <p>
     * Note, the layout for extracting first association end compartment is set up.
     * </p>
     *
     * @return a structure compartment extractor for extracting the first association end compartment
     */
    private StructureCompartmentExtractor getExtractorForFirstAssociationEnd() {
        StructureCompartmentExtractor extractor = new StructureCompartmentExtractor((GraphElement) this.getElement(),
            Association.class);
        extractor.addNextLevelSemanticModel(AssociationEnd.class, 0);

        return extractor;
    }

    /**
     * <p>
     * This method creates a structure compartment extractor for extracting the second association end compartment for
     * the diagram element in this class and returns it.
     * </p>
     *
     * <p>
     * Note, the layout for extracting second association end compartment is set up.
     * </p>
     *
     * @return a structure compartment extractor for extracting the second association end compartment
     */
    private StructureCompartmentExtractor getExtractorForSecondAssociationEnd() {
        StructureCompartmentExtractor extractor = new StructureCompartmentExtractor((GraphElement) this.getElement(),
            Association.class);
        extractor.addNextLevelSemanticModel(AssociationEnd.class, 1);

        return extractor;
    }
}
