/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.extensionmechanisms.accuracytests;

import java.util.ArrayList;

import junit.framework.TestCase;

import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinitionImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;
import com.topcoder.uml.model.datatypes.Multiplicity;
import com.topcoder.uml.model.datatypes.MultiplicityImpl;

/**
 * The accuracy test of the class TagDefinitionImpl.
 *
 * @author haozhangr
 * @version 1.0
 */
public class TagDefinitionImplAccuracyTests extends TestCase {
    /**
     * The Stereotype instance, which is the owner of the Tag that is testing for.
     *
     */
    private Stereotype owner;
    /**
     * The multiplicity instance.
     *
     */
    private Multiplicity multiplicity;

    /**
     * The TaggedValue instance used in tests.
     *
     */
    private TaggedValue typedValue;

    /**
     * The instance for accuracy testing.
     */
    private TagDefinitionImpl instance = null;

    /**
     * The setup of the accuracy test, create the instance for test.
     */
    protected void setUp() {
        multiplicity = new MultiplicityImpl();
        owner = new StereotypeImpl();
        typedValue = new TaggedValueImpl();
        instance = new TagDefinitionImpl();
    }

    /**
     * The accuracy test of the default constructor.
     *
     */
    public void test_ctor_accuracy1() {
        assertNotNull("Can not create the TagDefinitionImpl.", instance);
    }
    /**
     * The accuracy test of the constructor of parameters.
     *
     */
    public void test_ctor_accuracy2() {
        assertNotNull("Can not create the TagDefinitionImpl.", new TagDefinitionImpl("type",
                multiplicity, owner, new ArrayList<TaggedValue>()));
    }

    /**
     * The accuracy test of the getter and setter of Tag type.
     *
     */
    public void testGetTagType_1_accuracy() {
        instance.setTagType("tagtype");
        assertEquals("The type is not set properly.", "tagtype", instance.getTagType());
    }

    /**
     * The accuracy test of the setter and getter of multiplicity.
     *
     */
    public void testGetMultiplicity_1_accuracy() {
        instance.setMultiplicity(multiplicity);
        assertTrue("The multiplicity is not set properly.", multiplicity == instance.getMultiplicity());
    }

    /**
     * The accuracy of the setter and getter of owner.
     *
     */
    public void testGetOwner_1_accuracy() {
        instance.setOwner(owner);
        assertTrue("Owner is not set properly.", owner == instance.getOwner());
    }

    /**
     * The accuracy test of the method addTypedValue.
     *
     */
    public void test_addTypedValue_accuracy() {
        instance.addTypedValue(typedValue);
        assertTrue("The TypedValue is not added properly.", instance.containsTypedValue(typedValue));
    }
    /**
     * The accuracy test of the method removeTypedValue.
     *
     */
    public void test_removeTypedValue_accuracy() {
        instance.addTypedValue(typedValue);
        assertTrue("The TypedValue is not added properly.", instance.containsTypedValue(typedValue));

        instance.removeTypedValue(typedValue);
        assertFalse("The element is not removed properly.", instance.containsTypedValue(typedValue));
    }
    /**
     * The accuracy test of the method clearTypedValues.
     *
     */
    public void test_clearTypedValues_accuracy() {
        instance.addTypedValue(typedValue);
        assertTrue("The TypedValue is not added properly.", instance.containsTypedValue(typedValue));

        instance.clearTypedValues();
        assertFalse("The TypedValue is not removed properly.", instance.containsTypedValue(typedValue));
    }
    /**
     * The accuracy test of the method getTypedValues.
     *
     */
    public void test_getTypedValues_accuracy() {
        instance.addTypedValue(typedValue);
        assertEquals("TypedValue got incorrectly", 1, instance.getTypedValues().size());
    }
    /**
     * The accuracy test of the method containsTypedValue.
     *
     */
    public void test_containsTypedValue_accuracy() {
        instance.addTypedValue(typedValue);
        assertTrue("The TypedValue is not added properly.", instance.containsTypedValue(typedValue));
    }
    /**
     * The accuracy test of the method countTypedValues.
     *
     */
    public void test_countTypedValues_accuracy() {
        instance.addTypedValue(typedValue);
        assertEquals("The TypedValue is not added properly.", 1, instance.countTypedValues());
    }
}
