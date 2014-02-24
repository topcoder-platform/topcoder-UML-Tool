/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.birdseyeview.accuracytests;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.UIManager;

import com.topcoder.gui.panels.zoom.ZoomPanel;
import com.topcoder.swing.birdseyeview.BirdsEyeView;

import junit.framework.TestCase;

/**
 * Accuracy Test for {@link BirdsEyeView#BirdsEyeView(JComponent, Dimension, Point)}.
 *
 * @author iRabbit
 * @version 1.0
 */
public class BirdsEyeViewAccuracyTests extends TestCase {

    /**
     * {@link BirdsEyeView} instance used in test.
     */
    private BirdsEyeView instance;

    /**
     * {@link JComponent} instance used in test.
     */
    private JComponent inputObject;

    /**
     * {@link Dimension} instance used in test.
     */
    private Dimension inputObjectViewDimension;

    /**
     * {@link Point} instance used in test.
     */
    private Point inputObjectViewPosition;

    /**
     * Sets up the environment.
     *
     * @throws Exception to junit
     */
    protected void setUp() throws Exception {
        inputObject = new JPanel();
        inputObjectViewDimension = new Dimension();
        inputObjectViewPosition = new Point();
        instance = new BirdsEyeView(inputObject, inputObjectViewDimension, inputObjectViewPosition);
    }

    /**
     * Tears down the environment.
     *
     * @throws Exception to junit
     */
    protected void tearDown() throws Exception {
        instance = null;
        inputObject = null;
        inputObjectViewDimension = null;
        inputObjectViewPosition = null;
    }

    /**
     * Accuracy Test for {@link BirdsEyeView#BirdsEyeView(JComponent, Dimension, Point)}. default value should be
     * used.
     */
    public void testCtor_Accuracy1() {
        instance = new BirdsEyeView(inputObject, inputObjectViewDimension, inputObjectViewPosition);

        assertNotNull("viewPort is incorrect", instance.getViewPort());
        assertNotNull("zoomPanel is incorrect", instance.getZoomPanel());
        assertEquals("inputObject is incorrect", inputObject, instance.getInputObject());
        assertEquals("inputObjectViewDimension is incorrect", inputObjectViewDimension, instance
                .getInputObjectViewDimension());
        assertEquals("inputObjectViewPosition is incorrect", inputObjectViewPosition, instance
                .getInputObjectViewPosition());

        assertTrue("mouse listener is incorrect", Arrays.deepEquals(new MouseListener[] {instance}, instance
                .getMouseListeners()));

        boolean flag = false;
        for (Component component : instance.getComponents()) {
            flag |= component == instance.getZoomPanel();
        }
        assertTrue("zoom panel should be set correctly ", flag);

        flag = false;
        for (Component component : instance.getZoomPanel().getComponents()) {
            flag |= component == instance.getViewPort();
        }
        assertTrue("view port should be set correctly ", flag);

        assertEquals("default opacity is incorrect", 0.5, instance.getViewPort().getOpacity());
    }

    /**
     * Accuracy Test for {@link BirdsEyeView#BirdsEyeView(JComponent, Dimension, Point)}. config value should be used.
     */
    public void testCtor_Accuracy2() {
        UIManager.put("BirdsEyeView.overlayColor", Color.blue);
        UIManager.put("BirdsEyeView.overlayBorderColor", Color.red);
        UIManager.put("BirdsEyeView.overlayOpacity", "0.4");

        instance = new BirdsEyeView(inputObject, inputObjectViewDimension, inputObjectViewPosition);

        assertNotNull("viewPort is incorrect", instance.getViewPort());
        assertNotNull("zoomPanel is incorrect", instance.getZoomPanel());
        assertEquals("inputObject is incorrect", inputObject, instance.getInputObject());
        assertEquals("inputObjectViewDimension is incorrect", inputObjectViewDimension, instance
                .getInputObjectViewDimension());
        assertEquals("inputObjectViewPosition is incorrect", inputObjectViewPosition, instance
                .getInputObjectViewPosition());

        assertTrue("mouse listener is incorrect", Arrays.deepEquals(new MouseListener[] {instance}, instance
                .getMouseListeners()));
        boolean flag = false;
        for (Component component : instance.getComponents()) {
            flag |= component == instance.getZoomPanel();
        }
        assertTrue("zoom panel should be set correctly ", flag);

        flag = false;
        for (Component component : instance.getZoomPanel().getComponents()) {
            flag |= component == instance.getViewPort();
        }
        assertTrue("view port should be set correctly ", flag);

        assertEquals("opacity is incorrect", 0.4, instance.getViewPort().getOpacity());
        assertEquals("overlay color is incorrect", Color.blue, instance.getViewPort().getBackground());
        assertEquals("default overlay border color is incorrect", Color.red, instance.getViewPort().getForeground());
    }

    /**
     * Accuracy Test for {@link BirdsEyeView#setInputObject(JComponent)}. input object should be set correctly.
     */
    public void testSetInputObject_Accuracy() {
        JComponent anotherInputObject = new JPanel();
        ZoomPanel oldZoomPanel = instance.getZoomPanel();
        instance.setInputObject(anotherInputObject);

        assertEquals("inputObject is incorrect", anotherInputObject, instance.getInputObject());

        boolean flag = false;
        for (Component component : instance.getZoomPanel().getComponents()) {
            flag |= component == instance.getViewPort();
        }
        assertTrue("view port should be set correctly ", flag);

        assertEquals("this should be removed from previous input object", 0, inputObject.getComponentCount());

        flag = false;
        for (Component component : instance.getComponents()) {
            flag |= component == oldZoomPanel;
        }
        assertFalse("old zoom panel should be removed", flag);
    }

    /**
     * Accuracy Test for {@link BirdsEyeView#mousePressed(MouseEvent)}. the position of view port should be set
     * correctly.
     */
    public void testMousePressed_Accuracy() {
        int x = 1;
        int y = 1;
        instance.getZoomPanel().setZoomFactor(0.5);
        instance.setSize(5, 5);
        instance.getViewPort().setSize(6, 6);
        MouseEvent event = new MouseEvent(instance, 0, 0, 0, x, y, 0, false);
        instance.mousePressed(event);
    }
}
