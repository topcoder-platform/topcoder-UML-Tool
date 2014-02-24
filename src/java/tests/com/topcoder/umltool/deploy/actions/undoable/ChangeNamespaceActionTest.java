/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import junit.framework.TestCase;

import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;

/**
 * <p>
 * Test the functionality of <code>ChangeNamespaceActionTest</code> class.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class ChangeNamespaceActionTest extends TestCase {
    /**
     * Represents the ChangeNamespaceAction instance used for tests.
     */
    private ChangeNamespaceAction testChangeNamespaceAction;

    /**
     * Represents the association end model element to change the namespace.
     */
    private AssociationEnd element;

    /**
     * Represents the old namespace of the model element before the action performed.
     */
    private final Namespace oldNamespace = new ClassImpl();

    /**
     * Represents the new namespace of the model element the action will performed.
     */
    private final Namespace newNamespace = new ClassImpl();

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        element = new AssociationEndImpl();
        element.setNamespace(oldNamespace);
        testChangeNamespaceAction = new ChangeNamespaceAction(element, newNamespace);
    }

    /**
     * Accuracy test for the method <code>undoAction()</code>. The namespace value of the ModelElememt should be set
     * to oldNamespace;
     */
    public void testUndoAction() {
        testChangeNamespaceAction.undoAction();
        assertEquals("ChangeNamespaceAction undoAction incorrectly.", oldNamespace, element.getNamespace());
    }

    /**
     * Accuracy test for the method <code>redoAction()</code>. The namespace value of the ModelElememt should be set
     * to newNamespace;
     */
    public void testRedoAction() {
        testChangeNamespaceAction.redoAction();
        assertEquals("ChangeNamespaceAction redoAction incorrectly.", newNamespace, element.getNamespace());
    }

    /**
     * Accuracy test for the method <code>executeAction()</code>. The namespace value of the ModelElememt should be
     * set to newNamespace;
     */
    public void testExecuteAction() {
        testChangeNamespaceAction.executeAction();
        assertEquals("ChangeNamespaceAction executeAction incorrectly.", newNamespace, element.getNamespace());
    }

    /**
     * Test ChangeNamespaceAction constructor.
     */
    public void testChangeNamespaceActionConstructor() {
        UndoableAbstractAction action = new ChangeNamespaceAction(element, oldNamespace);
        assertNotNull("Create ChangeNamespaceAction incorrectly.", action);
    }

    /**
     * Test ChangeNamespaceAction constructor with null element. Should throw IllegalArgumentException.
     */
    public void testChangeNamespaceActionConstructorNullElement() {
        try {
            new ChangeNamespaceAction(null, oldNamespace);
            fail("IllegalArgumentException should be thrown when the passed element is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test ChangeNamespaceAction constructor with null new namespace. Should throw IllegalArgumentException.
     */
    public void testChangeNamespaceActionConstructorNullNewNamespace() {
        try {
            new ChangeNamespaceAction(element, null);
            fail("IllegalArgumentException should be thrown when the passed new namespace is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

}
