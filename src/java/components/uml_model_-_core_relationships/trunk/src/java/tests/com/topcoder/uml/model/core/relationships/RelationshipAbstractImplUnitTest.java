/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.relationships;

import junit.framework.TestCase;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;

/**
 * Unit test for RelationshipAbstractImpl.
 * We use GeneralizationImpl as its instance to test.
 *
 * @author fanse
 * @version 1.0
 */
public class RelationshipAbstractImplUnitTest extends TestCase {
    /**
     * Test constructor accuracy. No exception will be thrown.
     */
    public void testConstructorAccuracy() {
        RelationshipAbstractImpl ctorImpl = new GeneralizationImpl();

        assertNotNull("The ctorImpl should not be null.", ctorImpl);
    }

    /**
     * Test inheritance of <c>RelationshipAbstractImpl</c>.
     * <c>RelationshipAbstractImpl</c> should inherit from <c>Relationship</c>.
     */
    public void testRelationshipAbstractImplAccuracyInheritRelationship() {
        assertTrue("RelationshipAbstractImpl should inherit from Relationship.",
                ((Object) new GeneralizationImpl()) instanceof Relationship);
    }

    /**
     * Test inheritance of <c>RelationshipAbstractImpl</c>.
     * <c>RelationshipAbstractImpl</c> should inherit from <c>ModelElementAbstractImpl</c>.
     */
    public void testRelationshipAbstractImplAccuracyInheritModelElementAbstractImpl() {
        assertTrue("RelationshipAbstractImpl should inherit from ModelElementAbstractImpl.",
                ((Object) new GeneralizationImpl()) instanceof ModelElementAbstractImpl);
    }
}