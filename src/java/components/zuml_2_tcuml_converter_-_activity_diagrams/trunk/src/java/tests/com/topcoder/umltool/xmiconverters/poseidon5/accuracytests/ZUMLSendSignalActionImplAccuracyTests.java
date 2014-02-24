/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.accuracytests;

import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.statemachines.FinalState;

import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLSendSignalActionImpl;

import junit.framework.TestCase;


/**
 * The accuracy tests for the class ZUMLSendSignalActionImpl.
 *
 * @author KLW
 * @version 1.0
 */
public class ZUMLSendSignalActionImplAccuracyTests extends TestCase {
    /**
     * The accuracy test for the method {@link ZUMLSendSignalActionImpl#convertToTCUML()}.
     */
    public void testConvertToTCUML() {
        ZUMLSendSignalActionImpl instance = new ZUMLSendSignalActionImpl();
        instance.setName("action");

        Namespace namespace = new CollaborationImpl();
        instance.setNamespace(namespace);

        instance.setVisibility(null);
        instance.setSpecification(true);

        ModelElement element = instance.convertToTCUML();

        assertTrue(element instanceof FinalState);

        assertEquals(1, element.getTaggedValues().size());

        TaggedValue taggedValue = (TaggedValue) element.getTaggedValues().toArray()[0];
        assertEquals("True", taggedValue.getDataValue());
        assertEquals("SendSignalAction", taggedValue.getType().getTagType());

        assertEquals("action", element.getName());
        assertEquals(namespace, element.getNamespace());
        assertNull(element.getVisibility());
        assertTrue(element.isSpecification());
    }
}
