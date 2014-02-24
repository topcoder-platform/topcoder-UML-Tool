/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.elements.stresstests;

import com.topcoder.diagraminterchange.GraphNode;

import com.topcoder.gui.diagramviewer.elements.CornerDragListener;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.elements.NodeDragListener;
import com.topcoder.gui.diagramviewer.elements.SelectionCorner;
import com.topcoder.gui.diagramviewer.elements.SelectionCornerType;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.awt.Point;
import java.awt.Rectangle;

import java.lang.reflect.Field;

import java.util.ArrayList;
import java.util.Collection;

import javax.swing.JComponent;
import javax.swing.event.EventListenerList;


/**
 * <p>This class tests the <code>Node</code> class for stress. This stress tests addresses the
 * functionality provided by the <code>Node</code> class.</p>
 *
 * @author icyriver
 * @version 1.0
 */
public class NodeStressTest extends TestCase {
    /**
     * <p>The int number represents the loop times for stress test.</p>
     */
    private static final int LOOPTIMES = 100;

    /**
     * <p>The <code>GraphNode</code> instance used for test.</p>
     */
    private GraphNode graphNode = new GraphNode();

    /**
     * <p>The <code>Rectangle</code> instance used for test.</p>
     */
    private Rectangle bound = new Rectangle(50, 150, 100, 100);

    /**
     * <p>The <code>SelectionCornerType</code> collection used for test.</p>
     */
    private Collection<SelectionCornerType> cornerTypes = null;

    /**
     * <p>The instance of <code>Node</code> for test.</p>
     */
    private Node node = null;

    /**
     * <p>Return test suite of <code>NodeStressTest</code>.</p>
     *
     * @return Test suite of <code>NodeStressTest</code>.
     */
    public static Test suite() {
        return new TestSuite(NodeStressTest.class);
    }

    /**
     * <p>Set up the stress testing environment.</p>
     */
    protected void setUp() {
        // create the SelectionCorner type here.
        cornerTypes = new ArrayList<SelectionCornerType>();
        cornerTypes.add(SelectionCornerType.EAST);
        cornerTypes.add(SelectionCornerType.SOUTH);
        cornerTypes.add(SelectionCornerType.WEST);
        cornerTypes.add(SelectionCornerType.NORTH);
        cornerTypes.add(SelectionCornerType.NORTHEAST);
        cornerTypes.add(SelectionCornerType.NORTHWEST);
        cornerTypes.add(SelectionCornerType.SOUTHEAST);
        cornerTypes.add(SelectionCornerType.SOUTHWEST);
    }

    /**
     * <p>Basic stress test of <code>Node</code>'s constructor.</p>
     */
    public void testCtor_Node() {
        for (int i = 0; i < LOOPTIMES; i++) {
            // create a new node with new position.
            Point position = new Point(100 + i, 200);
            node = new SimpleNode(graphNode, position, bound, cornerTypes);

            // check the result here.
            assertNotNull("The Node constructor is incorrect.", node);
            assertEquals("The Node constructor  is incorrect.", cornerTypes.size(),
                ((SimpleNode) node).getSelectionCorners().size());
            assertTrue("The Node constructor  is incorrect.",
                node.getRelativePosition().equals(position));
            assertTrue("The Node constructor  is incorrect.", node.getSelectionBound().equals(bound));

            Collection<SelectionCorner> corners = ((SimpleNode) node).getSelectionCorners();

            // check the corner listener here.
            for (SelectionCorner corner : corners) {
                assertTrue("The Node constructor  is incorrect.",
                    corner.getMouseListeners().length == 1);
                assertTrue("The Node constructor  is incorrect.",
                    corner.getMouseMotionListeners().length == 1);
            }
        }
    }

    /**
     * <p>Basic stress test of <code>getSelectionCorners()</code> method.</p>
     */
    public void testMethod_getSelectionCorners() {
        Point position = new Point(100, 200);

        for (int i = 0; i < LOOPTIMES; i++) {
            // create a new node with new bound.
            int step = 2 * i;
            Rectangle newBound = new Rectangle(50, 150, 200 + step, 200 - step);

            node = new SimpleNode(graphNode, position, newBound, cornerTypes);

            // check the selection corner here.
            Collection<SelectionCorner> corners = ((SimpleNode) node).getSelectionCorners();

            for (SelectionCorner corner : corners) {
                // check the center here.
                assertTrue("The Node constructor  is incorrect.",
                    getCornerCenter(newBound, corner.getType()).equals(corner.getCenter()));

                // check the listener here.
                assertTrue("The Node constructor  is incorrect.",
                    corner.getMouseListeners().length == 1);
                assertTrue("The Node constructor  is incorrect.",
                    corner.getMouseMotionListeners().length == 1);
            }
        }
    }

    /**
     * <p>Basic stress test of <code>addXXXListener()</code> methods.</p>
     */
    public void testMethod_addXXXListener() {
        Point position = new Point(100, 200);
        node = new SimpleNode(graphNode, position, bound, cornerTypes);

        for (int i = 0; i < LOOPTIMES; i++) {
            node.addNodeDragListener(new SimpleNodeDragListener());
            node.addCornerDragListener(new SimpleCornerDragListener());
        }

        // check the eventListenerList here.
        EventListenerList eventListenerList = (EventListenerList) getPrivateField(JComponent.class,
                node, "listenerList");
        assertEquals("The addXXXListener method is incorrect.", LOOPTIMES * 2,
            eventListenerList.getListenerCount());

        // add null listener here, nothing will happen.
        for (int i = 0; i < LOOPTIMES; i++) {
            node.addNodeDragListener(null);
            node.addCornerDragListener(null);
        }

        // check the eventListenerList here.
        eventListenerList = (EventListenerList) getPrivateField(JComponent.class, node,
                "listenerList");
        assertEquals("The addXXXListener method is incorrect.", LOOPTIMES * 2,
            eventListenerList.getListenerCount());
    }

    /**
     * <p>Basic stress test of <code>reoveXXXListener()</code> methods.</p>
     */
    public void testMethod_removeXXXListener() {
        Point position = new Point(100, 200);
        node = new SimpleNode(graphNode, position, bound, cornerTypes);

        ArrayList<NodeDragListener> nodeListeners = new ArrayList<NodeDragListener>();
        ArrayList<CornerDragListener> cornerListeners = new ArrayList<CornerDragListener>();

        // add some listener here
        for (int i = 0; i < LOOPTIMES; i++) {
        	NodeDragListener nodeListener = new SimpleNodeDragListener();
        	nodeListeners.add(nodeListener);
        	CornerDragListener cornerListener = new SimpleCornerDragListener();
        	cornerListeners.add(cornerListener);
        	
        	// add into node here.
            node.addNodeDragListener(nodeListener);
            node.addCornerDragListener(cornerListener);
        }

        // remove null listener here, nothing will happen.
        for (int i = 0; i < LOOPTIMES; i++) {
            node.removeNodeDragListener(null);
            node.removeCornerDragListener(null);
        }

        // check the eventListenerList here.
        EventListenerList eventListenerList = (EventListenerList) getPrivateField(JComponent.class,
                node, "listenerList");
        assertEquals("The addXXXListener method is incorrect.", LOOPTIMES * 2,
            eventListenerList.getListenerCount());

        // remove the node listeners here
        for (NodeDragListener listener : nodeListeners) {
        	node.removeNodeDragListener(listener);
        }
        
        eventListenerList = (EventListenerList) getPrivateField(JComponent.class,
                node, "listenerList");
        assertEquals("The addXXXListener method is incorrect.", LOOPTIMES,
            eventListenerList.getListenerCount());
        
        // remove the corner listeners here
        for (CornerDragListener listener : cornerListeners) {
        	node.removeCornerDragListener(listener);
        }
        
        eventListenerList = (EventListenerList) getPrivateField(JComponent.class,
                node, "listenerList");
        assertEquals("The addXXXListener method is incorrect.", 0,
            eventListenerList.getListenerCount());
    }

    /**
     * <p>This method will get the center of the given corner basing its type and node
     * selection bound.</p>
     *
     * @param bound the selection bound of node.
     * @param type the type of corner.
     *
     * @return the center of  the given corner.
     */
    private Point getCornerCenter(Rectangle bound, SelectionCornerType type) {
        if (type == SelectionCornerType.EAST) {
            return new Point(bound.x + bound.width,
                (int) Math.round(bound.y + (bound.getHeight() / 2)));
        } else if (type == SelectionCornerType.SOUTH) {
            return new Point((int) Math.round(bound.x + (bound.getWidth() / 2)),
                bound.y + bound.height);
        } else if (type == SelectionCornerType.WEST) {
            return new Point(bound.x, (int) Math.round(bound.y + (bound.getHeight() / 2)));
        } else if (type == SelectionCornerType.NORTH) {
            return new Point((int) Math.round(bound.x + (bound.getWidth() / 2)), bound.y);
        } else if (type == SelectionCornerType.NORTHEAST) {
            return new Point(bound.x + bound.width, bound.y);
        } else if (type == SelectionCornerType.NORTHWEST) {
            return new Point(bound.x, bound.y);
        } else if (type == SelectionCornerType.SOUTHEAST) {
            return new Point(bound.x + bound.width, bound.y + bound.height);
        } else {
            return new Point(bound.x, bound.y + bound.height);
        }
    }

    /**
     * <p>This method will get the value of a private field in the given class.</p>
     *
     * @param type the class which the private field belongs to.
     * @param instance the instance which the private field belongs to.
     * @param name the name of the private field to be retrieved.
     *
     * @return the value of the private field.
     */
    private Object getPrivateField(Class type, Object instance, String name) {
        Field field = null;
        Object obj = null;

        try {
            // get the reflection of the field
            field = type.getDeclaredField(name);
            // set the field accessible
            field.setAccessible(true);
            // get the value
            obj = field.get(instance);
        } catch (NoSuchFieldException e) {
            // ignore
        } catch (IllegalAccessException e) {
            // ignore
        } finally {
            if (field != null) {
                // reset the accessibility
                field.setAccessible(false);
            }
        }

        return obj;
    }
}
