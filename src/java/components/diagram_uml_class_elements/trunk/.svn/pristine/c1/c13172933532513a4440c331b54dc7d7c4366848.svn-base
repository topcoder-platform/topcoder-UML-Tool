/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.util.Map;

import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPopupMenu;

import junit.extensions.jfcunit.JFCTestCase;
import junit.extensions.jfcunit.JFCTestHelper;
import junit.extensions.jfcunit.TestHelper;
import junit.extensions.jfcunit.eventdata.MouseEventData;
import junit.extensions.jfcunit.finder.NamedComponentFinder;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.TextInputBox;
import com.topcoder.gui.diagramviewer.uml.classelements.event.BoundaryChangedEvent;
import com.topcoder.gui.diagramviewer.uml.classelements.event.BoundaryChangedListener;
import com.topcoder.gui.diagramviewer.uml.classelements.event.EdgeAddEvent;
import com.topcoder.gui.diagramviewer.uml.classelements.event.EdgeAddListener;
import com.topcoder.gui.diagramviewer.uml.classelements.event.TextChangedEvent;
import com.topcoder.gui.diagramviewer.uml.classelements.event.TextChangedListener;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.Feature;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;

/**
 * <p>
 * Test the functionality of <code>ClassNode</code> class and <code>BaseNode</code> class.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class ClassNodeTest extends JFCTestCase {

    /** The absolute position of the visual node. Used for testing only. */
    private static final Point POSITION = new Point(100, 150);

    /** The size of the visual node. Used for testing only. */
    private static final Dimension SIZE = new Dimension(80, 40);

    /** An instance of <code>ClassNode</code> for testing. */
    private ClassNode classNode;

    /** A GraphNode for <code>ClassNode</code>. */
    private GraphNode graphNode;

    /** Properties for testing. */
    private Map<String, String> properties;

    /** Boundary changed listener for <code>ClassNode</code>. */
    private MockedBoundaryChangedListener boundChangedListener;

    /** Edge add listener for <code>ClassNode</code>. */
    private MockedEdgeAddListener edgeAddListener;

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

        graphNode = TestUtil.createClassGraphNode(POSITION, SIZE, false, false);
        graphNode.setContainer(new GraphNode());

        properties = TestUtil.createProperties();

        classNode = new ClassNode(graphNode, properties);

        classNode.setAttributesOperationsPopup(new TextInputBox());

        boundChangedListener = new MockedBoundaryChangedListener();
        edgeAddListener = new MockedEdgeAddListener();
    }

    /**
     * Test method for 'ClassNode(GraphNode, Map)'. The instance should be created successfully.
     */
    public void testClassNode_Accuracy() {
        assertNotNull("Test method for 'ClassNode(GraphNode, Map<String, String>)' failed.", classNode);
    }

    /**
     * Test method for 'ClassNode(GraphNode, Map)'. The first argument is null, IllegalArgumentException should be
     * thrown.
     */
    public void testClassNode_null_1() {
        try {
            new ClassNode(null, properties);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        } catch (IllegalGraphElementException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test method for 'ClassNode(GraphNode, Map)'. The second argument is null, IllegalArgumentException should be
     * thrown.
     */
    public void testClassNode_null_2() {
        try {
            new ClassNode(graphNode, null);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        } catch (IllegalGraphElementException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test method for 'ClassNode(GraphNode, Map)'. The properties map contains null, IllegalArgumentException should be
     * thrown.
     */
    public void testClassNode_contain_null() {
        try {
            Map<String, String> map = properties;
            map.put("sfd", null);
            new ClassNode(graphNode, map);
            fail("IllegalArgumentException should be thrown.");
        } catch (IllegalArgumentException iae) {
            // Success
        } catch (IllegalGraphElementException e) {
            fail(e.getMessage());
        }
    }

    /**
     * Test method for 'ClassNode(GraphNode, Map)'. Bad GraphNode structure is given, IllegalArgumentException should be
     * thrown.
     */
    public void testClassNode_Invalid_GraphNode() {
        try {
            GraphNode node = TestUtil.createPackageGraphNode(POSITION, SIZE);
            new ClassNode(node, properties);
            fail("IllegalGraphElementException should be thrown.");
        } catch (IllegalArgumentException iae) {
            fail(iae.getMessage());
        } catch (IllegalGraphElementException e) {
            // Success
        }
    }

    /**
     * Test method for 'contains(int, int)'. Inner point is given, should be true.
     */
    public void testContains_True() {
        int x = classNode.getSelectionBound().x + (int) classNode.getSelectionBound().getWidth() / 2;
        int y = classNode.getSelectionBound().y + (int) classNode.getSelectionBound().getHeight() / 2;
        assertTrue("The given point should be contained.", classNode.contains(x, y));
    }

    /**
     * Test method for 'contains(int, int)'. Outer point is given, should be false.
     */
    public void testContains_False_1() {
        int x = -10;
        int y = -10;
        assertFalse("The given point should not be contained.", classNode.contains(x, y));
    }

    /**
     * Test method for 'contains(int, int)'. A point between selection bound and graph node is given, should be false.
     */
    public void testContains_False_2() {
        int x = classNode.getSelectionBound().x / 2;
        /*
         * BugFix: BUGID UML-8194
         * Description:
         * In contains, the selection corners around this node should be checked to determine whether or not the
         * point is contained.
         * Solution:
         * Code is added to check the child components.
         */
        // old code
//        int y = classNode.getSelectionBound().y;
        int y = classNode.getSelectionBound().y + classNode.getSelectionBound().height / 4;
        assertFalse("The given point should not be contained.", classNode.contains(x, y));
    }

    /**
     * Test method for 'notifyGraphNodeChange(String)'. The node should change accordingly.
     */
    public void testNotifyGraphNodeChange() {
        Classifier classifier = (Classifier) TestUtil.getElement(graphNode);
        classifier.addFeature(TestUtil.createOperation("operation_4", "void", "parameter_4", "double"));

        Rectangle oldBound = classNode.getSelectionBound();
        classNode.addBoundaryChangedListener(boundChangedListener);
        classNode.notifyGraphNodeChange("New operation added.");
        Rectangle newBound = classNode.getSelectionBound();
        assertTrue("The size should increase.", newBound.height > oldBound.height);
    }

    /**
     * Test method for 'consumeEvent(MouseEvent)'. The argument is null, should be ignored.
     */
    public void testconsumeEvent_null() {
        assertFalse("Null event should be ignored.", classNode.consumeEvent(null));
    }

    /**
     * Test method for 'consumeEvent(MouseEvent)'. The argument is a valid MousePressed event, should be consumed.
     */
    public void testconsumeEvent_Valid_MousePressed() {
        MouseEvent event = new MouseEvent(TestUtil.createGeneralizationEdge(), MouseEvent.MOUSE_PRESSED, 1000,
                MouseEvent.ALT_DOWN_MASK, 0, 0, 1, false);
        assertTrue("Valid MousePressed event should be consumed.", classNode.consumeEvent(event));
    }

    /**
     * Test method for 'consumeEvent(MouseEvent)'. The argument is an invalid MousePressed event, should not be
     * consumed.
     */
    public void testconsumeEvent_Invalid_MousePressed() {
        MouseEvent event = new MouseEvent(TestUtil.createAbstractionEdge(), MouseEvent.MOUSE_PRESSED, 1000,
                MouseEvent.ALT_DOWN_MASK, 0, 0, 1, false);
        assertFalse("Invalid MousePressed event should not be consumed.", classNode.consumeEvent(event));
    }

    /**
     * Test method for 'consumeEvent(MouseEvent)'. The argument is a valid MouseReleased event, should be consumed.
     */
    public void testconsumeEvent_Valid_MouseReleased() {
        MouseEvent event = new MouseEvent(TestUtil.createAbstractionEdge(), MouseEvent.MOUSE_RELEASED, 1000,
                MouseEvent.ALT_DOWN_MASK, 0, 0, 1, false);
        assertTrue("Valid MouseReleased event should be consumed.", classNode.consumeEvent(event));
    }

    /**
     * Test method for 'consumeEvent(MouseEvent)'. The argument is an invalid MouseReleased event, should not be
     * consumed.
     */
    public void testconsumeEvent_Invalid_MouseReleased() {
        MouseEvent event = new MouseEvent(TestUtil.createGeneralizationEdge(), MouseEvent.MOUSE_RELEASED, 1000,
                MouseEvent.ALT_DOWN_MASK, 0, 0, 1, false);
        assertFalse("Invalid MouseReleased event should not be consumed.", classNode.consumeEvent(event));
    }

    /**
     * Test method for 'getPreferredGraphNodeSize()'. The default graph node size should be got correctly.
     */
    public void testGetPreferredGraphNodeSize() {
        assertNotNull("The default graph node size should be got correctly.", classNode.getPreferredGraphNodeSize());
    }

    /**
     * Test method for 'BaseNode.getStrokeColor()'. Stroke color of this node should be got correctly.
     */
    public void testGetStrokeColor() {
        assertEquals("Stroke color of this node should be got correctly.", classNode.getStrokeColor(), Color.BLACK);
    }

    /**
     * Test method for 'BaseNode.getFillColor()'. Fill color of this node should be got correctly.
     */
    public void testGetFillColor() {
        assertEquals("Fill color of this node should be got correctly.", classNode.getFillColor(), Color.GREEN);
    }

    /**
     * Test method for 'BaseNode.getFontColor()'. Font color of this node should be got correctly.
     */
    public void testGetFontColor() {
        assertEquals("Font color of this node should be got correctly.", classNode.getFontColor(), Color.BLACK);
    }

    /**
     * Test method for 'BaseNode.getConnector()'. Connector of this node should be got correctly.
     */
    public void testGetConnector() {
        assertNotNull("Connector of this node should be got correctly.", classNode.getConnector());
    }

    /**
     * Test method for 'BaseNode.getNameCompartment()'. Name compartment should be got correctly.
     */
    public void testGetNameCompartment() {
        assertNotNull("Name compartment should be got correctly.", classNode.getNameCompartment());
    }

    /**
     * Test method for 'BaseNode.getStereotypeCompartment()'. Stereotype compartment should be got correctly.
     */
    public void testGetStereotypeCompartment() {
        assertNotNull("Stereotype compartment should be got correctly.", classNode.getStereotypeCompartment());
    }

    /**
     * Test method for 'BaseNode.getNamespaceCompartment()'. Namespace compartment should be got correctly.
     */
    public void testGetNamespaceCompartment() {
        assertNotNull("Namespace compartment should be got correctly.", classNode.getNamespaceCompartment());
    }

    /**
     * Test method for 'notifyPropertiesChange()'. Properties of this node should be updated correctly.
     */
    public void testNotifyPropertiesChange() {
        graphNode.clearProperties();
        graphNode.addProperty(TestUtil.createProperty("FILL_COLOR", "FFFFFF"));
        classNode.notifyPropertiesChange();
        assertEquals(classNode.getFillColor(), Color.WHITE);
    }

    /**
     * Test method for 'BaseNode.addBoundaryChangedListener(BoundaryChangedListener)', listener should be added
     * correctly.
     */
    public void testAddBoundaryChangedListener() {
        classNode.removeBoundaryChangedListener(boundChangedListener);
        BoundaryChangedListener[] oldListeners = classNode.getListeners(BoundaryChangedListener.class);
        classNode.addBoundaryChangedListener(boundChangedListener);
        BoundaryChangedListener[] newListeners = classNode.getListeners(BoundaryChangedListener.class);
        assertEquals(oldListeners.length + 1, newListeners.length);
        assertEquals(newListeners[newListeners.length - 1], boundChangedListener);
    }

    /**
     * Test method for 'BaseNode.removeBoundaryChangedListener(BoundaryChangedListener)', listener should be removed
     * correctly.
     */
    public void testRemoveBoundaryChangedListener() {
        classNode.addBoundaryChangedListener(boundChangedListener);
        BoundaryChangedListener[] oldListeners = classNode.getListeners(BoundaryChangedListener.class);
        classNode.removeBoundaryChangedListener(boundChangedListener);
        BoundaryChangedListener[] newListeners = classNode.getListeners(BoundaryChangedListener.class);
        assertEquals(oldListeners.length - 1, newListeners.length);
    }

    /**
     * Test method for 'BaseNode.fireBoundaryChange(BoundaryChangedEvent)', event should be fired correctly.
     */
    public void testFireBoundaryChange() {
        classNode.addBoundaryChangedListener(boundChangedListener);
        BoundaryChangedEvent event = new BoundaryChangedEvent(classNode, new Rectangle(0, 0), new Rectangle(50, 50));
        classNode.fireBoundaryChanged(event);
    }

    /**
     * Test method for 'BaseNode.notifyNamespaceVisibilityChange()'. Bound of this node should be updated correctly.
     */
    public void testNotifyNamespaceVisibilityChange() {
        int oldHeight = classNode.getHeight();
        classNode.getNamespaceCompartment().getGraphNode().setVisible(false);
        classNode.notifyNamespaceVisibilityChange();
        /*
         * BugFix: BUGID UML-8194
         * Description:
         * In calculateSize, at the end of the method, the calculated size should also be compared with the user
         * defined size.
         * In notifyGraphNodeChange, the calculated preferred size should be set to the graph node to keep consistency.
         * Solution:
         * Code is added to compare with the user defined size.
         * Set the calculated size to the graph node to keep consistency.
         */
        // old code
//        assertTrue("Bound of this node should be changed.", classNode.getHeight() < oldHeight);
        assertTrue("Bound of this node should be changed.", classNode.getHeight() == oldHeight);
    }

    /**
     * Test method for 'notifyStereotypeVisibilityChange()'. Bound of this node should be updated correctly.
     */
    public void testNotifyStereotypeVisibilityChange() {
        int oldHeight = classNode.getHeight();
        classNode.getStereotypeCompartment().getGraphNode().setVisible(false);
        classNode.notifyStereotypeVisibilityChange();
        /*
         * BugFix: BUGID UML-8194
         * Description:
         * In calculateSize, at the end of the method, the calculated size should also be compared with the user
         * defined size.
         * In notifyGraphNodeChange, the calculated preferred size should be set to the graph node to keep consistency.
         * Solution:
         * Code is added to compare with the user defined size.
         * Set the calculated size to the graph node to keep consistency.
         */
        // old code
//        assertTrue("Bound of this node should be changed.", classNode.getHeight() < oldHeight);
        assertTrue("Bound of this node should be changed.", classNode.getHeight() == oldHeight);
    }

    /**
     * Test method for 'BaseNode.addEdgeAddListener(EdgeAddListener)', listener should be added correctly.
     */
    public void testAddEdgeAddListener() {
        classNode.removeEdgeAddListener(edgeAddListener);
        EdgeAddListener[] oldListeners = classNode.getListeners(EdgeAddListener.class);
        classNode.addEdgeAddListener(edgeAddListener);
        EdgeAddListener[] newListeners = classNode.getListeners(EdgeAddListener.class);
        assertEquals(oldListeners.length + 1, newListeners.length);
        assertEquals(newListeners[newListeners.length - 1], edgeAddListener);
    }

    /**
     * Test method for 'BaseNode.removeEdgeAddListener(EdgeAddListener)', listener should be removed correctly.
     */
    public void testRemoveEdgeAddListener() {
        classNode.addEdgeAddListener(edgeAddListener);
        EdgeAddListener[] oldListeners = classNode.getListeners(EdgeAddListener.class);
        classNode.removeEdgeAddListener(edgeAddListener);
        EdgeAddListener[] newListeners = classNode.getListeners(EdgeAddListener.class);
        assertEquals(oldListeners.length - 1, newListeners.length);
    }

    /**
     * Test method for 'BaseNode.fireEdgeAdd(EdgeAddEvent)', event should be fired correctly.
     */
    public void testFireEdgeAdd() {
        classNode.addEdgeAddListener(edgeAddListener);
        EdgeAddEvent event = new EdgeAddEvent(classNode, new Point(0, 0), false);
        classNode.fireEdgeAdd(event);
    }

    /**
     * Test method for 'notifyAttributesVisibilityChange()'. Bound of this node should be updated correctly.
     */
    public void testNotifyAttributesVisibilityChange() {
        int oldHeight = classNode.getHeight();
        graphNode.getContaineds().get(2).setVisible(false);
        classNode.notifyAttributesVisibilityChange();
        /*
         * BugFix: BUGID UML-8194
         * Description:
         * In calculateSize, at the end of the method, the calculated size should also be compared with the user
         * defined size.
         * In notifyGraphNodeChange, the calculated preferred size should be set to the graph node to keep consistency.
         * Solution:
         * Code is added to compare with the user defined size.
         * Set the calculated size to the graph node to keep consistency.
         */
        // old code
//        assertTrue("Bound of this node should be changed.", classNode.getHeight() < oldHeight);
        assertTrue("Bound of this node should be changed.", classNode.getHeight() == oldHeight);
    }

    /**
     * Test method for 'notifyOperationsVisibilityChange()'. Bound of this node should be updated correctly.
     */
    public void testNotifyOperationsVisibilityChange() {
        int oldHeight = classNode.getHeight();
        graphNode.getContaineds().get(4).setVisible(false);
        classNode.notifyOperationsVisibilityChange();
        /*
         * BugFix: BUGID UML-8194
         * Description:
         * In calculateSize, at the end of the method, the calculated size should also be compared with the user
         * defined size.
         * In notifyGraphNodeChange, the calculated preferred size should be set to the graph node to keep consistency.
         * Solution:
         * Code is added to compare with the user defined size.
         * Set the calculated size to the graph node to keep consistency.
         */
        // old code
//        assertTrue("Bound of this node should be changed.", classNode.getHeight() < oldHeight);
        assertTrue("Bound of this node should be changed.", classNode.getHeight() == oldHeight);
    }

    /**
     * Test method for 'BaseNode.getAttributesCompartment()'. Attributes compartment should be got correctly.
     */
    public void testGetAttributesCompartment() {
        assertNotNull("Attributes compartment should be got correctly.", classNode.getAttributesCompartment());
    }

    /**
     * Test method for 'BaseNode.getOperationsCompartment()'. Operations compartment should be got correctly.
     */
    public void testGetOperationsCompartment() {
        assertNotNull("Operations compartment should be got correctly.", classNode.getOperationsCompartment());
    }

    /**
     * Test method for 'BaseNode.notifyAttributesStereotypeVisibilityChanged()'. Attribute of this node should be
     * updated correctly.
     */
    public void testNotifyAttributesStereotypeVisibilityChanged() {
        StereotypeTextField attributeField = classNode.getAttributesCompartment().getItems().get(0);
        int oldWidth = attributeField.getStereotype().length();
        Classifier element = (Classifier) Util.getElement(graphNode);
        Attribute attribute = null;
        for (Feature feature : element.getFeatures()) {
            if (feature instanceof Attribute) {
                attribute = (Attribute) feature;
                break;
            }
        }
        Stereotype stereotype = new StereotypeImpl();
        stereotype.setName("Stereotype");
        attribute.addStereotype(stereotype);
        classNode.notifyAttributesStereotypeVisibilityChange();
        attributeField = classNode.getAttributesCompartment().getItems().get(0);
        assertTrue("Attribute of this node should be changed.", attributeField.getStereotype().length() > oldWidth);
    }

    /**
     * Test method for 'BaseNode.notifyOperationsStereotypeVisibilityChanged()'. Operation of this node should be
     * updated correctly.
     */
    public void testNotifyOperationsStereotypeVisibilityChanged() {
        StereotypeTextField operationField = classNode.getOperationsCompartment().getItems().get(0);
        int oldWidth = operationField.getStereotype().length();
        Classifier element = (Classifier) Util.getElement(graphNode);
        Operation operation = null;
        for (Feature feature : element.getFeatures()) {
            if (feature instanceof Operation) {
                operation = (Operation) feature;
                break;
            }
        }
        Stereotype stereotype = new StereotypeImpl();
        stereotype.setName("Stereotype");
        operation.addStereotype(stereotype);
        classNode.notifyOperationsStereotypeVisibilityChange();
        operationField = classNode.getOperationsCompartment().getItems().get(0);
        assertTrue("Operation of this node should be changed.", operationField.getStereotype().length() > oldWidth);
    }

    /**
     * Test method for 'BaseNode.getAttributesOperationsPopup()'. The menu should be got correctly.
     */
    public void testGetAttributesOperationsPopup() {
        assertNotNull("The menu should be got correctly.", classNode.getAttributesOperationsPopup());
    }

    /**
     * Test method for 'BaseNode.setAttributesOperationsPopup(JPopupMenu)'. The menu should be set correctly.
     */
    public void testSetAttributesOperationsPopup() {
        JPopupMenu menu = new JPopupMenu();
        classNode.setAttributesOperationsPopup(menu);
        assertEquals("The menu should be set correctly.", classNode.getAttributesOperationsPopup(), menu);
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

        classNode = null;

        boundChangedListener = null;
        edgeAddListener = null;
    }
}
