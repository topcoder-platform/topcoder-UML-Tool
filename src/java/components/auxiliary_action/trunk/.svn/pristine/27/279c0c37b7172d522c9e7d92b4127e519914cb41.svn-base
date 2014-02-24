/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * AuxiliaryElementCloneUtilityFailureTest.java
 */
package com.topcoder.uml.actions.auxiliary.failuretests;

import junit.framework.TestCase;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

import com.topcoder.uml.model.core.auxiliaryelements.Comment;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.GraphEdge;

/**
 * <p>
 * This is a failure tests for <code>AuxiliaryElementCloneUtility</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class AuxiliaryElementCloneUtilityFailureTest extends TestCase {

    /**Class name of AuxiliaryElementCloneUtility.*/
    private static final String CLASS_NAME = "com.topcoder.uml.actions.auxiliary.AuxiliaryElementCloneUtility";


    /**
     * <p>
     * Tests method cloneComment(comment) if comment is null.
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception exception
     */
    public void testCloneCommentIfCommentNull() throws Exception {
        try {
            Method cloneComment = getMethodByName("cloneComment", Comment.class);
            Comment comment = null;
            cloneComment.invoke(null, comment);
            fail("IllegalArgumentException is expected because comment cannot be null.");
        } catch (InvocationTargetException e) {
            //success
            assertTrue("Cause must be instance of IllegalArgumentException.",
                    e.getCause() instanceof IllegalArgumentException);
        }
    }

    /**
     * <p>
     * Tests method cloneCommentGraphNode(node) if node is null.
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception exception
     */
    public void testCloneCommentGraphNodeIfNodeNull() throws Exception {
        try {
            Method cloneCommentGraphNode = getMethodByName("cloneCommentGraphNode", GraphNode.class);
            GraphNode node = null;
            cloneCommentGraphNode.invoke(null, node);
            fail("IllegalArgumentException is expected because node cannot be null.");
        } catch (InvocationTargetException e) {
            //success
            assertTrue("Cause must be instance of IllegalArgumentException.",
                    e.getCause() instanceof IllegalArgumentException);
        }
    }

    /**
     * <p>
     * Tests method cloneCommentRelationshipGraphEdge(edge) if edge is null.
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception exception
     */
    public void testCloneCommentRelationshipGraphEdgeIfNodeNull() throws Exception {
        try {
            Method cloneCommentRelationshipGraphEdge = getMethodByName("cloneCommentRelationshipGraphEdge",
                    GraphEdge.class);
            GraphEdge edge = null;
            cloneCommentRelationshipGraphEdge.invoke(null, edge);
            fail("IllegalArgumentException is expected because edge cannot be null.");
        } catch (InvocationTargetException e) {
            //success
            assertTrue("Cause must be instance of IllegalArgumentException.",
                    e.getCause() instanceof IllegalArgumentException);
        }
    }


    /**
     * <p>
     * Tests method cloneFreeTextGraphNode(node) if node is null.
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception exception
     */
    public void testCloneFreeTextGraphNodeIfNodeNull() throws Exception {
        try {
            Method cloneFreeTextGraphNode = getMethodByName("cloneFreeTextGraphNode", GraphNode.class);
            GraphNode node = null;
            cloneFreeTextGraphNode.invoke(null, node);
            fail("IllegalArgumentException is expected because node cannot be null.");
        } catch (InvocationTargetException e) {
            //success
            assertTrue("Cause must be instance of IllegalArgumentException.",
                    e.getCause() instanceof IllegalArgumentException);
        }
    }


    /**
     * <p>
     * Tests method clonePolylineGraphEdge(edge) if edge is null.
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception exception
     */
    public void testClonePolylineGraphEdgeIfNodeNull() throws Exception {
        try {
            Method clonePolylineGraphEdge = getMethodByName("clonePolylineGraphEdge", GraphEdge.class);
            GraphEdge edge = null;
            clonePolylineGraphEdge.invoke(null, edge);
            fail("IllegalArgumentException is expected because edge cannot be null.");
        } catch (InvocationTargetException e) {
            //success
            assertTrue("Cause must be instance of IllegalArgumentException.",
                    e.getCause() instanceof IllegalArgumentException);
        }
    }

    /**
     * <p>
     * Returns AuxiliaryElementCloneUtility's method by name and specified parameter.
     * </p>
     *
     * @param methodName method name
     * @param param method parameter
     * @return necessary method
     * @throws Exception exception
     */
    private Method getMethodByName(String methodName, Class param) throws Exception {
        Class clazz = Class.forName(CLASS_NAME);
        Method method = clazz.getMethod(methodName, param);
        method.setAccessible(true);
        return method;
    }
}