/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.accuracytests;

import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.statemachines.Guard;

import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLOpaqueExpressionImpl;

import junit.framework.TestCase;


/**
 * The accuracy tests for the class ZUMLOpaqueExpressionImpl.
 *
 * @author KLW
 * @version 1.0
 */
public class ZUMLOpaqueExpressionImplAccuracyTests extends TestCase {
    /**
     * The accuracy tests for the method {@link ZUMLOpaqueExpressionImpl#convertToTCUML()}.
     */
    public void testConvertToTCUML() {
        ZUMLOpaqueExpressionImpl instance = new ZUMLOpaqueExpressionImpl();
        instance.setBody("body");
        instance.setLanguage("language");

        instance.setName("OpaqueExpression");

        Namespace namespace = new CollaborationImpl();
        instance.setNamespace(namespace);

        instance.setVisibility(null);
        instance.setSpecification(true);

        ModelElement element = instance.convertToTCUML();

        assertTrue(element instanceof Guard);

        Guard guard = (Guard) element;
        assertNotNull(guard.getExpression());
        assertEquals("body", guard.getExpression().getBody());
        assertEquals("language", guard.getExpression().getLanguage());

        assertEquals("OpaqueExpression", element.getName());
        assertEquals(namespace, element.getNamespace());
        assertNull(element.getVisibility());
        assertTrue(element.isSpecification());
    }
}
