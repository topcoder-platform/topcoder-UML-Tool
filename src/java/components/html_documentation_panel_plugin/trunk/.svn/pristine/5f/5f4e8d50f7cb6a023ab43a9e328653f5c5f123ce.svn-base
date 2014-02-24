/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 *
 * DefaultHTMLDocumentationEditorToolBarTest.java
 */
package com.topcoder.gui.panels.documentation.plugins.html.toolbars;

import com.topcoder.configuration.ConfigurationObject;

import com.topcoder.gui.panels.documentation.plugins.html.HTMLDocumentationEditorException;
import com.topcoder.gui.panels.documentation.plugins.html.HTMLDocumentationEditor;
import com.topcoder.gui.panels.documentation.plugins.html.TestHelper;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.awt.Component;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


/**
 * <p>Unit tests for <code>DefaultHTMLDocumentationEditorToolBar</code> class.</p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DefaultHTMLDocumentationEditorToolBarTest extends TestCase {
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
        return new TestSuite(DefaultHTMLDocumentationEditorToolBarTest.class);
    }

    /**
     * <p>Accuracy test for constructor <code>DefaultHTMLDocumentationEditorToolBar(config,editor)</code>.</p>
     *  <p>Verify that the instance can be created successfully.</p>
     *
     * @throws Exception to JUnit
     */
    public void testCtorAccuracy() throws Exception {
        ConfigurationObject config = TestHelper.getToolBarConfig(DEFAULT_NS);
        HTMLDocumentationEditor editor = new HTMLDocumentationEditor(DEFAULT_NS);
        DefaultHTMLDocumentationEditorToolBar instance = new DefaultHTMLDocumentationEditorToolBar(config, editor);

        Component comp = instance.getComponent(instance.getComponentCount() - 1);
        assertTrue("The component should be JMenuBar", comp instanceof JMenuBar);

        JMenuBar menuBar = (JMenuBar) comp;

        assertEquals("Menu name shuold be the same.", "Font Name", ((JMenu) menuBar.getComponent(0)).getText());
        assertEquals("Menu name shuold be the same.", "Font Size", ((JMenu) menuBar.getComponent(1)).getText());
        assertEquals("Menu name shuold be the same.", "Choose Color", ((JMenu) menuBar.getComponent(2)).getText());
    }

    /**
     * <p>Accuracy test for method <code>getFontSizes(config)</code>.</p>
     *  <p>Verify that can get font sizes correctly.</p>
     *  <p>font size is descending.</p>
     *
     * @throws Exception to JUnit
     */
    public void testGetFontSizesAccuracy1() throws Exception {
        ConfigurationObject config = TestHelper.getToolBarConfig(DEFAULT_NS);
        HTMLDocumentationEditor editor = new HTMLDocumentationEditor(DEFAULT_NS);
        DefaultHTMLDocumentationEditorToolBar instance = new DefaultHTMLDocumentationEditorToolBar(config, editor);

        Component comp = instance.getComponent(instance.getComponentCount() - 1);
        assertTrue("The component should be JMenuBar", comp instanceof JMenuBar);

        JMenuBar menuBar = (JMenuBar) comp;
        JMenu menu = (JMenu) menuBar.getComponent(1);
        assertEquals("The font size should be the same.", "10", ((JMenuItem) (menu.getMenuComponent(0))).getText());
        assertEquals("The font size should be the same.", "8", ((JMenuItem) (menu.getMenuComponent(1))).getText());
        assertEquals("The font size should be the same.", "2",
            ((JMenuItem) (menu.getMenuComponent(menu.getMenuComponentCount() - 1))).getText());
    }

    /**
     * <p>Accuracy test for method <code>getFontSizes(config)</code>.</p>
     *  <p>Verify that can get font sizes correctly.</p>
     *  <p>font size is ascending.</p>
     *
     * @throws Exception to JUnit
     */
    public void testGetFontSizesAccuracy2() throws Exception {
        ConfigurationObject config = TestHelper.getToolBarConfig("valid2");
        HTMLDocumentationEditor editor = new HTMLDocumentationEditor("valid2");
        DefaultHTMLDocumentationEditorToolBar instance = new DefaultHTMLDocumentationEditorToolBar(config, editor);

        Component comp = instance.getComponent(instance.getComponentCount() - 1);
        assertTrue("The component should be JMenuBar", comp instanceof JMenuBar);

        JMenuBar menuBar = (JMenuBar) comp;
        JMenu menu = (JMenu) menuBar.getComponent(1);
        assertEquals("The font size should be the same.", "1", ((JMenuItem) (menu.getMenuComponent(0))).getText());
        assertEquals("The font size should be the same.", "3", ((JMenuItem) (menu.getMenuComponent(1))).getText());
        assertEquals("The font size should be the same.", "9",
            ((JMenuItem) (menu.getMenuComponent(menu.getMenuComponentCount() - 1))).getText());
    }

    /**
     * <p>Failure test for method <code>getFontSizes(config)</code>.</p>
     *  <p>Font size configuration is missing, HTMLDocumentationEditorException should be thrown.</p>
     *
     * @throws Exception to JUnit
     */
    public void testGetFontSizesFailure1() throws Exception {
        try {
            new HTMLDocumentationEditor("invalid2");
            fail("HTMLDocumentationEditorException should be thrown.");
        } catch (HTMLDocumentationEditorException e) {
            //success
        }
    }

    /**
     * <p>Failure test for method <code>getFontSizes(config)</code>.</p>
     *  <p>Font size values length is not three, HTMLDocumentationEditorException should be thrown.</p>
     *
     * @throws Exception to JUnit
     */
    public void testGetFontSizesFailure2() throws Exception {
        try {
            new HTMLDocumentationEditor("invalid3");
            fail("HTMLDocumentationEditorException should be thrown.");
        } catch (HTMLDocumentationEditorException e) {
            //success
        }
    }

    /**
     * <p>Failure test for method <code>getFontSizes(config)</code>.</p>
     *  <p>Font size values are not integer, HTMLDocumentationEditorException should be thrown.</p>
     *
     * @throws Exception to JUnit
     */
    public void testGetFontSizesFailure3() throws Exception {
        try {
            new HTMLDocumentationEditor("invalid4");
            fail("HTMLDocumentationEditorException should be thrown.");
        } catch (HTMLDocumentationEditorException e) {
            //success
        }
    }

    /**
     * <p>Failure test for method <code>getFontSizes(config)</code>.</p>
     *  <p>start font size is not positive, HTMLDocumentationEditorException should be thrown.</p>
     *
     * @throws Exception to JUnit
     */
    public void testGetFontSizesFailure4() throws Exception {
        try {
            new HTMLDocumentationEditor("invalid5");
            fail("HTMLDocumentationEditorException should be thrown.");
        } catch (HTMLDocumentationEditorException e) {
            //success
        }
    }

    /**
     * <p>Failure test for method <code>getFontSizes(config)</code>.</p>
     *  <p>end font size is not positive, HTMLDocumentationEditorException should be thrown.</p>
     *
     * @throws Exception to JUnit
     */
    public void testGetFontSizesFailure5() throws Exception {
        try {
            new HTMLDocumentationEditor("invalid6");
            fail("HTMLDocumentationEditorException should be thrown.");
        } catch (HTMLDocumentationEditorException e) {
            //success
        }
    }

    /**
     * <p>Failure test for method <code>getFontSizes(config)</code>.</p>
     *  <p>font step is zero, HTMLDocumentationEditorException should be thrown.</p>
     *
     * @throws Exception to JUnit
     */
    public void testGetFontSizesFailure6() throws Exception {
        try {
            new HTMLDocumentationEditor("invalid7");
            fail("HTMLDocumentationEditorException should be thrown.");
        } catch (HTMLDocumentationEditorException e) {
            //success
        }
    }
}
