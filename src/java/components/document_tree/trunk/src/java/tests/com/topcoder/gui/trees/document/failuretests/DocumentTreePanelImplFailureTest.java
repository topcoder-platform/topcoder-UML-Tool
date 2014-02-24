/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.trees.document.failuretests;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.gui.trees.document.DocumentTreeConfigurationException;
import com.topcoder.gui.trees.document.DocumentTreeTabbedPane;
import com.topcoder.gui.trees.document.DocumentTreeViewType;
import com.topcoder.gui.trees.document.impl.DocumentTreePanelImpl;
import com.topcoder.gui.trees.document.impl.DocumentTreeTabbedPaneImpl;
import com.topcoder.uml.modelmanager.UMLModelManager;

/**
 * <p>
 * This Junit Test suite contains failure test cases for {@link DocumentTreePanelImpl} class.
 * </p>
 *
 * @author stylecheck
 * @version 1.0
 */
public class DocumentTreePanelImplFailureTest extends TestCase {

    /**
     * DocumentTreePanelImpl for testing.
     */
    private DocumentTreePanelImpl documentTreePanelImpl = null;

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
        documentTreePanelImpl = (DocumentTreePanelImpl) FailureTestHelper.getTreePanel();
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
        documentTreePanelImpl = null;
    }

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(DocumentTreePanelImplFailureTest.class);
    }

    /**
     * <p>
     * Tests the {@link DocumentTreePanelImpl#DocumentTreePanelImpl(DocumentTreeTabbedPane, String)}
     * constructor with parent as null value.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     *
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureDocumentTreePanelImpl() throws Exception {
        try {
            new DocumentTreePanelImpl(null, FailureTestHelper.NAMESPACE);
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the {@link DocumentTreePanelImpl#DocumentTreePanelImpl(DocumentTreeTabbedPane, String)}
     * constructor with namespace as null value.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     *
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureDocumentTreePanelImpl1() throws Exception {
        try {
            new DocumentTreePanelImpl(new DocumentTreeTabbedPaneImpl(UMLModelManager.getInstance(),
                FailureTestHelper.NAMESPACE), null);
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the {@link DocumentTreePanelImpl#DocumentTreePanelImpl(DocumentTreeTabbedPane, String)}
     * constructor with namespace as Empty string.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     *
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureDocumentTreePanelImpl2() throws Exception {
        try {
            new DocumentTreePanelImpl(new DocumentTreeTabbedPaneImpl(UMLModelManager.getInstance(),
                FailureTestHelper.NAMESPACE), "");
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the {@link DocumentTreePanelImpl#DocumentTreePanelImpl(DocumentTreeTabbedPane, String)}
     * constructor with namespace as Empty string with only spaces.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     *
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureDocumentTreePanelImpl3() throws Exception {
        try {
            new DocumentTreePanelImpl(new DocumentTreeTabbedPaneImpl(UMLModelManager.getInstance(),
                FailureTestHelper.NAMESPACE), "  ");
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

    /**
     * <p>
     * Tests the {@link DocumentTreePanelImpl#DocumentTreePanelImpl(DocumentTreeTabbedPane, String)}
     * constructor.
     * </p>
     * <p>
     * view_types property missing.
     * </p>
     * <p>
     * {@link DocumentTreeConfigurationException} Expected.
     * </p>
     *
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureDocumentTreePanelImpl4() throws Exception {
        try {
            FailureTestHelper.reSetup("Config_ViewTypesMissing.xml");
            new DocumentTreePanelImpl(new DocumentTreeTabbedPaneImpl(UMLModelManager.getInstance(),
                FailureTestHelper.NAMESPACE), FailureTestHelper.NAMESPACE);
            fail("DocumentTreeConfigurationException Expected.");
        } catch (DocumentTreeConfigurationException e) {
            // As expected.
        }
    }

    /**
     * <p>
     * Tests the {@link DocumentTreePanelImpl#DocumentTreePanelImpl(DocumentTreeTabbedPane, String)}
     * constructor.
     * </p>
     * <p>
     * view_types property empty.
     * </p>
     * <p>
     * {@link DocumentTreeConfigurationException} Expected.
     * </p>
     *
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureDocumentTreePanelImpl41() throws Exception {
        try {
            FailureTestHelper.reSetup("Config_ViewTypesEmpty.xml");
            new DocumentTreePanelImpl(new DocumentTreeTabbedPaneImpl(UMLModelManager.getInstance(),
                FailureTestHelper.NAMESPACE), FailureTestHelper.NAMESPACE);
            fail("DocumentTreeConfigurationException Expected.");
        } catch (DocumentTreeConfigurationException e) {
            // As expected.
        }
    }

    /**
     * <p>
     * Tests the {@link DocumentTreePanelImpl#DocumentTreePanelImpl(DocumentTreeTabbedPane, String)}
     * constructor.
     * </p>
     * <p>
     * view_types property contains empty tags.
     * </p>
     * <p>
     * {@link DocumentTreeConfigurationException} Expected.
     * </p>
     *
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureDocumentTreePanelImpl42() throws Exception {
        try {
            FailureTestHelper.reSetup("Config_ViewTypesContainsemptyTags.xml");
            new DocumentTreePanelImpl(new DocumentTreeTabbedPaneImpl(UMLModelManager.getInstance(),
                FailureTestHelper.NAMESPACE), FailureTestHelper.NAMESPACE);
            fail("DocumentTreeConfigurationException Expected.");
        } catch (DocumentTreeConfigurationException e) {
            // As expected.
        }
    }

    /**
     * <p>
     * Tests the {@link DocumentTreePanelImpl#DocumentTreePanelImpl(DocumentTreeTabbedPane, String)}
     * constructor.
     * </p>
     * <p>
     * view_types property contains wrong document type.
     * </p>
     * <p>
     * {@link DocumentTreeConfigurationException} Expected.
     * </p>
     *
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureDocumentTreePanelImpl43() throws Exception {
        try {
            FailureTestHelper.reSetup("Config_viewTypesWrogType.xml");
            new DocumentTreePanelImpl(new DocumentTreeTabbedPaneImpl(UMLModelManager.getInstance(),
                FailureTestHelper.NAMESPACE), FailureTestHelper.NAMESPACE);
            fail("DocumentTreeConfigurationException Expected.");
        } catch (DocumentTreeConfigurationException e) {
            // As expected.
        }
    }

    /**
     * <p>
     * Tests the {@link DocumentTreePanelImpl#DocumentTreePanelImpl(DocumentTreeTabbedPane, String)}
     * constructor.
     * </p>
     * <p>
     * view_types property contains views with the view class missing.
     * </p>
     * <p>
     * {@link DocumentTreeConfigurationException} Expected.
     * </p>
     *
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureDocumentTreePanelImpl44() throws Exception {
        try {
            FailureTestHelper.reSetup("Config_ViewTypesViewClassMissing.xml");
            new DocumentTreePanelImpl(new DocumentTreeTabbedPaneImpl(UMLModelManager.getInstance(),
                FailureTestHelper.NAMESPACE), FailureTestHelper.NAMESPACE);
            fail("DocumentTreeConfigurationException Expected.");
        } catch (DocumentTreeConfigurationException e) {
            // As expected.
        }
    }

    /**
     * <p>
     * Tests the {@link DocumentTreePanelImpl#DocumentTreePanelImpl(DocumentTreeTabbedPane, String)}
     * constructor.
     * </p>
     * <p>
     * view_types property contains views with the view text missing.
     * </p>
     * <p>
     * {@link DocumentTreeConfigurationException} Expected.
     * </p>
     *
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureDocumentTreePanelImpl421() throws Exception {
        try {
            FailureTestHelper.reSetup("Config_ViewTypesViewTextMissing.xml");
            new DocumentTreePanelImpl(new DocumentTreeTabbedPaneImpl(UMLModelManager.getInstance(),
                FailureTestHelper.NAMESPACE), FailureTestHelper.NAMESPACE);
            fail("DocumentTreeConfigurationException Expected.");
        } catch (DocumentTreeConfigurationException e) {
            // As expected.
        }
    }

    /**
     * <p>
     * Tests the {@link DocumentTreePanelImpl#DocumentTreePanelImpl(DocumentTreeTabbedPane, String)}
     * constructor.
     * </p>
     * <p>
     * view_types property contains views with the view class of wrong type.
     * </p>
     * <p>
     * {@link DocumentTreeConfigurationException} Expected.
     * </p>
     *
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureDocumentTreePanelImpl432() throws Exception {
        try {
            FailureTestHelper.reSetup("Config_ViewTypesViewClassWrongType.xml");
            new DocumentTreePanelImpl(new DocumentTreeTabbedPaneImpl(UMLModelManager.getInstance(),
                FailureTestHelper.NAMESPACE), FailureTestHelper.NAMESPACE);
            fail("DocumentTreeConfigurationException Expected.");
        } catch (DocumentTreeConfigurationException e) {
            // As expected.
        }
    }

    /**
     * <p>
     * Tests the {@link DocumentTreePanelImpl#DocumentTreePanelImpl(DocumentTreeTabbedPane, String)}
     * constructor.
     * </p>
     * <p>
     * view_types property contains views with the view class as empty.
     * </p>
     * <p>
     * {@link DocumentTreeConfigurationException} Expected.
     * </p>
     *
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureDocumentTreePanelImpl441() throws Exception {
        try {
            FailureTestHelper.reSetup("Config_ViewTypesViewClassEmpty.xml");
            new DocumentTreePanelImpl(new DocumentTreeTabbedPaneImpl(UMLModelManager.getInstance(),
                FailureTestHelper.NAMESPACE), FailureTestHelper.NAMESPACE);
            fail("DocumentTreeConfigurationException Expected.");
        } catch (DocumentTreeConfigurationException e) {
            // As expected.
        }
    }

    /**
     * <p>
     * Tests the {@link DocumentTreePanelImpl#DocumentTreePanelImpl(DocumentTreeTabbedPane, String)}
     * constructor.
     * </p>
     * <p>
     * view_types property contains views with the view text as empty.
     * </p>
     * <p>
     * {@link DocumentTreeConfigurationException} Expected.
     * </p>
     *
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureDocumentTreePanelImpl4411() throws Exception {
        try {
            FailureTestHelper.reSetup("Config_ViewTypesViewTextEmpty.xml");
            new DocumentTreePanelImpl(new DocumentTreeTabbedPaneImpl(UMLModelManager.getInstance(),
                FailureTestHelper.NAMESPACE), FailureTestHelper.NAMESPACE);
            fail("DocumentTreeConfigurationException Expected.");
        } catch (DocumentTreeConfigurationException e) {
            // As expected.
        }
    }

    /**
     * <p>
     * Tests the {@link DocumentTreePanelImpl#DocumentTreePanelImpl(DocumentTreeTabbedPane, String)}
     * constructor.
     * </p>
     * <p>
     * Diagram Centric view property missing.
     * </p>
     * <p>
     * {@link DocumentTreeConfigurationException} Expected.
     * </p>
     *
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailureDocumentTreePanelImpl14() throws Exception {
        try {
            FailureTestHelper.reSetup("Config_DiagramCentricViewMissing.xml");
            new DocumentTreePanelImpl(new DocumentTreeTabbedPaneImpl(UMLModelManager.getInstance(),
                FailureTestHelper.NAMESPACE), FailureTestHelper.NAMESPACE);
            fail("DocumentTreeConfigurationException Expected.");
        } catch (DocumentTreeConfigurationException e) {
            // As expected.
        }
    }

    /**
     * <p>
     * Tests the {@link DocumentTreePanelImpl#DocumentTreePanelImpl(DocumentTreeTabbedPane, String)}
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
    public void testFailureDocumentTreePanelImpl114() throws Exception {
        try {
            new DocumentTreePanelImpl(new DocumentTreeTabbedPaneImpl(UMLModelManager.getInstance(),
                FailureTestHelper.NAMESPACE), "Unknown");
            fail("DocumentTreeConfigurationException Expected.");
        } catch (DocumentTreeConfigurationException e) {
            // As expected.
        }
    }

    /**
     * <p>
     * Tests the {@link DocumentTreePanelImpl#setCurrentView(DocumentTreeViewType)} method with viewType
     * as null value.
     * </p>
     * <p>
     * {@link IllegalArgumentException} Expected.
     * </p>
     *
     * @throws Exception
     *             Any exception to JUnit.
     */
    public void testFailuresetCurrentView() throws Exception {
        try {
            documentTreePanelImpl.setCurrentView(null);
            fail("IllegalArgumentException is expected for the given input.");
        } catch (IllegalArgumentException e) {
            // as expected.
        }
    }

}
