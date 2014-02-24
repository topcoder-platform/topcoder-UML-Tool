/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements;

import java.io.File;

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
import com.topcoder.uml.model.core.relationships.GeneralizationImpl;
import com.topcoder.uml.model.statemachines.PseudostateImpl;
import com.topcoder.uml.model.usecases.ActorImpl;
import com.topcoder.uml.model.usecases.IncludeImpl;
import com.topcoder.util.config.ConfigManager;

/**
 * <p>
 * A helper class to perform those common operations which are helpful for the test.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TestHelper {
    /**
     * <p>
     * This private constructor prevents to create a new instance.
     * </p>
     */
    private TestHelper() {
    }

    /**
     * <p>
     * Use the given file to config the given namespace the format of the config file is
     * ConfigManager.CONFIG_XML_FORMAT.
     * </p>
     *
     * @param namespace use the namespace to load config information to ConfigManager
     * @param fileName config file to set up environment
     *
     * @throws Exception when any exception occurs
     */
    public static void loadSingleXMLConfig(String namespace, String fileName) throws Exception {
        //set up environment
        ConfigManager config = ConfigManager.getInstance();
        File file = new File(fileName);

        //config namespace
        if (config.existsNamespace(namespace)) {
            config.removeNamespace(namespace);
        }

        config.add(namespace, file.getCanonicalPath(), ConfigManager.CONFIG_XML_FORMAT);
    }

    /**
     * <p>
     * Remove the given namespace in the ConfigManager.
     * </p>
     *
     * @param namespace namespace use to remove the config information in ConfigManager
     *
     * @throws Exception when any exception occurs
     */
    public static void clearConfigFile(String namespace) throws Exception {
        ConfigManager config = ConfigManager.getInstance();

        //clear the environment
        if (config.existsNamespace(namespace)) {
            config.removeNamespace(namespace);
        }
    }

    /**
     * <p>
     * This method creates a GraphNode instance that follows the structures of ActivityNode.
     * </p>
     *
     * @return a GraphNode instance that follows the structures of ActivityNode.
     */
    public static GraphNode createGraphNodeForActivityNode() {
        GraphNode node = new GraphNode();
        node.setSemanticModel(createUmlSemanticModel(new PseudostateImpl()));

        // create a stereotype node
        GraphNode stereoTypeNode = new GraphNode();
        stereoTypeNode.setSemanticModel(createSimpleSemanticModel("StereotypeCompartment"));

        // create a name node
        GraphNode nameNode = new GraphNode();
        nameNode.setSemanticModel(createSimpleSemanticModel("Name"));

        node.addContained(stereoTypeNode);
        stereoTypeNode.setContainer(node);
        node.addContained(nameNode);
        nameNode.setContainer(node);

        return node;
    }

    /**
     * <p>
     * This method creates a GraphNode instance that follows the structures of ActivityState.
     * </p>
     *
     * @return a GraphNode instance that follows the structures of ActivityState.
     */
    public static GraphNode createGraphNodeForActivityState() {
        GraphNode root = new GraphNode();

        GraphNode node = root;
        node.setSemanticModel(createUmlSemanticModel(new ObjectFlowStateImpl()));

        // creates a NameCompartment node
        GraphNode subNode = new GraphNode();
        subNode.setSemanticModel(createSimpleSemanticModel("NameCompartment"));

        node.addContained(subNode);
        subNode.setContainer(node);
        node = subNode;

        // creates a NameAndType node
        subNode = new GraphNode();
        subNode.setSemanticModel(createSimpleSemanticModel("NameAndType"));

        node.addContained(subNode);
        subNode.setContainer(node);
        node = subNode;

        // creates a Name node
        subNode = new GraphNode();
        subNode.setSemanticModel(createSimpleSemanticModel("Name"));

        node.addContained(subNode);
        subNode.setContainer(node);
        node = subNode;

        return root;
    }

    /**
     * <p>
     * This method creates a GraphEdge instance that follows the structures of Association.
     * </p>
     *
     * @return a GraphEdge instance that follows the structures of Association.
     */
    public static GraphEdge createGraphEdgeForAssociation() {
        GraphEdge root = new GraphEdge();
        root.setSemanticModel(createUmlSemanticModel(new AssociationImpl()));

        GraphNode node = new GraphNode();
        node.setSemanticModel(createUmlSemanticModel(new AssociationEndImpl()));

        // The first association end
        root.addContained(node);
        node.setContainer(root);

        node = new GraphNode();
        node.setSemanticModel(createUmlSemanticModel(new AssociationEndImpl()));

        // The second association end
        root.addContained(node);
        node.setContainer(root);

        // creates a DirectedName node
        node = new GraphNode();
        node.setSemanticModel(createSimpleSemanticModel("DirectedName"));

        // creates a Name node
        GraphNode subNode = new GraphNode();
        subNode.setSemanticModel(createSimpleSemanticModel("Name"));

        node.addContained(subNode);
        subNode.setContainer(node);

        // The Name compartment
        root.addContained(node);
        node.setContainer(root);

        // creates a StereotypeCompartment node
        node = new GraphNode();
        node.setSemanticModel(createSimpleSemanticModel("StereotypeCompartment"));

        // The stereotype compartment
        root.addContained(node);
        node.setContainer(root);

        return root;
    }

    /**
     * <p>
     * This method creates a GraphNode instance that follows the structures of Classifier.
     * </p>
     *
     * @return a GraphNode instance that follows the structures of Classifier.
     */
    public static GraphNode createGraphNodeForClassifier() {
        GraphNode root = new GraphNode();
        root.setSemanticModel(createUmlSemanticModel(new ClassImpl()));

        // creates a NameCompartment node
        GraphNode node = new GraphNode();
        node.setSemanticModel(createSimpleSemanticModel("NameCompartment"));

        // creates a StereotypeCompartment node
        GraphNode subNode = new GraphNode();
        subNode.setSemanticModel(createSimpleSemanticModel("StereotypeCompartment"));
        node.addContained(subNode);
        subNode.setContainer(node);

        // creates a Name node
        subNode = new GraphNode();
        subNode.setSemanticModel(createSimpleSemanticModel("Name"));
        node.addContained(subNode);
        subNode.setContainer(node);

        // creates a NamespaceCompartment node
        subNode = new GraphNode();
        subNode.setSemanticModel(createSimpleSemanticModel("NamespaceCompartment"));
        node.addContained(subNode);
        subNode.setContainer(node);

        root.addContained(node);
        node.setContainer(root);

        // creates a CompartmentSeparator node
        node = new GraphNode();
        node.setSemanticModel(createSimpleSemanticModel("CompartmentSeparator"));

        root.addContained(node);
        node.setContainer(root);

        // creates a AttributeCompartment node
        node = new GraphNode();
        node.setSemanticModel(createSimpleSemanticModel("AttributeCompartment"));

        // creates a DelimitedSection node
        subNode = new GraphNode();
        subNode.setSemanticModel(createSimpleSemanticModel("DelimitedSection"));
        node.addContained(subNode);
        subNode.setContainer(node);

        root.addContained(node);
        node.setContainer(root);

        // creates a CompartmentSeparator node
        node = new GraphNode();
        node.setSemanticModel(createSimpleSemanticModel("CompartmentSeparator"));

        root.addContained(node);
        node.setContainer(root);

        // creates a OperationCompartment node
        node = new GraphNode();
        node.setSemanticModel(createSimpleSemanticModel("OperationCompartment"));

        // creates a DelimitedSection node
        subNode = new GraphNode();
        subNode.setSemanticModel(createSimpleSemanticModel("DelimitedSection"));
        node.addContained(subNode);
        subNode.setContainer(node);

        root.addContained(node);
        node.setContainer(root);

        return root;
    }

    /**
     * <p>
     * This method creates a GraphEdge instance that follows the structures of DefaultEdge.
     * </p>
     *
     * @return a GraphEdge instance that follows the structures of DefaultEdge.
     */
    public static GraphEdge createGraphEdgeForDefaultEdge() {
        GraphEdge edge = new GraphEdge();
        edge.setSemanticModel(createUmlSemanticModel(new IncludeImpl()));

        // creates a StereotypeCompartment node
        GraphNode stereoTypeNode = new GraphNode();
        stereoTypeNode.setSemanticModel(createSimpleSemanticModel("StereotypeCompartment"));

        // creates a Name node
        GraphNode nameNode = new GraphNode();
        nameNode.setSemanticModel(createSimpleSemanticModel("Name"));

        edge.addContained(stereoTypeNode);
        stereoTypeNode.setContainer(edge);
        edge.addContained(nameNode);
        nameNode.setContainer(edge);

        return edge;
    }

    /**
     * <p>
     * This method creates a GraphNode instance that follows the structures of DefaultNode.
     * </p>
     *
     * @return a GraphNode instance that follows the structures of DefaultNode.
     */
    public static GraphNode createGraphNodeForDefaultNode() {
        GraphNode root = new GraphNode();
        root.setSemanticModel(createUmlSemanticModel(new ActorImpl()));

        // creates a NameCompartment node
        GraphNode node = new GraphNode();
        node.setSemanticModel(createSimpleSemanticModel("NameCompartment"));

        // creates a StereotypeCompartment node
        GraphNode subNode = new GraphNode();
        subNode.setSemanticModel(createSimpleSemanticModel("StereotypeCompartment"));
        node.addContained(subNode);
        subNode.setContainer(node);

        // creates a Name node
        subNode = new GraphNode();
        subNode.setSemanticModel(createSimpleSemanticModel("Name"));
        node.addContained(subNode);
        subNode.setContainer(node);

        // creates a NamespaceCompartment node
        subNode = new GraphNode();
        subNode.setSemanticModel(createSimpleSemanticModel("NamespaceCompartment"));
        node.addContained(subNode);
        subNode.setContainer(node);

        root.addContained(node);
        node.setContainer(root);

        return root;
    }

    /**
     * <p>
     * This method creates a GraphEdge instance that follows the structures of Generalization.
     * </p>
     *
     * @return a GraphEdge instance that follows the structures of Generalization.
     */
    public static GraphEdge createGraphEdgeForGeneralization() {
        GraphEdge edge = new GraphEdge();
        edge.setSemanticModel(createUmlSemanticModel(new GeneralizationImpl()));

        // creates a DirectedName node
        GraphNode node = new GraphNode();
        node.setSemanticModel(createSimpleSemanticModel("DirectedName"));

        // creates a Name node
        GraphNode subNode = new GraphNode();
        subNode.setSemanticModel(createSimpleSemanticModel("Name"));
        node.addContained(subNode);
        subNode.setContainer(node);

        edge.addContained(node);
        node.setContainer(edge);

        // creates a StereotypeCompartment node
        node = new GraphNode();
        node.setSemanticModel(createSimpleSemanticModel("StereotypeCompartment"));

        edge.addContained(node);
        node.setContainer(edge);

        return edge;
    }

    /**
     * <p>
     * This method creates a GraphNode instance that follows the structures of Message.
     * </p>
     *
     * @return a GraphNode instance that follows the structures of Message.
     */
    public static GraphNode createGraphNodeForMessage() {
        GraphNode root = new GraphNode();
        root.setSemanticModel(createUmlSemanticModel(new LinkImpl()));

        GraphNode node = new GraphNode();
        node.setSemanticModel(createUmlSemanticModel(new StimulusImpl()));

        // creates a StereotypeCompartment node
        GraphNode subNode = new GraphNode();
        subNode.setSemanticModel(createSimpleSemanticModel("StereotypeCompartment"));

        node.addContained(subNode);
        subNode.setContainer(node);

        root.addContained(node);
        node.setContainer(root);

        return root;
    }

    /**
     * <p>
     * This method creates a GraphNode instance that follows the structures of Object.
     * </p>
     *
     * @return a GraphNode instance that follows the structures of Object.
     */
    public static GraphNode createGraphNodeForObject() {
        GraphNode root = new GraphNode();
        root.setSemanticModel(createUmlSemanticModel(new ObjectImpl()));

        // creates a HeaderCompartment node
        GraphNode node = new GraphNode();
        node.setSemanticModel(createSimpleSemanticModel("HeaderCompartment"));

        root.addContained(node);
        node.setContainer(root);

        // creates a NameCompartment node
        node = new GraphNode();
        node.setSemanticModel(createSimpleSemanticModel("NameCompartment"));

        // creates a StereotypeCompartment node
        GraphNode subNode = new GraphNode();
        subNode.setSemanticModel(createSimpleSemanticModel("StereotypeCompartment"));
        node.addContained(subNode);
        subNode.setContainer(node);

        // creates a NameAndType node
        subNode = new GraphNode();
        subNode.setSemanticModel(createSimpleSemanticModel("NameAndType"));
        node.addContained(subNode);
        subNode.setContainer(node);

        // creates a Name node
        GraphNode nameNode = new GraphNode();
        nameNode.setSemanticModel(createSimpleSemanticModel("Name"));
        subNode.addContained(nameNode);
        nameNode.setContainer(subNode);

        root.addContained(node);
        node.setContainer(root);

        return root;
    }

    /**
     * <p>
     * This method creates a SimpleSemanticModelElement instance with the given type information.
     * </p>
     *
     * @param typeInfo the type information
     * @return a SimpleSemanticModelElement instance with the given type information.
     */
    public static SimpleSemanticModelElement createSimpleSemanticModel(String typeInfo) {
        SimpleSemanticModelElement semanticModel;
        semanticModel = new SimpleSemanticModelElement();
        semanticModel.setTypeinfo(typeInfo);
        return semanticModel;
    }

    /**
     * <p>
     * This method creates a Uml1SemanticModelBridge instance with the given uml element.
     * </p>
     *
     * @param element a uml element to be associagted
     *
     * @return a SimpleSemanticModelElement instance with the given uml element.
     */
    public static Uml1SemanticModelBridge createUmlSemanticModel(Element element) {
        Uml1SemanticModelBridge bridge = new Uml1SemanticModelBridge();
        bridge.setElement(element);
        return bridge;
    }

}
