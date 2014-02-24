/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy;

import java.awt.event.ActionEvent;

import com.topcoder.diagraminterchange.GraphNode;
import com.topcoder.gui.diagramviewer.uml.classelements.ClassNode;
import com.topcoder.uml.actions.model.classifiers.feature.AddAttributeAction;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.umltool.deploy.actions.undoable.UpdateNodeContainerAction;

/**
 * <p>
 * This class is the base class to add attribute.
 * </p>
 *
 * @author ly
 * @version 1.0
 */
public class AttributeAddAction extends FeatureAddAction {

    /**
     * <p>
     * Represents the default index for new created attribute.
     * </p>
     */
    private static int DEFAULT_INDEX = 1;

    /**
     * <p>
     * Main frame window.
     * </p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Creates an instance of <code>AttributeAddAction</code>.
     * </p>
     *
     * @param mainframe
     *            main frame window
     * @throws IllegalArgumentException
     *             if argument is null
     */
    public AttributeAddAction(MainFrame mainframe) {
        DeployHelper.checkNotNull(mainframe, "mainframe");
        this.mainFrame = mainframe;
    }

    /**
     * <p>
     * Adds an attribute to node.
     * </p>
     *
     * @param e
     *            action event
     */
    public void actionPerformed(ActionEvent e) {
        ClassNode classNode = getClassNode();
        GraphNode graphNode = classNode.getGraphNode();
        UpdateNodeContainerAction compositeAction = new UpdateNodeContainerAction(classNode, "Attribute added");

        Attribute attribute = DeployHelper.createAttribute("attribute" + DEFAULT_INDEX++, "int");

        Classifier classifier = (Classifier) DeployHelper.getElement(graphNode);

        // FIXME remove this code after AddAttributeAction is fixed
        attribute.setOwner(classifier);

        AddAttributeAction addAttributeAction = new AddAttributeAction(classifier, attribute);
        compositeAction.put(addAttributeAction, classNode);

        mainFrame.handleActionEvent(compositeAction, classNode, "Attribute added");

        // BUGR-145 select attribute after creation
        updateSelection(mainFrame, attribute);
    }

}
