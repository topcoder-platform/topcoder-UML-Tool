/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.writer.transformers.model.xmidescription;

import com.topcoder.uml.xmi.writer.transformers.model.Implement1;
import com.topcoder.uml.xmi.writer.transformers.model.Interface1;
import com.topcoder.xmi.writer.transformers.model.ChildDescription;
import com.topcoder.xmi.writer.transformers.model.ConfigurationException;
import com.topcoder.xmi.writer.transformers.model.TestHelper;
import com.topcoder.xmi.writer.transformers.model.XMIDescription;
import com.topcoder.xmi.writer.transformers.model.XMIElementDescription;
import com.topcoder.xmi.writer.transformers.model.xmidescription.ReflectedXMIDescription;

import junit.framework.TestCase;
/**
 * <p>
 * Unit test cases for ReflectedXMIDescription.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ReflectedXMIDescriptionTests extends TestCase {
    /**
     * The namespace.
     */
    private static final String NAMESPACE
        = "com.topcoder.xmi.writer.transformers.model.xmidescription.ReflectedXMIDescription";
    /**
     * The ReflectedXMIDescription instance for test.
     */
    private ReflectedXMIDescription reflectedXMIDescription = null;
    /**
     * The setUp of the unit test.
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        TestHelper.clearConfig();
        TestHelper.addConfig();
        
        reflectedXMIDescription = new ReflectedXMIDescription(NAMESPACE);
    }
    /**
     * The tearDown, clear the configuration.
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        TestHelper.clearConfig();
    }
    /**
     * The accuracy test of the constructor.
     *
     */
    public void test_constructor_accuracy() {
        assertNotNull("can not create the ReflectedXMIDescription instance.", reflectedXMIDescription);
    }
    /**
     * The failure test of the constructor,
     * fail for the namespace is null,
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit
     */
    public void test_constructor_failure1() throws Exception {
        try {
            new ReflectedXMIDescription(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            //ok
        }
    }
    /**
     * The failure test of the constructor,
     * fail for the namespace is an empty String,
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit
     */
    public void test_constructor_failure2() throws Exception {
        try {
            new ReflectedXMIDescription(" ");
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            //ok
        }
    }
    /**
     * The failure test of the constructor,
     * fail for the namespace is unknown,
     * ConfigurationException should be thrown.
     *
     * @throws Exception to JUnit
     */
    public void test_constructor_failure3() throws Exception {
        try {
            new ReflectedXMIDescription("unknown namespace");
            fail("ConfigurationException should be thrown.");
        } catch (ConfigurationException e) {
            //ok
        }
    }
    /**
     * Inheritance test.
     */
    public void test_Inheritance() {
        assertTrue("ReflectedXMIDescription not implements XMIDescription.",
                reflectedXMIDescription instanceof XMIDescription);
    }
    /**
     * The failure test of the method <code>getXMIElementDescription</code>,
     * fail for the type is null,
     * IllegalArgumentException should be thrown.
     *
     * @throws Exception to JUnit
     */
    public void test_getXMIElementDescription_failure() throws Exception {
        try {
            reflectedXMIDescription.getXMIElementDescription(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            //ok
        }
    }
    /**
     * The accuracy test of the method <code>getXMIElementDescription</code>,
     * the class or interface is not registered in the description,
     * null will be return.
     *
     * @throws Exception to JUnit
     */
    public void test_getXMIElementDescription_accuracy1() throws Exception {
        assertNull("The XMIElement Desciption should not be retrieved.",
                reflectedXMIDescription.getXMIElementDescription(Object.class));
    }
    /**
     * The accuracy test of the method <code>getXMIElementDescription</code>,
     * the class or interface is configed,
     * non-null will be return.
     *
     * @throws Exception to JUnit
     */
    public void test_getXMIElementDescription_accuracy2() throws Exception {
        XMIElementDescription elementDescription = reflectedXMIDescription.getXMIElementDescription(Interface1.class);
        assertNotNull("The XMIElementDescription should be retrieved successfully.", elementDescription);
        assertEquals("The attributes are not created correctly.", 2, elementDescription.getAttributes().size());
        assertEquals("The children are not created correctly.", 4, elementDescription.getChildren().size());
        int refrenceAcount = 0;
        for(ChildDescription child : elementDescription.getChildren()) {
            if(child.isReference()) {
                refrenceAcount ++;
            }
        }

        assertEquals("The reference child is not retrieved properly.", 2, refrenceAcount);
    }
    /**
     * The accuracy test of the method <code>getXMIElementDescription</code>,
     * the class or interface is configed, actually it is a Class not an interface,
     * non-null will be return.
     *
     * @throws Exception to JUnit
     */
    public void test_getXMIElementDescription_accuracy3() throws Exception {
        XMIElementDescription elementDescription = reflectedXMIDescription.getXMIElementDescription(Implement1.class);
        assertNotNull("The XMIElementDescription should be retrieved successfully.", elementDescription);
        assertEquals("The attributes are not created correctly.", 2, elementDescription.getAttributes().size());
        assertEquals("The children are not created correctly.", 4, elementDescription.getChildren().size());
        int refrenceAcount = 0;
        for(ChildDescription child : elementDescription.getChildren()) {
            if(child.isReference()) {
                refrenceAcount ++;
            }
        }

        assertEquals("The refrence child is not retrieved properly.", 2, refrenceAcount);
    }
}
