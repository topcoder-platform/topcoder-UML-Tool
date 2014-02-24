/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.birdseyeview;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

import junit.framework.TestCase;

import com.topcoder.swing.birdseyeview.event.ViewPortEvent;
import com.topcoder.swing.birdseyeview.event.ViewPortListener;

/**
 * <p>
 * Demo test of this component.
 * </p>
 *
 * @author MiG-29, TCSDEVELOPER
 * @version 1.0
 */
public class DemoTest extends TestCase {
    /**
     * <p>
     * Sets up demo environment.
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    protected void setUp() throws Exception {
        UIManager.put("BirdsEyeView.overlayColor", Color.blue);
        UIManager.put("BirdsEyeView.overlayBorderColor", Color.black);
        UIManager.put("BirdsEyeView.overlayBorderThickness", "1");
        UIManager.put("BirdsEyeView.overlayOpacity", "0.3");
    }

    /**
     * <p>
     * Clears the demo environment.
     * </p>
     *
     * @throws Exception
     *             when error occurs
     */
    protected void tearDown() throws Exception {
    }

    /**
     * <p>
     * Show a simple demo of BirdEyeView.
     * </p>
     * @throws InterruptedException
     *                          to JUnit
     */
    public void testShowDemo() throws InterruptedException {
        GUIForTest gui = new GUIForTest();
        gui.createUI();

        JLabel label = new JLabel(new ImageIcon("test_files/demo_test.gif"));
        JScrollPane sp = new JScrollPane(label);
        sp.setSize(380, 220);

        JLabel label1 = new JLabel(new ImageIcon("test_files/demo_test.gif"));
        BirdsEyeView birdEye = new BirdsEyeView(label1, sp.getSize(),
                new Point(0, 0));
        birdEye.setMaximumSize(new Dimension(300, 190));
        birdEye.setMinimumSize(new Dimension(300, 190));
        birdEye.setPreferredSize(new Dimension(300, 190));
        birdEye.getZoomPanel().setPreferredSize(new Dimension(300, 160));
        birdEye.getViewPort().addViewPortListener(new ChangeViewPortListener(sp));

        gui.add(sp);
        gui.add(birdEye);

        gui.showUI();
        Thread.sleep(1000);
        gui.disposeUI();
    }

    /**
     * <p>
     * The demo in the component specification.
     * </p>
     */
    public void testSpecDemo() {
        // Assume we have the big class diagram, let's name it an input object
        JLabel inputObject = new JLabel(new ImageIcon(
                "test_files/demo_test.gif"));
        // The currently shown part of the input object has a size. We should
        // use that size with our birds eye view control
        Dimension inputObjectViewDimension = new Dimension(800, 600);
        // The user can scroll the input object (for example, the big class
        // diagram). The current location of the left-top origin of the
        // currently shown part of the input object should be used with our
        // birds eye view control
        Point inputObjectViewPosition = new Point(300, 200);
        // Finally - create the birds eye view control
        BirdsEyeView control = new BirdsEyeView(inputObject,
                inputObjectViewDimension, inputObjectViewPosition);
        // From now on, the birds view control is created, registered as a child
        // of the inputObject, registered to mouse events, and displayed. Any
        // changes in the inputObject (like change the entire size of the
        // inputObject, change of the graphical data - add/remove new class) -
        // will be automatically displayed by the current control. The user can
        // manually change the size of our control and modify any GUI related
        // properties as for other JComponent controls.

        // Set the new dimension of the inputObject view port. The birds eye
        // view control will update its own view port size to have proper value
        control.setInputObjectViewDimension(new Dimension(640, 480));
        // Or another way:
        control.getInputObjectViewDimension().setSize(500, 400);
        // Set the new position of the inputObejct view port. The birds eye view
        // control will update its own view port position to have proper value
        control.setInputObjectViewPosition(new Point(100, 150));
        // Or another way
        control.getInputObjectViewPosition().setLocation(90, 80);
        // If those updates were performed in the paintComponent(...) method of
        // the input object, then no other actions are needed - our birds eye
        // view control will be updated automatically.
        // In other case (if dimension and position were changed outside the
        // paintComponent(...) method of the parent JComponent), then we should
        // manually redraw our control like this:
        control.repaint();

        // Make an instance of the listener
        ViewPortListener listener = new ChangeViewPortListener(null);
        // Register the listener to the birds eye view control
        control.getViewPort().addViewPortListener(listener);
        // De-register the view port listener
        control.getViewPort().removeViewPortListener(listener);
        // Or all the ViewPortListener instances can be easily removed
        control.getViewPort().clearViewPortListeners();

        // Change to another input object
        control.setInputObject(inputObject);
        // The next actions were performed in the previous call: - the birds eye
        // view was totally de-registered from the previous inputObject. - all
        // the ViewPortListener instances were de-registered from the birds eye
        // view control view port. - the zoomPanel was updated with a new
        // inputObject JComponent instance - the new inputObject was set to the
        // internals of the bird eye view control - the birds eye view control
        // was registered as a child to the new inputObject The input object
        // view port position is most likely should be new, not from the
        // previous inputObject (for example, the sequence diagram can be
        // scrolled to the different position than class diagram). Set the new
        // position of the input object view port
        control.setInputObjectViewPosition(new Point(20, 40));
        // The size of the input object view port is most likely should NOT be
        // new, but the same as from previous input object (for example, the
        // shown part of the sequence diagram will be the same as of the
        // previous class diagram. So, no updating of the input object view part
        // dimension is needed.
        // But in the general cases, the user can set the new dimensions of the
        // input object view port like this:
        control.setInputObjectViewDimension(new Dimension(1024, 768));
        // Please note, the previous listener was removed, because in general
        // case the new inputObject will be a totally different and we can not
        // assume in our component that the user will ALWAYS use just one
        // listener for all the changed input objects.
        // So, the user have to manually register a new listener like this:
        control.getViewPort().addViewPortListener(new ViewPortListener() {
            public void viewPortMoved(ViewPortEvent event) {
            }
        });

        // Set the semi-transparent view port
        control.getViewPort().setOpacity(0.5);
        // Set the fully transparent view port
        control.getViewPort().setOpacity(0.0);
        // Set the solid (non-transparent) view port
        control.getViewPort().setOpacity(1.0);
    }
}
