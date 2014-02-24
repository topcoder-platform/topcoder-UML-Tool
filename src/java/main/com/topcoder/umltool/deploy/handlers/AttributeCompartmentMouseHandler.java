/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.awt.event.MouseEvent;

import com.topcoder.gui.diagramviewer.elements.SelectionCorner;
import com.topcoder.gui.diagramviewer.uml.classelements.ClassNode;
import com.topcoder.gui.diagramviewer.uml.classelements.GroupTextField;
import com.topcoder.umltool.deploy.AttributeAddButton;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * This handler will show the AttributeAddButton when mouse enters the Attribute Compartment, hide when mouse leaves.
 * </p>
 * <p>
 * Thread safety: This class are not required to be thread-safe. They could be used in a thread safe manner in this
 * component.
 * </p>
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class AttributeCompartmentMouseHandler extends CompartmentMouseHandler {

    /**
     * <p>
     * Represents the button to add attributes for this compartment.
     * </p>
     */
    private final AttributeAddButton button;

    /**
     * <p>
     * Creates an instance of <code>AttributeCompartmentMouseHandler</code>.
     * </p>
     * @param mainframe
     *            main frame window
     * @throws IllegalArgumentException
     *             if argument is null
     */
    public AttributeCompartmentMouseHandler(MainFrame mainframe) {
        button = new AttributeAddButton(mainframe);
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
        GroupTextField attributeCompartment = (GroupTextField) e.getSource();
        if (button.getParent() != attributeCompartment) {
            button.setClassNode((ClassNode) attributeCompartment.getParent());
            attributeCompartment.add(button);
        }
        button.setLocation(attributeCompartment.getWidth() - SelectionCorner.DEFAULT_RADIUS - button.getWidth(),
                SelectionCorner.DEFAULT_RADIUS);
        button.setVisible(true);
        attributeCompartment.setComponentZOrder(button, 0);
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
