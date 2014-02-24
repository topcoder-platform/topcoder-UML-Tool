/*
 * Copyright (C) 2008 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation.plugins.html.failuretests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.configuration.ConfigurationObject;
import com.topcoder.gui.panels.documentation.plugins.html.HTMLDocumentationEditorException;
import com.topcoder.gui.panels.documentation.plugins.html.HTMLDocumentationEditor;
import com.topcoder.gui.panels.documentation.plugins.html.toolbars.DefaultHTMLDocumentationEditorToolBar;

/**
 * <p>
 * FailureTest for DefaultHTMLDocumentationEditorToolBar class.
 * </p>
 * @author peony
 * @version 1.0
 */
public class DefaultHTMLDocumentationEditorToolBarFailureTest extends TestCase {
    /** Provide the config for toolbar. */
    private ConfigurationObject toolbarConfig;

    /** Provide the config for editor. */
    private ConfigurationObject editorConfig;

    /** Create the editor for testing. */
    private HTMLDocumentationEditor editor;

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(DefaultHTMLDocumentationEditorToolBarFailureTest.class);
    }

    /**
     * <p>
     * Sets up the environment for the TestCase.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void setUp() throws Exception {
        toolbarConfig = FailureTestHelper.getToolBarConfig();
        editorConfig = FailureTestHelper.getEditorConfig();
        editor = new HTMLDocumentationEditor(editorConfig);
    }

    /**
     * <p>
     * Failure test of
     * <code>DefaultHTMLDocumentationEditorToolBar(ConfigurationObject config, HTMLDocumentationEditor editor)</code>
     * constructor.
     * </p>
     * <p>
     * Test with null config.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testDefaultHTMLDocumentationEditorToolBarFailure_IAE1() throws Exception {
        try {
            new DefaultHTMLDocumentationEditorToolBar(null, editor);
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
     * Test with null editor.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testDefaultHTMLDocumentationEditorToolBarFailure_IAE2() throws Exception {
        try {
            new DefaultHTMLDocumentationEditorToolBar(toolbarConfig, null);
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
            new DefaultHTMLDocumentationEditorToolBar(toolbarConfig, editor);
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
            new DefaultHTMLDocumentationEditorToolBar(toolbarConfig, editor);
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
            new DefaultHTMLDocumentationEditorToolBar(toolbarConfig, editor);
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
        toolbarConfig.setPropertyValues("fontSizeConfig", new String[] {"1", "invalid", "2"});
        try {
            new DefaultHTMLDocumentationEditorToolBar(toolbarConfig, editor);
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
        toolbarConfig.setPropertyValues("fontSizeConfig", new String[] {"2", "10", "-2"});
        try {
            new DefaultHTMLDocumentationEditorToolBar(toolbarConfig, editor);
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
        toolbarConfig.setPropertyValues("fontSizeConfig", new String[] {"10", "2", "2"});
        try {
            new DefaultHTMLDocumentationEditorToolBar(toolbarConfig, editor);
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
        toolbarConfig.setPropertyValues("fontSizeConfig", new String[] {"2", "10", "0"});
        try {
            new DefaultHTMLDocumentationEditorToolBar(toolbarConfig, editor);
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
        toolbarConfig.setPropertyValues("fontSizeConfig", new String[] {"10", "2", "0"});
        try {
            new DefaultHTMLDocumentationEditorToolBar(toolbarConfig, editor);
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
            new DefaultHTMLDocumentationEditorToolBar(toolbarConfig, editor);
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
            new DefaultHTMLDocumentationEditorToolBar(toolbarConfig, editor);
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
            new DefaultHTMLDocumentationEditorToolBar(toolbarConfig, editor);
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
            new DefaultHTMLDocumentationEditorToolBar(toolbarConfig, editor);
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
     * Invalid copy config - missing copy image.
     * </p>
     * <p>
     * Expect HTMLDocumentationEditorException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testDefaultHTMLDocumentationEditorToolBarFailure_Copy1() throws Exception {
        toolbarConfig.removeProperty("copyImage");
        try {
            new DefaultHTMLDocumentationEditorToolBar(toolbarConfig, editor);
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
     * Invalid copy config - shortcut incorrect.
     * </p>
     * <p>
     * Expect HTMLDocumentationEditorException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testDefaultHTMLDocumentationEditorToolBarFailure_Copy3() throws Exception {
        toolbarConfig.setPropertyValue("copyShortKey", "XX");
        try {
            new DefaultHTMLDocumentationEditorToolBar(toolbarConfig, editor);
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
     * Invalid copy config - shortcut incorrect.
     * </p>
     * <p>
     * Expect HTMLDocumentationEditorException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testDefaultHTMLDocumentationEditorToolBarFailure_Copy5() throws Exception {
        toolbarConfig.setPropertyValue("copyShortKey", new String[0]);
        try {
            new DefaultHTMLDocumentationEditorToolBar(toolbarConfig, editor);
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
     * Invalid paste config - missing paste image.
     * </p>
     * <p>
     * Expect HTMLDocumentationEditorException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testDefaultHTMLDocumentationEditorToolBarFailure_Paste1() throws Exception {
        toolbarConfig.removeProperty("pasteImage");
        try {
            new DefaultHTMLDocumentationEditorToolBar(toolbarConfig, editor);
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
     * Invalid paste config - shortcut incorrect.
     * </p>
     * <p>
     * Expect HTMLDocumentationEditorException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testDefaultHTMLDocumentationEditorToolBarFailure_Paste3() throws Exception {
        toolbarConfig.setPropertyValue("pasteShortKey", "XX");
        try {
            new DefaultHTMLDocumentationEditorToolBar(toolbarConfig, editor);
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
     * Invalid paste config - shortcut incorrect.
     * </p>
     * <p>
     * Expect HTMLDocumentationEditorException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testDefaultHTMLDocumentationEditorToolBarFailure_Paste5() throws Exception {
        toolbarConfig.setPropertyValue("pasteShortKey", new String[0]);
        try {
            new DefaultHTMLDocumentationEditorToolBar(toolbarConfig, editor);
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
     * Invalid undo config - missing undo image.
     * </p>
     * <p>
     * Expect HTMLDocumentationEditorException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testDefaultHTMLDocumentationEditorToolBarFailure_Undo1() throws Exception {
        toolbarConfig.removeProperty("undoImage");
        try {
            new DefaultHTMLDocumentationEditorToolBar(toolbarConfig, editor);
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
     * Invalid undo config - shortcut incorrect.
     * </p>
     * <p>
     * Expect HTMLDocumentationEditorException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testDefaultHTMLDocumentationEditorToolBarFailure_Undo3() throws Exception {
        toolbarConfig.setPropertyValue("undoShortKey", "XX");
        try {
            new DefaultHTMLDocumentationEditorToolBar(toolbarConfig, editor);
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
     * Invalid undo config - shortcut incorrect.
     * </p>
     * <p>
     * Expect HTMLDocumentationEditorException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testDefaultHTMLDocumentationEditorToolBarFailure_Undo5() throws Exception {
        toolbarConfig.setPropertyValue("undoShortKey", new String[0]);
        try {
            new DefaultHTMLDocumentationEditorToolBar(toolbarConfig, editor);
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
     * Invalid redo config - missing redo image.
     * </p>
     * <p>
     * Expect HTMLDocumentationEditorException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testDefaultHTMLDocumentationEditorToolBarFailure_Redo1() throws Exception {
        toolbarConfig.removeProperty("redoImage");
        try {
            new DefaultHTMLDocumentationEditorToolBar(toolbarConfig, editor);
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
     * Invalid redo config - shortcut incorrect.
     * </p>
     * <p>
     * Expect HTMLDocumentationEditorException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testDefaultHTMLDocumentationEditorToolBarFailure_Redo3() throws Exception {
        toolbarConfig.setPropertyValue("redoShortKey", "XX");
        try {
            new DefaultHTMLDocumentationEditorToolBar(toolbarConfig, editor);
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
     * Invalid redo config - shortcut incorrect.
     * </p>
     * <p>
     * Expect HTMLDocumentationEditorException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testDefaultHTMLDocumentationEditorToolBarFailure_Redo5() throws Exception {
        toolbarConfig.setPropertyValue("redoShortKey", new String[0]);
        try {
            new DefaultHTMLDocumentationEditorToolBar(toolbarConfig, editor);
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
     * Invalid bold config - missing bold image.
     * </p>
     * <p>
     * Expect HTMLDocumentationEditorException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testDefaultHTMLDocumentationEditorToolBarFailure_Bold1() throws Exception {
        toolbarConfig.removeProperty("boldImage");
        try {
            new DefaultHTMLDocumentationEditorToolBar(toolbarConfig, editor);
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
     * Invalid bold config - shortcut incorrect.
     * </p>
     * <p>
     * Expect HTMLDocumentationEditorException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testDefaultHTMLDocumentationEditorToolBarFailure_Bold3() throws Exception {
        toolbarConfig.setPropertyValue("boldShortKey", "XX");
        try {
            new DefaultHTMLDocumentationEditorToolBar(toolbarConfig, editor);
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
     * Invalid bold config - shortcut incorrect.
     * </p>
     * <p>
     * Expect HTMLDocumentationEditorException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testDefaultHTMLDocumentationEditorToolBarFailure_Bold5() throws Exception {
        toolbarConfig.setPropertyValue("boldShortKey", new String[0]);
        try {
            new DefaultHTMLDocumentationEditorToolBar(toolbarConfig, editor);
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
     * Invalid italic config - missing italic image.
     * </p>
     * <p>
     * Expect HTMLDocumentationEditorException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testDefaultHTMLDocumentationEditorToolBarFailure_Italic1() throws Exception {
        toolbarConfig.removeProperty("italicImage");
        try {
            new DefaultHTMLDocumentationEditorToolBar(toolbarConfig, editor);
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
     * Invalid italic config - shortcut incorrect.
     * </p>
     * <p>
     * Expect HTMLDocumentationEditorException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testDefaultHTMLDocumentationEditorToolBarFailure_Italic3() throws Exception {
        toolbarConfig.setPropertyValue("italicShortKey", "XX");
        try {
            new DefaultHTMLDocumentationEditorToolBar(toolbarConfig, editor);
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
     * Invalid italic config - shortcut incorrect.
     * </p>
     * <p>
     * Expect HTMLDocumentationEditorException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testDefaultHTMLDocumentationEditorToolBarFailure_Italic5() throws Exception {
        toolbarConfig.setPropertyValue("italicShortKey", new String[0]);
        try {
            new DefaultHTMLDocumentationEditorToolBar(toolbarConfig, editor);
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
     * Invalid underline config - missing underline image.
     * </p>
     * <p>
     * Expect HTMLDocumentationEditorException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testDefaultHTMLDocumentationEditorToolBarFailure_Underline1() throws Exception {
        toolbarConfig.removeProperty("underlineImage");
        try {
            new DefaultHTMLDocumentationEditorToolBar(toolbarConfig, editor);
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
     * Invalid underline config - shortcut incorrect.
     * </p>
     * <p>
     * Expect HTMLDocumentationEditorException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testDefaultHTMLDocumentationEditorToolBarFailure_Underline3() throws Exception {
        toolbarConfig.setPropertyValue("underlineShortKey", "XX");
        try {
            new DefaultHTMLDocumentationEditorToolBar(toolbarConfig, editor);
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
     * Invalid underline config - shortcut incorrect.
     * </p>
     * <p>
     * Expect HTMLDocumentationEditorException.
     * </p>
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testDefaultHTMLDocumentationEditorToolBarFailure_Underline5() throws Exception {
        toolbarConfig.setPropertyValue("underlineShortKey", new String[0]);
        try {
            new DefaultHTMLDocumentationEditorToolBar(toolbarConfig, editor);
            fail("Expect HTMLDocumentationEditorException.");
        } catch (HTMLDocumentationEditorException e) {
            // expect
        }
    }

}
