/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions;

import java.awt.Event;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;

/**
 * <p>
 * Copy element action to copy representation of elements.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class CopyRepresentationAction extends AbstractAction {
    /**
     * <p>
     * The version id.
     * <p>
     */
    private static final long serialVersionUID = -2873752707169317598L;

    /**
     * <p>
     * Action name.
     * <p>
     */
    private static final String ACTION_NAME = "Copy Representation";

    /**
     * <p>
     * Action description.
     * <p>
     */
    private static final String SHORT_DESCRIPTION = "Copy Representation.";

    /**
     * <p>
     * Icon file name for menu.
     * <p>
     */
    private static final String ICON_FILE_NAME = "/images/CopySelectedDiagram_16.png";

    /**
     * <p>
     * Acceleration key.
     * <p>
     */
    private static final KeyStroke DEFAULT_ACCELERATOR_KEY = KeyStroke.getKeyStroke('C', Toolkit.getDefaultToolkit()
            .getMenuShortcutKeyMask()
            | Event.SHIFT_MASK);

    /**
     * <p>
     * Icon file for tool bar.
     * <p>
     */
    private static final String TOOLBAR_ICON_FILE_NAME = "/images/CopySelectedDiagram.png";

    /**
     * <p>
     * Reference to main frame.
     * <p>
     */
    private final MainFrame mainFrame;

    /**
     * <p>
     * Constructs an instance of copy element representation action.
     * <p>
     * @param mainFrame
     *            main frame of uml tool
     */
    public CopyRepresentationAction(MainFrame mainFrame) {
        super(ACTION_NAME, new ImageIcon(CopyRepresentationAction.class.getResource(ICON_FILE_NAME)));
        this.putValue(Action.SHORT_DESCRIPTION, SHORT_DESCRIPTION);
        this.putValue(Action.ACCELERATOR_KEY, DEFAULT_ACCELERATOR_KEY);

        this.putValue(MainFrame.TOOL_BAR_ICON_KEY_NAME, new ImageIcon(CopyRepresentationAction.class
                .getResource(TOOLBAR_ICON_FILE_NAME)));

        this.mainFrame = mainFrame;
    }

    /**
     * <p>
     * Performing the action.
     * <p>
     * @param actionEvent
     *            the action event
     */
    public void actionPerformed(ActionEvent actionEvent) {
        Set<Object> copyObjects = getCopyObjects();
        CopyPasteCutUtil.copyRepresentation(mainFrame, copyObjects);
    }

    /**
     * <p>
     * Gets the set of objects to be copied.
     * </p>
     * @return the set of objects to be copied
     */
    private Set<Object> getCopyObjects() {
        List<Object> filterObjects = DeployHelper.getFilteredSelectedNodes(mainFrame);
        Set<Object> copyObjects = new HashSet<Object>();
        Set<ModelElement> copyModelElements = new HashSet<ModelElement>();

        for (Object object : filterObjects) {
            if (object instanceof JComponent) {
                ModelElement modelElement = DeployHelper.getElement((JComponent) object);
                if (modelElement == null || !copyModelElements.contains(modelElement)) {
                    copyModelElements.add(modelElement);
                    copyObjects.add(object);
                }
            } else {
                copyObjects.add(object);
            }
        }

        return copyObjects;
    }
}
