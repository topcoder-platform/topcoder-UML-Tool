/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;

import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.uml.model.core.relationships.AssociationImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class CopyAssociationAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CopyAssociationActionTest extends TestCase {

    /**
     * The Association instance for the test.
     */
    private Association association = new AssociationImpl();

    /**
     * The Clipboard instance for the test.
     */
    private Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();

    /**
     * Test Constructor(Association), with correct association.
     */
    public void testCtor1() {
        CopyAssociationAction copyAction = new CopyAssociationAction(association);

        assertTrue("Should be a CopyAssociationAction instance.", copyAction instanceof CopyAssociationAction);
    }

    /**
     * Test Constructor(Association), with null association.
     * IllegalArgumentException is expected.
     */
    public void testCtor1WithNullAssociation() {
        try {
            new CopyAssociationAction(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test Constructor(Association, Clipboard), with correct association and
     * clipboard.
     */
    public void testCtor2() {
        CopyAssociationAction copyAction = new CopyAssociationAction(association, clipboard);

        assertTrue("Should be a CopyAssociationAction instance.", copyAction instanceof CopyAssociationAction);
    }

    /**
     * Test Constructor(Association, Clipboard), with null association.
     * IllegalArgumentException is expected.
     */
    public void testCtor2WithNullAssociation() {
        try {
            new CopyAssociationAction(null, clipboard);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test Constructor(Association, Clipboard), with null clipboard. Do the
     * same as it is not null, for the constructor will assign the default
     * clipboard.
     */
    public void testCtor2WithNullClipboard() {
        try {
            new CopyAssociationAction(association, null);
            // pass
        } catch (IllegalArgumentException iae) {
            fail("IllegalArgumentException is not expected.");
        }
    }
}
