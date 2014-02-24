/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.xmi.reader.handlers.uml.model.failuretests;

import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.xmi.reader.XMIReader;
import com.topcoder.xmi.reader.handlers.modelfactory.ModelElementFactory;
import com.topcoder.xmi.reader.handlers.uml.model.XMI2ModelHandler;

import junit.framework.TestCase;
/**
 * The failure test of the XMI2ModelHandler class.
 *
 * @author telly12
 * @version 1.0
 *
 */
public class XMI2ModelHandlerTests extends TestCase {
    /**
     * <p>
     * XMI2ModelHandler instance for testing.
     * </p>
     */
    private XMI2ModelHandler handler;

    /**
     * <p>
     * XMIReader instance for helping testing.
     * </p>
     */
    private XMIReader reader;
    /**
     * The namespace.
     */
    private static final String NAMESPACE = "com.topcoder.xmi.reader.handlers.uml.model.ModelElementFactory";
    /**
     * The ModelElementFactory instance for test.
     */
    private ModelElementFactory factory = null;
    /**
     * The setUp of the failure test.
     *
     * @throws Exception to JUnit
     */
    protected void setUp() throws Exception {
        FailureTestHelper.clearConfig();
        FailureTestHelper.addConfig();
        
        reader = new XMIReader();
        handler = new XMI2ModelHandler();
        factory = new ModelElementFactory(NAMESPACE);
    }

    /**
     * The tearDown.
     *
     * @throws Exception to JUnit
     */
    protected void tearDown() throws Exception {
        FailureTestHelper.clearConfig();
    }
    /**
     * The failure test of the constructor,
     * fail for the XMIReader is null,
     * IllegalArgumentException should be thrown.
     *
     */
    public void test_failure_constructor1() {
        try {
            new XMI2ModelHandler(null, factory, new UMLModelManager());
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            //pass
        }
    }
    /**
     * The failure test of the constructor,
     * fail for the factory is null,
     * IllegalArgumentException should be thrown.
     *
     */
    public void test_failure_constructor2() {
        try {
            new XMI2ModelHandler(reader, null, new UMLModelManager());
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            //pass
        }
    }
    /**
     * The failure test of the constructor,
     * fail for the UMLModelManager is null,
     * IllegalArgumentException should be thrown.
     *
     */
    public void test_failure_constructor3() {
        try {
            new XMI2ModelHandler(reader, factory, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            //pass
        }
    }
    /**
     * The failure test of the method setModelElementFactory,
     * fail for the parameter is null,
     * IllegalArgumentException should be thrown.
     *
     */
    public void test_failure_setModelElementFactory() {
        try {
            handler.setModelElementFactory(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            
        }
    }
    /**
     * The failure test of the method setUmlModelManager,
     * fail for the parameter is null,
     * IllegalArgumentException should be thrown.
     *
     */
    public void test_failure_setUmlModelManager() {
        try {
            handler.setUmlModelManager(null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException e) {
            
        }
    }
}
