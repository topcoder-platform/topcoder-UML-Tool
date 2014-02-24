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
import com.topcoder.gui.diagramviewer.uml.classelements.event.TextChangedListener;

/**
 * <p>
 * Test the functionality of <code>TextField</code> class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TextFieldTest extends JFCTestCase {

    /** The absolute position of the visual node. Used for testing only. */
    private static final Point POSITION = new Point(100, 150);

    /** The size of the visual node. Used for testing only. */
    private static final Dimension SIZE = new Dimension(80, 40);

    /** An instance of <code>TextField</code> for testing. */
    private TextField textField;

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

    /** Text changed listener for <code>TextField</code>. */
    private MockedTextChangedListener listener;

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

        textField = classNode.getNameCompartment();
        textField.setText(text);
        fontColor = Color.BLACK;
        textField.setFontColor(fontColor);

        listener = new MockedTextChangedListener();
    }

    /**
     * Test method for 'TextField(GraphNode)'. The instance should be created successfully.
     */
    public void testTextField_Accuracy() {
        assertNotNull("Test method for 'TextField(GraphNode)' failed.", textField);
    }

    /**
     * Test method for 'TextField(GraphNode)'. The argument is null, IllegalArgumentException should be thrown.
     */
    public void testTextField_null() {
        try {
            new TextField(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'TextField(GraphNode, AnchorType)'. The instance should be created successfully.
     */
    public void testTextFieldGraphNodeAnchorType_Accuracy() {
        assertNotNull("Test method for 'TextField(GraphNode, AnchorType)' failed.", new TextField(graphNode,
                AnchorType.Line));
    }

    /**
     * Test method for 'TextField(GraphNode, AnchorType)'. The graphNode is null, IllegalArgumentException should be
     * thrown.
     */
    public void testTextFieldGraphNodeAnchorType_null_1() {
        try {
            new TextField(null, AnchorType.Line);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'TextField(GraphNode, AnchorType)'. The anchor type is null, IllegalArgumentException should be
     * thrown.
     */
    public void testTextFieldGraphNodeAnchorType_null_2() {
        try {
            new TextField(graphNode, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'getText()', text should be got correctly.
     */
    public void testGetText() {
        assertEquals("Text should be got correctly.", textField.getText(), text);
    }

    /**
     * Test method for 'setText(String)', text should be set correctly.
     */
    public void testSetTextString() {
        String newText = "newText";
        textField.setText(newText);
        assertEquals("Text should be set correctly.", textField.getText(), newText);
    }

    /**
     * Test method for 'setText(String)', given null, should be set as empty string.
     */
    public void testSetTextString_null() {
        textField.setText(null);
        assertEquals("Text should be set correctly.", textField.getText(), "");
    }

    /**
     * Test method for 'getFontColor()', font color should be got correctly.
     */
    public void testGetFontColor() {
        assertEquals("Font color should be got correctly.", textField.getFontColor(), fontColor);
    }

    /**
     * Test method for 'setFontColor(Color)', font color should be set correctly.
     */
    public void testSetFontColor() {
        Color color = Color.CYAN;
        textField.setFontColor(color);
        assertEquals("Font color should be set correctly.", textField.getFontColor(), color);
    }

    /**
     * Test method for 'notifyTextChange(String)', text should change accordingly.
     */
    public void testNotifyTextChange() {
        textField.addTextChangedListener(listener);
        String newText = "testNotifyTextChange";
        textField.notifyTextChange(newText);
        assertEquals("text should change accordingly.", textField.getText(), newText);
    }

    /**
     * Test method for 'notifyTextChange(String)', given null, text should change to empty string.
     */
    public void testNotifyTextChange_null() {
        textField.addTextChangedListener(listener);
        textField.notifyTextChange(null);
        assertEquals("text should change accordingly.", textField.getText(), "");
    }

    /**
     * Test method for 'getPreferredSize()', preferred size should be got correctly.
     */
    public void testGetPreferredSize() {
        assertNotNull("The preferred size should be got correctly.", textField.getPreferredSize());
    }

    /**
     * Test method for 'addTextChangedListener(TextChangedListener)', listener should be added correctly.
     */
    public void testAddTextChangedListener() {
        textField.removeTextChangedListener(listener);
        TextChangedListener[] oldListeners = textField.getListeners(TextChangedListener.class);
        textField.addTextChangedListener(listener);
        TextChangedListener[] newListeners = textField.getListeners(TextChangedListener.class);
        assertEquals("Listener should be added correctly.", oldListeners.length + 1, newListeners.length);
        assertEquals("Listener should be added correctly.", newListeners[newListeners.length - 1], listener);
    }

    /**
     * Test method for 'RemoveTextChangedListener(TextChangedListener)', listener should be removed correctly.
     */
    public void testRemoveTextChangedListener() {
        textField.addTextChangedListener(listener);
        TextChangedListener[] oldListeners = textField.getListeners(TextChangedListener.class);
        textField.removeTextChangedListener(listener);
        TextChangedListener[] newListeners = textField.getListeners(TextChangedListener.class);
        assertEquals("Listener should be removed correctly.", oldListeners.length - 1, newListeners.length);
    }

    /**
     * Test method for 'paintComponent(Graphics)'. TextField should be painted correctly.
     */
    public void testPaintComponentGraphics() throws Exception {
        textField.setName("TextField");
        TestUtil.loadConfig("test_files/DiagramViewer.xml");
        DiagramViewer viewer = new DiagramViewer("DiagramViewer");
        viewer.setFont(new Font("Arial", 0, 14));
        viewer.add(textField);

        textField.setSize(textField.getPreferredSize());
        textField.setVisible(true);

        JDialog dialog = new JDialog((JFrame) null, "TextField", true);
        dialog.setSize(500, 500);
        dialog.getContentPane().add(viewer);
        dialog.setModal(false);
        dialog.setVisible(true);
        NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "TextField");
        TextField field = (TextField) finder.find(dialog, 0);
        assertNotNull("TextField component should be displayed", field);

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

        listener = null;
    }
}
