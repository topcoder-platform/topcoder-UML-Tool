/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document.failuretests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.gui.trees.document.DocumentTreeConfigurationException;
import com.topcoder.gui.trees.document.DocumentTreeEventListener;
import com.topcoder.gui.trees.document.DocumentTreeNode;
import com.topcoder.gui.trees.document.DocumentTreePanel;
import com.topcoder.gui.trees.document.NameChangedEvent;
import com.topcoder.gui.trees.document.SelectionChangedEvent;
import com.topcoder.gui.trees.document.impl.DocumentTreeTabbedPaneImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * This Junit Test suite contains failure test cases for {@link DocumentTreeTabbedPaneImpl} class.
 * </p>
 * 
 * @author stylecheck
 * @version 1.0
 */
public class DocumentTreeTabbedPaneImplFailureTest extends TestCase {

    /**
     * DocumentTreeTabbedPaneImpl for testing.
     */
    private DocumentTreeTabbedPaneImpl documentTreeTabbedPaneImpl = null;

    /**
     * <p>
     * Sets up the environment.
     * </p>
     * 
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void setUp() throws Exception {
        FailureTestHelper.setUp();
        documentTreeTabbedPaneImpl = new DocumentTreeTabbedPaneImpl(UMLModelManager.getInstance(),
            FailureTestHelper.NAMESPACE);
    }

    /**
     * <p>
     * Tears down the environment.
     * </p>
     * 
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void tearDown() throws Exception {
        FailureTestHelper.tearDown();
        documentTreeTabbedPaneImpl = null;
    }

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     * 
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(DocumentTreeTabbedPaneImplFailureTest.class);
    }

    /**
     * <p>
     * Tests the {@link DocumentTreeTabbedPaneImpl#DocumentTreeTabbedPaneImpl(UMLModelManager, String)}
     * constructor with modelManager as null value.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureDocumentTreeTabbedPaneImpl() throws Exception {
        try {
            new DocumentTreeTabbedPaneImpl(null, FailureTestHelper.NAMESPACE);
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the {@link DocumentTreeTabbedPaneImpl#DocumentTreeTabbedPaneImpl(UMLModelManager, String)}
     * constructor with namespace as null value.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureDocumentTreeTabbedPaneImpl1() throws Exception {
        try {
            new DocumentTreeTabbedPaneImpl(UMLModelManager.getInstance(), null);
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the {@link DocumentTreeTabbedPaneImpl#DocumentTreeTabbedPaneImpl(UMLModelManager, String)}
     * constructor with namespace as Empty string.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureDocumentTreeTabbedPaneImpl2() throws Exception {
        try {
            new DocumentTreeTabbedPaneImpl(UMLModelManager.getInstance(), "");
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the {@link DocumentTreeTabbedPaneImpl#DocumentTreeTabbedPaneImpl(UMLModelManager, String)}
     * constructor with namespace as Empty string with only spaces.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureDocumentTreeTabbedPaneImpl3() throws Exception {
        try {
            new DocumentTreeTabbedPaneImpl(UMLModelManager.getInstance(), "  ");
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the {@link DocumentTreeTabbedPaneImpl#DocumentTreeTabbedPaneImpl(UMLModelManager, String)}
     * constructor.
     * </p>
     * <p>
     * Unknown Namespace.
     * </p>
     * <p>
     * {@link DocumentTreeConfigurationException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureDocumentTreeTabbedPaneImpl4() throws Exception {
        try {
            new DocumentTreeTabbedPaneImpl(UMLModelManager.getInstance(), "Unknown");
            fail("DocumentTreeConfigurationException Expected.");
        } catch (DocumentTreeConfigurationException e) {
            // As expected.
        }
    }

    /**
     * <p>
     * Tests the {@link DocumentTreeTabbedPaneImpl#DocumentTreeTabbedPaneImpl(UMLModelManager, String)}
     * constructor.
     * </p>
     * <p>
     * config_manager_specification_factory_namespace property Missing.
     * </p>
     * <p>
     * {@link DocumentTreeConfigurationException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureDocumentTreeTabbedPaneImpl41() throws Exception {
        try {
            FailureTestHelper.reSetup("Config_config_manager_specification_factory_namespaceMissing.xml");
            new DocumentTreeTabbedPaneImpl(UMLModelManager.getInstance(), FailureTestHelper.NAMESPACE);
            fail("DocumentTreeConfigurationException Expected.");
        } catch (DocumentTreeConfigurationException e) {
            // As expected.
        }
    }

    /**
     * <p>
     * Tests the {@link DocumentTreeTabbedPaneImpl#DocumentTreeTabbedPaneImpl(UMLModelManager, String)}
     * constructor.
     * </p>
     * <p>
     * config_manager_specification_factory_namespace property empty.
     * </p>
     * <p>
     * {@link DocumentTreeConfigurationException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureDocumentTreeTabbedPaneImpl412() throws Exception {
        try {
            FailureTestHelper.reSetup("Config_config_manager_specification_factory_namespaceEmpty.xml");
            new DocumentTreeTabbedPaneImpl(UMLModelManager.getInstance(), FailureTestHelper.NAMESPACE);
            fail("DocumentTreeConfigurationException Expected.");
        } catch (DocumentTreeConfigurationException e) {
            // As expected.
        }
    }

    /**
     * <p>
     * Tests the {@link DocumentTreeTabbedPaneImpl#DocumentTreeTabbedPaneImpl(UMLModelManager, String)}
     * constructor.
     * </p>
     * <p>
     * tree_cell_renderer property missing.
     * </p>
     * <p>
     * {@link DocumentTreeConfigurationException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureDocumentTreeTabbedPaneImpl413() throws Exception {
        try {
            FailureTestHelper.reSetup("Config_tree_cell_renderer_missing.xml");
            new DocumentTreeTabbedPaneImpl(UMLModelManager.getInstance(), FailureTestHelper.NAMESPACE);
            fail("DocumentTreeConfigurationException Expected.");
        } catch (DocumentTreeConfigurationException e) {
            // As expected.
        }
    }

    /**
     * <p>
     * Tests the {@link DocumentTreeTabbedPaneImpl#DocumentTreeTabbedPaneImpl(UMLModelManager, String)}
     * constructor.
     * </p>
     * <p>
     * tree_cell_renderer property empty.
     * </p>
     * <p>
     * {@link DocumentTreeConfigurationException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureDocumentTreeTabbedPaneImpl414() throws Exception {
        try {
            FailureTestHelper.reSetup("Config_tree_cell_rendererEmpty.xml");
            new DocumentTreeTabbedPaneImpl(UMLModelManager.getInstance(), FailureTestHelper.NAMESPACE);
            fail("DocumentTreeConfigurationException Expected.");
        } catch (DocumentTreeConfigurationException e) {
            // As expected.
        }
    }

    /**
     * <p>
     * Tests the {@link DocumentTreeTabbedPaneImpl#DocumentTreeTabbedPaneImpl(UMLModelManager, String)}
     * constructor.
     * </p>
     * <p>
     * Object factory itself missing.
     * </p>
     * <p>
     * {@link DocumentTreeConfigurationException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureDocumentTreeTabbedPaneImpl415() throws Exception {
        try {
            FailureTestHelper.reSetup("Config_objectFactoryMissing.xml");
            new DocumentTreeTabbedPaneImpl(UMLModelManager.getInstance(), FailureTestHelper.NAMESPACE);
            fail("DocumentTreeConfigurationException Expected.");
        } catch (DocumentTreeConfigurationException e) {
            // As expected.
        }
    }

    /**
     * <p>
     * Tests the {@link DocumentTreeTabbedPaneImpl#DocumentTreeTabbedPaneImpl(UMLModelManager, String)}
     * constructor.
     * </p>
     * <p>
     * Cell render missing.
     * </p>
     * <p>
     * {@link DocumentTreeConfigurationException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureDocumentTreeTabbedPaneImpl416() throws Exception {
        try {
            FailureTestHelper.reSetup("Config_cellRenderMissing.xml");
            new DocumentTreeTabbedPaneImpl(UMLModelManager.getInstance(), FailureTestHelper.NAMESPACE);
            fail("DocumentTreeConfigurationException Expected.");
        } catch (DocumentTreeConfigurationException e) {
            // As expected.
        }
    }

    /**
     * <p>
     * Tests the {@link DocumentTreeTabbedPaneImpl#DocumentTreeTabbedPaneImpl(UMLModelManager, String)}
     * constructor.
     * </p>
     * <p>
     * Cell render value is wrong.
     * </p>
     * <p>
     * {@link DocumentTreeConfigurationException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureDocumentTreeTabbedPaneImpl417() throws Exception {
        try {
            FailureTestHelper.reSetup("Config_cellRenderValueWrong.xml");
            new DocumentTreeTabbedPaneImpl(UMLModelManager.getInstance(), FailureTestHelper.NAMESPACE);
            fail("DocumentTreeConfigurationException Expected.");
        } catch (DocumentTreeConfigurationException e) {
            // As expected.
        }
    }

    /**
     * <p>
     * Tests the {@link DocumentTreeTabbedPaneImpl#DocumentTreeTabbedPaneImpl(UMLModelManager, String)}
     * constructor.
     * </p>
     * <p>
     * Cell render class wrong.
     * </p>
     * <p>
     * {@link DocumentTreeConfigurationException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureDocumentTreeTabbedPaneImpl418() throws Exception {
        try {
            FailureTestHelper.reSetup("Config_cellRenderWrongClass.xml");
            new DocumentTreeTabbedPaneImpl(UMLModelManager.getInstance(), FailureTestHelper.NAMESPACE);
            fail("DocumentTreeConfigurationException Expected.");
        } catch (DocumentTreeConfigurationException e) {
            // As expected.
        }
    }

    /**
     * <p>
     * Tests the {@link DocumentTreeTabbedPaneImpl#DocumentTreeTabbedPaneImpl(UMLModelManager, String)}
     * constructor.
     * </p>
     * <p>
     * Class of the cell render has invalid input.
     * </p>
     * <p>
     * {@link DocumentTreeConfigurationException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureDocumentTreeTabbedPaneImpl419() throws Exception {
        try {
            FailureTestHelper.reSetup("Config_invalidinputCellRender.xml");
            new DocumentTreeTabbedPaneImpl(UMLModelManager.getInstance(), FailureTestHelper.NAMESPACE);
            fail("DocumentTreeConfigurationException Expected.");
        } catch (DocumentTreeConfigurationException e) {
            // As expected.
        }
    }

    /**
     * <p>
     * Tests the {@link DocumentTreeTabbedPaneImpl#setCurrentPanel(DocumentTreePanel)} method with panel
     * as null value.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailuresetCurrentPanel() throws Exception {
        try {
             documentTreeTabbedPaneImpl.setCurrentPanel(null);
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the {@link DocumentTreeTabbedPaneImpl#removePanel(DocumentTreePanel)} method with panel as
     * null value.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureremovePanel() throws Exception {
        try {
             documentTreeTabbedPaneImpl.removePanel(null);
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the
     * {@link DocumentTreeTabbedPaneImpl#addDocumentTreeEventListener(DocumentTreeEventListener)} method
     * with listener as null value.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureaddDocumentTreeEventListener() throws Exception {
        try {
             documentTreeTabbedPaneImpl.addDocumentTreeEventListener(null);
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the
     * {@link DocumentTreeTabbedPaneImpl#removeDocumentTreeEventListener(DocumentTreeEventListener)}
     * method with listener as null value.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureremoveDocumentTreeEventListener() throws Exception {
        try {
             documentTreeTabbedPaneImpl.removeDocumentTreeEventListener(null);
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the {@link DocumentTreeTabbedPaneImpl#fireSelectionChangedEvent(SelectionChangedEvent)}
     * method with event as null value.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailurefireSelectionChangedEvent() throws Exception {
        try {
             documentTreeTabbedPaneImpl.fireSelectionChangedEvent(null);
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the {@link DocumentTreeTabbedPaneImpl#fireNameChangedEvent(NameChangedEvent)} method with
     * event as null value.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailurefireNameChangedEvent() throws Exception {
        try {
             documentTreeTabbedPaneImpl.fireNameChangedEvent(null);
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the {@link DocumentTreeTabbedPaneImpl#addTreeNode(DocumentTreeNode)} method with treeNode as
     * null value.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureaddTreeNode() throws Exception {
        try {
             documentTreeTabbedPaneImpl.addTreeNode(null);
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the {@link DocumentTreeTabbedPaneImpl#updateTreeNode(DocumentTreeNode)} method with treeNode
     * as null value.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureupdateTreeNode() throws Exception {
        try {
             documentTreeTabbedPaneImpl.updateTreeNode(null);
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the {@link DocumentTreeTabbedPaneImpl#removeTreeNode(DocumentTreeNode)} method with treeNode
     * as null value.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureremoveTreeNode() throws Exception {
        try {
             documentTreeTabbedPaneImpl.removeTreeNode(null);
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the {@link DocumentTreeTabbedPaneImpl#setSelectedTreeNodes(DocumentTreeNode[])} method with
     * selectedTreeNodes as null value.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailuresetSelectedTreeNodes() throws Exception {
        try {
             documentTreeTabbedPaneImpl.setSelectedTreeNodes(null);
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the {@link DocumentTreeTabbedPaneImpl#setSelectedTreeNodes(DocumentTreeNode[])} method with
     * selectedTreeNodes contains null value.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     * 
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailuresetSelectedTreeNodes1() throws Exception {
        try {
             documentTreeTabbedPaneImpl.setSelectedTreeNodes(new DocumentTreeNode[]{null});
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }
}
