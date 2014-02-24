/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.gui.diagramviewer.uml.classelements.InterfaceNode;
import com.topcoder.uml.actions.model.classifiers.RemoveInterfaceAction;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This action is used for remove InterfaceNode from the diagram view.
 * </p>
 * @author ly, FireIce, ylouis, TCSDEVELOPER
 * @version 1.0
 */
public class RemoveInterfaceNodeAction extends RemoveNodeAction {

    /**
     * <p>
     * Presentation name of this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Remove InterfaceNode";

    /**
     * <p>
     * Creates an instance of RemoveInterfaceNodeAction.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param node
     *            node to remove
     */
    public RemoveInterfaceNodeAction(MainFrame mainFrame, InterfaceNode node) {
        this(mainFrame, node, true);
    }

    /**
     * <p>
     * Creates an instance of RemoveInterfaceNodeAction.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param node
     *            node to remove
     * @param isComplete
     *            whether it is delete complete or only delete representation
     */
    public RemoveInterfaceNodeAction(MainFrame mainFrame, InterfaceNode node, boolean isComplete) {
        super(PRESENTATION_NAME, mainFrame, node, isComplete ? createRemoveInterfaceAction(node) : null);
    }

    /**
     * <p>
     * Creates an instance of RemoveInterfaceAction.
     * </p>
     * @param node
     *            node to remove
     * @return an an instance of RemoveInterfaceAction
     */
    private static RemoveInterfaceAction createRemoveInterfaceAction(InterfaceNode node) {
        Interface element = (Interface) DeployHelper.getElement(node.getGraphNode());
        return new RemoveInterfaceAction(element);
    }
}
