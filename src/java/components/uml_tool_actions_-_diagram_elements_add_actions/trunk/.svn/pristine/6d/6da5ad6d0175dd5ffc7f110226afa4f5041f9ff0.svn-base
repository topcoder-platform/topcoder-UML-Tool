/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.compartmentextraction;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.uml.model.core.Classifier;;

/**
 * <p>
 * This class extends DefaultNodeCompartmentExtractor class and so implements CompartmentExtractor interface.
 * </p>
 *
 * <p>
 * This class is responsible to extract and update from the given GraphNode the following compartments:
 * <ul type="disc">
 * <li>attributes</li>
 * <li>operations</li>
 * </ul>
 * </p>
 *
 * <p>
 * This class extends DefaultNodeCompartmentExtractor to provide feature to extract and update the name,
 * namespace and stereotype.
 * </p>
 *
 * <p>
 * This class can be used for GraphNode that follows the structure:
 * </p>
 *
 * <p>
 * <pre>
 * Uml1SemanticModelBridge.element = &lt;UML:Interface&gt;
 *     SimpleSemanticModelElement.typeInfo = &quot;NameCompartment&quot;
 *         SimpleSemanticModelElement.typeInfo = &quot;StereotypeCompartment&quot;
 *         SimpleSemanticModelElement.typeInfo = &quot;Name&quot;&lt;br/&gt;
 *         SimpleSemanticModelElement.typeInfo = &quot;NamespaceCompartment&quot;
 *     SimpleSemanticModelElement.typeInfo = &quot;CompartmentSeparator&quot;
 *     SimpleSemanticModelElement.typeInfo = &quot;AttributeCompartment&quot;
 *         SimpleSemanticModelElement.typeInfo = &quot;DelimitedSection&quot;
 *             Uml1SemanticModelBridge.element = &lt;UML:Attribute&gt;
 *             Uml1SemanticModelBridge.element = &lt;UML:Attribute&gt;
 *             Repeat...
 *     SimpleSemanticModelElement.typeInfo = &quot;CompartmentSeparator&quot;
 *     SimpleSemanticModelElement.typeInfo = &quot;OperationCompartment&quot;
 *         SimpleSemanticModelElement.typeInfo = &quot;DelimitedSection&quot;
 *             Uml1SemanticModelBridge.element = &lt;UML:Operation&gt;
 *             Uml1SemanticModelBridge.element = &lt;UML:Operation&gt;
 *             Repeat...
 * </pre>
 * Such structure corresponds to the following type:
 * <ul type="disc">
 * <li>Interface</li>
 * <li>Class</li>
 * <li>Exception</li>
 * <li>Enumeration</li>
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
public class ClassifierCompartmentExtractor extends DefaultNodeCompartmentExtractor {
    /**
     * <p>
     * StructureCompartmentExtractor instance for extracting and updating attribute compartment.
     * </p>
     *
     * <p>
     * It is set in the constructor and setElement() method.
     * </p>
     */
    private StructureCompartmentExtractor attributeExtractor;

    /**
     * <p>
     * StructureCompartmentExtractor instance for extracting and updating operation compartment.
     * </p>
     *
     * <p>
     * It is set in the constructor and setElement() method.
     * </p>
     */
    private StructureCompartmentExtractor operationExtractor;

    /**
     * <p>
     * Create ClassifierCompartmentExtractor with the element set to the given GraphNode.
     * </p>
     *
     * @param classifier the graph node in which the compartment is to be extracted
     *
     * @throws IllegalArgumentException if classifier is null
     */
    public ClassifierCompartmentExtractor(GraphNode classifier) {
        super(classifier);

        attributeExtractor = this.getExtractorForAttribute();
        operationExtractor = this.getExtractorForOperation();
    }

    /**
     * <p>
     * Extract the attribute compartment from the element and return the GraphElement representing compartment
     * containing the set of attributes.
     * </p>
     *
     * @return the graph element representing overall attribute compartment
     *
     * @throws CompartmentNotFoundException if the compartment is supported but it does not exist in the element
     * @throws CompartmentMalformedException if the element contains malformed compartment
     */
    public GraphElement extractAttribute() throws CompartmentMalformedException, CompartmentNotFoundException {
        return attributeExtractor.extract();
    }

    /**
     * <p>
     * Update the attribute compartment of the element to the new value.
     * </p>
     *
     * <p>
     * Note, this method will update the whole Attribute compartment.
     * The corresponding SemanticModelBridge for the given new element should be of SimpleSemanticModelElement
     * and the type information should be &quot;AttributeCompartment&quot;.
     * </p>
     *
     * @param newElement the graph element representing overall attribute compartment
     *
     * @throws IllegalArgumentException if newElement is null
     * @throws CompartmentNotFoundException if the compartment is supported but it does not exist in the element
     * @throws CompartmentMalformedException if the element contains malformed compartment
     */
    public void updateAttribute(GraphElement newElement) throws CompartmentMalformedException,
        CompartmentNotFoundException {
        attributeExtractor.update(newElement);
    }

    /**
     * <p>
     * Extract the operation compartment from the element and return GraphElement representing
     * compartment containing the set of operations.
     * </p>
     *
     * @return the graph element representing overall operation compartment
     *
     * @throws CompartmentNotFoundException if the compartment is supported but it does not exist in the element
     * @throws CompartmentMalformedException if the element contains malformed compartment
     */
    public GraphElement extractOperation() throws CompartmentMalformedException, CompartmentNotFoundException {
        return operationExtractor.extract();
    }

    /**
     * <p>
     * Update the operation compartment of the element to the new value.
     * </p>
     *
     * <p>
     * Note, this method will update the whole Operation compartment.
     * The corresponding SemanticModelBridge for the given new element should be of SimpleSemanticModelElement
     * and the type information should be &quot;OperationCompartment&quot;.
     * </p>
     *
     * @param newElement the graph element representing overall operation compartment
     *
     * @throws IllegalArgumentException if newElement is null
     * @throws CompartmentNotFoundException if the compartment is supported but it does not exist in the element
     * @throws CompartmentMalformedException if the element contains malformed compartment
     */
    public void updateOperation(GraphElement newElement) throws CompartmentMalformedException,
        CompartmentNotFoundException {
        operationExtractor.update(newElement);
    }

    /**
     * <p>
     * Update the diagram element to be extracted to a new element.
     * </p>
     *
     * <p>
     * The attributeExtractor and operationExtractor are created in this method too.
     * </p>
     *
     * @param element set the graph element to be extracted, can not be null
     *
     * @throws IllegalArgumentException if element is null
     */
    public void setElement(DiagramElement element) {
        super.setElement(element);

        this.attributeExtractor = this.getExtractorForAttribute();
        this.operationExtractor = this.getExtractorForOperation();
    }

    /**
     * <p>
     * This method creates a structure compartment extractor for extracting the attribute compartment for
     * the diagram element in this class and returns it.
     * </p>
     *
     * <p>
     * Note, the layout for extracting attribute compartment is set up.
     * </p>
     *
     * @return a structure compartment extractor for extracting the attribute compartment
     */
    private StructureCompartmentExtractor getExtractorForAttribute() {
        StructureCompartmentExtractor extractor = new StructureCompartmentExtractor((GraphElement) this.getElement(),
            Classifier.class);
        extractor.addNextLevelSemanticModel("AttributeCompartment", 2);

        return extractor;
    }

    /**
     * <p>
     * This method creates a structure compartment extractor for extracting the operation compartment for
     * the diagram element in this class and returns it.
     * </p>
     *
     * <p>
     * Note, the layout for extracting operation compartment is set up.
     * </p>
     *
     * @return a structure compartment extractor for extracting the operation compartment
     */
    private StructureCompartmentExtractor getExtractorForOperation() {
        StructureCompartmentExtractor extractor = new StructureCompartmentExtractor((GraphElement) this.getElement(),
            Classifier.class);
        extractor.addNextLevelSemanticModel("OperationCompartment", 4);

        return extractor;
    }
}
