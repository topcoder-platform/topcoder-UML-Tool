/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.swing.birdseyeview;

import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.event.EventListenerList;

import junit.framework.TestCase;

import com.topcoder.swing.birdseyeview.event.ViewPortEvent;
/**
 * <p>
 * Unit test of the ViewPort class.
 * </p>
 *
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ViewPortTest extends TestCase {

    /**
     * <p>
     * Test the constructor of ViewPort.
     * </p>
     */
    public void testConstructor() {
        ViewPort vp = new ViewPort();
        assertEquals("The listener should contain the vp instance.",
                vp, vp.getMouseListeners()[0]);
        assertEquals("The listener should contain the vp instance.",
                vp, vp.getMouseMotionListeners()[0]);
    }

    /**
     * <p>
     * Test the getter and setter of opacity attribute.
     * </p>
     */
    public void testOpacity() {
        ViewPort vp = new ViewPort();
        vp.setOpacity(0.5);
        assertEquals("The opacity should be same with expected.", 0.5, vp.getOpacity());
    }

    /**
     * <p>
     * Test the setter of opacity with invalid value.
     * </p>
     */
    public void testOpacityWithInvalidValue() {
        ViewPort vp = new ViewPort();

        try {
            vp.setOpacity(-1);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // pass
        }
        try {
            vp.setOpacity(1.2);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * <p>
     * Test the getter and setter of zoomFactor attribute.
     * </p>
     */
    public void testZoomFactor() {
        ViewPort vp = new ViewPort();
        vp.setZoomFactor(0.5);
        assertEquals("The zoomFactor should be same with expected.", 0.5d, vp.getZoomFactor());
        vp.setZoomFactor(11);
        assertEquals("The zoomFactor should be same with expected.", 11d, vp.getZoomFactor());
        vp.setZoomFactor(0);
        assertEquals("The zoomFactor should be same with expected.", 1d, vp.getZoomFactor());
    }

    /**
     * <p>
     * Test the setter of zoomFactor with invalid value.
     * </p>
     */
    public void testZoomFactorWithInvalidValue() {
        ViewPort vp = new ViewPort();

        try {
            vp.setZoomFactor(-1);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * <p>
     * Test the mousePress method.
     * </p>
     */
    public void testMousePress() {
        ViewPort vp = new ViewPort();
        vp.mousePressed(new MouseEvent(vp, 0, System.currentTimeMillis(), 0, 200, 200, 1, false));
        assertTrue("The isDragging should be true.", vp.isDragging());
        assertEquals("The drag position should be same with expected.", new Point(200, 200), vp.getDragPosition());
    }

    /**
     * <p>
     * Failure test of the mousePress method.
     * </p>
     */
    public void testMousePressFail() {
        ViewPort vp = new ViewPort();
        vp.mousePressed(null);
        assertFalse("The isDragging should be false.", vp.isDragging());
    }

    /**
     * <p>
     * Test the mouseDragged method.
     * </p>
     */
    public void testMouseDragged() {
        GUIForTest gui = new GUIForTest();
        gui.createUI();

        JLabel label = new JLabel(new ImageIcon("test_files/demo_test.gif"));
        JScrollPane sp = new JScrollPane(label);
        sp.setSize(350, 277);

        JLabel label1 = new JLabel(new ImageIcon("test_files/demo_test.gif"));
        BirdsEyeView birdEye = new BirdsEyeView(label1, sp.getSize(), new Point(0, 0));
        gui.add(sp);
        gui.add(birdEye);
        gui.showUI();
        ViewPort vp = birdEye.getViewPort();

        vp.mouseDragged(new MouseEvent(vp, 0, System.currentTimeMillis(), 0, 200, 200, 1, false));
        assertEquals("The location should be same with expected.", new Point(0, 0), vp.getLocation());
        gui.disposeUI();
    }

    /**
     * <p>
     * Failure test of mouseDragged method.
     * </p>
     */
    public void testMouseDraggedFail() {
        GUIForTest gui = new GUIForTest();
        gui.createUI();

        JLabel label = new JLabel(new ImageIcon("test_files/demo_test.gif"));
        JScrollPane sp = new JScrollPane(label);
        sp.setSize(350, 277);

        JLabel label1 = new JLabel(new ImageIcon("test_files/demo_test.gif"));
        BirdsEyeView birdEye = new BirdsEyeView(label1, sp.getSize(), new Point(0, 0));
        gui.add(sp);
        gui.add(birdEye);
        gui.showUI();

        ViewPort vp = birdEye.getViewPort();
        vp.mousePressed(new MouseEvent(vp, 0, System.currentTimeMillis(), 0, 0, 0, 1, false));
        vp.mouseDragged(null);
        assertEquals("The location should be same with expected.", new Point(0, 0), vp.getLocation());
        gui.disposeUI();
    }
    /**
     * <p>
     * Test the mouseDragged and mouseReleased method.
     * </p>
     */
    public void testMouseDraggedAndMouseReleased() {
        GUIForTest gui = new GUIForTest();
        gui.createUI();

        JLabel label = new JLabel(new ImageIcon("test_files/demo_test.gif"));
        JScrollPane sp = new JScrollPane(label);
        sp.setSize(350, 277);

        JLabel label1 = new JLabel(new ImageIcon("test_files/demo_test.gif"));
        BirdsEyeView birdEye = new BirdsEyeView(label1, sp.getSize(), new Point(0, 0));
        gui.add(sp);
        gui.add(birdEye);
        gui.showUI();

        ViewPort vp = birdEye.getViewPort();
        vp.mousePressed(new MouseEvent(vp, 0, System.currentTimeMillis(), 0, 0, 0, 1, false));
        vp.mouseDragged(new MouseEvent(vp, 0, System.currentTimeMillis(), 0, 200, 200, 1, false));
        vp.mouseReleased(new MouseEvent(vp, 0, System.currentTimeMillis(), 0, 200, 200, 1, false));
        assertEquals("The location should be same with expected.", new Point(200, 200), vp.getLocation());
        assertFalse("The isDragging should be same false.", vp.isDragging());
        gui.disposeUI();
    }
    /**
     * <p>
     * Failure test of the mouseReleased method with null event.
     * </p>
     */
    public void testMouseReleasedFail() {
        GUIForTest gui = new GUIForTest();
        gui.createUI();

        JLabel label = new JLabel(new ImageIcon("test_files/demo_test.gif"));
        JScrollPane sp = new JScrollPane(label);
        sp.setSize(350, 277);

        JLabel label1 = new JLabel(new ImageIcon("test_files/demo_test.gif"));
        BirdsEyeView birdEye = new BirdsEyeView(label1, sp.getSize(), new Point(0, 0));
        gui.add(sp);
        gui.add(birdEye);
        gui.showUI();

        ViewPort vp = birdEye.getViewPort();
        vp.mousePressed(new MouseEvent(vp, 0, System.currentTimeMillis(), 0, 0, 0, 1, false));
        vp.mouseDragged(new MouseEvent(vp, 0, System.currentTimeMillis(), 0, 200, 200, 1, false));
        vp.mouseReleased(null);
        assertEquals("The location should be same with expected.", new Point(200, 200), vp.getLocation());
        assertTrue("The isDragging should be same false.", vp.isDragging());
        gui.disposeUI();
    }
    /**
     * <p>
     * Test the addViewPortListeners method.
     * </p>
     *
     * @throws Exception
     *              to JUnit
     */
    public void testAddViewPortListeners() throws Exception {
        ViewPort vp = new ViewPort();
        MockViewPortListener l = new MockViewPortListener();
        vp.addViewPortListener(l);
        EventListenerList ls = (EventListenerList) ReflectTestHelper.getField(vp, "listenerList");
        assertEquals("There should be 1 listener in the list.", 1, ls.getListenerCount());
    }

    /**
     * <p>
     * Test the addViewPortListeners method with null.
     * </p>
     *
     */
    public void testAddViewPortListenersWithNull() {
        ViewPort vp = new ViewPort();
        try {
            vp.addViewPortListener(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * <p>
     * Test the removeViewPortListeners method.
     * </p>
     *
     * @throws Exception
     *              to JUnit.
     */
    public void testRemoveViewPortListeners() throws Exception {
        ViewPort vp = new ViewPort();
        MockViewPortListener l = new MockViewPortListener();
        vp.addViewPortListener(l);
        vp.removeViewPortListener(l);
        EventListenerList ls = (EventListenerList) ReflectTestHelper.getField(vp, "listenerList");
        assertEquals("There should be 0 listener in the list.", 0, ls.getListenerCount());
    }

    /**
     * <p>
     * Test the removeViewPortListeners method with null.
     * </p>
     *
     */
    public void testRemoveViewPortListenersWithNull() {
        ViewPort vp = new ViewPort();
        try {
            vp.removeViewPortListener(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * <p>
     * Test the clearViewPortListeners method.
     * </p>
     *
     * @throws Exception
     *              to JUnit
     */
    public void testClearViewPortListeners() throws Exception {
        ViewPort vp = new ViewPort();
        MockViewPortListener l = new MockViewPortListener();
        vp.addViewPortListener(l);
        vp.clearViewPortListeners();
        EventListenerList ls = (EventListenerList) ReflectTestHelper.getField(vp, "listenerList");
        assertEquals("There should be 0 listener in the list.", 0, ls.getListenerCount());
    }

    /**
     * <p>
     * Test the fireViewPortListeners method.
     * </p>
     *
     * @throws Exception
     *              to JUnit
     */
    public void testFireViewPortListeners() throws Exception {
        ViewPort vp = new ViewPort();
        MockViewPortListener l = new MockViewPortListener();
        vp.addViewPortListener(l);
        ViewPortEvent e = new ViewPortEvent(1, 1);
        vp.fireViewPortListeners(e);
        assertEquals("The retrieved event should be same with expected.", e, l.getViewPortEvent());
    }

    /**
     * <p>
     * Test the setter and getter of dragging attribute.
     * </p>
     */
    public void testDragging() {
        ViewPort vp = new ViewPort();
        vp.setDragging(true);
        assertTrue("The retrieved dragging value should be true", vp.isDragging());
    }

    /**
     * <p>
     * Test the getter and setter of DragPosition attribute.
     * </p>
     */
    public void testDragPosition() {
        ViewPort vp = new ViewPort();
        Point p = new Point(1, 1);
        vp.setDragPosition(p);
        assertEquals("The retrieved dragging position should be same with expected.",
                p, vp.getDragPosition());
    }

    /**
     * <p>
     * Test the setter of DragPosition attribute with null.
     * </p>
     */
    public void testDragPositionWithNull() {
        ViewPort vp = new ViewPort();
        try {
            vp.setDragPosition(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException e) {
            // pass
        }
    }

    /**
     * <p>
     * Test of the paintComponent method with null parameter.
     * </p>
     */
    public void testPaintComponent() {
        ViewPort vp = new ViewPort();
        vp.setLocation(100, 100);
        vp.setZoomFactor(0.5);
        MockViewPortListener l = new MockViewPortListener();
        vp.addViewPortListener(l);
        vp.paintComponent(null);
        assertNull("The event should be null.", l.getViewPortEvent());
    }
}
