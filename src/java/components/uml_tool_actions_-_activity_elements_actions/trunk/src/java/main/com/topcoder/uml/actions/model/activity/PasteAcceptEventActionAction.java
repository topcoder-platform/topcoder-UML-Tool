/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.statemachines.SimpleState;

/**
 * <p>
 * This class extends PasteStateNodeAbstractAction abstract class.
 * This action add the SimpleState node with a tag definition attached
 * (TagDefinition("AcceptEventAction").value="True"), retrieved from
 * the clipboard into the specified activity graph.
 * </p>
 *
 * <p>
 * Thread-safety: this class is stateless, but as its base-class is not
 * thread-safe, this class is not thread-safe too.
 * </p>
 *
 * @author Standlove, TCSDEVELOPER
 * @version 1.0
 */
public class PasteAcceptEventActionAction extends PasteStateNodeAbstractAction {
    /**
     * <p>
     * The presentation name for this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Paste Accept Event Action";

    /**
     * <p>
     * Construct a PasteAcceptEventActionAction with the content and activityGraph specified.
     * </p>
     *
     * @param content the transferable content provided by the application
     * @param activityGraph the ActivityGraph object to add the content node
     *
     * @throws IllegalArgumentException if any argument is null, or the content
     * object is not of SimpleState type, and it doesn't have a tag definition
     * like TagDefinition("AcceptEventAction").value="True").
     */
    public PasteAcceptEventActionAction(Object content, ActivityGraph activityGraph) {
        super(PRESENTATION_NAME, content, activityGraph);

        // SimpleState class is required
        Util.checkClassType(content, SimpleState.class);

        if (!Util.checkTagDefinition((SimpleState) content, "AcceptEventAction", "True")) {
            throw new IllegalArgumentException(
                "The state doesn't have the tag definition [AcceptEventAction](The data value should be True).");
        }
    }
}
