/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.gui.diagramviewer.uml.classelements.ClassNode;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.actions.undoable.ChangeElementVisibilityAction;
import com.topcoder.umltool.deploy.actions.undoable.UpdateNodeContainerAction;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This action is to be used to show elements of specified external Node
 * </p>
 *
 * @author sempiq
 * @version 1.0
 */
public class ShowExternalElementsAction extends AbstractAction {
	/**
	 * Serial version UID
	 */
	private static final long serialVersionUID = 5257842053096498858L;

	/**
	 * <p>
	 * Main frame window.
	 * </p>
	 */
	private final MainFrame mainFrame;

	/**
	 * <p>
	 * Node whose element to be shown or not.
	 * </p>
	 */
	private final ClassNode node;

	/**
	 * <p>
	 * Represents the attribute compartment's graph node index in the graph node
	 * structure.
	 * </p>
	 */
	private static final int ATTRIBUTE_INDEX = 2;

	/**
	 * <p>
	 * Represents the operation compartment's graph node index in the graph node
	 * structure.
	 * </p>
	 */
	private static final int OPERATION_INDEX = 4;

	/**
	 * <p>
	 * Creates an instance of <code>ShowElementsAction</code> with specified
	 * node and graph element.
	 * </p>
	 *
	 * @param name
	 *            action name
	 * @param mainFrame
	 *            main frame window
	 * @param node
	 *            the node whose element will be shown or not
	 * @param graphElement
	 *            the graph element to be shown or not
	 */
	public ShowExternalElementsAction(String name, MainFrame mainFrame,
			ClassNode node) {
		super(name);
		this.mainFrame = mainFrame;
		this.node = node;
	}

	/**
	 * <p>
	 * Shows or hides the specified graph element according to its external property.
	 * If is external operations and attributes are not visible
	 * </p>
	 *
	 * @param e
	 *            the action event (ignore null)
	 */
	public void actionPerformed(ActionEvent e) {
		if (node != null) {
			node.setExternal(!node.isExternal());
			ChangeElementVisibilityAction changeVisibilityAction = new ChangeElementVisibilityAction(
					(GraphElement) node.getGraphNode().getContaineds().get(
							OPERATION_INDEX), !node.isExternal());
			mainFrame.handleActionEvent(changeVisibilityAction, node,
					"Change graph element's visibility");

			changeVisibilityAction = new ChangeElementVisibilityAction(
					(GraphElement) node.getGraphNode().getContaineds().get(
							ATTRIBUTE_INDEX), !node.isExternal());
			mainFrame.handleActionEvent(changeVisibilityAction, node,
					"Change graph element's visibility");

			UpdateNodeContainerAction updateNodeContainerAction = new UpdateNodeContainerAction(node, "external properties of node is changed");
	        updateNodeContainerAction.setEventManager(mainFrame.getEventManager());
	        try {
				updateNodeContainerAction.execute();
			} catch (ActionExecutionException e1) {
				// ignore
			}

		}
	}
}
