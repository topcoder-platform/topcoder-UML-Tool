/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;

import junit.extensions.jfcunit.JFCTestCase;
import junit.extensions.jfcunit.finder.NamedComponentFinder;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.edges.AnchorType;

/**
 * <p>
 * Test the functionality of <code>StereotypeTextField</code> class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class StereotypeTextFieldTest extends JFCTestCase {

    /** The absolute position of the visual node. Used for testing only. */
    private static final Point POSITION = new Point(100, 150);

    /** The size of the visual node. Used for testing only. */
    private static final Dimension SIZE = new Dimension(80, 40);

    /** An instance of <code>StereotypeTextField</code> for testing. */
    private StereotypeTextField textField;

    /** A string for testing. */
    private String text = "text";

    /** Font color for testing. */
    private Color fontColor;

    /** An instance of <code>ClassNode</code> for testing. */
    private ClassNode classNode;

    /** A GraphNode for <code>ClassNode</code>. */
    private GraphNode graphNode;

    /** Properties for testing. */
    private Map<String, String> properties;

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setUp();

        graphNode = TestUtil.createClassGraphNode(POSITION, SIZE, false, false);
        graphNode.setContainer(new GraphNode());

        properties = TestUtil.createProperties();

        classNode = new ClassNode(graphNode, properties);

        textField = classNode.getAttributesCompartment().getItems().get(0);
        textField.setText(text);
        fontColor = Color.BLACK;
        textField.setFontColor(fontColor);
    }

    /**
     * Test method for 'StereotypeTextField(GraphNode)'. The instance should be created successfully.
     */
    public void testStereotypeTextField_Accuracy() {
        assertNotNull("Test method for 'StereotypeTextField(GraphNode)' failed.", textField);
    }

    /**
     * Test method for 'StereotypeTextField(GraphNode)'. The argument is null, IllegalArgumentException should be
     * thrown.
     */
    public void testStereotypeTextField_null() {
        try {
            new StereotypeTextField(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'StereotypeTextField(GraphNode, AnchorType)'. The instance should be created successfully.
     */
    public void testStereotypeTextFieldGraphNodeAnchorType_Accuracy() {
        assertNotNull("Test method for 'StereotypeTextField(GraphNode, AnchorType)' failed.", new StereotypeTextField(
                graphNode, AnchorType.Line));
    }

    /**
     * Test method for 'StereotypeTextField(GraphNode, AnchorType)'. The graphNode is null, IllegalArgumentException
     * should be thrown.
     */
    public void testTextFieldGraphNodeAnchorType_null_1() {
        try {
            new StereotypeTextField(null, AnchorType.Line);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'StereotypeTextField(GraphNode, AnchorType)'. The anchor type is null, IllegalArgumentException
     * should be thrown.
     */
    public void testTextFieldGraphNodeAnchorType_null_2() {
        try {
            new StereotypeTextField(graphNode, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'getPreferredSize()', preferred size should be got correctly.
     */
    public void testGetPreferredSize() {
        assertNotNull("The preferred size should be got correctly.", textField.getPreferredSize());
    }

    /**
     * Test method for 'getStereotype()', stereotype should be got correctly.
     */
    public void testGetStereotype() {
        textField.setStereotype("new");
        assertEquals("stereotype should be got correctly.", textField.getStereotype(), "new");
    }

    /**
     * Test method for 'setStereotype(String)'. The argument is null, empty string should be set.
     */
    public void testSetStereotype_null() {
        textField.setStereotype(null);
        assertEquals("stereotype should be got correctly.", textField.getStereotype(), "");
    }

    /**
     * Test method for 'setStereotype(String)', stereotype should be set correctly.
     */
    public void testSetStereotype() {
        textField.setStereotype("new");
        assertEquals("stereotype should be got correctly.", textField.getStereotype(), "new");
    }

    /**
     * Test method for 'isStereotypeVisible()', the flag should be got correctly.
     */
    public void testIsStereotypeVisible() {
        textField.stereotypeVisible(false);
        assertFalse("the flag should be got correctly.", textField.isStereotypeVisible());
    }

    /**
     * Test method for 'setStereotypeVisible(boolean)', the flag should be set correctly.
     */
    public void testStereotypeVisible() {
        textField.stereotypeVisible(true);
        assertTrue("the flag should be set correctly.", textField.isStereotypeVisible());
    }

    /**
     * Test method for 'paintComponent(Graphics)'. StereotypeTextField should be painted correctly.
     */
    public void testPaintComponentGraphics() throws Exception {
        textField.setName("StereotypeTextField");
        TestUtil.loadConfig("test_files/DiagramViewer.xml");
        DiagramViewer viewer = new DiagramViewer("DiagramViewer");
        viewer.setFont(new Font("Arial", 0, 14));
        viewer.add(textField);

        textField.setSize(textField.getPreferredSize());
        textField.setVisible(true);

        JDialog dialog = new JDialog((JFrame) null, "StereotypeTextField", true);
        dialog.setSize(500, 500);
        dialog.getContentPane().add(viewer);
        dialog.setModal(false);
        dialog.setVisible(true);
        NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "StereotypeTextField");
        StereotypeTextField field = (StereotypeTextField) finder.find(dialog, 0);
        assertNotNull("StereoTextField component should be displayed", field);

        sleep(100);
        dialog.dispose();
    }

    /**
     * <p>
     * Tears down the test environment.
     * </p>
     */
    protected void tearDown() throws Exception {
        super.tearDown();

        graphNode = null;

        properties = null;

        classNode = null;

        textField = null;

        fontColor = null;
    }
}
