/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.auxiliaryelements;

import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.framework.Test;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;


/**
 * <p>
 * Unit test cases for TextNodeMouseListener.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class TextNodeMouseListenerTests extends TestCase {
    /**
     * <p>
     * The TextNodeMouseListener instance for helping testing.
     * </p>
     */
    private TextNodeMouseListener listener;

    /**
     * <p>
     * Setup test environment.
     * </p>
     *
     * @throws Exception to JUnit
     *
     */
    protected void setUp() throws Exception {
        listener = new TextNodeMouseListener();
    }

    /**
     * <p>
     * Tears down test environment.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        listener = null;
    }

    /**
     * <p>
     * Return all tests.
     * </p>
     *
     * @return all tests
     */
    public static Test suite() {
        return new TestSuite(TextNodeMouseListenerTests.class);
    }

    /**
     * <p>
     * Tests constructor TextNodeMouseListener#TextNodeMouseListener() for accuracy.
     * </p>
     *
     * <p>
     * Verify : the newly created TextNodeMouseListener instance should not be null.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testConstructor() throws Exception {
        assertNotNull("Failed to create a new TextNodeMouseListener instance.", listener);
        assertTrue("A TextNodeMouseListener instance should be also a MouseAdapter instance.",
                listener instanceof MouseAdapter);
    }

    /**
     * <p>
     * Tests TextNodeMouseListener#mouseClicked(MouseEvent event) for accuracy.
     * </p>
     *
     * <p>
     * Verify : TextNodeMouseListener#mouseClicked(MouseEvent event) is correct.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testMouseClicked() throws Exception {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.addMouseListener(listener);
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);

        MouseEvent mouseEvent = new MouseEvent(panel, 0, 0, 0, 0, 0, 1, true);
        listener.mouseClicked(mouseEvent);

        // make the Frame visible for 1 second
        Thread.sleep(1000);

        frame.setVisible(false);
        frame.dispose();
        frame = null;
    }
}
