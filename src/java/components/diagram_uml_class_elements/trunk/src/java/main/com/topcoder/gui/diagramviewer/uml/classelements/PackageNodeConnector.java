/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.gui.diagramviewer.uml.classelements;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Rectangle;

import com.topcoder.gui.diagramviewer.edges.Connector;
import com.topcoder.gui.diagramviewer.edges.connectors.RectangleConnector;

/**
 * <p>
 * This class is the connector used to connect to PackageNode. It is relatively
 * simple, as the shape of Package is two rectangles: one for
 * name/namespace/stereotypes compartments and the second is for package body.
 * </p>
 * <p>
 * This class is immutable, and thread-safe.
 * </p>
 *
 * @author MiG-29, TCSDEVELOPER
 * @version 1.0
 */
public class PackageNodeConnector implements Connector {

	/**
	 * <p>
	 * Represents the node containing this connector. Initialized in
	 * constructor, never changed later. Can't be null.
	 * </p>
	 */
	private final PackageNode parent;

	/**
	 * <p>
	 * Creates an instance of <code>PackageNodeConnector</code>.
	 * </p>
	 *
	 * @param parent
	 *            the node containing this connector
	 */
	public PackageNodeConnector(PackageNode parent) {
		Util.checkNotNull(parent, "parent");
		this.parent = parent;
	}

	/**
	 * <p>
	 * Implements the getConnectionPoint method in Connector interface.
	 * </p>
	 *
	 * @param wayPoint
	 *            the way point to be connected
	 * @return the target connection point
	 * @throws IllegalArgumentException
	 *             if given wayPoint is null
	 */
	public Point getConnectionPoint(Point wayPoint) {
		Util.checkNotNull(wayPoint, "wayPoint");

		// Get the top rectangle
		Point position = parent.getLocation();
		position.x += parent.getSelectionBound().x;
		position.y += parent.getSelectionBound().y;
		Dimension size = new Dimension();
		Dimension compartmentSize = null;
		if (parent.getStereotypeCompartment().isVisible()) {
			compartmentSize = parent.getStereotypeCompartment()
					.getPreferredSize();
			Util.combineSize(size, compartmentSize, true);
		}
		compartmentSize = parent.getNameCompartment().getSize();
		if (parent.getNamespaceCompartment().isVisible()) {
			Util.combineSize(size, compartmentSize, true);
			compartmentSize = parent.getNamespaceCompartment().getSize();
			Util.combineSize(size, compartmentSize, false);
		} else {
			Util.combineSize(size, compartmentSize, false);
		}

		if (wayPoint.x < position.x + size.width
				&& wayPoint.y < position.y + size.height) {
			// Connect to the top rectangle
			Rectangle bound = new Rectangle(position, size);
			return new RectangleConnector(bound).getConnectionPoint(wayPoint);
		}

		// Connect to the bottom rectangle
		position.y += size.height;
		size.width = parent.getSelectionBound().width;
		size.height = parent.getSelectionBound().height - size.height;
		Rectangle bound = new Rectangle(position, size);
		return new RectangleConnector(bound).getConnectionPoint(wayPoint);
	}
}
