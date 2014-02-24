/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document.accuracytests;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Iterator;

import javax.swing.JTabbedPane;

import com.topcoder.gui.trees.document.DocumentTreeEventListener;
import com.topcoder.gui.trees.document.DocumentTreeNode;
import com.topcoder.gui.trees.document.DocumentTreePanel;
import com.topcoder.gui.trees.document.DocumentTreeViewType;
import com.topcoder.gui.trees.document.NameChangedEvent;
import com.topcoder.gui.trees.document.SelectionChangedEvent;
import com.topcoder.gui.trees.document.ViewChangedEvent;
import com.topcoder.gui.trees.document.impl.DocumentTreeTabbedPaneImpl;
import com.topcoder.gui.trees.document.impl.IconTreeCellRenderer;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.util.config.ConfigManager;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Accuracy test for <code>DocumentTreeTabbedPaneImpl</code>.
 * 
 * @author enefem21
 * @version 1.0
 * 
 * @author Chenhong
 * @version 1.1
 */
public class DocumentTreeTabbedPaneImplTest extends TestCase {


    /** UMLModelManager used in the unit test. */
    private UMLModelManager umlModelManager;

    /** DocumentTreeTabbedPaneImpl used in the unit test. */
    private DocumentTreeTabbedPaneImpl documentTreeTabbedPaneImpl;

    /** ProjectConfigurationManager used in the unit test. */
    private ProjectConfigurationManager projectConfigurationManager;

    /**
     * <p>
     * Return the suite for this unit test.
     * </p>
     * 
     * @return the suite
     */
    public static Test suite() {
        return new TestSuite(DocumentTreeTabbedPaneImplTest.class);
    }

    /**
     * Sets the unit test up.
     * 
     * @throws Exception
     *             to JUnit
     */
    protected void setUp() throws Exception {
        super.setUp();

        ConfigManager cm = ConfigManager.getInstance();
        for (Iterator iter = ConfigManager.getInstance().getAllNamespaces(); iter.hasNext();) {
            ConfigManager.getInstance().removeNamespace(iter.next().toString());
        }
        cm.add(new File("test_files/accuracytests/DocumentTreeTabbedPaneImpl.xml").getCanonicalPath());

        
        cm.add(new File("test_files/accuracytests/IconTreeCellRenderer.xml").getCanonicalPath());
        cm.add(new File("test_files/accuracytests/ProjectConfigurationManager.objectfactory.xml").getCanonicalPath());
        cm.add(new File("test_files/accuracytests/standardclassloader.xml").getCanonicalPath());

        umlModelManager = new UMLModelManager();

        projectConfigurationManager = new ProjectConfigurationManager(umlModelManager);

        umlModelManager.setProjectConfigurationManager(projectConfigurationManager);

        documentTreeTabbedPaneImpl =
            new DocumentTreeTabbedPaneImpl(umlModelManager,
                "com.topcoder.gui.trees.document.impl.DocumentTreeTabbedPaneImpl");

    }

    /**
     * Tears the unit test down.
     * 
     * @throws Exception
     *             to JUnit
     */
    protected void tearDown() throws Exception {
        ConfigManager cm = ConfigManager.getInstance();
        for (Iterator iter = ConfigManager.getInstance().getAllNamespaces(); iter.hasNext();) {
            ConfigManager.getInstance().removeNamespace(iter.next().toString());
        }
        super.tearDown();
    }

    /**
     * Test constructor for accuracy. Condition: normal. Expect: All states are set as expected.
     * 
     * @throws Exception
     *             to JUnit
     */
    public void testDocumentTreeTabbedPaneImpl() throws Exception {
        DocumentTreeTabbedPaneImpl documentTreeTabbedPaneImpl =
            new DocumentTreeTabbedPaneImpl(umlModelManager,
                "com.topcoder.gui.trees.document.impl.DocumentTreeTabbedPaneImpl");

        // check the namespace fields
        Field namespaceField = DocumentTreeTabbedPaneImpl.class.getDeclaredField("namespace");
        namespaceField.setAccessible(true);
        assertEquals("The field is not set as expected",
            "com.topcoder.gui.trees.document.impl.DocumentTreeTabbedPaneImpl", namespaceField
                .get(documentTreeTabbedPaneImpl));

        // check the modelManager fields
        Field modelManagerField = DocumentTreeTabbedPaneImpl.class.getDeclaredField("modelManager");
        modelManagerField.setAccessible(true);
        assertEquals("The field is not set as expected", umlModelManager, modelManagerField
            .get(documentTreeTabbedPaneImpl));

        // check the treeCellRenderer fields
        Field treeCellRendererField = DocumentTreeTabbedPaneImpl.class.getDeclaredField("treeCellRenderer");
        treeCellRendererField.setAccessible(true);
        assertTrue("The field is not set as expected",
            treeCellRendererField.get(documentTreeTabbedPaneImpl) instanceof IconTreeCellRenderer);
        
        /*
         * 1.1 add static tabs.
         * In the configuration file: DocumentTreeTabbedPaneImpl.xml.
         * The tab configuration is:
         * 
         * <p>
         *  <Property name="default_view_types">
         *        <Value>DIAGRAM_CENTRIC</Value>
         *        <Value>CLASS_CENTRIC</Value>
         *  </Property>
         * </p>
         */
        
        assertEquals("There must be 2 tabs.", 2, documentTreeTabbedPaneImpl.getTabbedPane().getTabCount());
    }

    /**
     * Test <code>getTabbedPanel</code> for accuracy. Condition: normal. Expect: returned value is as expected.
     */
    public void testGetTabbedPane() {
        assertTrue("Returned is not as expected",
            documentTreeTabbedPaneImpl.getTabbedPane() instanceof JTabbedPane);
    }

    /**
     * Test <code>getModelManager</code> for accuracy. Condition: normal. Expect: returned value is as expected.
     */
    public void testGetModelManager() {
        assertEquals("Returned value is not as expected", umlModelManager, documentTreeTabbedPaneImpl
            .getModelManager());
    }

    /**
     * Test <code>getTreeCellRenderer</code> for accuracy. Condition: normal. Expect: returned value is as
     * expected.
     */
    public void testGetTreeCellRenderer() {
        assertTrue("Returned value is not as expected",
            documentTreeTabbedPaneImpl.getTreeCellRenderer() instanceof IconTreeCellRenderer);
    }

    /**
     * Test <code>createNewPanel</code> for accuracy. Condition: normal. Expect: returned value is as expected.
     */
    public void testCreateNewPanel() {
        DocumentTreePanel panel = documentTreeTabbedPaneImpl.createNewPanel();

        assertTrue("Returned value is as expected",
            documentTreeTabbedPaneImpl.createNewPanel().getParent() == documentTreeTabbedPaneImpl);
    }

    /**
     * Test <code>getCurrentPanel</code> for accuracy. Condition: normal. Expect: returned value is as expected.
     */
    public void testGetCurrentPanel() {
        DocumentTreePanel panel = documentTreeTabbedPaneImpl.createNewPanel();
        documentTreeTabbedPaneImpl.setCurrentPanel(panel);

        assertEquals("Returned value is not as expected", panel, documentTreeTabbedPaneImpl.getCurrentPanel());
    }

    /**
     * Test <code>removePanel</code> for accuracy. Condition: normal. Expect: All states are set as expected.
     */
    public void testRemovePanel() {
        DocumentTreePanel panel = documentTreeTabbedPaneImpl.createNewPanel();

        documentTreeTabbedPaneImpl.removePanel(panel);
    }

    /**
     * Test <code>addDocumentTreeEventListener</code> for accuracy. Condition: normal. Expect: All states are set
     * as expected.
     */
    public void testAddDocumentTreeEventListener() {
        MockDocumentTreeEventListener mockDocumentTreeEventListener = new MockDocumentTreeEventListener();
        documentTreeTabbedPaneImpl.addDocumentTreeEventListener(mockDocumentTreeEventListener);

        assertEquals("Returned value is not as expected", 1, documentTreeTabbedPaneImpl
            .getAllDocumentTreeEventListeners().length);
        assertEquals("Returned value is not as expected", mockDocumentTreeEventListener,
            documentTreeTabbedPaneImpl.getAllDocumentTreeEventListeners()[0]);
    }

    /**
     * Test <code>removeDocumentTreeEventListener</code> for accuracy. Condition: normal. Expect: All states are
     * set as expected.
     */
    public void testRemoveDocumentTreeEventListener() {
        MockDocumentTreeEventListener mockDocumentTreeEventListener = new MockDocumentTreeEventListener();
        documentTreeTabbedPaneImpl.addDocumentTreeEventListener(mockDocumentTreeEventListener);
        documentTreeTabbedPaneImpl.removeDocumentTreeEventListener(mockDocumentTreeEventListener);

        assertEquals("Returned value is not as expected", 0, documentTreeTabbedPaneImpl
            .getAllDocumentTreeEventListeners().length);
    }

    /**
     * Test <code>getAllDocumentTreeEventListeners</code> for accuracy. Condition: normal. Expect: returned value
     * is as expected.
     */
    public void testGetAllDocumentTreeEventListeners() {
        assertEquals("Returned value is not as expected", 0, documentTreeTabbedPaneImpl
            .getAllDocumentTreeEventListeners().length);
    }

    /**
     * Test <code>fireSelectionChangedEvent</code> for accuracy. Condition: normal. Expect: All states is set as
     * expected.
     */
    public void testFireSelectionChangedEvent() {
        MockDocumentTreeEventListener mockDocumentTreeEventListener = new MockDocumentTreeEventListener();
        documentTreeTabbedPaneImpl.addDocumentTreeEventListener(mockDocumentTreeEventListener);

        documentTreeTabbedPaneImpl.fireSelectionChangedEvent(new SelectionChangedEvent(new DocumentTreeNode[0], new boolean[0]));
        assertEquals("Returned value is not as expected", 1, mockDocumentTreeEventListener.b);
    }

    /**
     * Test <code>fireNameChangedEvent</code> for accuracy. Condition: normal. Expect: All states is set as
     * expected.
     */
    public void testFireNameChangedEvent() {
        MockDocumentTreeEventListener mockDocumentTreeEventListener = new MockDocumentTreeEventListener();
        documentTreeTabbedPaneImpl.addDocumentTreeEventListener(mockDocumentTreeEventListener);

        documentTreeTabbedPaneImpl.fireNameChangedEvent(new NameChangedEvent(new DocumentTreeNode(
            "diagramCategory"), "test"));
        assertEquals("Returned value is not as expected", 1, mockDocumentTreeEventListener.a);
    }

    /**
     * Test <code>getCurrentViewType</code> and <code>setCurrentViewType</code> for accuracy. Condition:
     * normal. Expect: returned value is as expected.
     * @throws Exception to junit
     */
    public void testGetCurrentViewType() throws Exception {
        ConfigManager cm = ConfigManager.getInstance();
        
        cm.add(new File("test_files/accuracytests/DocumentTreeTabbedPaneImpl_old.xml").getCanonicalPath());
        
        documentTreeTabbedPaneImpl = new DocumentTreeTabbedPaneImpl(umlModelManager, "oldstyle");
        documentTreeTabbedPaneImpl.setCurrentViewType(DocumentTreeViewType.DIAGRAM_CENTRIC);

        assertEquals("Returned value is not as expected", DocumentTreeViewType.DIAGRAM_CENTRIC,
            documentTreeTabbedPaneImpl.getCurrentViewType());
    }
    

    /**
     * A mock EventListener for testing.
     *
     */
    private final class MockDocumentTreeEventListener implements DocumentTreeEventListener {
        int a = 0;

        int b = 0;

        public void treeNodeNameChanged(NameChangedEvent event) {
            a++;
        }

        public void treeNodeSelectionChanged(SelectionChangedEvent event) {
            b++;
        }

        public void treeViewChanged(ViewChangedEvent event) {
        }
    }

}
