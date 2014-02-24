/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.accuracytests;

import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.statemachines.SimpleState;

import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLCallActionImpl;

import junit.framework.TestCase;


/**
 * The accuracy tests for the class ZUMLCallActionImpl.
 *
 * @author KLW
 * @version 1.0
 */
public class ZUMLCallActionImplAccuracyTests extends TestCase {
    /**
     * The accuracy test for the method {@link ZUMLCallActionImpl#convertToTCUML()}.
     */
    public void testConvertToTCUML() {
        ZUMLCallActionImpl instance = new ZUMLCallActionImpl();
        instance.setName("call");

        Namespace namespace = new CollaborationImpl();
        instance.setNamespace(namespace);

        instance.setVisibility(null);
        instance.setSpecification(true);

        ModelElement element = instance.convertToTCUML();

        assertTrue("The ZUMLCallActionImpl should be converted to SimpleState class.",
            element instanceof SimpleState);

        assertEquals("There is only 1 taggedValue.", 1, element.getTaggedValues().size());

        TaggedValue taggedValue = (TaggedValue) element.getTaggedValues().toArray()[0];
        assertEquals("True", taggedValue.getDataValue());
        assertEquals("CallAction", taggedValue.getType().getTagType());

        assertEquals("call", element.getName());
        assertEquals(namespace, element.getNamespace());
        assertNull(element.getVisibility());
        assertTrue(element.isSpecification());
    }
}
