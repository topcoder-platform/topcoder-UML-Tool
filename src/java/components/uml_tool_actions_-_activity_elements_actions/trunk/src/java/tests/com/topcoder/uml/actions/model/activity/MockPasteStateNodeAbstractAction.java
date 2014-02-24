/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import com.topcoder.uml.model.activitygraphs.ActivityGraph;

/**
 * <p>
 * This is a mock extends of PasteStateNodeAbstractAction class.
 * It is only used for testing.
 * </p>
 *
 * @author TCSDEVELOPER
 * @version 1.0
 */
public class MockPasteStateNodeAbstractAction extends PasteStateNodeAbstractAction {

    /**
     * <p>
     * Call the super construct.
     * </p>
     *
     * @param name the presentation name.
     * @param content the transferable content provided by the application
     * @param activityGraph the ActivityGraph object to add the content node
     *
     * @throws IllegalArgumentException if any argument is null, or the content object is not of StateVertex type.
     */
    public MockPasteStateNodeAbstractAction(String name, Object content, ActivityGraph activityGraph) {
        super(name, content, activityGraph);
    }

}
