/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.FeatureAddAction;

/**
 * <p>
 * This class is the base class to add accessor operations for attribute.
 * </p>
 * @author sempiq
 * @version 1.0
 */
public class GetterSetterOperationAddAction extends AbstractAction {

    /**
     * <p>
     * Represents the action used to add getter.
     * </p>
     */
    private FeatureAddAction getterAddAction;
    
    /**
     * <p>
     * Represents the action used to add setter.
     * </p>
     */
    private FeatureAddAction setterAddAction;

    /**
     * <p>
     * Creates an instance of <code>GetterSetterOperationAddAction</code>.
     * </p>
     * @param getterAddAction
     *            action used to add getter
     *            
     * @param setterAddAction   
     * 			  action used to add setter
     *          
     * @throws IllegalArgumentException
     *             if argument is null
     */
    public GetterSetterOperationAddAction(FeatureAddAction getterAddAction, FeatureAddAction setterAddAction) {
        DeployHelper.checkNotNull(getterAddAction, "getterAddAction");
        DeployHelper.checkNotNull(setterAddAction, "setterAddAction");
        this.getterAddAction	 = getterAddAction;
        this.setterAddAction	 = setterAddAction;
    }

    /**
     * <p>
     * Adds accessors for attribute to node.
     * </p>
     * @param e
     *            action event
     */
    public void actionPerformed(ActionEvent e) {
    	getterAddAction.actionPerformed(e);
    	setterAddAction.actionPerformed(e);
    }

}
