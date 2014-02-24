/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation.plugins.html.failuretests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.configuration.ConfigurationObject;
import com.topcoder.gui.panels.documentation.DocumentationPanelConfigurationException;
import com.topcoder.gui.panels.documentation.plugins.html.HTMLDocumentationEditorException;
import com.topcoder.gui.panels.documentation.plugins.html.HTMLDocumentationEditor;

/**
 * <p>
 * FailureTest for HTMLDocumentationEditor class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class HTMLDocumentationEditorFailureTest extends TestCase {
    /** Provide the config for toolbar. */
    private ConfigurationObject toolbarConfig;

    /** Provide the config for editor. */
    private ConfigurationObject editorConfig;

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(HTMLDocumentationEditorFailureTest.class);
    }

    /**
     * <p>
     * Sets up the environment for the TestCase.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void setUp() throws Exception {
        editorConfig = FailureTestHelper.getEditorConfig();
        toolbarConfig = editorConfig.getChild("toolBarConfig");
    }

    /**
     * <p>
     * Tears down the environment for the TestCase.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void tearDown() throws Exception {
        // your code here
    }

    /**
     * <p>
     * Failure test of <code>HTMLDocumentationEditor(String namespace)</code> constructor.
     * </p>
     * <p>
     * Call null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testHTMLDocumentationEditor1_Failure_IAE() throws Exception {
        try {
            new HTMLDocumentationEditor((String) null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>HTMLDocumentationEditor(String namespace)</code> constructor.
     * </p>
     * <p>
     * config not found.
     * </p>
     * <p>
     * Expect DocumentationPanelConfigurationException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testHTMLDocumentationEditor1_Failure1() throws Exception {
        try {
            new HTMLDocumentationEditor("not found");
            fail("Expect DocumentationPanelConfigurationException.");
        } catch (DocumentationPanelConfigurationException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>HTMLDocumentationEditor(String namespace)</code> constructor.
     * </p>
     * <p>
     * Invalid config.
     * </p>
     * <p>
     * Expect HTMLDocumentationEditorException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testHTMLDocumentationEditor1_Failure2() throws Exception {
        try {
            new HTMLDocumentationEditor("failure1");
            fail("Expect HTMLDocumentationEditorException.");
        } catch (HTMLDocumentationEditorException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>HTMLDocumentationEditor(ConfigurationObject config)</code> constructor.
     * </p>
     * <p>
     * Test with null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testHTMLDocumentationEditorFailure_IAE() throws Exception {
        try {
            new HTMLDocumentationEditor((ConfigurationObject) null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>DefaultHTMLDocumentationEditorToolBar(ConfigurationObject config, HTMLDocumentationEditor editor)</code>
     * constructor.
     * </p>
     * <p>
     * Invalid font size - too long.
     * </p>
     * <p>
     * Expect HTMLDocumentationEditorException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testDefaultHTMLDocumentationEditorToolBarFailure1() throws Exception {
        toolbarConfig.setPropertyValues("fontSizeConfig", new String[] {"2", "10", "2", "2"});
        try {
            new HTMLDocumentationEditor(editorConfig);
            fail("Expect HTMLDocumentationEditorException.");
        } catch (HTMLDocumentationEditorException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>DefaultHTMLDocumentationEditorToolBar(ConfigurationObject config, HTMLDocumentationEditor editor)</code>
     * constructor.
     * </p>
     * <p>
     * Invalid font size - too short.
     * </p>
     * <p>
     * Expect HTMLDocumentationEditorException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testDefaultHTMLDocumentationEditorToolBarFailure2() throws Exception {
        toolbarConfig.setPropertyValues("fontSizeConfig", new String[] {"2", "10"});
        try {
            new HTMLDocumentationEditor(editorConfig);
            fail("Expect HTMLDocumentationEditorException.");
        } catch (HTMLDocumentationEditorException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>DefaultHTMLDocumentationEditorToolBar(ConfigurationObject config, HTMLDocumentationEditor editor)</code>
     * constructor.
     * </p>
     * <p>
     * Invalid font size - invalid type.
     * </p>
     * <p>
     * Expect HTMLDocumentationEditorException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testDefaultHTMLDocumentationEditorToolBarFailure3() throws Exception {
        toolbarConfig.setPropertyValue("fontSizeConfig", "1");
        try {
            new HTMLDocumentationEditor(editorConfig);
            fail("Expect HTMLDocumentationEditorException.");
        } catch (HTMLDocumentationEditorException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>DefaultHTMLDocumentationEditorToolBar(ConfigurationObject config, HTMLDocumentationEditor editor)</code>
     * constructor.
     * </p>
     * <p>
     * Invalid font size - unable to parse.
     * </p>
     * <p>
     * Expect HTMLDocumentationEditorException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testDefaultHTMLDocumentationEditorToolBarFailure4() throws Exception {
        toolbarConfig.setPropertyValue("fontSizeConfig", new String[] {"1", "invalid", "2"});
        try {
            new HTMLDocumentationEditor(editorConfig);
            fail("Expect HTMLDocumentationEditorException.");
        } catch (HTMLDocumentationEditorException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>DefaultHTMLDocumentationEditorToolBar(ConfigurationObject config, HTMLDocumentationEditor editor)</code>
     * constructor.
     * </p>
     * <p>
     * Invalid font size - failed to decrease.
     * </p>
     * <p>
     * Expect HTMLDocumentationEditorException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testDefaultHTMLDocumentationEditorToolBarFailure5() throws Exception {
        toolbarConfig.setPropertyValue("fontSizeConfig", new String[] {"2", "10", "-2"});
        try {
            new HTMLDocumentationEditor(editorConfig);
            fail("Expect HTMLDocumentationEditorException.");
        } catch (HTMLDocumentationEditorException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>DefaultHTMLDocumentationEditorToolBar(ConfigurationObject config, HTMLDocumentationEditor editor)</code>
     * constructor.
     * </p>
     * <p>
     * Invalid font size - failed to increase.
     * </p>
     * <p>
     * Expect HTMLDocumentationEditorException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testDefaultHTMLDocumentationEditorToolBarFailure6() throws Exception {
        toolbarConfig.setPropertyValue("fontSizeConfig", new String[] {"10", "2", "2"});
        try {
            new HTMLDocumentationEditor(editorConfig);
            fail("Expect HTMLDocumentationEditorException.");
        } catch (HTMLDocumentationEditorException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>DefaultHTMLDocumentationEditorToolBar(ConfigurationObject config, HTMLDocumentationEditor editor)</code>
     * constructor.
     * </p>
     * <p>
     * Invalid font size - zero argument.
     * </p>
     * <p>
     * Expect HTMLDocumentationEditorException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testDefaultHTMLDocumentationEditorToolBarFailure7() throws Exception {
        toolbarConfig.setPropertyValue("fontSizeConfig", new String[] {"2", "10", "0"});
        try {
            new HTMLDocumentationEditor(editorConfig);
            fail("Expect HTMLDocumentationEditorException.");
        } catch (HTMLDocumentationEditorException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>DefaultHTMLDocumentationEditorToolBar(ConfigurationObject config, HTMLDocumentationEditor editor)</code>
     * constructor.
     * </p>
     * <p>
     * Invalid font size - zero argument.
     * </p>
     * <p>
     * Expect HTMLDocumentationEditorException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testDefaultHTMLDocumentationEditorToolBarFailure8() throws Exception {
        toolbarConfig.setPropertyValue("fontSizeConfig", new String[] {"10", "2", "0"});
        try {
            new HTMLDocumentationEditor(editorConfig);
            fail("Expect HTMLDocumentationEditorException.");
        } catch (HTMLDocumentationEditorException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>DefaultHTMLDocumentationEditorToolBar(ConfigurationObject config, HTMLDocumentationEditor editor)</code>
     * constructor.
     * </p>
     * <p>
     * Invalid font size - property missing.
     * </p>
     * <p>
     * Expect HTMLDocumentationEditorException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testDefaultHTMLDocumentationEditorToolBarFailure9() throws Exception {
        toolbarConfig.removeProperty("fontSizeConfig");
        try {
            new HTMLDocumentationEditor(editorConfig);
            fail("Expect HTMLDocumentationEditorException.");
        } catch (HTMLDocumentationEditorException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>DefaultHTMLDocumentationEditorToolBar(ConfigurationObject config, HTMLDocumentationEditor editor)</code>
     * constructor.
     * </p>
     * <p>
     * Invalid cut config - missing cut image.
     * </p>
     * <p>
     * Expect HTMLDocumentationEditorException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testDefaultHTMLDocumentationEditorToolBarFailure_Cut1() throws Exception {
        toolbarConfig.removeProperty("cutImage");
        try {
            new HTMLDocumentationEditor(editorConfig);
            fail("Expect HTMLDocumentationEditorException.");
        } catch (HTMLDocumentationEditorException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>DefaultHTMLDocumentationEditorToolBar(ConfigurationObject config, HTMLDocumentationEditor editor)</code>
     * constructor.
     * </p>
     * <p>
     * Invalid cut config - shortcut incorrect.
     * </p>
     * <p>
     * Expect HTMLDocumentationEditorException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testDefaultHTMLDocumentationEditorToolBarFailure_Cut3() throws Exception {
        toolbarConfig.setPropertyValue("cutShortKey", "XX");
        try {
            new HTMLDocumentationEditor(editorConfig);
            fail("Expect HTMLDocumentationEditorException.");
        } catch (HTMLDocumentationEditorException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>DefaultHTMLDocumentationEditorToolBar(ConfigurationObject config, HTMLDocumentationEditor editor)</code>
     * constructor.
     * </p>
     * <p>
     * Invalid cut config - shortcut incorrect.
     * </p>
     * <p>
     * Expect HTMLDocumentationEditorException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testDefaultHTMLDocumentationEditorToolBarFailure_Cut5() throws Exception {
        toolbarConfig.setPropertyValue("cutShortKey", new String[0]);
        try {
            new HTMLDocumentationEditor(editorConfig);
            fail("Expect HTMLDocumentationEditorException.");
        } catch (HTMLDocumentationEditorException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>HTMLDocumentationEditor(ConfigurationObject config)</code> constructor.
     * </p>
     * <p>
     * No 'default' child.
     * </p>
     * <p>
     * Expect HTMLDocumentationEditorException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testHTMLDocumentationEditorFailure1() throws Exception {
        editorConfig.removeChild("default");
        try {
            new HTMLDocumentationEditor(editorConfig);
            fail("Expect HTMLDocumentationEditorException.");
        } catch (HTMLDocumentationEditorException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>HTMLDocumentationEditor(ConfigurationObject config)</code> constructor.
     * </p>
     * <p>
     * Invalid vsbPolicy.
     * </p>
     * <p>
     * Expect HTMLDocumentationEditorException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testHTMLDocumentationEditorFailure2() throws Exception {
        editorConfig.getChild("default").setPropertyValue("vsbPolicy", "invalid");
        try {
            new HTMLDocumentationEditor(editorConfig);
            fail("Expect HTMLDocumentationEditorException.");
        } catch (HTMLDocumentationEditorException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>HTMLDocumentationEditor(ConfigurationObject config)</code> constructor.
     * </p>
     * <p>
     * Invalid vsbPolicy.
     * </p>
     * <p>
     * Expect HTMLDocumentationEditorException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testHTMLDocumentationEditorFailure3() throws Exception {
        editorConfig.getChild("default").setPropertyValue("vsbPolicy", "23");
        try {
            new HTMLDocumentationEditor(editorConfig);
            fail("Expect HTMLDocumentationEditorException.");
        } catch (HTMLDocumentationEditorException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>HTMLDocumentationEditor(ConfigurationObject config)</code> constructor.
     * </p>
     * <p>
     * Invalid hsbPolicy.
     * </p>
     * <p>
     * Expect HTMLDocumentationEditorException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testHTMLDocumentationEditorFailure4() throws Exception {
        editorConfig.getChild("default").setPropertyValue("hsbPolicy", "invalid");
        try {
            new HTMLDocumentationEditor(editorConfig);
            fail("Expect HTMLDocumentationEditorException.");
        } catch (HTMLDocumentationEditorException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>HTMLDocumentationEditor(ConfigurationObject config)</code> constructor.
     * </p>
     * <p>
     * Invalid hsbPolicy.
     * </p>
     * <p>
     * Expect HTMLDocumentationEditorException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testHTMLDocumentationEditorFailure5() throws Exception {
        editorConfig.getChild("default").setPropertyValue("hsbPolicy", "23");
        try {
            new HTMLDocumentationEditor(editorConfig);
            fail("Expect HTMLDocumentationEditorException.");
        } catch (HTMLDocumentationEditorException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>HTMLDocumentationEditor(ConfigurationObject config)</code> constructor.
     * </p>
     * <p>
     * Invalid toolBarClass - invalid class type.
     * </p>
     * <p>
     * Expect HTMLDocumentationEditorException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testHTMLDocumentationEditorFailure6() throws Exception {
        editorConfig.getChild("default").setPropertyValue("toolBarClass", "invalid");
        try {
            new HTMLDocumentationEditor(editorConfig);
            fail("Expect HTMLDocumentationEditorException.");
        } catch (HTMLDocumentationEditorException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>HTMLDocumentationEditor(ConfigurationObject config)</code> constructor.
     * </p>
     * <p>
     * Invalid toolBarClass - invalid class type.
     * </p>
     * <p>
     * Expect HTMLDocumentationEditorException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testHTMLDocumentationEditorFailure7() throws Exception {
        editorConfig.getChild("default").setPropertyValue("toolBarClass", "java.lang.String");
        try {
            new HTMLDocumentationEditor(editorConfig);
            fail("Expect HTMLDocumentationEditorException.");
        } catch (HTMLDocumentationEditorException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>setTarget(ModelElement element)</code> method.
     * </p>
     * <p>
     * Set when element is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSetTargetFailure() throws Exception {
        HTMLDocumentationEditor editor = new HTMLDocumentationEditor(editorConfig);
        try {
            editor.setTarget(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of <code>setToolBar(HTMLDocumentationEditorToolBar toolBar)</code> method.
     * </p>
     * <p>
     * Set null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSetToolBarFailure() throws Exception {
        HTMLDocumentationEditor editor = new HTMLDocumentationEditor(editorConfig);
        try {
            editor.setToolBar(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
