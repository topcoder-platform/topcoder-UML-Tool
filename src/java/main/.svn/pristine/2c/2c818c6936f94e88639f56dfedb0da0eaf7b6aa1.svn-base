/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.GraphEdge;
import com.topcoder.diagraminterchange.Polyline;
import com.topcoder.diagraminterchange.Property;
import com.topcoder.gui.diagramviewer.DiagramView;
import com.topcoder.gui.diagramviewer.uml.auxiliaryelements.PolylineNode;
import com.topcoder.uml.actions.diagram.elements.CopiedElement;
import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This class defines paste polyline action used for paste polyline to diagram
 * view.
 * </p>
 * <p>
 * Component to be pasted is created in the constructor according to given graph
 * element.
 * </p>
 * 
 * @author ly, FireIce, ylouis, TCSDEVELOPER
 * @version 1.0
 */
public class PastePolylineNodeAction extends UndoableAbstractAction {
	/**
	 * <p>
	 * Reference to main frame.
	 * <p>
	 */
	private final MainFrame mainFrame;

	/**
	 * <p>
	 * The diagram view to pasted to.
	 * </p>
	 */
	private DiagramView diagramView;

	/**
	 * <p>
	 * The component to paste.
	 * </p>
	 */
	private PolylineNode polylineNode;

	/**
	 * <p>
	 * Presentation name for parent class.
	 * </p>
	 */
	private final static String PRESENTAION_NAME = "PASTE";

	/**
	 * <p>
	 * Creates an instance of <code>PastePolylineAction</code>.
	 * </p>
	 * 
	 * @param mainFrame
	 *            reference to main frame
	 * @param transferable
	 *            the transferable contains the graph edge which contains
	 *            polyline
	 * @param diagram
	 *            the diagram to be pasted to
	 */
	public PastePolylineNodeAction(MainFrame mainFrame,
			Transferable transferable, Diagram diagram) {
		super(PRESENTAION_NAME);
		DeployHelper.checkNotNull(mainFrame, "mainFrame");
		DeployHelper.checkNotNull(transferable, "transferable");
		DeployHelper.checkNotNull(diagram, "diagram");

		this.mainFrame = mainFrame;
		this.diagramView = mainFrame.getDiagramViewer()
				.openDiagramView(diagram);

		CopiedElement copiedElement = (CopiedElement) transferable;
		DataFlavor dataFlavor = copiedElement.getTransferDataFlavors()[0];
		GraphEdge graphEdge = (GraphEdge) copiedElement
				.getTransferData(dataFlavor);
		Polyline polyline = (Polyline) graphEdge.getContaineds().get(0);
		polylineNode = DeployHelper.createPolylineNode(mainFrame, polyline);
		polylineNode.getGraphNode().setContainer(diagramView.getDiagram());
		for (Property property : polyline.getProperties()) {
			Property newProperty = new Property();
			newProperty.setKey(property.getKey());
			newProperty.setValue(property.getValue());
			polylineNode.getGraphNode().addProperty(newProperty);
		}
		polyline.clearProperties();
		polylineNode.notifyPropertiesChange();
		polylineNode.notifyUpdate();
	}

	/**
	 * <p>
	 * The method actually undo the edit that was made. If any exception
	 * prevents redo/undo methods from completing successfully, it should be log
	 * with logError.
	 * </p>
	 */
	public void undoAction() {
		diagramView.remove(polylineNode);
		diagramView.getDiagram().removeContained(polylineNode.getPolyline());
	}

	/**
	 * <p>
	 * The method actually redo the edit. If any exception prevents redo/undo
	 * methods from completing successfully, it should be log with logError.
	 * </p>
	 */
	public void redoAction() {
		diagramView.add(polylineNode);
		DeployHelper.addContained(diagramView.getDiagram(), polylineNode
				.getPolyline());
	}

	/**
	 * <p>
	 * The method actually execute this auction.
	 * </p>
	 * 
	 * @throws ActionExecutionException
	 *             if any exception prevents this method from completing
	 *             successfully
	 */
	public void executeAction() throws ActionExecutionException {
		diagramView.add(polylineNode);
		DeployHelper.addContained(diagramView.getDiagram(), polylineNode
				.getPolyline());
	}
}
