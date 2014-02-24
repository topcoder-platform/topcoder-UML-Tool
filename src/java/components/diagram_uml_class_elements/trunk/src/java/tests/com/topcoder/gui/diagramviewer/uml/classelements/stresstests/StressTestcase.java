/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements.stresstests;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.TransferHandler;

import junit.extensions.jfcunit.JFCTestCase;
import junit.extensions.jfcunit.JFCTestHelper;
import junit.extensions.jfcunit.TestHelper;
import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.NamedComponentFinder;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.TextInputBox;
import com.topcoder.gui.diagramviewer.uml.classelements.ClassNode;
import com.topcoder.gui.diagramviewer.uml.classelements.EnumerationNode;
import com.topcoder.gui.diagramviewer.uml.classelements.ExceptionNode;
import com.topcoder.gui.diagramviewer.uml.classelements.InterfaceNode;
import com.topcoder.gui.diagramviewer.uml.classelements.PackageNode;
import com.topcoder.gui.diagramviewer.uml.classelements.TextField;
import com.topcoder.gui.diagramviewer.uml.classelements.event.TextChangedEvent;
import com.topcoder.gui.diagramviewer.uml.classelements.event.TextChangedListener;

/**
 * <p>
 * This class do the stress tests for this component.
 * </p>
 * @author KLW
 * @version 1.0
 */
public class StressTestcase extends JFCTestCase {
    /** The absolute position of the visual node. Used for testing only. */
    private static final Point POSITION = new Point(100, 150);

    /** The size of the visual node. Used for testing only. */
    private static final Dimension SIZE = new Dimension(80, 40);

    /** An instance of JFC <code>TestHelper</code> for testing. */
    private TestHelper helper = null;

    /** A GraphNode for <code>ClassNode</code>. */
    private GraphNode graphNode;

    /** An instance of <code>ClassNode</code> for testing. */
    private ClassNode classNode;

    /** An instance of <code>EnumerationNode</code> for testing. */
    private EnumerationNode enumerationNode;

    /** An instance of <code>InterfaceNode</code> for testing. */
    private InterfaceNode interfaceNode;

    /** An instance of <code>ExceptionNode</code> for testing. */
    private ExceptionNode exceptionNode;

    /** An instance of <code>PackageNode</code> for testing. */
    private PackageNode packageNode;

    /** Properties for testing. */
    private Map < String, String > properties;

    /**
     * <p>
     * Sets up the test environment. The test instance is created.
     * </p>
     * @throws Exception
     *             to junit
     */
    protected void setUp() throws Exception {
        super.setUp();

        helper = new JFCTestHelper();
    }

    /**
     * <p>
     * Stress test for ClassNode.
     * </p>
     */
    public void testClassNode() throws Exception {
        helper = new JFCTestHelper();
        TextChangedListener textListener = new TextChangedListener() {
            public void textChanged(TextChangedEvent event) {
                TextField compartment = (TextField) event.getSource();
                compartment.setText(event.getNewText());
            }
        };
        graphNode = TestUtil.createClassGraphNode(POSITION, SIZE, false, false);
        graphNode.setContainer(new GraphNode());

        properties = properties = TestUtil.createProperties();
        long start = System.currentTimeMillis();

        classNode = new ClassNode(graphNode, properties);

        classNode.setAttributesOperationsPopup(new TextInputBox());
        // register the listener
        classNode.getNameCompartment().addTextChangedListener(textListener);

        // Then add the node to the container to show it
        classNode.setName("ClassNode");
        classNode.setVisible(true);
        TestUtil.loadConfig("test_files/DiagramViewer.xml");
        DiagramViewer viewer = new DiagramViewer("DiagramViewer");
        viewer.add(classNode);

        JDialog dialog = new JDialog((JFrame) null, "ClassNode", true);
        dialog.setSize(500, 500);
        dialog.getContentPane().add(viewer);
        dialog.setModal(false);
        dialog.setVisible(true);
        NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "ClassNode");
        ClassNode node = (ClassNode) finder.find(dialog, 0);
        assertNotNull("ClassNode component should be displayed", node);
        for (int i = 0; i < 100; i++) {
            helper.enterClickAndLeave(new MouseEventData(this, viewer, 1, true));

            TextField nameCompartment = node.getNameCompartment();
            helper.enterClickAndLeave(new MouseEventData(this, nameCompartment, 2));
        }
        dialog.dispose();
        System.out.println("ClassNode tests time:" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * <p>
     * Stress test for EnumerationNode.
     * </p>
     */
    public void testEnumerationNode() throws Exception {

        TextChangedListener textListener = new TextChangedListener() {
            public void textChanged(TextChangedEvent event) {
                TextField compartment = (TextField) event.getSource();
                compartment.setText(event.getNewText());
            }
        };
        graphNode = TestUtil.createEnumerationGraphNode(POSITION, SIZE);
        graphNode.setContainer(new GraphNode());
        properties = TestUtil.createProperties();

        long start = System.currentTimeMillis();

        enumerationNode = new EnumerationNode(graphNode, properties);

        enumerationNode.setAttributesOperationsPopup(new TextInputBox());
        enumerationNode = new EnumerationNode(graphNode, properties);

        enumerationNode.setAttributesOperationsPopup(new TextInputBox());
        // register the listener
        enumerationNode.getNameCompartment().addTextChangedListener(textListener);

        // Then add the node to the container to show it
        enumerationNode.setName("EnumerationNode");
        enumerationNode.setVisible(true);
        TestUtil.loadConfig("test_files/DiagramViewer.xml");
        DiagramViewer viewer = new DiagramViewer("DiagramViewer");
        viewer.add(enumerationNode);

        JDialog dialog = new JDialog((JFrame) null, "EnumerationNode", true);
        dialog.setSize(500, 500);
        dialog.getContentPane().add(viewer);
        dialog.setModal(false);
        dialog.setVisible(true);
        NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "EnumerationNode");
        EnumerationNode node = (EnumerationNode) finder.find(dialog, 0);
        assertNotNull("EnumerationNode component should be displayed", node);
        for (int i = 0; i < 100; i++) {
            helper.enterClickAndLeave(new MouseEventData(this, viewer, 1, true));

            TextField nameCompartment = node.getNameCompartment();
            helper.enterClickAndLeave(new MouseEventData(this, nameCompartment, 2));
        }
        dialog.dispose();
        System.out.println("EnumerationNode tests time:" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * <p>
     * Stress test for InterfaceNode.
     * </p>
     */
    public void testInterfaceNode() throws Exception {
        TextChangedListener textListener = new TextChangedListener() {
            public void textChanged(TextChangedEvent event) {
                TextField compartment = (TextField) event.getSource();
                compartment.setText(event.getNewText());
            }
        };
        graphNode = TestUtil.createClassGraphNode(POSITION, SIZE, true, false);
        graphNode.setContainer(new GraphNode());

        properties = TestUtil.createProperties();
        long start = System.currentTimeMillis();
        interfaceNode = new InterfaceNode(graphNode, properties);
        interfaceNode.setAttributesOperationsPopup(new TextInputBox());
        // register the listener
        interfaceNode.getNameCompartment().addTextChangedListener(textListener);

        // Then add the node to the container to show it
        interfaceNode.setName("InterfaceNode");
        interfaceNode.setVisible(true);
        TestUtil.loadConfig("test_files/DiagramViewer.xml");
        DiagramViewer viewer = new DiagramViewer("DiagramViewer");
        viewer.add(interfaceNode);

        JDialog dialog = new JDialog((JFrame) null, "InterfaceNode", true);
        dialog.setSize(500, 500);
        dialog.getContentPane().add(viewer);
        dialog.setModal(false);
        dialog.setVisible(true);
        NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "InterfaceNode");
        InterfaceNode node = (InterfaceNode) finder.find(dialog, 0);
        assertNotNull("InterfaceNode component should be displayed", node);
        for (int i = 0; i < 100; i++) {
            helper.enterClickAndLeave(new MouseEventData(this, viewer, 1, true));

            TextField nameCompartment = node.getNameCompartment();
            helper.enterClickAndLeave(new MouseEventData(this, nameCompartment, 2));
        }
        dialog.dispose();
        System.out.println("IbterfaceNode tests time:" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * <p>
     * Stress test for ExceptionNode.
     * </p>
     */
    public void testExceptionNode() throws Exception {
        TextChangedListener textListener = new TextChangedListener() {
            public void textChanged(TextChangedEvent event) {
                TextField compartment = (TextField) event.getSource();
                compartment.setText(event.getNewText());
            }
        };
        graphNode = TestUtil.createClassGraphNode(POSITION, SIZE, false, true);
        graphNode.setContainer(new GraphNode());

        properties = TestUtil.createProperties();
        long start = System.currentTimeMillis();
        exceptionNode = new ExceptionNode(graphNode, properties);

        exceptionNode.setAttributesOperationsPopup(new TextInputBox());
        // register the listener
        exceptionNode.getNameCompartment().addTextChangedListener(textListener);

        // Then add the node to the container to show it
        exceptionNode.setName("ExceptionNode");
        exceptionNode.setVisible(true);
        TestUtil.loadConfig("test_files/DiagramViewer.xml");
        DiagramViewer viewer = new DiagramViewer("DiagramViewer");
        viewer.add(exceptionNode);

        JDialog dialog = new JDialog((JFrame) null, "ExceptionNode", true);
        dialog.setSize(500, 500);
        dialog.getContentPane().add(viewer);
        dialog.setModal(false);
        dialog.setVisible(true);
        NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "ExceptionNode");
        ExceptionNode node = (ExceptionNode) finder.find(dialog, 0);
        assertNotNull("ExceptionNode component should be displayed", node);
        for (int i = 0; i < 100; i++) {
            helper.enterClickAndLeave(new MouseEventData(this, viewer, 1, true));

            TextField nameCompartment = node.getNameCompartment();
            helper.enterClickAndLeave(new MouseEventData(this, nameCompartment, 2));
        }
        dialog.dispose();
        System.out.println("ExceptioinNode tests time:" + (System.currentTimeMillis() - start) + " ms");
    }

    /**
     * <p>
     * Stress test for PackageNode.
     * </p>
     */
    public void testPackageNode() throws Exception {
        TextChangedListener textListener = new TextChangedListener() {
            public void textChanged(TextChangedEvent event) {
                TextField compartment = (TextField) event.getSource();
                compartment.setText(event.getNewText());
            }
        };
        graphNode = TestUtil.createPackageGraphNode(POSITION, SIZE);
        graphNode.setContainer(new GraphNode());

        properties = TestUtil.createProperties();
        TransferHandler handler = new TransferHandler(null);
        long start = System.currentTimeMillis();
        packageNode = new PackageNode(graphNode, properties, handler);

        GraphNode classGraphNode = TestUtil.createClassGraphNode(new Point(120, 180), SIZE, false, false);
        ClassNode classNode = new ClassNode(classGraphNode, properties);
        packageNode.addNode(classNode);
        packageNode.notifyGraphNodeChange("ClassNode added.");
        // register the listener
        packageNode.getNameCompartment().addTextChangedListener(textListener);

        // Then add the node to the container to show it
        packageNode.setName("PackageNode");
        packageNode.setVisible(true);
        TestUtil.loadConfig("test_files/DiagramViewer.xml");
        DiagramViewer viewer = new DiagramViewer("DiagramViewer");
        viewer.add(packageNode);

        JDialog dialog = new JDialog((JFrame) null, "PackageNode", true);
        dialog.setSize(500, 500);
        dialog.getContentPane().add(viewer);
        dialog.setModal(false);
        dialog.setVisible(true);
        NamedComponentFinder finder = new NamedComponentFinder(JComponent.class, "PackageNode");
        PackageNode node = (PackageNode) finder.find(dialog, 0);
        assertNotNull("PackageNode component should be displayed", node);
        for (int i = 0; i < 100; i++) {
            helper.enterClickAndLeave(new MouseEventData(this, viewer, 1, true));

            TextField nameCompartment = node.getNameCompartment();
            helper.enterClickAndLeave(new MouseEventData(this, nameCompartment, 2));
        }
        dialog.dispose();
        System.out.println("PackageNode tests time:" + (System.currentTimeMillis() - start) + " ms");
    }
}
