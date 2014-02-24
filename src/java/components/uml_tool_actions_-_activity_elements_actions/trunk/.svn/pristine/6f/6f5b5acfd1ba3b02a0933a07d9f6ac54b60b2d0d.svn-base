/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import com.topcoder.uml.model.activitygraphs.ActivityGraph;
import com.topcoder.uml.model.statemachines.FinalState;

/**
 * <p>
 * This class extends PasteStateNodeAbstractAction abstract class.
 * This action add the FinalState node with a tag definition attached
 * (TagDefinition("FinalNodeType").value="FlowFinalNode"), retrieved
 * from the clipboard into the specified activity graph.
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
public class PasteFlowFinalNodeAction extends PasteStateNodeAbstractAction {
    /**
     * <p>
     * The presentation name for this action.
     * </p>
     */
    private static final String PRESENTATION_NAME = "Paste Flow Final Node";

    /**
     * <p>
     * Construct a PasteFlowFinalNodeAction with the content and activityGraph specified.
     * </p>
     *
     * @param content the transferable content provided by the application
     * @param activityGraph the ActivityGraph object to add the content node
     *
     * @throws IllegalArgumentException if any argument is null, or the
     * content object is not of FinalState type, and it doesn't have a
     * tag definition like TagDefinition("FinalNodeType").value="FlowFinalNode")
     */
    public PasteFlowFinalNodeAction(Object content, ActivityGraph activityGraph) {
        super(PRESENTATION_NAME, content, activityGraph);

        Util.checkClassType(content, FinalState.class);

        if (!Util.checkTagDefinition((FinalState) content, "FinalNodeType", "FlowFinalNode")) {
            throw new IllegalArgumentException(
                "The state doesn't have the tag definition [FinalNodeType](The data value should be FlowFinalNode).");
        }
    }
}
