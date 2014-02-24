/*
 * Copyright (C) 2007, TopCoder, Inc. All rights reserved
 */
package com.topcoder.gui.diagramviewer.elements.accuracytests;

import java.awt.Point;
import java.awt.Rectangle;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.elements.LocationEvent;
import com.topcoder.gui.diagramviewer.elements.Node;

import junit.framework.TestCase;

/**
 * Accuracy test cases for class <code>LocationEvent </code>.
 *
 * @author Chenhong
 * @version 1.0
 */
public class TestLocationEventAccuracy extends TestCase {

	/**
     * Represents the LocationEvent instance for testing.
     */
	private LocationEvent event = null;

	/**
     * Represents the old point for testing.
     */
	private Point oldPoint = null;

	/**
     * Represents the new point for testing.
     */
	private Point newPoint = null;

	/**
     * Represents the Node for testing.
     */
	private Node node = null;

	/**
     * Set up.
     */
	public void setUp() {
		node = new MyNode(new GraphNode(), new Point(1, 100), new Rectangle(1, 2, 10, 100),
				Helper.getCollection());

		oldPoint = new Point(1, 2);
		newPoint = new Point(100, 101);
		event = new LocationEvent(node, oldPoint, newPoint);
	}

	/**
	 * Test the constructor.
	 */
	public void testLocationEvent() {
		assertNotNull("Should not be null.");
	}

	/**
	 * Test method <code>Point getOldLocation() </code>.
	 *
	 */
	public void testGetOldLocation() {
		Point ret = event.getOldLocation();
		assertEquals("Equal is expected.", 1.0, ret.getX());
		assertEquals("Equal is expected.", 2.0, ret.getY());
	}

	/**
	 * Test method <code>Point getNewLocation() </code>.
	 *
	 */
	public void testGetNewLocation() {
		Point ret = event.getNewLocation();
		assertEquals("Equal is expected.", 100.0, ret.getX());
		assertEquals("Equal is expected.", 101.0, ret.getY());
	}

	/**
	 * Test method <code>Point getOffset() </code>.
	 *
	 */
	public void testGetOffset_1() {
		Point ret = event.getOffset();
		assertEquals("Equal is expected.", 99.0, ret.getX());
		assertEquals("Equal is expected.", 99.0, ret.getY());
	}


	/**
	 * Test method <code>Point getOffset() </code>.
	 *
	 */
	public void testGetOffset_2() {
		event = new LocationEvent(node, newPoint, newPoint);
		Point ret = event.getOffset();
		assertEquals("Equal is expected.", 0.0, ret.getX());
		assertEquals("Equal is expected.", 0.0, ret.getY());
	}
}
