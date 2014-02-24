/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS Diagram_Interchange Version 1.0 Accuracytests.
 *
 * @ Uml1SemanticModelBridgeAccuracyTests.java
 */
package com.topcoder.diagraminterchange.accuracytests;

import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;

import com.topcoder.uml.model.core.Element;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * The <code>Uml1SemanticModelBridge</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>Uml1SemanticModelBridge</code> class.
 * </p>
 *
 * @author zmg
 * @version 1.0
 */
public class Uml1SemanticModelBridgeAccuracyTests extends TestCase {
    /**
     * <p>
     * The instance of <code>Uml1SemanticModelBridge</code> used for tests.
     * </p>
     */
    private Uml1SemanticModelBridge test = null;

    /**
     * <p>
     * Test suite of <code>Uml1SemanticModelBridgeAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>Uml1SemanticModelBridgeAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(Uml1SemanticModelBridgeAccuracyTests.class);
    }

    /**
     * <p>
     * Initialization for all tests here, creats some new instances for accuracy test.
     * </p>
     */
    protected void setUp() {
        test = new Uml1SemanticModelBridge();
    }

    /**
     * <p>
     * Accuracy Test of the <code>Uml1SemanticModelBridge()</code> constructor.
     * </p>
     */
    public void testConstructor() {
        // creat a new instance.
        assertNotNull("Constructor should work well.",
            new Uml1SemanticModelBridge());

        // get the original value of element to check the constructor
        assertNull("The element expected to be null", test.getElement());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setElement(Element)</code> method and
     * <code>getElement()</code>.
     * </p>
     */
    public void testElement_Operation() {
        Element element = new MockElement();

        // set the element.
        test.setElement(element);

        // get the element.
        assertEquals("The element expected to be equal", element,
            test.getElement());

        // set the element.
        test.setElement(null);

        // get the element.
        assertNull("The text expected to be null", test.getElement());
    }

    /**
     * <p>
     * A inner class which implements the <code>Element</code> interface, used for
     * accuracy test only.
     * </p>
     */
    class MockElement implements Element {
        // use default constructor.
    }
}
