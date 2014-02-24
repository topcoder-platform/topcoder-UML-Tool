/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.awt.event.MouseEvent;

import com.topcoder.gui.diagramviewer.elements.SelectionCorner;
import com.topcoder.gui.diagramviewer.uml.classelements.ClassNode;
import com.topcoder.gui.diagramviewer.uml.classelements.GroupTextField;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.OperationAddButton;

/**
 * <p>
 * This handler will show the OperationAddButton when mouse enters the Operation Compartment, hide when mouse leaves.
 * </p>
 * <p>
 * Thread safety: This class are not required to be thread-safe. They could be used in a thread safe manner in this
 * component.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class OperationCompartmentMouseHandler extends CompartmentMouseHandler {

    /**
     * <p>
     * Represents the button to add operations for this compartment.
     * </p>
     */
    private final OperationAddButton button;

    /**
     * <p>
     * Creates an instance of <code>OperationCompartmentMouseHandler</code>.
     * </p>
     * @param mainframe
     *            main frame window
     * @throws IllegalArgumentException
     *             if argument is null
     */
    public OperationCompartmentMouseHandler(MainFrame mainframe) {
        button = new OperationAddButton(mainframe);
        button.addMouseListener(new FeatureAddButtonMouseHandler());
    }

    /**
     * <p>
     * Shows the button.
     * </p>
     * @param e
     *            mouse event
     */
    public void mouseEntered(MouseEvent e) {
        if (e == null || !(e.getSource() instanceof GroupTextField)) {
            return;
        }
        GroupTextField operationCompartment = (GroupTextField) e.getSource();
        if (button.getParent() != operationCompartment) {
            button.setClassNode((ClassNode) operationCompartment.getParent());
            operationCompartment.add(button);
        }
        button.setLocation(operationCompartment.getWidth() - SelectionCorner.DEFAULT_RADIUS - button.getWidth(),
                SelectionCorner.DEFAULT_RADIUS);
        button.setVisible(true);
        operationCompartment.setComponentZOrder(button, 0);
    }

    /**
     * <p>
     * Hides the button.
     * </p>
     * @param e
     *            mouse event
     */
    public void mouseExited(MouseEvent e) {
        if (e == null || !(e.getSource() instanceof GroupTextField)) {
            return;
        }
        button.setVisible(false);
    }
}
