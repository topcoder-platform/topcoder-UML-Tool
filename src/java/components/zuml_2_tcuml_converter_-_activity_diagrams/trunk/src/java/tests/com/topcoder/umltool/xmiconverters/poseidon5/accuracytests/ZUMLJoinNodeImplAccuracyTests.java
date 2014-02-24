/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.accuracytests;

import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.statemachines.Pseudostate;

import com.topcoder.umltool.xmiconverters.poseidon5.activity.ZUMLOpaqueExpression;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLJoinNodeImpl;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLOpaqueExpressionImpl;

import junit.framework.TestCase;


/**
 * The accuracy test for the class ZUMLJoinNodeImpl.
 *
 * @author KLW
 * @version 1.0
 */
public class ZUMLJoinNodeImplAccuracyTests extends TestCase {
    /**
     * The accuracy tests for the getter and setter of the JoinSpec.
     *
     */
    public void testJoinSpec() {
        ZUMLJoinNodeImpl instance = new ZUMLJoinNodeImpl();

        ZUMLOpaqueExpression expression = new ZUMLOpaqueExpressionImpl();
        instance.setJoinSpec(expression);

        assertEquals(expression, instance.getJoinSpec());
    }

    /**
     * The accuracy test for the method {@link ZUMLJoinNodeImpl#convertToTCUML()}.
     */
    public void testConvertToTCUML() {
        ZUMLJoinNodeImpl instance = new ZUMLJoinNodeImpl();
        instance.setName("join");

        Namespace namespace = new CollaborationImpl();
        instance.setNamespace(namespace);

        instance.setVisibility(null);
        instance.setSpecification(true);

        ModelElement element = instance.convertToTCUML();

        assertTrue(element instanceof Pseudostate);

        assertEquals(PseudostateKind.JOIN, ((Pseudostate) element).getKind());

        assertEquals("join", element.getName());
        assertEquals(namespace, element.getNamespace());
        assertNull(element.getVisibility());
        assertTrue(element.isSpecification());
    }
}
