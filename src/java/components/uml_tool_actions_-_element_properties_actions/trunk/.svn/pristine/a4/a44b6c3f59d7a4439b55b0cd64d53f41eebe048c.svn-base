/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.failuretests;

import java.util.HashMap;

import junit.framework.TestCase;

import com.topcoder.uml.actions.general.UpdateDocumentationTagsAction;
import com.topcoder.uml.actions.general.operationtypes.UpdateDocumentationTagsOperationType;
import com.topcoder.uml.model.core.ModelElementAbstractImpl;
import com.topcoder.uml.model.core.extensionmechanisms.TaggedValue;

/**
 * Aggregates all failure tests for ChangeStyleAction class.
 * @author vilain
 * @version 1.0
 */
public class UpdateDocumentationTagsActionFailureTest extends TestCase {

    /**
     * Constructor under test UpdateDocumentationTagsAction(ModelElement, Map,
     * UpdateDocumentationTagsOperationType). Failure testing of exception in
     * case diagram is null.
     */
    public final void testUpdateDocumentationTagsActionFailureDiagramNull() {
        try {
            new UpdateDocumentationTagsAction(null, new HashMap<TaggedValue,String>(),
                UpdateDocumentationTagsOperationType.ADD);
            fail("IllegalArgumentException is expected since diagram is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Constructor under test UpdateDocumentationTagsAction(DiagramElement, Map,
     * UpdateDocumentationTagsOperationType). Failure testing of exception in
     * case name is null.
     */
    public final void testUpdateDocumentationTagsActionFailureNameNull() {
        try {
            new UpdateDocumentationTagsAction(new ModelElementAbstractImpl() {
            }, null, UpdateDocumentationTagsOperationType.ADD);
            fail("IllegalArgumentException is expected since name is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }

    /**
     * Constructor under test UpdateDocumentationTagsAction(DiagramElement, Map,
     * UpdateDocumentationTagsOperationType). Failure testing of exception in
     * case value is null.
     */
    public final void testUpdateDocumentationTagsActionFailureStyleNull() {
        try {
            new UpdateDocumentationTagsAction(new ModelElementAbstractImpl() {
            }, new HashMap<TaggedValue,String>(), null);
            fail("IllegalArgumentException is expected since value is null");
        } catch (IllegalArgumentException e) {
            // good
        }
    }
}