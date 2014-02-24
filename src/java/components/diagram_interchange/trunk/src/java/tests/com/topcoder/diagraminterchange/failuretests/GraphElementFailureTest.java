/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.diagraminterchange.failuretests;

import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphConnector;
import com.topcoder.diagraminterchange.GraphElement;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Failure test for GraphElement class.
 *
 * @author iamajia
 * @version 1.0
 */
public class GraphElementFailureTest extends TestCase {
    /**
     * Represents a {@link GraphElement} instance that is used in the test.
     */
    private GraphElement graphElement = new GraphElement() {
    };
    /**
     * Represents a contained that is used in the test.
     */
    private DiagramElement contained = new DiagramElement() {
    };
    /**
     * Represents a anchorage that is used in the test.
     */
    private GraphConnector anchorage = new GraphConnector();
    /**
     * Aggregates all tests in this class.
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(GraphElementFailureTest.class);
    }

    /**
     * Failure test of <code>addContained(DiagramElement contained)</code> method.
     *
     * <p>
     * contained is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddContained1FailureNullContained() throws Exception {
        try {
            graphElement.addContained(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }


    /**
     * Failure test of <code>addContained(int index, DiagramElement contained)</code> method.
     *
     * <p>
     * index is negative.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddContained2FailureNegativeIndex() throws Exception {
        try {
            graphElement.addContained(-1, contained);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>addContained(int index, DiagramElement contained)</code> method.
     *
     * <p>
     * index is greater than list size.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddContained2FailureIndexGreaterThanSize() throws Exception {
        try {
            graphElement.addContained(1, contained);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>addContained(int index, DiagramElement contained)</code> method.
     *
     * <p>
     * contained is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddContained2FailureNullContained() throws Exception {
        try {
            graphElement.addContained(0, null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>setContained(int index, DiagramElement contained)</code> method.
     *
     * <p>
     * index is negative.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSetContainedFailureNegativeIndex() throws Exception {
        try {
            graphElement.setContained(-1, contained);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>setContained(int index, DiagramElement contained)</code> method.
     *
     * <p>
     * index is equal to list size.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSetContainedFailureIndexEqualToSize() throws Exception {
        try {
            graphElement.setContained(0, contained);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>setContained(int index, DiagramElement contained)</code> method.
     *
     * <p>
     * contained is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSetContainedFailureNullContained() throws Exception {
        graphElement.addContained(contained);
        try {
            graphElement.setContained(0, null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>removeContained(int index)</code> method.
     *
     * <p>
     * index is negative.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveContainedFailureNegativeIndex() throws Exception {
        try {
            graphElement.removeContained(-1);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>removeContained(int index)</code> method.
     *
     * <p>
     * index is equal to list size.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveContainedFailureIndexEqualToSize() throws Exception {
        try {
            graphElement.removeContained(0);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>removeContained(DiagramElement contained)</code> method.
     *
     * <p>
     * contained is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveContainedFailureNullContained() throws Exception {
        try {
            graphElement.removeContained(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>containsContained(DiagramElement contained)</code> method.
     *
     * <p>
     * contained is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testContainsContainedFailureNullContained() throws Exception {
        try {
            graphElement.containsContained(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>indexOfContained(DiagramElement contained)</code> method.
     *
     * <p>
     * contained is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testIndexOfContainedFailureNullContained() throws Exception {
        try {
            graphElement.containsContained(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>addAnchorage(GraphConnector anchorage)</code> method.
     *
     * <p>
     * anchorage is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddAnchorage1FailureNullAnchorage() throws Exception {
        try {
            graphElement.addAnchorage(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }


    /**
     * Failure test of <code>addAnchorage(int index, GraphConnector anchorage)</code> method.
     *
     * <p>
     * index is negative.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddAnchorage2FailureNegativeIndex() throws Exception {
        try {
            graphElement.addAnchorage(-1, anchorage);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>addAnchorage(int index, GraphConnector anchorage)</code> method.
     *
     * <p>
     * index is greater than list size.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddAnchorage2FailureIndexGreaterThanSize() throws Exception {
        try {
            graphElement.addAnchorage(1, anchorage);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>addAnchorage(int index, GraphConnector anchorage)</code> method.
     *
     * <p>
     * anchorage is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddAnchorage2FailureNullAnchorage() throws Exception {
        try {
            graphElement.addAnchorage(0, null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>setAnchorage(int index, GraphConnector anchorage)</code> method.
     *
     * <p>
     * index is negative.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSetAnchorageFailureNegativeIndex() throws Exception {
        try {
            graphElement.setAnchorage(-1, anchorage);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>setAnchorage(int index, GraphConnector anchorageage)</code> method.
     *
     * <p>
     * index is equal to list size.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSetAnchorageFailureIndexEqualToSize() throws Exception {
        try {
            graphElement.setAnchorage(0, anchorage);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>setAnchorage(int index, GraphConnector anchorage)</code> method.
     *
     * <p>
     * anchorage is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testSetAnchorageFailureNullAnchorage() throws Exception {
        graphElement.addAnchorage(anchorage);
        try {
            graphElement.setAnchorage(0, null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>removeAnchorage(int index)</code> method.
     *
     * <p>
     * index is negative.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveAnchorageFailureNegativeIndex() throws Exception {
        try {
            graphElement.removeAnchorage(-1);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>removeAnchorage(int index)</code> method.
     *
     * <p>
     * index is equal to list size.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveAnchorageFailureIndexEqualToSize() throws Exception {
        try {
            graphElement.removeAnchorage(0);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>removeAnchorage(GraphConnector anchorage)</code> method.
     *
     * <p>
     * anchorage is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveAnchorageFailureNullAnchorage() throws Exception {
        try {
            graphElement.removeAnchorage(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>containsAnchorage(GraphConnector anchorage)</code> method.
     *
     * <p>
     * anchorage is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testContainsAnchorageFailureNullAnchorage() throws Exception {
        try {
            graphElement.containsAnchorage(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>indexOfAnchorage(GraphConnector anchorage)</code> method.
     *
     * <p>
     * anchorage is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testIndexOfAnchorageFailureNullAnchorage() throws Exception {
        try {
            graphElement.containsAnchorage(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
    /**
     * Failure test of <code>addLink(DiagramLink link)</code> method.
     *
     * <p>
     * link is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testAddLinkFailureNullLink() throws Exception {
        try {
            graphElement.addLink(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>removeLink(DiagramLink link)</code> method.
     *
     * <p>
     * link is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testRemoveLinkFailureNullLink() throws Exception {
        try {
            graphElement.removeLink(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * Failure test of <code>containsLink(DiagramLink link)</code> method.
     *
     * <p>
     * link is null.
     * </p>
     *
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void testContainsLinkFailureNullLink() throws Exception {
        try {
            graphElement.containsLink(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }
}
