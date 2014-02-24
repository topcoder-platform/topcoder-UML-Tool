/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.relationships.accuracytests;

import com.topcoder.uml.model.core.ModelElementAbstractImpl;
import com.topcoder.uml.model.core.relationships.Relationship;
import com.topcoder.uml.model.core.relationships.RelationshipAbstractImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * Accuracy test case of <code>RelationshipAbstractImpl</code> class.
 * This class tests <code>RelationshipAbstractImpl</code> for proper behavior. It covers
 * RelationshipAbstractImpl().
 *
 * @author still
 * @version 1.0
 */
public class RelationshipAbstractImplAccuracyTest extends TestCase {
    /** RelationshipAbstractImpl instance for accuracy test. */
    private RelationshipAbstractImpl instance;

    /**
     * Test suite of RelationshipAbstractImpl.
     *
     * @return Test suite of RelationshipAbstractImpl.
     */
    public static Test suite() {
        return new TestSuite(RelationshipAbstractImplAccuracyTest.class);
    }

    /**
     * Initialization for all tests here.
     */
    protected void setUp() {
        // set up for test
        instance = new RelationshipAbstractImpl() {
        };
    }

    /**
     * Test accuracy of RelationshipAbstractImpl() method.
     */
    public void testRelationshipAbstractImpl() {
        assertNotNull("create failed.", instance);
    }

    /**
     * Test class RelationshipAbstractImpl for correct type.
     */
    public void testRelationshipAbstractImpl_CorrectType() {
        assertEquals("equal value expected.",
                RelationshipAbstractImpl.class.getSuperclass(), ModelElementAbstractImpl.class);
        assertTrue("true value expected.",
                Relationship.class.isAssignableFrom(RelationshipAbstractImpl.class));
    }
}
