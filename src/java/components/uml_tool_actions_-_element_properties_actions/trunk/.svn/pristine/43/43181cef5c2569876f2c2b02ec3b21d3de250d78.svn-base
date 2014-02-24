/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.classifier.feature;

import com.topcoder.uml.actions.UnitTestsHelper;
import com.topcoder.uml.actions.model.classifiers.feature.UpdateAttributeAction;
import com.topcoder.uml.model.core.Attribute;
import com.topcoder.uml.model.core.AttributeImpl;
import com.topcoder.uml.model.core.Classifier;
import com.topcoder.uml.model.core.classifiers.ClassImpl;
import com.topcoder.uml.model.core.classifiers.InterfaceImpl;
import com.topcoder.uml.model.datatypes.ChangeableKind;
import com.topcoder.uml.model.datatypes.Multiplicity;
import com.topcoder.uml.model.datatypes.MultiplicityImpl;
import com.topcoder.uml.model.datatypes.ScopeKind;
import com.topcoder.uml.model.datatypes.VisibilityKind;
import com.topcoder.uml.model.datatypes.expressions.Expression;
import com.topcoder.uml.model.datatypes.expressions.ExpressionImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinitionImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test for the UpdateAttributeAction class.
 * </p>
 *
 * @author rainday
 * @version 1.0
 */
public class UpdateAttributeActionUnitTests extends TestCase {

    /**
     * Represents the UpdateAttributeAction instance used for tests.
     */
    private UpdateAttributeAction testUpdateAttributeAction;

    /**
     * Represents the new multiplicity of the attribute after this action performed.
     */
    private Multiplicity newMultiplicity;

    /**
     * Represents the new visibility of the attribute after this action performed.
     */
    private VisibilityKind newVisibility;

    /**
     * Represents the new name of the attribute after this action performed.
     */
    private String newName;

    /**
     * Represents the old name of the attribute before this action performed.
     */
    private String oldName;

    /**
     * Represents the old changeability of the attribute before this action performed.
     */
    private ChangeableKind oldChangeability;

    /**
     * Represents the new changeability of the attribute after this action performed.
     */
    private ChangeableKind newChangeability;

    /**
     * Represents the old multiplicity of the attribute before this action performed.
     */
    private Multiplicity oldMultiplicity;

    /**
     * Represents the old visibility of the attribute before this action performed.
     */
    private VisibilityKind oldVisibility;

    /**
     * Represents the old initial value of the attribute before this action performed.
     */
    private Expression oldInitialValue;

    /**
     * Represents the new initial value of the attribute after this action performed.
     */
    private Expression newInitialValue;

    /**
     * Represents the new type of the attribute after this action performed.
     */
    private Classifier newType;

    /**
     * Represents the old type of the attribute before this action performed.
     */
    private Classifier oldType;

    /**
     * Represents the new isTransient value of the attribute after this action performed.
     */
    private boolean newIsTransient;

    /**
     * Represents the old isTransient of the attribute before this action performed.
     */
    private boolean oldIsTransient;

    /**
     * Represents the new owner kind (INSTANCE is for non-static, CLASSIFIER is for static) of
     * the attribute after this action performed.
     */
    private ScopeKind newOwnerKind;

    /**
     * Represents the old owner kind (INSTANCE is for non-static, CLASSIFIER is for static) of
     * the attribute before this action performed.
     */
    private ScopeKind oldOwnerKind;

    /**
     * Represents the attribute to be updated.
     */
    private Attribute attribute;

    /**
     * Set up the test environment.
     */
    protected void setUp() {
        attribute = new AttributeImpl();

        newMultiplicity = new MultiplicityImpl();
        oldMultiplicity = new MultiplicityImpl();
        attribute.setMultiplicity(oldMultiplicity);

        newVisibility = VisibilityKind.PACKAGE;
        oldVisibility = VisibilityKind.PUBLIC;
        attribute.setVisibility(oldVisibility);

        newName = "newName";
        oldName = "oldName";
        attribute.setName(oldName);

        newChangeability = ChangeableKind.FROZEN;
        oldChangeability = ChangeableKind.ADD_ONLY;
        attribute.setChangeability(oldChangeability);

        newInitialValue = new ExpressionImpl();
        oldInitialValue = new ExpressionImpl();
        attribute.setInitialValue(oldInitialValue);

        newType = new InterfaceImpl();
        oldType = new ClassImpl();
        attribute.setType(oldType);

        newOwnerKind = ScopeKind.CLASSIFIER;
        oldOwnerKind = ScopeKind.INSTANCE;
        attribute.setOwnerScope(oldOwnerKind);

        TaggedValue value = new TaggedValueImpl();
        TagDefinition definition = new TagDefinitionImpl();
        definition.setTagType("transient");
        value.setType(definition);
        value.setDataValue("true");
        attribute.addTaggedValue(value);
        newIsTransient = false;
        oldIsTransient = true;
        testUpdateAttributeAction = new UpdateAttributeAction(attribute, newVisibility, newName,
                newType, newInitialValue, newChangeability, newMultiplicity, newOwnerKind, newIsTransient);
    }

    /**
     * Accuracy test for the method <code>undoAction()</code>. Each field value will be set to old|field| value.
     */
    public void testUndoAction() {
        testUpdateAttributeAction.undoAction();
        assertEquals("UpdateAttributeAction undoAction incorrectly", oldVisibility, attribute.getVisibility());
        assertEquals("UpdateAttributeAction undoAction incorrectly", oldName, attribute.getName());
        assertEquals("UpdateAttributeAction undoAction incorrectly", oldType, attribute.getType());
        assertEquals("UpdateAttributeAction undoAction incorrectly", oldInitialValue, attribute.getInitialValue());
        assertEquals("UpdateAttributeAction undoAction incorrectly", oldChangeability, attribute.getChangeability());
        assertEquals("UpdateAttributeAction undoAction incorrectly", oldMultiplicity, attribute.getMultiplicity());
        assertEquals("UpdateAttributeAction undoAction incorrectly", oldOwnerKind, attribute.getOwnerScope());
        assertEquals("UpdateAttributeAction undoAction incorrectly", oldIsTransient,
                Boolean.parseBoolean(attribute.getTaggedValues().iterator().next().getDataValue()));
    }

    /**
     * Accuracy test for the method <code>redoAction()</code>. Each field value will be set to new|field| value.
     */
    public void testRedoAction() {
        testUpdateAttributeAction.redoAction();
        assertEquals("UpdateAttributeAction redoAction incorrectly", newVisibility, attribute.getVisibility());
        assertEquals("UpdateAttributeAction redoAction incorrectly", newName, attribute.getName());
        assertEquals("UpdateAttributeAction redoAction incorrectly", newType, attribute.getType());
        assertEquals("UpdateAttributeAction redoAction incorrectly", newInitialValue, attribute.getInitialValue());
        assertEquals("UpdateAttributeAction redoAction incorrectly", newChangeability, attribute.getChangeability());
        assertEquals("UpdateAttributeAction redoAction incorrectly", newMultiplicity, attribute.getMultiplicity());
        assertEquals("UpdateAttributeAction redoAction incorrectly", newOwnerKind, attribute.getOwnerScope());
        assertEquals("UpdateAttributeAction redoAction incorrectly", newIsTransient,
                Boolean.parseBoolean(attribute.getTaggedValues().iterator().next().getDataValue()));
    }

    /**
     * Accuracy test for the method <code>executeAction()</code>. Each field value will be set to new|field| value.
     */
    public void testExecuteAction() {
        testUpdateAttributeAction.executeAction();
        assertEquals("UpdateAttributeAction executeAction incorrectly", newVisibility, attribute.getVisibility());
        assertEquals("UpdateAttributeAction executeAction incorrectly", newName, attribute.getName());
        assertEquals("UpdateAttributeAction executeAction incorrectly", newType, attribute.getType());
        assertEquals("UpdateAttributeAction executeAction incorrectly",
                newInitialValue, attribute.getInitialValue());
        assertEquals("UpdateAttributeAction executeAction incorrectly",
                newChangeability, attribute.getChangeability());
        assertEquals("UpdateAttributeAction executeAction incorrectly",
                newMultiplicity, attribute.getMultiplicity());
        assertEquals("UpdateAttributeAction executeAction incorrectly", newOwnerKind, attribute.getOwnerScope());
        assertEquals("UpdateAttributeAction executeAction incorrectly", newIsTransient,
            Boolean.parseBoolean(attribute.getTaggedValues().iterator().next().getDataValue()));
    }

    /**
     * Test UpdateAttributeAction constructor.
     */
    public void testUpdateAttributeAction() {
        assertNotNull("Create UpdateAttributeAction incorrectly.", testUpdateAttributeAction);
        assertEquals("UpdateAttributeAction executeAction incorrectly", attribute,
                UnitTestsHelper.getObjectFieldValue(testUpdateAttributeAction, "attribute"));
        assertEquals("UpdateAttributeAction executeAction incorrectly", newVisibility,
                UnitTestsHelper.getObjectFieldValue(testUpdateAttributeAction, "newVisibility"));
        assertEquals("UpdateAttributeAction executeAction incorrectly", newName,
                UnitTestsHelper.getObjectFieldValue(testUpdateAttributeAction, "newName"));
        assertEquals("UpdateAttributeAction executeAction incorrectly", newType,
                UnitTestsHelper.getObjectFieldValue(testUpdateAttributeAction, "newType"));
        assertEquals("UpdateAttributeAction executeAction incorrectly", newInitialValue,
                UnitTestsHelper.getObjectFieldValue(testUpdateAttributeAction, "newInitialValue"));
        assertEquals("UpdateAttributeAction executeAction incorrectly", newChangeability,
                UnitTestsHelper.getObjectFieldValue(testUpdateAttributeAction, "newChangeability"));
        assertEquals("UpdateAttributeAction executeAction incorrectly", newMultiplicity,
                UnitTestsHelper.getObjectFieldValue(testUpdateAttributeAction, "newMultiplicity"));
        assertEquals("UpdateAttributeAction executeAction incorrectly", newOwnerKind,
                UnitTestsHelper.getObjectFieldValue(testUpdateAttributeAction, "newOwnerKind"));
        assertEquals("UpdateAttributeAction executeAction incorrectly", newIsTransient,
            UnitTestsHelper.getObjectFieldValue(testUpdateAttributeAction, "newIsTransient"));
    }

    /**
     * Test UpdateAttributeAction constructor with null attribute.
     * Should throw IllegalArgumentException.
     */
    public void testUpdateAttributeActionNullAttribute() {
        try {
            new UpdateAttributeAction(null, newVisibility, newName, newType, newInitialValue,
                    newChangeability, newMultiplicity, newOwnerKind, newIsTransient);
            fail("IllegalArgumentException should be thrown when the passed attribute is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Test UpdateAttributeAction constructor with null name.
     * Should throw IllegalArgumentException.
     */
    public void testUpdateAttributeActionNullName() {
        try {
            new UpdateAttributeAction(attribute, newVisibility, null, newType, newInitialValue,
                    newChangeability, newMultiplicity, newOwnerKind, newIsTransient);
            fail("IllegalArgumentException should be thrown when the passed new name is null.");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
