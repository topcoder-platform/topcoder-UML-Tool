/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.accuracytests;

import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.statemachines.SimpleStateImpl;

import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLPinNodeImpl;

import junit.framework.TestCase;


/**
 * The accuracy tests for the class ZUMLPinNodeImpl.
 *
 * @author KLW
 * @version 1.0
 */
public class ZUMLPinNodeImplAccuracyTests extends TestCase {
    /**
     * The accuracy test for the method {@link ZUMLPinNodeImpl#convertToTCUML()}.
     */
    public void testConvertToTCUML() {
        ZUMLPinNodeImpl instance = new ZUMLPinNodeImpl();
        instance.setName("pin");

        Namespace namespace = new CollaborationImpl();
        instance.setNamespace(namespace);

        instance.setVisibility(null);
        instance.setSpecification(true);

        ModelElement element = instance.convertToTCUML();

        assertTrue(element instanceof SimpleStateImpl);

        assertEquals(1, element.getTaggedValues().size());

        TaggedValue taggedValue = (TaggedValue) element.getTaggedValues().toArray()[0];
        assertEquals("ObjectFlowStateNode", taggedValue.getDataValue());
        assertEquals("ObjectFlowStateType", taggedValue.getType().getTagType());

        assertEquals("pin", element.getName());
        assertEquals(namespace, element.getNamespace());
        assertNull(element.getVisibility());
        assertTrue(element.isSpecification());
    }
}
