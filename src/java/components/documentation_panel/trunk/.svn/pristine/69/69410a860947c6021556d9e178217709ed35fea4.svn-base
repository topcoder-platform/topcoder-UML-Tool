/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.panels.documentation;

import java.util.List;

import javax.swing.JSplitPane;

import com.topcoder.gui.panels.documentation.event.DocumentationListener;
import com.topcoder.gui.panels.documentation.event.MockDocumentationListener;
import com.topcoder.gui.panels.documentation.event.MockTagListener;
import com.topcoder.gui.panels.documentation.event.TagListener;
import com.topcoder.gui.panels.documentation.plugins.DefaultDocumentationEditor;
import com.topcoder.gui.panels.documentation.plugins.DefaultTagEditor;
import com.topcoder.uml.model.core.MethodImpl;
import com.topcoder.uml.model.core.OperationImpl;

import junit.framework.TestCase;


/**
 * <p>
 * This test case contains accuracy tests for
 * <code>DocumentationPanel</code>.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
  */
public class DocumentationPanelTestAcc extends TestCase {

    /**
     * <p>
     * <code>DefaultDocumentationEditor</code> used in this test case.
     * </p>
     */
    private DefaultDocumentationEditor docEditor = null;

    /**
     * <p>
     * <code>DefaultTagEditor</code> used in this test case.
     * </p>
     */
    private DefaultTagEditor tagEditor = null;

    /**
     * <p>
     * <code>DocumentationPanel</code> used in the test case.
     * </p>
     */
    private DocumentationPanel dp = null;

    /**
     * <p>
     * Set up the fixure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        super.setUp();
        TestHelper.addConfig("UnitTest/docPanel.xml");
        TestHelper.addConfig("UnitTest/docEditor.xml");
        TestHelper.addConfig("UnitTest/tagEditor.xml");
        TestHelper.addConfig("UnitTest/tagOptions.xml");
        dp = new DocumentationPanel("docPanelNamespace1");
    }

    /**
     * <p>
     * Tear down the fixure.
     * </p>
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        dp = null;
        TestHelper.removeConfigManagerNS();
        super.tearDown();
    }

    /**
     * <p>
     * Test accuracy of method <code>DocumentationPanel()</code>.
     * </p>
     */
    public void testDocumentationPanel1() {
        assertNotNull("Initialized successfully", dp);
    }
    /**
     * <p>
     * Test accuracy of method <code>DocumentationPanel()</code>.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDocumentationPanel2() throws Exception {
        dp = new DocumentationPanel("docPanelNamespace2");
        assertNotNull("Initialized successfully", dp);
    }
    /**
     * <p>
     * Test accuracy of method <code>DocumentationPanel()</code>.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDocumentationPanel3() throws Exception {
        dp = new DocumentationPanel("docPanelNamespace3");
        assertNotNull("Initialized successfully", dp);
    }
    /**
     * <p>
     * Test accuracy of method <code>DocumentationPanel()</code>.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDocumentationPanel4() throws Exception {
        dp = new DocumentationPanel("docPanelNamespace4");
        assertNotNull("Initialized successfully", dp);
    }
    /**
     * <p>
     * Test accuracy of method <code>DocumentationPanel()</code>.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDocumentationPanel5() throws Exception {
        this.docEditor = new DefaultDocumentationEditor("defaultDocEditor_1");
        this.tagEditor = new DefaultTagEditor("defaultTagEditor_1");
        this.dp = new DocumentationPanel(this.docEditor, this.tagEditor);
        assertNotNull("Initialized successfully", dp);
    }

    /**
     * <p>
     * Test accuracy of method <code>DocumentationPanel()</code>.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDocumentationPanel6() throws Exception {
        this.docEditor = new DefaultDocumentationEditor("defaultDocEditor_2");
        this.tagEditor = new DefaultTagEditor("defaultTagEditor_2");
        this.dp = new DocumentationPanel(this.docEditor, this.tagEditor);
        assertNotNull("Initialized successfully", dp);
    }
    /**
     * <p>
     * Test accuracy of method <code>DocumentationPanel()</code>.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDocumentationPanel7() throws Exception {
        this.docEditor = new DefaultDocumentationEditor("defaultDocEditor_3");
        this.tagEditor = new DefaultTagEditor("defaultTagEditor_3");
        this.dp = new DocumentationPanel(this.docEditor, this.tagEditor);
        assertNotNull("Initialized successfully", dp);
    }
    /**
     * <p>
     * Test accuracy of method <code>DocumentationPanel()</code>.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testDocumentationPanel8() throws Exception {
        this.docEditor = new DefaultDocumentationEditor("defaultDocEditor_4");
        this.tagEditor = new DefaultTagEditor("defaultTagEditor_4");
        this.dp = new DocumentationPanel(this.docEditor, this.tagEditor);
        assertNotNull("Initialized successfully", dp);
    }

    /**
     * <p>
     * Get split pane contained by documentation panel.
     * </p>
     *
     * @return <code>JSplitPane</code>
     */
    private JSplitPane getSplitPane() {
        return (JSplitPane) dp.getComponent(0);
    }
    /**
     * <p>
     * Test accuracy of method <code>setTarget()</code>.
     * </p>
     *
     * <p>
     * Target is null, whole panel is hidden.
     * That is, the left component and right component are
     * set as a new blank <code>JPanel</code>.
     * </p>
     */
    public void testSetTarget1() {
        this.dp.setTarget(null);
        assertEquals(getSplitPane().getLeftComponent(), getSplitPane().getRightComponent());
    }
    /**
     * <p>
     * Test accuracy of method <code>setTarget()</code>.
     * </p>
     *
     * <p>
     * Target is an unknown type for tag options, tag editor panel is hidden.
     * That is, the left component and right component should leave same,
     * but the right component(the tag editor) should be hidden.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetTarget2() throws Exception {
        testDocumentationPanel5();
        this.dp.setTarget(new MethodImpl());
        assertEquals(getSplitPane().getLeftComponent(), this.docEditor);
        assertEquals(getSplitPane().getRightComponent(), this.tagEditor);
        assertFalse("tag editor should be hidden", this.tagEditor.isVisible());
    }
    /**
     * <p>
     * Test accuracy of method <code>setTarget()</code>.
     * </p>
     *
     * <p>
     * Target is properly set, the whole panel is shown.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testSetTarget3() throws Exception {
        testDocumentationPanel5();
        //DocumentationPanel should start with the whole panel invisible
        assertFalse("doc editor is invisible", getSplitPane().getLeftComponent().isVisible());
        assertFalse("tag editor is invisible", getSplitPane().getRightComponent().isVisible());
        this.dp.setTarget(new OperationImpl());
        //The whole panel is shown after target is properly set
        assertEquals(getSplitPane().getLeftComponent(), this.docEditor);
        assertEquals(getSplitPane().getRightComponent(), this.tagEditor);
        assertTrue("doc editor is visible", getSplitPane().getLeftComponent().isVisible());
        assertTrue("tag editor is visible", getSplitPane().getRightComponent().isVisible());
    }
    /**
     * <p>
     * Get cached divider location of documentation panel.
     * </p>
     *
     * @return divider location
     *
     * @throws Exception to JUnit
     */
    private int getDividerLocation() throws Exception {
        return (Integer) TestHelper.getField(dp, "dividerLocation");
    }
    /**
     * <p>
     * Test accuracy of method <code>showTagEditor()</code>.
     * </p>
     *
     * <p>
     * Divider location of of <code>JSplitPane</code> is set as 2
     * before hidden, it will be cached by documentation panel.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testShowTagEditor1() throws Exception {
        getSplitPane().setDividerLocation(2);
        this.dp.showTagEditor(false);
        assertFalse("tag editor should be hidden", getSplitPane().getRightComponent().isVisible());
        assertEquals(2, getDividerLocation());
    }
    /**
     * <p>
     * Test accuracy of method <code>showTagEditor()</code>.
     * </p>
     *
     * <p>
     * Divider location of of <code>JSplitPane</code> is set as 2
     * before shown. The cached divider location should be -1 after
     * shown, the actual divider location of <code>JSplitPane</code>
     * should be reset to 2 after shown.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testShowTagEditor2() throws Exception {
        getSplitPane().setDividerLocation(2);
        this.dp.showTagEditor(true);
        assertTrue("tag editor should be shown", getSplitPane().getRightComponent().isVisible());
        assertEquals(2, getSplitPane().getDividerLocation());
        assertEquals(-1, getDividerLocation());
    }
    /**
     * <p>
     * Test accuracy of method <code>showWholeEditor()</code>.
     * </p>
     *
     * <p>
     * The whole panel is shown, left component of <code>JSplitPane</code>
     * should be document editor, right component of <code>JSplitPane</code>
     * should be tag editor.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testShowWholeEditor1() throws Exception {
        testDocumentationPanel5();
        this.dp.showWholeEditor(true);
        assertEquals(getSplitPane().getLeftComponent(), this.docEditor);
        assertEquals(getSplitPane().getRightComponent(), this.tagEditor);
    }
    /**
     * <p>
     * Test accuracy of method <code>showWholeEditor()</code>.
     * </p>
     *
     * <p>
     * The whole panel is hidden, left component and right component of
     * <code>JSplitPane</code> should be set as a same blank <code>JPanel</code>.
     * </p>
     *
     * @throws Exception to JUnit
     */
    public void testShowWholeEditor2() throws Exception {
        this.dp.showWholeEditor(false);
        assertEquals(getSplitPane().getLeftComponent(), getSplitPane().getRightComponent());
    }

    /**
     * <p>
     * Assert the accuracy of document listener related methods.
     * </p>
     */
    private void assertDocumentationListeners() {
        //Attach 2 listeners
        DocumentationListener listener1 = new MockDocumentationListener();
        DocumentationListener listener2 = new MockDocumentationListener();
        this.dp.addDocumentationListener(listener1);
        this.dp.addDocumentationListener(listener2);

        //Remove null
        this.dp.removeDocumentationListener(null);
        //Remove a listener which is not attached
        this.dp.removeDocumentationListener(new MockDocumentationListener());

        List < DocumentationListener > listeners =
            this.dp.getDocumentationListeners();
        assertEquals("Size of listeners should be 2", 2, listeners.size());
        assertEquals(listener1, listeners.get(0));
        assertEquals(listener2, listeners.get(1));

        //Remove one listener
        this.dp.removeDocumentationListener(listener1);
        listeners = this.dp.getDocumentationListeners();
        assertEquals("Size of listeners should be 1", 1, listeners.size());
        assertEquals(listener2, listeners.get(0));

        //Remove another listener
        this.dp.removeDocumentationListener(listener2);
        listeners = this.dp.getDocumentationListeners();
        assertEquals("Size of listeners should be 0", 0, listeners.size());
    }
    /**
     * <p>
     * Test accuracy of method <code>addDocumentationListener()</code>.
     * </p>
     */
    public void testAddDocumentationListener() {
        assertDocumentationListeners();
    }

    /**
     * <p>
     * Test accuracy of method <code>removeDocumentationListener()</code>.
     * </p>
     */
    public void testRemoveDocumentationListener() {
        assertDocumentationListeners();
    }

    /**
     * <p>
     * Test accuracy of method <code>getDocumentationListeners()</code>.
     * </p>
     */
    public void testGetDocumentationListeners() {
        assertDocumentationListeners();
    }

    /**
     * <p>
     * Assert the accuracy of tag listener related methods.
     * </p>
     */
    private void assertTagListeners() {
        //Attach 2 listeners
        TagListener listener1 = new MockTagListener();
        TagListener listener2 = new MockTagListener();
        this.dp.addTagListener(listener1);
        this.dp.addTagListener(listener2);

        //Remove null
        this.dp.removeTagListener(null);
        //Remove listener which is not attached
        this.dp.removeTagListener(new MockTagListener());

        List < TagListener > listeners =
            this.dp.getTagListeners();
        assertEquals("Size of listeners should be 2", 2, listeners.size());
        assertEquals(listener1, listeners.get(0));
        assertEquals(listener2, listeners.get(1));

        //Remove one listener
        this.dp.removeTagListener(listener1);
        listeners = this.dp.getTagListeners();
        assertEquals("Size of listeners should be 1", 1, listeners.size());
        assertEquals(listener2, listeners.get(0));

        //Remove another listener
        this.dp.removeTagListener(listener2);
        listeners = this.dp.getTagListeners();
        assertEquals("Size of listeners should be 0", 0, listeners.size());
    }
    /**
     * <p>
     * Test accuracy of method <code>addTagListener()</code>.
     * </p>
     */
    public void testAddTagListener() {
        assertTagListeners();
    }

    /**
     * <p>
     * Test accuracy of method <code>removeTagListener()</code>.
     * </p>
     */
    public void testRemoveTagListener() {
        assertTagListeners();
    }

    /**
     * <p>
     * Test accuracy of method <code>getTagListeners()</code>.
     * </p>
     */
    public void testGetTagListeners() {
        assertTagListeners();
    }
}
