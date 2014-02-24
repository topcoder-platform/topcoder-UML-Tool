/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classedges;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for <code>ActiveEdgeEnding</code>.
 * Since this class is abstract, a mock subclass named <code>MockActiveEdgeEnding</code> is used for testing.
 * </p>
 *
 * @author littlebull
 * @version 1.0
 */
public class ActiveEdgeEndingUnitTests extends TestCase {

    /** <code>ActiveEdgeEnding</code> instance used for testing. */
    private ActiveEdgeEnding edgeEnding;

    /** <code>TextField</code> instance representing name compartment. */
    private TextField name;

    /** <code>TextField</code> instance representing multiplicity compartment. */
    private TextField multiplicity;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     */
    protected void setUp() {
        name = UnitTestsHelper.createTextFiled("name");
        multiplicity = UnitTestsHelper.createTextFiled("1..n");
        edgeEnding = new MockActiveEdgeEnding(name, multiplicity);
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     */
    protected void tearDown() {
        name = null;
        multiplicity = null;
        edgeEnding = null;
    }

    /**
     * <p>
     * Failure test of constructor.
     * With null <code>name</code>.
     * Should throw IAE.
     * </p>
     */
    public void testCtor_Failure_NullName() {
        try {
            new MockActiveEdgeEnding(null, multiplicity);
            fail("Should throw IAE.");
        } catch (IllegalArgumentException e) {
            //pass
        }
    }

    /**
     * <p>
     * Failure test of constructor.
     * With null <code>multiplicity</code>.
     * Should throw IAE.
     * </p>
     */
    public void testCtor_Failure_NullMultiplicity() {
        try {
            new MockActiveEdgeEnding(name, null);
            fail("Should throw IAE.");
        } catch (IllegalArgumentException e) {
            //pass
        }
    }

    /**
     * <p>
     * Accuracy test of constructor .
     * Should create the instance successfully.
     * </p>
     */
    public void testCtor_Accuracy() {
        assertNotNull("Should create the instance successfully.", edgeEnding);
    }

    /**
     * <p>
     * Accuracy test of method <code>getNameCompartment()</code>.
     * Should return the name compartment.
     * </p>
     */
    public void testGetNameCompartment() {
        assertNotNull("Should return the name compartment.", edgeEnding.getNameCompartment());
    }

    /**
     * <p>
     * Accuracy test of method <code>getMultiplicityCompartment()</code>.
     * Should return the multiplicity compartment.
     * </p>
     */
    public void testGetMultiplicityCompartment() {
        assertNotNull("Should return the multiplicity compartment.", edgeEnding.getMultiplicityCompartment());
    }

    /**
     * <p>
     * Accuracy test of method <code>isNameVisible()</code>.
     * Should return the proper value.
     * </p>
     */
    public void testIsNameVisible() {
        assertTrue("Should return the proper value.", edgeEnding.isNameVisible());
    }

    /**
     * <p>
     * Accuracy test of method <code>nameVisible()</code>.
     * Should set the proper value.
     * </p>
     */
    public void testNameVisible() {
        edgeEnding.nameVisible(false);
        assertFalse("Should set the proper value.", edgeEnding.isNameVisible());
    }

    /**
     * <p>
     * Accuracy test of method <code>isMultiplicityVisible()</code>.
     * Should return the proper value.
     * </p>
     */
    public void testIsMultiplicityVisible() {
        assertTrue("Should return the proper value.", edgeEnding.isMultiplicityVisible());
    }

    /**
     * <p>
     * Accuracy test of method <code>multiplicityVisible()</code>.
     * Should set the proper value.
     * </p>
     */
    public void testMultiplicityVisible() {
        edgeEnding.multiplicityVisible(false);
        assertFalse("Should set the proper value.", edgeEnding.isMultiplicityVisible());
    }

    /**
     * <p>
     * Accuracy test of method <code>isNameVisibleWhenSelected()</code>.
     * Should return the proper value.
     * </p>
     */
    public void testIsNameVisibleWhenSelected() {
        assertTrue("Should return the proper value.", edgeEnding.isNameVisibleWhenSelected());
    }

    /**
     * <p>
     * Accuracy test of method <code>nameVisibleWhenSelected()</code>.
     * Should set the proper value.
     * </p>
     */
    public void testNameVisibleWhenSelected() {
        edgeEnding.nameVisibleWhenSelected(false);
        assertFalse("Should set the proper value.", edgeEnding.isNameVisibleWhenSelected());
    }

    /**
     * <p>
     * Accuracy test of method <code>isMultiplicityVisibleWhenSelected()</code>.
     * Should return the proper value.
     * </p>
     */
    public void testIsMultiplicityVisibleWhenSelected() {
        assertTrue("Should return the proper value.", edgeEnding.isMultiplicityVisibleWhenSelected());
    }

    /**
     * <p>
     * Accuracy test of method <code>multiplicityVisibleWhenSelected()</code>.
     * Should set the proper value.
     * </p>
     */
    public void testMultiplicityVisibleWhenSelected() {
        edgeEnding.multiplicityVisibleWhenSelected(false);
        assertFalse("Should set the proper value.", edgeEnding.isMultiplicityVisibleWhenSelected());
    }

    /**
     * <p>
     * Accuracy test of method <code>getHideNameText()</code>.
     * Should return the proper value.
     * </p>
     */
    public void testGetHideNameText() {
        assertEquals("Should return the proper value.", "", edgeEnding.getHideNameText());
    }

    /**
     * <p>
     * Failure test of method <code>setHideNameText(Text)</code>.
     * With null <code>text</code>.
     * Should throw IAE.
     * </p>
     */
    public void testSetHideNameText_Failure_NullText() {
        try {
            edgeEnding.setHideNameText(null);
            fail("Should throw IAE.");
        } catch (IllegalArgumentException e) {
            //pass
        }
    }

    /**
     * <p>
     * Accuracy test of method <code>setHideNameText(Text)</code>.
     * Should set the proper value.
     * </p>
     */
    public void testSetHideNameText_Accuracy() {
        edgeEnding.setHideNameText("some text");
        assertEquals("Should set the proper value.", "some text", edgeEnding.getHideNameText());
    }

    /**
     * <p>
     * Accuracy test of method <code>getHideMultiplicityText()</code>.
     * Should return the proper value.
     * </p>
     */
    public void testGetHideMultiplicityText() {
        assertEquals("Should return the proper value.", "1", edgeEnding.getHideMultiplicityText());
    }

    /**
     * <p>
     * Failure test of method <code>setHideMultiplicityText(Text)</code>.
     * With null <code>text</code>.
     * Should throw IAE.
     * </p>
     */
    public void testSetHideMultiplicityText_Failure_NullText() {
        try {
            edgeEnding.setHideMultiplicityText(null);
            fail("Should throw IAE.");
        } catch (IllegalArgumentException e) {
            //pass
        }
    }

    /**
     * <p>
     * Accuracy test of method <code>setHideMultiplicityText(Text)</code>.
     * Should set the proper value.
     * </p>
     */
    public void testSetHideMultiplicityText_Accuracy() {
        edgeEnding.setHideMultiplicityText("some text");
        assertEquals("Should set the proper value.", "some text", edgeEnding.getHideMultiplicityText());
    }

    /**
     * <p>
     * Accuracy test of method <code>isSelected()</code>.
     * Should return the proper value.
     * </p>
     */
    public void testIsSelected() {
        assertFalse("Should return the proper value.", edgeEnding.isSelected());
    }

    /**
     * <p>
     * Accuracy test of method <code>selected()</code>.
     * With true.
     * Should select this edge ending.
     * </p>
     */
    public void testSelected_Accuracy_True() {
        edgeEnding.selected(true);
        assertTrue("Should select this edge ending.", edgeEnding.isSelected());
    }

    /**
     * <p>
     * Accuracy test of method <code>selected()</code>.
     * With false.
     * Should not select this edge ending.
     * </p>
     */
    public void testSelected_Accuracy_False() {
        edgeEnding.selected(false);
        assertFalse("Should not select this edge ending.", edgeEnding.isSelected());
    }

}
