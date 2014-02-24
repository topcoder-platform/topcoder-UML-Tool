/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.uml.actions.model.activity;

import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;

import com.topcoder.uml.model.activitygraphs.ActionState;
import com.topcoder.uml.model.activitygraphs.ObjectFlowState;
import com.topcoder.uml.model.datatypes.PseudostateKind;
import com.topcoder.uml.model.statemachines.FinalState;
import com.topcoder.uml.model.statemachines.Pseudostate;
import com.topcoder.uml.model.statemachines.SimpleState;
import com.topcoder.uml.model.statemachines.StateVertex;
import com.topcoder.uml.model.statemachines.Transition;
import com.topcoder.util.actionmanager.ActionExecutionException;

/**
 * <p>
 * This utility class is used to copy specific activity element to the clipboard.
 * </p>
 *
 * <p>
 * It is used by all the cut/copy actions.
 * </p>
 *
 * <p>
 * Thread safety: this class is stateless and thread-safe.
 * </p>
 *
 * @author Standlove, TCSDEVELOPER
 * @version 1.0
 */
class ActivityObjectClipboardUtility {
    /**
     * <p>
     * Empty constructor.
     * </p>
     */
    private ActivityObjectClipboardUtility() {
        // empty
    }

    /**
     * <p>
     * Copy the Transition object to the clipboard.
     * </p>
     *
     *
     * @param transition the Transition object to copy
     * @param clipboard the clipboard to copy to
     *
     * @throws IllegalArgumentException if any argument is null, or fails to copy data to clipboard
     * @throws ActivityObjectCloneException if the clone operation fails
     */
    public static void copyTransition(Transition transition, Clipboard clipboard) throws ActivityObjectCloneException {
        Util.checkNull(transition, "transition");
        Util.checkNull(clipboard, "clipboard");

        // clone the Transition instance
        Transition clonedTransition = ActivityObjectCloneUtility.clone(transition);

        // save the object to clipboard
        Transferable transferable = new ActivityObjectSelection(clonedTransition, ActivityDataFlavor.TRANSITION);

        try {
            clipboard.setContents(transferable, null);
        } catch (IllegalStateException ise) {
            throw new IllegalArgumentException("IllegalStateException occurs when copy the data to clipboard.", ise);
        }
    }

    /**
     * <p>
     * Copy the state node to the given clipboard.
     * </p>
     *
     * <p>
     * The clone operation:
     * only Pseudostate, FinalState, ObjectFlowState, ActionState and SimpleState
     * are cloned, other types will result in ActionExecutionException.
     * </p>
     *
     * <p>
     * The DataFlavor when saved to clipboard:
     * <ul>
     * <li>Pseudostate state: If the kind is INITIAL, then ActivityDataFlavor.INITIAL_NODE;
     *                        If the kind is FORK, then ActivityDataFlavor.FORK_NODE;
     *                        If the kind is JOIN, then ActivityDataFlavor.JOIN_NODE;
     *                        If the kind is CHOICE, then ActivityDataFlavor.DECISION_NODE;
     *                        If the kind is JUNCTION, then ActivityDataFlavor.MERGE_NODE;
     *                        Other kind will result in ActionExecutionException.</li>
     * <li>FinalState: If (TagDefinition(&quot;FinalNodeType&quot;).value=&quot;FlowFinalNode&quot;),
     *                 then ActivityDataFlavor.FLOW_FINAL_NODE_ACTION;
     *                 Else ActivityDataFlavor.FINAL_NODE_ACTION.</li>
     * <li>ObjectFlowState: ActivityDataFlavor.OBJECT_FLOW_STATE</li>
     * <li>ActionState: ActivityDataFlavor.ACTION_STATE</li>
     * <li>SimpleState: If (TagDefinition(&quot;SendSignalAction&quot;).value=&quot;True&quot;),
     *                  then ActivityDataFlavor.SEND_SIGNAL_ACTION;
     *                  If (TagDefinition(&quot;AcceptEventAction&quot;).value=&quot;True&quot;),
     *                  then ActivityDataFlavor.ACCEPT_EVENT_ACTION;
     *                  Otherwise it will result in ActionExecutionException.</li>
     * <li>Other state: Result in ActionExecutionException</li>
     * </ul>
     * </p>
     *
     * @param state the StateVertex node to copy
     * @param clipboard the clipboard to copy to
     *
     * @throws IllegalArgumentException if any argument is null, or fails to copy data to clipboard
     * @throws ActivityObjectCloneException if the clone operation fails
     * @throws ActionExecutionException if there is no suitable DataFlavor or the node is unrecognizable
     */
    public static void copyStateNode(StateVertex state, Clipboard clipboard) throws ActivityObjectCloneException,
        ActionExecutionException {
        Util.checkNull(state, "state");
        Util.checkNull(clipboard, "clipboard");

        // copy the state vertex
        StateVertex clonedStateVertex = cloneStateNode(state);

        // save the object to clipboard
        DataFlavor dataFlavor = getDataFlavorForStateNode(state);

        try {
            clipboard.setContents(new ActivityObjectSelection(clonedStateVertex, dataFlavor), null);
        } catch (IllegalStateException ise) {
            throw new IllegalArgumentException("IllegalStateException occurs when copy the data to clipboard.", ise);
        }
    }

    /**
     * <p>
     * Clone the StateVertex object.
     * </p>
     *
     * <p>
     * Note, in this method, only Pseudostate, FinalState, ObjectFlowState, ActionState and SimpleState
     * are cloned, other types will result in ActionExecutionException.
     * </p>
     *
     * @param state the StateVertex node to copy
     * @return the cloned StateVertex object
     *
     * @throws ActivityObjectCloneException if the clone operation fails
     * @throws ActionExecutionException if the state is unrecognizable
     */
    private static StateVertex cloneStateNode(StateVertex state) throws ActivityObjectCloneException,
        ActionExecutionException {
        if (state instanceof Pseudostate) {
            return ActivityObjectCloneUtility.clone((Pseudostate) state);
        } else if (state instanceof FinalState) {
            return ActivityObjectCloneUtility.clone((FinalState) state);
        } else if (state instanceof ObjectFlowState) {
            return ActivityObjectCloneUtility.clone((ObjectFlowState) state);
        } else if (state instanceof ActionState) {
            return ActivityObjectCloneUtility.clone((ActionState) state);
        } else if (state instanceof SimpleState) {
            return ActivityObjectCloneUtility.clone((SimpleState) state);
        } else {
            // the state type is unrecognizable
            throw new ActionExecutionException("The given state is unrecognizable, the type is "
                + state.getClass().getName());
        }
    }

    /**
     * <p>
     * Get the DataFlavor for the given StateVertex object.
     * </p>
     *
     * <p>
     * The rule is as following:
     * <ul>
     * <li>Pseudostate state: If the kind is INITIAL, then ActivityDataFlavor.INITIAL_NODE;
     *                        If the kind is FORK, then ActivityDataFlavor.FORK_NODE;
     *                        If the kind is JOIN, then ActivityDataFlavor.JOIN_NODE;
     *                        If the kind is CHOICE, then ActivityDataFlavor.DECISION_NODE;
     *                        If the kind is JUNCTION, then ActivityDataFlavor.MERGE_NODE;
     *                        Other kind will result in ActionExecutionException.</li>
     * <li>FinalState: If (TagDefinition(&quot;FinalNodeType&quot;).value=&quot;FlowFinalNode&quot;),
     *                 then ActivityDataFlavor.FLOW_FINAL_NODE_ACTION;
     *                 Else ActivityDataFlavor.FINAL_NODE_ACTION.</li>
     * <li>ObjectFlowState: ActivityDataFlavor.OBJECT_FLOW_STATE</li>
     * <li>ActionState: ActivityDataFlavor.ACTION_STATE</li>
     * <li>SimpleState: If (TagDefinition(&quot;SendSignalAction&quot;).value=&quot;True&quot;),
     *                  then ActivityDataFlavor.SEND_SIGNAL_ACTION;
     *                  If (TagDefinition(&quot;AcceptEventAction&quot;).value=&quot;True&quot;),
     *                  then ActivityDataFlavor.ACCEPT_EVENT_ACTION;
     *                  Otherwise it will result in ActionExecutionException.</li>
     * <li>Other state: Result in ActionExecutionException</li>
     * </ul>
     * </p>
     *
     * @param state the StateVertex node to get its corresponding DataFlavor instance
     * @return the corresponding DataFlavor instance for the given StateVertex node
     *
     * @throws ActionExecutionException if there is no suitable DataFlavor according to the rule
     */
    private static DataFlavor getDataFlavorForStateNode(StateVertex state) throws ActionExecutionException {
        if (state instanceof Pseudostate) {
            // for Pseudostate state
            PseudostateKind kind = ((Pseudostate) state).getKind();

            // Which data flavor depends on the kind attribute
            if (kind == PseudostateKind.INITIAL) {
                return ActivityDataFlavor.INITIAL_NODE;
            } else if (kind == PseudostateKind.FORK) {
                return ActivityDataFlavor.FORK_NODE;
            } else if (kind == PseudostateKind.JOIN) {
                return ActivityDataFlavor.JOIN_NODE;
            } else if (kind == PseudostateKind.CHOICE) {
                return ActivityDataFlavor.DECISION_NODE;
            } else if (kind == PseudostateKind.JUNCTION) {
                return ActivityDataFlavor.MERGE_NODE;
            } else {
                throw new ActionExecutionException("The given state is of PseudostateKind type, the kind is " + kind
                    + ", only INITIAL, FORK, JOIN, CHOICE and JUNCTION are allowed.");
            }
        } else if (state instanceof FinalState) {
            // for FinalState state
            if (Util.checkTagDefinition(state, "FinalNodeType", "FlowFinalNode")) {
                return ActivityDataFlavor.FLOW_FINAL_NODE;
            } else {
                return ActivityDataFlavor.FINAL_NODE;
            }
        } else if (state instanceof ObjectFlowState) {
            // for ObjectFlowState state
            return ActivityDataFlavor.OBJECT_FLOW_STATE;
        } else if (state instanceof ActionState) {
            // for ActionState state
            return ActivityDataFlavor.ACTION_STATE;
        } else if (state instanceof SimpleState) {
            // for SimpleState
            if (Util.checkTagDefinition(state, "SendSignalAction", "True")) {
                return ActivityDataFlavor.SEND_SIGNAL_ACTION;
            } else if (Util.checkTagDefinition(state, "AcceptEventAction", "True")) {
                return ActivityDataFlavor.ACCEPT_EVENT_ACTION;
            } else {
                throw new ActionExecutionException("The given state is of SimpleState type, but it doesn't have "
                    + "SendSignalAction or AcceptEventAction tag definition(The data value should be True).");
            }
        } else {
            // the state type is unrecognizable
            throw new ActionExecutionException("The given state is unrecognizable, the type is "
                + state.getClass().getName());
        }
    }
}
