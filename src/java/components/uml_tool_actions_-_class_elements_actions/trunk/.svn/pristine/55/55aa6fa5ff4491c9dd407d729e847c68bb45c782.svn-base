/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.classifiers.InterfaceImpl;
import com.topcoder.uml.model.core.relationships.Generalization;
import com.topcoder.uml.model.core.relationships.GeneralizationImpl;
import com.topcoder.uml.model.modelmanagement.ModelImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class GeneralizationUtil.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class GeneralizationUtilTest extends TestCase {

    /**
     * The GeneralizationUtil instance for the test.
     */
    private GeneralizationUtil generalizationUtil;

    /**
     * The Generalization instance for the test.
     */
    private Generalization modelElement = new GeneralizationImpl();

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

        clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        namespace = new ModelImpl();
        modelElement.setChild(new ClassImpl());
        modelElement.setParent(new ClassImpl());
    }

    /**
     * Test constructor.
     */
    public void testCtor() {
        generalizationUtil = new GeneralizationUtil();
    }

    /**
     * Test addElementToModel, with correct modelElement and namespace.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testAddElementToModelSimple() throws Exception {
        modelElement.setNamespace(namespace);

        generalizationUtil = new GeneralizationUtil();

        generalizationUtil.addElementToModel(modelElement, namespace);

        assertTrue("Should be added to the namespace.", namespace.containsOwnedElement(modelElement));

        /*
         * BugFix: UML-9993
         * The generalization instance should be added to the child's generalization
         * list, and the parent's specialization list, not just the opposite.
         */
        // old code
//        assertTrue("Should add the relationship.", modelElement.getParent().containsGeneralization(modelElement));
//        assertTrue("Should add the relationship.", modelElement.getChild().containsSpecialization(modelElement));
        assertTrue("Should add the relationship.", modelElement.getChild().containsGeneralization(modelElement));
        assertTrue("Should add the relationship.", modelElement.getParent().containsSpecialization(modelElement));
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

        // parent namespace: namespace.com.tc
        Classifier parent = new InterfaceImpl();
        parent.setNamespace(tc);

        // chlid's namespace: namespace.com.test
        Classifier child = new InterfaceImpl();
        child.setNamespace(test);

        modelElement.setNamespace(namespace);
        modelElement.setParent(parent);
        modelElement.setChild(child);

        generalizationUtil = new GeneralizationUtil();

        generalizationUtil.addElementToModel(modelElement, namespace);

        // modelElement's namespace should be namespace.com
        assertTrue("Should be added to the namespace.", com.containsOwnedElement(modelElement));

        /*
         * BugFix: UML-9993
         * The generalization instance should be added to the child's generalization
         * list, and the parent's specialization list, not just the opposite.
         */
        // old code
//        assertTrue("Should add the relationship.", modelElement.getParent().containsGeneralization(modelElement));
//        assertTrue("Should add the relationship.", modelElement.getChild().containsSpecialization(modelElement));
        assertTrue("Should add the relationship.", modelElement.getChild().containsGeneralization(modelElement));
        assertTrue("Should add the relationship.", modelElement.getParent().containsSpecialization(modelElement));
    }

    /**
     * Test addElementToClipboard, with null modelElement.
     * IllegalArgumentException is expected.
     */
    public void testAddElementToModelWithNullModelElement() {
        generalizationUtil = new GeneralizationUtil();

        try {
            generalizationUtil.addElementToModel(null, namespace);
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
        generalizationUtil = new GeneralizationUtil();

        try {
            generalizationUtil.addElementToModel(modelElement, null);
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

        generalizationUtil = new GeneralizationUtil();

        generalizationUtil.removeElementFromModel(modelElement);

        assertFalse("Should remove the relationship.", modelElement.getParent().containsGeneralization(modelElement));
        assertFalse("Should remove the relationship.", modelElement.getChild().containsGeneralization(modelElement));
    }

    /**
     * Test removeElementFromModel, with correct modelElement.
     *
     * @throws Exception
     *             if an unexpected exception occurs
     */
    public void testRemoveElementFromModel() throws Exception {
        Classifier parent = new InterfaceImpl();
        Classifier child = new InterfaceImpl();

        modelElement.setNamespace(namespace);
        modelElement.setParent(parent);
        modelElement.setChild(child);

        namespace.addOwnedElement(modelElement);
        modelElement.setNamespace(namespace);

        generalizationUtil = new GeneralizationUtil();

        generalizationUtil.removeElementFromModel(modelElement);

        assertFalse("Should remove the relationship.", modelElement.getParent().containsGeneralization(modelElement));
        assertFalse("Should remove the relationship.", modelElement.getChild().containsGeneralization(modelElement));
    }

    /**
     * Test addElementToClipboard, with null modelElement.
     * IllegalArgumentException is expected.
     */
    public void testRemoveElementFromModelWithNullModelElement() {
        generalizationUtil = new GeneralizationUtil();

        try {
            generalizationUtil.removeElementFromModel(null);
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
        generalizationUtil = new GeneralizationUtil();

        generalizationUtil.addElementToClipboard(modelElement, clipboard);

        assertTrue("Should add a new modelElement to the clipboard.", clipboard
                .getData(ClassElementsTransfer.GENERALIZATION_FLAVOR) instanceof GeneralizationImpl);
        assertFalse("Should add a new modelElement to the clipboard.", clipboard.getData(
                ClassElementsTransfer.GENERALIZATION_FLAVOR).equals(modelElement));
    }

    /**
     * Test addElementToClipboard, with null modelElement.
     * IllegalArgumentException is expected.
     */
    public void testAddElementToClipboardWithNullModelElement() {
        generalizationUtil = new GeneralizationUtil();

        try {
            generalizationUtil.addElementToClipboard(null, clipboard);
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
        generalizationUtil = new GeneralizationUtil();

        try {
            generalizationUtil.addElementToClipboard(modelElement, null);
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
        generalizationUtil = new GeneralizationUtil();

        Generalization newModleElement = (Generalization) generalizationUtil.copyElement(modelElement);

        // the base attributes are test in ClassToolUtilTest
        assertEquals("Copy failed.", modelElement.getDiscriminator(), newModleElement.getDiscriminator());
        assertEquals("Copy failed.", modelElement.getPowertype(), newModleElement.getPowertype());
    }

    /**
     * Test copyElement, with null classUtil. IllegalArgumentException is
     * expected.
     */
    public void testCopyElementWithNullModelElement() {
        generalizationUtil = new GeneralizationUtil();

        try {
            generalizationUtil.copyElement(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }
}