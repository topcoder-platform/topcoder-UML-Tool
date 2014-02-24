/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.deploy.actions.undoable;

import java.util.Collection;

import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;
import com.topcoder.uml.model.core.relationships.AssociationEnd;
import com.topcoder.umltool.deploy.DeployHelper;

/**
 * <p>
 * This class is a subclass of UndoableAbstractAction. This action will change the transient property of a model
 * element.
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
public class ChangeTransientAction extends UndoableAbstractAction {
    /**
     * <p>
     * Represents the model element to change the transient. This variable is set in the constructor, is immutable (the
     * reference) and never be null. This variable is referenced in the redoAction undoAction and executeAction methods.
     * </p>
     */
    private final ModelElement element;

    /**
     * <p>
     * Represents the old transient of the model element before this action performed. This variable is set in the
     * constructor, is immutable (the reference) and never be null, possible empty. This variable is referenced in the
     * undoAction method.
     * </p>
     */
    private final Collection<TaggedValue> oldValue;

    /**
     * <p>
     * Represents the new transient of the model element after this action performed. This variable is set in the
     * constructor, is immutable (the reference )and never be null, possible empty. This variable is referenced in the
     * redoAction and executeAction methods.
     * </p>
     */
    private final boolean newIsTransient;

    /**
     * <p>
     * Creates an instance of the ChangeTransientAction.
     * </p>
     * @param element
     *            the non null model element to change the transient
     * @param isTransient
     *            the new transient of the model element
     * @throws IllegalArgumentException
     *             if any non null argument is null
     */
    public ChangeTransientAction(ModelElement element, boolean isTransient) {
        super("Change transient to " + isTransient);
        DeployHelper.checkNotNull(element, "element");
        this.element = element;
        if (element instanceof Attribute || element instanceof AssociationEnd) {
            oldValue = element.getTaggedValues();
        } else {
            oldValue = null;
        }
        newIsTransient = isTransient;
    }

    /**
     * <p>
     * Undo the change entity transient action.
     * </p>
     */
    public void undoAction() {
        setTaggedValues(oldValue);
    }

    /**
     * <p>
     * Redo the change entity transient action.
     * </p>
     */
    public void redoAction() {
        setTaggedValue("transient", String.valueOf(newIsTransient));
    }

    /**
     * <p>
     * Execute the change entity transient action.
     * </p>
     */
    public void executeAction() {
        redoAction();
    }

    /**
     * <p>
     * Sets the tagged value.
     * </p>
     * @param taggedValues
     *            the tagged value collection
     */
    private void setTaggedValues(Collection<TaggedValue> taggedValues) {
        element.clearTaggedValues();
        for (TaggedValue taggedValue : taggedValues) {
            element.addTaggedValue(taggedValue);
        }
    }

    /**
     * <p>
     * This method checks whether a given model element has a <code>TaggedValue</code> with the given
     * <code>type</code> name and set its value.
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
        TagDefinition tagDefinition = DeployHelper.getTagDefinition("transient");
        TaggedValueImpl taggedValueImpl = new TaggedValueImpl();
        taggedValueImpl.setType(tagDefinition);
        taggedValueImpl.setDataValue(value);
        element.addTaggedValue(taggedValueImpl);
    }
}
