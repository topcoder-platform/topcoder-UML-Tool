/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.model.classifiers.accuracytests;

import junit.framework.TestCase;

import com.topcoder.uml.actions.model.classifiers.MockAssociationUtil;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;
import com.topcoder.uml.model.core.relationships.AssociationImpl;

/**
 * Accuracy tests for AssociationUtil.
 *
 * @author superZZ
 * @version 1.0
 */
public class AssociationUtilTest extends TestCase {
    /**
     * Load logging configuration.
     *
     * @throws Exception
     *             Exception to JUnit.
     */
    protected void setUp() throws Exception {
        TestUtil.loadConfiguration();

        association.addConnection(new AssociationEndImpl());
        association.addConnection(new AssociationEndImpl());
    }

    /**
     * Unload logging configuration.
     *
     * @throws Exception
     *             Exception to JUnit.
     */
    protected void tearDown() throws Exception {
        TestUtil.unloadConfiguration();
    }

    /**
     * AssociationUtil instance for test.
     */
    private final MockAssociationUtil util = new MockAssociationUtil();

    /**
     * Association instance for test.
     */
    private final Association association = new AssociationImpl();

    /**
     * Namespace instance for test.
     */
    private final Namespace namespace = TestUtil.getInstance().getNamespace();

    /**
     * Test method for
     * {@link AssociationUtil#addElementToModel(ModelElement, Namespace)}.
     */
    public void testAddElementToModel() {
        util.addElementToModel(association, namespace);

        assertTrue(namespace.containsOwnedElement(association));
    }

    /**
     * Test method for
     * {@link AssociationUtil#removeElementFromModel(ModelElement)}.
     */
    public void testRemoveElementFromModel() {
        util.addElementToModel(association, namespace);
        util.removeElementFromModel(association);
        assertFalse(namespace.containsOwnedElement(association));
    }

    /**
     * Test method for {@link AssociationUtil#copyElement(ModelElement)}.
     */
    public void testCopyElement() {
        Association newElement = (Association) util.copyElement(association);

        assertEquals(association.getName(), newElement.getName());
        assertEquals(association.getConnections().size(), newElement
                .getConnections().size());
    }
}
