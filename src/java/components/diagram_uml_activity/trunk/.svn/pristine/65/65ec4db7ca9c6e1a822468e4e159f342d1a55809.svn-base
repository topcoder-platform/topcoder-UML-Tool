/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.activityelements.stresstests;

import java.awt.Font;
import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.Property;
import com.topcoder.diagraminterchange.SimpleSemanticModelElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.diagramviewer.uml.activityelements.DecisionNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.FinalNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.FlowFinalNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.ForkNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.InitialNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.JoinNode;
import com.topcoder.gui.diagramviewer.uml.activityelements.MergeNode;
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
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.PseudostateImpl;

/**
 * <p>
 * Stress tests for the all nodes.
 * </p>
 *
 * @author slion
 * @version 1.0
  */
public class StressTestsAll extends TestCase {
    /**
     * Represents the times of the loop.
     */
    private static final int TIMES_OF_LOOP = 10;

    /**
     * Represents the dimension of the node.
     */
    private static final Dimension DIMENSION = new Dimension();

    /**
     * Represents the position of the node.
     */
    private static final Point POSITION = new Point();
    
    /**
     * Represents the bound of the graph node.
     */
    private static final Rectangle bound = new Rectangle(0, 0, 10, 10);
    
    /**
     * Represents the properties of the graph node.
     */
    private Map<String, String> properties;
    
    /**
     * Represents the position of the corresponding node.
     */
    private java.awt.Point position = new java.awt.Point(10, 10);

    /**
     * Setup the test environment.
     *
     * @throws Exception to JUnit.
     */
    protected void setUp() throws Exception {
        properties = createProperties();
    }

    /**
     * Teardown the test environment.
     *
     * @throws Exception to JUnit.
     */
    protected void tearDown() throws Exception {
        properties = null;
        position = null;
    }

    /**
     * <p>
     * Tests the InitialNode class.
     * </p>
     */
    public void testInitialNode() {
        long time = System.currentTimeMillis();
        for (int i = 0; i < TIMES_OF_LOOP; i++) {
            new InitialNode(createGraphNode("InitialNode", POSITION, DIMENSION),
                    properties, position, bound);
        }
        System.out.println("Constructing InitialNode took " +
                (System.currentTimeMillis() - time) + "ms.");
    }

    /**
     * <p>
     * Tests the ForkNode class.
     * </p>
     */
    public void testForkNode() {
        long time = System.currentTimeMillis();
        for (int i = 0; i < TIMES_OF_LOOP; i++) {
            new ForkNode(createGraphNode("ForkNode", POSITION, DIMENSION),
                    properties, position, bound);
        }
        System.out.println("Constructing ForkNode took " +
                (System.currentTimeMillis() - time) + "ms.");
    }

    /**
     * <p>
     * Tests the JoinNode class.
     * </p>
     */
    public void testJoinNode() {
        long time = System.currentTimeMillis();
        for (int i = 0; i < TIMES_OF_LOOP; i++) {
            new JoinNode(createGraphNode("JoinNode", POSITION, DIMENSION),
                    properties, position, bound);
        }
        System.out.println("Constructing JoinNode took " +
                (System.currentTimeMillis() - time) + "ms.");
    }

    /**
     * <p>
     * Tests the DecisionNode class.
     * </p>
     */
    public void testDecisionNode() {
        long time = System.currentTimeMillis();
        for (int i = 0; i < TIMES_OF_LOOP; i++) {
            new DecisionNode(createGraphNode("DecisionNode", POSITION, DIMENSION),
                    properties, position, bound);
        }
        System.out.println("Constructing DecisionNode took " +
                (System.currentTimeMillis() - time) + "ms.");
    }

    /**
     * <p>
     * Tests the MergeNode class.
     * </p>
     */
    public void testMergeNode() {
        long time = System.currentTimeMillis();
        for (int i = 0; i < TIMES_OF_LOOP; i++) {
            new MergeNode(createGraphNode("MergeNode", POSITION, DIMENSION),
                    properties, position, bound);
        }
        System.out.println("Constructing MergeNode took " +
                (System.currentTimeMillis() - time) + "ms.");
    }

    /**
     * <p>
     * Tests the FlowFinalNode class.
     * </p>
     */
    public void testFlowFinalNode() {
        long time = System.currentTimeMillis();
        for (int i = 0; i < TIMES_OF_LOOP; i++) {
            new FlowFinalNode(createGraphNode("FlowFinalNode", POSITION, DIMENSION),
                    properties, position, bound);
        }
        System.out.println("Constructing FlowFinalNode took " +
                (System.currentTimeMillis() - time) + "ms.");
    }

    /**
     * <p>
     * Tests the FinalNode class.
     * </p>
     */
    public void testFinalNode() {
        long time = System.currentTimeMillis();
        for (int i = 0; i < TIMES_OF_LOOP; i++) {
            new FinalNode(createGraphNode("FinalNode", POSITION, DIMENSION),
                    properties, position, bound);
        }
        System.out.println("Constructing FinalNode took " +
                (System.currentTimeMillis() - time) + "ms.");
    }
    
    /**
     * Creates the GraphNode according to the specified node type, position and dimension.
     * @param nodeType the type of the node.
     * @param position the position of the node.
     * @param size the size of the node.
     * @return the related node.
     */
    private GraphNode createGraphNode(String nodeType, Point position, Dimension size) {
        GraphNode node = new GraphNode();
        node.setPosition(position);
        node.setSize(size);
        ModelElement state = null;

        if (nodeType == "InitialNode") {
            state = new PseudostateImpl();
            ((Pseudostate) state).setKind(PseudostateKind.INITIAL);
        }
        if (nodeType == "ForkNode") {
            state = new PseudostateImpl();
            ((Pseudostate) state).setKind(PseudostateKind.FORK);
        }
        if (nodeType == "JoinNode") {
            state = new PseudostateImpl();
            ((Pseudostate) state).setKind(PseudostateKind.JOIN);
        }
        if (nodeType == "DecisionNode") {
            state = new PseudostateImpl();
            ((Pseudostate) state).setKind(PseudostateKind.CHOICE);
        }
        if (nodeType == "MergeNode") {
            state = new PseudostateImpl();
            ((Pseudostate) state).setKind(PseudostateKind.JUNCTION);
        }
        if (nodeType == "FlowFinalNode") {
            state = new FinalStateImpl();
            createTagDefinition(state, "FinalNodeType", "FlowFinalNode");
        }
        if (nodeType == "FinalNode") {
            state = new FinalStateImpl();
        }

        state.setName("NameCompartment");

        Stereotype stereotypeOne = new StereotypeImpl();
        stereotypeOne.setName("StereotypeCompartment");

        state.addStereotype(stereotypeOne);

        Uml1SemanticModelBridge pseudostate = new Uml1SemanticModelBridge();
        pseudostate.setElement(state);
        node.setSemanticModel(pseudostate);

        GraphNode stereotypeCompartment = createStereotypeCompartment();
        stereotypeCompartment.setSize(size);
        GraphNode name = new GraphNode();
        setTypeInfo(name, "Name");
        name.setSize(size);
        node.addContained(0, stereotypeCompartment);
        node.addContained(1, name);

        // add some properties
        node.addProperty(getProperty("StrokeColor", "#000000"));
        node.addProperty(getProperty("FontColor", "#000000"));
        node.addProperty(getProperty("FontFamily", "Arial"));
        node.addProperty(getProperty("FontStyle", Integer.toString(Font.PLAIN)));
        node.addProperty(getProperty("FontSize", "10"));

        return node;
    }

    /**
     * Get the corresponding Property with given parameters.
     * @param key the key
     * @param value the value
     * @return the Property.
     */
    private Property getProperty(String key, String value) {
        Property property = new Property();
        property.setKey(key);
        property.setValue(value);
        return property;
    }

    /**
     * Creates the tag definition.
     * @param element the element.
     * @param tagType the tag type.
     * @param dataValue the data value.
     */
    private static void createTagDefinition(ModelElement element, String tagType, String dataValue) {
        TaggedValue taggedValue = new TaggedValueImpl();
        taggedValue.setDataValue(dataValue);

        TagDefinition tagDefinition = new TagDefinitionImpl();
        tagDefinition.setTagType(tagType);

        taggedValue.setType(tagDefinition);

        element.addTaggedValue(taggedValue);
        
    }
    /**
     * <p>
     * Sets the element of the <code>graphElement</code> to <code>element</code>.
     * </p>
     * 
     * @param graphElement
     *            the <code>GraphElement</code> which element should be set.
     * @param element
     *            the element which should be set to the <code>graphElement</code>.
     */
    private static void setElement(GraphElement graphElement, Element element) {

        Uml1SemanticModelBridge uml1ModelBridge = new Uml1SemanticModelBridge();
        uml1ModelBridge.setElement(element);
        graphElement.setSemanticModel(uml1ModelBridge);
    }

    /**
     * <p>
     * Sets the typeInfo of the <code>graphElement</code> to <code>typeInfo</code>.
     * </p>
     * 
     * @param graphElement
     *            the <code>GraphElement</code> which typeInfo should be set.
     * @param typeInfo
     *            the typeInfo which should be set to the <code>graphElement</code>.
     */
    private static void setTypeInfo(GraphElement graphElement, String typeInfo) {

        SimpleSemanticModelElement simpleElement = new SimpleSemanticModelElement();
        simpleElement.setTypeInfo(typeInfo);
        graphElement.setSemanticModel(simpleElement);
    }

    /**
     * Creates the valid stereotype.
     * @return the created stereotype.
     */
    private GraphNode createStereotypeCompartment() {
        GraphNode node = new GraphNode();

        // create SimpleSemanticmodelElement.typeinfo = "StereotypeCompartment"
        setTypeInfo(node, "StereotypeCompartment");

        // create SimpleSemanticModelElement.typeInfo = "StereotypeStart"
        GraphElement stereotypeStart = new GraphNode();
        setTypeInfo(stereotypeStart, "StereotypeStart");

        // create SimpleSemanticModelElement.typeInfo = "Name"
        GraphElement name = new GraphNode();
        setTypeInfo(name, "Name");

        // create Uml1SemanticModelBridgeElement.element = <UML:Stereotype>
        GraphElement umlStereotype = new GraphNode();
        setElement(umlStereotype, new StereotypeImpl());

        umlStereotype.addContained(0, name);

        // create SimpleSemanticModelElement.typeInfo = "StereotypeSeparator"
        GraphElement stereotypeSeparator = new GraphNode();
        setTypeInfo(stereotypeSeparator, "StereotypeSeparator");

        // create SimpleSemanticModelElement.typeInfo = "StereotypeEnd"
        GraphElement stereotypeEnd = new GraphNode();
        setTypeInfo(stereotypeEnd, "StereotypeEnd");

        // build correct structure
        node.addContained(0, stereotypeStart);
        node.addContained(1, umlStereotype);
        node.addContained(2, stereotypeSeparator);
        node.addContained(3, umlStereotype);
        node.addContained(4, stereotypeEnd);

        return node;
    }

    /**
     * Creates the properties for graph node.
     * @return the created properties.
     */
    private Map<String, String> createProperties() {
        Map<String, String> properties = new HashMap<String, String>();
        properties.put("StrokeColor", "STROKE_COLOR");
        properties.put("FontColor", "FONT_COLOR");
        properties.put("FontFamily", "FONT_FAMILY");
        properties.put("FontStyle", "FONT_STYLE");
        properties.put("FontSize", "FONT_SIZE");
        return properties;
    }
}
