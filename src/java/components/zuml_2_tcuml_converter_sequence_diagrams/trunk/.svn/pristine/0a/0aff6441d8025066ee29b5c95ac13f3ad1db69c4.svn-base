package com.topcoder.umltool.xmiconverters.poseidon5.failuretests;

import com.topcoder.umltool.xmiconverters.poseidon5.model.impl.MessageImpl;

import junit.framework.TestCase;

public class MessageImplFailureTest extends TestCase {

    private MessageImpl instance = new MessageImpl();

    /**
     * Failure Test for {@link MessageImpl#setMessageSort(String)}. messageSort is invalid and IAE is expected.
     */
    public void testSetMessageSort_Failure() {
        try {
            instance.setMessageSort("xx");
            fail("messageSort is invalid and IAE is expected");
        } catch (IllegalArgumentException e) {
            // success
        }
    }
}
