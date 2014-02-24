/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy;

import javax.swing.AbstractAction;
import javax.swing.JComponent;

import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.gui.diagramviewer.uml.classelements.ClassNode;
import com.topcoder.uml.model.core.Feature;

/**
 * <p>
 * This class is the base class to add attribute or operation.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public abstract class FeatureAddAction extends AbstractAction {

    /**
     * <p>
     * Represents the ClassNode which needs feature added.
     * </p>
     */
    private ClassNode classNode;

    /**
     * <p>
     * Gets the classNode field.
     * </p>
     * @return the class node
     */
    public ClassNode getClassNode() {
        return classNode;
    }

    /**
     * <p>
     * Sets the classNode field.
     * </p>
     * @param classNode
     *            the ClassNode which needs feature added
     */
    public void setClassNode(ClassNode classNode) {
        this.classNode = classNode;
    }
    
    /**
     * Updates selection after feature is created
     * 
     * @param mainFrame main frame
     * @param feature created feature
     */
    protected void updateSelection(MainFrame mainFrame, Feature feature) {
    	JComponent component = DeployHelper.getComponent(DeployHelper.getGraphElement(feature, classNode.getGraphNode()), mainFrame);
    	
        DiagramViewer diagramViewer = mainFrame.getDiagramViewer();
        DeployHelper.clearSelected(diagramViewer);
        diagramViewer.addSelectedElement(component);
        DeployHelper.notifySelectionChanged(mainFrame, diagramViewer);
	}

}
