/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.gui.diagramviewer.uml.classelements.PackageNode;
import com.topcoder.uml.actions.model.classifiers.RemovePackageAction;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This action is used for remove PackageNode from the diagram view.
 * </p>
 * @author ly, FireIce, ylouis, TCSDEVELOPER
 * @version 1.0
 */
public class RemovePackageNodeAction extends RemoveNodeContainerAction {

    /**
     * <p>
     * Presentation name of this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Remove PackageNode";

    /**
     * <p>
     * Creates an instance of RemovePackageNodeAction.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param node
     *            node to remove
     */
    public RemovePackageNodeAction(MainFrame mainFrame, PackageNode node) {
        this(mainFrame, node, true);
    }

    /**
     * <p>
     * Creates an instance of RemovePackageNodeAction.
     * </p>
     * @param mainFrame
     *            reference to main frame
     * @param node
     *            node to remove
     * @param isComplete
     *            whether it is delete complete or only delete representation
     */
    public RemovePackageNodeAction(MainFrame mainFrame, PackageNode node, boolean isComplete) {
        super(PRESENTATION_NAME, mainFrame, node, isComplete ? createRemovePackageAction(node) : null, isComplete);
    }

    /**
     * <p>
     * Creates an instance of RemovePackageAction.
     * </p>
     * @param node
     *            node to remove
     * @return an an instance of RemovePackageAction
     */
    private static RemovePackageAction createRemovePackageAction(PackageNode node) {
        Package element = (Package) DeployHelper.getElement(node.getGraphNode());
        return new RemovePackageAction(element);
    }
}
