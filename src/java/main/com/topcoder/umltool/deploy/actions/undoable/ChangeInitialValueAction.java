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
import com.topcoder.uml.model.datatypes.expressions.Expression;
import com.topcoder.uml.model.datatypes.expressions.ExpressionImpl;
import com.topcoder.umltool.deploy.DeployHelper;

/**
 * <p>
 * This class is a subclass of UndoableAbstractAction. This action will change
 * the initial value property of a model element.
 * </p>
 * <p>
 * This class will be created by the application directly. The application can
 * call redo to redo the action, undo to undo the action and execute to execute
 * the action.
 * </p>
 * <p>
 * <b>Thread Safety</b>: This class is not thread safe by containing mutable
 * state information.
 * </p>
 *
 * @author ly, FireIce, ylouis
 * @version 1.0
 */
public class ChangeInitialValueAction extends UndoableAbstractAction {
	/**
	 * <p>
	 * Represents the model element to change the initial value. This variable
	 * is set in the constructor, is immutable (the reference) and never be
	 * null. This variable is referenced in the redoAction undoAction and
	 * executeAction methods.
	 * </p>
	 */
	private final ModelElement element;

	/**
	 * <p>
	 * Represents the old initial value of the model element before this action
	 * performed. This variable is set in the constructor, is immutable (the
	 * reference) and never be null, possible empty. This variable is referenced
	 * in the undoAction method.
	 * </p>
	 */
	private final Object oldInitialValue;

	/**
	 * <p>
	 * Represents the new initial value of the model element after this action
	 * performed. This variable is set in the constructor, is immutable (the
	 * reference )and never be null, possible empty. This variable is referenced
	 * in the redoAction and executeAction methods.
	 * </p>
	 */
	private final String newInitialValue;

	/**
	 * <p>
	 * Creates an instance of the ChangeInitialValueAction.
	 * </p>
	 *
	 * @param element
	 *            the non null model element to change the initial value
	 * @param initialvalue
	 *            the new initial value of the model element
	 * @throws IllegalArgumentException
	 *             if any non null argument is null
	 */
	public ChangeInitialValueAction(ModelElement element, String initialvalue) {
		super("Change initialvalue to " + initialvalue);
		DeployHelper.checkNotNull(element, "element");
		DeployHelper.checkNotNull(initialvalue, "initialvalue");
		this.element = element;
		if (element instanceof Attribute) {
			Expression expression = ((Attribute) element).getInitialValue();
			if (expression == null) {
				oldInitialValue = "";
			} else {
				oldInitialValue = expression.getBody();
			}
		} else {
			// for AssociationEnd model element
			oldInitialValue = element.getTaggedValues();
		}
		newInitialValue = initialvalue;
	}

	/**
	 * <p>
	 * Undo the change entity initial value action.
	 * </p>
	 */
	public void undoAction() {
		updateInitialValue(oldInitialValue);
	}

	/**
	 * <p>
	 * Redo the change entity initial value action.
	 * </p>
	 */
	public void redoAction() {
		updateInitialValue(newInitialValue);
	}

	/**
	 * <p>
	 * Execute the change entity initial value action.
	 * </p>
	 */
	public void executeAction() {
		updateInitialValue(newInitialValue);
	}

	/**
	 * <p>
	 * Changes entity's initial value property.
	 * </p>
	 *
	 * @param object
	 *            the new value of initial value property
	 */
	private void updateInitialValue(Object object) {
		if (element instanceof Attribute) {
			String val = (String) object;
			if (val.length() != 0) {
				Expression expression = new ExpressionImpl();
				expression.setBody(val);
				((Attribute) element).setInitialValue(expression);
			} else {
				((Attribute) element).setInitialValue(null);
			}
		} else {
			// for AssociationEnd model element
			setTaggedValues(object);
		}
	}

	/**
	 * <p>
	 * Set the <b>initialValue</b> property value from the stereotype of the
	 * given model element.
	 * </p>
	 *
	 * @param object
	 *            the object containing initial values
	 */
	@SuppressWarnings("unchecked")
	private void setTaggedValues(Object object) {
		if (object instanceof String) {
			for (TaggedValue taggedValue : element.getTaggedValues()) {
				TagDefinition tagDefinition = taggedValue.getType();
				if ("initialValue".equals(tagDefinition.getTagType())) {
					taggedValue.setDataValue((String) object);
					return;
				}
			}
			TagDefinition tagDefinition = DeployHelper
					.getTagDefinition("initialValue");
			TaggedValueImpl taggedValueImpl = new TaggedValueImpl();
			taggedValueImpl.setType(tagDefinition);
			taggedValueImpl.setDataValue((String) object);
			element.addTaggedValue(taggedValueImpl);
		} else if (object instanceof Collection) {
			Collection<TaggedValue> taggedValues = (Collection<TaggedValue>) object;
			element.clearTaggedValues();
			for (TaggedValue taggedValue : taggedValues) {
				element.addTaggedValue(taggedValue);
			}
		}
	}
}
