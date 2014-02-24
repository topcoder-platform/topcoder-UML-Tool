/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document.accuracytests;

import java.io.File;
import java.lang.reflect.Field;
import java.util.Iterator;

import com.topcoder.gui.trees.document.DocumentTreeViewTransferHandler;
import com.topcoder.gui.trees.document.impl.DocumentTreeTabbedPaneImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.util.config.ConfigManager;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Accuracy test for <code>DocumentTreeViewTransferHandler</code>.
 * 
 * @author enefem21
 * @version 1.0
 */
public class DocumentTreeViewTransferHandlerTest extends TestCase {

    /** Unit under test. */
    private DocumentTreeViewTransferHandler documentTreeViewTransferHandler;

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
        return new TestSuite(DocumentTreeViewTransferHandlerTest.class);
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

        documentTreeViewTransferHandler = new DocumentTreeViewTransferHandler(documentTreeTabbedPaneImpl);

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
     *             to JUnit
     */
    public void testDocumentTreeViewTransferHandler() throws Exception {
        DocumentTreeViewTransferHandler documentTreeViewTransferHandler =
            new DocumentTreeViewTransferHandler(documentTreeTabbedPaneImpl);

        // check the documentTreeTabbedPane fields
        Field documentTreeTabbedPaneField =
            DocumentTreeViewTransferHandler.class.getDeclaredField("documentTreeTabbedPane");
        documentTreeTabbedPaneField.setAccessible(true);
        assertEquals("The field is not set as expected", documentTreeTabbedPaneImpl, documentTreeTabbedPaneField
            .get(documentTreeViewTransferHandler));

    }

}
