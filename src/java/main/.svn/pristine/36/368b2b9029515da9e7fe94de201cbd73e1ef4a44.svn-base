/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.Operation;
import com.topcoder.uml.model.core.Parameter;
import com.topcoder.uml.model.core.classifiers.Class;
import com.topcoder.uml.model.core.classifiers.Enumeration;
import com.topcoder.uml.model.core.classifiers.Interface;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;
import com.topcoder.uml.model.modelmanagement.Package;
import com.topcoder.uml.model.modelmanagement.Subsystem;
import com.topcoder.uml.model.usecases.Actor;
import com.topcoder.uml.model.usecases.UseCase;
import com.topcoder.umltool.deploy.DeployHelper;

/**
 * <p>
 * This class is a subclass of UndoableAbstractAction. This action will change the final property of a model element.
 * </p>
 * <p>
 * This class will be created by the application directly. The application can call redo to redo the action, undo to
 * undo the action and execute to execute the action.
 * </p>
 * <p>
 * <b>Thread Safety</b>: This class is not thread safe by containing mutable state information.
 * </p>
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class ChangeFinalAction extends UndoableAbstractAction {
    /**
     * <p>
     * Represents the model element to change the final. This variable is set in the constructor, is immutable (the
     * reference) and never be null. This variable is referenced in the redoAction undoAction and executeAction methods.
     * </p>
     */
    private final ModelElement element;

    /**
     * <p>
     * Represents the old final of the model element before this action performed. This variable is set in the
     * constructor, is immutable (the reference) and never be null, possible empty. This variable is referenced in the
     * undoAction method.
     * </p>
     */
    private final boolean oldIsFinal;

    /**
     * <p>
     * Represents the new final of the model element after this action performed. This variable is set in the
     * constructor, is immutable (the reference )and never be null, possible empty. This variable is referenced in the
     * redoAction and executeAction methods.
     * </p>
     */
    private final boolean newIsFinal;

    /**
     * <p>
     * Creates an instance of the ChangeFinalAction.
     * </p>
     * @param element
     *            the non null model element to change the final
     * @param isFinal
     *            the new final of the model element
     * @throws IllegalArgumentException
     *             if any non null argument is null
     */
    public ChangeFinalAction(ModelElement element, boolean isFinal) {
        super("Change final to " + isFinal);
        DeployHelper.checkNotNull(element, "element");
        this.element = element;
        if (element instanceof Package) {
            oldIsFinal = ((Package) element).isLeaf();
        } else if (element instanceof Interface) {
            oldIsFinal = ((Interface) element).isLeaf();
        } else if (element instanceof Class) {
            oldIsFinal = ((Class) element).isLeaf();
        } else if (element instanceof Enumeration) {
            oldIsFinal = ((Enumeration) element).isLeaf();
        } else if (element instanceof Operation) {
            oldIsFinal = ((Operation) element).isLeaf();
        } else if (element instanceof Actor) {
            oldIsFinal = ((Actor) element).isLeaf();
        } else if (element instanceof UseCase) {
            oldIsFinal = ((UseCase) element).isLeaf();
        } else if (element instanceof Subsystem) {
            oldIsFinal = ((Subsystem) element).isLeaf();
        } else if (element instanceof Parameter) {
            oldIsFinal = getTaggedValue("final");
        } else {
            oldIsFinal = false;
        }
        newIsFinal = isFinal;
    }

    /**
     * <p>
     * Undo the change entity final action.
     * </p>
     */
    public void undoAction() {
        updateFinal(oldIsFinal);
    }

    /**
     * <p>
     * Redo the change entity final action.
     * </p>
     */
    public void redoAction() {
        updateFinal(newIsFinal);
    }

    /**
     * <p>
     * Execute the change entity final action.
     * </p>
     */
    public void executeAction() {
        updateFinal(newIsFinal);
    }

    /**
     * <p>
     * Changes entity's final property.
     * </p>
     * @param isFinal
     *            the new value of final property
     */
    private void updateFinal(boolean isFinal) {
        if (element instanceof Package) {
            ((Package) element).setLeaf(isFinal);
        } else if (element instanceof Interface) {
            ((Interface) element).setLeaf(isFinal);
        } else if (element instanceof Class) {
            ((Class) element).setLeaf(isFinal);
        } else if (element instanceof Enumeration) {
            ((Enumeration) element).setLeaf(isFinal);
        } else if (element instanceof Operation) {
            ((Operation) element).setLeaf(isFinal);
        } else if (element instanceof Actor) {
            ((Actor) element).setLeaf(isFinal);
        } else if (element instanceof UseCase) {
            ((UseCase) element).setLeaf(isFinal);
        } else if (element instanceof Subsystem) {
            ((Subsystem) element).setLeaf(isFinal);
        } else if (element instanceof Parameter) {
            setTaggedValue("final", String.valueOf(isFinal));
        }
    }

    /**
     * <p>
     * This method checks whether a given model element has a <code>TaggedValue</code> with the given
     * <code>type</code> name and its value is <b>true</b>.
     * </p>
     * @param type
     *            the tag type
     * @return true if the <code>TaggedValue</code> can be found, false otherwise
     */
    private boolean getTaggedValue(String type) {
        for (TaggedValue taggedValue : element.getTaggedValues()) {
            TagDefinition tagDefinition = taggedValue.getType();
            if (type.equals(tagDefinition.getTagType())) {
                // The TaggedValue is found
                if ("true".equals(taggedValue.getDataValue())) {
                    return true;
                }
            }
        }

        // The TaggedValue is not found
        return false;
    }

    /**
     * <p>
     * This method set a given model element a <code>TaggedValue</code>.
     * </p>
     * @param type
     *            the tag type
     * @param value
     *            the tag value
     */
    private void setTaggedValue(String type, String value) {
        for (TaggedValue taggedValue : element.getTaggedValues()) {
            TagDefinition tagDefinition = taggedValue.getType();
            if (type.equals(tagDefinition.getTagType())) {
                // The TaggedValue is found
                taggedValue.setDataValue(value);
                return;
            }
        }
        // The TaggedValue is not found
        TagDefinition tagDefinition = DeployHelper.getTagDefinition(type);
        TaggedValueImpl taggedValueImpl = new TaggedValueImpl();
        taggedValueImpl.setType(tagDefinition);
        taggedValueImpl.setDataValue(value);
        element.addTaggedValue(taggedValueImpl);
    }
}
