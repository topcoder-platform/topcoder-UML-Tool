/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import com.topcoder.uml.model.activitygraphs.ActionState;
import com.topcoder.uml.model.activitygraphs.ActivityGraph;

/**
 * <p>
 * This class extends PasteStateNodeAbstractAction abstract class.
 * This action add the ActionState node retrieved from the clipboard
 * into the specified activity graph.
 * </p>
 *
 * <p>
 * Thread-safety: this class is stateless, but as its base-class is
 * not thread-safe, this class is not thread-safe too.
 * </p>
 *
 * @author Standlove, TCSDEVELOPER
 * @version 1.0
 */
public class PasteActionStateAction extends PasteStateNodeAbstractAction {
    /**
     * <p>
     * The presentation name for this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Paste Action State";

    /**
     * <p>
     * Construct a PasteActionStateAction with the content and activityGraph specified.
     *  </p>
     *
     * @param content the transferable content provided by the application
     * @param activityGraph the ActivityGraph object to add the content node
     *
     * @throws IllegalArgumentException if any argument is null, or the content
     * object is not of ActionState type
     */
    public PasteActionStateAction(Object content, ActivityGraph activityGraph) {
        super(PRESENTATION_NAME, content, activityGraph);

        Util.checkClassType(content, ActionState.class);
    }
}
