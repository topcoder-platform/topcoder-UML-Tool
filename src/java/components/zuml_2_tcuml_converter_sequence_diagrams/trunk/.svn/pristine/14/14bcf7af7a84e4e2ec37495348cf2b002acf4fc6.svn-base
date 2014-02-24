/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.model.impl;

import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.core.Classifier;

import com.topcoder.umltool.xmiconverters.poseidon5.model.Lifeline;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * Unit tests for <code>LifelineImpl</code> class.
 * </p>
 *
 * @author zhengjuyu
 * @version 1.0
 */
public class LifelineImplUnitTest extends TestCase {
    /**
     * <p>Returns the test suite of this class.</p>
     *
     * @return the test suite of this class.
     */
    public static Test suite() {
        return new TestSuite(LifelineImplUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for constructor <code>LifelineImpl()</code>.
     * </p>
     */
    public void testCtor() {
        Lifeline line = new LifelineImpl();
        assertNotNull("Unable to create LifelineImpl instance.", line);
    }

    /**
     * <p>
     * Accuracy test for <code>toTCUMLElement()</code>.
     * Verify whether the Lifeline is transformed to Object successfully,
     * the generated Object should have the same name and Classifier to the Lifeline's.
     * </p>
     */
    public void testToTCUMLElement1() {
        Attribute attr = new AttributeImpl();
        Classifier type = new InteractionImpl();

        //Set the type to Interaction
        attr.setType(type);

        Lifeline line = new LifelineImpl();
        line.setRepresents(attr);
        line.setName("line");

        Object object = line.toTCUMLElement();

        assertNotNull("Unable to translation the Lifeline to TCUML element.",
            object);
        assertEquals("The name should match.", "line", object.getName());
        assertEquals("The classifier should match.", type,
            object.getClassifier());
    }

    /**
     * <p>
     * Accuracy test for <code>toTCUMLElement()</code>.
     * Verify that the toTCUMLElement should always return the same instance.
     * </p>
     */
    public void testToTCUMLElement2() {
        Attribute attr = new AttributeImpl();
        Classifier type = new InteractionImpl();

        //Set the type to Interaction
        attr.setType(type);

        Lifeline line = new LifelineImpl();
        line.setRepresents(attr);
        line.setName("line");

        assertEquals("The toTCUMLElement should return the same element.",
            line.toTCUMLElement(), line.toTCUMLElement());
    }

    /**
     * <p>
     * Accuracy test for <code>setRepresents(Attribute)</code>.
     * </p>
     */
    public void testSetRepresents() {
        Lifeline line = new LifelineImpl();

        Attribute attr = new AttributeImpl();
        line.setRepresents(attr);
        assertEquals("The attribute should match.", attr, line.getRepresents());

        line.setRepresents(null);
        assertNull("The attribute should be set to null.", line.getRepresents());
    }

    /**
     * <p>
     * Accuracy test for <code>setGetRepresents(Attribute)</code>.
     * </p>
     */
    public void testGetRepresents() {
        Lifeline line = new LifelineImpl();

        assertNull("The attribute should be set to null as default.",
            line.getRepresents());

        Attribute attr = new AttributeImpl();
        line.setRepresents(attr);
        assertEquals("The attribute should match.", attr, line.getRepresents());
    }
}
