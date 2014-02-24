/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.compartmentextraction;

import java.util.ArrayList;
import java.util.List;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.SemanticModelBridge;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.actions.diagram.elements.Util;
import com.topcoder.uml.model.core.Element;

/**
 * <p>
 * This is a compartment extractor for a graph element based on the layout structure.
 * </p>
 *
 * <p>
 * The main purpose of this class is to extract a descendent GraphElement for a given
 * GraphElement and update the GraphElement to a new GraphElement.
 * </p>
 *
 * <p>
 * Note, this class is package private and so it is only used to the classes under the
 * same package and is private for other packages.
 * </p>
 *
 * <p>
 * Thread Safety : this class is mutable and so is not thread safe.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
final class StructureCompartmentExtractor {
    /**
     * <p>
     * Represent root graph element, used to extract its descendent GraphElement.
     * </p>
     *
     * <p>
     * Set in the constructor and never changed afterwards.
     * </p>
     */
    private final GraphElement element;

    /**
     * <p>
     * Represent the associated element class in uml concept for the root graph element.
     * </p>
     *
     * <p>
     * Set in the constructor and never changed afterwards.
     * </p>
     *
     * <p>
     * Can be null, when it is null, the type of associated element class in uml concept is
     * not checked.
     * </p>
     */
    private final Class modelType;

    /**
     * <p>
     * Represent the semantic model features on each layer from the root graph element to
     * the descendent graph element to be extracted or updated.
     * </p>
     *
     * <p>
     * This variable is used to guide locating and validating the descendent graph element to
     * be extracted or updated.
     * </p>
     *
     * <p>
     * Will not be null. Modified in the addNextLevelSemanticModel() methods.
     * </p>
     */
    private List<SemanticModelData> modelDataList = new ArrayList<SemanticModelData>();

    /**
     * <p>
     * Creates a StructureCompartmentExtractor instance with root graph element and its uml element
     * type specified.
     * </p>
     *
     * <p>
     * Note, this constructor is package private.
     * </p>
     *
     * @param element the root graph element to extract descendent graph element, cannot be null
     * @param modelType the uml element type of the root graph element, can be null
     *
     * @throws IllegalArgumentException if element is null
     */
    StructureCompartmentExtractor(GraphElement element, Class modelType) {
        Util.checkNull(element, "element");

        this.element = element;
        this.modelType = modelType;
    }

    /**
     * <p>
     * Add the next layout feature. The SemanticModelBridge of the current graph element
     * in the layout structures should be instance of Uml1SemanticModelBridge.
     * </p>
     *
     * <p>
     * The layer to be added should be one of the total layers from the root graph
     * element to the desired descendent graph element.
     * </p>
     *
     * <p>
     * Note, this method is package private.
     * </p>
     *
     * @param modelType the uml element type of the SemanticModelBridge in the current graph element
     * from the root graph element to the desired descendent graph element
     * @param index the order of the current graph element in its parent graph element
     *
     * @throws IllegalArgumentException if the index is negative
     */
    void addNextLevelSemanticModel(Class modelType, int index) {
        if (index < 0) {
            throw new IllegalArgumentException("The index argument is negative.");
        }

        modelDataList.add(new SemanticModelData(modelType, index));
    }

    /**
     * <p>
     * Add the next layout feature. The SemanticModelBridge of the current graph element
     * in the layout structures should be instance of SimpleSemanticModelElement.
     * </p>
     *
     * <p>
     * The layer to be added should be one of the total layers from the root graph
     * element to the desired descendent graph element.
     * </p>
     *
     * <p>
     * Note, this method is package private.
     * </p>
     *
     * @param typeInfo the type information of the SemanticModelBridge in the current graph element
     * @param index the order of the current graph element in its parent graph element
     *
     * @throws IllegalArgumentException if typeInfo is null or index is negative
     */
    void addNextLevelSemanticModel(String typeInfo, int index) {
        Util.checkNull(typeInfo, "typeInfo");
        if (index < 0) {
            throw new IllegalArgumentException("The index argument is negative.");
        }

        modelDataList.add(new SemanticModelData(typeInfo, index));
    }

    /**
     * <p>
     * Add the next layout feature. The SemanticModelBridge of the current graph element
     * in the layout structures should be instance of SimpleSemanticModelElement.
     * </p>
     *
     * <p>
     * The layer to be added should be one of the total layers from the root graph
     * element to the desired descendent graph element.
     * </p>
     *
     * <p>
     * Note, this method is package private. The current graph element can be in any order of
     * its parent graph element's child graph elements.
     * </p>
     *
     * @param typeInfo the type information of the SemanticModelBridge in the current graph element
     *
     * @throws IllegalArgumentException if typeInfo is null
     */
    void addNextLevelSemanticModel(String typeInfo) {
        Util.checkNull(typeInfo, "typeInfo");

        modelDataList.add(new SemanticModelData(typeInfo));
    }

    /**
     * <p>
     * Extract the descendent graph element from the root graph element based one the layout
     * structure features.
     * </p>
     *
     * <p>
     * Note, this method is package private.
     * </p>
     *
     * @return the desired descendent graph element
     *
     * @throws CompartmentNotFoundException if the compartment is supported but it does not exist in the element
     * @throws CompartmentMalformedException if the element contains malformed compartment
     */
    GraphElement extract() throws CompartmentMalformedException, CompartmentNotFoundException {

        // check the SemanticModelBridge of the root graph element
        validateUML1SemanticModelBridge(this.element, this.modelType);

        GraphElement currentElement = element;

        // check each layer structure
        for (SemanticModelData data : modelDataList) {
            DiagramElement diagremElement = null;

            int index = data.getIndex();

            if (index == -1) {
                // if the index is -1, the position is unknown, search all the child elements
                diagremElement = getSubElementByTypeInfo(currentElement, data.getTypeInfo());
            } else {
                // the position is specified
                // validate the index
                if (currentElement.countContaineds() <= index) {
                    throw new CompartmentNotFoundException("The graph element is missing, the position is " + index
                        + " but the parent graph element has only " + currentElement.countContaineds() + " children.");
                }

                // get the corresponding child diagram element
                diagremElement = currentElement.getContaineds().get(index);
            }

            // Only GraphElement is allowed
            if (!(diagremElement instanceof GraphElement)) {
                throw new CompartmentMalformedException(
                    "The element should be of GraphElement instead of diagram element");
            }
            currentElement = (GraphElement) diagremElement;

            // validate the SemanticModelBridge of the graph element
            validate(currentElement, data);
        }

        // return the desired graph element
        return currentElement;
    }

    /**
     * <p>
     * Updates the old descendent graph element to a new one.
     * </p>
     *
     * <p>
     * Note, this method is package private.
     * </p>
     *
     * @param newElement the new graph element to replace the desired descendent graph element
     *
     * @throws IllegalArgumentException if newElement is null
     * @throws CompartmentNotFoundException if the compartment is supported but it does not exist in the element
     * @throws CompartmentMalformedException if the element contains malformed compartment, or the given
     * new graph element is not a valid graph element to replace the old one
     */
    void update(GraphElement newElement) throws CompartmentMalformedException, CompartmentNotFoundException {
        Util.checkNull(newElement, "newElement");

        GraphElement graphElement = extract();

        // validate the SemanticalModelBridge of the given graph element
        validate(newElement, modelDataList.get(modelDataList.size() - 1));

        GraphElement parentElement = graphElement.getContainer();
        if (parentElement == null) {
            throw new CompartmentMalformedException(
                "The parent graph element for the graph element is missing, it is relationship is not set correctly.");
        }

        // update the new graph element
        int index = parentElement.indexOfContained(graphElement);
        parentElement.setContained(index, newElement);
        newElement.setContainer(parentElement);
    }

    /**
     * <p>
     * Search all the child elements for the given element whose SemanticalModelBridge is
     * of SimpleSemanticModelElement and the type information is the given type information.
     * </p>
     *
     * @param currentElement the current graph element to search
     * @param typeInfo the type information
     *
     * @return the expected child graph element
     *
     * @throws CompartmentNotFoundException if the desired child graph elemetn cannot be found
     */
    private DiagramElement getSubElementByTypeInfo(GraphElement currentElement, String typeInfo)
        throws CompartmentNotFoundException {
        // search all the child diagram elements
        List<DiagramElement> containedElements = currentElement.getContaineds();

        // each child diagram element
        for (DiagramElement subElement : containedElements) {
            // only graph element is handled
            if (subElement instanceof GraphElement) {
                SemanticModelBridge bridge = ((GraphElement) subElement).getSemanticModel();
                // only handle the SimpleSemanticModelElement case
                if (bridge instanceof SimpleSemanticModelElement) {
                    SimpleSemanticModelElement simpleBridge = (SimpleSemanticModelElement) bridge;

                    // check the type information
                    if (typeInfo.equals(simpleBridge.getTypeInfo())) {
                        return subElement;
                    }
                }
            }
        }

        // no child graph element is found, so throws CompartmentNotFoundException
        throw new CompartmentNotFoundException("The graph element with " + typeInfo + " type information is missing.");
    }

    /**
     * <p>
     * Validates the given element with some constraints for its associated SemanticalModelBridge.
     * </p>
     *
     * <p>
     * If the graph element passes validation, then no exception will be thrown, otherwise
     * CompartmentNotFoundException or CompartmentMalformedException will be thrown.
     * </p>
     *
     * @param currentElement the current graph element
     * @param data the SemanticalModelBridge constraints for the graph element
     *
     * @throws CompartmentNotFoundException if the compartment is supported but it does not exist in the element
     * @throws CompartmentMalformedException if the element contains malformed compartment
     */
    private void validate(GraphElement currentElement, SemanticModelData data) throws CompartmentNotFoundException,
        CompartmentMalformedException {
        // when typeInfo is null, check the SemanticModelBridge should be of
        // SimpleSemanticModelElement type, otherwise UML1SemanticModelBridge
        if (data.getTypeInfo() != null) {
            validateSimpleSemanticModelElement(currentElement, data.getTypeInfo());
        } else {
            validateUML1SemanticModelBridge(currentElement, data.getModelType());
        }
    }

    /**
     * <p>
     * Validates the given element with some constraints for its associated SemanticalModelBridge.
     * </p>
     *
     * <p>
     * The SemanticModelBridge for the given graph element should be of SimpleSemanticModelElement
     * type and the type information should be the same too.
     * </p>
     *
     * <p>
     * If the graph element passes validation, then no exception will be thrown, otherwise
     * CompartmentNotFoundException or CompartmentMalformedException will be thrown.
     * </p>
     *
     * @param element the current graph element
     * @param typeInfo the expected type information
     *
     * @throws CompartmentNotFoundException if the compartment is supported but it does not exist in the element
     * @throws CompartmentMalformedException if the element contains malformed compartment
     */
    private void validateSimpleSemanticModelElement(GraphElement element, String typeInfo)
        throws CompartmentNotFoundException, CompartmentMalformedException {
        SemanticModelBridge sematicModel = element.getSemanticModel();

        // The associated SematicModelBridge instance is required
        if (sematicModel == null) {
            throw new CompartmentNotFoundException("The associated SematicModelBridge is missing.");
        }

        // The type of the associated SematicModelBridge instance is SimpleSemanticModelElement
        if (!(sematicModel instanceof SimpleSemanticModelElement)) {
            throw new CompartmentMalformedException(
                "The associated SematicModelBridge should be of SimpleSemanticModelElement type.");
        }

        // validate the type information
        SimpleSemanticModelElement simpleSematicModel = (SimpleSemanticModelElement) sematicModel;
        if (!typeInfo.equals(simpleSematicModel.getTypeInfo())) {
            throw new CompartmentMalformedException("The type information is not the same, it should be " + typeInfo
                + ", instead of " + simpleSematicModel.getTypeInfo());
        }
    }

    /**
     * <p>
     * Validates the given element with some constraints for its associated SemanticalModelBridge.
     * </p>
     *
     * <p>
     * The SemanticModelBridge for the given graph element should be of Uml1SemanticModelBridge
     * type and the uml element associated should be of the given type.
     * </p>
     *
     * <p>
     * If the graph element passes validation, then no exception will be thrown, otherwise
     * CompartmentNotFoundException or CompartmentMalformedException will be thrown.
     * </p>
     *
     * @param element the current graph element
     * @param modelType the desired uml element type
     *
     * @throws CompartmentNotFoundException if the compartment is supported but it does not exist in the element
     * @throws CompartmentMalformedException if the element contains malformed compartment
     */
    private void validateUML1SemanticModelBridge(GraphElement element, Class<?> modelType)
        throws CompartmentNotFoundException, CompartmentMalformedException {
        SemanticModelBridge sematicModel = element.getSemanticModel();

        // The associated SematicModelBridge instance is required
        if (sematicModel == null) {
            throw new CompartmentNotFoundException("The associated SematicModelBridge is missing.");
        }

        // The type of the associated SematicModelBridge instance is Uml1SemanticModelBridge
        if (!(sematicModel instanceof Uml1SemanticModelBridge)) {
            throw new CompartmentMalformedException(
                "The associated SematicModelBridge should be of Uml1SemanticModelBridge type.");
        }

        // The associated Element is checked
        if (modelType != null) {
            Uml1SemanticModelBridge umlSematicModel = (Uml1SemanticModelBridge) sematicModel;
            Element modelElement = umlSematicModel.getElement();

            // Null is not allowed
            if (modelElement == null) {
                throw new CompartmentMalformedException(
                    "No UML model element is associated with the Uml1SemanticModelBridge.");
            }

            // check the class type
            if (!modelType.isAssignableFrom(modelElement.getClass())) {
                throw new CompartmentMalformedException("The uml model element type is not the same, it should be "
                    + modelType + ", instead of " + modelElement.getClass());
            }
        }
    }

    /**
     * <p>
     * This is a data class storing uml element type, type information and index information
     * for a graph element.
     * </p>
     *
     * <p>
     * When the SemanticalModelBridge for the graph element is Uml1SemanticModelBridge,
     * the uml element type can be used, when it is SimpleSemanticModelElement, the type
     * information can be used.
     * </p>
     *
     * <p>
     * This class is only used in the StructureCompartmentExtractor class.
     * </p>
     *
     * <p>
     * Thread Safety : This class is immutable and so is thread safe.
     * </p>
     *
     * @author TCSDEVELOPER
     * @version 1.0
     */
    private class SemanticModelData {
        /**
         * <p>
         * Represent the uml element class type for the SemanticModelBridage in the graph element.
         * </p>
         *
         * <p>
         * This variable is used only for the situation when the SemanticModelBridage of the graph
         * element is Uml1SemanticModelBridge.
         * </p>
         *
         * <p>
         * Set in the constructor and never changed afterwards, can be null.
         * </p>
         */
        private final Class modelType;

        /**
         * <p>
         * Represent the type information for the SemanticModelBridage in the graph element.
         * </p>
         *
         * <p>
         * This variable is used only for the situation when the SemanticModelBridage of the graph
         * element is SimpleSemanticModelElement.
         * </p>
         *
         * <p>
         * Set in the constructor and never changed afterwards, can be null.
         * </p>
         */
        private final String typeInfo;

        /**
         * <p>
         * Represent the index that identify the position of the graph element in its parent graph element's child
         * graph elements.
         * </p>
         *
         * <p>
         * Note, when the value for this variable is -1, it means the graph element can be in any position.
         * </p>
         *
         * <p>
         * Set in the constructor and never changed afterwards.
         * </p>
         */
        private final int index;

        /**
         * <p>
         * Create a SemanticModelData instance with uml element class type and index specified.
         * </p>
         *
         * <p>
         * Note, this constructor is used for the SemanticalModelBridge of the graph element is
         * Uml1SemanticModelBridge.
         * </p>
         *
         * @param modelType the uml element class type
         * @param index the position for the graph element in its parent graph elemnent's child
         * graph elements
         */
        public SemanticModelData(Class modelType, int index) {
            this.modelType = modelType;
            this.index = index;
            this.typeInfo = null;
        }

        /**
         * <p>
         * Create a SemanticModelData instance with type information and index specified.
         * </p>
         *
         * <p>
         * Note, this constructor is used for the SemanticalModelBridge of the graph element is
         * SimpleSemanticModelElement.
         * </p>
         *
         * @param typeInfo the uml element class type
         * @param index the position for the graph element
         */
        public SemanticModelData(String typeInfo, int index) {
            this.typeInfo = typeInfo;
            this.index = index;
            this.modelType = null;
        }

        /**
         * <p>
         * Create a SemanticModelData instance with type information specified.
         * </p>
         *
         * <p>
         * The index field will be set to -1 to identify the the graph element can be
         * in any position in its parent graph element's child graph elements.
         * </p>
         *
         * <p>
         * Note, this constructor is used for the SemanticalModelBridge of the graph element is
         * SimpleSemanticModelElement.
         * </p>
         *
         * @param typeInfo the uml element class type
         */
        public SemanticModelData(String typeInfo) {
            this.typeInfo = typeInfo;
            this.index = -1;
            this.modelType = null;
        }

        /**
         * <p>
         * Return the uml element class type for the SemanticModelBridage in the graph element.
         * </p>
         *
         * <p>
         * Note, it may be null.
         * </p>
         *
         * @return the uml element class type for the SemanticModelBridage in the graph element.
         */
        public Class getModelType() {
            return this.modelType;
        }

        /**
         * <p>
         * Return the type information for the SemanticModelBridage in the graph element.
         * </p>
         *
         * <p>
         * Note, it may be null.
         * </p>
         *
         * @return the type information for the SemanticModelBridage in the graph element.
         */
        public String getTypeInfo() {
            return this.typeInfo;
        }

        /**
         * <p>
         * Return the index that identify the position of the graph element in its parent
         * graph element's child graph elements.
         * </p>
         *
         * <p>
         * Note, it may be -1.
         * </p>
         *
         * @return the index that identify the position of the graph element in its parent
         * graph element's child graph elements.
         */
        public int getIndex() {
            return this.index;
        }
    }
}
