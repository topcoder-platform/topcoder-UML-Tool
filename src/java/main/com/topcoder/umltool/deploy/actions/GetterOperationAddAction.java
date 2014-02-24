/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions;

import java.awt.event.ActionEvent;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.classelements.ClassNode;
import com.topcoder.uml.actions.model.classifiers.feature.AddOperationAction;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.FeatureAddAction;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.actions.undoable.UpdateNodeContainerAction;

/**
 * <p>
 * This class is the base class to getter to attribute
 * </p>
 * @author sempiq
 * @version 1.0
 */
public class GetterOperationAddAction extends FeatureAddAction {

    /**
     * <p>
     * Main frame window.
     * </p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Target attribute.
     * </p>
     */
    private final Attribute attribute;

    /**
     * <p>
     * Creates an instance of <code>GetterOperationAddAction</code>.
     * </p>
     * @param mainframe
     *            main frame window
     * @param attribute
     *            target attribute
     *
     * @throws IllegalArgumentException
     *             if argument is null
     */
    public GetterOperationAddAction(MainFrame mainframe, Attribute attribute) {
        DeployHelper.checkNotNull(mainframe, "mainframe");
        DeployHelper.checkNotNull(attribute, "attribute");
        this.mainFrame = mainframe;
        this.attribute = attribute;
    }

    /**
     * <p>
     * Adds an getter for attribute to node.
     * </p>
     * @param e
     *            action event
     */
    public void actionPerformed(ActionEvent e) {
        ClassNode classNode = getClassNode();
        GraphNode graphNode = classNode.getGraphNode();
        UpdateNodeContainerAction compositeAction = new UpdateNodeContainerAction(classNode, "Operation added");

        Operation operation = DeployHelper.createOperation("get" + DeployHelper.firstToUpperCase(attribute.getName()), "void");
        operation.getParameters().get(0).setType(attribute.getType());
        Classifier classifier = (Classifier) DeployHelper.getElement(graphNode);

        // FIXME remove this code after AddOperationAction is fixed
        operation.setOwner(classifier);

        AddOperationAction addOperationAction = new AddOperationAction((Classifier) DeployHelper.getElement(graphNode),
                operation);
        compositeAction.put(addOperationAction, classNode);

        mainFrame.handleActionEvent(compositeAction, classNode, "Operation added");
    }

}
