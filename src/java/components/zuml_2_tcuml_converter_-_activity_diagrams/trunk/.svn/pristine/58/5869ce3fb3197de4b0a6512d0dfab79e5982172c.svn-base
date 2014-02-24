/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.accuracytests;

import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.statemachines.Transition;

import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLExceptionHandlerImpl;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLFlowFinalNodeImpl;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLInitialNodeImpl;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLOpaqueExpressionImpl;

import junit.framework.TestCase;


/**
 * The accuracy tests for the class ZUMLExceptionHandlerImpl.
 *
 * @author KLW
 * @version 1.0
 */
public class ZUMLExceptionHandlerImplAccuracyTests extends TestCase {
    /**
     * The accuracy tests for the class {@link ZUMLExceptionHandlerImpl#convertToTCUML()}.
     */
    public void testConvertToTCUML() {
        ZUMLExceptionHandlerImpl instance = new ZUMLExceptionHandlerImpl();
        instance.setSource(new ZUMLInitialNodeImpl());
        instance.setTarget(new ZUMLFlowFinalNodeImpl());
        instance.setGuard(new ZUMLOpaqueExpressionImpl());

        instance.setName("exception");

        Namespace namespace = new CollaborationImpl();
        instance.setNamespace(namespace);

        instance.setVisibility(null);
        instance.setSpecification(true);

        ModelElement element = instance.convertToTCUML();

        assertTrue(element instanceof Transition);

        Transition transition = (Transition) element;

        assertNotNull(transition.getSource());
        assertNotNull(transition.getTarget());
        assertNotNull(transition.getGuard());

        assertEquals("exception", element.getName());
        assertEquals(namespace, element.getNamespace());
        assertNull(element.getVisibility());
        assertTrue(element.isSpecification());
    }
}
