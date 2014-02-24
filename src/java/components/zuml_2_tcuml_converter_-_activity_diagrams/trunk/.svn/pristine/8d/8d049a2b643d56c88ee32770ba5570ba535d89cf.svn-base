/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.accuracytests;

import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.statemachines.Pseudostate;

import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLDecisionNodeImpl;

import junit.framework.TestCase;


/**
 * The accuracy tests for the method ZUMLDecisionNodeImpl.
 *
 * @author KLW
 * @version 1.0
 */
public class ZUMLDecisionNodeImplAccuracyTests extends TestCase {
    /**
     * The accuracy test for the method {@link ZUMLDecisionNodeImpl#convertToTCUML()}.
     */
    public void testConvertToTCUML() {
        ZUMLDecisionNodeImpl instance = new ZUMLDecisionNodeImpl();
        instance.setName("decision");

        Namespace namespace = new CollaborationImpl();
        instance.setNamespace(namespace);

        instance.setVisibility(null);
        instance.setSpecification(true);

        ModelElement element = instance.convertToTCUML();

        assertTrue(element instanceof Pseudostate);

        assertEquals(PseudostateKind.CHOICE, ((Pseudostate) element).getKind());

        assertEquals("decision", element.getName());
        assertEquals(namespace, element.getNamespace());
        assertNull(element.getVisibility());
        assertTrue(element.isSpecification());
    }
}
