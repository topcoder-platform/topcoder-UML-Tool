/*
 * Copyright (C) 2005 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.relationships.stresstests;

import java.util.List;

import com.topcoder.uml.model.core.relationships.AssociationClassImpl;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.AssociationEndImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Stress test case for AssociationClassImpl.
 * </p>
 * 
 * @author catcher
 * @version 1.0
 */
public class AssociationClassImplStressTest extends TestCase {
    /**
     * Represents the number of requests to process, used in stress tests.
     */
    private static final int MAX_COUNT = 1000;

    /**
     * Represents the number of association, used in stress tests.
     */
    private static final int MAX_NUM = 1000;

    /**
     * Keep the instance of the <c>AssociationClassImpl</c> for test.
     */
    private AssociationClassImpl association;

    /**
     * create <c>AssociationClassImpl</c> instance.
     * 
     * @throws Exception
     *         into Junit
     */
    protected void setUp() throws Exception {
        association = new AssociationClassImpl();
        for (int i = 0; i < MAX_NUM; i++) {
            association.addConnection(new AssociationEndImpl());
        }
    }

    /**
     * Stree test for <c>addConnection</c>.
     * 
     * @throws Exception
     *         into Junit
     */
    public void testAddConnection() throws Exception {
        // Get the copy of the association ends should be return.
        List<AssociationEnd> ends = association.getConnections();
        for (int i = 1; i <= MAX_COUNT; i++) {
            // create the new end
            AssociationEnd newEnd = new AssociationEndImpl();
            // add the new end into the association to the end
            association.addConnection(ends.size(), newEnd);

            // Get the copy of the association ends should be return.
            List<AssociationEnd> newEnds = association.getConnections();
            assertFalse("the old copy should not contain the new end.", ends.contains(newEnd));
            assertTrue("the new copy should contain the new end.", newEnds.contains(newEnd));
            assertEquals("the new end should be add and the old copy should not be changed", ends.size() + i, newEnds
                            .size());
        }
    }

    /**
     * Stree test for <c>indexOfConnection</c>.
     * 
     * @throws Exception
     *         into Junit
     */
    public void testIndexOfConnection() throws Exception {
        // Get the copy of the association ends should be return.
        List<AssociationEnd> ends = association.getConnections();
        for (int i = 1; i <= MAX_COUNT; i++) {
            // create the new end
            AssociationEnd newEnd = new AssociationEndImpl();
            // add the new end into the association
            association.addConnection(ends.size(), newEnd);
            assertEquals("the index should be just the old copy end", ends.size(), association
                            .indexOfConnection(newEnd));
        }
    }
    

    /**
     * Stree test for <c>removeConnection</c>.
     * 
     * @throws Exception
     *         into Junit
     */
    public void testRemoveConnection() throws Exception {
        // Get the copy of the association ends should be return.
        List<AssociationEnd> ends = association.getConnections();
        for (int i = 1; i <= MAX_COUNT; i++) {
            // create the new end
            AssociationEnd newEnd = new AssociationEndImpl();
            // add the new end into the association
            association.addConnection(ends.size(), newEnd);
            assertTrue("the new end should be removed", association
                            .removeConnection(newEnd));
        }
    }

}