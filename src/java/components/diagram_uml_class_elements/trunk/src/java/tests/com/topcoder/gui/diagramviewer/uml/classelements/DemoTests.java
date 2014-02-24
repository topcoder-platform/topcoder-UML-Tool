/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.datatransfer.Transferable;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.TransferHandler;

import junit.framework.TestCase;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.TextInputBox;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.uml.classelements.event.NodeAddEvent;
import com.topcoder.gui.diagramviewer.uml.classelements.event.NodeAddListener;
import com.topcoder.gui.diagramviewer.uml.classelements.event.TextChangedEvent;
import com.topcoder.gui.diagramviewer.uml.classelements.event.TextChangedListener;
import com.topcoder.uml.model.core.ModelElement;

/**
 * <p>
 * This class provides the demo usage of <code>ClassNode</code> component.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class DemoTests extends TestCase {

    /**
     * <p>
     * A custom transfer handler class.
     * </p>
     * @author TCSDEVELOPER
     * @version 1.0
     */
    class CustomTransferHandler extends TransferHandler {
        /**
         * Overrides 'importData' to provide custom transfer.
         * @param comp
         *            the component to receive the transfer
         * @param t
         *            the data to import
         * @return true if the data was inserted into the component, false otherwise
         */
        public boolean importData(JComponent comp, Transferable t) {
            // Transfer 't' to this component, maybe add a new element to diagram
            return false;
        }
    }

    /**
     * <p>
     * A class to listen to node add event.
     * </p>
     * @author TCSDEVELOPER
     * @version 1.0
     */
    class PackageChildAddListener implements NodeAddListener {
        /**
         * Processes node add event.
         * @param e
         *            a NodeAddEvent
         * @throws IllegalArgumentException
         *             if e is null
         */
        public void nodeAdd(NodeAddEvent e) {
            // FIXME Query the diagram viewer to know which kind of node should be added
            Node element = new ClassNode(TestUtil.createClassGraphNode(POSITION, SIZE, false, false), properties);
            // Specify the location of the element
            element.setLocation(e.getLocation());
            // Get the package node instance from event
            PackageNode pkg = (PackageNode) e.getSource();
            // Add the node to this package
            pkg.addNode("BodyCompartment", element);
        }
    }

    /**
     * A class to listen to text change event.
     * @author TCSDEVELOPER
     * @version 1.0
     */
    class NameChangedListener implements TextChangedListener {
        /**
         * Handles the text change event.
         * @param e
         *            the text change event
         * @throws IllegalArgumentException
         *             if e is null
         */
        public void textChanged(TextChangedEvent e) {
            // Retrieve the TextField, and package node.
            TextField textField = (TextField) e.getSource();
            Node node = (Node) textField.getParent();
            // Get package model element.
            GraphNode graphNode = node.getGraphNode();
            ModelElement modelElement = Util.getElement(graphNode);
            // Actually change the name
            modelElement.setName(e.getNewText());
            // Get preferred graphNode size
            Dimension newSize = null;
            if (node instanceof PackageNode) {
                newSize = ((PackageNode) node).getPreferredGraphNodeSize();
            } else if (node instanceof BaseNode) {
                newSize = ((BaseNode) node).getPreferredGraphNodeSize();
            }
            // Change size of graphNode according to new name
            com.topcoder.diagraminterchange.Dimension size = new com.topcoder.diagraminterchange.Dimension();
            size.setHeight(newSize.height);
            size.setWidth(newSize.width);
            graphNode.setSize(size);
            // Notify the size of graphNode is changed, the comment node will be updated accordingly
            if (node instanceof PackageNode) {
                ((PackageNode) node).notifyGraphNodeChange("Size of graph node is changed.");
            } else if (node instanceof BaseNode) {
                ((BaseNode) node).notifyGraphNodeChange("Size of graph node is changed.");
            }
        }
    }

    /** The absolute position of the package node. Used for testing only. */
    private static final Point PACKAGE_POSITION = new Point(10, 5);

    /** The size of the package node. Used for testing only. */
    private static final Dimension PACKAGE_SIZE = new Dimension(80, 80);

    /** The absolute position of the class node. Used for testing only. */
    private static final Point POSITION = new Point(15, 55);

    /** The size of the class node. Used for testing only. */
    private static final Dimension SIZE = new Dimension(80, 40);

    /** The absolute position of the enumeration node. Used for testing only. */
    private static final Point ENUM_POSITION = new Point(300, 45);

    /** The size of the enumeration node. Used for testing only. */
    private static final Dimension ENUM_SIZE = new Dimension(80, 40);

    /** An instance of <code>PackageNode</code> for testing. */
    private PackageNode packageNode;

    /** An instance of <code>BaseNode</code> for testing. */
    private BaseNode baseNode;

    /** An instance of <code>BaseNode</code> for testing. */
    private EnumerationNode enumerationNode;

    /** A GraphNode for <code>DiagramViewer</code>. */
    private GraphNode viewerNode = new GraphNode();

    /** Custom properties mappings. */
    private Map<String, String> properties;

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setUp();

        // Create custom properties mappings.
        properties = TestUtil.createProperties();

        // Create PackageNode with properties mapping and transfer handler
        GraphNode graphNode = TestUtil.createPackageGraphNode(PACKAGE_POSITION, PACKAGE_SIZE);
        graphNode.setContainer(viewerNode);
        packageNode = new PackageNode(graphNode, properties, new CustomTransferHandler());

        // Instantiate a concrete BaseNode (the example with ClassNode, all others - the same)
        graphNode = TestUtil.createClassGraphNode(POSITION, SIZE, false, false);
        graphNode.setContainer(viewerNode);
        baseNode = new ClassNode(graphNode, properties);

        // Instantiate a concrete EnumerationNode
        graphNode = TestUtil.createEnumerationGraphNode(ENUM_POSITION, ENUM_SIZE);
        graphNode.setContainer(viewerNode);
        enumerationNode = new EnumerationNode(graphNode, properties);
    }

    /**
     * <p>
     * A demo usage of PackageNode and BaseNode. It should complete without any exception.
     * </p>
     */
    public void testDemo() {
        // Register a listener to the package node to add child
        packageNode.addNodeAddListener(new PackageChildAddListener());

        // Register the text change listener to the name compartment, the name can be changed, and node will be
        // resized automatically
        packageNode.getNameCompartment().addTextChangedListener(new NameChangedListener());

        // Retrieve compartments
        TextField nameCompartment = baseNode.getNameCompartment();
        TextField stereotypeCompartment = baseNode.getStereotypeCompartment();
        TextField namespaceCompartment = baseNode.getNamespaceCompartment();

        GroupTextField attributesCompartment = baseNode.getAttributesCompartment();
        GroupTextField operationsCompartment = baseNode.getOperationsCompartment();
    }

    /**
     * <p>
     * A demo GUI usage of all components. It should complete without any exception.
     * </p>
     */
    public void testGUIDemo() throws Exception {
        // Register the listener
        baseNode.getNameCompartment().addTextChangedListener(new NameChangedListener());
        enumerationNode.getNameCompartment().addTextChangedListener(new NameChangedListener());
        packageNode.getNameCompartment().addTextChangedListener(new NameChangedListener());

        // Add the popup menu
        baseNode.setAttributesOperationsPopup(new TextInputBox());
        enumerationNode.setAttributesOperationsPopup(new TextInputBox());

        // Add baseNode and enumerationNode to packageNode
        packageNode.addNode(baseNode);
        packageNode.addNode(enumerationNode);
        packageNode.notifyGraphNodeChange("Nodes are added.");

        // Then add the node to the container to show it
        TestUtil.loadConfig("test_files/DiagramViewer.xml");
        DiagramViewer viewer = new DiagramViewer("DiagramViewer");
        viewer.add(baseNode);
        viewer.add(enumerationNode);
        viewer.add(packageNode);

        JDialog dialog = new JDialog((JFrame) null, "Demo", true);
        dialog.setSize(620, 500);
        dialog.getContentPane().add(viewer);

        dialog.setVisible(true);
    }

    /**
     * <p>
     * Tears down the test environment.
     * </p>
     */
    protected void tearDown() throws Exception {
        super.tearDown();

        properties = null;

        packageNode = null;

        baseNode = null;

        enumerationNode = null;
    }
}
