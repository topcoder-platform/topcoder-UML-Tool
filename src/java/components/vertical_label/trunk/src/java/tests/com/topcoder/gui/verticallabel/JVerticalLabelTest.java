/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.verticallabel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import junit.framework.TestCase;

/**
 * Unit tests of <code>JVerticalLabel</code> class. The private inner class <code>VerticalLabelUI</code> is
 * also tested through java reflection.
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class JVerticalLabelTest extends TestCase {

    /**
     * An instance of <code>ImageIcon</code> used in unit tests.
     */
    private ImageIcon icon;

    /**
     * An instance of <code>Class</code> used in unit tests, to test VerticalLabelUI.
     */
    private Class uiClazz;

    /**
     * An instance of <code>Object</code> used in unit tests, to check fired event.
     */
    private Object oldValue;

    /**
     * An instance of <code>Object</code> used in unit tests, to check fired event.
     */
    private Object newValue;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        // Load the icon.
        icon = new ImageIcon("test_files/uml.png");
        // Initialize the Class-typed variable to the private inner class of JVerticalLabel.
        uiClazz = JVerticalLabel.class.getDeclaredClasses()[0];
    }

    /**
     * Test constructor <code>JVerticalLabel#JVerticalLabel()</code> for accuracy.
     */
    public void testCtor_01() {
        JVerticalLabel label = new JVerticalLabel();
        assertTrue("JVerticalLabel#Ctor1 is incorrect", uiClazz.isInstance(label.getUI()));
        assertFalse("JVerticalLabel#Ctor1 is incorrect", label.isFlipped());
        assertNull("JVerticalLabel#Ctor1 is incorrect", label.getIcon());
        assertEquals("JVerticalLabel#Ctor1 is incorrect", 0, label.getText().length());
        assertEquals("JVerticalLabel#Ctor1 is incorrect", SwingConstants.LEADING, label.getHorizontalAlignment());
    }

    /**
     * Test constructor <code>JVerticalLabel#JVerticalLabel(boolean flipped)</code> for accuracy.
     */
    public void testCtor_02() {
        JVerticalLabel label = new JVerticalLabel(true);
        assertTrue("JVerticalLabel#Ctor2 is incorrect", uiClazz.isInstance(label.getUI()));
        assertTrue("JVerticalLabel#Ctor2 is incorrect", label.isFlipped());
        assertNull("JVerticalLabel#Ctor2 is incorrect", label.getIcon());
        assertEquals("JVerticalLabel#Ctor2 is incorrect", 0, label.getText().length());
        assertEquals("JVerticalLabel#Ctor2 is incorrect", SwingConstants.LEADING, label.getHorizontalAlignment());
    }

    /**
     * Test constructor <code>JVerticalLabel#JVerticalLabel(Icon icon)</code> for accuracy.
     */
    public void testCtor_03() {
        JVerticalLabel label = new JVerticalLabel(icon);
        assertTrue("JVerticalLabel#Ctor3 is incorrect", uiClazz.isInstance(label.getUI()));
        assertFalse("JVerticalLabel#Ctor3 is incorrect", label.isFlipped());
        assertEquals("JVerticalLabel#Ctor3 is incorrect", icon, label.getIcon());
        assertNull("JVerticalLabel#Ctor3 is incorrect", label.getText());
        assertEquals("JVerticalLabel#Ctor3 is incorrect", SwingConstants.CENTER, label.getHorizontalAlignment());
    }

    /**
     * Test constructor <code>JVerticalLabel#JVerticalLabel(Icon icon, boolean flipped)</code> for accuracy.
     */
    public void testCtor_04() {
        JVerticalLabel label = new JVerticalLabel(icon, true);
        assertTrue("JVerticalLabel#Ctor4 is incorrect", uiClazz.isInstance(label.getUI()));
        assertTrue("JVerticalLabel#Ctor4 is incorrect", label.isFlipped());
        assertEquals("JVerticalLabel#Ctor4 is incorrect", icon, label.getIcon());
        assertNull("JVerticalLabel#Ctor4 is incorrect", label.getText());
        assertEquals("JVerticalLabel#Ctor4 is incorrect", SwingConstants.CENTER, label.getHorizontalAlignment());
    }

    /**
     * Test constructor <code>JVerticalLabel#JVerticalLabel(Icon icon, int horizontalAlignment)</code> for
     * accuracy.
     */
    public void testCtor_05() {
        JVerticalLabel label = new JVerticalLabel(icon, SwingConstants.RIGHT);
        assertTrue("JVerticalLabel#Ctor5 is incorrect", uiClazz.isInstance(label.getUI()));
        assertFalse("JVerticalLabel#Ctor5 is incorrect", label.isFlipped());
        assertEquals("JVerticalLabel#Ctor5 is incorrect", icon, label.getIcon());
        assertNull("JVerticalLabel#Ctor5 is incorrect", label.getText());
        assertEquals("JVerticalLabel#Ctor5 is incorrect", SwingConstants.RIGHT, label.getHorizontalAlignment());
    }

    /**
     * Test constructor <code>JVerticalLabel#JVerticalLabel(Icon icon, int horizontalAlignment)</code>.<br>
     * The horizontalAlignment is invalid, so IllegalArgumentException is thrown.
     */
    public void testCtor_05_Failure() {
        try {
            new JVerticalLabel(icon, 100000000);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // Correct.
        }
    }

    /**
     * Test constructor
     * <code>JVerticalLabel#JVerticalLabel(Icon icon, int horizontalAlignment, boolean flipped)</code> for
     * accuracy.
     */
    public void testCtor_06() {
        JVerticalLabel label = new JVerticalLabel(icon, SwingConstants.RIGHT, true);
        assertTrue("JVerticalLabel#Ctor6 is incorrect", uiClazz.isInstance(label.getUI()));
        assertTrue("JVerticalLabel#Ctor6 is incorrect", label.isFlipped());
        assertEquals("JVerticalLabel#Ctor6 is incorrect", icon, label.getIcon());
        assertNull("JVerticalLabel#Ctor6 is incorrect", label.getText());
        assertEquals("JVerticalLabel#Ctor6 is incorrect", SwingConstants.RIGHT, label.getHorizontalAlignment());
    }

    /**
     * Test constructor
     * <code>JVerticalLabel#JVerticalLabel(Icon icon, int horizontalAlignment, boolean flipped)</code>.<br>
     * The horizontalAlignment is invalid, so IllegalArgumentException is thrown.
     */
    public void testCtor_06_Failure() {
        try {
            new JVerticalLabel(icon, 100000000, true);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // Correct.
        }
    }

    /**
     * Test constructor <code>JVerticalLabel#JVerticalLabel(String text)</code> for accuracy.
     */
    public void testCtor_07() {
        JVerticalLabel label = new JVerticalLabel("Text");
        assertTrue("JVerticalLabel#Ctor7 is incorrect", uiClazz.isInstance(label.getUI()));
        assertFalse("JVerticalLabel#Ctor7 is incorrect", label.isFlipped());
        assertNull("JVerticalLabel#Ctor7 is incorrect", label.getIcon());
        assertEquals("JVerticalLabel#Ctor7 is incorrect", "Text", label.getText());
        assertEquals("JVerticalLabel#Ctor7 is incorrect", SwingConstants.LEADING, label.getHorizontalAlignment());
    }

    /**
     * Test constructor <code>JVerticalLabel#JVerticalLabel(String text, boolean flipped)</code> for accuracy.
     */
    public void testCtor_08() {
        JVerticalLabel label = new JVerticalLabel("Text", true);
        assertTrue("JVerticalLabel#Ctor8 is incorrect", uiClazz.isInstance(label.getUI()));
        assertTrue("JVerticalLabel#Ctor8 is incorrect", label.isFlipped());
        assertNull("JVerticalLabel#Ctor8 is incorrect", label.getIcon());
        assertEquals("JVerticalLabel#Ctor8 is incorrect", "Text", label.getText());
        assertEquals("JVerticalLabel#Ctor8 is incorrect", SwingConstants.LEADING, label.getHorizontalAlignment());
    }

    /**
     * Test constructor <code>JVerticalLabel#JVerticalLabel(String text, Icon icon, int horizontalAlignment)</code>
     * for accuracy.
     */
    public void testCtor_09() {
        JVerticalLabel label = new JVerticalLabel("Text", icon, SwingConstants.RIGHT);
        assertTrue("JVerticalLabel#Ctor9 is incorrect", uiClazz.isInstance(label.getUI()));
        assertFalse("JVerticalLabel#Ctor9 is incorrect", label.isFlipped());
        assertEquals("JVerticalLabel#Ctor9 is incorrect", icon, label.getIcon());
        assertEquals("JVerticalLabel#Ctor9 is incorrect", "Text", label.getText());
        assertEquals("JVerticalLabel#Ctor9 is incorrect", SwingConstants.RIGHT, label.getHorizontalAlignment());
    }

    /**
     * Test constructor <code>JVerticalLabel#JVerticalLabel(String text, Icon icon, int horizontalAlignment)</code>.<br>
     * The horizontalAlignment is invalid, so IllegalArgumentException is thrown.
     */
    public void testCtor_09_Failure() {
        try {
            new JVerticalLabel("Text", icon, 100000000);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // Correct.
        }
    }

    /**
     * Test constructor
     * <code>JVerticalLabel#JVerticalLabel(String text, Icon icon, int horizontalAlignment, boolean flipped)</code>
     * for accuracy.
     */
    public void testCtor_10() {
        JVerticalLabel label = new JVerticalLabel("Text", icon, SwingConstants.RIGHT, true);
        assertTrue("JVerticalLabel#Ctor10 is incorrect", uiClazz.isInstance(label.getUI()));
        assertTrue("JVerticalLabel#Ctor10 is incorrect", label.isFlipped());
        assertEquals("JVerticalLabel#Ctor10 is incorrect", icon, label.getIcon());
        assertEquals("JVerticalLabel#Ctor10 is incorrect", "Text", label.getText());
        assertEquals("JVerticalLabel#Ctor10 is incorrect", SwingConstants.RIGHT, label.getHorizontalAlignment());
    }

    /**
     * Test constructor
     * <code>JVerticalLabel#JVerticalLabel(String text, Icon icon, int horizontalAlignment, boolean flipped)</code>.<br>
     * The horizontalAlignment is invalid, so IllegalArgumentException is thrown.
     */
    public void testCtor_10_Failure() {
        try {
            new JVerticalLabel("Text", icon, 100000000, true);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // Correct.
        }
    }

    /**
     * Test constructor <code>JVerticalLabel#JVerticalLabel(String text, int horizontalAlignment)</code> for
     * accuracy.
     */
    public void testCtor_11() {
        JVerticalLabel label = new JVerticalLabel("Text", SwingConstants.RIGHT);
        assertTrue("JVerticalLabel#Ctor11 is incorrect", uiClazz.isInstance(label.getUI()));
        assertFalse("JVerticalLabel#Ctor11 is incorrect", label.isFlipped());
        assertNull("JVerticalLabel#Ctor11 is incorrect", label.getIcon());
        assertEquals("JVerticalLabel#Ctor11 is incorrect", "Text", label.getText());
        assertEquals("JVerticalLabel#Ctor11 is incorrect", SwingConstants.RIGHT, label.getHorizontalAlignment());
    }

    /**
     * Test constructor <code>JVerticalLabel#JVerticalLabel(String text, int horizontalAlignment)</code>.<br>
     * The horizontalAlignment is invalid, so IllegalArgumentException is thrown.
     */
    public void testCtor_11_Failure() {
        try {
            new JVerticalLabel("Text", 100000000);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // Correct.
        }
    }

    /**
     * Test constructor
     * <code>JVerticalLabel#JVerticalLabel(String text, int horizontalAlignment, boolean flipped)</code> for
     * accuracy.
     */
    public void testCtor_12() {
        JVerticalLabel label = new JVerticalLabel("Text", SwingConstants.RIGHT, true);
        assertTrue("JVerticalLabel#Ctor12 is incorrect", uiClazz.isInstance(label.getUI()));
        assertTrue("JVerticalLabel#Ctor12 is incorrect", label.isFlipped());
        assertNull("JVerticalLabel#Ctor12 is incorrect", label.getIcon());
        assertEquals("JVerticalLabel#Ctor12 is incorrect", "Text", label.getText());
        assertEquals("JVerticalLabel#Ctor12 is incorrect", SwingConstants.RIGHT, label.getHorizontalAlignment());
    }

    /**
     * Test constructor
     * <code>JVerticalLabel#JVerticalLabel(String text, int horizontalAlignment, boolean flipped)</code>.<br>
     * The horizontalAlignment is invalid, so IllegalArgumentException is thrown.
     */
    public void testCtor_12_Failure() {
        try {
            new JVerticalLabel("Text", 100000000, true);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            // Correct.
        }
    }

    /**
     * Test <code>JVerticalLabel#setFlipped(boolean flipped)</code> and <code>JVerticalLabel#isFlipped()</code>
     * method. The propertyChange event is caught and checked.
     */
    public void testSetGetFlipped() {
        JVerticalLabel label = new JVerticalLabel();
        label.addPropertyChangeListener("flipped", new PropertyChangeListener() {
            public void propertyChange(PropertyChangeEvent e) {
                oldValue = e.getOldValue();
                newValue = e.getNewValue();
            }
        });

        oldValue = null;
        newValue = null;
        label.setFlipped(true);
        assertTrue("JVerticalLabel#set/getFlipped", label.isFlipped());
        assertEquals("JVerticalLabel#set/getFlipped", Boolean.FALSE, oldValue);
        assertEquals("JVerticalLabel#set/getFlipped", Boolean.TRUE, newValue);

        oldValue = null;
        newValue = null;
        label.setFlipped(false);
        assertFalse("JVerticalLabel#set/getFlipped", label.isFlipped());
        assertEquals("JVerticalLabel#set/getFlipped", Boolean.TRUE, oldValue);
        assertEquals("JVerticalLabel#set/getFlipped", Boolean.FALSE, newValue);
    }

    /**
     * Test constructor <code>VerticalLabelUI#Ctor</code>.
     *
     * @throws Exception throw exception to junit.
     */
    public void test_VerticalLabelUI_Ctor() throws Exception {
        Constructor ctor = uiClazz.getConstructor(new Class[0]);
        ctor.setAccessible(true);
        assertNotNull("VerticalLabelUI#Ctor is incorrect", ctor.newInstance(new Object[0]));
    }

    /**
     * Test <code>VerticalLabelUI#getPreferredSize(JComponent component)</code> method.<br>
     * The component is null, so IllegalArgumentException will be thrown.
     *
     * @throws Exception throw exception to junit.
     */
    public void test_VerticalLabelUI_getPreferredSize_Null() throws Exception {
        Constructor ctor = uiClazz.getConstructor(new Class[0]);
        ctor.setAccessible(true);
        Object inst = ctor.newInstance(new Object[0]);

        Method method = uiClazz.getMethod("getPreferredSize", JComponent.class);
        method.setAccessible(true);

        try {
            method.invoke(inst, (Object) null);
            fail("InvocationTargetException should be thrown.");
        } catch (InvocationTargetException e) {
            if (e.getCause() instanceof IllegalArgumentException) {
                System.out.println(e.getCause().getMessage());
            } else {
                fail("Inner exception should be IllegalArgumentException");
            }
        }
    }

    /**
     * Test <code>VerticalLabelUI#getPreferredSize(JComponent component)</code> method.<br>
     * The component is not a <code>JVerticalLabel</code>, so IllegalArgumentException will be thrown.
     *
     * @throws Exception throw exception to junit.
     */
    public void test_VerticalLabelUI_getPreferredSize_BadType() throws Exception {
        Constructor ctor = uiClazz.getConstructor(new Class[0]);
        ctor.setAccessible(true);
        Object inst = ctor.newInstance(new Object[0]);

        Method method = uiClazz.getMethod("getPreferredSize", JComponent.class);
        method.setAccessible(true);

        try {
            method.invoke(inst, new JLabel());
            fail("InvocationTargetException should be thrown.");
        } catch (InvocationTargetException e) {
            if (e.getCause() instanceof IllegalArgumentException) {
                System.out.println(e.getCause().getMessage());
            } else {
                fail("Inner exception should be IllegalArgumentException");
            }
        }
    }

    /**
     * Test <code>VerticalLabelUI#getPreferredSize(JComponent component)</code> method.
     *
     * @throws Exception throw exception to junit.
     */
    public void test_VerticalLabelUI_getPreferredSize_Accuracy() throws Exception {
        Constructor ctor = uiClazz.getConstructor(new Class[0]);
        ctor.setAccessible(true);
        Object inst = ctor.newInstance(new Object[0]);

        Method method = uiClazz.getMethod("getPreferredSize", JComponent.class);
        method.setAccessible(true);

        JVerticalLabel label = new JVerticalLabel();
        label.setSize(new Dimension(100, 200));

        method.invoke(inst, label);
    }

    /**
     * Test <code>VerticalLabelUI#paint(Graphics g, JComponent component)</code> method.<br>
     * The g is null, so IllegalArgumentException will be thrown.
     *
     * @throws Exception throw exception to junit.
     */
    public void test_VerticalLabelUI_paint_NullGraphics() throws Exception {
        Constructor ctor = uiClazz.getConstructor(new Class[0]);
        ctor.setAccessible(true);
        Object inst = ctor.newInstance(new Object[0]);

        Method method = uiClazz.getMethod("paint", Graphics.class, JComponent.class);
        method.setAccessible(true);

        try {
            method.invoke(inst, null, new JVerticalLabel());
            fail("InvocationTargetException should be thrown.");
        } catch (InvocationTargetException e) {
            if (e.getCause() instanceof IllegalArgumentException) {
                System.out.println(e.getCause().getMessage());
            } else {
                fail("Inner exception should be IllegalArgumentException");
            }
        }
    }

    /**
     * Test <code>VerticalLabelUI#paint(Graphics g, JComponent component)</code> method.<br>
     * The component is null, so IllegalArgumentException will be thrown.
     *
     * @throws Exception throw exception to junit.
     */
    public void test_VerticalLabelUI_paint_NullJComponent() throws Exception {
        Constructor ctor = uiClazz.getConstructor(new Class[0]);
        ctor.setAccessible(true);
        Object inst = ctor.newInstance(new Object[0]);

        Method method = uiClazz.getMethod("paint", Graphics.class, JComponent.class);
        method.setAccessible(true);

        JFrame frame = new JFrame();
        frame.setVisible(true);

        try {
            method.invoke(inst, frame.getGraphics(), null);
            fail("InvocationTargetException should be thrown.");
        } catch (InvocationTargetException e) {
            if (e.getCause() instanceof IllegalArgumentException) {
                System.out.println(e.getCause().getMessage());
            } else {
                fail("Inner exception should be IllegalArgumentException");
            }
        } finally {
            frame.dispose();
        }
    }

    /**
     * Test <code>VerticalLabelUI#paint(Graphics g, JComponent component)</code> method.<br>
     * The component is not a <code>JVerticalLabel</code>, so IllegalArgumentException will be thrown.
     *
     * @throws Exception throw exception to junit.
     */
    public void test_VerticalLabelUI_paint_BadType() throws Exception {
        Constructor ctor = uiClazz.getConstructor(new Class[0]);
        ctor.setAccessible(true);
        Object inst = ctor.newInstance(new Object[0]);

        Method method = uiClazz.getMethod("paint", Graphics.class, JComponent.class);
        method.setAccessible(true);

        JFrame frame = new JFrame();
        frame.setVisible(true);

        try {
            method.invoke(inst, frame.getGraphics(), new JLabel());
            fail("InvocationTargetException should be thrown.");
        } catch (InvocationTargetException e) {
            if (e.getCause() instanceof IllegalArgumentException) {
                System.out.println(e.getCause().getMessage());
            } else {
                fail("Inner exception should be IllegalArgumentException");
            }
        } finally {
            frame.dispose();
        }
    }

    /**
     * Test <code>VerticalLabelUI#paint(Graphics g, JComponent component)</code> method.<br>
     * No icon set.
     *
     * @throws Exception throw exception to junit.
     */
    public void test_VerticalLabelUI_paint_Accuracy_1() throws Exception {
        JVerticalLabel label = new JVerticalLabel("JVerticalLabel", SwingConstants.LEFT, false);

        Container c = new Container();
        c.setLayout(new BorderLayout());
        c.add(label, BorderLayout.CENTER);

        JFrame frame = new JFrame();
        frame.setSize(new Dimension(100, 200));
        frame.setContentPane(c);
        frame.setVisible(true);

        Thread.sleep(100);
        frame.dispose();
    }

    /**
     * Test <code>VerticalLabelUI#paint(Graphics g, JComponent component)</code> method.<br>
     * The label is disabled.
     *
     * @throws Exception throw exception to junit.
     */
    public void test_VerticalLabelUI_paint_Accuracy_2() throws Exception {
        JVerticalLabel label = new JVerticalLabel("JVerticalLabel", icon, SwingConstants.LEFT, true);
        label.setEnabled(false);

        Container c = new Container();
        c.setLayout(new BorderLayout());
        c.add(label, BorderLayout.CENTER);

        JFrame frame = new JFrame();
        frame.setSize(new Dimension(100, 200));
        frame.setContentPane(c);
        frame.setVisible(true);

        Thread.sleep(100);
        frame.dispose();
    }

    /**
     * Test <code>VerticalLabelUI#paint(Graphics g, JComponent component)</code> method.<br>
     * No icon and text set.
     *
     * @throws Exception throw exception to junit.
     */
    public void test_VerticalLabelUI_paint_Accuracy_3() throws Exception {
        JVerticalLabel label = new JVerticalLabel(null, null, SwingConstants.LEFT, true);

        Container c = new Container();
        c.setLayout(new BorderLayout());
        c.add(label, BorderLayout.CENTER);

        JFrame frame = new JFrame();
        frame.setSize(new Dimension(100, 200));
        frame.setContentPane(c);
        frame.setVisible(true);

        Thread.sleep(100);
        frame.dispose();
    }
}
