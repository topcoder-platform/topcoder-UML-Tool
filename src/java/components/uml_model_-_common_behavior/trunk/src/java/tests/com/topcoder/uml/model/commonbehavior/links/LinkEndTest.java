/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.commonbehavior.links;

import com.topcoder.uml.model.core.ModelElement;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;


/**
 * <p>
 * Unit test for <code>LinkEnd</code> class.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class LinkEndTest extends TestCase {
    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        TestSuite suite = new TestSuite(LinkEndTest.class);

        return suite;
    }

    /**
     * <p>
     * Tests inheritance of <code>LinkEnd</code>.
     * <code>LinkEnd</code> should inherit from <code>ModelElement</code>.
     * </p>
     */
    public void testLinkEndAccuracyInheritModelElement() {
        assertTrue("LinkEnd should inherit from ModelElement",
            LinkEnd.class.getInterfaces()[0].equals(ModelElement.class));
    }
}
