/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram;

import com.topcoder.diagraminterchange.Diagram;
import com.topcoder.diagraminterchange.SemanticModelBridge;
import com.topcoder.diagraminterchange.Uml1SemanticModelBridge;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.core.Element;

/**
 * <p>
 * This class is a subclass of {@link RemoveDiagramAction}.
 *
 * </p>
 *
 * <p>
 * This action will support removing an activity graph diagram.
 * </p>
 *
 * <p>
 * This class will be created by application directly. The <code>redoAction</code> method is called to redo the action,
 * while the <code>undoAction</code> method is called to undo the action and the <code>executeAction</code> method is
 * called to execute the action.
 * </p>
 *
 * <p>
 * <b>Thread Safety:</b>
 * This class is not thread safe by containing mutable state information.
 * </p>
 *
 * @author kinzz, TCSDEVELOPER
 * @version 1.0
 */
public class RemoveActivityDiagramAction extends RemoveDiagramAction {

    /**
     * <p>
     * Represents the activity graph to be removed.
     * </p>
     *
     * <p>
     * This variable is set in the constructor, is immutable (the reference) and never be null.
     * </p>
     *
     * <p>
     * This variable is referenced in the <code>executeAction</code> <code>redoAction</code> and
     * <code>undoAction</code> method.
     * </p>
     */
    private final ActivityGraph activityGraph;

    /**
     * <p>
     * Constructor of the remove activity diagram action.
     * </p>
     *
     * <p>
     * It will save the element from the owner of the diagram to the activityGraph variable. AnIllegalArgumentException
     * will be thrown if the diagram is null, or if the owner of the diagram is null or it does not hold an valid
     * ActivityGraph element.
     * </p>
     *
     * @param diagram the non null diagram to be removed
     *
     * @throws IllegalArgumentException if the diagram is null, or if the owner of the diagram is null or it does not
     *  hold an valid ActivityGraph element.
     */
    public RemoveActivityDiagramAction(Diagram diagram) {
        super(diagram);
        SemanticModelBridge modelBridge = diagram.getOwner();
        if (!(modelBridge instanceof Uml1SemanticModelBridge)) {
            throw new IllegalArgumentException(
                    "The SemanticModelBridge of the diagram should be of Uml1SemanticModelBridge type.");
        }
        Uml1SemanticModelBridge umlSemanticModelBridge = (Uml1SemanticModelBridge) modelBridge;
        Element owner = umlSemanticModelBridge.getElement();
        if (!(owner instanceof ActivityGraph)) {
            throw new IllegalArgumentException("The owner should be of ActivityGraph type.");
        }
        activityGraph = (ActivityGraph) owner;
    }

    /**
     * <p>
     * Undoes the edit that was made.
     * </p>
     *
     * <p>
     * It will add the activity graph diagram to the <code>UMLModelManager</code> instance.
     * </p>
     */
    public void undoAction() {
        Helper.addActivityGraphToUMLModelManager(activityGraph);
        super.undoAction();
    }

    /**
     * <p>
     * Re-applies the edit.
     * </p>
     *
     * <p>
     * It will remove the activity graph diagram from the <code>UMLModelManager</code> instance.
     * </p>
     */
    public void redoAction() {
        Helper.removeActivityGraphFromUMLModelManager(activityGraph);
        super.redoAction();
    }

    /**
     * <p>
     * Executes this auction.
     * </p>
     *
     * <p>
     * It will remove the activity graph diagram from the <code>UMLModelManager</code> instance.
     * </p>
     */
    public void executeAction() {
        Helper.removeActivityGraphFromUMLModelManager(activityGraph);
        super.executeAction();
    }
}
