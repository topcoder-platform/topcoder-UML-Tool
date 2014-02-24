/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.relationships.accuracytests;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.uml.model.core.GeneralizableElementAbstractImpl;
import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.uml.model.core.relationships.AssociationImpl;

/**
 * Accuracy test case of <code>AssociationImpl</code> class. This class tests <code>AssociationImpl</code> for
 * proper behavior. It covers AssociationImpl(), addConnection(AssociationEnd), addConnection(int, AssociationEnd),
 * setConnection(int, AssociationEnd), removeConnection(int), removeConnection(AssociationEnd), clearConnections(),
 * getConnections(), containsConnection(AssociationEnd), indexOfConnection(AssociationEnd), countConnections().
 *
 * @author still
 * @version 1.0
 */
public class AssociationImplAccuracyTest extends TestCase {
    /** different numbers of items in connection operation. */
    private static final int[] DIFFERENT_NUMBERS = new int[] {1, 10, 100, 1000, 3000};

    /** AssociationImpl instance used in this test. */
    private Association instance;

    /**
     * Test suite of AssociationImpl.
     *
     * @return Test suite of AssociationImpl.
     */
    public static Test suite() {
        return new TestSuite(AssociationImplAccuracyTest.class);
    }

    /**
     * Initialization for all tests here.
     */
    protected void setUp() {
        // set up for test
        instance = new AssociationImpl();
    }

    /**
     * Test accuracy of AssociationImpl() method.
     */
    public void testAssociationImpl() {
        assertNotNull("create failed.", instance);
    }

    /**
     * Test AssociationImpl for correct type.
     */
    public void testAssociationImpl_CorrectType() {
        assertEquals("equal value expected.", AssociationImpl.class.getSuperclass(),
                GeneralizableElementAbstractImpl.class);
        assertTrue("true value expected.", Association.class.isAssignableFrom(AssociationImpl.class));
    }

    /**
     * Test accuracy of addConnection(AssociationEnd) method.
     */
    public void testAddConnection() {

        for (int i : DIFFERENT_NUMBERS) {
            List<AssociationEnd> connections = new ArrayList<AssociationEnd>();
            for (int j = 0; j < i; j++) {
                AssociationEnd connection = createMock(AssociationEnd.class);
                replay(connection);
                instance.addConnection(connection);
                // ensure any AssociationEnd method is not called
                verify(connection);
                connections.add(connection);
                assertEquals("equal value expected.", j + 1, instance.countConnections());
            }
            for (AssociationEnd connection : connections) {
                assertTrue("returning true expected.", instance.containsConnection(connection));
            }
            instance.clearConnections();
        }
    }

    /**
     * Test accuracy of addConnection(AssociationEnd) method.
     */
    public void testAddConnection_DuplicateConnection() {
        AssociationEnd connection = createMock(AssociationEnd.class);
        replay(connection);
        for (int i : DIFFERENT_NUMBERS) {
            for (int j = 0; j < i; j++) {
                instance.addConnection(connection);
                assertEquals("equal value expected.", j + 1, instance.countConnections());
            }
            instance.clearConnections();
        }
        // ensure any AssociationEnd method is not called
        verify(connection);
    }

    /**
     * Test accuracy of addConnection(int, AssociationEnd) method.
     */
    public void testAddConnection_IndexAdd() {
        Random rand = new Random();
        for (int i : DIFFERENT_NUMBERS) {
            List<AssociationEnd> connections = new ArrayList<AssociationEnd>();
            for (int j = 0; j < i; j++) {
                AssociationEnd connection = createMock(AssociationEnd.class);
                replay(connection);
                int index = rand.nextInt(instance.countConnections() + 1);
                instance.addConnection(index, connection);
                // ensure any AssociationEnd method is not called
                verify(connection);
                connections.add(connection);
                assertEquals("equal value expected.", j + 1, instance.countConnections());
            }
            for (AssociationEnd connection : connections) {
                assertTrue("returning true expected.", instance.containsConnection(connection));
            }
            instance.clearConnections();
        }
    }

    /**
     * Test accuracy of addConnection(int, AssociationEnd) method.
     */
    public void testAddConnection_IndexAdd_DuplicateConnection() {

        for (int i : DIFFERENT_NUMBERS) {
            AssociationEnd connection = createMock(AssociationEnd.class);
            replay(connection);

            instance.addConnection(connection);
            // we add connection <i> times
            for (int j = 0; j < i; j++) {
                instance.addConnection(j + 1, connection);
            }

            List<AssociationEnd> connections = instance.getConnections();
            for (AssociationEnd each : connections) {
                assertSame("should be same.", connection, each);
            }
            instance.clearConnections();
            // ensure any AssociationEnd method is not called
            verify(connection);
        }

    }

    /**
     * Test accuracy of setConnection(int, AssociationEnd) method.
     */
    public void testSetConnection() {

        for (int i : DIFFERENT_NUMBERS) {
            for (int j = 0; j < i; j++) {
                AssociationEnd connection = createMock(AssociationEnd.class);
                instance.addConnection(connection);
                assertEquals("equal value expected.", j + 1, instance.countConnections());
            }
            AssociationEnd newConnection = createMock(AssociationEnd.class);
            replay(newConnection);
            Random rand = new Random();
            int[] indexs = new int[i];
            for (int j = 0; j < i; j++) {
                int index = rand.nextInt(i);
                indexs[j] = index;
                instance.setConnection(index, newConnection);
            }
            List<AssociationEnd> connections = instance.getConnections();
            for (int index : indexs) {
                assertSame("Should be same.", newConnection, connections.get(index));
            }
            instance.clearConnections();
            // ensure any AssociationEnd method is not called
            verify(newConnection);
        }
    }

    /**
     * Test accuracy of removeConnection(int) method.
     */
    public void testRemoveConnection_Index() {

        for (int i : DIFFERENT_NUMBERS) {
            List<AssociationEnd> connections = new ArrayList<AssociationEnd>();
            for (int j = 0; j < i; j++) {
                AssociationEnd connection = createMock(AssociationEnd.class);
                instance.addConnection(connection);
                connections.add(connection);
            }

            AssociationEnd newConnection = createMock(AssociationEnd.class);
            replay(newConnection);
            Random rand = new Random();
            int index = rand.nextInt(i);
            instance.setConnection(index, newConnection);
            assertSame("Should be same.", newConnection, instance.removeConnection(index));
            assertEquals("equal value expected.", i - 1, instance.countConnections());

            // ensure the code removes the right connection
            for (AssociationEnd connection : connections) {
                // the index's connection has been removed
                if (connections.get(index) != connection) {
                    assertTrue("returning true expected.", instance.containsConnection(connection));
                }
            }

            // newConnection has been removed
            assertFalse("returning false expected.", instance.containsConnection(newConnection));
            instance.clearConnections();
            // ensure any AssociationEnd method is not called
            verify(newConnection);
        }
    }

    /**
     * Test accuracy of removeConnection(AssociationEnd) method.
     */
    public void testRemoveConnection_AssociationEnd() {
        for (int i : DIFFERENT_NUMBERS) {
            for (int j = 0; j < i; j++) {
                AssociationEnd connection = createMock(AssociationEnd.class);
                instance.addConnection(connection);
            }
            List<AssociationEnd> returnedConnections = instance.getConnections();

            for (int j = returnedConnections.size() - 1; j >= 0; j--) {
                replay(returnedConnections.get(j));
                assertTrue("returning true expected.", instance.removeConnection(returnedConnections.get(j)));
                verify(returnedConnections.get(j));
            }
            assertEquals("equal value expected.", 0, instance.countConnections());
        }
    }

    /**
     * Test accuracy of removeConnection(AssociationEnd) method.
     */
    public void testRemoveConnection_AssociationEnd2() {
        for (int i : DIFFERENT_NUMBERS) {
            for (int j = 0; j < i; j++) {
                AssociationEnd connection = createMock(AssociationEnd.class);
                instance.addConnection(connection);
            }
            List<AssociationEnd> returnedConnections = instance.getConnections();

            for (AssociationEnd each : returnedConnections) {
                assertTrue("returning true expected.", instance.removeConnection(each));
            }
            assertEquals("equal value expected.", 0, instance.countConnections());
        }
    }

    /**
     * Test accuracy of removeConnection(AssociationEnd) method.
     */
    public void testRemoveConnection_NotExistedConnection() {
        for (int i : DIFFERENT_NUMBERS) {
            for (int j = 0; j < i; j++) {
                AssociationEnd connection = createMock(AssociationEnd.class);
                instance.addConnection(connection);
            }
            AssociationEnd newConnection = createMock(AssociationEnd.class);
            replay(newConnection);
            assertFalse("returning false expected.", instance.removeConnection(newConnection));
            // ensure any AssociationEnd method is not called
            verify(newConnection);

            assertEquals("equal value expected.", i, instance.countConnections());
            instance.clearConnections();

        }
    }

    /**
     * Test accuracy of removeConnection(AssociationEnd) method.
     */
    public void testRemoveConnection_DuplicateConnection() {
        for (int i : DIFFERENT_NUMBERS) {
            AssociationEnd connection = createMock(AssociationEnd.class);
            instance.addConnection(connection);
            // we add connection <i> times
            for (int j = 1; j < i; j++) {
                instance.addConnection(j, connection);
            }
            replay(connection);
            for (int j = 0; j < i; j++) {
                assertEquals("equal value expected.", i - j, instance.countConnections());
                assertTrue("returning true expected.", instance.removeConnection(connection));
                assertEquals("equal value expected.", i - j - 1, instance.countConnections());
            }
            // ensure any AssociationEnd method is not called
            verify(connection);
        }

    }

    /**
     * Test accuracy of clearConnections() method.
     */
    public void testClearConnections() {
        for (int i : DIFFERENT_NUMBERS) {
            for (int j = 0; j < i; j++) {
                AssociationEnd connection = createMock(AssociationEnd.class);
                instance.addConnection(connection);
            }
            instance.clearConnections();
            assertEquals("equal value expected.", 0, instance.countConnections());
        }
    }

    /**
     * Test accuracy of clearConnections() method.
     */
    public void testClearConnections_NoConnectionContained() {
        assertEquals("equal value expected.", 0, instance.countConnections());
        instance.clearConnections();
        assertEquals("equal value expected.", 0, instance.countConnections());
    }

    /**
     * Test accuracy of getConnections() method.
     */
    public void testGetConnections() {
        // no connection is in instance
        assertEquals("equal value expected.", new ArrayList<AssociationEnd>(), instance.getConnections());
        for (int i : DIFFERENT_NUMBERS) {
            for (int j = 0; j < i; j++) {
                AssociationEnd connection = createMock(AssociationEnd.class);
                instance.addConnection(connection);
            }
            List<AssociationEnd> returnedConnections = instance.getConnections();
            assertEquals("The right size expected.", i, returnedConnections.size());
            // ensure we get the right connections
            for (AssociationEnd each : returnedConnections) {
                assertSame("Should be same.", each, instance.removeConnection(0));
            }
        }

    }

    /**
     * Test accuracy of containsConnection(AssociationEnd) method.
     */
    public void testContainsConnection() {
        for (int i : DIFFERENT_NUMBERS) {

            for (int j = 0; j < i; j++) {
                AssociationEnd connection = createMock(AssociationEnd.class);
                instance.addConnection(connection);
                assertTrue("returning true expected.", instance.containsConnection(connection));

            }

            AssociationEnd newConnection = createMock(AssociationEnd.class);
            replay(newConnection);
            assertFalse("returning false expected.", instance.containsConnection(newConnection));
            verify(newConnection);

            instance.clearConnections();
        }
    }

    /**
     * Test accuracy of indexOfConnection(AssociationEnd) method.
     */
    public void testIndexOfConnection() {

        for (int i : DIFFERENT_NUMBERS) {
            List<AssociationEnd> connections = new ArrayList<AssociationEnd>();
            for (int j = 0; j < i; j++) {
                AssociationEnd connection = createMock(AssociationEnd.class);
                instance.addConnection(connection);
                connections.add(connection);
            }

            AssociationEnd newConnection = createMock(AssociationEnd.class);
            Random rand = new Random();
            int index = rand.nextInt(i);
            instance.setConnection(index, newConnection);
            replay(newConnection);
            assertEquals("equal value expected.", index, instance.indexOfConnection(newConnection));
            verify(newConnection);
            instance.clearConnections();
        }
    }

    /**
     * Test accuracy of indexOfConnection(AssociationEnd) method.
     *
     */
    public void testIndexOfConnection_DuplicateConnection() {

        for (int i : DIFFERENT_NUMBERS) {
            List<AssociationEnd> connections = new ArrayList<AssociationEnd>();
            for (int j = 0; j < i; j++) {
                AssociationEnd connection = createMock(AssociationEnd.class);
                instance.addConnection(connection);
                connections.add(connection);
            }

            AssociationEnd newConnection = createMock(AssociationEnd.class);
            Random rand = new Random();
            int index = rand.nextInt(i);
            instance.setConnection(index, newConnection);
            // add 4 newConnection's to the end
            instance.addConnection(newConnection);
            instance.addConnection(newConnection);
            instance.addConnection(newConnection);
            instance.addConnection(newConnection);
            replay(newConnection);
            assertEquals("equal value expected.", index, instance.indexOfConnection(newConnection));
            verify(newConnection);
            instance.clearConnections();
        }
    }

    /**
     * Test accuracy of indexOfConnection(AssociationEnd) method.
     */
    public void testIndexOfConnection_NotExistedConnection() {

        for (int i : DIFFERENT_NUMBERS) {
            List<AssociationEnd> connections = new ArrayList<AssociationEnd>();
            for (int j = 0; j < i; j++) {
                AssociationEnd connection = createMock(AssociationEnd.class);
                instance.addConnection(connection);
                connections.add(connection);
            }

            AssociationEnd newConnection = createMock(AssociationEnd.class);
            replay(newConnection);
            assertEquals("equal value expected.", -1, instance.indexOfConnection(newConnection));
            verify(newConnection);
            instance.clearConnections();
        }
    }

    /**
     * Test accuracy of countConnections() method.
     */
    public void testCountConnections() {

        for (int i : DIFFERENT_NUMBERS) {
            for (int j = 0; j < i; j++) {
                AssociationEnd connection = createMock(AssociationEnd.class);
                instance.addConnection(0, connection);
                replay(connection);
                assertEquals("equal value expected.", j + 1, instance.countConnections());
                verify(connection);
            }
            instance.clearConnections();
        }
    }

}
