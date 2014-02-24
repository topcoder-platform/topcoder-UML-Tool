/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy;

import java.awt.Color;

/**
 * <p>
 * This button is used to add operations to a ClassNode.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class OperationAddButton extends FeatureAddButton {
    /**
     * <p>
     * Creates an instance of OperationAddButton.
     * </p>
     * @param mainFrame
     *            main frame window
     */
    public OperationAddButton(MainFrame mainFrame) {
        super(new OperationAddAction(mainFrame));
        setFillColor(Color.BLUE);
    }
}
