/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 *
 * HTMLDocumentationEditorToolBarTest.java
 */
package com.topcoder.gui.panels.documentation.plugins.html;

import com.topcoder.configuration.ConfigurationObject;

import com.topcoder.gui.panels.documentation.plugins.html.HTMLDocumentationEditorToolBar.RedoAction;
import com.topcoder.gui.panels.documentation.plugins.html.HTMLDocumentationEditorToolBar.UndoAction;
import com.topcoder.gui.panels.documentation.plugins.html.toolbars.DefaultHTMLDocumentationEditorToolBar;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JToggleButton;
import javax.swing.text.DefaultEditorKit.CopyAction;
import javax.swing.text.DefaultEditorKit.CutAction;
import javax.swing.text.DefaultEditorKit.PasteAction;
import javax.swing.text.StyledEditorKit;
import javax.swing.text.StyledEditorKit.BoldAction;
import javax.swing.text.StyledEditorKit.ItalicAction;
import javax.swing.text.StyledEditorKit.UnderlineAction;


/**
 * <p>Unit tests for <code>HTMLDocumentationEditorToolBar</code> class.</p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class HTMLDocumentationEditorToolBarTest extends TestCase {
    /**
     * <p>Default namespace for configuration file.</p>
     */
    private static final String DEFAULT_NS = TestHelper.DEFAULT_NS;

    /**
     * <p>Returns the test suite of this class.</p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(HTMLDocumentationEditorToolBarTest.class);
    }

    /**
     * <p>Accuracy test for constructor <code>HTMLDocumentationEditorToolBar(conifg,editor)</code>.</p>
     *  <p>Verify that the instance can be created successfully.</p>
     *  <p>font size is ascending.</p>
     *
     * @throws Exception to JUnit
     */
    public void testCtorAccuracy1() throws Exception {
        ConfigurationObject config = TestHelper.getToolBarConfig(DEFAULT_NS);
        HTMLDocumentationEditor editor = new HTMLDocumentationEditor(DEFAULT_NS);

        HTMLDocumentationEditorToolBar instance = new DefaultHTMLDocumentationEditorToolBar(config, editor);
        assertNotNull("Unable to create HTMLDocumentationEditorToolBar instance.", instance);
        assertTrue("Should be instance of HTMLDocumentationEditorToolBar.",
            instance instanceof HTMLDocumentationEditorToolBar);

        JToggleButton button1 = (JToggleButton) instance.getComponent(0);
        assertTrue("button is instance of JToggleButton.", button1 instanceof JToggleButton);
        assertEquals("tool tip text should be the same.", "This is my cut tool tip.", button1.getToolTipText());
        assertEquals("command action should be the same.", CutAction.class, button1.getAction().getClass());

        JToggleButton button2 = (JToggleButton) instance.getComponent(1);
        assertTrue("button is instance of JToggleButton.", button2 instanceof JToggleButton);
        assertEquals("tool tip text should be the same.", "This is my copy tool tip.", button2.getToolTipText());
        assertEquals("command action should be the same.", CopyAction.class, button2.getAction().getClass());

        JToggleButton button3 = (JToggleButton) instance.getComponent(2);
        assertTrue("button is instance of JToggleButton.", button3 instanceof JToggleButton);
        assertEquals("tool tip text should be the same.", "This is my paste tool tip.", button3.getToolTipText());
        assertEquals("command action should be the same.", PasteAction.class, button3.getAction().getClass());

        JToggleButton button4 = (JToggleButton) instance.getComponent(3);
        assertTrue("button is instance of JToggleButton.", button4 instanceof JToggleButton);
        assertEquals("tool tip text should be the same.", "This is my undo tool tip.", button4.getToolTipText());
        assertEquals("command action should be the same.", UndoAction.class, button4.getAction().getClass());

        JToggleButton button5 = (JToggleButton) instance.getComponent(4);
        assertTrue("button is instance of JToggleButton.", button5 instanceof JToggleButton);
        assertEquals("tool tip text should be the same.", "This is my redo tool tip.", button5.getToolTipText());
        assertEquals("command action should be the same.", RedoAction.class, button5.getAction().getClass());

        JToggleButton button6 = (JToggleButton) instance.getComponent(5);
        assertTrue("button is instance of JToggleButton.", button6 instanceof JToggleButton);
        assertEquals("tool tip text should be the same.", "This is my bold tool tip.", button6.getToolTipText());
        assertEquals("command action should be the same.", BoldAction.class, button6.getAction().getClass());

        JToggleButton button7 = (JToggleButton) instance.getComponent(6);
        assertTrue("button is instance of JToggleButton.", button7 instanceof JToggleButton);
        assertEquals("tool tip text should be the same.", "This is my italic tool tip.", button7.getToolTipText());
        assertEquals("command action should be the same.", ItalicAction.class, button7.getAction().getClass());

        JToggleButton button8 = (JToggleButton) instance.getComponent(7);
        assertTrue("button is instance of JToggleButton.", button8 instanceof JToggleButton);
        assertEquals("tool tip text should be the same.", "This is my underline tool tip.", button8.getToolTipText());
        assertEquals("command action should be the same.", UnderlineAction.class, button8.getAction().getClass());
    }

    /**
     * <p>Accuracy test for constructor <code>HTMLDocumentationEditorToolBar(conifg,editor)</code>.</p>
     *  <p>Verify that the instance can be created successfully.</p>
     *  <p>font size is descending.</p>
     *
     * @throws Exception to JUnit
     */
    public void testCtorAccuracy2() throws Exception {
        ConfigurationObject config = TestHelper.getToolBarConfig("valid2");
        HTMLDocumentationEditor editor = new HTMLDocumentationEditor("valid2");

        HTMLDocumentationEditorToolBar instance = new DefaultHTMLDocumentationEditorToolBar(config, editor);
        assertNotNull("Unable to create HTMLDocumentationEditorToolBar instance.", instance);
        assertTrue("Should be instance of HTMLDocumentationEditorToolBar.",
            instance instanceof HTMLDocumentationEditorToolBar);

        JToggleButton button1 = (JToggleButton) instance.getComponent(0);
        assertTrue("button is instance of JToggleButton.", button1 instanceof JToggleButton);
        assertEquals("tool tip text should be the same.", "This is my cut tool tip.", button1.getToolTipText());
        assertEquals("command action should be the same.", CutAction.class, button1.getAction().getClass());

        JToggleButton button2 = (JToggleButton) instance.getComponent(1);
        assertTrue("button is instance of JToggleButton.", button2 instanceof JToggleButton);
        assertEquals("tool tip text should be the same.", "This is my copy tool tip.", button2.getToolTipText());
        assertEquals("command action should be the same.", CopyAction.class, button2.getAction().getClass());

        JToggleButton button3 = (JToggleButton) instance.getComponent(2);
        assertTrue("button is instance of JToggleButton.", button3 instanceof JToggleButton);
        assertEquals("tool tip text should be the same.", "This is my paste tool tip.", button3.getToolTipText());
        assertEquals("command action should be the same.", PasteAction.class, button3.getAction().getClass());

        JToggleButton button4 = (JToggleButton) instance.getComponent(3);
        assertTrue("button is instance of JToggleButton.", button4 instanceof JToggleButton);
        assertEquals("tool tip text should be the same.", "This is my undo tool tip.", button4.getToolTipText());
        assertEquals("command action should be the same.", UndoAction.class, button4.getAction().getClass());

        JToggleButton button5 = (JToggleButton) instance.getComponent(4);
        assertTrue("button is instance of JToggleButton.", button5 instanceof JToggleButton);
        assertEquals("tool tip text should be the same.", "This is my redo tool tip.", button5.getToolTipText());
        assertEquals("command action should be the same.", RedoAction.class, button5.getAction().getClass());

        JToggleButton button6 = (JToggleButton) instance.getComponent(5);
        assertTrue("button is instance of JToggleButton.", button6 instanceof JToggleButton);
        assertEquals("tool tip text should be the same.", "This is my bold tool tip.", button6.getToolTipText());
        assertEquals("command action should be the same.", BoldAction.class, button6.getAction().getClass());

        JToggleButton button7 = (JToggleButton) instance.getComponent(6);
        assertTrue("button is instance of JToggleButton.", button7 instanceof JToggleButton);
        assertEquals("tool tip text should be the same.", "This is my italic tool tip.", button7.getToolTipText());
        assertEquals("command action should be the same.", ItalicAction.class, button7.getAction().getClass());

        JToggleButton button8 = (JToggleButton) instance.getComponent(7);
        assertTrue("button is instance of JToggleButton.", button8 instanceof JToggleButton);
        assertEquals("tool tip text should be the same.", "This is my underline tool tip.", button8.getToolTipText());
        assertEquals("command action should be the same.", UnderlineAction.class, button8.getAction().getClass());
    }

    /**
     * <p>Failure test for constructor <code>HTMLDocumentationEditorToolBar(conifg,editor)</code>.</p>
     *  <p>Configuration object is null, IAE should be thrown.</p>
     *
     * @throws Exception to JUnit
     */
    public void testCtorFailure1() throws Exception {
        HTMLDocumentationEditor editor = new HTMLDocumentationEditor(DEFAULT_NS);

        try {
            new DefaultHTMLDocumentationEditorToolBar(null, editor);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>Failure test for constructor <code>HTMLDocumentationEditorToolBar(conifg,editor)</code>.</p>
     *  <p>editor is null, IAE should be thrown.</p>
     *
     * @throws Exception to JUnit
     */
    public void testCtorFailure2() throws Exception {
        ConfigurationObject config = TestHelper.getToolBarConfig(DEFAULT_NS);

        try {
            new DefaultHTMLDocumentationEditorToolBar(config, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>Failure test for constructor <code>HTMLDocumentationEditorToolBar(conifg,editor)</code>.</p>
     *  <p>shortcut is not a character, HTMLDocumentationEditorException should be thrown.</p>
     *
     * @throws Exception to JUnit
     */
    public void testCtorFailure3() throws Exception {
        ConfigurationObject config = TestHelper.getToolBarConfig("invalid1");
        HTMLDocumentationEditor editor = new HTMLDocumentationEditor(DEFAULT_NS);

        try {
            new DefaultHTMLDocumentationEditorToolBar(config, editor);
            fail("HTMLDocumentationEditorException should be thrown.");
        } catch (HTMLDocumentationEditorException e) {
            //success
        }
    }

    /**
     * <p>Accuracy test for method <code>resetUndoManager</code>.</p>
     *  <p>Verify that can reset undo manager successfully.</p>
     */
    public void testResetUndoManagerAccuracy() {
        HTMLDocumentationEditorToolBar toolBar = TestHelper.genToolBar(DEFAULT_NS);
        toolBar.resetUndoManager();
    }

    /**
     * <p>Accuracy test for method <code>createToolbarButton</code>.</p>
     *  <p>Verify that can create toolBar button correctly.</p>
     *  <p>operation system is 'windows'.</p>
     *
     * @throws Exception to JUnit
     */
    public void testCreateToolbarButtonAccuracy1() throws Exception {
        HTMLDocumentationEditorToolBar instance = TestHelper.genToolBar(DEFAULT_NS);
        Method method = HTMLDocumentationEditorToolBar.class.getDeclaredMethod("createToolbarButton", Icon.class,
                Action.class, Character.class, String.class);

        method.setAccessible(true);

        Icon icon = new ImageIcon("test_files/icon.jpg");
        Action action = new StyledEditorKit.CutAction();
        System.setProperty("os.name", "windows");

        JToggleButton button = (JToggleButton) method.invoke(instance, icon, action, 'K', "tooltip");

        assertTrue("button is instance of JToggleButton.", button instanceof JToggleButton);
        assertEquals("tool tip text should be the same.", "tooltip", button.getToolTipText());
        assertEquals("command action should be the same.", CutAction.class, button.getAction().getClass());
    }

    /**
     * <p>Accuracy test for method <code>createToolbarButton</code>.</p>
     *  <p>Verify that can create toolBar button correctly.</p>
     *  <p>operation system is 'unix'.</p>
     *
     * @throws Exception to JUnit
     */
    public void testCreateToolbarButtonAccuracy2() throws Exception {
        HTMLDocumentationEditorToolBar instance = TestHelper.genToolBar(DEFAULT_NS);
        Method method = HTMLDocumentationEditorToolBar.class.getDeclaredMethod("createToolbarButton", Icon.class,
                Action.class, Character.class, String.class);

        method.setAccessible(true);

        Icon icon = new ImageIcon("test_files/icon.jpg");
        Action action = new StyledEditorKit.CutAction();
        System.setProperty("os.name", "unix");

        JToggleButton button = (JToggleButton) method.invoke(instance, icon, action, 'K', "tooltip");

        assertTrue("button is instance of JToggleButton.", button instanceof JToggleButton);
        assertEquals("tool tip text should be the same.", "tooltip", button.getToolTipText());
        assertEquals("command action should be the same.", CutAction.class, button.getAction().getClass());

        System.setProperty("os.name", "windows");
    }

    /**
     * <p>Accuracy test for method <code>createToolbarButton</code>.</p>
     *  <p>Verify that can create toolBar button correctly.</p>
     *  <p>operation system is 'linux'.</p>
     *
     * @throws Exception to JUnit
     */
    public void testCreateToolbarButtonAccuracy3() throws Exception {
        HTMLDocumentationEditorToolBar instance = TestHelper.genToolBar(DEFAULT_NS);
        Method method = HTMLDocumentationEditorToolBar.class.getDeclaredMethod("createToolbarButton", Icon.class,
                Action.class, Character.class, String.class);

        method.setAccessible(true);

        Icon icon = new ImageIcon("test_files/icon.jpg");
        Action action = new StyledEditorKit.CutAction();
        System.setProperty("os.name", "linux");

        JToggleButton button = (JToggleButton) method.invoke(instance, icon, action, 'K', "tooltip");

        assertTrue("button is instance of JToggleButton.", button instanceof JToggleButton);
        assertEquals("tool tip text should be the same.", "tooltip", button.getToolTipText());
        assertEquals("command action should be the same.", CutAction.class, button.getAction().getClass());

        System.setProperty("os.name", "windows");
    }

    /**
     * <p>Accuracy test for method <code>createToolbarButton</code>.</p>
     *  <p>Verify that can create toolBar button correctly.</p>
     *  <p>operation system is 'macintosh'.</p>
     *
     * @throws Exception to JUnit
     */
    public void testCreateToolbarButtonAccuracy4() throws Exception {
        HTMLDocumentationEditorToolBar instance = TestHelper.genToolBar(DEFAULT_NS);
        Method method = HTMLDocumentationEditorToolBar.class.getDeclaredMethod("createToolbarButton", Icon.class,
                Action.class, Character.class, String.class);

        method.setAccessible(true);

        Icon icon = new ImageIcon("test_files/icon.jpg");
        Action action = new StyledEditorKit.CutAction();
        System.setProperty("os.name", "macintosh");

        JToggleButton button = (JToggleButton) method.invoke(instance, icon, action, 'K', "tooltip");

        assertTrue("button is instance of JToggleButton.", button instanceof JToggleButton);
        assertEquals("tool tip text should be the same.", "tooltip", button.getToolTipText());
        assertEquals("command action should be the same.", CutAction.class, button.getAction().getClass());

        System.setProperty("os.name", "windows");
    }

    /**
     * <p>Accuracy test for method <code>createToolbarButton</code>.</p>
     *  <p>Verify that can create toolBar button correctly.</p>
     *  <p>operation system is other system.</p>
     *
     * @throws Exception to JUnit
     */
    public void testCreateToolbarButtonAccuracy5() throws Exception {
        HTMLDocumentationEditorToolBar instance = TestHelper.genToolBar(DEFAULT_NS);
        Method method = HTMLDocumentationEditorToolBar.class.getDeclaredMethod("createToolbarButton", Icon.class,
                Action.class, Character.class, String.class);

        method.setAccessible(true);

        Icon icon = new ImageIcon("test_files/icon.jpg");
        Action action = new StyledEditorKit.CutAction();
        System.setProperty("os.name", "other");

        JToggleButton button = (JToggleButton) method.invoke(instance, icon, action, 'K', "tooltip");

        assertTrue("button is instance of JToggleButton.", button instanceof JToggleButton);
        assertEquals("tool tip text should be the same.", "tooltip", button.getToolTipText());
        assertEquals("command action should be the same.", CutAction.class, button.getAction().getClass());

        System.setProperty("os.name", "windows");
    }

    /**
     * <p>Failure test for method <code>createToolbarButton</code>.</p>
     *  <p>icon is null, IAE should be thrown.</p>
     *
     * @throws Exception to JUnit
     */
    public void testCreateToolbarButtonFailure1() throws Exception {
        HTMLDocumentationEditorToolBar instance = TestHelper.genToolBar(DEFAULT_NS);
        Method method = HTMLDocumentationEditorToolBar.class.getDeclaredMethod("createToolbarButton", Icon.class,
                Action.class, Character.class, String.class);

        method.setAccessible(true);

        Action action = new StyledEditorKit.CutAction();

        try {
            method.invoke(instance, null, action, 'K', "tooltip");
            fail("IllegalArgumentException should be thrown.");
        } catch (InvocationTargetException e) {
            assertTrue(e.getCause() instanceof IllegalArgumentException);

            //success
        }
    }

    /**
     * <p>Failure test for method <code>createToolbarButton</code>.</p>
     *  <p>action is null, IAE should be thrown.</p>
     *
     * @throws Exception to JUnit
     */
    public void testCreateToolbarButtonFailure2() throws Exception {
        HTMLDocumentationEditorToolBar instance = TestHelper.genToolBar(DEFAULT_NS);
        Method method = HTMLDocumentationEditorToolBar.class.getDeclaredMethod("createToolbarButton", Icon.class,
                Action.class, Character.class, String.class);

        method.setAccessible(true);

        Icon icon = new ImageIcon("test_files/icon.jpg");

        try {
            method.invoke(instance, icon, null, 'K', "tooltip");
            fail("IllegalArgumentException should be thrown.");
        } catch (InvocationTargetException e) {
            assertTrue(e.getCause() instanceof IllegalArgumentException);

            //success
        }
    }

    /**
     * <p>Accuracy test for method <code>createToolbarButton</code>.</p>
     *  <p>Verify that can add toolBar button correctly.</p>
     */
    public void testAddToolBarButtonAccuracy() {
        HTMLDocumentationEditorToolBar instance = TestHelper.genToolBar(DEFAULT_NS);

        Icon icon = new ImageIcon("test_files/icon.jpg");
        Action action = new StyledEditorKit.CutAction();
        instance.addToolBarButton(icon, action, 'K', "tooltip");

        JToggleButton button = (JToggleButton) instance.getComponent(instance.getComponentCount() - 1);

        assertTrue("button is instance of JToggleButton.", button instanceof JToggleButton);
        assertEquals("tool tip text should be the same.", "tooltip", button.getToolTipText());
        assertEquals("command action should be the same.", CutAction.class, button.getAction().getClass());
    }

    /**
     * <p>Failure test for method <code>createToolbarButton</code>.</p>
     *  <p>the length of shortcut string is more than one character.</p>
     *  <p>HTMLDocumentationEditorException should be thrown.</p>
     */
    public void testAddToolBarButtonFailure() {
        HTMLDocumentationEditorToolBar instance = TestHelper.genToolBar(DEFAULT_NS);

        Icon icon = new ImageIcon("test_files/icon.jpg");
        Action action = new StyledEditorKit.CutAction();
        instance.addToolBarButton(icon, action, 'K', "tooltip");

        JToggleButton button = (JToggleButton) instance.getComponent(instance.getComponentCount() - 1);

        assertTrue("button is instance of JToggleButton.", button instanceof JToggleButton);
        assertEquals("tool tip text should be the same.", "tooltip", button.getToolTipText());
        assertEquals("command action should be the same.", CutAction.class, button.getAction().getClass());
    }
}
