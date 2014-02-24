/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.accuracytests;

import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.statemachines.FinalState;

import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLActivityFinalNodeImpl;

import junit.framework.TestCase;


/**
 * The accuracy test for the class ZUMLActivityFinalNodeImpl.
 *
 * @author KLW
 * @version 1.0
 */
public class ZUMLActivityFinalNodeImplAccuracyTests extends TestCase {
    /**
     * The accuracy test for the class {@link ZUMLActivityFinalNodeImpl#convertToTCUML()}.
     */
    public void testConvertToTCUML() {
        ZUMLActivityFinalNodeImpl instance = new ZUMLActivityFinalNodeImpl();
        instance.setName("final");

        Namespace namespace = new CollaborationImpl();
        instance.setNamespace(namespace);

        instance.setVisibility(null);
        instance.setSpecification(true);

        ModelElement element = instance.convertToTCUML();
        assertTrue("The ZUMLActivityFinalNodeImpl should be converted to FinalState class.",
            element instanceof FinalState);

        //Verify that the simple attributes are copied.
        assertEquals("The name should match.", "final", element.getName());
        assertEquals("The namespace should match.", namespace, element.getNamespace());
        assertNull("The visibility is set to null.", element.getVisibility());
        assertTrue("The specification is set to true.", element.isSpecification());
    }
}
