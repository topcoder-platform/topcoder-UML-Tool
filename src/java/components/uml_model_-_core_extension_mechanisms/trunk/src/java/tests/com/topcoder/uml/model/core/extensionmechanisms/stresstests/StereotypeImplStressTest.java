/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.model.core.extensionmechanisms.stresstests;

import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinition;
import com.topcoder.uml.model.core.extensionmechanisms.TagDefinitionImpl;

import junit.framework.TestCase;

/**
 * <p>
 * Stress test case for StereotypeImpl.
 * </p>
 *
 * @author justforplay
 * @version 1.0
 */
public class StereotypeImplStressTest extends TestCase {

    /**
     * time to repeat.
     */
    private static final int REPEAT_TIME = 20000;

    /**
     * <p>
     * Test to repeat the main functions of StereotypeImpl. The functions include addDefinedTag,
     * containsDefinedTag removeDefinedTag and countDefinedTags.
     * </p>
     */
    public void testFunctionsManyTimes() {
        StereotypeImpl stereotype = new StereotypeImpl();
        TagDefinition tagDefArr[] = new TagDefinition[REPEAT_TIME];

        // initialize many instances of TagDefinition.
        for (int i = 0; i < REPEAT_TIME; i++) {
            tagDefArr[i] = new TagDefinitionImpl();
        }

        // test addDefinedTag many times.
        for (int i = 0; i < REPEAT_TIME; i++) {
            stereotype.addDefinedTag(tagDefArr[0]);
        }

        // test addDefinedTag many times.
        for (int i = 0; i < REPEAT_TIME; i++) {
            stereotype.addDefinedTag(tagDefArr[i]);
        }

        // Verify whether the result of addDefinedTag is correct.
        for (int i = 0; i < REPEAT_TIME; i++) {
            assertTrue("The addDefinedTag() or containsDefinedTag() is incorrect.", stereotype
                .containsDefinedTag(tagDefArr[i]));
        }

        // Verify whether the result of addDefinedTag is correct.
        for (int i = 0; i < REPEAT_TIME; i++) {
            assertEquals("The addDefinedTag() is incorrect.", stereotype, tagDefArr[i].getOwner());
        }

        // test removeDefinedTag many times.
        for (int i = 0; i < REPEAT_TIME; i++) {
            assertTrue("The addDefinedTag() or removeDefindedTag() is incorrect.", stereotype
                .removeDefinedTag(tagDefArr[i]));
        }

        // Verify whether the result of removeDefinedTag is correct.
        for (int i = 1; i < REPEAT_TIME; i++) {
            assertFalse("The addDefinedTag() or containsDefinedTag() is incorrect.", stereotype
                .containsDefinedTag(tagDefArr[i]));
        }

        // Verify whether the result of removeDefinedTag is correct.
        assertTrue("The addDefinedTag() or containsDefinedTag() is incorrect.", stereotype
            .containsDefinedTag(tagDefArr[0]));

        // test removeDefinedTag many times.
        for (int i = 0; i < REPEAT_TIME - 1; i++) {
            assertTrue("The addDefinedTag() or removeDefindedTag() is incorrect.", stereotype
                .removeDefinedTag(tagDefArr[0]));
        }

        // Verify whether the result of removeDefinedTag is correct.
        assertTrue("The addDefinedTag() or containsDefinedTag() is incorrect.", stereotype
            .containsDefinedTag(tagDefArr[0]));

        stereotype.clearDefinedTags();

        assertEquals("The clearDefinedTags() or containsDefinedTag() is incorrect.", 0, stereotype
            .countDefinedTags());

    }

}