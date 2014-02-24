/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.elements.Node;
import com.topcoder.gui.diagramviewer.uml.classelements.ClassNode;
import com.topcoder.gui.diagramviewer.uml.sequenceelements.ObjectNode;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.actions.undoable.ChangeElementVisibilityAction;
import com.topcoder.umltool.deploy.actions.undoable.UpdateNodeContainerAction;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This action is to be used to show elements of specified Node such as stereotypes, package, attributes and operations.
 * </p>
 * @author ly
 * @version 1.0
 */
public class ShowElementsAction extends AbstractAction {
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
    private final Node node;
    
    /**
     * <p>
     * action name.
     * </p>
     */
    private final String name;

    /**
     * <p>
     * The graph element to be shown or not.
     * </p>
     */
    private final GraphElement graphElement;

    /**
     * <p>
     * Represents the attribute compartment's graph node index in the graph node structure.
     * </p>
     */
    private static final int ATTRIBUTE_INDEX = 2;

    /**
     * <p>
     * Represents the operation compartment's graph node index in the graph node structure.
     * </p>
     */
    private static final int OPERATION_INDEX = 4;

    /**
     * <p>
     * Creates an instance of <code>ShowElementsAction</code> with specified node and graph element.
     * </p>
     * @param name
     *            action name
     * @param mainFrame
     *            main frame window
     * @param node
     *            the node whose element will be shown or not
     * @param graphElement
     *            the graph element to be shown or not
     */
    public ShowElementsAction(String name, MainFrame mainFrame, Node node, GraphElement graphElement) {
        super(name);
        this.mainFrame = mainFrame;
        this.node = node;
        this.graphElement = graphElement;
        this.name=name;
    }

    /**
     * <p>
     * Shows or hides the specified graph element according to its visibility. If originally visible, it will be hidden;
     * otherwise it will be shown.
     * </p>
     * @param e
     *            the action event (ignore null)
     */
    public void actionPerformed(ActionEvent e) {
        if (graphElement != null) {
            ChangeElementVisibilityAction changeVisibilityAction = new ChangeElementVisibilityAction(graphElement,
                    !graphElement.isVisible());

            //for classes attributes and operations invalidate external property
            if (node instanceof ClassNode) {
				ClassNode classNode = (ClassNode) node;
				GraphNode attrNode = (GraphNode) classNode.getGraphNode().getContaineds().get(ATTRIBUTE_INDEX);
				GraphNode operNode = (GraphNode) classNode.getGraphNode().getContaineds().get(OPERATION_INDEX);
				if(attrNode.equals(graphElement) || operNode.equals(graphElement)){
					classNode.setExternal(classNode.isExternal() && graphElement.isVisible());
				}

			}
            if(node instanceof ObjectNode){
            	ObjectNode objectNode=(ObjectNode)node;
            	if(name.indexOf("Name")>=0)
            	{
            		objectNode.changeShowName();
            	}
            	else
            	{
            		objectNode.changeShowType();
            	}
            	objectNode.repaint();
            }

            mainFrame.handleActionEvent(changeVisibilityAction, node, "Change graph element's visibility");

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
