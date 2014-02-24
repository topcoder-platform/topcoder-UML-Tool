/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;

import junit.extensions.jfcunit.JFCTestCase;
import junit.extensions.jfcunit.JFCTestHelper;
import junit.extensions.jfcunit.TestHelper;
import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.NamedComponentFinder;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.TextInputBox;
import com.topcoder.gui.diagramviewer.uml.classelements.event.TextChangedEvent;
import com.topcoder.gui.diagramviewer.uml.classelements.event.TextChangedListener;

/**
 * <p>
 * Test the functionality of <code>ExceptionNode</code> class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ExceptionNodeTest extends JFCTestCase {

    /** The absolute position of the visual node. Used for testing only. */
    private static final Point POSITION = new Point(100, 150);

    /** The size of the visual node. Used for testing only. */
    private static final Dimension SIZE = new Dimension(80, 40);

    /** An instance of <code>ExceptionNode</code> for testing. */
    private ExceptionNode exceptionNode;

    /** A GraphNode for <code>ExceptionNode</code>. */
    private GraphNode graphNode;

    /** Properties for testing. */
    private Map<String, String> properties;

    /** An instance of JFC <code>TestHelper</code> for testing. */
    private TestHelper helper = null;

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

        graphNode = TestUtil.createClassGraphNode(POSITION, SIZE, false, true);
        graphNode.setContainer(new GraphNode());

        properties = TestUtil.createProperties();

        exceptionNode = new ExceptionNode(graphNode, properties);

        exceptionNode.setAttributesOperationsPopup(new TextInputBox());
    }

    /**
     * Test method for 'ExceptionNode(GraphNode, Map)'. The instance should be created successfully.
     */
    public void testExceptionNode_Accuracy() {
        assertNotNull("Test method for 'ExceptionNode(GraphNode, Map<String, String>)' failed.", exceptionNode);
    }

    /**
     * Test method for 'ExceptionNode(GraphNode, Map)'. The first argument is null, IllegalArgumentException should be
     * thrown.
     */
    public void testExceptionNode_null_1() {
        try {
            new ExceptionNode(null, properties);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        } catch (IllegalGraphElementException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test method for 'ExceptionNode(GraphNode, Map)'. The second argument is null, IllegalArgumentException should be
     * thrown.
     */
    public void testExceptionNode_null_2() {
        try {
            new ExceptionNode(graphNode, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        } catch (IllegalGraphElementException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test method for 'ExceptionNode(GraphNode, Map)'. The properties map contains null, IllegalArgumentException
     * should be thrown.
     */
    public void testExceptionNode_contain_null() {
        try {
            Map<String, String> map = properties;
            map.put("sfd", null);
            new ExceptionNode(graphNode, map);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        } catch (IllegalGraphElementException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test method for 'ExceptionNode(GraphNode, Map)'. Bad GraphNode structure is given, IllegalArgumentException
     * should be thrown.
     */
    public void testExceptionNode_Invalid_GraphNode() {
        try {
            GraphNode node = TestUtil.createPackageGraphNode(POSITION, SIZE);
            new ExceptionNode(node, properties);
            fail("IllegalGraphElementException should be thrown.");
        } catch (IllegalArgumentException iae) {
            fail(iae.getMessage());
        } catch (IllegalGraphElementException e) {
            // Success
        }
    }

    /**
     * Test method for 'consumeEvent(MouseEvent)'. The argument is null, should be ignored.
     */
    public void testconsumeEvent_null() {
        assertFalse("Null event should be ignored.", exceptionNode.consumeEvent(null));
    }

    /**
     * Test method for 'consumeEvent(MouseEvent)'. The argument is a valid MousePressed event, should be consumed.
     */
    public void testconsumeEvent_Valid_MousePressed() {
        MouseEvent event = new MouseEvent(TestUtil.createGeneralizationEdge(), MouseEvent.MOUSE_PRESSED, 1000,
                MouseEvent.ALT_DOWN_MASK, 0, 0, 1, false);
        assertTrue("Valid MousePressed event should be consumed.", exceptionNode.consumeEvent(event));
    }

    /**
     * Test method for 'consumeEvent(MouseEvent)'. The argument is an invalid MousePressed event, should not be
     * consumed.
     */
    public void testconsumeEvent_Invalid_MousePressed() {
        MouseEvent event = new MouseEvent(TestUtil.createAbstractionEdge(), MouseEvent.MOUSE_PRESSED, 1000,
                MouseEvent.ALT_DOWN_MASK, 0, 0, 1, false);
        assertFalse("Invalid MousePressed event should not be consumed.", exceptionNode.consumeEvent(event));
    }

    /**
     * Test method for 'consumeEvent(MouseEvent)'. The argument is a valid MouseReleased event, should be consumed.
     */
    public void testconsumeEvent_Valid_MouseReleased() {
        MouseEvent event = new MouseEvent(TestUtil.createAbstractionEdge(), MouseEvent.MOUSE_RELEASED, 1000,
                MouseEvent.ALT_DOWN_MASK, 0, 0, 1, false);
        assertTrue("Valid MouseReleased event should be consumed.", exceptionNode.consumeEvent(event));
    }

    /**
     * Test method for 'consumeEvent(MouseEvent)'. The argument is an invalid MouseReleased event, should not be
     * consumed.
     */
    public void testconsumeEvent_Invalid_MouseReleased() {
        MouseEvent event = new MouseEvent(TestUtil.createGeneralizationEdge(), MouseEvent.MOUSE_RELEASED, 1000,
                MouseEvent.ALT_DOWN_MASK, 0, 0, 1, false);
        assertFalse("Invalid MouseReleased event should not be consumed.", exceptionNode.consumeEvent(event));
    }

    /**
     * Test the GUI. The component should be displayed correctly.
     */
    public void testGUI() throws Exception {

        TextChangedListener textListener = new TextChangedListener() {
            public void textChanged(TextChangedEvent event) {
                TextField compartment = (TextField) event.getSource();
                compartment.setText(event.getNewText());
            }
        };
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

        helper.enterClickAndLeave(new MouseEventData(this, viewer, 1, true));

        TextField nameCompartment = node.getNameCompartment();
        helper.enterClickAndLeave(new MouseEventData(this, nameCompartment, 2));
        sleep(100);
        dialog.dispose();
    }

    /**
     * <p>
     * Tears down the test environment.
     * </p>
     */
    protected void tearDown() throws Exception {
        super.tearDown();

        helper = null;

        graphNode = null;

        properties = null;

        exceptionNode = null;
    }
}
