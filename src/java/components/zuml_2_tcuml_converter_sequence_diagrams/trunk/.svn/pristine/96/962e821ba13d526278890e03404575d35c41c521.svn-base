/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.umltool.xmiconverters.poseidon5.accuracytests;

import com.topcoder.umltool.xmiconverters.poseidon5.model.impl.LifelineImpl;

import com.topcoder.uml.model.commonbehavior.instances.Object;

import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.AttributeImpl;

import com.topcoder.uml.model.core.classifiers.ClassImpl;

import junit.framework.TestCase;

/**
 * Accuracy tests for <code>LifelineImpl</code>.
 *
 * @author RachaelLCook
 * @version 1.0
 */

public class LifelineImplTests extends TestCase {

    /**
     * An instance of <code>LifelineImpl</code> for test.
     */
    private LifelineImpl lifelineImpl;

    /**
     * Setup the test environment.
     * @throws Exception
     *             if error occurs
     */
    protected void setUp() throws Exception {
        super.setUp();
        lifelineImpl = new LifelineImpl();
    }

    /**
     * Tear down the test environment.
     * @throws Exception
     *             if error occurs
     */
    protected void tearDown() throws Exception {
        lifelineImpl = null;
        super.tearDown();
    }

    /**
     * Test method for 'LifelineImpl()'. Instance should be created successfully.
     */
    public void testLifelineImpl() {
        assertNotNull("Instance should be created successfully. ", lifelineImpl);
    }

    /**
     * Test method for 'toTCUMLElement()'. The name in transformed objectNode should equals to that of lifelineImpl.
     */
    public void testToTCUMLElement_Name() {
        lifelineImpl.setName("test name");
        Object object = lifelineImpl.toTCUMLElement();
        assertEquals("The name in transformed object should equals to that of lifelineImpl.", object.getName(),
                lifelineImpl.getName());
    }

    /**
     * Test method for 'toTCUMLElement()'. The classifier in transformed objectNode should equals to the type of
     * represents in lifelineImpl.
     */
    public void testToTCUMLElement_Classifier() {
        Attribute represents = new AttributeImpl();
        represents.setType(new ClassImpl());
        lifelineImpl.setRepresents(represents);
        Object object = lifelineImpl.toTCUMLElement();
        assertEquals("The name in transformed object should equals to that of lifelineImpl.", object.getClassifier(),
                lifelineImpl.getRepresents().getType());
    }

    /**
     * Test method for 'toTCUMLElement()'. The returned instance must always the same for every call of this method.
     */
    public void testToTCUMLElement_Consistent() {
        Object object1 = lifelineImpl.toTCUMLElement();
        Object object2 = lifelineImpl.toTCUMLElement();
        assertEquals("The returned instance must always the same for every call of this method.", object1, object2);
    }

    /**
     * Test method for 'setRepresents(Attribute)'. represents should be set successfully.
     */
    public void testSetRepresents() {
        Attribute represents = new AttributeImpl();
        lifelineImpl.setRepresents(represents);
        assertEquals("Sets the represent failed.", represents, lifelineImpl.getRepresents());
    }

    /**
     * Test method for 'getRepresents()'. represents should be returned successfully.
     */
    public void testGetRepresents() {
        Attribute represents = new AttributeImpl();
        lifelineImpl.setRepresents(represents);
        assertEquals("Sets the represent failed.", represents, lifelineImpl.getRepresents());
    }
}
