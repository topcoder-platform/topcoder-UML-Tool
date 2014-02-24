package com.topcoder.gui.diagramviewer.uml.classelements.failuretests;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Map;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.edges.Connector;
import com.topcoder.gui.diagramviewer.uml.classelements.BaseNode;
import com.topcoder.gui.diagramviewer.uml.classelements.IllegalGraphElementException;
import com.topcoder.gui.diagramviewer.uml.classelements.TextField;

import junit.framework.TestCase;

/**
 * Failure tests for BaseNode class.
 * 
 * @author Yeung
 * @version 1.0
 */
public class BaseNodeFailureTests extends TestCase {
    /**
     * The MockBaseNode instance to test against.
     */
    private MockBaseNode baseNode;

    /**
     * A GraphNode for testing.
     */
    private GraphNode graphNode;

    /**
     * Properties for testing.
     */
    private Map<String, String> properties;

    /**
     * The TextField instance for testing.
     */
    private TextField name;

    /**
     * The TextField instance for testing.
     */
    private TextField stereotype;

    /**
     * The TextField instance for testing.
     */
    private TextField namespace;

    /**
     * Sets up test environment.
     * 
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setUp();

        graphNode = FailureTestHelper.createClassGraphNode(new Point(50, 50), new Dimension(20, 20), false, false);
        graphNode.setContainer(new GraphNode());

        properties = FailureTestHelper.createProperties();

        name = new TextField(graphNode);
        stereotype = new TextField(graphNode);
        namespace = new TextField(graphNode);

        baseNode = new MockBaseNode(graphNode, properties, name, stereotype, namespace);
    }

    /**
     * Tests the constructor BaseNode(GraphNode, Map&lt;String, String&gt;, TextField, TextField, TextField) with null
     * graphNode, expected IllegalArgumentException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testCtor_NullGraphNode() throws Exception {
        try {
            new MockBaseNode(null, properties, name, stereotype, namespace);
            fail("expect IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Tests the constructor BaseNode(GraphNode, Map&lt;String, String&gt;, TextField, TextField, TextField) with null
     * properties, expected IllegalArgumentException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testCtor_NullProperties() throws Exception {
        try {
            new MockBaseNode(graphNode, null, name, stereotype, namespace);
            fail("expect IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Tests the constructor BaseNode(GraphNode, Map&lt;String, String&gt;, TextField, TextField, TextField) with null
     * element properties, expected IllegalArgumentException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testCtor_NullElementProperties() throws Exception {
        properties.put("null", null);
        try {
            new MockBaseNode(graphNode, properties, name, stereotype, namespace);
            fail("expect IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Tests the constructor BaseNode(GraphNode, Map&lt;String, String&gt;, TextField, TextField, TextField) with empty
     * element properties, expected IllegalArgumentException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testCtor_EmptyElementProperties() throws Exception {
        properties.put("empty", "");
        try {
            new MockBaseNode(graphNode, properties, name, stereotype, namespace);
            fail("expect IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Tests the constructor BaseNode(GraphNode, Map&lt;String, String&gt;, TextField, TextField, TextField) with null
     * name, expected IllegalArgumentException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testCtor_NullName() throws Exception {
        try {
            new MockBaseNode(graphNode, properties, null, stereotype, namespace);
            fail("expect IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Tests the constructor BaseNode(GraphNode, Map&lt;String, String&gt;, TextField, TextField, TextField) with null
     * stereotype, expected IllegalArgumentException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testCtor_NullStereotype() throws Exception {
        try {
            new MockBaseNode(graphNode, properties, name, null, namespace);
            fail("expect IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Tests the constructor BaseNode(GraphNode, Map&lt;String, String&gt;, TextField, TextField, TextField) with null
     * namespace, expected IllegalArgumentException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testCtor_NullNamespace() throws Exception {
        try {
            new MockBaseNode(graphNode, properties, name, stereotype, null);
            fail("expect IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Tests the constructor BaseNode(GraphNode, Map&lt;String, String&gt;, TextField, TextField, TextField) with
     * invalid graphNode, expected IllegalGraphElementException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testCtor_InvalidGraphNode() throws Exception {
        try {
            new MockBaseNode(new GraphNode(), properties, name, stereotype, namespace);
            fail("expect IllegalGraphElementException");
        } catch (IllegalGraphElementException e) {
            // success
        }
    }

    /**
     * Tests the method setConnector(Connector) with null connector, expected IllegalArgumentException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testSetConnector_NullConnector() throws Exception {
        try {
            baseNode.setConnector(null);
            fail("expect IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Tests the method notifyStereotypeVisibilityChange() with invalid graphNode, expected
     * IllegalGraphElementException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testNotifyStereotypeVisibilityChange_InvalidGraphNode() throws Exception {
        baseNode.isInvalid = true;
        try {
            baseNode.notifyStereotypeVisibilityChange();
            fail("expect IllegalGraphElementException");
        } catch (IllegalGraphElementException e) {
            // success
        }
    }

    /**
     * Tests the method notifyAttributesVisibilityChange() with invalid graphNode, expected
     * IllegalGraphElementException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testNotifyAttributesVisibilityChange_InvalidGraphNode() throws Exception {
        baseNode.isInvalid = true;
        try {
            baseNode.notifyAttributesVisibilityChange();
            fail("expect IllegalGraphElementException");
        } catch (IllegalGraphElementException e) {
            // success
        }
    }

    /**
     * Tests the method notifyNamespaceVisibilityChange() with invalid graphNode, expected IllegalGraphElementException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testNotifyNamespaceVisibilityChange_InvalidGraphNode() throws Exception {
        baseNode.isInvalid = true;
        try {
            baseNode.notifyNamespaceVisibilityChange();
            fail("expect IllegalGraphElementException");
        } catch (IllegalGraphElementException e) {
            // success
        }
    }

    /**
     * Tests the method notifyOperationsVisibilityChange() with invalid graphNode, expected
     * IllegalGraphElementException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testNotifyOperationsVisibilityChange_InvalidGraphNode() throws Exception {
        baseNode.isInvalid = true;
        try {
            baseNode.notifyOperationsVisibilityChange();
            fail("expect IllegalGraphElementException");
        } catch (IllegalGraphElementException e) {
            // success
        }
    }

    /**
     * Tests the method notifyAttributesStereotypeVisibilityChange() with invalid graphNode, expected
     * IllegalGraphElementException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testNotifyAttributesStereotypeVisibilityChange_InvalidGraphNode() throws Exception {
        baseNode.isInvalid = true;
        try {
            baseNode.notifyAttributesStereotypeVisibilityChange();
            fail("expect IllegalGraphElementException");
        } catch (IllegalGraphElementException e) {
            // success
        }
    }

    /**
     * Tests the method notifyOperationsStereotypeVisibilityChange() with invalid graphNode, expected
     * IllegalGraphElementException.
     * 
     * @throws Exception
     *             to junit
     */
    public void testNotifyOperationsStereotypeVisibilityChange_InvalidGraphNode() throws Exception {
        baseNode.isInvalid = true;
        try {
            baseNode.notifyOperationsStereotypeVisibilityChange();
            fail("expect IllegalGraphElementException");
        } catch (IllegalGraphElementException e) {
            // success
        }
    }

    /**
     * This class extends BaseNode. It is used for testing.
     * 
     * @author Yeung
     * @version 1.0
     */
    private class MockBaseNode extends BaseNode {
        /**
         * Represents whether the structure of graphNode is invalid.
         */
        public boolean isInvalid = false;

        /**
         * Constructs a new node.
         * 
         * @param graphNode
         *            the graphNode corresponding to this Node
         * @param properties
         *            the property names mappings(See field documentation for explanation).
         * @param name
         *            The name compartment object.
         * @param stereotype
         *            The stereotype compartment object.
         * @param namespace
         *            The namespace compartment object.
         * @throws IllegalArgumentException
         *             if given graphNode, properties, name, stereotype, or namespace argument is null. Or properties
         *             contains null/empty element.
         * @throws IllegalGraphElementException
         *             if the structure of graphNode is invalid.
         */
        public MockBaseNode(GraphNode graphNode, Map<String, String> properties, TextField name, TextField stereotype,
                TextField namespace) {
            super(graphNode, properties, name, stereotype, namespace);
        }

        /**
         * Sets the connector for this node.
         * 
         * @param connector
         *            the connector used to connect this node
         * @throws IllegalArgumentException
         *             if <code>connector</code> is null
         */
        public void setConnector(Connector connector) {
            super.setConnector(connector);
        }

        /**
         * Notifies the contained graphNode is changed.
         * 
         * @param message
         *            message telling how the graphNode is changed.
         * @throws IllegalGraphElementException
         *             if the structure of graphNode is invalid
         */
        public void notifyGraphNodeChange(String message) {
            if (isInvalid) {
                throw new IllegalGraphElementException(null, "invalid graph");
            }
        }

        /**
         * Gets the preferred graph node size.
         * 
         * @return the preferred size of graph node.
         */
        public Dimension getPreferredGraphNodeSize() {
            return null;
        }

        /**
         * <p>
         * Consumes event when the diagram viewer is in the state of adding element. Simply return false.
         * </p>
         * @param event
         *            the mouse event or mouse motion event
         * @return true if the event is consumed, otherwise false
         */
        protected boolean consumeEvent(MouseEvent event) {
            return false;
        }
    }
}
