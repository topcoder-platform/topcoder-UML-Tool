/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.sequence;

import com.topcoder.uml.model.collaborations.collaborationinteractions.Collaboration;
import com.topcoder.uml.model.commonbehavior.instances.Object;
import com.topcoder.uml.modelmanager.UMLModelManager;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationException;
import com.topcoder.uml.projectconfiguration.ProjectConfigurationManager;
import com.topcoder.util.actionmanager.ActionExecutionException;
import com.topcoder.util.log.Level;

/**
 * <p>
 * This class extends from <code>ObjectUndoableAction</code> and provides functionality for adding Object instance
 * to collaboration.
 * </p>
 * <p>
 * It also provides redo and undo functionality for adding. This class also responsible for applying initial
 * formatting by using {@link ProjectConfigurationManager} for the given object.
 * </p>
 * <p>
 * <b>Thread Safety : </b>Class is not thread safe since it extends from a mutable class.
 * </p>
 *
 * @author tushak, evilisneo
 * @version 1.0
 */
public class AddObjectAction extends ObjectUndoableAction {

    /**
     * <p>
     * Represents human readable description of this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Add Object";

    /**
     * <p>
     * Represents UMLModelManager reference for current action. Cannot be <code>null</code>, Set in
     * constructor.
     * </p>
     */
    private final UMLModelManager manager;

    /**
     * <p>
     * Constructs the add object action using the <code>collaboration</code> and <code>manager</code>.
     * The namespace(collaboration) is added to the <code>object</code> for processing.
     * </p>
     *
     * @param object
     *            Object instance, Cannot be <code>null</code>
     * @param collaboration
     *            Collaboration instance, Cannot be <code>null</code>
     * @param manager
     *            UMLModelManager instance, Cannot be <code>null</code>
     * @throws IllegalArgumentException
     *             if the <code>object, collaboration, manager</code> is <code>null</code>.
     */
    public AddObjectAction(Object object, Collaboration collaboration, UMLModelManager manager) {
        // null will be checked in the super
        super(object);
        // check if collaboration is null
        Helper.checkObjectNotNull(collaboration, "collaboration in AddObjectAction#AddObjectAction");
        object.setNamespace(collaboration);
        // check if manager is null
        Helper.checkObjectNotNull(manager, "manager in AddObjectAction#AddObjectAction");
        this.manager = manager;
    }

    /**
     * <p>
     * This method is the main method for adding object. It first applies formatting using
     * {@link ProjectConfigurationManager} for the Object. If the Object is not added to the namespace, it is
     * added else exception will be thrown as it is already added.
     * </p>
     *
     * @throws ActionExecutionException
     *             if the object is already added to the namespace or any exception while formatting the
     *             object.
     */
    public void execute() throws ActionExecutionException {
        ObjectUtil objectUtil = getObjectUtil();
        // Check if applying formatting runs normal
        try {
            manager.getProjectConfigurationManager().applyInitialFormatting(manager.getProjectLanguage(),
                getObject());
        } catch (ProjectConfigurationException ex) {
            throw new ActionExecutionException("Occurred while applying initial formatting to the stimulus");
        } catch (IllegalStateException ex) {
            throw new ActionExecutionException("Occurred while applying initial formatting to the message,"
                + " configuration manager not set for model manager", ex);
        }
        // Check if given class instance already present in collaboration
        if (objectUtil.checkObjectNamespace(getObject())) {
            throw new ActionExecutionException("The object is already present in the namespace.");
        } else {
            objectUtil.addObjectToCollaboration(getObject());
        }
    }

    /**
     * <p>
     * This method redo's the adding of object to the collaboration. If the redo is not possible, a warning
     * message is written to the log file.
     * </p>
     */
    public void redo() {
        if (canRedo()) {
            getObjectUtil().addObjectToCollaboration(getObject());
            super.redo();
        } else {
            getLog().log(Level.WARN, "Cannot redo the 'Add object' action");
        }
    }

    /**
     * <p>
     * This method undo's the adding of object to the collaboration. If the undo is not possible, a warning
     * message is written to the log file.
     * </p>
     */
    public void undo() {
        if (canUndo()) {
            getObjectUtil().removeObjectFromCollaboration(getObject());
            super.undo();
        } else {
            getLog().log(Level.WARN, "Cannot undo 'Add Object' action");
        }
    }

    /**
     * <p>
     * Returns "Add Object" - Description of this action.
     * </p>
     *
     * @return the string describing this action.
     */
    public String getPresentationName() {
        return PRESENTATION_NAME;
    }
}
