/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.accuracytests;

import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.statemachines.Transition;

import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLActivityEdgeImpl;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLFlowFinalNodeImpl;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLInitialNodeImpl;
import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLOpaqueExpressionImpl;

import junit.framework.TestCase;


/**
 * The accuracy test
 *
 * @author KLW
 * @version 1.0
 */
public class ZUMLActivityEdgeImplAccuracyTests extends TestCase {
    /**
     * The accuracy test for the class {@link ZUMLActivityEdgeImpl#convertToTCUML()}.
     */
    public void testConvertToTCUML() {
        ZUMLActivityEdgeImpl instance = new ZUMLActivityEdgeImpl();
        instance.setSource(new ZUMLInitialNodeImpl());
        instance.setTarget(new ZUMLFlowFinalNodeImpl());
        instance.setGuard(new ZUMLOpaqueExpressionImpl());
        instance.setName("edge");

        Namespace namespace = new CollaborationImpl();
        instance.setNamespace(namespace);

        instance.setVisibility(null);
        instance.setSpecification(true);

        ModelElement element = instance.convertToTCUML();

        assertTrue("The ZUMLActivityEdgeImpl should be converted to Transition class.",
            element instanceof Transition);

        Transition transition = (Transition) element;

        assertNotNull("It should have a source vertex.", transition.getSource());
        assertNotNull("It should have a target vertex.", transition.getTarget());
        assertNotNull("It should have a guard.", transition.getGuard());

        assertEquals("The name should match.", "edge", element.getName());
        assertEquals("The namespace should match.", namespace, element.getNamespace());
        assertNull("The visibility is set to null.", element.getVisibility());
        assertTrue("The specification is set to true.", element.isSpecification());
    }
}
