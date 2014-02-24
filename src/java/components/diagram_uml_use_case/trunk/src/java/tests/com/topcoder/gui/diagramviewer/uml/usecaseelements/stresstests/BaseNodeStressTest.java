/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * TCS Diagram_UML_Use_Case Elements Version 1.0 StressTest.
 *
 * @ BaseNodeStressTest.java
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.stresstests;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Property;

import com.topcoder.gui.diagramviewer.uml.usecaseelements.TextField;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.awt.Color;

import java.util.Map;


/**
 * <p>
 * This class tests the <code>BaseNode</code> class for stress. This stress tests addresses
 * the functionality provided by the <code>BaseNode</code> class.
 * </p>
 *
 * @author zmg
 * @version 1.0
 */
public class BaseNodeStressTest extends TestCase {
    /**
     * <p>The int number represents the loop times for stress test.</p>
     */
    private static final int LOOPTIMES = 100;

    /**
     * <p>The <code>GraphNode</code> instance used for test.</p>
     */
    private GraphNode graphNode = null;

    /**
     * <p>The <code>Map</code> instance used for test.</p>
     */
    private Map<String, String> properties = null;

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
     * <p>The <code>TextField</code> instance used for test.</p>
     */
    private TextField name = null;

    /**
     * <p>The <code>TextField</code> instance used for test.</p>
     */
    private TextField stereotype = null;

    /**
     * <p>The <code>TextField</code> instance used for test.</p>
     */
    private TextField namespace = null;

    /**
     * <p>The instance of <code>SimpleBaseNode</code> for test.</p>
     */
    private SimpleBaseNode node = null;

    /**
     * <p>Return test suite of <code>BaseNodeStressTest</code>.</p>
     *
     * @return Test suite of <code>BaseNodeStressTest</code>.
     */
    public static Test suite() {
        return new TestSuite(BaseNodeStressTest.class);
    }

    /**
     * <p>Set up the stress testing environment.</p>
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

        // create text field here.
        name = new TextField(new GraphNode());
        stereotype = new TextField(new GraphNode());
        namespace = new TextField(new GraphNode());
    }

    /**
     * <p>Basic stress test of <code>BaseNode</code>'s constructor.</p>
     */
    public void testBaseNodeCtor_Times() {
        for (int i = 0; i < LOOPTIMES; i++) {
            node = new SimpleBaseNode(graphNode, properties, name, stereotype,
                    namespace);

            // check the result here.
            assertNotNull("The BaseNode constructor is incorrect.", node);
            assertEquals("The BaseNode constructor is incorrect.", name,
                node.getNameCompartment());
            assertEquals("The BaseNode constructor is incorrect.", stereotype,
                node.getStereotypeCompartment());
            assertEquals("The BaseNode constructor is incorrect.", namespace,
                node.getNamespaceCompartment());

            // check the color and font here.
            assertEquals("The BaseNode constructor is incorrect.", Color.GREEN,
                node.getFillColor());
            assertEquals("The BaseNode constructor is incorrect.", Color.BLUE,
                node.getStrokeColor());
            assertEquals("The BaseNode constructor is incorrect.", Color.RED,
                node.getFontColor());

            assertEquals("The BaseNode constructor is incorrect.",
                "Arial Black", node.getFont().getFamily());
            assertEquals("The BaseNode constructor is incorrect.", 9,
                node.getFont().getSize());

            // remove all the properties, so the default value will be used
            graphNode.removeProperty(strokeColorProperty);
            graphNode.removeProperty(fontColorProperty);
            graphNode.removeProperty(fillColorProperty);
            graphNode.removeProperty(fontFamilyProperty);
            graphNode.removeProperty(fontSizeProperty);

            node.notifyPropertiesChange();

            // check the color and font here.
            assertEquals("The BaseNode constructor is incorrect, the defaut value should be used here.",
                Color.BLACK, node.getFillColor());
            assertEquals("The BaseNode constructor is incorrect, the defaut value should be used here.",
                Color.BLACK, node.getStrokeColor());
            assertEquals("The BaseNode constructor is incorrect, the defaut value should be used here.",
                Color.BLACK, node.getFontColor());

            assertEquals("The BaseNode constructor is incorrect, the defaut value should be used here.",
                "Arial", node.getFont().getFamily());
            assertEquals("The BaseNode constructor is incorrect, the defaut value should be used here.",
                10, node.getFont().getSize());

            // add all the properties for the next test.
            graphNode.addProperty(strokeColorProperty);
            graphNode.addProperty(fontColorProperty);
            graphNode.addProperty(fillColorProperty);
            graphNode.addProperty(fontFamilyProperty);
            graphNode.addProperty(fontSizeProperty);
        }
    }

    /**
     * <p>
     * Basic stress test of <code>notifyPropertiesChange()</code> method.
     * It get the color and the font to test this method.
     * </p>
     */
    public void testBaseNode_notifyPropertiesChange_ColorAndFont() {
        // change the node's properties and test it.
        for (int i = 0; i < LOOPTIMES; i++) {
            // create a base node here.
            node = new SimpleBaseNode(graphNode, properties, name, stereotype,
                    namespace);

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

            node.notifyPropertiesChange();

            // check the result here.
            assertEquals("The BaseNode constructor is incorrect.", Color.RED,
                node.getStrokeColor());
            assertEquals("The BaseNode constructor is incorrect.", Color.GREEN,
                node.getFillColor());
            assertEquals("The BaseNode constructor is incorrect.",
                "Times New Roman", node.getFont().getFamily());
            assertEquals("The BaseNode constructor is incorrect.", i + 1,
                node.getFont().getSize());
            assertEquals("The BaseNode constructor is incorrect.", Color.RED,
                node.getFontColor());
        }
    }
}
