/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.classifiers.InterfaceImpl;
import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;
import com.topcoder.uml.model.core.relationships.AssociationImpl;
import com.topcoder.uml.model.modelmanagement.ModelImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class AssociationUtil.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AssociationUtilTest extends TestCase {

    /**
     * The AssociationUtil instance for the test.
     */
    private AssociationUtil associationUtil;

    /**
     * The Association instance for the test.
     */
    private Association modelElement = new AssociationImpl();

    /**
     * The Clipboard instance for the test.
     */
    private Clipboard clipboard;

    /**
     * The Namespace instance for the test.
     */
    private Namespace namespace;

    /**
     * Setup routine for JUnit.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    protected void setUp() throws Exception {
        super.setUp();

        modelElement.addConnection(new AssociationEndImpl());
        modelElement.addConnection(new AssociationEndImpl());

        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        namespace = new ModelImpl();
    }

    /**
     * Test constructor.
     */
    public void testCtor() {
        associationUtil = new AssociationUtil();
    }

    /**
     * Test addElementToModel, with correct modelElement and namespace.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testAddElementToModelSimple() throws Exception {
        modelElement.setNamespace(namespace);

        associationUtil = new AssociationUtil();

        associationUtil.addElementToModel(modelElement, namespace);

        assertTrue("Should be added to the namespace.", namespace.containsOwnedElement(modelElement));

        for (AssociationEnd associationEnd : modelElement.getConnections()) {
            for (Classifier classifier : associationEnd.getSpecifications()) {
                assertTrue("Should add the relationship.", classifier.containsAssociation(associationEnd));
            }
        }
    }

    /**
     * Test addElementToModel, with correct modelElement and namespace. Also the
     * modelElement's namespce will be checked here.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testAddElementToModel() throws Exception {
        Namespace com = new ModelImpl();
        com.setNamespace(namespace);
        Namespace tc = new ModelImpl();
        tc.setNamespace(com);
        Namespace test = new ModelImpl();
        test.setNamespace(com);

        // testSpec1's namespace: namespace.com.tc
        Classifier testSpec1 = new InterfaceImpl();
        testSpec1.setNamespace(tc);

        // testSpec2's namespace: namespace.com.test
        Classifier testSpec2 = new InterfaceImpl();
        testSpec2.setNamespace(test);

        AssociationEnd testEnd = new AssociationEndImpl();
        testEnd.addSpecification(testSpec1);
        testEnd.addSpecification(testSpec2);

        modelElement.addConnection(testEnd);
        modelElement.setNamespace(namespace);

        associationUtil = new AssociationUtil();

        associationUtil.addElementToModel(modelElement, namespace);

        // modelElement's namespace should be namespace.com
        assertTrue("Should be added to the Namespace namespace.", com.containsOwnedElement(modelElement));

        for (AssociationEnd associationEnd : modelElement.getConnections()) {
            for (Classifier classifier : associationEnd.getSpecifications()) {
                assertTrue("Should add the relationship.", classifier.containsAssociation(associationEnd));
            }
        }
    }

    /**
     * Test addElementToClipboard, with null modelElement.
     * IllegalArgumentException is expected.
     */
    public void testAddElementToModelWithNullModelElement() {
        associationUtil = new AssociationUtil();

        try {
            associationUtil.addElementToModel(null, namespace);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test addElementToClipboard, with null namespace. IllegalArgumentException
     * is expected.
     */
    public void testAddElementToModelWithNullNamespace() {
        associationUtil = new AssociationUtil();

        try {
            associationUtil.addElementToModel(modelElement, null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test removeElementFromModel, with correct modelElement.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testRemoveElementFromModelSimple() throws Exception {
        namespace.addOwnedElement(modelElement);
        modelElement.setNamespace(namespace);

        associationUtil = new AssociationUtil();

        associationUtil.removeElementFromModel(modelElement);

        for (AssociationEnd associationEnd : modelElement.getConnections()) {
            for (Classifier classifier : associationEnd.getSpecifications()) {
                assertFalse("Should remove the relationship.", classifier.containsAssociation(associationEnd));
            }
        }
    }

    /**
     * Test removeElementFromModel, with correct modelElement.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testRemoveElementFromModel() throws Exception {
        AssociationEnd testEnd = new AssociationEndImpl();
        Classifier testSpec1 = new InterfaceImpl();
        Classifier testSpec2 = new InterfaceImpl();
        testEnd.addSpecification(testSpec1);
        testSpec1.addAssociation(testEnd);
        testEnd.addSpecification(testSpec2);
        testSpec2.addAssociation(testEnd);

        modelElement.addConnection(testEnd);
        modelElement.setNamespace(namespace);
        namespace.addOwnedElement(modelElement);

        associationUtil = new AssociationUtil();

        associationUtil.removeElementFromModel(modelElement);

        for (AssociationEnd associationEnd : modelElement.getConnections()) {
            for (Classifier classifier : associationEnd.getSpecifications()) {
                assertFalse("Should remove the relationship.", classifier.containsAssociation(associationEnd));
            }
        }
    }

    /**
     * Test addElementToClipboard, with null modelElement.
     * IllegalArgumentException is expected.
     */
    public void testRemoveElementFromModelWithNullModelElement() {
        associationUtil = new AssociationUtil();

        try {
            associationUtil.removeElementFromModel(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test addElementToClipboard, with correct modelElement and classUtil.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testAddElementToClipboard() throws Exception {
        associationUtil = new AssociationUtil();

        associationUtil.addElementToClipboard(modelElement, clipboard);

        assertTrue("Should add a new modelElement to the clipboard.", clipboard
                .getData(ClassElementsTransfer.ASSOCIATION_FLAVOR) instanceof AssociationImpl);
        assertFalse("Should add a new modelElement to the clipboard.", clipboard.getData(
                ClassElementsTransfer.ASSOCIATION_FLAVOR).equals(modelElement));
    }

    /**
     * Test addElementToClipboard, with null modelElement.
     * IllegalArgumentException is expected.
     */
    public void testAddElementToClipboardWithNullModelElement() {
        associationUtil = new AssociationUtil();

        try {
            associationUtil.addElementToClipboard(null, clipboard);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test addElementToClipboard, with null classUtil. IllegalArgumentException
     * is expected.
     */
    public void testAddElementToClipboardWithNullClassUtil() {
        associationUtil = new AssociationUtil();

        try {
            associationUtil.addElementToClipboard(modelElement, null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test copyElement, with correct modelElement and classUtil.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testCopyElement() throws Exception {
        associationUtil = new AssociationUtil();

        Association newModleElement = (Association) associationUtil.copyElement(modelElement);

        // the base attributes are test in ClassToolUtilTest
        assertEquals("Copy failed.", modelElement.isRoot(), newModleElement.isRoot());
        assertEquals("Copy failed.", modelElement.isLeaf(), newModleElement.isLeaf());
        assertEquals("Copy failed.", modelElement.isAbstract(), newModleElement.isAbstract());
    }

    /**
     * Test copyElement, with null classUtil. IllegalArgumentException is
     * expected.
     */
    public void testCopyElementWithNullModelElement() {
        associationUtil = new AssociationUtil();

        try {
            associationUtil.copyElement(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }
}