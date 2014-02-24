/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.panels.style.StylePanel;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This implementation of MouseAdapter will check which graph element is
 * selected, and update style panel, document tree panel, property panel and
 * documentation panel in the main frame.
 * </p>
 * <p>
 * Thread safety: This class are not required to be thread-safe. They could be
 * used in a thread safe manner in this component.
 * </p>
 *
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class ElementSelectionHandler extends MouseAdapter {
	/**
	 * <p>
	 * The MainFrame associated with this handler.
	 * </p>
	 */
	private final MainFrame mainFrame;

	/**
	 * <p>
	 * Creates an instance of ElementSelectionHandler with the mainframe.
	 * </p>
	 *
	 * @param mainFrame
	 *            the mainframe
	 */
	public ElementSelectionHandler(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	/**
	 * <p>
	 * Updates the style panel when mouse is released.
	 * </p>
	 *
	 * @param e
	 *            the mouse event
	 */
	public void mouseReleased(MouseEvent e) {
		Object object = e.getSource();
		if (object instanceof Node) {
			DeployHelper.notifySelectionChanged(mainFrame,
					(DiagramView) ((Node) object).getParent());
			((Node) object).requestFocus(true);
		} else if (object instanceof Edge) {
			DeployHelper.notifySelectionChanged(mainFrame,
					(DiagramView) ((Edge) object).getParent());
			((Edge) object).requestFocus(true);
		}
		StylePanel stylePanel = mainFrame.getStylePanel();
		stylePanel.setStyleObjectList(stylePanel.getStyleObjectList());
	}
}
