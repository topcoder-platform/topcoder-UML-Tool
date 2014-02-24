/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements.accuracytests;

import java.awt.Color;
import java.util.ArrayList;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.classelements.GroupTextField;
import com.topcoder.gui.diagramviewer.uml.classelements.StereotypeTextField;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * <p>
 * This is a test case for <code>GroupTextField</code> class.
 * </p>
 * @author moonli
 * @version 1.0
 */
public class GroupTextFieldTest extends TestCase {

    /**
     * <p>
     * Represents a list of instances of <code>StereotypeTextField</code>
     * </p>
     */
    private ArrayList<StereotypeTextField> textFields;

    /**
     * <p>
     * Represents an instance of <code>GroupTextField</code>.
     * </p>
     */
    private GroupTextField groupField;

    /**
     * <p>
     * Represents an instance of <code>StereotypeTextField</code>.
     * </p>
     */
    private StereotypeTextField stf1;

    /**
     * <p>
     * Represents an instance of <code>StereotypeTextField</code>.
     * </p>
     */
    private StereotypeTextField stf2;

    /**
     * <p>
     * Represents an instance of <code>StereotypeTextField</code>.
     * </p>
     */
    private StereotypeTextField stf3;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        stf1 = new StereotypeTextField(new GraphNode());
        stf2 = new StereotypeTextField(new GraphNode());
        stf3 = new StereotypeTextField(new GraphNode());
        stf1.setStereotype("+");
        stf2.setStereotype("-");
        stf3.setStereotype("#");
        stf1.setText("getMemberCount");
        stf2.setText("setCount");
        stf3.setText("count");

        textFields = new ArrayList<StereotypeTextField>();
        textFields.add(stf1);
        textFields.add(stf2);
        textFields.add(stf3);

        groupField = new GroupTextField(textFields);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     * @throws Exception
     *             to JUnit
     */
    protected void tearDown() throws Exception {
        textFields = null;
        groupField = null;
    }

    /**
     * <p>
     * Aggregates all tests.
     * </p>
     * @return a test suite will be returned
     */
    public static Test suite() {
        return new TestSuite(GroupTextFieldTest.class);
    }

    /**
     * <p>
     * Test for constructor.
     * </p>
     * <p>
     * Tests it for accuracy, non-null instance should be returned.
     * </p>
     * @throws Exception
     *             to JUnit
     */
    public void testCtorAccuracy() throws Exception {
        assertNotNull("'groupField' should not be null.", groupField);
        assertEquals("Items mismatched.", textFields, groupField.getItems());

    }

    /**
     * <p>
     * Test for <code>setItems(items)</code> method.
     * </p>
     * <p>
     * Items should be set successfully. old items should be removed.
     * </p>
     * @throws Exception
     *             to JUnit
     */
    public void testSetItemsAccuracy() throws Exception {
        ArrayList<StereotypeTextField> items = new ArrayList<StereotypeTextField>();
        items.add(new StereotypeTextField(new GraphNode()));

        groupField.setItems(items);

        assertEquals("There should be only one stereotype text field registered.", 1, groupField
            .getItems().size());
    }

    /**
     * <p>
     * Test for <code>setFillColor(fillColor)</code> method.
     * </p>
     * <p>
     * Tests it with null, Color.WHITE should be set.
     * </p>
     * @throws Exception
     *             to JUnit
     */
    public void testSetFillColorWithNullArg() throws Exception {
        groupField.setFillColor(null);
        assertEquals("Fill color mismatched.", Color.WHITE, groupField.getFillColor());
    }

    /**
     * <p>
     * Test for <code>setFillColor(fillColor)</code> method.
     * </p>
     * <p>
     * Tests it with Color.GREEN, Color.GREEN should be set.
     * </p>
     * @throws Exception
     *             to JUnit
     */
    public void testSetFillColorWithGreen() throws Exception {
        groupField.setFillColor(Color.GREEN);
        assertEquals("Fill color mismatched.", Color.GREEN, groupField.getFillColor());
    }

    /**
     * <p>
     * Test for <code>setStrokeColor(strokeColor)</code> method.
     * </p>
     * <p>
     * Tests it with null, Color.BLACK should be set.
     * </p>
     * @throws Exception
     *             to JUnit
     */
    public void testSetStrokeColorWithNullArg() throws Exception {
        groupField.setStrokeColor(null);
        assertEquals("Stroke color mismatched.", Color.BLACK, groupField.getStrokeColor());
    }

    /**
     * <p>
     * Test for <code>setFontColor(fontColor)</code> method.
     * </p>
     * <p>
     * Tests it with null, Color.BLACK should be set.
     * </p>
     * @throws Exception
     *             to JUnit
     */
    public void testSetFontColorWithNullArg() throws Exception {
        groupField.setFontColor(null);
        assertEquals("Font color mismatched.", Color.BLACK, groupField.getFontColor());
    }

    /**
     * <p>
     * Test for <code>getPreferredSize()</code> method.
     * </p>
     * <p>
     * Tests it for accuracy, valid dimension should be returned.
     * </p>
     * @throws Exception
     *             to JUnit
     */
    public void testGetPreferredSizeAccuracy() throws Exception {

    }
}