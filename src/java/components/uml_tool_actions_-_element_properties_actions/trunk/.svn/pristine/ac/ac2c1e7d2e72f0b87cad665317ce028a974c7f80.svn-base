/*
 * Copyright (c) 2006, TopCoder, Inc. All rights reserved
 */
package com.topcoder.uml.actions.accuracytests;

import junit.framework.TestCase;

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

/**
 * Accuracy test cases for UpdateAttributeAction.
 *
 * @author justforplay
 * @version 1.0
 */
public class UpdateAttributeActionAccuracyTests extends TestCase {

    /**
     * Represents the UpdateAttributeAction instance used for tests.
     */
    private UpdateAttributeAction instance;

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
     * Represents the new owner kind (INSTANCE is for non-static, CLASSIFIER is for static) of the
     * attribute after this action performed.
     */
    private ScopeKind newOwnerKind;

    /**
     * Represents the old owner kind (INSTANCE is for non-static, CLASSIFIER is for static) of the
     * attribute before this action performed.
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
        AccuracyHelper.loadDefaultConfig();
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
        instance = new UpdateAttributeAction(attribute, newVisibility, newName, newType,
            newInitialValue, newChangeability, newMultiplicity, newOwnerKind, newIsTransient);
    }

    /**
     * Clear the environment.
     *
     * @throws Exception exception to JUnit.
     */
    protected void tearDown() throws Exception {
        AccuracyHelper.unloadConfig();
    }

    /**
     * Test undoAction().
     */
    public void testUndoAction() {
        instance.redoAction();
        instance.undoAction();
        assertEquals("undoAction() is incorrect.", oldVisibility, attribute.getVisibility());
        assertEquals("undoAction() is incorrect.", oldName, attribute.getName());
        assertEquals("undoAction() is incorrect.", oldType, attribute.getType());
        assertEquals("undoAction() is incorrect.", oldInitialValue, attribute.getInitialValue());
        assertEquals("undoAction() is incorrect.", oldChangeability, attribute.getChangeability());
        assertEquals("undoAction() is incorrect.", oldMultiplicity, attribute.getMultiplicity());
        assertEquals("undoAction() is incorrect.", oldOwnerKind, attribute.getOwnerScope());
        assertEquals("undoAction() is incorrect.", oldIsTransient, Boolean.parseBoolean(attribute
            .getTaggedValues().iterator().next().getDataValue()));
    }

    /**
     * Test redoAction().
     *
     * @throws Exception exception to JUnit.
     */
    public void testRedoAction() throws Exception {
        instance.executeAction();
        instance.redoAction();
        assertEquals("redoAction() is incorrect.", newVisibility, attribute.getVisibility());
        assertEquals("redoAction() is incorrect.", newName, attribute.getName());
        assertEquals("redoAction() is incorrect.", newType, attribute.getType());
        assertEquals("redoAction() is incorrect.", newInitialValue, attribute.getInitialValue());
        assertEquals("redoAction() is incorrect.", newChangeability, attribute.getChangeability());
        assertEquals("redoAction() is incorrect.", newMultiplicity, attribute.getMultiplicity());
        assertEquals("redoAction() is incorrect.", newOwnerKind, attribute.getOwnerScope());
        assertEquals("redoAction() is incorrect.", newIsTransient, Boolean.parseBoolean(attribute
            .getTaggedValues().iterator().next().getDataValue()));
    }

    /**
     * Test executeAction().
     */
    public void testExecuteAction() throws Exception {

        instance.executeAction();
        assertEquals("executeAction() is incorrect.", newVisibility, attribute.getVisibility());
        assertEquals("executeAction() is incorrect.", newName, attribute.getName());
        assertEquals("executeAction() is incorrect.", newType, attribute.getType());
        assertEquals("executeAction() is incorrect.", newInitialValue, attribute.getInitialValue());
        assertEquals("executeAction() is incorrect.", newChangeability, attribute
            .getChangeability());
        assertEquals("executeAction() is incorrect.", newMultiplicity, attribute.getMultiplicity());
        assertEquals("executeAction() is incorrect.", newOwnerKind, attribute.getOwnerScope());
        assertEquals("executeAction() is incorrect.", newIsTransient, Boolean
            .parseBoolean(attribute.getTaggedValues().iterator().next().getDataValue()));
    }

    /**
     * Test UpdateAttributeAction constructor.
     */
    public void testUpdateAttributeAction() {
        assertEquals("oldVisibility is incorrect.", oldVisibility, AccuracyHelper
            .getObjectFieldValue(instance, "oldVisibility"));
        assertEquals("newVisibility is incorrect.", newVisibility, AccuracyHelper
            .getObjectFieldValue(instance, "newVisibility"));
        assertEquals("oldName is incorrect.", oldName, AccuracyHelper.getObjectFieldValue(instance,
            "oldName"));
        assertEquals("newName is incorrect.", newName, AccuracyHelper.getObjectFieldValue(instance,
            "newName"));
        assertEquals("oldType is incorrect.", oldType, AccuracyHelper.getObjectFieldValue(instance,
            "oldType"));
        assertEquals("newType is incorrect.", newType, AccuracyHelper.getObjectFieldValue(instance,
            "newType"));
        assertEquals("oldInitialValue is incorrect.", oldInitialValue, AccuracyHelper
            .getObjectFieldValue(instance, "oldInitialValue"));
        assertEquals("newInitialValue is incorrect.", newInitialValue, AccuracyHelper
            .getObjectFieldValue(instance, "newInitialValue"));
        assertEquals("oldChangeability is incorrect.", oldChangeability, AccuracyHelper
            .getObjectFieldValue(instance, "oldChangeability"));
        assertEquals("newChangeability is incorrect.", newChangeability, AccuracyHelper
            .getObjectFieldValue(instance, "newChangeability"));
        assertEquals("oldMultiplicity is incorrect.", oldMultiplicity, AccuracyHelper
            .getObjectFieldValue(instance, "oldMultiplicity"));
        assertEquals("oldChangeability is incorrect.", oldChangeability, AccuracyHelper
            .getObjectFieldValue(instance, "oldChangeability"));
        assertEquals("newMultiplicity is incorrect.", newMultiplicity, AccuracyHelper
            .getObjectFieldValue(instance, "newMultiplicity"));
        assertEquals("oldOwnerKind is incorrect.", oldOwnerKind, AccuracyHelper
            .getObjectFieldValue(instance, "oldOwnerKind"));
        assertEquals("newOwnerKind is incorrect.", newOwnerKind, AccuracyHelper
            .getObjectFieldValue(instance, "newOwnerKind"));
        assertEquals("oldIsTransient is incorrect.", oldIsTransient, AccuracyHelper
            .getObjectFieldValue(instance, "oldIsTransient"));
        assertEquals("newIsTransient is incorrect.", newIsTransient, AccuracyHelper
            .getObjectFieldValue(instance, "newIsTransient"));

    }

}
