/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.extensionmechanisms;

import java.util.ArrayList;
import java.util.Collection;

import com.topcoder.uml.model.datatypes.Multiplicity;
import com.topcoder.uml.model.datatypes.MultiplicityImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class TagDefinitionImpl.
 * </p>
 *
 * @author BLE
 * @version 1.0
 */
public class TagDefinitionImplTest extends TestCase {

    /**
     * <p>
     * This instance is used in the test.
     * </p>
     */
    private TagDefinitionImpl tag = null;

    /**
     * <p>
     * The tagType of the TagDefinitionImpl.
     * </p>
     */
    private String tagType = "tagType";

    /**
     * <p>
     * Empty tagType of the TagDefinitionImpl.
     * </p>
     */
    private String emptyTagType = " ";

    /**
     * <p>
     * Another tagType of the TagDefinitionImpl.
     * </p>
     */
    private String tagType2 = "tagType2";

    /**
     * <p>
     * The Stereotype instance used in the test.
     * </p>
     */
    private Stereotype owner = new StereotypeImpl();

    /**
     * <p>
     * The Multiplicity instance used in the test.
     * </p>
     */
    private Multiplicity multiplicity = new MultiplicityImpl();

    /**
     * <p>
     * The TaggedValue instance used in the test.
     * </p>
     */
    private TaggedValue tagged = new TaggedValueImpl();

    /**
     * <p>
     * The TaggedValue Collection used in the test.
     * </p>
     */
    private Collection<TaggedValue> typedValues = new ArrayList<TaggedValue>();

    /**
     * <p>
     * Sets up the environment for the TestCase.
     * </p>
     */
    protected void setUp() {
        tag = new TagDefinitionImpl(tagType, multiplicity, owner, typedValues);
    }

    /**
     * <p>
     * Accuracy test of the <code>TagDefinitionImpl()</code>. The instance is
     * created.
     * </p>
     */
    public void testTagDefinitionImpl() {
        assertNotNull("The instance should be created.", new TagDefinitionImpl());
    }

    /**
     * <p>
     * Failure test of
     * <code>TagDefinitionImpl(String tagType, Multiplicity multiplicity, Stereotype owner,
     * Collection&lt;TaggedValue&gt; typedValues)</code>.
     * </p>
     * <p>
     * typedValues is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     */
    public void testTagDefinitionImpl2FailureNullTaggedValue() {
        try {
            new TagDefinitionImpl(tagType, multiplicity, owner, null);
            fail("TagDefinitionImpl(String, Multiplicity, Stereotype, Collection<TaggedValue>) is incorrect");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of
     * <code>TagDefinitionImpl(String tagType, Multiplicity multiplicity, Stereotype owner,
     * Collection&lt;TaggedValue&gt; typedValues)</code>.
     * </p>
     * <p>
     * typedValues contains null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     */
    public void testTagDefinitionImpl2FailureNullTaggedValueEntires() {
        try {
            typedValues.add(null);
            new TagDefinitionImpl(tagType, multiplicity, owner, typedValues);
            fail("TagDefinitionImpl(String, Multiplicity, Stereotype, Collection<TaggedValue>) is incorrect");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Accuracy Test of
     * <code>TagDefinitionImpl(String tagType, Multiplicity multiplicity, Stereotype owner,
     * Collection&lt;TaggedValue&gt; typedValues)</code>.
     * </p>
     */
    public void testTagDefinitionImpl2AccuracyA() {
        assertNotNull("TagDefinitionImpl(String, Multiplicity, Stereotype, Collection<TaggedValue>) is incorrect",
                new TagDefinitionImpl(null, multiplicity, owner, typedValues));
    }

    /**
     * <p>
     * Accuracy Test of
     * <code>TagDefinitionImpl(String tagType, Multiplicity multiplicity, Stereotype owner,
     * Collection&lt;TaggedValue&gt; typedValues)</code>.
     * </p>
     */
    public void testTagDefinitionImpl2AccuracyB() {
        assertNotNull("TagDefinitionImpl(String, Multiplicity, Stereotype, Collection<TaggedValue>) is incorrect",
                new TagDefinitionImpl(emptyTagType, multiplicity, owner, typedValues));
    }

    /**
     * <p>
     * Accuracy Test of
     * <code>TagDefinitionImpl(String tagType, Multiplicity multiplicity, Stereotype owner,
     * Collection&lt;TaggedValue&gt; typedValues)</code>.
     * </p>
     */
    public void testTagDefinitionImpl2AccuracyC() {
        assertNotNull("TagDefinitionImpl(String, Multiplicity, Stereotype, Collection<TaggedValue>) is incorrect",
                new TagDefinitionImpl(tagType, null, owner, typedValues));
    }

    /**
     * <p>
     * Accuracy Test of
     * <code>TagDefinitionImpl(String tagType, Multiplicity multiplicity, Stereotype owner,
     * Collection&lt;TaggedValue&gt; typedValues)</code>.
     * </p>
     */
    public void testTagDefinitionImpl2AccuracyD() {
        assertNotNull("TagDefinitionImpl(String, Multiplicity, Stereotype, Collection<TaggedValue>) is incorrect",
                new TagDefinitionImpl(tagType, multiplicity, null, typedValues));
    }

    /**
     * <p>
     * Accuracy Test of <code>getTagType()</code>.
     * </p>
     */
    public void testGetTagType() {
        assertEquals("getTagType is incorrect", tagType, tag.getTagType());
    }

    /**
     * <p>
     * Accuracy Test of <code>setTagType(String tagType)</code>.
     * </p>
     */
    public void testSetTagTypeAccuracyA() {
        tag.setTagType(null);
        assertNull("setTagType is incorrect", tag.getTagType());
    }

    /**
     * <p>
     * Accuracy Test of <code>setTagType(String tagType)</code>.
     * </p>
     */
    public void testSetTagTypeAccuracyB() {
        tag.setTagType(emptyTagType);
        assertEquals("setTagType is incorrect", emptyTagType, tag.getTagType());
    }

    /**
     * <p>
     * Accuracy Test of <code>setTagType(String tagType)</code>.
     * </p>
     */
    public void testSetTagTypeAccuracyC() {
        tag.setTagType(tagType2);
        assertEquals("setTagType is incorrect", tagType2, tag.getTagType());
    }

    /**
     * <p>
     * Accuracy Test of <code>getMultiplicity()</code>.
     * </p>
     */
    public void testGetMultiplicity() {
        assertEquals("getMultiplicity is incorrect", multiplicity, tag.getMultiplicity());
    }

    /**
     * <p>
     * Accuracy Test of <code>setMultiplicity(Multiplicity multiplicity)</code>.
     * </p>
     */
    public void testSetMultiplicityAccuracyA() {
        tag.setMultiplicity(null);
        assertNull("setMultiplicity is incorrect", tag.getMultiplicity());
    }

    /**
     * <p>
     * Accuracy Test of <code>setMultiplicity(Multiplicity multiplicity)</code>.
     * </p>
     */
    public void testSetMultiplicityAccuracyB() {
        Multiplicity mul = new MultiplicityImpl();
        tag.setMultiplicity(mul);
        assertEquals("getMultiplicity is incorrect", mul, tag.getMultiplicity());
    }

    /**
     * <p>
     * Accuracy Test of <code>getOwner()</code>.
     * </p>
     */
    public void testGetOwner() {
        assertEquals("getOwner is incorrect", owner, tag.getOwner());
    }

    /**
     * <p>
     * Accuracy Test of <code>setOwner(Stereotype owner)</code>.
     * </p>
     */
    public void testSetOwnerAccuracyA() {
        tag.setOwner(null);
        assertNull("setOwner is incorrect", tag.getOwner());
    }

    /**
     * <p>
     * Accuracy Test of <code>setOwner(Stereotype owner)</code>.
     * </p>
     */
    public void testSetOwnerAccuracyB() {
        Stereotype owner2 = new StereotypeImpl();
        tag.setOwner(owner2);
        assertEquals("setOwner is incorrect", owner2, tag.getOwner());
    }

    /**
     * <p>
     * Failure test of <code>addTypedValue(TaggedValue typedValue)</code>.
     * </p>
     * <p>
     * typedValue is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     */
    public void testAddTypedValueFailure() {
        try {
            tag.addTypedValue(null);
            fail("expect IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Accuracy Test of <code>addTypedValue(TaggedValue typedValue)</code>.
     * </p>
     */
    public void testAddTypedValue() {
        assertFalse("containsTypedValue is incorrect", tag.containsTypedValue(tagged));
        tag.addTypedValue(tagged);
        assertTrue("addTypedValue is incorrect", tag.containsTypedValue(tagged));
        assertEquals("addTypedValue is incorrect", tag, tagged.getType());
        assertEquals("addTypedValue is incorrect", 1, tag.countTypedValues());

        // Duplication is allowed
        tag.addTypedValue(tagged);
        assertTrue("addTypedValue is incorrect", tag.containsTypedValue(tagged));
        assertEquals("addTypedValue is incorrect", tag, tagged.getType());
        assertEquals("addTypedValue is incorrect", 2, tag.countTypedValues());
    }

    /**
     * <p>
     * Failure test of <code>removeTypedValue(TaggedValue typedValue)</code>.
     * </p>
     * <p>
     * typedValue is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     */
    public void testRemoveTypedValueFailure() {
        try {
            tag.removeTypedValue(null);
            fail("expect IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Accuracy Test of <code>removeTypedValue(TaggedValue typedValue)</code>.
     * </p>
     */
    public void testRemoveTypedValueAccuracyA() {
        tag.addTypedValue(tagged);
        assertTrue("addTypedValue is incorrect", tag.containsTypedValue(tagged));
        assertTrue("removeTypedValue is incorrect", tag.removeTypedValue(tagged));
        assertFalse("removeTypedValue is incorrect", tag.containsTypedValue(tagged));
        assertNull("removeTypedValue is incorrect", tagged.getType());
    }

    /**
     * <p>
     * Accuracy Test of <code>removeTypedValue(TaggedValue typedValue)</code>.
     * </p>
     */
    public void testRemoveTypedValueAccuracyB() {
        TaggedValue tagged2 = new TaggedValueImpl();
        TagDefinition def2 = new TagDefinitionImpl();
        def2.addTypedValue(tagged2);

        assertFalse("removeTypedValue is incorrect", tag.removeTypedValue(tagged2));
        assertEquals("removeTypedValue is incorrect", def2, tagged2.getType());
    }

    /**
     * <p>
     * Accuracy Test of <code>clearTypedValues(TaggedValue typedValue)</code>.
     * </p>
     */
    public void testClearTypedValues() {
        tag.addTypedValue(tagged);
        tag.addTypedValue(tagged);
        assertEquals("clearTypedValues is incorrect", 2, tag.countTypedValues());
        tag.clearTypedValues();
        assertEquals("clearTypedValues is incorrect", 0, tag.countTypedValues());
    }

    /**
     * <p>
     * Failure test of the <code>getTypedValues()</code>. The modifictaion of
     * the returned Collection will result in UnsupportedOperationException.
     * </p>
     */
    public void testGetExtendedElementsFailure() {
        tag.addTypedValue(tagged);
        tag.addTypedValue(tagged);
        try {
            tag.getTypedValues().clear();
            fail("Expect UnsupportedOperationException.");
        } catch (UnsupportedOperationException e) {
            // expect
        }
    }

    /**
     * <p>
     * Accuracy Test of <code>getTypedValues()</code>.
     * </p>
     */
    public void testGetTypedValuesAccuracyA() {
        assertEquals("getTypedValues is incorrect", 0, tag.getTypedValues().size());
    }

    /**
     * <p>
     * Accuracy Test of <code>getTypedValues()</code>.
     * </p>
     */
    public void testGetTypedValuesAccuracyB() {
        tag.addTypedValue(tagged);
        tag.addTypedValue(tagged);
        assertEquals("clearTypedValues is incorrect", 2, tag.countTypedValues());
        assertTrue("getTypedValues is incorrect", tag.getTypedValues().contains(tagged));
    }

    /**
     * <p>
     * Accuracy Test of <code>containsTypedValue(TaggedValue typedValue)</code>.
     * </p>
     */
    public void testContainsTypedValueAccuracy() {
        assertFalse("containsTypedValue is incorrect", tag.containsTypedValue(tagged));
        tag.addTypedValue(tagged);
        assertTrue("containsTypedValue is incorrect", tag.containsTypedValue(tagged));
    }

    /**
     * <p>
     * Failure test of <code>containsTypedValue(TaggedValue typedValue)</code>.
     * </p>
     * <p>
     * typedValue is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     */
    public void testContainsTypedValueFailure() {
        try {
            tag.containsTypedValue(null);
            fail("Expect IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Accuracy Test of <code>countTypedValues()</code>.
     * </p>
     */
    public void testCountTypedValues() {
        assertEquals("countTypedValues is incorrect", 0, tag.countTypedValues());
        tag.addTypedValue(tagged);
        tag.addTypedValue(tagged);
        assertEquals("countTypedValues is incorrect", 2, tag.countTypedValues());
        tag.clearTypedValues();
        assertEquals("countTypedValues is incorrect", 0, tag.countTypedValues());
    }

}
