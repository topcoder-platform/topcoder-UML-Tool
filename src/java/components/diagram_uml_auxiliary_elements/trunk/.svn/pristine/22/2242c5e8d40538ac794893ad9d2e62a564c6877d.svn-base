/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;


/**
 * <p>
 * Unit test cases for PopupMenuTrigger.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class PopupMenuTriggerTests extends TestCase {
    /**
     * <p>
     * The PopupMenuTrigger instance for helping testing.
     * </p>
     */
    private PopupMenuTrigger trigger;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        trigger = new PopupMenuTrigger();
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        trigger = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(PopupMenuTriggerTests.class);
    }

    /**
     * <p>
     * Tests constructor PopupMenuTrigger#PopupMenuTrigger() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created PopupMenuTrigger instance should not be null.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testConstructor() throws Exception {
        assertNotNull("Failed to create a new PopupMenuTrigger instance.", trigger);
    }

    /**
     * <p>
     * Tests PopupMenuTrigger#mouseClicked(MouseEvent event) for accuracy.
     * </p>
     *
     * <p>
     * Verify : PopupMenuTrigger#mouseClicked(MouseEvent event) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testMouseClicked() throws Exception {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.addMouseListener(trigger);
        JPopupMenu popup = new JPopupMenu();
        popup.add(new JMenuItem("menuItem"));
        panel.setComponentPopupMenu(popup);
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);

        MouseEvent mouseEvent = new MouseEvent(panel, 0, 0, 0, 0, 0, 1, true);
        trigger.mouseClicked(mouseEvent);

        // make the Frame visible for 1 second
        Thread.sleep(1000);

        frame.setVisible(false);
        frame.dispose();
        frame = null;
    }
}