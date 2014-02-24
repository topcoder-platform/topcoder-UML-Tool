/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.print.accuracytests;

import java.awt.Button;
import java.awt.Rectangle;

import javax.swing.JPanel;

import junit.framework.TestCase;

import com.topcoder.swing.print.impl.DefaultComponentVisibleMaker;

/**
 * This class aggregates accuracy tests for DefaultComponentVisibleMaker class.
 * 
 * @author ch_music
 * @version 1.0
 */
public class DefaultComponentVisibleMakerAccuracyTests extends TestCase {

    /**
     * A placeholder for DefaultComponentVisibleMaker.
     */
    private DefaultComponentVisibleMaker test;

    /**
     * A Button for testing purposes.
     */
    private Button button;

    /**
     * Sets up testing environment.
     */
    public void setUp() {
        test = new DefaultComponentVisibleMaker();
        button = new Button("test");
    }

    /**
     * Tests constructor for accuracy. No exception is expected.
     */
    public void testDefaultComponentVisibleMaker() {
        assertNotNull("Constructor fails to create instance.", test);
    }

    /**
     * Tests makeVisible method for accuracy. No exception is expected.
     */
    public void testMakeVisible_Basic() {
        assertNull("Initial condition not satisfied.", button.getGraphics());
        test.makeVisible(button);
        assertNotNull("makeVisible fails to make component visible.", button.getGraphics());
    }

    /**
     * Tests makeVisible method for accuracy. No exception is expected.
     */
    public void testMakeVisible_IsInJPanel() {
        assertNull("Initial condition not satisfied.", button.getGraphics());
        test.makeVisible(button);
        assertTrue("makeVisible fails to add component to JFrame.", button.getParent() instanceof JPanel);
    }

    /**
     * Tests makeInvisible method for accuracy. No exception is expected.
     */
    public void testMakeInvisible_Basic() {
        assertNull("Initial condition not satisfied.", button.getGraphics());
        test.makeVisible(button);
        test.makeInvisible(button);
        assertNull("makeInvisible fails to make component invisible.", button.getGraphics());
    }

    /**
     * Tests makeVisible with non-null parent. No exception is expected.
     */
    public void testMakeVisible_NonNullParent() {
        JPanel jp = new JPanel();
        jp.add(button);
        assertSame("Initial condition not met.", jp, button.getParent());
        assertNull("Initial condition not met.", button.getGraphics());
        test.makeVisible(button);
        assertNotNull("makeVisible fails to make component visible.", button.getGraphics());
        assertNotSame("makeVisible fails to move the component to the new parent (JFrame).", jp, button
                .getParent());
    }

    /**
     * Tests makeInvisible with non-null parent. No exception is expected.
     */
    public void testMakeInvisible_NonNullParent1() {
        JPanel jp = new JPanel();
        jp.add(new Button("temp"));
        jp.add(button);
        jp.setComponentZOrder(button, 1);

        test.makeVisible(button);
        test.makeInvisible(button);
        assertNull("makeInvisible fails to make the object invisible.", button.getGraphics());
    }

    /**
     * Tests makeInvisible with non-null parent. No exception is expected.
     */
    public void testMakeInvisible_NonNullParent2() {
        JPanel jp = new JPanel();
        jp.add(new Button("temp"));
        jp.add(button);
        jp.setComponentZOrder(button, 1);

        test.makeVisible(button);
        test.makeInvisible(button);
        assertEquals("makeInvisible fails to set the component to its original parent.", jp, button.getParent());
    }

    /**
     * Tests makeInvisible with non-null parent. No exception is expected.
     */
    public void testMakeInvisible_NonNullParent3() {
        JPanel jp = new JPanel();
        jp.add(new Button("temp"));
        jp.add(button);
        jp.setComponentZOrder(button, 1);

        test.makeVisible(button);
        test.makeInvisible(button);
        assertEquals("makeInvisible fails to set the component zOrder.", 1, jp.getComponentZOrder(button));
    }

    /**
     * Tests makeInvisible with non-null parent. No exception is expected.
     */
    public void testMakeInvisible_NonNullParent4() {
        JPanel jp = new JPanel();
        jp.add(new Button("temp"));
        jp.add(button);
        jp.setComponentZOrder(button, 1);
        button.setVisible(true);
        Rectangle origBound = new Rectangle(button.getBounds());

        test.makeVisible(button);
        test.makeInvisible(button);
        assertEquals("makeInvisible fails to set the original bounds (using component#setBounds).", origBound,
                button.getBounds());
    }
    
    /**
     * Tests makeInvisible with non-null parent. No exception is expected.
     */
    public void testMakeInvisible_NonNullParent5() {
        JPanel jp = new JPanel();
        jp.add(new Button("temp"));
        jp.add(button);
        jp.setComponentZOrder(button, 1);
        button.setVisible(true);
        button.setBounds(1, 1, 100, 90);
        Rectangle origBound = new Rectangle(button.getBounds());

        test.makeVisible(button);
        test.makeInvisible(button);
        assertEquals("makeInvisible fails to set the original bounds (using component#setBounds).", origBound,
                button.getBounds());
    }

    /**
     * Tests makeInvisible with non-null parent. No exception is expected.
     */
    public void testMakeInvisible_MapCleared() {
        test.makeVisible(button);
        test.makeInvisible(button);
        try {
            test.makeInvisible(button);
        } catch (IllegalArgumentException e) {
            // expected case.
        }
    }

    /**
     * Tests clear for accuracy. No exception is expected.
     */
    public void testClear() {
        JPanel jp = new JPanel();
        jp.add(button);
        assertSame("Initial condition not met.", jp, button.getParent());
        assertNull("Initial condition not met.", button.getGraphics());
        test.makeVisible(button);

        test.clear();
        try {
            test.makeInvisible(button);
        } catch (IllegalArgumentException e) {
            // expected case.
        }
    }
}
