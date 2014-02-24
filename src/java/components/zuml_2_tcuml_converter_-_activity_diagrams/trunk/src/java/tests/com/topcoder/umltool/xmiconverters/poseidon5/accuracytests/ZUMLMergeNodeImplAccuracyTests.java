/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.accuracytests;

import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.statemachines.Pseudostate;

import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLMergeNodeImpl;

import junit.framework.TestCase;


/**
 * The accuracy tests for the class ZUMLMergeNodeImpl.
 * @author KLW
 * @version 1.0
 */
public class ZUMLMergeNodeImplAccuracyTests extends TestCase {
    /**
     * the accuracy test for the method {@link ZUMLMergeNodeImpl#convertToTCUML()}.
     */
    public void testConvertToTCUML() {
        ZUMLMergeNodeImpl instance = new ZUMLMergeNodeImpl();
        instance.setName("merge");

        Namespace namespace = new CollaborationImpl();
        instance.setNamespace(namespace);

        instance.setVisibility(null);
        instance.setSpecification(true);

        ModelElement element = instance.convertToTCUML();

        assertTrue(element instanceof Pseudostate);

        assertEquals(PseudostateKind.JUNCTION, ((Pseudostate) element).getKind());

        assertEquals("merge", element.getName());
        assertEquals(namespace, element.getNamespace());
        assertNull(element.getVisibility());
        assertTrue(element.isSpecification());
    }
}
