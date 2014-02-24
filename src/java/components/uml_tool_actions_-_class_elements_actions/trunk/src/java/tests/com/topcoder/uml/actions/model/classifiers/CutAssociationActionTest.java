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
 * Unit test cases for class CutAssociationAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class CutAssociationActionTest extends TestCase {

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
        CutAssociationAction cutAction = new CutAssociationAction(association);

        assertEquals("Should return ModelElement instance.", association, cutAction.getModelElement());
    }

    /**
     * Test Constructor(Association), with null association.
     * IllegalArgumentException is expected.
     */
    public void testCtor1WithNullAssociation() {
        try {
            new CutAssociationAction(null);
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
        CutAssociationAction cutAction = new CutAssociationAction(association, clipboard);

        assertEquals("Should return ModelElement instance.", association, cutAction.getModelElement());
    }

    /**
     * Test Constructor(Association, Clipboard), with null association.
     * IllegalArgumentException is expected.
     */
    public void testCtor2WithNullAssociation() {
        try {
            new CutAssociationAction(null, clipboard);
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
            new CutAssociationAction(association, null);
            // pass
        } catch (IllegalArgumentException iae) {
            fail("IllegalArgumentException is not expected.");
        }
    }

    /**
     * Test getPresentationName.
     */
    public void testGetPresentationName() {
        CutAssociationAction cutAction = new CutAssociationAction(association);

        assertEquals("Should return PRESENTATION_NAME.", "Cut Association", cutAction.getPresentationName());
    }
}