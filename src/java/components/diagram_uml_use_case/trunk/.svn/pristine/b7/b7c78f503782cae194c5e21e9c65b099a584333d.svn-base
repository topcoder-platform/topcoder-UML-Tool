/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * TCS Diagram_UML_Use_Case Elements Version 1.0 StressTest.
 *
 * @ SubsystemNodeContainerStressTest.java
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.stresstests;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Property;

import com.topcoder.gui.diagramviewer.elements.SelectionCorner;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.SubsystemNodeContainer;

import com.topcoder.uml.model.core.Element;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.awt.Color;

import java.util.Map;

import javax.swing.TransferHandler;


/**
 * <p>
 * This class tests the <code>SubsystemNodeContainer</code> class for stress. This stress
 * tests addresses the functionality provided by the <code>SubsystemNodeContainer</code> class.</p>
 *
 * @author zmg
 * @version 1.0
 */
public class SubsystemNodeContainerStressTest extends TestCase {
    /**
     * <p>The int number represents the loop times for stress test.</p>
     */
    private static final int LOOPTIMES = 100;

    /**
     * <p>The default radius of <code>SelectionCorner</code> instance used for test.</p>
     */
    private static int radius = SelectionCorner.DEFAULT_RADIUS;

    /**
     * <p>The <code>GraphNode</code> instance used for test.</p>
     */
    private GraphNode graphNode = null;

    /**
     * <p>
     * The <code>Property</code> instance of font size used for test.
     * </p>
     */
    private Property fontSizeProperty = null;

    /**
     * <p>
     * The <code>Property</code> instance of font color used for test.
     * </p>
     */
    private Property fontColorProperty = null;

    /**
     * <p>
     * The <code>Property</code> instance of fill color used for test.
     * </p>
     */
    private Property fillColorProperty = null;

    /**
     * <p>
     * The <code>Property</code> instance of stroke colorused for test.
     * </p>
     */
    private Property strokeColorProperty = null;

    /**
     * <p>
     * The <code>Property</code> instance of font family used for test.
     * </p>
     */
    private Property fontFamilyProperty = null;

    /**
     * <p>The <code>Map</code> instance used for test.</p>
     */
    private Map<String, String> properties = null;

    /**
     * <p>The <code>GraphNode</code> instance used for test.</p>
     */
    private GraphNode nameNode = null;

    /**
     * <p>The <code>GraphNode</code> instance used for test.</p>
     */
    private GraphNode stereotypeNode = null;

    /**
     * <p>The <code>GraphNode</code> instance used for test.</p>
     */
    private GraphNode namespaceNode = null;

    /**
     * <p>The instance of <code>SubsystemNodeContainer</code> for test.</p>
     */
    private SubsystemNodeContainer container = null;

    /**
     * <p>Return test suite of <code>SubsystemNodeContainerStressTest</code>.</p>
     *
     * @return Test suite of <code>SubsystemNodeContainerStressTest</code>.
     */
    public static Test suite() {
        return new TestSuite(SubsystemNodeContainerStressTest.class);
    }

    /**
     * <p>
     * Set up the stress testing environment.
     * </p>
     */
    protected void setUp() {
        // create the properties map of BaseNode.
        properties = StressTestHelper.getProperties();

        // set the properties of graphNode here.
        graphNode = new GraphNode();

        // add fontColor.
        strokeColorProperty = StressTestHelper.createProperty("stroke_color",
                "0000FF");
        graphNode.addProperty(strokeColorProperty);

        // add fontColor.
        fontColorProperty = StressTestHelper.createProperty("font_color",
                "FF0000");
        graphNode.addProperty(fontColorProperty);

        // add fillColor.
        fillColorProperty = StressTestHelper.createProperty("fill_color",
                "00FF00");
        graphNode.addProperty(fillColorProperty);

        // add fontFamily
        fontFamilyProperty = StressTestHelper.createProperty("font_family",
                "Arial Black");
        graphNode.addProperty(fontFamilyProperty);

        // add fontSize.
        fontSizeProperty = StressTestHelper.createProperty("font_size", "9");
        graphNode.addProperty(fontSizeProperty);

        // create the structure of the Subsystem here.
        nameNode = new GraphNode();
        stereotypeNode = new GraphNode();
        namespaceNode = new GraphNode();

        // set the initializing size and position.
        nameNode.setPosition(StressTestHelper.createPoint(0, 0));
        nameNode.setSize(StressTestHelper.createDimension(10, 10));
        stereotypeNode.setPosition(StressTestHelper.createPoint(0, 0));
        stereotypeNode.setSize(StressTestHelper.createDimension(10, 10));
        namespaceNode.setPosition(StressTestHelper.createPoint(0, 0));
        namespaceNode.setSize(StressTestHelper.createDimension(10, 10));

        // create the NameCompartment here.
        GraphNode nameCompartment = new GraphNode();

        nameCompartment.addContained(stereotypeNode);
        nameCompartment.addContained(nameNode);
        nameCompartment.addContained(namespaceNode);

        // create the BodyCompartment here.
        GraphNode bodyCompartment = new GraphNode();

        graphNode.addContained(nameCompartment);
        graphNode.addContained(bodyCompartment);

        // set the position and size of graphNode.
        graphNode.setSize(StressTestHelper.createDimension(400, 300));
        graphNode.setPosition(StressTestHelper.createPoint(100, 200));

        //
        Element element = StressTestHelper.getElement(1);
        graphNode.setSemanticModel(StressTestHelper.getBridge(element));
    }

    /**
     * <p>Basic stress test of <code>SubsystemNodeContainer</code>'s constructor.</p>
     *
     * @throws Exception if if any exception occurs when testing.
     */
    public void testSubsystemNodeContainerCtor_Times()
        throws Exception {
        GraphNode dv = new GraphNode();
        graphNode.setContainer(dv);
        dv.setPosition(StressTestHelper.createPoint(0, 0));

        for (int i = 0; i < LOOPTIMES; i++) {
            int width = 400 + i;
            int height = 300 + i;
            graphNode.setSize(StressTestHelper.createDimension(width, height));
            container = new SubsystemNodeContainer(graphNode, properties,
                    new TransferHandler(null));

            // check the result here.
            assertNotNull("The SubsystemNodeContainer constructor is incorrect.",
                container);
            assertEquals("The SubsystemNodeContainer constructor is incorrect.",
                nameNode, container.getNameCompartment().getGraphNode());
            assertEquals("The SubsystemNodeContainer constructor is incorrect.",
                stereotypeNode,
                container.getStereotypeCompartment().getGraphNode());
            assertEquals("The SubsystemNodeContainer constructor is incorrect.",
                namespaceNode,
                container.getNamespaceCompartment().getGraphNode());

            // check the color and font here.
            assertEquals("The SubsystemNodeContainer constructor is incorrect.",
                Color.GREEN, container.getFillColor());
            assertEquals("The SubsystemNodeContainer constructor is incorrect.",
                Color.BLUE, container.getStrokeColor());
            assertEquals("The SubsystemNodeContainer constructor is incorrect.",
                Color.RED, container.getFontColor());

            assertEquals("The SubsystemNodeContainer constructor is incorrect.",
                "Arial Black", container.getFont().getFamily());
            assertEquals("The SubsystemNodeContainer constructor is incorrect.",
                9, container.getFont().getSize());

            //remove all the properties, so the default value will be used
            graphNode.removeProperty(strokeColorProperty);
            graphNode.removeProperty(fontColorProperty);
            graphNode.removeProperty(fillColorProperty);
            graphNode.removeProperty(fontFamilyProperty);
            graphNode.removeProperty(fontSizeProperty);

            container.notifyPropertiesChange();

            // check the color and font here.
            assertEquals("The SubsystemNodeContainer constructor is incorrect, the defaut value should be used here.",
                Color.WHITE, container.getFillColor());
            assertEquals("The SubsystemNodeContainer constructor is incorrect, the defaut value should be used here.",
                Color.BLACK, container.getStrokeColor());
            assertEquals("The SubsystemNodeContainer constructor is incorrect, the defaut value should be used here.",
                Color.BLACK, container.getFontColor());

            assertEquals("The SubsystemNodeContainer constructor is incorrect, the defaut value should be used here.",
                "Arial", container.getFont().getFamily());
            assertEquals("The SubsystemNodeContainer constructor is incorrect, the defaut value should be used here.",
                10, container.getFont().getSize());

            // add all the properties for the next test.
            graphNode.addProperty(strokeColorProperty);
            graphNode.addProperty(fontColorProperty);
            graphNode.addProperty(fillColorProperty);
            graphNode.addProperty(fontFamilyProperty);
            graphNode.addProperty(fontSizeProperty);

            // check the location and size here.
            assertEquals("The SubsystemNodeContainer constructor is incorrect.",
                width + (2 * radius), (int) container.getSize().getWidth());
            assertEquals("The SubsystemNodeContainer constructor is incorrect.",
                height + (2 * radius), (int) container.getSize().getHeight());
            assertEquals("The SubsystemNodeContainer constructor is incorrect.",
                100 - radius, (int) container.getLocation().getX());
            assertEquals("The SubsystemNodeContainer constructor is incorrect.",
                200 - radius, (int) container.getLocation().getY());
            assertEquals("The SubsystemNodeContainer constructor is incorrect.",
                radius, (int) container.getRelativePosition().getX());
            assertEquals("The SubsystemNodeContainer constructor is incorrect.",
                radius, (int) container.getRelativePosition().getY());
            assertEquals("The SubsystemNodeContainer constructor is incorrect.",
                radius, (int) container.getSelectionBound().getX());
            assertEquals("The SubsystemNodeContainer constructor is incorrect.",
                radius, (int) container.getSelectionBound().getY());
            assertEquals("The SubsystemNodeContainer constructor is incorrect.",
                width, (int) container.getSelectionBound().getWidth());
            assertEquals("The SubsystemNodeContainer constructor is incorrect.",
                height, (int) container.getSelectionBound().getHeight());

            // check the compartment text here.
            assertEquals("The SubsystemNodeContainer constructor is incorrect.",
                "topcoderSoft", container.getNameCompartment().getText());
            assertEquals("The SubsystemNodeContainer constructor is incorrect.",
                "<<type1, type2>>",
                container.getStereotypeCompartment().getText());
            assertEquals("The SubsystemNodeContainer constructor is incorrect.",
                "com.topcoder.soft",
                container.getNamespaceCompartment().getText());
        }
    }

    /**
     * <p>
     * Basic stress test of <code>notifyPropertiesChange()</code> method.
     * </p>
     *
     * @throws Exception if if any exception occurs when testing.
     */
    public void testSubsystemNodeContainer_notifyPropertiesChange_ColorAndFont()
        throws Exception {
        // change the node's properties and test it.
        for (int i = 0; i < LOOPTIMES; i++) {
            //  create a node container here.
            container = new SubsystemNodeContainer(graphNode, properties,
                    new TransferHandler(null));
            graphNode.removeProperty(fontSizeProperty);
            fontSizeProperty = StressTestHelper.createProperty("font_size",
                    "" + (i + 1));
            graphNode.addProperty(fontSizeProperty);

            graphNode.removeProperty(strokeColorProperty);
            strokeColorProperty = StressTestHelper.createProperty("stroke_color",
                    "FF0000");
            graphNode.addProperty(strokeColorProperty);

            graphNode.removeProperty(fillColorProperty);
            fillColorProperty = StressTestHelper.createProperty("fill_color",
                    "00FF00");
            graphNode.addProperty(fillColorProperty);

            graphNode.removeProperty(fontFamilyProperty);
            fontFamilyProperty = StressTestHelper.createProperty("font_family",
                    "Times New Roman");
            graphNode.addProperty(fontFamilyProperty);

            container.notifyPropertiesChange();

            // check the result here.
            assertEquals("The BaseNode constructor is incorrect.", Color.RED,
                container.getStrokeColor());
            assertEquals("The BaseNode constructor is incorrect.", Color.GREEN,
                container.getFillColor());
            assertEquals("The BaseNode constructor is incorrect.",
                "Times New Roman", container.getFont().getFamily());
            assertEquals("The BaseNode constructor is incorrect.", i + 1,
                container.getFont().getSize());
            assertEquals("The BaseNode constructor is incorrect.", Color.RED,
                container.getFontColor());
        }
    }

    /**
     * <p>
     * Basic stress test of <code>notifyGraphNodeChange()</code> method.
     * </p>
     *
     * @throws Exception if if any exception occurs when testing.
     */
    public void testSubsystemNodeContainer_notifyGraphNodeChange_AbsolutePosition()
        throws Exception {
        GraphNode dv = new GraphNode();
        dv.setPosition(StressTestHelper.createPoint(0, 0));
        GraphNode containNode = StressTestHelper.getGraphNode(1);
        containNode.setSize(StressTestHelper.createDimension(400, 800));
        containNode.setPosition(StressTestHelper.createPoint(100, 200));
        containNode.setContainer(dv);
        graphNode.setContainer(containNode);

        containNode.addContained(graphNode);

        // create a node container here.
        container = new SubsystemNodeContainer(graphNode, properties,
                new TransferHandler(null));

        // change the node and test it.
        for (int i = 0; i < LOOPTIMES; i++) {
            int width = 400 + i;
            int height = 300 + i;
            graphNode.setSize(StressTestHelper.createDimension(width, height));

            int x = 10 + i;
            int y = 20 + i;
            graphNode.setPosition(StressTestHelper.createPoint(x, y));

            // notify the container change here.
            container.notifyGraphNodeChange("node changed.");

            // get the location to test.
            assertEquals("The notifyGraphNodeChange method is incorrect.",
                105 + i, container.getLocation().x);
            assertEquals("The notifyGraphNodeChange method is incorrect.",
                215 + i, container.getLocation().y);

            // get the size to test.
            assertEquals("Equal size expected.", 310.0 + i,
                container.getSize().getHeight());
            assertEquals("Equal size expected.", 410.0 + i,
                container.getSize().getWidth());

            // get the relative position to test.
            assertEquals("Equal relative position expected.", 5.0,
                container.getRelativePosition().getX());
            assertEquals("Equal relative position expected.", 5.0,
                container.getRelativePosition().getY());

            // get the bound to test.
            assertEquals("Equal bound expected.", 5,
                container.getSelectionBound().x);
            assertEquals("Equal bound expected.", 5,
                container.getSelectionBound().y);
            assertEquals("Equal bound expected.", 300 + i,
                container.getSelectionBound().height);
            assertEquals("Equal bound expected.", 400 + i,
                container.getSelectionBound().width);
        }
    }

    /**
     * <p>
     * Basic stress test of <code>notifyGraphNodeChange()</code> method.
     * </p>
     *
     * @throws Exception if if any exception occurs when testing.
     */
    public void testSubsystemNodeContainer_notifyGraphNodeChange_Text()
        throws Exception {
        for (int i = 0; i < LOOPTIMES; i++) {
            int width = 50 + i;
            int height = 30 + i;
            graphNode.setSize(StressTestHelper.createDimension(width, height));
            // create a node container here.
            container = new SubsystemNodeContainer(graphNode, properties,
                    new TransferHandler(null));

            //  notify the container change here.
            container.notifyGraphNodeChange("container changed.");

            // check the result here.
            assertEquals("The SubsystemNodeContainer constructor is incorrect.",
                "topcoderSoft", container.getNameCompartment().getText());
            assertEquals("The SubsystemNodeContainer constructor is incorrect.",
                "<<type1, type2>>",
                container.getStereotypeCompartment().getText());
            assertEquals("The SubsystemNodeContainer constructor is incorrect.",
                "com.topcoder.soft",
                container.getNamespaceCompartment().getText());
        }
    }
}
