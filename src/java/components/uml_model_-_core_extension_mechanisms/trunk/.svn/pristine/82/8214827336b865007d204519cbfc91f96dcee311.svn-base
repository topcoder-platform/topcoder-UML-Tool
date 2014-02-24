/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.extensionmechanisms.stresstests;

import com.topcoder.uml.model.core.extensionmechanisms.TagDefinitionImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValueImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Stress test case for TagDefinitionImpl.
 * </p>
 *
 * @author justforplay
 * @version 1.0
 */
public class TagDefinitionImplStressTest extends TestCase {

    /**
     * time to repeat.
     */
    private static final int ITERATE_TIME = 20000;

    /**
     * <p>
     * Repeat the many functions many times. The main functions include addTypedValue, containsTypedValue,
     * removeTypedValue, clearTypedValues and countTypedValues.
     * </P>
     */
    public void testFunctionsManyTimes() {
        TagDefinitionImpl tagDef = new TagDefinitionImpl();

        TaggedValue valueArr[] = new TaggedValue[ITERATE_TIME];

        // Initialize many instances of TaggedValue.
        for (int i = 0; i < ITERATE_TIME; i++) {
            valueArr[i] = new TaggedValueImpl();
        }

        // test addTypedValue many times.
        for (int i = 0; i < ITERATE_TIME; i++) {
            tagDef.addTypedValue(valueArr[i]);
        }

        // test addTypedValue many times.
        for (int i = 0; i < ITERATE_TIME; i++) {
            tagDef.addTypedValue(valueArr[0]);
        }

        // Verify whether the result of addTypedValue is correct.
        for (int i = 0; i < ITERATE_TIME; i++) {
            assertTrue("The addTypedValue() or containsTypedValue() is incorrect.", tagDef
                .containsTypedValue(valueArr[i]));
        }

        // Verify whether the result of addTypedValue is correct.
        for (int i = 0; i < ITERATE_TIME; i++) {
            assertEquals("The addTypedValue() is incorrect.", tagDef, valueArr[i].getType());
        }

        // test removeTypedValue many times.
        for (int i = 0; i < ITERATE_TIME; i++) {
            assertTrue("The addTypedValue() or removeTypedValue() is incorrect.", tagDef
                .removeTypedValue(valueArr[i]));
        }

        // Verify whether the result of removeTypedValue is correct.
        for (int i = 1; i < ITERATE_TIME; i++) {
            assertFalse("The removeTypedValue() or containsTypedValue() is incorrect.", tagDef
                .containsTypedValue(valueArr[i]));
        }

        // Verify whether the result of removeTypedValue is correct.
        assertTrue("The addDefinedTag() or containsDefinedTag() is incorrect.", tagDef
            .containsTypedValue(valueArr[0]));

        // test removeTypedValue many times.
        for (int i = 0; i < ITERATE_TIME - 1; i++) {
            assertTrue("The addTypedValue() or removeTypedValue() is incorrect.", tagDef
                .removeTypedValue(valueArr[0]));
        }

        // Verify whether the result of removeTypedValue is correct.
        assertTrue("The addDefinedTag() or containsDefinedTag() is incorrect.", tagDef
            .containsTypedValue(valueArr[0]));

        tagDef.clearTypedValues();

        assertEquals("The clearTypedValues() or countTypedValues() is incorrect.", 0, tagDef
            .countTypedValues());
    }
}
