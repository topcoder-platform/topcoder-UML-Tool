/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.handlers;

import java.util.EventObject;
import java.util.List;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.DiagramElement;
import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.gui.diagramviewer.DiagramViewer;
import com.topcoder.uml.actions.diagram.RemoveSequenceDiagramAction;
import com.topcoder.uml.model.collaborations.collaborationinstances.CollaborationInstanceSet;
import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.commonbehavior.instances.Instance;
import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.uml.model.commonbehavior.links.Link;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.umltool.deploy.DeployHelper;
import com.topcoder.umltool.deploy.MainFrame;
import com.topcoder.util.actionmanager.Action;
import com.topcoder.util.actionmanager.UndoableAction;
import com.topcoder.util.eventmanager.ActionEvent;
import com.topcoder.util.eventmanager.ActionEventListener;
import com.topcoder.util.eventmanager.EventValidation;
import com.topcoder.util.eventmanager.RedoChangesEvent;
import com.topcoder.util.eventmanager.UndoChangesEvent;

/**
 * <p>
 * Implementation of the ActionEventListener interface. This class is registered to listen to the remove of diagram.
 * </p>
 * <p>
 * New a DiagramView using the created diagram.
 * </p>
 * <p>
 * Thread Safety: The class is immutable and thread safe.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class RemoveDiagramHandler implements ActionEventListener {
    /**
     * <p>
     * Reference to main frame.
     * </p>
     */
    private MainFrame mainFrame;

    /**
     * <p>
     * Creates an instance of RemoveDiagramHandler.
     * </p>
     * @param mainFrame
     *            main frame of the uml tool
     */
    public RemoveDiagramHandler(MainFrame mainFrame) {
        DeployHelper.checkNotNull(mainFrame, "mainFrame");
        this.mainFrame = mainFrame;
    }

    /**
     * <p>
     * This method is called to inform the listener that the event is performed.
     * </p>
     * @param event
     *            the non null event has been performed
     * @param eventValidation
     *            the non null validation result
     * @throws IllegalArgumentException
     *             if event or eventValidation is null
     */
    public void actionPerformed(EventObject event, EventValidation eventValidation) {
        DeployHelper.checkNotNull(eventValidation, "eventValidation");
        removeDiagram(event);
    }

    /**
     * <p>
     * This method is called to inform the listener that the event is undone.
     * </p>
     * @param event
     *            the non null event has been undone
     * @param undoableAction
     *            the non null action which is undone
     * @throws IllegalArgumentException
     *             if event or undoableAction is null
     */
    public void undoActionPerformed(UndoChangesEvent event, UndoableAction undoableAction) {
        DeployHelper.checkNotNull(event, "event");
        DeployHelper.checkNotNull(undoableAction, "undoableAction");
        DeployHelper.checkNotNull(event.getSource(), "source");

        DiagramViewer viewer = mainFrame.getDiagramViewer();
        Action action = ((ActionEvent) event).getAction();
        Diagram diagram = (Diagram) event.getSource();
        if (action instanceof RemoveSequenceDiagramAction) {
            addToCollaboration(diagram);
        }
        mainFrame.getDocumentTree().updateTree();
        viewer.openDiagramView(diagram);
        viewer.revalidate();
    }

    /**
     * <p>
     * This method is called to inform the listener that the event is redone.
     * </p>
     * @param event
     *            the non null event which has been redone
     * @param undoableAction
     *            the non null action which is redone
     * @throws IllegalArgumentException
     *             if event or undoableAction is null
     */
    public void redoActionPerformed(RedoChangesEvent event, UndoableAction undoableAction) {
        DeployHelper.checkNotNull(undoableAction, "undoableAction");
        removeDiagram(event);
    }

    /**
     * <p>
     * Removes the pane related to given diagram.
     * </p>
     * @param event
     *            event that holds the remove diagram action
     */
    private void removeDiagram(EventObject event) {
        DeployHelper.checkNotNull(event, "event");
        DeployHelper.checkNotNull(event.getSource(), "source");

        DiagramViewer viewer = mainFrame.getDiagramViewer();
        Action action = ((ActionEvent) event).getAction();
        Diagram diagram = (Diagram) event.getSource();
        if (action instanceof RemoveSequenceDiagramAction) {
            removeFromCollaboration(diagram);
        }

        mainFrame.getDocumentTree().updateTree();
        viewer.closeDiagramView(diagram);
        viewer.revalidate();
    }

    /**
     * <p>
     * Removes the model elements from the given collaboration.
     * </p>
     * @param diagram
     *            the removing diagram
     */
    private void removeFromCollaboration(Diagram diagram) {
        Uml1SemanticModelBridge bridge = (Uml1SemanticModelBridge) diagram.getOwner();
        Collaboration collaboration = (Collaboration) bridge.getElement();

        List<DiagramElement> elements = diagram.getContaineds();
        for (DiagramElement element : elements) {
            if (element instanceof GraphElement) {
                ModelElement modelElement = DeployHelper.getElement((GraphElement) element);
                if (modelElement != null) {
                    removeModelElementFromCollaboration(collaboration, modelElement);
                }
            }
        }
    }

    /**
     * <p>
     * Removes the model element from the given collaboration.
     * </p>
     * @param collaboration
     *            the collaboration to remove model elements
     * @param modelElement
     *            the model element to remove
     */
    private void removeModelElementFromCollaboration(Collaboration collaboration, ModelElement modelElement) {
        if(modelElement instanceof Object) {
            collaboration.removeOwnedElement(modelElement);
            for (CollaborationInstanceSet set : collaboration.getCollaborationInstanceSets()) {
                set.removeParticipatingInstance((Instance) modelElement);
            }
        } else if(modelElement instanceof Link) {
            for (CollaborationInstanceSet set : collaboration.getCollaborationInstanceSets()) {
                Link link = (Link) modelElement;
                set.removeParticipatingLink(link);
                collaboration.removeOwnedElement(link.getStimuli().iterator().next());
            }
        } else {
            collaboration.removeOwnedElement(modelElement);
        }
    }

    /**
     * <p>
     * Add model elements back to collaboration.
     * </p>
     * @param diagram
     *            the removing diagram
     */
    private void addToCollaboration(Diagram diagram) {
        Uml1SemanticModelBridge bridge = (Uml1SemanticModelBridge) diagram.getOwner();
        Collaboration collaboration = (Collaboration) bridge.getElement();

        List<DiagramElement> elements = diagram.getContaineds();
        for (DiagramElement element : elements) {
            if (element instanceof GraphElement) {
                ModelElement modelElement = DeployHelper.getElement((GraphElement) element);
                if (modelElement != null) {
                    addModelElementToCollaboration(collaboration, modelElement);
                }
            }
        }
    }

    /**
     * <p>
     * Adds back the model element to the given collaboration.
     * </p>
     * @param collaboration
     *            the collaboration to add back to
     * @param modelElement
     *            the model element to add back
     */
    private void addModelElementToCollaboration(Collaboration collaboration, ModelElement modelElement) {
        if(modelElement instanceof Object) {
            collaboration.addOwnedElement(modelElement);
            for (CollaborationInstanceSet set : collaboration.getCollaborationInstanceSets()) {
                set.addParticipatingInstance((Instance) modelElement);
            }
        } else if(modelElement instanceof Link) {
            for (CollaborationInstanceSet set : collaboration.getCollaborationInstanceSets()) {
                Link link = (Link) modelElement;
                set.addParticipatingLink(link);
                collaboration.addOwnedElement(link.getStimuli().iterator().next());
            }
        } else if(modelElement.getNamespace().equals(collaboration)){
            collaboration.addOwnedElement(modelElement);
        }
    }
}
