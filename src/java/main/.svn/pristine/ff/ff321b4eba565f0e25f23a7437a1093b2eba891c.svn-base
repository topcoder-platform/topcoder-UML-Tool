/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import javax.swing.JComponent;
import javax.swing.JViewport;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.Dimension;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.diagraminterchange.Point;
import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.edges.Edge;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.BaseNode;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.PolylineNode;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNode;
import com.topcoder.gui.panels.style.StyleEvent;
import com.topcoder.gui.panels.style.StyleListener;
import com.topcoder.gui.panels.style.StyleObject;
import com.topcoder.gui.panels.style.StylePanel;
import com.topcoder.gui.panels.style.styleobject.GraphEdgeStyleObjectAdapter;
import com.topcoder.gui.panels.style.styleobject.GraphNodeStyleObjectAdapter;
import com.topcoder.gui.panels.style.styleobject.PolylineStyleObjectAdapter;
import com.topcoder.gui.panels.zoom.ZoomPane;
import com.topcoder.gui.panels.zoom.ZoomPanel;
import com.topcoder.uml.actions.general.ChangePositionAction;
import com.topcoder.uml.actions.general.ChangeSizeAction;
import com.topcoder.uml.actions.general.ChangeStyleAction;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.actions.undoable.UpdateNodeContainerAction;
import com.topcoder.umltool.deploy.handlers.HandlerHelper;

/**
 * <p>
 * This implementation of StyleListener will update the graph element according
 * the changed style, and update diagram viewer in the main frame.
 * </p>
 * <p>
 * Thread safety: The implementation of this interface is not required to be
 * thread safe.
 * </p>
 * 
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class StyleHandler implements StyleListener {

	/**
	 * <p>
	 * The mainframe associated with this handler.
	 * </p>
	 */
	private MainFrame mainFrame = null;

	/**
	 * <p>
	 * Create an instance of style handler with the mainframe.
	 * </p>
	 * 
	 * @param mainFrame
	 *            the mainframe
	 */

	public StyleHandler(MainFrame mainFrame) {
		DeployHelper.checkNotNull(mainFrame, "mainFrame");
		this.mainFrame = mainFrame;
	}

	/**
	 * <p>
	 * Change graph element and update diagram viewer according to the style
	 * change.
	 * </p>
	 * 
	 * @param styleEvent
	 *            the style event
	 */
	public void styleChanged(StyleEvent styleEvent) {
		DeployHelper.checkNotNull(styleEvent, "styleEvent");
		StyleObject styleObject = styleEvent.getStyleObject();
		StylePanel stylePanel = styleObject.getStylePanel();
		String changedKey = styleEvent.getChangedKey();
		if ((styleObject instanceof GraphNodeStyleObjectAdapter)
				&& (((GraphNodeStyleObjectAdapter) styleObject).getGraphNode() instanceof Diagram)) {
			/*
			 * BUGR-84 In order to resize the back canvas of the DiagramView, We
			 * will get the DiagramViewer and it's configured gap and the
			 * desired dimensions. Then update the Diagram, DiagramViewer and
			 * DiagramViewer accordingly.
			 */
			DiagramViewer viewer = mainFrame.getDiagramViewer();
			int gap = viewer.getDiagramViewGap();

			Dimension size = new Dimension();
			size.setWidth(changedKey == stylePanel.getWidthKey() ? Double
					.parseDouble(styleEvent.getNewValue()) : styleObject
					.getWidth());
			size.setHeight(changedKey == stylePanel.getHeightKey() ? Double
					.parseDouble(styleEvent.getNewValue()) : styleObject
					.getHeight());

			java.awt.Dimension dim = new java.awt.Dimension();
			dim.setSize(size.getWidth(), size.getHeight());
			// update the Diagram
			Diagram d = (Diagram) ((GraphNodeStyleObjectAdapter) styleObject).getGraphNode();
            d.setSize(size);

			//get the ZoomPanel and DiagramView and update them
            ZoomPanel zoomPanel = (ZoomPanel) mainFrame.getDiagramViewer().getTabbedPane().getSelectedComponent();
            JViewport viewport = (JViewport) zoomPanel.getComponent(0);
            ZoomPane zoomPane = (ZoomPane) viewport.getComponent(0);
            DiagramView view = (DiagramView) zoomPane.getComponent(0);
            view.setSize(dim);
            
            stylePanel.setSizeStyle(dim);
            
            //the ZoomPanel and the DiagramViewer have larger dimensions than the Diagram and DiagramView
            dim.width+=(2*gap);
            dim.height+=(2*gap);
            
            zoomPane.setSize(dim);
            zoomPane.setPreferredSize(dim);
            
            viewer.setSize(dim);
            mainFrame.getDiagramViewer().revalidate();
            
            stylePanel.setStyleObject(styleObject);
			return;
		}
		if (changedKey == stylePanel.getXKey()
				|| changedKey == stylePanel.getYKey()) {
			// Change position
			changePosition(styleEvent);
		} else if (changedKey == stylePanel.getWidthKey()
				|| changedKey == stylePanel.getHeightKey()) {
			// Change size
			changeSize(styleEvent);
		} else {
			// Change Style
			if (changedKey == stylePanel.getFillColorKey()
					|| changedKey == stylePanel.getOutlineColorKey()
					|| changedKey == stylePanel.getTextColorKey()) {
				changeStyle(styleEvent, styleEvent.getNewValue().substring(1));
			} else {
				changeStyle(styleEvent, styleEvent.getNewValue());
			}
		}
		mainFrame.updateDiagramView();
	}

	/**
	 * <p>
	 * Change position.
	 * </p>
	 * 
	 * @param styleEvent
	 *            the style event
	 */
	private void changePosition(StyleEvent styleEvent) {
		StyleObject styleObject = styleEvent.getStyleObject();
		StylePanel stylePanel = styleObject.getStylePanel();
		String changedKey = styleEvent.getChangedKey();
		Point position = new Point();
		position.setX(changedKey == stylePanel.getXKey() ? Double
				.parseDouble(styleEvent.getNewValue()) : styleObject.getX());
		position.setY(changedKey == stylePanel.getYKey() ? Double
				.parseDouble(styleEvent.getNewValue()) : styleObject.getY());

		if (styleObject instanceof GraphNodeStyleObjectAdapter) {
			GraphNode graphNode = ((GraphNodeStyleObjectAdapter) styleObject)
					.getGraphNode();
			Node node = HandlerHelper.getSelectNode(graphNode, mainFrame);
			// OjbectNode can only move horizontally
			if (node instanceof ObjectNode
					&& changedKey == stylePanel.getYKey()) {
				stylePanel.setStyleObject(styleObject);
				return;
			}

			ChangePositionAction changePositionAction = new ChangePositionAction(
					graphNode, position);
			UpdateNodeContainerAction compositeAction = new UpdateNodeContainerAction(
					node, "change position");
			compositeAction.put(changePositionAction, node);
			mainFrame.handleActionEvent(compositeAction, node,
					"change position");
		}
	}

	/**
	 * <p>
	 * Change size.
	 * </p>
	 * 
	 * @param styleEvent
	 *            the style event
	 */
	private void changeSize(StyleEvent styleEvent) {
		StyleObject styleObject = styleEvent.getStyleObject();
		StylePanel stylePanel = styleObject.getStylePanel();
		String changedKey = styleEvent.getChangedKey();
		Dimension size = new Dimension();
		size
				.setWidth(changedKey == stylePanel.getWidthKey() ? Double
						.parseDouble(styleEvent.getNewValue()) : styleObject
						.getWidth());
		size.setHeight(changedKey == stylePanel.getHeightKey() ? Double
				.parseDouble(styleEvent.getNewValue()) : styleObject
				.getHeight());
		if (styleObject instanceof GraphNodeStyleObjectAdapter) {
			GraphNode graphNode = ((GraphNodeStyleObjectAdapter) styleObject)
					.getGraphNode();
			Node node = HandlerHelper.getSelectNode(graphNode, mainFrame);
			// OjbectNode can only change width
			if (node instanceof ObjectNode
					&& changedKey == stylePanel.getHeightKey()) {
				stylePanel.setStyleObject(styleObject);
				return;
			}

			ChangeSizeAction changeSizeAction = new ChangeSizeAction(graphNode,
					size);
			UpdateNodeContainerAction compositeAction = new UpdateNodeContainerAction(
					node, "change size");
			compositeAction.put(changeSizeAction, node);
			mainFrame.handleActionEvent(changeSizeAction, node, "change size");
		}
	}

	/**
	 * <p>
	 * Change color or font.
	 * </p>
	 * 
	 * @param styleEvent
	 *            the style event
	 * @param newValue
	 *            the new value of color or font
	 */
	private void changeStyle(StyleEvent styleEvent, String newValue) {
		StyleObject styleObject = styleEvent.getStyleObject();
		if (styleObject instanceof GraphNodeStyleObjectAdapter) {
			GraphNode graphNode = ((GraphNodeStyleObjectAdapter) styleObject)
					.getGraphNode();
			JComponent jComponent = DeployHelper.getComponent(graphNode,
					mainFrame);
			if (jComponent instanceof BaseNode
					|| jComponent instanceof ObjectNode) {
				String changedKey = styleEvent.getChangedKey();
				StylePanel stylePanel = styleObject.getStylePanel();
				if (changedKey == stylePanel.getFillColorKey()
						|| changedKey == stylePanel.getOutlineColorKey()
						|| changedKey == stylePanel.getTextColorKey()) {
					newValue = "#" + newValue;
				}
			}
			ChangeStyleAction changeStyleAction = new ChangeStyleAction(
					graphNode, styleEvent.getChangedKey(), newValue);
			mainFrame.handleActionEvent(changeStyleAction, jComponent,
					"change style");
		} else if (styleObject instanceof GraphEdgeStyleObjectAdapter) {
			String changedKey = styleEvent.getChangedKey();
			StylePanel stylePanel = styleObject.getStylePanel();
			if (changedKey == stylePanel.getOutlineColorKey()
					|| changedKey == stylePanel.getTextColorKey()) {
				newValue = "#" + newValue;
			}
			GraphEdge graphEdge = ((GraphEdgeStyleObjectAdapter) styleObject)
					.getGraphEdge();
			ChangeStyleAction changeStyleAction = new ChangeStyleAction(
					graphEdge, styleEvent.getChangedKey(), newValue);
			Edge edge = HandlerHelper.getSelectEdge(graphEdge, mainFrame);
			mainFrame
					.handleActionEvent(changeStyleAction, edge, "change style");
		} else if (styleObject instanceof PolylineStyleObjectAdapter) {
			String changedKey = styleEvent.getChangedKey();
			StylePanel stylePanel = styleObject.getStylePanel();
			if (changedKey == stylePanel.getOutlineColorKey()
					|| changedKey == stylePanel.getFillColorKey()) {
				newValue = "#" + newValue;
			}
			Polyline polyline = ((PolylineStyleObjectAdapter) styleObject)
					.getPolyline();
			PolylineNode polylineNode = DeployHelper.getPolylineNode(polyline,
					mainFrame);
			ChangeStyleAction changeStyleAction = new ChangeStyleAction(
					polyline, styleEvent.getChangedKey(), newValue);
			mainFrame.handleActionEvent(changeStyleAction, polylineNode,
					"change style");
		}
	}
}
