/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.accuracytests;

import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.statemachines.FinalState;

import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLFlowFinalNodeImpl;

import junit.framework.TestCase;


/**
 * The accuracy tests for the class ZUMLFlowFinalNodeImpl.
 *
 * @author KLW
 * @version 1.0
 */
public class ZUMLFlowFinalNodeImplAccuracyTests extends TestCase {
    /**
     * The accuracy test for the method {@link ZUMLFlowFinalNodeImpl#convertToTCUML()}.
     */
    public void testConvertToTCUML() {
        ZUMLFlowFinalNodeImpl instance = new ZUMLFlowFinalNodeImpl();
        instance.setName("final");

        Namespace namespace = new CollaborationImpl();
        instance.setNamespace(namespace);

        instance.setVisibility(null);
        instance.setSpecification(true);

        ModelElement element = instance.convertToTCUML();

        assertTrue(element instanceof FinalState);

        assertEquals(1, element.getTaggedValues().size());

        TaggedValue taggedValue = (TaggedValue) element.getTaggedValues().toArray()[0];
        assertEquals("FlowFinalNode", taggedValue.getDataValue());
        assertEquals("FinalNodeType", taggedValue.getType().getTagType());

        //Verify that the simple attributes are copied.
        assertEquals("final", element.getName());
        assertEquals(namespace, element.getNamespace());
        assertNull(element.getVisibility());
        assertTrue(element.isSpecification());
    }
}
