/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements.accuracytests;

import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import junit.framework.TestCase;

import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.PopupMenuTrigger;

/**
 * <p>
 * Accuracy test of <code>PopupMenuTrigger</code>.
 * </p>
 * 
 * @author Achilles_2005
 * @version 1.0
 */
public class PopupMenuTriggerAccuracyTest extends TestCase {
    /**
     * <p>
     * Private instance used for test.
     * </p>
     */
    private PopupMenuTrigger popupMenuTrigger;

    /**
     * <p>
     * Sets up test environment.
     * </p>
     * 
     * @throws Exception
     *             exception to JUnit.
     */
    protected void setUp() throws Exception {
        popupMenuTrigger = new PopupMenuTrigger();
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     * 
     * @throws Exception
     *             exception to JUnit.
     */
    protected void tearDown() throws Exception {
        popupMenuTrigger = null;
    }

    /**
     * <p>
     * Tests accuracy of <code>PopupMenuTrigger()</code>.
     * </p>
     * 
     * @throws Exception
     *             exception to JUnit.
     */
    public void testConstructorAccuracy() throws Exception {
        assertNotNull("constructed instance should not be null.", popupMenuTrigger);
    }

    /**
     * <p>
     * Tests accuracy of <code>mouseClicked(MouseEvent)</code>.
     * </p>
     * 
     * @throws Exception
     *             exception to JUnit.
     */
    public void testMouseClicked() throws Exception {
        JFrame frame = new JFrame();
        frame.addMouseListener(popupMenuTrigger);

        JPopupMenu popupMenu = new JPopupMenu();
        popupMenu.add(new JMenuItem("This is PopupMenuTrigger"));

        frame.add(popupMenu);
        frame.setSize(300, 500);
        frame.pack();
        frame.setVisible(true);
        Thread.sleep(2000);
        frame.dispose();
    }
}
