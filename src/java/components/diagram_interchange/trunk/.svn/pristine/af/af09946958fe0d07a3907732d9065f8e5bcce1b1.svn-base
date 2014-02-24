/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS Diagram_Interchange Version 1.0 Accuracytests.
 *
 * @ ReferenceAccuracyTests.java
 */
package com.topcoder.diagraminterchange.accuracytests;

import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.Reference;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * The <code>Reference</code>'s Accuracy Tests.
 * This accuracy tests addresses the functionality provided
 * by the <code>Reference</code> class.
 * </p>
 *
 * @author zmg
 * @version 1.0
 */
public class ReferenceAccuracyTests extends TestCase {
    /**
     * <p>
     * The instance of <code>Reference</code> used for tests.
     * </p>
     */
    private Reference test = null;

    /**
     * <p>
     * Test suite of <code>ReferenceAccuracyTests</code>.
     * </p>
     *
     * @return Test suite of <code>ReferenceAccuracyTests</code>.
     */
    public static Test suite() {
        return new TestSuite(ReferenceAccuracyTests.class);
    }

    /**
     * <p>
     * Initialization for all tests here, creats some new instances for accuracy test.
     * </p>
     */
    protected void setUp() {
        test = new Reference();
    }

    /**
     * <p>
     * Accuracy Test of the <code>Reference()</code> constructor.
     * </p>
     */
    public void testConstructor() {
        // creat a new instance.
        assertNotNull("Constructor should work well.", new Reference());

        // get the original value of isIndividualRepresentation to check the constructor
        assertFalse("The isIndividualRepresentation expected to be false",
            test.isIndividualRepresentation());

        // get the original value of graphElement to check the constructor
        assertNull("The graphElement expected to be null", test.getReferenced());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setIndividualRepresentation(boolean)</code> method and
     * <code>isIndividualRepresentation()</code>.
     * </p>
     */
    public void testIndividualRepresentation_Operation() {
        // set to true.
        test.setIndividualRepresentation(true);

        // get the isIndividualRepresentation.
        assertTrue("The isIndividualRepresentation expected to be true",
            test.isIndividualRepresentation());
    }

    /**
     * <p>
     * Accuracy Test of the <code>setReferenced(GraphElement)</code> method and
     * <code>getReferenced()</code>.
     * </p>
     */
    public void testReferenced_Operation() {
        // creat a GraphElement.
        GraphElement graphElement = new GraphEdge();

        // set the graphElement.
        test.setReferenced(graphElement);

        // get the graphElement.
        assertEquals("The graphElement expected to be equal", graphElement,
            test.getReferenced());

        // set the graphElement to null.
        test.setReferenced(null);

        // get the graphElement.
        assertNull("The graphElement expected to be null", test.getReferenced());
    }
}
