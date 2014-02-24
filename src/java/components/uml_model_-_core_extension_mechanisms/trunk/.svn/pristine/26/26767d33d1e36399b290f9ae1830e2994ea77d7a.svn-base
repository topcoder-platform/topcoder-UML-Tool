/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.extensionmechanisms.stresstests;

import com.topcoder.uml.model.core.ModelElement;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinitionImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Stress test case for TaggedValueImpl.
 * </p>
 *
 * @author justforplay
 * @version 1.0
 */
public class TagValueImplStressTest extends TestCase {

    /**
     * time to repeat.
     */
    private static final int ITERATE_TIME = 20000;

    public void testFunctionsManyTimes() {

        TaggedValueImpl tagValue = new TaggedValueImpl();

        ModelElement valueArr[] = new ModelElement[ITERATE_TIME];

        // Initialize many instances of ModelElement.
        for (int i = 0; i < ITERATE_TIME; i++) {
            valueArr[i] = new TagDefinitionImpl();
        }

        // test addReferenceValue many times.
        for (int i = 0; i < ITERATE_TIME; i++) {
            tagValue.addReferenceValue(valueArr[i]);
        }

        // test addReferenceValue many times.
        for (int i = 0; i < ITERATE_TIME; i++) {
            tagValue.addReferenceValue(valueArr[0]);
        }

        // Verify whether the result of addReferenceValue is correct.
        for (int i = 0; i < ITERATE_TIME; i++) {
            assertTrue("The addReferenceValue() or containsReferenceValue() is incorrect.", tagValue
                .containsReferenceValue(valueArr[i]));
        }

        // test removeReferenceValue many times.
        for (int i = 0; i < ITERATE_TIME; i++) {
            assertTrue("The addReferenceValue() or removeReferenceValue() is incorrect.", tagValue
                .removeReferenceValue(valueArr[i]));
        }

        // Verify whether the result of removeReferenceValue is correct.
        for (int i = 1; i < ITERATE_TIME; i++) {
            assertFalse("The removeReferenceValue() or containsReferenceValue() is incorrect.", tagValue
                .containsReferenceValue(valueArr[i]));
        }

        // Verify whether the result of removeReferenceValue is correct.
        assertTrue("The addReferenceValue() or containsReferenceValue() is incorrect.", tagValue
            .containsReferenceValue(valueArr[0]));

        // test removeReferenceValue many times.
        for (int i = 0; i < ITERATE_TIME - 1; i++) {
            assertTrue("The addReferenceValue() or removeReferenceValue() is incorrect.", tagValue
                .removeReferenceValue(valueArr[0]));
        }

        // Verify whether the result of removeReferenceValue is correct.
        assertTrue("The addReferenceValue() or containsReferenceValue() is incorrect.", tagValue
            .containsReferenceValue(valueArr[0]));

        tagValue.clearReferenceValues();

        assertEquals("The clearReferenceValues() or countReferenceValues() is incorrect.", 0, tagValue
            .countReferenceValues());

    }

}
