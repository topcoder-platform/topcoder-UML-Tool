/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.accuracytests;

import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.statemachines.Pseudostate;

import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLInitialNodeImpl;

import junit.framework.TestCase;


/**
 * The accuracy test for the class ZUMLInitialNodeImpl.
 * @author KLW
 * @version 1.0
 */
public class ZUMLInitialNodeImplAccuracyTests extends TestCase {
    /**
     * The accuracy test for the method {@link ZUMLInitialNodeImpl#convertToTCUML()}.
     */
    public void testConvertToTCUML() {
        ZUMLInitialNodeImpl instance = new ZUMLInitialNodeImpl();
        instance.setName("initial");

        Namespace namespace = new CollaborationImpl();
        instance.setNamespace(namespace);

        instance.setVisibility(null);
        instance.setSpecification(true);

        ModelElement element = instance.convertToTCUML();

        assertTrue(element instanceof Pseudostate);

        assertEquals(PseudostateKind.INITIAL, ((Pseudostate) element).getKind());

        assertEquals("initial", element.getName());
        assertEquals(namespace, element.getNamespace());
        assertNull(element.getVisibility());
        assertTrue(element.isSpecification());
    }
}
