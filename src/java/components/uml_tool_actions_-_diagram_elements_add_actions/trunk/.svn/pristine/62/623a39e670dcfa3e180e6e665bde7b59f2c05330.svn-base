/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.compartmentextraction;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.model.activitygraphs.ObjectFlowState;

/**
 * <p>
 * This class extends AbstractCompartmentExtractor class and so implements CompartmentExtractor interface.
 * </p>
 *
 * <p>
 * This class is responsible to extract and update from the given GraphNode the following compartments:
 * <ul type="disc">
 * <li>name</li>
 * </ul>
 * </p>
 *
 * <p>
 * This class can be used for GraphNode that follows the structure:
 * </p>
 *
 * <p>
 * <pre>
 * Uml1SemanticModelBridge.element = &lt;UML:ObjectFlowNode&gt;
 *     SimpleSemanticModelElement.typeInfo = &quot;NameCompartment&quot;
 *         SimpleSemanticModelElement.typeInfo = &quot;NameAndType&quot;
 *             SimpleSemanticModelElement.typeInfo = &quot;Name&quot;
 * </pre>
 * Such structure corresponds to the following type:
 * <ul type="disc">
 * <li>ObjectFlowNode</li>
 * <li>ActionState</li>
 * <li>SendSignalAction</li>
 * <li>AcceptEventAction</li>
 * </ul>
 * </p>
 *
 * <p>
 * Thread Safety : This class is not thread safe as element is mutable, in addition it
 * depends on the thread safety of implementation of diagram interchange component.
 * </p>
 *
 * @author bramandia, biotrail
 * @version 1.0
 */
public class ActivityStateCompartmentExtractor extends AbstractCompartmentExtractor {
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
     * Create ActivityStateCompartmentExtractor with the element set to the given GraphNode.
     * </p>
     *
     * @param node the graph node in which the compartment is to be extracted
     *
     * @throws IllegalArgumentException if the argument is null
     */
    public ActivityStateCompartmentExtractor(GraphNode node) {
        super(node);

        nameExtractor = this.getExtractorForName();
    }

    /**
     * <p>
     * Extract the name compartment from the element and return the GraphElement representing name compartment.
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
     * Update the diagram element to be extracted to a new element.
     * </p>
     *
     * <p>
     * The nameExtractor is created in this method too.
     * </p>
     *
     * @param element set the graph element to be extracted, can not be null
     *
     * @throws IllegalArgumentException if element is null
     */
    public void setElement(DiagramElement element) {
        super.setElement(element);

        this.nameExtractor = this.getExtractorForName();
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
            ObjectFlowState.class);
        extractor.addNextLevelSemanticModel("NameCompartment", 0);
        extractor.addNextLevelSemanticModel("NameAndType", 0);
        extractor.addNextLevelSemanticModel("Name", 0);

        return extractor;
    }
}
