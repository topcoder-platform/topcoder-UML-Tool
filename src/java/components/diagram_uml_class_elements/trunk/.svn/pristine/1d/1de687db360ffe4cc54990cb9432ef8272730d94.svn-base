/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;

import junit.extensions.jfcunit.JFCTestCase;
import junit.extensions.jfcunit.finder.NamedComponentFinder;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.DiagramViewer;

/**
 * <p>
 * Test the functionality of <code>GroupTextField</code> class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class GroupTextFieldTest extends JFCTestCase {

    /** The absolute position of the visual node. Used for testing only. */
    private static final Point POSITION = new Point(100, 150);

    /** The size of the visual node. Used for testing only. */
    private static final Dimension SIZE = new Dimension(80, 40);

    /** An instance of <code>GroupTextField</code> for testing. */
    private GroupTextField groupTextField;

    /** Items for testing. */
    private ArrayList<StereotypeTextField> items = new ArrayList<StereotypeTextField>();

    /** Fill color for testing. */
    private Color fillColor;

    /** Stroke color for testing. */
    private Color strokeColor;

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

        groupTextField = classNode.getAttributesCompartment();

        for (int i = 0; i < 5; i++) {
            items.add(new StereotypeTextField(new GraphNode()));
        }

        fillColor = Color.GREEN;
        groupTextField.setFillColor(fillColor);

        strokeColor = Color.BLACK;
        groupTextField.setStrokeColor(strokeColor);

        fontColor = Color.BLACK;
        groupTextField.setFontColor(fontColor);
    }

    /**
     * Test method for 'GroupTextField(ArrayList)'. The instance should be created successfully.
     */
    public void testGroupTextField_Accuracy() {
        assertNotNull("Test method for 'GroupTextField(ArrayList)' failed.", groupTextField);
    }

    /**
     * Test method for 'GroupTextField(ArrayList)'. The instance should be created successfully.
     */
    public void testGroupTextField_Accuracy_2() {
        items.add(new StereotypeTextField(new GraphNode()));
        assertNotNull("Test method for 'GroupTextField(ArrayList)' failed.", new GroupTextField(items));
    }

    /**
     * Test method for 'GroupTextField(ArrayList)'. The argument is null, IllegalArgumentException should be thrown.
     */
    public void testTextField_null() {
        try {
            new GroupTextField(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'GroupTextField(ArrayList)'. The argument contains null, IllegalArgumentException should be
     * thrown.
     */
    public void testTextField_Contain_null() {
        try {
            ArrayList<StereotypeTextField> nullItems = new ArrayList<StereotypeTextField>();
            nullItems.add(null);
            new GroupTextField(nullItems);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        }
    }

    /**
     * Test method for 'getItems()'. Items should be got correctly.
     */
    public void testGetItems() {
        groupTextField.setItems(items);
        assertEquals("Items should be got correctly.", groupTextField.getItems(), items);
    }

    /**
     * Test method for 'setItems(ArrayList)'. Items should be set correctly.
     */
    public void testSetItems() {
        ArrayList<StereotypeTextField> newItems = new ArrayList<StereotypeTextField>();
        newItems.add(new StereotypeTextField(new GraphNode()));
        groupTextField.setItems(newItems);
        assertEquals("Items should be set correctly.", groupTextField.getItems(), newItems);
    }

    /**
     * Test method for 'getFillColor()'. Fill color should be got correctly.
     */
    public void testGetFillColor() {
        assertEquals("Fill color should be got correctly.", groupTextField.getFillColor(), fillColor);
    }

    /**
     * Test method for 'setFillColor(Color)'. The argument is null, white color should be set.
     */
    public void testSetFillColor_null() {
        groupTextField.setFillColor(null);
        assertEquals("Fill color should be set correctly.", groupTextField.getFillColor(), Color.WHITE);
    }

    /**
     * Test method for 'setFillColor(Color)'. Fill color should be set correctly.
     */
    public void testSetFillColor() {
        Color newColor = Color.GREEN;
        groupTextField.setFillColor(newColor);
        assertEquals("Fill color should be set correctly.", groupTextField.getFillColor(), newColor);
    }

    /**
     * Test method for 'getStrokeColor()'. Stroke color should be got correctly.
     */
    public void testGetStrokeColor() {
        assertEquals("Stroke color should be got correctly.", groupTextField.getStrokeColor(), strokeColor);
    }

    /**
     * Test method for 'setStrokeColor(Color)'. The argument is null, black color should be set.
     */
    public void testSetStrokeColor_null() {
        groupTextField.setStrokeColor(null);
        assertEquals("Stroke color should be set correctly.", groupTextField.getStrokeColor(), Color.BLACK);
    }

    /**
     * Test method for 'setStrokeColor(Color)'. Stroke color should be set correctly.
     */
    public void testSetStrokeColor() {
        Color newColor = Color.YELLOW;
        groupTextField.setStrokeColor(newColor);
        assertEquals("Stroke color should be set correctly.", groupTextField.getStrokeColor(), newColor);
    }

    /**
     * Test method for 'getFontColor()'. Font color should be got correctly.
     */
    public void testGetFontColor() {
        assertEquals("Font color should be got correctly.", groupTextField.getFontColor(), fontColor);
    }

    /**
     * Test method for 'setFontColor(Color)'. The argument is null, black color should be set.
     */
    public void testsetFontColor_null() {
        groupTextField.setFontColor(null);
        assertEquals("Font color should be set correctly.", groupTextField.getFontColor(), Color.BLACK);
    }

    /**
     * Test method for 'setFontColor(Color)'. Font color should be set correctly.
     */
    public void testSetFontColor() {
        Color newColor = Color.GRAY;
        groupTextField.setFontColor(newColor);
        assertEquals("Font color should be set correctly.", groupTextField.getFontColor(), newColor);
    }

    /**
     * Test method for 'getPreferredSize()'. Preferred size should be got correctly.
     */
    public void testGetPreferredSize() {
        assertNotNull("Preferred size should be got correctly.", groupTextField.getPreferredSize());
    }

    /**
     * Test method for 'paintComponent(Graphics)'. GroupTextField should be painted correctly.
     */
    public void testPaintComponentGraphics() throws Exception {
        groupTextField.setName("GroupTextField");
        groupTextField.setVisible(true);
        TestUtil.loadConfig("test_files/DiagramViewer.xml");
        DiagramViewer viewer = new DiagramViewer("DiagramViewer");
        viewer.add(groupTextField);

        JDialog dialog = new JDialog((JFrame) null, "GroupTextField", true);
        dialog.setSize(500, 500);
        dialog.getContentPane().add(viewer);
        dialog.setModal(false);
        dialog.setVisible(true);
        NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "GroupTextField");
        GroupTextField field = (GroupTextField) finder.find(dialog, 0);
        assertNotNull("GroupTextField component should be displayed", field);

        sleep(100);
        dialog.dispose();
    }

    /**
     * Test method for 'findItem(Point)'. Correct item should be found.
     */
    public void testFindItem() {
        StereotypeTextField item = groupTextField.getItems().get(1);
        Rectangle bounds = item.getBounds();
        Point pos = bounds.getLocation();
        pos.x += bounds.width / 2;
        pos.y += bounds.height / 2;
        assertEquals("Correct item should be found.", groupTextField.findItem(pos), item);
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

        groupTextField = null;

        items.clear();
        items = null;

        fillColor = null;
        strokeColor = null;
        fontColor = null;
    }
}
