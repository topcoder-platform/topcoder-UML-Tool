/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */

package com.topcoder.gui.diagramviewer.uml.sequenceelements;

import java.awt.Component;
import java.awt.Point;

import com.topcoder.gui.diagramviewer.edges.Connector;
import com.topcoder.gui.diagramviewer.edges.Util;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.lifeline.LifelineSegment;

// added
/**
 * <p>
 * This class implements the Connector interface and is the default connector
 * for ObjectNode.
 * </p>
 *
 * <p>
 * Thread Safety : This class is mutable, and not thread safe.
 * </p>
 *
 * @author ly, TCSDEVELOPER
 * @version 1.0
 */
public class ObjectNodeConnector implements Connector {
	/**
	 * <p>
	 * Represents the ObjectNode which owns this connector.
	 * </p>
	 *
	 * <p>
	 * It will be used to compute the connection point.
	 * </p>
	 *
	 * <p>
	 * It is initialized in the constructor, and can be accessed by
	 * setter/getter. It will never null.
	 * </p>
	 *
	 */
	private ObjectNode objectNode;

	/**
	 * <p>
	 * Construct a ObjectNodeConnector with its objectNode given.
	 * </p>
	 *
	 * @param objectNode
	 *            the objectNode which owns this connector
	 *
	 * @throws IllegalArgumentException
	 *             if given argument is null
	 */
	public ObjectNodeConnector(ObjectNode objectNode) {
		Util.checkNull(objectNode, "objectNode");

		this.objectNode = objectNode;
	}

	/**
	 * <p>
	 * Get the ObjectNode defined for this connector.
	 * </p>
	 *
	 *
	 * @return the ObjectNode defined for this connector.
	 */
	public ObjectNode getObjectNode() {
		return objectNode;
	}

	/**
	 * <p>
	 * Set the ObjectNode defined for this connector.
	 * </p>
	 *
	 * @param ObjectNode
	 *            the new ObjectNode defined for the connector
	 *
	 * @throws IllegalArgumentException
	 *             if ObjectNode is null
	 */
	public void setObjectNode(ObjectNode objectNode) {
		Util.checkNull(objectNode, "ObjectNode");
		this.objectNode = objectNode;
	}

	/**
	 * <p>
	 * Get the connection point for the nearest way point of edge.
	 * </p>
	 *
	 * <p>
	 * Iterate through the four edge of rectangle, and find the nearest
	 * connection point.
	 * </p>
	 *
	 * @return the connector way point
	 *
	 * @param wayPoint
	 *            the way point to be connected to the rectangle
	 *
	 * @throws IllegalArgumentException
	 *             if wayPoint is null
	 */
	public Point getConnectionPoint(Point wayPoint) {
		Util.checkNull(wayPoint, "wayPoint");

		Point point = new Point();
		point.x = objectNode.getLocation().x + objectNode.getSelectionBound().x
				+ objectNode.getSelectionBound().width / 2;
		point.y = wayPoint.y;

		int offset = 0;
		Component[] components = objectNode.getComponents();
		for (Component component : components) {
			if (component instanceof LifelineSegment) {
				LifelineSegment segment = (LifelineSegment) component;
				if (wayPoint.y >= segment.getY() + objectNode.getY()
						&& wayPoint.y <= segment.getY() + objectNode.getY()
								+ segment.getHeight()) {
					if (wayPoint.x < point.x) {
						offset -= (int) (segment.getSelectionBound()
								.getWidth() / 2);
					} else {
						offset += (int) (segment.getSelectionBound()
								.getWidth() / 2);
					}
					break;
				}
			}
		}
		point.x += offset;

		return point;
	}
}
