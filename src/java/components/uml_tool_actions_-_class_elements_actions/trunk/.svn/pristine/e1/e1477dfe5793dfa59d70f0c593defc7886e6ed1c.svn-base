/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifiers;

import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.classifiers.InterfaceImpl;
import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class RemoveInterfaceAction.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class RemoveInterfaceActionTest extends TestCase {

    /**
     * Test Constructor, with correct interface.
     */
    public void testCtor() {
        Interface interfacee = new InterfaceImpl();

        RemoveInterfaceAction removeAction = new RemoveInterfaceAction(interfacee);

        assertEquals("Should return ModelElement instance.", interfacee, removeAction.getModelElement());
    }

    /**
     * Test Constructor, with null interface. IllegalArgumentException is
     * expected.
     */
    public void testCtorWithNullInterface() {
        try {
            new RemoveInterfaceAction(null);
            fail("IllegalArgumentException is expected.");
        } catch (IllegalArgumentException iae) {
            // pass
        }
    }

    /**
     * Test getPresentationName.
     */
    public void testGetPresentationName() {
        Interface interfacee = new InterfaceImpl();

        RemoveInterfaceAction removeAction = new RemoveInterfaceAction(interfacee);

        assertEquals("Should return PRESENTATION_NAME.", "Remove Interface", removeAction.getPresentationName());
    }
}