/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 *
 * BaseNodeFailureTest.java
 */
package com.topcoder.gui.diagramviewer.uml.usecaseelements.failuretests;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.BaseNode;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.IllegalGraphElementException;
import com.topcoder.gui.diagramviewer.uml.usecaseelements.TextField;
import com.topcoder.gui.diagramviewer.edges.Connector;
import junit.framework.TestCase;

import java.awt.Dimension;
import java.util.Map;
import java.util.HashMap;

/**
 * <p>
 * This is a failure tests for <code>BaseNode</code> class.
 * </p>
 *
 * @author wiedzmin
 * @version 1.0
 */
public class BaseNodeFailureTest extends TestCase {

    /**GraphNode that is used for testing.*/
    private GraphNode graphNode;

    /**Properties map.*/
    private Map<String, String> properties;

    /**Name text field.*/
    private TextField name;

    /**Stereotype text field.*/
    private TextField stereotype;

    /**Namespace text field.*/
    private TextField namespace;

    /**BaseNode instance that will be tested.*/
    private BaseNodeImpl baseNode;

    /**
     * <p>
     * Set up environment.
     * </p>
     *
     * @throws Exception exception
     */
    public void setUp() throws Exception {
        graphNode = new GraphNode();
        properties = new HashMap<String, String>();
        name = new TextField(graphNode);
        stereotype = new TextField(graphNode);
        namespace = new TextField(graphNode);
        baseNode = new BaseNodeImpl(graphNode, properties, name, stereotype, namespace);
    }

    /**
     * <p>
     * Tests constructor BaseNode(graphNode, properties, name, stereotype, namespace) if graphNode is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfGrapchNodeNull() {
        try {
            new BaseNodeImpl(null, properties, name, stereotype, namespace);
            fail("IllegalArgumentException is expected because graphNode cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor BaseNode(graphNode, properties, name, stereotype, namespace) if properties map is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfPropertiesMapNull() {
        try {
            new BaseNodeImpl(graphNode, null, name, stereotype, namespace);
            fail("IllegalArgumentException is expected because properties map cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor BaseNodeImpl(graphNode, properties, name, stereotype, namespace) if properties map contains
     * null key.
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception exception
     */
    public void testCtorIfPropertiesMapContainNullKey() throws Exception {
        properties.put(null, "value");
        try {
            new BaseNodeImpl(graphNode, properties, name, stereotype, namespace);
            fail("IllegalArgumentException is expected because properties map cannot contain null key.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor BaseNodeImpl(graphNode, properties, name, stereotype, namespace) if properties map contains
     * empty key.
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception exception
     */
    public void testCtorIfPropertiesMapContainEmptyKey() throws Exception {
        properties.put("  ", "value");
        try {
            new BaseNodeImpl(graphNode, properties, name, stereotype, namespace);
            fail("IllegalArgumentException is expected because properties map cannot contain empty key.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor BaseNodeImpl(graphNode, properties, name, stereotype, namespace) if properties map contains
     * null value.
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception exception
     */
    public void testCtorIfPropertiesMapContainNullValue() throws Exception {
        properties.put("key", null);
        try {
            new BaseNodeImpl(graphNode, properties, name, stereotype, namespace);
            fail("IllegalArgumentException is expected because properties map cannot contain null value.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor BaseNodeImpl(graphNode, properties, name, stereotype, namespace) if properties map contains
     * empty value.
     * IllegalArgumentException is expected.
     * </p>
     *
     * @throws Exception exception
     */
    public void testCtorIfPropertiesMapContainEmptyValue() throws Exception {
        properties.put("key", "  ");
        try {
            new BaseNodeImpl(graphNode, properties, name, stereotype, namespace);
            fail("IllegalArgumentException is expected because properties map cannot contain empty value.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor BaseNode(graphNode, properties, name, stereotype, namespace) if name is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfNameNull() {
        try {
            new BaseNodeImpl(graphNode, properties, null, stereotype, namespace);
            fail("IllegalArgumentException is expected because name cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor BaseNode(graphNode, properties, name, stereotype, namespace) if stereotype is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfStereotypeNull() {
        try {
            new BaseNodeImpl(graphNode, properties, name, null, namespace);
            fail("IllegalArgumentException is expected because stereotype cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests constructor BaseNode(graphNode, properties, name, stereotype, namespace) if namespace is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testCtorIfNamespaceNull() {
        try {
            new BaseNodeImpl(graphNode, properties, name, stereotype, null);
            fail("IllegalArgumentException is expected because namespace cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests method setConnector(connector) if connector is null.
     * IllegalArgumentException is expected.
     * </p>
     */
    public void testSetConnectorIfConnectorNull() {
        try {
            baseNode.setConnector(null);
            fail("IllegalArgumentException is expected because connector cannot be null.");
        } catch (IllegalArgumentException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests method notifyNamespaceVisibilityChange().
     * IllegalGraphElementException is expected because BaseNode method notifyGraphNodeChange(message)
     * implementation throws this exception, and notifyNamespaceVisibilityChange() delegates its call to
     * notifyGraphNodeChange(message).
     * </p>
     *
     * @throws Exception exception
     */
    public void testNotifyNamespaceVisibilityChange() throws Exception {
        try {
            baseNode.notifyNamespaceVisibilityChange();
            fail("IllegalGraphElementException is expected.");
        } catch (IllegalGraphElementException e) {
            //success
        }
    }

    /**
     * <p>
     * Tests method notifyStereotypeVisibilityChange().
     * IllegalGraphElementException is expected because BaseNode method notifyGraphNodeChange(message)
     * implementation throws this exception, and notifyStereotypeVisibilityChange() delegates its call to
     * notifyGraphNodeChange(message).
     * </p>
     *
     * @throws Exception exception
     */
    public void testNotifyStereotypeVisibilityChange() throws Exception {
        try {
            baseNode.notifyStereotypeVisibilityChange();
            fail("IllegalGraphElementException is expected.");
        } catch (IllegalGraphElementException e) {
            //success
        }
    }

    /**
     * <p>
     * Simple implementation of BaseNode class.
     * Used for testing.
     * </p>
     */
    private class BaseNodeImpl extends BaseNode {

        public BaseNodeImpl(GraphNode graphNode, Map<String, String> properties,
                            TextField name,
                            TextField stereotype,
                            TextField namespace) {
            super(graphNode, properties, name, stereotype, namespace);
        }

        public void notifyGraphNodeChange(String message) throws IllegalGraphElementException {
            throw new IllegalGraphElementException(null, null);
        }

        public Dimension getPreferredGraphNodeSize() {
            return new Dimension();
        }

        public void setConnector(Connector connector) {
            super.setConnector(connector);
        }
    }
}