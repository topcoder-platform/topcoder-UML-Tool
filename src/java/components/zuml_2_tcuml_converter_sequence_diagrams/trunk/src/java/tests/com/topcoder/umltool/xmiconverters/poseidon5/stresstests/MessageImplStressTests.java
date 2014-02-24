/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.stresstests;

import com.topcoder.uml.model.core.extensionmechanisms.Stereotype;
import com.topcoder.uml.model.core.extensionmechanisms.StereotypeImpl;
import com.topcoder.umltool.xmiconverters.poseidon5.model.impl.MessageImpl;

/**
 * <p>
 * Stress tests for class MessageImpl.
 * </p>
 *
 * @author extra
 * @version 1.0
 */
public class MessageImplStressTests extends BaseStressTests {

    /**
     * <p>
     * Tests method toTCUMLStimulus for stress, it runs 100 times.
     * </p>
     */
    public void testToTCUMLStimulus() {
        begin();
        for (int i = 0; i < 100; i++) {
            MessageImpl message = new MessageImpl();
            Stereotype stereotype = new StereotypeImpl();
            stereotype.addStereotype(new StereotypeImpl());
            message.addStereotype(stereotype);
            message.setMessageSort("asynchCall");
            message.toTCUMLStimulus();
        }
        printResult("MessageImpl#toTCUMLStimulus", 100);
    }

    /**
     * <p>
     * Tests method toTCUMLElement for stress, it runs 100 times.
     * </p>
     */
    public void testToTCUMLElement() {
        begin();
        for (int i = 0; i < 100; i++) {
            MessageImpl message = new MessageImpl();
            Stereotype stereotype = new StereotypeImpl();
            stereotype.addStereotype(new StereotypeImpl());
            message.addStereotype(stereotype);
            message.toTCUMLElement();
        }
        printResult("MessageImpl#toTCUMLElement", 100);
    }

}
