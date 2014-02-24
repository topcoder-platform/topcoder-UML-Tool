/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.compartmentextraction;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;
import com.topcoder.uml.model.commonbehavior.links.Link;

/**
 * <p>
 * This class extends AbstractCompartmentExtractor class and so implements CompartmentExtractor interface.
 * </p>
 *
 * <p>
 * This class is responsible to extract and update from the given GraphNode the following compartments:
 * <ul type="disc">
 * <li>stereotype</li>
 * </ul>
 * </p>
 *
 * <p>
 * This class can be used for GraphNode that follows the structure:
 * </p>
 * <p>
 * <pre>
 * Uml1SemanticModelBridge.element = &lt;UML:Link&gt;
 *     Uml1SemanticModelBridge.element = &lt;UML:Stimulus&gt;
 *         SimpleSemanticModelElement.typeInfo = &quot;StereotypeCompartment&quot;
 * </pre>
 * Such structure corresponds to the following type:
 * <ul type="disc">
 * <li>SynchronousMessage</li>
 * <li>AsynchronousMessage</li>
 * <li>CreateMessage</li>
 * <li>SendSignalMessage</li>
 * <li>DestroyMessage</li>
 * <li>ReturnMessage</li>
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
public class MessageCompartmentExtractor extends AbstractCompartmentExtractor {
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
     * Create MessageCompartmentExtractor with the element set to the given GraphNode.
     * </p>
     *
     * @param node the graph node in which the compartment is to be extracted
     *
     * @throws IllegalArgumentException if the argument is null
     */
    public MessageCompartmentExtractor(GraphNode node) {
        super(node);

        this.stereotypeExtractor = this.getExtractorForStereotype();
    }

    /**
     * <p>
     * Extract the stereotype compartment from the element and return the GraphElement
     * representing stereotype compartment.
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
     * Update the diagram element to be extracted to a new element.
     * </p>
     *
     * <p>
     * The nameExtractor and stereotypeExtractor are created in this method too.
     * </p>
     *
     * @param element set the graph element to be extracted, can not be null
     *
     * @throws IllegalArgumentException if element is null
     */
    public void setElement(DiagramElement element) {
        super.setElement(element);

        this.stereotypeExtractor = this.getExtractorForStereotype();
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
            Link.class);
        extractor.addNextLevelSemanticModel(Stimulus.class, 0);
        extractor.addNextLevelSemanticModel("StereotypeCompartment", 0);

        return extractor;
    }
}
