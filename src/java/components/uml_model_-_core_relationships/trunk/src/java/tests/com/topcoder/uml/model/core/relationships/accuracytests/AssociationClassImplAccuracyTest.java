/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.relationships.accuracytests;

import java.util.ArrayList;

import com.topcoder.uml.model.core.relationships.Association;
import com.topcoder.uml.model.core.relationships.AssociationClassImpl;
import com.topcoder.uml.model.core.relationships.AssociationEnd;

import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.easymock.EasyMock.expect;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Accuracy test case of <code>AssociationClassImpl</code> class. This class tests
 * <code>AssociationClassImpl</code> for proper behavior. It covers AssociationClassImpl(),
 * AssociationClassImpl(Association), addConnection(AssociationEnd) , addConnection(int, AssociationEnd),
 * setConnection(int, AssociationEnd), removeConnection(int), removeConnection(AssociationEnd), clearConnections(),
 * getConnections(), containsConnection(AssociationEnd), indexOfConnection(AssociationEnd), countConnections().
 *
 * @author still
 * @version 1.0
 */
public class AssociationClassImplAccuracyTest extends TestCase {
    /** AssociationClassImpl instance used in this test. */
    private AssociationClassImpl instance;

    /**
     * Test suite of AssociationClassImpl.
     *
     * @return Test suite of AssociationClassImpl.
     */
    public static Test suite() {
        return new TestSuite(AssociationClassImplAccuracyTest.class);
    }

    /**
     * Initialization for all tests here.
     */
    protected void setUp() {
        // set up for test
        instance = new AssociationClassImpl();

    }

    /**
     * Test accuracy of AssociationClassImpl() method.
     */
    public void testAssociationClassImpl() {
        assertNotNull("create failed.", instance);
        // test if association is successfully created
        assertEquals("equal value expected.", 0, instance.getConnections().size());
    }

    /**
     * Test accuracy of AssociationClassImpl(Association) method.
     */
    public void testAssociationClassImpl_Association() {
        Association mock = createMock(Association.class);
        replay(mock);
        instance = new AssociationClassImpl();
        assertNotNull("create failed.", instance);
        verify(mock);
    }

    /**
     * Test accuracy of addConnection(AssociationEnd) method.
     */
    public void testAddConnection() {
        Association mockAssociation = createMock(Association.class);
        AssociationEnd mockAssociationEnd = createMock(AssociationEnd.class);

        mockAssociation.addConnection(mockAssociationEnd);
        replay(mockAssociation);

        instance = new AssociationClassImpl(mockAssociation);
        instance.addConnection(mockAssociationEnd);
        verify(mockAssociation);
    }

    /**
     * Test accuracy of addConnection(int, AssociationEnd) method.
     */
    public void testAddConnection_IndexAdd() {

        Association mockAssociation = createMock(Association.class);
        AssociationEnd mockAssociationEnd = createMock(AssociationEnd.class);

        mockAssociation.addConnection(100, mockAssociationEnd);
        replay(mockAssociation);

        instance = new AssociationClassImpl(mockAssociation);
        instance.addConnection(100, mockAssociationEnd);
        verify(mockAssociation);
    }

    /**
     * Test accuracy of setConnection(int, AssociationEnd) method.
     */
    public void testSetConnection() {
        Association mockAssociation = createMock(Association.class);
        AssociationEnd mockAssociationEnd = createMock(AssociationEnd.class);

        mockAssociation.setConnection(100, mockAssociationEnd);
        replay(mockAssociation);

        instance = new AssociationClassImpl(mockAssociation);
        instance.setConnection(100, mockAssociationEnd);
        verify(mockAssociation);
    }

    /**
     * Test accuracy of removeConnection(int) method.
     */
    public void testRemoveConnection_IndexRemove() {
        Association mockAssociation = createMock(Association.class);

        AssociationEnd mockAssociationEnd = createMock(AssociationEnd.class);
        expect(mockAssociation.removeConnection(100)).andReturn(mockAssociationEnd);
        replay(mockAssociation);

        instance = new AssociationClassImpl(mockAssociation);
        assertEquals("equal value expected.", mockAssociationEnd, instance.removeConnection(100));
        verify(mockAssociation);
    }

    /**
     * Test accuracy of removeConnection(AssociationEnd) method.
     */
    public void testRemoveConnection() {

        Association mockAssociation = createMock(Association.class);
        AssociationEnd mockAssociationEnd = createMock(AssociationEnd.class);

        expect(mockAssociation.removeConnection(mockAssociationEnd)).andReturn(true);
        replay(mockAssociation);

        instance = new AssociationClassImpl(mockAssociation);
        assertTrue("returning true value expected.", instance.removeConnection(mockAssociationEnd));
        verify(mockAssociation);
    }

    /**
     * Test accuracy of clearConnections() method.
     */
    public void testClearConnections() {

        Association mockAssociation = createMock(Association.class);

        mockAssociation.clearConnections();
        replay(mockAssociation);

        instance = new AssociationClassImpl(mockAssociation);
        instance.clearConnections();
        verify(mockAssociation);
    }

    /**
     * Test accuracy of getConnections() method.
     */
    public void testGetConnections() {

        Association mockAssociation = createMock(Association.class);

        expect(mockAssociation.getConnections()).andReturn(new ArrayList<AssociationEnd>());
        replay(mockAssociation);

        instance = new AssociationClassImpl(mockAssociation);
        assertEquals("equal value expected.", 0, instance.getConnections().size());
        verify(mockAssociation);
    }

    /**
     * Test accuracy of containsConnection(AssociationEnd) method.
     */
    public void testContainsConnection() {

        Association mockAssociation = createMock(Association.class);
        AssociationEnd mockAssociationEnd = createMock(AssociationEnd.class);

        expect(mockAssociation.containsConnection(mockAssociationEnd)).andReturn(false);
        replay(mockAssociation);

        instance = new AssociationClassImpl(mockAssociation);
        assertFalse(instance.containsConnection(mockAssociationEnd));
        verify(mockAssociation);
    }

    /**
     * Test accuracy of indexOfConnection(AssociationEnd) method.
     */
    public void testIndexOfConnection() {

        Association mockAssociation = createMock(Association.class);
        AssociationEnd mockAssociationEnd = createMock(AssociationEnd.class);

        expect(mockAssociation.indexOfConnection(mockAssociationEnd)).andReturn(1000);
        replay(mockAssociation);

        instance = new AssociationClassImpl(mockAssociation);
        assertEquals("equal value expected.", 1000, instance.indexOfConnection(mockAssociationEnd));
        verify(mockAssociation);
    }

    /**
     * Test accuracy of countConnections() method.
     */
    public void testCountConnections() {

        Association mockAssociation = createMock(Association.class);

        expect(mockAssociation.countConnections()).andReturn(1000000);
        replay(mockAssociation);

        instance = new AssociationClassImpl(mockAssociation);
        assertEquals("equal value expected.", 1000000, instance.countConnections());
        verify(mockAssociation);
    }

}
