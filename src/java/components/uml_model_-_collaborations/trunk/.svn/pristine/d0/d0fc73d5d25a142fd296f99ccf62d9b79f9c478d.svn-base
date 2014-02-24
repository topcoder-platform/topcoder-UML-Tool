/*
 * Copyright (C) 2006 TopCoder Inc., All Rights Reserved.
 *
 * TCS UML Model - Collaborations Version 1.0
 *
 * @ MessageImplTest.java
 */

package com.topcoder.uml.model.collaborations.collaborationroles;

import com.topcoder.uml.model.commonbehavior.instances.MockStimulus;
import com.topcoder.uml.model.commonbehavior.instances.Stimulus;

import junit.framework.TestCase;

/**
 * <p>Tests for MessageImpl class.</p>
 *
 * @author yinzi
 * @version 1.0
 */
public class MessageImplTest extends TestCase {
    /**
     * <p>MessageImpl used for testing. It is instantiated in SetUp.</p>
     */
    private MessageImpl messageImpl;

    /**
     * <p>Sets up test environment, creates object used for test.</p>
     */
    public void setUp() {
        messageImpl = new MessageImpl();
    }

    /**
     * <p>Tears down test environment, disposes object used for test.</p>
     */
    public void tearDown() {
        messageImpl = null;
    }

    /**
     * <p>Tests inheritance of <c>MessageImpl</c>.</p>
     * <p><c>MessageImpl</c> should inherit from <c>Message</c>.</p>
     */
    public void testMessageImplAccuracyInheritMessage() {
        assertEquals("MessageImpl should inherit from Message.", true, messageImpl instanceof Message);
    }

    /**
     * <p>Tests accuracy of <c>getConformingStimulus</c> method.</p>
     * <p>Value should be gotten correctly.</p>
     */
    public void testGetConformingStimulusAccuracy() {
        assertEquals("Value should be gotten correctly.", null, messageImpl.getConformingStimulus());
        Stimulus testObj = new MockStimulus();
        messageImpl.setConformingStimulus(testObj);
        assertEquals("Value should be gotten correctly.", testObj, messageImpl.getConformingStimulus());
    }

    /**
     * <p>Tests accuracy of <c>setConformingStimulus</c> method.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testSetConformingStimulusAccuracy() {
        assertEquals("Value should be gotten correctly.", null, messageImpl.getConformingStimulus());
        Stimulus testObj = new MockStimulus();
        messageImpl.setConformingStimulus(testObj);
        assertEquals("Value should be gotten correctly.", testObj, messageImpl.getConformingStimulus());
    }

    /**
     * <p>Tests accuracy of <c>MessageImpl()</c>.</p>
     * <p>Value should be set correctly.</p>
     */
    public void testMessageImplAccuracy() {
        assertEquals("Value should be gotten correctly.", null, messageImpl.getConformingStimulus());
    }
}
