/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS Diagram_Interchange Version 1.0 Accuracytests.
 *
 * @ SimpleSemanticModelElementAccuracyTests.java
 */
package com.topcoder.diagraminterchange.accuracytests;

import com.topcoder.diagraminterchange.SimpleSemanticModelElement;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * The <code>SimpleSemanticModelElement</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>SimpleSemanticModelElement</code> class.
 * </p>
 *
 * @author zmg
 * @version 1.0
 */
public class SimpleSemanticModelElementAccuracyTests extends TestCase {
    /**
     * <p>
     * The instance of <code>SimpleSemanticModelElement</code> used for tests.
     * </p>
     */
    private SimpleSemanticModelElement test = null;

    /**
     * <p>
     * The array of <code>String</code> used for tests.
     * </p>
     */
    private String [] typeInfoes = null;
    /**
     * <p>
     * Test suite of <code>SimpleSemanticModelElementAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>SimpleSemanticModelElementAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(SimpleSemanticModelElementAccuracyTests.class);
    }

    /**
     * <p>
     * Initialization for all tests here, creats some new instances for accuracy test.
     * </p>
     */
    protected void setUp() {
        test = new SimpleSemanticModelElement();
        typeInfoes = new String [] {"Top", "Coder", "Dev", "Des"};
    }

    /**
     * <p>
     * Accuracy Test of the <code>SimpleSemanticModelElement()</code> constructor.
     * </p>
     */
    public void testConstructor() {
        // creat a new instance.
        assertNotNull("Constructor should work well.", new SimpleSemanticModelElement());

        // get the original value of typeInfo to check the constructor
        assertNull("The typeInfo expected to be null", test.getTypeInfo());
    }

    /**
     * <p>
     * Accuracy Test of the <code>getTypeInfo()</code> method and
     * <code>setTypeInfo(String)</code>.
     * </p>
     */
    public void testTypeInfo_Operation() {
        for (String typeInfo : typeInfoes) {
            // set the typeInfo.
            test.setTypeInfo(typeInfo);
            // get the typeInfo.
            assertEquals("The text expected to be equal", typeInfo,
                test.getTypeInfo());
        }
        // set the typeInfo to null.
        test.setTypeInfo(null);
         // get the typeInfo.
        assertNull("The typeInfo expected to be null", test.getTypeInfo());
    }
}
