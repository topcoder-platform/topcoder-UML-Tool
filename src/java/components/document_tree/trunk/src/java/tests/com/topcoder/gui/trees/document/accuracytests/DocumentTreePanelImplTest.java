/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document.accuracytests;

import java.io.File;
import java.util.Iterator;

import com.topcoder.gui.trees.document.DocumentTreeViewType;
import com.topcoder.gui.trees.document.impl.DocumentTreePanelImpl;
import com.topcoder.gui.trees.document.impl.DocumentTreeTabbedPaneImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.util.config.ConfigManager;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Accuracy test for <code>DocumentTreePanelImpl</code>.
 * 
 * @author enefem21
 * @version 1.0
 * 
 * @author Chenhong
 * @version 1.1
 */
public class DocumentTreePanelImplTest extends TestCase {

    /** UMLModelManager used in the unit test. */
    private UMLModelManager umlModelManager;

    /** DocumentTreeTabbedPaneImpl used in the unit test. */
    private DocumentTreeTabbedPaneImpl documentTreeTabbedPaneImpl;

    /** ProjectConfigurationManager used in the unit test. */
    private ProjectConfigurationManager projectConfigurationManager;

    /** Unit under test. */
    private DocumentTreePanelImpl documentTreePanelImpl;

    /**
     * <p>
     * Return the suite for this unit test.
     * </p>
     * 
     * @return the suite
     */
    public static Test suite() {
        return new TestSuite(DocumentTreePanelImplTest.class);
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

        ConfigManager.getInstance().add("accuracytests" + File.separator + "IconTreeCellRenderer.xml");
        ConfigManager.getInstance().add(
            "accuracytests" + File.separator + "ProjectConfigurationManager.objectfactory.xml");
        ConfigManager.getInstance().add("accuracytests" + File.separator + "standardclassloader.xml");

        umlModelManager = new UMLModelManager();

        projectConfigurationManager = new ProjectConfigurationManager(umlModelManager);

        umlModelManager.setProjectConfigurationManager(projectConfigurationManager);

        documentTreeTabbedPaneImpl =
            new DocumentTreeTabbedPaneImpl(umlModelManager,
                "com.topcoder.gui.trees.document.impl.DocumentTreeTabbedPaneImpl");

        documentTreePanelImpl =
            new DocumentTreePanelImpl(documentTreeTabbedPaneImpl,
                "com.topcoder.gui.trees.document.impl.DocumentTreeTabbedPaneImpl");

    }

    /**
     * Tears the unit test down.
     * 
     * @throws Exception
     *             to JUnit
     */
    protected void tearDown() throws Exception {
        ConfigManager.getInstance().removeNamespace(
            "com.topcoder.gui.trees.document.impl.DocumentTreeTabbedPaneImpl");
        ConfigManager.getInstance().removeNamespace("com.topcoder.gui.trees.document.impl.objectfactory");
        ConfigManager.getInstance().removeNamespace("com.topcoder.gui.trees.document.impl.IconTreeCellRenderer");
        ConfigManager.getInstance().removeNamespace(
            "com.topcoder.uml.projectconfiguration.ProjectConfigurationManager.objectfactory");
        ConfigManager.getInstance().removeNamespace("com.topcoder.uml.standardclassloader");
        ConfigManager.getInstance().removeNamespace("classData_objectFactory");

        super.tearDown();
    }

    /**
     * Test constructor for accuracy. Condition: normal. Expect: All states are set as expected.
     * 
     * @throws Exception
     */
    public void testDocumentTreePanelImpl() throws Exception {
        assertNotNull("Creation of object is failed", new DocumentTreePanelImpl(documentTreeTabbedPaneImpl,
            "com.topcoder.gui.trees.document.impl.DocumentTreeTabbedPaneImpl"));
    }

    /**
     * Test constructor for accuracy. Condition: normal. Expect: returned value is as expected.
     */
    public void testGetParent() {
        assertEquals("Returned value is not as expected", documentTreeTabbedPaneImpl, documentTreePanelImpl
            .getParent());
    }

    /**
     * Test <code>getPanel</code> for accuracy. Condition: normal. Expect: returned value is as expected.
     */
    public void testGetPanel() {
        assertNotNull("Returned value is not as expected", documentTreePanelImpl.getPanel());
    }

    /**
     * Test <code>getCurrentView</code> and <code>setCurrentView</code> for accuracy. Condition: normal.
     * Expect: returned value is as expected.
     */
    public void testGetCurrentView() {
        documentTreePanelImpl.setCurrentView(DocumentTreeViewType.DIAGRAM_CENTRIC);

        assertEquals("Returned value is not as expected", DocumentTreeViewType.DIAGRAM_CENTRIC,
            documentTreePanelImpl.getCurrentView().getViewType());
    }

    /**
     * Test <code>getAllViews</code> for accuracy. Condition: normal. Expect: returned value is as expected.
     */
    public void testGetAllViews() {
        assertEquals("Returned value is not as expected", 3, documentTreePanelImpl.getAllViews().length);
    }

}
