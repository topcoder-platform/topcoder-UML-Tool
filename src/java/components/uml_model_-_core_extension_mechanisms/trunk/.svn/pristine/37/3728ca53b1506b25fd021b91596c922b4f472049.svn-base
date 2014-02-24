/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.extensionmechanisms;

import java.util.ArrayList;
import java.util.Collection;

import com.topcoder.uml.model.core.MethodImpl;
import com.topcoder.uml.model.core.ModelElement;

import junit.framework.TestCase;

/**
 * <p>
 * Unit test cases for class TaggedValueImpl.
 * </p>
 *
 * @author BLE
 * @version 1.0
 */
public class TaggedValueImplTest extends TestCase {

    /**
     * <p>
     * This instance is used in the test.
     * </p>
     */
    private TaggedValueImpl tagged = null;

    /**
     * <p>
     * The dataValue of the TaggedValueImpl.
     * </p>
     */
    private String dataValue = "dataValue";

    /**
     * <p>
     * Empty dataValue of the TaggedValueImpl.
     * </p>
     */
    private String emptyDataValue = "dataValue";

    /**
     * <p>
     * Another dataValue of the TaggedValueImpl.
     * </p>
     */
    private String dataValue2 = "dataValue2";

    /**
     * <p>
     * The TagDefinition instance of the TaggedValueImpl.
     * </p>
     */
    private TagDefinition type = new TagDefinitionImpl();

    /**
     * <p>
     * The ModelElement instance of the TaggedValueImpl.
     * </p>
     */
    private ModelElement modelElement = new MethodImpl();

    /**
     * <p>
     * Represents a collection of ModelElement objects this tagged value
     * references.
     * </p>
     */
    private final Collection<ModelElement> referenceValues = new ArrayList<ModelElement>();

    /**
     * <p>
     * Sets up the environment for the TestCase.
     * </p>
     */
    protected void setUp() {
        tagged = new TaggedValueImpl(dataValue, type, modelElement, referenceValues);
    }

    /**
     * <p>
     * Accuracy test of the <code>TagDefinitionImpl()</code>. The instance is
     * created.
     * </p>
     */
    public void testTaggedValueImpl() {
        assertNotNull("The instance should be created.", new TagDefinitionImpl());
    }

    /**
     * <p>
     * Faliure test of the
     * <code>TaggedValueImpl(String dataValue, TagDefinition type, ModelElement modelElement,
     * Collection&lt;ModelElement&gt; referenceValues)</code>.
     * </p>
     * <p>
     * referenceValues is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     */
    public void testTaggedValueImplFailureNullReferenceValues() {
        try {
            new TaggedValueImpl(dataValue, type, modelElement, null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Faliure test of the
     * <code>TaggedValueImpl(String dataValue, TagDefinition type, ModelElement modelElement,
     * Collection&lt;ModelElement&gt; referenceValues)</code>.
     * </p>
     * <p>
     * referenceValues contains null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     */
    public void testTaggedValueImplFailure() {
        try {
            referenceValues.add(null);
            new TaggedValueImpl(dataValue, type, modelElement, referenceValues);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Accuracy test of the
     * <code>TagDefinitionImpl(String dataValue, TagDefinition type, ModelElement modelElement,
     * Collection&lt;ModelElement&gt; referenceValues)</code>.
     * The instance is created.
     * </p>
     */
    public void testTaggedValueImplAccuracyA() {
        assertNotNull("The instance should be created.",
                new TaggedValueImpl(null, type, modelElement, referenceValues));
    }

    /**
     * <p>
     * Accuracy test of the
     * <code>TagDefinitionImpl(String dataValue, TagDefinition type, ModelElement modelElement,
     * Collection&lt;ModelElement&gt; referenceValues)</code>.
     * The instance is created.
     * </p>
     */
    public void testTaggedValueImplAccuracyB() {
        assertNotNull("The instance should be created.", new TaggedValueImpl(emptyDataValue, type, modelElement,
                referenceValues));
    }

    /**
     * <p>
     * Accuracy test of the
     * <code>TagDefinitionImpl(String dataValue, TagDefinition type, ModelElement modelElement,
     * Collection&lt;ModelElement&gt; referenceValues)</code>.
     * The instance is created.
     * </p>
     */
    public void testTaggedValueImplAccuracyC() {
        assertNotNull("The instance should be created.", new TaggedValueImpl(emptyDataValue, type, null,
                referenceValues));
    }

    /**
     * <p>
     * Accuracy test of the
     * <code>TagDefinitionImpl(String dataValue, TagDefinition type, ModelElement modelElement,
     * Collection&lt;ModelElement&gt; referenceValues)</code>.
     * The instance is created.
     * </p>
     */
    public void testTaggedValueImplAccuracyD() {
        assertNotNull("The instance should be created.", new TaggedValueImpl(dataValue, type, null, referenceValues));
    }

    /**
     * <p>
     * Accuracy test of the <code>getDataValue()</code>.
     * </p>
     */
    public void testGetDataValue() {
        assertEquals("getDataValue is incorrect", dataValue, tagged.getDataValue());
    }

    /**
     * <p>
     * Accuracy test of the <code>setDataValue(String)</code>.
     * </p>
     */
    public void testSetDataValueAccuracyA() {
        tagged.setDataValue(null);
        assertNull("setDataValue is incorrect", tagged.getDataValue());
    }

    /**
     * <p>
     * Accuracy test of the <code>setDataValue(String dataValue)</code>.
     * </p>
     */
    public void testSetDataValueAccuracyB() {
        tagged.setDataValue(emptyDataValue);
        assertEquals("setDataValue is incorrect", emptyDataValue, tagged.getDataValue());
    }

    /**
     * <p>
     * Accuracy test of the <code>setDataValue(String dataValue)</code>.
     * </p>
     */
    public void testSetDataValueAccuracyC() {
        tagged.setDataValue(dataValue2);
        assertEquals("setDataValue is incorrect", dataValue2, tagged.getDataValue());
    }

    /**
     * <p>
     * Accuracy test of the <code>getType()</code>.
     * </p>
     */
    public void testGetType() {
        assertEquals("getType is incorrect", type, tagged.getType());
    }

    /**
     * <p>
     * Accuracy test of the <code>setType(TagDefinition type)</code>.
     * </p>
     */
    public void testSetTypeAccuracyA() {
        tagged.setType(null);
        assertNull("setType is incorrect", tagged.getType());
    }

    /**
     * <p>
     * Accuracy test of the <code>setType(TagDefinition type)</code>.
     * </p>
     */
    public void testSetTypeAccuracyB() {
        TagDefinition tag = new TagDefinitionImpl();
        tagged.setType(tag);
        assertEquals("setType is incorrect", tag, tagged.getType());
    }

    /**
     * <p>
     * Accuracy test of the <code>getModelElement()</code>.
     * </p>
     */
    public void testGetModelElement() {
        assertEquals("getModelElement is incorrect", modelElement, tagged.getModelElement());
    }

    /**
     * <p>
     * Accuracy test of the <code>setModelElement(ModelElement element)</code>.
     * </p>
     */
    public void testSetModelElementAccuracyA() {
        tagged.setModelElement(null);
        assertNull("setModelElement is incorrect", tagged.getModelElement());
    }

    /**
     * <p>
     * Accuracy test of the <code>setModelElement(ModelElement element)</code>.
     * </p>
     */
    public void testSetModelElementAccuracyB() {
        ModelElement element = new MethodImpl();
        tagged.setModelElement(element);
        assertEquals("setModelElement is incorrect", element, tagged.getModelElement());
    }

    /**
     * <p>
     * Faliure test of the <code>addReferenceValue(ModelElement value)</code>.
     * </p>
     * <p>
     * value is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     */
    public void testAddReferenceValueFailureNullModelElement() {
        try {
            tagged.addReferenceValue(null);
            fail("Expect IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Accuracy test of the <code>addReferenceValue(ModelElement value)</code>.
     * </p>
     */
    public void testAddReferenceValueAccuracy() {
        assertEquals("countReferenceValues is incorrect", 0, tagged.countReferenceValues());
        tagged.addReferenceValue(modelElement);
        assertEquals("addReferenceValue is incorrect", 1, tagged.countReferenceValues());
    }

    /**
     * <p>
     * Faliure test of the <code>removeReferenceValue(ModelElement value)</code>.
     * </p>
     * <p>
     * value is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     */
    public void testRemoveReferenceValueFailureNullModelElement() {
        try {
            tagged.removeReferenceValue(null);
            fail("Expect IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Accuracy test of the
     * <code>removeReferenceValue(ModelElement value)</code>.
     * </p>
     */
    public void testRemoveReferenceValueAccuracy() {
        assertEquals("countReferenceValues is incorrect", 0, tagged.countReferenceValues());
        tagged.addReferenceValue(modelElement);
        tagged.addReferenceValue(modelElement);
        assertEquals("addReferenceValue is incorrect", 2, tagged.countReferenceValues());

        // Only one reference should be removed
        assertTrue("removeReferenceValue is incorrect", tagged.removeReferenceValue(modelElement));
        assertEquals("addReferenceValue is incorrect", 1, tagged.countReferenceValues());
        assertTrue("removeReferenceValue is incorrect", tagged.removeReferenceValue(modelElement));
        assertEquals("addReferenceValue is incorrect", 0, tagged.countReferenceValues());

        // No element is removed
        assertFalse("removeReferenceValue is incorrect", tagged.removeReferenceValue(modelElement));
    }

    /**
     * <p>
     * Accuracy test of the <code>clearReferenceValues()</code>.
     * </p>
     */
    public void testClearReferenceValues() {
        assertEquals("countReferenceValues is incorrect", 0, tagged.countReferenceValues());
        tagged.addReferenceValue(modelElement);
        tagged.addReferenceValue(modelElement);
        assertEquals("addReferenceValue is incorrect", 2, tagged.countReferenceValues());
        tagged.clearReferenceValues();
        assertEquals("clearReferenceValues is incorrect", 0, tagged.countReferenceValues());
    }

    /**
     * <p>
     * Accuracy test of the <code>getReferenceValues()</code>.
     * </p>
     */
    public void testGetReferenceValuesAccuracy() {
        tagged.addReferenceValue(modelElement);
        tagged.addReferenceValue(modelElement);
        Collection<ModelElement> elements = tagged.getReferenceValues();
        assertEquals("getReferenceValues is incorrect", 2, elements.size());
        assertTrue("getReferenceValues is incorrect", elements.contains(modelElement));
    }

    /**
     * <p>
     * Failure test of the <code>getReferenceValues()</code>. The
     * modifictaion of the returned Collection will result in
     * UnsupportedOperationException.
     * </p>
     */
    public void testGetReferenceValues() {
        tagged.addReferenceValue(modelElement);
        tagged.addReferenceValue(modelElement);
        try {
            tagged.getReferenceValues().clear();
            fail("Expect UnsupportedOperationException.");
        } catch (UnsupportedOperationException e) {
            // expect
        }
    }

    /**
     * <p>
     * Failure test of the
     * <code>containsReferenceValue(ModelElement value)</code>.
     * </p>
     * <p>
     * value is null.
     * </p>
     * <p>
     * Expect IllegalArgumentException.
     * </p>
     */
    public void testContainsReferenceValueFailure() {
        try {
            tagged.containsReferenceValue(null);
            fail("Expect IllegalArgumentException.");
        } catch (IllegalArgumentException e) {
            // expect
        }
    }

    /**
     * <p>
     * Accuracy test of the
     * <code>containsReferenceValue(ModelElement value)</code>.
     * </p>
     */
    public void testContainsReferenceValueAccuracy() {
        assertFalse("containsReferenceValue is incorrect", tagged.containsReferenceValue(modelElement));
        tagged.addReferenceValue(modelElement);
        assertTrue("containsReferenceValue is incorrect", tagged.containsReferenceValue(modelElement));
    }

    /**
     * <p>
     * Accuracy test of the <code>countReferenceValues()</code>.
     * </p>
     */
    public void testCountReferenceValues() {
        assertEquals("countReferenceValues is incorrect", 0, tagged.countReferenceValues());
        tagged.addReferenceValue(modelElement);
        tagged.addReferenceValue(modelElement);
        assertEquals("countReferenceValues is incorrect", 2, tagged.countReferenceValues());
        tagged.clearReferenceValues();
        assertEquals("countReferenceValues is incorrect", 0, tagged.countReferenceValues());
    }
}
