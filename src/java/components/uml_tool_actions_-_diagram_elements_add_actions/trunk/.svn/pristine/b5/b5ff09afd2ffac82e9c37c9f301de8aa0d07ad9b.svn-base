/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements.accuracytests;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.model.activitygraphs.ObjectFlowStateImpl;
import com.topcoder.uml.model.commonbehavior.instances.ObjectImpl;
import com.topcoder.uml.model.commonbehavior.instances.StimulusImpl;
import com.topcoder.uml.model.commonbehavior.links.LinkImpl;
import com.topcoder.uml.model.core.Element;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;
import com.topcoder.uml.model.core.relationships.AssociationImpl;
import com.topcoder.uml.model.statemachines.PseudostateImpl;

/**
 * This class will create some Graphic instance for testing.
 *
 * @author Chenhong
 * @version 1.0
 */
public final class HelperUtil {
    /**
     * Create a GraphNode instance for testing class <code>ActivityStateCompartmentExtractor</code>.
     *
     * @return a GraphNode instance.
     */
    public static GraphNode createGraphNodeInstance() {
        GraphNode root = new GraphNode();

        Uml1SemanticModelBridge bridge = new Uml1SemanticModelBridge();
        bridge.setElement(new PseudostateImpl());

        // Set the Uml1SemanticModel.
        root.setSemanticModel(bridge);
        Dimension d = new Dimension();
        d.setHeight(new Double(100));
        d.setWidth(new Double(1000));

        GraphNode stereoTypeNode = new GraphNode();
        stereoTypeNode.setSemanticModel(createSimpleSemanticModel(EnumUtil.STEREOTYPE_COMPARTMENT));
        stereoTypeNode.setSize(d);
        root.addContained(stereoTypeNode);
        stereoTypeNode.setContainer(root);

        GraphNode nameNode = new GraphNode();
        nameNode.setSemanticModel(createSimpleSemanticModel(EnumUtil.NAME));
        nameNode.setVisible(true);

        nameNode.setSize(d);

        root.addContained(nameNode);
        nameNode.setContainer(root);

        return root;
    }

    /**
     * Create a GraphNode instance for testing class <code>ActivityStateCompartmentExtractor </code>.
     *
     * @return a GraphNode instance.
     */
    public static GraphNode createGraphNodeInstanceForActivityState() {
        GraphNode root = new GraphNode();

        // Create a Uml1SemanticModelBridge instance with PseudostateImpl element
        Uml1SemanticModelBridge bridge = new Uml1SemanticModelBridge();
        // the element type must be ObjectFlowState.
        bridge.setElement(new ObjectFlowStateImpl());

        // Set the Uml1SemanticModel.
        root.setSemanticModel(bridge);

        Dimension d = new Dimension();
        d.setHeight(new Double(100));
        d.setWidth(new Double(1000));

        // create a name compartment and add it to the root GraphNode.
        GraphNode nameCompartment = new GraphNode();
        nameCompartment.setSemanticModel(createSimpleSemanticModel(EnumUtil.NAME_COMPARTMENT));
        root.addContained(nameCompartment);
        nameCompartment.setContainer(root);

        // create a name and type compartment and add it to its parent name compartment GraphNode
        GraphNode nameAndTypeCompartment = new GraphNode();
        nameAndTypeCompartment.setSemanticModel(createSimpleSemanticModel(EnumUtil.NAME_AND_TYPE));
        nameAndTypeCompartment.setVisible(true);

        nameCompartment.addContained(nameAndTypeCompartment);
        nameAndTypeCompartment.setContainer(nameCompartment);

        // Create a name node and add it to its parent name and type compartment.
        GraphNode nameNode = new GraphNode();
        nameNode.setSemanticModel(createSimpleSemanticModel(EnumUtil.NAME));
        nameNode.setVisible(true);

        // set the size of the nameNode;
        nameNode.setSize(d);

        nameAndTypeCompartment.addContained(nameNode);
        nameNode.setContainer(nameAndTypeCompartment);

        return root;
    }

    /**
     * Create a GraphEdge instance for test class <code>AssociationCompartmentExtractor </code>.
     *
     *
     * @return a GraphEdge instance.
     */
    public static GraphEdge createGraphEdgeInstanceForAssociationCompartment() {
        GraphEdge root = new GraphEdge();

        Dimension d = new Dimension();
        d.setHeight(new Double(100));
        d.setWidth(new Double(1000));

        // UML:Association
        root.setSemanticModel(createUmlSemanticModel(new AssociationImpl()));

        GraphNode firstAssociationEndNode = new GraphNode();
        firstAssociationEndNode.setSemanticModel(createUmlSemanticModel(new AssociationEndImpl()));
        firstAssociationEndNode.setSize(d);
        root.addContained(firstAssociationEndNode);
        firstAssociationEndNode.setContainer(root);

        GraphNode secondAssociationEndNode = new GraphNode();
        secondAssociationEndNode.setSemanticModel(createUmlSemanticModel(new AssociationEndImpl()));
        secondAssociationEndNode.setSize(d);
        root.addContained(secondAssociationEndNode);
        secondAssociationEndNode.setContainer(root);


        // add DirectedName;

        GraphNode directNameNode = new GraphNode();
        directNameNode.setSemanticModel(createSimpleSemanticModel(EnumUtil.DIRECT_NAME));
        root.addContained(directNameNode);
        directNameNode.setContainer(root);

        // add NameNode to the subnode of direct name node.
        GraphNode nameNode = new GraphNode();
        nameNode.setSemanticModel(createSimpleSemanticModel(EnumUtil.NAME));
        nameNode.setSize(d);

        directNameNode.addContained(nameNode);
        nameNode.setContainer(directNameNode);

        // add stereotype compartment node to the root node.
        GraphNode stereoTypeNode = new GraphNode();
        stereoTypeNode.setSemanticModel(createSimpleSemanticModel(EnumUtil.STEREOTYPE_COMPARTMENT));
        // set the size to the sterotype node.
        stereoTypeNode.setSize(d);
        root.addContained(stereoTypeNode);
        stereoTypeNode.setContainer(root);

        return root;
    }

    /**
     * Create a GraphEdge instance for testing class ClassifierCompartmentExtractor.
     * @return a GraphNode instance.
     */
    public static GraphNode createGraphNodeForClassifierCompartment() {
        GraphNode root = new GraphNode();
        root.setSemanticModel(createUmlSemanticModel(new ClassImpl()));

        // create a name compartment and add it to the root GraphNode.
        GraphNode nameCompartment = new GraphNode();
        nameCompartment.setSemanticModel(createSimpleSemanticModel(EnumUtil.NAME_COMPARTMENT));
        root.addContained(nameCompartment);
        nameCompartment.setContainer(root);

        GraphNode stereoTypeNode = new GraphNode();
        stereoTypeNode.setSemanticModel(createSimpleSemanticModel(EnumUtil.STEREOTYPE_COMPARTMENT));
        nameCompartment.addContained(stereoTypeNode);
        stereoTypeNode.setContainer(nameCompartment);

        GraphNode nameNode = new GraphNode();
        nameNode.setSemanticModel(createSimpleSemanticModel(EnumUtil.NAME));
        nameCompartment.addContained(nameNode);
        nameNode.setContainer(nameCompartment);

        GraphNode namespaceNode = new GraphNode();
        namespaceNode.setSemanticModel(createSimpleSemanticModel(EnumUtil.NAMESPACE_COMPARTMENT));
        nameCompartment.addContained(namespaceNode);
        namespaceNode.setContainer(nameCompartment);

        GraphNode compartmentSeperator = new GraphNode();
        compartmentSeperator.setSemanticModel(createSimpleSemanticModel(EnumUtil.COMPARTMENT_SEPERATOR));
        root.addContained(compartmentSeperator);
        compartmentSeperator.setContainer(root);


        Dimension d = new Dimension();
        d.setHeight(new Double(1));
        d.setWidth(new Double(10));


        GraphNode attribute = new GraphNode();
        attribute.setVisible(true);
        attribute.setSemanticModel(createSimpleSemanticModel(EnumUtil.ATTRIBUTE_COMPARTMENT));
        attribute.setSize(d);



        GraphNode delimitedSection = new GraphNode();
        delimitedSection.setSemanticModel(createSimpleSemanticModel(EnumUtil.DELIMITED_SECTION));
        delimitedSection.setSize(d);

        attribute.addContained(delimitedSection);
        delimitedSection.setContainer(attribute);

        root.addContained(attribute);
        attribute.setContainer(root);

        GraphNode node = new GraphNode();
        node.setSemanticModel(createSimpleSemanticModel(EnumUtil.COMPARTMENT_SEPERATOR));

        root.addContained(node);
        node.setContainer(root);

        node = new GraphNode();
        node.setSemanticModel(createSimpleSemanticModel(EnumUtil.OPERATION_COMPARTMENT));
        node.setSize(d);

        delimitedSection = new GraphNode();
        delimitedSection.setSemanticModel(createSimpleSemanticModel(EnumUtil.DELIMITED_SECTION));
        delimitedSection.setSize(d);
        node.addContained(delimitedSection );
        delimitedSection .setContainer(node);

        root.addContained(node);
        node.setContainer(root);

        return root;
    }

    /**
     * Create a GraphNode instance for testing class <code>DefaultEdgeCompartmentExtractor</code>.
     *
     * @return a GraphNode instance.
     */
    public static GraphEdge createGraphEdgeInstance() {
        GraphEdge root = new GraphEdge();

        // Create a Uml1SemanticModelBridge instance with PseudostateImpl element
        Uml1SemanticModelBridge bridge = new Uml1SemanticModelBridge();
        bridge.setElement(new PseudostateImpl());

        // Set the Uml1SemanticModel.
        root.setSemanticModel(bridge);

        // There should be a Graph element exists, so we should add one compartment more.

        Dimension d = new Dimension();
        d.setHeight(new Double(100));
        d.setWidth(new Double(1000));

        GraphNode stereoTypeNode = new GraphNode();
        stereoTypeNode.setSemanticModel(createSimpleSemanticModel(EnumUtil.STEREOTYPE_COMPARTMENT));
        // set the size to the sterotype node.
        stereoTypeNode.setSize(d);
        root.addContained(stereoTypeNode);
        stereoTypeNode.setContainer(root);

        // create a name compartment and add it to the root GraphNode
        GraphNode nameNode = new GraphNode();
        nameNode.setSemanticModel(createSimpleSemanticModel(EnumUtil.NAME));
        nameNode.setVisible(true);

        // set the size to the name compartment node.
        nameNode.setSize(d);

        root.addContained(nameNode);
        nameNode.setContainer(root);

        return root;
    }


    /**
     * Create a GraphNode instance for testing class <code>DefaultNodeCompartmentExtractor</code>.
     *
     * @return a GraphNode instance.
     */
    public static GraphNode createGraphNodeInstanceForDefaultNodeCompartmentExtractor() {
        GraphNode root = new GraphNode();

        // Create a Uml1SemanticModelBridge instance with PseudostateImpl element
        Uml1SemanticModelBridge bridge = new Uml1SemanticModelBridge();
        bridge.setElement(new PseudostateImpl());

        root.setSemanticModel(bridge);

        Dimension d = new Dimension();
        d.setHeight(new Double(100));
        d.setWidth(new Double(1000));

        GraphNode nameCompartment = new GraphNode();
        nameCompartment.setSemanticModel(createSimpleSemanticModel(EnumUtil.NAME_COMPARTMENT));

        GraphNode stereoTypeNode = new GraphNode();
        stereoTypeNode.setSemanticModel(createSimpleSemanticModel(EnumUtil.STEREOTYPE_COMPARTMENT));
        // set the size to the sterotype node.
        stereoTypeNode.setSize(d);
        nameCompartment.addContained(stereoTypeNode);
        stereoTypeNode.setContainer(nameCompartment);

        GraphNode nameNode = new GraphNode();
        nameNode.setSemanticModel(createSimpleSemanticModel(EnumUtil.NAME));
        nameNode.setVisible(true);
        nameNode.setSize(d);

        // set the size to the name compartment node.
        nameNode.setSize(d);

        nameCompartment.addContained(nameNode);
        nameNode.setContainer(nameCompartment);

        GraphNode namespaceNode = new GraphNode();
        namespaceNode.setSemanticModel(createSimpleSemanticModel(EnumUtil.NAMESPACE_COMPARTMENT));
        namespaceNode.setSize(d);
        nameCompartment.addContained(namespaceNode);
        namespaceNode.setContainer(nameCompartment);


        root.addContained(nameCompartment);
        nameCompartment.setContainer(root);

        return root;
    }

    /**
     * Create GraphEdge instance for testing GeneralizationCompartmentExtractor.
     * @return a GraphEdge instance.
     */
    public static GraphEdge createGraphEdgeForGeneralizationCompartmentExtractor() {
        GraphEdge root = new GraphEdge();

        Uml1SemanticModelBridge bridge = new Uml1SemanticModelBridge();
        bridge.setElement(new PseudostateImpl());

        root.setSemanticModel(bridge);

        Dimension d = new Dimension();
        d.setHeight(new Double(100));
        d.setWidth(new Double(1000));

        GraphNode directName = new GraphNode();
        directName.setSemanticModel(createSimpleSemanticModel(EnumUtil.DIRECT_NAME));
        directName.setSize(d);
        root.addContained(directName);
        directName.setContainer(root);

        GraphNode nameNode = new GraphNode();
        nameNode.setSemanticModel(createSimpleSemanticModel(EnumUtil.NAME));
        nameNode.setVisible(true);
        nameNode.setSize(d);

        directName.addContained(nameNode);
        nameNode.setContainer(directName);

        GraphNode stereoTypeNode = new GraphNode();
        stereoTypeNode.setSemanticModel(createSimpleSemanticModel(EnumUtil.STEREOTYPE_COMPARTMENT));
        // set the size to the sterotype node.
        stereoTypeNode.setSize(d);
        root.addContained(stereoTypeNode);
        stereoTypeNode.setContainer(root);


        return root;
    }

    /**
     * Create GraphNode instance for testing MessageCompartmentExtractor class.
     * @return GraphNode instance
     */
    public static GraphNode createGraphNodeInstanceForMessageCompartmentExtractor() {
        GraphNode root = new GraphNode();
        root.setSemanticModel(createUmlSemanticModel(new LinkImpl()));

        GraphNode stimulusNode = new GraphNode();
        stimulusNode.setSemanticModel(createUmlSemanticModel(new StimulusImpl()));

        Dimension d = new Dimension();
        d.setHeight(new Double(50));
        d.setWidth(new Double(5));

        GraphNode stereotypeNode = new GraphNode();
        stereotypeNode.setSemanticModel(createSimpleSemanticModel(EnumUtil.STEREOTYPE_COMPARTMENT));
        stereotypeNode.setSize(d);

        stimulusNode.addContained(stereotypeNode);
        stereotypeNode.setContainer(stimulusNode);

        root.addContained(stimulusNode);
        stimulusNode.setContainer(root);

        return root;
    }

    /**
     * Create GraphNode instance for testing ObjectCompartmentExtractor.
     * @return a GraphNode instance.
     */
    public static GraphNode createGraphNodeInstanceForObjectCompartmentExtractor() {
        GraphNode root = new GraphNode();
        root.setSemanticModel(createUmlSemanticModel(new ObjectImpl()));

        GraphNode headerCompartment = new GraphNode();
        headerCompartment.setSemanticModel(createSimpleSemanticModel(EnumUtil.HEADER_COMPARTMENT));

        root.addContained(headerCompartment);
        headerCompartment.setContainer(root);

        Dimension d = new Dimension();
        d.setHeight(new Double(100));;
        d.setWidth(new Double(100));

        GraphNode nameCompartment = new GraphNode();

        nameCompartment.setSemanticModel(createSimpleSemanticModel(EnumUtil.NAME_COMPARTMENT));

        GraphNode stereotypeNode = new GraphNode();
        stereotypeNode.setSemanticModel(createSimpleSemanticModel(EnumUtil.STEREOTYPE_COMPARTMENT));
        stereotypeNode.setSize(d);

        nameCompartment.addContained(stereotypeNode);
        stereotypeNode.setContainer(nameCompartment);

        GraphNode nameAndTypeNode = new GraphNode();
        nameAndTypeNode.setSemanticModel(createSimpleSemanticModel(EnumUtil.NAME_AND_TYPE));
        nameCompartment.addContained(nameAndTypeNode);
        nameAndTypeNode.setContainer(nameCompartment);

        GraphNode nameNode = new GraphNode();
        nameNode.setSemanticModel(createSimpleSemanticModel(EnumUtil.NAME));
        nameNode.setSize(d);

        nameAndTypeNode.addContained(nameNode);
        nameNode.setContainer(nameAndTypeNode);

        root.addContained(nameCompartment);
        nameCompartment.setContainer(root);

        return root;

    }

    /**
     * <p>
     * Greates a SimpleSemanticModelElement instance with the type.
     * </p>
     *
     * @param typeInfo
     *            the type information
     * @return a SimpleSemanticModelElement instance with the given type information.
     */
    public static SimpleSemanticModelElement createSimpleSemanticModel(String typeInfo) {
        SimpleSemanticModelElement semanticModel = new SimpleSemanticModelElement();
        semanticModel.setTypeinfo(typeInfo);
        return semanticModel;
    }

    /**
     * <p>
     * Greates a Uml1SemanticModelBridge instance with the given uml element.
     * </p>
     *
     * @param element a uml element
     *
     * @return a SimpleSemanticModelElement instance.
     */
    public static Uml1SemanticModelBridge createUmlSemanticModel(Element element) {
        Uml1SemanticModelBridge bridge = new Uml1SemanticModelBridge();
        bridge.setElement(element);
        return bridge;
    }
}