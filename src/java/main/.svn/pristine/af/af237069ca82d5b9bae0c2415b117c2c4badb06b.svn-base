/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.gui.diagramviewer.uml.classelements.ClassNode;
import com.topcoder.uml.actions.model.classifiers.RemoveClassAction;
import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This action is used for remove ClassNode from the diagram view.
 * </p>
 * @author ly, FireIce, ylouis, TCSDEVELOPER
 * @version 1.0
 */
public class RemoveClassNodeAction extends RemoveNodeAction {

    /**
     * <p>
     * Presentation name of this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Remove ClassNode";

    /**
     * <p>
     * Creates an instance of RemoveClassNodeAction.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param node
     *            node to remove
     */
    public RemoveClassNodeAction(MainFrame mainFrame, ClassNode node) {
        this(mainFrame, node, true);
    }

    /**
     * <p>
     * Creates an instance of RemoveClassNodeAction.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param node
     *            node to remove
     * @param isComplete
     *            whether it is delete complete or only delete representation
     */
    public RemoveClassNodeAction(MainFrame mainFrame, ClassNode node, boolean isComplete) {
        super(PRESENTATION_NAME, mainFrame, node, isComplete ? createRemoveClassAction(node) : null);
    }

    /**
     * <p>
     * Creates an instance of RemoveClassAction.
     * </p>
     * @param node
     *            node to remove
     * @return an an instance of RemoveClassAction
     */
    private static RemoveClassAction createRemoveClassAction(ClassNode node) {
        Class element = (Class) DeployHelper.getElement(node.getGraphNode());
        return new RemoveClassAction(element);
    }
}
