/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import com.topcoder.gui.panels.documentation.event.DocumentationEvent;
import com.topcoder.gui.panels.documentation.event.DocumentationListener;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.umltool.deploy.actions.undoable.ChangeDocumentationAction;

/**
 * <p>
 * This implementation of DocumentationListener will change the documentation for an element and update the element.
 * </p>
 * <p>
 * Thread safety: This class are not required to be thread-safe. They could be used in a thread safe manner in this
 * component.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class DocumentationHandler implements DocumentationListener {
    /**
     * <p>
     * The mainframe associated with this handler.
     * </p>
     */
    private MainFrame mainFrame = null;

    /**
     * <p>
     * Creates an instance of DocumentationHandler with the mainframe.
     * </p>
     * @param mainFrame
     *            the mainFrame
     */
    public DocumentationHandler(MainFrame mainFrame) {
        this.mainFrame = mainFrame;
    }

    /**
     * <p>
     * Creates initial documentation for an element.
     * </p>
     * @param event
     *            the DocumentationEvent
     * @throws IllegalArgumentException
     *             if the event is null
     */
    public void documentationCreated(DocumentationEvent event) {
        DeployHelper.checkNotNull(event, "event");
        ModelElement modelElement = event.getModelElement();
        changeDocumentation(modelElement, event.getCurrentDocumentation());
    }

    /**
     * <p>
     * Modifies the documentation for an element.
     * </p>
     * @param event
     *            the DocumentationEvent
     * @throws IllegalArgumentException
     *             if the event is null
     */
    public void documentationUpdated(DocumentationEvent event) {
        DeployHelper.checkNotNull(event, "event");
        ModelElement modelElement = event.getModelElement();
        changeDocumentation(modelElement, event.getCurrentDocumentation());
    }

    /**
     * <p>
     * Deletes documentation for an element.
     * </p>
     * @param event
     *            the DocumentationEvent
     * @throws IllegalArgumentException
     *             if the event is null
     */
    public void documentationDeleted(DocumentationEvent event) {
        DeployHelper.checkNotNull(event, "event");
        ModelElement modelElement = event.getModelElement();
        changeDocumentation(modelElement, "");
    }

    /**
     * Updates model element's documentation.
     * @param modelElement
     *            the model element
     * @param documentation
     *            new documentation
     */
    private void changeDocumentation(ModelElement modelElement, String documentation) {
        ChangeDocumentationAction changeDocumentationAction = new ChangeDocumentationAction(modelElement, documentation);
        mainFrame.handleActionEvent(changeDocumentationAction, modelElement, "Change Documentation" + documentation);
    }
}
