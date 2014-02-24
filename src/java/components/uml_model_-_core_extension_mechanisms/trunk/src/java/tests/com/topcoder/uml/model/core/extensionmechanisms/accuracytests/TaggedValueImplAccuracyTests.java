/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.extensionmechanisms.accuracytests;

import java.util.ArrayList;

import junit.framework.TestCase;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinitionImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;

/**
 * The accuracy test of the class aggedValueImpl.
 *
 * @author haozhangr
 * @version 1.0
 */
public class TaggedValueImplAccuracyTests extends TestCase {
    /**
     * The TagDefinition instance for the test.
     *
     */
    private TagDefinition type;

    /**
     * The ModelElement instance for test.
     *
     */
    private ModelElement modelElement;

    /**
     * The TaggedValueImpl instance for accuracy test.
     */
    private TaggedValueImpl instance = null;

    /**
     * <p>
     * setUp() routine. Creates test TaggedValueImpl instance using
     * <code>TaggedValueImpl()</code>.
     * </p>
     */
    protected void setUp() {
        type = new TagDefinitionImpl();
        modelElement = new StereotypeImpl();
        instance = new TaggedValueImpl();
    }

    /**
     * The accuracy test of the default constructor.
     *
     */
    public void test_ctor_accuracy1() {
        assertNotNull("Can not create the TaggedValueImpl.", instance);
    }
    /**
     * The accuracy test of the constructor of parameters.
     *
     */
    public void test_ctor_accuracy2() {
        assertNotNull("Can not create the TaggedValueImpl.",
                new TaggedValueImpl("data", type, modelElement, new ArrayList<ModelElement>()));
    }

    /**
     * The accuracy test of the setter and getter of dataValue.
     *
     */
    public void test_setDataValueAndGetDataValue_accuracy() {
        instance.setDataValue("new dataValue");
        assertEquals("DataValue is not set properly.", "new dataValue", instance.getDataValue());
    }

    /**
     * The accuracy test of the setter and getter of dataValue.
     *
     */
    public void test_setTypeAndGetType_accuracy() {
        instance.setType(type);
        assertTrue("The 'Type' is not set properly.", type == instance.getType());
    }

    /**
     * The accuracy test of the setter and getter of modelElement.
     *
     */
    public void testGetModelElement_1_accuracy() {
        instance.setModelElement(modelElement);
        assertTrue("'ModelElement' got incorrectly", modelElement == instance.getModelElement());
    }

    /**
     * The accuracy test of the method addReferenceValue.
     *
     */
    public void test_addReferenceValue_accuracy() {
        instance.addReferenceValue(modelElement);
        assertTrue("The ReferenceValue is not added properly.", instance.containsReferenceValue(modelElement));
    }
    /**
     * The accuracy test of the method removeReferenceValue.
     *
     */
    public void test_removeReferenceValue_accuracy() {
        instance.addReferenceValue(modelElement);
        assertTrue("The ReferenceValue is not added properly.", instance.containsReferenceValue(modelElement));

        instance.removeReferenceValue(modelElement);
        assertFalse("The element is not removed properly.", instance.containsReferenceValue(modelElement));
    }
    /**
     * The accuracy test of the method clearReferenceValues.
     *
     */
    public void test_clearReferenceValues_accuracy() {
        instance.addReferenceValue(modelElement);
        assertTrue("The ReferenceValue is not added properly.", instance.containsReferenceValue(modelElement));

        instance.clearReferenceValues();
        assertFalse("The ReferenceValue is not removed properly.", instance.containsReferenceValue(modelElement));
    }
    /**
     * The accuracy test of the method getReferenceValues.
     *
     */
    public void test_getReferenceValues_accuracy() {
        instance.addReferenceValue(modelElement);
        assertEquals("ReferenceValue got incorrectly", 1, instance.getReferenceValues().size());
    }
    /**
     * The accuracy test of the method containsReferenceValue.
     *
     */
    public void test_containsReferenceValue_accuracy() {
        instance.addReferenceValue(modelElement);
        assertTrue("The ReferenceValue is not added properly.", instance.containsReferenceValue(modelElement));
    }
    /**
     * The accuracy test of the method countReferenceValues.
     *
     */
    public void test_countReferenceValues_accuracy() {
        instance.addReferenceValue(modelElement);
        assertEquals("The ReferenceValue is not added properly.", 1, instance.countReferenceValues());
    }
}
