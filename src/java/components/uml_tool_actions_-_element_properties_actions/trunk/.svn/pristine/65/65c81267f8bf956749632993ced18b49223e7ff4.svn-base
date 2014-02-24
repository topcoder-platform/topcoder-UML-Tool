/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.custom;

import java.util.Iterator;

import com.topcoder.uml.actions.general.Helper;
import com.topcoder.uml.actions.general.UndoableAbstractAction;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;

/**
 * <p>
 * This class is a subclass of UndoableAbstractAction. This action will mark a classifier static.
 * This is accomplished using a TagDefinition(&quot;static&quot;) with a taggedvalue in the
 * Classifier with value &quot;true&quot;.
 * </p>
 * <p>
 * This class will be created by the application directly. The application can call redo to redo the
 * action, undo to undo the action and execute to execute the action. If any exception prevents
 * redo/undo methods from completing successfully, it should be log with logError.
 * </p>
 * <p>
 * <b>Thread Safety</b>: This class is not thread safe by containing mutable state information.
 * </p>
 *
 * @author kinzz, rainday
 * @version 1.0
 */
public class MarkNestedClassifierStaticAction extends UndoableAbstractAction {

    /**
     * <p>
     * Represents the classifier to change the static attributes. This variable is set in the
     * constructor, is immutable (the reference) and never be null. This variable is referenced in
     * the doAction and undoAction method.
     * </p>
     */
    private final TaggedValue taggedValue;

    /**
     * <p>
     * Represents the old static attribute of the classifier before this action performed. This
     * variable is set in the constructor, is immutable. This variable is referenced in the
     * undoAction method.
     * </p>
     */
    private final boolean oldIsStatic;

    /**
     * <p>
     * Represents the new static attribute of the classifier after this action performed. This
     * variable is set in the constructor, is immutable. This variable is referenced in the
     * redoAction and execute methods.
     * </p>
     */
    private final boolean newIsStatic;

    /**
     * <p>
     * Constructor of the mark nested classifier static action.
     * </p>
     *
     * @param classifier
     *        the non null classifier to change the static attributes
     * @param isStatic
     *        the new static attribute of the classifier
     * @throws IllegalArgumentException
     *         if any non null argument is null
     */
    public MarkNestedClassifierStaticAction(Classifier classifier, boolean isStatic) {
        super("Mark nested classifier static action to " + isStatic);
        Helper.checkNotNull(classifier, "classifier");
        Iterator<TaggedValue> iter = classifier.getTaggedValues().iterator();
        TaggedValue value = null;
        while (iter.hasNext()) {
            value = iter.next();
            if (value.getType().getTagType().equals("static")) {
                break;
            }
            value = null;
        }

        if (value == null) {
            oldIsStatic = isStatic;
        } else {
            oldIsStatic = Boolean.parseBoolean(value.getDataValue());
        }
        taggedValue = value;
        newIsStatic = isStatic;
    }

    /**
     * <p>
     * Redo the mark nested classifier static action.
     * </p>
     */
    public void redoAction() {
        taggedValue.setDataValue(Boolean.toString(newIsStatic));
    }

    /**
     * <p>
     * Execute the mark nested classifier static action.
     * </p>
     */
    public void executeAction() {
        taggedValue.setDataValue(Boolean.toString(newIsStatic));
    }

    /**
     * <p>
     * Undo the mark nested classifier static action.
     * </p>
     */
    public void undoAction() {
        taggedValue.setDataValue(Boolean.toString(oldIsStatic));
    }
}
