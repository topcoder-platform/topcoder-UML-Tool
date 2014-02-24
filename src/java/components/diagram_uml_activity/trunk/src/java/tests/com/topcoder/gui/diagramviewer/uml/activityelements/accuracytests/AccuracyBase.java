/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements.accuracytests;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Property;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.model.activitygraphs.ActionStateImpl;
import com.topcoder.uml.model.activitygraphs.ObjectFlowStateImpl;
import com.topcoder.uml.model.core.ClassifierAbstractImpl;
import com.topcoder.uml.model.core.Element;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinitionImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;
import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.statemachines.FinalStateImpl;
import com.topcoder.uml.model.statemachines.Guard;
import com.topcoder.uml.model.statemachines.GuardImpl;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.PseudostateImpl;
import com.topcoder.uml.model.statemachines.SimpleStateImpl;
import com.topcoder.uml.model.statemachines.TransitionImpl;

/**
 * A base class (helper) for accuracy tests.
 * 
 * @author kinfkong
 * @version 1.0
 */
public class AccuracyBase extends TestCase {

    /**
     * Creates a valid graph node.
     * 
     * @param nodeType the node type
     * @param position the position
     * @param size the size
     * @param gradientColor the gradient color
     * @return the graph node
     */
    public static GraphNode createGraphNode(String nodeType, Point position, Dimension size, String gradientColor) {

        if (nodeType.equals("ObjectFlowNode") || nodeType.equals("SendSignalAction") || nodeType.equals("AcceptEventAction")
                        || nodeType.equals("ActionState")) {

            return createValidActionGraphNode(nodeType, position, size, gradientColor);
        } else {

            return createValidNodeGraphNode(nodeType, position, size, gradientColor);
        }
    }

    /**
     * Creates valid node graph node.
     * 
     * @param nodeType the node type
     * @param position the position
     * @param size the size
     * @param gradientColor the gradient color
     * 
     * @return the graph node
     */
    private static GraphNode createValidNodeGraphNode(String nodeType, Point position, Dimension size,
                    String gradientColor) {

        GraphNode node = new GraphNode();

        com.topcoder.diagraminterchange.Dimension sizeTC = new com.topcoder.diagraminterchange.Dimension();
        sizeTC.setHeight(size.height);
        sizeTC.setWidth(size.width);

        com.topcoder.diagraminterchange.Point positionTC = new com.topcoder.diagraminterchange.Point();
        positionTC.setX(position.x);
        positionTC.setY(position.y);

        // set size and position
        node.setSize(sizeTC);
        node.setPosition(positionTC);

        String fillColor = "FFFFFF";
        String imageFile = "";

        ModelElement state = null;

        if (nodeType.equals("InitialNode")) {

            imageFile = "test_files/InitialNode.gif";

            state = new PseudostateImpl();
            ((Pseudostate) state).setKind(PseudostateKind.INITIAL);
        }
        if (nodeType.equals("ForkNode")) {

            fillColor = "999999";

            state = new PseudostateImpl();
            ((Pseudostate) state).setKind(PseudostateKind.FORK);
        }
        if (nodeType.equals("JoinNode")) {

            fillColor = "999999";

            state = new PseudostateImpl();
            ((Pseudostate) state).setKind(PseudostateKind.JOIN);
        }
        if (nodeType.equals("DecisionNode")) {

            imageFile = "test_files/MergeNode.gif";
            fillColor = "00FF00";

            state = new PseudostateImpl();
            ((Pseudostate) state).setKind(PseudostateKind.CHOICE);
        }
        if (nodeType.equals("MergeNode")) {

            imageFile = "test_files/MergeNode.gif";
            fillColor = "00FF00";

            state = new PseudostateImpl();
            ((Pseudostate) state).setKind(PseudostateKind.JUNCTION);
        }
        if (nodeType.equals("FlowFinalNode")) {

            fillColor = "FFFFFF";

            state = new FinalStateImpl();
            createTagDefinition(state, "FinalNodeType", "FlowFinalNode");
        }
        if (nodeType.equals("FinalNode")) {

            imageFile = "test_files/InitialNode.gif";
            fillColor = "FFFFFF";

            state = new FinalStateImpl();
        }

        // set nameCompartment text
        state.setName("NameCompartment");

        // set stereotypeCompartment text
        Stereotype stereotypeOne = new StereotypeImpl();
        stereotypeOne.setName("StereotypeCompartment");

        state.addStereotype(stereotypeOne);

        Uml1SemanticModelBridge pseudostate = new Uml1SemanticModelBridge();
        pseudostate.setElement(state);
        node.setSemanticModel(pseudostate);

        // create valid stereotpe compartment
        GraphElement stereotypeCompartment = createValidStereotypeCompartment();

        // create SimpleSemanticmodelElement.typeinfo = "Name"
        GraphElement name = new GraphNode();
        setTypeInfo(name, "Name");

        // build correct structure
        ((GraphNode) stereotypeCompartment).setSize(sizeTC);
        node.addContained(0, stereotypeCompartment);
        ((GraphNode) name).setSize(sizeTC);
        node.addContained(1, name);

        // create properties
        node.addProperty(createProperty("STROKE_COLOR", "000000"));
        node.addProperty(createProperty("FILL_COLOR", fillColor));
        node.addProperty(createProperty("FONT_COLOR", "000000"));
        node.addProperty(createProperty("GRADIENT_COLOR", gradientColor));
        node.addProperty(createProperty("SHADOW_COLOR", "999999"));
        node.addProperty(createProperty("IMAGE_FILE", imageFile));
        node.addProperty(createProperty("FONT_FAMILY", "Arial"));
        node.addProperty(createProperty("FONT_STYLE", Integer.toString(Font.PLAIN)));
        node.addProperty(createProperty("FONT_SIZE", "10"));

        return node;
    }

    /**
     * Creates valid action graph node.
     * 
     * @param nodeType the node type
     * @param position the position
     * @param size the size
     * @param gradientColor the gradient color
     * 
     * @return the graph node representing the action
     */
    private static GraphNode createValidActionGraphNode(String nodeType, Point position, Dimension size,
                    String gradientColor) {

        GraphNode node = new GraphNode();

        com.topcoder.diagraminterchange.Dimension sizeTC = new com.topcoder.diagraminterchange.Dimension();
        sizeTC.setHeight(size.height);
        sizeTC.setWidth(size.width);

        com.topcoder.diagraminterchange.Point positionTC = new com.topcoder.diagraminterchange.Point();
        positionTC.setX(position.x);
        positionTC.setY(position.y);

        // set size and position
        node.setSize(sizeTC);
        node.setPosition(positionTC);
        
        // node.addContained(subNode);
        
        ModelElement state = null;

        if (nodeType.equals("ObjectFlowNode")) {
            state = new ObjectFlowStateImpl();
        }
        if (nodeType.equals("SendSignalAction")) {
            state = new SimpleStateImpl();
            createTagDefinition(state, "SendSignalAction", "True");
        }
        if (nodeType.equals("AcceptEventAction")) {
            state = new SimpleStateImpl();
            createTagDefinition(state, "AcceptEventAction", "True");
        }
        if (nodeType.equals("ActionState")) {
            state = new ActionStateImpl();
        }

        // set nameCompartment text
        state.setName("NameCompartment");

        // set stereotypeCompartment text
        Stereotype stereotypeOne = new StereotypeImpl();
        stereotypeOne.setName("StereotypeCompartment");

        state.addStereotype(stereotypeOne);

        // Uml1SemanticModelBridge.element = <UML:ObjectFlowState>
        Uml1SemanticModelBridge elementObjectFlowState = new Uml1SemanticModelBridge();
        elementObjectFlowState.setElement(state);
        node.setSemanticModel(elementObjectFlowState);

        // create SimpleSemanticmodelElement.typeinfo = "Name"
        GraphElement name = new GraphNode();
        setTypeInfo(name, "Name");

        // create Uml1SemanticModelBridge.element = <UML:Class>
        GraphElement umlClass = new GraphNode();
        setElement(umlClass, new ClassifierImpl());

        umlClass.addContained(name);

        // create SimpleSemanticmodelElement.typeinfo = "TypeSeparator"
        GraphElement typeSeparator = new GraphNode();
        setTypeInfo(typeSeparator, "TypeSeparator");

        typeSeparator.addContained(umlClass);

        // create SimpleSemanticmodelElement.typeinfo = "NameAndType"
        GraphElement nameAndType = new GraphNode();
        setTypeInfo(nameAndType, "NameAndType");

        // for testing we use the name once created
        nameAndType.addContained(name);
        nameAndType.addContained(typeSeparator);

        // create SimpleSemanticmodelElement.typeinfo = "NameCompartment"
        GraphElement nameCompartment = new GraphNode();
        setTypeInfo(nameCompartment, "NameCompartment");

        nameCompartment.addContained(nameAndType);
        
        // build correct structure
        node.addContained(0, nameCompartment);

        ((GraphNode) nameCompartment).setSize(sizeTC);
        
        // create properties
        node.addProperty(createProperty("STROKE_COLOR", "000000"));
        node.addProperty(createProperty("FILL_COLOR", "FFFFFF"));
        node.addProperty(createProperty("FONT_COLOR", "000000"));
        node.addProperty(createProperty("GRADIENT_COLOR", gradientColor));
        node.addProperty(createProperty("SHADOW_COLOR", "999999"));
        node.addProperty(createProperty("FONT_FAMILY", "Arial"));
        node.addProperty(createProperty("FONT_STYLE", Integer.toString(Font.PLAIN)));
        node.addProperty(createProperty("FONT_SIZE", "10"));

        return node;
    }

    /**
     * Creates a valid graph edge.
     * 
     * @param position the position
     * @return the graph edge
     */
    public static GraphEdge createValidGraphEdge(Point position) {

        GraphEdge edge = new GraphEdge();

        com.topcoder.diagraminterchange.Point positionTC = new com.topcoder.diagraminterchange.Point();
        positionTC.setX(position.x);
        positionTC.setY(position.y);

        edge.setPosition(positionTC);

        ModelElement element = new TransitionImpl();

        element.setName("TransitionNameCompartment");

        Stereotype stereotypeOne = new StereotypeImpl();
        stereotypeOne.setName("TransitionStereotypeCompartment");

        element.addStereotype(stereotypeOne);

        Uml1SemanticModelBridge umlTransition = new Uml1SemanticModelBridge();
        umlTransition.setElement(element);

        edge.setSemanticModel(umlTransition);

        GraphElement name = new GraphNode();
        setTypeInfo(name, "Name");

        GraphElement transitionDescription = new GraphNode();
        setTypeInfo(transitionDescription, "TransitionDescription");

        GraphElement guardStart = new GraphNode();
        setTypeInfo(guardStart, "GuardStart");

        Guard guardImpl = new GuardImpl();
        guardImpl.setName("TransitionDescriptionCompartment");

        GraphElement guard = new GraphNode();
        Uml1SemanticModelBridge umlGuard = new Uml1SemanticModelBridge();
        umlGuard.setElement(guardImpl);
        guard.setSemanticModel(umlGuard);

        guard.addContained(0, name);

        GraphElement guardEnd = new GraphNode();
        setTypeInfo(guardEnd, "GuardEnd");

        transitionDescription.addContained(0, guardStart);
        transitionDescription.addContained(1, guard);
        transitionDescription.addContained(2, guardEnd);

        GraphElement stereotypeCompartment = createValidStereotypeCompartment();

        edge.addContained(0, name);
        edge.addContained(1, transitionDescription);
        edge.addContained(2, stereotypeCompartment);

        return edge;
    }

    /**
     * Creates a valid stereotype compartment.
     * 
     * @return the graph element represents the stereotype
     */
    private static GraphElement createValidStereotypeCompartment() {

        GraphNode node = new GraphNode();

        setTypeInfo(node, "StereotypeCompartment");

        GraphElement stereotypeStart = new GraphNode();
        setTypeInfo(stereotypeStart, "StereotypeStart");

        GraphElement name = new GraphNode();
        setTypeInfo(name, "Name");

        GraphElement umlStereotype = new GraphNode();
        setElement(umlStereotype, new StereotypeImpl());

        umlStereotype.addContained(0, name);

        GraphElement stereotypeSeparator = new GraphNode();
        setTypeInfo(stereotypeSeparator, "StereotypeSeparator");

        GraphElement stereotypeEnd = new GraphNode();
        setTypeInfo(stereotypeEnd, "StereotypeEnd");

        node.addContained(0, stereotypeStart);
        node.addContained(1, umlStereotype);
        node.addContained(2, stereotypeSeparator);
        node.addContained(3, umlStereotype);
        node.addContained(4, stereotypeEnd);

        return node;
    }


    /**
     * Sets the type info.
     * 
     * @param graphElement the graph element
     * 
     * @param typeInfo the type info
     */
    private static void setTypeInfo(GraphElement graphElement, String typeInfo) {

        SimpleSemanticModelElement simpleElement = new SimpleSemanticModelElement();
        simpleElement.setTypeInfo(typeInfo);
        graphElement.setSemanticModel(simpleElement);
    }

    /**
     * Sets the element.
     * 
     * @param graphElement the graph element
     * 
     * @param element the element
     */
    private static void setElement(GraphElement graphElement, Element element) {

        Uml1SemanticModelBridge uml1ModelBridge = new Uml1SemanticModelBridge();
        uml1ModelBridge.setElement(element);
        graphElement.setSemanticModel(uml1ModelBridge);
    }

    /**
     * Creates the properties.
     * 
     * 
     * @return the properties map
     */
    public static Map<String, String> createProperties() {

        Map<String, String> properties = new HashMap<String, String>();

        properties.put(TestHelper.COLOR3, "FILL_COLOR");
        properties.put(TestHelper.COLOR1, "STROKE_COLOR");
        properties.put(TestHelper.COLOR5, "FONT_COLOR");
        properties.put(TestHelper.COLOR9, "SHADOW_COLOR");
        properties.put(TestHelper.COLOR7, "GRADIENT_COLOR");
        properties.put(TestHelper.IMAGE_FILE, "IMAGE_FILE");
        properties.put(TestHelper.FONT_FAMILY, "FONT_FAMILY");
        properties.put(TestHelper.FONT_STYLE, "FONT_STYLE");
        properties.put(TestHelper.FONT_SIZE, "FONT_SIZE");

        return properties;
    }

    /**
     * Creates the Property.
     * 
     * @param key the key
     * @param value the value
     * @return the property
     */
    public static Property createProperty(String key, String value) {

        Property property = new Property();
        property.setKey(key);
        property.setValue(value);

        return property;
    }

    /**
     * Adds the stereotype.
     * 
     * @param graphElement the graph element
     * @param text the text
     */
    public static void addStereotype(GraphElement graphElement, String text) {

        ModelElement element = ((ModelElement) ((Uml1SemanticModelBridge) graphElement.getSemanticModel())
                        .getElement());

        Stereotype stereotype = new StereotypeImpl();
        stereotype.setName(text);

        element.addStereotype(stereotype);

    }

    /**
     * Changes the name.
     * 
     * @param graphElement the graph element
     * @param text the text
     * 
     * @return the model elment
     */
    public static ModelElement changeName(GraphElement graphElement, String text) {

        ModelElement element = new ObjectFlowStateImpl();
        element.setName(text);

        return element;
    }

    /**
     * Creates the tag definition.
     * 
     * @param element the element
     * @param tagType the tag type
     * @param dataValue the data value
     */
    private static void createTagDefinition(ModelElement element, String tagType, String dataValue) {

        TaggedValue taggedValue = new TaggedValueImpl();
        taggedValue.setDataValue(dataValue);

        TagDefinition tagDefinition = new TagDefinitionImpl();
        tagDefinition.setTagType(tagType);

        taggedValue.setType(tagDefinition);

        element.addTaggedValue(taggedValue);
    }
}

/**
 * A mock implementation of classifier for accuracy tests.
 * 
 * @author kinfkong
 * @version 1.0
 * 
 */
class ClassifierImpl extends ClassifierAbstractImpl {

}