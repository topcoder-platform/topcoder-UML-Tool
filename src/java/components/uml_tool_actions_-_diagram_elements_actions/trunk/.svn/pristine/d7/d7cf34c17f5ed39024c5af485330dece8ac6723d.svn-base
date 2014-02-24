/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.diagram.elements;

import com.topcoder.diagraminterchange.GraphElement;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationException;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This class handles all add actions of this component.
 * </p>
 *
 * <p>
 * Client of this class will instantiate this class by giving both the parent and the child
 * GraphElement as well as ProjectConfigurationManager.
 * </p>
 *
 * <p>
 * Thread Safety : This class is not thread safe as execute, redo and undo can interfere
 * each other.
 * </p>
 *
 * @author bramandia, TCSDEVELOPER
 * @version 1.0
 */
public class AddDiagramElementAction extends DiagramElementUndoableAction {
    /**
     * <p>
     * Represents the child GraphElement to be added to the parent GraphElement.
     * </p>
     *
     * <p>
     * This variable will not be null and will not be changed.
     * </p>
     */
    private final GraphElement child;

    /**
     * <p>
     * Represents the ProjectConfigurationManager to be used.
     * </p>
     *
     * <p>
     * This variable will not be null and will not be changed.
     * </p>
     */
    private final ProjectConfigurationManager manager;

    /**
     * <p>
     * Constructor an AddDiagramElementAction instance with parent graph element, child graph element
     * and project configuration manager specified.
     * </p>
     *
     * @param parent the parent element
     * @param child child to be added
     * @param manager project configuration manager to be used
     *
     * @throws IllegalArgumentException if any of the argument is null
     */
    public AddDiagramElementAction(GraphElement parent, GraphElement child, ProjectConfigurationManager manager) {
        super(parent);

        Util.checkNull(parent, "parent");
        Util.checkNull(child, "child");
        Util.checkNull(manager, "manager");

        this.child = child;
        this.manager = manager;
    }

    /**
     * <p>
     * Return the child GraphElement to be added.
     * </p>
     *
     * @return the child graph element
     */
    public GraphElement getChild() {
        return this.child;
    }

    /**
     * <p>
     * Execute the Add Action, add the child element to the parent element and
     * use ProjectConfigurationManager to apply initial formatting.
     * </p>
     *
     * @throws ActionExecutionException if fails to execute the action successfully
     */
    public void execute() throws ActionExecutionException {
        performAction();
        this.executionSuccess();
    }

    /**
     * <p>
     * Redo the add action.
     * </p>
     *
     * <p>
     * Execute the Add Action, add the child element to the parent element and
     * use ProjectConfigurationManager to apply initial formatting.
     * </p>
     *
     * <p>
     * If ActionExecutionException is not re-thrown during the redo operation, it is
     * stored to the last exception and intended for later retrieve.
     * </p>
     *
     * @throws CannotRedoException if redo operation cannot be performed
     */
    public void redo() {
        super.redo();

        // the ActionExecutionException will be set the lastException variable
        // and then ignored
        try {
            performAction();
            this.redoSuccess();
        } catch (ActionExecutionException e) {
            this.setLastException(e);
        }
    }

    /**
     * <p>
     * Undo the add action.
     * </p>
     *
     * @throws CannotUndoException if undo operation cannot be performed
     */
    public void undo() {
        super.undo();
        this.getElement().removeContained(child);
        this.undoSuccess();
    }

    /**
     * <p>
     * Return the project configuration manager used.
     * </p>
     *
     * @return the Project Configuration Manager used.
     */
    public ProjectConfigurationManager getProjectConfigurationManager() {
        return manager;
    }

    /**
     * <p>
     * Perform the Add Action, add the child element to the parent element and
     * use ProjectConfigurationManager to apply initial formatting.
     * </p>
     *
     * @throws ActionExecutionException if fails to perform the action successfully
     */
    private void performAction() throws ActionExecutionException {
        // add the child element to the parent element
        // The project configuration manager is used too.
        try {
            this.getElement().addContained(child);
            child.setContainer(this.getElement());
            manager.applyInitialFormatting(manager.getDefaultProjectLanguage(), child);
        } catch (ProjectConfigurationException e) {
            throw new ActionExecutionException("ProjectConfigurationException occurs while formatting the element.", e);
        }
    }
}
