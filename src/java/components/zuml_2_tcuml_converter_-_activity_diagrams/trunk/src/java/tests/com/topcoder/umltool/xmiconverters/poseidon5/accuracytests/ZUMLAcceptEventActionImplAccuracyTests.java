/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.accuracytests;

import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Namespace;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.statemachines.SimpleStateImpl;

import com.topcoder.umltool.xmiconverters.poseidon5.activity.impl.ZUMLAcceptEventActionImpl;

import junit.framework.TestCase;


/**
 * Thea accuracy tests for the class ZUMLAcceptEventActionImpl.
 *
 * @author KLW
 * @version 1.0
 */
public class ZUMLAcceptEventActionImplAccuracyTests extends TestCase {
    /**
     * the accuracy test for the method {@link ZUMLAcceptEventActionImpl#convertToTCUML()}.
     *
     */
    public void testConvertToTCUML() {
        ZUMLAcceptEventActionImpl instance = new ZUMLAcceptEventActionImpl();
        instance.setName("accept");

        Namespace namespace = new CollaborationImpl();
        instance.setNamespace(namespace);
        instance.setVisibility(null);
        instance.setSpecification(true);

        ModelElement element = instance.convertToTCUML();
        assertNotNull("the element should not be null.", element);
        assertTrue(element instanceof SimpleStateImpl);
        assertEquals("There is only 1 taggedValue.", 1, element.getTaggedValues().size());

        TaggedValue taggedValue = (TaggedValue) element.getTaggedValues().toArray()[0];
        assertEquals("The data value is True.", "True", taggedValue.getDataValue());
        assertEquals("Its type's tagType is AcceptEventAction.", "AcceptEventAction",
            taggedValue.getType().getTagType());
        assertEquals("The name should match.", "accept", element.getName());
        assertEquals("The namespace should match.", namespace, element.getNamespace());
        assertNull("The visibility is set to null.", element.getVisibility());
        assertTrue("The specification is set to true.", element.isSpecification());
    }
}
