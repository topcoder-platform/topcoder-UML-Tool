/*
 * Copyright (C) 2007 TopCoder Inc., All Rights Reserved.
 */
package com.topcoder.umltool.xmiconverters.poseidon5.stresstests;

import com.topcoder.umltool.xmiconverters.poseidon5.model.impl.InteractionImpl;
import com.topcoder.umltool.xmiconverters.poseidon5.model.impl.LifelineImpl;
import com.topcoder.umltool.xmiconverters.poseidon5.model.impl.MessageImpl;

/**
 * <p>
 * Stress tests for class InteractionImpl.
 * </p>
 *
 * @author extra
 * @version 1.0
 */
public class InteractionImplStressTests extends BaseStressTests {

    /**
     * <p>
     * Tests method toTCUMLElement for stress, it runs 100 times.
     * </p>
     */
    public void testToTCUMLElement() {
        begin();
        for (int i = 0; i < 100; i++) {
            InteractionImpl interac = new InteractionImpl();
            interac.addLifeline(new LifelineImpl());
            interac.addMessage(new MessageImpl());
            interac.toTCUMLElement();
        }
        printResult("InteractionImpl#toTCUMLElement", 100);
    }
}
