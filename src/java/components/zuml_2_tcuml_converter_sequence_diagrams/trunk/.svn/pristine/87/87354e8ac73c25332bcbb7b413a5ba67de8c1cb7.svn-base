package com.topcoder.umltool.xmiconverters.poseidon5.failuretests;

import com.topcoder.umltool.xmiconverters.poseidon5.model.impl.InteractionImpl;

import junit.framework.TestCase;

public class InteractionImplFailureTest extends TestCase {

    private InteractionImpl instance = new InteractionImpl();

    /**
     * Failure Test for
     * {@link InteractionImpl#addLifeline(com.topcoder.umltool.xmiconverters.poseidon5.model.Lifeline)}. lifeline is
     * null and IAE is expected.
     */
    public void testAddLifeline_Failure() {
        try {
            instance.addLifeline(null);
            fail("lifeline is null and IAE is expected");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Failure Test for {@link InteractionImpl#addMessage(com.topcoder.umltool.xmiconverters.poseidon5.model.Message)}.
     * message is null and IAE is expected.
     */
    public void testAddMessage_Failure() {
        try {
            instance.addMessage(null);
            fail("message is null and IAE is expected");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Failure Test for
     * {@link InteractionImpl#removeLifeline(com.topcoder.umltool.xmiconverters.poseidon5.model.Lifeline)}. lifeline
     * is null and IAE is expected.
     */
    public void testRemoveLifeline_Failure() {
        try {
            instance.removeLifeline(null);
            fail("lifeline is null and IAE is expected");
        } catch (IllegalArgumentException e) {
            // success
        }
    }

    /**
     * Failure Test for
     * {@link InteractionImpl#removeMessage(com.topcoder.umltool.xmiconverters.poseidon5.model.Message)}. message is
     * null and IAE is expected.
     */
    public void testRemoveMessage_Failure() {
        try {
            instance.removeMessage(null);
            fail("message is null and IAE is expected");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
