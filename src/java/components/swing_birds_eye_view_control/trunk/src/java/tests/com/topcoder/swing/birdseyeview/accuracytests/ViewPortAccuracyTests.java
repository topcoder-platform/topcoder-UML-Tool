/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.birdseyeview.accuracytests;

import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import com.topcoder.swing.birdseyeview.ViewPort;

import junit.framework.TestCase;

/**
 * Accuracy Test for {@link ViewPort}.
 *
 * @author iRabbit
 * @version 1.0
 */
public class ViewPortAccuracyTests extends TestCase {

    /**
     * Accuracy Test for {@link ViewPort#mouseDragged(MouseEvent)}. the x and y should be set correctly.
     */
    public void testMouseDragged_Accuracy() {
        ViewPort instance = new ViewPort();
        instance.setBounds(2, 2, 50, 50);
        int oldX = 4;
        int oldY = 4;
        MouseEvent oldEvent = new MouseEvent(instance, 0, 0, 0, oldX, oldY, 0, false);

        int newX = 10;
        int newY = 10;
        MouseEvent newEvent = new MouseEvent(instance, 0, 0, 0, newX, newY, 0, false);

        JPanel panel = new JPanel();
        panel.setSize(100, 100);
        panel.add(instance);

        instance.mousePressed(oldEvent);
        instance.mouseDragged(newEvent);

        assertEquals("x is incorrect", 8, instance.getX());
        assertEquals("y is incorrect", 8, instance.getY());
    }
}
