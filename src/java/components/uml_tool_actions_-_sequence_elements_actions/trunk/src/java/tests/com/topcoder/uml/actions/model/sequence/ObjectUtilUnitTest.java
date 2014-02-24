/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.util.ArrayList;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import com.topcoder.uml.model.collaborations.collaborationinstances.CollaborationInstanceSet;
import com.topcoder.uml.model.collaborations.collaborationinstances.CollaborationInstanceSetImpl;
import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.collaborations.collaborationinteractions.CollaborationImpl;
import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.uml.model.commonbehavior.instances.ObjectImpl;
import com.topcoder.uml.model.core.ModelElement;

/**
 * <p>
 * This Junit Test suite contains the accuracy and failure test cases for {@link ObjectUtil} class. The
 * accuracy test cases gives all valid inputs to the methods/constructors and checks for inconsistencies The
 * failure test cases gives all invalid inputs to the methods/constructors and checks for expected exceptions
 * </p>
 *
 * @author evilisneo
 * @version 1.0
 */
public class ObjectUtilUnitTest extends TestCase {

    /**
     * ObjectUtil instance to be used for the testing.
     */
    private ObjectUtil objectUtil = null;

    /**
     * <p>
     * Sets up the environment for the TestCase.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void setUp() throws Exception {
        TestHelper.loadConfig();
        objectUtil = new ObjectUtil();
    }

    /**
     * <p>
     * Tears down the environment after the TestCase.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    protected void tearDown() throws Exception {
        objectUtil = null;
        Thread.sleep(50);
        TestHelper.releaseConfig();
    }

    /**
     * <p>
     * Aggregates all tests in this class.
     * </p>
     *
     * @return Test suite aggregating all tests.
     */
    public static Test suite() {
        return new TestSuite(ObjectUtilUnitTest.class);
    }

    /**
     * <p>
     * Accuracy test for {@link ObjectUtil#ObjectUtil()} constructor.
     * </p>
     * <p>
     * Creates an instance and checks its instantiation and the variable initialization.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_ObjectUtil() throws Exception {
        // check for null
        assertNotNull("ObjectUtil creation failed", objectUtil);
    }

    /**
     * <p>
     * Accuracy test for {@link ObjectUtil#addObjectToCollaboration(Object)} method.
     * </p>
     * <p>
     * Checks whether all the required details of object are added to the collaboration.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_addObjectToCollaboration() throws Exception {
        Object object = new ObjectImpl();
        Collaboration collaboration = new CollaborationImpl();
        object.setNamespace(collaboration);
        CollaborationInstanceSet collaborationInstanceSet = new CollaborationInstanceSetImpl();
        CollaborationInstanceSet collaborationInstanceSet1 = new CollaborationInstanceSetImpl();
        collaboration.addCollaborationInstanceSet(collaborationInstanceSet);
        collaboration.addCollaborationInstanceSet(collaborationInstanceSet1);
        objectUtil.addObjectToCollaboration(object);
        // check whether the object is added to the owned element of namespace
        assertEquals("addObjectToCollaboration failed", new ArrayList<ModelElement>(collaboration
            .getOwnedElements()).get(0), object);
        assertEquals("addObjectToCollaboration failed", new ArrayList<ModelElement>(collaborationInstanceSet
            .getParticipatingInstances()).get(0), object);
        assertEquals("addObjectToCollaboration failed", new ArrayList<ModelElement>(collaborationInstanceSet1
            .getParticipatingInstances()).get(0), object);
    }

    /**
     * <p>
     * Failure test for {@link ObjectUtil#addObjectToCollaboration(Object)} method.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *  Input
     *       Object object : null value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_addObjectToCollaboration() throws Exception {
        try {
            objectUtil.addObjectToCollaboration(null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message for IllegalArgumentException is wrong", e.getMessage(),
                "object in ObjectUtil#addObjectToCollaboration should not be null.");
        }
    }

    /**
     * <p>
     * Accuracy test for {@link ObjectUtil#removeObjectFromCollaboration(Object)} method.
     * </p>
     * <p>
     * Checks whether all the required details are removed from the object and collaboration.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_removeObjectFromCollaboration() throws Exception {
        Object object = new ObjectImpl();
        Collaboration collaboration = new CollaborationImpl();
        object.setNamespace(collaboration);
        CollaborationInstanceSet collaborationInstanceSet = new CollaborationInstanceSetImpl();
        CollaborationInstanceSet collaborationInstanceSet1 = new CollaborationInstanceSetImpl();
        collaboration.addCollaborationInstanceSet(collaborationInstanceSet);
        collaboration.addCollaborationInstanceSet(collaborationInstanceSet1);
        collaboration.addOwnedElement(object);
        collaborationInstanceSet.addParticipatingInstance(object);
        collaborationInstanceSet1.addParticipatingInstance(object);
        objectUtil.removeObjectFromCollaboration(object);
        // check whether the object is removed from the owned element of namespace
        assertEquals("removeObjectFromCollaboration failed", new ArrayList<ModelElement>(collaboration
            .getOwnedElements()).size(), 0);
        // check whether the communication link is removed from the participatory link.
        assertEquals("removeObjectFromCollaboration failed", new ArrayList<ModelElement>(collaborationInstanceSet
            .getParticipatingInstances()).size(), 0);
        assertEquals("removeObjectFromCollaboration failed", new ArrayList<ModelElement>(collaborationInstanceSet1
            .getParticipatingInstances()).size(), 0);

    }

    /**
     * <p>
     * Failure test for {@link ObjectUtil#removeObjectFromCollaboration(Object)} method.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *  Input
     *       Object object : null value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_removeObjectFromCollaboration() throws Exception {
        try {
            objectUtil.removeObjectFromCollaboration(null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message for IllegalArgumentException is wrong", e.getMessage(),
                "object in ObjectUtil#removeObjectFromCollaboration should not be null.");
        }
    }

    /**
     * <p>
     * Accuracy test for {@link ObjectUtil#addObjectToClipboard(Object, Clipboard)} method.
     * </p>
     * <p>
     * Checks whether the added content is correct.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_addObjectToClipboard() throws Exception {
        TestHelper.OBJECT.setName("test");
        objectUtil.addObjectToClipboard(TestHelper.OBJECT, Toolkit.getDefaultToolkit().getSystemClipboard());
        assertEquals("addObjectToClipboard failed", ((Object) Toolkit.getDefaultToolkit().getSystemClipboard()
                .getContents(null).getTransferData(CollaborationTransfer.OBJECT_FLAVOR)).getName(), "test");
    }

    /**
     * <p>
     * Failure test for {@link ObjectUtil#addObjectToClipboard(Object, Clipboard)} method.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *  Input
     *       Object object : null value
     *       Clipboard clipboard : Valid value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_addObjectToClipboard() throws Exception {
        try {
            objectUtil.addObjectToClipboard(null, Toolkit.getDefaultToolkit().getSystemClipboard());
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message for IllegalArgumentException is wrong", e.getMessage(),
                "object in ObjectUtil#addObjectToClipboard should not be null.");
        }
    }

    /**
     * <p>
     * Failure test for {@link ObjectUtil#addObjectToClipboard(Object, Clipboard)} method.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *  Input
     *       Object object : Valid value
     *       Clipboard clipboard : null value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_addObjectToClipboard1() throws Exception {
        try {
            objectUtil.addObjectToClipboard(TestHelper.OBJECT, null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message for IllegalArgumentException is wrong", e.getMessage(),
                "clipboard in ObjectUtil#addObjectToClipboard should not be null.");
        }
    }

    /**
     * <p>
     * Accuracy test for {@link ObjectUtil#checkObjectNamespace(Object)} method.
     * </p>
     * <p>
     * Checks whether true is returned if the namespace contains the object.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_checkObjectNamespace() throws Exception {
        Object object = new ObjectImpl();
        Collaboration collaboration = new CollaborationImpl();
        object.setNamespace(collaboration);
        collaboration.addOwnedElement(object);
        assertTrue("checkObjectNamespace failed", objectUtil.checkObjectNamespace(object));
    }

    /**
     * <p>
     * Accuracy test for {@link ObjectUtil#checkObjectNamespace(Object)} method.
     * </p>
     * <p>
     * Checks whether true is returned if the namespace contains the object.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_checkObjectNamespace1() throws Exception {
        Object object = new ObjectImpl();
        object.setNamespace(new CollaborationImpl());
        assertFalse("checkObjectNamespace failed", objectUtil.checkObjectNamespace(object));
    }

    /**
     * <p>
     * Failure test for {@link ObjectUtil#checkObjectNamespace(Object)} method.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *  Input
     *       Object object : null value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_checkObjectNamespace() throws Exception {
        try {
            objectUtil.checkObjectNamespace(null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message for IllegalArgumentException is wrong", e.getMessage(),
                "object in ObjectUtil#checkObjectNamespace should not be null.");
        }
    }

    /**
     * <p>
     * Accuracy test for {@link ObjectUtil#copyObject(Object)} method.
     * </p>
     * <p>
     * Checks whether new instance of the Object is returned and all the required attributes of the Object are
     * properly set.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_accuracy_copyObject() throws Exception {
        Object object = new ObjectImpl();
        objectUtil.copyObject(object);
        // FIXME complete this
        assertNotSame("copyObject failed", objectUtil.copyObject(object), object);
    }

    /**
     * <p>
     * Failure test for {@link ObjectUtil#copyObject(Object)} method.
     * </p>
     * <p>
     * For the following inputs:
     * </p>
     *
     * <pre>
     *  Input
     *       Object object : null value
     * </pre>
     *
     * <p>
     * Expected {@link IllegalArgumentException}.
     * </p>
     *
     * @throws Exception
     *             throw exception to JUnit.
     */
    public void test_failure_copyObject() throws Exception {
        try {
            objectUtil.copyObject(null);
            fail("IllegalArgumentException Expected.");
        } catch (IllegalArgumentException e) {
            // Check for the expected error message
            assertEquals("The Exception message for IllegalArgumentException is wrong", e.getMessage(),
                "object in ObjectUtil#copyObject should not be null.");
        }
    }
}
